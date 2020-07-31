package com.baidu.searchbox.ui.animview.praise.resource;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.baidu.android.util.io.FileUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.PraiseEnvironment;
import com.baidu.searchbox.ui.animview.util.DebugUtil;
import com.baidu.searchbox.ui.animview.util.PraiseLevelUtil;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class ComboPraiseProvider implements IResourceProvider {
    private static final boolean DEBUG = DebugUtil.isApkInDebug();
    public static final String DIR_NAME_ERUPTION = "exploding";
    public static final String DIR_NAME_HAND_WAVE = "wave";
    public static final String DIR_NAME_PRAISE_LEVEL = "praise";
    public static final String DIR_NAME_PRAISE_NUMBER = "number";
    public static final String DIR_NAME_SHAKE_HAND = "shake";
    public static final String DIR_PREFIX_DAY = "day";
    public static final String DIR_PREFIX_NIGHT = "night";
    public static final String PRAISE_CONFIG_NAME = "config.json";
    public static final String PRAISE_GUIDE_DIR_DAY = "guide_day";
    public static final String PRAISE_GUIDE_DIR_NIGHT = "guide_night";
    public static final String PRAISE_ICON_DIR_DAY = "praise_icon_day";
    public static final String PRAISE_ICON_DIR_NIGHT = "praise_icon_night";
    public static final String PRAISE_LEVEL_DIRNAME_PREFIX = "l";
    public static final String RES_KEY_PREFIX_PRAISE_LEVEL = "level";
    public static final String RES_KEY_PREFIX_PRAISE_NUMBER = "number";
    public static final String RES_KEY_SUFFIX_ERUPTION = "eruption";
    public static final String RES_KEY_SUFFIX_HAND_WAVE = "wave";
    public static final String RES_KEY_SUFFIX_SHAKE_HAND = "shake";
    public static final String RES_NAME_PRAISE_NUMBER_SUFFIX = ".png";
    private static final String TAG = "ResourceAPSManager";
    private Context mContext;
    private IResourcePackage mCurrentPkg;
    private Map<String, IResourceProvider.PackageInfo> mPkgMap;
    private IResourceProvider.PraiseConfigInfo mPraiseConfigInfo;
    private IResourcePackage.LottieResource[] mPraiseGuideLottieArr = new IResourcePackage.LottieResource[2];
    private String[] mResDirNameArr = {"shake", "wave", "praise", "number", DIR_NAME_ERUPTION};
    private File mResourcePath;

    ComboPraiseProvider(Context context, File file) {
        this.mResourcePath = file;
        this.mContext = context;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public void loadResource(String... strArr) {
        synchronized (this) {
            clearAll();
            searchResourcePackage(this.mResourcePath, strArr);
            searchPraiseConfig(this.mResourcePath);
            searchPraiseGuideLottie(this.mResourcePath);
            searchPraiseIcon(this.mResourcePath);
        }
    }

    private void searchPraiseIcon(File file) {
        if (file != null && file.exists()) {
            file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    if (file2.isDirectory() && ComboPraiseProvider.this.isFilteredResDir(file2, ComboPraiseProvider.PRAISE_ICON_DIR_DAY, ComboPraiseProvider.PRAISE_ICON_DIR_NIGHT)) {
                        String name = TextUtils.isEmpty(file2.getName()) ? "" : file2.getName();
                        if (name.equalsIgnoreCase(ComboPraiseProvider.PRAISE_ICON_DIR_DAY)) {
                            CoolPraiseIconResource.storePraiseIconResource(ComboPraiseProvider.this.mContext, file2, false);
                        } else if (name.equalsIgnoreCase(ComboPraiseProvider.PRAISE_ICON_DIR_NIGHT)) {
                            CoolPraiseIconResource.storePraiseIconResource(ComboPraiseProvider.this.mContext, file2, true);
                        }
                        return true;
                    }
                    return false;
                }
            });
        }
    }

    private void searchPraiseConfig(File file) {
        File[] listFiles;
        if (file != null && file.exists() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.2
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return !file2.isDirectory() && ComboPraiseProvider.this.isFilteredResDir(file2, ComboPraiseProvider.PRAISE_CONFIG_NAME);
            }
        })) != null && listFiles.length > 0) {
            this.mPraiseConfigInfo = restorePraiseConfigInfo(listFiles[0]);
            PraiseLevelUtil.updateLevelConfig(this.mPraiseConfigInfo != null ? this.mPraiseConfigInfo.mLevelConfigSet : null);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public IResourceProvider.PraiseConfigInfo getPraiseConfigInfo() {
        return this.mPraiseConfigInfo;
    }

    private IResourceProvider.PraiseConfigInfo restorePraiseConfigInfo(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        String readFileData = FileUtils.readFileData(file);
        if (TextUtils.isEmpty(readFileData)) {
            return null;
        }
        return IResourceProvider.PraiseConfigInfo.valueOf(readFileData);
    }

    private void searchPraiseGuideLottie(File file) {
        if (file != null && file.exists()) {
            file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.3
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    if (file2.isDirectory() && ComboPraiseProvider.this.isFilteredResDir(file2, ComboPraiseProvider.PRAISE_GUIDE_DIR_DAY, ComboPraiseProvider.PRAISE_GUIDE_DIR_NIGHT)) {
                        String name = TextUtils.isEmpty(file2.getName()) ? "" : file2.getName();
                        if (name.equalsIgnoreCase(ComboPraiseProvider.PRAISE_GUIDE_DIR_DAY)) {
                            ComboPraiseProvider.this.mPraiseGuideLottieArr[0] = IResourcePackage.Utils.prepareLottieResource(ComboPraiseProvider.this.mContext, file2, "");
                        } else if (name.equalsIgnoreCase(ComboPraiseProvider.PRAISE_GUIDE_DIR_NIGHT)) {
                            ComboPraiseProvider.this.mPraiseGuideLottieArr[1] = IResourcePackage.Utils.prepareLottieResource(ComboPraiseProvider.this.mContext, file2, "");
                        }
                        return true;
                    }
                    return false;
                }
            });
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public IResourcePackage.LottieResource getPraiseGuideLottie() {
        return NightModeHelper.getNightModeSwitcherState() ? this.mPraiseGuideLottieArr[1] : this.mPraiseGuideLottieArr[0];
    }

    private void searchResourcePackage(File file, final String... strArr) {
        File[] listFiles;
        if (file != null && file.exists() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.4
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory() && !ComboPraiseProvider.this.isFilteredResDir(file2, strArr);
            }
        })) != null) {
            for (File file2 : listFiles) {
                if (isValidPackage(file2)) {
                    addResoucePackage(file2.getName().toLowerCase(), file2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFilteredResDir(File file, String... strArr) {
        if (file == null || strArr == null) {
            return false;
        }
        String lowerCase = TextUtils.isEmpty(file.getName()) ? "" : file.getName().toLowerCase();
        for (String str : strArr) {
            if (lowerCase.indexOf(TextUtils.isEmpty(str) ? "" : str.toLowerCase()) != -1) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidPackage(File file) {
        File[] listFiles;
        return file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.5
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2.isDirectory()) {
                    String lowerCase = file2.getName().toLowerCase();
                    for (String str : ComboPraiseProvider.this.mResDirNameArr) {
                        if (TextUtils.equals(lowerCase, str.toLowerCase())) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
        })) != null && listFiles.length == this.mResDirNameArr.length;
    }

    private void addResoucePackage(String str, File file) {
        if (this.mPkgMap == null) {
            this.mPkgMap = new HashMap();
        }
        this.mPkgMap.put(str, new IResourceProvider.PackageInfo(str, file.getPath(), new ResourcePackage(this.mContext, file, str)));
    }

    private void clearAll() {
        if (this.mPkgMap != null && this.mPkgMap.size() > 0) {
            for (Map.Entry<String, IResourceProvider.PackageInfo> entry : this.mPkgMap.entrySet()) {
                entry.getValue().mResPkg.releaseResource();
            }
            this.mPkgMap.clear();
            this.mCurrentPkg = null;
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public void setCurrentPackage(String str) {
        IResourceProvider.PackageInfo packageInfo;
        if (this.mPkgMap != null && this.mPkgMap.size() > 0 && (packageInfo = this.mPkgMap.get(str)) != null) {
            this.mCurrentPkg = packageInfo.mResPkg;
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public List<IResourceProvider.PackageInfo> getPackageList() {
        if (this.mPkgMap == null || this.mPkgMap.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, IResourceProvider.PackageInfo> entry : this.mPkgMap.entrySet()) {
            arrayList.add(entry.getValue());
        }
        return arrayList;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public boolean containPackage(String str) {
        if (this.mPkgMap == null || this.mPkgMap.size() <= 0) {
            return false;
        }
        return this.mPkgMap.containsKey(str);
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
    public Drawable getDrawable(String str, Object... objArr) {
        if (this.mCurrentPkg == null) {
            return null;
        }
        return this.mCurrentPkg.getDrawable(str, objArr);
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
    public IResourcePackage.LottieResource getLottie(String str, Object... objArr) {
        if (this.mCurrentPkg == null) {
            return null;
        }
        return this.mCurrentPkg.getLottie(str, objArr);
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
    public int getResourceCounts(String str) {
        if (this.mCurrentPkg == null) {
            return 0;
        }
        return this.mCurrentPkg.getResourceCounts(str);
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
    public void releaseResource() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class ResourcePackage implements IResourcePackage {
        public static final int LRU_SIZE = 4;
        private Context mContext;
        private boolean mIsDegradedMode;
        private String mPkgTag;
        private File mResourcePath;
        private HashMap<String, Drawable> mResDrawableCache = new HashMap<>();
        private HashMap<String, IResourcePackage.LottieResource> mResLottieCache = new HashMap<>();
        private HashMap<String, Integer> mResCounts = new HashMap<>();
        private LruCache<Integer, Drawable> mNumberLRUCache = new LruCache<>(4);

        public ResourcePackage(Context context, File file, String str) {
            this.mIsDegradedMode = false;
            this.mResourcePath = file;
            this.mContext = context;
            this.mPkgTag = str;
            if (PraiseEnvironment.getPerformanceLevel() == PraiseEnvironment.Performance.LEVEL_1) {
                this.mIsDegradedMode = true;
            }
            prepareResource();
        }

        @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
        public void releaseResource() {
            this.mResCounts.clear();
            this.mResDrawableCache.clear();
            this.mResLottieCache.clear();
            this.mNumberLRUCache.evictAll();
        }

        private void prepareResource() {
            prepareLottieResource(new File(this.mResourcePath, "wave"), "", makeKey("wave", new String[0]));
            if (!this.mIsDegradedMode) {
                preparePraiseNumberResource(new File(this.mResourcePath, "number"));
            }
            if (!this.mIsDegradedMode) {
                preparePraiseLevelResource(new File(this.mResourcePath, "praise"));
            }
            prepareEruptionResource(new File(this.mResourcePath, ComboPraiseProvider.DIR_NAME_ERUPTION));
        }

        private String makeKey(String str, String... strArr) {
            char c = 65535;
            switch (str.hashCode()) {
                case -1034364087:
                    if (str.equals("number")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3642105:
                    if (str.equals("wave")) {
                        c = 1;
                        break;
                    }
                    break;
                case 102865796:
                    if (str.equals(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL)) {
                        c = 3;
                        break;
                    }
                    break;
                case 109399814:
                    if (str.equals("shake")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1482994460:
                    if (str.equals(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION)) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                    return this.mPkgTag + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str;
                case 2:
                case 3:
                case 4:
                    return this.mPkgTag + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + strArr[0];
                default:
                    return "";
            }
        }

        private void prepareLottieResource(File file, String str, String str2) {
            IResourcePackage.LottieResource prepareLottieResource = IResourcePackage.Utils.prepareLottieResource(this.mContext, file, str);
            if (prepareLottieResource != null) {
                this.mResLottieCache.put(str2, prepareLottieResource);
                addResourceCount(str2);
            }
        }

        private void preparePraiseNumberResource(File file) {
            File[] findAllTargetFiles;
            if (file != null && (findAllTargetFiles = IResourcePackage.Utils.findAllTargetFiles(file, ComboPraiseProvider.RES_NAME_PRAISE_NUMBER_SUFFIX, true)) != null) {
                for (File file2 : findAllTargetFiles) {
                    int indexOf = file2.getName().toLowerCase().indexOf(ComboPraiseProvider.RES_NAME_PRAISE_NUMBER_SUFFIX);
                    if (indexOf != -1) {
                        loadImageFromFile(makeKey("number", file2.getName().toLowerCase().substring(0, indexOf).trim()), file2);
                    }
                }
            }
        }

        private void loadImageFromFile(String str, File file) {
            Drawable loadImageFromFile = IResourcePackage.Utils.loadImageFromFile(this.mContext, file);
            if (loadImageFromFile != null) {
                this.mResDrawableCache.put(str, loadImageFromFile);
                addResourceCount(str);
            }
        }

        private void preparePraiseLevelResource(File file) {
            File[] findAllTargetFiles;
            if (file != null && (findAllTargetFiles = IResourcePackage.Utils.findAllTargetFiles(file, "l", false)) != null) {
                for (File file2 : findAllTargetFiles) {
                    prepareLottieResource(file2, "", makeKey(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, file2.getName().toLowerCase().trim()));
                }
            }
        }

        private void prepareEruptionResource(File file) {
            File[] findAllTargetFiles;
            if (file != null && (findAllTargetFiles = IResourcePackage.Utils.findAllTargetFiles(file, "", false)) != null) {
                int length = findAllTargetFiles.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    prepareLottieResource(findAllTargetFiles[i], "", makeKey(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION, i2 + ""));
                    i++;
                    i2++;
                }
            }
        }

        @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
        public Drawable getDrawable(String str, Object... objArr) {
            if (this.mContext == null) {
                return null;
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -1034364087:
                    if (str.equals("number")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return getPraiseNumberDrawable(objArr);
                default:
                    return null;
            }
        }

        @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
        public IResourcePackage.LottieResource getLottie(String str, Object... objArr) {
            if (this.mContext == null) {
                return null;
            }
            char c = 65535;
            switch (str.hashCode()) {
                case 3642105:
                    if (str.equals("wave")) {
                        c = 3;
                        break;
                    }
                    break;
                case 102865796:
                    if (str.equals(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL)) {
                        c = 0;
                        break;
                    }
                    break;
                case 109399814:
                    if (str.equals("shake")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1482994460:
                    if (str.equals(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION)) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return getPraiseLevelLottie(objArr);
                case 1:
                    return getEruptionLottie(objArr);
                case 2:
                case 3:
                    return this.mResLottieCache.get(makeKey(str, new String[0]));
                default:
                    return null;
            }
        }

        private Drawable getPraiseNumberDrawable(Object... objArr) {
            if (objArr != null && objArr.length == 3 && (objArr[0] instanceof Integer) && (objArr[1] instanceof Integer) && (objArr[2] instanceof Integer)) {
                int intValue = ((Integer) objArr[0]).intValue();
                int intValue2 = ((Integer) objArr[1]).intValue();
                int intValue3 = ((Integer) objArr[2]).intValue();
                if (intValue < 0 || intValue > 9) {
                    return null;
                }
                Drawable drawable = this.mResDrawableCache.get(makeKey("number", intValue + ""));
                if (drawable != null) {
                    drawable.setBounds(0, 0, intValue2, intValue3);
                    return drawable;
                }
                return drawable;
            }
            return null;
        }

        private IResourcePackage.LottieResource getPraiseLevelLottie(Object... objArr) {
            return getIndexLottie(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, objArr);
        }

        private IResourcePackage.LottieResource getEruptionLottie(Object... objArr) {
            return getIndexLottie(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION, objArr);
        }

        private IResourcePackage.LottieResource getIndexLottie(String str, Object... objArr) {
            if (objArr != null && objArr.length == 1 && (objArr[0] instanceof Integer)) {
                int intValue = ((Integer) objArr[0]).intValue();
                if (intValue < 0) {
                    return null;
                }
                return TextUtils.equals(str, ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL) ? this.mResLottieCache.get(makeKey(str, "l" + intValue)) : this.mResLottieCache.get(makeKey(str, intValue + ""));
            }
            return null;
        }

        private void addResourceCount(String str) {
            String str2;
            if (this.mResCounts != null && !TextUtils.isEmpty(str)) {
                if (str.contains(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL)) {
                    str2 = ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL;
                } else if (str.contains("number")) {
                    str2 = "number";
                } else if (str.contains(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION)) {
                    str2 = ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION;
                } else if (str.contains("wave")) {
                    str2 = "wave";
                } else if (str.contains("shake")) {
                    str2 = "shake";
                } else {
                    str2 = "";
                }
                int i = 0;
                if (this.mResCounts.containsKey(str2)) {
                    i = this.mResCounts.get(str2).intValue();
                }
                this.mResCounts.put(str2, Integer.valueOf(i + 1));
            }
        }

        @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
        public int getResourceCounts(String str) {
            if (this.mResCounts.containsKey(str)) {
                return this.mResCounts.get(str).intValue();
            }
            return -1;
        }

        private static int stringToIntSafety(String str, int i) {
            try {
                return Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return i;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class Builder {
        private static final String DEFAULT_UNZIP_DIR_NAME = "lottie_unzip";
        Context mContext;
        private File mProcessedResPath;
        private ComboPraiseProvider mProvider;
        private File mUnZipOutputPath;
        private File mZipInputPath;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setZipInputPath(String str) {
            this.mZipInputPath = new File(str);
            if (!this.mZipInputPath.exists() || !FileUtils.isZipFile(this.mZipInputPath)) {
                this.mZipInputPath = null;
            } else if (this.mUnZipOutputPath == null) {
                setUnZipOutputPath(this.mZipInputPath.getParent() + File.separator + DEFAULT_UNZIP_DIR_NAME);
            }
            return this;
        }

        public Builder setUnZipOutputPath(String str) {
            this.mUnZipOutputPath = new File(str);
            if (!this.mUnZipOutputPath.exists()) {
                this.mUnZipOutputPath.mkdirs();
            }
            return this;
        }

        public Builder setProcessedResourcePath(String str) {
            this.mProcessedResPath = new File(str);
            if (!this.mProcessedResPath.exists()) {
                this.mProcessedResPath = null;
            }
            return this;
        }

        private void releaseProvider() {
            if (this.mProvider != null) {
                this.mProvider.releaseResource();
            }
        }

        public IResourceProvider build() {
            if (this.mProcessedResPath != null) {
                releaseProvider();
                this.mProvider = new ComboPraiseProvider(this.mContext, this.mProcessedResPath);
            } else if (this.mZipInputPath == null || this.mUnZipOutputPath == null) {
                if (ComboPraiseProvider.DEBUG) {
                    Log.d(ComboPraiseProvider.TAG, "build failed, ZipInputPath or UnZipOutputPath is empty");
                    return null;
                }
                return null;
            } else if (!FileUtils.unzipFile(this.mZipInputPath.getPath(), this.mUnZipOutputPath.getPath())) {
                if (ComboPraiseProvider.DEBUG) {
                    Log.d(ComboPraiseProvider.TAG, "build failed, failed to unzip, src:" + this.mZipInputPath.getPath() + ", dest:" + this.mUnZipOutputPath.getPath());
                    return null;
                }
                return null;
            } else {
                releaseProvider();
                this.mProvider = new ComboPraiseProvider(this.mContext, this.mUnZipOutputPath);
            }
            return this.mProvider;
        }
    }
}

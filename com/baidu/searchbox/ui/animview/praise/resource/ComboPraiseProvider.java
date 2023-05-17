package com.baidu.searchbox.ui.animview.praise.resource;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.PraiseEnvironment;
import com.baidu.searchbox.ui.animview.praise.ioc.ComboPraiseRuntime;
import com.baidu.searchbox.ui.animview.util.DebugUtil;
import com.baidu.searchbox.ui.animview.util.PraiseLevelUtil;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public class ComboPraiseProvider implements IResourceProvider {
    public static final String CONTENT_DOUBLE_CLICK_ANIM = "content_double_click";
    public static final String CONTENT_MULTIPLE_CLICK_ANIM = "content_multiple_click";
    public static final boolean DEBUG = DebugUtil.isApkInDebug();
    public static final String DIR_NAME_ERUPTION = "exploding";
    public static final String DIR_NAME_HAND_WAVE = "wave";
    public static final String DIR_NAME_PRAISE_LEVEL = "praise";
    public static final String DIR_NAME_PRAISE_NUMBER = "number";
    public static final String DIR_NAME_SHAKE_HAND = "shake";
    public static final String DIR_PREFIX_DAY = "day";
    public static final String DIR_PREFIX_NIGHT = "night";
    public static final String ICON_MULTIPLE_CLICK_ANIM = "icon_multiple_click";
    public static final String ICON_SINGLE_CLICK_ANIM = "icon_single_click";
    public static final String MERGE_VIDEO_PRAISE_ANIM = "merge_video_praise_heart_anim";
    public static final String MINI_VIDEO_PRAISE_ANIM = "minivideo_webp";
    public static final String PRAISE_CONFIG_NAME = "config.json";
    public static final String PRAISE_GUIDE_DIR_DAY = "guide_day";
    public static final String PRAISE_GUIDE_DIR_NIGHT = "guide_night";
    public static final String PRAISE_ICON_DIR_DAY = "praise_icon_day";
    public static final String PRAISE_ICON_DIR_NIGHT = "praise_icon_night";
    public static final String PRAISE_LEVEL_DIRNAME_PREFIX = "l";
    public static final String PREFIX_NOT_PRESSED_UNCLICKED = "un_";
    public static final String PREFIX_PRESSED_CLICKED = "pre_";
    public static final String PREFIX_PRESSED_UNCLICKED = "pre_un_";
    public static final String RES_KEY_PREFIX_PRAISE_LEVEL = "level";
    public static final String RES_KEY_PREFIX_PRAISE_NUMBER = "number";
    public static final String RES_KEY_SUFFIX_ERUPTION = "eruption";
    public static final String RES_KEY_SUFFIX_HAND_WAVE = "wave";
    public static final String RES_KEY_SUFFIX_SHAKE_HAND = "shake";
    public static final String RES_NAME_PRAISE_FILE_PREFIX = "file://";
    public static final String RES_NAME_PRAISE_NUMBER_SUFFIX = ".png";
    public static final String RES_NAME_PRAISE_WEBP_SUFFIX = ".webp";
    public static final String STRONG_PRAISE_EFFECT_DIR = "strong_praise_anim";
    public static final String TAG = "ResourceAPSManager";
    public Context mContext;
    public IResourcePackage mCurrentPkg;
    public Map<String, IResourceProvider.PackageInfo> mPkgMap;
    public IResourceProvider.PraiseConfigInfo mPraiseConfigInfo;
    public File mResourcePath;
    public IResourcePackage.LottieResource[] mPraiseGuideLottieArr = new IResourcePackage.LottieResource[2];
    public boolean mContainsLoveAnimation = false;
    public String[] mResDirNameArr = {"shake", "wave", "praise", "number", DIR_NAME_ERUPTION};

    @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
    public void releaseResource() {
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        public static final String DEFAULT_UNZIP_DIR_NAME = "lottie_unzip";
        public Context mContext;
        public File mProcessedResPath;
        public ComboPraiseProvider mProvider;
        public File mUnZipOutputPath;
        public File mZipInputPath;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setProcessedResourcePath(String str) {
            File file = new File(str);
            this.mProcessedResPath = file;
            if (!file.exists()) {
                this.mProcessedResPath = null;
            }
            return this;
        }

        public Builder setUnZipOutputPath(String str) {
            File file = new File(str);
            this.mUnZipOutputPath = file;
            if (!file.exists()) {
                this.mUnZipOutputPath.mkdirs();
            }
            return this;
        }

        private void releaseProvider() {
            ComboPraiseProvider comboPraiseProvider = this.mProvider;
            if (comboPraiseProvider == null) {
                return;
            }
            comboPraiseProvider.releaseResource();
        }

        public IResourceProvider build() {
            boolean z;
            if (this.mProcessedResPath != null) {
                releaseProvider();
                this.mProvider = new ComboPraiseProvider(this.mContext, this.mProcessedResPath);
                if (this.mZipInputPath != null) {
                    if (ComboPraiseProvider.DEBUG) {
                        Log.d("ResourceAPSManager", "clear history zip:" + this.mZipInputPath.getPath());
                    }
                    FileUtils.deleteFile(this.mZipInputPath);
                }
            } else {
                File file = this.mZipInputPath;
                if (file != null && this.mUnZipOutputPath != null) {
                    try {
                        z = FileUtils.unzipFile(file.getPath(), this.mUnZipOutputPath.getPath());
                    } catch (Exception unused) {
                        z = false;
                    }
                    if (!z) {
                        if (ComboPraiseProvider.DEBUG) {
                            Log.d("ResourceAPSManager", "build failed, failed to unzip, src:" + this.mZipInputPath.getPath() + ", dest:" + this.mUnZipOutputPath.getPath());
                        }
                        return null;
                    }
                    if (ComboPraiseProvider.DEBUG) {
                        Log.d("ResourceAPSManager", "clear cur download zip:" + this.mZipInputPath.getPath());
                    }
                    FileUtils.deleteFile(this.mZipInputPath);
                    releaseProvider();
                    this.mProvider = new ComboPraiseProvider(this.mContext, this.mUnZipOutputPath);
                } else {
                    if (ComboPraiseProvider.DEBUG) {
                        Log.d("ResourceAPSManager", "build failed, ZipInputPath or UnZipOutputPath is empty");
                    }
                    return null;
                }
            }
            return this.mProvider;
        }

        public Builder setZipInputPath(String str) {
            this.mZipInputPath = new File(str);
            String str2 = this.mZipInputPath.getParent() + File.separator + DEFAULT_UNZIP_DIR_NAME;
            setProcessedResourcePath(str2);
            if (this.mZipInputPath.exists() && FileUtils.isZipFile(this.mZipInputPath)) {
                if (this.mUnZipOutputPath == null) {
                    setUnZipOutputPath(str2);
                }
            } else {
                this.mZipInputPath = null;
            }
            return this;
        }
    }

    /* loaded from: classes4.dex */
    public static class ResourcePackage implements IResourcePackage {
        public static final int LRU_SIZE = 4;
        public Context mContext;
        public boolean mIsDegradedMode;
        public String mPkgTag;
        public File mResourcePath;
        public HashMap<String, Drawable> mResDrawableCache = new HashMap<>();
        public HashMap<String, IResourcePackage.LottieResource> mResLottieCache = new HashMap<>();
        public HashMap<String, Integer> mResCounts = new HashMap<>();
        public LruCache<Integer, Drawable> mNumberLRUCache = new LruCache<>(4);

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

        private void addResourceCount(String str) {
            if (this.mResCounts != null && !TextUtils.isEmpty(str)) {
                String str2 = "level";
                if (!str.contains("level")) {
                    if (str.contains("number")) {
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
                }
                int i = 0;
                if (this.mResCounts.containsKey(str2)) {
                    i = this.mResCounts.get(str2).intValue();
                }
                this.mResCounts.put(str2, Integer.valueOf(i + 1));
            }
        }

        private void preparePraiseNumberResource(File file) {
            File[] findAllTargetFiles;
            if (file == null || (findAllTargetFiles = IResourcePackage.Utils.findAllTargetFiles(file, ".png", true)) == null) {
                return;
            }
            for (File file2 : findAllTargetFiles) {
                int indexOf = file2.getName().toLowerCase(Locale.getDefault()).indexOf(".png");
                if (indexOf != -1) {
                    loadImageFromFile(makeKey("number", file2.getName().toLowerCase(Locale.getDefault()).substring(0, indexOf).trim()), file2);
                }
            }
        }

        private IResourcePackage.LottieResource getEruptionLottie(Object... objArr) {
            return getIndexLottie(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION, objArr);
        }

        private IResourcePackage.LottieResource getPraiseLevelLottie(Object... objArr) {
            return getIndexLottie("level", objArr);
        }

        @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
        public int getResourceCounts(String str) {
            if (this.mResCounts.containsKey(str) && this.mResCounts.get(str) != null) {
                return this.mResCounts.get(str).intValue();
            }
            return -1;
        }

        private IResourcePackage.LottieResource getIndexLottie(String str, Object... objArr) {
            int intValue;
            if (objArr == null || objArr.length != 1 || !(objArr[0] instanceof Integer) || (intValue = ((Integer) objArr[0]).intValue()) < 0) {
                return null;
            }
            if (TextUtils.equals(str, "level")) {
                HashMap<String, IResourcePackage.LottieResource> hashMap = this.mResLottieCache;
                return hashMap.get(makeKey(str, "l" + intValue));
            }
            HashMap<String, IResourcePackage.LottieResource> hashMap2 = this.mResLottieCache;
            return hashMap2.get(makeKey(str, intValue + ""));
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
                    if (str.equals("level")) {
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
            if (c != 0) {
                if (c != 1) {
                    if (c != 2 && c != 3) {
                        return null;
                    }
                    return this.mResLottieCache.get(makeKey(str, new String[0]));
                }
                return getEruptionLottie(objArr);
            }
            return getPraiseLevelLottie(objArr);
        }

        private Drawable getPraiseNumberDrawable(Object... objArr) {
            Drawable drawable = null;
            if (objArr != null && objArr.length == 3 && (objArr[0] instanceof Integer) && (objArr[1] instanceof Integer) && (objArr[2] instanceof Integer)) {
                int intValue = ((Integer) objArr[0]).intValue();
                int intValue2 = ((Integer) objArr[1]).intValue();
                int intValue3 = ((Integer) objArr[2]).intValue();
                if (intValue >= 0 && intValue <= 9) {
                    HashMap<String, Drawable> hashMap = this.mResDrawableCache;
                    drawable = hashMap.get(makeKey("number", intValue + ""));
                    if (drawable != null) {
                        drawable.setBounds(0, 0, intValue2, intValue3);
                    }
                }
            }
            return drawable;
        }

        private void loadImageFromFile(String str, File file) {
            Drawable loadImageFromFile = IResourcePackage.Utils.loadImageFromFile(this.mContext, file);
            if (loadImageFromFile != null) {
                this.mResDrawableCache.put(str, loadImageFromFile);
                addResourceCount(str);
            }
        }

        public static int stringToIntSafety(String str, int i) {
            try {
                return Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return i;
            }
        }

        @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
        public Drawable getDrawable(String str, Object... objArr) {
            if (this.mContext == null) {
                return null;
            }
            char c = 65535;
            if (str.hashCode() == -1034364087 && str.equals("number")) {
                c = 0;
            }
            if (c != 0) {
                return null;
            }
            return getPraiseNumberDrawable(objArr);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private String makeKey(String str, String... strArr) {
            char c;
            switch (str.hashCode()) {
                case -1034364087:
                    if (str.equals("number")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 3642105:
                    if (str.equals("wave")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 102865796:
                    if (str.equals("level")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 109399814:
                    if (str.equals("shake")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1482994460:
                    if (str.equals(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0 && c != 1) {
                if (c != 2 && c != 3 && c != 4) {
                    return "";
                }
                return this.mPkgTag + "_" + str + "_" + strArr[0];
            }
            return this.mPkgTag + "_" + str;
        }

        private void prepareEruptionResource(File file) {
            File[] findAllTargetFiles;
            if (file == null || (findAllTargetFiles = IResourcePackage.Utils.findAllTargetFiles(file, "", false)) == null) {
                return;
            }
            int length = findAllTargetFiles.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                File file2 = findAllTargetFiles[i];
                prepareLottieResource(file2, "", makeKey(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION, i2 + ""));
                i++;
                i2++;
            }
        }

        private void preparePraiseLevelResource(File file) {
            File[] findAllTargetFiles;
            if (file == null || (findAllTargetFiles = IResourcePackage.Utils.findAllTargetFiles(file, "l", false)) == null) {
                return;
            }
            for (File file2 : findAllTargetFiles) {
                prepareLottieResource(file2, "", makeKey("level", file2.getName().toLowerCase(Locale.getDefault()).trim()));
            }
        }

        private void prepareLottieResource(File file, String str, String str2) {
            IResourcePackage.LottieResource prepareLottieResource = IResourcePackage.Utils.prepareLottieResource(this.mContext, file, str);
            if (prepareLottieResource != null) {
                this.mResLottieCache.put(str2, prepareLottieResource);
                addResourceCount(str2);
            }
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

        @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
        public void releaseResource() {
            this.mResCounts.clear();
            this.mResDrawableCache.clear();
            this.mResLottieCache.clear();
            this.mNumberLRUCache.evictAll();
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public IResourceProvider.PraiseConfigInfo getPraiseConfigInfo() {
        return this.mPraiseConfigInfo;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public IResourcePackage.LottieResource getPraiseGuideLottie() {
        if (NightModeHelper.getNightModeSwitcherState()) {
            return this.mPraiseGuideLottieArr[1];
        }
        return this.mPraiseGuideLottieArr[0];
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public void onlyLoadPraiseIcon() {
        synchronized (this) {
            searchPraiseIcon(this.mResourcePath);
        }
    }

    public ComboPraiseProvider(Context context, File file) {
        this.mResourcePath = file;
        this.mContext = context;
    }

    private void addResoucePackage(String str, File file) {
        if (this.mPkgMap == null) {
            this.mPkgMap = new HashMap();
        }
        this.mPkgMap.put(str, new IResourceProvider.PackageInfo(str, file.getPath(), new ResourcePackage(this.mContext, file, str)));
    }

    public static File[] findAllMatchedPraiseFiles(File file, final String str) {
        if (file == null) {
            return null;
        }
        return file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.6
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2 == null || file2.isDirectory()) {
                    return false;
                }
                return ComboPraiseProvider.isMatchedPraiseFiles(file2.getName().toLowerCase(Locale.getDefault()), str);
            }
        });
    }

    public static boolean isMatchedPraiseFiles(String str, String str2) {
        return TextUtils.equals(str, str2 + ".png");
    }

    private void searchMergeVideoAnim(File file, final String str) {
        File[] listFiles;
        if (file != null && file.exists() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.5
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2 == null || !file2.isDirectory() || !ComboPraiseProvider.this.isFilteredResDir(file2, str)) {
                    return false;
                }
                return true;
            }
        })) != null && listFiles.length > 0) {
            CoolPraiseIconResource.storeHeartPraiseAnim(listFiles[0], str);
        }
    }

    private void searchResource(File file, final String... strArr) {
        if (file != null && file.exists()) {
            file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.9
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    ComboPraiseProvider.this.searchResourcePackageWithoutFilter(file2, strArr);
                    ComboPraiseProvider.this.searchPraiseConfigWithoutFilter(file2);
                    ComboPraiseProvider.this.searchPraiseGuideLottieWithoutFilter(file2);
                    ComboPraiseProvider.this.searchPraiseIconWithoutFilter(file2);
                    ComboPraiseProvider.this.searchMergeVideoPraiseAnimWithoutFilter(file2);
                    ComboPraiseProvider.this.searchStrongPraiseAnimWithFilter(file2);
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchResourcePackageWithoutFilter(File file, String... strArr) {
        if (file != null && file.exists() && file.isDirectory() && !isFilteredResDir(file, strArr) && isValidPackage(file)) {
            addResoucePackage(file.getName().toLowerCase(Locale.getDefault()), file);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
    public Drawable getDrawable(String str, Object... objArr) {
        IResourcePackage iResourcePackage = this.mCurrentPkg;
        if (iResourcePackage == null) {
            return null;
        }
        return iResourcePackage.getDrawable(str, objArr);
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
    public IResourcePackage.LottieResource getLottie(String str, Object... objArr) {
        IResourcePackage iResourcePackage = this.mCurrentPkg;
        if (iResourcePackage == null) {
            return null;
        }
        return iResourcePackage.getLottie(str, objArr);
    }

    private boolean isValidPackage(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.11
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (!file2.isDirectory()) {
                    return false;
                }
                String lowerCase = file2.getName().toLowerCase(Locale.getDefault());
                for (String str : ComboPraiseProvider.this.mResDirNameArr) {
                    if (TextUtils.equals(lowerCase, str.toLowerCase(Locale.getDefault()))) {
                        return true;
                    }
                }
                return false;
            }
        })) == null || listFiles.length != this.mResDirNameArr.length) {
            return false;
        }
        return true;
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

    private void searchMergeVideoAnim(File file) {
        if (file != null && file.exists()) {
            file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.4
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    if (file2 != null && file2.isDirectory() && ComboPraiseProvider.this.isFilteredResDir(file2, ComboPraiseProvider.CONTENT_DOUBLE_CLICK_ANIM, ComboPraiseProvider.CONTENT_MULTIPLE_CLICK_ANIM, ComboPraiseProvider.ICON_SINGLE_CLICK_ANIM, ComboPraiseProvider.ICON_MULTIPLE_CLICK_ANIM)) {
                        CoolPraiseIconResource.storeHeartPraiseAnim(file2, file2.getName());
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchMergeVideoPraiseAnimWithoutFilter(File file) {
        if (file != null && file.exists() && file.isDirectory() && isFilteredResDir(file, MERGE_VIDEO_PRAISE_ANIM)) {
            searchMergeVideoAnim(file);
        }
    }

    private void searchPraiseConfig(File file) {
        File[] listFiles;
        Set<IResourceProvider.PraiseLevelConfig> set;
        if (file != null && file.exists() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.7
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (!file2.isDirectory() && ComboPraiseProvider.this.isFilteredResDir(file2, ComboPraiseProvider.PRAISE_CONFIG_NAME)) {
                    return true;
                }
                return false;
            }
        })) != null && listFiles.length > 0) {
            IResourceProvider.PraiseConfigInfo restorePraiseConfigInfo = restorePraiseConfigInfo(listFiles[0]);
            this.mPraiseConfigInfo = restorePraiseConfigInfo;
            if (restorePraiseConfigInfo != null) {
                set = restorePraiseConfigInfo.mLevelConfigSet;
            } else {
                set = null;
            }
            PraiseLevelUtil.updateLevelConfig(set);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchPraiseConfigWithoutFilter(File file) {
        Set<IResourceProvider.PraiseLevelConfig> set;
        if (file != null && file.exists() && !file.isDirectory() && isFilteredResDir(file, PRAISE_CONFIG_NAME)) {
            IResourceProvider.PraiseConfigInfo restorePraiseConfigInfo = restorePraiseConfigInfo(file);
            this.mPraiseConfigInfo = restorePraiseConfigInfo;
            if (restorePraiseConfigInfo != null) {
                set = restorePraiseConfigInfo.mLevelConfigSet;
            } else {
                set = null;
            }
            PraiseLevelUtil.updateLevelConfig(set);
        }
    }

    private void searchPraiseGuideLottie(File file) {
        if (file != null && file.exists()) {
            file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.8
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    String name;
                    if (!file2.isDirectory() || !ComboPraiseProvider.this.isFilteredResDir(file2, ComboPraiseProvider.PRAISE_GUIDE_DIR_DAY, ComboPraiseProvider.PRAISE_GUIDE_DIR_NIGHT)) {
                        return false;
                    }
                    if (TextUtils.isEmpty(file2.getName())) {
                        name = "";
                    } else {
                        name = file2.getName();
                    }
                    if (name.equalsIgnoreCase(ComboPraiseProvider.PRAISE_GUIDE_DIR_DAY)) {
                        ComboPraiseProvider.this.mPraiseGuideLottieArr[0] = IResourcePackage.Utils.prepareLottieResource(ComboPraiseProvider.this.mContext, file2, "");
                    } else if (name.equalsIgnoreCase(ComboPraiseProvider.PRAISE_GUIDE_DIR_NIGHT)) {
                        ComboPraiseProvider.this.mPraiseGuideLottieArr[1] = IResourcePackage.Utils.prepareLottieResource(ComboPraiseProvider.this.mContext, file2, "");
                    }
                    return true;
                }
            });
        }
    }

    private void searchPraiseIcon(File file) {
        if (file != null && file.exists()) {
            file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    String name;
                    if (!file2.isDirectory() || !ComboPraiseProvider.this.isFilteredResDir(file2, ComboPraiseProvider.PRAISE_ICON_DIR_DAY, ComboPraiseProvider.PRAISE_ICON_DIR_NIGHT)) {
                        return false;
                    }
                    if (TextUtils.isEmpty(file2.getName())) {
                        name = "";
                    } else {
                        name = file2.getName();
                    }
                    if (name.equalsIgnoreCase(ComboPraiseProvider.PRAISE_ICON_DIR_DAY)) {
                        CoolPraiseIconResource.storePraiseIconResource(ComboPraiseProvider.this.mContext, file2, false);
                    } else if (name.equalsIgnoreCase(ComboPraiseProvider.PRAISE_ICON_DIR_NIGHT)) {
                        CoolPraiseIconResource.storePraiseIconResource(ComboPraiseProvider.this.mContext, file2, true);
                    }
                    return true;
                }
            });
        }
    }

    private void searchStrongPraiseAnim(File file) {
        File[] listFiles;
        if (file != null && file.exists() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.2
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2 == null || !file2.isDirectory() || !ComboPraiseProvider.this.isFilteredResDir(file2, ComboPraiseProvider.STRONG_PRAISE_EFFECT_DIR)) {
                    return false;
                }
                return true;
            }
        })) != null && listFiles.length > 0) {
            CoolPraiseIconResource.storeStrongPraiseAnim(listFiles[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchStrongPraiseAnimWithFilter(File file) {
        if (file != null && file.exists() && file.isDirectory() && isFilteredResDir(file, STRONG_PRAISE_EFFECT_DIR)) {
            CoolPraiseIconResource.storeStrongPraiseAnim(file);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public boolean containPackage(String str) {
        Map<String, IResourceProvider.PackageInfo> map = this.mPkgMap;
        if (map != null && map.size() > 0) {
            return this.mPkgMap.containsKey(str);
        }
        return false;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
    public int getResourceCounts(String str) {
        IResourcePackage iResourcePackage = this.mCurrentPkg;
        if (iResourcePackage == null) {
            return 0;
        }
        return iResourcePackage.getResourceCounts(str);
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public void setCurrentPackage(String str) {
        IResourceProvider.PackageInfo packageInfo;
        Map<String, IResourceProvider.PackageInfo> map = this.mPkgMap;
        if (map == null || map.size() <= 0 || (packageInfo = this.mPkgMap.get(str)) == null) {
            return;
        }
        this.mCurrentPkg = packageInfo.mResPkg;
    }

    private void clearAll() {
        Map<String, IResourceProvider.PackageInfo> map = this.mPkgMap;
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, IResourceProvider.PackageInfo> entry : this.mPkgMap.entrySet()) {
                entry.getValue().mResPkg.releaseResource();
            }
            this.mPkgMap.clear();
            this.mCurrentPkg = null;
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public List<IResourceProvider.PackageInfo> getPackageList() {
        Map<String, IResourceProvider.PackageInfo> map = this.mPkgMap;
        if (map != null && map.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, IResourceProvider.PackageInfo> entry : this.mPkgMap.entrySet()) {
                arrayList.add(entry.getValue());
            }
            return arrayList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFilteredResDir(File file, String... strArr) {
        String lowerCase;
        String lowerCase2;
        if (file != null && strArr != null) {
            if (TextUtils.isEmpty(file.getName())) {
                lowerCase = "";
            } else {
                lowerCase = file.getName().toLowerCase(Locale.getDefault());
            }
            for (String str : strArr) {
                if (TextUtils.isEmpty(str)) {
                    lowerCase2 = "";
                } else {
                    lowerCase2 = str.toLowerCase(Locale.getDefault());
                }
                if (lowerCase.indexOf(lowerCase2) != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    private void searchResourcePackage(File file, final String... strArr) {
        File[] listFiles;
        if (file == null || !file.exists() || (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.10
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2.isDirectory() && !ComboPraiseProvider.this.isFilteredResDir(file2, strArr)) {
                    return true;
                }
                return false;
            }
        })) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (isValidPackage(file2)) {
                addResoucePackage(file2.getName().toLowerCase(Locale.getDefault()), file2);
            }
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public File[] getPraiseIconById(String str, boolean z) {
        String str2;
        File file = this.mResourcePath;
        if (file == null) {
            if (DEBUG) {
                Log.e("ResourceAPSManager", "在获取点赞资源时还没有初始化点赞");
            }
            return null;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return null;
        }
        for (File file2 : listFiles) {
            if (file2 != null && file2.isDirectory()) {
                String[] strArr = new String[1];
                if (z) {
                    str2 = PRAISE_ICON_DIR_NIGHT;
                } else {
                    str2 = PRAISE_ICON_DIR_DAY;
                }
                strArr[0] = str2;
                if (isFilteredResDir(file2, strArr)) {
                    return findAllMatchedPraiseFiles(file2, str);
                }
            }
        }
        return null;
    }

    private void searchMergeVideoPraiseAnim(File file) {
        File[] listFiles;
        if (file != null && file.exists() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.3
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2 == null || !file2.isDirectory() || !ComboPraiseProvider.this.isFilteredResDir(file2, ComboPraiseProvider.MERGE_VIDEO_PRAISE_ANIM)) {
                    return false;
                }
                return true;
            }
        })) != null && listFiles.length > 0) {
            searchMergeVideoAnim(listFiles[0], CONTENT_DOUBLE_CLICK_ANIM);
            searchMergeVideoAnim(listFiles[0], CONTENT_MULTIPLE_CLICK_ANIM);
            searchMergeVideoAnim(listFiles[0], ICON_SINGLE_CLICK_ANIM);
            searchMergeVideoAnim(listFiles[0], ICON_MULTIPLE_CLICK_ANIM);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public void loadResource(String... strArr) {
        synchronized (this) {
            clearAll();
            if (ComboPraiseRuntime.getContext().isPraiseResourceLoadSwitch()) {
                searchResource(this.mResourcePath, strArr);
            } else {
                searchResourcePackage(this.mResourcePath, strArr);
                searchPraiseConfig(this.mResourcePath);
                searchPraiseGuideLottie(this.mResourcePath);
                searchPraiseIcon(this.mResourcePath);
                searchMergeVideoPraiseAnim(this.mResourcePath);
                searchStrongPraiseAnim(this.mResourcePath);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchPraiseGuideLottieWithoutFilter(File file) {
        String name;
        if (file != null && file.exists() && file.isDirectory() && isFilteredResDir(file, PRAISE_GUIDE_DIR_DAY, PRAISE_GUIDE_DIR_NIGHT)) {
            if (TextUtils.isEmpty(file.getName())) {
                name = "";
            } else {
                name = file.getName();
            }
            if (name.equalsIgnoreCase(PRAISE_GUIDE_DIR_DAY)) {
                this.mPraiseGuideLottieArr[0] = IResourcePackage.Utils.prepareLottieResource(this.mContext, file, "");
            } else if (name.equalsIgnoreCase(PRAISE_GUIDE_DIR_NIGHT)) {
                this.mPraiseGuideLottieArr[1] = IResourcePackage.Utils.prepareLottieResource(this.mContext, file, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchPraiseIconWithoutFilter(File file) {
        String name;
        if (file != null && file.exists() && file.isDirectory() && isFilteredResDir(file, PRAISE_ICON_DIR_DAY, PRAISE_ICON_DIR_NIGHT)) {
            if (TextUtils.isEmpty(file.getName())) {
                name = "";
            } else {
                name = file.getName();
            }
            if (name.equalsIgnoreCase(PRAISE_ICON_DIR_DAY)) {
                CoolPraiseIconResource.storePraiseIconResource(this.mContext, file, false);
            } else if (name.equalsIgnoreCase(PRAISE_ICON_DIR_NIGHT)) {
                CoolPraiseIconResource.storePraiseIconResource(this.mContext, file, true);
            }
        }
    }
}

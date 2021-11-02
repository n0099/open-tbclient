package com.baidu.searchbox.ui.animview.praise.resource;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.FileUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.PraiseEnvironment;
import com.baidu.searchbox.ui.animview.util.DebugUtil;
import com.baidu.searchbox.ui.animview.util.PraiseLevelUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes7.dex */
public class ComboPraiseProvider implements IResourceProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String DIR_NAME_ERUPTION = "exploding";
    public static final String DIR_NAME_HAND_WAVE = "wave";
    public static final String DIR_NAME_PRAISE_LEVEL = "praise";
    public static final String DIR_NAME_PRAISE_NUMBER = "number";
    public static final String DIR_NAME_SHAKE_HAND = "shake";
    public static final String DIR_PREFIX_DAY = "day";
    public static final String DIR_PREFIX_NIGHT = "night";
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
    public static final String RES_NAME_PRAISE_NUMBER_SUFFIX = ".png";
    public static final String RES_NAME_PRAISE_WEBP_SUFFIX = ".webp";
    public static final String TAG = "ResourceAPSManager";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public IResourcePackage mCurrentPkg;
    public Map<String, IResourceProvider.PackageInfo> mPkgMap;
    public IResourceProvider.PraiseConfigInfo mPraiseConfigInfo;
    public IResourcePackage.LottieResource[] mPraiseGuideLottieArr;
    public String[] mResDirNameArr;
    public File mResourcePath;

    /* loaded from: classes7.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DEFAULT_UNZIP_DIR_NAME = "lottie_unzip";
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;
        public File mProcessedResPath;
        public ComboPraiseProvider mProvider;
        public File mUnZipOutputPath;
        public File mZipInputPath;

        public Builder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mContext = context;
        }

        private void releaseProvider() {
            ComboPraiseProvider comboPraiseProvider;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (comboPraiseProvider = this.mProvider) == null) {
                return;
            }
            comboPraiseProvider.releaseResource();
        }

        public IResourceProvider build() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mProcessedResPath != null) {
                    releaseProvider();
                    this.mProvider = new ComboPraiseProvider(this.mContext, this.mProcessedResPath);
                } else {
                    File file = this.mZipInputPath;
                    if (file == null || this.mUnZipOutputPath == null) {
                        boolean unused = ComboPraiseProvider.DEBUG;
                        return null;
                    }
                    try {
                        z = FileUtils.unzipFile(file.getPath(), this.mUnZipOutputPath.getPath());
                    } catch (Exception unused2) {
                        z = false;
                    }
                    if (!z) {
                        if (ComboPraiseProvider.DEBUG) {
                            String str = "build failed, failed to unzip, src:" + this.mZipInputPath.getPath() + ", dest:" + this.mUnZipOutputPath.getPath();
                        }
                        return null;
                    }
                    releaseProvider();
                    this.mProvider = new ComboPraiseProvider(this.mContext, this.mUnZipOutputPath);
                }
                return this.mProvider;
            }
            return (IResourceProvider) invokeV.objValue;
        }

        public Builder setProcessedResourcePath(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                File file = new File(str);
                this.mProcessedResPath = file;
                if (!file.exists()) {
                    this.mProcessedResPath = null;
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setUnZipOutputPath(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                File file = new File(str);
                this.mUnZipOutputPath = file;
                if (!file.exists()) {
                    this.mUnZipOutputPath.mkdirs();
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setZipInputPath(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                File file = new File(str);
                this.mZipInputPath = file;
                if (file.exists() && FileUtils.isZipFile(this.mZipInputPath)) {
                    if (this.mUnZipOutputPath == null) {
                        setUnZipOutputPath(this.mZipInputPath.getParent() + File.separator + DEFAULT_UNZIP_DIR_NAME);
                    }
                } else {
                    this.mZipInputPath = null;
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class ResourcePackage implements IResourcePackage {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int LRU_SIZE = 4;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;
        public boolean mIsDegradedMode;
        public LruCache<Integer, Drawable> mNumberLRUCache;
        public String mPkgTag;
        public HashMap<String, Integer> mResCounts;
        public HashMap<String, Drawable> mResDrawableCache;
        public HashMap<String, IResourcePackage.LottieResource> mResLottieCache;
        public File mResourcePath;

        public ResourcePackage(Context context, File file, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, file, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mIsDegradedMode = false;
            this.mResDrawableCache = new HashMap<>();
            this.mResLottieCache = new HashMap<>();
            this.mResCounts = new HashMap<>();
            this.mNumberLRUCache = new LruCache<>(4);
            this.mResourcePath = file;
            this.mContext = context;
            this.mPkgTag = str;
            if (PraiseEnvironment.getPerformanceLevel() == PraiseEnvironment.Performance.LEVEL_1) {
                this.mIsDegradedMode = true;
            }
            prepareResource();
        }

        private void addResourceCount(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, str) == null) || this.mResCounts == null || TextUtils.isEmpty(str)) {
                return;
            }
            String str2 = ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL;
            if (!str.contains(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL)) {
                if (str.contains("number")) {
                    str2 = "number";
                } else if (str.contains(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION)) {
                    str2 = ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION;
                } else if (str.contains("wave")) {
                    str2 = "wave";
                } else {
                    str2 = str.contains("shake") ? "shake" : "";
                }
            }
            this.mResCounts.put(str2, Integer.valueOf((this.mResCounts.containsKey(str2) ? this.mResCounts.get(str2).intValue() : 0) + 1));
        }

        private IResourcePackage.LottieResource getEruptionLottie(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, objArr)) == null) ? getIndexLottie(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION, objArr) : (IResourcePackage.LottieResource) invokeL.objValue;
        }

        private IResourcePackage.LottieResource getIndexLottie(String str, Object... objArr) {
            InterceptResult invokeLL;
            int intValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, objArr)) == null) {
                if (objArr == null || objArr.length != 1 || !(objArr[0] instanceof Integer) || (intValue = ((Integer) objArr[0]).intValue()) < 0) {
                    return null;
                }
                if (TextUtils.equals(str, ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL)) {
                    HashMap<String, IResourcePackage.LottieResource> hashMap = this.mResLottieCache;
                    return hashMap.get(makeKey(str, "l" + intValue));
                }
                HashMap<String, IResourcePackage.LottieResource> hashMap2 = this.mResLottieCache;
                return hashMap2.get(makeKey(str, intValue + ""));
            }
            return (IResourcePackage.LottieResource) invokeLL.objValue;
        }

        private IResourcePackage.LottieResource getPraiseLevelLottie(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, objArr)) == null) ? getIndexLottie(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, objArr) : (IResourcePackage.LottieResource) invokeL.objValue;
        }

        private Drawable getPraiseNumberDrawable(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, objArr)) == null) {
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
            return (Drawable) invokeL.objValue;
        }

        private void loadImageFromFile(String str, File file) {
            Drawable loadImageFromFile;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, str, file) == null) || (loadImageFromFile = IResourcePackage.Utils.loadImageFromFile(this.mContext, file)) == null) {
                return;
            }
            this.mResDrawableCache.put(str, loadImageFromFile);
            addResourceCount(str);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private String makeKey(String str, String... strArr) {
            InterceptResult invokeLL;
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, str, strArr)) == null) {
                switch (str.hashCode()) {
                    case -1034364087:
                        if (str.equals("number")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3642105:
                        if (str.equals("wave")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 102865796:
                        if (str.equals(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL)) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 109399814:
                        if (str.equals("shake")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1482994460:
                        if (str.equals(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION)) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0 || c2 == 1) {
                    return this.mPkgTag + "_" + str;
                } else if (c2 == 2 || c2 == 3 || c2 == 4) {
                    return this.mPkgTag + "_" + str + "_" + strArr[0];
                } else {
                    return "";
                }
            }
            return (String) invokeLL.objValue;
        }

        private void prepareEruptionResource(File file) {
            File[] findAllTargetFiles;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65544, this, file) == null) || file == null || (findAllTargetFiles = IResourcePackage.Utils.findAllTargetFiles(file, "", false)) == null) {
                return;
            }
            int length = findAllTargetFiles.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                File file2 = findAllTargetFiles[i2];
                prepareLottieResource(file2, "", makeKey(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION, i3 + ""));
                i2++;
                i3++;
            }
        }

        private void prepareLottieResource(File file, String str, String str2) {
            IResourcePackage.LottieResource prepareLottieResource;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(65545, this, file, str, str2) == null) || (prepareLottieResource = IResourcePackage.Utils.prepareLottieResource(this.mContext, file, str)) == null) {
                return;
            }
            this.mResLottieCache.put(str2, prepareLottieResource);
            addResourceCount(str2);
        }

        private void preparePraiseLevelResource(File file) {
            File[] findAllTargetFiles;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65546, this, file) == null) || file == null || (findAllTargetFiles = IResourcePackage.Utils.findAllTargetFiles(file, "l", false)) == null) {
                return;
            }
            for (File file2 : findAllTargetFiles) {
                prepareLottieResource(file2, "", makeKey(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, file2.getName().toLowerCase().trim()));
            }
        }

        private void preparePraiseNumberResource(File file) {
            File[] findAllTargetFiles;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65547, this, file) == null) || file == null || (findAllTargetFiles = IResourcePackage.Utils.findAllTargetFiles(file, ".png", true)) == null) {
                return;
            }
            for (File file2 : findAllTargetFiles) {
                int indexOf = file2.getName().toLowerCase().indexOf(".png");
                if (indexOf != -1) {
                    loadImageFromFile(makeKey("number", file2.getName().toLowerCase().substring(0, indexOf).trim()), file2);
                }
            }
        }

        private void prepareResource() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65548, this) == null) {
                prepareLottieResource(new File(this.mResourcePath, "wave"), "", makeKey("wave", new String[0]));
                if (!this.mIsDegradedMode) {
                    preparePraiseNumberResource(new File(this.mResourcePath, "number"));
                }
                if (!this.mIsDegradedMode) {
                    preparePraiseLevelResource(new File(this.mResourcePath, "praise"));
                }
                prepareEruptionResource(new File(this.mResourcePath, ComboPraiseProvider.DIR_NAME_ERUPTION));
            }
        }

        public static int stringToIntSafety(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, str, i2)) == null) {
                try {
                    return Integer.valueOf(str).intValue();
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    return i2;
                }
            }
            return invokeLI.intValue;
        }

        @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
        public Drawable getDrawable(String str, Object... objArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, objArr)) == null) {
                if (this.mContext == null) {
                    return null;
                }
                char c2 = 65535;
                if (str.hashCode() == -1034364087 && str.equals("number")) {
                    c2 = 0;
                }
                if (c2 != 0) {
                    return null;
                }
                return getPraiseNumberDrawable(objArr);
            }
            return (Drawable) invokeLL.objValue;
        }

        @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
        public IResourcePackage.LottieResource getLottie(String str, Object... objArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, objArr)) == null) {
                if (this.mContext == null) {
                    return null;
                }
                char c2 = 65535;
                switch (str.hashCode()) {
                    case 3642105:
                        if (str.equals("wave")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 102865796:
                        if (str.equals(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 109399814:
                        if (str.equals("shake")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1482994460:
                        if (str.equals(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION)) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        if (c2 == 2 || c2 == 3) {
                            return this.mResLottieCache.get(makeKey(str, new String[0]));
                        }
                        return null;
                    }
                    return getEruptionLottie(objArr);
                }
                return getPraiseLevelLottie(objArr);
            }
            return (IResourcePackage.LottieResource) invokeLL.objValue;
        }

        @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
        public int getResourceCounts(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (this.mResCounts.containsKey(str)) {
                    return this.mResCounts.get(str).intValue();
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
        public void releaseResource() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.mResCounts.clear();
                this.mResDrawableCache.clear();
                this.mResLottieCache.clear();
                this.mNumberLRUCache.evictAll();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(116338182, "Lcom/baidu/searchbox/ui/animview/praise/resource/ComboPraiseProvider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(116338182, "Lcom/baidu/searchbox/ui/animview/praise/resource/ComboPraiseProvider;");
                return;
            }
        }
        DEBUG = DebugUtil.isApkInDebug();
    }

    public ComboPraiseProvider(Context context, File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, file};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPraiseGuideLottieArr = new IResourcePackage.LottieResource[2];
        this.mResDirNameArr = new String[]{"shake", "wave", "praise", "number", DIR_NAME_ERUPTION};
        this.mResourcePath = file;
        this.mContext = context;
    }

    private void addResoucePackage(String str, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, str, file) == null) {
            if (this.mPkgMap == null) {
                this.mPkgMap = new HashMap();
            }
            this.mPkgMap.put(str, new IResourceProvider.PackageInfo(str, file.getPath(), new ResourcePackage(this.mContext, file, str)));
        }
    }

    private void clearAll() {
        Map<String, IResourceProvider.PackageInfo> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (map = this.mPkgMap) == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, IResourceProvider.PackageInfo> entry : this.mPkgMap.entrySet()) {
            entry.getValue().mResPkg.releaseResource();
        }
        this.mPkgMap.clear();
        this.mCurrentPkg = null;
    }

    public static File[] findAllMatchedPraiseFiles(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, file, str)) == null) {
            if (file == null) {
                return null;
            }
            return file.listFiles(new FileFilter(str) { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String val$resourceId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$resourceId = str;
                }

                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file2)) == null) {
                        if (file2 == null || file2.isDirectory()) {
                            return false;
                        }
                        return ComboPraiseProvider.isMatchedPraiseFiles(file2.getName().toLowerCase(Locale.getDefault()), this.val$resourceId);
                    }
                    return invokeL.booleanValue;
                }
            });
        }
        return (File[]) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFilteredResDir(File file, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, file, strArr)) == null) {
            if (file != null && strArr != null) {
                String lowerCase = TextUtils.isEmpty(file.getName()) ? "" : file.getName().toLowerCase();
                for (String str : strArr) {
                    if (lowerCase.indexOf(TextUtils.isEmpty(str) ? "" : str.toLowerCase()) != -1) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isMatchedPraiseFiles(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            return TextUtils.equals(str, str2 + ".png");
        }
        return invokeLL.booleanValue;
    }

    private boolean isValidPackage(File file) {
        InterceptResult invokeL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, this, file)) == null) ? file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles(new FileFilter(this) { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ComboPraiseProvider this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, file2)) == null) {
                    if (file2.isDirectory()) {
                        String lowerCase = file2.getName().toLowerCase();
                        for (String str : this.this$0.mResDirNameArr) {
                            if (TextUtils.equals(lowerCase, str.toLowerCase())) {
                                return true;
                            }
                        }
                        return false;
                    }
                    return false;
                }
                return invokeL2.booleanValue;
            }
        })) != null && listFiles.length == this.mResDirNameArr.length : invokeL.booleanValue;
    }

    private IResourceProvider.PraiseConfigInfo restorePraiseConfigInfo(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, file)) == null) {
            if (file == null || !file.exists()) {
                return null;
            }
            String readFileData = FileUtils.readFileData(file);
            if (TextUtils.isEmpty(readFileData)) {
                return null;
            }
            return IResourceProvider.PraiseConfigInfo.valueOf(readFileData);
        }
        return (IResourceProvider.PraiseConfigInfo) invokeL.objValue;
    }

    private void searchMiniVideoPraiseAnim(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, this, file) == null) || file == null || !file.exists() || (listFiles = file.listFiles(new FileFilter(this) { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ComboPraiseProvider this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file2)) == null) ? file2.isDirectory() && this.this$0.isFilteredResDir(file2, ComboPraiseProvider.MINI_VIDEO_PRAISE_ANIM) : invokeL.booleanValue;
            }
        })) == null || listFiles.length <= 0) {
            return;
        }
        CoolPraiseIconResource.storeMiniVideoPraiseAnim(listFiles[0]);
    }

    private void searchPraiseConfig(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, this, file) == null) || file == null || !file.exists() || (listFiles = file.listFiles(new FileFilter(this) { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ComboPraiseProvider this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file2)) == null) ? !file2.isDirectory() && this.this$0.isFilteredResDir(file2, ComboPraiseProvider.PRAISE_CONFIG_NAME) : invokeL.booleanValue;
            }
        })) == null || listFiles.length <= 0) {
            return;
        }
        IResourceProvider.PraiseConfigInfo restorePraiseConfigInfo = restorePraiseConfigInfo(listFiles[0]);
        this.mPraiseConfigInfo = restorePraiseConfigInfo;
        PraiseLevelUtil.updateLevelConfig(restorePraiseConfigInfo != null ? restorePraiseConfigInfo.mLevelConfigSet : null);
    }

    private void searchPraiseGuideLottie(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65553, this, file) == null) && file != null && file.exists()) {
            file.listFiles(new FileFilter(this) { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ComboPraiseProvider this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file2)) == null) {
                        if (file2.isDirectory() && this.this$0.isFilteredResDir(file2, ComboPraiseProvider.PRAISE_GUIDE_DIR_DAY, ComboPraiseProvider.PRAISE_GUIDE_DIR_NIGHT)) {
                            String name = TextUtils.isEmpty(file2.getName()) ? "" : file2.getName();
                            if (name.equalsIgnoreCase(ComboPraiseProvider.PRAISE_GUIDE_DIR_DAY)) {
                                this.this$0.mPraiseGuideLottieArr[0] = IResourcePackage.Utils.prepareLottieResource(this.this$0.mContext, file2, "");
                            } else if (name.equalsIgnoreCase(ComboPraiseProvider.PRAISE_GUIDE_DIR_NIGHT)) {
                                this.this$0.mPraiseGuideLottieArr[1] = IResourcePackage.Utils.prepareLottieResource(this.this$0.mContext, file2, "");
                            }
                            return true;
                        }
                        return false;
                    }
                    return invokeL.booleanValue;
                }
            });
        }
    }

    private void searchPraiseIcon(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, this, file) == null) && file != null && file.exists()) {
            file.listFiles(new FileFilter(this) { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ComboPraiseProvider this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file2)) == null) {
                        if (file2.isDirectory() && this.this$0.isFilteredResDir(file2, ComboPraiseProvider.PRAISE_ICON_DIR_DAY, ComboPraiseProvider.PRAISE_ICON_DIR_NIGHT)) {
                            String name = TextUtils.isEmpty(file2.getName()) ? "" : file2.getName();
                            if (name.equalsIgnoreCase(ComboPraiseProvider.PRAISE_ICON_DIR_DAY)) {
                                CoolPraiseIconResource.storePraiseIconResource(this.this$0.mContext, file2, false);
                            } else if (name.equalsIgnoreCase(ComboPraiseProvider.PRAISE_ICON_DIR_NIGHT)) {
                                CoolPraiseIconResource.storePraiseIconResource(this.this$0.mContext, file2, true);
                            }
                            return true;
                        }
                        return false;
                    }
                    return invokeL.booleanValue;
                }
            });
        }
    }

    private void searchResourcePackage(File file, String... strArr) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65555, this, file, strArr) == null) || file == null || !file.exists() || (listFiles = file.listFiles(new FileFilter(this, strArr) { // from class: com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ComboPraiseProvider this$0;
            public final /* synthetic */ String[] val$filterdPkgTags;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, strArr};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$filterdPkgTags = strArr;
            }

            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file2)) == null) ? file2.isDirectory() && !this.this$0.isFilteredResDir(file2, this.val$filterdPkgTags) : invokeL.booleanValue;
            }
        })) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (isValidPackage(file2)) {
                addResoucePackage(file2.getName().toLowerCase(), file2);
            }
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public boolean containPackage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Map<String, IResourceProvider.PackageInfo> map = this.mPkgMap;
            if (map == null || map.size() <= 0) {
                return false;
            }
            return this.mPkgMap.containsKey(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
    public Drawable getDrawable(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, objArr)) == null) {
            IResourcePackage iResourcePackage = this.mCurrentPkg;
            if (iResourcePackage == null) {
                return null;
            }
            return iResourcePackage.getDrawable(str, objArr);
        }
        return (Drawable) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
    public IResourcePackage.LottieResource getLottie(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, objArr)) == null) {
            IResourcePackage iResourcePackage = this.mCurrentPkg;
            if (iResourcePackage == null) {
                return null;
            }
            return iResourcePackage.getLottie(str, objArr);
        }
        return (IResourcePackage.LottieResource) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public List<IResourceProvider.PackageInfo> getPackageList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Map<String, IResourceProvider.PackageInfo> map = this.mPkgMap;
            if (map == null || map.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, IResourceProvider.PackageInfo> entry : this.mPkgMap.entrySet()) {
                arrayList.add(entry.getValue());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public IResourceProvider.PraiseConfigInfo getPraiseConfigInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPraiseConfigInfo : (IResourceProvider.PraiseConfigInfo) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public IResourcePackage.LottieResource getPraiseGuideLottie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? NightModeHelper.getNightModeSwitcherState() ? this.mPraiseGuideLottieArr[1] : this.mPraiseGuideLottieArr[0] : (IResourcePackage.LottieResource) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public File[] getPraiseIconById(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            File file = this.mResourcePath;
            if (file == null) {
                boolean z2 = DEBUG;
                return null;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return null;
            }
            for (File file2 : listFiles) {
                if (file2 != null && file2.isDirectory()) {
                    String[] strArr = new String[1];
                    strArr[0] = z ? PRAISE_ICON_DIR_NIGHT : PRAISE_ICON_DIR_DAY;
                    if (isFilteredResDir(file2, strArr)) {
                        return findAllMatchedPraiseFiles(file2, str);
                    }
                }
            }
            return null;
        }
        return (File[]) invokeLZ.objValue;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
    public int getResourceCounts(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            IResourcePackage iResourcePackage = this.mCurrentPkg;
            if (iResourcePackage == null) {
                return 0;
            }
            return iResourcePackage.getResourceCounts(str);
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public void loadResource(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, strArr) == null) {
            synchronized (this) {
                clearAll();
                searchResourcePackage(this.mResourcePath, strArr);
                searchPraiseConfig(this.mResourcePath);
                searchPraiseGuideLottie(this.mResourcePath);
                searchPraiseIcon(this.mResourcePath);
                searchMiniVideoPraiseAnim(this.mResourcePath);
            }
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public void onlyLoadPraiseIcon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this) {
                searchPraiseIcon(this.mResourcePath);
            }
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourcePackage
    public void releaseResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IResourceProvider
    public void setCurrentPackage(String str) {
        Map<String, IResourceProvider.PackageInfo> map;
        IResourceProvider.PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (map = this.mPkgMap) == null || map.size() <= 0 || (packageInfo = this.mPkgMap.get(str)) == null) {
            return;
        }
        this.mCurrentPkg = packageInfo.mResPkg;
    }
}

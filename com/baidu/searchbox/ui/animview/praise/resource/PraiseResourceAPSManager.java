package com.baidu.searchbox.ui.animview.praise.resource;

import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.element.IPraiseElementBuilder;
import com.baidu.searchbox.ui.animview.praise.element.PraiseAnimElementBuilderEx;
import com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionElementBuilder;
import com.baidu.searchbox.ui.animview.praise.ioc.ComboPraiseRuntime;
import com.baidu.searchbox.ui.animview.praise.ioc.PraisePerformanceStrategyRuntime;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.searchbox.ui.animview.util.DebugUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes7.dex */
public class PraiseResourceAPSManager implements NightModeChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String PRAISE_DOWNLOAD_DIR_NAME = "download";
    public static final int PRAISE_INSTALL_FAILED = 1;
    public static final int PRAISE_INSTALL_SUCCESS = 0;
    public static final String PRAISE_PACKAGE_NAME_FOR_NORMAL = "com.baidu.box.praise.v2";
    public static final String PRAISE_ROOT_DIR_NAME = "praise_root";
    public static final String RESTORE_SUFFIX = "_lastest.json";
    public static final String TAG = "ResourceAPSManager";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsDebugLoadMode;
    public volatile boolean mLoaded;
    public final Object mNightModeSubObj;
    public Map<String, PraiseResourceInfo> mResourceMap;

    /* loaded from: classes7.dex */
    public static final class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static final PraiseResourceAPSManager sINSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-162222940, "Lcom/baidu/searchbox/ui/animview/praise/resource/PraiseResourceAPSManager$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-162222940, "Lcom/baidu/searchbox/ui/animview/praise/resource/PraiseResourceAPSManager$Holder;");
                    return;
                }
            }
            sINSTANCE = new PraiseResourceAPSManager();
        }

        public Holder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface PraiseInstallResultCb {
        void onResult(int i2, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2030994690, "Lcom/baidu/searchbox/ui/animview/praise/resource/PraiseResourceAPSManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2030994690, "Lcom/baidu/searchbox/ui/animview/praise/resource/PraiseResourceAPSManager;");
                return;
            }
        }
        DEBUG = DebugUtil.isApkInDebug();
    }

    public static boolean copyPraiseResourceFile(PraiseResourceInfo praiseResourceInfo, PraiseInstallResultCb praiseInstallResultCb) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, praiseResourceInfo, praiseInstallResultCb)) == null) {
            File praiseResourceDir = getPraiseResourceDir(praiseResourceInfo.mPkgName, String.valueOf(praiseResourceInfo.mVersion));
            if (!praiseResourceDir.exists() && !praiseResourceDir.mkdirs()) {
                praiseInstallResultCb.onResult(1, "make praise resource dir failed.");
                return false;
            }
            File file = new File(praiseResourceInfo.mDownloadFilePath);
            File file2 = new File(praiseResourceDir, file.getName());
            if (file2.exists()) {
                file2.delete();
            }
            if (file.length() != 0 && FileUtils.copyFile(file, file2) == file.length()) {
                praiseResourceInfo.mPraiseResSavePath = file2.getPath();
                return true;
            }
            praiseInstallResultCb.onResult(1, "failed to copy praise resource.");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static final PraiseResourceAPSManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? Holder.sINSTANCE : (PraiseResourceAPSManager) invokeV.objValue;
    }

    public static File getPraiseDownloadDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            File file = new File(getPraiseRootDir(), "download");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    @Nullable
    public static File getPraiseIconById(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? getPraiseIconById(str, NightModeHelper.getNightModeSwitcherState()) : (File) invokeL.objValue;
    }

    public static File getPraiseResourceDir(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, str2)) == null) {
            File praiseRootDir = getPraiseRootDir();
            return new File(praiseRootDir, str + File.separator + str2);
        }
        return (File) invokeLL.objValue;
    }

    public static File getPraiseRootDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            String path = AppRuntime.getAppContext().getFilesDir().getPath();
            if (DEBUG) {
                String str = "getPraiseRootDir = " + path;
            }
            return new File(path, PRAISE_ROOT_DIR_NAME);
        }
        return (File) invokeV.objValue;
    }

    public static File[] getRestoreFileList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            File praiseRootDir = getPraiseRootDir();
            if (!praiseRootDir.exists()) {
                boolean z = DEBUG;
                return null;
            }
            File[] listFiles = praiseRootDir.listFiles(new FileFilter() { // from class: com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) ? !file.isDirectory() && PraiseResourceAPSManager.isValidRestoreFileName(file.getName()) : invokeL.booleanValue;
                }
            });
            if (listFiles == null || listFiles.length <= 0) {
                boolean z2 = DEBUG;
                return null;
            }
            return listFiles;
        }
        return (File[]) invokeV.objValue;
    }

    public static boolean isValidRestoreFileName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String lowerCase = str.toLowerCase();
            return lowerCase.endsWith("_lastest.json") && lowerCase.contains(PRAISE_PACKAGE_NAME_FOR_NORMAL);
        }
        return invokeL.booleanValue;
    }

    public static boolean makePraiseRootDirIfNeeded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            File praiseRootDir = getPraiseRootDir();
            if (praiseRootDir.exists()) {
                return true;
            }
            return praiseRootDir.mkdirs();
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preInitPraiseElements() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(4, 8);
            IPraiseElementBuilder.PreBuildConfig preBuildConfig = new IPraiseElementBuilder.PreBuildConfig();
            preBuildConfig.setResourceProvider(getProvider(PRAISE_PACKAGE_NAME_FOR_NORMAL));
            preBuildConfig.setElementCntsMap(hashMap);
            PraiseAnimElementBuilderEx.getInstance().preBuild(preBuildConfig);
            EruptionElementBuilder.getInstance().preBuild(preBuildConfig);
        }
    }

    public static void removeNoIgnoreResources(String str, long... jArr) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, str, jArr) == null) {
            File file = new File(getPraiseRootDir(), str);
            if (file.exists() && (listFiles = file.listFiles(new FileFilter(jArr) { // from class: com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long[] val$ignoreVersions;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$ignoreVersions = jArr;
                }

                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file2)) == null) ? file2.isDirectory() && PraiseResourceAPSManager.willBeRemovedButIgnore(file2, this.val$ignoreVersions) : invokeL.booleanValue;
                }
            })) != null) {
                for (File file2 : listFiles) {
                    FileUtils.deleteFile(file2);
                }
            }
        }
    }

    public static void removeOldResources(PraiseResourceInfo praiseResourceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, praiseResourceInfo) == null) {
            removeNoIgnoreResources(praiseResourceInfo.mPkgName, praiseResourceInfo.mVersion);
        }
    }

    public static void removeTargetResources(String str, long... jArr) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, str, jArr) == null) {
            File file = new File(getPraiseRootDir(), str);
            if (file.exists() && (listFiles = file.listFiles(new FileFilter(jArr) { // from class: com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long[] val$deleteVersions;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {jArr};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$deleteVersions = jArr;
                }

                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file2)) == null) ? file2.isDirectory() && PraiseResourceAPSManager.willBeRemoved(file2, this.val$deleteVersions) : invokeL.booleanValue;
                }
            })) != null) {
                for (File file2 : listFiles) {
                    FileUtils.deleteFile(file2);
                }
            }
        }
    }

    public static PraiseResourceInfo restorePraiseResourceInfo(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, file)) == null) {
            if (file == null || !file.exists()) {
                return null;
            }
            String readFileData = FileUtils.readFileData(file);
            if (TextUtils.isEmpty(readFileData)) {
                return null;
            }
            return PraiseResourceInfo.valueOf(readFileData);
        }
        return (PraiseResourceInfo) invokeL.objValue;
    }

    private void savePraiseResource(PraiseResourceInfo praiseResourceInfo, PraiseInstallResultCb praiseInstallResultCb, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65560, this, praiseResourceInfo, praiseInstallResultCb, z) == null) {
            if (!praiseResourceInfo.isAvailable()) {
                removeTargetResources(praiseResourceInfo.mPkgName, praiseResourceInfo.mVersion);
                praiseInstallResultCb.onResult(1, "praise resource is not available.");
                boolean z2 = DEBUG;
                return;
            }
            IResourceProvider build = new ComboPraiseProvider.Builder(AppRuntime.getAppContext()).setZipInputPath(praiseResourceInfo.mPraiseResSavePath).build();
            if (build == null) {
                removeTargetResources(praiseResourceInfo.mPkgName, praiseResourceInfo.mVersion);
                praiseInstallResultCb.onResult(1, "failed to build provider.");
                boolean z3 = DEBUG;
                return;
            }
            praiseResourceInfo.mProvider = build;
            savePraiseResourceInfo(praiseResourceInfo);
            removeOldResources(praiseResourceInfo);
            if (z && !TextUtils.isEmpty(praiseResourceInfo.mPkgName) && praiseResourceInfo.mPkgName.contains(PRAISE_PACKAGE_NAME_FOR_NORMAL)) {
                if (PraisePerformanceStrategyRuntime.getContext().isEnable()) {
                    String[] strArr = new String[1];
                    strArr[0] = NightModeHelper.getNightModeSwitcherState() ? "day" : "night";
                    build.loadResource(strArr);
                    boolean z4 = DEBUG;
                } else {
                    build.onlyLoadPraiseIcon();
                    boolean z5 = DEBUG;
                }
                this.mResourceMap.put(praiseResourceInfo.mPkgName, praiseResourceInfo);
                this.mLoaded = true;
                if (DEBUG) {
                    String str = "loadToMem success, pkgName = " + praiseResourceInfo.mPkgName;
                }
            }
            preInitPraiseElements();
            praiseInstallResultCb.onResult(0, "praise install success, loadToMem = " + z);
            if (DEBUG) {
                String str2 = "praise install success, loadToMem = " + z;
            }
        }
    }

    private void savePraiseResourceInfo(PraiseResourceInfo praiseResourceInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65561, this, praiseResourceInfo) == null) || praiseResourceInfo == null) {
            return;
        }
        File praiseRootDir = getPraiseRootDir();
        File file = new File(praiseRootDir, praiseResourceInfo.mPkgName + "_lastest.json");
        FileUtils.deleteFile(file);
        FileUtils.saveFile(praiseResourceInfo.toJSONString(), file);
    }

    public static boolean willBeRemoved(File file, long... jArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, file, jArr)) == null) {
            if (jArr == null) {
                return false;
            }
            String name = file.getName();
            for (long j : jArr) {
                if (TextUtils.equals(name, String.valueOf(j))) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean willBeRemovedButIgnore(File file, long... jArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, file, jArr)) == null) {
            if (jArr == null) {
                return false;
            }
            String name = file.getName();
            for (long j : jArr) {
                if (TextUtils.equals(name, String.valueOf(j))) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void doAPSProcess(PraiseResourceInfo praiseResourceInfo, PraiseInstallResultCb praiseInstallResultCb, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, praiseResourceInfo, praiseInstallResultCb, z) == null) {
            if (praiseResourceInfo != null && praiseInstallResultCb != null) {
                if (!praiseResourceInfo.isValid()) {
                    praiseInstallResultCb.onResult(1, "praiseInfo invalid.");
                    boolean z2 = DEBUG;
                    return;
                } else if (makePraiseRootDirIfNeeded() && copyPraiseResourceFile(praiseResourceInfo, praiseInstallResultCb)) {
                    savePraiseResource(praiseResourceInfo, praiseInstallResultCb, z);
                    return;
                } else {
                    praiseInstallResultCb.onResult(1, "failed to make praise root dir or copyPraiseResourceFile.");
                    boolean z3 = DEBUG;
                    return;
                }
            }
            boolean z4 = DEBUG;
        }
    }

    public String getAPSResourceDebugInfo() {
        InterceptResult invokeV;
        List<IResourceProvider.PackageInfo> packageList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("点赞动效APS根目录:" + getPraiseRootDir().getPath());
            sb.append("\n点赞动效合法资源清单:\n");
            Map<String, PraiseResourceInfo> map = this.mResourceMap;
            int i2 = 1;
            if (map != null && !map.isEmpty()) {
                Iterator<Map.Entry<String, PraiseResourceInfo>> it = this.mResourceMap.entrySet().iterator();
                while (it != null && it.hasNext()) {
                    PraiseResourceInfo value = it.next().getValue();
                    if (value != null) {
                        sb.append("\n======第" + i2 + "个资源包======\n");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("包名:");
                        sb2.append(value.mPkgName);
                        sb.append(sb2.toString());
                        sb.append("\n包版本号:" + value.mVersion);
                        sb.append("\n最小宿主版本号:" + value.mMinHostVer);
                        sb.append("\n最大宿主版本号:" + value.mMaxHostVer);
                        sb.append("\nAPS下载路径:" + value.mDownloadFilePath);
                        sb.append("\n包存储路径:" + value.mPraiseResSavePath);
                        IResourceProvider iResourceProvider = value.mProvider;
                        if (iResourceProvider != null && (packageList = iResourceProvider.getPackageList()) != null && packageList.size() > 0) {
                            for (IResourceProvider.PackageInfo packageInfo : packageList) {
                                sb.append("\n<" + packageInfo.mPkgTag + "> shake = " + packageInfo.mResPkg.getResourceCounts("shake"));
                                sb.append("\n<" + packageInfo.mPkgTag + "> wave = " + packageInfo.mResPkg.getResourceCounts("wave"));
                                sb.append("\n<" + packageInfo.mPkgTag + "> level = " + packageInfo.mResPkg.getResourceCounts(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL));
                                sb.append("\n<" + packageInfo.mPkgTag + "> number = " + packageInfo.mResPkg.getResourceCounts("number"));
                                sb.append("\n<" + packageInfo.mPkgTag + "> eruption = " + packageInfo.mResPkg.getResourceCounts(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION));
                                sb.append(StringUtils.LF);
                            }
                        }
                        i2++;
                    }
                }
            } else {
                File[] restoreFileList = getRestoreFileList();
                boolean z = restoreFileList == null || restoreFileList.length <= 0;
                i2 = (ComboPraiseRuntime.getContext() == null || !ComboPraiseRuntime.getContext().getPraiseSwitchState()) ? 0 : 0;
                sb.append("\n暂无\n");
                StringBuilder sb3 = new StringBuilder();
                sb3.append("\n点赞动效资源: ");
                sb3.append(z ? "下载失败\n" : "下载成功\n");
                sb.append(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("\n点赞动效开关: ");
                sb4.append(i2 != 0 ? "开启\n" : "关闭\n");
                sb.append(sb4.toString());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public IResourceProvider getProvider(String str) {
        InterceptResult invokeL;
        PraiseResourceInfo praiseResourceInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!hasValidProvider() || TextUtils.isEmpty(str) || (praiseResourceInfo = this.mResourceMap.get(str)) == null) {
                return null;
            }
            return praiseResourceInfo.mProvider;
        }
        return (IResourceProvider) invokeL.objValue;
    }

    public boolean hasValidProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Map<String, PraiseResourceInfo> map = this.mResourceMap;
            return (map == null || map.isEmpty()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean isDebugLoadMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (DEBUG) {
                return this.mIsDebugLoadMode;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mLoaded : invokeV.booleanValue;
    }

    public void loadPraiseIcon() {
        IResourceProvider build;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            File[] restoreFileList = getRestoreFileList();
            if (restoreFileList != null && restoreFileList.length > 0) {
                for (File file : restoreFileList) {
                    PraiseResourceInfo restorePraiseResourceInfo = restorePraiseResourceInfo(file);
                    if (restorePraiseResourceInfo != null && (build = new ComboPraiseProvider.Builder(AppRuntime.getAppContext()).setZipInputPath(restorePraiseResourceInfo.mPraiseResSavePath).build()) != null) {
                        build.onlyLoadPraiseIcon();
                    }
                }
                return;
            }
            boolean z = DEBUG;
        }
    }

    public void loadResourcesIfNeeded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.mLoaded) {
                boolean z = DEBUG;
                return;
            }
            File[] restoreFileList = getRestoreFileList();
            if (restoreFileList != null && restoreFileList.length > 0) {
                boolean z2 = false;
                for (File file : restoreFileList) {
                    PraiseResourceInfo restorePraiseResourceInfo = restorePraiseResourceInfo(file);
                    if (restorePraiseResourceInfo != null) {
                        IResourceProvider build = new ComboPraiseProvider.Builder(AppRuntime.getAppContext()).setZipInputPath(restorePraiseResourceInfo.mPraiseResSavePath).build();
                        if (build != null) {
                            if (!z2) {
                                releaseResources();
                                z2 = true;
                            }
                            String[] strArr = new String[1];
                            strArr[0] = NightModeHelper.getNightModeSwitcherState() ? "day" : "night";
                            build.loadResource(strArr);
                            restorePraiseResourceInfo.mProvider = build;
                            this.mResourceMap.put(restorePraiseResourceInfo.mPkgName, restorePraiseResourceInfo);
                            this.mLoaded = true;
                            preInitPraiseElements();
                            if (DEBUG) {
                                String str = "loadResourcesIfNeeded success, pkgName = " + restorePraiseResourceInfo.mPkgName;
                            }
                        } else if (DEBUG) {
                            String str2 = "loadResourcesIfNeeded failed, pkgName = " + restorePraiseResourceInfo.mPkgName;
                        }
                    }
                }
                if (this.mLoaded || !DEBUG) {
                    return;
                }
                for (File file2 : restoreFileList) {
                    FileUtils.deleteFile(file2);
                }
                return;
            }
            boolean z3 = DEBUG;
        }
    }

    public void mockDoAPSProcess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            doAPSProcess(new PraiseResourceInfo(PRAISE_PACKAGE_NAME_FOR_NORMAL, Environment.getExternalStorageDirectory().getPath() + File.separator + "lottie.zip", "", 1L, "0", "10101010"), new PraiseInstallResultCb(this) { // from class: com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PraiseResourceAPSManager this$0;

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

                @Override // com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager.PraiseInstallResultCb
                public void onResult(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    }
                }
            }, true);
        }
    }

    @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
    public void onNightModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            Map<String, PraiseResourceInfo> map = this.mResourceMap;
            if (map != null && !map.isEmpty()) {
                ExecutorUtilsExt.postOnElastic(new Runnable(this, z) { // from class: com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PraiseResourceAPSManager this$0;
                    public final /* synthetic */ boolean val$isNightMode;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(z)};
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
                        this.val$isNightMode = z;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IResourceProvider iResourceProvider;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Iterator it = this.this$0.mResourceMap.entrySet().iterator();
                            while (it != null && it.hasNext()) {
                                PraiseResourceInfo praiseResourceInfo = (PraiseResourceInfo) ((Map.Entry) it.next()).getValue();
                                if (praiseResourceInfo != null && (iResourceProvider = praiseResourceInfo.mProvider) != null) {
                                    String[] strArr = new String[1];
                                    strArr[0] = this.val$isNightMode ? "day" : "night";
                                    iResourceProvider.loadResource(strArr);
                                    this.this$0.preInitPraiseElements();
                                    if (this.val$isNightMode) {
                                        if (PraiseResourceAPSManager.DEBUG) {
                                            String str = praiseResourceInfo.mPkgName + " has been switched to night mode";
                                        }
                                    } else if (PraiseResourceAPSManager.DEBUG) {
                                        String str2 = praiseResourceInfo.mPkgName + " has been switched to day mode";
                                    }
                                }
                            }
                        }
                    }
                }, "praiseResNightModeProcess", 2);
            } else {
                boolean z2 = DEBUG;
            }
        }
    }

    public void releaseResources() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.mLoaded) {
            Map<String, PraiseResourceInfo> map = this.mResourceMap;
            if (map != null && !map.isEmpty()) {
                Iterator<Map.Entry<String, PraiseResourceInfo>> it = this.mResourceMap.entrySet().iterator();
                while (it != null && it.hasNext()) {
                    PraiseResourceInfo value = it.next().getValue();
                    if (value != null) {
                        value.mProvider = null;
                    }
                }
                this.mResourceMap.clear();
            }
            this.mLoaded = false;
        }
    }

    public void setDebugLoadMode(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && DEBUG) {
            releaseResources();
            this.mIsDebugLoadMode = z;
            File[] restoreFileList = getRestoreFileList();
            if (restoreFileList != null && restoreFileList.length > 0) {
                for (File file : restoreFileList) {
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                }
            }
            if (this.mIsDebugLoadMode) {
                getInstance().mockDoAPSProcess();
            }
        }
    }

    public PraiseResourceAPSManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mNightModeSubObj = new Object();
        this.mIsDebugLoadMode = false;
        this.mResourceMap = new ConcurrentHashMap();
        NightModeHelper.subscribeNightModeChangeEvent(this.mNightModeSubObj, this);
    }

    @Nullable
    public static File getPraiseIconById(String str, boolean z) {
        InterceptResult invokeLZ;
        File[] praiseIconById;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65549, null, str, z)) == null) {
            File[] restoreFileList = getRestoreFileList();
            if (restoreFileList != null && restoreFileList.length > 0) {
                for (File file : restoreFileList) {
                    PraiseResourceInfo restorePraiseResourceInfo = restorePraiseResourceInfo(file);
                    if (restorePraiseResourceInfo != null && (praiseIconById = new ComboPraiseProvider.Builder(AppRuntime.getAppContext()).setZipInputPath(restorePraiseResourceInfo.mPraiseResSavePath).build().getPraiseIconById(str, z)) != null && praiseIconById.length > 0) {
                        if (DEBUG) {
                            StringBuilder sb = new StringBuilder();
                            for (File file2 : praiseIconById) {
                                sb.append(file2.getPath());
                                sb.append("; ");
                            }
                            String str2 = "获取到匹配的文件：" + ((Object) sb);
                        }
                        return praiseIconById[0];
                    }
                }
            }
            return null;
        }
        return (File) invokeLZ.objValue;
    }
}

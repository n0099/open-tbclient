package com.baidu.spswitch.emotion.resource;

import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.spswitch.emotion.EmotionUsageUtil;
import com.baidu.spswitch.emotion.EmotionUtils;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.spswitch.utils.SPConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class EmotionAPSManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String EMOTION_DOWNLOAD_DIR_NAME = "download";
    public static final int EMOTION_INSTALL_FAILED = 1;
    public static final int EMOTION_INSTALL_SUCCESS = 0;
    public static final String EMOTION_PACKAGE_NAME_FOR_NORMAL = "com.baidu.spswitch.emotion";
    public static final String EMOTION_PRESET_PATH = "emotion/com.baidu.spswitch.emotion.preset.zip";
    public static final String EMOTION_ROOT_DIR_NAME = "emotion_root";
    public static final long MOCK_VERSION = -2;
    public static final long PRESET_VERSION = -1;
    public static final String RESTORE_SUFFIX = "_lastest.json";
    public static final String TAG = "EmotionAPSManager";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsDebugLoadMode;
    public volatile boolean mLoaded;
    public Map<String, EmotionResourceInfo> mResourceMap;

    /* loaded from: classes10.dex */
    public interface EmotionInstallResultCb {
        void onResult(int i2, String str);
    }

    /* loaded from: classes10.dex */
    public static final class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static final EmotionAPSManager sINSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1553916274, "Lcom/baidu/spswitch/emotion/resource/EmotionAPSManager$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1553916274, "Lcom/baidu/spswitch/emotion/resource/EmotionAPSManager$Holder;");
                    return;
                }
            }
            sINSTANCE = new EmotionAPSManager();
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-651166732, "Lcom/baidu/spswitch/emotion/resource/EmotionAPSManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-651166732, "Lcom/baidu/spswitch/emotion/resource/EmotionAPSManager;");
                return;
            }
        }
        DEBUG = SPConfig.isDebug();
        try {
            Class.forName(EmotionUsageUtil.class.getName());
        } catch (ClassNotFoundException unused) {
        }
    }

    public static boolean copyEmotionResourceFile(EmotionResourceInfo emotionResourceInfo, EmotionInstallResultCb emotionInstallResultCb) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, emotionResourceInfo, emotionInstallResultCb)) == null) {
            File emotionResourceDir = getEmotionResourceDir(emotionResourceInfo.mPkgName, String.valueOf(emotionResourceInfo.mVersion));
            if (!emotionResourceDir.exists() && !emotionResourceDir.mkdirs()) {
                emotionInstallResultCb.onResult(1, "make emotion resource dir failed.");
                return false;
            }
            File file = new File(emotionResourceInfo.mDownloadFilePath);
            File file2 = new File(emotionResourceDir, file.getName());
            if (file2.exists()) {
                file2.delete();
            }
            if (emotionResourceInfo.mVersion == -1) {
                InputStream inputStream = null;
                try {
                    InputStream open = AppRuntime.getAppContext().getAssets().open(emotionResourceInfo.mDownloadFilePath);
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            if (FileUtils.copyStream(open, fileOutputStream) == 0) {
                                emotionInstallResultCb.onResult(1, "failed to copy emotion resource.");
                                Closeables.closeSafely(open);
                                Closeables.closeSafely(fileOutputStream);
                                return false;
                            }
                            Closeables.closeSafely(open);
                            Closeables.closeSafely(fileOutputStream);
                        } catch (IOException e2) {
                            e = e2;
                            inputStream = open;
                            try {
                                e.printStackTrace();
                                emotionInstallResultCb.onResult(1, "failed to copy emotion resource.");
                                Closeables.closeSafely(inputStream);
                                Closeables.closeSafely(fileOutputStream);
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                Closeables.closeSafely(inputStream);
                                Closeables.closeSafely(fileOutputStream);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = open;
                            Closeables.closeSafely(inputStream);
                            Closeables.closeSafely(fileOutputStream);
                            throw th;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        fileOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                    }
                } catch (IOException e4) {
                    e = e4;
                    fileOutputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                }
            } else if (file.length() == 0 || FileUtils.copyFile(file, file2) != file.length()) {
                emotionInstallResultCb.onResult(1, "failed to copy emotion resource.");
                return false;
            }
            emotionResourceInfo.mEmotionResSavePath = file2.getPath();
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static File getEmotionDownloadDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            File file = new File(getEmotionRootDir(), "download");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static File getEmotionResourceDir(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            File emotionRootDir = getEmotionRootDir();
            return new File(emotionRootDir, str + File.separator + str2);
        }
        return (File) invokeLL.objValue;
    }

    public static File getEmotionRootDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            String path = AppRuntime.getAppContext().getFilesDir().getPath();
            if (DEBUG) {
                String str = "getEmotionRootDir = " + path;
            }
            return new File(path, EMOTION_ROOT_DIR_NAME);
        }
        return (File) invokeV.objValue;
    }

    public static final EmotionAPSManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? Holder.sINSTANCE : (EmotionAPSManager) invokeV.objValue;
    }

    public static File[] getRestoreFileList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            File emotionRootDir = getEmotionRootDir();
            if (!emotionRootDir.exists()) {
                boolean z = DEBUG;
                return null;
            }
            File[] listFiles = emotionRootDir.listFiles(new FileFilter() { // from class: com.baidu.spswitch.emotion.resource.EmotionAPSManager.3
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
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) ? !file.isDirectory() && EmotionAPSManager.isValidRestoreFileName(file.getName()) : invokeL.booleanValue;
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

    public static boolean hasPresetRestoreFile(File[] fileArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, fileArr)) == null) {
            if (fileArr != null && fileArr.length > 0) {
                for (File file : fileArr) {
                    EmotionResourceInfo restoreEmotionResourceInfo = restoreEmotionResourceInfo(file);
                    if (restoreEmotionResourceInfo != null && restoreEmotionResourceInfo.mVersion == -1) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isValidRestoreFileName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String lowerCase = str.toLowerCase();
            return lowerCase.endsWith(RESTORE_SUFFIX) && lowerCase.contains(EMOTION_PACKAGE_NAME_FOR_NORMAL);
        }
        return invokeL.booleanValue;
    }

    public static boolean makeEmotionRootDirIfNeeded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            File emotionRootDir = getEmotionRootDir();
            if (emotionRootDir.exists()) {
                return true;
            }
            return emotionRootDir.mkdirs();
        }
        return invokeV.booleanValue;
    }

    public static void removeNoIgnoreResources(String str, long... jArr) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, jArr) == null) {
            File file = new File(getEmotionRootDir(), str);
            if (file.exists() && (listFiles = file.listFiles(new FileFilter(jArr) { // from class: com.baidu.spswitch.emotion.resource.EmotionAPSManager.4
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
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file2)) == null) ? file2.isDirectory() && EmotionAPSManager.willBeRemovedButIgnore(file2, this.val$ignoreVersions) : invokeL.booleanValue;
                }
            })) != null) {
                for (File file2 : listFiles) {
                    FileUtils.deleteFile(file2);
                }
            }
        }
    }

    public static void removeOldResources(EmotionResourceInfo emotionResourceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, emotionResourceInfo) == null) {
            removeNoIgnoreResources(emotionResourceInfo.mPkgName, emotionResourceInfo.mVersion);
        }
    }

    public static void removeTargetResources(String str, long... jArr) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, str, jArr) == null) {
            File file = new File(getEmotionRootDir(), str);
            if (file.exists() && (listFiles = file.listFiles(new FileFilter(jArr) { // from class: com.baidu.spswitch.emotion.resource.EmotionAPSManager.5
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
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file2)) == null) ? file2.isDirectory() && EmotionAPSManager.willBeRemoved(file2, this.val$deleteVersions) : invokeL.booleanValue;
                }
            })) != null) {
                for (File file2 : listFiles) {
                    FileUtils.deleteFile(file2);
                }
            }
        }
    }

    public static EmotionResourceInfo restoreEmotionResourceInfo(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, file)) == null) {
            if (file == null || !file.exists()) {
                return null;
            }
            String readFileData = FileUtils.readFileData(file);
            if (TextUtils.isEmpty(readFileData)) {
                return null;
            }
            return EmotionResourceInfo.valueOf(readFileData);
        }
        return (EmotionResourceInfo) invokeL.objValue;
    }

    private void saveEmotionResource(EmotionResourceInfo emotionResourceInfo, EmotionInstallResultCb emotionInstallResultCb, boolean z) {
        boolean z2;
        IResourceProvider iResourceProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65555, this, emotionResourceInfo, emotionInstallResultCb, z) == null) {
            if (!emotionResourceInfo.isAvailable()) {
                removeTargetResources(emotionResourceInfo.mPkgName, emotionResourceInfo.mVersion);
                emotionInstallResultCb.onResult(1, "emotion resource is not available.");
                boolean z3 = DEBUG;
                return;
            }
            IResourceProvider build = new EmotionResourceProvider.Builder(AppRuntime.getAppContext()).setZipInputPath(emotionResourceInfo.mEmotionResSavePath).build();
            if (build == null) {
                removeTargetResources(emotionResourceInfo.mPkgName, emotionResourceInfo.mVersion);
                emotionInstallResultCb.onResult(1, "failed to build provider.");
                boolean z4 = DEBUG;
                return;
            }
            emotionResourceInfo.mProvider = build;
            EmotionResourceInfo emotionResourceInfo2 = this.mResourceMap.get(emotionResourceInfo.mPkgName);
            if (z) {
                if (TextUtils.isEmpty(emotionResourceInfo.mPkgName) || !emotionResourceInfo.mPkgName.contains(EMOTION_PACKAGE_NAME_FOR_NORMAL)) {
                    z2 = false;
                } else {
                    build.loadResource();
                    z2 = EmotionUtils.getInstance().loadEmotionInfo(build);
                    if (z2) {
                        if (emotionResourceInfo2 != null && (iResourceProvider = emotionResourceInfo2.mProvider) != null) {
                            iResourceProvider.releaseResource();
                        }
                        this.mResourceMap.put(emotionResourceInfo.mPkgName, emotionResourceInfo);
                        this.mLoaded = true;
                        if (DEBUG) {
                            String str = "loadToMem success, pkgName = " + emotionResourceInfo.mPkgName;
                        }
                    }
                }
                if (z2) {
                    removeOldResources(emotionResourceInfo);
                    saveEmotionResourceInfo(emotionResourceInfo);
                    emotionInstallResultCb.onResult(0, "emotion install success, loadToMem = " + z);
                    if (DEBUG) {
                        String str2 = "emotion install success, loadToMem = " + z;
                        return;
                    }
                    return;
                }
                build.releaseResource();
                removeTargetResources(emotionResourceInfo.mPkgName, emotionResourceInfo.mVersion);
                emotionInstallResultCb.onResult(1, "failed to load EmotionInfo.");
                boolean z5 = DEBUG;
                return;
            }
            removeOldResources(emotionResourceInfo);
            saveEmotionResourceInfo(emotionResourceInfo);
            emotionInstallResultCb.onResult(0, "emotion install success, loadToMem = " + z);
            if (DEBUG) {
                String str3 = "emotion install success, loadToMem = " + z;
            }
        }
    }

    private void saveEmotionResourceInfo(EmotionResourceInfo emotionResourceInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65556, this, emotionResourceInfo) == null) || emotionResourceInfo == null) {
            return;
        }
        File emotionRootDir = getEmotionRootDir();
        File file = new File(emotionRootDir, emotionResourceInfo.mPkgName + RESTORE_SUFFIX);
        FileUtils.deleteFile(file);
        FileUtils.saveFile(emotionResourceInfo.toJSONString(), file);
    }

    public static boolean willBeRemoved(File file, long... jArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, file, jArr)) == null) {
            if (jArr == null) {
                return false;
            }
            String name = file.getName();
            for (long j2 : jArr) {
                if (TextUtils.equals(name, String.valueOf(j2))) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, file, jArr)) == null) {
            if (jArr == null) {
                return false;
            }
            String name = file.getName();
            for (long j2 : jArr) {
                if (TextUtils.equals(name, String.valueOf(j2))) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void doAPSProcess(EmotionResourceInfo emotionResourceInfo, EmotionInstallResultCb emotionInstallResultCb, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, emotionResourceInfo, emotionInstallResultCb, z) == null) {
            if (emotionResourceInfo != null && emotionInstallResultCb != null) {
                if (!emotionResourceInfo.isValid()) {
                    emotionInstallResultCb.onResult(1, "emotionInfo invalid.");
                    boolean z2 = DEBUG;
                    return;
                } else if (makeEmotionRootDirIfNeeded() && copyEmotionResourceFile(emotionResourceInfo, emotionInstallResultCb)) {
                    saveEmotionResource(emotionResourceInfo, emotionInstallResultCb, z);
                    return;
                } else {
                    emotionInstallResultCb.onResult(1, "failed to make emotion root dir or copyEmotionResourceFile.");
                    boolean z3 = DEBUG;
                    return;
                }
            }
            boolean z4 = DEBUG;
        }
    }

    public IResourceProvider getProvider(String str) {
        InterceptResult invokeL;
        EmotionResourceInfo emotionResourceInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (!hasValidProvider() || TextUtils.isEmpty(str) || (emotionResourceInfo = this.mResourceMap.get(str)) == null) {
                return null;
            }
            return emotionResourceInfo.mProvider;
        }
        return (IResourceProvider) invokeL.objValue;
    }

    public String getResourceDebugInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("表情APS根目录:" + getEmotionRootDir().getPath());
            sb.append("\n合法资源清单:\n");
            Map<String, EmotionResourceInfo> map = this.mResourceMap;
            int i2 = 1;
            if (map != null && !map.isEmpty()) {
                Iterator<Map.Entry<String, EmotionResourceInfo>> it = this.mResourceMap.entrySet().iterator();
                while (it != null && it.hasNext()) {
                    EmotionResourceInfo value = it.next().getValue();
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
                        sb.append("\n包存储路径:" + value.mEmotionResSavePath);
                        i2++;
                    }
                }
            } else {
                File[] restoreFileList = getRestoreFileList();
                if (restoreFileList != null && restoreFileList.length > 0) {
                    i2 = 0;
                }
                sb.append("\n暂无\n");
                StringBuilder sb3 = new StringBuilder();
                sb3.append("\n表情资源: ");
                sb3.append(i2 != 0 ? "下载失败\n" : "下载成功\n");
                sb.append(sb3.toString());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean hasValidProvider() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Map<String, EmotionResourceInfo> map = this.mResourceMap;
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

    public void loadResourcesIfNeeded() {
        IResourceProvider iResourceProvider;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.mLoaded) {
                boolean z = DEBUG;
                return;
            }
            File[] restoreFileList = getRestoreFileList();
            if (restoreFileList != null && restoreFileList.length > 0) {
                int length = restoreFileList.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    File file = restoreFileList[i2];
                    EmotionResourceInfo restoreEmotionResourceInfo = restoreEmotionResourceInfo(file);
                    if (restoreEmotionResourceInfo != null) {
                        EmotionResourceInfo emotionResourceInfo = this.mResourceMap.get(restoreEmotionResourceInfo.mPkgName);
                        IResourceProvider build = new EmotionResourceProvider.Builder(AppRuntime.getAppContext()).setZipInputPath(restoreEmotionResourceInfo.mEmotionResSavePath).build();
                        if (build != null) {
                            build.loadResource();
                            restoreEmotionResourceInfo.mProvider = build;
                            if (EmotionUtils.getInstance().loadEmotionInfo(build)) {
                                if (emotionResourceInfo != null && (iResourceProvider = emotionResourceInfo.mProvider) != null) {
                                    iResourceProvider.releaseResource();
                                }
                                this.mResourceMap.put(restoreEmotionResourceInfo.mPkgName, restoreEmotionResourceInfo);
                                this.mLoaded = true;
                                if (DEBUG) {
                                    String str = "loadResourcesIfNeeded success, pkgName = " + restoreEmotionResourceInfo.mPkgName;
                                }
                            } else {
                                build.releaseResource();
                                removeTargetResources(restoreEmotionResourceInfo.mPkgName, restoreEmotionResourceInfo.mVersion);
                                FileUtils.deleteFile(file);
                                if (DEBUG) {
                                    String str2 = "loadResourcesIfNeeded failed1, pkgName = " + restoreEmotionResourceInfo.mPkgName;
                                }
                            }
                        } else {
                            removeTargetResources(restoreEmotionResourceInfo.mPkgName, restoreEmotionResourceInfo.mVersion);
                            FileUtils.deleteFile(file);
                            if (DEBUG) {
                                String str3 = "loadResourcesIfNeeded failed2, pkgName = " + restoreEmotionResourceInfo.mPkgName;
                            }
                        }
                    } else {
                        FileUtils.deleteFile(file);
                    }
                    i2++;
                }
                if (this.mLoaded) {
                    return;
                }
                boolean z2 = DEBUG;
                return;
            }
            boolean z3 = DEBUG;
        }
    }

    public void mockDoAPSProcess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            doAPSProcess(new EmotionResourceInfo(EMOTION_PACKAGE_NAME_FOR_NORMAL, Environment.getExternalStorageDirectory().getPath() + File.separator + "emotion.zip", "", -2L, "0.0.0.0", "255.255.255.255"), new EmotionInstallResultCb(this) { // from class: com.baidu.spswitch.emotion.resource.EmotionAPSManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EmotionAPSManager this$0;

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

                @Override // com.baidu.spswitch.emotion.resource.EmotionAPSManager.EmotionInstallResultCb
                public void onResult(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    }
                }
            }, true);
        }
    }

    public void presetDoAPSProcess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            doAPSProcess(new EmotionResourceInfo(EMOTION_PACKAGE_NAME_FOR_NORMAL, EMOTION_PRESET_PATH, "", -1L, "0.0.0.0", "255.255.255.255"), new EmotionInstallResultCb(this) { // from class: com.baidu.spswitch.emotion.resource.EmotionAPSManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EmotionAPSManager this$0;

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

                @Override // com.baidu.spswitch.emotion.resource.EmotionAPSManager.EmotionInstallResultCb
                public void onResult(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    }
                }
            }, true);
        }
    }

    public void releaseResources() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.mLoaded) {
            Map<String, EmotionResourceInfo> map = this.mResourceMap;
            if (map != null && !map.isEmpty()) {
                Iterator<Map.Entry<String, EmotionResourceInfo>> it = this.mResourceMap.entrySet().iterator();
                while (it != null && it.hasNext()) {
                    EmotionResourceInfo value = it.next().getValue();
                    if (value != null) {
                        value.mProvider.releaseResource();
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
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && DEBUG) {
            this.mIsDebugLoadMode = z;
            if (EmotionDownloadRuntime.getDownloadImpl() != null) {
                EmotionDownloadRuntime.getDownloadImpl().downloadRetryImmediately();
            }
        }
    }

    public EmotionAPSManager() {
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
        this.mIsDebugLoadMode = false;
        this.mResourceMap = new ConcurrentHashMap();
    }
}

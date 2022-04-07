package com.baidu.spswitch.emotion.resource;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.FileUtils;
import com.baidu.spswitch.utils.SPConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class EmotionResourceProvider implements IResourceProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String EMOTION_CONFIG_NAME = "emotion_info.json";
    public static final String EMOTION_RES_NAME_SUFFIX = ".png";
    public static final String EMOTION_SOUND_SUFFIX = ".mp3";
    public static final String TAG = "EmotionResourceProvider";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public String mEmotionConfigInfo;
    public Map<String, File> mEmotionIconFileMap;
    public File mEmotionSoundFile;
    public File mResourcePath;

    /* loaded from: classes2.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DEFAULT_UNZIP_DIR_NAME = "emotion_unzip";
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;
        public File mProcessedResPath;
        public EmotionResourceProvider mProvider;
        public File mUnZipOutputPath;
        public File mZipInputPath;

        public Builder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mContext = context;
        }

        private void releaseProvider() {
            EmotionResourceProvider emotionResourceProvider;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (emotionResourceProvider = this.mProvider) == null) {
                return;
            }
            emotionResourceProvider.releaseResource();
        }

        public IResourceProvider build() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mProcessedResPath != null) {
                    releaseProvider();
                    this.mProvider = new EmotionResourceProvider(this.mContext, this.mProcessedResPath);
                } else {
                    File file = this.mZipInputPath;
                    if (file == null || this.mUnZipOutputPath == null) {
                        if (EmotionResourceProvider.DEBUG) {
                            Log.d(EmotionResourceProvider.TAG, "build failed, ZipInputPath or UnZipOutputPath is empty");
                        }
                        return null;
                    }
                    try {
                        z = FileUtils.unzipFile(file.getPath(), this.mUnZipOutputPath.getPath());
                    } catch (Exception unused) {
                        z = false;
                    }
                    if (!z) {
                        if (EmotionResourceProvider.DEBUG) {
                            Log.d(EmotionResourceProvider.TAG, "build failed, failed to unzip, src:" + this.mZipInputPath.getPath() + ", dest:" + this.mUnZipOutputPath.getPath());
                        }
                        return null;
                    }
                    releaseProvider();
                    this.mProvider = new EmotionResourceProvider(this.mContext, this.mUnZipOutputPath);
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1622394370, "Lcom/baidu/spswitch/emotion/resource/EmotionResourceProvider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1622394370, "Lcom/baidu/spswitch/emotion/resource/EmotionResourceProvider;");
                return;
            }
        }
        DEBUG = SPConfig.isDebug();
    }

    public EmotionResourceProvider(Context context, File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, file};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mEmotionConfigInfo = "";
        this.mEmotionIconFileMap = new HashMap();
        this.mResourcePath = file;
        this.mContext = context;
    }

    private void clearAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.mEmotionIconFileMap.clear();
            this.mEmotionConfigInfo = "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0071 A[Catch: IOException -> 0x006d, TRY_LEAVE, TryCatch #5 {IOException -> 0x006d, blocks: (B:41:0x0069, B:45:0x0071), top: B:57:0x0069 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void getEmotionConfigInfo(File file) {
        FileInputStream fileInputStream;
        IOException e;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, this, file) == null) && file != null && file.exists()) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (IOException e3) {
                fileInputStream = null;
                e = e3;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, IMAudioTransRequest.CHARSET));
                try {
                    try {
                        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                            sb.append(readLine);
                        }
                        bufferedReader.close();
                        fileInputStream.close();
                    } catch (IOException e4) {
                        e = e4;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        this.mEmotionConfigInfo = sb.toString();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader2 != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
            this.mEmotionConfigInfo = sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFilteredResDir(File file, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, file, strArr)) == null) {
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

    private void searchEmotionConfig(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, file) == null) || file == null || !file.exists() || (listFiles = file.listFiles(new FileFilter(this) { // from class: com.baidu.spswitch.emotion.resource.EmotionResourceProvider.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EmotionResourceProvider this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file2)) == null) ? !file2.isDirectory() && this.this$0.isFilteredResDir(file2, "emotion_info.json") : invokeL.booleanValue;
            }
        })) == null || listFiles.length <= 0) {
            return;
        }
        getEmotionConfigInfo(listFiles[0]);
    }

    private void searchEmotionIcon(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, this, file) == null) && file != null && file.exists()) {
            file.listFiles(new FileFilter(this) { // from class: com.baidu.spswitch.emotion.resource.EmotionResourceProvider.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EmotionResourceProvider this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                        if (file2.isDirectory() || !this.this$0.isFilteredResDir(file2, EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX)) {
                            return false;
                        }
                        this.this$0.mEmotionIconFileMap.put(file2.getName(), file2);
                        return true;
                    }
                    return invokeL.booleanValue;
                }
            });
        }
    }

    private void searchEmotionSound(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, file) == null) || file == null || !file.exists() || (listFiles = file.listFiles(new FileFilter(this) { // from class: com.baidu.spswitch.emotion.resource.EmotionResourceProvider.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EmotionResourceProvider this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file2)) == null) ? !file2.isDirectory() && this.this$0.isFilteredResDir(file2, ".mp3") : invokeL.booleanValue;
            }
        })) == null || listFiles.length <= 0) {
            return;
        }
        this.mEmotionSoundFile = listFiles[0];
    }

    @Override // com.baidu.spswitch.emotion.resource.IResourceProvider
    public String getEmotionConfigContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mEmotionConfigInfo : (String) invokeV.objValue;
    }

    @Override // com.baidu.spswitch.emotion.resource.IResourceProvider
    public File getEmotionIconResFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.mEmotionIconFileMap.get(str) : (File) invokeL.objValue;
    }

    @Override // com.baidu.spswitch.emotion.resource.IResourceProvider
    public File getEmotionSoundFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mEmotionSoundFile : (File) invokeV.objValue;
    }

    @Override // com.baidu.spswitch.emotion.resource.IResourceProvider
    public void loadResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                clearAll();
                searchEmotionConfig(this.mResourcePath);
                searchEmotionIcon(this.mResourcePath);
                searchEmotionSound(this.mResourcePath);
            }
        }
    }

    @Override // com.baidu.spswitch.emotion.resource.IResourceProvider
    public void releaseResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            clearAll();
        }
    }
}

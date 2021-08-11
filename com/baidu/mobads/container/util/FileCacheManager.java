package com.baidu.mobads.container.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: classes5.dex */
public class FileCacheManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FILE_CHECK_COMPLETION = 256;
    public static long MAX_CACHA_Byte = 50000000;
    public static final long MAX_CACHE_KB_DEFAULT = 50000000;
    public transient /* synthetic */ FieldHolder $fh;
    public MyHandler mHandler;
    public IFileCacheCheckListener mListener;

    /* loaded from: classes5.dex */
    public interface IFileCacheCheckListener {
        void checkFileCacheEnd();
    }

    /* loaded from: classes5.dex */
    public static class MyHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<FileCacheManager> mReference;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyHandler(FileCacheManager fileCacheManager) {
            super(Looper.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fileCacheManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mReference = new WeakReference<>(fileCacheManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            FileCacheManager fileCacheManager;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || (fileCacheManager = this.mReference.get()) == null) {
                return;
            }
            if (message.what == 256 && fileCacheManager.mListener != null) {
                fileCacheManager.mListener.checkFileCacheEnd();
            }
            super.handleMessage(message);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1507722810, "Lcom/baidu/mobads/container/util/FileCacheManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1507722810, "Lcom/baidu/mobads/container/util/FileCacheManager;");
        }
    }

    public FileCacheManager() {
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
        this.mHandler = new MyHandler(this);
    }

    public static void setMaxCache(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2) == null) {
            MAX_CACHA_Byte = i2 * 1000 * 1000;
        }
    }

    public void clear(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            TaskScheduler.getInstance().submit(new BaseTask(this, str) { // from class: com.baidu.mobads.container.util.FileCacheManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FileCacheManager this$0;
                public final /* synthetic */ String val$outputFolder;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
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
                    this.val$outputFolder = str;
                }

                @Override // com.baidu.mobads.container.executor.BaseTask
                public Object doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        try {
                            File file = new File(this.val$outputFolder);
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            File[] listFiles = file.listFiles();
                            if (listFiles == null || listFiles.length <= 0) {
                                if (this.this$0.mHandler != null) {
                                    this.this$0.mHandler.sendEmptyMessage(256);
                                    return null;
                                }
                                return null;
                            }
                            Arrays.sort(listFiles, new Comparator<File>(this) { // from class: com.baidu.mobads.container.util.FileCacheManager.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // java.util.Comparator
                                public int compare(File file2, File file3) {
                                    InterceptResult invokeLL;
                                    Interceptable interceptable3 = $ic;
                                    return (interceptable3 == null || (invokeLL = interceptable3.invokeLL(1048576, this, file2, file3)) == null) ? Long.valueOf(file2.lastModified()).compareTo(Long.valueOf(file3.lastModified())) : invokeLL.intValue;
                                }
                            });
                            long j2 = 0;
                            for (int length = listFiles.length - 1; length >= 0; length--) {
                                File file2 = listFiles[length];
                                if (file2.exists()) {
                                    if (file2.length() + j2 > FileCacheManager.MAX_CACHA_Byte) {
                                        file2.delete();
                                    } else {
                                        j2 += file2.length();
                                    }
                                }
                            }
                            if (this.this$0.mHandler != null) {
                                this.this$0.mHandler.sendEmptyMessage(256);
                                return null;
                            }
                            return null;
                        } catch (Exception unused) {
                            return null;
                        }
                    }
                    return invokeV.objValue;
                }
            });
        }
    }

    public void setFileCheckCompletion(IFileCacheCheckListener iFileCacheCheckListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iFileCacheCheckListener) == null) {
            this.mListener = iFileCacheCheckListener;
        }
    }

    public void updateFileLastModified(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    file.setLastModified(System.currentTimeMillis());
                }
            } catch (Exception unused) {
            }
        }
    }
}

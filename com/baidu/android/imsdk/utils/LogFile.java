package com.baidu.android.imsdk.utils;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes10.dex */
public class LogFile {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "LogFile";
    public static LogFile mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(467737952, "Lcom/baidu/android/imsdk/utils/LogFile;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(467737952, "Lcom/baidu/android/imsdk/utils/LogFile;");
        }
    }

    public LogFile(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    public static synchronized LogFile getInstance(Context context) {
        InterceptResult invokeL;
        LogFile logFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (LogFile.class) {
                if (mInstance == null) {
                    mInstance = new LogFile(context);
                }
                logFile = mInstance;
            }
            return logFile;
        }
        return (LogFile) invokeL.objValue;
    }

    public void writeByte(byte[] bArr) {
        IMTrack.CrashBuilder crashBuilder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bArr) == null) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    Context context = this.mContext;
                    fileOutputStream = context.openFileOutput(LogUtils.fileName() + ".log", 32768);
                    if (fileOutputStream != null) {
                        fileOutputStream.write(bArr);
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            LogUtils.e(TAG, "Exception ", e);
                            crashBuilder = new IMTrack.CrashBuilder(this.mContext);
                            crashBuilder.exception(Log.getStackTraceString(e)).build();
                        }
                    }
                } catch (Exception e3) {
                    LogUtils.e(TAG, "Exception ", e3);
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e3)).build();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e = e4;
                            LogUtils.e(TAG, "Exception ", e);
                            crashBuilder = new IMTrack.CrashBuilder(this.mContext);
                            crashBuilder.exception(Log.getStackTraceString(e)).build();
                        }
                    }
                }
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        LogUtils.e(TAG, "Exception ", e5);
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e5)).build();
                    }
                }
                throw th;
            }
        }
    }
}

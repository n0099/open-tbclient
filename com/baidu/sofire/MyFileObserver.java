package com.baidu.sofire;

import android.content.Context;
import android.os.FileObserver;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.d.D;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.sofire.utility.ThreadPoolManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes2.dex */
public class MyFileObserver extends FileObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mBackupfile;
    public Context mContext;
    public int mKey;
    public String mWatchingfile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyFileObserver(Context context, int i, String str, String str2) {
        super(str, 4095);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        try {
            this.mWatchingfile = str;
            this.mBackupfile = str2;
            this.mKey = i;
            this.mContext = context;
        } catch (Throwable th) {
            CommonMethods.handleNuLException(th);
        }
    }

    public boolean deleteBackUpFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                File file = new File(this.mBackupfile);
                if (file.exists()) {
                    return file.delete();
                }
                return false;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            if (i == 2 || i == 4 || i == 64 || i == 128 || i == 512 || i == 1024 || i == 2048) {
                try {
                    ThreadPoolManager.getInstance(this.mContext).execute(new Runnable(this) { // from class: com.baidu.sofire.MyFileObserver.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MyFileObserver this$0;

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

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    synchronized (MyFileObserver.class) {
                                        if (!CommonMethods.isFileExist(this.this$0.mWatchingfile)) {
                                            CommonMethods.copyFile(this.this$0.mBackupfile, this.this$0.mWatchingfile);
                                            CommonMethods.ensureQuanxian(this.this$0.mWatchingfile, true);
                                            FileDeleteObserverUtils.unRegisterObserver(new File(this.this$0.mWatchingfile));
                                            FileDeleteObserverUtils.registerObserver(this.this$0.mContext, this.this$0.mKey, new File(this.this$0.mWatchingfile), new File(this.this$0.mBackupfile));
                                            D.getInstance(this.this$0.mContext).updatePluginDeleteStatus(this.this$0.mKey, -1);
                                        }
                                    }
                                } catch (Throwable th) {
                                    CommonMethods.handleNuLException(th);
                                }
                            }
                        }
                    });
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
            }
        }
    }
}

package com.baidu.pass.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class HttpResponseHandler extends Handler implements com.baidu.pass.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_CHARSET = "UTF-8";
    public static final int FAILURE_MESSAGE = 1;
    public static final int FINISH_MESSAGE = 3;
    public static final int START_MESSAGE = 2;
    public static final int SUCCESS_MESSAGE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean executCallbackInChildThread;
    public String mDefaultCharset;

    public void onFailure(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th, str) == null) {
        }
    }

    public void onFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public void onSuccess(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i, str) == null) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponseHandler() {
        this("UTF-8");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.executCallbackInChildThread) {
                onFinish();
            } else {
                sendMessage(obtainMessage(3));
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.executCallbackInChildThread) {
                onStart();
            } else {
                sendMessage(obtainMessage(2));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponseHandler(Looper looper) {
        this(looper, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Looper) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpResponseHandler(Looper looper, boolean z) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.executCallbackInChildThread = z;
        this.mDefaultCharset = "UTF-8";
    }

    public HttpResponseHandler(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mDefaultCharset = str;
    }

    public void a(int i, HashMap hashMap, byte[] bArr) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, hashMap, bArr) == null) {
            if (bArr == null) {
                str = null;
            } else {
                str = new String(bArr);
            }
            onSuccess(i, str, hashMap);
        }
    }

    public void b(int i, HashMap hashMap, byte[] bArr) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, hashMap, bArr) == null) {
            if (i == 200) {
                c(i, hashMap, bArr);
                return;
            }
            if (bArr == null) {
                str = null;
            } else {
                str = new String(bArr);
            }
            b(new HttpErrorException(i, str), str);
        }
    }

    public void onSuccess(int i, String str, HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048588, this, i, str, hashMap) == null) {
            onSuccess(i, str);
        }
    }

    public void a(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, th, str) == null) {
            onFailure(th, str);
        }
    }

    public void b(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, th, str) == null) {
            if (this.executCallbackInChildThread) {
                onFailure(th, str);
            } else {
                sendMessage(obtainMessage(1, new Object[]{th, str}));
            }
        }
    }

    public void c(int i, HashMap hashMap, byte[] bArr) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i, hashMap, bArr) == null) {
            if (this.executCallbackInChildThread) {
                if (bArr == null) {
                    str = null;
                } else {
                    str = new String(bArr);
                }
                onSuccess(i, str, hashMap);
                return;
            }
            sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i), hashMap, bArr}));
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, message) == null) {
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            onFinish();
                            return;
                        }
                        return;
                    }
                    onStart();
                    return;
                }
                Object[] objArr = (Object[]) message.obj;
                a((Throwable) objArr[0], (String) objArr[1]);
                return;
            }
            Object[] objArr2 = (Object[]) message.obj;
            a(((Integer) objArr2[0]).intValue(), (HashMap) objArr2[1], (byte[]) objArr2[2]);
        }
    }
}

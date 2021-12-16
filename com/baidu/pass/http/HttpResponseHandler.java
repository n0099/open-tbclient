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
/* loaded from: classes10.dex */
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponseHandler() {
        this("UTF-8");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public void c(int i2, HashMap<String, String> hashMap, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i2, hashMap, bArr) == null) {
            if (this.executCallbackInChildThread) {
                onSuccess(i2, bArr == null ? null : new String(bArr), hashMap);
            } else {
                sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i2), hashMap, bArr}));
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, message) == null) {
            int i2 = message.what;
            if (i2 == 0) {
                Object[] objArr = (Object[]) message.obj;
                a(((Integer) objArr[0]).intValue(), (HashMap) objArr[1], (byte[]) objArr[2]);
            } else if (i2 == 1) {
                Object[] objArr2 = (Object[]) message.obj;
                a((Throwable) objArr2[0], (String) objArr2[1]);
            } else if (i2 == 2) {
                onStart();
            } else if (i2 != 3) {
            } else {
                onFinish();
            }
        }
    }

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

    public void onSuccess(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, str) == null) {
        }
    }

    public void onSuccess(int i2, String str, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048588, this, i2, str, hashMap) == null) {
            onSuccess(i2, str);
        }
    }

    public HttpResponseHandler(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mDefaultCharset = str;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Looper) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void a(int i2, HashMap<String, String> hashMap, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, hashMap, bArr) == null) {
            onSuccess(i2, bArr == null ? null : new String(bArr), hashMap);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpResponseHandler(Looper looper, boolean z) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.executCallbackInChildThread = z;
        this.mDefaultCharset = "UTF-8";
    }

    public void a(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, th, str) == null) {
            onFailure(th, str);
        }
    }

    public void b(int i2, HashMap<String, String> hashMap, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i2, hashMap, bArr) == null) {
            if (i2 == 200) {
                c(i2, hashMap, bArr);
                return;
            }
            String str = bArr == null ? null : new String(bArr);
            b(new HttpErrorException(i2, str), str);
        }
    }
}

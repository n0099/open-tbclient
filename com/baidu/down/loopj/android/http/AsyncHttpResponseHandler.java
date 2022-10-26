package com.baidu.down.loopj.android.http;

import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class AsyncHttpResponseHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DOWNLOAD_MESSAGE = 4;
    public static final int FAILURE_MESSAGE = 1;
    public static final int FILELENGTH_MESSAGE = 6;
    public static final int FINISH_MESSAGE = 3;
    public static final int PAUSED_MESSAGE = 5;
    public static final int REDIRECT_MESSAGE = 7;
    public static final int START_MESSAGE = 2;
    public static final int SUCCESS_MESSAGE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mRunning;
    public boolean mSupportRange;
    public boolean mTrunked;

    public void onDownload(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    public void onFailure(Throwable th, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, th, i) == null) {
        }
    }

    public void onFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public void onSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
        }
    }

    public AsyncHttpResponseHandler() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRunning = true;
        this.mSupportRange = true;
        this.mTrunked = false;
    }

    public void sendFinishMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            sendMessage(obtainMessage(3, null));
        }
    }

    public void sendPausedMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            sendMessage(obtainMessage(5, null));
        }
    }

    public void sendStartMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            sendMessage(obtainMessage(2, null));
        }
    }

    public void handleFailureMessage(Throwable th, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, th, str, i) == null) {
            onFailure(th, str, i);
        }
    }

    public void onFailure(Throwable th, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, th, str, i) == null) {
            onFailure(th, i);
        }
    }

    public void sendFailureMessage(Throwable th, byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048588, this, th, bArr, i) == null) {
            sendMessage(obtainMessage(1, new Object[]{th, bArr, Integer.valueOf(i)}));
        }
    }

    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
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
                if (objArr[0] != null && objArr[1] != null) {
                    handleFailureMessage((Throwable) objArr[0], objArr[1].toString(), ((Integer) objArr[2]).intValue());
                    return;
                } else if (objArr[1] == null) {
                    handleFailureMessage((Throwable) objArr[0], "error", ((Integer) objArr[2]).intValue());
                    return;
                } else if (objArr[0] == null) {
                    handleFailureMessage(null, objArr[1].toString(), ((Integer) objArr[2]).intValue());
                    return;
                } else {
                    handleFailureMessage(null, "error", ((Integer) objArr[2]).intValue());
                    return;
                }
            }
            Object[] objArr2 = (Object[]) message.obj;
            handleSuccessMessage(((Integer) objArr2[0]).intValue(), (String) objArr2[2]);
        }
    }

    public void handleSuccessMessage(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
            onSuccess(i, str);
        }
    }

    public Message obtainMessage(int i, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, obj)) == null) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = obj;
            return obtain;
        }
        return (Message) invokeIL.objValue;
    }

    public void onSuccess(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, str) == null) {
            onSuccess(str);
        }
    }

    public void sendFailureMessage(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, th, str) == null) {
            sendMessage(obtainMessage(1, new Object[]{th, str}));
        }
    }

    public void sendMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, message) == null) {
            handleMessage(message);
        }
    }

    public void sendSuccessMessage(int i, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j)}) == null) {
            sendMessage(obtainMessage(0, new Object[]{new Integer(i), str, Long.valueOf(j)}));
        }
    }
}

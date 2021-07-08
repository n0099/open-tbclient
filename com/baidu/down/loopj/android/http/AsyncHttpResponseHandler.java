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

    public AsyncHttpResponseHandler() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRunning = true;
        this.mSupportRange = true;
        this.mTrunked = false;
    }

    public void handleFailureMessage(Throwable th, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, th, str, i2) == null) {
            onFailure(th, str, i2);
        }
    }

    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
            int i2 = message.what;
            if (i2 == 0) {
                Object[] objArr = (Object[]) message.obj;
                handleSuccessMessage(((Integer) objArr[0]).intValue(), (String) objArr[2]);
            } else if (i2 != 1) {
                if (i2 == 2) {
                    onStart();
                } else if (i2 != 3) {
                } else {
                    onFinish();
                }
            } else {
                Object[] objArr2 = (Object[]) message.obj;
                if (objArr2[0] != null && objArr2[1] != null) {
                    handleFailureMessage((Throwable) objArr2[0], objArr2[1].toString(), ((Integer) objArr2[2]).intValue());
                } else if (objArr2[1] == null) {
                    handleFailureMessage((Throwable) objArr2[0], "error", ((Integer) objArr2[2]).intValue());
                } else if (objArr2[0] == null) {
                    handleFailureMessage(null, objArr2[1].toString(), ((Integer) objArr2[2]).intValue());
                } else {
                    handleFailureMessage(null, "error", ((Integer) objArr2[2]).intValue());
                }
            }
        }
    }

    public void handleSuccessMessage(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
            onSuccess(i2, str);
        }
    }

    public Message obtainMessage(int i2, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, obj)) == null) {
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.obj = obj;
            return obtain;
        }
        return (Message) invokeIL.objValue;
    }

    public void onDownload(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    public void onFailure(Throwable th, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, th, i2) == null) {
        }
    }

    public void onFailure(Throwable th, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, th, str, i2) == null) {
            onFailure(th, i2);
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

    public void onSuccess(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, str) == null) {
            onSuccess(str);
        }
    }

    public void onSuccess(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
        }
    }

    public void sendFailureMessage(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, th, str) == null) {
            sendMessage(obtainMessage(1, new Object[]{th, str}));
        }
    }

    public void sendFinishMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            sendMessage(obtainMessage(3, null));
        }
    }

    public void sendMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, message) == null) {
            handleMessage(message);
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

    public void sendSuccessMessage(int i2, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j)}) == null) {
            sendMessage(obtainMessage(0, new Object[]{new Integer(i2), str, Long.valueOf(j)}));
        }
    }

    public void sendFailureMessage(Throwable th, byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048588, this, th, bArr, i2) == null) {
            sendMessage(obtainMessage(1, new Object[]{th, bArr, Integer.valueOf(i2)}));
        }
    }
}

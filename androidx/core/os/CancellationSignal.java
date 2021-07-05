package androidx.core.os;

import android.os.Build;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class CancellationSignal {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mCancelInProgress;
    public Object mCancellationSignalObj;
    public boolean mIsCanceled;
    public OnCancelListener mOnCancelListener;

    /* loaded from: classes.dex */
    public interface OnCancelListener {
        void onCancel();
    }

    public CancellationSignal() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void waitForCancelFinishedLocked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            while (this.mCancelInProgress) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.mIsCanceled) {
                    return;
                }
                this.mIsCanceled = true;
                this.mCancelInProgress = true;
                OnCancelListener onCancelListener = this.mOnCancelListener;
                Object obj = this.mCancellationSignalObj;
                if (onCancelListener != null) {
                    try {
                        onCancelListener.onCancel();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.mCancelInProgress = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null && Build.VERSION.SDK_INT >= 16) {
                    ((android.os.CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.mCancelInProgress = false;
                    notifyAll();
                }
            }
        }
    }

    @Nullable
    public Object getCancellationSignalObject() {
        InterceptResult invokeV;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (Build.VERSION.SDK_INT < 16) {
                return null;
            }
            synchronized (this) {
                if (this.mCancellationSignalObj == null) {
                    android.os.CancellationSignal cancellationSignal = new android.os.CancellationSignal();
                    this.mCancellationSignalObj = cancellationSignal;
                    if (this.mIsCanceled) {
                        cancellationSignal.cancel();
                    }
                }
                obj = this.mCancellationSignalObj;
            }
            return obj;
        }
        return invokeV.objValue;
    }

    public boolean isCanceled() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                z = this.mIsCanceled;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void setOnCancelListener(@Nullable OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onCancelListener) == null) {
            synchronized (this) {
                waitForCancelFinishedLocked();
                if (this.mOnCancelListener == onCancelListener) {
                    return;
                }
                this.mOnCancelListener = onCancelListener;
                if (this.mIsCanceled && onCancelListener != null) {
                    onCancelListener.onCancel();
                }
            }
        }
    }

    public void throwIfCanceled() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && isCanceled()) {
            throw new OperationCanceledException();
        }
    }
}

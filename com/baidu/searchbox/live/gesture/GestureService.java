package com.baidu.searchbox.live.gesture;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.api.IService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0006J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/live/gesture/GestureService;", "Lcom/baidu/live/arch/api/IService;", "Lcom/baidu/searchbox/live/gesture/OnGestureListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "addGestureListener", "(Lcom/baidu/searchbox/live/gesture/OnGestureListener;)V", "onCloseEvent", "()V", "", "delX", "currentLeftViewOffset", "onLeftMove", "(II)V", "currentRightViewOffset", "onRightMove", "removeAllRegisterListener", "removeRegisterListener", "", "mListeners", "Ljava/util/List;", "<init>", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class GestureService implements IService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<OnGestureListener> mListeners;

    public GestureService() {
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
        this.mListeners = new ArrayList();
    }

    public final void onCloseEvent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (OnGestureListener onGestureListener : this.mListeners) {
                if (onGestureListener != null) {
                    onGestureListener.onCloseEvent();
                }
            }
        }
    }

    public final void addGestureListener(OnGestureListener onGestureListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, onGestureListener) == null) && !this.mListeners.contains(onGestureListener)) {
            this.mListeners.add(onGestureListener);
        }
    }

    public final void removeAllRegisterListener(OnGestureListener onGestureListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onGestureListener) == null) {
            this.mListeners.clear();
        }
    }

    public final void removeRegisterListener(OnGestureListener onGestureListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, onGestureListener) == null) && this.mListeners.contains(onGestureListener)) {
            this.mListeners.remove(onGestureListener);
        }
    }

    public final void onLeftMove(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            for (OnGestureListener onGestureListener : this.mListeners) {
                if (onGestureListener != null) {
                    onGestureListener.onLeftMove(i, i2);
                }
            }
        }
    }

    public final void onRightMove(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            for (OnGestureListener onGestureListener : this.mListeners) {
                if (onGestureListener != null) {
                    onGestureListener.onRightMove(i, i2);
                }
            }
        }
    }
}

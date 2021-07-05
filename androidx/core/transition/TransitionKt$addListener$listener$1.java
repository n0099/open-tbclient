package androidx.core.transition;

import android.transition.Transition;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"androidx/core/transition/TransitionKt$addListener$listener$1", "android/transition/Transition$TransitionListener", "Landroid/transition/Transition;", AnimatedStateListDrawableCompat.ELEMENT_TRANSITION, "", "onTransitionCancel", "(Landroid/transition/Transition;)V", "onTransitionEnd", "onTransitionPause", "onTransitionResume", "onTransitionStart", "core-ktx_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Function1 $onCancel;
    public final /* synthetic */ Function1 $onEnd;
    public final /* synthetic */ Function1 $onPause;
    public final /* synthetic */ Function1 $onResume;
    public final /* synthetic */ Function1 $onStart;

    public TransitionKt$addListener$listener$1(Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {function1, function12, function13, function14, function15};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.$onEnd = function1;
        this.$onResume = function12;
        this.$onPause = function13;
        this.$onCancel = function14;
        this.$onStart = function15;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition transition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, transition) == null) {
            this.$onCancel.invoke(transition);
        }
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transition) == null) {
            this.$onEnd.invoke(transition);
        }
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition transition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, transition) == null) {
            this.$onPause.invoke(transition);
        }
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition transition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, transition) == null) {
            this.$onResume.invoke(transition);
        }
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, transition) == null) {
            this.$onStart.invoke(transition);
        }
    }
}

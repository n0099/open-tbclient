package androidx.core.transition;

import android.transition.Transition;
import androidx.annotation.RequiresApi;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u001aÍ\u0001\u0010\f\u001a\u00020\u000b*\u00020\u00002#\b\u0006\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b¢\u0006\u0004\b\f\u0010\r\u001a9\u0010\u000f\u001a\u00020\u000b*\u00020\u00002#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a9\u0010\u0011\u001a\u00020\u000b*\u00020\u00002#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b¢\u0006\u0004\b\u0011\u0010\u0010\u001a9\u0010\u0012\u001a\u00020\u000b*\u00020\u00002#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b¢\u0006\u0004\b\u0012\u0010\u0010\u001a9\u0010\u0013\u001a\u00020\u000b*\u00020\u00002#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b¢\u0006\u0004\b\u0013\u0010\u0010\u001a9\u0010\u0014\u001a\u00020\u000b*\u00020\u00002#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\u0087\b¢\u0006\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"Landroid/transition/Transition;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", AnimatedStateListDrawableCompat.ELEMENT_TRANSITION, "", "onEnd", "onStart", "onCancel", "onResume", MissionEvent.MESSAGE_PAUSE, "Landroid/transition/Transition$TransitionListener;", "addListener", "(Landroid/transition/Transition;Lkotlin/Function1;Lkotlin/Function1;Lkotlin/Function1;Lkotlin/Function1;Lkotlin/Function1;)Landroid/transition/Transition$TransitionListener;", "action", "doOnCancel", "(Landroid/transition/Transition;Lkotlin/Function1;)Landroid/transition/Transition$TransitionListener;", "doOnEnd", "doOnPause", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class TransitionKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @RequiresApi(19)
    public static final Transition.TransitionListener addListener(Transition transition, Function1<? super Transition, Unit> function1, Function1<? super Transition, Unit> function12, Function1<? super Transition, Unit> function13, Function1<? super Transition, Unit> function14, Function1<? super Transition, Unit> function15) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{transition, function1, function12, function13, function14, function15})) == null) {
            TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(function1, function14, function15, function13, function12);
            transition.addListener(transitionKt$addListener$listener$1);
            return transitionKt$addListener$listener$1;
        }
        return (Transition.TransitionListener) invokeCommon.objValue;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition transition, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            function1 = TransitionKt$addListener$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            function12 = TransitionKt$addListener$2.INSTANCE;
        }
        Function1 function16 = function12;
        if ((i2 & 4) != 0) {
            function13 = TransitionKt$addListener$3.INSTANCE;
        }
        Function1 function17 = function13;
        if ((i2 & 8) != 0) {
            function14 = TransitionKt$addListener$4.INSTANCE;
        }
        if ((i2 & 16) != 0) {
            function15 = TransitionKt$addListener$5.INSTANCE;
        }
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(function1, function14, function15, function17, function16);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnCancel(Transition transition, final Function1<? super Transition, Unit> function1) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, transition, function1)) == null) {
            Transition.TransitionListener transitionListener = new Transition.TransitionListener(function1) { // from class: androidx.core.transition.TransitionKt$doOnCancel$$inlined$addListener$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Function1 $onCancel;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {function1};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$onCancel = function1;
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionCancel(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, transition2) == null) {
                        this.$onCancel.invoke(transition2);
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionEnd(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transition2) == null) {
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionPause(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, transition2) == null) {
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionResume(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, transition2) == null) {
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionStart(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, transition2) == null) {
                    }
                }
            };
            transition.addListener(transitionListener);
            return transitionListener;
        }
        return (Transition.TransitionListener) invokeLL.objValue;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnEnd(Transition transition, final Function1<? super Transition, Unit> function1) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, transition, function1)) == null) {
            Transition.TransitionListener transitionListener = new Transition.TransitionListener(function1) { // from class: androidx.core.transition.TransitionKt$doOnEnd$$inlined$addListener$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Function1 $onEnd;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {function1};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$onEnd = function1;
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionCancel(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, transition2) == null) {
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionEnd(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transition2) == null) {
                        this.$onEnd.invoke(transition2);
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionPause(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, transition2) == null) {
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionResume(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, transition2) == null) {
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionStart(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, transition2) == null) {
                    }
                }
            };
            transition.addListener(transitionListener);
            return transitionListener;
        }
        return (Transition.TransitionListener) invokeLL.objValue;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnPause(Transition transition, final Function1<? super Transition, Unit> function1) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, transition, function1)) == null) {
            Transition.TransitionListener transitionListener = new Transition.TransitionListener(function1) { // from class: androidx.core.transition.TransitionKt$doOnPause$$inlined$addListener$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Function1 $onPause;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {function1};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$onPause = function1;
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionCancel(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, transition2) == null) {
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionEnd(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transition2) == null) {
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionPause(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, transition2) == null) {
                        this.$onPause.invoke(transition2);
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionResume(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, transition2) == null) {
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionStart(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, transition2) == null) {
                    }
                }
            };
            transition.addListener(transitionListener);
            return transitionListener;
        }
        return (Transition.TransitionListener) invokeLL.objValue;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnResume(Transition transition, final Function1<? super Transition, Unit> function1) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, transition, function1)) == null) {
            Transition.TransitionListener transitionListener = new Transition.TransitionListener(function1) { // from class: androidx.core.transition.TransitionKt$doOnResume$$inlined$addListener$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Function1 $onResume;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {function1};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$onResume = function1;
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionCancel(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, transition2) == null) {
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionEnd(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transition2) == null) {
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionPause(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, transition2) == null) {
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionResume(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, transition2) == null) {
                        this.$onResume.invoke(transition2);
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionStart(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, transition2) == null) {
                    }
                }
            };
            transition.addListener(transitionListener);
            return transitionListener;
        }
        return (Transition.TransitionListener) invokeLL.objValue;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnStart(Transition transition, final Function1<? super Transition, Unit> function1) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, transition, function1)) == null) {
            Transition.TransitionListener transitionListener = new Transition.TransitionListener(function1) { // from class: androidx.core.transition.TransitionKt$doOnStart$$inlined$addListener$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Function1 $onStart;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {function1};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$onStart = function1;
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionCancel(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, transition2) == null) {
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionEnd(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transition2) == null) {
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionPause(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, transition2) == null) {
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionResume(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, transition2) == null) {
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionStart(Transition transition2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, transition2) == null) {
                        this.$onStart.invoke(transition2);
                    }
                }
            };
            transition.addListener(transitionListener);
            return transitionListener;
        }
        return (Transition.TransitionListener) invokeLL.objValue;
    }
}

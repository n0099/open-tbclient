package com.baidu.searchbox.player.view;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.player.interfaces.IKernelGestureDetector;
import com.baidu.searchbox.player.utils.BdGestureHelper;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 52\u00020\u00012\u00020\u0002:\u0003567B\u000f\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b3\u00104J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001d\u0010-\u001a\u00020\u00038B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010/\u001a\u00020.8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00068"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector;", "Lcom/baidu/searchbox/player/interfaces/IKernelGestureDetector;", "android/view/ScaleGestureDetector$SimpleOnScaleGestureListener", "Landroid/view/ScaleGestureDetector;", "detector", "", "computeScale", "(Landroid/view/ScaleGestureDetector;)F", "getMaxScale", "()F", "getMinScale", "", "onScale", "(Landroid/view/ScaleGestureDetector;)Z", "onScaleBegin", "", "onScaleEnd", "(Landroid/view/ScaleGestureDetector;)V", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "newPivotX", "newPivotY", "setPivot", "(FF)V", AnimationProperty.SCALE, "setScale", "(F)V", "isScaleDetected", "Z", "()Z", "setScaleDetected", "(Z)V", "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;", "listener", "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;", "getListener", "()Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;", "setListener", "(Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;)V", "scaleGestureDetector$delegate", "Lkotlin/Lazy;", "getScaleGestureDetector", "()Landroid/view/ScaleGestureDetector;", "scaleGestureDetector", "Landroid/view/View;", NativeConstants.TYPE_VIEW, "Landroid/view/View;", "getView", "()Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "Companion", "OnScaleGestureListener", "SimpleOnScaleGestureListener", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public class BdVideoScaleGestureDetector extends ScaleGestureDetector.SimpleOnScaleGestureListener implements IKernelGestureDetector {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final float SCALE_MAX = 3.0f;
    public static final float SCALE_MIN = 0.3f;
    public static final float SCALE_NORMAL = 1.0f;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isScaleDetected;
    public OnScaleGestureListener listener;
    public final Lazy scaleGestureDetector$delegate;

    /* renamed from: view  reason: collision with root package name */
    public final View f1032view;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$Companion;", "", "SCALE_MAX", "F", "SCALE_MIN", "SCALE_NORMAL", "<init>", "()V", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;", "Lkotlin/Any;", "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector;", "detector", "", "onScaleBegin", "(Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector;)V", "onScaleEnd", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface OnScaleGestureListener {
        void onScaleBegin(BdVideoScaleGestureDetector bdVideoScaleGestureDetector);

        void onScaleEnd(BdVideoScaleGestureDetector bdVideoScaleGestureDetector);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$SimpleOnScaleGestureListener;", "com/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener", "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector;", "detector", "", "onScaleBegin", "(Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector;)V", "onScaleEnd", "<init>", "()V", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static class SimpleOnScaleGestureListener implements OnScaleGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public SimpleOnScaleGestureListener() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.player.view.BdVideoScaleGestureDetector.OnScaleGestureListener
        public void onScaleBegin(BdVideoScaleGestureDetector detector) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, detector) == null) {
                Intrinsics.checkNotNullParameter(detector, "detector");
            }
        }

        @Override // com.baidu.searchbox.player.view.BdVideoScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(BdVideoScaleGestureDetector detector) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, detector) == null) {
                Intrinsics.checkNotNullParameter(detector, "detector");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(308888595, "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(308888595, "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    public BdVideoScaleGestureDetector(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(view2, "view");
        this.f1032view = view2;
        this.scaleGestureDetector$delegate = LazyKt__LazyJVMKt.lazy(new BdVideoScaleGestureDetector$scaleGestureDetector$2(this));
    }

    private final ScaleGestureDetector getScaleGestureDetector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? (ScaleGestureDetector) this.scaleGestureDetector$delegate.getValue() : (ScaleGestureDetector) invokeV.objValue;
    }

    public float computeScale(ScaleGestureDetector detector) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, detector)) == null) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            float scaleFactor = detector.getScaleFactor();
            float scaleX = this.f1032view.getScaleX();
            if (scaleFactor < 1.0f && scaleX > getMinScale()) {
                float f = scaleX * scaleFactor;
                return f < getMinScale() ? getMinScale() : f;
            } else if (scaleFactor <= 1.0f || scaleX >= getMaxScale()) {
                return scaleX;
            } else {
                float f2 = scaleX * scaleFactor;
                return f2 > getMaxScale() ? getMaxScale() : f2;
            }
        }
        return invokeL.floatValue;
    }

    public final OnScaleGestureListener getListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.listener : (OnScaleGestureListener) invokeV.objValue;
    }

    public float getMaxScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 3.0f;
        }
        return invokeV.floatValue;
    }

    public float getMinScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0.3f;
        }
        return invokeV.floatValue;
    }

    public final View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f1032view : (View) invokeV.objValue;
    }

    public final boolean isScaleDetected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.isScaleDetected : invokeV.booleanValue;
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector detector) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, detector)) == null) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            BdVideoLog.d(BdGestureHelper.GESTURE_TAG, "onScale");
            setScale(computeScale(detector));
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, detector)) == null) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            BdVideoLog.d(BdGestureHelper.GESTURE_TAG, "onScaleBegin");
            this.isScaleDetected = true;
            setPivot(detector.getFocusX(), detector.getFocusY());
            OnScaleGestureListener onScaleGestureListener = this.listener;
            if (onScaleGestureListener != null) {
                onScaleGestureListener.onScaleBegin(this);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, scaleGestureDetector) == null) {
            this.isScaleDetected = false;
            OnScaleGestureListener onScaleGestureListener = this.listener;
            if (onScaleGestureListener != null) {
                onScaleGestureListener.onScaleEnd(this);
            }
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.IKernelGestureDetector
    public boolean onTouchEvent(MotionEvent event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, event)) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            return getScaleGestureDetector().onTouchEvent(event);
        }
        return invokeL.booleanValue;
    }

    public final void setListener(OnScaleGestureListener onScaleGestureListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onScaleGestureListener) == null) {
            this.listener = onScaleGestureListener;
        }
    }

    public void setPivot(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            View view2 = this.f1032view;
            float f3 = 1;
            BdGestureHelper.fixScaleTranslate(view2, view2.getTranslationX() + ((this.f1032view.getPivotX() - f) * (f3 - this.f1032view.getScaleX())), this.f1032view.getTranslationY() + ((this.f1032view.getPivotY() - f2) * (f3 - this.f1032view.getScaleY())));
            view2.setPivotX(f);
            view2.setPivotY(f2);
        }
    }

    public final void setScale(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f) == null) {
            this.f1032view.setScaleX(f);
            this.f1032view.setScaleY(f);
        }
    }

    public final void setScaleDetected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.isScaleDetected = z;
        }
    }
}

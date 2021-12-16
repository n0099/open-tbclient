package com.baidu.searchbox.player.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.interfaces.IKernelGestureDetector;
import com.baidu.searchbox.player.utils.BdGestureHelper;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.player.view.BdVideoMoveGestureDetector;
import com.baidu.searchbox.player.view.BdVideoRotateGestureDetector;
import com.baidu.searchbox.player.view.BdVideoScaleGestureDetector;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0001HB\u000f\u0012\u0006\u0010B\u001a\u00020A¢\u0006\u0004\bF\u0010GJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0014J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0006J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0016\u0010!\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u001d\u0010%\u001a\u00020\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\tR$\u0010'\u001a\u0004\u0018\u00010&8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001d\u0010/\u001a\u00020\n8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010#\u001a\u0004\b.\u0010\fR$\u00101\u001a\u0004\u0018\u0001008\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001d\u00109\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010#\u001a\u0004\b8\u0010\u000fR$\u0010;\u001a\u0004\u0018\u00010:8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0019\u0010B\u001a\u00020A8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E¨\u0006I"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoMultipleGesturesDetector;", "Lcom/baidu/searchbox/player/interfaces/IKernelGestureDetector;", "", "flags", "", "clearFlags", "(I)V", "Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector;", "generateMoveGestureDetector", "()Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector;", "Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;", "generateRotateGestureDetector", "()Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;", "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector;", "generateScaleGestureDetector", "()Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector;", "Landroid/view/MotionEvent;", "event", "", "onAllowTouchEvent", "(Landroid/view/MotionEvent;)Z", "onGestureTouchEvent", "(Landroid/view/MotionEvent;)V", "onTouchEvent", "setFlags", "switchNormal", "()V", "switchNormalWithAnimation", "gestureFlags", "I", "isMoveDetected", "Z", "isRotateDetected", "isScaleDetected", "moveGestureDetector$delegate", "Lkotlin/Lazy;", "getMoveGestureDetector", "moveGestureDetector", "Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$SimpleOnMoveGestureListener;", "moveGestureListener", "Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$SimpleOnMoveGestureListener;", "getMoveGestureListener", "()Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$SimpleOnMoveGestureListener;", "setMoveGestureListener", "(Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$SimpleOnMoveGestureListener;)V", "rotateGestureDetector$delegate", "getRotateGestureDetector", "rotateGestureDetector", "Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$SimpleOnRotationGestureListener;", "rotateGestureListener", "Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$SimpleOnRotationGestureListener;", "getRotateGestureListener", "()Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$SimpleOnRotationGestureListener;", "setRotateGestureListener", "(Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector$SimpleOnRotationGestureListener;)V", "scaleGestureDetector$delegate", "getScaleGestureDetector", "scaleGestureDetector", "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;", "scaleGestureListener", "Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;", "getScaleGestureListener", "()Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;", "setScaleGestureListener", "(Lcom/baidu/searchbox/player/view/BdVideoScaleGestureDetector$OnScaleGestureListener;)V", "Landroid/view/View;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "RotateGestureDetectorListener", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public class BdVideoMultipleGesturesDetector implements IKernelGestureDetector {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int gestureFlags;
    public boolean isMoveDetected;
    public boolean isRotateDetected;
    public boolean isScaleDetected;
    public final Lazy moveGestureDetector$delegate;
    public BdVideoMoveGestureDetector.SimpleOnMoveGestureListener moveGestureListener;
    public final Lazy rotateGestureDetector$delegate;
    public BdVideoRotateGestureDetector.SimpleOnRotationGestureListener rotateGestureListener;
    public final Lazy scaleGestureDetector$delegate;
    public BdVideoScaleGestureDetector.OnScaleGestureListener scaleGestureListener;
    public final View view;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0096\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoMultipleGesturesDetector$RotateGestureDetectorListener;", "com/baidu/searchbox/player/view/BdVideoRotateGestureDetector$SimpleOnRotationGestureListener", "Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;", "detector", "", "onRotate", "(Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;)Z", "", "onRotationEnd", "(Lcom/baidu/searchbox/player/view/BdVideoRotateGestureDetector;)V", "Landroid/view/View;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "<init>", "(Lcom/baidu/searchbox/player/view/BdVideoMultipleGesturesDetector;Landroid/view/View;)V", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes10.dex */
    public class RotateGestureDetectorListener extends BdVideoRotateGestureDetector.SimpleOnRotationGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdVideoMultipleGesturesDetector this$0;
        public final View view;

        public RotateGestureDetectorListener(BdVideoMultipleGesturesDetector bdVideoMultipleGesturesDetector, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdVideoMultipleGesturesDetector, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(view, "view");
            this.this$0 = bdVideoMultipleGesturesDetector;
            this.view = view;
        }

        public final View getView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.view : (View) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.player.view.BdVideoRotateGestureDetector.SimpleOnRotationGestureListener, com.baidu.searchbox.player.view.BdVideoRotateGestureDetector.OnRotationGestureListener
        public boolean onRotate(BdVideoRotateGestureDetector detector) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, detector)) == null) {
                Intrinsics.checkNotNullParameter(detector, "detector");
                float rotation = this.view.getRotation() + detector.getRotationDelta();
                if (rotation >= 360.0f) {
                    rotation -= 360.0f;
                } else if (rotation < 0) {
                    rotation += 360.0f;
                }
                View view = this.view;
                view.setPivotX(view.getWidth() * 0.5f);
                View view2 = this.view;
                view2.setPivotY(view2.getHeight() * 0.5f);
                this.view.setRotation(rotation);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.searchbox.player.view.BdVideoRotateGestureDetector.SimpleOnRotationGestureListener, com.baidu.searchbox.player.view.BdVideoRotateGestureDetector.OnRotationGestureListener
        public void onRotationEnd(BdVideoRotateGestureDetector detector) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, detector) == null) {
                Intrinsics.checkNotNullParameter(detector, "detector");
                int abs = (int) (Math.abs(this.view.getRotation() + 45) / 90);
                BdVideoLog.d(BdGestureHelper.GESTURE_TAG, "当前对应的旋转值: " + abs + ", 旋转的角度=" + this.view.getRotation());
                View view = this.view;
                ObjectAnimator.ofFloat(view, View.ROTATION, view.getRotation(), (float) (abs * 90)).setDuration(300L).start();
            }
        }
    }

    public BdVideoMultipleGesturesDetector(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.gestureFlags = 7;
        this.scaleGestureDetector$delegate = LazyKt__LazyJVMKt.lazy(new BdVideoMultipleGesturesDetector$scaleGestureDetector$2(this));
        this.moveGestureDetector$delegate = LazyKt__LazyJVMKt.lazy(new BdVideoMultipleGesturesDetector$moveGestureDetector$2(this));
        this.rotateGestureDetector$delegate = LazyKt__LazyJVMKt.lazy(new BdVideoMultipleGesturesDetector$rotateGestureDetector$2(this));
    }

    private final BdVideoMoveGestureDetector getMoveGestureDetector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? (BdVideoMoveGestureDetector) this.moveGestureDetector$delegate.getValue() : (BdVideoMoveGestureDetector) invokeV.objValue;
    }

    private final BdVideoRotateGestureDetector getRotateGestureDetector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? (BdVideoRotateGestureDetector) this.rotateGestureDetector$delegate.getValue() : (BdVideoRotateGestureDetector) invokeV.objValue;
    }

    private final BdVideoScaleGestureDetector getScaleGestureDetector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? (BdVideoScaleGestureDetector) this.scaleGestureDetector$delegate.getValue() : (BdVideoScaleGestureDetector) invokeV.objValue;
    }

    public final void clearFlags(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.gestureFlags = (~i2) & this.gestureFlags;
        }
    }

    public BdVideoMoveGestureDetector generateMoveGestureDetector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new BdVideoMoveGestureDetector(this.view, getMoveGestureListener()) : (BdVideoMoveGestureDetector) invokeV.objValue;
    }

    public BdVideoRotateGestureDetector generateRotateGestureDetector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getRotateGestureListener() == null) {
                setRotateGestureListener(new RotateGestureDetectorListener(this, this.view));
            }
            BdVideoRotateGestureDetector.SimpleOnRotationGestureListener rotateGestureListener = getRotateGestureListener();
            Intrinsics.checkNotNull(rotateGestureListener);
            return new BdVideoRotateGestureDetector(rotateGestureListener);
        }
        return (BdVideoRotateGestureDetector) invokeV.objValue;
    }

    public BdVideoScaleGestureDetector generateScaleGestureDetector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BdVideoScaleGestureDetector bdVideoScaleGestureDetector = new BdVideoScaleGestureDetector(this.view);
            bdVideoScaleGestureDetector.setListener(getScaleGestureListener());
            return bdVideoScaleGestureDetector;
        }
        return (BdVideoScaleGestureDetector) invokeV.objValue;
    }

    public BdVideoMoveGestureDetector.SimpleOnMoveGestureListener getMoveGestureListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.moveGestureListener : (BdVideoMoveGestureDetector.SimpleOnMoveGestureListener) invokeV.objValue;
    }

    public BdVideoRotateGestureDetector.SimpleOnRotationGestureListener getRotateGestureListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.rotateGestureListener : (BdVideoRotateGestureDetector.SimpleOnRotationGestureListener) invokeV.objValue;
    }

    public BdVideoScaleGestureDetector.OnScaleGestureListener getScaleGestureListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.scaleGestureListener : (BdVideoScaleGestureDetector.OnScaleGestureListener) invokeV.objValue;
    }

    public final View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.view : (View) invokeV.objValue;
    }

    public boolean onAllowTouchEvent(MotionEvent event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, event)) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            return true;
        }
        return invokeL.booleanValue;
    }

    public void onGestureTouchEvent(MotionEvent event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.IKernelGestureDetector
    public boolean onTouchEvent(MotionEvent event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, event)) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!onAllowTouchEvent(event) || event.getPointerCount() < 2) {
                return false;
            }
            this.view.getParent().requestDisallowInterceptTouchEvent(true);
            if ((this.gestureFlags & 4) == 4) {
                getRotateGestureDetector().onTouchEvent(event);
                this.isRotateDetected = getRotateGestureDetector().isRotateDetected();
            }
            if ((this.gestureFlags & 1) == 1) {
                getScaleGestureDetector().onTouchEvent(event);
                this.isScaleDetected = getScaleGestureDetector().isScaleDetected();
            }
            if ((this.gestureFlags & 2) == 2) {
                getMoveGestureDetector().onTouchEvent(event);
                this.isMoveDetected = getMoveGestureDetector().isMoveDetected();
            }
            onGestureTouchEvent(event);
            return this.isRotateDetected || this.isScaleDetected || this.isMoveDetected;
        }
        return invokeL.booleanValue;
    }

    public final void setFlags(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.gestureFlags = i2;
        }
    }

    public void setMoveGestureListener(BdVideoMoveGestureDetector.SimpleOnMoveGestureListener simpleOnMoveGestureListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, simpleOnMoveGestureListener) == null) {
            this.moveGestureListener = simpleOnMoveGestureListener;
        }
    }

    public void setRotateGestureListener(BdVideoRotateGestureDetector.SimpleOnRotationGestureListener simpleOnRotationGestureListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, simpleOnRotationGestureListener) == null) {
            this.rotateGestureListener = simpleOnRotationGestureListener;
        }
    }

    public void setScaleGestureListener(BdVideoScaleGestureDetector.OnScaleGestureListener onScaleGestureListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onScaleGestureListener) == null) {
            this.scaleGestureListener = onScaleGestureListener;
        }
    }

    public void switchNormal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            View view = this.view;
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
        }
    }

    public void switchNormalWithAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this.view, PropertyValuesHolder.ofFloat(View.SCALE_X, this.view.getScaleX(), 1.0f), PropertyValuesHolder.ofFloat(View.SCALE_Y, this.view.getScaleY(), 1.0f), PropertyValuesHolder.ofFloat(View.ROTATION, this.view.getRotation(), this.view.getRotation() >= ((float) 180) ? 360.0f : 0.0f), PropertyValuesHolder.ofFloat(View.TRANSLATION_X, this.view.getTranslationX(), 0.0f), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, this.view.getTranslationY(), 0.0f)).setDuration(300L);
            Intrinsics.checkNotNullExpressionValue(duration, "ObjectAnimator.ofPropert…ation(ANIMATION_DURATION)");
            animatorSet.play(duration);
            animatorSet.start();
        }
    }
}

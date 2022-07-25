package com.baidu.searchbox.player.view;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.player.interfaces.IKernelGestureDetector;
import com.baidu.searchbox.player.utils.BdGestureHelper;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002()B\u001b\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b&\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\"\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector;", "Lcom/baidu/searchbox/player/interfaces/IKernelGestureDetector;", "", "cancelMove", "()V", "", "minPointerCount", "()I", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "offsetX", "offsetY", "setTranslate", "(FF)V", "isMoveDetected", "Z", "()Z", "setMoveDetected", "(Z)V", "lastPointerCount", "I", "lastX", "F", "lastY", "Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$OnMoveGestureListener;", "listener", "Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$OnMoveGestureListener;", "getListener", "()Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$OnMoveGestureListener;", "Landroid/view/View;", NativeConstants.TYPE_VIEW, "Landroid/view/View;", "getView", "()Landroid/view/View;", "<init>", "(Landroid/view/View;Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$OnMoveGestureListener;)V", "OnMoveGestureListener", "SimpleOnMoveGestureListener", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class BdVideoMoveGestureDetector implements IKernelGestureDetector {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isMoveDetected;
    public int lastPointerCount;
    public float lastX;
    public float lastY;
    public final OnMoveGestureListener listener;

    /* renamed from: view  reason: collision with root package name */
    public final View f1036view;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$OnMoveGestureListener;", "Lkotlin/Any;", "Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector;", "detector", "", "onMoveBegin", "(Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector;)V", "onMoveEnd", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface OnMoveGestureListener {
        void onMoveBegin(BdVideoMoveGestureDetector bdVideoMoveGestureDetector);

        void onMoveEnd(BdVideoMoveGestureDetector bdVideoMoveGestureDetector);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector$SimpleOnMoveGestureListener;", "com/baidu/searchbox/player/view/BdVideoMoveGestureDetector$OnMoveGestureListener", "Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector;", "detector", "", "onMoveBegin", "(Lcom/baidu/searchbox/player/view/BdVideoMoveGestureDetector;)V", "onMoveEnd", "<init>", "()V", "framework_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static class SimpleOnMoveGestureListener implements OnMoveGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public SimpleOnMoveGestureListener() {
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

        @Override // com.baidu.searchbox.player.view.BdVideoMoveGestureDetector.OnMoveGestureListener
        public void onMoveBegin(BdVideoMoveGestureDetector detector) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, detector) == null) {
                Intrinsics.checkNotNullParameter(detector, "detector");
            }
        }

        @Override // com.baidu.searchbox.player.view.BdVideoMoveGestureDetector.OnMoveGestureListener
        public void onMoveEnd(BdVideoMoveGestureDetector detector) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, detector) == null) {
                Intrinsics.checkNotNullParameter(detector, "detector");
            }
        }
    }

    public BdVideoMoveGestureDetector(View view2, OnMoveGestureListener onMoveGestureListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, onMoveGestureListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(view2, "view");
        this.f1036view = view2;
        this.listener = onMoveGestureListener;
    }

    private final void cancelMove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.lastPointerCount = 0;
            this.isMoveDetected = false;
            OnMoveGestureListener onMoveGestureListener = this.listener;
            if (onMoveGestureListener != null) {
                onMoveGestureListener.onMoveEnd(this);
            }
            BdVideoLog.d(BdGestureHelper.GESTURE_TAG, "BdVideoMoveGestureDetector->滑动取消");
        }
    }

    public final OnMoveGestureListener getListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.listener : (OnMoveGestureListener) invokeV.objValue;
    }

    public final View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1036view : (View) invokeV.objValue;
    }

    public final boolean isMoveDetected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.isMoveDetected : invokeV.booleanValue;
    }

    public int minPointerCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006a, code lost:
        if (r0 != 6) goto L26;
     */
    @Override // com.baidu.searchbox.player.interfaces.IKernelGestureDetector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, event)) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            BdVideoLog.d(BdGestureHelper.GESTURE_TAG, "BdVideoMoveGestureDetector->event: " + event + ".action");
            int pointerCount = event.getPointerCount();
            if (pointerCount < (minPointerCount() < 2 ? 2 : minPointerCount())) {
                this.lastPointerCount = 0;
                return false;
            }
            float f = 0.0f;
            float f2 = 0.0f;
            for (int i = 0; i < pointerCount; i++) {
                f += event.getX(i);
                f2 += event.getY(i);
            }
            float f3 = pointerCount;
            float f4 = f / f3;
            float f5 = f2 / f3;
            if (pointerCount != this.lastPointerCount) {
                this.lastX = f4;
                this.lastY = f5;
            }
            this.lastPointerCount = pointerCount;
            int actionMasked = event.getActionMasked();
            if (actionMasked != 0 && actionMasked != 1) {
                if (actionMasked == 2) {
                    float f6 = f4 - this.lastX;
                    float f7 = f5 - this.lastY;
                    BdVideoLog.d(BdGestureHelper.GESTURE_TAG, "BdVideoMoveGestureDetector->dx=" + f6 + ", y=" + f7);
                    if (!this.isMoveDetected) {
                        boolean z = Math.abs(event.getX(1) - event.getX(0)) > ((float) BdGestureHelper.touchSlop(this.f1036view)) || Math.abs(event.getY(1) - event.getY(0)) > ((float) BdGestureHelper.touchSlop(this.f1036view));
                        this.isMoveDetected = z;
                        if (z) {
                            return false;
                        }
                    }
                    boolean actionMoveEnabled = BdGestureHelper.actionMoveEnabled(this.f1036view, f6, f7);
                    this.isMoveDetected = actionMoveEnabled;
                    if (actionMoveEnabled && f6 != 0.0f && f7 != 0.0f) {
                        OnMoveGestureListener onMoveGestureListener = this.listener;
                        if (onMoveGestureListener != null) {
                            onMoveGestureListener.onMoveBegin(this);
                        }
                        BdVideoLog.d(BdGestureHelper.GESTURE_TAG, "BdVideoMoveGestureDetector->触发滑动");
                        setTranslate(f6, f7);
                        this.lastX = f4;
                        this.lastY = f5;
                    }
                } else if (actionMasked != 3) {
                }
                return true;
            }
            cancelMove();
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void setMoveDetected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.isMoveDetected = z;
        }
    }

    public void setTranslate(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            if (this.f1036view.getScaleX() <= 1) {
                View view2 = this.f1036view;
                view2.setTranslationX(view2.getTranslationX() + f);
                View view3 = this.f1036view;
                view3.setTranslationY(view3.getTranslationY() + f2);
                return;
            }
            PointF scaleMovePointF$default = BdGestureHelper.getScaleMovePointF$default(this.f1036view, f, f2, false, 4, null);
            if (scaleMovePointF$default.x != 0.0f) {
                View view4 = this.f1036view;
                view4.setTranslationX(view4.getTranslationX() + scaleMovePointF$default.x);
            }
            if (scaleMovePointF$default.y != 0.0f) {
                View view5 = this.f1036view;
                view5.setTranslationY(view5.getTranslationY() + scaleMovePointF$default.y);
            }
        }
    }

    public /* synthetic */ BdVideoMoveGestureDetector(View view2, OnMoveGestureListener onMoveGestureListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view2, (i & 2) != 0 ? null : onMoveGestureListener);
    }
}

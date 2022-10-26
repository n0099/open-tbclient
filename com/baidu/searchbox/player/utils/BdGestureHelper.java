package com.baidu.searchbox.player.utils;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewConfiguration;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u001a!\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\u000b\u001a\u00020\n*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a+\u0010\u0011\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0011\u0010\u0013\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0011\u0010\u0016\u001a\u00020\u0015*\u00020\u0000¢\u0006\u0004\b\u0016\u0010\u0017\"\u0016\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\"\u0016\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d\"\u0016\u0010\u001e\u001a\u00020\u00158\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f\"\u0016\u0010 \u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010!\"\u0016\u0010\"\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010!\"\u0016\u0010#\u001a\u00020\u00158\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\u001f\"\u0016\u0010$\u001a\u00020\u00158\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\u001f\"\u0016\u0010%\u001a\u00020\u00158\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\u001f\"\u0016\u0010&\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010!\"\u0016\u0010'\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010!\"\u0016\u0010(\u001a\u00020\u00158\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010\u001f¨\u0006)"}, d2 = {"Landroid/view/View;", "", "dx", "dy", "", "actionMoveEnabled", "(Landroid/view/View;FF)Z", "", "fixScaleTranslate", "(Landroid/view/View;FF)V", "Landroid/graphics/RectF;", "getRelativeToParentOffset", "(Landroid/view/View;)Landroid/graphics/RectF;", "offsetX", "offsetY", "isRestore", "Landroid/graphics/PointF;", "getScaleMovePointF", "(Landroid/view/View;FFZ)Landroid/graphics/PointF;", "isVideoViewMatrixChanged", "(Landroid/view/View;)Z", "", "touchSlop", "(Landroid/view/View;)I", "", "ANIMATION_DURATION", "J", "", "GESTURE_TAG", "Ljava/lang/String;", "MIN_POINTER_COUNT", "I", "MOVE_SLOP", "F", "OFFSET_BORDER", "ROTATION_180", "ROTATION_45", "ROTATION_90", "ROTATION_MAX", "ROTATION_SLOP", "TWO_POINTER", "framework_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class BdGestureHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long ANIMATION_DURATION = 300;
    public static final String GESTURE_TAG = "BdGestureHelper";
    public static final int MIN_POINTER_COUNT = 2;
    public static final float MOVE_SLOP = 50.0f;
    public static final float OFFSET_BORDER = 0.0f;
    public static final int ROTATION_180 = 180;
    public static final int ROTATION_45 = 45;
    public static final int ROTATION_90 = 90;
    public static final float ROTATION_MAX = 360.0f;
    public static final float ROTATION_SLOP = 5.0f;
    public static final int TWO_POINTER = 2;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean actionMoveEnabled(View actionMoveEnabled, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{actionMoveEnabled, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            Intrinsics.checkNotNullParameter(actionMoveEnabled, "$this$actionMoveEnabled");
            if (((float) Math.sqrt((f * f) + (f2 * f2))) >= touchSlop(actionMoveEnabled)) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static final void fixScaleTranslate(View fixScaleTranslate, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{fixScaleTranslate, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            Intrinsics.checkNotNullParameter(fixScaleTranslate, "$this$fixScaleTranslate");
            if (fixScaleTranslate.getScaleX() > 1) {
                if (Math.abs(f) > 50.0f) {
                    f = 50.0f;
                }
                if (Math.abs(f2) > 50.0f) {
                    f2 = 50.0f;
                }
            }
            fixScaleTranslate.setTranslationX(f);
            fixScaleTranslate.setTranslationY(f2);
        }
    }

    public static final RectF getRelativeToParentOffset(View getRelativeToParentOffset) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, getRelativeToParentOffset)) == null) {
            Intrinsics.checkNotNullParameter(getRelativeToParentOffset, "$this$getRelativeToParentOffset");
            float translationX = getRelativeToParentOffset.getTranslationX() - getRelativeToParentOffset.getWidth();
            float translationY = getRelativeToParentOffset.getTranslationY() - getRelativeToParentOffset.getHeight();
            float width = ((getRelativeToParentOffset.getWidth() * getRelativeToParentOffset.getScaleX()) - getRelativeToParentOffset.getWidth()) + translationX;
            float height = ((getRelativeToParentOffset.getHeight() * getRelativeToParentOffset.getScaleY()) - getRelativeToParentOffset.getHeight()) + translationY;
            BdVideoLog.d(GESTURE_TAG, "左偏移=" + translationX + ", 右偏移=" + width + ", 上偏移=" + translationY + ", 下偏移=" + height);
            return new RectF(translationX, translationY, width, height);
        }
        return (RectF) invokeL.objValue;
    }

    public static final PointF getScaleMovePointF(View getScaleMovePointF, float f, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{getScaleMovePointF, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            Intrinsics.checkNotNullParameter(getScaleMovePointF, "$this$getScaleMovePointF");
            if (!z) {
                RectF relativeToParentOffset = getRelativeToParentOffset(getScaleMovePointF);
                float f3 = 0;
                if (f > f3) {
                    float f4 = relativeToParentOffset.left;
                    if (f4 > 0.0f || (f4 < 0.0f && f4 + f > 0.0f)) {
                        f = 0.0f - f4;
                    }
                } else if (f < f3) {
                    float f5 = relativeToParentOffset.right;
                    if (f5 < -0.0f || (f5 > -0.0f && f5 + f < -0.0f)) {
                        f = (-0.0f) - f5;
                    }
                }
                if (f2 > f3) {
                    float f6 = relativeToParentOffset.top;
                    if (f6 > 0.0f || (f6 < 0.0f && f6 + f2 > 0.0f)) {
                        f2 = 0.0f - f6;
                    }
                } else if (f2 < f3) {
                    float f7 = relativeToParentOffset.bottom;
                    if (f7 < -0.0f || (f7 > -0.0f && f7 + f2 < -0.0f)) {
                        f2 = (-0.0f) - f7;
                    }
                }
            }
            BdVideoLog.d(GESTURE_TAG, "x位移=" + f + ", y位移=" + f2);
            if (Math.abs(f) >= 50.0f) {
                f = 50.0f;
            }
            if (Math.abs(f2) >= 50.0f) {
                f2 = 50.0f;
            }
            return new PointF(f, f2);
        }
        return (PointF) invokeCommon.objValue;
    }

    public static /* synthetic */ PointF getScaleMovePointF$default(View view2, float f, float f2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return getScaleMovePointF(view2, f, f2, z);
    }

    public static final boolean isVideoViewMatrixChanged(View isVideoViewMatrixChanged) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, isVideoViewMatrixChanged)) == null) {
            Intrinsics.checkNotNullParameter(isVideoViewMatrixChanged, "$this$isVideoViewMatrixChanged");
            if (isVideoViewMatrixChanged.getScaleX() == 1.0f && isVideoViewMatrixChanged.getScaleY() == 1.0f && (isVideoViewMatrixChanged.getRotation() == 0.0f || isVideoViewMatrixChanged.getRotation() == 360.0f)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static final int touchSlop(View touchSlop) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, touchSlop)) == null) {
            Intrinsics.checkNotNullParameter(touchSlop, "$this$touchSlop");
            ViewConfiguration viewConfiguration = ViewConfiguration.get(touchSlop.getContext());
            Intrinsics.checkNotNullExpressionValue(viewConfiguration, "ViewConfiguration.get(context)");
            return viewConfiguration.getScaledTouchSlop();
        }
        return invokeL.intValue;
    }
}

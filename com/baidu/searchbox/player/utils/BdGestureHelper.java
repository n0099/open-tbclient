package com.baidu.searchbox.player.utils;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewConfiguration;
import com.baidu.searchbox.account.contants.LoginConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001a\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007\u001a\u001a\u0010\u0014\u001a\u00020\u0015*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007\u001a\n\u0010\u0016\u001a\u00020\u0017*\u00020\u0011\u001a$\u0010\u0018\u001a\u00020\u0019*\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u0010\u001a\n\u0010\u001d\u001a\u00020\u0010*\u00020\u0011\u001a\n\u0010\u001e\u001a\u00020\u0005*\u00020\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"ANIMATION_DURATION", "", "GESTURE_TAG", "", "MIN_POINTER_COUNT", "", "MOVE_SLOP", "", "OFFSET_BORDER", "ROTATION_180", "ROTATION_45", "ROTATION_90", "ROTATION_MAX", "ROTATION_SLOP", "TWO_POINTER", "actionMoveEnabled", "", "Landroid/view/View;", LoginConstants.DX_ONE_KEY_LOGIN, "dy", "fixScaleTranslate", "", "getRelativeToParentOffset", "Landroid/graphics/RectF;", "getScaleMovePointF", "Landroid/graphics/PointF;", "offsetX", "offsetY", "isRestore", "isVideoViewMatrixChanged", "touchSlop", "framework_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = BdGestureHelper.GESTURE_TAG)
/* loaded from: classes4.dex */
public final class BdGestureHelper {
    public static final long ANIMATION_DURATION = 240;
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

    public static final boolean actionMoveEnabled(View view2, float f, float f2) {
        Intrinsics.checkNotNullParameter(view2, "<this>");
        if (((float) Math.sqrt((f * f) + (f2 * f2))) >= touchSlop(view2)) {
            return true;
        }
        return false;
    }

    public static final void fixScaleTranslate(View view2, float f, float f2) {
        Intrinsics.checkNotNullParameter(view2, "<this>");
        if (view2.getScaleX() > 1.0f) {
            if (Math.abs(f) > 50.0f) {
                f = 50.0f;
            }
            if (Math.abs(f2) > 50.0f) {
                f2 = 50.0f;
            }
        }
        view2.setTranslationX(f);
        view2.setTranslationY(f2);
    }

    public static final RectF getRelativeToParentOffset(View view2) {
        Intrinsics.checkNotNullParameter(view2, "<this>");
        float translationX = view2.getTranslationX() - view2.getWidth();
        float translationY = view2.getTranslationY() - view2.getHeight();
        float width = ((view2.getWidth() * view2.getScaleX()) - view2.getWidth()) + translationX;
        float height = ((view2.getHeight() * view2.getScaleY()) - view2.getHeight()) + translationY;
        BdVideoLog.d(GESTURE_TAG, "左偏移=" + translationX + ", 右偏移=" + width + ", 上偏移=" + translationY + ", 下偏移=" + height);
        return new RectF(translationX, translationY, width, height);
    }

    public static final PointF getScaleMovePointF(View view2, float f, float f2, boolean z) {
        Intrinsics.checkNotNullParameter(view2, "<this>");
        if (!z) {
            RectF relativeToParentOffset = getRelativeToParentOffset(view2);
            if (f > 0.0f) {
                float f3 = relativeToParentOffset.left;
                if (f3 > 0.0f || (f3 < 0.0f && f3 + f > 0.0f)) {
                    f = 0.0f - f3;
                }
            } else if (f < 0.0f) {
                float f4 = relativeToParentOffset.right;
                if (f4 < -0.0f || (f4 > -0.0f && f4 + f < -0.0f)) {
                    f = (-0.0f) - f4;
                }
            }
            if (f2 > 0.0f) {
                float f5 = relativeToParentOffset.top;
                if (f5 > 0.0f || (f5 < 0.0f && f5 + f2 > 0.0f)) {
                    f2 = 0.0f - f5;
                }
            } else if (f2 < 0.0f) {
                float f6 = relativeToParentOffset.bottom;
                if (f6 < -0.0f || (f6 > -0.0f && f6 + f2 < -0.0f)) {
                    f2 = (-0.0f) - f6;
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

    public static /* synthetic */ PointF getScaleMovePointF$default(View view2, float f, float f2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return getScaleMovePointF(view2, f, f2, z);
    }

    public static final boolean isVideoViewMatrixChanged(View view2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.checkNotNullParameter(view2, "<this>");
        if (view2.getScaleX() == 1.0f) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return true;
        }
        if (view2.getScaleY() == 1.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return true;
        }
        if (view2.getRotation() == 0.0f) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            if (view2.getRotation() == 360.0f) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                return true;
            }
        }
        return false;
    }

    public static final int touchSlop(View view2) {
        Intrinsics.checkNotNullParameter(view2, "<this>");
        return ViewConfiguration.get(view2.getContext()).getScaledTouchSlop();
    }
}

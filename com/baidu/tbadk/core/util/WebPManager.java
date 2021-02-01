package com.baidu.tbadk.core.util;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class WebPManager {

    /* loaded from: classes.dex */
    public enum ResourceStateType {
        NORMAL(false, false, 1),
        NORMAL_PRESS(true, false, 2),
        NORMAL_PRESS_DISABLE(true, true, 3),
        NORMAL_DISABLE(false, true, 2);
        
        private boolean canDisable;
        private boolean canPress;
        private int stateCount;

        ResourceStateType(boolean z, boolean z2, int i) {
            this.canPress = z;
            this.canDisable = z2;
            this.stateCount = i;
        }
    }

    public static void a(ImageView imageView, @DrawableRes int i, ResourceStateType resourceStateType) {
        if (i != 0 && imageView != null) {
            if (resourceStateType == null) {
                resourceStateType = ResourceStateType.NORMAL;
            }
            imageView.setImageDrawable(a(i, resourceStateType));
        }
    }

    public static void a(ImageView imageView, @DrawableRes int i, @ColorRes int i2, ResourceStateType resourceStateType) {
        if (i != 0 && imageView != null) {
            if (resourceStateType == null) {
                resourceStateType = ResourceStateType.NORMAL;
            }
            imageView.setImageDrawable(a(i, ap.getColor(i2), resourceStateType));
        }
    }

    public static Drawable a(int i, @ColorInt int i2, @Nullable ResourceStateType resourceStateType) {
        if (i <= 0) {
            return null;
        }
        if (resourceStateType == null) {
            resourceStateType = ResourceStateType.NORMAL;
        }
        Drawable mutate = ap.getDrawable(i).mutate();
        mutate.setTintList(b(i2, resourceStateType));
        return mutate;
    }

    public static Drawable a(int i, @Nullable ResourceStateType resourceStateType) {
        Drawable oL;
        if (i <= 0) {
            return null;
        }
        if (resourceStateType == null) {
            resourceStateType = ResourceStateType.NORMAL;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (resourceStateType.canPress && (oL = oL(i)) != null) {
            oL.setAlpha((int) (ap.faN * 255.0f));
            stateListDrawable.addState(new int[]{16842919}, oL);
        }
        Drawable oL2 = oL(i);
        if (resourceStateType.canDisable) {
            stateListDrawable.addState(new int[0], oL2);
            Drawable oL3 = oL(i);
            oL3.setAlpha((int) (ap.faO * 255.0f));
            stateListDrawable.addState(new int[0], oL3);
            return stateListDrawable;
        }
        stateListDrawable.addState(new int[0], oL2);
        return stateListDrawable;
    }

    private static Drawable oL(int i) {
        Drawable mutate = ap.getDrawable(i).mutate();
        if (TbadkCoreApplication.getInst().getSkinType() != 0) {
            mutate.setColorFilter(ap.getColor(R.color.CAM_X0501), PorterDuff.Mode.SRC_ATOP);
        }
        return mutate;
    }

    private static ColorStateList b(@ColorInt int i, ResourceStateType resourceStateType) {
        int i2;
        if (resourceStateType == null) {
            resourceStateType = ResourceStateType.NORMAL;
        }
        int[] iArr = new int[resourceStateType.stateCount];
        int[][] iArr2 = new int[resourceStateType.stateCount];
        if (resourceStateType.canPress) {
            iArr[0] = com.baidu.tieba.tbadkCore.c.l(i, ap.faN);
            iArr2[0] = new int[]{16842919, 16842910};
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (resourceStateType.canDisable) {
            iArr[i2] = i;
            int[] iArr3 = new int[1];
            iArr3[0] = 16842910;
            iArr2[i2] = iArr3;
            int i3 = i2 + 1;
            iArr[i3] = com.baidu.tieba.tbadkCore.c.l(i, ap.faO);
            iArr2[i3] = new int[0];
        } else {
            iArr[i2] = i;
            iArr2[i2] = new int[0];
        }
        return new ColorStateList(iArr2, iArr);
    }

    public static Drawable A(int i, int i2, int i3) {
        Drawable drawable;
        if (i <= 0) {
            return null;
        }
        int i4 = R.color.CAM_X0107;
        int i5 = R.color.CAM_X0302;
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable2 = ap.getDrawable(i);
        if (drawable2 != null) {
            Drawable mutate = ap.getDrawable(i).mutate();
            mutate.setTint(com.baidu.tieba.tbadkCore.c.l(ap.getColor(i3, i4), ap.faO));
            stateListDrawable.addState(new int[]{-16842910}, mutate);
            if (i2 > 0 && (drawable = ap.getDrawable(i2)) != null) {
                Drawable mutate2 = ap.getDrawable(i2).mutate();
                mutate2.setAlpha((int) (255.0f * ap.faN));
                mutate2.setTint(ap.getColor(i3, i5));
                stateListDrawable.addState(new int[]{16842913, 16842919}, mutate2);
                drawable.mutate().setTint(ap.getColor(i3, i5));
                stateListDrawable.addState(new int[]{16842913}, drawable);
            }
            Drawable mutate3 = ap.getDrawable(i).mutate();
            mutate3.setTint(com.baidu.tieba.tbadkCore.c.l(ap.getColor(i3, i4), ap.faN));
            stateListDrawable.addState(new int[]{16842919}, mutate3);
            drawable2.mutate().setTint(ap.getColor(i3, i4));
            stateListDrawable.addState(new int[0], drawable2);
            return stateListDrawable;
        }
        return null;
    }
}

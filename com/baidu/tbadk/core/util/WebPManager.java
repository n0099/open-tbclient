package com.baidu.tbadk.core.util;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
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
        Drawable on;
        Drawable on2;
        if (i <= 0) {
            return null;
        }
        if (resourceStateType == null) {
            resourceStateType = ResourceStateType.NORMAL;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (resourceStateType.canDisable && (on2 = on(i)) != null) {
            on2.setAlpha(76);
            stateListDrawable.addState(new int[]{-16842910}, on2);
        }
        if (resourceStateType.canPress && (on = on(i)) != null) {
            on.setAlpha(127);
            stateListDrawable.addState(new int[]{16842919}, on);
        }
        Drawable on3 = on(i);
        if (on3 != null) {
            stateListDrawable.addState(new int[0], on3);
            return stateListDrawable;
        }
        return null;
    }

    private static Drawable on(int i) {
        Drawable mutate = ap.getDrawable(i).mutate();
        if (TbadkCoreApplication.getInst().getSkinType() != 0) {
            mutate.setColorFilter(ap.getColor(R.color.cp_mask_a), PorterDuff.Mode.SRC_ATOP);
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
        if (resourceStateType.canDisable) {
            iArr[0] = com.baidu.tieba.tbadkCore.c.l(i, 0.3f);
            int[] iArr3 = new int[1];
            iArr3[0] = -16842910;
            iArr2[0] = iArr3;
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (resourceStateType.canPress) {
            iArr[i2] = com.baidu.tieba.tbadkCore.c.l(i, 0.5f);
            int[] iArr4 = new int[1];
            iArr4[0] = 16842919;
            iArr2[i2] = iArr4;
            i2++;
        }
        iArr[i2] = i;
        iArr2[i2] = new int[0];
        return new ColorStateList(iArr2, iArr);
    }
}

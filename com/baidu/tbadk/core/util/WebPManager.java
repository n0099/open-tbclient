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
import d.b.i0.d3.c;
/* loaded from: classes3.dex */
public class WebPManager {

    /* loaded from: classes3.dex */
    public enum ResourceStateType {
        NORMAL(false, false, 1),
        NORMAL_PRESS(true, false, 2),
        NORMAL_PRESS_DISABLE(true, true, 3),
        NORMAL_DISABLE(false, true, 2);
        
        public boolean canDisable;
        public boolean canPress;
        public int stateCount;

        ResourceStateType(boolean z, boolean z2, int i) {
            this.canPress = z;
            this.canDisable = z2;
            this.stateCount = i;
        }
    }

    public static ColorStateList getColorListByResourceType(@ColorInt int i, ResourceStateType resourceStateType) {
        int i2;
        if (resourceStateType == null) {
            resourceStateType = ResourceStateType.NORMAL;
        }
        int[] iArr = new int[resourceStateType.stateCount];
        int[][] iArr2 = new int[resourceStateType.stateCount];
        if (resourceStateType.canPress) {
            iArr[0] = c.a(i, SkinManager.RESOURCE_ALPHA_PRESS);
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
            iArr[i3] = c.a(i, SkinManager.RESOURCE_ALPHA_DISABLE);
            iArr2[i3] = new int[0];
        } else {
            iArr[i2] = i;
            iArr2[i2] = new int[0];
        }
        return new ColorStateList(iArr2, iArr);
    }

    public static Drawable getMaskDrawable(int i, @Nullable ResourceStateType resourceStateType) {
        Drawable maskedDrawable;
        if (i <= 0) {
            return null;
        }
        if (resourceStateType == null) {
            resourceStateType = ResourceStateType.NORMAL;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (resourceStateType.canPress && (maskedDrawable = getMaskedDrawable(i)) != null) {
            maskedDrawable.setAlpha((int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f));
            stateListDrawable.addState(new int[]{16842919}, maskedDrawable);
        }
        Drawable maskedDrawable2 = getMaskedDrawable(i);
        if (resourceStateType.canDisable) {
            stateListDrawable.addState(new int[0], maskedDrawable2);
            Drawable maskedDrawable3 = getMaskedDrawable(i);
            maskedDrawable3.setAlpha((int) (SkinManager.RESOURCE_ALPHA_DISABLE * 255.0f));
            stateListDrawable.addState(new int[0], maskedDrawable3);
        } else {
            stateListDrawable.addState(new int[0], maskedDrawable2);
        }
        return stateListDrawable;
    }

    public static Drawable getMaskedDrawable(int i) {
        Drawable drawable = SkinManager.getDrawable(i);
        if (drawable == null) {
            return null;
        }
        Drawable mutate = drawable.mutate();
        if (TbadkCoreApplication.getInst().getSkinType() != 0) {
            mutate.setColorFilter(SkinManager.getColor(R.color.CAM_X0501), PorterDuff.Mode.SRC_ATOP);
        }
        return mutate;
    }

    public static Drawable getPureDrawable(int i, @ColorInt int i2, @Nullable ResourceStateType resourceStateType) {
        if (i <= 0) {
            return null;
        }
        if (resourceStateType == null) {
            resourceStateType = ResourceStateType.NORMAL;
        }
        Drawable drawable = SkinManager.getDrawable(i);
        if (drawable == null) {
            return null;
        }
        Drawable mutate = drawable.mutate();
        mutate.setTintList(getColorListByResourceType(i2, resourceStateType));
        return mutate;
    }

    @Deprecated
    public static Drawable getSeletableDrawableForEditorTools(int i, int i2, int i3) {
        Drawable drawable;
        if (i <= 0) {
            return null;
        }
        int i4 = R.color.CAM_X0105;
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable2 = SkinManager.getDrawable(i);
        if (drawable2 == null) {
            return null;
        }
        Drawable mutate = SkinManager.getDrawable(i).mutate();
        mutate.setTint(c.a(SkinManager.getColor(i3, i4), SkinManager.RESOURCE_ALPHA_DISABLE));
        stateListDrawable.addState(new int[]{-16842910}, mutate);
        if (i2 > 0 && (drawable = SkinManager.getDrawable(i2)) != null) {
            Drawable mutate2 = SkinManager.getDrawable(i2).mutate();
            mutate2.setAlpha((int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f));
            stateListDrawable.addState(new int[]{16842913, 16842919}, mutate2);
            stateListDrawable.addState(new int[]{16842913}, drawable);
        }
        Drawable mutate3 = SkinManager.getDrawable(i).mutate();
        mutate3.setTint(c.a(SkinManager.getColor(i3, i4), SkinManager.RESOURCE_ALPHA_PRESS));
        stateListDrawable.addState(new int[]{16842919}, mutate3);
        drawable2.mutate().setTint(SkinManager.getColor(i3, i4));
        stateListDrawable.addState(new int[0], drawable2);
        return stateListDrawable;
    }

    public static Drawable getSeletableDrawableForEditorToolsEM(int i, int i2, int i3) {
        Drawable drawable;
        if (i <= 0) {
            return null;
        }
        int i4 = R.color.CAM_X0107;
        int i5 = R.color.CAM_X0302;
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable2 = SkinManager.getDrawable(i);
        if (drawable2 == null) {
            return null;
        }
        Drawable mutate = SkinManager.getDrawable(i).mutate();
        mutate.setTint(c.a(SkinManager.getColor(i3, i4), SkinManager.RESOURCE_ALPHA_DISABLE));
        stateListDrawable.addState(new int[]{-16842910}, mutate);
        if (i2 > 0 && (drawable = SkinManager.getDrawable(i2)) != null) {
            Drawable mutate2 = SkinManager.getDrawable(i2).mutate();
            mutate2.setAlpha((int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f));
            mutate2.setTint(SkinManager.getColor(i3, i5));
            stateListDrawable.addState(new int[]{16842913, 16842919}, mutate2);
            drawable.mutate().setTint(SkinManager.getColor(i3, i5));
            stateListDrawable.addState(new int[]{16842913}, drawable);
        }
        Drawable mutate3 = SkinManager.getDrawable(i).mutate();
        mutate3.setTint(c.a(SkinManager.getColor(i3, i4), SkinManager.RESOURCE_ALPHA_PRESS));
        stateListDrawable.addState(new int[]{16842919}, mutate3);
        drawable2.mutate().setTint(SkinManager.getColor(i3, i4));
        stateListDrawable.addState(new int[0], drawable2);
        return stateListDrawable;
    }

    public static void setMaskDrawable(ImageView imageView, @DrawableRes int i, ResourceStateType resourceStateType) {
        if (i == 0 || imageView == null) {
            return;
        }
        if (resourceStateType == null) {
            resourceStateType = ResourceStateType.NORMAL;
        }
        imageView.setImageDrawable(getMaskDrawable(i, resourceStateType));
    }

    public static void setPureDrawable(ImageView imageView, @DrawableRes int i, @ColorRes int i2, ResourceStateType resourceStateType) {
        if (i == 0 || imageView == null) {
            return;
        }
        if (resourceStateType == null) {
            resourceStateType = ResourceStateType.NORMAL;
        }
        imageView.setImageDrawable(getPureDrawable(i, SkinManager.getColor(i2), resourceStateType));
    }
}

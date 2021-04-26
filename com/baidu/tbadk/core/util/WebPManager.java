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
import d.a.j0.d3.c;
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

        ResourceStateType(boolean z, boolean z2, int i2) {
            this.canPress = z;
            this.canDisable = z2;
            this.stateCount = i2;
        }
    }

    public static ColorStateList getColorListByResourceType(@ColorInt int i2, ResourceStateType resourceStateType) {
        int i3;
        if (resourceStateType == null) {
            resourceStateType = ResourceStateType.NORMAL;
        }
        int[] iArr = new int[resourceStateType.stateCount];
        int[][] iArr2 = new int[resourceStateType.stateCount];
        if (resourceStateType.canPress) {
            iArr[0] = c.a(i2, SkinManager.RESOURCE_ALPHA_PRESS);
            iArr2[0] = new int[]{16842919, 16842910};
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (resourceStateType.canDisable) {
            iArr[i3] = i2;
            int[] iArr3 = new int[1];
            iArr3[0] = 16842910;
            iArr2[i3] = iArr3;
            int i4 = i3 + 1;
            iArr[i4] = c.a(i2, SkinManager.RESOURCE_ALPHA_DISABLE);
            iArr2[i4] = new int[0];
        } else {
            iArr[i3] = i2;
            iArr2[i3] = new int[0];
        }
        return new ColorStateList(iArr2, iArr);
    }

    public static Drawable getMaskDrawable(int i2, @Nullable ResourceStateType resourceStateType) {
        Drawable maskedDrawable;
        if (i2 <= 0) {
            return null;
        }
        if (resourceStateType == null) {
            resourceStateType = ResourceStateType.NORMAL;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (resourceStateType.canPress && (maskedDrawable = getMaskedDrawable(i2)) != null) {
            maskedDrawable.setAlpha((int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f));
            stateListDrawable.addState(new int[]{16842919}, maskedDrawable);
        }
        Drawable maskedDrawable2 = getMaskedDrawable(i2);
        if (resourceStateType.canDisable) {
            stateListDrawable.addState(new int[0], maskedDrawable2);
            Drawable maskedDrawable3 = getMaskedDrawable(i2);
            maskedDrawable3.setAlpha((int) (SkinManager.RESOURCE_ALPHA_DISABLE * 255.0f));
            stateListDrawable.addState(new int[0], maskedDrawable3);
        } else {
            stateListDrawable.addState(new int[0], maskedDrawable2);
        }
        return stateListDrawable;
    }

    public static Drawable getMaskedDrawable(int i2) {
        Drawable drawable = SkinManager.getDrawable(i2);
        if (drawable == null) {
            return null;
        }
        Drawable mutate = drawable.mutate();
        if (TbadkCoreApplication.getInst().getSkinType() != 0) {
            mutate.setColorFilter(SkinManager.getColor(R.color.CAM_X0501), PorterDuff.Mode.SRC_ATOP);
        }
        return mutate;
    }

    public static Drawable getPureDrawable(int i2, @ColorInt int i3, @Nullable ResourceStateType resourceStateType) {
        if (i2 <= 0) {
            return null;
        }
        if (resourceStateType == null) {
            resourceStateType = ResourceStateType.NORMAL;
        }
        Drawable drawable = SkinManager.getDrawable(i2);
        if (drawable == null) {
            return null;
        }
        Drawable mutate = drawable.mutate();
        mutate.setTintList(getColorListByResourceType(i3, resourceStateType));
        return mutate;
    }

    @Deprecated
    public static Drawable getSeletableDrawableForEditorTools(int i2, int i3, int i4) {
        Drawable drawable;
        if (i2 <= 0) {
            return null;
        }
        int i5 = R.color.CAM_X0105;
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable2 = SkinManager.getDrawable(i2);
        if (drawable2 == null) {
            return null;
        }
        Drawable mutate = SkinManager.getDrawable(i2).mutate();
        mutate.setTint(c.a(SkinManager.getColor(i4, i5), SkinManager.RESOURCE_ALPHA_DISABLE));
        stateListDrawable.addState(new int[]{-16842910}, mutate);
        if (i3 > 0 && (drawable = SkinManager.getDrawable(i3)) != null) {
            Drawable mutate2 = SkinManager.getDrawable(i3).mutate();
            mutate2.setAlpha((int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f));
            stateListDrawable.addState(new int[]{16842913, 16842919}, mutate2);
            stateListDrawable.addState(new int[]{16842913}, drawable);
        }
        Drawable mutate3 = SkinManager.getDrawable(i2).mutate();
        mutate3.setTint(c.a(SkinManager.getColor(i4, i5), SkinManager.RESOURCE_ALPHA_PRESS));
        stateListDrawable.addState(new int[]{16842919}, mutate3);
        drawable2.mutate().setTint(SkinManager.getColor(i4, i5));
        stateListDrawable.addState(new int[0], drawable2);
        return stateListDrawable;
    }

    public static Drawable getSeletableDrawableForEditorToolsEM(int i2, int i3, int i4) {
        Drawable drawable;
        if (i2 <= 0) {
            return null;
        }
        int i5 = R.color.CAM_X0107;
        int i6 = R.color.CAM_X0302;
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable2 = SkinManager.getDrawable(i2);
        if (drawable2 == null) {
            return null;
        }
        Drawable mutate = SkinManager.getDrawable(i2).mutate();
        mutate.setTint(c.a(SkinManager.getColor(i4, i5), SkinManager.RESOURCE_ALPHA_DISABLE));
        stateListDrawable.addState(new int[]{-16842910}, mutate);
        if (i3 > 0 && (drawable = SkinManager.getDrawable(i3)) != null) {
            Drawable mutate2 = SkinManager.getDrawable(i3).mutate();
            mutate2.setAlpha((int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f));
            mutate2.setTint(SkinManager.getColor(i4, i6));
            stateListDrawable.addState(new int[]{16842913, 16842919}, mutate2);
            drawable.mutate().setTint(SkinManager.getColor(i4, i6));
            stateListDrawable.addState(new int[]{16842913}, drawable);
        }
        Drawable mutate3 = SkinManager.getDrawable(i2).mutate();
        mutate3.setTint(c.a(SkinManager.getColor(i4, i5), SkinManager.RESOURCE_ALPHA_PRESS));
        stateListDrawable.addState(new int[]{16842919}, mutate3);
        drawable2.mutate().setTint(SkinManager.getColor(i4, i5));
        stateListDrawable.addState(new int[0], drawable2);
        return stateListDrawable;
    }

    public static void setMaskDrawable(ImageView imageView, @DrawableRes int i2, ResourceStateType resourceStateType) {
        if (i2 == 0 || imageView == null) {
            return;
        }
        if (resourceStateType == null) {
            resourceStateType = ResourceStateType.NORMAL;
        }
        imageView.setImageDrawable(getMaskDrawable(i2, resourceStateType));
    }

    public static void setPureDrawable(ImageView imageView, @DrawableRes int i2, @ColorRes int i3, ResourceStateType resourceStateType) {
        if (i2 == 0 || imageView == null) {
            return;
        }
        if (resourceStateType == null) {
            resourceStateType = ResourceStateType.NORMAL;
        }
        imageView.setImageDrawable(getPureDrawable(i2, SkinManager.getColor(i3), resourceStateType));
    }
}

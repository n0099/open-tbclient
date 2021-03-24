package com.baidu.tbadk.core.util.tbselector;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.selector.ColorSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
/* loaded from: classes3.dex */
public class TBSelector {
    public static final float RESOURCE_ALPHA_PRESS = SkinManager.RESOURCE_ALPHA_PRESS;
    public static final float RESOURCE_ALPHA_DISABLE = SkinManager.RESOURCE_ALPHA_DISABLE;

    public static ColorSelector makeColorSelector() {
        return ColorSelector.make().textType(1);
    }

    public static DrawableSelector makeDrawableSelector() {
        return DrawableSelector.make();
    }

    public static ShadowDrawable makeShadowDrawable() {
        return ShadowDrawable.make();
    }

    public static ColorSelector makeTextColorSelector() {
        return ColorSelector.make().textType(1);
    }

    public static ColorSelector makeTextHintColorSelector() {
        return ColorSelector.make().textType(2);
    }

    public static DrawableSelector selectorBackgroundColor(@ColorRes int i, @ColorRes int i2, int i3) {
        return DrawableSelector.make().setType(1).defaultColor(i).pressedColor(i2).radius(i3);
    }

    public static DrawableSelector selectorBackgroundDrawable(Drawable drawable, Drawable drawable2) {
        return DrawableSelector.make().setType(1).defaultDrawable(drawable).pressedDrawable(drawable2);
    }

    public static DrawableSelector selectorImageDrawable(@DrawableRes int i, @DrawableRes int i2) {
        return DrawableSelector.make().setType(2).defaultDrawable(i).pressedDrawable(i2);
    }

    public static ColorSelector selectorTextColor(@ColorRes int i, @ColorRes int i2) {
        return ColorSelector.make().textType(1).pressedColor(i2).defaultColor(i);
    }

    public static ColorSelector selectorTextHintColor(@ColorRes int i, @ColorRes int i2) {
        return ColorSelector.make().textType(2).pressedColor(i2).defaultColor(i);
    }

    public static void setViewBackgroundColorWithDisabledState(View view, @ColorRes int i) {
        if (view == null) {
            return;
        }
        Drawable colorDrawable = SelectorHelper.getColorDrawable(i);
        DrawableSelector.make().setType(1).defaultDrawable(colorDrawable).disabledDrawable(SelectorHelper.getColorDrawable(i, RESOURCE_ALPHA_DISABLE)).into(view);
    }

    public static void setViewBackgroundColorWithPressedState(View view, int i, int i2) {
        if (view == null) {
            return;
        }
        DrawableSelector.make().setType(1).defaultColor(i).pressedColor(i2).into(view);
    }

    public static DrawableSelector selectorBackgroundDrawable(@DrawableRes int i, @DrawableRes int i2) {
        return DrawableSelector.make().setType(1).defaultDrawable(i).pressedDrawable(i2);
    }

    public static ColorSelector selectorTextColor(String str, String str2) {
        return ColorSelector.make().textType(1).pressedColor(str2).defaultColor(str);
    }

    public static ColorSelector selectorTextHintColor(String str, String str2) {
        return ColorSelector.make().textType(2).pressedColor(str2).defaultColor(str);
    }

    public static DrawableSelector selectorBackgroundColor(String str, String str2, int i) {
        return DrawableSelector.make().setType(1).defaultColor(str).pressedColor(str2).radius(i);
    }

    public static void setViewBackgroundColorWithPressedState(View view, @ColorRes int i) {
        if (view == null) {
            return;
        }
        Drawable colorDrawable = SelectorHelper.getColorDrawable(i);
        DrawableSelector.make().setType(1).defaultDrawable(colorDrawable).pressedDrawable(SelectorHelper.getColorDrawable(i, RESOURCE_ALPHA_PRESS)).into(view);
    }
}

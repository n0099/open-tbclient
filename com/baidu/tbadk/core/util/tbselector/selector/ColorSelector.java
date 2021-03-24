package com.baidu.tbadk.core.util.tbselector.selector;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import com.baidu.tbadk.core.util.tbselector.interfaces.ISelector;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
/* loaded from: classes3.dex */
public class ColorSelector implements ISelector<ColorStateList, TextView> {
    public static final int HINT_TEXT_COLOR = 2;
    public static final int TEXT_COLOR = 1;
    public int disabledColor;
    public int focusedColor;
    public ColorStateList mColorStateList;
    public int normalColor;
    public int pressedColor;
    public int selectedColor;
    public int textType = 1;
    public boolean hasSetDisabledColor = false;
    public boolean hasSetPressedColor = false;
    public boolean hasSetSelectedColor = false;
    public boolean hasSetFocusedColor = false;

    private ColorStateList create() {
        int[] iArr = new int[5];
        iArr[0] = this.hasSetDisabledColor ? this.disabledColor : this.normalColor;
        iArr[1] = this.hasSetPressedColor ? this.pressedColor : this.normalColor;
        iArr[2] = this.hasSetSelectedColor ? this.selectedColor : this.normalColor;
        iArr[3] = this.hasSetFocusedColor ? this.focusedColor : this.normalColor;
        iArr[4] = this.normalColor;
        return getColorStateList(iArr);
    }

    private ColorStateList getColorStateList(int[] iArr) {
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842919}, new int[]{16842913}, new int[]{16842908}, new int[0]}, iArr);
    }

    public static ColorSelector make() {
        return new ColorSelector();
    }

    public ColorSelector defaultColor(@ColorRes int i) {
        int color = SelectorHelper.getColor(i);
        this.normalColor = color;
        if (!this.hasSetDisabledColor) {
            this.disabledColor = color;
        }
        if (!this.hasSetPressedColor) {
            this.pressedColor = color;
        }
        if (!this.hasSetSelectedColor) {
            this.selectedColor = color;
        }
        if (!this.hasSetFocusedColor) {
            this.focusedColor = color;
        }
        return this;
    }

    public ColorSelector disabledColor(@ColorRes int i) {
        this.disabledColor = SelectorHelper.getColor(i);
        this.hasSetDisabledColor = true;
        return this;
    }

    public ColorSelector focusedColor(@ColorRes int i) {
        this.focusedColor = SelectorHelper.getColor(i);
        this.hasSetFocusedColor = true;
        return this;
    }

    public ColorSelector pressedColor(@ColorRes int i) {
        this.pressedColor = SelectorHelper.getColor(i);
        this.hasSetPressedColor = true;
        return this;
    }

    public ColorSelector selectedColor(@ColorRes int i) {
        this.selectedColor = SelectorHelper.getColor(i);
        this.hasSetSelectedColor = true;
        return this;
    }

    public ColorSelector selectorColor(@ColorRes int i, @ColorRes int i2) {
        this.pressedColor = i;
        this.normalColor = i2;
        this.hasSetPressedColor = true;
        return this;
    }

    public ColorSelector textType(int i) {
        this.textType = i;
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.tbselector.interfaces.ISelector
    public ColorStateList build() {
        ColorStateList create = create();
        this.mColorStateList = create;
        return create;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.tbselector.interfaces.ISelector
    public void into(TextView textView) {
        if (textView == null) {
            return;
        }
        build();
        if (2 == this.textType) {
            textView.setHintTextColor(this.mColorStateList);
        } else {
            textView.setTextColor(this.mColorStateList);
        }
    }

    public ColorSelector disabledColor(String str) {
        this.disabledColor = SelectorHelper.parseColor(str);
        this.hasSetDisabledColor = true;
        return this;
    }

    public ColorSelector focusedColor(String str) {
        this.focusedColor = SelectorHelper.parseColor(str);
        this.hasSetFocusedColor = true;
        return this;
    }

    public ColorSelector pressedColor(String str) {
        this.pressedColor = SelectorHelper.parseColor(str);
        this.hasSetPressedColor = true;
        return this;
    }

    public ColorSelector selectedColor(String str) {
        this.selectedColor = SelectorHelper.parseColor(str);
        this.hasSetSelectedColor = true;
        return this;
    }

    public ColorSelector defaultColor(String str) {
        int parseColor = Color.parseColor(str);
        this.normalColor = parseColor;
        if (!this.hasSetDisabledColor) {
            this.disabledColor = parseColor;
        }
        if (!this.hasSetPressedColor) {
            this.pressedColor = parseColor;
        }
        if (!this.hasSetSelectedColor) {
            this.selectedColor = parseColor;
        }
        if (!this.hasSetFocusedColor) {
            this.focusedColor = parseColor;
        }
        return this;
    }
}

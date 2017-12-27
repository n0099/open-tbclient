package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.TypedValue;
@RestrictTo
/* loaded from: classes2.dex */
public class TintTypedArray {
    private TypedValue MY;
    private final TypedArray Xn;
    private final Context mContext;

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public static TintTypedArray obtainStyledAttributes(Context context, int i, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i, iArr));
    }

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.mContext = context;
        this.Xn = typedArray;
    }

    public Drawable getDrawable(int i) {
        int resourceId;
        return (!this.Xn.hasValue(i) || (resourceId = this.Xn.getResourceId(i, 0)) == 0) ? this.Xn.getDrawable(i) : AppCompatResources.getDrawable(this.mContext, resourceId);
    }

    public Drawable getDrawableIfKnown(int i) {
        int resourceId;
        if (!this.Xn.hasValue(i) || (resourceId = this.Xn.getResourceId(i, 0)) == 0) {
            return null;
        }
        return AppCompatDrawableManager.get().b(this.mContext, resourceId, true);
    }

    public int length() {
        return this.Xn.length();
    }

    public int getIndexCount() {
        return this.Xn.getIndexCount();
    }

    public int getIndex(int i) {
        return this.Xn.getIndex(i);
    }

    public Resources getResources() {
        return this.Xn.getResources();
    }

    public CharSequence getText(int i) {
        return this.Xn.getText(i);
    }

    public String getString(int i) {
        return this.Xn.getString(i);
    }

    public String getNonResourceString(int i) {
        return this.Xn.getNonResourceString(i);
    }

    public boolean getBoolean(int i, boolean z) {
        return this.Xn.getBoolean(i, z);
    }

    public int getInt(int i, int i2) {
        return this.Xn.getInt(i, i2);
    }

    public float getFloat(int i, float f) {
        return this.Xn.getFloat(i, f);
    }

    public int getColor(int i, int i2) {
        return this.Xn.getColor(i, i2);
    }

    public ColorStateList getColorStateList(int i) {
        int resourceId;
        ColorStateList colorStateList;
        return (!this.Xn.hasValue(i) || (resourceId = this.Xn.getResourceId(i, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(this.mContext, resourceId)) == null) ? this.Xn.getColorStateList(i) : colorStateList;
    }

    public int getInteger(int i, int i2) {
        return this.Xn.getInteger(i, i2);
    }

    public float getDimension(int i, float f) {
        return this.Xn.getDimension(i, f);
    }

    public int getDimensionPixelOffset(int i, int i2) {
        return this.Xn.getDimensionPixelOffset(i, i2);
    }

    public int getDimensionPixelSize(int i, int i2) {
        return this.Xn.getDimensionPixelSize(i, i2);
    }

    public int getLayoutDimension(int i, String str) {
        return this.Xn.getLayoutDimension(i, str);
    }

    public int getLayoutDimension(int i, int i2) {
        return this.Xn.getLayoutDimension(i, i2);
    }

    public float getFraction(int i, int i2, int i3, float f) {
        return this.Xn.getFraction(i, i2, i3, f);
    }

    public int getResourceId(int i, int i2) {
        return this.Xn.getResourceId(i, i2);
    }

    public CharSequence[] getTextArray(int i) {
        return this.Xn.getTextArray(i);
    }

    public boolean getValue(int i, TypedValue typedValue) {
        return this.Xn.getValue(i, typedValue);
    }

    public int getType(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.Xn.getType(i);
        }
        if (this.MY == null) {
            this.MY = new TypedValue();
        }
        this.Xn.getValue(i, this.MY);
        return this.MY.type;
    }

    public boolean hasValue(int i) {
        return this.Xn.hasValue(i);
    }

    public TypedValue peekValue(int i) {
        return this.Xn.peekValue(i);
    }

    public String getPositionDescription() {
        return this.Xn.getPositionDescription();
    }

    public void recycle() {
        this.Xn.recycle();
    }

    public int getChangingConfigurations() {
        return this.Xn.getChangingConfigurations();
    }
}

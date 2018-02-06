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
    private TypedValue MX;
    private final TypedArray Xm;
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
        this.Xm = typedArray;
    }

    public Drawable getDrawable(int i) {
        int resourceId;
        return (!this.Xm.hasValue(i) || (resourceId = this.Xm.getResourceId(i, 0)) == 0) ? this.Xm.getDrawable(i) : AppCompatResources.getDrawable(this.mContext, resourceId);
    }

    public Drawable getDrawableIfKnown(int i) {
        int resourceId;
        if (!this.Xm.hasValue(i) || (resourceId = this.Xm.getResourceId(i, 0)) == 0) {
            return null;
        }
        return AppCompatDrawableManager.get().b(this.mContext, resourceId, true);
    }

    public int length() {
        return this.Xm.length();
    }

    public int getIndexCount() {
        return this.Xm.getIndexCount();
    }

    public int getIndex(int i) {
        return this.Xm.getIndex(i);
    }

    public Resources getResources() {
        return this.Xm.getResources();
    }

    public CharSequence getText(int i) {
        return this.Xm.getText(i);
    }

    public String getString(int i) {
        return this.Xm.getString(i);
    }

    public String getNonResourceString(int i) {
        return this.Xm.getNonResourceString(i);
    }

    public boolean getBoolean(int i, boolean z) {
        return this.Xm.getBoolean(i, z);
    }

    public int getInt(int i, int i2) {
        return this.Xm.getInt(i, i2);
    }

    public float getFloat(int i, float f) {
        return this.Xm.getFloat(i, f);
    }

    public int getColor(int i, int i2) {
        return this.Xm.getColor(i, i2);
    }

    public ColorStateList getColorStateList(int i) {
        int resourceId;
        ColorStateList colorStateList;
        return (!this.Xm.hasValue(i) || (resourceId = this.Xm.getResourceId(i, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(this.mContext, resourceId)) == null) ? this.Xm.getColorStateList(i) : colorStateList;
    }

    public int getInteger(int i, int i2) {
        return this.Xm.getInteger(i, i2);
    }

    public float getDimension(int i, float f) {
        return this.Xm.getDimension(i, f);
    }

    public int getDimensionPixelOffset(int i, int i2) {
        return this.Xm.getDimensionPixelOffset(i, i2);
    }

    public int getDimensionPixelSize(int i, int i2) {
        return this.Xm.getDimensionPixelSize(i, i2);
    }

    public int getLayoutDimension(int i, String str) {
        return this.Xm.getLayoutDimension(i, str);
    }

    public int getLayoutDimension(int i, int i2) {
        return this.Xm.getLayoutDimension(i, i2);
    }

    public float getFraction(int i, int i2, int i3, float f) {
        return this.Xm.getFraction(i, i2, i3, f);
    }

    public int getResourceId(int i, int i2) {
        return this.Xm.getResourceId(i, i2);
    }

    public CharSequence[] getTextArray(int i) {
        return this.Xm.getTextArray(i);
    }

    public boolean getValue(int i, TypedValue typedValue) {
        return this.Xm.getValue(i, typedValue);
    }

    public int getType(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.Xm.getType(i);
        }
        if (this.MX == null) {
            this.MX = new TypedValue();
        }
        this.Xm.getValue(i, this.MX);
        return this.MX.type;
    }

    public boolean hasValue(int i) {
        return this.Xm.hasValue(i);
    }

    public TypedValue peekValue(int i) {
        return this.Xm.peekValue(i);
    }

    public String getPositionDescription() {
        return this.Xm.getPositionDescription();
    }

    public void recycle() {
        this.Xm.recycle();
    }

    public int getChangingConfigurations() {
        return this.Xm.getChangingConfigurations();
    }
}

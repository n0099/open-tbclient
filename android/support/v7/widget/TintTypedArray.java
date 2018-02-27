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
    private TypedValue MS;
    private final TypedArray Xg;
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
        this.Xg = typedArray;
    }

    public Drawable getDrawable(int i) {
        int resourceId;
        return (!this.Xg.hasValue(i) || (resourceId = this.Xg.getResourceId(i, 0)) == 0) ? this.Xg.getDrawable(i) : AppCompatResources.getDrawable(this.mContext, resourceId);
    }

    public Drawable getDrawableIfKnown(int i) {
        int resourceId;
        if (!this.Xg.hasValue(i) || (resourceId = this.Xg.getResourceId(i, 0)) == 0) {
            return null;
        }
        return AppCompatDrawableManager.get().b(this.mContext, resourceId, true);
    }

    public int length() {
        return this.Xg.length();
    }

    public int getIndexCount() {
        return this.Xg.getIndexCount();
    }

    public int getIndex(int i) {
        return this.Xg.getIndex(i);
    }

    public Resources getResources() {
        return this.Xg.getResources();
    }

    public CharSequence getText(int i) {
        return this.Xg.getText(i);
    }

    public String getString(int i) {
        return this.Xg.getString(i);
    }

    public String getNonResourceString(int i) {
        return this.Xg.getNonResourceString(i);
    }

    public boolean getBoolean(int i, boolean z) {
        return this.Xg.getBoolean(i, z);
    }

    public int getInt(int i, int i2) {
        return this.Xg.getInt(i, i2);
    }

    public float getFloat(int i, float f) {
        return this.Xg.getFloat(i, f);
    }

    public int getColor(int i, int i2) {
        return this.Xg.getColor(i, i2);
    }

    public ColorStateList getColorStateList(int i) {
        int resourceId;
        ColorStateList colorStateList;
        return (!this.Xg.hasValue(i) || (resourceId = this.Xg.getResourceId(i, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(this.mContext, resourceId)) == null) ? this.Xg.getColorStateList(i) : colorStateList;
    }

    public int getInteger(int i, int i2) {
        return this.Xg.getInteger(i, i2);
    }

    public float getDimension(int i, float f) {
        return this.Xg.getDimension(i, f);
    }

    public int getDimensionPixelOffset(int i, int i2) {
        return this.Xg.getDimensionPixelOffset(i, i2);
    }

    public int getDimensionPixelSize(int i, int i2) {
        return this.Xg.getDimensionPixelSize(i, i2);
    }

    public int getLayoutDimension(int i, String str) {
        return this.Xg.getLayoutDimension(i, str);
    }

    public int getLayoutDimension(int i, int i2) {
        return this.Xg.getLayoutDimension(i, i2);
    }

    public float getFraction(int i, int i2, int i3, float f) {
        return this.Xg.getFraction(i, i2, i3, f);
    }

    public int getResourceId(int i, int i2) {
        return this.Xg.getResourceId(i, i2);
    }

    public CharSequence[] getTextArray(int i) {
        return this.Xg.getTextArray(i);
    }

    public boolean getValue(int i, TypedValue typedValue) {
        return this.Xg.getValue(i, typedValue);
    }

    public int getType(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.Xg.getType(i);
        }
        if (this.MS == null) {
            this.MS = new TypedValue();
        }
        this.Xg.getValue(i, this.MS);
        return this.MS.type;
    }

    public boolean hasValue(int i) {
        return this.Xg.hasValue(i);
    }

    public TypedValue peekValue(int i) {
        return this.Xg.peekValue(i);
    }

    public String getPositionDescription() {
        return this.Xg.getPositionDescription();
    }

    public void recycle() {
        this.Xg.recycle();
    }

    public int getChangingConfigurations() {
        return this.Xg.getChangingConfigurations();
    }
}

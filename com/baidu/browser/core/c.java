package com.baidu.browser.core;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class c extends Resources {
    private Map<String, String> UX;
    private Resources UY;
    private Resources UZ;
    private String mPackageName;
    private static final String UW = Environment.getRootDirectory().toString() + File.separator + "baidu/flyflow/plugin_asset";
    private static final String TAG = c.class.getSimpleName();
    private static HashMap<String, com.baidu.browser.core.util.c<String, Integer>> UV = new HashMap<>();

    public c(Resources resources, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        super(assetManager, displayMetrics, configuration);
        this.UZ = resources;
        this.UX = new HashMap();
    }

    public int bA(int i) {
        com.baidu.browser.core.util.c<String, Integer> cVar;
        if (TextUtils.isEmpty(this.mPackageName) || this.mPackageName.equals("com.baidu.browser.theme.default")) {
            return 0;
        }
        try {
            String resourceEntryName = this.UZ.getResourceEntryName(i);
            String resourceTypeName = this.UZ.getResourceTypeName(i);
            com.baidu.browser.core.util.c<String, Integer> cVar2 = UV.get(resourceTypeName);
            if (cVar2 == null) {
                com.baidu.browser.core.util.c<String, Integer> cVar3 = new com.baidu.browser.core.util.c<>(100);
                UV.put(resourceTypeName, cVar3);
                cVar = cVar3;
            } else {
                cVar = cVar2;
            }
            Integer num = cVar.get(resourceEntryName);
            if (num == null) {
                num = Integer.valueOf(this.UY.getIdentifier(resourceEntryName, resourceTypeName, this.mPackageName));
                if (num.intValue() != 0) {
                    cVar.put(resourceEntryName, num);
                }
            }
            return num.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.UZ.getConfiguration();
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UY.getAnimation(bA) : this.UZ.getAnimation(i);
    }

    @Override // android.content.res.Resources
    public int getColor(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UY.getColor(bA) : this.UZ.getColor(i);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UY.getColorStateList(bA) : this.UZ.getColorStateList(i);
    }

    @Override // android.content.res.Resources
    public float getDimension(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UY.getDimension(bA) : this.UZ.getDimension(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UY.getDimensionPixelOffset(bA) : this.UZ.getDimensionPixelOffset(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UY.getDimensionPixelSize(bA) : this.UZ.getDimensionPixelSize(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UY.getDrawable(bA) : this.UZ.getDrawable(i);
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawable(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UY.getDrawable(bA, null) : this.UZ.getDrawable(i, theme);
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public Drawable getDrawableForDensity(int i, int i2) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UY.getDrawableForDensity(bA, i2) : this.UZ.getDrawableForDensity(i, i2);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i, int i2, int i3) {
        int bA = bA(i);
        return bA != 0 ? this.UY.getFraction(bA, i2, i3) : this.UZ.getFraction(i, i2, i3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UY.getIntArray(bA) : this.UZ.getIntArray(i);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UY.getInteger(bA) : this.UZ.getInteger(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UY.getLayout(bA) : this.UZ.getLayout(i);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UY.getMovie(bA) : this.UZ.getMovie(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i, int i2) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UY.getQuantityText(bA, i2) : this.UZ.getQuantityText(i, i2);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UY.getQuantityString(bA, i2) : this.UZ.getQuantityString(i, i2);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2, Object... objArr) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UY.getQuantityString(bA, i2, objArr) : this.UZ.getQuantityString(i, i2, objArr);
    }

    @Override // android.content.res.Resources
    public String getString(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UY.getString(bA) : this.UZ.getString(i);
    }

    @Override // android.content.res.Resources
    public String getString(int i, Object... objArr) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UY.getString(bA, objArr) : this.UZ.getString(i, objArr);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UY.getStringArray(bA) : this.UZ.getStringArray(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UY.getText(bA) : this.UZ.getText(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i, CharSequence charSequence) {
        int bA = bA(i);
        return bA != 0 ? this.UY.getText(bA, charSequence) : this.UZ.getText(i, charSequence);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UY.getTextArray(bA) : this.UZ.getTextArray(i);
    }

    @Override // android.content.res.Resources
    public void getValue(int i, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int bA = bA(i);
        if (bA != 0) {
            this.UY.getValue(bA, typedValue, z);
        } else {
            this.UZ.getValue(i, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int bA = bA(i);
        if (bA != 0) {
            this.UY.getValueForDensity(bA, i2, typedValue, z);
        } else {
            this.UZ.getValueForDensity(i, i2, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i) throws Resources.NotFoundException {
        return this.UZ.obtainTypedArray(i);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i) throws Resources.NotFoundException {
        return this.UZ.getBoolean(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i) throws Resources.NotFoundException {
        return this.UZ.getXml(i);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.UZ.getValue(str, typedValue, z);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.UZ.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i) throws Resources.NotFoundException {
        return this.UZ.getResourceName(i);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i) throws Resources.NotFoundException {
        return this.UZ.getResourcePackageName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i) throws Resources.NotFoundException {
        return this.UZ.getResourceTypeName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i) throws Resources.NotFoundException {
        return this.UZ.getResourceEntryName(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        if (bA != 0 && this.UY != null) {
            try {
                InputStream openRawResource = this.UY.openRawResource(bA);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.UZ.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i, TypedValue typedValue) throws Resources.NotFoundException {
        int bA = bA(i);
        if (bA != 0 && this.UY != null) {
            try {
                InputStream openRawResource = this.UY.openRawResource(bA, typedValue);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.UZ.openRawResource(i, typedValue);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        if (bA != 0 && this.UY != null) {
            try {
                AssetFileDescriptor openRawResourceFd = this.UY.openRawResourceFd(bA);
                if (openRawResourceFd != null) {
                    return openRawResourceFd;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.UZ.openRawResourceFd(i);
    }
}

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
/* loaded from: classes10.dex */
public class h extends Resources {
    private Map<String, String> HW;
    private Resources HX;
    private Resources HY;
    private String mPackageName;
    private static final String HV = Environment.getRootDirectory().toString() + File.separator + "baidu/flyflow/plugin_asset";
    private static final String TAG = h.class.getSimpleName();
    private static HashMap<String, com.baidu.browser.core.util.e<String, Integer>> HU = new HashMap<>();

    public h(Resources resources, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        super(assetManager, displayMetrics, configuration);
        this.HY = resources;
        this.HW = new HashMap();
    }

    public int aE(int i) {
        com.baidu.browser.core.util.e<String, Integer> eVar;
        if (TextUtils.isEmpty(this.mPackageName) || this.mPackageName.equals("com.baidu.browser.theme.default")) {
            return 0;
        }
        try {
            String resourceEntryName = this.HY.getResourceEntryName(i);
            String resourceTypeName = this.HY.getResourceTypeName(i);
            com.baidu.browser.core.util.e<String, Integer> eVar2 = HU.get(resourceTypeName);
            if (eVar2 == null) {
                com.baidu.browser.core.util.e<String, Integer> eVar3 = new com.baidu.browser.core.util.e<>(100);
                HU.put(resourceTypeName, eVar3);
                eVar = eVar3;
            } else {
                eVar = eVar2;
            }
            Integer num = eVar.get(resourceEntryName);
            if (num == null) {
                num = Integer.valueOf(this.HX.getIdentifier(resourceEntryName, resourceTypeName, this.mPackageName));
                if (num.intValue() != 0) {
                    eVar.put(resourceEntryName, num);
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
        return this.HY.getConfiguration();
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i) throws Resources.NotFoundException {
        int aE = aE(i);
        return aE != 0 ? this.HX.getAnimation(aE) : this.HY.getAnimation(i);
    }

    @Override // android.content.res.Resources
    public int getColor(int i) throws Resources.NotFoundException {
        return getColor(i, null);
    }

    @Override // android.content.res.Resources
    public int getColor(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int aE = aE(i);
        return aE != 0 ? this.HX.getColor(aE) : this.HY.getColor(i);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i) throws Resources.NotFoundException {
        return getColorStateList(i, null);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int aE = aE(i);
        return aE != 0 ? this.HX.getColorStateList(aE) : this.HY.getColorStateList(i);
    }

    @Override // android.content.res.Resources
    public float getDimension(int i) throws Resources.NotFoundException {
        int aE = aE(i);
        return aE != 0 ? this.HX.getDimension(aE) : this.HY.getDimension(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i) throws Resources.NotFoundException {
        int aE = aE(i);
        return aE != 0 ? this.HX.getDimensionPixelOffset(aE) : this.HY.getDimensionPixelOffset(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i) throws Resources.NotFoundException {
        int aE = aE(i);
        return aE != 0 ? this.HX.getDimensionPixelSize(aE) : this.HY.getDimensionPixelSize(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        int aE = aE(i);
        return aE != 0 ? this.HX.getDrawable(aE) : this.HY.getDrawable(i);
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawable(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int aE = aE(i);
        return aE != 0 ? this.HX.getDrawable(aE, null) : this.HY.getDrawable(i, theme);
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public Drawable getDrawableForDensity(int i, int i2) throws Resources.NotFoundException {
        int aE = aE(i);
        return aE != 0 ? this.HX.getDrawableForDensity(aE, i2) : this.HY.getDrawableForDensity(i, i2);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i, int i2, int i3) {
        int aE = aE(i);
        return aE != 0 ? this.HX.getFraction(aE, i2, i3) : this.HY.getFraction(i, i2, i3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i) throws Resources.NotFoundException {
        int aE = aE(i);
        return aE != 0 ? this.HX.getIntArray(aE) : this.HY.getIntArray(i);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i) throws Resources.NotFoundException {
        int aE = aE(i);
        return aE != 0 ? this.HX.getInteger(aE) : this.HY.getInteger(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i) throws Resources.NotFoundException {
        int aE = aE(i);
        return aE != 0 ? this.HX.getLayout(aE) : this.HY.getLayout(i);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i) throws Resources.NotFoundException {
        int aE = aE(i);
        return aE != 0 ? this.HX.getMovie(aE) : this.HY.getMovie(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i, int i2) throws Resources.NotFoundException {
        int aE = aE(i);
        return aE != 0 ? this.HX.getQuantityText(aE, i2) : this.HY.getQuantityText(i, i2);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2) throws Resources.NotFoundException {
        int aE = aE(i);
        return aE != 0 ? this.HX.getQuantityString(aE, i2) : this.HY.getQuantityString(i, i2);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2, Object... objArr) throws Resources.NotFoundException {
        int aE = aE(i);
        return aE != 0 ? this.HX.getQuantityString(aE, i2, objArr) : this.HY.getQuantityString(i, i2, objArr);
    }

    @Override // android.content.res.Resources
    public String getString(int i) throws Resources.NotFoundException {
        int aE = aE(i);
        return aE != 0 ? this.HX.getString(aE) : this.HY.getString(i);
    }

    @Override // android.content.res.Resources
    public String getString(int i, Object... objArr) throws Resources.NotFoundException {
        int aE = aE(i);
        return aE != 0 ? this.HX.getString(aE, objArr) : this.HY.getString(i, objArr);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i) throws Resources.NotFoundException {
        int aE = aE(i);
        return aE != 0 ? this.HX.getStringArray(aE) : this.HY.getStringArray(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i) throws Resources.NotFoundException {
        int aE = aE(i);
        return aE != 0 ? this.HX.getText(aE) : this.HY.getText(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i, CharSequence charSequence) {
        int aE = aE(i);
        return aE != 0 ? this.HX.getText(aE, charSequence) : this.HY.getText(i, charSequence);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i) throws Resources.NotFoundException {
        int aE = aE(i);
        return aE != 0 ? this.HX.getTextArray(aE) : this.HY.getTextArray(i);
    }

    @Override // android.content.res.Resources
    public void getValue(int i, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int aE = aE(i);
        if (aE != 0) {
            this.HX.getValue(aE, typedValue, z);
        } else {
            this.HY.getValue(i, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int aE = aE(i);
        if (aE != 0) {
            this.HX.getValueForDensity(aE, i2, typedValue, z);
        } else {
            this.HY.getValueForDensity(i, i2, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i) throws Resources.NotFoundException {
        return this.HY.obtainTypedArray(i);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i) throws Resources.NotFoundException {
        return this.HY.getBoolean(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i) throws Resources.NotFoundException {
        return this.HY.getXml(i);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.HY.getValue(str, typedValue, z);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.HY.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i) throws Resources.NotFoundException {
        return this.HY.getResourceName(i);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i) throws Resources.NotFoundException {
        return this.HY.getResourcePackageName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i) throws Resources.NotFoundException {
        return this.HY.getResourceTypeName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i) throws Resources.NotFoundException {
        return this.HY.getResourceEntryName(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i) throws Resources.NotFoundException {
        int aE = aE(i);
        if (aE != 0 && this.HX != null) {
            try {
                InputStream openRawResource = this.HX.openRawResource(aE);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.HY.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i, TypedValue typedValue) throws Resources.NotFoundException {
        int aE = aE(i);
        if (aE != 0 && this.HX != null) {
            try {
                InputStream openRawResource = this.HX.openRawResource(aE, typedValue);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.HY.openRawResource(i, typedValue);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i) throws Resources.NotFoundException {
        int aE = aE(i);
        if (aE != 0 && this.HX != null) {
            try {
                AssetFileDescriptor openRawResourceFd = this.HX.openRawResourceFd(aE);
                if (openRawResourceFd != null) {
                    return openRawResourceFd;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.HY.openRawResourceFd(i);
    }
}

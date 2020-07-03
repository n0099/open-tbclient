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
/* loaded from: classes11.dex */
public class h extends Resources {
    private Resources acA;
    private Resources acB;
    private Map<String, String> acz;
    private String mPackageName;
    private static final String acy = Environment.getRootDirectory().toString() + File.separator + "baidu/flyflow/plugin_asset";
    private static final String TAG = h.class.getSimpleName();
    private static HashMap<String, com.baidu.browser.core.util.e<String, Integer>> acx = new HashMap<>();

    public h(Resources resources, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        super(assetManager, displayMetrics, configuration);
        this.acB = resources;
        this.acz = new HashMap();
    }

    public int ba(int i) {
        com.baidu.browser.core.util.e<String, Integer> eVar;
        if (TextUtils.isEmpty(this.mPackageName) || this.mPackageName.equals("com.baidu.browser.theme.default")) {
            return 0;
        }
        try {
            String resourceEntryName = this.acB.getResourceEntryName(i);
            String resourceTypeName = this.acB.getResourceTypeName(i);
            com.baidu.browser.core.util.e<String, Integer> eVar2 = acx.get(resourceTypeName);
            if (eVar2 == null) {
                com.baidu.browser.core.util.e<String, Integer> eVar3 = new com.baidu.browser.core.util.e<>(100);
                acx.put(resourceTypeName, eVar3);
                eVar = eVar3;
            } else {
                eVar = eVar2;
            }
            Integer num = eVar.get(resourceEntryName);
            if (num == null) {
                num = Integer.valueOf(this.acA.getIdentifier(resourceEntryName, resourceTypeName, this.mPackageName));
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
        return this.acB.getConfiguration();
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i) throws Resources.NotFoundException {
        int ba = ba(i);
        return ba != 0 ? this.acA.getAnimation(ba) : this.acB.getAnimation(i);
    }

    @Override // android.content.res.Resources
    public int getColor(int i) throws Resources.NotFoundException {
        return getColor(i, null);
    }

    @Override // android.content.res.Resources
    public int getColor(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int ba = ba(i);
        return ba != 0 ? this.acA.getColor(ba) : this.acB.getColor(i);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i) throws Resources.NotFoundException {
        return getColorStateList(i, null);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int ba = ba(i);
        return ba != 0 ? this.acA.getColorStateList(ba) : this.acB.getColorStateList(i);
    }

    @Override // android.content.res.Resources
    public float getDimension(int i) throws Resources.NotFoundException {
        int ba = ba(i);
        return ba != 0 ? this.acA.getDimension(ba) : this.acB.getDimension(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i) throws Resources.NotFoundException {
        int ba = ba(i);
        return ba != 0 ? this.acA.getDimensionPixelOffset(ba) : this.acB.getDimensionPixelOffset(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i) throws Resources.NotFoundException {
        int ba = ba(i);
        return ba != 0 ? this.acA.getDimensionPixelSize(ba) : this.acB.getDimensionPixelSize(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        int ba = ba(i);
        return ba != 0 ? this.acA.getDrawable(ba) : this.acB.getDrawable(i);
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawable(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int ba = ba(i);
        return ba != 0 ? this.acA.getDrawable(ba, null) : this.acB.getDrawable(i, theme);
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public Drawable getDrawableForDensity(int i, int i2) throws Resources.NotFoundException {
        int ba = ba(i);
        return ba != 0 ? this.acA.getDrawableForDensity(ba, i2) : this.acB.getDrawableForDensity(i, i2);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i, int i2, int i3) {
        int ba = ba(i);
        return ba != 0 ? this.acA.getFraction(ba, i2, i3) : this.acB.getFraction(i, i2, i3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i) throws Resources.NotFoundException {
        int ba = ba(i);
        return ba != 0 ? this.acA.getIntArray(ba) : this.acB.getIntArray(i);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i) throws Resources.NotFoundException {
        int ba = ba(i);
        return ba != 0 ? this.acA.getInteger(ba) : this.acB.getInteger(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i) throws Resources.NotFoundException {
        int ba = ba(i);
        return ba != 0 ? this.acA.getLayout(ba) : this.acB.getLayout(i);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i) throws Resources.NotFoundException {
        int ba = ba(i);
        return ba != 0 ? this.acA.getMovie(ba) : this.acB.getMovie(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i, int i2) throws Resources.NotFoundException {
        int ba = ba(i);
        return ba != 0 ? this.acA.getQuantityText(ba, i2) : this.acB.getQuantityText(i, i2);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2) throws Resources.NotFoundException {
        int ba = ba(i);
        return ba != 0 ? this.acA.getQuantityString(ba, i2) : this.acB.getQuantityString(i, i2);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2, Object... objArr) throws Resources.NotFoundException {
        int ba = ba(i);
        return ba != 0 ? this.acA.getQuantityString(ba, i2, objArr) : this.acB.getQuantityString(i, i2, objArr);
    }

    @Override // android.content.res.Resources
    public String getString(int i) throws Resources.NotFoundException {
        int ba = ba(i);
        return ba != 0 ? this.acA.getString(ba) : this.acB.getString(i);
    }

    @Override // android.content.res.Resources
    public String getString(int i, Object... objArr) throws Resources.NotFoundException {
        int ba = ba(i);
        return ba != 0 ? this.acA.getString(ba, objArr) : this.acB.getString(i, objArr);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i) throws Resources.NotFoundException {
        int ba = ba(i);
        return ba != 0 ? this.acA.getStringArray(ba) : this.acB.getStringArray(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i) throws Resources.NotFoundException {
        int ba = ba(i);
        return ba != 0 ? this.acA.getText(ba) : this.acB.getText(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i, CharSequence charSequence) {
        int ba = ba(i);
        return ba != 0 ? this.acA.getText(ba, charSequence) : this.acB.getText(i, charSequence);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i) throws Resources.NotFoundException {
        int ba = ba(i);
        return ba != 0 ? this.acA.getTextArray(ba) : this.acB.getTextArray(i);
    }

    @Override // android.content.res.Resources
    public void getValue(int i, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int ba = ba(i);
        if (ba != 0) {
            this.acA.getValue(ba, typedValue, z);
        } else {
            this.acB.getValue(i, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int ba = ba(i);
        if (ba != 0) {
            this.acA.getValueForDensity(ba, i2, typedValue, z);
        } else {
            this.acB.getValueForDensity(i, i2, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i) throws Resources.NotFoundException {
        return this.acB.obtainTypedArray(i);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i) throws Resources.NotFoundException {
        return this.acB.getBoolean(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i) throws Resources.NotFoundException {
        return this.acB.getXml(i);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.acB.getValue(str, typedValue, z);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.acB.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i) throws Resources.NotFoundException {
        return this.acB.getResourceName(i);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i) throws Resources.NotFoundException {
        return this.acB.getResourcePackageName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i) throws Resources.NotFoundException {
        return this.acB.getResourceTypeName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i) throws Resources.NotFoundException {
        return this.acB.getResourceEntryName(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i) throws Resources.NotFoundException {
        int ba = ba(i);
        if (ba != 0 && this.acA != null) {
            try {
                InputStream openRawResource = this.acA.openRawResource(ba);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.acB.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i, TypedValue typedValue) throws Resources.NotFoundException {
        int ba = ba(i);
        if (ba != 0 && this.acA != null) {
            try {
                InputStream openRawResource = this.acA.openRawResource(ba, typedValue);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.acB.openRawResource(i, typedValue);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i) throws Resources.NotFoundException {
        int ba = ba(i);
        if (ba != 0 && this.acA != null) {
            try {
                AssetFileDescriptor openRawResourceFd = this.acA.openRawResourceFd(ba);
                if (openRawResourceFd != null) {
                    return openRawResourceFd;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.acB.openRawResourceFd(i);
    }
}

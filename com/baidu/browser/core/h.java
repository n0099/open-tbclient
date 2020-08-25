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
/* loaded from: classes19.dex */
public class h extends Resources {
    private Map<String, String> adZ;
    private Resources aea;
    private Resources aeb;
    private String mPackageName;
    private static final String adY = Environment.getRootDirectory().toString() + File.separator + "baidu/flyflow/plugin_asset";
    private static final String TAG = h.class.getSimpleName();
    private static HashMap<String, com.baidu.browser.core.util.e<String, Integer>> adX = new HashMap<>();

    public h(Resources resources, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        super(assetManager, displayMetrics, configuration);
        this.aeb = resources;
        this.adZ = new HashMap();
    }

    public int bh(int i) {
        com.baidu.browser.core.util.e<String, Integer> eVar;
        if (TextUtils.isEmpty(this.mPackageName) || this.mPackageName.equals("com.baidu.browser.theme.default")) {
            return 0;
        }
        try {
            String resourceEntryName = this.aeb.getResourceEntryName(i);
            String resourceTypeName = this.aeb.getResourceTypeName(i);
            com.baidu.browser.core.util.e<String, Integer> eVar2 = adX.get(resourceTypeName);
            if (eVar2 == null) {
                com.baidu.browser.core.util.e<String, Integer> eVar3 = new com.baidu.browser.core.util.e<>(100);
                adX.put(resourceTypeName, eVar3);
                eVar = eVar3;
            } else {
                eVar = eVar2;
            }
            Integer num = eVar.get(resourceEntryName);
            if (num == null) {
                num = Integer.valueOf(this.aea.getIdentifier(resourceEntryName, resourceTypeName, this.mPackageName));
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
        return this.aeb.getConfiguration();
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i) throws Resources.NotFoundException {
        int bh = bh(i);
        return bh != 0 ? this.aea.getAnimation(bh) : this.aeb.getAnimation(i);
    }

    @Override // android.content.res.Resources
    public int getColor(int i) throws Resources.NotFoundException {
        return getColor(i, null);
    }

    @Override // android.content.res.Resources
    public int getColor(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int bh = bh(i);
        return bh != 0 ? this.aea.getColor(bh) : this.aeb.getColor(i);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i) throws Resources.NotFoundException {
        return getColorStateList(i, null);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int bh = bh(i);
        return bh != 0 ? this.aea.getColorStateList(bh) : this.aeb.getColorStateList(i);
    }

    @Override // android.content.res.Resources
    public float getDimension(int i) throws Resources.NotFoundException {
        int bh = bh(i);
        return bh != 0 ? this.aea.getDimension(bh) : this.aeb.getDimension(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i) throws Resources.NotFoundException {
        int bh = bh(i);
        return bh != 0 ? this.aea.getDimensionPixelOffset(bh) : this.aeb.getDimensionPixelOffset(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i) throws Resources.NotFoundException {
        int bh = bh(i);
        return bh != 0 ? this.aea.getDimensionPixelSize(bh) : this.aeb.getDimensionPixelSize(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        int bh = bh(i);
        return bh != 0 ? this.aea.getDrawable(bh) : this.aeb.getDrawable(i);
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawable(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int bh = bh(i);
        return bh != 0 ? this.aea.getDrawable(bh, null) : this.aeb.getDrawable(i, theme);
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public Drawable getDrawableForDensity(int i, int i2) throws Resources.NotFoundException {
        int bh = bh(i);
        return bh != 0 ? this.aea.getDrawableForDensity(bh, i2) : this.aeb.getDrawableForDensity(i, i2);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i, int i2, int i3) {
        int bh = bh(i);
        return bh != 0 ? this.aea.getFraction(bh, i2, i3) : this.aeb.getFraction(i, i2, i3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i) throws Resources.NotFoundException {
        int bh = bh(i);
        return bh != 0 ? this.aea.getIntArray(bh) : this.aeb.getIntArray(i);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i) throws Resources.NotFoundException {
        int bh = bh(i);
        return bh != 0 ? this.aea.getInteger(bh) : this.aeb.getInteger(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i) throws Resources.NotFoundException {
        int bh = bh(i);
        return bh != 0 ? this.aea.getLayout(bh) : this.aeb.getLayout(i);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i) throws Resources.NotFoundException {
        int bh = bh(i);
        return bh != 0 ? this.aea.getMovie(bh) : this.aeb.getMovie(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i, int i2) throws Resources.NotFoundException {
        int bh = bh(i);
        return bh != 0 ? this.aea.getQuantityText(bh, i2) : this.aeb.getQuantityText(i, i2);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2) throws Resources.NotFoundException {
        int bh = bh(i);
        return bh != 0 ? this.aea.getQuantityString(bh, i2) : this.aeb.getQuantityString(i, i2);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2, Object... objArr) throws Resources.NotFoundException {
        int bh = bh(i);
        return bh != 0 ? this.aea.getQuantityString(bh, i2, objArr) : this.aeb.getQuantityString(i, i2, objArr);
    }

    @Override // android.content.res.Resources
    public String getString(int i) throws Resources.NotFoundException {
        int bh = bh(i);
        return bh != 0 ? this.aea.getString(bh) : this.aeb.getString(i);
    }

    @Override // android.content.res.Resources
    public String getString(int i, Object... objArr) throws Resources.NotFoundException {
        int bh = bh(i);
        return bh != 0 ? this.aea.getString(bh, objArr) : this.aeb.getString(i, objArr);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i) throws Resources.NotFoundException {
        int bh = bh(i);
        return bh != 0 ? this.aea.getStringArray(bh) : this.aeb.getStringArray(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i) throws Resources.NotFoundException {
        int bh = bh(i);
        return bh != 0 ? this.aea.getText(bh) : this.aeb.getText(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i, CharSequence charSequence) {
        int bh = bh(i);
        return bh != 0 ? this.aea.getText(bh, charSequence) : this.aeb.getText(i, charSequence);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i) throws Resources.NotFoundException {
        int bh = bh(i);
        return bh != 0 ? this.aea.getTextArray(bh) : this.aeb.getTextArray(i);
    }

    @Override // android.content.res.Resources
    public void getValue(int i, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int bh = bh(i);
        if (bh != 0) {
            this.aea.getValue(bh, typedValue, z);
        } else {
            this.aeb.getValue(i, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int bh = bh(i);
        if (bh != 0) {
            this.aea.getValueForDensity(bh, i2, typedValue, z);
        } else {
            this.aeb.getValueForDensity(i, i2, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i) throws Resources.NotFoundException {
        return this.aeb.obtainTypedArray(i);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i) throws Resources.NotFoundException {
        return this.aeb.getBoolean(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i) throws Resources.NotFoundException {
        return this.aeb.getXml(i);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.aeb.getValue(str, typedValue, z);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.aeb.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i) throws Resources.NotFoundException {
        return this.aeb.getResourceName(i);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i) throws Resources.NotFoundException {
        return this.aeb.getResourcePackageName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i) throws Resources.NotFoundException {
        return this.aeb.getResourceTypeName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i) throws Resources.NotFoundException {
        return this.aeb.getResourceEntryName(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i) throws Resources.NotFoundException {
        int bh = bh(i);
        if (bh != 0 && this.aea != null) {
            try {
                InputStream openRawResource = this.aea.openRawResource(bh);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.aeb.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i, TypedValue typedValue) throws Resources.NotFoundException {
        int bh = bh(i);
        if (bh != 0 && this.aea != null) {
            try {
                InputStream openRawResource = this.aea.openRawResource(bh, typedValue);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.aeb.openRawResource(i, typedValue);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i) throws Resources.NotFoundException {
        int bh = bh(i);
        if (bh != 0 && this.aea != null) {
            try {
                AssetFileDescriptor openRawResourceFd = this.aea.openRawResourceFd(bh);
                if (openRawResourceFd != null) {
                    return openRawResourceFd;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.aeb.openRawResourceFd(i);
    }
}

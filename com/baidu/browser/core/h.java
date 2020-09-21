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
    private Map<String, String> aet;
    private Resources aeu;
    private Resources aev;
    private String mPackageName;
    private static final String aes = Environment.getRootDirectory().toString() + File.separator + "baidu/flyflow/plugin_asset";
    private static final String TAG = h.class.getSimpleName();
    private static HashMap<String, com.baidu.browser.core.util.e<String, Integer>> aer = new HashMap<>();

    public h(Resources resources, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        super(assetManager, displayMetrics, configuration);
        this.aev = resources;
        this.aet = new HashMap();
    }

    public int bl(int i) {
        com.baidu.browser.core.util.e<String, Integer> eVar;
        if (TextUtils.isEmpty(this.mPackageName) || this.mPackageName.equals("com.baidu.browser.theme.default")) {
            return 0;
        }
        try {
            String resourceEntryName = this.aev.getResourceEntryName(i);
            String resourceTypeName = this.aev.getResourceTypeName(i);
            com.baidu.browser.core.util.e<String, Integer> eVar2 = aer.get(resourceTypeName);
            if (eVar2 == null) {
                com.baidu.browser.core.util.e<String, Integer> eVar3 = new com.baidu.browser.core.util.e<>(100);
                aer.put(resourceTypeName, eVar3);
                eVar = eVar3;
            } else {
                eVar = eVar2;
            }
            Integer num = eVar.get(resourceEntryName);
            if (num == null) {
                num = Integer.valueOf(this.aeu.getIdentifier(resourceEntryName, resourceTypeName, this.mPackageName));
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
        return this.aev.getConfiguration();
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getAnimation(bl) : this.aev.getAnimation(i);
    }

    @Override // android.content.res.Resources
    public int getColor(int i) throws Resources.NotFoundException {
        return getColor(i, null);
    }

    @Override // android.content.res.Resources
    public int getColor(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getColor(bl) : this.aev.getColor(i);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i) throws Resources.NotFoundException {
        return getColorStateList(i, null);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getColorStateList(bl) : this.aev.getColorStateList(i);
    }

    @Override // android.content.res.Resources
    public float getDimension(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getDimension(bl) : this.aev.getDimension(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getDimensionPixelOffset(bl) : this.aev.getDimensionPixelOffset(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getDimensionPixelSize(bl) : this.aev.getDimensionPixelSize(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getDrawable(bl) : this.aev.getDrawable(i);
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawable(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getDrawable(bl, null) : this.aev.getDrawable(i, theme);
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public Drawable getDrawableForDensity(int i, int i2) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getDrawableForDensity(bl, i2) : this.aev.getDrawableForDensity(i, i2);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i, int i2, int i3) {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getFraction(bl, i2, i3) : this.aev.getFraction(i, i2, i3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getIntArray(bl) : this.aev.getIntArray(i);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getInteger(bl) : this.aev.getInteger(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getLayout(bl) : this.aev.getLayout(i);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getMovie(bl) : this.aev.getMovie(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i, int i2) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getQuantityText(bl, i2) : this.aev.getQuantityText(i, i2);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getQuantityString(bl, i2) : this.aev.getQuantityString(i, i2);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2, Object... objArr) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getQuantityString(bl, i2, objArr) : this.aev.getQuantityString(i, i2, objArr);
    }

    @Override // android.content.res.Resources
    public String getString(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getString(bl) : this.aev.getString(i);
    }

    @Override // android.content.res.Resources
    public String getString(int i, Object... objArr) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getString(bl, objArr) : this.aev.getString(i, objArr);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getStringArray(bl) : this.aev.getStringArray(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getText(bl) : this.aev.getText(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i, CharSequence charSequence) {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getText(bl, charSequence) : this.aev.getText(i, charSequence);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.aeu.getTextArray(bl) : this.aev.getTextArray(i);
    }

    @Override // android.content.res.Resources
    public void getValue(int i, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int bl = bl(i);
        if (bl != 0) {
            this.aeu.getValue(bl, typedValue, z);
        } else {
            this.aev.getValue(i, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int bl = bl(i);
        if (bl != 0) {
            this.aeu.getValueForDensity(bl, i2, typedValue, z);
        } else {
            this.aev.getValueForDensity(i, i2, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i) throws Resources.NotFoundException {
        return this.aev.obtainTypedArray(i);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i) throws Resources.NotFoundException {
        return this.aev.getBoolean(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i) throws Resources.NotFoundException {
        return this.aev.getXml(i);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.aev.getValue(str, typedValue, z);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.aev.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i) throws Resources.NotFoundException {
        return this.aev.getResourceName(i);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i) throws Resources.NotFoundException {
        return this.aev.getResourcePackageName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i) throws Resources.NotFoundException {
        return this.aev.getResourceTypeName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i) throws Resources.NotFoundException {
        return this.aev.getResourceEntryName(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        if (bl != 0 && this.aeu != null) {
            try {
                InputStream openRawResource = this.aeu.openRawResource(bl);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.aev.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i, TypedValue typedValue) throws Resources.NotFoundException {
        int bl = bl(i);
        if (bl != 0 && this.aeu != null) {
            try {
                InputStream openRawResource = this.aeu.openRawResource(bl, typedValue);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.aev.openRawResource(i, typedValue);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        if (bl != 0 && this.aeu != null) {
            try {
                AssetFileDescriptor openRawResourceFd = this.aeu.openRawResourceFd(bl);
                if (openRawResourceFd != null) {
                    return openRawResourceFd;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.aev.openRawResourceFd(i);
    }
}

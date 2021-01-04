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
/* loaded from: classes4.dex */
public class h extends Resources {
    private Map<String, String> agp;
    private Resources agq;
    private Resources agr;
    private String mPackageName;
    private static final String ago = Environment.getRootDirectory().toString() + File.separator + "baidu/flyflow/plugin_asset";
    private static final String TAG = h.class.getSimpleName();
    private static HashMap<String, com.baidu.browser.core.util.e<String, Integer>> agn = new HashMap<>();

    public h(Resources resources, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        super(assetManager, displayMetrics, configuration);
        this.agr = resources;
        this.agp = new HashMap();
    }

    public int bp(int i) {
        com.baidu.browser.core.util.e<String, Integer> eVar;
        if (TextUtils.isEmpty(this.mPackageName) || this.mPackageName.equals("com.baidu.browser.theme.default")) {
            return 0;
        }
        try {
            String resourceEntryName = this.agr.getResourceEntryName(i);
            String resourceTypeName = this.agr.getResourceTypeName(i);
            com.baidu.browser.core.util.e<String, Integer> eVar2 = agn.get(resourceTypeName);
            if (eVar2 == null) {
                com.baidu.browser.core.util.e<String, Integer> eVar3 = new com.baidu.browser.core.util.e<>(100);
                agn.put(resourceTypeName, eVar3);
                eVar = eVar3;
            } else {
                eVar = eVar2;
            }
            Integer num = eVar.get(resourceEntryName);
            if (num == null) {
                num = Integer.valueOf(this.agq.getIdentifier(resourceEntryName, resourceTypeName, this.mPackageName));
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
        return this.agr.getConfiguration();
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i) throws Resources.NotFoundException {
        int bp = bp(i);
        return bp != 0 ? this.agq.getAnimation(bp) : this.agr.getAnimation(i);
    }

    @Override // android.content.res.Resources
    public int getColor(int i) throws Resources.NotFoundException {
        return getColor(i, null);
    }

    @Override // android.content.res.Resources
    public int getColor(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int bp = bp(i);
        return bp != 0 ? this.agq.getColor(bp) : this.agr.getColor(i);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i) throws Resources.NotFoundException {
        return getColorStateList(i, null);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int bp = bp(i);
        return bp != 0 ? this.agq.getColorStateList(bp) : this.agr.getColorStateList(i);
    }

    @Override // android.content.res.Resources
    public float getDimension(int i) throws Resources.NotFoundException {
        int bp = bp(i);
        return bp != 0 ? this.agq.getDimension(bp) : this.agr.getDimension(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i) throws Resources.NotFoundException {
        int bp = bp(i);
        return bp != 0 ? this.agq.getDimensionPixelOffset(bp) : this.agr.getDimensionPixelOffset(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i) throws Resources.NotFoundException {
        int bp = bp(i);
        return bp != 0 ? this.agq.getDimensionPixelSize(bp) : this.agr.getDimensionPixelSize(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        int bp = bp(i);
        return bp != 0 ? this.agq.getDrawable(bp) : this.agr.getDrawable(i);
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawable(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int bp = bp(i);
        return bp != 0 ? this.agq.getDrawable(bp, null) : this.agr.getDrawable(i, theme);
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public Drawable getDrawableForDensity(int i, int i2) throws Resources.NotFoundException {
        int bp = bp(i);
        return bp != 0 ? this.agq.getDrawableForDensity(bp, i2) : this.agr.getDrawableForDensity(i, i2);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i, int i2, int i3) {
        int bp = bp(i);
        return bp != 0 ? this.agq.getFraction(bp, i2, i3) : this.agr.getFraction(i, i2, i3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i) throws Resources.NotFoundException {
        int bp = bp(i);
        return bp != 0 ? this.agq.getIntArray(bp) : this.agr.getIntArray(i);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i) throws Resources.NotFoundException {
        int bp = bp(i);
        return bp != 0 ? this.agq.getInteger(bp) : this.agr.getInteger(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i) throws Resources.NotFoundException {
        int bp = bp(i);
        return bp != 0 ? this.agq.getLayout(bp) : this.agr.getLayout(i);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i) throws Resources.NotFoundException {
        int bp = bp(i);
        return bp != 0 ? this.agq.getMovie(bp) : this.agr.getMovie(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i, int i2) throws Resources.NotFoundException {
        int bp = bp(i);
        return bp != 0 ? this.agq.getQuantityText(bp, i2) : this.agr.getQuantityText(i, i2);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2) throws Resources.NotFoundException {
        int bp = bp(i);
        return bp != 0 ? this.agq.getQuantityString(bp, i2) : this.agr.getQuantityString(i, i2);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2, Object... objArr) throws Resources.NotFoundException {
        int bp = bp(i);
        return bp != 0 ? this.agq.getQuantityString(bp, i2, objArr) : this.agr.getQuantityString(i, i2, objArr);
    }

    @Override // android.content.res.Resources
    public String getString(int i) throws Resources.NotFoundException {
        int bp = bp(i);
        return bp != 0 ? this.agq.getString(bp) : this.agr.getString(i);
    }

    @Override // android.content.res.Resources
    public String getString(int i, Object... objArr) throws Resources.NotFoundException {
        int bp = bp(i);
        return bp != 0 ? this.agq.getString(bp, objArr) : this.agr.getString(i, objArr);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i) throws Resources.NotFoundException {
        int bp = bp(i);
        return bp != 0 ? this.agq.getStringArray(bp) : this.agr.getStringArray(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i) throws Resources.NotFoundException {
        int bp = bp(i);
        return bp != 0 ? this.agq.getText(bp) : this.agr.getText(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i, CharSequence charSequence) {
        int bp = bp(i);
        return bp != 0 ? this.agq.getText(bp, charSequence) : this.agr.getText(i, charSequence);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i) throws Resources.NotFoundException {
        int bp = bp(i);
        return bp != 0 ? this.agq.getTextArray(bp) : this.agr.getTextArray(i);
    }

    @Override // android.content.res.Resources
    public void getValue(int i, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int bp = bp(i);
        if (bp != 0) {
            this.agq.getValue(bp, typedValue, z);
        } else {
            this.agr.getValue(i, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int bp = bp(i);
        if (bp != 0) {
            this.agq.getValueForDensity(bp, i2, typedValue, z);
        } else {
            this.agr.getValueForDensity(i, i2, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i) throws Resources.NotFoundException {
        return this.agr.obtainTypedArray(i);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i) throws Resources.NotFoundException {
        return this.agr.getBoolean(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i) throws Resources.NotFoundException {
        return this.agr.getXml(i);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.agr.getValue(str, typedValue, z);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.agr.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i) throws Resources.NotFoundException {
        return this.agr.getResourceName(i);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i) throws Resources.NotFoundException {
        return this.agr.getResourcePackageName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i) throws Resources.NotFoundException {
        return this.agr.getResourceTypeName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i) throws Resources.NotFoundException {
        return this.agr.getResourceEntryName(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i) throws Resources.NotFoundException {
        int bp = bp(i);
        if (bp != 0 && this.agq != null) {
            try {
                InputStream openRawResource = this.agq.openRawResource(bp);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.agr.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i, TypedValue typedValue) throws Resources.NotFoundException {
        int bp = bp(i);
        if (bp != 0 && this.agq != null) {
            try {
                InputStream openRawResource = this.agq.openRawResource(bp, typedValue);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.agr.openRawResource(i, typedValue);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i) throws Resources.NotFoundException {
        int bp = bp(i);
        if (bp != 0 && this.agq != null) {
            try {
                AssetFileDescriptor openRawResourceFd = this.agq.openRawResourceFd(bp);
                if (openRawResourceFd != null) {
                    return openRawResourceFd;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.agr.openRawResourceFd(i);
    }
}

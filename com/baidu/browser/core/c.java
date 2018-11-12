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
    private Map<String, String> UN;
    private Resources UO;
    private Resources UQ;
    private String mPackageName;
    private static final String UM = Environment.getRootDirectory().toString() + File.separator + "baidu/flyflow/plugin_asset";
    private static final String TAG = c.class.getSimpleName();
    private static HashMap<String, com.baidu.browser.core.util.c<String, Integer>> UL = new HashMap<>();

    public c(Resources resources, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        super(assetManager, displayMetrics, configuration);
        this.UQ = resources;
        this.UN = new HashMap();
    }

    public int bA(int i) {
        com.baidu.browser.core.util.c<String, Integer> cVar;
        if (TextUtils.isEmpty(this.mPackageName) || this.mPackageName.equals("com.baidu.browser.theme.default")) {
            return 0;
        }
        try {
            String resourceEntryName = this.UQ.getResourceEntryName(i);
            String resourceTypeName = this.UQ.getResourceTypeName(i);
            com.baidu.browser.core.util.c<String, Integer> cVar2 = UL.get(resourceTypeName);
            if (cVar2 == null) {
                com.baidu.browser.core.util.c<String, Integer> cVar3 = new com.baidu.browser.core.util.c<>(100);
                UL.put(resourceTypeName, cVar3);
                cVar = cVar3;
            } else {
                cVar = cVar2;
            }
            Integer num = cVar.get(resourceEntryName);
            if (num == null) {
                num = Integer.valueOf(this.UO.getIdentifier(resourceEntryName, resourceTypeName, this.mPackageName));
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
        return this.UQ.getConfiguration();
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UO.getAnimation(bA) : this.UQ.getAnimation(i);
    }

    @Override // android.content.res.Resources
    public int getColor(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UO.getColor(bA) : this.UQ.getColor(i);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UO.getColorStateList(bA) : this.UQ.getColorStateList(i);
    }

    @Override // android.content.res.Resources
    public float getDimension(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UO.getDimension(bA) : this.UQ.getDimension(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UO.getDimensionPixelOffset(bA) : this.UQ.getDimensionPixelOffset(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UO.getDimensionPixelSize(bA) : this.UQ.getDimensionPixelSize(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UO.getDrawable(bA) : this.UQ.getDrawable(i);
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawable(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UO.getDrawable(bA, null) : this.UQ.getDrawable(i, theme);
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public Drawable getDrawableForDensity(int i, int i2) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UO.getDrawableForDensity(bA, i2) : this.UQ.getDrawableForDensity(i, i2);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i, int i2, int i3) {
        int bA = bA(i);
        return bA != 0 ? this.UO.getFraction(bA, i2, i3) : this.UQ.getFraction(i, i2, i3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UO.getIntArray(bA) : this.UQ.getIntArray(i);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UO.getInteger(bA) : this.UQ.getInteger(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UO.getLayout(bA) : this.UQ.getLayout(i);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UO.getMovie(bA) : this.UQ.getMovie(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i, int i2) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UO.getQuantityText(bA, i2) : this.UQ.getQuantityText(i, i2);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UO.getQuantityString(bA, i2) : this.UQ.getQuantityString(i, i2);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2, Object... objArr) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UO.getQuantityString(bA, i2, objArr) : this.UQ.getQuantityString(i, i2, objArr);
    }

    @Override // android.content.res.Resources
    public String getString(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UO.getString(bA) : this.UQ.getString(i);
    }

    @Override // android.content.res.Resources
    public String getString(int i, Object... objArr) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UO.getString(bA, objArr) : this.UQ.getString(i, objArr);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UO.getStringArray(bA) : this.UQ.getStringArray(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UO.getText(bA) : this.UQ.getText(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i, CharSequence charSequence) {
        int bA = bA(i);
        return bA != 0 ? this.UO.getText(bA, charSequence) : this.UQ.getText(i, charSequence);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        return bA != 0 ? this.UO.getTextArray(bA) : this.UQ.getTextArray(i);
    }

    @Override // android.content.res.Resources
    public void getValue(int i, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int bA = bA(i);
        if (bA != 0) {
            this.UO.getValue(bA, typedValue, z);
        } else {
            this.UQ.getValue(i, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int bA = bA(i);
        if (bA != 0) {
            this.UO.getValueForDensity(bA, i2, typedValue, z);
        } else {
            this.UQ.getValueForDensity(i, i2, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i) throws Resources.NotFoundException {
        return this.UQ.obtainTypedArray(i);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i) throws Resources.NotFoundException {
        return this.UQ.getBoolean(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i) throws Resources.NotFoundException {
        return this.UQ.getXml(i);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.UQ.getValue(str, typedValue, z);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.UQ.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i) throws Resources.NotFoundException {
        return this.UQ.getResourceName(i);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i) throws Resources.NotFoundException {
        return this.UQ.getResourcePackageName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i) throws Resources.NotFoundException {
        return this.UQ.getResourceTypeName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i) throws Resources.NotFoundException {
        return this.UQ.getResourceEntryName(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        if (bA != 0 && this.UO != null) {
            try {
                InputStream openRawResource = this.UO.openRawResource(bA);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.UQ.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i, TypedValue typedValue) throws Resources.NotFoundException {
        int bA = bA(i);
        if (bA != 0 && this.UO != null) {
            try {
                InputStream openRawResource = this.UO.openRawResource(bA, typedValue);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.UQ.openRawResource(i, typedValue);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i) throws Resources.NotFoundException {
        int bA = bA(i);
        if (bA != 0 && this.UO != null) {
            try {
                AssetFileDescriptor openRawResourceFd = this.UO.openRawResourceFd(bA);
                if (openRawResourceFd != null) {
                    return openRawResourceFd;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.UQ.openRawResourceFd(i);
    }
}

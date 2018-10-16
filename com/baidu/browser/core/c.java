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
    private Map<String, String> UL;
    private Resources UM;
    private Resources UN;
    private String mPackageName;
    private static final String UK = Environment.getRootDirectory().toString() + File.separator + "baidu/flyflow/plugin_asset";
    private static final String TAG = c.class.getSimpleName();
    private static HashMap<String, com.baidu.browser.core.util.c<String, Integer>> UJ = new HashMap<>();

    public c(Resources resources, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        super(assetManager, displayMetrics, configuration);
        this.UN = resources;
        this.UL = new HashMap();
    }

    public int bl(int i) {
        com.baidu.browser.core.util.c<String, Integer> cVar;
        if (TextUtils.isEmpty(this.mPackageName) || this.mPackageName.equals("com.baidu.browser.theme.default")) {
            return 0;
        }
        try {
            String resourceEntryName = this.UN.getResourceEntryName(i);
            String resourceTypeName = this.UN.getResourceTypeName(i);
            com.baidu.browser.core.util.c<String, Integer> cVar2 = UJ.get(resourceTypeName);
            if (cVar2 == null) {
                com.baidu.browser.core.util.c<String, Integer> cVar3 = new com.baidu.browser.core.util.c<>(100);
                UJ.put(resourceTypeName, cVar3);
                cVar = cVar3;
            } else {
                cVar = cVar2;
            }
            Integer num = cVar.get(resourceEntryName);
            if (num == null) {
                num = Integer.valueOf(this.UM.getIdentifier(resourceEntryName, resourceTypeName, this.mPackageName));
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
        return this.UN.getConfiguration();
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.UM.getAnimation(bl) : this.UN.getAnimation(i);
    }

    @Override // android.content.res.Resources
    public int getColor(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.UM.getColor(bl) : this.UN.getColor(i);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.UM.getColorStateList(bl) : this.UN.getColorStateList(i);
    }

    @Override // android.content.res.Resources
    public float getDimension(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.UM.getDimension(bl) : this.UN.getDimension(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.UM.getDimensionPixelOffset(bl) : this.UN.getDimensionPixelOffset(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.UM.getDimensionPixelSize(bl) : this.UN.getDimensionPixelSize(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.UM.getDrawable(bl) : this.UN.getDrawable(i);
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public Drawable getDrawable(int i, Resources.Theme theme) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.UM.getDrawable(bl, null) : this.UN.getDrawable(i, theme);
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public Drawable getDrawableForDensity(int i, int i2) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.UM.getDrawableForDensity(bl, i2) : this.UN.getDrawableForDensity(i, i2);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i, int i2, int i3) {
        int bl = bl(i);
        return bl != 0 ? this.UM.getFraction(bl, i2, i3) : this.UN.getFraction(i, i2, i3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.UM.getIntArray(bl) : this.UN.getIntArray(i);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.UM.getInteger(bl) : this.UN.getInteger(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.UM.getLayout(bl) : this.UN.getLayout(i);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.UM.getMovie(bl) : this.UN.getMovie(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i, int i2) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.UM.getQuantityText(bl, i2) : this.UN.getQuantityText(i, i2);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.UM.getQuantityString(bl, i2) : this.UN.getQuantityString(i, i2);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2, Object... objArr) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.UM.getQuantityString(bl, i2, objArr) : this.UN.getQuantityString(i, i2, objArr);
    }

    @Override // android.content.res.Resources
    public String getString(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.UM.getString(bl) : this.UN.getString(i);
    }

    @Override // android.content.res.Resources
    public String getString(int i, Object... objArr) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.UM.getString(bl, objArr) : this.UN.getString(i, objArr);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.UM.getStringArray(bl) : this.UN.getStringArray(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.UM.getText(bl) : this.UN.getText(i);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i, CharSequence charSequence) {
        int bl = bl(i);
        return bl != 0 ? this.UM.getText(bl, charSequence) : this.UN.getText(i, charSequence);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        return bl != 0 ? this.UM.getTextArray(bl) : this.UN.getTextArray(i);
    }

    @Override // android.content.res.Resources
    public void getValue(int i, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int bl = bl(i);
        if (bl != 0) {
            this.UM.getValue(bl, typedValue, z);
        } else {
            this.UN.getValue(i, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    @TargetApi(15)
    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        int bl = bl(i);
        if (bl != 0) {
            this.UM.getValueForDensity(bl, i2, typedValue, z);
        } else {
            this.UN.getValueForDensity(i, i2, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i) throws Resources.NotFoundException {
        return this.UN.obtainTypedArray(i);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i) throws Resources.NotFoundException {
        return this.UN.getBoolean(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i) throws Resources.NotFoundException {
        return this.UN.getXml(i);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.UN.getValue(str, typedValue, z);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.UN.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i) throws Resources.NotFoundException {
        return this.UN.getResourceName(i);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i) throws Resources.NotFoundException {
        return this.UN.getResourcePackageName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i) throws Resources.NotFoundException {
        return this.UN.getResourceTypeName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i) throws Resources.NotFoundException {
        return this.UN.getResourceEntryName(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        if (bl != 0 && this.UM != null) {
            try {
                InputStream openRawResource = this.UM.openRawResource(bl);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.UN.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i, TypedValue typedValue) throws Resources.NotFoundException {
        int bl = bl(i);
        if (bl != 0 && this.UM != null) {
            try {
                InputStream openRawResource = this.UM.openRawResource(bl, typedValue);
                if (openRawResource != null) {
                    return openRawResource;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.UN.openRawResource(i, typedValue);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i) throws Resources.NotFoundException {
        int bl = bl(i);
        if (bl != 0 && this.UM != null) {
            try {
                AssetFileDescriptor openRawResourceFd = this.UM.openRawResourceFd(bl);
                if (openRawResourceFd != null) {
                    return openRawResourceFd;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.UN.openRawResourceFd(i);
    }
}

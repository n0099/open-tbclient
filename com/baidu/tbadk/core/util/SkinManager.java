package com.baidu.tbadk.core.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.content.res.AppCompatResources;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import d.b.c.a.b;
import d.b.c.e.p.l;
import d.b.i0.r.u.a;
import d.b.j0.d3.c;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class SkinManager {
    public static final int IMAGE_COVER_COLOR = 1275068416;
    public static final String PLUGIN_NIGHT_RESOURCE = "com.baidu.tieba.pluginResource";
    public static final int PRIOROTY_BEFORE_CHANGE_SKIN = -1;
    public static final float RESOURCE_ALPHA_DISABLE;
    public static final float RESOURCE_ALPHA_PRESS;
    public static final int SKIN_TYPE_DARK = 4;
    public static final int SKIN_TYPE_NIGHT = 1;
    public static final int SKIN_TYPE_NONE = 3;
    public static final int SKIN_TYPE_NORMAL = 0;
    public static final String SKIN_TYPE_STR_DARK = "dark";
    public static final String SKIN_TYPE_STR_NIGHT = "night";
    public static final String SKIN_TYPE_STR_NORMAL = "default";
    public static final int SKIN_TYPE_THEME = 2;
    public static final String THEME_ICON_COLOR_VALUE = "icon_color";
    public static final String THEME_ICON_COVER_VALUE = "icon_cover_maintab";
    public static String TYPE_ERROR = null;
    public static AssetManager am = null;
    public static final String darkSuffix = "_2";
    public static String mPluginPackage = null;
    public static Resources mPluginRes = null;
    public static String mSkinPackageName = null;
    public static Resources mSkinRes = null;
    public static final String nightSufix = "_1";
    public static SparseIntArray sDarkResourceIdMap;
    public static SparseIntArray sNightResourceIdMap;
    public static String sPackagename;
    public static int sPacknameLength;

    /* loaded from: classes3.dex */
    public static final class ViewType {
        public static final int BUTTON = 3;
        public static final int CHECKBOX = 4;
        public static final int EDITTEXT = 2;
        public static final int TEXTVIEW = 1;
    }

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005017) { // from class: com.baidu.tbadk.core.util.SkinManager.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SkinManager.mPluginRes = null;
            }
        });
        RESOURCE_ALPHA_PRESS = a.a(R.string.A_X07);
        RESOURCE_ALPHA_DISABLE = a.a(R.string.A_X09);
        TYPE_ERROR = "skinType not support";
        sPackagename = null;
        sPacknameLength = 0;
        sNightResourceIdMap = new SparseIntArray();
        sDarkResourceIdMap = new SparseIntArray();
    }

    public static ColorStateList createCheckedColorStateList(int i, int i2, int i3, int i4) {
        if (i == 0 || i2 == 0 || i3 == 0) {
            return null;
        }
        return new ColorStateList(new int[][]{new int[]{16842912}, new int[]{-16842910}, new int[0]}, new int[]{getColor(i4, i2), c.a(getColor(i4, i3), RESOURCE_ALPHA_DISABLE), getColor(i4, i)});
    }

    public static ColorStateList createColorStateList(int i, int i2, int i3) {
        if (i == 0 || i2 == 0) {
            return null;
        }
        int color = getColor(i3, i);
        int color2 = getColor(i3, i2);
        return new ColorStateList(new int[][]{new int[]{16842910, 16842919}, new int[]{16842910, 16842908}, new int[0]}, new int[]{color2, color2, color});
    }

    public static GradientDrawable createShapeDrawable(int i, int i2, int i3, int i4, int i5) {
        if (i2 == 0) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(getColor(i5, i2));
        if (i > 0) {
            gradientDrawable.setCornerRadius(i);
        }
        if (i3 != 0 && i4 > 0) {
            gradientDrawable.setStroke(i4, getColor(i5, i3));
        }
        return gradientDrawable;
    }

    public static GradientDrawable createShapeDrawableFromColor(int i, int i2, String str, int i3, int i4) {
        if (i2 == 0) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(getColor(i4, i2));
        if (i > 0) {
            gradientDrawable.setCornerRadius(i);
        }
        if (i3 > 0) {
            gradientDrawable.setStroke(i3, Color.parseColor("#80" + str));
        }
        return gradientDrawable;
    }

    public static ShapeDrawable createShapeDrawableWithShadow(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (i2 == 0) {
            return null;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        int max = i6 != 0 ? Math.max(Math.abs(i4), Math.abs(i5)) + i6 : 0;
        int color = getColor(i7, i3);
        if (i6 != 0) {
            shapeDrawable.getPaint().setShadowLayer(i6, i4, i5, color);
        }
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        shapeDrawable.getPaint().setColor(getColor(i7, i2));
        float[] fArr = new float[8];
        Arrays.fill(fArr, i);
        RoundRectShapeWithEdge roundRectShapeWithEdge = new RoundRectShapeWithEdge(fArr);
        roundRectShapeWithEdge.setEdge(max);
        shapeDrawable.setShape(roundRectShapeWithEdge);
        return shapeDrawable;
    }

    public static StateListDrawable createStateDrawable(int i, int i2, int i3) {
        if (i != 0 && i2 != 0) {
            Drawable drawable = getDrawable(i3, i);
            Drawable drawable2 = getDrawable(i3, i2);
            if (drawable != null && drawable2 != null) {
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{16842910, 16842919}, drawable2);
                stateListDrawable.addState(new int[]{16842910, 16842908}, drawable2);
                stateListDrawable.addState(new int[0], drawable);
                return stateListDrawable;
            }
        }
        return null;
    }

    public static int getBarTextUnselColor(int i) {
        if (i != 1 && i != 4) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
        return BdBaseApplication.getInst().getApp().getResources().getColor(R.color.common_color_10219);
    }

    public static int getBgColor(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        if (i != 1 && i != 4) {
            return app.getResources().getColor(R.color.common_color_10163);
        }
        return app.getResources().getColor(R.color.common_color_10150);
    }

    public static Bitmap getBitmap(Resources resources, int i, BitmapFactory.Options options) {
        return getBitmap(resources, i, options, TbadkCoreApplication.getInst().getSkinType());
    }

    public static Bitmap getBitmap565Quality(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return getBitmap(null, i, options);
    }

    public static Bitmap getBitmapAllowFail(Resources resources, int i) {
        return getBitmap(i);
    }

    public static Bitmap getBitmapLowQuality(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        return getBitmap(null, i, options);
    }

    public static Bitmap getBitmapQuiteLowQuality(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 4;
        return getBitmap(null, i, options);
    }

    public static int getColor(int i, Resources resources, int i2) {
        int darkResourceId;
        Resources resources2;
        if (i2 == 0) {
            return 0;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        if (i != 2 ? i != 1 ? i != 4 || (darkResourceId = getDarkResourceId(resources, i2)) == 0 || (resources2 = mPluginRes) == null : (darkResourceId = getNightResouceId(resources, i2)) == 0 || (resources2 = mPluginRes) == null : (darkResourceId = getSkinResourceId(resources, i2)) == 0 || (resources2 = mSkinRes) == null) {
            resources2 = resources;
            darkResourceId = i2;
        }
        try {
            return resources2.getColor(darkResourceId);
        } catch (Throwable unused) {
            return resources.getColor(i2);
        }
    }

    public static Drawable getColorDrawableWithClickState(int i) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = getDrawable(i);
        drawable.mutate().setAlpha((int) (RESOURCE_ALPHA_PRESS * 255.0f));
        stateListDrawable.addState(new int[]{16842910, 16842919}, drawable);
        stateListDrawable.addState(new int[0], getDrawable(i).mutate());
        return stateListDrawable;
    }

    public static ColorStateList getColorList(int i, Resources resources, int i2) {
        int darkResourceId;
        if (i2 == 0) {
            return null;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        if (i != 2 ? !(i != 1 ? i != 4 || (darkResourceId = getDarkResourceId(resources, i2)) == 0 || mPluginRes == null : (darkResourceId = getNightResouceId(resources, i2)) == 0 || mPluginRes == null) : !((darkResourceId = getSkinResourceId(resources, i2)) == 0 || mSkinRes == null)) {
            i2 = darkResourceId;
        }
        if (i2 == 0) {
            return null;
        }
        try {
            return AppCompatResources.getColorStateList(BdBaseApplication.getInst().getApp(), i2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static ColorStateList getColorStateListWithClickAndDisableState(int i, int i2) {
        if (i <= 0) {
            return null;
        }
        return new ColorStateList(new int[][]{new int[]{16842910, 16842919}, new int[]{-16842910}, new int[0]}, new int[]{c.a(getColor(i2, i), RESOURCE_ALPHA_PRESS), c.a(getColor(i2, i), RESOURCE_ALPHA_DISABLE), getColor(i2, i)});
    }

    public static ColorStateList getColorStateListWithClickState(int i) {
        if (i <= 0) {
            return null;
        }
        return new ColorStateList(new int[][]{new int[]{16842910, 16842919}, new int[0]}, new int[]{c.a(getColor(i), RESOURCE_ALPHA_PRESS), getColor(i)});
    }

    public static int getCommentTextColor(int i) {
        if (i != 1 && i != 4) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
        return BdBaseApplication.getInst().getApp().getResources().getColor(R.color.common_color_10004);
    }

    public static String getCurrentSkinTypeString() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        return skinType == 1 ? SKIN_TYPE_STR_NIGHT : skinType == 4 ? SKIN_TYPE_STR_DARK : "default";
    }

    public static int getDarkResourceId(Resources resources, int i) {
        String str;
        if (mPluginRes == null) {
            mPluginRes = resources;
        }
        int i2 = sDarkResourceIdMap.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        try {
            str = resources.getResourceName(i);
        } catch (Exception unused) {
            str = null;
        }
        if (!TextUtils.isEmpty(str) && str.indexOf(":") > 0 && mPluginRes != null) {
            if (sPacknameLength == 0) {
                String packageName = BdBaseApplication.getInst().getPackageName();
                sPackagename = packageName;
                sPacknameLength = packageName.length();
            }
            int length = str.length();
            int i3 = sPacknameLength;
            if (length > i3 && str.charAt(i3) != ':' && str.startsWith(sPackagename)) {
                str = sPackagename + str.substring(str.indexOf(":"));
            }
            i2 = mPluginRes.getIdentifier(str + darkSuffix, null, null);
            if (i2 <= 0) {
                String str2 = PLUGIN_NIGHT_RESOURCE + str.substring(str.indexOf(":"));
                i2 = mPluginRes.getIdentifier(str2 + darkSuffix, null, null);
            }
        }
        if (i2 <= 0) {
            i2 = getNightResouceId(resources, i);
        }
        sDarkResourceIdMap.put(i, i2);
        return i2;
    }

    public static Drawable getDrawable(int i, Resources resources, int i2) {
        int darkResourceId;
        Resources resources2;
        if (i2 == 0) {
            return null;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        if (i != 2 ? i != 1 ? i != 4 || (darkResourceId = getDarkResourceId(resources, i2)) == 0 || (resources2 = mPluginRes) == null : (darkResourceId = getNightResouceId(resources, i2)) == 0 || (resources2 = mPluginRes) == null : (darkResourceId = getSkinResourceId(resources, i2)) == 0 || (resources2 = mSkinRes) == null) {
            resources2 = resources;
            darkResourceId = i2;
        }
        try {
            try {
                return resources2.getDrawable(darkResourceId);
            } catch (Throwable unused) {
                return resources.getDrawable(i2);
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static Drawable getDrawableWithClickState(int i) {
        if (i <= 0) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = getDrawable(i);
        drawable.setAlpha((int) (RESOURCE_ALPHA_PRESS * 255.0f));
        stateListDrawable.addState(new int[]{16842919}, drawable);
        stateListDrawable.addState(new int[0], getDrawable(i).mutate());
        return stateListDrawable;
    }

    public static ColorStateList getIntColorStateListWithClickState(@ColorInt int i) {
        return new ColorStateList(new int[][]{new int[]{16842910, 16842919}, new int[0]}, new int[]{c.a(i, RESOURCE_ALPHA_PRESS), i});
    }

    public static int getLottieAnimation(int i) {
        int darkResourceId;
        if (i <= 0) {
            return 0;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1) {
            darkResourceId = getNightResouceId(TbadkCoreApplication.getInst().getResources(), i);
            if (darkResourceId <= 0) {
                return i;
            }
        } else if (skinType != 4 || (darkResourceId = getDarkResourceId(TbadkCoreApplication.getInst().getResources(), i)) <= 0) {
            return i;
        }
        return darkResourceId;
    }

    public static int getNightResouceId(Resources resources, int i) {
        String str;
        if (mPluginRes == null) {
            mPluginRes = resources;
        }
        int i2 = sNightResourceIdMap.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        try {
            str = resources.getResourceName(i);
        } catch (Exception unused) {
            str = null;
        }
        if (!TextUtils.isEmpty(str) && str.indexOf(":") > 0 && mPluginRes != null) {
            if (sPacknameLength == 0) {
                String packageName = BdBaseApplication.getInst().getPackageName();
                sPackagename = packageName;
                sPacknameLength = packageName.length();
            }
            int length = str.length();
            int i3 = sPacknameLength;
            if (length > i3 && str.charAt(i3) != ':' && str.startsWith(sPackagename)) {
                str = sPackagename + str.substring(str.indexOf(":"));
            }
            i2 = mPluginRes.getIdentifier(str + nightSufix, null, null);
            if (i2 <= 0) {
                Resources resources2 = mPluginRes;
                i2 = resources2.getIdentifier((PLUGIN_NIGHT_RESOURCE + str.substring(str.indexOf(":"))) + nightSufix, null, null);
            }
        }
        sNightResourceIdMap.put(i, i2);
        return i2;
    }

    public static int getResourceId(int i) {
        int darkResourceId;
        if (i <= 0) {
            return 0;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1) {
            darkResourceId = getNightResouceId(TbadkCoreApplication.getInst().getResources(), i);
            if (darkResourceId <= 0) {
                return i;
            }
        } else if (skinType != 4 || (darkResourceId = getDarkResourceId(TbadkCoreApplication.getInst().getResources(), i)) <= 0) {
            return i;
        }
        return darkResourceId;
    }

    public static int getSecondCommentTextColor(int i) {
        if (i != 1 && i != 4) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
        return BdBaseApplication.getInst().getApp().getResources().getColor(R.color.common_color_10217);
    }

    public static int getSkinColor(Resources resources, int i) {
        Resources resources2;
        if (i == 0) {
            return 0;
        }
        if (TbadkCoreApplication.getInst().getUsedThemeId() > 0 && TbadkCoreApplication.getInst().getSkinType() == 2) {
            if (resources == null) {
                resources = BdBaseApplication.getInst().getApp().getResources();
            }
            int skinResourceId = getSkinResourceId(resources, i);
            if (skinResourceId == 0 || (resources2 = mSkinRes) == null) {
                resources2 = resources;
                skinResourceId = i;
            }
            try {
                return resources2.getColor(skinResourceId);
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
                return resources.getColor(i);
            }
        }
        return getColor(i);
    }

    public static ColorStateList getSkinColorList(Resources resources, int i) {
        Resources resources2;
        if (i == 0) {
            return null;
        }
        if (TbadkCoreApplication.getInst().getUsedThemeId() > 0 && TbadkCoreApplication.getInst().getSkinType() == 2) {
            if (resources == null) {
                resources = BdBaseApplication.getInst().getApp().getResources();
            }
            int skinResourceId = getSkinResourceId(resources, i);
            if (skinResourceId == 0 || (resources2 = mSkinRes) == null) {
                resources2 = resources;
                skinResourceId = i;
            }
            try {
                return resources2.getColorStateList(skinResourceId);
            } catch (Throwable unused) {
                return resources.getColorStateList(i);
            }
        }
        return getColorList(i);
    }

    public static Drawable getSkinDrawable(Resources resources, int i) {
        Resources resources2;
        if (i == 0) {
            return null;
        }
        if (TbadkCoreApplication.getInst().getUsedThemeId() > 0 && TbadkCoreApplication.getInst().getSkinType() == 2) {
            if (resources == null) {
                resources = BdBaseApplication.getInst().getApp().getResources();
            }
            int skinResourceId = getSkinResourceId(resources, i);
            if (skinResourceId == 0 || (resources2 = mSkinRes) == null) {
                resources2 = resources;
                skinResourceId = i;
            }
            try {
                return resources2.getDrawable(skinResourceId);
            } catch (Throwable unused) {
                return resources.getDrawable(i);
            }
        }
        return getDrawable(i);
    }

    public static int getSkinResourceId(Resources resources, int i) {
        String str;
        if (mSkinRes == null) {
            mSkinRes = resources;
        }
        if (mSkinRes == null) {
            return 0;
        }
        try {
            str = resources.getResourceName(i);
        } catch (Exception unused) {
            str = null;
        }
        if (StringUtils.isNull(str)) {
            return 0;
        }
        String substring = str.substring(str.indexOf("/"));
        if (StringUtils.isNull(substring) || !substring.startsWith("/s_")) {
            return 0;
        }
        String substring2 = str.substring(str.indexOf(":"));
        return mSkinRes.getIdentifier(mSkinPackageName + substring2, null, null);
    }

    public static int getThirdCommentTextColor(int i) {
        if (i != 1 && i != 4) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
        return BdBaseApplication.getInst().getApp().getResources().getColor(R.color.common_color_10218);
    }

    public static int getVectorToDefaultResId(Resources resources, int i) {
        if (mPluginRes == null) {
            mPluginRes = resources;
        }
        d.b.i0.r.z.a.a("img", -1L, 0, "svg_load_failed", 0, "svg_load_failed", "version_code", Build.VERSION.RELEASE, "model", Build.MODEL, "brand", Build.BRAND);
        try {
            String resourceName = resources.getResourceName(i);
            if (StringUtils.isNull(resourceName)) {
                return 0;
            }
            String replace = resourceName.replace("_svg", "");
            if (replace.indexOf(":") <= 0 || mPluginRes == null) {
                return 0;
            }
            if (sPacknameLength == 0) {
                String packageName = BdBaseApplication.getInst().getPackageName();
                sPackagename = packageName;
                sPacknameLength = packageName.length();
            }
            if (replace.length() > sPacknameLength && replace.charAt(sPacknameLength) != ':' && replace.startsWith(sPackagename)) {
                replace = sPackagename + replace.substring(replace.indexOf(":"));
            }
            return mPluginRes.getIdentifier(replace + nightSufix, null, null);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean isCurrentSystemDarkMode() {
        return (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getResources() == null || TbadkCoreApplication.getInst().getResources().getConfiguration() == null || (TbadkCoreApplication.getInst().getResources().getConfiguration().uiMode & 48) != 32) ? false : true;
    }

    public static void setBackgroundColor(View view, int i) {
        setBackgroundColor(view, i, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void setBackgroundColorToTransparent(View view, @ColorRes int i, GradientDrawable.Orientation orientation) {
        if (view == null || i == 0 || orientation == null) {
            return;
        }
        view.setBackgroundDrawable(new GradientDrawable(orientation, new int[]{getColor(i), 0}));
    }

    public static void setBackgroundColorWithAlpha(View view, int i, float f2, int i2) {
        int color;
        if (view == null || i == 0) {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        if (i2 == 0) {
            color = view.getResources().getColor(i);
        } else {
            color = getColor(i2, view.getResources(), i);
        }
        view.setBackgroundColor(c.a(color, f2));
        if (paddingLeft == 0 && paddingRight == 0 && paddingTop == 0 && paddingBottom == 0) {
            return;
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public static void setBackgroundColorWithSkin(View view, int i) {
        int color;
        if (view == null || i == 0) {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        if (TbadkCoreApplication.getInst().getUsedThemeId() > 0 && TbadkCoreApplication.getInst().getSkinType() == 2) {
            color = getSkinColor(view.getResources(), i);
        } else {
            color = getColor(view.getResources(), i);
        }
        view.setBackgroundColor(color);
        if (paddingLeft == 0 && paddingRight == 0 && paddingTop == 0 && paddingBottom == 0) {
            return;
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public static void setBackgroundDrawable(PopupWindow popupWindow, int i) {
        setBackgroundDrawable(popupWindow, i, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void setBackgroundEndColorToAutoColor(View view, @ColorRes int i, GradientDrawable.Orientation orientation, float[] fArr) {
        GradientDrawable gradientDrawable;
        if (view == null || i == 0 || orientation == null || fArr.length < 8) {
            return;
        }
        int color = getColor(i);
        int[] iArr = {c.b(color), color};
        if (Build.VERSION.SDK_INT >= 16) {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(orientation);
            gradientDrawable.setColors(iArr);
        } else {
            gradientDrawable = new GradientDrawable(orientation, iArr);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(fArr);
        view.setBackgroundDrawable(gradientDrawable);
    }

    public static void setBackgroundResource(View view, int i) {
        setBackgroundResource(view, i, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void setBackgroundResourceSelector(View view, int i, int i2) {
        setBackgroundSelector(view, i, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void setBackgroundResourceWithSkin(View view, int i) {
        Drawable drawable;
        if (view == null || i == 0) {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        if (TbadkCoreApplication.getInst().getUsedThemeId() > 0 && TbadkCoreApplication.getInst().getSkinType() == 2) {
            drawable = getSkinDrawable(view.getResources(), i);
        } else {
            drawable = getDrawable(view.getResources(), i);
        }
        view.setBackgroundDrawable(drawable);
        if (paddingLeft == 0 && paddingRight == 0 && paddingTop == 0 && paddingBottom == 0) {
            return;
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public static void setBackgroundSelector(View view, int i, int i2, int i3) {
        StateListDrawable createStateDrawable;
        if (i == 0 || i2 == 0 || view == null || (createStateDrawable = createStateDrawable(i, i2, i3)) == null) {
            return;
        }
        view.setBackgroundDrawable(createStateDrawable);
    }

    public static void setBackgroundShapeDrawable(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (view == null) {
            return;
        }
        GradientDrawable createShapeDrawable = createShapeDrawable(i, i2, i4, i6, i7);
        GradientDrawable createShapeDrawable2 = createShapeDrawable(i, i3, i5, i6, i7);
        if (createShapeDrawable == null || createShapeDrawable2 == null) {
            return;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, createShapeDrawable2);
        stateListDrawable.addState(new int[]{16842910, 16842908}, createShapeDrawable2);
        stateListDrawable.addState(new int[0], createShapeDrawable);
        view.setBackgroundDrawable(stateListDrawable);
    }

    public static void setBackgroundShapeDrawableWithShadow(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (view == null) {
            return;
        }
        view.setLayerType(1, null);
        ShapeDrawable createShapeDrawableWithShadow = createShapeDrawableWithShadow(i, i2, i4, i5, i6, i7, i8);
        ShapeDrawable createShapeDrawableWithShadow2 = createShapeDrawableWithShadow(i, i3, i4, i5, i6, i7, i8);
        if (createShapeDrawableWithShadow == null || createShapeDrawableWithShadow2 == null) {
            return;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, createShapeDrawableWithShadow2);
        stateListDrawable.addState(new int[]{16842910, 16842908}, createShapeDrawableWithShadow2);
        stateListDrawable.addState(new int[0], createShapeDrawableWithShadow);
        view.setBackgroundDrawable(stateListDrawable);
    }

    public static void setBgColor(View view, int i) {
        if (view != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i != 1 && i != 4) {
                view.setBackgroundColor(app.getResources().getColor(R.color.common_color_10163));
            } else {
                view.setBackgroundColor(app.getResources().getColor(R.color.common_color_10150));
            }
        }
    }

    @Deprecated
    public static void setBlueTextColor1(TextView textView, int i) {
        if (textView != null) {
            setViewTextColor(textView, R.color.common_color_10213, 1);
        }
    }

    public static void setBlueTextColor2(TextView textView, int i) {
        if (textView != null) {
            setViewTextColor(textView, R.color.common_color_10214, 1);
        }
    }

    @Deprecated
    public static void setButtonTextColor(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i != 1 && i != 4) {
                textView.setTextColor(app.getResources().getColor(R.color.CAM_X0201));
            } else {
                textView.setTextColor(app.getResources().getColor(R.color.common_color_10212));
            }
        }
    }

    public static void setCommonListView(ListView listView, int i) {
        if (listView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            setBackgroundColor(listView, R.color.common_color_10163);
            listView.setCacheColorHint(app.getResources().getColor(17170445));
            listView.setDivider(getDrawable(R.drawable.list_divider));
            listView.setSelector(getDrawable(R.drawable.list_selector));
        }
    }

    public static void setCommonListViewNoBackground(ListView listView, int i) {
        if (listView != null) {
            listView.setCacheColorHint(BdBaseApplication.getInst().getApp().getResources().getColor(17170445));
            listView.setDivider(getDrawable(R.drawable.list_divider));
            listView.setSelector(getDrawable(R.drawable.list_selector));
        }
    }

    public static void setCommonTabBgImage(View view, int i) {
        if (view != null) {
            setBackgroundResource(view, R.drawable.home_radio_button);
        }
    }

    public static void setDayOrDarkSkinTypeWithSystemMode(boolean z, boolean z2) {
        boolean isCurrentSystemDarkMode = isCurrentSystemDarkMode();
        Activity b2 = b.f().b();
        if (b2 == null) {
            return;
        }
        if (!isCurrentSystemDarkMode) {
            if (z) {
                UtilHelper.showSkinChangeAnimation(b2);
            }
            if (z2) {
                TbadkCoreApplication.getInst().setSkinTypeValue(0);
                TbadkCoreApplication.getInst().SendSkinTypeBroadcast(0);
                return;
            }
            TbadkCoreApplication.getInst().setSkinType(0);
        } else if (d.b.i0.r.d0.b.j().g("key_is_dark_mode_notify_shown", false)) {
            boolean g2 = d.b.i0.r.d0.b.j().g("key_is_follow_system_mode", false);
            if (z) {
                UtilHelper.showSkinChangeAnimation(b2);
            }
            int i = g2 ? 4 : 0;
            if (z2) {
                TbadkCoreApplication.getInst().setSkinTypeValue(i);
                TbadkCoreApplication.getInst().SendSkinTypeBroadcast(i);
                return;
            }
            TbadkCoreApplication.getInst().setSkinType(i);
        } else {
            d.b.i0.r.d0.b.j().t("key_is_dark_mode_notify_shown", true);
            d.b.i0.r.d0.b.j().t("key_is_follow_system_mode", true);
            TbadkCoreApplication.getInst().setSkinType(isCurrentSystemDarkMode() ? 4 : 0);
        }
    }

    public static void setFrsPBBgColor(View view, int i) {
        if (view != null) {
            setBackgroundResource(view, R.drawable.common_bg);
        }
    }

    public static void setGrayTextColor1(TextView textView, int i) {
        if (textView != null) {
            setViewTextColor(textView, R.color.CAM_X0105, 1);
        }
    }

    public static void setGrayTextColor2(TextView textView, int i) {
        if (textView != null) {
            setViewTextColor(textView, R.color.common_color_10005, 1);
        }
    }

    public static void setGrayTextColor3(TextView textView, int i) {
        if (textView != null) {
            setViewTextColor(textView, R.color.common_color_10215, 1);
        }
    }

    public static void setImageResource(ImageView imageView, int i) {
        if (imageView == null || i == 0) {
            return;
        }
        imageView.setImageDrawable(getDrawable(imageView.getResources(), i));
    }

    public static void setImageResourceFromContainer(ImageView imageView, int i) {
        if (imageView == null || i == 0) {
            return;
        }
        imageView.setImageDrawable(getDrawable((Resources) null, i));
    }

    public static void setImageResourceSelector(ImageView imageView, int i, int i2, int i3) {
        StateListDrawable createStateDrawable;
        if (i == 0 || i2 == 0 || imageView == null || (createStateDrawable = createStateDrawable(i, i2, i3)) == null) {
            return;
        }
        imageView.setImageDrawable(createStateDrawable);
    }

    public static void setListViewNoDivider(ListView listView, int i) {
        if (listView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            setBackgroundColor(listView, R.color.common_color_10163);
            listView.setCacheColorHint(app.getResources().getColor(17170445));
            listView.setSelector(getDrawable(R.drawable.list_selector));
        }
    }

    public static void setLoginBgColor(View view, int i) {
        if (view != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i != 1 && i != 4) {
                view.setBackgroundColor(app.getResources().getColor(R.color.common_color_10216));
            } else {
                view.setBackgroundColor(app.getResources().getColor(R.color.common_color_10150));
            }
        }
    }

    public static void setLottieAnimation(TBLottieAnimationView tBLottieAnimationView, int i) {
        int lottieAnimation = getLottieAnimation(i);
        if (lottieAnimation > 0) {
            tBLottieAnimationView.setAnimation(lottieAnimation);
        }
    }

    public static void setLvSelector(ListView listView, int i) {
        if (listView != null) {
            listView.setSelector(getDrawable(R.drawable.list_selector));
        }
    }

    public static void setNavbarIconSrc(ImageView imageView, int i, int i2) {
        setNavbarIconSrc(imageView, i, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void setNavbarTitleColor(View view, int i, int i2) {
        setNavbarTitleColor(view, i, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void setNightLottieAnimation(TBLottieAnimationView tBLottieAnimationView, int i) {
        int nightResouceId = getNightResouceId(TbadkCoreApplication.getInst().getResources(), i);
        if (nightResouceId > 0) {
            tBLottieAnimationView.setAnimation(nightResouceId);
        }
    }

    public static void setNineTextColorMode(TextView textView, boolean z) {
        Application app = BdBaseApplication.getInst().getApp();
        if (z) {
            textView.setTextColor(app.getResources().getColor(R.color.CAM_X0201));
        } else {
            setViewTextColor(textView, R.color.CAM_X0201, 1);
        }
    }

    public static void setNormalBackgroundResource(View view, int i) {
        if (view == null) {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        view.setBackgroundResource(i);
        if (paddingLeft == 0 && paddingRight == 0 && paddingTop == 0 && paddingBottom == 0) {
            return;
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public static void setSkinRes(String str) throws IllegalAccessException, InstantiationException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        if (StringUtils.isNull(str)) {
            return;
        }
        try {
            Resources resources = TbadkCoreApplication.getInst().getResources();
            if (resources == null) {
                return;
            }
            am = (AssetManager) AssetManager.class.newInstance();
            File GetFile = FileHelper.GetFile(str);
            if (GetFile != null && GetFile.exists()) {
                am.getClass().getDeclaredMethod(V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, String.class).invoke(am, GetFile.getAbsolutePath());
                mSkinRes = new Resources(am, resources.getDisplayMetrics(), resources.getConfiguration());
                mSkinPackageName = FileHelper.getApkFilePackageName(str);
                return;
            }
            l.K(BdBaseApplication.getInst().getApp(), R.string.theme_skin_apk_error);
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    public static void setSubPbBgFootImage(View view, int i) {
        if (view != null) {
            setBackgroundResource(view, R.drawable.bg_pb_list_bottom);
        }
    }

    public static void setSubPbBgHeadImage(View view, int i) {
        if (view != null) {
            setBackgroundResource(view, R.drawable.bg_pb_list_top);
        }
    }

    @Deprecated
    public static void setTextColor(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i != 1 && i != 4) {
                textView.setTextColor(app.getResources().getColor(R.color.black_alpha100));
            } else {
                textView.setTextColor(app.getResources().getColor(R.color.common_color_10004));
            }
        }
    }

    public static void setTopBarBackBgImage(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            setImageResource(imageView, R.drawable.icon_topbar_return_n);
        }
    }

    public static void setTopBarBgImage(View view, int i) {
        if (view != null) {
            setBackgroundResource(view, R.drawable.titlebar_bg);
        }
    }

    public static void setTopBarCommonButtonBgImage(TextView textView, int i) {
        if (textView != null) {
            setBackgroundResource(textView, R.drawable.title_comm);
        }
        setTopBarTitleColor(textView, i);
    }

    public static void setTopBarCommonDeleteButton(TextView textView, int i) {
        if (textView != null) {
            setBackgroundResource(textView, R.drawable.navi_del_text_bg);
        }
        setTopBarCommonDeleteButtonText(textView, i);
    }

    public static void setTopBarCommonDeleteButtonText(TextView textView, int i) {
        if (textView != null) {
            setViewTextColor(textView, R.color.navi_del_text, 1);
        }
    }

    public static void setTopBarCommonFinishButton(TextView textView, int i) {
        if (textView != null) {
            setBackgroundResource(textView, R.drawable.navi_done_text_bg);
        }
        setTopBarCommonFinishButtonText(textView, i);
    }

    public static void setTopBarCommonFinishButtonText(TextView textView, int i) {
        if (textView != null) {
            setViewTextColor(textView, R.color.navi_done_text, 1);
        }
    }

    public static void setTopBarCommonHiliteButton(TextView textView, int i) {
        if (textView != null) {
            setBackgroundResource(textView, R.drawable.title_comm_hilite);
        }
        setTopBarTitleColor(textView, i);
    }

    public static void setTopBarCommonOperateButton(TextView textView, int i) {
        setTopBarCommonOperateButtonText(textView, i);
    }

    public static void setTopBarCommonOperateButtonText(TextView textView, int i) {
        if (textView != null) {
            setViewTextColor(textView, R.color.navi_op_text, 1);
        }
    }

    public static void setTopBarRefrshBgImage(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            setImageResource(imageView, R.drawable.icon_refresh_n);
        }
    }

    public static void setTopBarSearchBgImage(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            setImageResource(imageView, R.drawable.icon_topbar_search_n);
        }
    }

    public static void setTopBarTitleColor(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i != 1 && i != 4) {
                textView.setTextColor(app.getResources().getColor(R.color.CAM_X0201));
            } else {
                textView.setTextColor(app.getResources().getColor(R.color.common_color_10004));
            }
        }
    }

    public static void setViewCheckedTextColorSelector(View view, int i, int i2, int i3) {
        ColorStateList createCheckedColorStateList;
        if (i == 0 || i2 == 0 || view == null || (createCheckedColorStateList = createCheckedColorStateList(i, i2, i3, TbadkCoreApplication.getInst().getSkinType())) == null || !(view instanceof CheckBox)) {
            return;
        }
        ((CheckBox) view).setTextColor(createCheckedColorStateList);
    }

    public static void setViewTextColor(View view, int i) {
        setViewTextColor(view, i, 1);
    }

    public static void setViewTextColorSelector(View view, int i) {
        ColorStateList createColorStateList;
        if (i == 0 || view == null || (createColorStateList = createColorStateList(i)) == null) {
            return;
        }
        if (view instanceof Button) {
            ((Button) view).setTextColor(createColorStateList);
        } else if (view instanceof EditText) {
            ((EditText) view).setTextColor(createColorStateList);
        } else if (view instanceof TextView) {
            ((TextView) view).setTextColor(createColorStateList);
        } else if (view instanceof CheckBox) {
            ((CheckBox) view).setTextColor(createColorStateList);
        }
    }

    public static void setViewTextColorWithClickState(TextView textView, @ColorInt int i) {
        if (textView == null) {
            return;
        }
        textView.setTextColor(getIntColorStateListWithClickState(i));
    }

    public static void setViewTextColorWithSkin(View view, int i, int i2) {
        ColorStateList colorList;
        if (view == null || i == 0) {
            return;
        }
        if (TbadkCoreApplication.getInst().getUsedThemeId() > 0 && TbadkCoreApplication.getInst().getSkinType() == 2) {
            colorList = getSkinColorList(view.getResources(), i);
        } else {
            colorList = getColorList(view.getResources(), i);
        }
        if (i2 == 3 && (view instanceof Button)) {
            ((Button) view).setTextColor(colorList);
        } else if (i2 == 2 && (view instanceof EditText)) {
            ((EditText) view).setTextColor(colorList);
        } else if (i2 == 1 && (view instanceof TextView)) {
            ((TextView) view).setTextColor(colorList);
        }
    }

    public static void setBackgroundColor(View view, int i, int i2) {
        int color;
        if (view == null || i == 0) {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        if (i2 == 0) {
            color = view.getResources().getColor(i);
        } else {
            color = getColor(i2, view.getResources(), i);
        }
        view.setBackgroundColor(color);
        if (paddingLeft == 0 && paddingRight == 0 && paddingTop == 0 && paddingBottom == 0) {
            return;
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public static void setBackgroundDrawable(PopupWindow popupWindow, int i, int i2) {
        if (popupWindow == null || i == 0) {
            return;
        }
        popupWindow.setBackgroundDrawable(getDrawable(i2, i));
    }

    public static void setBackgroundResource(View view, int i, int i2) {
        if (view == null || i == 0) {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        view.setBackgroundDrawable(getDrawable(i2, i));
        if (paddingLeft == 0 && paddingRight == 0 && paddingTop == 0 && paddingBottom == 0) {
            return;
        }
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public static void setViewTextColor(View view, int i, int i2, int i3) {
        ColorStateList colorList;
        if (view == null || i == 0 || view.getResources() == null) {
            return;
        }
        if (i3 == 0) {
            colorList = view.getResources().getColorStateList(i);
        } else {
            colorList = getColorList(i3, view.getResources(), i);
        }
        if (colorList == null) {
            return;
        }
        if (i2 == 3 && (view instanceof Button)) {
            ((Button) view).setTextColor(colorList);
        } else if (i2 == 2 && (view instanceof EditText)) {
            ((EditText) view).setTextColor(colorList);
        } else if (i2 == 1 && (view instanceof TextView)) {
            ((TextView) view).setTextColor(colorList);
        } else if (i2 == 4 && (view instanceof CheckBox)) {
            ((CheckBox) view).setTextColor(colorList);
        }
    }

    public static Bitmap getBitmap(Resources resources, int i, BitmapFactory.Options options, int i2) {
        Resources resources2;
        if (i == 0) {
            return null;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        if (i2 == 1) {
            int nightResouceId = getNightResouceId(resources, i);
            if (nightResouceId == 0 || mPluginRes == null) {
                nightResouceId = i;
            }
            try {
                Bitmap nightCashBitmap = BitmapHelper.getNightCashBitmap(mPluginRes, nightResouceId, i, options);
                return nightCashBitmap == null ? BitmapHelper.getCashBitmap(i, options) : nightCashBitmap;
            } catch (Throwable unused) {
                return BitmapHelper.getCashBitmap(i, options);
            }
        } else if (i2 == 4) {
            int darkResourceId = getDarkResourceId(resources, i);
            if (darkResourceId == 0 || (resources2 = mPluginRes) == null) {
                darkResourceId = i;
            } else {
                resources = resources2;
            }
            try {
                Bitmap darkCashBitmap = BitmapHelper.getDarkCashBitmap(mPluginRes, darkResourceId, i, options);
                return (darkCashBitmap == null && (darkCashBitmap = BitmapHelper.getNightCashBitmap(mPluginRes, getNightResouceId(resources, i), i, options)) == null) ? BitmapHelper.getCashBitmap(i, options) : darkCashBitmap;
            } catch (Throwable unused2) {
                return BitmapHelper.getCashBitmap(i, options);
            }
        } else if (i2 == 2) {
            int skinResourceId = getSkinResourceId(resources, i);
            if (skinResourceId == 0) {
                return BitmapHelper.getCashBitmap(i, options);
            }
            try {
                Bitmap themeCashBitmap = BitmapHelper.getThemeCashBitmap(mSkinRes, skinResourceId, i, options);
                return themeCashBitmap == null ? BitmapHelper.getCashBitmap(i, options) : themeCashBitmap;
            } catch (Throwable unused3) {
                return BitmapHelper.getCashBitmap(i, options);
            }
        } else {
            return BitmapHelper.getCashBitmap(i, options);
        }
    }

    public static void setImageResource(ImageView imageView, int i, int i2) {
        if (imageView == null || i == 0) {
            return;
        }
        Drawable drawable = null;
        if (i2 == 0) {
            try {
                drawable = imageView.getResources().getDrawable(i);
            } catch (Throwable unused) {
            }
        } else {
            drawable = getDrawable(i2, imageView.getResources(), i);
        }
        imageView.setImageDrawable(drawable);
    }

    public static void setImageResourceSelector(ImageView imageView, int i, int i2) {
        setImageResourceSelector(imageView, i, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void setNavbarIconSrc(ImageView imageView, int i, int i2, int i3) {
        if (i == 0 || i2 == 0 || imageView == null) {
            return;
        }
        boolean z = TbadkCoreApplication.getInst().getUsedThemeColor() == 1;
        if (i3 == 2 && TbadkCoreApplication.getInst().getUsedThemeId() > 0) {
            if (z) {
                imageView.setImageResource(i);
            } else {
                imageView.setImageResource(i2);
            }
        } else if (i3 != 1 && i3 != 4) {
            setImageResource(imageView, i, i3);
        } else {
            setImageResource(imageView, i2, i3);
        }
    }

    public static void setNavbarTitleColor(View view, int i, int i2, int i3) {
        if (i == 0 || i2 == 0 || view == null) {
            return;
        }
        boolean z = TbadkCoreApplication.getInst().getUsedThemeColor() == 1;
        if (i3 != 2 || TbadkCoreApplication.getInst().getUsedThemeId() <= 0) {
            setViewTextColor(view, i);
        } else if (z) {
            setViewTextColor(view, i);
        } else {
            setViewTextColor(view, i2);
        }
    }

    public static Bitmap getBitmap565Quality(int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return getBitmap(null, i, options, i2);
    }

    public static Bitmap getBitmapLowQuality(int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        return getBitmap(null, i, options, i2);
    }

    public static ColorStateList createColorStateList(int i) {
        if (i == 0) {
            return null;
        }
        int color = getColor(TbadkCoreApplication.getInst().getSkinType(), i);
        int a2 = c.a(color, RESOURCE_ALPHA_PRESS);
        return new ColorStateList(new int[][]{new int[]{16842910, 16842919}, new int[]{16842910, 16842908}, new int[0]}, new int[]{a2, a2, color});
    }

    public static GradientDrawable createShapeDrawableFromColor(int i, int i2) {
        if (i2 == 0) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        if (i > 0) {
            gradientDrawable.setCornerRadius(i);
        }
        return gradientDrawable;
    }

    public static GradientDrawable createShapeDrawable(int i, int i2, int i3, int i4) {
        return createShapeDrawable(i, i2, i3, i4, TbadkCoreApplication.getInst().getSkinType());
    }

    public static StateListDrawable createStateDrawable(int i, int i2) {
        return createStateDrawable(i, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void setBackgroundShapeDrawable(View view, int i, int i2, int i3, int i4, int i5, int i6) {
        setBackgroundShapeDrawable(view, i, i2, i3, i4, i5, i6, TbadkCoreApplication.getInst().getSkinType());
    }

    public static GradientDrawable createShapeDrawableFromColor(int i, int i2, String str, int i3) {
        return createShapeDrawableFromColor(i, i2, str, i3, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void setNavbarIconSrc(ImageView imageView, int i, int i2, int i3, int i4) {
        if (i == 0 || i2 == 0 || imageView == null) {
            return;
        }
        boolean z = TbadkCoreApplication.getInst().getUsedThemeColor() == 1;
        if (i4 == 2 && TbadkCoreApplication.getInst().getUsedThemeId() > 0) {
            if (z) {
                imageView.setImageResource(i);
            } else {
                imageView.setImageResource(i2);
            }
        } else if (i4 != 1 && i4 != 4) {
            setImageResource(imageView, i, i4);
        } else {
            setImageResource(imageView, i3, i4);
        }
    }

    public static int getColor(int i, int i2) {
        return getColor(i, null, i2);
    }

    public static ColorStateList getColorList(Resources resources, int i) {
        return getColorList(TbadkCoreApplication.getInst().getSkinType(), resources, i);
    }

    public static Drawable getDrawable(Resources resources, int i) {
        return getDrawable(TbadkCoreApplication.getInst().getSkinType(), resources, i);
    }

    public static void setBackgroundShapeDrawable(View view, int i, int i2, int i3) {
        setBackgroundShapeDrawable(view, i, i2, i3, 0, 0, 0, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void setViewTextColorSelector(View view, int i, int i2, int i3) {
        ColorStateList createColorStateList;
        if (i == 0 || i2 == 0 || view == null || (createColorStateList = createColorStateList(i, i2, i3)) == null) {
            return;
        }
        if (view instanceof Button) {
            ((Button) view).setTextColor(createColorStateList);
        } else if (view instanceof EditText) {
            ((EditText) view).setTextColor(createColorStateList);
        } else if (view instanceof TextView) {
            ((TextView) view).setTextColor(createColorStateList);
        } else if (view instanceof CheckBox) {
            ((CheckBox) view).setTextColor(createColorStateList);
        }
    }

    public static ColorStateList createColorStateList(int i, int i2) {
        return createColorStateList(i, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public static int getColor(Resources resources, int i) {
        return getColor(TbadkCoreApplication.getInst().getSkinType(), resources, i);
    }

    public static ColorStateList getColorList(int i, int i2) {
        return getColorList(i, null, i2);
    }

    public static Drawable getDrawable(int i) {
        return getDrawable(TbadkCoreApplication.getInst().getSkinType(), null, i);
    }

    public static ShapeDrawable createShapeDrawableWithShadow(int i, int i2, int i3, int i4, int i5, int i6) {
        return createShapeDrawableWithShadow(i, i2, i3, i4, i5, i6, TbadkCoreApplication.getInst().getSkinType());
    }

    public static int getColor(int i) {
        return getColor(TbadkCoreApplication.getInst().getSkinType(), null, i);
    }

    public static ColorStateList getColorList(int i) {
        return getColorList(TbadkCoreApplication.getInst().getSkinType(), null, i);
    }

    public static Drawable getDrawable(int i, int i2) {
        if (i == 0) {
            try {
                return BdBaseApplication.getInst().getApp().getResources().getDrawable(i2);
            } catch (Throwable unused) {
                return null;
            }
        }
        return getDrawable(i, null, i2);
    }

    public static void setBackgroundShapeDrawable(View view, int i, int i2, int i3, int i4) {
        setBackgroundShapeDrawable(view, i, i2, i3, 0, 0, 0, i4);
    }

    public static void setViewTextColor(View view, int i, int i2) {
        setViewTextColor(view, i, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public static boolean setViewTextColor(View view, String str) {
        Resources resources;
        int identifier;
        ColorStateList colorList;
        if (view == null || StringUtils.isNull(str) || (resources = view.getResources()) == null || (identifier = resources.getIdentifier(str, "color", TbadkCoreApplication.getInst().getPackageName())) <= 0 || (colorList = getColorList(resources, identifier)) == null || !(view instanceof TextView)) {
            return false;
        }
        ((TextView) view).setTextColor(colorList);
        return true;
    }

    public static void setViewTextColorSelector(View view, int i, int i2) {
        setViewTextColorSelector(view, i, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public static Bitmap getBitmap(int i) {
        return getBitmap(null, i, new BitmapFactory.Options());
    }
}

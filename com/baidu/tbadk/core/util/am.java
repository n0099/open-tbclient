package com.baidu.tbadk.core.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.v7.content.res.AppCompatResources;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class am {
    private static com.baidu.tbadk.core.dialog.a FR;
    private static String TYPE_ERROR;
    private static String dak;
    private static AssetManager dal;
    private static SparseIntArray dam;
    private static SparseIntArray dan;
    public static Resources mPluginRes;
    private static Resources mSkinRes;
    private static String sPackagename;
    private static int sPacknameLength;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_NIGHTRES_PLUGIN_CHANGE) { // from class: com.baidu.tbadk.core.util.am.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                am.mPluginRes = null;
            }
        });
        TYPE_ERROR = "skinType not support";
        sPackagename = null;
        sPacknameLength = 0;
        dam = new SparseIntArray();
        dan = new SparseIntArray();
    }

    public static void tt(String str) throws IllegalAccessException, InstantiationException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        if (!StringUtils.isNull(str)) {
            try {
                Resources resources = TbadkCoreApplication.getInst().getResources();
                if (resources != null) {
                    dal = (AssetManager) AssetManager.class.newInstance();
                    File GetFile = m.GetFile(str);
                    if (GetFile == null || !GetFile.exists()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), (int) R.string.theme_skin_apk_error);
                    } else {
                        dal.getClass().getDeclaredMethod("addAssetPath", String.class).invoke(dal, GetFile.getAbsolutePath());
                        mSkinRes = new Resources(dal, resources.getDisplayMetrics(), resources.getConfiguration());
                        dak = m.getApkFilePackageName(str);
                    }
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    public static String aGv() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1) {
            return ComboPraiseProvider.DIR_PREFIX_NIGHT;
        }
        if (skinType != 4) {
            return "default";
        }
        return "dark";
    }

    @Deprecated
    public static void setButtonTextColor(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1 || i == 4) {
                textView.setTextColor(app.getResources().getColor(R.color.common_color_10212));
            } else {
                textView.setTextColor(app.getResources().getColor(R.color.cp_bg_line_d));
            }
        }
    }

    @Deprecated
    public static void setTextColor(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1 || i == 4) {
                textView.setTextColor(app.getResources().getColor(R.color.common_color_10004));
            } else {
                textView.setTextColor(app.getResources().getColor(R.color.black_alpha100));
            }
        }
    }

    public static void setBgColor(View view, int i) {
        if (view != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1 || i == 4) {
                view.setBackgroundColor(app.getResources().getColor(R.color.common_color_10150));
            } else {
                view.setBackgroundColor(app.getResources().getColor(R.color.common_color_10163));
            }
        }
    }

    public static void setFrsPBBgColor(View view, int i) {
        if (view != null) {
            setBackgroundResource(view, R.drawable.common_bg);
        }
    }

    public static void setTopBarTitleColor(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1 || i == 4) {
                textView.setTextColor(app.getResources().getColor(R.color.common_color_10004));
            } else {
                textView.setTextColor(app.getResources().getColor(R.color.cp_bg_line_d));
            }
        }
    }

    public static void setTopBarBgImage(View view, int i) {
        if (view != null) {
            setBackgroundResource(view, R.drawable.titlebar_bg);
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

    public static void setTopBarBackBgImage(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            setImageResource(imageView, R.drawable.icon_topbar_return_n);
        }
    }

    public static void setTopBarRefrshBgImage(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            setImageResource(imageView, R.drawable.icon_refresh_n);
        }
    }

    public static int getCommentTextColor(int i) {
        if (i == 1 || i == 4) {
            return BdBaseApplication.getInst().getApp().getResources().getColor(R.color.common_color_10004);
        }
        throw new IllegalArgumentException(TYPE_ERROR);
    }

    public static int getBgColor(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        return (i == 1 || i == 4) ? app.getResources().getColor(R.color.common_color_10150) : app.getResources().getColor(R.color.common_color_10163);
    }

    public static int c(Resources resources, int i) {
        String str;
        int i2;
        if (mPluginRes == null) {
            mPluginRes = resources;
        }
        int i3 = dam.get(i, -1);
        if (i3 == -1) {
            try {
                str = resources.getResourceName(i);
            } catch (Exception e) {
                str = null;
            }
            if (!TextUtils.isEmpty(str) && str.indexOf(":") > 0 && mPluginRes != null) {
                if (sPacknameLength == 0) {
                    sPackagename = BdBaseApplication.getInst().getPackageName();
                    sPacknameLength = sPackagename.length();
                }
                if (str.length() > sPacknameLength && str.charAt(sPacknameLength) != ':' && str.startsWith(sPackagename)) {
                    str = sPackagename + str.substring(str.indexOf(":"));
                }
                i3 = mPluginRes.getIdentifier(str + "_1", null, null);
                if (i3 <= 0) {
                    i2 = mPluginRes.getIdentifier(("com.baidu.tieba.pluginResource" + str.substring(str.indexOf(":"))) + "_1", null, null);
                    dam.put(i, i2);
                    return i2;
                }
            }
            i2 = i3;
            dam.put(i, i2);
            return i2;
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int d(Resources resources, int i) {
        String str;
        int i2;
        if (mPluginRes == null) {
            mPluginRes = resources;
        }
        int i3 = dan.get(i, -1);
        if (i3 != -1) {
            return i3;
        }
        try {
            str = resources.getResourceName(i);
        } catch (Exception e) {
            str = null;
        }
        if (!TextUtils.isEmpty(str) && str.indexOf(":") > 0 && mPluginRes != null) {
            if (sPacknameLength == 0) {
                sPackagename = BdBaseApplication.getInst().getPackageName();
                sPacknameLength = sPackagename.length();
            }
            if (str.length() > sPacknameLength && str.charAt(sPacknameLength) != ':' && str.startsWith(sPackagename)) {
                str = sPackagename + str.substring(str.indexOf(":"));
            }
            i3 = mPluginRes.getIdentifier(str + "_2", null, null);
            if (i3 <= 0) {
                i2 = mPluginRes.getIdentifier(("com.baidu.tieba.pluginResource" + str.substring(str.indexOf(":"))) + "_2", null, null);
                if (i2 <= 0) {
                    i2 = c(resources, i);
                }
                dan.put(i, i2);
                return i2;
            }
        }
        i2 = i3;
        if (i2 <= 0) {
        }
        dan.put(i, i2);
        return i2;
    }

    public static void setNavbarIconSrc(ImageView imageView, int i, int i2) {
        setNavbarIconSrc(imageView, i, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void setNavbarIconSrc(ImageView imageView, int i, int i2, int i3) {
        if (i != 0 && i2 != 0 && imageView != null) {
            boolean z = TbadkCoreApplication.getInst().getUsedThemeColor() == 1;
            if (i3 == 2 && TbadkCoreApplication.getInst().getUsedThemeId() > 0) {
                if (z) {
                    imageView.setImageResource(i);
                } else {
                    imageView.setImageResource(i2);
                }
            } else if (i3 == 1 || i3 == 4) {
                setImageResource(imageView, i2, i3);
            } else {
                setImageResource(imageView, i, i3);
            }
        }
    }

    public static void setNavbarTitleColor(View view, int i, int i2) {
        setNavbarTitleColor(view, i, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void setNavbarTitleColor(View view, int i, int i2, int i3) {
        if (i != 0 && i2 != 0 && view != null) {
            boolean z = TbadkCoreApplication.getInst().getUsedThemeColor() == 1;
            if (i3 == 2 && TbadkCoreApplication.getInst().getUsedThemeId() > 0) {
                if (z) {
                    setViewTextColor(view, i);
                    return;
                } else {
                    setViewTextColor(view, i2);
                    return;
                }
            }
            setViewTextColor(view, i);
        }
    }

    private static int getSkinResourceId(Resources resources, int i) {
        String str;
        if (mSkinRes == null) {
            mSkinRes = resources;
        }
        if (mSkinRes == null) {
            return 0;
        }
        try {
            str = resources.getResourceName(i);
        } catch (Exception e) {
            str = null;
        }
        if (StringUtils.isNull(str)) {
            return 0;
        }
        String substring = str.substring(str.indexOf("/"));
        if (StringUtils.isNull(substring) || !substring.startsWith("/s_")) {
            return 0;
        }
        return mSkinRes.getIdentifier(dak + str.substring(str.indexOf(":")), null, null);
    }

    public static void setViewTextColor(View view, int i) {
        setViewTextColor(view, i, 1);
    }

    public static Drawable getSkinDrawable(Resources resources, int i) {
        Resources resources2;
        if (i == 0) {
            return null;
        }
        if (TbadkCoreApplication.getInst().getUsedThemeId() <= 0 || TbadkCoreApplication.getInst().getSkinType() != 2) {
            return getDrawable(i);
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        int skinResourceId = getSkinResourceId(resources, i);
        if (skinResourceId == 0) {
            resources2 = resources;
            skinResourceId = i;
        } else if (mSkinRes != null) {
            resources2 = mSkinRes;
        } else {
            resources2 = resources;
            skinResourceId = i;
        }
        try {
            return resources2.getDrawable(skinResourceId);
        } catch (Throwable th) {
            return resources.getDrawable(i);
        }
    }

    public static int getSkinColor(Resources resources, int i) {
        Resources resources2;
        if (i == 0) {
            return 0;
        }
        if (TbadkCoreApplication.getInst().getUsedThemeId() <= 0 || TbadkCoreApplication.getInst().getSkinType() != 2) {
            return getColor(i);
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        int skinResourceId = getSkinResourceId(resources, i);
        if (skinResourceId == 0) {
            resources2 = resources;
            skinResourceId = i;
        } else if (mSkinRes != null) {
            resources2 = mSkinRes;
        } else {
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

    public static int getColor(int i, Resources resources, int i2) {
        Resources resources2;
        int i3;
        if (i2 == 0) {
            return 0;
        }
        Resources resources3 = resources != null ? resources : BdBaseApplication.getInst().getApp().getResources();
        if (i == 2) {
            i3 = getSkinResourceId(resources3, i2);
            if (i3 == 0) {
                resources2 = resources3;
                i3 = i2;
            } else if (mSkinRes != null) {
                resources2 = mSkinRes;
            } else {
                resources2 = resources3;
                i3 = i2;
            }
        } else if (i == 1) {
            i3 = c(resources3, i2);
            if (i3 == 0) {
                resources2 = resources3;
                i3 = i2;
            } else if (mPluginRes != null) {
                resources2 = mPluginRes;
            } else {
                resources2 = resources3;
                i3 = i2;
            }
        } else if (i == 4) {
            i3 = d(resources3, i2);
            if (i3 == 0) {
                resources2 = resources3;
                i3 = i2;
            } else if (mPluginRes != null) {
                resources2 = mPluginRes;
            } else {
                resources2 = resources3;
                i3 = i2;
            }
        } else {
            resources2 = resources3;
            i3 = i2;
        }
        try {
            return resources2.getColor(i3);
        } catch (Throwable th) {
            return resources3.getColor(i2);
        }
    }

    public static int getColor(int i, int i2) {
        return getColor(i, null, i2);
    }

    public static int getColor(int i) {
        return getColor(TbadkCoreApplication.getInst().getSkinType(), null, i);
    }

    public static ColorStateList getColorList(int i, Resources resources, int i2) {
        int d;
        if (i2 == 0) {
            return null;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        if (i == 2) {
            int skinResourceId = getSkinResourceId(resources, i2);
            if (skinResourceId != 0 && mSkinRes != null) {
                Resources resources2 = mSkinRes;
                i2 = skinResourceId;
            }
        } else if (i == 1) {
            int c = c(resources, i2);
            if (c != 0 && mPluginRes != null) {
                Resources resources3 = mPluginRes;
                i2 = c;
            }
        } else if (i == 4 && (d = d(resources, i2)) != 0 && mPluginRes != null) {
            Resources resources4 = mPluginRes;
            i2 = d;
        }
        if (i2 != 0) {
            try {
                return AppCompatResources.getColorStateList(BdBaseApplication.getInst().getApp(), i2);
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    public static ColorStateList getColorList(Resources resources, int i) {
        return getColorList(TbadkCoreApplication.getInst().getSkinType(), resources, i);
    }

    public static ColorStateList getColorList(int i) {
        return getColorList(TbadkCoreApplication.getInst().getSkinType(), null, i);
    }

    public static Drawable getDrawable(int i, Resources resources, int i2) {
        Resources resources2;
        int i3;
        if (i2 == 0) {
            return null;
        }
        Resources resources3 = resources != null ? resources : BdBaseApplication.getInst().getApp().getResources();
        if (i == 2) {
            i3 = getSkinResourceId(resources3, i2);
            if (i3 == 0) {
                resources2 = resources3;
                i3 = i2;
            } else if (mSkinRes != null) {
                resources2 = mSkinRes;
            } else {
                resources2 = resources3;
                i3 = i2;
            }
        } else if (i == 1) {
            i3 = c(resources3, i2);
            if (i3 == 0) {
                resources2 = resources3;
                i3 = i2;
            } else if (mPluginRes != null) {
                resources2 = mPluginRes;
            } else {
                resources2 = resources3;
                i3 = i2;
            }
        } else if (i == 4) {
            i3 = d(resources3, i2);
            if (i3 == 0) {
                resources2 = resources3;
                i3 = i2;
            } else if (mPluginRes != null) {
                resources2 = mPluginRes;
            } else {
                resources2 = resources3;
                i3 = i2;
            }
        } else {
            resources2 = resources3;
            i3 = i2;
        }
        try {
            return resources2.getDrawable(i3);
        } catch (Throwable th) {
            try {
                return resources3.getDrawable(i2);
            } catch (Throwable th2) {
                return null;
            }
        }
    }

    public static Drawable getDrawable(Resources resources, int i) {
        return getDrawable(TbadkCoreApplication.getInst().getSkinType(), resources, i);
    }

    public static Drawable getDrawable(int i) {
        return getDrawable(TbadkCoreApplication.getInst().getSkinType(), null, i);
    }

    public static Drawable getDrawable(int i, int i2) {
        if (i == 0) {
            try {
                return BdBaseApplication.getInst().getApp().getResources().getDrawable(i2);
            } catch (Throwable th) {
                return null;
            }
        }
        return getDrawable(i, null, i2);
    }

    public static Bitmap getBitmap(Resources resources, int i, BitmapFactory.Options options) {
        return getBitmap(resources, i, options, TbadkCoreApplication.getInst().getSkinType());
    }

    public static int getVectorToDefaultResId(Resources resources, int i) {
        if (mPluginRes == null) {
            mPluginRes = resources;
        }
        com.baidu.tbadk.core.d.a.a("img", -1L, 0, "svg_load_failed", 0, "svg_load_failed", "version_code", Build.VERSION.RELEASE, "model", Build.MODEL, Constants.PHONE_BRAND, Build.BRAND);
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
                sPackagename = BdBaseApplication.getInst().getPackageName();
                sPacknameLength = sPackagename.length();
            }
            if (replace.length() > sPacknameLength && replace.charAt(sPacknameLength) != ':' && replace.startsWith(sPackagename)) {
                replace = sPackagename + replace.substring(replace.indexOf(":"));
            }
            return mPluginRes.getIdentifier(replace + "_1", null, null);
        } catch (Exception e) {
            return 0;
        }
    }

    public static Bitmap getBitmap(Resources resources, int i, BitmapFactory.Options options, int i2) {
        Resources resources2;
        int i3;
        if (i == 0) {
            return null;
        }
        Resources resources3 = resources != null ? resources : BdBaseApplication.getInst().getApp().getResources();
        if (i2 == 1) {
        }
        if (i2 == 1) {
            int c = c(resources3, i);
            if (c == 0) {
                c = i;
            } else if (mPluginRes != null) {
                Resources resources4 = mPluginRes;
            } else {
                c = i;
            }
            try {
                Bitmap nightCashBitmap = BitmapHelper.getNightCashBitmap(mPluginRes, c, i, options);
                if (nightCashBitmap == null) {
                    return BitmapHelper.getCashBitmap(i, options);
                }
                return nightCashBitmap;
            } catch (Throwable th) {
                return BitmapHelper.getCashBitmap(i, options);
            }
        } else if (i2 == 4) {
            int d = d(resources3, i);
            if (d == 0) {
                resources2 = resources3;
                i3 = i;
            } else if (mPluginRes != null) {
                i3 = d;
                resources2 = mPluginRes;
            } else {
                resources2 = resources3;
                i3 = i;
            }
            try {
                Bitmap darkCashBitmap = BitmapHelper.getDarkCashBitmap(mPluginRes, i3, i, options);
                if (darkCashBitmap == null) {
                    Bitmap nightCashBitmap2 = BitmapHelper.getNightCashBitmap(mPluginRes, c(resources2, i), i, options);
                    if (nightCashBitmap2 == null) {
                        return BitmapHelper.getCashBitmap(i, options);
                    }
                    return nightCashBitmap2;
                }
                return darkCashBitmap;
            } catch (Throwable th2) {
                return BitmapHelper.getCashBitmap(i, options);
            }
        } else if (i2 == 2) {
            int skinResourceId = getSkinResourceId(resources3, i);
            if (skinResourceId == 0) {
                return BitmapHelper.getCashBitmap(i, options);
            }
            try {
                Bitmap themeCashBitmap = BitmapHelper.getThemeCashBitmap(mSkinRes, skinResourceId, i, options);
                if (themeCashBitmap == null) {
                    return BitmapHelper.getCashBitmap(i, options);
                }
                return themeCashBitmap;
            } catch (Throwable th3) {
                return BitmapHelper.getCashBitmap(i, options);
            }
        } else {
            return BitmapHelper.getCashBitmap(i, options);
        }
    }

    public static Bitmap getBitmap(int i) {
        return getBitmap(null, i, new BitmapFactory.Options());
    }

    public static Bitmap getBitmap565Quality(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return getBitmap(null, i, options);
    }

    public static void setViewTextColor(View view, int i, int i2, int i3) {
        ColorStateList colorList;
        if (view != null && i != 0 && view.getResources() != null) {
            if (i3 == 0) {
                colorList = view.getResources().getColorStateList(i);
            } else {
                colorList = getColorList(i3, view.getResources(), i);
            }
            if (colorList != null) {
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
        }
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

    public static void setImageResource(ImageView imageView, int i) {
        if (imageView != null && i != 0) {
            imageView.setImageDrawable(getDrawable(imageView.getResources(), i));
        }
    }

    public static void setImageResource(ImageView imageView, int i, int i2) {
        if (imageView != null && i != 0) {
            Drawable drawable = null;
            if (i2 == 0) {
                try {
                    drawable = imageView.getResources().getDrawable(i);
                } catch (Throwable th) {
                }
            } else {
                drawable = getDrawable(i2, imageView.getResources(), i);
            }
            imageView.setImageDrawable(drawable);
        }
    }

    public static void setBackgroundResource(View view, int i) {
        setBackgroundResource(view, i, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void setBackgroundResource(View view, int i, int i2) {
        if (view != null && i != 0) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            view.setBackgroundDrawable(getDrawable(i2, i));
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static void setBackgroundDrawable(PopupWindow popupWindow, int i) {
        setBackgroundDrawable(popupWindow, i, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void setBackgroundDrawable(PopupWindow popupWindow, int i, int i2) {
        if (popupWindow != null && i != 0) {
            popupWindow.setBackgroundDrawable(getDrawable(i2, i));
        }
    }

    public static void setBackgroundColor(View view, int i) {
        setBackgroundColor(view, i, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void setBackgroundColor(View view, int i, int i2) {
        int color;
        if (view != null && i != 0) {
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
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static void a(View view, int i, float f, int i2) {
        int color;
        if (view != null && i != 0) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            if (i2 == 0) {
                color = view.getResources().getColor(i);
            } else {
                color = getColor(i2, view.getResources(), i);
            }
            view.setBackgroundColor(com.baidu.tieba.tbadkCore.c.n(color, f));
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static void a(TBLottieAnimationView tBLottieAnimationView, int i) {
        int kt = kt(i);
        if (kt > 0) {
            tBLottieAnimationView.setAnimation(kt);
        }
    }

    public static void b(TBLottieAnimationView tBLottieAnimationView, int i) {
        int c = c(TbadkCoreApplication.getInst().getResources(), i);
        if (c > 0) {
            tBLottieAnimationView.setAnimation(c);
        }
    }

    public static int kt(int i) {
        int d;
        if (i <= 0) {
            return 0;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 1) {
            return (skinType != 4 || (d = d(TbadkCoreApplication.getInst().getResources(), i)) <= 0) ? i : d;
        }
        int c = c(TbadkCoreApplication.getInst().getResources(), i);
        return c > 0 ? c : i;
    }

    public static int ku(int i) {
        int d;
        if (i <= 0) {
            return 0;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 1) {
            return (skinType != 4 || (d = d(TbadkCoreApplication.getInst().getResources(), i)) <= 0) ? i : d;
        }
        int c = c(TbadkCoreApplication.getInst().getResources(), i);
        return c > 0 ? c : i;
    }

    public static void a(View view, int i, int i2, int i3) {
        ColorStateList v;
        if (i != 0 && i2 != 0 && view != null && (v = v(i, i2, i3)) != null) {
            if (view instanceof Button) {
                ((Button) view).setTextColor(v);
            } else if (view instanceof EditText) {
                ((EditText) view).setTextColor(v);
            } else if (view instanceof TextView) {
                ((TextView) view).setTextColor(v);
            } else if (view instanceof CheckBox) {
                ((CheckBox) view).setTextColor(v);
            }
        }
    }

    public static void b(View view, int i, int i2) {
        a(view, i, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void b(View view, int i, int i2, int i3) {
        StateListDrawable u;
        if (i != 0 && i2 != 0 && view != null && (u = u(i, i2, i3)) != null) {
            view.setBackgroundDrawable(u);
        }
    }

    public static void c(View view, int i, int i2) {
        b(view, i, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public static StateListDrawable u(int i, int i2, int i3) {
        if (i == 0 || i2 == 0) {
            return null;
        }
        Drawable drawable = getDrawable(i3, i);
        Drawable drawable2 = getDrawable(i3, i2);
        if (drawable == null || drawable2 == null) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, drawable2);
        stateListDrawable.addState(new int[]{16842910, 16842908}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static ColorStateList v(int i, int i2, int i3) {
        if (i == 0 || i2 == 0) {
            return null;
        }
        int color = getColor(i3, i);
        int color2 = getColor(i3, i2);
        return new ColorStateList(new int[][]{new int[]{16842910, 16842919}, new int[]{16842910, 16842908}, new int[0]}, new int[]{color2, color2, color});
    }

    public static GradientDrawable c(int i, int i2, int i3, int i4, int i5) {
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
            return gradientDrawable;
        }
        return gradientDrawable;
    }

    public static GradientDrawable ay(int i, int i2) {
        if (i2 == 0) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        if (i > 0) {
            gradientDrawable.setCornerRadius(i);
            return gradientDrawable;
        }
        return gradientDrawable;
    }

    public static void a(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (view != null) {
            GradientDrawable c = c(i, i2, i4, i6, i7);
            GradientDrawable c2 = c(i, i3, i5, i6, i7);
            if (c != null && c2 != null) {
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{16842910, 16842919}, c2);
                stateListDrawable.addState(new int[]{16842910, 16842908}, c2);
                stateListDrawable.addState(new int[0], c);
                view.setBackgroundDrawable(stateListDrawable);
            }
        }
    }

    public static void c(View view, int i, int i2, int i3) {
        a(view, i, i2, i3, 0, 0, 0, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void c(View view, int i, int i2, int i3, int i4) {
        a(view, i, i2, i3, 0, 0, 0, i4);
    }

    public static Drawable kv(int i) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = getDrawable(i);
        drawable.mutate().setAlpha(127);
        stateListDrawable.addState(new int[]{16842910, 16842919}, drawable);
        stateListDrawable.addState(new int[0], getDrawable(i).mutate());
        return stateListDrawable;
    }

    public static boolean aGw() {
        return (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getResources() == null || TbadkCoreApplication.getInst().getResources().getConfiguration() == null || (TbadkCoreApplication.getInst().getResources().getConfiguration().uiMode & 48) != 32) ? false : true;
    }

    public static void w(boolean z, boolean z2) {
        boolean aGw = aGw();
        final Activity currentActivity = com.baidu.adp.base.a.eH().currentActivity();
        if (currentActivity != null) {
            if (!aGw) {
                if (z) {
                    UtilHelper.showSkinChangeAnimation(currentActivity);
                }
                if (z2) {
                    TbadkCoreApplication.getInst().setSkinTypeValue(0);
                    TbadkCoreApplication.getInst().SendSkinTypeBroadcast(0);
                    return;
                }
                TbadkCoreApplication.getInst().setSkinType(0);
            } else if (com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("key_is_dark_mode_notify_shown", false)) {
                boolean z3 = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("key_is_follow_system_mode", false);
                if (z) {
                    UtilHelper.showSkinChangeAnimation(currentActivity);
                }
                int i = z3 ? 4 : 0;
                if (z2) {
                    TbadkCoreApplication.getInst().setSkinTypeValue(i);
                    TbadkCoreApplication.getInst().SendSkinTypeBroadcast(i);
                    return;
                }
                TbadkCoreApplication.getInst().setSkinType(i);
            } else {
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("key_is_dark_mode_notify_shown", true);
                View inflate = LayoutInflater.from(currentActivity).inflate(R.layout.dark_mode_notify_dialog_layout, (ViewGroup) null);
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.util.am.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view != null) {
                            if (view.getId() == R.id.dark_notify_dialog_cancel) {
                                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("key_is_follow_system_mode", false);
                                TbadkCoreApplication.getInst().setSkinType(0);
                                TiebaStatic.log(new an("c13577").X("obj_type", 2).X("obj_locate", 2));
                            } else if (view.getId() == R.id.dark_notify_dialog_ok) {
                                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("key_is_follow_system_mode", true);
                                TbadkCoreApplication.getInst().setSkinType(am.aGw() ? 4 : 0);
                                TiebaStatic.log(new an("c13577").X("obj_type", 1).X("obj_locate", 2));
                            }
                            com.baidu.adp.lib.util.l.showToast(currentActivity, (int) R.string.dark_mode_notify_dissmis_toast);
                            if (am.FR != null) {
                                am.FR.dismiss();
                            }
                            com.baidu.tbadk.core.dialog.a unused = am.FR = null;
                        }
                    }
                };
                inflate.findViewById(R.id.dark_notify_dialog_cancel).setOnClickListener(onClickListener);
                inflate.findViewById(R.id.dark_notify_dialog_ok).setOnClickListener(onClickListener);
                TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.dark_notify_background);
                tbImageView.setConrers(15);
                tbImageView.setDrawCorner(true);
                tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32));
                tbImageView.setAutoChangeStyle(false);
                FR = new com.baidu.tbadk.core.dialog.a(currentActivity);
                FR.jZ(2);
                FR.fG(false);
                FR.fH(false);
                FR.aO(inflate);
                FR.b(com.baidu.adp.base.i.ab(currentActivity)).aEC();
            }
        }
    }
}

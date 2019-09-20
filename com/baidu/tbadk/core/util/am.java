package com.baidu.tbadk.core.util;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.v7.content.res.AppCompatResources;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.tencent.open.SocialConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class am {
    private static String bUa;
    public static Resources bUb;
    private static Resources bUc;
    private static String bUd;
    private static AssetManager bUe;
    private static SparseIntArray bUf;
    private static SparseIntArray bUg;
    private static String sPackagename;
    private static int sPacknameLength;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005017) { // from class: com.baidu.tbadk.core.util.am.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                am.bUb = null;
            }
        });
        bUa = "skinType not support";
        sPackagename = null;
        sPacknameLength = 0;
        bUf = new SparseIntArray();
        bUg = new SparseIntArray();
    }

    public static void nW(String str) throws IllegalAccessException, InstantiationException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        if (!StringUtils.isNull(str)) {
            try {
                Resources resources = TbadkCoreApplication.getInst().getResources();
                if (resources != null) {
                    bUe = (AssetManager) AssetManager.class.newInstance();
                    File nm = m.nm(str);
                    if (nm == null || !nm.exists()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), (int) R.string.theme_skin_apk_error);
                    } else {
                        bUe.getClass().getDeclaredMethod("addAssetPath", String.class).invoke(bUe, nm.getAbsolutePath());
                        bUc = new Resources(bUe, resources.getDisplayMetrics(), resources.getConfiguration());
                        bUd = m.np(str);
                    }
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    @Deprecated
    public static void a(TextView textView, int i) {
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
    public static void b(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1 || i == 4) {
                textView.setTextColor(app.getResources().getColor(R.color.common_color_10004));
            } else {
                textView.setTextColor(app.getResources().getColor(R.color.black_alpha100));
            }
        }
    }

    public static void g(View view, int i) {
        if (view != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1 || i == 4) {
                view.setBackgroundColor(app.getResources().getColor(R.color.common_color_10150));
            } else {
                view.setBackgroundColor(app.getResources().getColor(R.color.common_color_10163));
            }
        }
    }

    public static void h(View view, int i) {
        if (view != null) {
            k(view, R.drawable.common_bg);
        }
    }

    public static void c(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1 || i == 4) {
                textView.setTextColor(app.getResources().getColor(R.color.common_color_10004));
            } else {
                textView.setTextColor(app.getResources().getColor(R.color.cp_bg_line_d));
            }
        }
    }

    public static void i(View view, int i) {
        if (view != null) {
            k(view, R.drawable.titlebar_bg);
        }
    }

    public static void d(TextView textView, int i) {
        if (textView != null) {
            k(textView, R.drawable.navi_done_text_bg);
        }
        e(textView, i);
    }

    public static void e(TextView textView, int i) {
        if (textView != null) {
            f(textView, R.color.navi_done_text, 1);
        }
    }

    public static void a(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            c(imageView, (int) R.drawable.icon_topbar_return_n);
        }
    }

    public static void b(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            c(imageView, (int) R.drawable.icon_refresh_n);
        }
    }

    public static int ig(int i) {
        if (i == 1 || i == 4) {
            return BdBaseApplication.getInst().getApp().getResources().getColor(R.color.common_color_10004);
        }
        throw new IllegalArgumentException(bUa);
    }

    public static int ih(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        return (i == 1 || i == 4) ? app.getResources().getColor(R.color.common_color_10150) : app.getResources().getColor(R.color.common_color_10163);
    }

    public static int b(Resources resources, int i) {
        String str;
        int i2;
        if (bUb == null) {
            bUb = resources;
        }
        int i3 = bUf.get(i, -1);
        if (i3 == -1) {
            try {
                str = resources.getResourceName(i);
            } catch (Exception e) {
                str = null;
            }
            if (!TextUtils.isEmpty(str) && str.indexOf(":") > 0 && bUb != null) {
                if (sPacknameLength == 0) {
                    sPackagename = BdBaseApplication.getInst().getPackageName();
                    sPacknameLength = sPackagename.length();
                }
                if (str.length() > sPacknameLength && str.charAt(sPacknameLength) != ':' && str.startsWith(sPackagename)) {
                    str = sPackagename + str.substring(str.indexOf(":"));
                }
                i3 = bUb.getIdentifier(str + "_1", null, null);
                if (i3 <= 0) {
                    i2 = bUb.getIdentifier(("com.baidu.tieba.pluginResource" + str.substring(str.indexOf(":"))) + "_1", null, null);
                    bUf.put(i, i2);
                    return i2;
                }
            }
            i2 = i3;
            bUf.put(i, i2);
            return i2;
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int c(Resources resources, int i) {
        String str;
        int i2;
        if (bUb == null) {
            bUb = resources;
        }
        int i3 = bUg.get(i, -1);
        if (i3 != -1) {
            return i3;
        }
        try {
            str = resources.getResourceName(i);
        } catch (Exception e) {
            str = null;
        }
        if (!TextUtils.isEmpty(str) && str.indexOf(":") > 0 && bUb != null) {
            if (sPacknameLength == 0) {
                sPackagename = BdBaseApplication.getInst().getPackageName();
                sPacknameLength = sPackagename.length();
            }
            if (str.length() > sPacknameLength && str.charAt(sPacknameLength) != ':' && str.startsWith(sPackagename)) {
                str = sPackagename + str.substring(str.indexOf(":"));
            }
            i3 = bUb.getIdentifier(str + "_2", null, null);
            if (i3 <= 0) {
                i2 = bUb.getIdentifier(("com.baidu.tieba.pluginResource" + str.substring(str.indexOf(":"))) + "_2", null, null);
                if (i2 <= 0) {
                    i2 = b(resources, i);
                }
                bUg.put(i, i2);
                return i2;
            }
        }
        i2 = i3;
        if (i2 <= 0) {
        }
        bUg.put(i, i2);
        return i2;
    }

    public static void a(ImageView imageView, int i, int i2) {
        a(imageView, i, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void a(ImageView imageView, int i, int i2, int i3) {
        if (i != 0 && i2 != 0 && imageView != null) {
            boolean z = TbadkCoreApplication.getInst().getUsedThemeColor() == 1;
            if (i3 == 2 && TbadkCoreApplication.getInst().getUsedThemeId() > 0) {
                if (z) {
                    imageView.setImageResource(i);
                } else {
                    imageView.setImageResource(i2);
                }
            } else if (i3 == 1 || i3 == 4) {
                b(imageView, i2, i3);
            } else {
                b(imageView, i, i3);
            }
        }
    }

    public static void e(View view, int i, int i2) {
        c(view, i, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void c(View view, int i, int i2, int i3) {
        if (i != 0 && i2 != 0 && view != null) {
            boolean z = TbadkCoreApplication.getInst().getUsedThemeColor() == 1;
            if (i3 == 2 && TbadkCoreApplication.getInst().getUsedThemeId() > 0) {
                if (z) {
                    j(view, i);
                    return;
                } else {
                    j(view, i2);
                    return;
                }
            }
            j(view, i);
        }
    }

    private static int d(Resources resources, int i) {
        String str;
        if (bUc == null) {
            bUc = resources;
        }
        if (bUc == null) {
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
        return bUc.getIdentifier(bUd + str.substring(str.indexOf(":")), null, null);
    }

    public static void j(View view, int i) {
        f(view, i, 1);
    }

    public static Drawable e(Resources resources, int i) {
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
        int d = d(resources, i);
        if (d == 0) {
            resources2 = resources;
            d = i;
        } else if (bUc != null) {
            resources2 = bUc;
        } else {
            resources2 = resources;
            d = i;
        }
        try {
            return resources2.getDrawable(d);
        } catch (Throwable th) {
            return resources.getDrawable(i);
        }
    }

    public static int f(Resources resources, int i) {
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
        int d = d(resources, i);
        if (d == 0) {
            resources2 = resources;
            d = i;
        } else if (bUc != null) {
            resources2 = bUc;
        } else {
            resources2 = resources;
            d = i;
        }
        try {
            return resources2.getColor(d);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            return resources.getColor(i);
        }
    }

    public static int a(int i, Resources resources, int i2) {
        Resources resources2;
        int i3;
        if (i2 == 0) {
            return 0;
        }
        Resources resources3 = resources != null ? resources : BdBaseApplication.getInst().getApp().getResources();
        if (i == 2) {
            i3 = d(resources3, i2);
            if (i3 == 0) {
                resources2 = resources3;
                i3 = i2;
            } else if (bUc != null) {
                resources2 = bUc;
            } else {
                resources2 = resources3;
                i3 = i2;
            }
        } else if (i == 1) {
            i3 = b(resources3, i2);
            if (i3 == 0) {
                resources2 = resources3;
                i3 = i2;
            } else if (bUb != null) {
                resources2 = bUb;
            } else {
                resources2 = resources3;
                i3 = i2;
            }
        } else if (i == 4) {
            i3 = c(resources3, i2);
            if (i3 == 0) {
                resources2 = resources3;
                i3 = i2;
            } else if (bUb != null) {
                resources2 = bUb;
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
        return a(i, (Resources) null, i2);
    }

    public static int getColor(int i) {
        return a(TbadkCoreApplication.getInst().getSkinType(), (Resources) null, i);
    }

    public static ColorStateList b(int i, Resources resources, int i2) {
        int c;
        if (i2 == 0) {
            return null;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        if (i == 2) {
            int d = d(resources, i2);
            if (d != 0 && bUc != null) {
                Resources resources2 = bUc;
                i2 = d;
            }
        } else if (i == 1) {
            int b = b(resources, i2);
            if (b != 0 && bUb != null) {
                Resources resources3 = bUb;
                i2 = b;
            }
        } else if (i == 4 && (c = c(resources, i2)) != 0 && bUb != null) {
            Resources resources4 = bUb;
            i2 = c;
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

    public static ColorStateList g(Resources resources, int i) {
        return b(TbadkCoreApplication.getInst().getSkinType(), resources, i);
    }

    public static ColorStateList ii(int i) {
        return b(TbadkCoreApplication.getInst().getSkinType(), (Resources) null, i);
    }

    public static Drawable c(int i, Resources resources, int i2) {
        Resources resources2;
        int i3;
        if (i2 == 0) {
            return null;
        }
        Resources resources3 = resources != null ? resources : BdBaseApplication.getInst().getApp().getResources();
        if (i == 2) {
            i3 = d(resources3, i2);
            if (i3 == 0) {
                resources2 = resources3;
                i3 = i2;
            } else if (bUc != null) {
                resources2 = bUc;
            } else {
                resources2 = resources3;
                i3 = i2;
            }
        } else if (i == 1) {
            i3 = b(resources3, i2);
            if (i3 == 0) {
                resources2 = resources3;
                i3 = i2;
            } else if (bUb != null) {
                resources2 = bUb;
            } else {
                resources2 = resources3;
                i3 = i2;
            }
        } else if (i == 4) {
            i3 = c(resources3, i2);
            if (i3 == 0) {
                resources2 = resources3;
                i3 = i2;
            } else if (bUb != null) {
                resources2 = bUb;
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

    public static Drawable h(Resources resources, int i) {
        return c(TbadkCoreApplication.getInst().getSkinType(), resources, i);
    }

    public static Drawable getDrawable(int i) {
        return c(TbadkCoreApplication.getInst().getSkinType(), null, i);
    }

    public static Drawable V(int i, int i2) {
        if (i == 0) {
            try {
                return BdBaseApplication.getInst().getApp().getResources().getDrawable(i2);
            } catch (Throwable th) {
                return null;
            }
        }
        return c(i, null, i2);
    }

    public static Bitmap a(Resources resources, int i, BitmapFactory.Options options) {
        return a(resources, i, options, TbadkCoreApplication.getInst().getSkinType());
    }

    public static int i(Resources resources, int i) {
        if (bUb == null) {
            bUb = resources;
        }
        com.baidu.tbadk.core.e.a.a(SocialConstants.PARAM_IMG_URL, -1L, 0, "svg_load_failed", 0, "svg_load_failed", "version_code", Build.VERSION.RELEASE, "model", Build.MODEL, Constants.PHONE_BRAND, Build.BRAND);
        try {
            String resourceName = resources.getResourceName(i);
            if (StringUtils.isNull(resourceName)) {
                return 0;
            }
            String replace = resourceName.replace("_svg", "");
            if (replace.indexOf(":") <= 0 || bUb == null) {
                return 0;
            }
            if (sPacknameLength == 0) {
                sPackagename = BdBaseApplication.getInst().getPackageName();
                sPacknameLength = sPackagename.length();
            }
            if (replace.length() > sPacknameLength && replace.charAt(sPacknameLength) != ':' && replace.startsWith(sPackagename)) {
                replace = sPackagename + replace.substring(replace.indexOf(":"));
            }
            return bUb.getIdentifier(replace + "_1", null, null);
        } catch (Exception e) {
            return 0;
        }
    }

    public static Bitmap a(Resources resources, int i, BitmapFactory.Options options, int i2) {
        Resources resources2;
        int i3;
        if (i == 0) {
            return null;
        }
        Resources resources3 = resources != null ? resources : BdBaseApplication.getInst().getApp().getResources();
        if (i2 == 1) {
        }
        if (i2 == 1) {
            int b = b(resources3, i);
            if (b == 0) {
                b = i;
            } else if (bUb != null) {
                Resources resources4 = bUb;
            } else {
                b = i;
            }
            try {
                Bitmap nightCashBitmap = BitmapHelper.getNightCashBitmap(bUb, b, i, options);
                if (nightCashBitmap == null) {
                    return BitmapHelper.getCashBitmap(i, options);
                }
                return nightCashBitmap;
            } catch (Throwable th) {
                return BitmapHelper.getCashBitmap(i, options);
            }
        } else if (i2 == 4) {
            int c = c(resources3, i);
            if (c == 0) {
                resources2 = resources3;
                i3 = i;
            } else if (bUb != null) {
                i3 = c;
                resources2 = bUb;
            } else {
                resources2 = resources3;
                i3 = i;
            }
            try {
                Bitmap darkCashBitmap = BitmapHelper.getDarkCashBitmap(bUb, i3, i, options);
                if (darkCashBitmap == null) {
                    Bitmap nightCashBitmap2 = BitmapHelper.getNightCashBitmap(bUb, b(resources2, i), i, options);
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
            int d = d(resources3, i);
            if (d == 0) {
                return BitmapHelper.getCashBitmap(i, options);
            }
            try {
                Bitmap themeCashBitmap = BitmapHelper.getThemeCashBitmap(bUc, d, i, options);
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

    public static Bitmap ij(int i) {
        return a((Resources) null, i, new BitmapFactory.Options());
    }

    public static Bitmap ik(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        return a((Resources) null, i, options);
    }

    public static Bitmap il(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return a((Resources) null, i, options);
    }

    public static Bitmap W(int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return a((Resources) null, i, options, i2);
    }

    public static void d(View view, int i, int i2, int i3) {
        ColorStateList b;
        if (view != null && i != 0 && view.getResources() != null) {
            if (i3 == 0) {
                b = view.getResources().getColorStateList(i);
            } else {
                b = b(i3, view.getResources(), i);
            }
            if (b != null) {
                if (i2 == 3 && (view instanceof Button)) {
                    ((Button) view).setTextColor(b);
                } else if (i2 == 2 && (view instanceof EditText)) {
                    ((EditText) view).setTextColor(b);
                } else if (i2 == 1 && (view instanceof TextView)) {
                    ((TextView) view).setTextColor(b);
                } else if (i2 == 4 && (view instanceof CheckBox)) {
                    ((CheckBox) view).setTextColor(b);
                }
            }
        }
    }

    public static void f(View view, int i, int i2) {
        d(view, i, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public static boolean e(View view, String str) {
        Resources resources;
        int identifier;
        ColorStateList g;
        if (view == null || StringUtils.isNull(str) || (resources = view.getResources()) == null || (identifier = resources.getIdentifier(str, "color", TbadkCoreApplication.getInst().getPackageName())) <= 0 || (g = g(resources, identifier)) == null || !(view instanceof TextView)) {
            return false;
        }
        ((TextView) view).setTextColor(g);
        return true;
    }

    public static void c(ImageView imageView, int i) {
        if (imageView != null && i != 0) {
            imageView.setImageDrawable(h(imageView.getResources(), i));
        }
    }

    public static void b(ImageView imageView, int i, int i2) {
        if (imageView != null && i != 0) {
            Drawable drawable = null;
            if (i2 == 0) {
                try {
                    drawable = imageView.getResources().getDrawable(i);
                } catch (Throwable th) {
                }
            } else {
                drawable = c(i2, imageView.getResources(), i);
            }
            imageView.setImageDrawable(drawable);
        }
    }

    public static void k(View view, int i) {
        g(view, i, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void g(View view, int i, int i2) {
        if (view != null && i != 0) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            view.setBackgroundDrawable(V(i2, i));
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static void a(PopupWindow popupWindow, int i) {
        a(popupWindow, i, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void a(PopupWindow popupWindow, int i, int i2) {
        if (popupWindow != null && i != 0) {
            popupWindow.setBackgroundDrawable(V(i2, i));
        }
    }

    public static void l(View view, int i) {
        h(view, i, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void h(View view, int i, int i2) {
        int a;
        if (view != null && i != 0) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            if (i2 == 0) {
                a = view.getResources().getColor(i);
            } else {
                a = a(i2, view.getResources(), i);
            }
            view.setBackgroundColor(a);
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static void a(View view, int i, float f, int i2) {
        int a;
        if (view != null && i != 0) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            if (i2 == 0) {
                a = view.getResources().getColor(i);
            } else {
                a = a(i2, view.getResources(), i);
            }
            view.setBackgroundColor(com.baidu.tieba.tbadkCore.c.j(a, f));
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static void a(TBLottieAnimationView tBLottieAnimationView, int i) {
        int im = im(i);
        if (im > 0) {
            tBLottieAnimationView.setAnimation(im);
        }
    }

    public static int im(int i) {
        int c;
        if (i <= 0) {
            return 0;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 1) {
            return (skinType != 4 || (c = c(TbadkCoreApplication.getInst().getResources(), i)) <= 0) ? i : c;
        }
        int b = b(TbadkCoreApplication.getInst().getResources(), i);
        return b > 0 ? b : i;
    }

    public static int in(int i) {
        int c;
        if (i <= 0) {
            return 0;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != 1) {
            return (skinType != 4 || (c = c(TbadkCoreApplication.getInst().getResources(), i)) <= 0) ? i : c;
        }
        int b = b(TbadkCoreApplication.getInst().getResources(), i);
        return b > 0 ? b : i;
    }

    public static void e(View view, int i, int i2, int i3) {
        ColorStateList p;
        if (i != 0 && i2 != 0 && view != null && (p = p(i, i2, i3)) != null) {
            if (view instanceof Button) {
                ((Button) view).setTextColor(p);
            } else if (view instanceof EditText) {
                ((EditText) view).setTextColor(p);
            } else if (view instanceof TextView) {
                ((TextView) view).setTextColor(p);
            } else if (view instanceof CheckBox) {
                ((CheckBox) view).setTextColor(p);
            }
        }
    }

    public static void f(View view, int i, int i2, int i3) {
        StateListDrawable o;
        if (i != 0 && i2 != 0 && view != null && (o = o(i, i2, i3)) != null) {
            view.setBackgroundDrawable(o);
        }
    }

    public static void i(View view, int i, int i2) {
        f(view, i, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public static StateListDrawable o(int i, int i2, int i3) {
        if (i == 0 || i2 == 0) {
            return null;
        }
        Drawable V = V(i3, i);
        Drawable V2 = V(i3, i2);
        if (V == null || V2 == null) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, V2);
        stateListDrawable.addState(new int[]{16842910, 16842908}, V2);
        stateListDrawable.addState(new int[0], V);
        return stateListDrawable;
    }

    public static ColorStateList p(int i, int i2, int i3) {
        if (i == 0 || i2 == 0) {
            return null;
        }
        int color = getColor(i3, i);
        int color2 = getColor(i3, i2);
        return new ColorStateList(new int[][]{new int[]{16842910, 16842919}, new int[]{16842910, 16842908}, new int[0]}, new int[]{color2, color2, color});
    }

    public static GradientDrawable b(int i, int i2, int i3, int i4, int i5) {
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

    public static GradientDrawable a(int i, int i2, String str, int i3, int i4) {
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
            return gradientDrawable;
        }
        return gradientDrawable;
    }

    public static GradientDrawable X(int i, int i2) {
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

    public static GradientDrawable n(int i, int i2, int i3, int i4) {
        return b(i, i2, i3, i4, TbadkCoreApplication.getInst().getSkinType());
    }

    public static GradientDrawable b(int i, int i2, String str, int i3) {
        return a(i, i2, str, i3, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void a(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (view != null) {
            GradientDrawable b = b(i, i2, i4, i6, i7);
            GradientDrawable b2 = b(i, i3, i5, i6, i7);
            if (b != null && b2 != null) {
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{16842910, 16842919}, b2);
                stateListDrawable.addState(new int[]{16842910, 16842908}, b2);
                stateListDrawable.addState(new int[0], b);
                view.setBackgroundDrawable(stateListDrawable);
            }
        }
    }

    public static void g(View view, int i, int i2, int i3) {
        a(view, i, i2, i3, 0, 0, 0, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void b(View view, int i, int i2, int i3, int i4) {
        a(view, i, i2, i3, 0, 0, 0, i4);
    }

    public static Drawable io(int i) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = getDrawable(i);
        drawable.mutate().setAlpha(127);
        stateListDrawable.addState(new int[]{16842910, 16842919}, drawable);
        stateListDrawable.addState(new int[0], getDrawable(i).mutate());
        return stateListDrawable;
    }

    public static boolean ajn() {
        return (TbadkCoreApplication.getInst() == null || TbadkCoreApplication.getInst().getResources() == null || TbadkCoreApplication.getInst().getResources().getConfiguration() == null || (TbadkCoreApplication.getInst().getResources().getConfiguration().uiMode & 48) != 32) ? false : true;
    }

    public static int ajo() {
        return ajn() ? 4 : 0;
    }
}

package com.baidu.tbadk.core.util;

import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.u;
import java.io.File;
/* loaded from: classes.dex */
public class av {
    private static String LH;
    private static int LI;
    private static String XS;
    private static Resources XT;
    private static Resources XU;
    private static String XV;
    private static AssetManager XW;

    static {
        MessageManager.getInstance().registerListener(new aw(CmdConfigCustom.METHOD_NIGHTRES_PLUGIN_CHANGE));
        XS = "skinType not support";
        LH = null;
        LI = 0;
    }

    public static void dt(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                Resources resources = TbadkCoreApplication.m9getInst().getResources();
                if (resources != null) {
                    XW = (AssetManager) AssetManager.class.newInstance();
                    File cR = m.cR(str);
                    if (cR == null || !cR.exists()) {
                        com.baidu.adp.lib.util.k.showToast(BdBaseApplication.getInst().getApp(), u.j.theme_skin_apk_error);
                    } else {
                        XW.getClass().getDeclaredMethod("addAssetPath", String.class).invoke(XW, cR.getAbsolutePath());
                        XU = new Resources(XW, resources.getDisplayMetrics(), resources.getConfiguration());
                        XV = m.cS(str);
                    }
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    @Deprecated
    public static void b(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(u.d.common_color_10212));
            } else {
                textView.setTextColor(app.getResources().getColor(u.d.cp_bg_line_d));
            }
        }
    }

    @Deprecated
    public static void c(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(u.d.common_color_10004));
            } else {
                textView.setTextColor(app.getResources().getColor(u.d.cp_bg_line_k));
            }
        }
    }

    public static void d(TextView textView, int i) {
        if (textView != null) {
            c(textView, u.d.cp_cont_b, 1);
        }
    }

    public static void g(View view, int i) {
        if (view != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                view.setBackgroundColor(app.getResources().getColor(u.d.common_color_10150));
            } else {
                view.setBackgroundColor(app.getResources().getColor(u.d.common_color_10163));
            }
        }
    }

    public static void h(View view, int i) {
        if (view != null) {
            k(view, u.f.common_bg);
        }
    }

    public static void e(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(u.d.common_color_10004));
            } else {
                textView.setTextColor(app.getResources().getColor(u.d.cp_bg_line_d));
            }
        }
    }

    public static void i(View view, int i) {
        if (view != null) {
            k(view, u.f.titlebar_bg);
        }
    }

    public static void f(TextView textView, int i) {
        if (textView != null) {
            k(textView, u.f.title_comm);
        }
        e(textView, i);
    }

    public static void g(TextView textView, int i) {
        if (textView != null) {
            k(textView, u.f.navi_done_text_bg);
        }
        h(textView, i);
    }

    public static void h(TextView textView, int i) {
        if (textView != null) {
            c(textView, u.d.navi_done_text, 1);
        }
    }

    public static void i(TextView textView, int i) {
        j(textView, i);
    }

    public static void j(TextView textView, int i) {
        if (textView != null) {
            c(textView, u.d.navi_op_text, 1);
        }
    }

    public static void a(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            c(imageView, u.f.icon_return_old_n);
        }
    }

    public static void b(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            c(imageView, u.f.icon_refresh_n);
        }
    }

    public static int cx(int i) {
        if (i == 1) {
            return BdBaseApplication.getInst().getApp().getResources().getColor(u.d.common_color_10004);
        }
        throw new IllegalArgumentException(XS);
    }

    public static int cy(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        return i == 1 ? app.getResources().getColor(u.d.common_color_10150) : app.getResources().getColor(u.d.common_color_10163);
    }

    public static void a(ListView listView, int i) {
        if (listView != null) {
            listView.setSelector(getDrawable(u.f.list_selector));
        }
    }

    public static int a(Resources resources, int i) {
        String str;
        if (XT == null) {
            XT = resources;
        }
        try {
            str = resources.getResourceName(i);
        } catch (Exception e) {
            str = null;
        }
        if (TextUtils.isEmpty(str) || str.indexOf(":") <= 0 || XT == null) {
            return 0;
        }
        if (LI == 0) {
            LH = BdBaseApplication.getInst().getPackageName();
            LI = LH.length();
        }
        if (str.length() > LI && str.charAt(LI) != ':' && str.startsWith(LH)) {
            str = String.valueOf(LH) + str.substring(str.indexOf(":"));
        }
        return XT.getIdentifier(String.valueOf(str) + "_1", null, null);
    }

    public static void a(ImageView imageView, int i, int i2) {
        a(imageView, i, i2, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public static void a(ImageView imageView, int i, int i2, int i3) {
        if (i != 0 && i2 != 0 && imageView != null) {
            boolean z = TbadkCoreApplication.m9getInst().getUsedThemeColor() == 1;
            if (i3 == 2 && TbadkCoreApplication.m9getInst().getUsedThemeId() > 0) {
                if (z) {
                    imageView.setImageResource(i);
                } else {
                    imageView.setImageResource(i2);
                }
            } else if (i3 == 1) {
                b(imageView, i2, i3);
            } else {
                b(imageView, i, i3);
            }
        }
    }

    public static void a(ImageView imageView, int i, int i2, int i3, int i4) {
        if (i != 0 && i2 != 0 && imageView != null) {
            boolean z = TbadkCoreApplication.m9getInst().getUsedThemeColor() == 1;
            if (i4 == 2 && TbadkCoreApplication.m9getInst().getUsedThemeId() > 0) {
                if (z) {
                    imageView.setImageResource(i);
                } else {
                    imageView.setImageResource(i2);
                }
            } else if (i4 == 1) {
                b(imageView, i3, i4);
            } else {
                b(imageView, i, i4);
            }
        }
    }

    public static void b(View view, int i, int i2) {
        a(view, i, i2, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public static void a(View view, int i, int i2, int i3) {
        if (i != 0 && i2 != 0 && view != null) {
            boolean z = TbadkCoreApplication.m9getInst().getUsedThemeColor() == 1;
            if (i3 == 2 && TbadkCoreApplication.m9getInst().getUsedThemeId() > 0) {
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

    private static int b(Resources resources, int i) {
        String str;
        if (XU == null) {
            XU = resources;
        }
        if (XU == null) {
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
        return XU.getIdentifier(String.valueOf(XV) + str.substring(str.indexOf(":")), null, null);
    }

    public static void j(View view, int i) {
        c(view, i, 1);
    }

    public static Drawable c(Resources resources, int i) {
        Resources resources2;
        if (i == 0) {
            return null;
        }
        if (TbadkCoreApplication.m9getInst().getUsedThemeId() <= 0 || TbadkCoreApplication.m9getInst().getSkinType() != 2) {
            return getDrawable(i);
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        int b = b(resources, i);
        if (b == 0) {
            resources2 = resources;
            b = i;
        } else if (XU != null) {
            resources2 = XU;
        } else {
            resources2 = resources;
            b = i;
        }
        try {
            return resources2.getDrawable(b);
        } catch (Throwable th) {
            return resources.getDrawable(i);
        }
    }

    public static int d(Resources resources, int i) {
        Resources resources2;
        if (i == 0) {
            return 0;
        }
        if (TbadkCoreApplication.m9getInst().getUsedThemeId() <= 0 || TbadkCoreApplication.m9getInst().getSkinType() != 2) {
            return getColor(i);
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        int b = b(resources, i);
        if (b == 0) {
            resources2 = resources;
            b = i;
        } else if (XU != null) {
            resources2 = XU;
        } else {
            resources2 = resources;
            b = i;
        }
        try {
            return resources2.getColor(b);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            return resources.getColor(i);
        }
    }

    public static int e(Resources resources, int i) {
        Resources resources2;
        int i2;
        if (i == 0) {
            return 0;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            i2 = b(resources, i);
            if (i2 == 0) {
                resources2 = resources;
                i2 = i;
            } else if (XU != null) {
                resources2 = XU;
            } else {
                resources2 = resources;
                i2 = i;
            }
        } else if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            i2 = a(resources, i);
            if (i2 == 0) {
                resources2 = resources;
                i2 = i;
            } else if (XT != null) {
                resources2 = XT;
            } else {
                resources2 = resources;
                i2 = i;
            }
        } else {
            resources2 = resources;
            i2 = i;
        }
        try {
            return resources2.getColor(i2);
        } catch (Throwable th) {
            return resources.getColor(i);
        }
    }

    public static int getColor(int i) {
        return e((Resources) null, i);
    }

    public static ColorStateList f(Resources resources, int i) {
        Resources resources2;
        int i2;
        if (i == 0) {
            return null;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            i2 = b(resources, i);
            if (i2 == 0) {
                resources2 = resources;
                i2 = i;
            } else if (XU != null) {
                resources2 = XU;
            } else {
                resources2 = resources;
                i2 = i;
            }
        } else if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            i2 = a(resources, i);
            if (i2 == 0) {
                resources2 = resources;
                i2 = i;
            } else if (XT != null) {
                resources2 = XT;
            } else {
                resources2 = resources;
                i2 = i;
            }
        } else {
            resources2 = resources;
            i2 = i;
        }
        try {
            return resources2.getColorStateList(i2);
        } catch (Throwable th) {
            return resources.getColorStateList(i);
        }
    }

    public static ColorStateList cz(int i) {
        return f((Resources) null, i);
    }

    public static Drawable g(Resources resources, int i) {
        Resources resources2;
        int i2;
        if (i == 0) {
            return null;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
            i2 = b(resources, i);
            if (i2 == 0) {
                resources2 = resources;
                i2 = i;
            } else if (XU != null) {
                resources2 = XU;
            } else {
                resources2 = resources;
                i2 = i;
            }
        } else if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
            i2 = a(resources, i);
            if (i2 == 0) {
                resources2 = resources;
                i2 = i;
            } else if (XT != null) {
                resources2 = XT;
            } else {
                resources2 = resources;
                i2 = i;
            }
        } else {
            resources2 = resources;
            i2 = i;
        }
        try {
            return resources2.getDrawable(i2);
        } catch (Throwable th) {
            try {
                return resources.getDrawable(i);
            } catch (Throwable th2) {
                return null;
            }
        }
    }

    public static Drawable getDrawable(int i) {
        return g((Resources) null, i);
    }

    public static Drawable o(int i, int i2) {
        if (i == 0) {
            try {
                return BdBaseApplication.getInst().getApp().getResources().getDrawable(i2);
            } catch (Throwable th) {
                return null;
            }
        }
        return getDrawable(i2);
    }

    public static Bitmap a(Resources resources, int i, BitmapFactory.Options options) {
        return a(resources, i, options, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public static Bitmap a(Resources resources, int i, BitmapFactory.Options options, int i2) {
        if (i == 0) {
            return null;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        if (i2 == 1) {
            int a = a(resources, i);
            if (a == 0) {
                a = i;
            } else if (XT != null) {
                Resources resources2 = XT;
            } else {
                a = i;
            }
            try {
                Bitmap nightCashBitmap = BitmapHelper.getNightCashBitmap(XT, a, i, options);
                if (nightCashBitmap == null) {
                    return BitmapHelper.getCashBitmap(i, options);
                }
                return nightCashBitmap;
            } catch (Throwable th) {
                return BitmapHelper.getCashBitmap(i, options);
            }
        } else if (i2 == 2) {
            int b = b(resources, i);
            if (b == 0) {
                return BitmapHelper.getCashBitmap(i, options);
            }
            try {
                Bitmap themeCashBitmap = BitmapHelper.getThemeCashBitmap(XU, b, i, options);
                if (themeCashBitmap == null) {
                    return BitmapHelper.getCashBitmap(i, options);
                }
                return themeCashBitmap;
            } catch (Throwable th2) {
                return BitmapHelper.getCashBitmap(i, options);
            }
        } else {
            return BitmapHelper.getCashBitmap(i, options);
        }
    }

    public static Bitmap cA(int i) {
        return a((Resources) null, i, new BitmapFactory.Options());
    }

    public static Bitmap cB(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        return a((Resources) null, i, options);
    }

    public static Bitmap p(int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        return a((Resources) null, i, options, i2);
    }

    public static Bitmap cC(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return a((Resources) null, i, options);
    }

    public static void b(View view, int i, int i2, int i3) {
        ColorStateList f;
        if (view != null && i != 0) {
            if (i3 == 0) {
                f = view.getResources().getColorStateList(i);
            } else {
                f = f(view.getResources(), i);
            }
            if (i2 == 3 && (view instanceof Button)) {
                ((Button) view).setTextColor(f);
            } else if (i2 == 2 && (view instanceof EditText)) {
                ((EditText) view).setTextColor(f);
            } else if (i2 == 1 && (view instanceof TextView)) {
                ((TextView) view).setTextColor(f);
            }
        }
    }

    public static void c(View view, int i, int i2) {
        if (view != null && i != 0) {
            ColorStateList f = f(view.getResources(), i);
            if (i2 == 3 && (view instanceof Button)) {
                ((Button) view).setTextColor(f);
            } else if (i2 == 2 && (view instanceof EditText)) {
                ((EditText) view).setTextColor(f);
            } else if (i2 == 1 && (view instanceof TextView)) {
                ((TextView) view).setTextColor(f);
            }
        }
    }

    public static boolean a(View view, String str) {
        Resources resources;
        int identifier;
        ColorStateList f;
        if (view == null || StringUtils.isNull(str) || (resources = view.getResources()) == null || (identifier = resources.getIdentifier(str, "color", TbadkCoreApplication.m9getInst().getPackageName())) <= 0 || (f = f(resources, identifier)) == null || !(view instanceof TextView)) {
            return false;
        }
        ((TextView) view).setTextColor(f);
        return true;
    }

    public static void c(ImageView imageView, int i) {
        if (imageView != null && i != 0) {
            imageView.setImageDrawable(g(imageView.getResources(), i));
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
                drawable = g(imageView.getResources(), i);
            }
            imageView.setImageDrawable(drawable);
        }
    }

    public static void k(View view, int i) {
        if (view != null && i != 0) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            view.setBackgroundDrawable(g(view.getResources(), i));
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static void d(View view, int i, int i2) {
        if (view != null && i != 0) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            view.setBackgroundDrawable(o(i2, i));
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static void l(View view, int i) {
        if (view != null && i != 0) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            view.setBackgroundColor(e(view.getResources(), i));
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static void e(View view, int i, int i2) {
        int e;
        if (view != null && i != 0) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            if (i2 == 0) {
                e = view.getResources().getColor(i);
            } else {
                e = e(view.getResources(), i);
            }
            view.setBackgroundColor(e);
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }
}

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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.r;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class ar {
    private static String NT;
    private static int NU;
    private static String abt;
    private static Resources abu;
    private static Resources abv;
    private static String abw;
    private static AssetManager abx;

    static {
        MessageManager.getInstance().registerListener(new as(CmdConfigCustom.METHOD_NIGHTRES_PLUGIN_CHANGE));
        abt = "skinType not support";
        NT = null;
        NU = 0;
    }

    public static void dw(String str) throws IllegalAccessException, InstantiationException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        if (!StringUtils.isNull(str)) {
            try {
                Resources resources = TbadkCoreApplication.m9getInst().getResources();
                if (resources != null) {
                    abx = (AssetManager) AssetManager.class.newInstance();
                    File cZ = m.cZ(str);
                    if (cZ == null || !cZ.exists()) {
                        com.baidu.adp.lib.util.k.showToast(BdBaseApplication.getInst().getApp(), r.j.theme_skin_apk_error);
                    } else {
                        abx.getClass().getDeclaredMethod("addAssetPath", String.class).invoke(abx, cZ.getAbsolutePath());
                        abv = new Resources(abx, resources.getDisplayMetrics(), resources.getConfiguration());
                        abw = m.da(str);
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
                textView.setTextColor(app.getResources().getColor(r.d.common_color_10212));
            } else {
                textView.setTextColor(app.getResources().getColor(r.d.cp_bg_line_d));
            }
        }
    }

    @Deprecated
    public static void c(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(r.d.common_color_10004));
            } else {
                textView.setTextColor(app.getResources().getColor(r.d.cp_bg_line_k));
            }
        }
    }

    public static void d(TextView textView, int i) {
        if (textView != null) {
            c(textView, r.d.cp_cont_b, 1);
        }
    }

    public static void g(View view, int i) {
        if (view != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                view.setBackgroundColor(app.getResources().getColor(r.d.common_color_10150));
            } else {
                view.setBackgroundColor(app.getResources().getColor(r.d.common_color_10163));
            }
        }
    }

    public static void h(View view, int i) {
        if (view != null) {
            k(view, r.f.common_bg);
        }
    }

    public static void e(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(r.d.common_color_10004));
            } else {
                textView.setTextColor(app.getResources().getColor(r.d.cp_bg_line_d));
            }
        }
    }

    public static void i(View view, int i) {
        if (view != null) {
            k(view, r.f.titlebar_bg);
        }
    }

    public static void f(TextView textView, int i) {
        if (textView != null) {
            k(textView, r.f.title_comm);
        }
        e(textView, i);
    }

    public static void g(TextView textView, int i) {
        if (textView != null) {
            k(textView, r.f.navi_done_text_bg);
        }
        h(textView, i);
    }

    public static void h(TextView textView, int i) {
        if (textView != null) {
            c(textView, r.d.navi_done_text, 1);
        }
    }

    public static void i(TextView textView, int i) {
        j(textView, i);
    }

    public static void j(TextView textView, int i) {
        if (textView != null) {
            c(textView, r.d.navi_op_text, 1);
        }
    }

    public static void a(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            c(imageView, r.f.icon_return_old_n);
        }
    }

    public static void b(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            c(imageView, r.f.icon_refresh_n);
        }
    }

    public static int cN(int i) {
        if (i == 1) {
            return BdBaseApplication.getInst().getApp().getResources().getColor(r.d.common_color_10004);
        }
        throw new IllegalArgumentException(abt);
    }

    public static int cO(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        return i == 1 ? app.getResources().getColor(r.d.common_color_10150) : app.getResources().getColor(r.d.common_color_10163);
    }

    public static void b(ListView listView, int i) {
        if (listView != null) {
            listView.setSelector(getDrawable(r.f.list_selector));
        }
    }

    public static int a(Resources resources, int i) {
        String str;
        if (abu == null) {
            abu = resources;
        }
        try {
            str = resources.getResourceName(i);
        } catch (Exception e) {
            str = null;
        }
        if (TextUtils.isEmpty(str) || str.indexOf(":") <= 0 || abu == null) {
            return 0;
        }
        if (NU == 0) {
            NT = BdBaseApplication.getInst().getPackageName();
            NU = NT.length();
        }
        if (str.length() > NU && str.charAt(NU) != ':' && str.startsWith(NT)) {
            str = String.valueOf(NT) + str.substring(str.indexOf(":"));
        }
        return abu.getIdentifier(String.valueOf(str) + "_1", null, null);
    }

    public static void b(ImageView imageView, int i, int i2) {
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
                c(imageView, i2, i3);
            } else {
                c(imageView, i, i3);
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
                c(imageView, i3, i4);
            } else {
                c(imageView, i, i4);
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
        if (abv == null) {
            abv = resources;
        }
        if (abv == null) {
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
        return abv.getIdentifier(String.valueOf(abw) + str.substring(str.indexOf(":")), null, null);
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
        } else if (abv != null) {
            resources2 = abv;
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
        } else if (abv != null) {
            resources2 = abv;
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

    public static int a(int i, Resources resources, int i2) {
        Resources resources2;
        int i3;
        if (i2 == 0) {
            return 0;
        }
        Resources resources3 = resources != null ? resources : BdBaseApplication.getInst().getApp().getResources();
        if (i == 2) {
            i3 = b(resources3, i2);
            if (i3 == 0) {
                resources2 = resources3;
                i3 = i2;
            } else if (abv != null) {
                resources2 = abv;
            } else {
                resources2 = resources3;
                i3 = i2;
            }
        } else if (i == 1) {
            i3 = a(resources3, i2);
            if (i3 == 0) {
                resources2 = resources3;
                i3 = i2;
            } else if (abu != null) {
                resources2 = abu;
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
        return a(TbadkCoreApplication.m9getInst().getSkinType(), (Resources) null, i);
    }

    public static ColorStateList b(int i, Resources resources, int i2) {
        Resources resources2;
        int i3;
        if (i2 == 0) {
            return null;
        }
        Resources resources3 = resources != null ? resources : BdBaseApplication.getInst().getApp().getResources();
        if (i == 2) {
            i3 = b(resources3, i2);
            if (i3 == 0) {
                resources2 = resources3;
                i3 = i2;
            } else if (abv != null) {
                resources2 = abv;
            } else {
                resources2 = resources3;
                i3 = i2;
            }
        } else if (i == 1) {
            i3 = a(resources3, i2);
            if (i3 == 0) {
                resources2 = resources3;
                i3 = i2;
            } else if (abu != null) {
                resources2 = abu;
            } else {
                resources2 = resources3;
                i3 = i2;
            }
        } else {
            resources2 = resources3;
            i3 = i2;
        }
        try {
            return resources2.getColorStateList(i3);
        } catch (Throwable th) {
            return resources3.getColorStateList(i2);
        }
    }

    public static ColorStateList e(Resources resources, int i) {
        return b(TbadkCoreApplication.m9getInst().getSkinType(), resources, i);
    }

    public static ColorStateList cP(int i) {
        return b(TbadkCoreApplication.m9getInst().getSkinType(), (Resources) null, i);
    }

    public static Drawable c(int i, Resources resources, int i2) {
        Resources resources2;
        int i3;
        if (i2 == 0) {
            return null;
        }
        Resources resources3 = resources != null ? resources : BdBaseApplication.getInst().getApp().getResources();
        if (i == 2) {
            i3 = b(resources3, i2);
            if (i3 == 0) {
                resources2 = resources3;
                i3 = i2;
            } else if (abv != null) {
                resources2 = abv;
            } else {
                resources2 = resources3;
                i3 = i2;
            }
        } else if (i == 1) {
            i3 = a(resources3, i2);
            if (i3 == 0) {
                resources2 = resources3;
                i3 = i2;
            } else if (abu != null) {
                resources2 = abu;
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

    public static Drawable f(Resources resources, int i) {
        return c(TbadkCoreApplication.m9getInst().getSkinType(), resources, i);
    }

    public static Drawable getDrawable(int i) {
        return c(TbadkCoreApplication.m9getInst().getSkinType(), (Resources) null, i);
    }

    public static Drawable q(int i, int i2) {
        if (i == 0) {
            try {
                return BdBaseApplication.getInst().getApp().getResources().getDrawable(i2);
            } catch (Throwable th) {
                return null;
            }
        }
        return c(i, (Resources) null, i2);
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
            } else if (abu != null) {
                Resources resources2 = abu;
            } else {
                a = i;
            }
            try {
                Bitmap nightCashBitmap = BitmapHelper.getNightCashBitmap(abu, a, i, options);
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
                Bitmap themeCashBitmap = BitmapHelper.getThemeCashBitmap(abv, b, i, options);
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

    public static Bitmap cQ(int i) {
        return a((Resources) null, i, new BitmapFactory.Options());
    }

    public static Bitmap cR(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        return a((Resources) null, i, options);
    }

    public static Bitmap r(int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        return a((Resources) null, i, options, i2);
    }

    public static Bitmap cS(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return a((Resources) null, i, options);
    }

    public static void b(View view, int i, int i2, int i3) {
        ColorStateList b;
        if (view != null && i != 0) {
            if (i3 == 0) {
                b = view.getResources().getColorStateList(i);
            } else {
                b = b(i3, view.getResources(), i);
            }
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

    public static void c(View view, int i, int i2) {
        b(view, i, i2, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public static boolean a(View view, String str) {
        Resources resources;
        int identifier;
        ColorStateList e;
        if (view == null || StringUtils.isNull(str) || (resources = view.getResources()) == null || (identifier = resources.getIdentifier(str, "color", TbadkCoreApplication.m9getInst().getPackageName())) <= 0 || (e = e(resources, identifier)) == null || !(view instanceof TextView)) {
            return false;
        }
        ((TextView) view).setTextColor(e);
        return true;
    }

    public static void c(ImageView imageView, int i) {
        if (imageView != null && i != 0) {
            imageView.setImageDrawable(f(imageView.getResources(), i));
        }
    }

    public static void c(ImageView imageView, int i, int i2) {
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
        d(view, i, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public static void d(View view, int i, int i2) {
        if (view != null && i != 0) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            view.setBackgroundDrawable(q(i2, i));
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static void a(PopupWindow popupWindow, int i) {
        a(popupWindow, i, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public static void a(PopupWindow popupWindow, int i, int i2) {
        if (popupWindow != null && i != 0) {
            popupWindow.setBackgroundDrawable(q(i2, i));
        }
    }

    public static void l(View view, int i) {
        e(view, i, TbadkCoreApplication.m9getInst().getSkinType());
    }

    public static void e(View view, int i, int i2) {
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
}

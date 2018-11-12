package com.baidu.tbadk.core.util;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.content.res.AppCompatResources;
import android.text.TextUtils;
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
import com.baidu.tieba.e;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class al {
    private static String ayG;
    private static Resources ayH;
    private static Resources ayI;
    private static String ayJ;
    private static AssetManager ayK;
    private static String sPackagename;
    private static int sPacknameLength;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2005017) { // from class: com.baidu.tbadk.core.util.al.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Resources unused = al.ayH = null;
            }
        });
        ayG = "skinType not support";
        sPackagename = null;
        sPacknameLength = 0;
    }

    public static void fk(String str) throws IllegalAccessException, InstantiationException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        if (!StringUtils.isNull(str)) {
            try {
                Resources resources = TbadkCoreApplication.getInst().getResources();
                if (resources != null) {
                    ayK = (AssetManager) AssetManager.class.newInstance();
                    File eC = l.eC(str);
                    if (eC == null || !eC.exists()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), e.j.theme_skin_apk_error);
                    } else {
                        ayK.getClass().getDeclaredMethod("addAssetPath", String.class).invoke(ayK, eC.getAbsolutePath());
                        ayI = new Resources(ayK, resources.getDisplayMetrics(), resources.getConfiguration());
                        ayJ = l.eF(str);
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
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(e.d.common_color_10212));
            } else {
                textView.setTextColor(app.getResources().getColor(e.d.cp_bg_line_d));
            }
        }
    }

    @Deprecated
    public static void b(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(e.d.common_color_10004));
            } else {
                textView.setTextColor(app.getResources().getColor(e.d.cp_bg_line_k));
            }
        }
    }

    public static void e(View view, int i) {
        if (view != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                view.setBackgroundColor(app.getResources().getColor(e.d.common_color_10150));
            } else {
                view.setBackgroundColor(app.getResources().getColor(e.d.common_color_10163));
            }
        }
    }

    public static void f(View view, int i) {
        if (view != null) {
            i(view, e.f.common_bg);
        }
    }

    public static void c(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(e.d.common_color_10004));
            } else {
                textView.setTextColor(app.getResources().getColor(e.d.cp_bg_line_d));
            }
        }
    }

    public static void g(View view, int i) {
        if (view != null) {
            i(view, e.f.titlebar_bg);
        }
    }

    public static void d(TextView textView, int i) {
        if (textView != null) {
            i(textView, e.f.navi_done_text_bg);
        }
        e(textView, i);
    }

    public static void e(TextView textView, int i) {
        if (textView != null) {
            c(textView, e.d.navi_done_text, 1);
        }
    }

    public static void f(TextView textView, int i) {
        g(textView, i);
    }

    public static void g(TextView textView, int i) {
        if (textView != null) {
            c(textView, e.d.navi_op_text, 1);
        }
    }

    public static void a(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            c(imageView, e.f.icon_topbar_return_n);
        }
    }

    public static void b(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            c(imageView, e.f.icon_refresh_n);
        }
    }

    public static int dx(int i) {
        if (i == 1) {
            return BdBaseApplication.getInst().getApp().getResources().getColor(e.d.common_color_10004);
        }
        throw new IllegalArgumentException(ayG);
    }

    public static int dy(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        return i == 1 ? app.getResources().getColor(e.d.common_color_10150) : app.getResources().getColor(e.d.common_color_10163);
    }

    public static int a(Resources resources, int i) {
        String str;
        if (ayH == null) {
            ayH = resources;
        }
        try {
            str = resources.getResourceName(i);
        } catch (Exception e) {
            str = null;
        }
        if (TextUtils.isEmpty(str) || str.indexOf(":") <= 0 || ayH == null) {
            return 0;
        }
        if (sPacknameLength == 0) {
            sPackagename = BdBaseApplication.getInst().getPackageName();
            sPacknameLength = sPackagename.length();
        }
        if (str.length() > sPacknameLength && str.charAt(sPacknameLength) != ':' && str.startsWith(sPackagename)) {
            str = sPackagename + str.substring(str.indexOf(":"));
        }
        return ayH.getIdentifier(str + "_1", null, null);
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
            } else if (i3 == 1) {
                b(imageView, i2, i3);
            } else {
                b(imageView, i, i3);
            }
        }
    }

    public static void a(ImageView imageView, int i, int i2, int i3, int i4) {
        if (i != 0 && i2 != 0 && imageView != null) {
            boolean z = TbadkCoreApplication.getInst().getUsedThemeColor() == 1;
            if (i4 == 2 && TbadkCoreApplication.getInst().getUsedThemeId() > 0) {
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
        a(view, i, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void a(View view, int i, int i2, int i3) {
        if (i != 0 && i2 != 0 && view != null) {
            boolean z = TbadkCoreApplication.getInst().getUsedThemeColor() == 1;
            if (i3 == 2 && TbadkCoreApplication.getInst().getUsedThemeId() > 0) {
                if (z) {
                    h(view, i);
                    return;
                } else {
                    h(view, i2);
                    return;
                }
            }
            h(view, i);
        }
    }

    private static int b(Resources resources, int i) {
        String str;
        if (ayI == null) {
            ayI = resources;
        }
        if (ayI == null) {
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
        return ayI.getIdentifier(ayJ + str.substring(str.indexOf(":")), null, null);
    }

    public static void h(View view, int i) {
        c(view, i, 1);
    }

    public static Drawable c(Resources resources, int i) {
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
        int b = b(resources, i);
        if (b == 0) {
            resources2 = resources;
            b = i;
        } else if (ayI != null) {
            resources2 = ayI;
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
        if (TbadkCoreApplication.getInst().getUsedThemeId() <= 0 || TbadkCoreApplication.getInst().getSkinType() != 2) {
            return getColor(i);
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        int b = b(resources, i);
        if (b == 0) {
            resources2 = resources;
            b = i;
        } else if (ayI != null) {
            resources2 = ayI;
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
            } else if (ayI != null) {
                resources2 = ayI;
            } else {
                resources2 = resources3;
                i3 = i2;
            }
        } else if (i == 1) {
            i3 = a(resources3, i2);
            if (i3 == 0) {
                resources2 = resources3;
                i3 = i2;
            } else if (ayH != null) {
                resources2 = ayH;
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
        int a;
        if (i2 == 0) {
            return null;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        if (i == 2) {
            int b = b(resources, i2);
            if (b != 0 && ayI != null) {
                Resources resources2 = ayI;
                i2 = b;
            }
        } else if (i == 1 && (a = a(resources, i2)) != 0 && ayH != null) {
            Resources resources3 = ayH;
            i2 = a;
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

    public static ColorStateList e(Resources resources, int i) {
        return b(TbadkCoreApplication.getInst().getSkinType(), resources, i);
    }

    public static ColorStateList dz(int i) {
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
            i3 = b(resources3, i2);
            if (i3 == 0) {
                resources2 = resources3;
                i3 = i2;
            } else if (ayI != null) {
                resources2 = ayI;
            } else {
                resources2 = resources3;
                i3 = i2;
            }
        } else if (i == 1) {
            i3 = a(resources3, i2);
            if (i3 == 0) {
                resources2 = resources3;
                i3 = i2;
            } else if (ayH != null) {
                resources2 = ayH;
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
        return c(TbadkCoreApplication.getInst().getSkinType(), resources, i);
    }

    public static Drawable getDrawable(int i) {
        return c(TbadkCoreApplication.getInst().getSkinType(), (Resources) null, i);
    }

    public static Drawable x(int i, int i2) {
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
        return a(resources, i, options, TbadkCoreApplication.getInst().getSkinType());
    }

    public static int g(Resources resources, int i) {
        if (ayH == null) {
            ayH = resources;
        }
        com.baidu.tbadk.core.d.a.a(SocialConstants.PARAM_IMG_URL, -1L, 0, "svg_load_failed", 0, "svg_load_failed", "version_code", Build.VERSION.RELEASE, "model", Build.MODEL, "brand", Build.BRAND);
        try {
            String resourceName = resources.getResourceName(i);
            if (StringUtils.isNull(resourceName)) {
                return 0;
            }
            String replace = resourceName.replace("_svg", "");
            if (replace.indexOf(":") <= 0 || ayH == null) {
                return 0;
            }
            if (sPacknameLength == 0) {
                sPackagename = BdBaseApplication.getInst().getPackageName();
                sPacknameLength = sPackagename.length();
            }
            if (replace.length() > sPacknameLength && replace.charAt(sPacknameLength) != ':' && replace.startsWith(sPackagename)) {
                replace = sPackagename + replace.substring(replace.indexOf(":"));
            }
            return ayH.getIdentifier(replace + "_1", null, null);
        } catch (Exception e) {
            return 0;
        }
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
            } else if (ayH != null) {
                Resources resources2 = ayH;
            } else {
                a = i;
            }
            try {
                Bitmap nightCashBitmap = BitmapHelper.getNightCashBitmap(ayH, a, i, options);
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
                Bitmap themeCashBitmap = BitmapHelper.getThemeCashBitmap(ayI, b, i, options);
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

    public static Bitmap dA(int i) {
        return a((Resources) null, i, new BitmapFactory.Options());
    }

    public static Bitmap dB(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        return a((Resources) null, i, options);
    }

    public static Bitmap y(int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        return a((Resources) null, i, options, i2);
    }

    public static Bitmap dC(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return a((Resources) null, i, options);
    }

    public static Bitmap z(int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return a((Resources) null, i, options, i2);
    }

    public static void b(View view, int i, int i2, int i3) {
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

    public static void c(View view, int i, int i2) {
        b(view, i, i2, TbadkCoreApplication.getInst().getSkinType());
    }

    public static boolean d(View view, String str) {
        Resources resources;
        int identifier;
        ColorStateList e;
        if (view == null || StringUtils.isNull(str) || (resources = view.getResources()) == null || (identifier = resources.getIdentifier(str, "color", TbadkCoreApplication.getInst().getPackageName())) <= 0 || (e = e(resources, identifier)) == null || !(view instanceof TextView)) {
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

    public static void i(View view, int i) {
        d(view, i, TbadkCoreApplication.getInst().getSkinType());
    }

    public static void d(View view, int i, int i2) {
        if (view != null && i != 0) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            view.setBackgroundDrawable(x(i2, i));
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
            popupWindow.setBackgroundDrawable(x(i2, i));
        }
    }

    public static void j(View view, int i) {
        e(view, i, TbadkCoreApplication.getInst().getSkinType());
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

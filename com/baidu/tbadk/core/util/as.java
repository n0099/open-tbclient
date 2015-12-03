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
import com.baidu.tieba.n;
import java.io.File;
/* loaded from: classes.dex */
public class as {
    private static String Tv;
    private static int Tw;
    private static String abN;
    private static Resources abO;
    private static Resources abP;
    private static String abQ;
    private static AssetManager abR;

    static {
        MessageManager.getInstance().registerListener(new at(CmdConfigCustom.METHOD_NIGHTRES_PLUGIN_CHANGE));
        abN = "skinType not support";
        Tv = null;
        Tw = 0;
    }

    public static void dr(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                Resources resources = TbadkCoreApplication.m411getInst().getResources();
                if (resources != null) {
                    abR = (AssetManager) AssetManager.class.newInstance();
                    File cR = n.cR(str);
                    if (cR == null || !cR.exists()) {
                        com.baidu.adp.lib.util.k.showToast(BdBaseApplication.getInst().getApp(), n.i.theme_skin_apk_error);
                    } else {
                        abR.getClass().getDeclaredMethod("addAssetPath", String.class).invoke(abR, cR.getAbsolutePath());
                        abP = new Resources(abR, resources.getDisplayMetrics(), resources.getConfiguration());
                        abQ = n.cS(str);
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
                textView.setTextColor(app.getResources().getColor(n.c.skin_1_common_button_color));
            } else {
                textView.setTextColor(app.getResources().getColor(n.c.cp_bg_line_d));
            }
        }
    }

    @Deprecated
    public static void c(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(n.c.skin_1_common_color));
            } else {
                textView.setTextColor(app.getResources().getColor(n.c.black));
            }
        }
    }

    public static void d(TextView textView, int i) {
        if (textView != null) {
            b(textView, n.c.cp_cont_b, 1);
        }
    }

    public static void e(View view, int i) {
        if (view != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                view.setBackgroundColor(app.getResources().getColor(n.c.skin_1_common_bg));
            } else {
                view.setBackgroundColor(app.getResources().getColor(n.c.backgroundcolor));
            }
        }
    }

    public static void f(View view, int i) {
        if (view != null) {
            i(view, n.e.common_bg);
        }
    }

    public static void e(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(n.c.skin_1_common_color));
            } else {
                textView.setTextColor(app.getResources().getColor(n.c.cp_bg_line_d));
            }
        }
    }

    public static void g(View view, int i) {
        if (view != null) {
            i(view, n.e.titlebar_bg);
        }
    }

    public static void f(TextView textView, int i) {
        if (textView != null) {
            i((View) textView, n.e.title_comm);
        }
        e(textView, i);
    }

    public static void g(TextView textView, int i) {
        if (textView != null) {
            i((View) textView, n.e.navi_done_text_bg);
        }
        h(textView, i);
    }

    public static void h(TextView textView, int i) {
        if (textView != null) {
            b(textView, n.c.navi_done_text, 1);
        }
    }

    public static void i(TextView textView, int i) {
        j(textView, i);
    }

    public static void j(TextView textView, int i) {
        if (textView != null) {
            b(textView, n.c.navi_op_text, 1);
        }
    }

    public static void a(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            c(imageView, n.e.icon_return_old_n);
        }
    }

    public static void b(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            c(imageView, n.e.icon_refresh_n);
        }
    }

    public static int cB(int i) {
        if (i == 1) {
            return BdBaseApplication.getInst().getApp().getResources().getColor(n.c.skin_1_common_color);
        }
        throw new IllegalArgumentException(abN);
    }

    public static int cC(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        return i == 1 ? app.getResources().getColor(n.c.skin_1_common_bg) : app.getResources().getColor(n.c.backgroundcolor);
    }

    public static void a(ListView listView, int i) {
        if (listView != null) {
            listView.setSelector(getDrawable(n.e.list_selector));
        }
    }

    private static int a(Resources resources, int i) {
        String str;
        if (abO == null) {
            abO = resources;
        }
        try {
            str = resources.getResourceName(i);
        } catch (Exception e) {
            str = null;
        }
        if (TextUtils.isEmpty(str) || str.indexOf(":") <= 0 || abO == null) {
            return 0;
        }
        if (Tw == 0) {
            Tv = BdBaseApplication.getInst().getPackageName();
            Tw = Tv.length();
        }
        if (str.length() > Tw && str.charAt(Tw) != ':' && str.startsWith(Tv)) {
            str = String.valueOf(Tv) + str.substring(str.indexOf(":"));
        }
        return abO.getIdentifier(String.valueOf(str) + "_1", null, null);
    }

    public static void a(ImageView imageView, int i, int i2) {
        a(imageView, i, i2, TbadkCoreApplication.m411getInst().getSkinType());
    }

    public static void a(ImageView imageView, int i, int i2, int i3) {
        if (i != 0 && i2 != 0 && imageView != null) {
            boolean z = TbadkCoreApplication.m411getInst().getUsedThemeColor() == 1;
            if (i3 == 2 && TbadkCoreApplication.m411getInst().getUsedThemeId() > 0) {
                if (z) {
                    imageView.setImageResource(i);
                    return;
                } else {
                    imageView.setImageResource(i2);
                    return;
                }
            }
            b(imageView, i2, i3);
        }
    }

    private static int b(Resources resources, int i) {
        String str;
        if (abP == null) {
            abP = resources;
        }
        if (abP == null) {
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
        return abP.getIdentifier(String.valueOf(abQ) + str.substring(str.indexOf(":")), null, null);
    }

    public static void h(View view, int i) {
        b(view, i, 1);
    }

    public static Drawable c(Resources resources, int i) {
        Resources resources2;
        if (i == 0) {
            return null;
        }
        if (TbadkCoreApplication.m411getInst().getUsedThemeId() <= 0 || TbadkCoreApplication.m411getInst().getSkinType() != 2) {
            return getDrawable(i);
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        int b = b(resources, i);
        if (b == 0) {
            resources2 = resources;
            b = i;
        } else if (abP != null) {
            resources2 = abP;
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
        if (TbadkCoreApplication.m411getInst().getUsedThemeId() <= 0 || TbadkCoreApplication.m411getInst().getSkinType() != 2) {
            return getColor(i);
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        int b = b(resources, i);
        if (b == 0) {
            resources2 = resources;
            b = i;
        } else if (abP != null) {
            resources2 = abP;
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
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            i2 = b(resources, i);
            if (i2 == 0) {
                resources2 = resources;
                i2 = i;
            } else if (abP != null) {
                resources2 = abP;
            } else {
                resources2 = resources;
                i2 = i;
            }
        } else if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            i2 = a(resources, i);
            if (i2 == 0) {
                resources2 = resources;
                i2 = i;
            } else if (abO != null) {
                resources2 = abO;
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
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            i2 = b(resources, i);
            if (i2 == 0) {
                resources2 = resources;
                i2 = i;
            } else if (abP != null) {
                resources2 = abP;
            } else {
                resources2 = resources;
                i2 = i;
            }
        } else if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            i2 = a(resources, i);
            if (i2 == 0) {
                resources2 = resources;
                i2 = i;
            } else if (abO != null) {
                resources2 = abO;
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

    public static ColorStateList cD(int i) {
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
        if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
            i2 = b(resources, i);
            if (i2 == 0) {
                resources2 = resources;
                i2 = i;
            } else if (abP != null) {
                resources2 = abP;
            } else {
                resources2 = resources;
                i2 = i;
            }
        } else if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            i2 = a(resources, i);
            if (i2 == 0) {
                resources2 = resources;
                i2 = i;
            } else if (abO != null) {
                resources2 = abO;
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

    public static Drawable x(int i, int i2) {
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
        if (i == 0) {
            return null;
        }
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        if (skinType == 1) {
            int a = a(resources, i);
            if (a == 0) {
                a = i;
            } else if (abO != null) {
                Resources resources2 = abO;
            } else {
                a = i;
            }
            try {
                Bitmap a2 = c.a(abO, a, i, options);
                if (a2 == null) {
                    return c.a(i, options);
                }
                return a2;
            } catch (Throwable th) {
                return c.a(i, options);
            }
        } else if (skinType == 2) {
            int b = b(resources, i);
            if (b == 0) {
                return c.a(i, options);
            }
            try {
                Bitmap b2 = c.b(abP, b, i, options);
                if (b2 == null) {
                    return c.a(i, options);
                }
                return b2;
            } catch (Throwable th2) {
                return c.a(i, options);
            }
        } else {
            return c.a(i, options);
        }
    }

    public static Bitmap cE(int i) {
        return a((Resources) null, i, new BitmapFactory.Options());
    }

    public static Bitmap cF(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        return a((Resources) null, i, options);
    }

    public static Bitmap cG(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return a((Resources) null, i, options);
    }

    public static void a(View view, int i, int i2, int i3) {
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

    public static void b(View view, int i, int i2) {
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
        if (view == null || StringUtils.isNull(str) || (resources = view.getResources()) == null || (identifier = resources.getIdentifier(str, "color", TbadkCoreApplication.m411getInst().getPackageName())) <= 0 || (f = f(resources, identifier)) == null || !(view instanceof TextView)) {
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

    public static void d(ImageView imageView, int i) {
        if (imageView != null && i != 0) {
            imageView.setImageDrawable(g((Resources) null, i));
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

    public static void i(View view, int i) {
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

    public static void c(View view, int i, int i2) {
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

    public static void j(View view, int i) {
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

    public static void d(View view, int i, int i2) {
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

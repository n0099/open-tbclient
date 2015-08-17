package com.baidu.tbadk.core.util;

import android.app.Application;
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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class al {
    private static String Tr;
    private static int Ts;
    private static String aaP;
    private static Resources aaQ;

    static {
        MessageManager.getInstance().registerListener(new am(CmdConfigCustom.METHOD_NIGHTRES_PLUGIN_CHANGE));
        aaP = "skinType not support";
        Tr = null;
        Ts = 0;
    }

    @Deprecated
    public static void b(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(i.c.skin_1_common_button_color));
            } else {
                textView.setTextColor(app.getResources().getColor(i.c.cp_bg_line_d));
            }
        }
    }

    @Deprecated
    public static void c(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(i.c.skin_1_common_color));
            } else {
                textView.setTextColor(app.getResources().getColor(i.c.black));
            }
        }
    }

    public static void d(TextView textView, int i) {
        if (textView != null) {
            b(textView, i.c.cp_cont_b, 1);
        }
    }

    public static void e(View view, int i) {
        if (view != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                view.setBackgroundColor(app.getResources().getColor(i.c.skin_1_common_bg));
            } else {
                view.setBackgroundColor(app.getResources().getColor(i.c.backgroundcolor));
            }
        }
    }

    public static void f(View view, int i) {
        if (view != null) {
            i(view, i.e.common_bg);
        }
    }

    public static void g(View view, int i) {
        if (view != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                view.setBackgroundColor(app.getResources().getColor(i.c.skin_1_common_bg));
            } else {
                view.setBackgroundColor(app.getResources().getColor(i.c.login_bg_color));
            }
        }
    }

    public static void e(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(i.c.skin_1_common_color));
            } else {
                textView.setTextColor(app.getResources().getColor(i.c.cp_bg_line_d));
            }
        }
    }

    public static void h(View view, int i) {
        if (view != null) {
            i(view, i.e.titlebar_bg);
        }
    }

    public static void f(TextView textView, int i) {
        if (textView != null) {
            i((View) textView, i.e.title_comm);
        }
        e(textView, i);
    }

    public static void g(TextView textView, int i) {
        if (textView != null) {
            i((View) textView, i.e.navi_done_text_bg);
        }
        h(textView, i);
    }

    public static void h(TextView textView, int i) {
        if (textView != null) {
            b(textView, i.c.navi_done_text, 1);
        }
    }

    public static void i(TextView textView, int i) {
        if (textView != null) {
            i((View) textView, i.e.navi_op_text_bg);
        }
        j(textView, i);
    }

    public static void j(TextView textView, int i) {
        if (textView != null) {
            b(textView, i.c.navi_op_text, 1);
        }
    }

    public static void a(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            i(imageView, i.e.title_icon_bg);
            c(imageView, i.e.icon_return_old_n);
        }
    }

    public static void b(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            i(imageView, i.e.title_icon_bg);
            c(imageView, i.e.icon_refresh_n);
        }
    }

    public static int cn(int i) {
        if (i == 1) {
            return BdBaseApplication.getInst().getApp().getResources().getColor(i.c.skin_1_common_color);
        }
        throw new IllegalArgumentException(aaP);
    }

    public static int co(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        return i == 1 ? app.getResources().getColor(i.c.skin_1_common_bg) : app.getResources().getColor(i.c.backgroundcolor);
    }

    public static void a(ListView listView, int i) {
        if (listView != null) {
            listView.setSelector(getDrawable(i.e.list_selector));
        }
    }

    private static int a(Resources resources, int i) {
        if (aaQ == null) {
            aaQ = resources;
        }
        String resourceName = resources.getResourceName(i);
        if (TextUtils.isEmpty(resourceName) || resourceName.indexOf(":") <= 0 || aaQ == null) {
            return 0;
        }
        if (Ts == 0) {
            Tr = BdBaseApplication.getInst().getPackageName();
            Ts = Tr.length();
        }
        if (resourceName.length() > Ts && resourceName.charAt(Ts) != ':' && resourceName.startsWith(Tr)) {
            resourceName = String.valueOf(Tr) + resourceName.substring(resourceName.indexOf(":"));
        }
        return aaQ.getIdentifier(String.valueOf(resourceName) + "_1", null, null);
    }

    public static int b(Resources resources, int i) {
        Resources resources2;
        int i2;
        if (i == 0) {
            return 0;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            i2 = a(resources, i);
            if (i2 == 0) {
                resources2 = resources;
                i2 = i;
            } else if (aaQ != null) {
                resources2 = aaQ;
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
        return b((Resources) null, i);
    }

    public static ColorStateList c(Resources resources, int i) {
        Resources resources2;
        int i2;
        if (i == 0) {
            return null;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            i2 = a(resources, i);
            if (i2 == 0) {
                resources2 = resources;
                i2 = i;
            } else if (aaQ != null) {
                resources2 = aaQ;
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

    public static ColorStateList cp(int i) {
        return c((Resources) null, i);
    }

    public static Drawable d(Resources resources, int i) {
        Resources resources2;
        int i2;
        if (i == 0) {
            return null;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            i2 = a(resources, i);
            if (i2 == 0) {
                resources2 = resources;
                i2 = i;
            } else if (aaQ != null) {
                resources2 = aaQ;
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
        return d((Resources) null, i);
    }

    public static Drawable x(int i, int i2) {
        return i == 0 ? BdBaseApplication.getInst().getApp().getResources().getDrawable(i2) : getDrawable(i2);
    }

    public static Bitmap a(Resources resources, int i, BitmapFactory.Options options) {
        if (i == 0) {
            return null;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            int a = a(resources, i);
            if (a == 0) {
                a = i;
            } else if (aaQ != null) {
                Resources resources2 = aaQ;
            } else {
                a = i;
            }
            try {
                Bitmap a2 = c.a(aaQ, a, i, options);
                if (a2 == null) {
                    return c.a(i, options);
                }
                return a2;
            } catch (Throwable th) {
                return c.a(i, options);
            }
        }
        return c.a(i, options);
    }

    public static Bitmap e(Resources resources, int i) {
        return cq(i);
    }

    public static Bitmap cq(int i) {
        return a((Resources) null, i, new BitmapFactory.Options());
    }

    public static Bitmap cr(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return a((Resources) null, i, options);
    }

    public static Bitmap cs(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 4;
        return a((Resources) null, i, options);
    }

    public static void a(View view, int i, int i2, int i3) {
        ColorStateList c;
        if (view != null && i != 0) {
            if (i3 == 0) {
                c = view.getResources().getColorStateList(i);
            } else {
                c = c(view.getResources(), i);
            }
            if (i2 == 3 && (view instanceof Button)) {
                ((Button) view).setTextColor(c);
            } else if (i2 == 2 && (view instanceof EditText)) {
                ((EditText) view).setTextColor(c);
            } else if (i2 == 1 && (view instanceof TextView)) {
                ((TextView) view).setTextColor(c);
            }
        }
    }

    public static void b(View view, int i, int i2) {
        if (view != null && i != 0) {
            ColorStateList c = c(view.getResources(), i);
            if (i2 == 3 && (view instanceof Button)) {
                ((Button) view).setTextColor(c);
            } else if (i2 == 2 && (view instanceof EditText)) {
                ((EditText) view).setTextColor(c);
            } else if (i2 == 1 && (view instanceof TextView)) {
                ((TextView) view).setTextColor(c);
            }
        }
    }

    public static boolean a(View view, String str) {
        Resources resources;
        int identifier;
        ColorStateList c;
        if (view == null || StringUtils.isNull(str) || (resources = view.getResources()) == null || (identifier = resources.getIdentifier(str, "color", TbadkCoreApplication.m411getInst().getPackageName())) <= 0 || (c = c(resources, identifier)) == null || !(view instanceof TextView)) {
            return false;
        }
        ((TextView) view).setTextColor(c);
        return true;
    }

    public static void c(ImageView imageView, int i) {
        if (imageView != null && i != 0) {
            imageView.setImageDrawable(d(imageView.getResources(), i));
        }
    }

    public static void d(ImageView imageView, int i) {
        if (imageView != null && i != 0) {
            imageView.setImageDrawable(d((Resources) null, i));
        }
    }

    public static void a(ImageView imageView, int i, int i2) {
        Drawable d;
        if (imageView != null && i != 0) {
            if (i2 == 0) {
                d = imageView.getResources().getDrawable(i);
            } else {
                d = d(imageView.getResources(), i);
            }
            imageView.setImageDrawable(d);
        }
    }

    public static void i(View view, int i) {
        if (view != null && i != 0) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            view.setBackgroundDrawable(d(view.getResources(), i));
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
            view.setBackgroundColor(b(view.getResources(), i));
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static void d(View view, int i, int i2) {
        int b;
        if (view != null && i != 0) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            if (i2 == 0) {
                b = view.getResources().getColor(i);
            } else {
                b = b(view.getResources(), i);
            }
            view.setBackgroundColor(b);
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }
}

package com.baidu.tbadk.core.util;

import android.app.Application;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.pluginArch.PluginHelper;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.pluginArch.PluginResourcesManager;
/* loaded from: classes.dex */
public class aw {
    private static String EV = "skinType not support";
    private static Resources EW;
    private static String EX;

    @Deprecated
    public static void a(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(com.baidu.tieba.s.skin_1_common_button_color));
            } else {
                textView.setTextColor(app.getResources().getColor(com.baidu.tieba.s.white));
            }
        }
    }

    @Deprecated
    public static void b(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(com.baidu.tieba.s.skin_1_common_color));
            } else {
                textView.setTextColor(app.getResources().getColor(com.baidu.tieba.s.black));
            }
        }
    }

    public static void c(TextView textView, int i) {
        if (textView != null) {
            b(textView, com.baidu.tieba.s.search_text_content, 1);
        }
    }

    public static void d(View view, int i) {
        if (view != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                view.setBackgroundColor(app.getResources().getColor(com.baidu.tieba.s.skin_1_common_bg));
            } else {
                view.setBackgroundColor(app.getResources().getColor(com.baidu.tieba.s.backgroundcolor));
            }
        }
    }

    public static void e(View view, int i) {
        if (view != null) {
            h(view, com.baidu.tieba.u.common_bg);
        }
    }

    public static void f(View view, int i) {
        if (view != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                view.setBackgroundColor(app.getResources().getColor(com.baidu.tieba.s.skin_1_common_bg));
            } else {
                view.setBackgroundColor(app.getResources().getColor(com.baidu.tieba.s.login_bg_color));
            }
        }
    }

    public static void d(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(com.baidu.tieba.s.skin_1_common_color));
            } else {
                textView.setTextColor(app.getResources().getColor(com.baidu.tieba.s.white));
            }
        }
    }

    public static void g(View view, int i) {
        if (view != null) {
            h(view, com.baidu.tieba.u.titlebar_bg);
        }
    }

    public static void e(TextView textView, int i) {
        if (textView != null) {
            h((View) textView, com.baidu.tieba.u.title_comm);
        }
        d(textView, i);
    }

    public static void f(TextView textView, int i) {
        if (textView != null) {
            h((View) textView, com.baidu.tieba.u.navi_done_text_bg);
        }
        g(textView, i);
    }

    public static void g(TextView textView, int i) {
        if (textView != null) {
            b(textView, com.baidu.tieba.s.navi_done_text, 1);
        }
    }

    public static void h(TextView textView, int i) {
        if (textView != null) {
            h((View) textView, com.baidu.tieba.u.navi_op_text_bg);
        }
        i(textView, i);
    }

    public static void i(TextView textView, int i) {
        if (textView != null) {
            b(textView, com.baidu.tieba.s.navi_op_text, 1);
        }
    }

    public static void j(TextView textView, int i) {
        if (textView != null) {
            h((View) textView, com.baidu.tieba.u.navi_del_text_bg);
        }
        k(textView, i);
    }

    public static void k(TextView textView, int i) {
        if (textView != null) {
            b(textView, com.baidu.tieba.s.navi_del_text, 1);
        }
    }

    public static void a(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            h(imageView, com.baidu.tieba.u.title_icon_bg);
            c(imageView, com.baidu.tieba.u.icon_return_old_n);
        }
    }

    public static void b(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            h(imageView, com.baidu.tieba.u.title_icon_bg);
            c(imageView, com.baidu.tieba.u.icon_refresh_n);
        }
    }

    public static int bx(int i) {
        if (i == 1) {
            return BdBaseApplication.getInst().getApp().getResources().getColor(com.baidu.tieba.s.skin_1_common_color);
        }
        throw new IllegalArgumentException(EV);
    }

    public static int by(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        return i == 1 ? app.getResources().getColor(com.baidu.tieba.s.skin_1_common_bg) : app.getResources().getColor(com.baidu.tieba.s.backgroundcolor);
    }

    public static void a(ListView listView, int i) {
        if (listView != null) {
            listView.setSelector(getDrawable(com.baidu.tieba.u.list_selector));
        }
    }

    private static int a(Resources resources, int i) {
        int indexOf;
        if (TextUtils.isEmpty(EX)) {
            EX = PluginHelper.getPluginPackage(PluginNameList.NAME_NIGHT_RESOURCE);
        }
        if (EW == null) {
            EW = PluginResourcesManager.getInstance().getPluginResource(PluginNameList.NAME_NIGHT_RESOURCE, resources);
        }
        String resourceName = resources.getResourceName(i);
        if (TextUtils.isEmpty(resourceName) || (indexOf = resourceName.indexOf(":")) <= 0 || TextUtils.isEmpty(EX) || EW == null) {
            return 0;
        }
        return EW.getIdentifier(String.valueOf(String.valueOf(EX) + resourceName.substring(indexOf)) + "_1", null, null);
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
        if (TbadkApplication.m251getInst().getSkinType() == 1) {
            i2 = a(resources, i);
            if (i2 == 0) {
                resources2 = resources;
                i2 = i;
            } else if (EW != null) {
                resources2 = EW;
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
        if (TbadkApplication.m251getInst().getSkinType() == 1) {
            i2 = a(resources, i);
            if (i2 == 0) {
                resources2 = resources;
                i2 = i;
            } else if (EW != null) {
                resources2 = EW;
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

    public static ColorStateList bz(int i) {
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
        if (TbadkApplication.m251getInst().getSkinType() == 1) {
            i2 = a(resources, i);
            if (i2 == 0) {
                resources2 = resources;
                i2 = i;
            } else if (EW != null) {
                resources2 = EW;
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
            return resources.getDrawable(i);
        }
    }

    public static Drawable getDrawable(int i) {
        return d((Resources) null, i);
    }

    public static Drawable m(int i, int i2) {
        return i == 0 ? BdBaseApplication.getInst().getApp().getResources().getDrawable(i2) : getDrawable(i2);
    }

    public static Bitmap e(Resources resources, int i) {
        if (i == 0) {
            return null;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        if (TbadkApplication.m251getInst().getSkinType() == 1) {
            int a = a(resources, i);
            if (a == 0) {
                a = i;
            } else if (EW != null) {
                Resources resources2 = EW;
            } else {
                a = i;
            }
            try {
                Bitmap a2 = d.a(EW, a, i);
                if (a2 == null) {
                    return d.bl(i);
                }
                return a2;
            } catch (Throwable th) {
                return d.bl(i);
            }
        }
        return d.bl(i);
    }

    public static Bitmap f(Resources resources, int i) {
        return bA(i);
    }

    public static Bitmap bA(int i) {
        return e((Resources) null, i);
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

    public static void c(ImageView imageView, int i) {
        if (imageView != null && i != 0) {
            imageView.setImageDrawable(d(imageView.getResources(), i));
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

    public static void h(View view, int i) {
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
            view.setBackgroundDrawable(m(i2, i));
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static void i(View view, int i) {
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

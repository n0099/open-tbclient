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
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class bc {
    private static String JA;
    private static Resources JB;

    static {
        MessageManager.getInstance().registerListener(new bd(2005017));
        JA = "skinType not support";
    }

    @Deprecated
    public static void b(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(com.baidu.tieba.t.skin_1_common_button_color));
            } else {
                textView.setTextColor(app.getResources().getColor(com.baidu.tieba.t.cp_bg_line_d));
            }
        }
    }

    @Deprecated
    public static void c(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(com.baidu.tieba.t.skin_1_common_color));
            } else {
                textView.setTextColor(app.getResources().getColor(com.baidu.tieba.t.black));
            }
        }
    }

    public static void d(TextView textView, int i) {
        if (textView != null) {
            b(textView, com.baidu.tieba.t.cp_cont_b, 1);
        }
    }

    public static void e(View view, int i) {
        if (view != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                view.setBackgroundColor(app.getResources().getColor(com.baidu.tieba.t.skin_1_common_bg));
            } else {
                view.setBackgroundColor(app.getResources().getColor(com.baidu.tieba.t.backgroundcolor));
            }
        }
    }

    public static void f(View view, int i) {
        if (view != null) {
            i(view, com.baidu.tieba.v.common_bg);
        }
    }

    public static void g(View view, int i) {
        if (view != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                view.setBackgroundColor(app.getResources().getColor(com.baidu.tieba.t.skin_1_common_bg));
            } else {
                view.setBackgroundColor(app.getResources().getColor(com.baidu.tieba.t.login_bg_color));
            }
        }
    }

    public static void e(TextView textView, int i) {
        if (textView != null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (i == 1) {
                textView.setTextColor(app.getResources().getColor(com.baidu.tieba.t.skin_1_common_color));
            } else {
                textView.setTextColor(app.getResources().getColor(com.baidu.tieba.t.cp_bg_line_d));
            }
        }
    }

    public static void h(View view, int i) {
        if (view != null) {
            i(view, com.baidu.tieba.v.titlebar_bg);
        }
    }

    public static void f(TextView textView, int i) {
        if (textView != null) {
            i((View) textView, com.baidu.tieba.v.title_comm);
        }
        e(textView, i);
    }

    public static void g(TextView textView, int i) {
        if (textView != null) {
            i((View) textView, com.baidu.tieba.v.navi_done_text_bg);
        }
        h(textView, i);
    }

    public static void h(TextView textView, int i) {
        if (textView != null) {
            b(textView, com.baidu.tieba.t.navi_done_text, 1);
        }
    }

    public static void i(TextView textView, int i) {
        if (textView != null) {
            i((View) textView, com.baidu.tieba.v.navi_op_text_bg);
        }
        j(textView, i);
    }

    public static void j(TextView textView, int i) {
        if (textView != null) {
            b(textView, com.baidu.tieba.t.navi_op_text, 1);
        }
    }

    public static void a(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            i(imageView, com.baidu.tieba.v.title_icon_bg);
            c(imageView, com.baidu.tieba.v.icon_return_old_n);
        }
    }

    public static void b(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            i(imageView, com.baidu.tieba.v.title_icon_bg);
            c(imageView, com.baidu.tieba.v.icon_refresh_n);
        }
    }

    public static int cb(int i) {
        if (i == 1) {
            return BdBaseApplication.getInst().getApp().getResources().getColor(com.baidu.tieba.t.skin_1_common_color);
        }
        throw new IllegalArgumentException(JA);
    }

    public static int cc(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        return i == 1 ? app.getResources().getColor(com.baidu.tieba.t.skin_1_common_bg) : app.getResources().getColor(com.baidu.tieba.t.backgroundcolor);
    }

    public static void a(ListView listView, int i) {
        if (listView != null) {
            listView.setSelector(getDrawable(com.baidu.tieba.v.list_selector));
        }
    }

    private static int b(Resources resources, int i) {
        if (JB == null) {
            JB = resources;
        }
        String resourceName = resources.getResourceName(i);
        if (TextUtils.isEmpty(resourceName) || resourceName.indexOf(":") <= 0 || JB == null) {
            return 0;
        }
        return JB.getIdentifier(String.valueOf(resourceName) + "_1", null, null);
    }

    public static int c(Resources resources, int i) {
        Resources resources2;
        int i2;
        if (i == 0) {
            return 0;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
            i2 = b(resources, i);
            if (i2 == 0) {
                resources2 = resources;
                i2 = i;
            } else if (JB != null) {
                resources2 = JB;
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
        return c((Resources) null, i);
    }

    public static ColorStateList d(Resources resources, int i) {
        Resources resources2;
        int i2;
        if (i == 0) {
            return null;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
            i2 = b(resources, i);
            if (i2 == 0) {
                resources2 = resources;
                i2 = i;
            } else if (JB != null) {
                resources2 = JB;
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

    public static ColorStateList cd(int i) {
        return d((Resources) null, i);
    }

    public static Drawable e(Resources resources, int i) {
        Resources resources2;
        int i2;
        if (i == 0) {
            return null;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
            i2 = b(resources, i);
            if (i2 == 0) {
                resources2 = resources;
                i2 = i;
            } else if (JB != null) {
                resources2 = JB;
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
        return e((Resources) null, i);
    }

    public static Drawable p(int i, int i2) {
        return i == 0 ? BdBaseApplication.getInst().getApp().getResources().getDrawable(i2) : getDrawable(i2);
    }

    public static Bitmap f(Resources resources, int i) {
        if (i == 0) {
            return null;
        }
        if (resources == null) {
            resources = BdBaseApplication.getInst().getApp().getResources();
        }
        if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
            int b = b(resources, i);
            if (b == 0) {
                b = i;
            } else if (JB != null) {
                Resources resources2 = JB;
            } else {
                b = i;
            }
            try {
                Bitmap a = d.a(JB, b, i);
                if (a == null) {
                    return d.bN(i);
                }
                return a;
            } catch (Throwable th) {
                return d.bN(i);
            }
        }
        return d.bN(i);
    }

    public static Bitmap g(Resources resources, int i) {
        return ce(i);
    }

    public static Bitmap ce(int i) {
        return f((Resources) null, i);
    }

    public static void a(View view, int i, int i2, int i3) {
        ColorStateList d;
        if (view != null && i != 0) {
            if (i3 == 0) {
                d = view.getResources().getColorStateList(i);
            } else {
                d = d(view.getResources(), i);
            }
            if (i2 == 3 && (view instanceof Button)) {
                ((Button) view).setTextColor(d);
            } else if (i2 == 2 && (view instanceof EditText)) {
                ((EditText) view).setTextColor(d);
            } else if (i2 == 1 && (view instanceof TextView)) {
                ((TextView) view).setTextColor(d);
            }
        }
    }

    public static void b(View view, int i, int i2) {
        if (view != null && i != 0) {
            ColorStateList d = d(view.getResources(), i);
            if (i2 == 3 && (view instanceof Button)) {
                ((Button) view).setTextColor(d);
            } else if (i2 == 2 && (view instanceof EditText)) {
                ((EditText) view).setTextColor(d);
            } else if (i2 == 1 && (view instanceof TextView)) {
                ((TextView) view).setTextColor(d);
            }
        }
    }

    public static void c(ImageView imageView, int i) {
        if (imageView != null && i != 0) {
            imageView.setImageDrawable(e(imageView.getResources(), i));
        }
    }

    public static void d(ImageView imageView, int i) {
        if (imageView != null && i != 0) {
            imageView.setImageDrawable(e((Resources) null, i));
        }
    }

    public static void a(ImageView imageView, int i, int i2) {
        Drawable e;
        if (imageView != null && i != 0) {
            if (i2 == 0) {
                e = imageView.getResources().getDrawable(i);
            } else {
                e = e(imageView.getResources(), i);
            }
            imageView.setImageDrawable(e);
        }
    }

    public static void i(View view, int i) {
        if (view != null && i != 0) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            view.setBackgroundDrawable(e(view.getResources(), i));
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
            view.setBackgroundDrawable(p(i2, i));
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
            view.setBackgroundColor(c(view.getResources(), i));
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static void d(View view, int i, int i2) {
        int c;
        if (view != null && i != 0) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            if (i2 == 0) {
                c = view.getResources().getColor(i);
            } else {
                c = c(view.getResources(), i);
            }
            view.setBackgroundColor(c);
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }
}

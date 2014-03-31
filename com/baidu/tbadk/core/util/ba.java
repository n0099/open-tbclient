package com.baidu.tbadk.core.util;

import android.app.Application;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public final class ba {
    private static String a = "skinType not support";

    public static void a(TextView textView, int i) {
        if (textView != null) {
            Application b = com.baidu.adp.a.b.a().b();
            if (i == 1) {
                textView.setTextColor(b.getResources().getColor(com.baidu.tbadk.g.skin_1_common_button_color));
            } else {
                textView.setTextColor(b.getResources().getColor(com.baidu.tbadk.g.white));
            }
        }
    }

    public static void b(TextView textView, int i) {
        if (textView != null) {
            Application b = com.baidu.adp.a.b.a().b();
            if (i == 1) {
                textView.setTextColor(b.getResources().getColor(com.baidu.tbadk.g.skin_1_common_color));
            } else {
                textView.setTextColor(b.getResources().getColor(com.baidu.tbadk.g.black));
            }
        }
    }

    public static void c(TextView textView, int i) {
        if (textView != null) {
            Application b = com.baidu.adp.a.b.a().b();
            if (i == 1) {
                textView.setTextColor(b.getResources().getColor(com.baidu.tbadk.g.gray_night_1));
            } else {
                textView.setTextColor(b.getResources().getColor(com.baidu.tbadk.g.search_text_content));
            }
        }
    }

    public static void a(View view, int i) {
        if (view != null) {
            Application b = com.baidu.adp.a.b.a().b();
            if (i == 1) {
                view.setBackgroundColor(b.getResources().getColor(com.baidu.tbadk.g.skin_1_common_bg));
            } else {
                view.setBackgroundColor(b.getResources().getColor(com.baidu.tbadk.g.backgroundcolor));
            }
        }
    }

    public static void b(View view, int i) {
        if (view != null) {
            if (i == 1) {
                view.setBackgroundResource(com.baidu.tbadk.i.common_bg_1);
            } else {
                view.setBackgroundResource(com.baidu.tbadk.i.common_bg);
            }
        }
    }

    public static void c(View view, int i) {
        if (view != null) {
            Application b = com.baidu.adp.a.b.a().b();
            if (i == 1) {
                view.setBackgroundColor(b.getResources().getColor(com.baidu.tbadk.g.skin_1_common_bg));
            } else {
                view.setBackgroundColor(b.getResources().getColor(com.baidu.tbadk.g.login_bg_color));
            }
        }
    }

    public static void d(TextView textView, int i) {
        if (textView != null) {
            Application b = com.baidu.adp.a.b.a().b();
            if (i == 1) {
                textView.setTextColor(b.getResources().getColor(com.baidu.tbadk.g.skin_1_common_color));
            } else {
                textView.setTextColor(b.getResources().getColor(com.baidu.tbadk.g.white));
            }
        }
    }

    public static void d(View view, int i) {
        if (view != null) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            if (i == 1) {
                view.setBackgroundResource(com.baidu.tbadk.i.titlebar_bg_1);
            } else {
                view.setBackgroundResource(com.baidu.tbadk.i.titlebar_bg);
            }
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public static void e(TextView textView, int i) {
        if (textView != null) {
            if (i == 1) {
                e((View) textView, com.baidu.tbadk.i.title_comm_1);
            } else {
                e((View) textView, com.baidu.tbadk.i.title_comm);
            }
        }
        d(textView, i);
    }

    public static void f(TextView textView, int i) {
        if (textView != null) {
            e((View) textView, com.baidu.tbadk.i.title_comm_hilite);
        }
        d(textView, 0);
    }

    public static void g(TextView textView, int i) {
        if (textView != null) {
            if (i == 1) {
                e((View) textView, com.baidu.tbadk.i.navi_done_text_bg_1);
            } else {
                e((View) textView, com.baidu.tbadk.i.navi_done_text_bg);
            }
        }
        if (textView != null) {
            Application b = com.baidu.adp.a.b.a().b();
            if (i != 1) {
                textView.setTextColor(b.getResources().getColorStateList(com.baidu.tbadk.g.navi_done_text));
            } else {
                textView.setTextColor(b.getResources().getColorStateList(com.baidu.tbadk.g.navi_done_text_1));
            }
        }
    }

    public static void h(TextView textView, int i) {
        if (textView != null) {
            if (i == 1) {
                e((View) textView, com.baidu.tbadk.i.navi_op_text_bg_1);
            } else {
                e((View) textView, com.baidu.tbadk.i.navi_op_text_bg);
            }
        }
        if (textView != null) {
            Application b = com.baidu.adp.a.b.a().b();
            if (i != 1) {
                textView.setTextColor(b.getResources().getColorStateList(com.baidu.tbadk.g.navi_op_text));
            } else {
                textView.setTextColor(b.getResources().getColorStateList(com.baidu.tbadk.g.navi_op_text_1));
            }
        }
    }

    public static void i(TextView textView, int i) {
        if (textView != null) {
            if (i == 1) {
                e((View) textView, com.baidu.tbadk.i.navi_del_text_bg_1);
            } else {
                e((View) textView, com.baidu.tbadk.i.navi_del_text_bg);
            }
        }
        if (textView != null) {
            Application b = com.baidu.adp.a.b.a().b();
            if (i != 1) {
                textView.setTextColor(b.getResources().getColorStateList(com.baidu.tbadk.g.navi_del_text));
            } else {
                textView.setTextColor(b.getResources().getColorStateList(com.baidu.tbadk.g.navi_del_text_1));
            }
        }
    }

    public static void a(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            if (i == 1) {
                imageView.setBackgroundResource(com.baidu.tbadk.i.title_icon_bg_1);
                imageView.setImageResource(com.baidu.tbadk.i.icon_return_old_n_1);
                return;
            }
            imageView.setBackgroundResource(com.baidu.tbadk.i.title_icon_bg);
            imageView.setImageResource(com.baidu.tbadk.i.icon_return_old_n);
        }
    }

    public static void b(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            if (i == 1) {
                imageView.setBackgroundResource(com.baidu.tbadk.i.title_icon_bg_1);
                imageView.setImageResource(com.baidu.tbadk.i.icon_refresh_n_1);
                return;
            }
            imageView.setBackgroundResource(com.baidu.tbadk.i.title_icon_bg);
            imageView.setImageResource(com.baidu.tbadk.i.icon_refresh_n);
        }
    }

    public static int a(int i) {
        if (i == 1) {
            return com.baidu.adp.a.b.a().b().getResources().getColor(com.baidu.tbadk.g.skin_1_common_color);
        }
        throw new IllegalArgumentException(a);
    }

    public static int b(int i) {
        return com.baidu.adp.a.b.a().b().getResources().getColor(com.baidu.tbadk.g.skin_1_second_common_color);
    }

    public static int c(int i) {
        return com.baidu.adp.a.b.a().b().getResources().getColor(com.baidu.tbadk.g.skin_1_third_common_color);
    }

    public static int d(int i) {
        Application b = com.baidu.adp.a.b.a().b();
        return i == 1 ? b.getResources().getColor(com.baidu.tbadk.g.skin_1_common_bg) : b.getResources().getColor(com.baidu.tbadk.g.backgroundcolor);
    }

    public static void e(View view, int i) {
        if (view != null) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            view.setBackgroundResource(i);
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    private static final int a(Context context, int i) {
        String resourceName;
        if (i != 0 && (resourceName = context.getResources().getResourceName(i)) != null) {
            int identifier = context.getResources().getIdentifier(String.valueOf(resourceName) + "_1", null, null);
            if (identifier == 0) {
                com.baidu.adp.lib.util.f.b("cannot find res:" + resourceName + "_1");
                return i;
            }
            return identifier;
        }
        return i;
    }

    public static void c(ImageView imageView, int i) {
        if (imageView != null) {
            if (TbadkApplication.j().l() == 1) {
                i = a(imageView.getContext(), i);
            }
            imageView.setImageResource(i);
        }
    }

    public static void f(View view, int i) {
        if (view != null) {
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            int paddingTop = view.getPaddingTop();
            int paddingBottom = view.getPaddingBottom();
            if (TbadkApplication.j().l() == 1) {
                view.setBackgroundResource(a(view.getContext(), i));
            } else {
                view.setBackgroundResource(i);
            }
            if (paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    public static void a(View view, int i, int i2) {
        if (view != null) {
            if (TbadkApplication.j().l() == 1) {
                i = a(view.getContext(), i);
            }
            ColorStateList colorStateList = com.baidu.adp.a.b.a().b().getResources().getColorStateList(i);
            if (i2 == 1) {
                ((TextView) view).setTextColor(colorStateList);
            } else if (i2 == 2) {
                ((EditText) view).setTextColor(colorStateList);
            } else if (i2 == 3) {
                ((Button) view).setTextColor(colorStateList);
            }
        }
    }

    public static void a(ListView listView, int i) {
        if (listView != null) {
            Application b = com.baidu.adp.a.b.a().b();
            if (i == 1) {
                listView.setBackgroundColor(b.getResources().getColor(com.baidu.tbadk.g.skin_1_common_bg));
                listView.setCacheColorHint(b.getResources().getColor(17170445));
                listView.setDivider(b.getResources().getDrawable(com.baidu.tbadk.i.list_divider_1));
                listView.setSelector(com.baidu.tbadk.i.list_selector_1);
                return;
            }
            listView.setBackgroundColor(b.getResources().getColor(com.baidu.tbadk.g.backgroundcolor));
            listView.setCacheColorHint(b.getResources().getColor(17170445));
            listView.setDivider(b.getResources().getDrawable(com.baidu.tbadk.i.list_divider));
            listView.setSelector(com.baidu.tbadk.i.list_selector);
        }
    }
}

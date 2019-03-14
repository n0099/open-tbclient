package com.baidu.tbadk.core.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tieba.d;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bc {
    private static int bLG = -1;
    private static int bLH = -1;
    private static boolean bLI = false;
    private static com.baidu.adp.lib.e.a<Integer, Integer> bLJ = new com.baidu.adp.lib.e.a<>(500);
    private static Context mAppContext = null;

    /* loaded from: classes.dex */
    public interface a {
        boolean aA(View view);
    }

    public static void cW(Context context) {
        mAppContext = context;
        bLI = true;
    }

    private static void adE() {
        if (mAppContext != null && mAppContext.getResources() != null) {
            bLH = mAppContext.getResources().getColor(d.C0277d.common_color_10097);
            bLG = mAppContext.getResources().getColor(d.C0277d.common_color_10004);
        }
    }

    private static int hC(int i) {
        return dF(i == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int dF(boolean z) {
        if (bLI) {
            bLI = false;
            adE();
        }
        return z ? bLG : bLH;
    }

    public static void aC(View view) {
        if (view instanceof ViewGroup) {
            c((ViewGroup) view, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void aD(View view) {
        if (view != null) {
            bLJ.remove(Integer.valueOf(System.identityHashCode(view)));
        }
    }

    public static void c(ViewGroup viewGroup, int i) {
        int identityHashCode = System.identityHashCode(viewGroup);
        Integer num = bLJ.get(Integer.valueOf(identityHashCode));
        if (num == null || i != num.intValue()) {
            d(viewGroup, i);
            bLJ.put(Integer.valueOf(identityHashCode), Integer.valueOf(i));
        }
    }

    public static void a(ViewGroup viewGroup, boolean z, a aVar) {
        if (!z || !aVar.aA(viewGroup)) {
            LinkedList linkedList = new LinkedList();
            while (true) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (!aVar.aA(childAt)) {
                        if (childAt instanceof ViewGroup) {
                            linkedList.addLast((ViewGroup) childAt);
                        }
                    } else {
                        return;
                    }
                }
                if (!linkedList.isEmpty()) {
                    viewGroup = (ViewGroup) linkedList.removeFirst();
                } else {
                    return;
                }
            }
        }
    }

    private static void d(ViewGroup viewGroup, final int i) {
        final boolean z = i == 1;
        a(viewGroup, true, new a() { // from class: com.baidu.tbadk.core.util.bc.1
            @Override // com.baidu.tbadk.core.util.bc.a
            public boolean aA(View view) {
                Object tag = view.getTag();
                if (tag != null) {
                    if ("skin_text_group".equals(tag)) {
                        bc.b((TextView) view, i);
                        return false;
                    } else if ("skin_text_content".equals(tag)) {
                        bc.b((TextView) view, i);
                        return false;
                    } else if ("skin_text_num".equals(tag)) {
                        bc.f((TextView) view, i);
                        return false;
                    } else if ("skin_check_box".equals(tag)) {
                        bc.a((CheckBox) view, i);
                        return false;
                    } else if ("skin_sidebar_content".equals(tag)) {
                        ((TextView) view).setTextAppearance(TbadkCoreApplication.getInst().getApp(), z ? d.k.sidebar_content_1 : d.k.sidebar_content);
                        return false;
                    } else if ("skin_more_up".equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(bc.dF(z));
                        }
                        al.k(view, d.f.more_up);
                        return false;
                    } else if ("skin_more_middle".equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(bc.dF(z));
                        }
                        al.k(view, d.f.more_middle);
                        return false;
                    } else if ("skin_more_down".equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(bc.dF(z));
                        }
                        al.k(view, d.f.more_down);
                        return false;
                    } else if ("skin_more_all".equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(bc.dF(z));
                        }
                        al.k(view, d.f.more_all);
                        return false;
                    } else if ("skin_arrow".equals(tag)) {
                        al.c((ImageView) view, d.f.icon_ba_top_arrow_big);
                        return false;
                    } else if ("skin_list_line".equals(tag)) {
                        bc.m(view, i);
                        return false;
                    } else {
                        return false;
                    }
                }
                return false;
            }
        });
    }

    public static void m(View view, int i) {
        if (view != null) {
            if (i == 1) {
                view.setBackgroundColor(-14078923);
            } else {
                view.setBackgroundColor(-1183760);
            }
        }
    }

    @Deprecated
    public static void cX(Context context) {
        if (context != null) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "nologin_intercept_toregister", 0, "", new Object[0]);
            cY(context);
        }
    }

    public static void cY(Context context) {
        if (context != null) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "nologin_intercept_tologin", 0, "", new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true)));
        }
    }

    public static void i(Context context, String str, String str2) {
        if (context != null) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "nologin_intercept_tologin", 0, "", new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true, str, str2)));
        }
    }

    public static boolean cZ(Context context) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            cY(context);
        }
        return isLogin;
    }

    public static boolean j(Context context, String str, String str2) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            i(context, str, str2);
        }
        return isLogin;
    }

    public static boolean a(LoginActivityConfig loginActivityConfig) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
        }
        return isLogin;
    }

    public static void f(TextView textView, int i) {
        if (textView != null) {
            if (i == 1) {
                textView.setTextColor(-11446171);
            } else {
                textView.setTextColor(-5065030);
            }
        }
    }

    public static void b(TextView textView, int i) {
        if (textView != null) {
            textView.setTextColor(hC(i));
        }
    }

    public static void a(CheckBox checkBox, int i) {
        if (checkBox != null) {
            checkBox.setTextColor(hC(i));
        }
    }

    public static void b(View view, int i, boolean z) {
        if (view != null && view.getParent() != null) {
            View view2 = (View) view.getParent().getParent();
            if (view2 instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) view2;
                linearLayout.setOrientation(1);
                View view3 = new View(view.getContext());
                if (z) {
                    al.l(view3, i);
                } else {
                    view3.setBackgroundResource(i);
                }
                linearLayout.addView(view3, 0, new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
            }
        }
    }
}

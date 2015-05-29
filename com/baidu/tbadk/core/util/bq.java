package com.baidu.tbadk.core.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bq {
    private static int Ws = -1;
    private static int Wt = -1;
    private static boolean Wu = false;
    private static com.baidu.adp.lib.e.a<Integer, Integer> Wv = new com.baidu.adp.lib.e.a<>(500);
    private static Context mAppContext = null;

    public static void ab(Context context) {
        mAppContext = context;
        Wu = true;
    }

    private static void tP() {
        if (mAppContext != null && mAppContext.getResources() != null) {
            Wt = mAppContext.getResources().getColor(com.baidu.tieba.n.more_color);
            Ws = mAppContext.getResources().getColor(com.baidu.tieba.n.skin_1_common_color);
        }
    }

    private static int cm(int i) {
        return ap(i == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int ap(boolean z) {
        if (Wu) {
            Wu = false;
            tP();
        }
        return z ? Ws : Wt;
    }

    public static void o(View view) {
        if (view instanceof ViewGroup) {
            b((ViewGroup) view, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    public static void p(View view) {
        if (view != null) {
            Wv.remove(Integer.valueOf(System.identityHashCode(view)));
        }
    }

    public static void b(ViewGroup viewGroup, int i) {
        int identityHashCode = System.identityHashCode(viewGroup);
        Integer num = Wv.get(Integer.valueOf(identityHashCode));
        if (num == null || i != num.intValue()) {
            c(viewGroup, i);
            Wv.put(Integer.valueOf(identityHashCode), Integer.valueOf(i));
        }
    }

    public static void a(ViewGroup viewGroup, boolean z, bs bsVar) {
        if (!z || !bsVar.m(viewGroup)) {
            LinkedList linkedList = new LinkedList();
            while (true) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (!bsVar.m(childAt)) {
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

    private static void c(ViewGroup viewGroup, int i) {
        a(viewGroup, true, (bs) new br(i, i == 1));
    }

    public static void k(View view, int i) {
        if (view != null) {
            if (i == 1) {
                view.setBackgroundColor(-14078923);
            } else {
                view.setBackgroundColor(-1183760);
            }
        }
    }

    public static void e(View view, int i, int i2) {
        if (view != null) {
            view.setBackgroundDrawable(null);
            if (i == 0) {
                ay.i(view, com.baidu.tieba.p.auto_skin_list_item_bg_up);
            } else if (i == 2) {
                ay.i(view, com.baidu.tieba.p.auto_skin_list_item_bg_down);
            } else {
                ay.i(view, com.baidu.tieba.p.list_selector_item);
            }
        }
    }

    public static void ac(Context context) {
        if (context != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RegisterActivityConfig(context, 3, true)));
        }
    }

    public static void ad(Context context) {
        if (context != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, 3, true)));
        }
    }

    public static boolean ae(Context context) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            ac(context);
        }
        return isLogin;
    }

    public static void k(TextView textView, int i) {
        if (textView != null) {
            if (i == 1) {
                textView.setTextColor(-11446171);
            } else {
                textView.setTextColor(-5065030);
            }
        }
    }

    public static void c(TextView textView, int i) {
        if (textView != null) {
            textView.setTextColor(cm(i));
        }
    }

    public static void a(CheckBox checkBox, int i) {
        if (checkBox != null) {
            checkBox.setTextColor(cm(i));
        }
    }

    public static void a(View view, int i, boolean z) {
        if (view != null && view.getParent() != null) {
            View view2 = (View) view.getParent().getParent();
            if (view2 instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) view2;
                linearLayout.setOrientation(1);
                View view3 = new View(view.getContext());
                if (z) {
                    ay.j(view3, i);
                } else {
                    view3.setBackgroundResource(i);
                }
                linearLayout.addView(view3, 0, new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
            }
        }
    }

    public static void q(View view) {
        if (view != null && view.getParent() != null) {
            View view2 = (View) view.getParent().getParent();
            if (view2 instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) view2;
                if (linearLayout.getChildCount() >= 2) {
                    linearLayout.removeViewAt(0);
                }
            }
        }
    }
}

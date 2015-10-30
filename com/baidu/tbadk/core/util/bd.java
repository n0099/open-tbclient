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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bd {
    public static ap abG;
    public static ap abH;
    private static int abC = -1;
    private static int abD = -1;
    private static boolean abE = false;
    private static com.baidu.adp.lib.e.a<Integer, Integer> abF = new com.baidu.adp.lib.e.a<>(500);
    private static Context mAppContext = null;

    /* loaded from: classes.dex */
    public interface a {
        boolean n(View view);
    }

    public static void ae(Context context) {
        mAppContext = context;
        abE = true;
    }

    private static void uU() {
        if (mAppContext != null && mAppContext.getResources() != null) {
            abD = mAppContext.getResources().getColor(i.c.more_color);
            abC = mAppContext.getResources().getColor(i.c.skin_1_common_color);
        }
    }

    private static int cB(int i) {
        return at(i == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int at(boolean z) {
        if (abE) {
            abE = false;
            uU();
        }
        return z ? abC : abD;
    }

    public static void p(View view) {
        if (view instanceof ViewGroup) {
            b((ViewGroup) view, TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    public static void q(View view) {
        if (view != null) {
            abF.remove(Integer.valueOf(System.identityHashCode(view)));
        }
    }

    public static void b(ViewGroup viewGroup, int i) {
        int identityHashCode = System.identityHashCode(viewGroup);
        Integer num = abF.get(Integer.valueOf(identityHashCode));
        if (num == null || i != num.intValue()) {
            c(viewGroup, i);
            abF.put(Integer.valueOf(identityHashCode), Integer.valueOf(i));
        }
    }

    public static void a(ViewGroup viewGroup, boolean z, a aVar) {
        if (!z || !aVar.n(viewGroup)) {
            LinkedList linkedList = new LinkedList();
            while (true) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (!aVar.n(childAt)) {
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
        a(viewGroup, true, (a) new be(i, i == 1));
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
                an.i(view, i.e.auto_skin_list_item_bg_up);
            } else if (i == 2) {
                an.i(view, i.e.auto_skin_list_item_bg_down);
            } else {
                an.i(view, i.e.list_selector_item);
            }
        }
    }

    public static void af(Context context) {
        if (context != null) {
            if (abG != null) {
                abG.ad(context);
                return;
            }
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "nologin_intercept_toregister", 0, "", new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RegisterActivityConfig(context, 3, true)));
        }
    }

    public static void ag(Context context) {
        if (context != null) {
            if (abH != null) {
                abH.ad(context);
                return;
            }
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "nologin_intercept_tologin", 0, "", new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(context, 3, true)));
        }
    }

    public static boolean ah(Context context) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            af(context);
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
            textView.setTextColor(cB(i));
        }
    }

    public static void a(CheckBox checkBox, int i) {
        if (checkBox != null) {
            checkBox.setTextColor(cB(i));
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
                    an.j(view3, i);
                } else {
                    view3.setBackgroundResource(i);
                }
                linearLayout.addView(view3, 0, new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
            }
        }
    }

    public static void r(View view) {
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

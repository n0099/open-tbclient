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
import com.baidu.tieba.t;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bl {
    public static av Ys;
    public static av Yt;
    private static int Yo = -1;
    private static int Yp = -1;
    private static boolean Yq = false;
    private static com.baidu.adp.lib.f.a<Integer, Integer> Yr = new com.baidu.adp.lib.f.a<>(500);
    private static Context mAppContext = null;

    /* loaded from: classes.dex */
    public interface a {
        boolean A(View view);
    }

    public static void Z(Context context) {
        mAppContext = context;
        Yq = true;
    }

    private static void uu() {
        if (mAppContext != null && mAppContext.getResources() != null) {
            Yp = mAppContext.getResources().getColor(t.d.more_color);
            Yo = mAppContext.getResources().getColor(t.d.skin_1_common_color);
        }
    }

    private static int cD(int i) {
        return aB(i == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int aB(boolean z) {
        if (Yq) {
            Yq = false;
            uu();
        }
        return z ? Yo : Yp;
    }

    public static void C(View view) {
        if (view instanceof ViewGroup) {
            b((ViewGroup) view, TbadkCoreApplication.m11getInst().getSkinType());
        }
    }

    public static void D(View view) {
        if (view != null) {
            Yr.remove(Integer.valueOf(System.identityHashCode(view)));
        }
    }

    public static void b(ViewGroup viewGroup, int i) {
        int identityHashCode = System.identityHashCode(viewGroup);
        Integer num = Yr.get(Integer.valueOf(identityHashCode));
        if (num == null || i != num.intValue()) {
            c(viewGroup, i);
            Yr.put(Integer.valueOf(identityHashCode), Integer.valueOf(i));
        }
    }

    public static void a(ViewGroup viewGroup, boolean z, a aVar) {
        if (!z || !aVar.A(viewGroup)) {
            LinkedList linkedList = new LinkedList();
            while (true) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (!aVar.A(childAt)) {
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
        a(viewGroup, true, new bm(i, i == 1));
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

    public static void aa(Context context) {
        if (context != null) {
            if (Ys != null) {
                Ys.Y(context);
                return;
            }
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "nologin_intercept_toregister", 0, "", new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RegisterActivityConfig(context, 3, true)));
        }
    }

    public static void ab(Context context) {
        if (context != null) {
            if (Yt != null) {
                Yt.Y(context);
                return;
            }
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "nologin_intercept_tologin", 0, "", new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(context, 3, true)));
        }
    }

    public static boolean ac(Context context) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            aa(context);
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
            textView.setTextColor(cD(i));
        }
    }

    public static void a(CheckBox checkBox, int i) {
        if (checkBox != null) {
            checkBox.setTextColor(cD(i));
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
                    at.l(view3, i);
                } else {
                    view3.setBackgroundResource(i);
                }
                linearLayout.addView(view3, 0, new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
            }
        }
    }
}

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
import com.baidu.tieba.u;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bn {
    public static ax YJ;
    public static ax YK;
    private static int YF = -1;
    private static int YG = -1;
    private static boolean YH = false;
    private static com.baidu.adp.lib.f.a<Integer, Integer> YI = new com.baidu.adp.lib.f.a<>(500);
    private static Context mAppContext = null;

    /* loaded from: classes.dex */
    public interface a {
        boolean z(View view);
    }

    public static void Y(Context context) {
        mAppContext = context;
        YH = true;
    }

    private static void ut() {
        if (mAppContext != null && mAppContext.getResources() != null) {
            YG = mAppContext.getResources().getColor(u.d.common_color_10097);
            YF = mAppContext.getResources().getColor(u.d.common_color_10004);
        }
    }

    private static int cF(int i) {
        return az(i == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int az(boolean z) {
        if (YH) {
            YH = false;
            ut();
        }
        return z ? YF : YG;
    }

    public static void B(View view) {
        if (view instanceof ViewGroup) {
            b((ViewGroup) view, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    public static void C(View view) {
        if (view != null) {
            YI.remove(Integer.valueOf(System.identityHashCode(view)));
        }
    }

    public static void b(ViewGroup viewGroup, int i) {
        int identityHashCode = System.identityHashCode(viewGroup);
        Integer num = YI.get(Integer.valueOf(identityHashCode));
        if (num == null || i != num.intValue()) {
            c(viewGroup, i);
            YI.put(Integer.valueOf(identityHashCode), Integer.valueOf(i));
        }
    }

    public static void a(ViewGroup viewGroup, boolean z, a aVar) {
        if (!z || !aVar.z(viewGroup)) {
            LinkedList linkedList = new LinkedList();
            while (true) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (!aVar.z(childAt)) {
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
        a(viewGroup, true, new bo(i, i == 1));
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

    public static void Z(Context context) {
        if (context != null) {
            if (YJ != null) {
                YJ.X(context);
                return;
            }
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "nologin_intercept_toregister", 0, "", new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RegisterActivityConfig(context, 3, true)));
        }
    }

    public static void aa(Context context) {
        if (context != null) {
            if (YK != null) {
                YK.X(context);
                return;
            }
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "nologin_intercept_tologin", 0, "", new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(context, 3, true)));
        }
    }

    public static boolean ab(Context context) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            Z(context);
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
            textView.setTextColor(cF(i));
        }
    }

    public static void a(CheckBox checkBox, int i) {
        if (checkBox != null) {
            checkBox.setTextColor(cF(i));
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
                    av.l(view3, i);
                } else {
                    view3.setBackgroundResource(i);
                }
                linearLayout.addView(view3, 0, new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
            }
        }
    }
}

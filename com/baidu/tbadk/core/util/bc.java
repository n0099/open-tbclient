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
import com.baidu.tieba.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bc {
    private static int bTv = -1;
    private static int bTw = -1;
    private static boolean bTx = false;
    private static com.baidu.adp.lib.e.a<Integer, Integer> bTy = new com.baidu.adp.lib.e.a<>(500);
    private static Context mAppContext = null;

    /* loaded from: classes.dex */
    public interface a {
        boolean aG(View view);
    }

    public static void cB(Context context) {
        mAppContext = context;
        bTx = true;
    }

    private static void aiA() {
        if (mAppContext != null && mAppContext.getResources() != null) {
            bTw = mAppContext.getResources().getColor(R.color.common_color_10097);
            bTv = mAppContext.getResources().getColor(R.color.common_color_10004);
        }
    }

    private static int ip(int i) {
        return eb(i == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int eb(boolean z) {
        if (bTx) {
            bTx = false;
            aiA();
        }
        return z ? bTv : bTw;
    }

    public static void aI(View view) {
        if (view instanceof ViewGroup) {
            d((ViewGroup) view, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void aJ(View view) {
        if (view != null) {
            bTy.remove(Integer.valueOf(System.identityHashCode(view)));
        }
    }

    public static void d(ViewGroup viewGroup, int i) {
        int identityHashCode = System.identityHashCode(viewGroup);
        Integer num = bTy.get(Integer.valueOf(identityHashCode));
        if (num == null || i != num.intValue()) {
            e(viewGroup, i);
            bTy.put(Integer.valueOf(identityHashCode), Integer.valueOf(i));
        }
    }

    public static void a(ViewGroup viewGroup, boolean z, a aVar) {
        if (!z || !aVar.aG(viewGroup)) {
            LinkedList linkedList = new LinkedList();
            while (true) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (!aVar.aG(childAt)) {
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

    private static void e(ViewGroup viewGroup, final int i) {
        final boolean z = i == 1;
        a(viewGroup, true, new a() { // from class: com.baidu.tbadk.core.util.bc.1
            @Override // com.baidu.tbadk.core.util.bc.a
            public boolean aG(View view) {
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
                        ((TextView) view).setTextAppearance(TbadkCoreApplication.getInst().getApp(), z ? R.style.sidebar_content_1 : R.style.sidebar_content);
                        return false;
                    } else if ("skin_more_up".equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(bc.eb(z));
                        }
                        al.k(view, R.drawable.more_up);
                        return false;
                    } else if ("skin_more_middle".equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(bc.eb(z));
                        }
                        al.k(view, R.drawable.more_middle);
                        return false;
                    } else if ("skin_more_down".equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(bc.eb(z));
                        }
                        al.k(view, R.drawable.more_down);
                        return false;
                    } else if ("skin_more_all".equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(bc.eb(z));
                        }
                        al.k(view, R.drawable.more_all);
                        return false;
                    } else if ("skin_arrow".equals(tag)) {
                        al.c((ImageView) view, (int) R.drawable.icon_ba_top_arrow_big);
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
    public static void cC(Context context) {
        if (context != null) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "nologin_intercept_toregister", 0, "", new Object[0]);
            cD(context);
        }
    }

    public static void cD(Context context) {
        if (context != null) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "nologin_intercept_tologin", 0, "", new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true)));
        }
    }

    public static void l(Context context, String str, String str2) {
        if (context != null) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "nologin_intercept_tologin", 0, "", new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true, str, str2)));
        }
    }

    public static boolean cE(Context context) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            cD(context);
        }
        return isLogin;
    }

    public static boolean m(Context context, String str, String str2) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            l(context, str, str2);
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
            textView.setTextColor(ip(i));
        }
    }

    public static void a(CheckBox checkBox, int i) {
        if (checkBox != null) {
            checkBox.setTextColor(ip(i));
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

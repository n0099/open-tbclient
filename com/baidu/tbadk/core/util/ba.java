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
public class ba {
    private static int arH = -1;
    private static int arI = -1;
    private static boolean arJ = false;
    private static com.baidu.adp.lib.e.a<Integer, Integer> arK = new com.baidu.adp.lib.e.a<>(500);
    private static Context mAppContext = null;

    /* loaded from: classes.dex */
    public interface a {
        boolean x(View view);
    }

    public static void aS(Context context) {
        mAppContext = context;
        arJ = true;
    }

    private static void zL() {
        if (mAppContext != null && mAppContext.getResources() != null) {
            arI = mAppContext.getResources().getColor(d.C0140d.common_color_10097);
            arH = mAppContext.getResources().getColor(d.C0140d.common_color_10004);
        }
    }

    private static int dd(int i) {
        return aK(i == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int aK(boolean z) {
        if (arJ) {
            arJ = false;
            zL();
        }
        return z ? arH : arI;
    }

    public static void z(View view) {
        if (view instanceof ViewGroup) {
            b((ViewGroup) view, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void A(View view) {
        if (view != null) {
            arK.remove(Integer.valueOf(System.identityHashCode(view)));
        }
    }

    public static void b(ViewGroup viewGroup, int i) {
        int identityHashCode = System.identityHashCode(viewGroup);
        Integer num = arK.get(Integer.valueOf(identityHashCode));
        if (num == null || i != num.intValue()) {
            c(viewGroup, i);
            arK.put(Integer.valueOf(identityHashCode), Integer.valueOf(i));
        }
    }

    public static void a(ViewGroup viewGroup, boolean z, a aVar) {
        if (!z || !aVar.x(viewGroup)) {
            LinkedList linkedList = new LinkedList();
            while (true) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (!aVar.x(childAt)) {
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

    private static void c(ViewGroup viewGroup, final int i) {
        final boolean z = i == 1;
        a(viewGroup, true, new a() { // from class: com.baidu.tbadk.core.util.ba.1
            @Override // com.baidu.tbadk.core.util.ba.a
            public boolean x(View view) {
                Object tag = view.getTag();
                if (tag != null) {
                    if ("skin_text_group".equals(tag)) {
                        ba.b((TextView) view, i);
                        return false;
                    } else if ("skin_text_content".equals(tag)) {
                        ba.b((TextView) view, i);
                        return false;
                    } else if ("skin_text_num".equals(tag)) {
                        ba.h((TextView) view, i);
                        return false;
                    } else if ("skin_check_box".equals(tag)) {
                        ba.a((CheckBox) view, i);
                        return false;
                    } else if ("skin_sidebar_content".equals(tag)) {
                        ((TextView) view).setTextAppearance(TbadkCoreApplication.getInst().getApp(), z ? d.k.sidebar_content_1 : d.k.sidebar_content);
                        return false;
                    } else if ("skin_more_up".equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(ba.aK(z));
                        }
                        am.i(view, d.f.more_up);
                        return false;
                    } else if ("skin_more_middle".equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(ba.aK(z));
                        }
                        am.i(view, d.f.more_middle);
                        return false;
                    } else if ("skin_more_down".equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(ba.aK(z));
                        }
                        am.i(view, d.f.more_down);
                        return false;
                    } else if ("skin_more_all".equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(ba.aK(z));
                        }
                        am.i(view, d.f.more_all);
                        return false;
                    } else if ("skin_arrow".equals(tag)) {
                        am.c((ImageView) view, d.f.icon_ba_top_arrow_big);
                        return false;
                    } else if ("skin_list_line".equals(tag)) {
                        ba.k(view, i);
                        return false;
                    } else {
                        return false;
                    }
                }
                return false;
            }
        });
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

    @Deprecated
    public static void aT(Context context) {
        if (context != null) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "nologin_intercept_toregister", 0, "", new Object[0]);
            aU(context);
        }
    }

    public static void aU(Context context) {
        if (context != null) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "nologin_intercept_tologin", 0, "", new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true)));
        }
    }

    public static boolean aV(Context context) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            aU(context);
        }
        return isLogin;
    }

    public static void h(TextView textView, int i) {
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
            textView.setTextColor(dd(i));
        }
    }

    public static void a(CheckBox checkBox, int i) {
        if (checkBox != null) {
            checkBox.setTextColor(dd(i));
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
                    am.j(view3, i);
                } else {
                    view3.setBackgroundResource(i);
                }
                linearLayout.addView(view3, 0, new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
            }
        }
    }
}

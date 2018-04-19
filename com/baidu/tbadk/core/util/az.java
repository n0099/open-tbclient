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
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tieba.d;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class az {
    private static int ajt = -1;
    private static int aju = -1;
    private static boolean ajv = false;
    private static com.baidu.adp.lib.e.a<Integer, Integer> ajw = new com.baidu.adp.lib.e.a<>(500);
    private static Context mAppContext = null;

    /* loaded from: classes.dex */
    public interface a {
        boolean x(View view2);
    }

    public static void aH(Context context) {
        mAppContext = context;
        ajv = true;
    }

    private static void wh() {
        if (mAppContext != null && mAppContext.getResources() != null) {
            aju = mAppContext.getResources().getColor(d.C0126d.common_color_10097);
            ajt = mAppContext.getResources().getColor(d.C0126d.common_color_10004);
        }
    }

    private static int cX(int i) {
        return aG(i == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int aG(boolean z) {
        if (ajv) {
            ajv = false;
            wh();
        }
        return z ? ajt : aju;
    }

    public static void z(View view2) {
        if (view2 instanceof ViewGroup) {
            c((ViewGroup) view2, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void A(View view2) {
        if (view2 != null) {
            ajw.remove(Integer.valueOf(System.identityHashCode(view2)));
        }
    }

    public static void c(ViewGroup viewGroup, int i) {
        int identityHashCode = System.identityHashCode(viewGroup);
        Integer num = ajw.get(Integer.valueOf(identityHashCode));
        if (num == null || i != num.intValue()) {
            d(viewGroup, i);
            ajw.put(Integer.valueOf(identityHashCode), Integer.valueOf(i));
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

    private static void d(ViewGroup viewGroup, final int i) {
        final boolean z = i == 1;
        a(viewGroup, true, new a() { // from class: com.baidu.tbadk.core.util.az.1
            @Override // com.baidu.tbadk.core.util.az.a
            public boolean x(View view2) {
                Object tag = view2.getTag();
                if (tag != null) {
                    if ("skin_text_group".equals(tag)) {
                        az.b((TextView) view2, i);
                        return false;
                    } else if ("skin_text_content".equals(tag)) {
                        az.b((TextView) view2, i);
                        return false;
                    } else if ("skin_text_num".equals(tag)) {
                        az.h((TextView) view2, i);
                        return false;
                    } else if ("skin_check_box".equals(tag)) {
                        az.a((CheckBox) view2, i);
                        return false;
                    } else if ("skin_sidebar_content".equals(tag)) {
                        ((TextView) view2).setTextAppearance(TbadkCoreApplication.getInst().getApp(), z ? d.l.sidebar_content_1 : d.l.sidebar_content);
                        return false;
                    } else if ("skin_more_up".equals(tag)) {
                        if (view2 instanceof RadioButton) {
                            ((RadioButton) view2).setTextColor(az.aG(z));
                        }
                        ak.i(view2, d.f.more_up);
                        return false;
                    } else if ("skin_more_middle".equals(tag)) {
                        if (view2 instanceof RadioButton) {
                            ((RadioButton) view2).setTextColor(az.aG(z));
                        }
                        ak.i(view2, d.f.more_middle);
                        return false;
                    } else if ("skin_more_down".equals(tag)) {
                        if (view2 instanceof RadioButton) {
                            ((RadioButton) view2).setTextColor(az.aG(z));
                        }
                        ak.i(view2, d.f.more_down);
                        return false;
                    } else if ("skin_more_all".equals(tag)) {
                        if (view2 instanceof RadioButton) {
                            ((RadioButton) view2).setTextColor(az.aG(z));
                        }
                        ak.i(view2, d.f.more_all);
                        return false;
                    } else if ("skin_arrow".equals(tag)) {
                        ak.c((ImageView) view2, d.f.icon_ba_top_arrow_big);
                        return false;
                    } else if ("skin_list_line".equals(tag)) {
                        az.k(view2, i);
                        return false;
                    } else {
                        return false;
                    }
                }
                return false;
            }
        });
    }

    public static void k(View view2, int i) {
        if (view2 != null) {
            if (i == 1) {
                view2.setBackgroundColor(-14078923);
            } else {
                view2.setBackgroundColor(-1183760);
            }
        }
    }

    public static void aI(Context context) {
        if (context != null) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "nologin_intercept_toregister", 0, "", new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RegisterActivityConfig(context, 3, true)));
        }
    }

    public static void aJ(Context context) {
        if (context != null) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "nologin_intercept_tologin", 0, "", new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, 3, true)));
        }
    }

    public static boolean aK(Context context) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            aJ(context);
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
            textView.setTextColor(cX(i));
        }
    }

    public static void a(CheckBox checkBox, int i) {
        if (checkBox != null) {
            checkBox.setTextColor(cX(i));
        }
    }

    public static void b(View view2, int i, boolean z) {
        if (view2 != null && view2.getParent() != null) {
            View view3 = (View) view2.getParent().getParent();
            if (view3 instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) view3;
                linearLayout.setOrientation(1);
                View view4 = new View(view2.getContext());
                if (z) {
                    ak.j(view4, i);
                } else {
                    view4.setBackgroundResource(i);
                }
                linearLayout.addView(view4, 0, new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
            }
        }
    }
}

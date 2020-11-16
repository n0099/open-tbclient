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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tieba.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class bh {
    private static int eNj = -1;
    private static int eNk = -1;
    private static boolean eNl = false;
    private static com.baidu.adp.lib.d.a<Integer, Integer> eNm = new com.baidu.adp.lib.d.a<>(500);
    private static Context mAppContext = null;

    /* loaded from: classes.dex */
    public interface a {
        boolean bh(View view);
    }

    public static void ee(Context context) {
        mAppContext = context;
        eNl = true;
    }

    private static void bqG() {
        if (mAppContext != null && mAppContext.getResources() != null) {
            eNk = mAppContext.getResources().getColor(R.color.common_color_10097);
            eNj = mAppContext.getResources().getColor(R.color.common_color_10004);
        }
    }

    private static int pB(int i) {
        boolean z = true;
        if (i != 1 && i != 4) {
            z = false;
        }
        return jf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int jf(boolean z) {
        if (eNl) {
            eNl = false;
            bqG();
        }
        return z ? eNj : eNk;
    }

    public static void bl(View view) {
        if (view instanceof ViewGroup) {
            g((ViewGroup) view, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void bm(View view) {
        if (view != null) {
            eNm.remove(Integer.valueOf(System.identityHashCode(view)));
        }
    }

    public static void g(ViewGroup viewGroup, int i) {
        int identityHashCode = System.identityHashCode(viewGroup);
        Integer num = eNm.get(Integer.valueOf(identityHashCode));
        if (num == null || i != num.intValue()) {
            h(viewGroup, i);
            eNm.put(Integer.valueOf(identityHashCode), Integer.valueOf(i));
        }
    }

    public static void a(ViewGroup viewGroup, boolean z, a aVar) {
        if (!z || !aVar.bh(viewGroup)) {
            LinkedList linkedList = new LinkedList();
            while (true) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (!aVar.bh(childAt)) {
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

    private static void h(ViewGroup viewGroup, final int i) {
        final boolean z = i == 1 || i == 4;
        a(viewGroup, true, new a() { // from class: com.baidu.tbadk.core.util.bh.1
            @Override // com.baidu.tbadk.core.util.bh.a
            public boolean bh(View view) {
                Object tag = view.getTag();
                if (tag != null) {
                    if ("skin_text_group".equals(tag)) {
                        bh.setTextColor((TextView) view, i);
                        return false;
                    } else if ("skin_text_content".equals(tag)) {
                        bh.setTextColor((TextView) view, i);
                        return false;
                    } else if ("skin_text_num".equals(tag)) {
                        bh.setGroupTextColor((TextView) view, i);
                        return false;
                    } else if ("skin_check_box".equals(tag)) {
                        bh.a((CheckBox) view, i);
                        return false;
                    } else if ("skin_sidebar_content".equals(tag)) {
                        ((TextView) view).setTextAppearance(TbadkCoreApplication.getInst().getApp(), z ? R.style.sidebar_content_1 : R.style.sidebar_content);
                        return false;
                    } else if ("skin_more_up".equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(bh.jf(z));
                        }
                        ap.setBackgroundResource(view, R.drawable.more_up);
                        return false;
                    } else if ("skin_more_middle".equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(bh.jf(z));
                        }
                        ap.setBackgroundResource(view, R.drawable.more_middle);
                        return false;
                    } else if ("skin_more_down".equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(bh.jf(z));
                        }
                        ap.setBackgroundResource(view, R.drawable.more_down);
                        return false;
                    } else if ("skin_more_all".equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(bh.jf(z));
                        }
                        ap.setBackgroundResource(view, R.drawable.more_all);
                        return false;
                    } else if ("skin_arrow".equals(tag)) {
                        ap.setImageResource((ImageView) view, R.drawable.icon_ba_top_arrow_big);
                        return false;
                    } else if ("skin_list_line".equals(tag)) {
                        bh.l(view, i);
                        return false;
                    } else {
                        return false;
                    }
                }
                return false;
            }
        });
    }

    public static void l(View view, int i) {
        if (view != null) {
            if (i == 1 || i == 4) {
                view.setBackgroundColor(-14078923);
            } else {
                view.setBackgroundColor(-1183760);
            }
        }
    }

    @Deprecated
    public static void skipToRegisterActivity(Context context) {
        if (context != null) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "nologin_intercept_toregister", 0, "", new Object[0]);
            skipToLoginActivity(context);
        }
    }

    public static void skipToLoginActivity(Context context) {
        if (context != null) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "nologin_intercept_tologin", 0, "", new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(context, true)));
        }
    }

    public static void s(Context context, String str, String str2) {
        if (context != null) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "nologin_intercept_tologin", 0, "", new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(context, true, str, str2)));
        }
    }

    public static boolean checkUpIsLogin(Context context) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            skipToLoginActivity(context);
        }
        return isLogin;
    }

    public static boolean t(Context context, String str, String str2) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            s(context, str, str2);
        }
        return isLogin;
    }

    public static boolean a(LoginActivityConfig loginActivityConfig) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        }
        return isLogin;
    }

    public static void setGroupTextColor(TextView textView, int i) {
        if (textView != null) {
            if (i == 1 || i == 4) {
                textView.setTextColor(-11446171);
            } else {
                textView.setTextColor(-5065030);
            }
        }
    }

    public static void setTextColor(TextView textView, int i) {
        if (textView != null) {
            textView.setTextColor(pB(i));
        }
    }

    public static void a(CheckBox checkBox, int i) {
        if (checkBox != null) {
            checkBox.setTextColor(pB(i));
        }
    }

    public static void c(View view, int i, boolean z) {
        if (view != null && view.getParent() != null) {
            View view2 = (View) view.getParent().getParent();
            if (view2 instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) view2;
                linearLayout.setOrientation(1);
                View view3 = new View(view.getContext());
                if (z) {
                    ap.setBackgroundColor(view3, i);
                } else {
                    view3.setBackgroundResource(i);
                }
                linearLayout.addView(view3, 0, new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
            }
        }
    }
}

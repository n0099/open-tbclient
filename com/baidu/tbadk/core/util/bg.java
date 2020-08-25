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
/* loaded from: classes2.dex */
public class bg {
    private static int mSkin_1_common_color = -1;
    private static int mMore_color = -1;
    private static boolean mIsNeedInit = false;
    private static com.baidu.adp.lib.d.a<Integer, Integer> elq = new com.baidu.adp.lib.d.a<>(500);
    private static Context mAppContext = null;

    /* loaded from: classes2.dex */
    public interface a {
        boolean onViewFound(View view);
    }

    public static void initSkinDataOnStartup(Context context) {
        mAppContext = context;
        mIsNeedInit = true;
    }

    private static void initCommonColor() {
        if (mAppContext != null && mAppContext.getResources() != null) {
            mMore_color = mAppContext.getResources().getColor(R.color.common_color_10097);
            mSkin_1_common_color = mAppContext.getResources().getColor(R.color.common_color_10004);
        }
    }

    private static int getCommonColor(int i) {
        boolean z = true;
        if (i != 1 && i != 4) {
            z = false;
        }
        return getCommonColor(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getCommonColor(boolean z) {
        if (mIsNeedInit) {
            mIsNeedInit = false;
            initCommonColor();
        }
        return z ? mSkin_1_common_color : mMore_color;
    }

    public static void processCurrentSkin(View view) {
        if (view instanceof ViewGroup) {
            processSkin((ViewGroup) view, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void prepareNewView(View view) {
        if (view != null) {
            elq.remove(Integer.valueOf(System.identityHashCode(view)));
        }
    }

    public static void processSkin(ViewGroup viewGroup, int i) {
        int identityHashCode = System.identityHashCode(viewGroup);
        Integer num = elq.get(Integer.valueOf(identityHashCode));
        if (num == null || i != num.intValue()) {
            processSkin0(viewGroup, i);
            elq.put(Integer.valueOf(identityHashCode), Integer.valueOf(i));
        }
    }

    public static void a(ViewGroup viewGroup, boolean z, a aVar) {
        if (!z || !aVar.onViewFound(viewGroup)) {
            LinkedList linkedList = new LinkedList();
            while (true) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (!aVar.onViewFound(childAt)) {
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

    private static void processSkin0(ViewGroup viewGroup, final int i) {
        final boolean z = i == 1 || i == 4;
        a(viewGroup, true, new a() { // from class: com.baidu.tbadk.core.util.bg.1
            @Override // com.baidu.tbadk.core.util.bg.a
            public boolean onViewFound(View view) {
                Object tag = view.getTag();
                if (tag != null) {
                    if ("skin_text_group".equals(tag)) {
                        bg.setTextColor((TextView) view, i);
                        return false;
                    } else if ("skin_text_content".equals(tag)) {
                        bg.setTextColor((TextView) view, i);
                        return false;
                    } else if ("skin_text_num".equals(tag)) {
                        bg.setGroupTextColor((TextView) view, i);
                        return false;
                    } else if ("skin_check_box".equals(tag)) {
                        bg.setTextColor((CheckBox) view, i);
                        return false;
                    } else if ("skin_sidebar_content".equals(tag)) {
                        ((TextView) view).setTextAppearance(TbadkCoreApplication.getInst().getApp(), z ? R.style.sidebar_content_1 : R.style.sidebar_content);
                        return false;
                    } else if ("skin_more_up".equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(bg.getCommonColor(z));
                        }
                        ap.setBackgroundResource(view, R.drawable.more_up);
                        return false;
                    } else if ("skin_more_middle".equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(bg.getCommonColor(z));
                        }
                        ap.setBackgroundResource(view, R.drawable.more_middle);
                        return false;
                    } else if ("skin_more_down".equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(bg.getCommonColor(z));
                        }
                        ap.setBackgroundResource(view, R.drawable.more_down);
                        return false;
                    } else if ("skin_more_all".equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(bg.getCommonColor(z));
                        }
                        ap.setBackgroundResource(view, R.drawable.more_all);
                        return false;
                    } else if ("skin_arrow".equals(tag)) {
                        ap.setImageResource((ImageView) view, R.drawable.icon_ba_top_arrow_big);
                        return false;
                    } else if ("skin_list_line".equals(tag)) {
                        bg.setSkinForListDivider(view, i);
                        return false;
                    } else {
                        return false;
                    }
                }
                return false;
            }
        });
    }

    public static void setSkinForListDivider(View view, int i) {
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

    public static void p(Context context, String str, String str2) {
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

    public static boolean q(Context context, String str, String str2) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            p(context, str, str2);
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
            textView.setTextColor(getCommonColor(i));
        }
    }

    public static void setTextColor(CheckBox checkBox, int i) {
        if (checkBox != null) {
            checkBox.setTextColor(getCommonColor(i));
        }
    }

    public static void addStateBarViewSpace(View view, int i, boolean z) {
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

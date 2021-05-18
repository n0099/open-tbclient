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
import d.a.c.e.k.a;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class ViewHelper {
    public static final String ARROW = "skin_arrow";
    public static final String CHECK_BOX = "skin_check_box";
    public static final String LIST_ITEM_LINE = "skin_list_line";
    public static final String MORE_ALL = "skin_more_all";
    public static final String MORE_DOWN = "skin_more_down";
    public static final String MORE_MIDDLE = "skin_more_middle";
    public static final String MORE_UP = "skin_more_up";
    public static final String SIDE_BAR_CONTENT = "skin_sidebar_content";
    public static final String TEXT_CONTENT = "skin_text_content";
    public static final String TEXT_GROUP = "skin_text_group";
    public static final String TEXT_NUM = "skin_text_num";
    public static final int TYPE_DOWN = 2;
    public static final int TYPE_MIDDLE = 1;
    public static final int TYPE_UP = 0;
    public static a<Integer, Integer> cachedSkinInViews = new a<>(500);
    public static Context mAppContext = null;
    public static boolean mIsNeedInit = false;
    public static int mMore_color = -1;
    public static int mSkin_1_common_color = -1;

    /* loaded from: classes3.dex */
    public interface ShareCallback {
        void finishProgressForSharing();

        void startProgressForSharing();
    }

    /* loaded from: classes3.dex */
    public interface ViewCallback {
        boolean onViewFound(View view);
    }

    public static void addStateBarViewSpace(View view, int i2, boolean z) {
        if (view == null || view.getParent() == null) {
            return;
        }
        View view2 = (View) view.getParent().getParent();
        if (view2 instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) view2;
            linearLayout.setOrientation(1);
            View view3 = new View(view.getContext());
            if (z) {
                SkinManager.setBackgroundColor(view3, i2);
            } else {
                view3.setBackgroundResource(i2);
            }
            linearLayout.addView(view3, 0, new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        }
    }

    public static boolean checkUpIsLogin(Context context) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            skipToLoginActivity(context);
        }
        return isLogin;
    }

    public static boolean checkUpIsLoginFromH5(Context context, String str, String str2) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            skipToLoginActivityFromH5(context, str, str2);
        }
        return isLogin;
    }

    public static int getCommonColor(int i2) {
        boolean z = true;
        if (i2 != 1 && i2 != 4) {
            z = false;
        }
        return getCommonColor(z);
    }

    public static void initCommonColor() {
        Context context = mAppContext;
        if (context == null || context.getResources() == null) {
            return;
        }
        mMore_color = mAppContext.getResources().getColor(R.color.common_color_10097);
        mSkin_1_common_color = mAppContext.getResources().getColor(R.color.common_color_10004);
    }

    public static void initSkinDataOnStartup(Context context) {
        mAppContext = context;
        mIsNeedInit = true;
    }

    public static void prepareNewView(View view) {
        if (view == null) {
            return;
        }
        cachedSkinInViews.i(Integer.valueOf(System.identityHashCode(view)));
    }

    public static void processAllViewsIn(ViewGroup viewGroup, boolean z, ViewCallback viewCallback) {
        if (z && viewCallback.onViewFound(viewGroup)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (viewCallback.onViewFound(childAt)) {
                    return;
                }
                if (childAt instanceof ViewGroup) {
                    linkedList.addLast((ViewGroup) childAt);
                }
            }
            if (linkedList.isEmpty()) {
                return;
            }
            viewGroup = (ViewGroup) linkedList.removeFirst();
        }
    }

    public static void processCurrentSkin(View view) {
        if (view instanceof ViewGroup) {
            processSkin((ViewGroup) view, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void processSkin(ViewGroup viewGroup, int i2) {
        int identityHashCode = System.identityHashCode(viewGroup);
        Integer f2 = cachedSkinInViews.f(Integer.valueOf(identityHashCode));
        if (f2 == null || i2 != f2.intValue()) {
            processSkin0(viewGroup, i2);
            cachedSkinInViews.h(Integer.valueOf(identityHashCode), Integer.valueOf(i2));
        }
    }

    public static void processSkin0(ViewGroup viewGroup, final int i2) {
        final boolean z = i2 == 1 || i2 == 4;
        processAllViewsIn(viewGroup, true, new ViewCallback() { // from class: com.baidu.tbadk.core.util.ViewHelper.1
            @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
            public boolean onViewFound(View view) {
                Object tag = view.getTag();
                if (tag != null) {
                    if (ViewHelper.TEXT_GROUP.equals(tag)) {
                        ViewHelper.setTextColor((TextView) view, i2);
                        return false;
                    } else if (ViewHelper.TEXT_CONTENT.equals(tag)) {
                        ViewHelper.setTextColor((TextView) view, i2);
                        return false;
                    } else if (ViewHelper.TEXT_NUM.equals(tag)) {
                        ViewHelper.setGroupTextColor((TextView) view, i2);
                        return false;
                    } else if (ViewHelper.CHECK_BOX.equals(tag)) {
                        ViewHelper.setTextColor((CheckBox) view, i2);
                        return false;
                    } else if (ViewHelper.SIDE_BAR_CONTENT.equals(tag)) {
                        ((TextView) view).setTextAppearance(TbadkCoreApplication.getInst().getApp(), z ? R.style.sidebar_content_1 : R.style.sidebar_content);
                        return false;
                    } else if (ViewHelper.MORE_UP.equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(ViewHelper.getCommonColor(z));
                        }
                        SkinManager.setBackgroundResource(view, R.drawable.more_up);
                        return false;
                    } else if (ViewHelper.MORE_MIDDLE.equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(ViewHelper.getCommonColor(z));
                        }
                        SkinManager.setBackgroundResource(view, R.drawable.more_middle);
                        return false;
                    } else if (ViewHelper.MORE_DOWN.equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(ViewHelper.getCommonColor(z));
                        }
                        SkinManager.setBackgroundResource(view, R.drawable.more_down);
                        return false;
                    } else if (ViewHelper.MORE_ALL.equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(ViewHelper.getCommonColor(z));
                        }
                        SkinManager.setBackgroundResource(view, R.drawable.more_all);
                        return false;
                    } else if (ViewHelper.ARROW.equals(tag)) {
                        SkinManager.setImageResource((ImageView) view, R.drawable.icon_ba_top_arrow_big);
                        return false;
                    } else if (ViewHelper.LIST_ITEM_LINE.equals(tag)) {
                        ViewHelper.setSkinForListDivider(view, i2);
                        return false;
                    } else {
                        return false;
                    }
                }
                return false;
            }
        });
    }

    public static void removeStateBarViewSpace(View view) {
        if (view == null || view.getParent() == null) {
            return;
        }
        View view2 = (View) view.getParent().getParent();
        if (view2 instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) view2;
            if (linearLayout.getChildCount() >= 2) {
                linearLayout.removeViewAt(0);
            }
        }
    }

    public static void setGroupTextColor(TextView textView, int i2) {
        if (textView != null) {
            if (i2 != 1 && i2 != 4) {
                textView.setTextColor(-5065030);
            } else {
                textView.setTextColor(-11446171);
            }
        }
    }

    public static void setSkinForListDivider(View view, int i2) {
        if (view == null) {
            return;
        }
        if (i2 != 1 && i2 != 4) {
            view.setBackgroundColor(-1183760);
        } else {
            view.setBackgroundColor(-14078923);
        }
    }

    public static void setSkinForListItem(View view, int i2, int i3) {
        if (view == null) {
            return;
        }
        view.setBackgroundDrawable(null);
        if (i2 == 0) {
            SkinManager.setBackgroundResource(view, R.drawable.auto_skin_list_item_bg_up);
        } else if (i2 == 2) {
            SkinManager.setBackgroundResource(view, R.drawable.auto_skin_list_item_bg_down);
        } else {
            SkinManager.setBackgroundResource(view, R.drawable.list_selector_item);
        }
    }

    public static void setTextColor(TextView textView, int i2) {
        if (textView != null) {
            textView.setTextColor(getCommonColor(i2));
        }
    }

    public static void skipToLoginActivity(Context context) {
        if (context != null) {
            d.a.j0.r.z.a.a("account", -1L, 0, "nologin_intercept_tologin", 0, "", new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true)));
        }
    }

    public static void skipToLoginActivityFromH5(Context context, String str, String str2) {
        if (context != null) {
            d.a.j0.r.z.a.a("account", -1L, 0, "nologin_intercept_tologin", 0, "", new Object[0]);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true, str, str2)));
        }
    }

    @Deprecated
    public static void skipToRegisterActivity(Context context) {
        if (context != null) {
            d.a.j0.r.z.a.a("account", -1L, 0, "nologin_intercept_toregister", 0, "", new Object[0]);
            skipToLoginActivity(context);
        }
    }

    public static int getCommonColor(boolean z) {
        if (mIsNeedInit) {
            mIsNeedInit = false;
            initCommonColor();
        }
        return z ? mSkin_1_common_color : mMore_color;
    }

    public static void setTextColor(CheckBox checkBox, int i2) {
        if (checkBox != null) {
            checkBox.setTextColor(getCommonColor(i2));
        }
    }

    public static boolean checkUpIsLoginFromH5(LoginActivityConfig loginActivityConfig) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
        }
        return isLogin;
    }
}

package com.baidu.live.tbadk.core.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.pool.BdCache;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.RegisterActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class ViewHelper {
    private static final String ARROW = "skin_arrow";
    private static final String CHECK_BOX = "skin_check_box";
    private static final String LIST_ITEM_LINE = "skin_list_line";
    private static final String MORE_ALL = "skin_more_all";
    private static final String MORE_DOWN = "skin_more_down";
    private static final String MORE_MIDDLE = "skin_more_middle";
    private static final String MORE_UP = "skin_more_up";
    private static final String SIDE_BAR_CONTENT = "skin_sidebar_content";
    private static final String TEXT_CONTENT = "skin_text_content";
    private static final String TEXT_GROUP = "skin_text_group";
    private static final String TEXT_NUM = "skin_text_num";
    public static final int TYPE_DOWN = 2;
    public static final int TYPE_MIDDLE = 1;
    public static final int TYPE_UP = 0;
    private static int mSkin_1_common_color = -1;
    private static int mMore_color = -1;
    private static boolean mIsNeedInit = false;
    private static BdCache<Integer, Integer> cachedSkinInViews = new BdCache<>(500);
    private static Context mAppContext = null;

    /* loaded from: classes6.dex */
    public interface ShareCallback {
        void finishProgressForSharing();

        void startProgressForSharing();
    }

    /* loaded from: classes6.dex */
    public interface ViewCallback {
        boolean onViewFound(View view);
    }

    public static void initSkinDataOnStartup(Context context) {
        mAppContext = context;
        mIsNeedInit = true;
    }

    private static void initCommonColor() {
        if (mAppContext != null && mAppContext.getResources() != null) {
            mMore_color = mAppContext.getResources().getColor(a.d.sdk_common_color_10097);
            mSkin_1_common_color = mAppContext.getResources().getColor(a.d.sdk_common_color_10004);
        }
    }

    private static int getCommonColor(int i) {
        return getCommonColor(i == 1);
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
            cachedSkinInViews.remove(Integer.valueOf(System.identityHashCode(view)));
        }
    }

    public static void processSkin(ViewGroup viewGroup, int i) {
        int identityHashCode = System.identityHashCode(viewGroup);
        Integer num = cachedSkinInViews.get(Integer.valueOf(identityHashCode));
        if (num == null || i != num.intValue()) {
            processSkin0(viewGroup, i);
            cachedSkinInViews.put(Integer.valueOf(identityHashCode), Integer.valueOf(i));
        }
    }

    public static void processAllViewsIn(ViewGroup viewGroup, boolean z, ViewCallback viewCallback) {
        if (!z || !viewCallback.onViewFound(viewGroup)) {
            LinkedList linkedList = new LinkedList();
            while (true) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (!viewCallback.onViewFound(childAt)) {
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
        final boolean z = i == 1;
        processAllViewsIn(viewGroup, true, new ViewCallback() { // from class: com.baidu.live.tbadk.core.util.ViewHelper.1
            @Override // com.baidu.live.tbadk.core.util.ViewHelper.ViewCallback
            public boolean onViewFound(View view) {
                Object tag = view.getTag();
                if (tag != null) {
                    if (ViewHelper.TEXT_GROUP.equals(tag)) {
                        ViewHelper.setTextColor((TextView) view, i);
                        return false;
                    } else if (ViewHelper.TEXT_CONTENT.equals(tag)) {
                        ViewHelper.setTextColor((TextView) view, i);
                        return false;
                    } else if (ViewHelper.TEXT_NUM.equals(tag)) {
                        ViewHelper.setGroupTextColor((TextView) view, i);
                        return false;
                    } else if (ViewHelper.CHECK_BOX.equals(tag)) {
                        ViewHelper.setTextColor((CheckBox) view, i);
                        return false;
                    } else if (ViewHelper.SIDE_BAR_CONTENT.equals(tag)) {
                        ((TextView) view).setTextAppearance(TbadkCoreApplication.getInst().getApp(), z ? a.j.sdk_sidebar_content_1 : a.j.sdk_sidebar_content);
                        return false;
                    } else if (ViewHelper.MORE_UP.equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(ViewHelper.getCommonColor(z));
                        }
                        SkinManager.setBackgroundResource(view, a.f.sdk_more_up);
                        return false;
                    } else if (ViewHelper.MORE_MIDDLE.equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(ViewHelper.getCommonColor(z));
                        }
                        SkinManager.setBackgroundResource(view, a.f.sdk_more_middle);
                        return false;
                    } else if (ViewHelper.MORE_DOWN.equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(ViewHelper.getCommonColor(z));
                        }
                        SkinManager.setBackgroundResource(view, a.f.sdk_more_down);
                        return false;
                    } else if (ViewHelper.MORE_ALL.equals(tag)) {
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setTextColor(ViewHelper.getCommonColor(z));
                        }
                        SkinManager.setBackgroundResource(view, a.f.sdk_more_all);
                        return false;
                    } else if (ViewHelper.ARROW.equals(tag)) {
                        SkinManager.setImageResource((ImageView) view, a.f.sdk_icon_ba_top_arrow_big);
                        return false;
                    } else if (ViewHelper.LIST_ITEM_LINE.equals(tag)) {
                        ViewHelper.setSkinForListDivider(view, i);
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
            if (i == 1) {
                view.setBackgroundColor(-14078923);
            } else {
                view.setBackgroundColor(-1183760);
            }
        }
    }

    public static void setSkinForListItem(View view, int i, int i2) {
        if (view != null) {
            view.setBackgroundDrawable(null);
            if (i == 0) {
                SkinManager.setBackgroundResource(view, a.f.sdk_auto_skin_list_item_bg_up);
            } else if (i == 2) {
                SkinManager.setBackgroundResource(view, a.f.sdk_auto_skin_list_item_bg_down);
            } else {
                SkinManager.setBackgroundResource(view, a.f.sdk_list_selector_item);
            }
        }
    }

    public static void skipToRegisterActivity(Context context) {
        if (context != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RegisterActivityConfig(context, 3, true)));
        }
    }

    public static void skipToLoginActivity(Context context) {
        if (context != null) {
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN));
    }

    public static boolean checkUpIsLogin(Context context) {
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (!isLogin) {
            skipToLoginActivity(context);
        }
        return isLogin;
    }

    public static void setGroupTextColor(TextView textView, int i) {
        if (textView != null) {
            if (i == 1) {
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
                    SkinManager.setBackgroundColor(view3, i);
                } else {
                    view3.setBackgroundResource(i);
                }
                linearLayout.addView(view3, 0, new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
            }
        }
    }

    public static void removeStateBarViewSpace(View view) {
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

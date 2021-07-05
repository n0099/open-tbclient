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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.k.a;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class ViewHelper {
    public static /* synthetic */ Interceptable $ic = null;
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
    public static a<Integer, Integer> cachedSkinInViews = null;
    public static Context mAppContext = null;
    public static boolean mIsNeedInit = false;
    public static int mMore_color = -1;
    public static int mSkin_1_common_color = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface ShareCallback {
        void finishProgressForSharing();

        void startProgressForSharing();
    }

    /* loaded from: classes4.dex */
    public interface ViewCallback {
        boolean onViewFound(View view);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-662335224, "Lcom/baidu/tbadk/core/util/ViewHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-662335224, "Lcom/baidu/tbadk/core/util/ViewHelper;");
                return;
            }
        }
        cachedSkinInViews = new a<>(500);
        mAppContext = null;
    }

    public ViewHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void addStateBarViewSpace(View view, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || view == null || view.getParent() == null) {
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) {
            boolean isLogin = TbadkCoreApplication.isLogin();
            if (!isLogin) {
                skipToLoginActivity(context);
            }
            return isLogin;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkUpIsLoginFromH5(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, str, str2)) == null) {
            boolean isLogin = TbadkCoreApplication.isLogin();
            if (!isLogin) {
                skipToLoginActivityFromH5(context, str, str2);
            }
            return isLogin;
        }
        return invokeLLL.booleanValue;
    }

    public static int getCommonColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) {
            boolean z = true;
            if (i2 != 1 && i2 != 4) {
                z = false;
            }
            return getCommonColor(z);
        }
        return invokeI.intValue;
    }

    public static void initCommonColor() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, null) == null) || (context = mAppContext) == null || context.getResources() == null) {
            return;
        }
        mMore_color = mAppContext.getResources().getColor(R.color.common_color_10097);
        mSkin_1_common_color = mAppContext.getResources().getColor(R.color.common_color_10004);
    }

    public static void initSkinDataOnStartup(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            mAppContext = context;
            mIsNeedInit = true;
        }
    }

    public static void prepareNewView(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, view) == null) || view == null) {
            return;
        }
        cachedSkinInViews.i(Integer.valueOf(System.identityHashCode(view)));
    }

    public static void processAllViewsIn(ViewGroup viewGroup, boolean z, ViewCallback viewCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65548, null, new Object[]{viewGroup, Boolean.valueOf(z), viewCallback}) != null) {
            return;
        }
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, null, view) == null) && (view instanceof ViewGroup)) {
            processSkin((ViewGroup) view, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void processSkin(ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, viewGroup, i2) == null) {
            int identityHashCode = System.identityHashCode(viewGroup);
            Integer f2 = cachedSkinInViews.f(Integer.valueOf(identityHashCode));
            if (f2 == null || i2 != f2.intValue()) {
                processSkin0(viewGroup, i2);
                cachedSkinInViews.h(Integer.valueOf(identityHashCode), Integer.valueOf(i2));
            }
        }
    }

    public static void processSkin0(ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65551, null, viewGroup, i2) == null) {
            processAllViewsIn(viewGroup, true, new ViewCallback(i2, i2 == 1 || i2 == 4) { // from class: com.baidu.tbadk.core.util.ViewHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean val$isNight;
                public final /* synthetic */ int val$skinType;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(r7)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$skinType = i2;
                    this.val$isNight = r7;
                }

                @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
                public boolean onViewFound(View view) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view)) == null) {
                        Object tag = view.getTag();
                        if (tag != null) {
                            if (ViewHelper.TEXT_GROUP.equals(tag)) {
                                ViewHelper.setTextColor((TextView) view, this.val$skinType);
                                return false;
                            } else if (ViewHelper.TEXT_CONTENT.equals(tag)) {
                                ViewHelper.setTextColor((TextView) view, this.val$skinType);
                                return false;
                            } else if (ViewHelper.TEXT_NUM.equals(tag)) {
                                ViewHelper.setGroupTextColor((TextView) view, this.val$skinType);
                                return false;
                            } else if (ViewHelper.CHECK_BOX.equals(tag)) {
                                ViewHelper.setTextColor((CheckBox) view, this.val$skinType);
                                return false;
                            } else if (ViewHelper.SIDE_BAR_CONTENT.equals(tag)) {
                                ((TextView) view).setTextAppearance(TbadkCoreApplication.getInst().getApp(), this.val$isNight ? R.style.sidebar_content_1 : R.style.sidebar_content);
                                return false;
                            } else if (ViewHelper.MORE_UP.equals(tag)) {
                                if (view instanceof RadioButton) {
                                    ((RadioButton) view).setTextColor(ViewHelper.getCommonColor(this.val$isNight));
                                }
                                SkinManager.setBackgroundResource(view, R.drawable.more_up);
                                return false;
                            } else if (ViewHelper.MORE_MIDDLE.equals(tag)) {
                                if (view instanceof RadioButton) {
                                    ((RadioButton) view).setTextColor(ViewHelper.getCommonColor(this.val$isNight));
                                }
                                SkinManager.setBackgroundResource(view, R.drawable.more_middle);
                                return false;
                            } else if (ViewHelper.MORE_DOWN.equals(tag)) {
                                if (view instanceof RadioButton) {
                                    ((RadioButton) view).setTextColor(ViewHelper.getCommonColor(this.val$isNight));
                                }
                                SkinManager.setBackgroundResource(view, R.drawable.more_down);
                                return false;
                            } else if (ViewHelper.MORE_ALL.equals(tag)) {
                                if (view instanceof RadioButton) {
                                    ((RadioButton) view).setTextColor(ViewHelper.getCommonColor(this.val$isNight));
                                }
                                SkinManager.setBackgroundResource(view, R.drawable.more_all);
                                return false;
                            } else if (ViewHelper.ARROW.equals(tag)) {
                                SkinManager.setImageResource((ImageView) view, R.drawable.icon_ba_top_arrow_big);
                                return false;
                            } else if (ViewHelper.LIST_ITEM_LINE.equals(tag)) {
                                ViewHelper.setSkinForListDivider(view, this.val$skinType);
                                return false;
                            } else {
                                return false;
                            }
                        }
                        return false;
                    }
                    return invokeL.booleanValue;
                }
            });
        }
    }

    public static void removeStateBarViewSpace(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, null, view) == null) || view == null || view.getParent() == null) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65553, null, textView, i2) == null) || textView == null) {
            return;
        }
        if (i2 != 1 && i2 != 4) {
            textView.setTextColor(-5065030);
        } else {
            textView.setTextColor(-11446171);
        }
    }

    public static void setSkinForListDivider(View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65554, null, view, i2) == null) || view == null) {
            return;
        }
        if (i2 != 1 && i2 != 4) {
            view.setBackgroundColor(-1183760);
        } else {
            view.setBackgroundColor(-14078923);
        }
    }

    public static void setSkinForListItem(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65555, null, view, i2, i3) == null) || view == null) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65557, null, textView, i2) == null) || textView == null) {
            return;
        }
        textView.setTextColor(getCommonColor(i2));
    }

    public static void skipToLoginActivity(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, null, context) == null) || context == null) {
            return;
        }
        d.a.r0.r.z.a.a("account", -1L, 0, "nologin_intercept_tologin", 0, "", new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true)));
    }

    public static void skipToLoginActivityFromH5(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65559, null, context, str, str2) == null) || context == null) {
            return;
        }
        d.a.r0.r.z.a.a("account", -1L, 0, "nologin_intercept_tologin", 0, "", new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true, str, str2)));
    }

    @Deprecated
    public static void skipToRegisterActivity(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65560, null, context) == null) || context == null) {
            return;
        }
        d.a.r0.r.z.a.a("account", -1L, 0, "nologin_intercept_toregister", 0, "", new Object[0]);
        skipToLoginActivity(context);
    }

    public static int getCommonColor(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65544, null, z)) == null) {
            if (mIsNeedInit) {
                mIsNeedInit = false;
                initCommonColor();
            }
            return z ? mSkin_1_common_color : mMore_color;
        }
        return invokeZ.intValue;
    }

    public static void setTextColor(CheckBox checkBox, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65556, null, checkBox, i2) == null) || checkBox == null) {
            return;
        }
        checkBox.setTextColor(getCommonColor(i2));
    }

    public static boolean checkUpIsLoginFromH5(LoginActivityConfig loginActivityConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, loginActivityConfig)) == null) {
            boolean isLogin = TbadkCoreApplication.isLogin();
            if (!isLogin) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
            }
            return isLogin;
        }
        return invokeL.booleanValue;
    }
}

package com.baidu.tbadk.core.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.storage.swankv.SwanKV;
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
import com.repackage.am;
import com.repackage.dg;
import com.repackage.fm;
import com.repackage.nt4;
import com.repackage.oi;
import com.repackage.qg;
import com.repackage.zl;
import java.util.LinkedList;
/* loaded from: classes3.dex */
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
    public static dg<Integer, Integer> cachedSkinInViews = null;
    public static Context mAppContext = null;
    public static boolean mIsNeedInit = false;
    public static int mMore_color = -1;
    public static int mSkin_1_common_color = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface ShareCallback {
        void finishProgressForSharing();

        void startProgressForSharing();
    }

    /* loaded from: classes3.dex */
    public interface ViewCallback {
        boolean onViewFound(View view2);
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
        cachedSkinInViews = new dg<>(500);
        mAppContext = null;
    }

    public ViewHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void addStateBarViewSpace(View view2, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || view2 == null || view2.getParent() == null) {
            return;
        }
        View view3 = (View) view2.getParent().getParent();
        if (view3 instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) view3;
            linearLayout.setOrientation(1);
            View view4 = new View(view2.getContext());
            if (z) {
                SkinManager.setBackgroundColor(view4, i);
            } else {
                view4.setBackgroundResource(i);
            }
            linearLayout.addView(view4, 0, new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        }
    }

    public static void checkDownloadSo(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, str, str2, str3) == null) {
            if (StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get(str))) {
                DefaultDownloadCallback defaultDownloadCallback = new DefaultDownloadCallback(str3) { // from class: com.baidu.tbadk.core.util.ViewHelper.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String val$soName;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str3};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$soName = str3;
                    }

                    @Override // com.baidu.searchbox.pms.callback.DefaultDownloadCallback, com.baidu.searchbox.pms.callback.DownloadCallback
                    public void onDownloadSuccess(PackageInfo packageInfo, ErrorInfo errorInfo) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048576, this, packageInfo, errorInfo) == null) {
                            super.onDownloadSuccess(packageInfo, errorInfo);
                            ViewHelper.loadPassFaceSo(this.val$soName);
                        }
                    }
                };
                fm fmVar = new fm(str3) { // from class: com.baidu.tbadk.core.util.ViewHelper.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String val$soName;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str3};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$soName = str3;
                    }

                    @Override // com.repackage.fm
                    public void onSoFileLoaded(String str4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str4) == null) {
                            ViewHelper.loadPassFaceSo(this.val$soName);
                        }
                    }
                };
                RequestParams requestParams = new RequestParams();
                requestParams.setRunType(am.a);
                requestParams.setRunNode("aps");
                requestParams.addChannel(new zl(str2, defaultDownloadCallback, fmVar));
                PmsManager.getInstance().execute(requestParams);
                return;
            }
            loadPassFaceSo(str3);
        }
    }

    public static boolean checkUpIsLogin(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, str, str2)) == null) {
            boolean isLogin = TbadkCoreApplication.isLogin();
            if (!isLogin) {
                skipToLoginActivityFromH5(context, str, str2);
            }
            return isLogin;
        }
        return invokeLLL.booleanValue;
    }

    public static int getCommonColor(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            boolean z = true;
            if (i != 1 && i != 4) {
                z = false;
            }
            return getCommonColor(z);
        }
        return invokeI.intValue;
    }

    public static void initCommonColor() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, null) == null) || (context = mAppContext) == null || context.getResources() == null) {
            return;
        }
        mMore_color = mAppContext.getResources().getColor(R.color.common_color_10097);
        mSkin_1_common_color = mAppContext.getResources().getColor(R.color.common_color_10004);
    }

    public static void initSkinDataOnStartup(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            mAppContext = context;
            mIsNeedInit = true;
        }
    }

    public static void loadPassFaceSo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            qg.a().post(new Runnable(str) { // from class: com.baidu.tbadk.core.util.ViewHelper.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String val$soName;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$soName = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            System.loadLibrary(this.val$soName);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public static void prepareNewView(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, null, view2) == null) || view2 == null) {
            return;
        }
        cachedSkinInViews.i(Integer.valueOf(System.identityHashCode(view2)));
    }

    public static void processAllViewsIn(ViewGroup viewGroup, boolean z, ViewCallback viewCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65551, null, new Object[]{viewGroup, Boolean.valueOf(z), viewCallback}) != null) {
            return;
        }
        if (z && viewCallback.onViewFound(viewGroup)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        while (true) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
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

    public static void processCurrentSkin(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65552, null, view2) == null) && (view2 instanceof ViewGroup)) {
            processSkin((ViewGroup) view2, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public static void processSkin(ViewGroup viewGroup, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65553, null, viewGroup, i) == null) {
            int identityHashCode = System.identityHashCode(viewGroup);
            Integer f = cachedSkinInViews.f(Integer.valueOf(identityHashCode));
            if (f == null || i != f.intValue()) {
                processSkin0(viewGroup, i);
                cachedSkinInViews.h(Integer.valueOf(identityHashCode), Integer.valueOf(i));
            }
        }
    }

    public static void processSkin0(ViewGroup viewGroup, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65554, null, viewGroup, i) == null) {
            processAllViewsIn(viewGroup, true, new ViewCallback(i, i == 1 || i == 4) { // from class: com.baidu.tbadk.core.util.ViewHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean val$isNight;
                public final /* synthetic */ int val$skinType;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(i), Boolean.valueOf(r7)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$skinType = i;
                    this.val$isNight = r7;
                }

                @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
                public boolean onViewFound(View view2) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view2)) == null) {
                        Object tag = view2.getTag();
                        if (tag != null) {
                            if (ViewHelper.TEXT_GROUP.equals(tag)) {
                                ViewHelper.setTextColor((TextView) view2, this.val$skinType);
                                return false;
                            } else if (ViewHelper.TEXT_CONTENT.equals(tag)) {
                                ViewHelper.setTextColor((TextView) view2, this.val$skinType);
                                return false;
                            } else if (ViewHelper.TEXT_NUM.equals(tag)) {
                                ViewHelper.setGroupTextColor((TextView) view2, this.val$skinType);
                                return false;
                            } else if (ViewHelper.CHECK_BOX.equals(tag)) {
                                ViewHelper.setTextColor((CheckBox) view2, this.val$skinType);
                                return false;
                            } else if (ViewHelper.SIDE_BAR_CONTENT.equals(tag)) {
                                ((TextView) view2).setTextAppearance(TbadkCoreApplication.getInst().getApp(), this.val$isNight ? R.style.obfuscated_res_0x7f1003f4 : R.style.obfuscated_res_0x7f1003f3);
                                return false;
                            } else if (ViewHelper.MORE_UP.equals(tag)) {
                                if (view2 instanceof RadioButton) {
                                    ((RadioButton) view2).setTextColor(ViewHelper.getCommonColor(this.val$isNight));
                                }
                                SkinManager.setBackgroundResource(view2, R.drawable.more_up);
                                return false;
                            } else if (ViewHelper.MORE_MIDDLE.equals(tag)) {
                                if (view2 instanceof RadioButton) {
                                    ((RadioButton) view2).setTextColor(ViewHelper.getCommonColor(this.val$isNight));
                                }
                                SkinManager.setBackgroundResource(view2, R.drawable.more_middle);
                                return false;
                            } else if (ViewHelper.MORE_DOWN.equals(tag)) {
                                if (view2 instanceof RadioButton) {
                                    ((RadioButton) view2).setTextColor(ViewHelper.getCommonColor(this.val$isNight));
                                }
                                SkinManager.setBackgroundResource(view2, R.drawable.more_down);
                                return false;
                            } else if (ViewHelper.MORE_ALL.equals(tag)) {
                                if (view2 instanceof RadioButton) {
                                    ((RadioButton) view2).setTextColor(ViewHelper.getCommonColor(this.val$isNight));
                                }
                                SkinManager.setBackgroundResource(view2, R.drawable.more_all);
                                return false;
                            } else if (ViewHelper.ARROW.equals(tag)) {
                                SkinManager.setImageResource((ImageView) view2, R.drawable.icon_ba_top_arrow_big);
                                return false;
                            } else if (ViewHelper.LIST_ITEM_LINE.equals(tag)) {
                                ViewHelper.setSkinForListDivider(view2, this.val$skinType);
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

    public static void removeStateBarViewSpace(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, null, view2) == null) || view2 == null || view2.getParent() == null) {
            return;
        }
        View view3 = (View) view2.getParent().getParent();
        if (view3 instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) view3;
            if (linearLayout.getChildCount() >= 2) {
                linearLayout.removeViewAt(0);
            }
        }
    }

    public static void setGroupTextColor(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65556, null, textView, i) == null) || textView == null) {
            return;
        }
        if (i != 1 && i != 4) {
            textView.setTextColor(-5065030);
        } else {
            textView.setTextColor(-11446171);
        }
    }

    public static void setSkinForListDivider(View view2, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65557, null, view2, i) == null) || view2 == null) {
            return;
        }
        if (i != 1 && i != 4) {
            view2.setBackgroundColor(-1183760);
        } else {
            view2.setBackgroundColor(-14078923);
        }
    }

    public static void setSkinForListItem(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65558, null, view2, i, i2) == null) || view2 == null) {
            return;
        }
        view2.setBackgroundDrawable(null);
        if (i == 0) {
            SkinManager.setBackgroundResource(view2, R.drawable.auto_skin_list_item_bg_up);
        } else if (i == 2) {
            SkinManager.setBackgroundResource(view2, R.drawable.auto_skin_list_item_bg_down);
        } else {
            SkinManager.setBackgroundResource(view2, R.drawable.list_selector_item);
        }
    }

    public static void setTextColor(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65560, null, textView, i) == null) || textView == null) {
            return;
        }
        textView.setTextColor(getCommonColor(i));
    }

    public static void skipToLoginActivity(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, context) == null) {
            skipToLoginActivity(context, null);
        }
    }

    public static void skipToLoginActivityFromH5(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65563, null, context, str, str2) == null) || context == null) {
            return;
        }
        nt4.a(DI.ACCOUNT, -1L, 0, "nologin_intercept_tologin", 0, "", new Object[0]);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(context, true, str, str2)));
    }

    @Deprecated
    public static void skipToRegisterActivity(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65564, null, context) == null) || context == null) {
            return;
        }
        nt4.a(DI.ACCOUNT, -1L, 0, "nologin_intercept_toregister", 0, "", new Object[0]);
        skipToLoginActivity(context);
    }

    public static int getCommonColor(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65546, null, z)) == null) {
            if (mIsNeedInit) {
                mIsNeedInit = false;
                initCommonColor();
            }
            return z ? mSkin_1_common_color : mMore_color;
        }
        return invokeZ.intValue;
    }

    public static void setTextColor(CheckBox checkBox, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65559, null, checkBox, i) == null) || checkBox == null) {
            return;
        }
        checkBox.setTextColor(getCommonColor(i));
    }

    public static void skipToLoginActivity(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65562, null, context, str) == null) || context == null) {
            return;
        }
        nt4.a(DI.ACCOUNT, -1L, 0, "nologin_intercept_tologin", 0, "", new Object[0]);
        checkDownloadSo("libmml_framework.so", "com.baidu.tieba.soloader.libmmlframework", "mml_framework");
        checkDownloadSo("libc++_shared.so", "com.baidu.tieba.soloader.libcshared", SwanKV.LIB_CPP_SHARED);
        checkDownloadSo("libopencv_java3.so", "com.baidu.tieba.soloader.libopencv_java3", "opencv_java3");
        checkDownloadSo("libbd_pass_face_sdk.so", "com.baidu.tieba.soloader.libbdface", "bd_pass_face_sdk");
        LoginActivityConfig loginActivityConfig = new LoginActivityConfig(context, true);
        if (!oi.isEmpty(str)) {
            loginActivityConfig.setFrom(str);
        }
        if (StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get("libmml_framework.so"))) {
            RequestParams requestParams = new RequestParams();
            requestParams.setRunType(am.a);
            requestParams.setRunNode("aps");
            requestParams.addChannel(new zl("com.baidu.tieba.soloader.libmmlframework", (DefaultDownloadCallback) null));
            PmsManager.getInstance().execute(requestParams);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
    }

    public static boolean checkUpIsLoginFromH5(LoginActivityConfig loginActivityConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, loginActivityConfig)) == null) {
            boolean isLogin = TbadkCoreApplication.isLogin();
            if (!isLogin) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, loginActivityConfig));
            }
            return isLogin;
        }
        return invokeL.booleanValue;
    }
}

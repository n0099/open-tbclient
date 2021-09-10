package com.baidu.fsg.base.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.NoProguard;
import com.baidu.fsg.base.activity.a.a;
import com.baidu.fsg.base.restnet.beans.business.BeanConstants;
import com.baidu.fsg.base.statistics.RimStatisticsUtil;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.fsg.base.utils.RimAnimUtils;
import com.baidu.fsg.base.utils.RimGlobalUtils;
import com.baidu.fsg.base.widget.SafeScrollView;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class BaseActivity extends Activity implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DIALOG_LOADING = 242;
    public static final int DIALOG_PROMPT = 241;
    public static final int FLAG_PAY_SKD = 1;
    public static final String MULTI_WINDOW_TIPS;
    public static final String MULTI_WINDOW_TIPS_CLOSE;
    public static final String WITH_ANIM = "with_anim";

    /* renamed from: a  reason: collision with root package name */
    public static final String f39322a = "BaseActivity";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f39323b = false;
    public static LinkedList<BaseActivity> mActivityStack;
    public static int mLiveActivityNum;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39324c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39325d;

    /* renamed from: e  reason: collision with root package name */
    public String f39326e;

    /* renamed from: f  reason: collision with root package name */
    public SafeScrollView f39327f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39328g;

    /* renamed from: h  reason: collision with root package name */
    public long f39329h;
    public int mFlag;
    public RimStatisticsUtil mStatUtil;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1408168714, "Lcom/baidu/fsg/base/activity/BaseActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1408168714, "Lcom/baidu/fsg/base/activity/BaseActivity;");
                return;
            }
        }
        mActivityStack = new LinkedList<>();
        mLiveActivityNum = 0;
        MULTI_WINDOW_TIPS = ResUtils.string("multi_window_tips");
        MULTI_WINDOW_TIPS_CLOSE = ResUtils.string("multi_window_tips_close");
    }

    public BaseActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFlag = -1;
        this.f39324c = false;
        this.f39325d = true;
        this.f39326e = MULTI_WINDOW_TIPS;
        this.f39327f = null;
        this.f39328g = false;
    }

    @TargetApi(24)
    private void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && Build.VERSION.SDK_INT >= 24 && isInMultiWindowMode()) {
            if (this.f39324c) {
                RimGlobalUtils.toastWithText(getActivity(), this.f39326e, 1);
            }
            if (this.f39325d) {
                return;
            }
            finish();
        }
    }

    public static void addLiveActivityNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            mLiveActivityNum++;
        }
    }

    public static synchronized void addToTask(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, baseActivity) == null) {
            synchronized (BaseActivity.class) {
                mActivityStack.remove(baseActivity);
                mActivityStack.add(baseActivity);
            }
        }
    }

    public static synchronized void clearTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            synchronized (BaseActivity.class) {
                Iterator<BaseActivity> it = mActivityStack.iterator();
                while (it.hasNext()) {
                    it.next().finish();
                }
            }
        }
    }

    public static synchronized void clearTaskExcept(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, baseActivity) == null) {
            synchronized (BaseActivity.class) {
                Iterator<BaseActivity> it = mActivityStack.iterator();
                while (it.hasNext()) {
                    BaseActivity next = it.next();
                    if (next != baseActivity) {
                        next.finish();
                    }
                }
            }
        }
    }

    public static synchronized void clearTasksTopOf(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, baseActivity) == null) {
            synchronized (BaseActivity.class) {
                LogUtil.d("BaseActivity", "clearTasksTopOf. stack size = " + mActivityStack.size());
                for (int size = mActivityStack.size() + (-1); size > 0; size--) {
                    BaseActivity baseActivity2 = mActivityStack.get(size);
                    if (baseActivity2 == baseActivity) {
                        break;
                    }
                    baseActivity2.finish();
                }
            }
        }
    }

    public static synchronized void clearTasksWithFlag(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, null, i2) == null) {
            synchronized (BaseActivity.class) {
                LogUtil.d("BaseActivity", "clearTasksWithFlag. stack size = " + mActivityStack.size());
                Iterator<BaseActivity> it = mActivityStack.iterator();
                while (it.hasNext()) {
                    BaseActivity next = it.next();
                    if (next.mFlag == i2) {
                        next.finish();
                        next.overridePendingTransition(0, 0);
                    }
                }
            }
        }
    }

    public static void decLiveActivityNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            mLiveActivityNum--;
        }
    }

    public static BaseActivity getTopActivity() throws Throwable {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? mActivityStack.getLast() : (BaseActivity) invokeV.objValue;
    }

    public static boolean isAppInForeground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? mLiveActivityNum > 0 : invokeV.booleanValue;
    }

    public static synchronized void removeFromTask(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, baseActivity) == null) {
            synchronized (BaseActivity.class) {
                mActivityStack.remove(baseActivity);
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.finish();
            if ("1".equals(BeanConstants.ANIMSTYLE)) {
                RimAnimUtils.finishActivityAnim(getActivity());
            }
        }
    }

    public void finishWithoutAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.finish();
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (Activity) invokeV.objValue;
    }

    public ArrayList<String> getHandlerFailureData(int i2, int i3, String str) {
        InterceptResult invokeIIL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048579, this, i2, i3, str)) == null) {
            String str3 = "";
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                str2 = String.valueOf(i2);
                try {
                    str3 = String.valueOf(i3);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                str2 = "";
            }
            arrayList.add(str2);
            arrayList.add(str3);
            arrayList.add(str);
            return arrayList;
        }
        return (ArrayList) invokeIIL.objValue;
    }

    public boolean isActivityInForeground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f39328g : invokeV.booleanValue;
    }

    public boolean isRequestedOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onBackPressed();
            if ("1".equals(BeanConstants.ANIMSTYLE)) {
                RimAnimUtils.finishActivityAnim(getActivity());
            }
        }
    }

    public void onBackPressedWithoutAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onBackPressed();
            overridePendingTransition(0, 0);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            this.f39329h = System.currentTimeMillis();
            this.mStatUtil = RimStatisticsUtil.getInstance();
            RimStatisticsUtil.onPush(getClass().getSimpleName());
            if (isRequestedOrientation()) {
                setRequestedOrientation(1);
            }
            super.onCreate(bundle);
            LogUtil.e("debug_msg", "onCreate-----" + getClass().getName(), null);
            addToTask(this);
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? i2 != 242 ? super.onCreateDialog(i2) : new a(this) : (Dialog) invokeI.objValue;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            removeFromTask(this);
            RimStatisticsUtil.onBack(getClass().getSimpleName());
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i2, keyEvent)) == null) {
            if (i2 == 82 && keyEvent.isLongPress()) {
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    @TargetApi(24)
    public void onMultiWindowModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || Build.VERSION.SDK_INT < 24) {
            return;
        }
        super.onMultiWindowModeChanged(z);
        SafeScrollView safeScrollView = this.f39327f;
        if (safeScrollView != null) {
            safeScrollView.dismissKeyBoard();
        }
        if (z && isActivityInForeground()) {
            if (this.f39324c) {
                RimGlobalUtils.toastWithText(getActivity(), this.f39326e, 1);
            }
            if (this.f39325d) {
                return;
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            decLiveActivityNum();
            this.f39328g = false;
            RimStatisticsUtil.onOut(getClass().getSimpleName());
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            addLiveActivityNum();
            this.f39328g = true;
            if (0 != this.f39329h) {
                RimStatisticsUtil.onIn(getClass().getSimpleName(), System.currentTimeMillis() - this.f39329h);
                this.f39329h = 0L;
            } else {
                RimStatisticsUtil.onIn(getClass().getSimpleName(), 0L);
            }
            a();
        }
    }

    public void setFlagPaySdk() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.mFlag = 1;
        }
    }

    public void setIsMultiWindowAvailable(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || z == this.f39325d) {
            return;
        }
        this.f39325d = z;
    }

    public void setIsShowMultiWindowTips(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || z == this.f39324c) {
            return;
        }
        this.f39324c = z;
    }

    public void setMultiWindowTipsId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.f39326e = str;
        }
    }

    public void setSafeScrollView(SafeScrollView safeScrollView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, safeScrollView) == null) {
            this.f39327f = safeScrollView;
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, intent) == null) {
            startActivityForResult(intent, -1);
        }
    }

    public void startActivity(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cls) == null) {
            startActivityForResult(new Intent(getActivity(), cls), -1);
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, intent, i2) == null) {
            super.startActivityForResult(intent, i2);
            if ("1".equals(BeanConstants.ANIMSTYLE)) {
                RimAnimUtils.startActivityAnim(getActivity());
            }
        }
    }

    public void startActivityForResult(Class<?> cls, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, cls, i2) == null) {
            startActivityForResult(new Intent(this, cls), i2);
        }
    }

    public void startActivityForResultWithoutAnim(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048600, this, intent, i2) == null) {
            super.startActivityForResult(intent, i2);
        }
    }

    public void startActivityWithExtras(Bundle bundle, Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, bundle, cls) == null) {
            startActivityWithExtras(bundle, cls, true);
        }
    }

    public void startActivityWithExtras(Bundle bundle, Class<?> cls, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048602, this, bundle, cls, z) == null) {
            if (bundle == null) {
                bundle = getIntent().getExtras();
            }
            Intent intent = new Intent(getActivity(), cls);
            intent.putExtras(bundle);
            if (z) {
                startActivity(intent);
            } else {
                startActivityWithoutAnim(intent);
            }
        }
    }

    public void startActivityWithoutAnim(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, intent) == null) {
            super.startActivityForResult(intent, -1);
        }
    }
}

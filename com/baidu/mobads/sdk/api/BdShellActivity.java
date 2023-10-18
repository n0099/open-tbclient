package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.ar;
import com.baidu.mobads.sdk.internal.bq;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BdShellActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public static boolean canShowWhenLock;
    public static ActionBarColorTheme mSActionBarColorTheme;
    public transient /* synthetic */ FieldHolder $fh;
    public br mAdLogger;
    public ClassLoader mLoader;
    public IActivityImpl mProxyActivity;

    /* loaded from: classes3.dex */
    public static class ActionBarColorTheme implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final ActionBarColorTheme ACTION_BAR_BLACK_THEME;
        public static final ActionBarColorTheme ACTION_BAR_BLUE_THEME;
        public static final ActionBarColorTheme ACTION_BAR_COFFEE_THEME;
        public static final ActionBarColorTheme ACTION_BAR_GREEN_THEME;
        public static final ActionBarColorTheme ACTION_BAR_NAVYBLUE_THEME;
        public static final ActionBarColorTheme ACTION_BAR_RED_THEME;
        public static final ActionBarColorTheme ACTION_BAR_WHITE_THEME;
        public transient /* synthetic */ FieldHolder $fh;
        public int backgroundColor;
        public int closeColor;
        public int progressColor;
        public int titleColor;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(573224474, "Lcom/baidu/mobads/sdk/api/BdShellActivity$ActionBarColorTheme;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(573224474, "Lcom/baidu/mobads/sdk/api/BdShellActivity$ActionBarColorTheme;");
                    return;
                }
            }
            ACTION_BAR_WHITE_THEME = new ActionBarColorTheme(-5987164, -6842473, -11113262, SwipeRefreshLayout.CIRCLE_BG_LIGHT);
            ACTION_BAR_RED_THEME = new ActionBarColorTheme(-1, -1, -12510, -1294276);
            ACTION_BAR_GREEN_THEME = new ActionBarColorTheme(-1, -1, -11113262, -14303071);
            ACTION_BAR_NAVYBLUE_THEME = new ActionBarColorTheme(-1, -1, 16764706, -14210226);
            ACTION_BAR_BLUE_THEME = new ActionBarColorTheme(-1, -1, -12510, -13870424);
            ACTION_BAR_COFFEE_THEME = new ActionBarColorTheme(-1, -1, -12510, -11255230);
            ACTION_BAR_BLACK_THEME = new ActionBarColorTheme(-1, -1, -12510, -13749450);
        }

        public ActionBarColorTheme(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.closeColor = i;
            this.titleColor = i2;
            this.progressColor = i3;
            this.backgroundColor = i4;
        }

        public ActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {actionBarColorTheme};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.closeColor = actionBarColorTheme.closeColor;
            this.titleColor = actionBarColorTheme.titleColor;
            this.progressColor = actionBarColorTheme.progressColor;
            this.backgroundColor = actionBarColorTheme.backgroundColor;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                ActionBarColorTheme actionBarColorTheme = (ActionBarColorTheme) obj;
                if (this.backgroundColor == actionBarColorTheme.backgroundColor && this.titleColor == actionBarColorTheme.titleColor && this.closeColor == actionBarColorTheme.closeColor && this.progressColor == actionBarColorTheme.progressColor) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void setBackgroundColor(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                this.backgroundColor = i;
            }
        }

        public void setCloseColor(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.closeColor = i;
            }
        }

        public void setProgressColor(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
                this.progressColor = i;
            }
        }

        public void setTitleColor(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                this.titleColor = i;
            }
        }

        public int getBackgroundColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.backgroundColor;
            }
            return invokeV.intValue;
        }

        public int getCloseColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.closeColor;
            }
            return invokeV.intValue;
        }

        public int getProgressColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.progressColor;
            }
            return invokeV.intValue;
        }

        public int getTitleColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.titleColor;
            }
            return invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1745246329, "Lcom/baidu/mobads/sdk/api/BdShellActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1745246329, "Lcom/baidu/mobads/sdk/api/BdShellActivity;");
                return;
            }
        }
        mSActionBarColorTheme = ActionBarColorTheme.ACTION_BAR_WHITE_THEME;
    }

    public BdShellActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAdLogger = br.a();
    }

    public static ActionBarColorTheme getActionBarColorTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return mSActionBarColorTheme;
        }
        return (ActionBarColorTheme) invokeV.objValue;
    }

    public static Class<?> getActivityClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return BdShellActivity.class;
        }
        return (Class) invokeV.objValue;
    }

    public static boolean getLpShowWhenLocked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return canShowWhenLock;
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            IActivityImpl iActivityImpl = this.mProxyActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onAttachedToWindow();
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onBackPressed();
            IActivityImpl iActivityImpl = this.mProxyActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onBackPressed();
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            IActivityImpl iActivityImpl = this.mProxyActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onDestroy();
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDetachedFromWindow();
            IActivityImpl iActivityImpl = this.mProxyActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onDetachedFromWindow();
            }
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            IActivityImpl iActivityImpl = this.mProxyActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onPause();
            }
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            IActivityImpl iActivityImpl = this.mProxyActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onResume();
            }
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onStart();
            IActivityImpl iActivityImpl = this.mProxyActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onStart();
            }
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onStop();
            IActivityImpl iActivityImpl = this.mProxyActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onStop();
            }
        }
    }

    public static void canLpShowWhenLocked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            canShowWhenLock = z;
        }
    }

    public static void setActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, actionBarColorTheme) == null) && actionBarColorTheme != null) {
            mSActionBarColorTheme = new ActionBarColorTheme(actionBarColorTheme);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, keyEvent)) == null) {
            IActivityImpl iActivityImpl = this.mProxyActivity;
            if (iActivityImpl != null) {
                z = iActivityImpl.dispatchKeyEvent(keyEvent);
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            IActivityImpl iActivityImpl = this.mProxyActivity;
            if (iActivityImpl != null) {
                z = iActivityImpl.dispatchTouchEvent(motionEvent);
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, configuration) == null) {
            IActivityImpl iActivityImpl = this.mProxyActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onConfigurationChanged(configuration);
            }
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, intent) == null) {
            IActivityImpl iActivityImpl = this.mProxyActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onNewIntent(intent);
            }
            super.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
            IActivityImpl iActivityImpl = this.mProxyActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onRestoreInstanceState(bundle);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            IActivityImpl iActivityImpl = this.mProxyActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onSaveInstanceState(bundle);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, motionEvent)) == null) {
            IActivityImpl iActivityImpl = this.mProxyActivity;
            if (iActivityImpl != null) {
                z = iActivityImpl.onTouchEvent(motionEvent);
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            super.onWindowFocusChanged(z);
            IActivityImpl iActivityImpl = this.mProxyActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onWindowFocusChanged(z);
            }
        }
    }

    public static void setActionBarColor(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(65542, null, i, i2, i3, i4) == null) {
            mSActionBarColorTheme = new ActionBarColorTheme(i, i2, i3, i4);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            IActivityImpl iActivityImpl = this.mProxyActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onActivityResult(i, i2, intent);
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Class<?> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            Intent intent = getIntent();
            try {
                ClassLoader a2 = bq.a(this);
                this.mLoader = a2;
                if (intent != null) {
                    intent.setExtrasClassLoader(a2);
                }
                String str = "";
                if (intent != null) {
                    str = intent.getStringExtra("activityImplName");
                    if ("Dialog".equals(intent.getStringExtra("theme"))) {
                        setTheme(R.style.obfuscated_res_0x7f1003b7);
                    }
                }
                Object obj = null;
                if (!TextUtils.isEmpty(str) && (a = ar.a(str, this.mLoader)) != null) {
                    obj = a.getConstructor(new Class[0]).newInstance(new Object[0]);
                }
                if (obj != null) {
                    this.mProxyActivity = (IActivityImpl) obj;
                }
                if (this.mProxyActivity != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("bar_close_color", mSActionBarColorTheme.closeColor);
                        jSONObject.put("bar_pro_color", mSActionBarColorTheme.progressColor);
                        jSONObject.put("bar_title_color", mSActionBarColorTheme.titleColor);
                        jSONObject.put("bar_bg_color", mSActionBarColorTheme.backgroundColor);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    this.mProxyActivity.setLpBussParam(jSONObject);
                    this.mProxyActivity.setActivity(this);
                    if (intent != null) {
                        this.mProxyActivity.onCreate(bundle);
                    }
                }
            } catch (Exception e2) {
                br.a().c(e2);
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, keyEvent)) == null) {
            IActivityImpl iActivityImpl = this.mProxyActivity;
            if (iActivityImpl != null) {
                z = iActivityImpl.onKeyDown(i, keyEvent);
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i, keyEvent)) == null) {
            IActivityImpl iActivityImpl = this.mProxyActivity;
            if (iActivityImpl != null) {
                z = iActivityImpl.onKeyUp(i, keyEvent);
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
            return super.onKeyUp(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i, i2) == null) {
            super.overridePendingTransition(i, i2);
            IActivityImpl iActivityImpl = this.mProxyActivity;
            if (iActivityImpl != null) {
                iActivityImpl.overridePendingTransition(i, i2);
            }
        }
    }
}

package com.baidu.searchbox.process.ipc.agent.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.searchbox.process.ipc.agent.Agent;
import com.baidu.searchbox.process.ipc.delegate.DelegateDef;
import com.baidu.searchbox.process.ipc.delegate.Delegation;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.searchbox.process.ipc.util.OrientationUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Modifier;
/* loaded from: classes4.dex */
public class ProcessDelegateBaseActivity extends Activity implements Agent, DelegateDef {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "DelegateBaseActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public String mAppKey;
    public ActivityDelegation mDelegation;
    public String mDelegationName;

    public ProcessDelegateBaseActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDelegationName = "";
    }

    private void exitByIllegalDelegationClass(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            exit(4, str);
        }
    }

    private boolean initDelegation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            try {
                Class<?> cls = Class.forName(this.mDelegationName);
                if (cls == null) {
                    exitByIllegalDelegationClass("Action class is null");
                    return false;
                }
                int modifiers = cls.getModifiers();
                if (Delegation.class.isAssignableFrom(cls) && !cls.isInterface() && !Modifier.isAbstract(modifiers)) {
                    Object newInstance = cls.newInstance();
                    if (!(newInstance instanceof ActivityDelegation)) {
                        exitByIllegalDelegationClass("action obj illegal");
                        return false;
                    }
                    this.mDelegation = (ActivityDelegation) newInstance;
                    return true;
                }
                exitByIllegalDelegationClass("Illegal action class, modifiers=" + modifiers);
                return false;
            } catch (ClassNotFoundException e2) {
                exitByIllegalDelegationClass(e2.toString());
                return false;
            } catch (IllegalAccessException e3) {
                exitByIllegalDelegationClass(e3.toString());
                return false;
            } catch (InstantiationException e4) {
                exitByIllegalDelegationClass(e4.toString());
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.process.ipc.agent.Agent
    public void exit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            exit(0, "");
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.finish();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            this.mDelegation.onAttachedToWindow();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            exit(5, "by BackPresse");
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            int releaseFixedOrientation = OrientationUtils.releaseFixedOrientation(this);
            super.onCreate(bundle);
            OrientationUtils.fixedOrientation(this, releaseFixedOrientation);
            Intent intent = getIntent();
            String stringExtra = intent.getStringExtra(DelegateDef.EXTRA_DELEGATION_NAME);
            this.mDelegationName = stringExtra;
            if (!TextUtils.isEmpty(stringExtra)) {
                if (!initDelegation()) {
                    LogUtil.logActivity(this, "onCreate");
                    return;
                }
                Bundle bundleExtra = intent.getBundleExtra(DelegateDef.EXTRA_PARAMS);
                if (bundleExtra != null && !bundleExtra.isEmpty()) {
                    this.mDelegation.mParams.putAll(bundleExtra);
                }
                this.mDelegation.setAgent(this);
                this.mDelegation.exec();
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("empty action name");
            LogUtil.logActivity(this, "onCreate");
            throw illegalArgumentException;
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ActivityDelegation activityDelegation = this.mDelegation;
            if (activityDelegation != null) {
                activityDelegation.onAgentDestroy();
            }
            super.onDestroy();
        }
    }

    public void exit(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            Intent intent = new Intent();
            intent.putExtra(DelegateDef.EXTRA_DELEGATION_NAME, this.mDelegationName);
            intent.putExtra(DelegateDef.EXTRA_RESULT_CODE, i);
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra(DelegateDef.EXTRA_RESULT_DESC, str);
            }
            ActivityDelegation activityDelegation = this.mDelegation;
            if (activityDelegation != null && !activityDelegation.mResult.isEmpty()) {
                intent.putExtra(DelegateDef.EXTRA_RESULT, this.mDelegation.mResult);
            }
            setResult(-1, intent);
            finish();
        }
    }
}

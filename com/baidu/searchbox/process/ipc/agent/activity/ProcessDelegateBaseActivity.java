package com.baidu.searchbox.process.ipc.agent.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.process.ipc.agent.Agent;
import com.baidu.searchbox.process.ipc.delegate.DelegateDef;
import com.baidu.searchbox.process.ipc.delegate.Delegation;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.searchbox.process.ipc.util.OrientationUtils;
import java.lang.reflect.Modifier;
/* loaded from: classes4.dex */
public class ProcessDelegateBaseActivity extends Activity implements Agent, DelegateDef {
    public static final boolean DEBUG = false;
    public static final String TAG = "DelegateBaseActivity";
    public String mAppKey;
    public ActivityDelegation mDelegation;
    public String mDelegationName = "";

    @Override // com.baidu.searchbox.process.ipc.agent.Agent
    public void exit() {
        exit(0, "");
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mDelegation.onAttachedToWindow();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        exit(5, "by BackPresse");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        ActivityDelegation activityDelegation = this.mDelegation;
        if (activityDelegation != null) {
            activityDelegation.onAgentDestroy();
        }
        super.onDestroy();
    }

    private void exitByIllegalDelegationClass(String str) {
        exit(4, str);
    }

    private boolean initDelegation() {
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
        } catch (ClassNotFoundException e) {
            exitByIllegalDelegationClass(e.toString());
            return false;
        } catch (IllegalAccessException e2) {
            exitByIllegalDelegationClass(e2.toString());
            return false;
        } catch (InstantiationException e3) {
            exitByIllegalDelegationClass(e3.toString());
            return false;
        }
    }

    public void exit(int i, String str) {
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

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = OrientationUtils.releaseFixedOrientation(this);
        super.onCreate(bundle);
        OrientationUtils.fixedOrientation(this, releaseFixedOrientation);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(DelegateDef.EXTRA_DELEGATION_NAME);
        this.mDelegationName = stringExtra;
        if (!TextUtils.isEmpty(stringExtra)) {
            if (!initDelegation()) {
                return;
            }
            Bundle bundleExtra = intent.getBundleExtra(DelegateDef.EXTRA_PARAMS);
            if (bundleExtra != null && !bundleExtra.isEmpty()) {
                this.mDelegation.mParams.putAll(bundleExtra);
            }
            this.mDelegation.setAgent(this);
            this.mDelegation.exec();
            return;
        }
        throw new IllegalArgumentException("empty action name");
    }
}

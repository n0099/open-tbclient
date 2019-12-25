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
/* loaded from: classes9.dex */
public class ProcessDelegateBaseActivity extends Activity implements Agent, DelegateDef {
    private static final boolean DEBUG = false;
    private static final String TAG = "DelegateBaseActivity";
    private String mAppKey;
    protected ActivityDelegation mDelegation;
    protected String mDelegationName = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = OrientationUtils.releaseFixedOrientation(this);
        super.onCreate(bundle);
        OrientationUtils.fixedOrientation(this, releaseFixedOrientation);
        Intent intent = getIntent();
        this.mDelegationName = intent.getStringExtra(DelegateDef.EXTRA_DELEGATION_NAME);
        if (TextUtils.isEmpty(this.mDelegationName)) {
            throw new IllegalArgumentException("empty action name");
        }
        if (initDelegation()) {
            Bundle bundleExtra = intent.getBundleExtra("extra_params");
            if (bundleExtra != null && !bundleExtra.isEmpty()) {
                this.mDelegation.mParams.putAll(bundleExtra);
            }
            this.mDelegation.setAgent(this);
            this.mDelegation.exec();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mDelegation.onAttachedToWindow();
    }

    private boolean initDelegation() {
        boolean z;
        try {
            Class<?> cls = Class.forName(this.mDelegationName);
            if (cls == null) {
                exitByIllegalDelegationClass("Action class is null");
                z = false;
            } else {
                int modifiers = cls.getModifiers();
                if (!Delegation.class.isAssignableFrom(cls) || cls.isInterface() || Modifier.isAbstract(modifiers)) {
                    exitByIllegalDelegationClass("Illegal action class, modifiers=" + modifiers);
                    z = false;
                } else {
                    Object newInstance = cls.newInstance();
                    if (!(newInstance instanceof ActivityDelegation)) {
                        exitByIllegalDelegationClass("action obj illegal");
                        z = false;
                    } else {
                        this.mDelegation = (ActivityDelegation) newInstance;
                        z = true;
                    }
                }
            }
            return z;
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

    private void exitByIllegalDelegationClass(String str) {
        exit(4, str);
    }

    @Override // com.baidu.searchbox.process.ipc.agent.Agent
    public void exit() {
        exit(0, "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void exit(int i, String str) {
        Intent intent = new Intent();
        intent.putExtra(DelegateDef.EXTRA_DELEGATION_NAME, this.mDelegationName);
        intent.putExtra(DelegateDef.EXTRA_RESULT_CODE, i);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra(DelegateDef.EXTRA_RESULT_DESC, str);
        }
        if (this.mDelegation != null && !this.mDelegation.mResult.isEmpty()) {
            intent.putExtra(DelegateDef.EXTRA_RESULT, this.mDelegation.mResult);
        }
        setResult(-1, intent);
        finish();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.mDelegation != null) {
            this.mDelegation.onAgentDestroy();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        exit(5, "by BackPresse");
    }
}

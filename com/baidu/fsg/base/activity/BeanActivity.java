package com.baidu.fsg.base.activity;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.fsg.base.restnet.beans.IBeanResponseCallback;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.fsg.base.utils.RimGlobalUtils;
/* loaded from: classes6.dex */
public abstract class BeanActivity extends BaseActivity implements IBeanResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1918a = "BaseActivity";

    /* renamed from: b  reason: collision with root package name */
    private Handler f1919b = null;
    public BeanActivity mAct;

    @Override // com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAct = this;
    }

    public void initActionBar(String str) {
    }

    public void handleResponse(int i, Object obj, String str) {
    }

    public void handleResponse(int i, Object obj, String str, String str2) {
    }

    public void handleFailure(int i, int i2, String str) {
        if (i2 == -2) {
            RimGlobalUtils.toastWithTextId(getActivity(), ResUtils.string(this.mAct, "rim_base_get_data_fail"));
        } else if (i2 == -3) {
            RimGlobalUtils.toastWithTextId(getActivity(), ResUtils.string(this.mAct, "rim_base_get_data_fail"));
        } else if (i2 == -4) {
            RimGlobalUtils.toastWithTextId(getActivity(), ResUtils.string(this.mAct, "rim_base_get_data_fail"));
        } else if (i2 == -8) {
            RimGlobalUtils.toastWithTextId(getActivity(), ResUtils.string(this.mAct, "rim_base__no_network"));
        } else {
            RimGlobalUtils.toastWithText(getActivity(), str);
        }
    }

    private Handler a() {
        if (this.f1919b == null) {
            this.f1919b = new Handler(getMainLooper());
        }
        return this.f1919b;
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i, Object obj, String str, String str2) {
        a().post(new a(this, i, obj, str, str2));
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i, int i2, String str) {
        LogUtil.i("BeanActivity", "onBeanExecFailure. bean id = " + i + ", err code = " + i2 + ", err msg = " + str);
        a().post(new b(this, i, i2, str));
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}

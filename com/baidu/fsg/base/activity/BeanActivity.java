package com.baidu.fsg.base.activity;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.fsg.base.restnet.beans.IBeanResponseCallback;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.fsg.base.utils.RimGlobalUtils;
/* loaded from: classes2.dex */
public abstract class BeanActivity extends BaseActivity implements IBeanResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5100a = "BaseActivity";

    /* renamed from: b  reason: collision with root package name */
    public Handler f5101b = null;
    public BeanActivity mAct;

    private Handler a() {
        if (this.f5101b == null) {
            this.f5101b = new Handler(getMainLooper());
        }
        return this.f5101b;
    }

    public void handleFailure(int i2, int i3, String str) {
        if (i3 == -2) {
            RimGlobalUtils.toastWithTextId(getActivity(), ResUtils.string(this.mAct, "rim_base_get_data_fail"));
        } else if (i3 == -3) {
            RimGlobalUtils.toastWithTextId(getActivity(), ResUtils.string(this.mAct, "rim_base_get_data_fail"));
        } else if (i3 == -4) {
            RimGlobalUtils.toastWithTextId(getActivity(), ResUtils.string(this.mAct, "rim_base_get_data_fail"));
        } else if (i3 == -8) {
            RimGlobalUtils.toastWithTextId(getActivity(), ResUtils.string(this.mAct, "rim_base__no_network"));
        } else {
            RimGlobalUtils.toastWithText(getActivity(), str);
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
    }

    public void handleResponse(int i2, Object obj, String str, String str2) {
    }

    public void initActionBar(String str) {
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        LogUtil.i("BeanActivity", "onBeanExecFailure. bean id = " + i2 + ", err code = " + i3 + ", err msg = " + str);
        a().post(new b(this, i2, i3, str));
    }

    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str, String str2) {
        a().post(new a(this, i2, obj, str, str2));
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAct = this;
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.fsg.base.activity.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}

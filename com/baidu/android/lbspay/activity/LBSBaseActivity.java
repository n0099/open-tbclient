package com.baidu.android.lbspay.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.view.TitleBar;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity;
/* loaded from: classes.dex */
public abstract class LBSBaseActivity extends DxmPayBaseActivity implements IBeanResponseCallback, NoProguard {
    public TitleBar titleBar;
    public Handler mHandler = null;
    public BroadcastReceiver mExitReceiver = new BroadcastReceiver() { // from class: com.baidu.android.lbspay.activity.LBSBaseActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (LBSPayResult.ACTION_EXIT.equals(intent.getAction())) {
                LBSBaseActivity.this.finish();
            }
        }
    };

    private Handler getHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(getMainLooper());
        }
        return this.mHandler;
    }

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    public abstract void handleFailure(int i, int i2, String str);

    public abstract void handleResponse(int i, Object obj, String str);

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(final int i, final int i2, final String str) {
        getHandler().post(new Runnable() { // from class: com.baidu.android.lbspay.activity.LBSBaseActivity.4
            @Override // java.lang.Runnable
            public void run() {
                LBSBaseActivity.this.handleFailure(i, i2, str);
            }
        });
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(final int i, final Object obj, final String str) {
        getHandler().post(new Runnable() { // from class: com.baidu.android.lbspay.activity.LBSBaseActivity.3
            @Override // java.lang.Runnable
            public void run() {
                LBSBaseActivity.this.handleResponse(i, obj, str);
            }
        });
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.mExitReceiver, new IntentFilter(LBSPayResult.ACTION_EXIT));
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.mExitReceiver != null) {
            LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.mExitReceiver);
        }
        super.onDestroy();
    }

    public void setBackButton() {
        TitleBar titleBar = this.titleBar;
        if (titleBar != null) {
            titleBar.setLeftButton(new View.OnClickListener() { // from class: com.baidu.android.lbspay.activity.LBSBaseActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LBSBaseActivity.this.onBackPressed();
                }
            });
        }
    }
}

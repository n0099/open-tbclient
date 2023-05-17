package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareLoginModel;
import com.baidu.sapi2.share.ShareResultCallback;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.enums.AccountType;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ShareResultProxyActivity extends Activity implements NoProguard {
    public static final String KEY_EXTRA_PARAMS = "key_extra_params";
    public static final String KEY_PKG = "key_pkg";
    public static final String KEY_SESSION_ID = "key_session_id";
    public static final String KEY_TRACE_ID = "key_trace_id";
    public static final String KEY_URL = "key_url";
    public static final String KEY_VERSION = "key_version";
    public static final String h = "ShareResultProxyActivity";
    public static final String i = "key_launch_share_activity_status";
    public String a;
    public String b;
    public String c;
    public String d;
    public ArrayList<PassNameValuePair> e;
    public String f;
    public boolean g;

    private boolean a() {
        ISAccountManager isAccountManager;
        SapiConfiguration confignation;
        ServiceManager serviceManager = ServiceManager.getInstance();
        if (serviceManager == null || (isAccountManager = serviceManager.getIsAccountManager()) == null || (confignation = isAccountManager.getConfignation()) == null || confignation.context == null) {
            return false;
        }
        return true;
    }

    private void b() {
        this.g = true;
        this.a = getIntent().getStringExtra(KEY_PKG);
        if (ShareLoginModel.getInstance().isMeetShareV4(this, this.a)) {
            Log.d(h, "openShareLogin: is meet share_v4");
            ShareLoginModel.getInstance().openV4ShareLogin(this, this.a, "product");
            ShareLoginStat.MakeShareLoginStat.statExtMap.put(ShareLoginStat.MakeShareLoginStat.KEY_NEED_AUTH, "0");
            return;
        }
        Log.d(h, "openShareLogin: is not share_v4");
        c();
    }

    private void c() {
        Intent intent = getIntent();
        this.a = intent.getStringExtra(KEY_PKG);
        this.b = intent.getStringExtra("key_url");
        this.c = intent.getStringExtra(KEY_TRACE_ID);
        this.d = intent.getStringExtra("key_session_id");
        this.e = (ArrayList) intent.getSerializableExtra(KEY_EXTRA_PARAMS);
        this.f = intent.getStringExtra(KEY_VERSION);
        new ShareCallPacking().startLoginShareActivityForResult(this, this.a, this.b, this.c, this.d, this.e, this.f, "product");
        ShareLoginStat.MakeShareLoginStat.statExtMap.put(ShareLoginStat.MakeShareLoginStat.KEY_NEED_AUTH, "1");
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 20001) {
            CoreViewRouter.getInstance().onShareLoginActivityResult(i2, i3, intent, "");
        } else if (i2 == 100004) {
            ShareLoginModel.getInstance().processShareResult(this, intent, new ShareResultCallback() { // from class: com.baidu.sapi2.activity.ShareResultProxyActivity.1
                @Override // com.baidu.sapi2.share.ShareResultCallback
                public void onResultAccount(SapiAccount sapiAccount) {
                    WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
                    if (webAuthListener == null) {
                        return;
                    }
                    WebAuthResult webAuthResult = new WebAuthResult();
                    if (sapiAccount == null) {
                        webAuthResult.setResultCode(-207);
                        webAuthResult.setResultMsg("互通登录失败,请稍后再试");
                        webAuthListener.onFailure(webAuthResult);
                        return;
                    }
                    webAuthResult.accountType = AccountType.NORMAL;
                    webAuthResult.setResultCode(0);
                    webAuthListener.onSuccess(webAuthResult);
                    CoreViewRouter.getInstance().release();
                }
            });
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(51);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.width = 1;
        attributes.height = 1;
        attributes.type = 2002;
        attributes.flags = 32;
        window.setAttributes(attributes);
        if (!a()) {
            WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
            if (webAuthListener == null) {
                finish();
                return;
            }
            WebAuthResult webAuthResult = new WebAuthResult();
            webAuthResult.setResultCode(-801);
            webAuthResult.setResultMsg("服务异常，请稍后再试");
            webAuthListener.onFailure(webAuthResult);
            finish();
        }
        if (bundle != null) {
            this.g = bundle.getBoolean(i, false);
        }
        if (!this.g) {
            b();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(i, this.g);
        super.onSaveInstanceState(bundle);
    }
}

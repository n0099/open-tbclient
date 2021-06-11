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
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareLoginModel;
import com.baidu.sapi2.share.ShareResultCallback;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.enums.AccountType;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ShareResultProxyActivity extends Activity implements NoProguard {
    public static final String KEY_EXTRA_PARAMS = "key_extra_params";
    public static final String KEY_PKG = "key_pkg";
    public static final String KEY_SESSION_ID = "key_session_id";
    public static final String KEY_TRACE_ID = "key_trace_id";
    public static final String KEY_URL = "key_url";
    public static final String KEY_VERSION = "key_version";

    /* renamed from: h  reason: collision with root package name */
    public static final String f9761h = "ShareResultProxyActivity";

    /* renamed from: i  reason: collision with root package name */
    public static final String f9762i = "key_launch_share_activity_status";

    /* renamed from: a  reason: collision with root package name */
    public String f9763a;

    /* renamed from: b  reason: collision with root package name */
    public String f9764b;

    /* renamed from: c  reason: collision with root package name */
    public String f9765c;

    /* renamed from: d  reason: collision with root package name */
    public String f9766d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<PassNameValuePair> f9767e;

    /* renamed from: f  reason: collision with root package name */
    public String f9768f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9769g;

    private void a() {
        this.f9769g = true;
        this.f9763a = getIntent().getStringExtra(KEY_PKG);
        if (ShareLoginModel.getInstance().isMeetShareV4(this, this.f9763a)) {
            Log.d(f9761h, "openShareLogin: is meet share_v4");
            ShareLoginModel.getInstance().openV4ShareLogin(this, this.f9763a, "product");
            return;
        }
        Log.d(f9761h, "openShareLogin: is not share_v4");
        b();
    }

    private void b() {
        Intent intent = getIntent();
        this.f9763a = intent.getStringExtra(KEY_PKG);
        this.f9764b = intent.getStringExtra("key_url");
        this.f9765c = intent.getStringExtra(KEY_TRACE_ID);
        this.f9766d = intent.getStringExtra("key_session_id");
        this.f9767e = (ArrayList) intent.getSerializableExtra(KEY_EXTRA_PARAMS);
        this.f9768f = intent.getStringExtra("key_version");
        new ShareCallPacking().startLoginShareActivityForResult(this, this.f9763a, this.f9764b, this.f9765c, this.f9766d, this.f9767e, this.f9768f, "product");
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
        if (bundle != null) {
            this.f9769g = bundle.getBoolean(f9762i, false);
        }
        if (this.f9769g) {
            return;
        }
        a();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(f9762i, this.f9769g);
        super.onSaveInstanceState(bundle);
    }
}

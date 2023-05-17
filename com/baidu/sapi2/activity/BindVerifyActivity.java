package com.baidu.sapi2.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.NormalizeGuestAccountCallback;
import com.baidu.sapi2.callback.WebBindWidgetCallback;
import com.baidu.sapi2.dto.NormalizeGuestAccountDTO;
import com.baidu.sapi2.dto.RealNameDTO;
import com.baidu.sapi2.dto.WebBindWidgetDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.NormalizeGuestAccountResult;
import com.baidu.sapi2.result.WebBindWidgetResult;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.validation.ValidationManager;
import com.baidu.validation.callback.ValidationCallback;
import com.baidu.validation.dto.ValidationDTO;
import com.baidu.validation.result.ValidationResult;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class BindVerifyActivity extends Activity {
    public static final int A = 300;
    public static final int B = 301;
    public static final int C = 302;
    public static final int D = 303;
    public static final int E = 304;
    public static final int F = 305;
    public static final int G = 306;
    public static final int H = 400;
    public static final int I = 401;
    public static final int J = 402;
    public static final int K = 403;
    public static final String KEY_REAL_NAME_LEVEL = "realNameLevel";
    public static final int L = 404;
    public static final int M = 405;
    public static final int N = 406;
    public static final int O = 407;
    public static final int P = 500;
    public static final int Q = 505;
    public static final int R = 600;
    public static final int S = 601;
    public static final String SCENE = "auth_cashier";
    public static final int T = 602;
    public static final String b = "cmd";
    public static final String c = "taskId";
    public static final String d = "tplExtraCode";
    public static final String e = "resultCode";
    public static final String f = "juniorRealNameSuc";
    public static final String g = "seniorRealNameSuc";
    public static final String h = "ds";
    public static final String i = "tk";
    public static final String j = "login";
    public static final String k = "bindphone";
    public static final String l = "normalize";
    public static final String m = "realName";
    public static final String n = "validation";
    public static final String o = "ak";
    public static final String p = "scene";
    public static final String q = "type";
    public static final int r = 101;
    public static final int s = 102;
    public static final int t = 200;
    public static final int u = 201;
    public static final int v = 202;
    public static final int w = 203;
    public static final int x = 204;
    public static final int y = 205;
    public static final int z = 206;
    public Intent a;

    public static boolean a() {
        try {
            Class.forName("com.baidu.validation.ValidationManager");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void b() {
        try {
            int intExtra = this.a.getIntExtra("taskId", -1);
            if (intExtra == -1) {
                return;
            }
            ((ActivityManager) getSystemService("activity")).moveTaskToFront(intExtra, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void d() {
        CoreViewRouter.getInstance().startLogin(this, new WebAuthListener() { // from class: com.baidu.sapi2.activity.BindVerifyActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(WebAuthResult webAuthResult) {
                int resultCode = webAuthResult.getResultCode();
                if (resultCode != -801) {
                    if (resultCode != -301) {
                        if (resultCode != -201) {
                            if (resultCode != -204) {
                                if (resultCode != -203) {
                                    BindVerifyActivity.this.a(206);
                                } else {
                                    BindVerifyActivity.this.a(203);
                                }
                            } else {
                                BindVerifyActivity.this.a(205);
                            }
                        } else {
                            BindVerifyActivity.this.a(202);
                        }
                    } else {
                        BindVerifyActivity.this.a(201);
                    }
                } else {
                    BindVerifyActivity.this.a(204);
                }
                BindVerifyActivity.this.finish();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(WebAuthResult webAuthResult) {
                try {
                    SapiAccountManager.getGlobalCallback().onLoginStatusChange();
                } catch (Exception unused) {
                    Log.e(Log.TAG, new Object[0]);
                }
                BindVerifyActivity.this.a(200);
                BindVerifyActivity.this.finish();
            }
        }, new WebLoginDTO());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        b();
        Intent intent = new Intent();
        intent.putExtra("resultCode", i2);
        setResult(-1, intent);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.a = intent;
        if (intent == null) {
            finish();
        } else {
            a(intent.getStringExtra("cmd"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, Intent intent) {
        b();
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("resultCode", i2);
        setResult(-1, intent);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        setResult(i3, intent);
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            a(101);
            finish();
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -914671791:
                if (str.equals(k)) {
                    c2 = 1;
                    break;
                }
                break;
            case -860337847:
                if (str.equals(m)) {
                    c2 = 3;
                    break;
                }
                break;
            case -43562887:
                if (str.equals(n)) {
                    c2 = 4;
                    break;
                }
                break;
            case 103149417:
                if (str.equals("login")) {
                    c2 = 0;
                    break;
                }
                break;
            case 236609293:
                if (str.equals(l)) {
                    c2 = 2;
                    break;
                }
                break;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    if (c2 != 3) {
                        if (c2 != 4) {
                            a(102);
                            finish();
                            return;
                        }
                        g();
                        return;
                    }
                    f();
                    return;
                }
                e();
                return;
            }
            c();
            return;
        }
        d();
    }

    private void c() {
        WebBindWidgetDTO webBindWidgetDTO = new WebBindWidgetDTO();
        webBindWidgetDTO.bindWidgetAction = BindWidgetAction.BIND_MOBILE;
        SapiAccountManager sapiAccountManager = SapiAccountManager.getInstance();
        if (sapiAccountManager == null) {
            a(305);
            finish();
            return;
        }
        SapiAccount session = sapiAccountManager.getSession();
        if (sapiAccountManager.getSession() == null) {
            a(305);
            finish();
            return;
        }
        webBindWidgetDTO.bduss = session.bduss;
        CoreViewRouter.getInstance().loadBindWidget(new WebBindWidgetCallback() { // from class: com.baidu.sapi2.activity.BindVerifyActivity.2
            @Override // com.baidu.sapi2.callback.WebBindWidgetCallback
            public void onFinish(WebBindWidgetResult webBindWidgetResult) {
                int resultCode = webBindWidgetResult.getResultCode();
                if (resultCode != -801) {
                    if (resultCode != -301) {
                        if (resultCode != -201) {
                            if (resultCode != 0) {
                                if (resultCode != -204) {
                                    if (resultCode != -203) {
                                        BindVerifyActivity.this.a(306);
                                    } else {
                                        BindVerifyActivity.this.a(303);
                                    }
                                } else {
                                    BindVerifyActivity.this.a(305);
                                }
                            } else {
                                BindVerifyActivity.this.a(300);
                            }
                        } else {
                            BindVerifyActivity.this.a(302);
                        }
                    } else {
                        BindVerifyActivity.this.a(301);
                    }
                } else {
                    BindVerifyActivity.this.a(304);
                }
                BindVerifyActivity.this.finish();
            }
        }, webBindWidgetDTO);
    }

    private void e() {
        NormalizeGuestAccountDTO normalizeGuestAccountDTO = new NormalizeGuestAccountDTO();
        SapiAccountManager sapiAccountManager = SapiAccountManager.getInstance();
        if (sapiAccountManager == null) {
            a(405);
            finish();
            return;
        }
        SapiAccount session = sapiAccountManager.getSession();
        if (sapiAccountManager.getSession() == null) {
            a(405);
            finish();
            return;
        }
        normalizeGuestAccountDTO.bduss = session.bduss;
        CoreViewRouter.getInstance().startNormalizeGuestAccount(this, new NormalizeGuestAccountCallback() { // from class: com.baidu.sapi2.activity.BindVerifyActivity.3
            @Override // com.baidu.sapi2.callback.NormalizeGuestAccountCallback
            public void onSuccess(NormalizeGuestAccountResult normalizeGuestAccountResult) {
                BindVerifyActivity.this.a(400);
                BindVerifyActivity.this.finish();
            }

            @Override // com.baidu.sapi2.callback.NormalizeGuestAccountCallback
            public void onFailure(NormalizeGuestAccountResult normalizeGuestAccountResult) {
                int resultCode = normalizeGuestAccountResult.getResultCode();
                if (resultCode != -801) {
                    if (resultCode != -601) {
                        if (resultCode != -301) {
                            if (resultCode != -201) {
                                if (resultCode != -204) {
                                    if (resultCode != -203) {
                                        BindVerifyActivity.this.a(407);
                                    } else {
                                        BindVerifyActivity.this.a(403);
                                    }
                                } else {
                                    BindVerifyActivity.this.a(405);
                                }
                            } else {
                                BindVerifyActivity.this.a(402);
                            }
                        } else {
                            BindVerifyActivity.this.a(401);
                        }
                    } else {
                        BindVerifyActivity.this.a(406);
                    }
                } else {
                    BindVerifyActivity.this.a(404);
                }
                BindVerifyActivity.this.finish();
            }
        }, normalizeGuestAccountDTO);
    }

    private void f() {
        int intExtra = this.a.getIntExtra(KEY_REAL_NAME_LEVEL, 0);
        String stringExtra = this.a.getStringExtra(d);
        RealNameDTO realNameDTO = new RealNameDTO();
        SapiAccountManager sapiAccountManager = SapiAccountManager.getInstance();
        if (sapiAccountManager == null) {
            a(505);
            finish();
            return;
        }
        SapiAccount session = sapiAccountManager.getSession();
        if (sapiAccountManager.getSession() == null) {
            a(505);
            finish();
            return;
        }
        realNameDTO.bduss = session.bduss;
        realNameDTO.realNameLevel = intExtra;
        realNameDTO.scene = SCENE;
        if (!TextUtils.isEmpty(stringExtra)) {
            Bundle bundle = new Bundle();
            bundle.putString(d, stringExtra);
            realNameDTO.extraParams = bundle;
        }
        CoreViewRouter.getInstance().loadAccountRealName(this, new AccountRealNameCallback() { // from class: com.baidu.sapi2.activity.BindVerifyActivity.4
            @Override // com.baidu.sapi2.callback.AccountRealNameCallback
            public void onFinish(AccountRealNameResult accountRealNameResult) {
                boolean z2 = accountRealNameResult.juniorRealNameSuc;
                boolean z3 = accountRealNameResult.seniorRealNameSuc;
                Intent intent = new Intent();
                intent.putExtra(BindVerifyActivity.f, z2);
                intent.putExtra(BindVerifyActivity.g, z3);
                BindVerifyActivity.this.a(500, intent);
                BindVerifyActivity.this.finish();
            }
        }, realNameDTO);
    }

    private void g() {
        if (!a()) {
            a(602);
            finish();
            return;
        }
        ValidationDTO validationDTO = new ValidationDTO();
        validationDTO.ak = this.a.getStringExtra("ak");
        validationDTO.scene = this.a.getStringExtra("scene");
        validationDTO.type = this.a.getStringExtra("type");
        String stringExtra = this.a.getStringExtra(d);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(d, stringExtra);
        validationDTO.extraParams = hashMap;
        ValidationManager.getInstance().openValidation(this, validationDTO, new ValidationCallback() { // from class: com.baidu.sapi2.activity.BindVerifyActivity.5
            @Override // com.baidu.validation.callback.ValidationCallback
            public void onFinish(ValidationResult validationResult) {
                Log.e("ValidationManager.getInstance().openValidation onFinish", new Object[0]);
                if (validationResult != null && validationResult.errno == 0) {
                    if (validationResult.data != null) {
                        Intent intent = new Intent();
                        intent.putExtra("ds", validationResult.data.ds);
                        intent.putExtra("tk", validationResult.data.tk);
                        BindVerifyActivity.this.a(600, intent);
                    } else {
                        BindVerifyActivity.this.a(600);
                    }
                } else {
                    BindVerifyActivity.this.a(601);
                }
                Log.e("BindVerifyActivity finish", new Object[0]);
                BindVerifyActivity.this.finish();
            }
        });
    }
}

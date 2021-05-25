package com.baidu.poly.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import com.alibaba.fastjson.asm.Label;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.poly.widget.m;
import com.google.protobuf.CodedInputStream;
import com.heytap.mcssdk.mode.CommandMessage;
import d.a.c0.a;
import d.a.c0.k.h.d;
import d.a.c0.n.b;
import d.a.c0.o.a.c;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PolyActivity extends Activity implements m.l {
    public static c m = null;
    public static a.b n = null;
    public static boolean o = false;
    public static PolyActivity p;
    public Bundle arguments;
    public m q;

    private String X() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void Y() {
        if (p != null) {
            if (n != null) {
                String a2 = b.a(2, null, "repeat_pay_cancel");
                n.a(2, a2);
                d.e(2, a2);
            }
            p.finish();
        }
    }

    private void Z() {
        this.arguments = getIntent().getBundleExtra("pay_arguements");
    }

    public static void a(Context context, c cVar, a.b bVar, Bundle bundle) {
        if (o) {
            Y();
        }
        m = cVar;
        n = bVar;
        Intent intent = new Intent(context, PolyActivity.class);
        intent.putExtra("pay_arguements", bundle);
        if (!(context instanceof Activity)) {
            d.a.c0.n.d.e("!context instanceof Activity");
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        context.startActivity(intent);
    }

    private void aa() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            window.getDecorView().setSystemUiVisibility(1024);
        }
    }

    private void b(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            String string = bundle.getString("zid");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            bundle.remove("zid");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("c", bundle.getString("cuid"));
            jSONObject.put("z", string);
            jSONObject.put(IAdRequestParam.MAC, d.a.c0.n.a.d());
            jSONObject.put("app", "android");
            jSONObject.put("ver", X());
            bundle.putString("deviceInfo", jSONObject.toString());
        } catch (Exception unused) {
        }
    }

    private Bundle c(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        d.f39439a = bundle.getString("bduss");
        d.f39440b = bundle.getString("tpOrderId");
        d.f39443e = bundle.getString("nativeAppId");
        bundle.putString("deviceType", "ANDROID");
        bundle.putString("channel", "cashiersdk");
        bundle.putString(CommandMessage.SDK_VERSION, "2.7.7");
        String[] stringArray = bundle.getStringArray("blockedPayChannels");
        if (stringArray != null && stringArray.length > 0) {
            bundle.remove("blockedPayChannels");
            JSONArray jSONArray = new JSONArray();
            for (String str : stringArray) {
                jSONArray.put(str);
            }
            bundle.putString("bannedChannels", jSONArray.toString());
        }
        b(bundle);
        return bundle;
    }

    private void clear() {
        this.q = null;
        m = null;
        this.arguments = null;
        n = null;
        o = false;
        p = null;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        clear();
        d.j();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 200) {
            if (i3 == -1) {
                d.a.c0.k.i.a.k().d(this, intent.getExtras(), this.q, true);
                return;
            }
            m mVar = this.q;
            if (mVar != null) {
                mVar.g(3, "pay canceled , back from H5. ");
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        m mVar = this.q;
        if (mVar == null) {
            super.onBackPressed();
            return;
        }
        if (!mVar.g0()) {
            super.onBackPressed();
        }
        d.a.c0.n.d.e("PolyActivity onBackPressed");
    }

    @Override // com.baidu.poly.widget.m.l
    public void onClose() {
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        aa();
        o = true;
        p = this;
        d.a();
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        Z();
        d.a.c0.n.d.e("PolyActivity onCreate");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        clear();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z || this.q != null || isFinishing() || this.arguments == null) {
            return;
        }
        m mVar = new m(this);
        this.q = mVar;
        setContentView(mVar);
        this.q.setResultListener(n);
        this.q.setCloseListener(this);
        this.q.setWalletList(new d.a.c0.k.i.c(new d.a.c0.k.i.b(this, m)));
        String string = this.arguments.getString("chosenChannel");
        if (TextUtils.equals(this.arguments.getString("panelType"), "NONE") && !TextUtils.isEmpty(string)) {
            this.q.i(c(this.arguments), string);
            return;
        }
        this.q.h(c(this.arguments));
        this.q.O();
    }
}

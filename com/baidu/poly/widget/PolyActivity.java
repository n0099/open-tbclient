package com.baidu.poly.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.poly.a;
import com.baidu.poly.a.h.d;
import com.baidu.poly.widget.m;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.heytap.mcssdk.mode.CommandMessage;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class PolyActivity extends Activity {
    private static com.baidu.poly.d.a.c bBj;
    private static a.b bBk;
    private static PolyActivity bBl;
    private static boolean o;
    private m bBm;
    private Bundle bBn;

    /* loaded from: classes9.dex */
    class a implements m.l {
        a() {
        }

        @Override // com.baidu.poly.widget.m.l
        public void onClose() {
            PolyActivity.this.finish();
        }
    }

    private String OB() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void X() {
        if (bBl != null) {
            if (bBk != null) {
                String a2 = com.baidu.poly.util.b.a(2, null, "repeat_pay_cancel");
                bBk.onResult(2, a2);
                d.b(2, a2);
            }
            bBl.finish();
        }
    }

    private void Y() {
        this.bBn = getIntent().getBundleExtra("pay_arguements");
    }

    public static void a(Context context, com.baidu.poly.d.a.c cVar, a.b bVar, Bundle bundle) {
        if (o) {
            X();
        }
        bBj = cVar;
        bBk = bVar;
        Intent intent = new Intent(context, PolyActivity.class);
        intent.putExtra("pay_arguements", bundle);
        if (!(context instanceof Activity)) {
            com.baidu.poly.util.d.info("!context instanceof Activity");
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private void clear() {
        this.bBm = null;
        bBj = null;
        this.bBn = null;
        bBk = null;
        o = false;
        bBl = null;
    }

    private Bundle m(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        d.bAj = bundle.getString("bduss");
        d.bAk = bundle.getString("tpOrderId");
        d.bAn = bundle.getString("nativeAppId");
        bundle.putString(CashierData.DEVICE_TYPE, "ANDROID");
        bundle.putString("channel", "cashiersdk");
        bundle.putString(CommandMessage.SDK_VERSION, "2.7.2");
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

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        clear();
        d.flush();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 200) {
            if (i2 == -1) {
                com.baidu.poly.a.j.a.Os().a((Context) this, intent.getExtras(), this.bBm, true);
                return;
            }
            m mVar = this.bBm;
            if (mVar != null) {
                mVar.a(3, "pay canceled , back from H5. ");
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        m mVar = this.bBm;
        if (mVar == null) {
            super.onBackPressed();
            return;
        }
        if (!mVar.onBackPressed()) {
            super.onBackPressed();
        }
        com.baidu.poly.util.d.info("PolyActivity onBackPressed");
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        o = true;
        bBl = this;
        d.G();
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        Y();
        com.baidu.poly.util.d.info("PolyActivity onCreate");
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        clear();
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.bBm == null && !isFinishing()) {
            this.bBm = new m(this);
            setContentView(this.bBm);
            this.bBm.a(bBk).n(m(this.bBn)).a(new com.baidu.poly.a.j.c(new com.baidu.poly.a.j.b(this, bBj))).a(new a()).OI();
        }
    }

    private void b(Bundle bundle) {
        if (bundle != null) {
            try {
                String string = bundle.getString("zid");
                if (!TextUtils.isEmpty(string)) {
                    bundle.remove("zid");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("c", bundle.getString("cuid"));
                    jSONObject.put("z", string);
                    jSONObject.put("mac", com.baidu.poly.util.a.getMacAddress());
                    jSONObject.put("app", "android");
                    jSONObject.put("ver", OB());
                    bundle.putString("deviceInfo", jSONObject.toString());
                }
            } catch (Exception e) {
            }
        }
    }
}

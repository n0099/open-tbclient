package com.baidu.poly.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.poly.a;
import com.baidu.poly.a.g.d;
import com.baidu.poly.widget.m;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.heytap.mcssdk.mode.CommandMessage;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PolyActivity extends Activity {
    private static com.baidu.poly.c.a.c btN;
    private static a.b bwc;
    private static PolyActivity bwd;
    private static boolean n;
    private m bwe;
    private Bundle bwf;

    /* loaded from: classes11.dex */
    class a implements m.l {
        a() {
        }

        @Override // com.baidu.poly.widget.m.l
        public void onClose() {
            PolyActivity.this.finish();
        }
    }

    private String O() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void P() {
        if (bwd != null) {
            if (bwc != null) {
                String a2 = com.baidu.poly.util.b.a(2, null, "repeat_pay_cancel");
                bwc.onResult(2, a2);
                d.b(2, a2);
            }
            bwd.finish();
        }
    }

    private void Q() {
        this.bwf = getIntent().getBundleExtra("pay_arguements");
    }

    public static void a(Context context, com.baidu.poly.c.a.c cVar, a.b bVar, Bundle bundle) {
        if (n) {
            P();
        }
        btN = cVar;
        bwc = bVar;
        Intent intent = new Intent(context, PolyActivity.class);
        intent.putExtra("pay_arguements", bundle);
        if (!(context instanceof Activity)) {
            com.baidu.poly.util.d.info("!context instanceof Activity");
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private void clear() {
        this.bwe = null;
        btN = null;
        this.bwf = null;
        bwc = null;
        n = false;
        bwd = null;
    }

    private Bundle m(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        d.bve = bundle.getString("bduss");
        d.bvf = bundle.getString("tpOrderId");
        d.bvi = bundle.getString("nativeAppId");
        bundle.putString(CashierData.DEVICE_TYPE, "ANDROID");
        bundle.putString("channel", "cashiersdk");
        bundle.putString(CommandMessage.SDK_VERSION, "2.6.3");
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
                com.baidu.poly.a.i.a.Nc().a((Context) this, intent.getExtras(), this.bwe, true);
                return;
            }
            m mVar = this.bwe;
            if (mVar != null) {
                mVar.a(3, "pay canceled , back from H5. ");
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        m mVar = this.bwe;
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
        n = true;
        bwd = this;
        d.y();
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        Q();
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
        if (z && this.bwe == null && !isFinishing()) {
            this.bwe = new m(this);
            setContentView(this.bwe);
            this.bwe.a(bwc).n(m(this.bwf)).a(new com.baidu.poly.a.i.c(new com.baidu.poly.a.i.b(this, btN))).a(new a()).Nn();
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
                    jSONObject.put("ver", O());
                    bundle.putString("deviceInfo", jSONObject.toString());
                }
            } catch (Exception e) {
            }
        }
    }
}

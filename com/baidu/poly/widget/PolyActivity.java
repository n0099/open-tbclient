package com.baidu.poly.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.poly.a;
import com.baidu.poly.widget.l;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.coloros.mcssdk.mode.CommandMessage;
import org.json.JSONArray;
/* loaded from: classes11.dex */
public class PolyActivity extends Activity {
    private static com.baidu.poly.c.a.c aPU;
    private static a.b aSh;
    private static PolyActivity aSi;
    private static boolean n;
    private l aSj;
    private Bundle aSk;

    /* loaded from: classes11.dex */
    class a implements l.k {
        a() {
        }

        @Override // com.baidu.poly.widget.l.k
        public void onClose() {
            PolyActivity.this.finish();
        }
    }

    private static void E() {
        if (aSi != null) {
            if (aSh != null) {
                String a2 = com.baidu.poly.util.a.a(2, null, "repeat_pay_cancel");
                aSh.onResult(2, a2);
                com.baidu.poly.a.g.c.b(2, a2);
            }
            aSi.finish();
        }
    }

    private void F() {
        this.aSk = getIntent().getBundleExtra("pay_arguements");
    }

    public static void a(Context context, com.baidu.poly.c.a.c cVar, a.b bVar, Bundle bundle) {
        if (n) {
            E();
        }
        aPU = cVar;
        aSh = bVar;
        Intent intent = new Intent(context, PolyActivity.class);
        intent.putExtra("pay_arguements", bundle);
        if (!(context instanceof Activity)) {
            com.baidu.poly.util.c.info("!context instanceof Activity");
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private void clear() {
        this.aSj = null;
        aPU = null;
        this.aSk = null;
        aSh = null;
        n = false;
        aSi = null;
    }

    private Bundle k(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        com.baidu.poly.a.g.c.aRh = bundle.getString("bduss");
        com.baidu.poly.a.g.c.aRi = bundle.getString("tpOrderId");
        com.baidu.poly.a.g.c.aRl = bundle.getString("nativeAppId");
        bundle.putString(CashierData.DEVICE_TYPE, "ANDROID");
        bundle.putString("channel", "cashiersdk");
        bundle.putString(CommandMessage.SDK_VERSION, "2.6.0");
        String[] stringArray = bundle.getStringArray("blockedPayChannels");
        if (stringArray != null && stringArray.length > 0) {
            bundle.remove("blockedPayChannels");
            JSONArray jSONArray = new JSONArray();
            for (String str : stringArray) {
                jSONArray.put(str);
            }
            bundle.putString("bannedChannels", jSONArray.toString());
            return bundle;
        }
        return bundle;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
        clear();
        com.baidu.poly.a.g.c.flush();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 200) {
            if (i2 == -1) {
                com.baidu.poly.a.i.a.EJ().a((Context) this, intent.getExtras(), this.aSj, true);
                return;
            }
            l lVar = this.aSj;
            if (lVar != null) {
                lVar.a(3, "pay canceled , back from H5. ");
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        l lVar = this.aSj;
        if (lVar == null) {
            super.onBackPressed();
            return;
        }
        if (!lVar.onBackPressed()) {
            super.onBackPressed();
        }
        com.baidu.poly.util.c.info("PolyActivity onBackPressed");
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        n = true;
        aSi = this;
        com.baidu.poly.a.g.c.o();
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        F();
        com.baidu.poly.util.c.info("PolyActivity onCreate");
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
        if (z && this.aSj == null && !isFinishing()) {
            this.aSj = new l(this);
            setContentView(this.aSj);
            this.aSj.a(aSh).l(k(this.aSk)).a(new com.baidu.poly.a.i.c(new com.baidu.poly.a.i.b(this, aPU))).a(new a()).EL();
        }
    }
}

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
    private static com.baidu.poly.c.a.c bml;
    private static a.b box;
    private static PolyActivity boy;
    private static boolean n;
    private Bundle boA;
    private l boz;

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
        if (boy != null) {
            if (box != null) {
                String a2 = com.baidu.poly.util.a.a(2, null, "repeat_pay_cancel");
                box.onResult(2, a2);
                com.baidu.poly.a.g.c.b(2, a2);
            }
            boy.finish();
        }
    }

    private void F() {
        this.boA = getIntent().getBundleExtra("pay_arguements");
    }

    public static void a(Context context, com.baidu.poly.c.a.c cVar, a.b bVar, Bundle bundle) {
        if (n) {
            E();
        }
        bml = cVar;
        box = bVar;
        Intent intent = new Intent(context, PolyActivity.class);
        intent.putExtra("pay_arguements", bundle);
        if (!(context instanceof Activity)) {
            com.baidu.poly.util.c.info("!context instanceof Activity");
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private void clear() {
        this.boz = null;
        bml = null;
        this.boA = null;
        box = null;
        n = false;
        boy = null;
    }

    private Bundle k(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        com.baidu.poly.a.g.c.bny = bundle.getString("bduss");
        com.baidu.poly.a.g.c.bnz = bundle.getString("tpOrderId");
        com.baidu.poly.a.g.c.bnC = bundle.getString("nativeAppId");
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
                com.baidu.poly.a.i.a.KZ().a((Context) this, intent.getExtras(), this.boz, true);
                return;
            }
            l lVar = this.boz;
            if (lVar != null) {
                lVar.a(3, "pay canceled , back from H5. ");
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        l lVar = this.boz;
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
        boy = this;
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
        if (z && this.boz == null && !isFinishing()) {
            this.boz = new l(this);
            setContentView(this.boz);
            this.boz.a(box).l(k(this.boA)).a(new com.baidu.poly.a.i.c(new com.baidu.poly.a.i.b(this, bml))).a(new a()).Lc();
        }
    }
}

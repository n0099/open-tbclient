package com.baidu.poly.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.poly.a;
import com.baidu.poly.a.h.d;
import com.baidu.poly.widget.m;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.heytap.mcssdk.mode.CommandMessage;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PolyActivity extends Activity implements m.l {
    private static com.baidu.poly.d.a.c cpf;
    private static a.b cpg;
    private static PolyActivity cph;
    private static boolean o;
    private m cpi;
    private Bundle cpj;

    private static void Y() {
        if (cph != null) {
            if (cpg != null) {
                String a2 = com.baidu.poly.util.b.a(2, null, "repeat_pay_cancel");
                cpg.onResult(2, a2);
                d.b(2, a2);
            }
            cph.finish();
        }
    }

    private void Z() {
        this.cpj = getIntent().getBundleExtra("pay_arguements");
    }

    public static void a(Context context, com.baidu.poly.d.a.c cVar, a.b bVar, Bundle bundle) {
        if (o) {
            Y();
        }
        cpf = cVar;
        cpg = bVar;
        Intent intent = new Intent(context, PolyActivity.class);
        intent.putExtra("pay_arguements", bundle);
        if (!(context instanceof Activity)) {
            com.baidu.poly.util.d.info("!context instanceof Activity");
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private String adI() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Bundle c(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        d.cof = bundle.getString("bduss");
        d.cog = bundle.getString("tpOrderId");
        d.coi = bundle.getString("nativeAppId");
        bundle.putString(CashierData.DEVICE_TYPE, "ANDROID");
        bundle.putString("channel", "cashiersdk");
        bundle.putString(CommandMessage.SDK_VERSION, "2.7.5");
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
        this.cpi = null;
        cpf = null;
        this.cpj = null;
        cpg = null;
        o = false;
        cph = null;
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
                com.baidu.poly.a.j.a.adB().a((Context) this, intent.getExtras(), this.cpi, true);
                return;
            }
            m mVar = this.cpi;
            if (mVar != null) {
                mVar.a(3, "pay canceled , back from H5. ");
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        m mVar = this.cpi;
        if (mVar == null) {
            super.onBackPressed();
            return;
        }
        if (!mVar.onBackPressed()) {
            super.onBackPressed();
        }
        com.baidu.poly.util.d.info("PolyActivity onBackPressed");
    }

    @Override // com.baidu.poly.widget.m.l
    public void onClose() {
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        o = true;
        cph = this;
        d.H();
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        Z();
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
        if (z && this.cpi == null && !isFinishing() && this.cpj != null) {
            this.cpi = new m(this);
            setContentView(this.cpi);
            this.cpi.setResultListener(cpg);
            this.cpi.setCloseListener(this);
            this.cpi.setWalletList(new com.baidu.poly.a.j.c(new com.baidu.poly.a.j.b(this, cpf)));
            String string = this.cpj.getString("chosenChannel");
            if (TextUtils.equals(this.cpj.getString("panelType"), "NONE") && !TextUtils.isEmpty(string)) {
                this.cpi.c(c(this.cpj), string);
                return;
            }
            this.cpi.a(c(this.cpj));
            this.cpi.adS();
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
                    jSONObject.put("app", HttpConstants.OS_TYPE_VALUE);
                    jSONObject.put("ver", adI());
                    bundle.putString("deviceInfo", jSONObject.toString());
                }
            } catch (Exception e) {
            }
        }
    }
}

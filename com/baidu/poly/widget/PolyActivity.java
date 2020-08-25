package com.baidu.poly.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.poly.a;
import com.baidu.poly.a.h.d;
import com.baidu.poly.widget.m;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import com.heytap.mcssdk.mode.CommandMessage;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class PolyActivity extends Activity implements m.l {
    private static com.baidu.poly.d.a.c bGN;
    private static a.b bGO;
    private static PolyActivity bGP;
    private static boolean o;
    private m bGQ;
    private Bundle bGR;

    private void Ut() {
        this.bGR = getIntent().getBundleExtra("pay_arguements");
    }

    private String Uu() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void Y() {
        if (bGP != null) {
            if (bGO != null) {
                String a = com.baidu.poly.util.b.a(2, null, "repeat_pay_cancel");
                bGO.onResult(2, a);
                d.b(2, a);
            }
            bGP.finish();
        }
    }

    public static void a(Context context, com.baidu.poly.d.a.c cVar, a.b bVar, Bundle bundle) {
        if (o) {
            Y();
        }
        bGN = cVar;
        bGO = bVar;
        Intent intent = new Intent(context, PolyActivity.class);
        intent.putExtra("pay_arguements", bundle);
        if (!(context instanceof Activity)) {
            com.baidu.poly.util.d.info("!context instanceof Activity");
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private Bundle c(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        d.nd = bundle.getString("bduss");
        d.bFO = bundle.getString("tpOrderId");
        d.bFR = bundle.getString("nativeAppId");
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
        this.bGQ = null;
        bGN = null;
        this.bGR = null;
        bGO = null;
        o = false;
        bGP = null;
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
                com.baidu.poly.a.j.a.Um().a((Context) this, intent.getExtras(), this.bGQ, true);
                return;
            }
            m mVar = this.bGQ;
            if (mVar != null) {
                mVar.a(3, "pay canceled , back from H5. ");
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        m mVar = this.bGQ;
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
        bGP = this;
        d.H();
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        Ut();
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
        if (z && this.bGQ == null && !isFinishing() && this.bGR != null) {
            this.bGQ = new m(this);
            setContentView(this.bGQ);
            this.bGQ.setResultListener(bGO);
            this.bGQ.setCloseListener(this);
            this.bGQ.setWalletList(new com.baidu.poly.a.j.c(new com.baidu.poly.a.j.b(this, bGN)));
            String string = this.bGR.getString("chosenChannel");
            if (TextUtils.equals(this.bGR.getString("panelType"), "NONE") && !TextUtils.isEmpty(string)) {
                this.bGQ.c(c(this.bGR), string);
                return;
            }
            this.bGQ.a(c(this.bGR));
            this.bGQ.UE();
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
                    jSONObject.put(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, string);
                    jSONObject.put("mac", com.baidu.poly.util.a.getMacAddress());
                    jSONObject.put("app", "android");
                    jSONObject.put("ver", Uu());
                    bundle.putString("deviceInfo", jSONObject.toString());
                }
            } catch (Exception e) {
            }
        }
    }
}

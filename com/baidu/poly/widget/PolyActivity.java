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
/* loaded from: classes19.dex */
public class PolyActivity extends Activity implements m.l {
    private static com.baidu.poly.d.a.c ciB;
    private static a.b ciC;
    private static PolyActivity ciD;
    private static boolean o;
    private m ciE;
    private Bundle ciF;

    private static void Y() {
        if (ciD != null) {
            if (ciC != null) {
                String a2 = com.baidu.poly.util.b.a(2, null, "repeat_pay_cancel");
                ciC.onResult(2, a2);
                d.b(2, a2);
            }
            ciD.finish();
        }
    }

    public static void a(Context context, com.baidu.poly.d.a.c cVar, a.b bVar, Bundle bundle) {
        if (o) {
            Y();
        }
        ciB = cVar;
        ciC = bVar;
        Intent intent = new Intent(context, PolyActivity.class);
        intent.putExtra("pay_arguements", bundle);
        if (!(context instanceof Activity)) {
            com.baidu.poly.util.d.info("!context instanceof Activity");
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private void adR() {
        this.ciF = getIntent().getBundleExtra("pay_arguements");
    }

    private String adS() {
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
        d.chB = bundle.getString("bduss");
        d.chC = bundle.getString("tpOrderId");
        d.chE = bundle.getString("nativeAppId");
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
        this.ciE = null;
        ciB = null;
        this.ciF = null;
        ciC = null;
        o = false;
        ciD = null;
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
                com.baidu.poly.a.j.a.adK().a((Context) this, intent.getExtras(), this.ciE, true);
                return;
            }
            m mVar = this.ciE;
            if (mVar != null) {
                mVar.a(3, "pay canceled , back from H5. ");
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        m mVar = this.ciE;
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
        ciD = this;
        d.H();
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        adR();
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
        if (z && this.ciE == null && !isFinishing() && this.ciF != null) {
            this.ciE = new m(this);
            setContentView(this.ciE);
            this.ciE.setResultListener(ciC);
            this.ciE.setCloseListener(this);
            this.ciE.setWalletList(new com.baidu.poly.a.j.c(new com.baidu.poly.a.j.b(this, ciB)));
            String string = this.ciF.getString("chosenChannel");
            if (TextUtils.equals(this.ciF.getString("panelType"), "NONE") && !TextUtils.isEmpty(string)) {
                this.ciE.c(c(this.ciF), string);
                return;
            }
            this.ciE.a(c(this.ciF));
            this.ciE.aec();
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
                    jSONObject.put("ver", adS());
                    bundle.putString("deviceInfo", jSONObject.toString());
                }
            } catch (Exception e) {
            }
        }
    }
}

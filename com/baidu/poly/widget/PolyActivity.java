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
/* loaded from: classes3.dex */
public class PolyActivity extends Activity implements m.l {
    private static com.baidu.poly.d.a.c ckO;
    private static a.b ckP;
    private static PolyActivity ckQ;
    private static boolean o;
    private m ckR;
    private Bundle ckS;

    private static void Y() {
        if (ckQ != null) {
            if (ckP != null) {
                String a2 = com.baidu.poly.util.b.a(2, null, "repeat_pay_cancel");
                ckP.onResult(2, a2);
                d.b(2, a2);
            }
            ckQ.finish();
        }
    }

    private void Z() {
        this.ckS = getIntent().getBundleExtra("pay_arguements");
    }

    public static void a(Context context, com.baidu.poly.d.a.c cVar, a.b bVar, Bundle bundle) {
        if (o) {
            Y();
        }
        ckO = cVar;
        ckP = bVar;
        Intent intent = new Intent(context, PolyActivity.class);
        intent.putExtra("pay_arguements", bundle);
        if (!(context instanceof Activity)) {
            com.baidu.poly.util.d.info("!context instanceof Activity");
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private String abU() {
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
        d.cjP = bundle.getString("bduss");
        d.cjQ = bundle.getString("tpOrderId");
        d.cjS = bundle.getString("nativeAppId");
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
        this.ckR = null;
        ckO = null;
        this.ckS = null;
        ckP = null;
        o = false;
        ckQ = null;
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
                com.baidu.poly.a.j.a.abN().a((Context) this, intent.getExtras(), this.ckR, true);
                return;
            }
            m mVar = this.ckR;
            if (mVar != null) {
                mVar.a(3, "pay canceled , back from H5. ");
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        m mVar = this.ckR;
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
        ckQ = this;
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
        if (z && this.ckR == null && !isFinishing() && this.ckS != null) {
            this.ckR = new m(this);
            setContentView(this.ckR);
            this.ckR.setResultListener(ckP);
            this.ckR.setCloseListener(this);
            this.ckR.setWalletList(new com.baidu.poly.a.j.c(new com.baidu.poly.a.j.b(this, ckO)));
            String string = this.ckS.getString("chosenChannel");
            if (TextUtils.equals(this.ckS.getString("panelType"), "NONE") && !TextUtils.isEmpty(string)) {
                this.ckR.c(c(this.ckS), string);
                return;
            }
            this.ckR.a(c(this.ckS));
            this.ckR.ace();
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
                    jSONObject.put("ver", abU());
                    bundle.putString("deviceInfo", jSONObject.toString());
                }
            } catch (Exception e) {
            }
        }
    }
}

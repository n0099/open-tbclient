package com.baidu.swan.bdprivate.address;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.bdprivate.activity.BaseActivity;
import com.baidu.swan.bdprivate.address.a.b;
import com.baidu.swan.bdprivate.address.b.a;
import com.baidu.swan.bdprivate.address.b.c;
import com.baidu.swan.bdprivate.address.view.EditAddressView;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.widget.SwanAppBdActionBar;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class DeliveryEditActivity extends BaseActivity implements b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.bdprivate.address.c.b bWV;
    private EditAddressView bWW;
    private g bWX;
    private com.baidu.swan.bdprivate.widget.b bWY;
    private boolean bWZ;
    private String bXa;
    private SwanAppBdActionBar bXb;
    private String mType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        dY(true);
        super.onCreate(bundle);
        C(getIntent());
        init();
    }

    private void init() {
        this.bWW = new EditAddressView(this, this.bWV);
        setContentView(this.bWW);
        af.U(this);
        this.bWY = new com.baidu.swan.bdprivate.widget.b(this);
        this.bWY.setMessage("加载中...");
        this.bWY.setCancelable(true);
        afj();
        this.bWW.setDeliveryEditChangedListener(this);
        if (!c.afB().afC()) {
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    c.afB().initData();
                }
            }, "initRegionData");
        }
    }

    @Override // com.baidu.swan.bdprivate.address.a.b.a
    public void dZ(boolean z) {
        if (z == this.bWZ) {
            eb(!z);
        }
    }

    private void afj() {
        this.bXb = this.bWW.getBdActionBar();
        this.bXb.setLeftFirstViewVisibility(false);
        this.bXb.setRightMenuVisibility(false);
        this.bXb.setLeftSecondViewVisibility(0);
        this.bXb.setLeftSecondViewText(getString(b.g.delivery_cancel));
        this.bXb.setLeftSecondViewTextSize(14);
        this.bXb.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeliveryEditActivity.this.afl();
            }
        });
        this.bXb.setRightTxtZone1Visibility(0);
        this.bXb.setRightTxtZone1Text(b.g.delivery_save);
        eb(false);
        if (TextUtils.equals(this.mType, IMTrack.DbBuilder.ACTION_UPDATE)) {
            this.bXb.setTitle(b.g.delivery_title_edit);
        } else if (TextUtils.equals(this.mType, "add")) {
            this.bXb.setTitle(b.g.delivery_title_add);
        }
    }

    private boolean afk() {
        return this.bWW.getEditAdapter().afk();
    }

    public void afl() {
        if (afk()) {
            this.bWX = new g.a(this).kr("退出后已编辑的信息不会保存").e("退出编辑").a("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DeliveryEditActivity.this.ea(false);
                }
            }).b(PayHelper.STATUS_CANCEL_DESC, null).ZC();
        } else {
            ea(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea(boolean z) {
        Intent intent = new Intent();
        intent.putExtra("dataChanged", z);
        setResult(-1, intent);
        finish();
    }

    public void eb(boolean z) {
        if (z) {
            this.bXb.setRightTxtZone1OnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DeliveryEditActivity.this.afm();
                }
            });
        } else {
            this.bXb.setRightTxtZone1OnClickListener(null);
        }
        this.bWZ = z;
        ec(com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState());
    }

    private void ec(boolean z) {
        int parseColor;
        if (z) {
            if (this.bWZ) {
                parseColor = Color.parseColor("#1D3A7F");
            } else {
                parseColor = Color.parseColor("#555555");
            }
        } else if (this.bWZ) {
            parseColor = Color.parseColor("#3C76FF");
        } else {
            parseColor = Color.parseColor("#33666666");
        }
        this.bXb.setRightTxtZone1TextColor(parseColor);
    }

    public void afm() {
        Map<String, Object> deliveryEditData = this.bWW.getDeliveryEditData();
        if (q(deliveryEditData)) {
            final com.baidu.swan.bdprivate.address.c.b t = com.baidu.swan.bdprivate.address.c.b.t(deliveryEditData);
            if (!TextUtils.isEmpty(this.bWV.id)) {
                t.id = this.bWV.id;
            }
            if (t != null) {
                a.C0304a c0304a = new a.C0304a() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.5
                    @Override // com.baidu.swan.bdprivate.address.b.a.C0304a, com.baidu.swan.bdprivate.address.b.b
                    public void K(String str, int i) {
                        try {
                            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                            if (optJSONObject != null) {
                                String optString = optJSONObject.optString("id");
                                if (!TextUtils.isEmpty(optString)) {
                                    t.id = optString;
                                }
                            }
                            DeliveryEditActivity.this.a(t, "add");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override // com.baidu.swan.bdprivate.address.b.a.C0304a, com.baidu.swan.bdprivate.address.b.b
                    public void L(String str, int i) {
                        DeliveryEditActivity.this.a(t, IMTrack.DbBuilder.ACTION_UPDATE);
                    }

                    @Override // com.baidu.swan.bdprivate.address.b.a.C0304a, com.baidu.swan.bdprivate.address.b.b
                    public void onFailure() {
                        DeliveryEditActivity.this.afn();
                        d.a(AppRuntime.getAppContext(), "保存失败").showToast();
                    }

                    @Override // com.baidu.swan.bdprivate.address.b.a.C0304a, com.baidu.swan.bdprivate.address.b.b
                    public void onFailure(String str) {
                        DeliveryEditActivity.this.afn();
                        d.a(AppRuntime.getAppContext(), str).showToast();
                    }
                };
                showLoading();
                if (!TextUtils.isEmpty(t.id)) {
                    com.baidu.swan.bdprivate.address.b.a.afw().c(t, c0304a);
                } else {
                    com.baidu.swan.bdprivate.address.b.a.afw().a(t, c0304a);
                }
            }
        }
    }

    private void showLoading() {
        this.bWY.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afn() {
        this.bWY.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.swan.bdprivate.address.c.b bVar, String str) {
        boolean z;
        bVar.afJ();
        List<com.baidu.swan.bdprivate.address.c.b> afz = com.baidu.swan.bdprivate.address.b.a.afw().afz();
        if (TextUtils.equals(str, "add")) {
            if (afz.size() == 0) {
                bVar.bYa = true;
            }
            afz.add(0, bVar);
            z = true;
        } else {
            z = false;
        }
        if (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE)) {
            int i = 0;
            while (true) {
                if (i >= afz.size()) {
                    break;
                }
                com.baidu.swan.bdprivate.address.c.b bVar2 = afz.get(i);
                if (!TextUtils.equals(bVar2.id, bVar.id)) {
                    i++;
                } else {
                    bVar2.f(bVar);
                    afz.add(0, afz.remove(i));
                    z = true;
                    break;
                }
            }
        }
        afn();
        ea(z);
        return z;
    }

    private boolean q(Map<String, Object> map) {
        if (map.containsKey("phone") && !com.baidu.swan.bdprivate.address.c.b.mM(String.valueOf(map.get("phone")))) {
            d.a(this, "电话号码格式不正确").showToast();
            return false;
        } else if (map.containsKey("zipcode") && !com.baidu.swan.bdprivate.address.c.b.mN(String.valueOf(map.get("zipcode")))) {
            d.a(this, "邮编格式不正确").showToast();
            return false;
        } else {
            return true;
        }
    }

    private void C(Intent intent) {
        if (intent != null) {
            this.bXa = intent.getStringExtra("openSource");
            Bundle bundleExtra = intent.getBundleExtra("data");
            if (bundleExtra != null) {
                String string = bundleExtra.getString("addrInfo");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.bWV = com.baidu.swan.bdprivate.address.c.b.bc(new JSONObject(string));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                this.mType = bundleExtra.getString("type");
            }
        }
    }
}

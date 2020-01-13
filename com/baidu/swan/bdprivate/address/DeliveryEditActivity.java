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
/* loaded from: classes10.dex */
public class DeliveryEditActivity extends BaseActivity implements b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.bdprivate.address.c.b bXh;
    private EditAddressView bXi;
    private g bXj;
    private com.baidu.swan.bdprivate.widget.b bXk;
    private boolean bXl;
    private String bXm;
    private SwanAppBdActionBar bXn;
    private String mType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ed(true);
        super.onCreate(bundle);
        C(getIntent());
        init();
    }

    private void init() {
        this.bXi = new EditAddressView(this, this.bXh);
        setContentView(this.bXi);
        af.V(this);
        this.bXk = new com.baidu.swan.bdprivate.widget.b(this);
        this.bXk.setMessage("加载中...");
        this.bXk.setCancelable(true);
        afC();
        this.bXi.setDeliveryEditChangedListener(this);
        if (!c.afU().afV()) {
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    c.afU().initData();
                }
            }, "initRegionData");
        }
    }

    @Override // com.baidu.swan.bdprivate.address.a.b.a
    public void ee(boolean z) {
        if (z == this.bXl) {
            eg(!z);
        }
    }

    private void afC() {
        this.bXn = this.bXi.getBdActionBar();
        this.bXn.setLeftFirstViewVisibility(false);
        this.bXn.setRightMenuVisibility(false);
        this.bXn.setLeftSecondViewVisibility(0);
        this.bXn.setLeftSecondViewText(getString(b.g.delivery_cancel));
        this.bXn.setLeftSecondViewTextSize(14);
        this.bXn.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeliveryEditActivity.this.afE();
            }
        });
        this.bXn.setRightTxtZone1Visibility(0);
        this.bXn.setRightTxtZone1Text(b.g.delivery_save);
        eg(false);
        if (TextUtils.equals(this.mType, IMTrack.DbBuilder.ACTION_UPDATE)) {
            this.bXn.setTitle(b.g.delivery_title_edit);
        } else if (TextUtils.equals(this.mType, "add")) {
            this.bXn.setTitle(b.g.delivery_title_add);
        }
    }

    private boolean afD() {
        return this.bXi.getEditAdapter().afD();
    }

    public void afE() {
        if (afD()) {
            this.bXj = new g.a(this).ku("退出后已编辑的信息不会保存").e("退出编辑").a("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DeliveryEditActivity.this.ef(false);
                }
            }).b(PayHelper.STATUS_CANCEL_DESC, null).ZZ();
        } else {
            ef(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ef(boolean z) {
        Intent intent = new Intent();
        intent.putExtra("dataChanged", z);
        setResult(-1, intent);
        finish();
    }

    public void eg(boolean z) {
        if (z) {
            this.bXn.setRightTxtZone1OnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DeliveryEditActivity.this.afF();
                }
            });
        } else {
            this.bXn.setRightTxtZone1OnClickListener(null);
        }
        this.bXl = z;
        eh(com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState());
    }

    private void eh(boolean z) {
        int parseColor;
        if (z) {
            if (this.bXl) {
                parseColor = Color.parseColor("#1D3A7F");
            } else {
                parseColor = Color.parseColor("#555555");
            }
        } else if (this.bXl) {
            parseColor = Color.parseColor("#3C76FF");
        } else {
            parseColor = Color.parseColor("#33666666");
        }
        this.bXn.setRightTxtZone1TextColor(parseColor);
    }

    public void afF() {
        Map<String, Object> deliveryEditData = this.bXi.getDeliveryEditData();
        if (q(deliveryEditData)) {
            final com.baidu.swan.bdprivate.address.c.b t = com.baidu.swan.bdprivate.address.c.b.t(deliveryEditData);
            if (!TextUtils.isEmpty(this.bXh.id)) {
                t.id = this.bXh.id;
            }
            if (t != null) {
                a.C0306a c0306a = new a.C0306a() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.5
                    @Override // com.baidu.swan.bdprivate.address.b.a.C0306a, com.baidu.swan.bdprivate.address.b.b
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

                    @Override // com.baidu.swan.bdprivate.address.b.a.C0306a, com.baidu.swan.bdprivate.address.b.b
                    public void L(String str, int i) {
                        DeliveryEditActivity.this.a(t, IMTrack.DbBuilder.ACTION_UPDATE);
                    }

                    @Override // com.baidu.swan.bdprivate.address.b.a.C0306a, com.baidu.swan.bdprivate.address.b.b
                    public void onFailure() {
                        DeliveryEditActivity.this.afG();
                        d.a(AppRuntime.getAppContext(), "保存失败").showToast();
                    }

                    @Override // com.baidu.swan.bdprivate.address.b.a.C0306a, com.baidu.swan.bdprivate.address.b.b
                    public void onFailure(String str) {
                        DeliveryEditActivity.this.afG();
                        d.a(AppRuntime.getAppContext(), str).showToast();
                    }
                };
                showLoading();
                if (!TextUtils.isEmpty(t.id)) {
                    com.baidu.swan.bdprivate.address.b.a.afP().c(t, c0306a);
                } else {
                    com.baidu.swan.bdprivate.address.b.a.afP().a(t, c0306a);
                }
            }
        }
    }

    private void showLoading() {
        this.bXk.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afG() {
        this.bXk.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.swan.bdprivate.address.c.b bVar, String str) {
        boolean z;
        bVar.agc();
        List<com.baidu.swan.bdprivate.address.c.b> afS = com.baidu.swan.bdprivate.address.b.a.afP().afS();
        if (TextUtils.equals(str, "add")) {
            if (afS.size() == 0) {
                bVar.bYm = true;
            }
            afS.add(0, bVar);
            z = true;
        } else {
            z = false;
        }
        if (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE)) {
            int i = 0;
            while (true) {
                if (i >= afS.size()) {
                    break;
                }
                com.baidu.swan.bdprivate.address.c.b bVar2 = afS.get(i);
                if (!TextUtils.equals(bVar2.id, bVar.id)) {
                    i++;
                } else {
                    bVar2.f(bVar);
                    afS.add(0, afS.remove(i));
                    z = true;
                    break;
                }
            }
        }
        afG();
        ef(z);
        return z;
    }

    private boolean q(Map<String, Object> map) {
        if (map.containsKey("phone") && !com.baidu.swan.bdprivate.address.c.b.mP(String.valueOf(map.get("phone")))) {
            d.a(this, "电话号码格式不正确").showToast();
            return false;
        } else if (map.containsKey("zipcode") && !com.baidu.swan.bdprivate.address.c.b.mQ(String.valueOf(map.get("zipcode")))) {
            d.a(this, "邮编格式不正确").showToast();
            return false;
        } else {
            return true;
        }
    }

    private void C(Intent intent) {
        if (intent != null) {
            this.bXm = intent.getStringExtra("openSource");
            Bundle bundleExtra = intent.getBundleExtra("data");
            if (bundleExtra != null) {
                String string = bundleExtra.getString("addrInfo");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.bXh = com.baidu.swan.bdprivate.address.c.b.bc(new JSONObject(string));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                this.mType = bundleExtra.getString("type");
            }
        }
    }
}

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
/* loaded from: classes11.dex */
public class DeliveryEditActivity extends BaseActivity implements b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.bdprivate.address.c.b cbk;
    private EditAddressView cbl;
    private g cbm;
    private com.baidu.swan.bdprivate.widget.b cbn;
    private boolean cbo;
    private String cbp;
    private SwanAppBdActionBar cbq;
    private String mType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ek(true);
        super.onCreate(bundle);
        C(getIntent());
        init();
    }

    private void init() {
        this.cbl = new EditAddressView(this, this.cbk);
        setContentView(this.cbl);
        af.W(this);
        this.cbn = new com.baidu.swan.bdprivate.widget.b(this);
        this.cbn.setMessage("加载中...");
        this.cbn.setCancelable(true);
        ahQ();
        this.cbl.setDeliveryEditChangedListener(this);
        if (!c.aii().aij()) {
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    c.aii().initData();
                }
            }, "initRegionData");
        }
    }

    @Override // com.baidu.swan.bdprivate.address.a.b.a
    public void el(boolean z) {
        if (z == this.cbo) {
            en(!z);
        }
    }

    private void ahQ() {
        this.cbq = this.cbl.getBdActionBar();
        this.cbq.setLeftFirstViewVisibility(false);
        this.cbq.setRightMenuVisibility(false);
        this.cbq.setLeftSecondViewVisibility(0);
        this.cbq.setLeftSecondViewText(getString(b.g.delivery_cancel));
        this.cbq.setLeftSecondViewTextSize(14);
        this.cbq.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeliveryEditActivity.this.ahS();
            }
        });
        this.cbq.setRightTxtZone1Visibility(0);
        this.cbq.setRightTxtZone1Text(b.g.delivery_save);
        en(false);
        if (TextUtils.equals(this.mType, IMTrack.DbBuilder.ACTION_UPDATE)) {
            this.cbq.setTitle(b.g.delivery_title_edit);
        } else if (TextUtils.equals(this.mType, "add")) {
            this.cbq.setTitle(b.g.delivery_title_add);
        }
    }

    private boolean ahR() {
        return this.cbl.getEditAdapter().ahR();
    }

    public void ahS() {
        if (ahR()) {
            this.cbm = new g.a(this).kJ("退出后已编辑的信息不会保存").e("退出编辑").a("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DeliveryEditActivity.this.em(false);
                }
            }).b(PayHelper.STATUS_CANCEL_DESC, null).acn();
        } else {
            em(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void em(boolean z) {
        Intent intent = new Intent();
        intent.putExtra("dataChanged", z);
        setResult(-1, intent);
        finish();
    }

    public void en(boolean z) {
        if (z) {
            this.cbq.setRightTxtZone1OnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DeliveryEditActivity.this.ahT();
                }
            });
        } else {
            this.cbq.setRightTxtZone1OnClickListener(null);
        }
        this.cbo = z;
        eo(com.baidu.swan.apps.w.a.Uq().getNightModeSwitcherState());
    }

    private void eo(boolean z) {
        int parseColor;
        if (z) {
            if (this.cbo) {
                parseColor = Color.parseColor("#1D3A7F");
            } else {
                parseColor = Color.parseColor("#555555");
            }
        } else if (this.cbo) {
            parseColor = Color.parseColor("#3C76FF");
        } else {
            parseColor = Color.parseColor("#33666666");
        }
        this.cbq.setRightTxtZone1TextColor(parseColor);
    }

    public void ahT() {
        Map<String, Object> deliveryEditData = this.cbl.getDeliveryEditData();
        if (q(deliveryEditData)) {
            final com.baidu.swan.bdprivate.address.c.b t = com.baidu.swan.bdprivate.address.c.b.t(deliveryEditData);
            if (!TextUtils.isEmpty(this.cbk.id)) {
                t.id = this.cbk.id;
            }
            if (t != null) {
                a.C0316a c0316a = new a.C0316a() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.5
                    @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
                    public void I(String str, int i) {
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

                    @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
                    public void J(String str, int i) {
                        DeliveryEditActivity.this.a(t, IMTrack.DbBuilder.ACTION_UPDATE);
                    }

                    @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
                    public void onFailure() {
                        DeliveryEditActivity.this.ahU();
                        d.a(AppRuntime.getAppContext(), "保存失败").showToast();
                    }

                    @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
                    public void onFailure(String str) {
                        DeliveryEditActivity.this.ahU();
                        d.a(AppRuntime.getAppContext(), str).showToast();
                    }
                };
                showLoading();
                if (!TextUtils.isEmpty(t.id)) {
                    com.baidu.swan.bdprivate.address.b.a.aid().c(t, c0316a);
                } else {
                    com.baidu.swan.bdprivate.address.b.a.aid().a(t, c0316a);
                }
            }
        }
    }

    private void showLoading() {
        this.cbn.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahU() {
        this.cbn.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.swan.bdprivate.address.c.b bVar, String str) {
        boolean z;
        bVar.aiq();
        List<com.baidu.swan.bdprivate.address.c.b> aig = com.baidu.swan.bdprivate.address.b.a.aid().aig();
        if (TextUtils.equals(str, "add")) {
            if (aig.size() == 0) {
                bVar.ccq = true;
            }
            aig.add(0, bVar);
            z = true;
        } else {
            z = false;
        }
        if (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE)) {
            int i = 0;
            while (true) {
                if (i >= aig.size()) {
                    break;
                }
                com.baidu.swan.bdprivate.address.c.b bVar2 = aig.get(i);
                if (!TextUtils.equals(bVar2.id, bVar.id)) {
                    i++;
                } else {
                    bVar2.f(bVar);
                    aig.add(0, aig.remove(i));
                    z = true;
                    break;
                }
            }
        }
        ahU();
        em(z);
        return z;
    }

    private boolean q(Map<String, Object> map) {
        if (map.containsKey("phone") && !com.baidu.swan.bdprivate.address.c.b.ne(String.valueOf(map.get("phone")))) {
            d.a(this, "电话号码格式不正确").showToast();
            return false;
        } else if (map.containsKey("zipcode") && !com.baidu.swan.bdprivate.address.c.b.nf(String.valueOf(map.get("zipcode")))) {
            d.a(this, "邮编格式不正确").showToast();
            return false;
        } else {
            return true;
        }
    }

    private void C(Intent intent) {
        if (intent != null) {
            this.cbp = intent.getStringExtra("openSource");
            Bundle bundleExtra = intent.getBundleExtra("data");
            if (bundleExtra != null) {
                String string = bundleExtra.getString("addrInfo");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.cbk = com.baidu.swan.bdprivate.address.c.b.bc(new JSONObject(string));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                this.mType = bundleExtra.getString("type");
            }
        }
    }
}

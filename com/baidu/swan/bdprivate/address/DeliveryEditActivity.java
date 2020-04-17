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
    private EditAddressView cAA;
    private g cAB;
    private com.baidu.swan.bdprivate.widget.b cAC;
    private boolean cAD;
    private String cAE;
    private SwanAppBdActionBar cAF;
    private com.baidu.swan.bdprivate.address.c.b cAz;
    private String mType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        fi(true);
        super.onCreate(bundle);
        B(getIntent());
        init();
    }

    private void init() {
        this.cAA = new EditAddressView(this, this.cAz);
        setContentView(this.cAA);
        af.S(this);
        this.cAC = new com.baidu.swan.bdprivate.widget.b(this);
        this.cAC.setMessage("加载中...");
        this.cAC.setCancelable(true);
        aqd();
        this.cAA.setDeliveryEditChangedListener(this);
        if (!c.aqv().aqw()) {
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    c.aqv().initData();
                }
            }, "initRegionData");
        }
    }

    @Override // com.baidu.swan.bdprivate.address.a.b.a
    public void fj(boolean z) {
        if (z == this.cAD) {
            fl(!z);
        }
    }

    private void aqd() {
        this.cAF = this.cAA.getBdActionBar();
        this.cAF.setLeftFirstViewVisibility(false);
        this.cAF.setRightMenuVisibility(false);
        this.cAF.setLeftSecondViewVisibility(0);
        this.cAF.setLeftSecondViewText(getString(b.g.delivery_cancel));
        this.cAF.setLeftSecondViewTextSize(14);
        this.cAF.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeliveryEditActivity.this.aqf();
            }
        });
        this.cAF.setRightTxtZone1Visibility(0);
        this.cAF.setRightTxtZone1Text(b.g.delivery_save);
        fl(false);
        if (TextUtils.equals(this.mType, IMTrack.DbBuilder.ACTION_UPDATE)) {
            this.cAF.setTitle(b.g.delivery_title_edit);
        } else if (TextUtils.equals(this.mType, "add")) {
            this.cAF.setTitle(b.g.delivery_title_add);
        }
    }

    private boolean aqe() {
        return this.cAA.getEditAdapter().aqe();
    }

    public void aqf() {
        if (aqe()) {
            this.cAB = new g.a(this).lV("退出后已编辑的信息不会保存").e("退出编辑").a("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DeliveryEditActivity.this.fk(false);
                }
            }).b(PayHelper.STATUS_CANCEL_DESC, null).akx();
        } else {
            fk(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fk(boolean z) {
        Intent intent = new Intent();
        intent.putExtra("dataChanged", z);
        setResult(-1, intent);
        finish();
    }

    public void fl(boolean z) {
        if (z) {
            this.cAF.setRightTxtZone1OnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DeliveryEditActivity.this.aqg();
                }
            });
        } else {
            this.cAF.setRightTxtZone1OnClickListener(null);
        }
        this.cAD = z;
        fm(com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState());
    }

    private void fm(boolean z) {
        int parseColor;
        if (z) {
            if (this.cAD) {
                parseColor = Color.parseColor("#1D3A7F");
            } else {
                parseColor = Color.parseColor("#555555");
            }
        } else if (this.cAD) {
            parseColor = Color.parseColor("#3C76FF");
        } else {
            parseColor = Color.parseColor("#33666666");
        }
        this.cAF.setRightTxtZone1TextColor(parseColor);
    }

    public void aqg() {
        Map<String, Object> deliveryEditData = this.cAA.getDeliveryEditData();
        if (o(deliveryEditData)) {
            final com.baidu.swan.bdprivate.address.c.b r = com.baidu.swan.bdprivate.address.c.b.r(deliveryEditData);
            if (!TextUtils.isEmpty(this.cAz.id)) {
                r.id = this.cAz.id;
            }
            if (r != null) {
                a.C0346a c0346a = new a.C0346a() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.5
                    @Override // com.baidu.swan.bdprivate.address.b.a.C0346a, com.baidu.swan.bdprivate.address.b.b
                    public void Q(String str, int i) {
                        try {
                            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                            if (optJSONObject != null) {
                                String optString = optJSONObject.optString("id");
                                if (!TextUtils.isEmpty(optString)) {
                                    r.id = optString;
                                }
                            }
                            DeliveryEditActivity.this.a(r, "add");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override // com.baidu.swan.bdprivate.address.b.a.C0346a, com.baidu.swan.bdprivate.address.b.b
                    public void R(String str, int i) {
                        DeliveryEditActivity.this.a(r, IMTrack.DbBuilder.ACTION_UPDATE);
                    }

                    @Override // com.baidu.swan.bdprivate.address.b.a.C0346a, com.baidu.swan.bdprivate.address.b.b
                    public void onFailure() {
                        DeliveryEditActivity.this.aqh();
                        d.a(AppRuntime.getAppContext(), "保存失败").showToast();
                    }

                    @Override // com.baidu.swan.bdprivate.address.b.a.C0346a, com.baidu.swan.bdprivate.address.b.b
                    public void onFailure(String str) {
                        DeliveryEditActivity.this.aqh();
                        d.a(AppRuntime.getAppContext(), str).showToast();
                    }
                };
                showLoading();
                if (!TextUtils.isEmpty(r.id)) {
                    com.baidu.swan.bdprivate.address.b.a.aqq().c(r, c0346a);
                } else {
                    com.baidu.swan.bdprivate.address.b.a.aqq().a(r, c0346a);
                }
            }
        }
    }

    private void showLoading() {
        this.cAC.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqh() {
        this.cAC.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.swan.bdprivate.address.c.b bVar, String str) {
        boolean z;
        bVar.aqD();
        List<com.baidu.swan.bdprivate.address.c.b> aqt = com.baidu.swan.bdprivate.address.b.a.aqq().aqt();
        if (TextUtils.equals(str, "add")) {
            if (aqt.size() == 0) {
                bVar.cBE = true;
            }
            aqt.add(0, bVar);
            z = true;
        } else {
            z = false;
        }
        if (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE)) {
            int i = 0;
            while (true) {
                if (i >= aqt.size()) {
                    break;
                }
                com.baidu.swan.bdprivate.address.c.b bVar2 = aqt.get(i);
                if (!TextUtils.equals(bVar2.id, bVar.id)) {
                    i++;
                } else {
                    bVar2.f(bVar);
                    aqt.add(0, aqt.remove(i));
                    z = true;
                    break;
                }
            }
        }
        aqh();
        fk(z);
        return z;
    }

    private boolean o(Map<String, Object> map) {
        if (map.containsKey("phone") && !com.baidu.swan.bdprivate.address.c.b.os(String.valueOf(map.get("phone")))) {
            d.a(this, "电话号码格式不正确").showToast();
            return false;
        } else if (map.containsKey("zipcode") && !com.baidu.swan.bdprivate.address.c.b.ot(String.valueOf(map.get("zipcode")))) {
            d.a(this, "邮编格式不正确").showToast();
            return false;
        } else {
            return true;
        }
    }

    private void B(Intent intent) {
        if (intent != null) {
            this.cAE = intent.getStringExtra("openSource");
            Bundle bundleExtra = intent.getBundleExtra("data");
            if (bundleExtra != null) {
                String string = bundleExtra.getString("addrInfo");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.cAz = com.baidu.swan.bdprivate.address.c.b.bn(new JSONObject(string));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                this.mType = bundleExtra.getString("type");
            }
        }
    }
}

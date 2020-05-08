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
    private com.baidu.swan.bdprivate.address.c.b cAF;
    private EditAddressView cAG;
    private g cAH;
    private com.baidu.swan.bdprivate.widget.b cAI;
    private boolean cAJ;
    private String cAK;
    private SwanAppBdActionBar cAL;
    private String mType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        fi(true);
        super.onCreate(bundle);
        o(getIntent());
        init();
    }

    private void init() {
        this.cAG = new EditAddressView(this, this.cAF);
        setContentView(this.cAG);
        af.S(this);
        this.cAI = new com.baidu.swan.bdprivate.widget.b(this);
        this.cAI.setMessage("加载中...");
        this.cAI.setCancelable(true);
        aqc();
        this.cAG.setDeliveryEditChangedListener(this);
        if (!c.aqu().aqv()) {
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    c.aqu().initData();
                }
            }, "initRegionData");
        }
    }

    @Override // com.baidu.swan.bdprivate.address.a.b.a
    public void fj(boolean z) {
        if (z == this.cAJ) {
            fl(!z);
        }
    }

    private void aqc() {
        this.cAL = this.cAG.getBdActionBar();
        this.cAL.setLeftFirstViewVisibility(false);
        this.cAL.setRightMenuVisibility(false);
        this.cAL.setLeftSecondViewVisibility(0);
        this.cAL.setLeftSecondViewText(getString(b.g.delivery_cancel));
        this.cAL.setLeftSecondViewTextSize(14);
        this.cAL.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeliveryEditActivity.this.aqe();
            }
        });
        this.cAL.setRightTxtZone1Visibility(0);
        this.cAL.setRightTxtZone1Text(b.g.delivery_save);
        fl(false);
        if (TextUtils.equals(this.mType, IMTrack.DbBuilder.ACTION_UPDATE)) {
            this.cAL.setTitle(b.g.delivery_title_edit);
        } else if (TextUtils.equals(this.mType, "add")) {
            this.cAL.setTitle(b.g.delivery_title_add);
        }
    }

    private boolean aqd() {
        return this.cAG.getEditAdapter().aqd();
    }

    public void aqe() {
        if (aqd()) {
            this.cAH = new g.a(this).lV("退出后已编辑的信息不会保存").e("退出编辑").a("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DeliveryEditActivity.this.fk(false);
                }
            }).b(PayHelper.STATUS_CANCEL_DESC, null).akw();
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
            this.cAL.setRightTxtZone1OnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DeliveryEditActivity.this.aqf();
                }
            });
        } else {
            this.cAL.setRightTxtZone1OnClickListener(null);
        }
        this.cAJ = z;
        fm(com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState());
    }

    private void fm(boolean z) {
        int parseColor;
        if (z) {
            if (this.cAJ) {
                parseColor = Color.parseColor("#1D3A7F");
            } else {
                parseColor = Color.parseColor("#555555");
            }
        } else if (this.cAJ) {
            parseColor = Color.parseColor("#3C76FF");
        } else {
            parseColor = Color.parseColor("#33666666");
        }
        this.cAL.setRightTxtZone1TextColor(parseColor);
    }

    public void aqf() {
        Map<String, Object> deliveryEditData = this.cAG.getDeliveryEditData();
        if (o(deliveryEditData)) {
            final com.baidu.swan.bdprivate.address.c.b r = com.baidu.swan.bdprivate.address.c.b.r(deliveryEditData);
            if (!TextUtils.isEmpty(this.cAF.id)) {
                r.id = this.cAF.id;
            }
            if (r != null) {
                a.C0367a c0367a = new a.C0367a() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.5
                    @Override // com.baidu.swan.bdprivate.address.b.a.C0367a, com.baidu.swan.bdprivate.address.b.b
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

                    @Override // com.baidu.swan.bdprivate.address.b.a.C0367a, com.baidu.swan.bdprivate.address.b.b
                    public void R(String str, int i) {
                        DeliveryEditActivity.this.a(r, IMTrack.DbBuilder.ACTION_UPDATE);
                    }

                    @Override // com.baidu.swan.bdprivate.address.b.a.C0367a, com.baidu.swan.bdprivate.address.b.b
                    public void onFailure() {
                        DeliveryEditActivity.this.aqg();
                        d.a(AppRuntime.getAppContext(), "保存失败").showToast();
                    }

                    @Override // com.baidu.swan.bdprivate.address.b.a.C0367a, com.baidu.swan.bdprivate.address.b.b
                    public void onFailure(String str) {
                        DeliveryEditActivity.this.aqg();
                        d.a(AppRuntime.getAppContext(), str).showToast();
                    }
                };
                showLoading();
                if (!TextUtils.isEmpty(r.id)) {
                    com.baidu.swan.bdprivate.address.b.a.aqp().c(r, c0367a);
                } else {
                    com.baidu.swan.bdprivate.address.b.a.aqp().a(r, c0367a);
                }
            }
        }
    }

    private void showLoading() {
        this.cAI.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqg() {
        this.cAI.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.swan.bdprivate.address.c.b bVar, String str) {
        boolean z;
        bVar.aqC();
        List<com.baidu.swan.bdprivate.address.c.b> aqs = com.baidu.swan.bdprivate.address.b.a.aqp().aqs();
        if (TextUtils.equals(str, "add")) {
            if (aqs.size() == 0) {
                bVar.cBK = true;
            }
            aqs.add(0, bVar);
            z = true;
        } else {
            z = false;
        }
        if (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE)) {
            int i = 0;
            while (true) {
                if (i >= aqs.size()) {
                    break;
                }
                com.baidu.swan.bdprivate.address.c.b bVar2 = aqs.get(i);
                if (!TextUtils.equals(bVar2.id, bVar.id)) {
                    i++;
                } else {
                    bVar2.f(bVar);
                    aqs.add(0, aqs.remove(i));
                    z = true;
                    break;
                }
            }
        }
        aqg();
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

    private void o(Intent intent) {
        if (intent != null) {
            this.cAK = intent.getStringExtra("openSource");
            Bundle bundleExtra = intent.getBundleExtra("data");
            if (bundleExtra != null) {
                String string = bundleExtra.getString("addrInfo");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.cAF = com.baidu.swan.bdprivate.address.c.b.bn(new JSONObject(string));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                this.mType = bundleExtra.getString("type");
            }
        }
    }
}

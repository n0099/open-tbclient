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
    private g cbA;
    private com.baidu.swan.bdprivate.widget.b cbB;
    private boolean cbC;
    private String cbD;
    private SwanAppBdActionBar cbE;
    private com.baidu.swan.bdprivate.address.c.b cby;
    private EditAddressView cbz;
    private String mType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        el(true);
        super.onCreate(bundle);
        C(getIntent());
        init();
    }

    private void init() {
        this.cbz = new EditAddressView(this, this.cby);
        setContentView(this.cbz);
        af.W(this);
        this.cbB = new com.baidu.swan.bdprivate.widget.b(this);
        this.cbB.setMessage("加载中...");
        this.cbB.setCancelable(true);
        ahV();
        this.cbz.setDeliveryEditChangedListener(this);
        if (!c.ain().aio()) {
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    c.ain().initData();
                }
            }, "initRegionData");
        }
    }

    @Override // com.baidu.swan.bdprivate.address.a.b.a
    public void em(boolean z) {
        if (z == this.cbC) {
            eo(!z);
        }
    }

    private void ahV() {
        this.cbE = this.cbz.getBdActionBar();
        this.cbE.setLeftFirstViewVisibility(false);
        this.cbE.setRightMenuVisibility(false);
        this.cbE.setLeftSecondViewVisibility(0);
        this.cbE.setLeftSecondViewText(getString(b.g.delivery_cancel));
        this.cbE.setLeftSecondViewTextSize(14);
        this.cbE.setLeftSecondViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeliveryEditActivity.this.ahX();
            }
        });
        this.cbE.setRightTxtZone1Visibility(0);
        this.cbE.setRightTxtZone1Text(b.g.delivery_save);
        eo(false);
        if (TextUtils.equals(this.mType, IMTrack.DbBuilder.ACTION_UPDATE)) {
            this.cbE.setTitle(b.g.delivery_title_edit);
        } else if (TextUtils.equals(this.mType, "add")) {
            this.cbE.setTitle(b.g.delivery_title_add);
        }
    }

    private boolean ahW() {
        return this.cbz.getEditAdapter().ahW();
    }

    public void ahX() {
        if (ahW()) {
            this.cbA = new g.a(this).kI("退出后已编辑的信息不会保存").e("退出编辑").a("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DeliveryEditActivity.this.en(false);
                }
            }).b(PayHelper.STATUS_CANCEL_DESC, null).acs();
        } else {
            en(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void en(boolean z) {
        Intent intent = new Intent();
        intent.putExtra("dataChanged", z);
        setResult(-1, intent);
        finish();
    }

    public void eo(boolean z) {
        if (z) {
            this.cbE.setRightTxtZone1OnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryEditActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DeliveryEditActivity.this.ahY();
                }
            });
        } else {
            this.cbE.setRightTxtZone1OnClickListener(null);
        }
        this.cbC = z;
        ep(com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState());
    }

    private void ep(boolean z) {
        int parseColor;
        if (z) {
            if (this.cbC) {
                parseColor = Color.parseColor("#1D3A7F");
            } else {
                parseColor = Color.parseColor("#555555");
            }
        } else if (this.cbC) {
            parseColor = Color.parseColor("#3C76FF");
        } else {
            parseColor = Color.parseColor("#33666666");
        }
        this.cbE.setRightTxtZone1TextColor(parseColor);
    }

    public void ahY() {
        Map<String, Object> deliveryEditData = this.cbz.getDeliveryEditData();
        if (q(deliveryEditData)) {
            final com.baidu.swan.bdprivate.address.c.b t = com.baidu.swan.bdprivate.address.c.b.t(deliveryEditData);
            if (!TextUtils.isEmpty(this.cby.id)) {
                t.id = this.cby.id;
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
                        DeliveryEditActivity.this.ahZ();
                        d.a(AppRuntime.getAppContext(), "保存失败").showToast();
                    }

                    @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
                    public void onFailure(String str) {
                        DeliveryEditActivity.this.ahZ();
                        d.a(AppRuntime.getAppContext(), str).showToast();
                    }
                };
                showLoading();
                if (!TextUtils.isEmpty(t.id)) {
                    com.baidu.swan.bdprivate.address.b.a.aii().c(t, c0316a);
                } else {
                    com.baidu.swan.bdprivate.address.b.a.aii().a(t, c0316a);
                }
            }
        }
    }

    private void showLoading() {
        this.cbB.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahZ() {
        this.cbB.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.swan.bdprivate.address.c.b bVar, String str) {
        boolean z;
        bVar.aiv();
        List<com.baidu.swan.bdprivate.address.c.b> ail = com.baidu.swan.bdprivate.address.b.a.aii().ail();
        if (TextUtils.equals(str, "add")) {
            if (ail.size() == 0) {
                bVar.ccE = true;
            }
            ail.add(0, bVar);
            z = true;
        } else {
            z = false;
        }
        if (TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE)) {
            int i = 0;
            while (true) {
                if (i >= ail.size()) {
                    break;
                }
                com.baidu.swan.bdprivate.address.c.b bVar2 = ail.get(i);
                if (!TextUtils.equals(bVar2.id, bVar.id)) {
                    i++;
                } else {
                    bVar2.f(bVar);
                    ail.add(0, ail.remove(i));
                    z = true;
                    break;
                }
            }
        }
        ahZ();
        en(z);
        return z;
    }

    private boolean q(Map<String, Object> map) {
        if (map.containsKey("phone") && !com.baidu.swan.bdprivate.address.c.b.nd(String.valueOf(map.get("phone")))) {
            d.a(this, "电话号码格式不正确").showToast();
            return false;
        } else if (map.containsKey("zipcode") && !com.baidu.swan.bdprivate.address.c.b.ne(String.valueOf(map.get("zipcode")))) {
            d.a(this, "邮编格式不正确").showToast();
            return false;
        } else {
            return true;
        }
    }

    private void C(Intent intent) {
        if (intent != null) {
            this.cbD = intent.getStringExtra("openSource");
            Bundle bundleExtra = intent.getBundleExtra("data");
            if (bundleExtra != null) {
                String string = bundleExtra.getString("addrInfo");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.cby = com.baidu.swan.bdprivate.address.c.b.bc(new JSONObject(string));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                this.mType = bundleExtra.getString("type");
            }
        }
    }
}

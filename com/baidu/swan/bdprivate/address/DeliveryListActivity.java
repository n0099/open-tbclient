package com.baidu.swan.bdprivate.address;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.res.widget.a.b;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.bdprivate.activity.BaseActivity;
import com.baidu.swan.bdprivate.address.a.a;
import com.baidu.swan.bdprivate.address.b.a;
import com.baidu.swan.bdprivate.address.view.ChooseAddressView;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.widget.SwanAppBdActionBar;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class DeliveryListActivity extends BaseActivity implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Bundle cbA;
    private boolean cbB;
    private com.baidu.swan.bdprivate.widget.b cbp;
    private String cbr;
    private ChooseAddressView cbw;
    private List<com.baidu.swan.bdprivate.address.c.b> cbx = new ArrayList();
    private com.baidu.swan.bdprivate.widget.a cby;
    private Handler cbz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C(getIntent());
        ahX();
    }

    private void ahX() {
        if (!com.baidu.swan.bdprivate.a.a.isLogin(this)) {
            com.baidu.swan.bdprivate.a.a.a((Activity) this, false, (Bundle) null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.1
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (com.baidu.swan.bdprivate.a.a.isLogin(DeliveryListActivity.this)) {
                        DeliveryListActivity.this.init();
                    } else {
                        DeliveryListActivity.this.finish();
                    }
                }
            });
        } else {
            init();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        this.cbw = new ChooseAddressView(this);
        setContentView(this.cbw);
        af.W(this);
        this.cbp = new com.baidu.swan.bdprivate.widget.b(this);
        this.cbp.setMessage("加载中...");
        this.cbp.setCancelable(true);
        ahS();
        this.cbw.setDeliveryChooseListener(this);
        this.cbz = new Handler() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        DeliveryListActivity.this.cbw.ag(DeliveryListActivity.this.cbx);
                        DeliveryListActivity.this.ahZ();
                        return;
                    default:
                        return;
                }
            }
        };
        com.baidu.swan.bdprivate.address.b.a.aif().R(this.cbA);
        ahY();
    }

    private void ahS() {
        SwanAppBdActionBar bdActionBar = this.cbw.getBdActionBar();
        bdActionBar.setRightMenuVisibility(false);
        bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeliveryListActivity.this.finish();
            }
        });
        if (TextUtils.equals(this.cbr, "aiapp")) {
            bdActionBar.setTitle(b.g.delivery_title_choose);
        } else {
            bdActionBar.setTitle(b.g.delivery_title_list);
        }
        bdActionBar.setLeftFirstViewVisibility(true);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.cbB) {
            this.cbx = com.baidu.swan.bdprivate.address.b.a.aif().aii();
            this.cbw.ag(this.cbx);
        }
    }

    private void ahY() {
        List<com.baidu.swan.bdprivate.address.c.b> aii = com.baidu.swan.bdprivate.address.b.a.aif().aii();
        if (aii.size() > 0) {
            this.cbx = aii;
            this.cbw.ag(this.cbx);
            ahZ();
            return;
        }
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.4
            @Override // java.lang.Runnable
            public void run() {
                List<com.baidu.swan.bdprivate.address.c.b> aig = com.baidu.swan.bdprivate.address.b.a.aif().aig();
                if (aig != null && aig.size() > 0) {
                    DeliveryListActivity.this.cbx = aig;
                }
                DeliveryListActivity.this.cbz.sendEmptyMessage(1);
            }
        }, "loadDeliveryData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahZ() {
        showLoading();
        if (TextUtils.equals(this.cbr, "aiapp")) {
            com.baidu.swan.bdprivate.a.a.a(this, new com.baidu.swan.apps.as.d.b<Bundle>() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: z */
                public void D(Bundle bundle) {
                    if (bundle != null) {
                        String string = bundle.getString("dev", "");
                        if (!TextUtils.isEmpty(string)) {
                            DeliveryListActivity.this.cbA.putString("stoken", string);
                            com.baidu.swan.bdprivate.address.b.a.aif().R(DeliveryListActivity.this.cbA);
                            DeliveryListActivity.this.aia();
                            return;
                        }
                    }
                    d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_token_error)).showToast();
                }
            }, "dev");
        } else {
            aia();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aia() {
        com.baidu.swan.bdprivate.address.b.a.aif().a(new a.C0316a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.6
            @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
            public void aib() {
                DeliveryListActivity.this.ahW();
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
            public void b(List<com.baidu.swan.bdprivate.address.c.b> list, int i) {
                DeliveryListActivity.this.ab(list);
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_net_error)).showToast();
                if (DeliveryListActivity.this.cbx == null || DeliveryListActivity.this.cbx.size() == 0) {
                    DeliveryListActivity.this.cbw.e(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.6.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DeliveryListActivity.this.ahZ();
                        }
                    });
                }
            }
        });
    }

    private void showLoading() {
        this.cbp.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahW() {
        if (this != null && !isFinishing()) {
            this.cbp.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(List<com.baidu.swan.bdprivate.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.cbw.ag(list);
            this.cbx = list;
        } else if (this.cbx == null || this.cbx.size() <= 0) {
            this.cbw.aiu();
        }
    }

    @Override // com.baidu.swan.bdprivate.address.a.a.b
    public void b(com.baidu.swan.bdprivate.address.c.b bVar, String str) {
        if (bVar != null) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("addrInfo", com.baidu.swan.bdprivate.address.c.b.c(bVar).toString());
            bundle.putString("type", str);
            intent.putExtra("data", bundle);
            intent.putExtra("openSource", this.cbr);
            intent.setClass(this, DeliveryEditActivity.class);
            startActivityForResult(intent, nc(str));
        }
    }

    private int nc(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -838846263:
                if (str.equals(IMTrack.DbBuilder.ACTION_UPDATE)) {
                    c = 1;
                    break;
                }
                break;
            case 96417:
                if (str.equals("add")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 256;
            case 1:
                return 257;
            default:
                return 0;
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            this.cbB = intent.getBooleanExtra("dataChanged", false);
        }
    }

    @Override // com.baidu.swan.bdprivate.address.a.a.b
    public void onItemClick(int i) {
        if (this.cbx != null && i < this.cbx.size()) {
            com.baidu.swan.bdprivate.address.c.b bVar = this.cbx.get(i);
            if (TextUtils.equals(this.cbr, "main")) {
                a(bVar, i);
            }
            if (TextUtils.equals(this.cbr, "aiapp")) {
                Intent intent = new Intent();
                intent.putExtra("data", com.baidu.swan.bdprivate.address.c.b.d(bVar).toString());
                setResult(-1, intent);
                finish();
            }
        }
    }

    private void a(com.baidu.swan.bdprivate.address.c.b bVar, final int i) {
        com.baidu.swan.bdprivate.address.c.b bVar2 = new com.baidu.swan.bdprivate.address.c.b();
        bVar2.id = bVar.id;
        com.baidu.swan.bdprivate.address.b.a.aif().d(bVar2, new a.C0316a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.7
            @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
            public void J(String str, int i2) {
                for (int i3 = 0; i3 < DeliveryListActivity.this.cbx.size(); i3++) {
                    com.baidu.swan.bdprivate.address.c.b bVar3 = (com.baidu.swan.bdprivate.address.c.b) DeliveryListActivity.this.cbx.get(i3);
                    bVar3.cct = false;
                    if (i3 == i) {
                        bVar3.cct = true;
                    }
                }
                DeliveryListActivity.this.cbw.ag(DeliveryListActivity.this.cbx);
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_net_error)).showToast();
            }
        });
    }

    @Override // com.baidu.swan.bdprivate.address.a.a.b
    public void hq(final int i) {
        if (this.cby == null) {
            this.cby = new com.baidu.swan.bdprivate.widget.a(this.cbw);
            this.cby.setPopupWindowWidth(af.S(148.0f));
            this.cby.setLayoutInCenter(true);
            this.cby.s(0, b.g.delivery_delete, b.d.delivery_delete);
        }
        this.cby.a(new b.a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.8
            @Override // com.baidu.swan.apps.res.widget.a.b.a
            public void c(com.baidu.swan.apps.res.widget.a.b bVar) {
                switch (bVar.getItemId()) {
                    case 0:
                        DeliveryListActivity.this.hr(i);
                        return;
                    default:
                        return;
                }
            }
        });
        this.cby.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hr(final int i) {
        com.baidu.swan.bdprivate.address.c.b bVar;
        if (this.cbx != null && i < this.cbx.size() && (bVar = this.cbx.get(i)) != null && !TextUtils.isEmpty(bVar.id)) {
            final boolean z = bVar.cct;
            com.baidu.swan.bdprivate.address.c.b bVar2 = new com.baidu.swan.bdprivate.address.c.b();
            bVar2.id = bVar.id;
            showLoading();
            com.baidu.swan.bdprivate.address.b.a.aif().b(bVar2, new a.C0316a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.9
                @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
                public void aib() {
                    DeliveryListActivity.this.ahW();
                }

                @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
                public void K(String str, int i2) {
                    DeliveryListActivity.this.cbx.remove(i);
                    if (z && DeliveryListActivity.this.cbx.size() > 0) {
                        ((com.baidu.swan.bdprivate.address.c.b) DeliveryListActivity.this.cbx.get(0)).cct = true;
                    }
                    DeliveryListActivity.this.cbB = true;
                    DeliveryListActivity.this.cbw.ag(DeliveryListActivity.this.cbx);
                }

                @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
                public void onFailure() {
                    d.a(AppRuntime.getAppContext(), "网络异常").showToast();
                }
            });
        }
    }

    private void C(Intent intent) {
        this.cbA = intent.getExtras();
        if (this.cbA == null) {
            this.cbA = new Bundle();
        }
        String string = this.cbA.getString("openSource");
        if (!TextUtils.isEmpty(string)) {
            this.cbr = string;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cbB) {
            com.baidu.swan.bdprivate.address.b.a.aif().aih();
        }
    }
}

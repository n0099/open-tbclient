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
    private com.baidu.swan.bdprivate.widget.b cbn;
    private String cbp;
    private ChooseAddressView cbu;
    private List<com.baidu.swan.bdprivate.address.c.b> cbv = new ArrayList();
    private com.baidu.swan.bdprivate.widget.a cbw;
    private Handler cbx;
    private Bundle cby;
    private boolean cbz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C(getIntent());
        ahV();
    }

    private void ahV() {
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
        this.cbu = new ChooseAddressView(this);
        setContentView(this.cbu);
        af.W(this);
        this.cbn = new com.baidu.swan.bdprivate.widget.b(this);
        this.cbn.setMessage("加载中...");
        this.cbn.setCancelable(true);
        ahQ();
        this.cbu.setDeliveryChooseListener(this);
        this.cbx = new Handler() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        DeliveryListActivity.this.cbu.ag(DeliveryListActivity.this.cbv);
                        DeliveryListActivity.this.ahX();
                        return;
                    default:
                        return;
                }
            }
        };
        com.baidu.swan.bdprivate.address.b.a.aid().R(this.cby);
        ahW();
    }

    private void ahQ() {
        SwanAppBdActionBar bdActionBar = this.cbu.getBdActionBar();
        bdActionBar.setRightMenuVisibility(false);
        bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeliveryListActivity.this.finish();
            }
        });
        if (TextUtils.equals(this.cbp, "aiapp")) {
            bdActionBar.setTitle(b.g.delivery_title_choose);
        } else {
            bdActionBar.setTitle(b.g.delivery_title_list);
        }
        bdActionBar.setLeftFirstViewVisibility(true);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.cbz) {
            this.cbv = com.baidu.swan.bdprivate.address.b.a.aid().aig();
            this.cbu.ag(this.cbv);
        }
    }

    private void ahW() {
        List<com.baidu.swan.bdprivate.address.c.b> aig = com.baidu.swan.bdprivate.address.b.a.aid().aig();
        if (aig.size() > 0) {
            this.cbv = aig;
            this.cbu.ag(this.cbv);
            ahX();
            return;
        }
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.4
            @Override // java.lang.Runnable
            public void run() {
                List<com.baidu.swan.bdprivate.address.c.b> aie = com.baidu.swan.bdprivate.address.b.a.aid().aie();
                if (aie != null && aie.size() > 0) {
                    DeliveryListActivity.this.cbv = aie;
                }
                DeliveryListActivity.this.cbx.sendEmptyMessage(1);
            }
        }, "loadDeliveryData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahX() {
        showLoading();
        if (TextUtils.equals(this.cbp, "aiapp")) {
            com.baidu.swan.bdprivate.a.a.a(this, new com.baidu.swan.apps.as.d.b<Bundle>() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: z */
                public void D(Bundle bundle) {
                    if (bundle != null) {
                        String string = bundle.getString("dev", "");
                        if (!TextUtils.isEmpty(string)) {
                            DeliveryListActivity.this.cby.putString("stoken", string);
                            com.baidu.swan.bdprivate.address.b.a.aid().R(DeliveryListActivity.this.cby);
                            DeliveryListActivity.this.ahY();
                            return;
                        }
                    }
                    d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_token_error)).showToast();
                }
            }, "dev");
        } else {
            ahY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahY() {
        com.baidu.swan.bdprivate.address.b.a.aid().a(new a.C0316a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.6
            @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
            public void ahZ() {
                DeliveryListActivity.this.ahU();
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
            public void b(List<com.baidu.swan.bdprivate.address.c.b> list, int i) {
                DeliveryListActivity.this.ab(list);
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_net_error)).showToast();
                if (DeliveryListActivity.this.cbv == null || DeliveryListActivity.this.cbv.size() == 0) {
                    DeliveryListActivity.this.cbu.e(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.6.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DeliveryListActivity.this.ahX();
                        }
                    });
                }
            }
        });
    }

    private void showLoading() {
        this.cbn.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahU() {
        if (this != null && !isFinishing()) {
            this.cbn.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(List<com.baidu.swan.bdprivate.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.cbu.ag(list);
            this.cbv = list;
        } else if (this.cbv == null || this.cbv.size() <= 0) {
            this.cbu.ais();
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
            intent.putExtra("openSource", this.cbp);
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
            this.cbz = intent.getBooleanExtra("dataChanged", false);
        }
    }

    @Override // com.baidu.swan.bdprivate.address.a.a.b
    public void onItemClick(int i) {
        if (this.cbv != null && i < this.cbv.size()) {
            com.baidu.swan.bdprivate.address.c.b bVar = this.cbv.get(i);
            if (TextUtils.equals(this.cbp, "main")) {
                a(bVar, i);
            }
            if (TextUtils.equals(this.cbp, "aiapp")) {
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
        com.baidu.swan.bdprivate.address.b.a.aid().d(bVar2, new a.C0316a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.7
            @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
            public void J(String str, int i2) {
                for (int i3 = 0; i3 < DeliveryListActivity.this.cbv.size(); i3++) {
                    com.baidu.swan.bdprivate.address.c.b bVar3 = (com.baidu.swan.bdprivate.address.c.b) DeliveryListActivity.this.cbv.get(i3);
                    bVar3.ccq = false;
                    if (i3 == i) {
                        bVar3.ccq = true;
                    }
                }
                DeliveryListActivity.this.cbu.ag(DeliveryListActivity.this.cbv);
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_net_error)).showToast();
            }
        });
    }

    @Override // com.baidu.swan.bdprivate.address.a.a.b
    public void hq(final int i) {
        if (this.cbw == null) {
            this.cbw = new com.baidu.swan.bdprivate.widget.a(this.cbu);
            this.cbw.setPopupWindowWidth(af.S(148.0f));
            this.cbw.setLayoutInCenter(true);
            this.cbw.s(0, b.g.delivery_delete, b.d.delivery_delete);
        }
        this.cbw.a(new b.a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.8
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
        this.cbw.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hr(final int i) {
        com.baidu.swan.bdprivate.address.c.b bVar;
        if (this.cbv != null && i < this.cbv.size() && (bVar = this.cbv.get(i)) != null && !TextUtils.isEmpty(bVar.id)) {
            final boolean z = bVar.ccq;
            com.baidu.swan.bdprivate.address.c.b bVar2 = new com.baidu.swan.bdprivate.address.c.b();
            bVar2.id = bVar.id;
            showLoading();
            com.baidu.swan.bdprivate.address.b.a.aid().b(bVar2, new a.C0316a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.9
                @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
                public void ahZ() {
                    DeliveryListActivity.this.ahU();
                }

                @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
                public void K(String str, int i2) {
                    DeliveryListActivity.this.cbv.remove(i);
                    if (z && DeliveryListActivity.this.cbv.size() > 0) {
                        ((com.baidu.swan.bdprivate.address.c.b) DeliveryListActivity.this.cbv.get(0)).ccq = true;
                    }
                    DeliveryListActivity.this.cbz = true;
                    DeliveryListActivity.this.cbu.ag(DeliveryListActivity.this.cbv);
                }

                @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
                public void onFailure() {
                    d.a(AppRuntime.getAppContext(), "网络异常").showToast();
                }
            });
        }
    }

    private void C(Intent intent) {
        this.cby = intent.getExtras();
        if (this.cby == null) {
            this.cby = new Bundle();
        }
        String string = this.cby.getString("openSource");
        if (!TextUtils.isEmpty(string)) {
            this.cbp = string;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cbz) {
            com.baidu.swan.bdprivate.address.b.a.aid().aif();
        }
    }
}

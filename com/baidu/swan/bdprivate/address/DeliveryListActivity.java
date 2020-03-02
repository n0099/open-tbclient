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
    private boolean cbA;
    private com.baidu.swan.bdprivate.widget.b cbo;
    private String cbq;
    private ChooseAddressView cbv;
    private List<com.baidu.swan.bdprivate.address.c.b> cbw = new ArrayList();
    private com.baidu.swan.bdprivate.widget.a cbx;
    private Handler cby;
    private Bundle cbz;

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
        this.cbv = new ChooseAddressView(this);
        setContentView(this.cbv);
        af.W(this);
        this.cbo = new com.baidu.swan.bdprivate.widget.b(this);
        this.cbo.setMessage("加载中...");
        this.cbo.setCancelable(true);
        ahS();
        this.cbv.setDeliveryChooseListener(this);
        this.cby = new Handler() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        DeliveryListActivity.this.cbv.ag(DeliveryListActivity.this.cbw);
                        DeliveryListActivity.this.ahZ();
                        return;
                    default:
                        return;
                }
            }
        };
        com.baidu.swan.bdprivate.address.b.a.aif().R(this.cbz);
        ahY();
    }

    private void ahS() {
        SwanAppBdActionBar bdActionBar = this.cbv.getBdActionBar();
        bdActionBar.setRightMenuVisibility(false);
        bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeliveryListActivity.this.finish();
            }
        });
        if (TextUtils.equals(this.cbq, "aiapp")) {
            bdActionBar.setTitle(b.g.delivery_title_choose);
        } else {
            bdActionBar.setTitle(b.g.delivery_title_list);
        }
        bdActionBar.setLeftFirstViewVisibility(true);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.cbA) {
            this.cbw = com.baidu.swan.bdprivate.address.b.a.aif().aii();
            this.cbv.ag(this.cbw);
        }
    }

    private void ahY() {
        List<com.baidu.swan.bdprivate.address.c.b> aii = com.baidu.swan.bdprivate.address.b.a.aif().aii();
        if (aii.size() > 0) {
            this.cbw = aii;
            this.cbv.ag(this.cbw);
            ahZ();
            return;
        }
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.4
            @Override // java.lang.Runnable
            public void run() {
                List<com.baidu.swan.bdprivate.address.c.b> aig = com.baidu.swan.bdprivate.address.b.a.aif().aig();
                if (aig != null && aig.size() > 0) {
                    DeliveryListActivity.this.cbw = aig;
                }
                DeliveryListActivity.this.cby.sendEmptyMessage(1);
            }
        }, "loadDeliveryData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahZ() {
        showLoading();
        if (TextUtils.equals(this.cbq, "aiapp")) {
            com.baidu.swan.bdprivate.a.a.a(this, new com.baidu.swan.apps.as.d.b<Bundle>() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: z */
                public void D(Bundle bundle) {
                    if (bundle != null) {
                        String string = bundle.getString("dev", "");
                        if (!TextUtils.isEmpty(string)) {
                            DeliveryListActivity.this.cbz.putString("stoken", string);
                            com.baidu.swan.bdprivate.address.b.a.aif().R(DeliveryListActivity.this.cbz);
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
                if (DeliveryListActivity.this.cbw == null || DeliveryListActivity.this.cbw.size() == 0) {
                    DeliveryListActivity.this.cbv.e(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.6.1
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
        this.cbo.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahW() {
        if (this != null && !isFinishing()) {
            this.cbo.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(List<com.baidu.swan.bdprivate.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.cbv.ag(list);
            this.cbw = list;
        } else if (this.cbw == null || this.cbw.size() <= 0) {
            this.cbv.aiu();
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
            intent.putExtra("openSource", this.cbq);
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
            this.cbA = intent.getBooleanExtra("dataChanged", false);
        }
    }

    @Override // com.baidu.swan.bdprivate.address.a.a.b
    public void onItemClick(int i) {
        if (this.cbw != null && i < this.cbw.size()) {
            com.baidu.swan.bdprivate.address.c.b bVar = this.cbw.get(i);
            if (TextUtils.equals(this.cbq, "main")) {
                a(bVar, i);
            }
            if (TextUtils.equals(this.cbq, "aiapp")) {
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
                for (int i3 = 0; i3 < DeliveryListActivity.this.cbw.size(); i3++) {
                    com.baidu.swan.bdprivate.address.c.b bVar3 = (com.baidu.swan.bdprivate.address.c.b) DeliveryListActivity.this.cbw.get(i3);
                    bVar3.ccr = false;
                    if (i3 == i) {
                        bVar3.ccr = true;
                    }
                }
                DeliveryListActivity.this.cbv.ag(DeliveryListActivity.this.cbw);
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_net_error)).showToast();
            }
        });
    }

    @Override // com.baidu.swan.bdprivate.address.a.a.b
    public void hq(final int i) {
        if (this.cbx == null) {
            this.cbx = new com.baidu.swan.bdprivate.widget.a(this.cbv);
            this.cbx.setPopupWindowWidth(af.S(148.0f));
            this.cbx.setLayoutInCenter(true);
            this.cbx.s(0, b.g.delivery_delete, b.d.delivery_delete);
        }
        this.cbx.a(new b.a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.8
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
        this.cbx.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hr(final int i) {
        com.baidu.swan.bdprivate.address.c.b bVar;
        if (this.cbw != null && i < this.cbw.size() && (bVar = this.cbw.get(i)) != null && !TextUtils.isEmpty(bVar.id)) {
            final boolean z = bVar.ccr;
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
                    DeliveryListActivity.this.cbw.remove(i);
                    if (z && DeliveryListActivity.this.cbw.size() > 0) {
                        ((com.baidu.swan.bdprivate.address.c.b) DeliveryListActivity.this.cbw.get(0)).ccr = true;
                    }
                    DeliveryListActivity.this.cbA = true;
                    DeliveryListActivity.this.cbv.ag(DeliveryListActivity.this.cbw);
                }

                @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
                public void onFailure() {
                    d.a(AppRuntime.getAppContext(), "网络异常").showToast();
                }
            });
        }
    }

    private void C(Intent intent) {
        this.cbz = intent.getExtras();
        if (this.cbz == null) {
            this.cbz = new Bundle();
        }
        String string = this.cbz.getString("openSource");
        if (!TextUtils.isEmpty(string)) {
            this.cbq = string;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cbA) {
            com.baidu.swan.bdprivate.address.b.a.aif().aih();
        }
    }
}

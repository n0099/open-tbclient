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
/* loaded from: classes9.dex */
public class DeliveryListActivity extends BaseActivity implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.bdprivate.widget.b bWY;
    private String bXa;
    private ChooseAddressView bXe;
    private List<com.baidu.swan.bdprivate.address.c.b> bXf = new ArrayList();
    private com.baidu.swan.bdprivate.widget.a bXg;
    private Handler bXh;
    private Bundle bXi;
    private boolean bXj;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C(getIntent());
        afo();
    }

    private void afo() {
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
        this.bXe = new ChooseAddressView(this);
        setContentView(this.bXe);
        af.U(this);
        this.bWY = new com.baidu.swan.bdprivate.widget.b(this);
        this.bWY.setMessage("加载中...");
        this.bWY.setCancelable(true);
        afj();
        this.bXe.setDeliveryChooseListener(this);
        this.bXh = new Handler() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        DeliveryListActivity.this.bXe.ah(DeliveryListActivity.this.bXf);
                        DeliveryListActivity.this.afq();
                        return;
                    default:
                        return;
                }
            }
        };
        com.baidu.swan.bdprivate.address.b.a.afw().R(this.bXi);
        afp();
    }

    private void afj() {
        SwanAppBdActionBar bdActionBar = this.bXe.getBdActionBar();
        bdActionBar.setRightMenuVisibility(false);
        bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeliveryListActivity.this.finish();
            }
        });
        if (TextUtils.equals(this.bXa, "aiapp")) {
            bdActionBar.setTitle(b.g.delivery_title_choose);
        } else {
            bdActionBar.setTitle(b.g.delivery_title_list);
        }
        bdActionBar.setLeftFirstViewVisibility(true);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.bXj) {
            this.bXf = com.baidu.swan.bdprivate.address.b.a.afw().afz();
            this.bXe.ah(this.bXf);
        }
    }

    private void afp() {
        List<com.baidu.swan.bdprivate.address.c.b> afz = com.baidu.swan.bdprivate.address.b.a.afw().afz();
        if (afz.size() > 0) {
            this.bXf = afz;
            this.bXe.ah(this.bXf);
            afq();
            return;
        }
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.4
            @Override // java.lang.Runnable
            public void run() {
                List<com.baidu.swan.bdprivate.address.c.b> afx = com.baidu.swan.bdprivate.address.b.a.afw().afx();
                if (afx != null && afx.size() > 0) {
                    DeliveryListActivity.this.bXf = afx;
                }
                DeliveryListActivity.this.bXh.sendEmptyMessage(1);
            }
        }, "loadDeliveryData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afq() {
        showLoading();
        if (TextUtils.equals(this.bXa, "aiapp")) {
            com.baidu.swan.bdprivate.a.a.a(this, new com.baidu.swan.apps.as.d.b<Bundle>() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: z */
                public void B(Bundle bundle) {
                    if (bundle != null) {
                        String string = bundle.getString("dev", "");
                        if (!TextUtils.isEmpty(string)) {
                            DeliveryListActivity.this.bXi.putString("stoken", string);
                            com.baidu.swan.bdprivate.address.b.a.afw().R(DeliveryListActivity.this.bXi);
                            DeliveryListActivity.this.afr();
                            return;
                        }
                    }
                    d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_token_error)).showToast();
                }
            }, "dev");
        } else {
            afr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afr() {
        com.baidu.swan.bdprivate.address.b.a.afw().a(new a.C0304a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.6
            @Override // com.baidu.swan.bdprivate.address.b.a.C0304a, com.baidu.swan.bdprivate.address.b.b
            public void afs() {
                DeliveryListActivity.this.afn();
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0304a, com.baidu.swan.bdprivate.address.b.b
            public void b(List<com.baidu.swan.bdprivate.address.c.b> list, int i) {
                DeliveryListActivity.this.ac(list);
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0304a, com.baidu.swan.bdprivate.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_net_error)).showToast();
                if (DeliveryListActivity.this.bXf == null || DeliveryListActivity.this.bXf.size() == 0) {
                    DeliveryListActivity.this.bXe.f(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.6.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DeliveryListActivity.this.afq();
                        }
                    });
                }
            }
        });
    }

    private void showLoading() {
        this.bWY.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afn() {
        if (this != null && !isFinishing()) {
            this.bWY.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(List<com.baidu.swan.bdprivate.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.bXe.ah(list);
            this.bXf = list;
        } else if (this.bXf == null || this.bXf.size() <= 0) {
            this.bXe.afL();
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
            intent.putExtra("openSource", this.bXa);
            intent.setClass(this, DeliveryEditActivity.class);
            startActivityForResult(intent, mK(str));
        }
    }

    private int mK(String str) {
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
            this.bXj = intent.getBooleanExtra("dataChanged", false);
        }
    }

    @Override // com.baidu.swan.bdprivate.address.a.a.b
    public void onItemClick(int i) {
        if (this.bXf != null && i < this.bXf.size()) {
            com.baidu.swan.bdprivate.address.c.b bVar = this.bXf.get(i);
            if (TextUtils.equals(this.bXa, "main")) {
                a(bVar, i);
            }
            if (TextUtils.equals(this.bXa, "aiapp")) {
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
        com.baidu.swan.bdprivate.address.b.a.afw().d(bVar2, new a.C0304a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.7
            @Override // com.baidu.swan.bdprivate.address.b.a.C0304a, com.baidu.swan.bdprivate.address.b.b
            public void L(String str, int i2) {
                for (int i3 = 0; i3 < DeliveryListActivity.this.bXf.size(); i3++) {
                    com.baidu.swan.bdprivate.address.c.b bVar3 = (com.baidu.swan.bdprivate.address.c.b) DeliveryListActivity.this.bXf.get(i3);
                    bVar3.bYa = false;
                    if (i3 == i) {
                        bVar3.bYa = true;
                    }
                }
                DeliveryListActivity.this.bXe.ah(DeliveryListActivity.this.bXf);
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0304a, com.baidu.swan.bdprivate.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_net_error)).showToast();
            }
        });
    }

    @Override // com.baidu.swan.bdprivate.address.a.a.b
    public void gZ(final int i) {
        if (this.bXg == null) {
            this.bXg = new com.baidu.swan.bdprivate.widget.a(this.bXe);
            this.bXg.setPopupWindowWidth(af.T(148.0f));
            this.bXg.setLayoutInCenter(true);
            this.bXg.r(0, b.g.delivery_delete, b.d.delivery_delete);
        }
        this.bXg.a(new b.a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.8
            @Override // com.baidu.swan.apps.res.widget.a.b.a
            public void c(com.baidu.swan.apps.res.widget.a.b bVar) {
                switch (bVar.getItemId()) {
                    case 0:
                        DeliveryListActivity.this.ha(i);
                        return;
                    default:
                        return;
                }
            }
        });
        this.bXg.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ha(final int i) {
        com.baidu.swan.bdprivate.address.c.b bVar;
        if (this.bXf != null && i < this.bXf.size() && (bVar = this.bXf.get(i)) != null && !TextUtils.isEmpty(bVar.id)) {
            final boolean z = bVar.bYa;
            com.baidu.swan.bdprivate.address.c.b bVar2 = new com.baidu.swan.bdprivate.address.c.b();
            bVar2.id = bVar.id;
            showLoading();
            com.baidu.swan.bdprivate.address.b.a.afw().b(bVar2, new a.C0304a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.9
                @Override // com.baidu.swan.bdprivate.address.b.a.C0304a, com.baidu.swan.bdprivate.address.b.b
                public void afs() {
                    DeliveryListActivity.this.afn();
                }

                @Override // com.baidu.swan.bdprivate.address.b.a.C0304a, com.baidu.swan.bdprivate.address.b.b
                public void M(String str, int i2) {
                    DeliveryListActivity.this.bXf.remove(i);
                    if (z && DeliveryListActivity.this.bXf.size() > 0) {
                        ((com.baidu.swan.bdprivate.address.c.b) DeliveryListActivity.this.bXf.get(0)).bYa = true;
                    }
                    DeliveryListActivity.this.bXj = true;
                    DeliveryListActivity.this.bXe.ah(DeliveryListActivity.this.bXf);
                }

                @Override // com.baidu.swan.bdprivate.address.b.a.C0304a, com.baidu.swan.bdprivate.address.b.b
                public void onFailure() {
                    d.a(AppRuntime.getAppContext(), "网络异常").showToast();
                }
            });
        }
    }

    private void C(Intent intent) {
        this.bXi = intent.getExtras();
        if (this.bXi == null) {
            this.bXi = new Bundle();
        }
        String string = this.bXi.getString("openSource");
        if (!TextUtils.isEmpty(string)) {
            this.bXa = string;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bXj) {
            com.baidu.swan.bdprivate.address.b.a.afw().afy();
        }
    }
}

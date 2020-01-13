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
/* loaded from: classes10.dex */
public class DeliveryListActivity extends BaseActivity implements a.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.bdprivate.widget.b bXk;
    private String bXm;
    private ChooseAddressView bXq;
    private List<com.baidu.swan.bdprivate.address.c.b> bXr = new ArrayList();
    private com.baidu.swan.bdprivate.widget.a bXs;
    private Handler bXt;
    private Bundle bXu;
    private boolean bXv;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C(getIntent());
        afH();
    }

    private void afH() {
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
        this.bXq = new ChooseAddressView(this);
        setContentView(this.bXq);
        af.V(this);
        this.bXk = new com.baidu.swan.bdprivate.widget.b(this);
        this.bXk.setMessage("加载中...");
        this.bXk.setCancelable(true);
        afC();
        this.bXq.setDeliveryChooseListener(this);
        this.bXt = new Handler() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        DeliveryListActivity.this.bXq.ag(DeliveryListActivity.this.bXr);
                        DeliveryListActivity.this.afJ();
                        return;
                    default:
                        return;
                }
            }
        };
        com.baidu.swan.bdprivate.address.b.a.afP().R(this.bXu);
        afI();
    }

    private void afC() {
        SwanAppBdActionBar bdActionBar = this.bXq.getBdActionBar();
        bdActionBar.setRightMenuVisibility(false);
        bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeliveryListActivity.this.finish();
            }
        });
        if (TextUtils.equals(this.bXm, "aiapp")) {
            bdActionBar.setTitle(b.g.delivery_title_choose);
        } else {
            bdActionBar.setTitle(b.g.delivery_title_list);
        }
        bdActionBar.setLeftFirstViewVisibility(true);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.bXv) {
            this.bXr = com.baidu.swan.bdprivate.address.b.a.afP().afS();
            this.bXq.ag(this.bXr);
        }
    }

    private void afI() {
        List<com.baidu.swan.bdprivate.address.c.b> afS = com.baidu.swan.bdprivate.address.b.a.afP().afS();
        if (afS.size() > 0) {
            this.bXr = afS;
            this.bXq.ag(this.bXr);
            afJ();
            return;
        }
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.4
            @Override // java.lang.Runnable
            public void run() {
                List<com.baidu.swan.bdprivate.address.c.b> afQ = com.baidu.swan.bdprivate.address.b.a.afP().afQ();
                if (afQ != null && afQ.size() > 0) {
                    DeliveryListActivity.this.bXr = afQ;
                }
                DeliveryListActivity.this.bXt.sendEmptyMessage(1);
            }
        }, "loadDeliveryData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afJ() {
        showLoading();
        if (TextUtils.equals(this.bXm, "aiapp")) {
            com.baidu.swan.bdprivate.a.a.a(this, new com.baidu.swan.apps.as.d.b<Bundle>() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: z */
                public void B(Bundle bundle) {
                    if (bundle != null) {
                        String string = bundle.getString("dev", "");
                        if (!TextUtils.isEmpty(string)) {
                            DeliveryListActivity.this.bXu.putString("stoken", string);
                            com.baidu.swan.bdprivate.address.b.a.afP().R(DeliveryListActivity.this.bXu);
                            DeliveryListActivity.this.afK();
                            return;
                        }
                    }
                    d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_token_error)).showToast();
                }
            }, "dev");
        } else {
            afK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afK() {
        com.baidu.swan.bdprivate.address.b.a.afP().a(new a.C0306a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.6
            @Override // com.baidu.swan.bdprivate.address.b.a.C0306a, com.baidu.swan.bdprivate.address.b.b
            public void afL() {
                DeliveryListActivity.this.afG();
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0306a, com.baidu.swan.bdprivate.address.b.b
            public void b(List<com.baidu.swan.bdprivate.address.c.b> list, int i) {
                DeliveryListActivity.this.ab(list);
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0306a, com.baidu.swan.bdprivate.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_net_error)).showToast();
                if (DeliveryListActivity.this.bXr == null || DeliveryListActivity.this.bXr.size() == 0) {
                    DeliveryListActivity.this.bXq.e(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.6.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DeliveryListActivity.this.afJ();
                        }
                    });
                }
            }
        });
    }

    private void showLoading() {
        this.bXk.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afG() {
        if (this != null && !isFinishing()) {
            this.bXk.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(List<com.baidu.swan.bdprivate.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.bXq.ag(list);
            this.bXr = list;
        } else if (this.bXr == null || this.bXr.size() <= 0) {
            this.bXq.age();
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
            intent.putExtra("openSource", this.bXm);
            intent.setClass(this, DeliveryEditActivity.class);
            startActivityForResult(intent, mN(str));
        }
    }

    private int mN(String str) {
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
            this.bXv = intent.getBooleanExtra("dataChanged", false);
        }
    }

    @Override // com.baidu.swan.bdprivate.address.a.a.b
    public void onItemClick(int i) {
        if (this.bXr != null && i < this.bXr.size()) {
            com.baidu.swan.bdprivate.address.c.b bVar = this.bXr.get(i);
            if (TextUtils.equals(this.bXm, "main")) {
                a(bVar, i);
            }
            if (TextUtils.equals(this.bXm, "aiapp")) {
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
        com.baidu.swan.bdprivate.address.b.a.afP().d(bVar2, new a.C0306a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.7
            @Override // com.baidu.swan.bdprivate.address.b.a.C0306a, com.baidu.swan.bdprivate.address.b.b
            public void L(String str, int i2) {
                for (int i3 = 0; i3 < DeliveryListActivity.this.bXr.size(); i3++) {
                    com.baidu.swan.bdprivate.address.c.b bVar3 = (com.baidu.swan.bdprivate.address.c.b) DeliveryListActivity.this.bXr.get(i3);
                    bVar3.bYm = false;
                    if (i3 == i) {
                        bVar3.bYm = true;
                    }
                }
                DeliveryListActivity.this.bXq.ag(DeliveryListActivity.this.bXr);
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0306a, com.baidu.swan.bdprivate.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_net_error)).showToast();
            }
        });
    }

    @Override // com.baidu.swan.bdprivate.address.a.a.b
    public void gZ(final int i) {
        if (this.bXs == null) {
            this.bXs = new com.baidu.swan.bdprivate.widget.a(this.bXq);
            this.bXs.setPopupWindowWidth(af.S(148.0f));
            this.bXs.setLayoutInCenter(true);
            this.bXs.r(0, b.g.delivery_delete, b.d.delivery_delete);
        }
        this.bXs.a(new b.a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.8
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
        this.bXs.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ha(final int i) {
        com.baidu.swan.bdprivate.address.c.b bVar;
        if (this.bXr != null && i < this.bXr.size() && (bVar = this.bXr.get(i)) != null && !TextUtils.isEmpty(bVar.id)) {
            final boolean z = bVar.bYm;
            com.baidu.swan.bdprivate.address.c.b bVar2 = new com.baidu.swan.bdprivate.address.c.b();
            bVar2.id = bVar.id;
            showLoading();
            com.baidu.swan.bdprivate.address.b.a.afP().b(bVar2, new a.C0306a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.9
                @Override // com.baidu.swan.bdprivate.address.b.a.C0306a, com.baidu.swan.bdprivate.address.b.b
                public void afL() {
                    DeliveryListActivity.this.afG();
                }

                @Override // com.baidu.swan.bdprivate.address.b.a.C0306a, com.baidu.swan.bdprivate.address.b.b
                public void M(String str, int i2) {
                    DeliveryListActivity.this.bXr.remove(i);
                    if (z && DeliveryListActivity.this.bXr.size() > 0) {
                        ((com.baidu.swan.bdprivate.address.c.b) DeliveryListActivity.this.bXr.get(0)).bYm = true;
                    }
                    DeliveryListActivity.this.bXv = true;
                    DeliveryListActivity.this.bXq.ag(DeliveryListActivity.this.bXr);
                }

                @Override // com.baidu.swan.bdprivate.address.b.a.C0306a, com.baidu.swan.bdprivate.address.b.b
                public void onFailure() {
                    d.a(AppRuntime.getAppContext(), "网络异常").showToast();
                }
            });
        }
    }

    private void C(Intent intent) {
        this.bXu = intent.getExtras();
        if (this.bXu == null) {
            this.bXu = new Bundle();
        }
        String string = this.bXu.getString("openSource");
        if (!TextUtils.isEmpty(string)) {
            this.bXm = string;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bXv) {
            com.baidu.swan.bdprivate.address.b.a.afP().afR();
        }
    }
}

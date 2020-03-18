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
    private com.baidu.swan.bdprivate.widget.b cbB;
    private String cbD;
    private ChooseAddressView cbH;
    private List<com.baidu.swan.bdprivate.address.c.b> cbI = new ArrayList();
    private com.baidu.swan.bdprivate.widget.a cbJ;
    private Handler cbK;
    private Bundle cbL;
    private boolean cbM;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C(getIntent());
        aia();
    }

    private void aia() {
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
        this.cbH = new ChooseAddressView(this);
        setContentView(this.cbH);
        af.W(this);
        this.cbB = new com.baidu.swan.bdprivate.widget.b(this);
        this.cbB.setMessage("加载中...");
        this.cbB.setCancelable(true);
        ahV();
        this.cbH.setDeliveryChooseListener(this);
        this.cbK = new Handler() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        DeliveryListActivity.this.cbH.ag(DeliveryListActivity.this.cbI);
                        DeliveryListActivity.this.aic();
                        return;
                    default:
                        return;
                }
            }
        };
        com.baidu.swan.bdprivate.address.b.a.aii().R(this.cbL);
        aib();
    }

    private void ahV() {
        SwanAppBdActionBar bdActionBar = this.cbH.getBdActionBar();
        bdActionBar.setRightMenuVisibility(false);
        bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeliveryListActivity.this.finish();
            }
        });
        if (TextUtils.equals(this.cbD, "aiapp")) {
            bdActionBar.setTitle(b.g.delivery_title_choose);
        } else {
            bdActionBar.setTitle(b.g.delivery_title_list);
        }
        bdActionBar.setLeftFirstViewVisibility(true);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.cbM) {
            this.cbI = com.baidu.swan.bdprivate.address.b.a.aii().ail();
            this.cbH.ag(this.cbI);
        }
    }

    private void aib() {
        List<com.baidu.swan.bdprivate.address.c.b> ail = com.baidu.swan.bdprivate.address.b.a.aii().ail();
        if (ail.size() > 0) {
            this.cbI = ail;
            this.cbH.ag(this.cbI);
            aic();
            return;
        }
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.4
            @Override // java.lang.Runnable
            public void run() {
                List<com.baidu.swan.bdprivate.address.c.b> aij = com.baidu.swan.bdprivate.address.b.a.aii().aij();
                if (aij != null && aij.size() > 0) {
                    DeliveryListActivity.this.cbI = aij;
                }
                DeliveryListActivity.this.cbK.sendEmptyMessage(1);
            }
        }, "loadDeliveryData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aic() {
        showLoading();
        if (TextUtils.equals(this.cbD, "aiapp")) {
            com.baidu.swan.bdprivate.a.a.a(this, new com.baidu.swan.apps.as.d.b<Bundle>() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: z */
                public void D(Bundle bundle) {
                    if (bundle != null) {
                        String string = bundle.getString("dev", "");
                        if (!TextUtils.isEmpty(string)) {
                            DeliveryListActivity.this.cbL.putString("stoken", string);
                            com.baidu.swan.bdprivate.address.b.a.aii().R(DeliveryListActivity.this.cbL);
                            DeliveryListActivity.this.aid();
                            return;
                        }
                    }
                    d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_token_error)).showToast();
                }
            }, "dev");
        } else {
            aid();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aid() {
        com.baidu.swan.bdprivate.address.b.a.aii().a(new a.C0316a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.6
            @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
            public void aie() {
                DeliveryListActivity.this.ahZ();
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
            public void b(List<com.baidu.swan.bdprivate.address.c.b> list, int i) {
                DeliveryListActivity.this.ab(list);
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_net_error)).showToast();
                if (DeliveryListActivity.this.cbI == null || DeliveryListActivity.this.cbI.size() == 0) {
                    DeliveryListActivity.this.cbH.e(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.6.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DeliveryListActivity.this.aic();
                        }
                    });
                }
            }
        });
    }

    private void showLoading() {
        this.cbB.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahZ() {
        if (this != null && !isFinishing()) {
            this.cbB.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(List<com.baidu.swan.bdprivate.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.cbH.ag(list);
            this.cbI = list;
        } else if (this.cbI == null || this.cbI.size() <= 0) {
            this.cbH.aix();
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
            intent.putExtra("openSource", this.cbD);
            intent.setClass(this, DeliveryEditActivity.class);
            startActivityForResult(intent, nb(str));
        }
    }

    private int nb(String str) {
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
            this.cbM = intent.getBooleanExtra("dataChanged", false);
        }
    }

    @Override // com.baidu.swan.bdprivate.address.a.a.b
    public void onItemClick(int i) {
        if (this.cbI != null && i < this.cbI.size()) {
            com.baidu.swan.bdprivate.address.c.b bVar = this.cbI.get(i);
            if (TextUtils.equals(this.cbD, "main")) {
                a(bVar, i);
            }
            if (TextUtils.equals(this.cbD, "aiapp")) {
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
        com.baidu.swan.bdprivate.address.b.a.aii().d(bVar2, new a.C0316a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.7
            @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
            public void J(String str, int i2) {
                for (int i3 = 0; i3 < DeliveryListActivity.this.cbI.size(); i3++) {
                    com.baidu.swan.bdprivate.address.c.b bVar3 = (com.baidu.swan.bdprivate.address.c.b) DeliveryListActivity.this.cbI.get(i3);
                    bVar3.ccE = false;
                    if (i3 == i) {
                        bVar3.ccE = true;
                    }
                }
                DeliveryListActivity.this.cbH.ag(DeliveryListActivity.this.cbI);
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_net_error)).showToast();
            }
        });
    }

    @Override // com.baidu.swan.bdprivate.address.a.a.b
    public void hq(final int i) {
        if (this.cbJ == null) {
            this.cbJ = new com.baidu.swan.bdprivate.widget.a(this.cbH);
            this.cbJ.setPopupWindowWidth(af.S(148.0f));
            this.cbJ.setLayoutInCenter(true);
            this.cbJ.s(0, b.g.delivery_delete, b.d.delivery_delete);
        }
        this.cbJ.a(new b.a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.8
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
        this.cbJ.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hr(final int i) {
        com.baidu.swan.bdprivate.address.c.b bVar;
        if (this.cbI != null && i < this.cbI.size() && (bVar = this.cbI.get(i)) != null && !TextUtils.isEmpty(bVar.id)) {
            final boolean z = bVar.ccE;
            com.baidu.swan.bdprivate.address.c.b bVar2 = new com.baidu.swan.bdprivate.address.c.b();
            bVar2.id = bVar.id;
            showLoading();
            com.baidu.swan.bdprivate.address.b.a.aii().b(bVar2, new a.C0316a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.9
                @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
                public void aie() {
                    DeliveryListActivity.this.ahZ();
                }

                @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
                public void K(String str, int i2) {
                    DeliveryListActivity.this.cbI.remove(i);
                    if (z && DeliveryListActivity.this.cbI.size() > 0) {
                        ((com.baidu.swan.bdprivate.address.c.b) DeliveryListActivity.this.cbI.get(0)).ccE = true;
                    }
                    DeliveryListActivity.this.cbM = true;
                    DeliveryListActivity.this.cbH.ag(DeliveryListActivity.this.cbI);
                }

                @Override // com.baidu.swan.bdprivate.address.b.a.C0316a, com.baidu.swan.bdprivate.address.b.b
                public void onFailure() {
                    d.a(AppRuntime.getAppContext(), "网络异常").showToast();
                }
            });
        }
    }

    private void C(Intent intent) {
        this.cbL = intent.getExtras();
        if (this.cbL == null) {
            this.cbL = new Bundle();
        }
        String string = this.cbL.getString("openSource");
        if (!TextUtils.isEmpty(string)) {
            this.cbD = string;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cbM) {
            com.baidu.swan.bdprivate.address.b.a.aii().aik();
        }
    }
}

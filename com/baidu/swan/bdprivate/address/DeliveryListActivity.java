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
    private com.baidu.swan.bdprivate.widget.b cAI;
    private String cAK;
    private ChooseAddressView cAO;
    private List<com.baidu.swan.bdprivate.address.c.b> cAP = new ArrayList();
    private com.baidu.swan.bdprivate.widget.a cAQ;
    private Handler cAR;
    private Bundle cAS;
    private boolean cAT;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o(getIntent());
        aqh();
    }

    private void aqh() {
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
        this.cAO = new ChooseAddressView(this);
        setContentView(this.cAO);
        af.S(this);
        this.cAI = new com.baidu.swan.bdprivate.widget.b(this);
        this.cAI.setMessage("加载中...");
        this.cAI.setCancelable(true);
        aqc();
        this.cAO.setDeliveryChooseListener(this);
        this.cAR = new Handler() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        DeliveryListActivity.this.cAO.ao(DeliveryListActivity.this.cAP);
                        DeliveryListActivity.this.aqj();
                        return;
                    default:
                        return;
                }
            }
        };
        com.baidu.swan.bdprivate.address.b.a.aqp().R(this.cAS);
        aqi();
    }

    private void aqc() {
        SwanAppBdActionBar bdActionBar = this.cAO.getBdActionBar();
        bdActionBar.setRightMenuVisibility(false);
        bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeliveryListActivity.this.finish();
            }
        });
        if (TextUtils.equals(this.cAK, "aiapp")) {
            bdActionBar.setTitle(b.g.delivery_title_choose);
        } else {
            bdActionBar.setTitle(b.g.delivery_title_list);
        }
        bdActionBar.setLeftFirstViewVisibility(true);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.cAT) {
            this.cAP = com.baidu.swan.bdprivate.address.b.a.aqp().aqs();
            this.cAO.ao(this.cAP);
        }
    }

    private void aqi() {
        List<com.baidu.swan.bdprivate.address.c.b> aqs = com.baidu.swan.bdprivate.address.b.a.aqp().aqs();
        if (aqs.size() > 0) {
            this.cAP = aqs;
            this.cAO.ao(this.cAP);
            aqj();
            return;
        }
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.4
            @Override // java.lang.Runnable
            public void run() {
                List<com.baidu.swan.bdprivate.address.c.b> aqq = com.baidu.swan.bdprivate.address.b.a.aqp().aqq();
                if (aqq != null && aqq.size() > 0) {
                    DeliveryListActivity.this.cAP = aqq;
                }
                DeliveryListActivity.this.cAR.sendEmptyMessage(1);
            }
        }, "loadDeliveryData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqj() {
        showLoading();
        if (TextUtils.equals(this.cAK, "aiapp")) {
            com.baidu.swan.bdprivate.a.a.a(this, new com.baidu.swan.apps.as.d.b<Bundle>() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: z */
                public void F(Bundle bundle) {
                    if (bundle != null) {
                        String string = bundle.getString("dev", "");
                        if (!TextUtils.isEmpty(string)) {
                            DeliveryListActivity.this.cAS.putString("stoken", string);
                            com.baidu.swan.bdprivate.address.b.a.aqp().R(DeliveryListActivity.this.cAS);
                            DeliveryListActivity.this.aqk();
                            return;
                        }
                    }
                    d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_token_error)).showToast();
                }
            }, "dev");
        } else {
            aqk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqk() {
        com.baidu.swan.bdprivate.address.b.a.aqp().a(new a.C0367a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.6
            @Override // com.baidu.swan.bdprivate.address.b.a.C0367a, com.baidu.swan.bdprivate.address.b.b
            public void aql() {
                DeliveryListActivity.this.aqg();
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0367a, com.baidu.swan.bdprivate.address.b.b
            public void c(List<com.baidu.swan.bdprivate.address.c.b> list, int i) {
                DeliveryListActivity.this.aj(list);
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0367a, com.baidu.swan.bdprivate.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_net_error)).showToast();
                if (DeliveryListActivity.this.cAP == null || DeliveryListActivity.this.cAP.size() == 0) {
                    DeliveryListActivity.this.cAO.e(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.6.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DeliveryListActivity.this.aqj();
                        }
                    });
                }
            }
        });
    }

    private void showLoading() {
        this.cAI.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqg() {
        if (this != null && !isFinishing()) {
            this.cAI.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(List<com.baidu.swan.bdprivate.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.cAO.ao(list);
            this.cAP = list;
        } else if (this.cAP == null || this.cAP.size() <= 0) {
            this.cAO.aqE();
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
            intent.putExtra("openSource", this.cAK);
            intent.setClass(this, DeliveryEditActivity.class);
            startActivityForResult(intent, oq(str));
        }
    }

    private int oq(String str) {
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
            this.cAT = intent.getBooleanExtra("dataChanged", false);
        }
    }

    @Override // com.baidu.swan.bdprivate.address.a.a.b
    public void onItemClick(int i) {
        if (this.cAP != null && i < this.cAP.size()) {
            com.baidu.swan.bdprivate.address.c.b bVar = this.cAP.get(i);
            if (TextUtils.equals(this.cAK, "main")) {
                a(bVar, i);
            }
            if (TextUtils.equals(this.cAK, "aiapp")) {
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
        com.baidu.swan.bdprivate.address.b.a.aqp().d(bVar2, new a.C0367a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.7
            @Override // com.baidu.swan.bdprivate.address.b.a.C0367a, com.baidu.swan.bdprivate.address.b.b
            public void R(String str, int i2) {
                for (int i3 = 0; i3 < DeliveryListActivity.this.cAP.size(); i3++) {
                    com.baidu.swan.bdprivate.address.c.b bVar3 = (com.baidu.swan.bdprivate.address.c.b) DeliveryListActivity.this.cAP.get(i3);
                    bVar3.cBK = false;
                    if (i3 == i) {
                        bVar3.cBK = true;
                    }
                }
                DeliveryListActivity.this.cAO.ao(DeliveryListActivity.this.cAP);
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0367a, com.baidu.swan.bdprivate.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_net_error)).showToast();
            }
        });
    }

    @Override // com.baidu.swan.bdprivate.address.a.a.b
    public void hx(final int i) {
        if (this.cAQ == null) {
            this.cAQ = new com.baidu.swan.bdprivate.widget.a(this.cAO);
            this.cAQ.setPopupWindowWidth(af.C(148.0f));
            this.cAQ.setLayoutInCenter(true);
            this.cAQ.u(0, b.g.delivery_delete, b.d.delivery_delete);
        }
        this.cAQ.a(new b.a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.8
            @Override // com.baidu.swan.apps.res.widget.a.b.a
            public void c(com.baidu.swan.apps.res.widget.a.b bVar) {
                switch (bVar.getItemId()) {
                    case 0:
                        DeliveryListActivity.this.hy(i);
                        return;
                    default:
                        return;
                }
            }
        });
        this.cAQ.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hy(final int i) {
        com.baidu.swan.bdprivate.address.c.b bVar;
        if (this.cAP != null && i < this.cAP.size() && (bVar = this.cAP.get(i)) != null && !TextUtils.isEmpty(bVar.id)) {
            final boolean z = bVar.cBK;
            com.baidu.swan.bdprivate.address.c.b bVar2 = new com.baidu.swan.bdprivate.address.c.b();
            bVar2.id = bVar.id;
            showLoading();
            com.baidu.swan.bdprivate.address.b.a.aqp().b(bVar2, new a.C0367a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.9
                @Override // com.baidu.swan.bdprivate.address.b.a.C0367a, com.baidu.swan.bdprivate.address.b.b
                public void aql() {
                    DeliveryListActivity.this.aqg();
                }

                @Override // com.baidu.swan.bdprivate.address.b.a.C0367a, com.baidu.swan.bdprivate.address.b.b
                public void S(String str, int i2) {
                    DeliveryListActivity.this.cAP.remove(i);
                    if (z && DeliveryListActivity.this.cAP.size() > 0) {
                        ((com.baidu.swan.bdprivate.address.c.b) DeliveryListActivity.this.cAP.get(0)).cBK = true;
                    }
                    DeliveryListActivity.this.cAT = true;
                    DeliveryListActivity.this.cAO.ao(DeliveryListActivity.this.cAP);
                }

                @Override // com.baidu.swan.bdprivate.address.b.a.C0367a, com.baidu.swan.bdprivate.address.b.b
                public void onFailure() {
                    d.a(AppRuntime.getAppContext(), "网络异常").showToast();
                }
            });
        }
    }

    private void o(Intent intent) {
        this.cAS = intent.getExtras();
        if (this.cAS == null) {
            this.cAS = new Bundle();
        }
        String string = this.cAS.getString("openSource");
        if (!TextUtils.isEmpty(string)) {
            this.cAK = string;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cAT) {
            com.baidu.swan.bdprivate.address.b.a.aqp().aqr();
        }
    }
}

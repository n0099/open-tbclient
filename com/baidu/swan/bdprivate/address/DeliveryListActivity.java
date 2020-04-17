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
    private com.baidu.swan.bdprivate.widget.b cAC;
    private String cAE;
    private ChooseAddressView cAI;
    private List<com.baidu.swan.bdprivate.address.c.b> cAJ = new ArrayList();
    private com.baidu.swan.bdprivate.widget.a cAK;
    private Handler cAL;
    private Bundle cAM;
    private boolean cAN;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        B(getIntent());
        aqi();
    }

    private void aqi() {
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
        this.cAI = new ChooseAddressView(this);
        setContentView(this.cAI);
        af.S(this);
        this.cAC = new com.baidu.swan.bdprivate.widget.b(this);
        this.cAC.setMessage("加载中...");
        this.cAC.setCancelable(true);
        aqd();
        this.cAI.setDeliveryChooseListener(this);
        this.cAL = new Handler() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        DeliveryListActivity.this.cAI.ao(DeliveryListActivity.this.cAJ);
                        DeliveryListActivity.this.aqk();
                        return;
                    default:
                        return;
                }
            }
        };
        com.baidu.swan.bdprivate.address.b.a.aqq().R(this.cAM);
        aqj();
    }

    private void aqd() {
        SwanAppBdActionBar bdActionBar = this.cAI.getBdActionBar();
        bdActionBar.setRightMenuVisibility(false);
        bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DeliveryListActivity.this.finish();
            }
        });
        if (TextUtils.equals(this.cAE, "aiapp")) {
            bdActionBar.setTitle(b.g.delivery_title_choose);
        } else {
            bdActionBar.setTitle(b.g.delivery_title_list);
        }
        bdActionBar.setLeftFirstViewVisibility(true);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.cAN) {
            this.cAJ = com.baidu.swan.bdprivate.address.b.a.aqq().aqt();
            this.cAI.ao(this.cAJ);
        }
    }

    private void aqj() {
        List<com.baidu.swan.bdprivate.address.c.b> aqt = com.baidu.swan.bdprivate.address.b.a.aqq().aqt();
        if (aqt.size() > 0) {
            this.cAJ = aqt;
            this.cAI.ao(this.cAJ);
            aqk();
            return;
        }
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.4
            @Override // java.lang.Runnable
            public void run() {
                List<com.baidu.swan.bdprivate.address.c.b> aqr = com.baidu.swan.bdprivate.address.b.a.aqq().aqr();
                if (aqr != null && aqr.size() > 0) {
                    DeliveryListActivity.this.cAJ = aqr;
                }
                DeliveryListActivity.this.cAL.sendEmptyMessage(1);
            }
        }, "loadDeliveryData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqk() {
        showLoading();
        if (TextUtils.equals(this.cAE, "aiapp")) {
            com.baidu.swan.bdprivate.a.a.a(this, new com.baidu.swan.apps.as.d.b<Bundle>() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: z */
                public void E(Bundle bundle) {
                    if (bundle != null) {
                        String string = bundle.getString("dev", "");
                        if (!TextUtils.isEmpty(string)) {
                            DeliveryListActivity.this.cAM.putString("stoken", string);
                            com.baidu.swan.bdprivate.address.b.a.aqq().R(DeliveryListActivity.this.cAM);
                            DeliveryListActivity.this.aql();
                            return;
                        }
                    }
                    d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_token_error)).showToast();
                }
            }, "dev");
        } else {
            aql();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aql() {
        com.baidu.swan.bdprivate.address.b.a.aqq().a(new a.C0346a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.6
            @Override // com.baidu.swan.bdprivate.address.b.a.C0346a, com.baidu.swan.bdprivate.address.b.b
            public void aqm() {
                DeliveryListActivity.this.aqh();
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0346a, com.baidu.swan.bdprivate.address.b.b
            public void c(List<com.baidu.swan.bdprivate.address.c.b> list, int i) {
                DeliveryListActivity.this.aj(list);
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0346a, com.baidu.swan.bdprivate.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_net_error)).showToast();
                if (DeliveryListActivity.this.cAJ == null || DeliveryListActivity.this.cAJ.size() == 0) {
                    DeliveryListActivity.this.cAI.e(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.6.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DeliveryListActivity.this.aqk();
                        }
                    });
                }
            }
        });
    }

    private void showLoading() {
        this.cAC.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqh() {
        if (this != null && !isFinishing()) {
            this.cAC.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(List<com.baidu.swan.bdprivate.address.c.b> list) {
        if (list != null && list.size() > 0) {
            this.cAI.ao(list);
            this.cAJ = list;
        } else if (this.cAJ == null || this.cAJ.size() <= 0) {
            this.cAI.aqF();
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
            intent.putExtra("openSource", this.cAE);
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
            this.cAN = intent.getBooleanExtra("dataChanged", false);
        }
    }

    @Override // com.baidu.swan.bdprivate.address.a.a.b
    public void onItemClick(int i) {
        if (this.cAJ != null && i < this.cAJ.size()) {
            com.baidu.swan.bdprivate.address.c.b bVar = this.cAJ.get(i);
            if (TextUtils.equals(this.cAE, "main")) {
                a(bVar, i);
            }
            if (TextUtils.equals(this.cAE, "aiapp")) {
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
        com.baidu.swan.bdprivate.address.b.a.aqq().d(bVar2, new a.C0346a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.7
            @Override // com.baidu.swan.bdprivate.address.b.a.C0346a, com.baidu.swan.bdprivate.address.b.b
            public void R(String str, int i2) {
                for (int i3 = 0; i3 < DeliveryListActivity.this.cAJ.size(); i3++) {
                    com.baidu.swan.bdprivate.address.c.b bVar3 = (com.baidu.swan.bdprivate.address.c.b) DeliveryListActivity.this.cAJ.get(i3);
                    bVar3.cBE = false;
                    if (i3 == i) {
                        bVar3.cBE = true;
                    }
                }
                DeliveryListActivity.this.cAI.ao(DeliveryListActivity.this.cAJ);
            }

            @Override // com.baidu.swan.bdprivate.address.b.a.C0346a, com.baidu.swan.bdprivate.address.b.b
            public void onFailure() {
                d.a(AppRuntime.getAppContext(), DeliveryListActivity.this.getResources().getString(b.g.delivery_net_error)).showToast();
            }
        });
    }

    @Override // com.baidu.swan.bdprivate.address.a.a.b
    public void hx(final int i) {
        if (this.cAK == null) {
            this.cAK = new com.baidu.swan.bdprivate.widget.a(this.cAI);
            this.cAK.setPopupWindowWidth(af.C(148.0f));
            this.cAK.setLayoutInCenter(true);
            this.cAK.u(0, b.g.delivery_delete, b.d.delivery_delete);
        }
        this.cAK.a(new b.a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.8
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
        this.cAK.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hy(final int i) {
        com.baidu.swan.bdprivate.address.c.b bVar;
        if (this.cAJ != null && i < this.cAJ.size() && (bVar = this.cAJ.get(i)) != null && !TextUtils.isEmpty(bVar.id)) {
            final boolean z = bVar.cBE;
            com.baidu.swan.bdprivate.address.c.b bVar2 = new com.baidu.swan.bdprivate.address.c.b();
            bVar2.id = bVar.id;
            showLoading();
            com.baidu.swan.bdprivate.address.b.a.aqq().b(bVar2, new a.C0346a() { // from class: com.baidu.swan.bdprivate.address.DeliveryListActivity.9
                @Override // com.baidu.swan.bdprivate.address.b.a.C0346a, com.baidu.swan.bdprivate.address.b.b
                public void aqm() {
                    DeliveryListActivity.this.aqh();
                }

                @Override // com.baidu.swan.bdprivate.address.b.a.C0346a, com.baidu.swan.bdprivate.address.b.b
                public void S(String str, int i2) {
                    DeliveryListActivity.this.cAJ.remove(i);
                    if (z && DeliveryListActivity.this.cAJ.size() > 0) {
                        ((com.baidu.swan.bdprivate.address.c.b) DeliveryListActivity.this.cAJ.get(0)).cBE = true;
                    }
                    DeliveryListActivity.this.cAN = true;
                    DeliveryListActivity.this.cAI.ao(DeliveryListActivity.this.cAJ);
                }

                @Override // com.baidu.swan.bdprivate.address.b.a.C0346a, com.baidu.swan.bdprivate.address.b.b
                public void onFailure() {
                    d.a(AppRuntime.getAppContext(), "网络异常").showToast();
                }
            });
        }
    }

    private void B(Intent intent) {
        this.cAM = intent.getExtras();
        if (this.cAM == null) {
            this.cAM = new Bundle();
        }
        String string = this.cAM.getString("openSource");
        if (!TextUtils.isEmpty(string)) {
            this.cAE = string;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cAN) {
            com.baidu.swan.bdprivate.address.b.a.aqq().aqs();
        }
    }
}

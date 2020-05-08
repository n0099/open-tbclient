package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.res.ui.CommonEmptyView;
import com.baidu.swan.apps.res.widget.a.b;
import com.baidu.swan.bdprivate.activity.BaseActivity;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.invoice.c;
import com.baidu.swan.bdprivate.invoice.d;
import com.baidu.swan.bdprivate.invoice.model.InvoiceInfo;
import com.baidu.swan.bdprivate.invoice.ui.a;
import com.baidu.swan.bdprivate.widget.SwanAppBdActionBar;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class InvoiceListActivity extends BaseActivity {
    private SwanAppBdActionBar cAL;
    private CommonEmptyView cBP;
    private RecyclerView cDM;
    private com.baidu.swan.bdprivate.invoice.ui.a cDN;
    private LinearLayout cDO;
    private View cDP;
    private Button cDQ;
    private RelativeLayout cDR;
    private String cDS;
    private String cbJ;
    private RecyclerView.LayoutManager mLayoutManager;
    private String mSource = "source_setting";
    private c.InterfaceC0372c cDT = new c.InterfaceC0372c() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.4
        @Override // com.baidu.swan.bdprivate.invoice.c.InterfaceC0372c
        public void aq(List<InvoiceInfo> list) {
            if (InvoiceListActivity.this.cDN != null) {
                InvoiceListActivity.this.Ow();
                InvoiceListActivity.this.cDN.ak(list);
                InvoiceListActivity.this.aqW();
            }
        }

        @Override // com.baidu.swan.bdprivate.invoice.c
        public void oA(String str) {
            InvoiceListActivity.this.n(true, false);
        }

        @Override // com.baidu.swan.bdprivate.invoice.c
        public void bH(String str, String str2) {
            InvoiceListActivity.this.bI(str, str2);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(b.f.activity_invoice_list);
        af.S(this);
        z(getIntent());
        aqV();
        initView();
    }

    private void z(Intent intent) {
        if (intent != null) {
            this.mSource = intent.getStringExtra("source");
            this.cbJ = intent.getStringExtra("appId");
            this.cDS = intent.getStringExtra("appKey");
        }
    }

    private void aqV() {
        this.cAL = (SwanAppBdActionBar) findViewById(b.e.bd_action_bar);
        this.cAL.setTitle(getString(b.g.invoice_info_activity_title));
        this.cAL.setLeftFirstViewVisibility(true);
        this.cAL.setRightMenuVisibility(false);
        this.cAL.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.finish();
            }
        });
    }

    private void initView() {
        this.cDR = (RelativeLayout) findViewById(b.e.root_container);
        this.cDM = (RecyclerView) findViewById(b.e.invoice_list_view);
        this.cDQ = (Button) findViewById(b.e.new_invoice_info_btn);
        this.cBP = (CommonEmptyView) findViewById(b.e.empty_view);
        this.cDO = (LinearLayout) findViewById(b.e.new_invoice_info_area);
        this.cDP = findViewById(b.e.new_invoice_info_divider_line);
        this.cDM.setBackground(getResources().getDrawable(b.C0369b.invoice_list_bg));
        this.cDO.setBackground(getResources().getDrawable(b.C0369b.invoice_create_new_btn_area));
        this.cDP.setBackground(getResources().getDrawable(b.C0369b.invoice_create_new_divider_line));
        this.cDQ.setTextColor(getResources().getColor(b.C0369b.invoice_create_new_btn_text));
        this.cDQ.setBackground(getResources().getDrawable(b.d.invoice_create_new_btn_bg));
        this.cDN = new com.baidu.swan.bdprivate.invoice.ui.a(this);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.cDM.setLayoutManager(this.mLayoutManager);
        this.cDM.setAdapter(this.cDN);
        aqW();
        this.cDN.a(new a.b() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.2
            @Override // com.baidu.swan.bdprivate.invoice.ui.a.b
            public void a(View view, InvoiceInfo invoiceInfo) {
                InvoiceListActivity.this.g(invoiceInfo);
            }

            @Override // com.baidu.swan.bdprivate.invoice.ui.a.b
            public void b(View view, InvoiceInfo invoiceInfo) {
                InvoiceListActivity.this.l(invoiceInfo);
            }

            @Override // com.baidu.swan.bdprivate.invoice.ui.a.b
            public void c(View view, InvoiceInfo invoiceInfo) {
                InvoiceListActivity.this.j(invoiceInfo);
            }
        });
        this.cDQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.aqZ();
            }
        });
        aqX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqW() {
        if (this.cBP != null) {
            this.cBP.setTitle(getString(b.g.invoice_empty_title));
            this.cBP.setIcon(b.d.empty_icon_document);
            if (this.cDN != null && this.cDN.getItemCount() > 0) {
                this.cBP.setVisibility(8);
            } else {
                this.cBP.setVisibility(0);
            }
        }
    }

    private void aqX() {
        if (com.baidu.swan.bdprivate.a.a.isLogin(this)) {
            aqY();
        } else {
            n(true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqY() {
        showLoadingView();
        if (TextUtils.equals(this.mSource, "source_ai_app")) {
            d.aqN().a(this, this.cbJ, this.cDS, this.cDT);
        } else {
            d.aqN().a(this.cDT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z, boolean z2) {
        Ow();
        com.baidu.swan.bdprivate.invoice.a.a(this, new a(this, z, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(String str, String str2) {
        Ow();
        com.baidu.swan.bdprivate.invoice.a.q(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this, this.cDR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ow() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.cDR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(InvoiceInfo invoiceInfo) {
        if (TextUtils.equals(this.mSource, "source_ai_app")) {
            com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "选择发票");
            Intent intent = new Intent();
            intent.putExtra("invoiceInfo", h(invoiceInfo).toString());
            setResult(-1, intent);
            finish();
        } else if (invoiceInfo != null && invoiceInfo.mIsDefault != 1) {
            i(invoiceInfo);
        }
    }

    private JSONObject h(InvoiceInfo invoiceInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", invoiceInfo.mType + "");
            jSONObject.put("title", invoiceInfo.mTitle);
            jSONObject.put("taxNumber", invoiceInfo.mTaxNumber);
            jSONObject.put("companyAddress", invoiceInfo.mCompanyAddress);
            jSONObject.put(InvoiceInfo.KEY_TELEPHONE, invoiceInfo.mTelephone);
            jSONObject.put("bankName", invoiceInfo.mBankName);
            jSONObject.put("bankAccount", invoiceInfo.mBankAccount);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private void i(final InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aqN().a(invoiceInfo.mId, new c.d() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.5
                @Override // com.baidu.swan.bdprivate.invoice.c.d
                public void bs(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票成功");
                    if (InvoiceListActivity.this.cDN != null) {
                        InvoiceListActivity.this.Ow();
                        InvoiceListActivity.this.cDN.bu(invoiceInfo.mId);
                    }
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void oA(String str) {
                    InvoiceListActivity.this.n(false, false);
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void bH(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票失败");
                    InvoiceListActivity.this.bI(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final InvoiceInfo invoiceInfo) {
        com.baidu.swan.bdprivate.widget.a aVar = new com.baidu.swan.bdprivate.widget.a(this.cDM);
        aVar.u(0, b.g.invoice_menu_delete, b.d.menu_delete);
        aVar.a(new b.a() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.6
            @Override // com.baidu.swan.apps.res.widget.a.b.a
            public void c(com.baidu.swan.apps.res.widget.a.b bVar) {
                if (bVar != null && bVar.getItemId() == 0) {
                    InvoiceListActivity.this.k(invoiceInfo);
                }
            }
        });
        aVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(final InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aqN().a(invoiceInfo.mId, new c.b() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.7
                @Override // com.baidu.swan.bdprivate.invoice.c.b
                public void br(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票成功");
                    if (InvoiceListActivity.this.cDN != null) {
                        InvoiceListActivity.this.Ow();
                        InvoiceListActivity.this.cDN.bt(invoiceInfo.mId);
                        if (invoiceInfo.mIsDefault == 1) {
                            InvoiceListActivity.this.cDN.bu(j);
                        }
                        InvoiceListActivity.this.aqW();
                    }
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void oA(String str) {
                    InvoiceListActivity.this.n(false, false);
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void bH(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票失败");
                    InvoiceListActivity.this.bI(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(InvoiceInfo invoiceInfo) {
        Intent intent = new Intent(this, InvoiceEditActivity.class);
        intent.putExtra("type", 0);
        intent.putExtra("invoice", invoiceInfo);
        startActivityForResult(intent, 10002);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqZ() {
        Intent intent = new Intent(this, InvoiceEditActivity.class);
        intent.putExtra("type", 1);
        startActivityForResult(intent, 10001);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            InvoiceInfo invoiceInfo = null;
            if (intent != null) {
                invoiceInfo = (InvoiceInfo) intent.getParcelableExtra("invoice");
            }
            switch (i) {
                case 10001:
                    com.baidu.swan.apps.res.widget.b.d.k(this, b.g.invoice_toast_create_success).showToast();
                    if (this.cDN != null && invoiceInfo != null) {
                        this.cDN.m(invoiceInfo);
                        aqW();
                        break;
                    }
                    break;
                case 10002:
                    if (this.cDN != null && invoiceInfo != null) {
                        this.cDN.n(invoiceInfo);
                        break;
                    }
                    break;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a implements com.baidu.swan.apps.a.a {
        private WeakReference<InvoiceListActivity> cDW;
        private boolean cDX;
        private boolean cDY;

        public a(InvoiceListActivity invoiceListActivity, boolean z, boolean z2) {
            this.cDW = new WeakReference<>(invoiceListActivity);
            this.cDX = z;
            this.cDY = z2;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            InvoiceListActivity invoiceListActivity = this.cDW.get();
            if (invoiceListActivity != null) {
                if (com.baidu.swan.bdprivate.a.a.isLogin(invoiceListActivity)) {
                    if (this.cDX) {
                        invoiceListActivity.aqY();
                    }
                } else if (this.cDY) {
                    invoiceListActivity.finish();
                }
            }
        }
    }
}

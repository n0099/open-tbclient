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
import com.baidu.sapi2.activity.SlideActiviy;
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
/* loaded from: classes9.dex */
public class InvoiceListActivity extends BaseActivity {
    private SwanAppBdActionBar bXb;
    private CommonEmptyView bYf;
    private String bxY;
    private RecyclerView cad;
    private com.baidu.swan.bdprivate.invoice.ui.a cae;
    private LinearLayout caf;
    private View cag;
    private Button cah;
    private RelativeLayout cai;
    private String caj;
    private RecyclerView.LayoutManager mLayoutManager;
    private String mSource = "source_setting";
    private c.InterfaceC0309c cak = new c.InterfaceC0309c() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.4
        @Override // com.baidu.swan.bdprivate.invoice.c.InterfaceC0309c
        public void aj(List<InvoiceInfo> list) {
            if (InvoiceListActivity.this.cae != null) {
                InvoiceListActivity.this.DS();
                InvoiceListActivity.this.cae.ad(list);
                InvoiceListActivity.this.agd();
            }
        }

        @Override // com.baidu.swan.bdprivate.invoice.c
        public void mU(String str) {
            InvoiceListActivity.this.m(true, false);
        }

        @Override // com.baidu.swan.bdprivate.invoice.c
        public void bn(String str, String str2) {
            InvoiceListActivity.this.bo(str, str2);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(b.f.activity_invoice_list);
        af.U(this);
        N(getIntent());
        agc();
        initView();
    }

    private void N(Intent intent) {
        if (intent != null) {
            this.mSource = intent.getStringExtra("source");
            this.bxY = intent.getStringExtra("appId");
            this.caj = intent.getStringExtra("appKey");
        }
    }

    private void agc() {
        this.bXb = (SwanAppBdActionBar) findViewById(b.e.bd_action_bar);
        this.bXb.setTitle(getString(b.g.invoice_info_activity_title));
        this.bXb.setLeftFirstViewVisibility(true);
        this.bXb.setRightMenuVisibility(false);
        this.bXb.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.finish();
            }
        });
    }

    private void initView() {
        this.cai = (RelativeLayout) findViewById(b.e.root_container);
        this.cad = (RecyclerView) findViewById(b.e.invoice_list_view);
        this.cah = (Button) findViewById(b.e.new_invoice_info_btn);
        this.bYf = (CommonEmptyView) findViewById(b.e.empty_view);
        this.caf = (LinearLayout) findViewById(b.e.new_invoice_info_area);
        this.cag = findViewById(b.e.new_invoice_info_divider_line);
        this.cad.setBackground(getResources().getDrawable(b.C0306b.invoice_list_bg));
        this.caf.setBackground(getResources().getDrawable(b.C0306b.invoice_create_new_btn_area));
        this.cag.setBackground(getResources().getDrawable(b.C0306b.invoice_create_new_divider_line));
        this.cah.setTextColor(getResources().getColor(b.C0306b.invoice_create_new_btn_text));
        this.cah.setBackground(getResources().getDrawable(b.d.invoice_create_new_btn_bg));
        this.cae = new com.baidu.swan.bdprivate.invoice.ui.a(this);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.cad.setLayoutManager(this.mLayoutManager);
        this.cad.setAdapter(this.cae);
        agd();
        this.cae.a(new a.b() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.2
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
        this.cah.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.agg();
            }
        });
        age();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agd() {
        if (this.bYf != null) {
            this.bYf.setTitle(getString(b.g.invoice_empty_title));
            this.bYf.setIcon(b.d.empty_icon_document);
            if (this.cae != null && this.cae.getItemCount() > 0) {
                this.bYf.setVisibility(8);
            } else {
                this.bYf.setVisibility(0);
            }
        }
    }

    private void age() {
        if (com.baidu.swan.bdprivate.a.a.isLogin(this)) {
            agf();
        } else {
            m(true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agf() {
        showLoadingView();
        if (TextUtils.equals(this.mSource, "source_ai_app")) {
            d.afU().a(this, this.bxY, this.caj, this.cak);
        } else {
            d.afU().a(this.cak);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z, boolean z2) {
        DS();
        com.baidu.swan.bdprivate.invoice.a.a(this, new a(this, z, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(String str, String str2) {
        DS();
        com.baidu.swan.bdprivate.invoice.a.o(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this, this.cai);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DS() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.cai);
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
            d.afU().a(invoiceInfo.mId, new c.d() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.5
                @Override // com.baidu.swan.bdprivate.invoice.c.d
                public void aG(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票成功");
                    if (InvoiceListActivity.this.cae != null) {
                        InvoiceListActivity.this.DS();
                        InvoiceListActivity.this.cae.aI(invoiceInfo.mId);
                    }
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void mU(String str) {
                    InvoiceListActivity.this.m(false, false);
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void bn(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票失败");
                    InvoiceListActivity.this.bo(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final InvoiceInfo invoiceInfo) {
        com.baidu.swan.bdprivate.widget.a aVar = new com.baidu.swan.bdprivate.widget.a(this.cad);
        aVar.r(0, b.g.invoice_menu_delete, b.d.menu_delete);
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
            d.afU().a(invoiceInfo.mId, new c.b() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.7
                @Override // com.baidu.swan.bdprivate.invoice.c.b
                public void aF(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票成功");
                    if (InvoiceListActivity.this.cae != null) {
                        InvoiceListActivity.this.DS();
                        InvoiceListActivity.this.cae.aH(invoiceInfo.mId);
                        if (invoiceInfo.mIsDefault == 1) {
                            InvoiceListActivity.this.cae.aI(j);
                        }
                        InvoiceListActivity.this.agd();
                    }
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void mU(String str) {
                    InvoiceListActivity.this.m(false, false);
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void bn(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票失败");
                    InvoiceListActivity.this.bo(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(InvoiceInfo invoiceInfo) {
        Intent intent = new Intent(this, InvoiceEditActivity.class);
        intent.putExtra("type", 0);
        intent.putExtra(SlideActiviy.INVOICE_PAGE_NAME, invoiceInfo);
        startActivityForResult(intent, 10002);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agg() {
        Intent intent = new Intent(this, InvoiceEditActivity.class);
        intent.putExtra("type", 1);
        startActivityForResult(intent, 10001);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            InvoiceInfo invoiceInfo = null;
            if (intent != null) {
                invoiceInfo = (InvoiceInfo) intent.getParcelableExtra(SlideActiviy.INVOICE_PAGE_NAME);
            }
            switch (i) {
                case 10001:
                    com.baidu.swan.apps.res.widget.b.d.q(this, b.g.invoice_toast_create_success).showToast();
                    if (this.cae != null && invoiceInfo != null) {
                        this.cae.m(invoiceInfo);
                        agd();
                        break;
                    }
                    break;
                case 10002:
                    if (this.cae != null && invoiceInfo != null) {
                        this.cae.n(invoiceInfo);
                        break;
                    }
                    break;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a implements com.baidu.swan.apps.a.a {
        private WeakReference<InvoiceListActivity> can;
        private boolean cao;
        private boolean cap;

        public a(InvoiceListActivity invoiceListActivity, boolean z, boolean z2) {
            this.can = new WeakReference<>(invoiceListActivity);
            this.cao = z;
            this.cap = z2;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            InvoiceListActivity invoiceListActivity = this.can.get();
            if (invoiceListActivity != null) {
                if (com.baidu.swan.bdprivate.a.a.isLogin(invoiceListActivity)) {
                    if (this.cao) {
                        invoiceListActivity.agf();
                    }
                } else if (this.cap) {
                    invoiceListActivity.finish();
                }
            }
        }
    }
}

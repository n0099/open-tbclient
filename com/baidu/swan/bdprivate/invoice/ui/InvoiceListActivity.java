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
/* loaded from: classes11.dex */
public class InvoiceListActivity extends BaseActivity {
    private String bCU;
    private SwanAppBdActionBar cbt;
    private CommonEmptyView ccy;
    private View ceA;
    private Button ceB;
    private RelativeLayout ceC;
    private String ceD;
    private RecyclerView cex;
    private com.baidu.swan.bdprivate.invoice.ui.a cey;
    private LinearLayout cez;
    private RecyclerView.LayoutManager mLayoutManager;
    private String mSource = "source_setting";
    private c.InterfaceC0321c ceE = new c.InterfaceC0321c() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.4
        @Override // com.baidu.swan.bdprivate.invoice.c.InterfaceC0321c
        public void ai(List<InvoiceInfo> list) {
            if (InvoiceListActivity.this.cey != null) {
                InvoiceListActivity.this.GF();
                InvoiceListActivity.this.cey.ac(list);
                InvoiceListActivity.this.aiM();
            }
        }

        @Override // com.baidu.swan.bdprivate.invoice.c
        public void nm(String str) {
            InvoiceListActivity.this.o(true, false);
        }

        @Override // com.baidu.swan.bdprivate.invoice.c
        public void bx(String str, String str2) {
            InvoiceListActivity.this.by(str, str2);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(b.f.activity_invoice_list);
        af.W(this);
        N(getIntent());
        aiL();
        initView();
    }

    private void N(Intent intent) {
        if (intent != null) {
            this.mSource = intent.getStringExtra("source");
            this.bCU = intent.getStringExtra("appId");
            this.ceD = intent.getStringExtra("appKey");
        }
    }

    private void aiL() {
        this.cbt = (SwanAppBdActionBar) findViewById(b.e.bd_action_bar);
        this.cbt.setTitle(getString(b.g.invoice_info_activity_title));
        this.cbt.setLeftFirstViewVisibility(true);
        this.cbt.setRightMenuVisibility(false);
        this.cbt.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.finish();
            }
        });
    }

    private void initView() {
        this.ceC = (RelativeLayout) findViewById(b.e.root_container);
        this.cex = (RecyclerView) findViewById(b.e.invoice_list_view);
        this.ceB = (Button) findViewById(b.e.new_invoice_info_btn);
        this.ccy = (CommonEmptyView) findViewById(b.e.empty_view);
        this.cez = (LinearLayout) findViewById(b.e.new_invoice_info_area);
        this.ceA = findViewById(b.e.new_invoice_info_divider_line);
        this.cex.setBackground(getResources().getDrawable(b.C0318b.invoice_list_bg));
        this.cez.setBackground(getResources().getDrawable(b.C0318b.invoice_create_new_btn_area));
        this.ceA.setBackground(getResources().getDrawable(b.C0318b.invoice_create_new_divider_line));
        this.ceB.setTextColor(getResources().getColor(b.C0318b.invoice_create_new_btn_text));
        this.ceB.setBackground(getResources().getDrawable(b.d.invoice_create_new_btn_bg));
        this.cey = new com.baidu.swan.bdprivate.invoice.ui.a(this);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.cex.setLayoutManager(this.mLayoutManager);
        this.cex.setAdapter(this.cey);
        aiM();
        this.cey.a(new a.b() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.2
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
        this.ceB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.aiP();
            }
        });
        aiN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiM() {
        if (this.ccy != null) {
            this.ccy.setTitle(getString(b.g.invoice_empty_title));
            this.ccy.setIcon(b.d.empty_icon_document);
            if (this.cey != null && this.cey.getItemCount() > 0) {
                this.ccy.setVisibility(8);
            } else {
                this.ccy.setVisibility(0);
            }
        }
    }

    private void aiN() {
        if (com.baidu.swan.bdprivate.a.a.isLogin(this)) {
            aiO();
        } else {
            o(true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiO() {
        showLoadingView();
        if (TextUtils.equals(this.mSource, "source_ai_app")) {
            d.aiD().a(this, this.bCU, this.ceD, this.ceE);
        } else {
            d.aiD().a(this.ceE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, boolean z2) {
        GF();
        com.baidu.swan.bdprivate.invoice.a.a(this, new a(this, z, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(String str, String str2) {
        GF();
        com.baidu.swan.bdprivate.invoice.a.o(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this, this.ceC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GF() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.ceC);
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
            d.aiD().a(invoiceInfo.mId, new c.d() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.5
                @Override // com.baidu.swan.bdprivate.invoice.c.d
                public void aN(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票成功");
                    if (InvoiceListActivity.this.cey != null) {
                        InvoiceListActivity.this.GF();
                        InvoiceListActivity.this.cey.aP(invoiceInfo.mId);
                    }
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void nm(String str) {
                    InvoiceListActivity.this.o(false, false);
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void bx(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票失败");
                    InvoiceListActivity.this.by(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final InvoiceInfo invoiceInfo) {
        com.baidu.swan.bdprivate.widget.a aVar = new com.baidu.swan.bdprivate.widget.a(this.cex);
        aVar.s(0, b.g.invoice_menu_delete, b.d.menu_delete);
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
            d.aiD().a(invoiceInfo.mId, new c.b() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.7
                @Override // com.baidu.swan.bdprivate.invoice.c.b
                public void aM(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票成功");
                    if (InvoiceListActivity.this.cey != null) {
                        InvoiceListActivity.this.GF();
                        InvoiceListActivity.this.cey.aO(invoiceInfo.mId);
                        if (invoiceInfo.mIsDefault == 1) {
                            InvoiceListActivity.this.cey.aP(j);
                        }
                        InvoiceListActivity.this.aiM();
                    }
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void nm(String str) {
                    InvoiceListActivity.this.o(false, false);
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void bx(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票失败");
                    InvoiceListActivity.this.by(str, str2);
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
    public void aiP() {
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
                    if (this.cey != null && invoiceInfo != null) {
                        this.cey.m(invoiceInfo);
                        aiM();
                        break;
                    }
                    break;
                case 10002:
                    if (this.cey != null && invoiceInfo != null) {
                        this.cey.n(invoiceInfo);
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
        private WeakReference<InvoiceListActivity> ceH;
        private boolean ceI;
        private boolean ceJ;

        public a(InvoiceListActivity invoiceListActivity, boolean z, boolean z2) {
            this.ceH = new WeakReference<>(invoiceListActivity);
            this.ceI = z;
            this.ceJ = z2;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            InvoiceListActivity invoiceListActivity = this.ceH.get();
            if (invoiceListActivity != null) {
                if (com.baidu.swan.bdprivate.a.a.isLogin(invoiceListActivity)) {
                    if (this.ceI) {
                        invoiceListActivity.aiO();
                    }
                } else if (this.ceJ) {
                    invoiceListActivity.finish();
                }
            }
        }
    }
}

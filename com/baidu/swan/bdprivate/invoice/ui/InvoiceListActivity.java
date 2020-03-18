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
    private String bDf;
    private SwanAppBdActionBar cbE;
    private CommonEmptyView ccJ;
    private RecyclerView ceI;
    private com.baidu.swan.bdprivate.invoice.ui.a ceJ;
    private LinearLayout ceK;
    private View ceL;
    private Button ceM;
    private RelativeLayout ceN;
    private String ceO;
    private RecyclerView.LayoutManager mLayoutManager;
    private String mSource = "source_setting";
    private c.InterfaceC0321c ceP = new c.InterfaceC0321c() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.4
        @Override // com.baidu.swan.bdprivate.invoice.c.InterfaceC0321c
        public void ai(List<InvoiceInfo> list) {
            if (InvoiceListActivity.this.ceJ != null) {
                InvoiceListActivity.this.GK();
                InvoiceListActivity.this.ceJ.ac(list);
                InvoiceListActivity.this.aiP();
            }
        }

        @Override // com.baidu.swan.bdprivate.invoice.c
        public void nl(String str) {
            InvoiceListActivity.this.o(true, false);
        }

        @Override // com.baidu.swan.bdprivate.invoice.c
        public void bw(String str, String str2) {
            InvoiceListActivity.this.bx(str, str2);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(b.f.activity_invoice_list);
        af.W(this);
        N(getIntent());
        aiO();
        initView();
    }

    private void N(Intent intent) {
        if (intent != null) {
            this.mSource = intent.getStringExtra("source");
            this.bDf = intent.getStringExtra("appId");
            this.ceO = intent.getStringExtra("appKey");
        }
    }

    private void aiO() {
        this.cbE = (SwanAppBdActionBar) findViewById(b.e.bd_action_bar);
        this.cbE.setTitle(getString(b.g.invoice_info_activity_title));
        this.cbE.setLeftFirstViewVisibility(true);
        this.cbE.setRightMenuVisibility(false);
        this.cbE.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.finish();
            }
        });
    }

    private void initView() {
        this.ceN = (RelativeLayout) findViewById(b.e.root_container);
        this.ceI = (RecyclerView) findViewById(b.e.invoice_list_view);
        this.ceM = (Button) findViewById(b.e.new_invoice_info_btn);
        this.ccJ = (CommonEmptyView) findViewById(b.e.empty_view);
        this.ceK = (LinearLayout) findViewById(b.e.new_invoice_info_area);
        this.ceL = findViewById(b.e.new_invoice_info_divider_line);
        this.ceI.setBackground(getResources().getDrawable(b.C0318b.invoice_list_bg));
        this.ceK.setBackground(getResources().getDrawable(b.C0318b.invoice_create_new_btn_area));
        this.ceL.setBackground(getResources().getDrawable(b.C0318b.invoice_create_new_divider_line));
        this.ceM.setTextColor(getResources().getColor(b.C0318b.invoice_create_new_btn_text));
        this.ceM.setBackground(getResources().getDrawable(b.d.invoice_create_new_btn_bg));
        this.ceJ = new com.baidu.swan.bdprivate.invoice.ui.a(this);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.ceI.setLayoutManager(this.mLayoutManager);
        this.ceI.setAdapter(this.ceJ);
        aiP();
        this.ceJ.a(new a.b() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.2
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
        this.ceM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.aiS();
            }
        });
        aiQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiP() {
        if (this.ccJ != null) {
            this.ccJ.setTitle(getString(b.g.invoice_empty_title));
            this.ccJ.setIcon(b.d.empty_icon_document);
            if (this.ceJ != null && this.ceJ.getItemCount() > 0) {
                this.ccJ.setVisibility(8);
            } else {
                this.ccJ.setVisibility(0);
            }
        }
    }

    private void aiQ() {
        if (com.baidu.swan.bdprivate.a.a.isLogin(this)) {
            aiR();
        } else {
            o(true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiR() {
        showLoadingView();
        if (TextUtils.equals(this.mSource, "source_ai_app")) {
            d.aiG().a(this, this.bDf, this.ceO, this.ceP);
        } else {
            d.aiG().a(this.ceP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, boolean z2) {
        GK();
        com.baidu.swan.bdprivate.invoice.a.a(this, new a(this, z, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(String str, String str2) {
        GK();
        com.baidu.swan.bdprivate.invoice.a.o(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this, this.ceN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GK() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.ceN);
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
            d.aiG().a(invoiceInfo.mId, new c.d() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.5
                @Override // com.baidu.swan.bdprivate.invoice.c.d
                public void aN(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票成功");
                    if (InvoiceListActivity.this.ceJ != null) {
                        InvoiceListActivity.this.GK();
                        InvoiceListActivity.this.ceJ.aP(invoiceInfo.mId);
                    }
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void nl(String str) {
                    InvoiceListActivity.this.o(false, false);
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void bw(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票失败");
                    InvoiceListActivity.this.bx(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final InvoiceInfo invoiceInfo) {
        com.baidu.swan.bdprivate.widget.a aVar = new com.baidu.swan.bdprivate.widget.a(this.ceI);
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
            d.aiG().a(invoiceInfo.mId, new c.b() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.7
                @Override // com.baidu.swan.bdprivate.invoice.c.b
                public void aM(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票成功");
                    if (InvoiceListActivity.this.ceJ != null) {
                        InvoiceListActivity.this.GK();
                        InvoiceListActivity.this.ceJ.aO(invoiceInfo.mId);
                        if (invoiceInfo.mIsDefault == 1) {
                            InvoiceListActivity.this.ceJ.aP(j);
                        }
                        InvoiceListActivity.this.aiP();
                    }
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void nl(String str) {
                    InvoiceListActivity.this.o(false, false);
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void bw(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票失败");
                    InvoiceListActivity.this.bx(str, str2);
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
    public void aiS() {
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
                    if (this.ceJ != null && invoiceInfo != null) {
                        this.ceJ.m(invoiceInfo);
                        aiP();
                        break;
                    }
                    break;
                case 10002:
                    if (this.ceJ != null && invoiceInfo != null) {
                        this.ceJ.n(invoiceInfo);
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
        private WeakReference<InvoiceListActivity> ceS;
        private boolean ceT;
        private boolean ceU;

        public a(InvoiceListActivity invoiceListActivity, boolean z, boolean z2) {
            this.ceS = new WeakReference<>(invoiceListActivity);
            this.ceT = z;
            this.ceU = z2;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            InvoiceListActivity invoiceListActivity = this.ceS.get();
            if (invoiceListActivity != null) {
                if (com.baidu.swan.bdprivate.a.a.isLogin(invoiceListActivity)) {
                    if (this.ceT) {
                        invoiceListActivity.aiR();
                    }
                } else if (this.ceU) {
                    invoiceListActivity.finish();
                }
            }
        }
    }
}

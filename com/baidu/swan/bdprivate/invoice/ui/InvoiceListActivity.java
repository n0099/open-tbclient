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
    private SwanAppBdActionBar cAF;
    private CommonEmptyView cBJ;
    private RecyclerView cDG;
    private com.baidu.swan.bdprivate.invoice.ui.a cDH;
    private LinearLayout cDI;
    private View cDJ;
    private Button cDK;
    private RelativeLayout cDL;
    private String cDM;
    private String cbD;
    private RecyclerView.LayoutManager mLayoutManager;
    private String mSource = "source_setting";
    private c.InterfaceC0351c cDN = new c.InterfaceC0351c() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.4
        @Override // com.baidu.swan.bdprivate.invoice.c.InterfaceC0351c
        public void aq(List<InvoiceInfo> list) {
            if (InvoiceListActivity.this.cDH != null) {
                InvoiceListActivity.this.Ox();
                InvoiceListActivity.this.cDH.ak(list);
                InvoiceListActivity.this.aqX();
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
        M(getIntent());
        aqW();
        initView();
    }

    private void M(Intent intent) {
        if (intent != null) {
            this.mSource = intent.getStringExtra("source");
            this.cbD = intent.getStringExtra("appId");
            this.cDM = intent.getStringExtra("appKey");
        }
    }

    private void aqW() {
        this.cAF = (SwanAppBdActionBar) findViewById(b.e.bd_action_bar);
        this.cAF.setTitle(getString(b.g.invoice_info_activity_title));
        this.cAF.setLeftFirstViewVisibility(true);
        this.cAF.setRightMenuVisibility(false);
        this.cAF.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.finish();
            }
        });
    }

    private void initView() {
        this.cDL = (RelativeLayout) findViewById(b.e.root_container);
        this.cDG = (RecyclerView) findViewById(b.e.invoice_list_view);
        this.cDK = (Button) findViewById(b.e.new_invoice_info_btn);
        this.cBJ = (CommonEmptyView) findViewById(b.e.empty_view);
        this.cDI = (LinearLayout) findViewById(b.e.new_invoice_info_area);
        this.cDJ = findViewById(b.e.new_invoice_info_divider_line);
        this.cDG.setBackground(getResources().getDrawable(b.C0348b.invoice_list_bg));
        this.cDI.setBackground(getResources().getDrawable(b.C0348b.invoice_create_new_btn_area));
        this.cDJ.setBackground(getResources().getDrawable(b.C0348b.invoice_create_new_divider_line));
        this.cDK.setTextColor(getResources().getColor(b.C0348b.invoice_create_new_btn_text));
        this.cDK.setBackground(getResources().getDrawable(b.d.invoice_create_new_btn_bg));
        this.cDH = new com.baidu.swan.bdprivate.invoice.ui.a(this);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.cDG.setLayoutManager(this.mLayoutManager);
        this.cDG.setAdapter(this.cDH);
        aqX();
        this.cDH.a(new a.b() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.2
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
        this.cDK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.ara();
            }
        });
        aqY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqX() {
        if (this.cBJ != null) {
            this.cBJ.setTitle(getString(b.g.invoice_empty_title));
            this.cBJ.setIcon(b.d.empty_icon_document);
            if (this.cDH != null && this.cDH.getItemCount() > 0) {
                this.cBJ.setVisibility(8);
            } else {
                this.cBJ.setVisibility(0);
            }
        }
    }

    private void aqY() {
        if (com.baidu.swan.bdprivate.a.a.isLogin(this)) {
            aqZ();
        } else {
            n(true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqZ() {
        showLoadingView();
        if (TextUtils.equals(this.mSource, "source_ai_app")) {
            d.aqO().a(this, this.cbD, this.cDM, this.cDN);
        } else {
            d.aqO().a(this.cDN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z, boolean z2) {
        Ox();
        com.baidu.swan.bdprivate.invoice.a.a(this, new a(this, z, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(String str, String str2) {
        Ox();
        com.baidu.swan.bdprivate.invoice.a.o(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this, this.cDL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ox() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.cDL);
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
            d.aqO().a(invoiceInfo.mId, new c.d() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.5
                @Override // com.baidu.swan.bdprivate.invoice.c.d
                public void bs(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票成功");
                    if (InvoiceListActivity.this.cDH != null) {
                        InvoiceListActivity.this.Ox();
                        InvoiceListActivity.this.cDH.bu(invoiceInfo.mId);
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
        com.baidu.swan.bdprivate.widget.a aVar = new com.baidu.swan.bdprivate.widget.a(this.cDG);
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
            d.aqO().a(invoiceInfo.mId, new c.b() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.7
                @Override // com.baidu.swan.bdprivate.invoice.c.b
                public void br(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票成功");
                    if (InvoiceListActivity.this.cDH != null) {
                        InvoiceListActivity.this.Ox();
                        InvoiceListActivity.this.cDH.bt(invoiceInfo.mId);
                        if (invoiceInfo.mIsDefault == 1) {
                            InvoiceListActivity.this.cDH.bu(j);
                        }
                        InvoiceListActivity.this.aqX();
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
        intent.putExtra(SlideActiviy.INVOICE_PAGE_NAME, invoiceInfo);
        startActivityForResult(intent, 10002);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ara() {
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
                    com.baidu.swan.apps.res.widget.b.d.k(this, b.g.invoice_toast_create_success).showToast();
                    if (this.cDH != null && invoiceInfo != null) {
                        this.cDH.m(invoiceInfo);
                        aqX();
                        break;
                    }
                    break;
                case 10002:
                    if (this.cDH != null && invoiceInfo != null) {
                        this.cDH.n(invoiceInfo);
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
        private WeakReference<InvoiceListActivity> cDQ;
        private boolean cDR;
        private boolean cDS;

        public a(InvoiceListActivity invoiceListActivity, boolean z, boolean z2) {
            this.cDQ = new WeakReference<>(invoiceListActivity);
            this.cDR = z;
            this.cDS = z2;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            InvoiceListActivity invoiceListActivity = this.cDQ.get();
            if (invoiceListActivity != null) {
                if (com.baidu.swan.bdprivate.a.a.isLogin(invoiceListActivity)) {
                    if (this.cDR) {
                        invoiceListActivity.aqZ();
                    }
                } else if (this.cDS) {
                    invoiceListActivity.finish();
                }
            }
        }
    }
}

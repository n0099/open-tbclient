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
/* loaded from: classes10.dex */
public class InvoiceListActivity extends BaseActivity {
    private SwanAppBdActionBar bXn;
    private CommonEmptyView bYr;
    private String byL;
    private RecyclerView cap;
    private com.baidu.swan.bdprivate.invoice.ui.a caq;
    private LinearLayout car;
    private View cas;
    private Button cat;
    private RelativeLayout cau;
    private String cav;
    private RecyclerView.LayoutManager mLayoutManager;
    private String mSource = "source_setting";
    private c.InterfaceC0311c caw = new c.InterfaceC0311c() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.4
        @Override // com.baidu.swan.bdprivate.invoice.c.InterfaceC0311c
        public void ai(List<InvoiceInfo> list) {
            if (InvoiceListActivity.this.caq != null) {
                InvoiceListActivity.this.Eo();
                InvoiceListActivity.this.caq.ac(list);
                InvoiceListActivity.this.agw();
            }
        }

        @Override // com.baidu.swan.bdprivate.invoice.c
        public void mX(String str) {
            InvoiceListActivity.this.l(true, false);
        }

        @Override // com.baidu.swan.bdprivate.invoice.c
        public void bo(String str, String str2) {
            InvoiceListActivity.this.bp(str, str2);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(b.f.activity_invoice_list);
        af.V(this);
        N(getIntent());
        agv();
        initView();
    }

    private void N(Intent intent) {
        if (intent != null) {
            this.mSource = intent.getStringExtra("source");
            this.byL = intent.getStringExtra("appId");
            this.cav = intent.getStringExtra("appKey");
        }
    }

    private void agv() {
        this.bXn = (SwanAppBdActionBar) findViewById(b.e.bd_action_bar);
        this.bXn.setTitle(getString(b.g.invoice_info_activity_title));
        this.bXn.setLeftFirstViewVisibility(true);
        this.bXn.setRightMenuVisibility(false);
        this.bXn.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.finish();
            }
        });
    }

    private void initView() {
        this.cau = (RelativeLayout) findViewById(b.e.root_container);
        this.cap = (RecyclerView) findViewById(b.e.invoice_list_view);
        this.cat = (Button) findViewById(b.e.new_invoice_info_btn);
        this.bYr = (CommonEmptyView) findViewById(b.e.empty_view);
        this.car = (LinearLayout) findViewById(b.e.new_invoice_info_area);
        this.cas = findViewById(b.e.new_invoice_info_divider_line);
        this.cap.setBackground(getResources().getDrawable(b.C0308b.invoice_list_bg));
        this.car.setBackground(getResources().getDrawable(b.C0308b.invoice_create_new_btn_area));
        this.cas.setBackground(getResources().getDrawable(b.C0308b.invoice_create_new_divider_line));
        this.cat.setTextColor(getResources().getColor(b.C0308b.invoice_create_new_btn_text));
        this.cat.setBackground(getResources().getDrawable(b.d.invoice_create_new_btn_bg));
        this.caq = new com.baidu.swan.bdprivate.invoice.ui.a(this);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.cap.setLayoutManager(this.mLayoutManager);
        this.cap.setAdapter(this.caq);
        agw();
        this.caq.a(new a.b() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.2
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
        this.cat.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.agz();
            }
        });
        agx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agw() {
        if (this.bYr != null) {
            this.bYr.setTitle(getString(b.g.invoice_empty_title));
            this.bYr.setIcon(b.d.empty_icon_document);
            if (this.caq != null && this.caq.getItemCount() > 0) {
                this.bYr.setVisibility(8);
            } else {
                this.bYr.setVisibility(0);
            }
        }
    }

    private void agx() {
        if (com.baidu.swan.bdprivate.a.a.isLogin(this)) {
            agy();
        } else {
            l(true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agy() {
        showLoadingView();
        if (TextUtils.equals(this.mSource, "source_ai_app")) {
            d.agn().a(this, this.byL, this.cav, this.caw);
        } else {
            d.agn().a(this.caw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z, boolean z2) {
        Eo();
        com.baidu.swan.bdprivate.invoice.a.a(this, new a(this, z, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(String str, String str2) {
        Eo();
        com.baidu.swan.bdprivate.invoice.a.o(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this, this.cau);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eo() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.cau);
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
            d.agn().a(invoiceInfo.mId, new c.d() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.5
                @Override // com.baidu.swan.bdprivate.invoice.c.d
                public void aJ(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票成功");
                    if (InvoiceListActivity.this.caq != null) {
                        InvoiceListActivity.this.Eo();
                        InvoiceListActivity.this.caq.aL(invoiceInfo.mId);
                    }
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void mX(String str) {
                    InvoiceListActivity.this.l(false, false);
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void bo(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票失败");
                    InvoiceListActivity.this.bp(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final InvoiceInfo invoiceInfo) {
        com.baidu.swan.bdprivate.widget.a aVar = new com.baidu.swan.bdprivate.widget.a(this.cap);
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
            d.agn().a(invoiceInfo.mId, new c.b() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.7
                @Override // com.baidu.swan.bdprivate.invoice.c.b
                public void aI(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票成功");
                    if (InvoiceListActivity.this.caq != null) {
                        InvoiceListActivity.this.Eo();
                        InvoiceListActivity.this.caq.aK(invoiceInfo.mId);
                        if (invoiceInfo.mIsDefault == 1) {
                            InvoiceListActivity.this.caq.aL(j);
                        }
                        InvoiceListActivity.this.agw();
                    }
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void mX(String str) {
                    InvoiceListActivity.this.l(false, false);
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void bo(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票失败");
                    InvoiceListActivity.this.bp(str, str2);
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
    public void agz() {
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
                    if (this.caq != null && invoiceInfo != null) {
                        this.caq.m(invoiceInfo);
                        agw();
                        break;
                    }
                    break;
                case 10002:
                    if (this.caq != null && invoiceInfo != null) {
                        this.caq.n(invoiceInfo);
                        break;
                    }
                    break;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a implements com.baidu.swan.apps.a.a {
        private boolean caA;
        private boolean caB;
        private WeakReference<InvoiceListActivity> caz;

        public a(InvoiceListActivity invoiceListActivity, boolean z, boolean z2) {
            this.caz = new WeakReference<>(invoiceListActivity);
            this.caA = z;
            this.caB = z2;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            InvoiceListActivity invoiceListActivity = this.caz.get();
            if (invoiceListActivity != null) {
                if (com.baidu.swan.bdprivate.a.a.isLogin(invoiceListActivity)) {
                    if (this.caA) {
                        invoiceListActivity.agy();
                    }
                } else if (this.caB) {
                    invoiceListActivity.finish();
                }
            }
        }
    }
}

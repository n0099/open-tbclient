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
    private String bCS;
    private SwanAppBdActionBar cbq;
    private CommonEmptyView ccw;
    private RelativeLayout ceA;
    private String ceB;
    private RecyclerView cev;
    private com.baidu.swan.bdprivate.invoice.ui.a cew;
    private LinearLayout cex;
    private View cey;
    private Button cez;
    private RecyclerView.LayoutManager mLayoutManager;
    private String mSource = "source_setting";
    private c.InterfaceC0321c ceC = new c.InterfaceC0321c() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.4
        @Override // com.baidu.swan.bdprivate.invoice.c.InterfaceC0321c
        public void ai(List<InvoiceInfo> list) {
            if (InvoiceListActivity.this.cew != null) {
                InvoiceListActivity.this.GD();
                InvoiceListActivity.this.cew.ac(list);
                InvoiceListActivity.this.aiK();
            }
        }

        @Override // com.baidu.swan.bdprivate.invoice.c
        public void nm(String str) {
            InvoiceListActivity.this.n(true, false);
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
        aiJ();
        initView();
    }

    private void N(Intent intent) {
        if (intent != null) {
            this.mSource = intent.getStringExtra("source");
            this.bCS = intent.getStringExtra("appId");
            this.ceB = intent.getStringExtra("appKey");
        }
    }

    private void aiJ() {
        this.cbq = (SwanAppBdActionBar) findViewById(b.e.bd_action_bar);
        this.cbq.setTitle(getString(b.g.invoice_info_activity_title));
        this.cbq.setLeftFirstViewVisibility(true);
        this.cbq.setRightMenuVisibility(false);
        this.cbq.setLeftZoneOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.finish();
            }
        });
    }

    private void initView() {
        this.ceA = (RelativeLayout) findViewById(b.e.root_container);
        this.cev = (RecyclerView) findViewById(b.e.invoice_list_view);
        this.cez = (Button) findViewById(b.e.new_invoice_info_btn);
        this.ccw = (CommonEmptyView) findViewById(b.e.empty_view);
        this.cex = (LinearLayout) findViewById(b.e.new_invoice_info_area);
        this.cey = findViewById(b.e.new_invoice_info_divider_line);
        this.cev.setBackground(getResources().getDrawable(b.C0318b.invoice_list_bg));
        this.cex.setBackground(getResources().getDrawable(b.C0318b.invoice_create_new_btn_area));
        this.cey.setBackground(getResources().getDrawable(b.C0318b.invoice_create_new_divider_line));
        this.cez.setTextColor(getResources().getColor(b.C0318b.invoice_create_new_btn_text));
        this.cez.setBackground(getResources().getDrawable(b.d.invoice_create_new_btn_bg));
        this.cew = new com.baidu.swan.bdprivate.invoice.ui.a(this);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.cev.setLayoutManager(this.mLayoutManager);
        this.cev.setAdapter(this.cew);
        aiK();
        this.cew.a(new a.b() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.2
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
        this.cez.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InvoiceListActivity.this.aiN();
            }
        });
        aiL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiK() {
        if (this.ccw != null) {
            this.ccw.setTitle(getString(b.g.invoice_empty_title));
            this.ccw.setIcon(b.d.empty_icon_document);
            if (this.cew != null && this.cew.getItemCount() > 0) {
                this.ccw.setVisibility(8);
            } else {
                this.ccw.setVisibility(0);
            }
        }
    }

    private void aiL() {
        if (com.baidu.swan.bdprivate.a.a.isLogin(this)) {
            aiM();
        } else {
            n(true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiM() {
        showLoadingView();
        if (TextUtils.equals(this.mSource, "source_ai_app")) {
            d.aiB().a(this, this.bCS, this.ceB, this.ceC);
        } else {
            d.aiB().a(this.ceC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z, boolean z2) {
        GD();
        com.baidu.swan.bdprivate.invoice.a.a(this, new a(this, z, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(String str, String str2) {
        GD();
        com.baidu.swan.bdprivate.invoice.a.o(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this, this.ceA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GD() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.ceA);
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
            d.aiB().a(invoiceInfo.mId, new c.d() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.5
                @Override // com.baidu.swan.bdprivate.invoice.c.d
                public void aN(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改默认发票成功");
                    if (InvoiceListActivity.this.cew != null) {
                        InvoiceListActivity.this.GD();
                        InvoiceListActivity.this.cew.aP(invoiceInfo.mId);
                    }
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void nm(String str) {
                    InvoiceListActivity.this.n(false, false);
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
        com.baidu.swan.bdprivate.widget.a aVar = new com.baidu.swan.bdprivate.widget.a(this.cev);
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
            d.aiB().a(invoiceInfo.mId, new c.b() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceListActivity.7
                @Override // com.baidu.swan.bdprivate.invoice.c.b
                public void aM(long j) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "删除发票成功");
                    if (InvoiceListActivity.this.cew != null) {
                        InvoiceListActivity.this.GD();
                        InvoiceListActivity.this.cew.aO(invoiceInfo.mId);
                        if (invoiceInfo.mIsDefault == 1) {
                            InvoiceListActivity.this.cew.aP(j);
                        }
                        InvoiceListActivity.this.aiK();
                    }
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void nm(String str) {
                    InvoiceListActivity.this.n(false, false);
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
    public void aiN() {
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
                    if (this.cew != null && invoiceInfo != null) {
                        this.cew.m(invoiceInfo);
                        aiK();
                        break;
                    }
                    break;
                case 10002:
                    if (this.cew != null && invoiceInfo != null) {
                        this.cew.n(invoiceInfo);
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
        private WeakReference<InvoiceListActivity> ceF;
        private boolean ceG;
        private boolean ceH;

        public a(InvoiceListActivity invoiceListActivity, boolean z, boolean z2) {
            this.ceF = new WeakReference<>(invoiceListActivity);
            this.ceG = z;
            this.ceH = z2;
        }

        @Override // com.baidu.swan.apps.a.a
        public void onResult(int i) {
            InvoiceListActivity invoiceListActivity = this.ceF.get();
            if (invoiceListActivity != null) {
                if (com.baidu.swan.bdprivate.a.a.isLogin(invoiceListActivity)) {
                    if (this.ceG) {
                        invoiceListActivity.aiM();
                    }
                } else if (this.ceH) {
                    invoiceListActivity.finish();
                }
            }
        }
    }
}

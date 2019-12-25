package com.baidu.swan.bdprivate.invoice.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import com.baidu.sapi2.activity.SlideActiviy;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.bdprivate.activity.BaseActivity;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.invoice.c;
import com.baidu.swan.bdprivate.invoice.d;
import com.baidu.swan.bdprivate.invoice.model.InvoiceInfo;
import com.baidu.swan.bdprivate.widget.SwanAppBdActionBar;
/* loaded from: classes9.dex */
public class InvoiceEditActivity extends BaseActivity {
    private SwanAppBdActionBar bXb;
    private InvoiceInfoEditView bZC;
    private InvoiceInfo bZD;
    private ScrollView bes;
    private int mType = 1;
    private View.OnClickListener bZE = new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (InvoiceEditActivity.this.bZC != null && InvoiceEditActivity.this.bZC.afW()) {
                new g.a(InvoiceEditActivity.this).e(InvoiceEditActivity.this.getString(b.g.invoice_dialog_exit_title)).kr(InvoiceEditActivity.this.getString(b.g.invoice_dialog_exit_message)).c(b.g.invoice_dialog_exit_pos_btn, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        InvoiceEditActivity.this.finish();
                    }
                }).d(b.g.invoice_dialog_exit_neg_btn, null).ZC();
            } else {
                InvoiceEditActivity.this.finish();
            }
        }
    };
    private View.OnClickListener bZF = new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InvoiceInfo invoiceInfo;
            if (InvoiceEditActivity.this.bZC != null) {
                invoiceInfo = InvoiceEditActivity.this.bZC.getInvoiceInfo();
            } else {
                invoiceInfo = null;
            }
            if (InvoiceEditActivity.this.mType != 0 || invoiceInfo == null) {
                if (InvoiceEditActivity.this.mType == 1 && invoiceInfo != null) {
                    InvoiceEditActivity.this.f(invoiceInfo);
                    return;
                }
                return;
            }
            InvoiceEditActivity.this.e(invoiceInfo.c(InvoiceEditActivity.this.bZD));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        dY(true);
        super.onCreate(bundle);
        setContentView(b.f.activity_invoice_edit);
        af.U(this);
        L(getIntent());
        initView();
        M(getIntent());
    }

    private void L(Intent intent) {
        if (intent != null) {
            this.mType = intent.getIntExtra("type", 1);
        }
        this.bXb = (SwanAppBdActionBar) findViewById(b.e.bd_action_bar);
        if (this.bXb != null) {
            this.bXb.setLeftFirstViewVisibility(false);
            this.bXb.setRightMenuVisibility(false);
            this.bXb.setLeftSecondViewVisibility(0);
            this.bXb.setLeftSecondViewText(getString(b.g.invoice_action_bar_cancel));
            this.bXb.setLeftSecondViewTextSize(14);
            this.bXb.setLeftSecondViewClickListener(this.bZE);
            this.bXb.setRightTxtZone1Visibility(0);
            this.bXb.setRightTxtZone1Text(getString(b.g.invoice_action_bar_save));
            this.bXb.setRightTxtZone1Clickable(false);
            this.bXb.setRightTxtZone1OnClickListener(this.bZF);
            this.bXb.setRightTxtZone1TextSelector(getResources().getColorStateList(b.C0306b.aiapps_invoice_action_bar_txt_color_selector));
            if (this.mType == 0) {
                this.bXb.setTitle(getString(b.g.invoice_action_bar_title_edit));
            } else {
                this.bXb.setTitle(getString(b.g.invoice_action_bar_title_create));
            }
        }
    }

    private void initView() {
        this.bes = (ScrollView) findViewById(b.e.scroll_view);
        this.bZC = (InvoiceInfoEditView) findViewById(b.e.invoice_info_view);
        afY();
        this.bZC.setInputStatusListener(new com.baidu.swan.bdprivate.invoice.b() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.1
            @Override // com.baidu.swan.bdprivate.invoice.b
            public void afR() {
                InvoiceEditActivity.this.ed(true);
            }

            @Override // com.baidu.swan.bdprivate.invoice.b
            public void afS() {
                InvoiceEditActivity.this.ed(false);
            }

            @Override // com.baidu.swan.bdprivate.invoice.b
            public void afT() {
                InvoiceEditActivity.this.afY();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afY() {
        if (this.bZC.afV()) {
            ed(true);
        } else {
            ed(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ed(boolean z) {
        if (getBdActionBar() != null) {
            if (z) {
                getBdActionBar().setRightTxtZone1Clickable(true);
                getBdActionBar().setRightTxtZone1TextSelector(getResources().getColorStateList(b.C0306b.aiapps_invoice_action_bar_activate_txt_color_selector));
                return;
            }
            getBdActionBar().setRightTxtZone1Clickable(false);
            getBdActionBar().setRightTxtZone1TextSelector(getResources().getColorStateList(b.C0306b.aiapps_invoice_action_bar_txt_color_selector));
        }
    }

    private void M(Intent intent) {
        if (intent != null && this.mType == 0) {
            InvoiceInfo invoiceInfo = (InvoiceInfo) intent.getParcelableExtra(SlideActiviy.INVOICE_PAGE_NAME);
            this.bZD = invoiceInfo;
            if (invoiceInfo != null) {
                this.bZC.d(this.bZD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.afU().a(invoiceInfo, new c.e() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.4
                @Override // com.baidu.swan.bdprivate.invoice.c.e
                public void b(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票成功");
                    InvoiceEditActivity.this.DS();
                    Intent intent = new Intent();
                    intent.putExtra(SlideActiviy.INVOICE_PAGE_NAME, invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void mU(String str) {
                    InvoiceEditActivity.this.mV(str);
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void bn(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票失败");
                    InvoiceEditActivity.this.bo(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.afU().a(invoiceInfo, new c.a() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.5
                @Override // com.baidu.swan.bdprivate.invoice.c.a
                public void a(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票成功");
                    InvoiceEditActivity.this.DS();
                    Intent intent = new Intent();
                    intent.putExtra(SlideActiviy.INVOICE_PAGE_NAME, invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void mU(String str) {
                    InvoiceEditActivity.this.mV(str);
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void bn(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票失败");
                    InvoiceEditActivity.this.bo(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mV(String str) {
        DS();
        com.baidu.swan.bdprivate.invoice.a.a(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(String str, String str2) {
        DS();
        com.baidu.swan.bdprivate.invoice.a.o(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this, this.bZC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DS() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.bZC);
    }

    public SwanAppBdActionBar getBdActionBar() {
        return this.bXb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bZC != null) {
            this.bZC.afZ();
        }
    }
}

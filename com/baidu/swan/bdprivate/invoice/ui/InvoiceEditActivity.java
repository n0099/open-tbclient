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
/* loaded from: classes11.dex */
public class InvoiceEditActivity extends BaseActivity {
    private ScrollView bHT;
    private SwanAppBdActionBar cAF;
    private InvoiceInfoEditView cDf;
    private InvoiceInfo cDg;
    private int mType = 1;
    private View.OnClickListener cDh = new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (InvoiceEditActivity.this.cDf != null && InvoiceEditActivity.this.cDf.aqQ()) {
                new g.a(InvoiceEditActivity.this).e(InvoiceEditActivity.this.getString(b.g.invoice_dialog_exit_title)).lV(InvoiceEditActivity.this.getString(b.g.invoice_dialog_exit_message)).c(b.g.invoice_dialog_exit_pos_btn, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        InvoiceEditActivity.this.finish();
                    }
                }).d(b.g.invoice_dialog_exit_neg_btn, null).akx();
            } else {
                InvoiceEditActivity.this.finish();
            }
        }
    };
    private View.OnClickListener cDi = new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InvoiceInfo invoiceInfo;
            if (InvoiceEditActivity.this.cDf != null) {
                invoiceInfo = InvoiceEditActivity.this.cDf.getInvoiceInfo();
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
            InvoiceEditActivity.this.e(invoiceInfo.c(InvoiceEditActivity.this.cDg));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        fi(true);
        super.onCreate(bundle);
        setContentView(b.f.activity_invoice_edit);
        af.S(this);
        K(getIntent());
        initView();
        L(getIntent());
    }

    private void K(Intent intent) {
        if (intent != null) {
            this.mType = intent.getIntExtra("type", 1);
        }
        this.cAF = (SwanAppBdActionBar) findViewById(b.e.bd_action_bar);
        if (this.cAF != null) {
            this.cAF.setLeftFirstViewVisibility(false);
            this.cAF.setRightMenuVisibility(false);
            this.cAF.setLeftSecondViewVisibility(0);
            this.cAF.setLeftSecondViewText(getString(b.g.invoice_action_bar_cancel));
            this.cAF.setLeftSecondViewTextSize(14);
            this.cAF.setLeftSecondViewClickListener(this.cDh);
            this.cAF.setRightTxtZone1Visibility(0);
            this.cAF.setRightTxtZone1Text(getString(b.g.invoice_action_bar_save));
            this.cAF.setRightTxtZone1Clickable(false);
            this.cAF.setRightTxtZone1OnClickListener(this.cDi);
            this.cAF.setRightTxtZone1TextSelector(getResources().getColorStateList(b.C0348b.aiapps_invoice_action_bar_txt_color_selector));
            if (this.mType == 0) {
                this.cAF.setTitle(getString(b.g.invoice_action_bar_title_edit));
            } else {
                this.cAF.setTitle(getString(b.g.invoice_action_bar_title_create));
            }
        }
    }

    private void initView() {
        this.bHT = (ScrollView) findViewById(b.e.scroll_view);
        this.cDf = (InvoiceInfoEditView) findViewById(b.e.invoice_info_view);
        aqS();
        this.cDf.setInputStatusListener(new com.baidu.swan.bdprivate.invoice.b() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.1
            @Override // com.baidu.swan.bdprivate.invoice.b
            public void aqL() {
                InvoiceEditActivity.this.fn(true);
            }

            @Override // com.baidu.swan.bdprivate.invoice.b
            public void aqM() {
                InvoiceEditActivity.this.fn(false);
            }

            @Override // com.baidu.swan.bdprivate.invoice.b
            public void aqN() {
                InvoiceEditActivity.this.aqS();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqS() {
        if (this.cDf.aqP()) {
            fn(true);
        } else {
            fn(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fn(boolean z) {
        if (getBdActionBar() != null) {
            if (z) {
                getBdActionBar().setRightTxtZone1Clickable(true);
                getBdActionBar().setRightTxtZone1TextSelector(getResources().getColorStateList(b.C0348b.aiapps_invoice_action_bar_activate_txt_color_selector));
                return;
            }
            getBdActionBar().setRightTxtZone1Clickable(false);
            getBdActionBar().setRightTxtZone1TextSelector(getResources().getColorStateList(b.C0348b.aiapps_invoice_action_bar_txt_color_selector));
        }
    }

    private void L(Intent intent) {
        if (intent != null && this.mType == 0) {
            InvoiceInfo invoiceInfo = (InvoiceInfo) intent.getParcelableExtra(SlideActiviy.INVOICE_PAGE_NAME);
            this.cDg = invoiceInfo;
            if (invoiceInfo != null) {
                this.cDf.d(this.cDg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aqO().a(invoiceInfo, new c.e() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.4
                @Override // com.baidu.swan.bdprivate.invoice.c.e
                public void b(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票成功");
                    InvoiceEditActivity.this.Ox();
                    Intent intent = new Intent();
                    intent.putExtra(SlideActiviy.INVOICE_PAGE_NAME, invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void oA(String str) {
                    InvoiceEditActivity.this.oB(str);
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void bH(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票失败");
                    InvoiceEditActivity.this.bI(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aqO().a(invoiceInfo, new c.a() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.5
                @Override // com.baidu.swan.bdprivate.invoice.c.a
                public void a(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票成功");
                    InvoiceEditActivity.this.Ox();
                    Intent intent = new Intent();
                    intent.putExtra(SlideActiviy.INVOICE_PAGE_NAME, invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void oA(String str) {
                    InvoiceEditActivity.this.oB(str);
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void bH(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票失败");
                    InvoiceEditActivity.this.bI(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oB(String str) {
        Ox();
        com.baidu.swan.bdprivate.invoice.a.a(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(String str, String str2) {
        Ox();
        com.baidu.swan.bdprivate.invoice.a.o(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this, this.cDf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ox() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.cDf);
    }

    public SwanAppBdActionBar getBdActionBar() {
        return this.cAF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cDf != null) {
            this.cDf.aqT();
        }
    }
}

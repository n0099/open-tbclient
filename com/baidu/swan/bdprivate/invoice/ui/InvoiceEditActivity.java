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
/* loaded from: classes10.dex */
public class InvoiceEditActivity extends BaseActivity {
    private SwanAppBdActionBar bXn;
    private InvoiceInfoEditView bZO;
    private InvoiceInfo bZP;
    private ScrollView bfi;
    private int mType = 1;
    private View.OnClickListener bZQ = new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (InvoiceEditActivity.this.bZO != null && InvoiceEditActivity.this.bZO.agp()) {
                new g.a(InvoiceEditActivity.this).e(InvoiceEditActivity.this.getString(b.g.invoice_dialog_exit_title)).ku(InvoiceEditActivity.this.getString(b.g.invoice_dialog_exit_message)).c(b.g.invoice_dialog_exit_pos_btn, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        InvoiceEditActivity.this.finish();
                    }
                }).d(b.g.invoice_dialog_exit_neg_btn, null).ZZ();
            } else {
                InvoiceEditActivity.this.finish();
            }
        }
    };
    private View.OnClickListener bZR = new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InvoiceInfo invoiceInfo;
            if (InvoiceEditActivity.this.bZO != null) {
                invoiceInfo = InvoiceEditActivity.this.bZO.getInvoiceInfo();
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
            InvoiceEditActivity.this.e(invoiceInfo.c(InvoiceEditActivity.this.bZP));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ed(true);
        super.onCreate(bundle);
        setContentView(b.f.activity_invoice_edit);
        af.V(this);
        L(getIntent());
        initView();
        M(getIntent());
    }

    private void L(Intent intent) {
        if (intent != null) {
            this.mType = intent.getIntExtra("type", 1);
        }
        this.bXn = (SwanAppBdActionBar) findViewById(b.e.bd_action_bar);
        if (this.bXn != null) {
            this.bXn.setLeftFirstViewVisibility(false);
            this.bXn.setRightMenuVisibility(false);
            this.bXn.setLeftSecondViewVisibility(0);
            this.bXn.setLeftSecondViewText(getString(b.g.invoice_action_bar_cancel));
            this.bXn.setLeftSecondViewTextSize(14);
            this.bXn.setLeftSecondViewClickListener(this.bZQ);
            this.bXn.setRightTxtZone1Visibility(0);
            this.bXn.setRightTxtZone1Text(getString(b.g.invoice_action_bar_save));
            this.bXn.setRightTxtZone1Clickable(false);
            this.bXn.setRightTxtZone1OnClickListener(this.bZR);
            this.bXn.setRightTxtZone1TextSelector(getResources().getColorStateList(b.C0308b.aiapps_invoice_action_bar_txt_color_selector));
            if (this.mType == 0) {
                this.bXn.setTitle(getString(b.g.invoice_action_bar_title_edit));
            } else {
                this.bXn.setTitle(getString(b.g.invoice_action_bar_title_create));
            }
        }
    }

    private void initView() {
        this.bfi = (ScrollView) findViewById(b.e.scroll_view);
        this.bZO = (InvoiceInfoEditView) findViewById(b.e.invoice_info_view);
        agr();
        this.bZO.setInputStatusListener(new com.baidu.swan.bdprivate.invoice.b() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.1
            @Override // com.baidu.swan.bdprivate.invoice.b
            public void agk() {
                InvoiceEditActivity.this.ei(true);
            }

            @Override // com.baidu.swan.bdprivate.invoice.b
            public void agl() {
                InvoiceEditActivity.this.ei(false);
            }

            @Override // com.baidu.swan.bdprivate.invoice.b
            public void agm() {
                InvoiceEditActivity.this.agr();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agr() {
        if (this.bZO.ago()) {
            ei(true);
        } else {
            ei(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ei(boolean z) {
        if (getBdActionBar() != null) {
            if (z) {
                getBdActionBar().setRightTxtZone1Clickable(true);
                getBdActionBar().setRightTxtZone1TextSelector(getResources().getColorStateList(b.C0308b.aiapps_invoice_action_bar_activate_txt_color_selector));
                return;
            }
            getBdActionBar().setRightTxtZone1Clickable(false);
            getBdActionBar().setRightTxtZone1TextSelector(getResources().getColorStateList(b.C0308b.aiapps_invoice_action_bar_txt_color_selector));
        }
    }

    private void M(Intent intent) {
        if (intent != null && this.mType == 0) {
            InvoiceInfo invoiceInfo = (InvoiceInfo) intent.getParcelableExtra(SlideActiviy.INVOICE_PAGE_NAME);
            this.bZP = invoiceInfo;
            if (invoiceInfo != null) {
                this.bZO.d(this.bZP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.agn().a(invoiceInfo, new c.e() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.4
                @Override // com.baidu.swan.bdprivate.invoice.c.e
                public void b(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票成功");
                    InvoiceEditActivity.this.Eo();
                    Intent intent = new Intent();
                    intent.putExtra(SlideActiviy.INVOICE_PAGE_NAME, invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void mX(String str) {
                    InvoiceEditActivity.this.mY(str);
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void bo(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票失败");
                    InvoiceEditActivity.this.bp(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.agn().a(invoiceInfo, new c.a() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.5
                @Override // com.baidu.swan.bdprivate.invoice.c.a
                public void a(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票成功");
                    InvoiceEditActivity.this.Eo();
                    Intent intent = new Intent();
                    intent.putExtra(SlideActiviy.INVOICE_PAGE_NAME, invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void mX(String str) {
                    InvoiceEditActivity.this.mY(str);
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void bo(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票失败");
                    InvoiceEditActivity.this.bp(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mY(String str) {
        Eo();
        com.baidu.swan.bdprivate.invoice.a.a(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(String str, String str2) {
        Eo();
        com.baidu.swan.bdprivate.invoice.a.o(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this, this.bZO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eo() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.bZO);
    }

    public SwanAppBdActionBar getBdActionBar() {
        return this.bXn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bZO != null) {
            this.bZO.ags();
        }
    }
}

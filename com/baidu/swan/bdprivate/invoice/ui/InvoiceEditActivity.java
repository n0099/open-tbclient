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
    private ScrollView bjL;
    private SwanAppBdActionBar cbE;
    private InvoiceInfoEditView ceh;
    private InvoiceInfo cei;
    private int mType = 1;
    private View.OnClickListener cej = new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (InvoiceEditActivity.this.ceh != null && InvoiceEditActivity.this.ceh.aiI()) {
                new g.a(InvoiceEditActivity.this).e(InvoiceEditActivity.this.getString(b.g.invoice_dialog_exit_title)).kI(InvoiceEditActivity.this.getString(b.g.invoice_dialog_exit_message)).c(b.g.invoice_dialog_exit_pos_btn, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        InvoiceEditActivity.this.finish();
                    }
                }).d(b.g.invoice_dialog_exit_neg_btn, null).acs();
            } else {
                InvoiceEditActivity.this.finish();
            }
        }
    };
    private View.OnClickListener cek = new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InvoiceInfo invoiceInfo;
            if (InvoiceEditActivity.this.ceh != null) {
                invoiceInfo = InvoiceEditActivity.this.ceh.getInvoiceInfo();
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
            InvoiceEditActivity.this.e(invoiceInfo.c(InvoiceEditActivity.this.cei));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        el(true);
        super.onCreate(bundle);
        setContentView(b.f.activity_invoice_edit);
        af.W(this);
        L(getIntent());
        initView();
        M(getIntent());
    }

    private void L(Intent intent) {
        if (intent != null) {
            this.mType = intent.getIntExtra("type", 1);
        }
        this.cbE = (SwanAppBdActionBar) findViewById(b.e.bd_action_bar);
        if (this.cbE != null) {
            this.cbE.setLeftFirstViewVisibility(false);
            this.cbE.setRightMenuVisibility(false);
            this.cbE.setLeftSecondViewVisibility(0);
            this.cbE.setLeftSecondViewText(getString(b.g.invoice_action_bar_cancel));
            this.cbE.setLeftSecondViewTextSize(14);
            this.cbE.setLeftSecondViewClickListener(this.cej);
            this.cbE.setRightTxtZone1Visibility(0);
            this.cbE.setRightTxtZone1Text(getString(b.g.invoice_action_bar_save));
            this.cbE.setRightTxtZone1Clickable(false);
            this.cbE.setRightTxtZone1OnClickListener(this.cek);
            this.cbE.setRightTxtZone1TextSelector(getResources().getColorStateList(b.C0318b.aiapps_invoice_action_bar_txt_color_selector));
            if (this.mType == 0) {
                this.cbE.setTitle(getString(b.g.invoice_action_bar_title_edit));
            } else {
                this.cbE.setTitle(getString(b.g.invoice_action_bar_title_create));
            }
        }
    }

    private void initView() {
        this.bjL = (ScrollView) findViewById(b.e.scroll_view);
        this.ceh = (InvoiceInfoEditView) findViewById(b.e.invoice_info_view);
        aiK();
        this.ceh.setInputStatusListener(new com.baidu.swan.bdprivate.invoice.b() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.1
            @Override // com.baidu.swan.bdprivate.invoice.b
            public void aiD() {
                InvoiceEditActivity.this.eq(true);
            }

            @Override // com.baidu.swan.bdprivate.invoice.b
            public void aiE() {
                InvoiceEditActivity.this.eq(false);
            }

            @Override // com.baidu.swan.bdprivate.invoice.b
            public void aiF() {
                InvoiceEditActivity.this.aiK();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiK() {
        if (this.ceh.aiH()) {
            eq(true);
        } else {
            eq(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eq(boolean z) {
        if (getBdActionBar() != null) {
            if (z) {
                getBdActionBar().setRightTxtZone1Clickable(true);
                getBdActionBar().setRightTxtZone1TextSelector(getResources().getColorStateList(b.C0318b.aiapps_invoice_action_bar_activate_txt_color_selector));
                return;
            }
            getBdActionBar().setRightTxtZone1Clickable(false);
            getBdActionBar().setRightTxtZone1TextSelector(getResources().getColorStateList(b.C0318b.aiapps_invoice_action_bar_txt_color_selector));
        }
    }

    private void M(Intent intent) {
        if (intent != null && this.mType == 0) {
            InvoiceInfo invoiceInfo = (InvoiceInfo) intent.getParcelableExtra(SlideActiviy.INVOICE_PAGE_NAME);
            this.cei = invoiceInfo;
            if (invoiceInfo != null) {
                this.ceh.d(this.cei);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aiG().a(invoiceInfo, new c.e() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.4
                @Override // com.baidu.swan.bdprivate.invoice.c.e
                public void b(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票成功");
                    InvoiceEditActivity.this.GK();
                    Intent intent = new Intent();
                    intent.putExtra(SlideActiviy.INVOICE_PAGE_NAME, invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void nl(String str) {
                    InvoiceEditActivity.this.nm(str);
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void bw(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票失败");
                    InvoiceEditActivity.this.bx(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aiG().a(invoiceInfo, new c.a() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.5
                @Override // com.baidu.swan.bdprivate.invoice.c.a
                public void a(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票成功");
                    InvoiceEditActivity.this.GK();
                    Intent intent = new Intent();
                    intent.putExtra(SlideActiviy.INVOICE_PAGE_NAME, invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void nl(String str) {
                    InvoiceEditActivity.this.nm(str);
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void bw(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票失败");
                    InvoiceEditActivity.this.bx(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nm(String str) {
        GK();
        com.baidu.swan.bdprivate.invoice.a.a(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(String str, String str2) {
        GK();
        com.baidu.swan.bdprivate.invoice.a.o(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this, this.ceh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GK() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.ceh);
    }

    public SwanAppBdActionBar getBdActionBar() {
        return this.cbE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ceh != null) {
            this.ceh.aiL();
        }
    }
}

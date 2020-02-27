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
    private ScrollView bjw;
    private SwanAppBdActionBar cbq;
    private InvoiceInfoEditView cdU;
    private InvoiceInfo cdV;
    private int mType = 1;
    private View.OnClickListener cdW = new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (InvoiceEditActivity.this.cdU != null && InvoiceEditActivity.this.cdU.aiD()) {
                new g.a(InvoiceEditActivity.this).e(InvoiceEditActivity.this.getString(b.g.invoice_dialog_exit_title)).kJ(InvoiceEditActivity.this.getString(b.g.invoice_dialog_exit_message)).c(b.g.invoice_dialog_exit_pos_btn, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        InvoiceEditActivity.this.finish();
                    }
                }).d(b.g.invoice_dialog_exit_neg_btn, null).acn();
            } else {
                InvoiceEditActivity.this.finish();
            }
        }
    };
    private View.OnClickListener cdX = new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InvoiceInfo invoiceInfo;
            if (InvoiceEditActivity.this.cdU != null) {
                invoiceInfo = InvoiceEditActivity.this.cdU.getInvoiceInfo();
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
            InvoiceEditActivity.this.e(invoiceInfo.c(InvoiceEditActivity.this.cdV));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ek(true);
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
        this.cbq = (SwanAppBdActionBar) findViewById(b.e.bd_action_bar);
        if (this.cbq != null) {
            this.cbq.setLeftFirstViewVisibility(false);
            this.cbq.setRightMenuVisibility(false);
            this.cbq.setLeftSecondViewVisibility(0);
            this.cbq.setLeftSecondViewText(getString(b.g.invoice_action_bar_cancel));
            this.cbq.setLeftSecondViewTextSize(14);
            this.cbq.setLeftSecondViewClickListener(this.cdW);
            this.cbq.setRightTxtZone1Visibility(0);
            this.cbq.setRightTxtZone1Text(getString(b.g.invoice_action_bar_save));
            this.cbq.setRightTxtZone1Clickable(false);
            this.cbq.setRightTxtZone1OnClickListener(this.cdX);
            this.cbq.setRightTxtZone1TextSelector(getResources().getColorStateList(b.C0318b.aiapps_invoice_action_bar_txt_color_selector));
            if (this.mType == 0) {
                this.cbq.setTitle(getString(b.g.invoice_action_bar_title_edit));
            } else {
                this.cbq.setTitle(getString(b.g.invoice_action_bar_title_create));
            }
        }
    }

    private void initView() {
        this.bjw = (ScrollView) findViewById(b.e.scroll_view);
        this.cdU = (InvoiceInfoEditView) findViewById(b.e.invoice_info_view);
        aiF();
        this.cdU.setInputStatusListener(new com.baidu.swan.bdprivate.invoice.b() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.1
            @Override // com.baidu.swan.bdprivate.invoice.b
            public void aiy() {
                InvoiceEditActivity.this.ep(true);
            }

            @Override // com.baidu.swan.bdprivate.invoice.b
            public void aiz() {
                InvoiceEditActivity.this.ep(false);
            }

            @Override // com.baidu.swan.bdprivate.invoice.b
            public void aiA() {
                InvoiceEditActivity.this.aiF();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiF() {
        if (this.cdU.aiC()) {
            ep(true);
        } else {
            ep(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ep(boolean z) {
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
            this.cdV = invoiceInfo;
            if (invoiceInfo != null) {
                this.cdU.d(this.cdV);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aiB().a(invoiceInfo, new c.e() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.4
                @Override // com.baidu.swan.bdprivate.invoice.c.e
                public void b(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票成功");
                    InvoiceEditActivity.this.GD();
                    Intent intent = new Intent();
                    intent.putExtra(SlideActiviy.INVOICE_PAGE_NAME, invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void nm(String str) {
                    InvoiceEditActivity.this.nn(str);
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void bx(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票失败");
                    InvoiceEditActivity.this.by(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aiB().a(invoiceInfo, new c.a() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.5
                @Override // com.baidu.swan.bdprivate.invoice.c.a
                public void a(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票成功");
                    InvoiceEditActivity.this.GD();
                    Intent intent = new Intent();
                    intent.putExtra(SlideActiviy.INVOICE_PAGE_NAME, invoiceInfo2);
                    InvoiceEditActivity.this.setResult(-1, intent);
                    InvoiceEditActivity.this.finish();
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void nm(String str) {
                    InvoiceEditActivity.this.nn(str);
                }

                @Override // com.baidu.swan.bdprivate.invoice.c
                public void bx(String str, String str2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票失败");
                    InvoiceEditActivity.this.by(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nn(String str) {
        GD();
        com.baidu.swan.bdprivate.invoice.a.a(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(String str, String str2) {
        GD();
        com.baidu.swan.bdprivate.invoice.a.o(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this, this.cdU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GD() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.cdU);
    }

    public SwanAppBdActionBar getBdActionBar() {
        return this.cbq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cdU != null) {
            this.cdU.aiG();
        }
    }
}

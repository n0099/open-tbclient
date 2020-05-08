package com.baidu.swan.bdprivate.invoice.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
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
    private ScrollView bHY;
    private SwanAppBdActionBar cAL;
    private InvoiceInfoEditView cDl;
    private InvoiceInfo cDm;
    private int mType = 1;
    private View.OnClickListener cDn = new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (InvoiceEditActivity.this.cDl != null && InvoiceEditActivity.this.cDl.aqP()) {
                new g.a(InvoiceEditActivity.this).e(InvoiceEditActivity.this.getString(b.g.invoice_dialog_exit_title)).lV(InvoiceEditActivity.this.getString(b.g.invoice_dialog_exit_message)).c(b.g.invoice_dialog_exit_pos_btn, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        InvoiceEditActivity.this.finish();
                    }
                }).d(b.g.invoice_dialog_exit_neg_btn, null).akw();
            } else {
                InvoiceEditActivity.this.finish();
            }
        }
    };
    private View.OnClickListener cDo = new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InvoiceInfo invoiceInfo;
            if (InvoiceEditActivity.this.cDl != null) {
                invoiceInfo = InvoiceEditActivity.this.cDl.getInvoiceInfo();
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
            InvoiceEditActivity.this.e(invoiceInfo.c(InvoiceEditActivity.this.cDm));
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        fi(true);
        super.onCreate(bundle);
        setContentView(b.f.activity_invoice_edit);
        af.S(this);
        x(getIntent());
        initView();
        y(getIntent());
    }

    private void x(Intent intent) {
        if (intent != null) {
            this.mType = intent.getIntExtra("type", 1);
        }
        this.cAL = (SwanAppBdActionBar) findViewById(b.e.bd_action_bar);
        if (this.cAL != null) {
            this.cAL.setLeftFirstViewVisibility(false);
            this.cAL.setRightMenuVisibility(false);
            this.cAL.setLeftSecondViewVisibility(0);
            this.cAL.setLeftSecondViewText(getString(b.g.invoice_action_bar_cancel));
            this.cAL.setLeftSecondViewTextSize(14);
            this.cAL.setLeftSecondViewClickListener(this.cDn);
            this.cAL.setRightTxtZone1Visibility(0);
            this.cAL.setRightTxtZone1Text(getString(b.g.invoice_action_bar_save));
            this.cAL.setRightTxtZone1Clickable(false);
            this.cAL.setRightTxtZone1OnClickListener(this.cDo);
            this.cAL.setRightTxtZone1TextSelector(getResources().getColorStateList(b.C0369b.aiapps_invoice_action_bar_txt_color_selector));
            if (this.mType == 0) {
                this.cAL.setTitle(getString(b.g.invoice_action_bar_title_edit));
            } else {
                this.cAL.setTitle(getString(b.g.invoice_action_bar_title_create));
            }
        }
    }

    private void initView() {
        this.bHY = (ScrollView) findViewById(b.e.scroll_view);
        this.cDl = (InvoiceInfoEditView) findViewById(b.e.invoice_info_view);
        aqR();
        this.cDl.setInputStatusListener(new com.baidu.swan.bdprivate.invoice.b() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.1
            @Override // com.baidu.swan.bdprivate.invoice.b
            public void aqK() {
                InvoiceEditActivity.this.fn(true);
            }

            @Override // com.baidu.swan.bdprivate.invoice.b
            public void aqL() {
                InvoiceEditActivity.this.fn(false);
            }

            @Override // com.baidu.swan.bdprivate.invoice.b
            public void aqM() {
                InvoiceEditActivity.this.aqR();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqR() {
        if (this.cDl.aqO()) {
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
                getBdActionBar().setRightTxtZone1TextSelector(getResources().getColorStateList(b.C0369b.aiapps_invoice_action_bar_activate_txt_color_selector));
                return;
            }
            getBdActionBar().setRightTxtZone1Clickable(false);
            getBdActionBar().setRightTxtZone1TextSelector(getResources().getColorStateList(b.C0369b.aiapps_invoice_action_bar_txt_color_selector));
        }
    }

    private void y(Intent intent) {
        if (intent != null && this.mType == 0) {
            InvoiceInfo invoiceInfo = (InvoiceInfo) intent.getParcelableExtra("invoice");
            this.cDm = invoiceInfo;
            if (invoiceInfo != null) {
                this.cDl.d(this.cDm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            showLoadingView();
            d.aqN().a(invoiceInfo, new c.e() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.4
                @Override // com.baidu.swan.bdprivate.invoice.c.e
                public void b(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "修改发票成功");
                    InvoiceEditActivity.this.Ow();
                    Intent intent = new Intent();
                    intent.putExtra("invoice", invoiceInfo2);
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
            d.aqN().a(invoiceInfo, new c.a() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceEditActivity.5
                @Override // com.baidu.swan.bdprivate.invoice.c.a
                public void a(InvoiceInfo invoiceInfo2) {
                    com.baidu.swan.apps.console.c.i("chooseInvoiceTitle", "创建发票成功");
                    InvoiceEditActivity.this.Ow();
                    Intent intent = new Intent();
                    intent.putExtra("invoice", invoiceInfo2);
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
        Ow();
        com.baidu.swan.bdprivate.invoice.a.a(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(String str, String str2) {
        Ow();
        com.baidu.swan.bdprivate.invoice.a.q(this, str, str2);
    }

    private void showLoadingView() {
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this, this.cDl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ow() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.cDl);
    }

    public SwanAppBdActionBar getBdActionBar() {
        return this.cAL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cDl != null) {
            this.cDl.aqS();
        }
    }
}

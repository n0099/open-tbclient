package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.invoice.b;
import com.baidu.swan.bdprivate.invoice.e;
import com.baidu.swan.bdprivate.invoice.model.InvoiceInfo;
/* loaded from: classes11.dex */
public class InvoiceInfoEditView extends FrameLayout implements e {
    private RadioGroup cDl;
    private ViewSwitcher cDm;
    private InvoiceCompanyInfoView cDn;
    private InvoicePersonalInfoView cDo;
    private TextWatcher cDp;
    private RadioGroup.OnCheckedChangeListener cDq;
    private b cDr;
    private LinearLayout cDs;
    private TextView cDt;
    private RadioButton cDu;
    private RadioButton cDv;
    private View cDw;
    private Context mContext;

    public InvoiceInfoEditView(@NonNull Context context) {
        this(context, null);
    }

    public InvoiceInfoEditView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InvoiceInfoEditView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        inflate(context, b.f.invoice_info_edit_view, this);
        this.cDl = (RadioGroup) findViewById(b.e.invoice_type_group);
        this.cDm = (ViewSwitcher) findViewById(b.e.invoice_type_switcher);
        this.cDt = (TextView) findViewById(b.e.invoice_type_desc);
        this.cDu = (RadioButton) findViewById(b.e.invoice_type_company);
        this.cDv = (RadioButton) findViewById(b.e.invoice_type_personal);
        this.cDw = findViewById(b.e.divider_line);
        this.cDs = (LinearLayout) findViewById(b.e.invoice_type_area);
        this.cDt.setTextColor(getResources().getColor(b.C0348b.invoice_type));
        this.cDu.setTextColor(getResources().getColor(b.C0348b.invoice_type_company));
        this.cDu.setButtonDrawable(getResources().getDrawable(b.d.radio_button_selector));
        this.cDv.setTextColor(getResources().getColor(b.C0348b.invoice_type_personal));
        this.cDv.setButtonDrawable(getResources().getDrawable(b.d.radio_button_selector));
        this.cDw.setBackground(getResources().getDrawable(b.C0348b.invoice_info_item_divider_line));
        this.cDs.setBackground(getResources().getDrawable(b.C0348b.invoice_edit_view_bg));
        this.cDq = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == b.e.invoice_type_company) {
                    InvoiceInfoEditView.this.cDm.setDisplayedChild(0);
                } else if (i == b.e.invoice_type_personal) {
                    InvoiceInfoEditView.this.cDm.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.cDr != null) {
                    InvoiceInfoEditView.this.cDr.aqN();
                }
            }
        };
        this.cDl.setOnCheckedChangeListener(this.cDq);
        this.cDn = new InvoiceCompanyInfoView(context);
        this.cDo = new InvoicePersonalInfoView(context);
        this.cDm.addView(this.cDn, 0);
        this.cDm.addView(this.cDo, 1);
        this.cDp = new TextWatcher() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.aqU();
            }
        };
        this.cDo.setTextChangedListener(this.cDp);
        this.cDn.setTextChangedListener(this.cDp);
        this.cDl.check(b.e.invoice_type_company);
    }

    public void aqT() {
        if (this.cDo != null) {
            this.cDo.a(this.cDp);
        }
        if (this.cDn != null) {
            this.cDn.a(this.cDp);
        }
    }

    public void setInputStatusListener(com.baidu.swan.bdprivate.invoice.b bVar) {
        this.cDr = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqU() {
        if (this.cDr != null) {
            if (aqP()) {
                this.cDr.aqL();
            } else {
                this.cDr.aqM();
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean aqP() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aqP();
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        e currentInvoiceView = getCurrentInvoiceView();
        if (currentInvoiceView != null) {
            return currentInvoiceView.getInvoiceInfo();
        }
        return null;
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            if (invoiceInfo.mType == 0) {
                this.cDl.check(b.e.invoice_type_company);
                this.cDn.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.cDl.check(b.e.invoice_type_personal);
                this.cDo.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean aqQ() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aqQ();
    }

    private e getCurrentInvoiceView() {
        if (this.cDm == null) {
            return null;
        }
        if (this.cDm.getDisplayedChild() == 0) {
            return this.cDn;
        }
        if (this.cDm.getDisplayedChild() == 1) {
            return this.cDo;
        }
        return null;
    }
}

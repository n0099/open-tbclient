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
/* loaded from: classes9.dex */
public class InvoiceInfoEditView extends FrameLayout implements e {
    private RadioGroup bZI;
    private ViewSwitcher bZJ;
    private InvoiceCompanyInfoView bZK;
    private InvoicePersonalInfoView bZL;
    private TextWatcher bZM;
    private RadioGroup.OnCheckedChangeListener bZN;
    private b bZO;
    private LinearLayout bZP;
    private TextView bZQ;
    private RadioButton bZR;
    private RadioButton bZS;
    private View bZT;
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
        this.bZI = (RadioGroup) findViewById(b.e.invoice_type_group);
        this.bZJ = (ViewSwitcher) findViewById(b.e.invoice_type_switcher);
        this.bZQ = (TextView) findViewById(b.e.invoice_type_desc);
        this.bZR = (RadioButton) findViewById(b.e.invoice_type_company);
        this.bZS = (RadioButton) findViewById(b.e.invoice_type_personal);
        this.bZT = findViewById(b.e.divider_line);
        this.bZP = (LinearLayout) findViewById(b.e.invoice_type_area);
        this.bZQ.setTextColor(getResources().getColor(b.C0306b.invoice_type));
        this.bZR.setTextColor(getResources().getColor(b.C0306b.invoice_type_company));
        this.bZR.setButtonDrawable(getResources().getDrawable(b.d.radio_button_selector));
        this.bZS.setTextColor(getResources().getColor(b.C0306b.invoice_type_personal));
        this.bZS.setButtonDrawable(getResources().getDrawable(b.d.radio_button_selector));
        this.bZT.setBackground(getResources().getDrawable(b.C0306b.invoice_info_item_divider_line));
        this.bZP.setBackground(getResources().getDrawable(b.C0306b.invoice_edit_view_bg));
        this.bZN = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == b.e.invoice_type_company) {
                    InvoiceInfoEditView.this.bZJ.setDisplayedChild(0);
                } else if (i == b.e.invoice_type_personal) {
                    InvoiceInfoEditView.this.bZJ.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.bZO != null) {
                    InvoiceInfoEditView.this.bZO.afT();
                }
            }
        };
        this.bZI.setOnCheckedChangeListener(this.bZN);
        this.bZK = new InvoiceCompanyInfoView(context);
        this.bZL = new InvoicePersonalInfoView(context);
        this.bZJ.addView(this.bZK, 0);
        this.bZJ.addView(this.bZL, 1);
        this.bZM = new TextWatcher() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.aga();
            }
        };
        this.bZL.setTextChangedListener(this.bZM);
        this.bZK.setTextChangedListener(this.bZM);
        this.bZI.check(b.e.invoice_type_company);
    }

    public void afZ() {
        if (this.bZL != null) {
            this.bZL.a(this.bZM);
        }
        if (this.bZK != null) {
            this.bZK.a(this.bZM);
        }
    }

    public void setInputStatusListener(com.baidu.swan.bdprivate.invoice.b bVar) {
        this.bZO = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aga() {
        if (this.bZO != null) {
            if (afV()) {
                this.bZO.afR();
            } else {
                this.bZO.afS();
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean afV() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.afV();
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
                this.bZI.check(b.e.invoice_type_company);
                this.bZK.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.bZI.check(b.e.invoice_type_personal);
                this.bZL.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean afW() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.afW();
    }

    private e getCurrentInvoiceView() {
        if (this.bZJ == null) {
            return null;
        }
        if (this.bZJ.getDisplayedChild() == 0) {
            return this.bZK;
        }
        if (this.bZJ.getDisplayedChild() == 1) {
            return this.bZL;
        }
        return null;
    }
}

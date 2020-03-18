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
    private RadioGroup cen;
    private ViewSwitcher ceo;
    private InvoiceCompanyInfoView cep;
    private InvoicePersonalInfoView ceq;
    private TextWatcher cer;
    private RadioGroup.OnCheckedChangeListener ces;
    private b cet;
    private LinearLayout ceu;
    private TextView cev;
    private RadioButton cew;
    private RadioButton cex;
    private View cey;
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
        this.cen = (RadioGroup) findViewById(b.e.invoice_type_group);
        this.ceo = (ViewSwitcher) findViewById(b.e.invoice_type_switcher);
        this.cev = (TextView) findViewById(b.e.invoice_type_desc);
        this.cew = (RadioButton) findViewById(b.e.invoice_type_company);
        this.cex = (RadioButton) findViewById(b.e.invoice_type_personal);
        this.cey = findViewById(b.e.divider_line);
        this.ceu = (LinearLayout) findViewById(b.e.invoice_type_area);
        this.cev.setTextColor(getResources().getColor(b.C0318b.invoice_type));
        this.cew.setTextColor(getResources().getColor(b.C0318b.invoice_type_company));
        this.cew.setButtonDrawable(getResources().getDrawable(b.d.radio_button_selector));
        this.cex.setTextColor(getResources().getColor(b.C0318b.invoice_type_personal));
        this.cex.setButtonDrawable(getResources().getDrawable(b.d.radio_button_selector));
        this.cey.setBackground(getResources().getDrawable(b.C0318b.invoice_info_item_divider_line));
        this.ceu.setBackground(getResources().getDrawable(b.C0318b.invoice_edit_view_bg));
        this.ces = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == b.e.invoice_type_company) {
                    InvoiceInfoEditView.this.ceo.setDisplayedChild(0);
                } else if (i == b.e.invoice_type_personal) {
                    InvoiceInfoEditView.this.ceo.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.cet != null) {
                    InvoiceInfoEditView.this.cet.aiF();
                }
            }
        };
        this.cen.setOnCheckedChangeListener(this.ces);
        this.cep = new InvoiceCompanyInfoView(context);
        this.ceq = new InvoicePersonalInfoView(context);
        this.ceo.addView(this.cep, 0);
        this.ceo.addView(this.ceq, 1);
        this.cer = new TextWatcher() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.aiM();
            }
        };
        this.ceq.setTextChangedListener(this.cer);
        this.cep.setTextChangedListener(this.cer);
        this.cen.check(b.e.invoice_type_company);
    }

    public void aiL() {
        if (this.ceq != null) {
            this.ceq.a(this.cer);
        }
        if (this.cep != null) {
            this.cep.a(this.cer);
        }
    }

    public void setInputStatusListener(com.baidu.swan.bdprivate.invoice.b bVar) {
        this.cet = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiM() {
        if (this.cet != null) {
            if (aiH()) {
                this.cet.aiD();
            } else {
                this.cet.aiE();
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean aiH() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aiH();
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
                this.cen.check(b.e.invoice_type_company);
                this.cep.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.cen.check(b.e.invoice_type_personal);
                this.ceq.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean aiI() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aiI();
    }

    private e getCurrentInvoiceView() {
        if (this.ceo == null) {
            return null;
        }
        if (this.ceo.getDisplayedChild() == 0) {
            return this.cep;
        }
        if (this.ceo.getDisplayedChild() == 1) {
            return this.ceq;
        }
        return null;
    }
}

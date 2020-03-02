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
    private RadioGroup ceb;
    private ViewSwitcher cec;
    private InvoiceCompanyInfoView ced;
    private InvoicePersonalInfoView cee;
    private TextWatcher cef;
    private RadioGroup.OnCheckedChangeListener ceg;
    private b ceh;
    private LinearLayout cei;
    private TextView cej;
    private RadioButton cek;
    private RadioButton cel;
    private View cem;
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
        this.ceb = (RadioGroup) findViewById(b.e.invoice_type_group);
        this.cec = (ViewSwitcher) findViewById(b.e.invoice_type_switcher);
        this.cej = (TextView) findViewById(b.e.invoice_type_desc);
        this.cek = (RadioButton) findViewById(b.e.invoice_type_company);
        this.cel = (RadioButton) findViewById(b.e.invoice_type_personal);
        this.cem = findViewById(b.e.divider_line);
        this.cei = (LinearLayout) findViewById(b.e.invoice_type_area);
        this.cej.setTextColor(getResources().getColor(b.C0318b.invoice_type));
        this.cek.setTextColor(getResources().getColor(b.C0318b.invoice_type_company));
        this.cek.setButtonDrawable(getResources().getDrawable(b.d.radio_button_selector));
        this.cel.setTextColor(getResources().getColor(b.C0318b.invoice_type_personal));
        this.cel.setButtonDrawable(getResources().getDrawable(b.d.radio_button_selector));
        this.cem.setBackground(getResources().getDrawable(b.C0318b.invoice_info_item_divider_line));
        this.cei.setBackground(getResources().getDrawable(b.C0318b.invoice_edit_view_bg));
        this.ceg = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == b.e.invoice_type_company) {
                    InvoiceInfoEditView.this.cec.setDisplayedChild(0);
                } else if (i == b.e.invoice_type_personal) {
                    InvoiceInfoEditView.this.cec.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.ceh != null) {
                    InvoiceInfoEditView.this.ceh.aiC();
                }
            }
        };
        this.ceb.setOnCheckedChangeListener(this.ceg);
        this.ced = new InvoiceCompanyInfoView(context);
        this.cee = new InvoicePersonalInfoView(context);
        this.cec.addView(this.ced, 0);
        this.cec.addView(this.cee, 1);
        this.cef = new TextWatcher() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.aiJ();
            }
        };
        this.cee.setTextChangedListener(this.cef);
        this.ced.setTextChangedListener(this.cef);
        this.ceb.check(b.e.invoice_type_company);
    }

    public void aiI() {
        if (this.cee != null) {
            this.cee.a(this.cef);
        }
        if (this.ced != null) {
            this.ced.a(this.cef);
        }
    }

    public void setInputStatusListener(com.baidu.swan.bdprivate.invoice.b bVar) {
        this.ceh = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiJ() {
        if (this.ceh != null) {
            if (aiE()) {
                this.ceh.aiA();
            } else {
                this.ceh.aiB();
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean aiE() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aiE();
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
                this.ceb.check(b.e.invoice_type_company);
                this.ced.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.ceb.check(b.e.invoice_type_personal);
                this.cee.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean aiF() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aiF();
    }

    private e getCurrentInvoiceView() {
        if (this.cec == null) {
            return null;
        }
        if (this.cec.getDisplayedChild() == 0) {
            return this.ced;
        }
        if (this.cec.getDisplayedChild() == 1) {
            return this.cee;
        }
        return null;
    }
}

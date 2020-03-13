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
    private RadioGroup cec;
    private ViewSwitcher ced;
    private InvoiceCompanyInfoView cee;
    private InvoicePersonalInfoView cef;
    private TextWatcher ceg;
    private RadioGroup.OnCheckedChangeListener ceh;
    private b cei;
    private LinearLayout cej;
    private TextView cek;
    private RadioButton cel;
    private RadioButton cem;
    private View cen;
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
        this.cec = (RadioGroup) findViewById(b.e.invoice_type_group);
        this.ced = (ViewSwitcher) findViewById(b.e.invoice_type_switcher);
        this.cek = (TextView) findViewById(b.e.invoice_type_desc);
        this.cel = (RadioButton) findViewById(b.e.invoice_type_company);
        this.cem = (RadioButton) findViewById(b.e.invoice_type_personal);
        this.cen = findViewById(b.e.divider_line);
        this.cej = (LinearLayout) findViewById(b.e.invoice_type_area);
        this.cek.setTextColor(getResources().getColor(b.C0318b.invoice_type));
        this.cel.setTextColor(getResources().getColor(b.C0318b.invoice_type_company));
        this.cel.setButtonDrawable(getResources().getDrawable(b.d.radio_button_selector));
        this.cem.setTextColor(getResources().getColor(b.C0318b.invoice_type_personal));
        this.cem.setButtonDrawable(getResources().getDrawable(b.d.radio_button_selector));
        this.cen.setBackground(getResources().getDrawable(b.C0318b.invoice_info_item_divider_line));
        this.cej.setBackground(getResources().getDrawable(b.C0318b.invoice_edit_view_bg));
        this.ceh = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == b.e.invoice_type_company) {
                    InvoiceInfoEditView.this.ced.setDisplayedChild(0);
                } else if (i == b.e.invoice_type_personal) {
                    InvoiceInfoEditView.this.ced.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.cei != null) {
                    InvoiceInfoEditView.this.cei.aiC();
                }
            }
        };
        this.cec.setOnCheckedChangeListener(this.ceh);
        this.cee = new InvoiceCompanyInfoView(context);
        this.cef = new InvoicePersonalInfoView(context);
        this.ced.addView(this.cee, 0);
        this.ced.addView(this.cef, 1);
        this.ceg = new TextWatcher() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoEditView.2
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
        this.cef.setTextChangedListener(this.ceg);
        this.cee.setTextChangedListener(this.ceg);
        this.cec.check(b.e.invoice_type_company);
    }

    public void aiI() {
        if (this.cef != null) {
            this.cef.a(this.ceg);
        }
        if (this.cee != null) {
            this.cee.a(this.ceg);
        }
    }

    public void setInputStatusListener(com.baidu.swan.bdprivate.invoice.b bVar) {
        this.cei = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiJ() {
        if (this.cei != null) {
            if (aiE()) {
                this.cei.aiA();
            } else {
                this.cei.aiB();
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
                this.cec.check(b.e.invoice_type_company);
                this.cee.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.cec.check(b.e.invoice_type_personal);
                this.cef.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean aiF() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aiF();
    }

    private e getCurrentInvoiceView() {
        if (this.ced == null) {
            return null;
        }
        if (this.ced.getDisplayedChild() == 0) {
            return this.cee;
        }
        if (this.ced.getDisplayedChild() == 1) {
            return this.cef;
        }
        return null;
    }
}

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
    private RadioGroup cea;
    private ViewSwitcher ceb;
    private InvoiceCompanyInfoView cec;
    private InvoicePersonalInfoView ced;
    private TextWatcher cee;
    private RadioGroup.OnCheckedChangeListener cef;
    private b ceg;
    private LinearLayout ceh;
    private TextView cei;
    private RadioButton cej;
    private RadioButton cek;
    private View cel;
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
        this.cea = (RadioGroup) findViewById(b.e.invoice_type_group);
        this.ceb = (ViewSwitcher) findViewById(b.e.invoice_type_switcher);
        this.cei = (TextView) findViewById(b.e.invoice_type_desc);
        this.cej = (RadioButton) findViewById(b.e.invoice_type_company);
        this.cek = (RadioButton) findViewById(b.e.invoice_type_personal);
        this.cel = findViewById(b.e.divider_line);
        this.ceh = (LinearLayout) findViewById(b.e.invoice_type_area);
        this.cei.setTextColor(getResources().getColor(b.C0318b.invoice_type));
        this.cej.setTextColor(getResources().getColor(b.C0318b.invoice_type_company));
        this.cej.setButtonDrawable(getResources().getDrawable(b.d.radio_button_selector));
        this.cek.setTextColor(getResources().getColor(b.C0318b.invoice_type_personal));
        this.cek.setButtonDrawable(getResources().getDrawable(b.d.radio_button_selector));
        this.cel.setBackground(getResources().getDrawable(b.C0318b.invoice_info_item_divider_line));
        this.ceh.setBackground(getResources().getDrawable(b.C0318b.invoice_edit_view_bg));
        this.cef = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == b.e.invoice_type_company) {
                    InvoiceInfoEditView.this.ceb.setDisplayedChild(0);
                } else if (i == b.e.invoice_type_personal) {
                    InvoiceInfoEditView.this.ceb.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.ceg != null) {
                    InvoiceInfoEditView.this.ceg.aiA();
                }
            }
        };
        this.cea.setOnCheckedChangeListener(this.cef);
        this.cec = new InvoiceCompanyInfoView(context);
        this.ced = new InvoicePersonalInfoView(context);
        this.ceb.addView(this.cec, 0);
        this.ceb.addView(this.ced, 1);
        this.cee = new TextWatcher() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.aiH();
            }
        };
        this.ced.setTextChangedListener(this.cee);
        this.cec.setTextChangedListener(this.cee);
        this.cea.check(b.e.invoice_type_company);
    }

    public void aiG() {
        if (this.ced != null) {
            this.ced.a(this.cee);
        }
        if (this.cec != null) {
            this.cec.a(this.cee);
        }
    }

    public void setInputStatusListener(com.baidu.swan.bdprivate.invoice.b bVar) {
        this.ceg = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiH() {
        if (this.ceg != null) {
            if (aiC()) {
                this.ceg.aiy();
            } else {
                this.ceg.aiz();
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean aiC() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aiC();
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
                this.cea.check(b.e.invoice_type_company);
                this.cec.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.cea.check(b.e.invoice_type_personal);
                this.ced.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean aiD() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aiD();
    }

    private e getCurrentInvoiceView() {
        if (this.ceb == null) {
            return null;
        }
        if (this.ceb.getDisplayedChild() == 0) {
            return this.cec;
        }
        if (this.ceb.getDisplayedChild() == 1) {
            return this.ced;
        }
        return null;
    }
}

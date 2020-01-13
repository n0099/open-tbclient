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
/* loaded from: classes10.dex */
public class InvoiceInfoEditView extends FrameLayout implements e {
    private RadioGroup bZU;
    private ViewSwitcher bZV;
    private InvoiceCompanyInfoView bZW;
    private InvoicePersonalInfoView bZX;
    private TextWatcher bZY;
    private RadioGroup.OnCheckedChangeListener bZZ;
    private b caa;
    private LinearLayout cab;
    private TextView cac;
    private RadioButton cad;
    private RadioButton cae;
    private View caf;
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
        this.bZU = (RadioGroup) findViewById(b.e.invoice_type_group);
        this.bZV = (ViewSwitcher) findViewById(b.e.invoice_type_switcher);
        this.cac = (TextView) findViewById(b.e.invoice_type_desc);
        this.cad = (RadioButton) findViewById(b.e.invoice_type_company);
        this.cae = (RadioButton) findViewById(b.e.invoice_type_personal);
        this.caf = findViewById(b.e.divider_line);
        this.cab = (LinearLayout) findViewById(b.e.invoice_type_area);
        this.cac.setTextColor(getResources().getColor(b.C0308b.invoice_type));
        this.cad.setTextColor(getResources().getColor(b.C0308b.invoice_type_company));
        this.cad.setButtonDrawable(getResources().getDrawable(b.d.radio_button_selector));
        this.cae.setTextColor(getResources().getColor(b.C0308b.invoice_type_personal));
        this.cae.setButtonDrawable(getResources().getDrawable(b.d.radio_button_selector));
        this.caf.setBackground(getResources().getDrawable(b.C0308b.invoice_info_item_divider_line));
        this.cab.setBackground(getResources().getDrawable(b.C0308b.invoice_edit_view_bg));
        this.bZZ = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == b.e.invoice_type_company) {
                    InvoiceInfoEditView.this.bZV.setDisplayedChild(0);
                } else if (i == b.e.invoice_type_personal) {
                    InvoiceInfoEditView.this.bZV.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.caa != null) {
                    InvoiceInfoEditView.this.caa.agm();
                }
            }
        };
        this.bZU.setOnCheckedChangeListener(this.bZZ);
        this.bZW = new InvoiceCompanyInfoView(context);
        this.bZX = new InvoicePersonalInfoView(context);
        this.bZV.addView(this.bZW, 0);
        this.bZV.addView(this.bZX, 1);
        this.bZY = new TextWatcher() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.agt();
            }
        };
        this.bZX.setTextChangedListener(this.bZY);
        this.bZW.setTextChangedListener(this.bZY);
        this.bZU.check(b.e.invoice_type_company);
    }

    public void ags() {
        if (this.bZX != null) {
            this.bZX.a(this.bZY);
        }
        if (this.bZW != null) {
            this.bZW.a(this.bZY);
        }
    }

    public void setInputStatusListener(com.baidu.swan.bdprivate.invoice.b bVar) {
        this.caa = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agt() {
        if (this.caa != null) {
            if (ago()) {
                this.caa.agk();
            } else {
                this.caa.agl();
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean ago() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.ago();
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
                this.bZU.check(b.e.invoice_type_company);
                this.bZW.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.bZU.check(b.e.invoice_type_personal);
                this.bZX.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean agp() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.agp();
    }

    private e getCurrentInvoiceView() {
        if (this.bZV == null) {
            return null;
        }
        if (this.bZV.getDisplayedChild() == 0) {
            return this.bZW;
        }
        if (this.bZV.getDisplayedChild() == 1) {
            return this.bZX;
        }
        return null;
    }
}

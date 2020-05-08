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
    private RadioButton cDA;
    private RadioButton cDB;
    private View cDC;
    private RadioGroup cDr;
    private ViewSwitcher cDs;
    private InvoiceCompanyInfoView cDt;
    private InvoicePersonalInfoView cDu;
    private TextWatcher cDv;
    private RadioGroup.OnCheckedChangeListener cDw;
    private b cDx;
    private LinearLayout cDy;
    private TextView cDz;
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
        this.cDr = (RadioGroup) findViewById(b.e.invoice_type_group);
        this.cDs = (ViewSwitcher) findViewById(b.e.invoice_type_switcher);
        this.cDz = (TextView) findViewById(b.e.invoice_type_desc);
        this.cDA = (RadioButton) findViewById(b.e.invoice_type_company);
        this.cDB = (RadioButton) findViewById(b.e.invoice_type_personal);
        this.cDC = findViewById(b.e.divider_line);
        this.cDy = (LinearLayout) findViewById(b.e.invoice_type_area);
        this.cDz.setTextColor(getResources().getColor(b.C0369b.invoice_type));
        this.cDA.setTextColor(getResources().getColor(b.C0369b.invoice_type_company));
        this.cDA.setButtonDrawable(getResources().getDrawable(b.d.radio_button_selector));
        this.cDB.setTextColor(getResources().getColor(b.C0369b.invoice_type_personal));
        this.cDB.setButtonDrawable(getResources().getDrawable(b.d.radio_button_selector));
        this.cDC.setBackground(getResources().getDrawable(b.C0369b.invoice_info_item_divider_line));
        this.cDy.setBackground(getResources().getDrawable(b.C0369b.invoice_edit_view_bg));
        this.cDw = new RadioGroup.OnCheckedChangeListener() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoEditView.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == b.e.invoice_type_company) {
                    InvoiceInfoEditView.this.cDs.setDisplayedChild(0);
                } else if (i == b.e.invoice_type_personal) {
                    InvoiceInfoEditView.this.cDs.setDisplayedChild(1);
                }
                if (InvoiceInfoEditView.this.cDx != null) {
                    InvoiceInfoEditView.this.cDx.aqM();
                }
            }
        };
        this.cDr.setOnCheckedChangeListener(this.cDw);
        this.cDt = new InvoiceCompanyInfoView(context);
        this.cDu = new InvoicePersonalInfoView(context);
        this.cDs.addView(this.cDt, 0);
        this.cDs.addView(this.cDu, 1);
        this.cDv = new TextWatcher() { // from class: com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoEditView.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                InvoiceInfoEditView.this.aqT();
            }
        };
        this.cDu.setTextChangedListener(this.cDv);
        this.cDt.setTextChangedListener(this.cDv);
        this.cDr.check(b.e.invoice_type_company);
    }

    public void aqS() {
        if (this.cDu != null) {
            this.cDu.a(this.cDv);
        }
        if (this.cDt != null) {
            this.cDt.a(this.cDv);
        }
    }

    public void setInputStatusListener(com.baidu.swan.bdprivate.invoice.b bVar) {
        this.cDx = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqT() {
        if (this.cDx != null) {
            if (aqO()) {
                this.cDx.aqK();
            } else {
                this.cDx.aqL();
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean aqO() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aqO();
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
                this.cDr.check(b.e.invoice_type_company);
                this.cDt.d(invoiceInfo);
            } else if (invoiceInfo.mType == 1) {
                this.cDr.check(b.e.invoice_type_personal);
                this.cDu.d(invoiceInfo);
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean aqP() {
        e currentInvoiceView = getCurrentInvoiceView();
        return currentInvoiceView != null && currentInvoiceView.aqP();
    }

    private e getCurrentInvoiceView() {
        if (this.cDs == null) {
            return null;
        }
        if (this.cDs.getDisplayedChild() == 0) {
            return this.cDt;
        }
        if (this.cDs.getDisplayedChild() == 1) {
            return this.cDu;
        }
        return null;
    }
}

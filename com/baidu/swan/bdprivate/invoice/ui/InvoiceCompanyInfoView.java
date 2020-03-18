package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.invoice.model.InvoiceInfo;
import com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes11.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView ceb;
    private InvoiceInfoItemView cec;
    private InvoiceInfoItemView ced;
    private InvoiceInfoItemView cee;
    private InvoiceInfoItemView cef;
    private InvoiceInfoItemView ceg;

    public InvoiceCompanyInfoView(Context context) {
        this(context, null);
    }

    public InvoiceCompanyInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InvoiceCompanyInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        this.ceb = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().er(true).es(true).nn(context.getString(b.g.invoice_desc_name)).no(context.getString(b.g.invoice_hint_name)).np(InvoiceInfo.REG_NON_EMPTY).nq(context.getString(b.g.invoice_err_msg_name)));
        this.cec = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().er(true).nn(context.getString(b.g.invoice_desc_tax_number)).es(true).hv(2).nr(context.getString(b.g.alphabet_and_number)).no(context.getString(b.g.invoice_hint_tax_number)).np(InvoiceInfo.REG_NON_EMPTY).nq(context.getString(b.g.invoice_err_msg_tax_number)));
        this.ced = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().es(true).nn(context.getString(b.g.invoice_desc_company_address)).no(context.getString(b.g.invoice_hint_company_address)));
        this.cee = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().nn(context.getString(b.g.invoice_desc_mobile)).es(true).hv(2).no(context.getString(b.g.invoice_hint_mobile)));
        this.cef = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().es(true).nn(context.getString(b.g.invoice_desc_bank)).no(context.getString(b.g.invoice_hint_bank)));
        this.ceg = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().nn(context.getString(b.g.invoice_desc_bank_account)).es(true).hv(2).no(context.getString(b.g.invoice_hint_bank_account)));
        this.cea = new InvoiceInfoItemView[]{this.ceb, this.cec, this.ced, this.cee, this.cef, this.ceg};
        for (int i = 0; i < this.cea.length; i++) {
            addView(this.cea[i], i);
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.ceb.getContent(), this.cec.getContent(), this.ced.getContent(), this.cee.getContent(), this.cef.getContent(), this.ceg.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.ceb.setContent(invoiceInfo.mTitle);
            this.cec.setContent(invoiceInfo.mTaxNumber);
            this.ced.setContent(invoiceInfo.mCompanyAddress);
            this.cee.setContent(invoiceInfo.mTelephone);
            this.cef.setContent(invoiceInfo.mBankName);
            this.ceg.setContent(invoiceInfo.mBankAccount);
        }
    }
}

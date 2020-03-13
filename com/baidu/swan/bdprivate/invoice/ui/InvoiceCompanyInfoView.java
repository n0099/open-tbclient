package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.invoice.model.InvoiceInfo;
import com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes11.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView cdQ;
    private InvoiceInfoItemView cdR;
    private InvoiceInfoItemView cdS;
    private InvoiceInfoItemView cdT;
    private InvoiceInfoItemView cdU;
    private InvoiceInfoItemView cdV;

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
        this.cdQ = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().eq(true).er(true).no(context.getString(b.g.invoice_desc_name)).np(context.getString(b.g.invoice_hint_name)).nq(InvoiceInfo.REG_NON_EMPTY).nr(context.getString(b.g.invoice_err_msg_name)));
        this.cdR = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().eq(true).no(context.getString(b.g.invoice_desc_tax_number)).er(true).hv(2).ns(context.getString(b.g.alphabet_and_number)).np(context.getString(b.g.invoice_hint_tax_number)).nq(InvoiceInfo.REG_NON_EMPTY).nr(context.getString(b.g.invoice_err_msg_tax_number)));
        this.cdS = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().er(true).no(context.getString(b.g.invoice_desc_company_address)).np(context.getString(b.g.invoice_hint_company_address)));
        this.cdT = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().no(context.getString(b.g.invoice_desc_mobile)).er(true).hv(2).np(context.getString(b.g.invoice_hint_mobile)));
        this.cdU = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().er(true).no(context.getString(b.g.invoice_desc_bank)).np(context.getString(b.g.invoice_hint_bank)));
        this.cdV = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().no(context.getString(b.g.invoice_desc_bank_account)).er(true).hv(2).np(context.getString(b.g.invoice_hint_bank_account)));
        this.cdP = new InvoiceInfoItemView[]{this.cdQ, this.cdR, this.cdS, this.cdT, this.cdU, this.cdV};
        for (int i = 0; i < this.cdP.length; i++) {
            addView(this.cdP[i], i);
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.cdQ.getContent(), this.cdR.getContent(), this.cdS.getContent(), this.cdT.getContent(), this.cdU.getContent(), this.cdV.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.cdQ.setContent(invoiceInfo.mTitle);
            this.cdR.setContent(invoiceInfo.mTaxNumber);
            this.cdS.setContent(invoiceInfo.mCompanyAddress);
            this.cdT.setContent(invoiceInfo.mTelephone);
            this.cdU.setContent(invoiceInfo.mBankName);
            this.cdV.setContent(invoiceInfo.mBankAccount);
        }
    }
}

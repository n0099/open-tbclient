package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.invoice.model.InvoiceInfo;
import com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes10.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView bZI;
    private InvoiceInfoItemView bZJ;
    private InvoiceInfoItemView bZK;
    private InvoiceInfoItemView bZL;
    private InvoiceInfoItemView bZM;
    private InvoiceInfoItemView bZN;

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
        this.bZI = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().ej(true).ek(true).mZ(context.getString(b.g.invoice_desc_name)).na(context.getString(b.g.invoice_hint_name)).nb(InvoiceInfo.REG_NON_EMPTY).nc(context.getString(b.g.invoice_err_msg_name)));
        this.bZJ = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().ej(true).mZ(context.getString(b.g.invoice_desc_tax_number)).ek(true).he(2).nd(context.getString(b.g.alphabet_and_number)).na(context.getString(b.g.invoice_hint_tax_number)).nb(InvoiceInfo.REG_NON_EMPTY).nc(context.getString(b.g.invoice_err_msg_tax_number)));
        this.bZK = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().ek(true).mZ(context.getString(b.g.invoice_desc_company_address)).na(context.getString(b.g.invoice_hint_company_address)));
        this.bZL = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().mZ(context.getString(b.g.invoice_desc_mobile)).ek(true).he(2).na(context.getString(b.g.invoice_hint_mobile)));
        this.bZM = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().ek(true).mZ(context.getString(b.g.invoice_desc_bank)).na(context.getString(b.g.invoice_hint_bank)));
        this.bZN = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().mZ(context.getString(b.g.invoice_desc_bank_account)).ek(true).he(2).na(context.getString(b.g.invoice_hint_bank_account)));
        this.bZH = new InvoiceInfoItemView[]{this.bZI, this.bZJ, this.bZK, this.bZL, this.bZM, this.bZN};
        for (int i = 0; i < this.bZH.length; i++) {
            addView(this.bZH[i], i);
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.bZI.getContent(), this.bZJ.getContent(), this.bZK.getContent(), this.bZL.getContent(), this.bZM.getContent(), this.bZN.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.bZI.setContent(invoiceInfo.mTitle);
            this.bZJ.setContent(invoiceInfo.mTaxNumber);
            this.bZK.setContent(invoiceInfo.mCompanyAddress);
            this.bZL.setContent(invoiceInfo.mTelephone);
            this.bZM.setContent(invoiceInfo.mBankName);
            this.bZN.setContent(invoiceInfo.mBankAccount);
        }
    }
}

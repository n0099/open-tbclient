package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.invoice.model.InvoiceInfo;
import com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes9.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView bZA;
    private InvoiceInfoItemView bZB;
    private InvoiceInfoItemView bZw;
    private InvoiceInfoItemView bZx;
    private InvoiceInfoItemView bZy;
    private InvoiceInfoItemView bZz;

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
        this.bZw = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().ee(true).ef(true).mW(context.getString(b.g.invoice_desc_name)).mX(context.getString(b.g.invoice_hint_name)).mY(InvoiceInfo.REG_NON_EMPTY).mZ(context.getString(b.g.invoice_err_msg_name)));
        this.bZx = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().ee(true).mW(context.getString(b.g.invoice_desc_tax_number)).ef(true).he(2).na(context.getString(b.g.alphabet_and_number)).mX(context.getString(b.g.invoice_hint_tax_number)).mY(InvoiceInfo.REG_NON_EMPTY).mZ(context.getString(b.g.invoice_err_msg_tax_number)));
        this.bZy = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().ef(true).mW(context.getString(b.g.invoice_desc_company_address)).mX(context.getString(b.g.invoice_hint_company_address)));
        this.bZz = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().mW(context.getString(b.g.invoice_desc_mobile)).ef(true).he(2).mX(context.getString(b.g.invoice_hint_mobile)));
        this.bZA = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().ef(true).mW(context.getString(b.g.invoice_desc_bank)).mX(context.getString(b.g.invoice_hint_bank)));
        this.bZB = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().mW(context.getString(b.g.invoice_desc_bank_account)).ef(true).he(2).mX(context.getString(b.g.invoice_hint_bank_account)));
        this.bZv = new InvoiceInfoItemView[]{this.bZw, this.bZx, this.bZy, this.bZz, this.bZA, this.bZB};
        for (int i = 0; i < this.bZv.length; i++) {
            addView(this.bZv[i], i);
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.bZw.getContent(), this.bZx.getContent(), this.bZy.getContent(), this.bZz.getContent(), this.bZA.getContent(), this.bZB.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.bZw.setContent(invoiceInfo.mTitle);
            this.bZx.setContent(invoiceInfo.mTaxNumber);
            this.bZy.setContent(invoiceInfo.mCompanyAddress);
            this.bZz.setContent(invoiceInfo.mTelephone);
            this.bZA.setContent(invoiceInfo.mBankName);
            this.bZB.setContent(invoiceInfo.mBankAccount);
        }
    }
}

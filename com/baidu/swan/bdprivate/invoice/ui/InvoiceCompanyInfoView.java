package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.invoice.model.InvoiceInfo;
import com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes11.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView cCZ;
    private InvoiceInfoItemView cDa;
    private InvoiceInfoItemView cDb;
    private InvoiceInfoItemView cDc;
    private InvoiceInfoItemView cDd;
    private InvoiceInfoItemView cDe;

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
        this.cCZ = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fo(true).fp(true).oC(context.getString(b.g.invoice_desc_name)).oD(context.getString(b.g.invoice_hint_name)).oE(InvoiceInfo.REG_NON_EMPTY).oF(context.getString(b.g.invoice_err_msg_name)));
        this.cDa = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fo(true).oC(context.getString(b.g.invoice_desc_tax_number)).fp(true).hC(2).oG(context.getString(b.g.alphabet_and_number)).oD(context.getString(b.g.invoice_hint_tax_number)).oE(InvoiceInfo.REG_NON_EMPTY).oF(context.getString(b.g.invoice_err_msg_tax_number)));
        this.cDb = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fp(true).oC(context.getString(b.g.invoice_desc_company_address)).oD(context.getString(b.g.invoice_hint_company_address)));
        this.cDc = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().oC(context.getString(b.g.invoice_desc_mobile)).fp(true).hC(2).oD(context.getString(b.g.invoice_hint_mobile)));
        this.cDd = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fp(true).oC(context.getString(b.g.invoice_desc_bank)).oD(context.getString(b.g.invoice_hint_bank)));
        this.cDe = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().oC(context.getString(b.g.invoice_desc_bank_account)).fp(true).hC(2).oD(context.getString(b.g.invoice_hint_bank_account)));
        this.cCY = new InvoiceInfoItemView[]{this.cCZ, this.cDa, this.cDb, this.cDc, this.cDd, this.cDe};
        for (int i = 0; i < this.cCY.length; i++) {
            addView(this.cCY[i], i);
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.cCZ.getContent(), this.cDa.getContent(), this.cDb.getContent(), this.cDc.getContent(), this.cDd.getContent(), this.cDe.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.cCZ.setContent(invoiceInfo.mTitle);
            this.cDa.setContent(invoiceInfo.mTaxNumber);
            this.cDb.setContent(invoiceInfo.mCompanyAddress);
            this.cDc.setContent(invoiceInfo.mTelephone);
            this.cDd.setContent(invoiceInfo.mBankName);
            this.cDe.setContent(invoiceInfo.mBankAccount);
        }
    }
}

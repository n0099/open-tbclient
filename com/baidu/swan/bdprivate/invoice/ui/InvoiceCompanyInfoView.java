package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.invoice.model.InvoiceInfo;
import com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes11.dex */
public class InvoiceCompanyInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView cDf;
    private InvoiceInfoItemView cDg;
    private InvoiceInfoItemView cDh;
    private InvoiceInfoItemView cDi;
    private InvoiceInfoItemView cDj;
    private InvoiceInfoItemView cDk;

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
        this.cDf = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fo(true).fp(true).oC(context.getString(b.g.invoice_desc_name)).oD(context.getString(b.g.invoice_hint_name)).oE(InvoiceInfo.REG_NON_EMPTY).oF(context.getString(b.g.invoice_err_msg_name)));
        this.cDg = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fo(true).oC(context.getString(b.g.invoice_desc_tax_number)).fp(true).hC(2).oG(context.getString(b.g.alphabet_and_number)).oD(context.getString(b.g.invoice_hint_tax_number)).oE(InvoiceInfo.REG_NON_EMPTY).oF(context.getString(b.g.invoice_err_msg_tax_number)));
        this.cDh = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fp(true).oC(context.getString(b.g.invoice_desc_company_address)).oD(context.getString(b.g.invoice_hint_company_address)));
        this.cDi = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().oC(context.getString(b.g.invoice_desc_mobile)).fp(true).hC(2).oD(context.getString(b.g.invoice_hint_mobile)));
        this.cDj = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fp(true).oC(context.getString(b.g.invoice_desc_bank)).oD(context.getString(b.g.invoice_hint_bank)));
        this.cDk = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().oC(context.getString(b.g.invoice_desc_bank_account)).fp(true).hC(2).oD(context.getString(b.g.invoice_hint_bank_account)));
        this.cDe = new InvoiceInfoItemView[]{this.cDf, this.cDg, this.cDh, this.cDi, this.cDj, this.cDk};
        for (int i = 0; i < this.cDe.length; i++) {
            addView(this.cDe[i], i);
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(0, this.cDf.getContent(), this.cDg.getContent(), this.cDh.getContent(), this.cDi.getContent(), this.cDj.getContent(), this.cDk.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.cDf.setContent(invoiceInfo.mTitle);
            this.cDg.setContent(invoiceInfo.mTaxNumber);
            this.cDh.setContent(invoiceInfo.mCompanyAddress);
            this.cDi.setContent(invoiceInfo.mTelephone);
            this.cDj.setContent(invoiceInfo.mBankName);
            this.cDk.setContent(invoiceInfo.mBankAccount);
        }
    }
}

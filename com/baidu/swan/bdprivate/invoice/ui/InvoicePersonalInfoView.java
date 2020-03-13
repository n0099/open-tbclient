package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.invoice.model.InvoiceInfo;
import com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes11.dex */
public class InvoicePersonalInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView cdQ;
    private InvoiceInfoItemView cdT;

    public InvoicePersonalInfoView(Context context) {
        this(context, null);
    }

    public InvoicePersonalInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InvoicePersonalInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        this.cdQ = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().eq(true).no(context.getString(b.g.invoice_desc_name)).er(true).np(context.getString(b.g.invoice_hint_personal_name)).nq(InvoiceInfo.REG_NON_EMPTY).nr(context.getString(b.g.invoice_err_msg_personal_name)));
        this.cdT = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().no(context.getString(b.g.invoice_desc_mobile)).er(true).hv(2).np(context.getString(b.g.invoice_hint_mobile)));
        this.cdP = new InvoiceInfoItemView[]{this.cdQ, this.cdT};
        for (int i = 0; i < this.cdP.length; i++) {
            addView(this.cdP[i], i);
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(1, this.cdQ.getContent(), this.cdT.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.cdQ.setContent(invoiceInfo.mTitle);
            this.cdT.setContent(invoiceInfo.mTelephone);
        }
    }
}

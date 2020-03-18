package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.invoice.model.InvoiceInfo;
import com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes11.dex */
public class InvoicePersonalInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView ceb;
    private InvoiceInfoItemView cee;

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
        this.ceb = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().er(true).nn(context.getString(b.g.invoice_desc_name)).es(true).no(context.getString(b.g.invoice_hint_personal_name)).np(InvoiceInfo.REG_NON_EMPTY).nq(context.getString(b.g.invoice_err_msg_personal_name)));
        this.cee = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().nn(context.getString(b.g.invoice_desc_mobile)).es(true).hv(2).no(context.getString(b.g.invoice_hint_mobile)));
        this.cea = new InvoiceInfoItemView[]{this.ceb, this.cee};
        for (int i = 0; i < this.cea.length; i++) {
            addView(this.cea[i], i);
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(1, this.ceb.getContent(), this.cee.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.ceb.setContent(invoiceInfo.mTitle);
            this.cee.setContent(invoiceInfo.mTelephone);
        }
    }
}

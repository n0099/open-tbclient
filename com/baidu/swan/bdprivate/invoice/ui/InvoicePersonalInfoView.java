package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.invoice.model.InvoiceInfo;
import com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes11.dex */
public class InvoicePersonalInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView cdO;
    private InvoiceInfoItemView cdR;

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
        this.cdO = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().eq(true).no(context.getString(b.g.invoice_desc_name)).er(true).np(context.getString(b.g.invoice_hint_personal_name)).nq(InvoiceInfo.REG_NON_EMPTY).nr(context.getString(b.g.invoice_err_msg_personal_name)));
        this.cdR = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().no(context.getString(b.g.invoice_desc_mobile)).er(true).hv(2).np(context.getString(b.g.invoice_hint_mobile)));
        this.cdN = new InvoiceInfoItemView[]{this.cdO, this.cdR};
        for (int i = 0; i < this.cdN.length; i++) {
            addView(this.cdN[i], i);
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(1, this.cdO.getContent(), this.cdR.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.cdO.setContent(invoiceInfo.mTitle);
            this.cdR.setContent(invoiceInfo.mTelephone);
        }
    }
}

package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.invoice.model.InvoiceInfo;
import com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes10.dex */
public class InvoicePersonalInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView bZI;
    private InvoiceInfoItemView bZL;

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
        this.bZI = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().ej(true).mZ(context.getString(b.g.invoice_desc_name)).ek(true).na(context.getString(b.g.invoice_hint_personal_name)).nb(InvoiceInfo.REG_NON_EMPTY).nc(context.getString(b.g.invoice_err_msg_personal_name)));
        this.bZL = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().mZ(context.getString(b.g.invoice_desc_mobile)).ek(true).he(2).na(context.getString(b.g.invoice_hint_mobile)));
        this.bZH = new InvoiceInfoItemView[]{this.bZI, this.bZL};
        for (int i = 0; i < this.bZH.length; i++) {
            addView(this.bZH[i], i);
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(1, this.bZI.getContent(), this.bZL.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.bZI.setContent(invoiceInfo.mTitle);
            this.bZL.setContent(invoiceInfo.mTelephone);
        }
    }
}

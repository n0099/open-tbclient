package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.invoice.model.InvoiceInfo;
import com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes11.dex */
public class InvoicePersonalInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView cCZ;
    private InvoiceInfoItemView cDc;

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
        this.cCZ = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().fo(true).oC(context.getString(b.g.invoice_desc_name)).fp(true).oD(context.getString(b.g.invoice_hint_personal_name)).oE(InvoiceInfo.REG_NON_EMPTY).oF(context.getString(b.g.invoice_err_msg_personal_name)));
        this.cDc = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().oC(context.getString(b.g.invoice_desc_mobile)).fp(true).hC(2).oD(context.getString(b.g.invoice_hint_mobile)));
        this.cCY = new InvoiceInfoItemView[]{this.cCZ, this.cDc};
        for (int i = 0; i < this.cCY.length; i++) {
            addView(this.cCY[i], i);
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(1, this.cCZ.getContent(), this.cDc.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.cCZ.setContent(invoiceInfo.mTitle);
            this.cDc.setContent(invoiceInfo.mTelephone);
        }
    }
}

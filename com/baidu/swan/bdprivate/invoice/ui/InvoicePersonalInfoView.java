package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.invoice.model.InvoiceInfo;
import com.baidu.swan.bdprivate.invoice.ui.InvoiceInfoItemView;
/* loaded from: classes9.dex */
public class InvoicePersonalInfoView extends InvoiceBaseInfoView {
    private InvoiceInfoItemView bZw;
    private InvoiceInfoItemView bZz;

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
        this.bZw = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().ee(true).mW(context.getString(b.g.invoice_desc_name)).ef(true).mX(context.getString(b.g.invoice_hint_personal_name)).mY(InvoiceInfo.REG_NON_EMPTY).mZ(context.getString(b.g.invoice_err_msg_personal_name)));
        this.bZz = new InvoiceInfoItemView(context).a(new InvoiceInfoItemView.a().mW(context.getString(b.g.invoice_desc_mobile)).ef(true).he(2).mX(context.getString(b.g.invoice_hint_mobile)));
        this.bZv = new InvoiceInfoItemView[]{this.bZw, this.bZz};
        for (int i = 0; i < this.bZv.length; i++) {
            addView(this.bZv[i], i);
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public InvoiceInfo getInvoiceInfo() {
        return new InvoiceInfo(1, this.bZw.getContent(), this.bZz.getContent());
    }

    public void d(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.bZw.setContent(invoiceInfo.mTitle);
            this.bZz.setContent(invoiceInfo.mTelephone);
        }
    }
}

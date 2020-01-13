package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.swan.bdprivate.invoice.e;
/* loaded from: classes10.dex */
public abstract class InvoiceBaseInfoView extends LinearLayout implements e {
    protected InvoiceInfoItemView[] bZH;

    public InvoiceBaseInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.bZH != null && textWatcher != null) {
            for (int i = 0; i < this.bZH.length; i++) {
                this.bZH[i].setTextChangedListener(textWatcher);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextWatcher textWatcher) {
        if (this.bZH != null && textWatcher != null) {
            for (int i = 0; i < this.bZH.length; i++) {
                this.bZH[i].a(textWatcher);
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean ago() {
        InvoiceInfoItemView[] invoiceInfoItemViewArr;
        if (this.bZH == null || this.bZH.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.bZH) {
            if (invoiceInfoItemView.agu() && TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean agp() {
        if (this.bZH == null || this.bZH.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.bZH) {
            if (!TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return true;
            }
        }
        return false;
    }
}

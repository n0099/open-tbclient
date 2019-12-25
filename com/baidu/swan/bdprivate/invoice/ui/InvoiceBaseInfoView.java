package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.swan.bdprivate.invoice.e;
/* loaded from: classes9.dex */
public abstract class InvoiceBaseInfoView extends LinearLayout implements e {
    protected InvoiceInfoItemView[] bZv;

    public InvoiceBaseInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.bZv != null && textWatcher != null) {
            for (int i = 0; i < this.bZv.length; i++) {
                this.bZv[i].setTextChangedListener(textWatcher);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextWatcher textWatcher) {
        if (this.bZv != null && textWatcher != null) {
            for (int i = 0; i < this.bZv.length; i++) {
                this.bZv[i].a(textWatcher);
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean afV() {
        InvoiceInfoItemView[] invoiceInfoItemViewArr;
        if (this.bZv == null || this.bZv.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.bZv) {
            if (invoiceInfoItemView.agb() && TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean afW() {
        if (this.bZv == null || this.bZv.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.bZv) {
            if (!TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return true;
            }
        }
        return false;
    }
}

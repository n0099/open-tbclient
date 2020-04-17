package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.swan.bdprivate.invoice.e;
/* loaded from: classes11.dex */
public abstract class InvoiceBaseInfoView extends LinearLayout implements e {
    protected InvoiceInfoItemView[] cCY;

    public InvoiceBaseInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.cCY != null && textWatcher != null) {
            for (int i = 0; i < this.cCY.length; i++) {
                this.cCY[i].setTextChangedListener(textWatcher);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextWatcher textWatcher) {
        if (this.cCY != null && textWatcher != null) {
            for (int i = 0; i < this.cCY.length; i++) {
                this.cCY[i].a(textWatcher);
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean aqP() {
        InvoiceInfoItemView[] invoiceInfoItemViewArr;
        if (this.cCY == null || this.cCY.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.cCY) {
            if (invoiceInfoItemView.aqV() && TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean aqQ() {
        if (this.cCY == null || this.cCY.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.cCY) {
            if (!TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return true;
            }
        }
        return false;
    }
}

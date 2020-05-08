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
    protected InvoiceInfoItemView[] cDe;

    public InvoiceBaseInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.cDe != null && textWatcher != null) {
            for (int i = 0; i < this.cDe.length; i++) {
                this.cDe[i].setTextChangedListener(textWatcher);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextWatcher textWatcher) {
        if (this.cDe != null && textWatcher != null) {
            for (int i = 0; i < this.cDe.length; i++) {
                this.cDe[i].a(textWatcher);
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean aqO() {
        InvoiceInfoItemView[] invoiceInfoItemViewArr;
        if (this.cDe == null || this.cDe.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.cDe) {
            if (invoiceInfoItemView.aqU() && TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean aqP() {
        if (this.cDe == null || this.cDe.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.cDe) {
            if (!TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return true;
            }
        }
        return false;
    }
}

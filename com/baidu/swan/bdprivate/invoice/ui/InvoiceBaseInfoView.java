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
    protected InvoiceInfoItemView[] cdP;

    public InvoiceBaseInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.cdP != null && textWatcher != null) {
            for (int i = 0; i < this.cdP.length; i++) {
                this.cdP[i].setTextChangedListener(textWatcher);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextWatcher textWatcher) {
        if (this.cdP != null && textWatcher != null) {
            for (int i = 0; i < this.cdP.length; i++) {
                this.cdP[i].a(textWatcher);
            }
        }
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean aiE() {
        InvoiceInfoItemView[] invoiceInfoItemViewArr;
        if (this.cdP == null || this.cdP.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.cdP) {
            if (invoiceInfoItemView.aiK() && TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.bdprivate.invoice.e
    public boolean aiF() {
        if (this.cdP == null || this.cdP.length == 0) {
            return false;
        }
        for (InvoiceInfoItemView invoiceInfoItemView : this.cdP) {
            if (!TextUtils.isEmpty(invoiceInfoItemView.getContent())) {
                return true;
            }
        }
        return false;
    }
}

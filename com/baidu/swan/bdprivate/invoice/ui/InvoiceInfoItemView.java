package com.baidu.swan.bdprivate.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes11.dex */
public class InvoiceInfoItemView extends RelativeLayout {
    private View cDC;
    private TextView cDE;
    private EditText cDF;
    private String cDG;
    private boolean cDH;
    private Context mContext;
    private String mErrorMessage;
    private RelativeLayout mRootView;

    public InvoiceInfoItemView(Context context) {
        this(context, null);
    }

    public InvoiceInfoItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InvoiceInfoItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        inflate(context, b.f.invoice_info_item_view, this);
        this.mRootView = (RelativeLayout) findViewById(b.e.item_root_view);
        this.mRootView.setBackground(getResources().getDrawable(b.C0369b.invoice_edit_view_bg));
        this.cDE = (TextView) findViewById(b.e.invoice_info_desc);
        this.cDF = (EditText) findViewById(b.e.invoice_info_content);
        this.cDC = findViewById(b.e.divider_line);
        this.cDE.setTextColor(getResources().getColor(b.C0369b.invoice_info_desc));
        this.cDF.setTextColor(getResources().getColor(b.C0369b.invoice_info_content));
        this.cDF.setHintTextColor(getResources().getColor(b.C0369b.invoice_info_content_hint));
        this.cDC.setBackground(getResources().getDrawable(b.C0369b.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.cDH = aVar.cDH;
            this.cDE.setText(aVar.mDesc);
            this.cDF.setHint(aVar.cDJ);
            if (!aVar.cDK) {
                this.cDF.setSingleLine();
            } else {
                aVar.cDI |= 131072;
            }
            this.cDF.setInputType(aVar.cDI);
            if (!TextUtils.isEmpty(aVar.cDL)) {
                this.cDF.setKeyListener(DigitsKeyListener.getInstance(aVar.cDL));
            }
            this.cDG = aVar.cDG;
            this.mErrorMessage = aVar.mErrorMessage;
        }
        return this;
    }

    public String getContent() {
        if (this.cDF != null) {
            return this.cDF.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.cDF != null) {
            this.cDF.setText(charSequence);
        }
    }

    public boolean aqU() {
        return this.cDH;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.cDF != null && textWatcher != null) {
            this.cDF.addTextChangedListener(textWatcher);
        }
    }

    public void a(TextWatcher textWatcher) {
        if (this.cDF != null) {
            this.cDF.removeTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        private String cDG;
        private boolean cDH = false;
        private int cDI = 1;
        private String cDJ;
        private boolean cDK;
        private String cDL;
        private String mDesc;
        private String mErrorMessage;

        public a fo(boolean z) {
            this.cDH = z;
            return this;
        }

        public a oC(String str) {
            this.mDesc = str;
            return this;
        }

        public a hC(int i) {
            this.cDI = i;
            return this;
        }

        public a oD(String str) {
            this.cDJ = str;
            return this;
        }

        public a oE(String str) {
            this.cDG = str;
            return this;
        }

        public a oF(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public a fp(boolean z) {
            this.cDK = z;
            return this;
        }

        public a oG(String str) {
            this.cDL = str;
            return this;
        }
    }
}

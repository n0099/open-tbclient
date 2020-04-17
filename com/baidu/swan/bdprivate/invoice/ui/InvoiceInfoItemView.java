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
    private String cDA;
    private boolean cDB;
    private View cDw;
    private TextView cDy;
    private EditText cDz;
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
        this.mRootView.setBackground(getResources().getDrawable(b.C0348b.invoice_edit_view_bg));
        this.cDy = (TextView) findViewById(b.e.invoice_info_desc);
        this.cDz = (EditText) findViewById(b.e.invoice_info_content);
        this.cDw = findViewById(b.e.divider_line);
        this.cDy.setTextColor(getResources().getColor(b.C0348b.invoice_info_desc));
        this.cDz.setTextColor(getResources().getColor(b.C0348b.invoice_info_content));
        this.cDz.setHintTextColor(getResources().getColor(b.C0348b.invoice_info_content_hint));
        this.cDw.setBackground(getResources().getDrawable(b.C0348b.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.cDB = aVar.cDB;
            this.cDy.setText(aVar.mDesc);
            this.cDz.setHint(aVar.cDD);
            if (!aVar.cDE) {
                this.cDz.setSingleLine();
            } else {
                aVar.cDC |= 131072;
            }
            this.cDz.setInputType(aVar.cDC);
            if (!TextUtils.isEmpty(aVar.cDF)) {
                this.cDz.setKeyListener(DigitsKeyListener.getInstance(aVar.cDF));
            }
            this.cDA = aVar.cDA;
            this.mErrorMessage = aVar.mErrorMessage;
        }
        return this;
    }

    public String getContent() {
        if (this.cDz != null) {
            return this.cDz.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.cDz != null) {
            this.cDz.setText(charSequence);
        }
    }

    public boolean aqV() {
        return this.cDB;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.cDz != null && textWatcher != null) {
            this.cDz.addTextChangedListener(textWatcher);
        }
    }

    public void a(TextWatcher textWatcher) {
        if (this.cDz != null) {
            this.cDz.removeTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        private String cDA;
        private boolean cDB = false;
        private int cDC = 1;
        private String cDD;
        private boolean cDE;
        private String cDF;
        private String mDesc;
        private String mErrorMessage;

        public a fo(boolean z) {
            this.cDB = z;
            return this;
        }

        public a oC(String str) {
            this.mDesc = str;
            return this;
        }

        public a hC(int i) {
            this.cDC = i;
            return this;
        }

        public a oD(String str) {
            this.cDD = str;
            return this;
        }

        public a oE(String str) {
            this.cDA = str;
            return this;
        }

        public a oF(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public a fp(boolean z) {
            this.cDE = z;
            return this;
        }

        public a oG(String str) {
            this.cDF = str;
            return this;
        }
    }
}

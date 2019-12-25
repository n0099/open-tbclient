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
/* loaded from: classes9.dex */
public class InvoiceInfoItemView extends RelativeLayout {
    private View bZT;
    private TextView bZV;
    private EditText bZW;
    private String bZX;
    private boolean bZY;
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
        this.mRootView.setBackground(getResources().getDrawable(b.C0306b.invoice_edit_view_bg));
        this.bZV = (TextView) findViewById(b.e.invoice_info_desc);
        this.bZW = (EditText) findViewById(b.e.invoice_info_content);
        this.bZT = findViewById(b.e.divider_line);
        this.bZV.setTextColor(getResources().getColor(b.C0306b.invoice_info_desc));
        this.bZW.setTextColor(getResources().getColor(b.C0306b.invoice_info_content));
        this.bZW.setHintTextColor(getResources().getColor(b.C0306b.invoice_info_content_hint));
        this.bZT.setBackground(getResources().getDrawable(b.C0306b.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.bZY = aVar.bZY;
            this.bZV.setText(aVar.mDesc);
            this.bZW.setHint(aVar.caa);
            if (!aVar.cab) {
                this.bZW.setSingleLine();
            } else {
                aVar.bZZ |= 131072;
            }
            this.bZW.setInputType(aVar.bZZ);
            if (!TextUtils.isEmpty(aVar.cac)) {
                this.bZW.setKeyListener(DigitsKeyListener.getInstance(aVar.cac));
            }
            this.bZX = aVar.bZX;
            this.mErrorMessage = aVar.mErrorMessage;
        }
        return this;
    }

    public String getContent() {
        if (this.bZW != null) {
            return this.bZW.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.bZW != null) {
            this.bZW.setText(charSequence);
        }
    }

    public boolean agb() {
        return this.bZY;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.bZW != null && textWatcher != null) {
            this.bZW.addTextChangedListener(textWatcher);
        }
    }

    public void a(TextWatcher textWatcher) {
        if (this.bZW != null) {
            this.bZW.removeTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        private String bZX;
        private boolean bZY = false;
        private int bZZ = 1;
        private String caa;
        private boolean cab;
        private String cac;
        private String mDesc;
        private String mErrorMessage;

        public a ee(boolean z) {
            this.bZY = z;
            return this;
        }

        public a mW(String str) {
            this.mDesc = str;
            return this;
        }

        public a he(int i) {
            this.bZZ = i;
            return this;
        }

        public a mX(String str) {
            this.caa = str;
            return this;
        }

        public a mY(String str) {
            this.bZX = str;
            return this;
        }

        public a mZ(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public a ef(boolean z) {
            this.cab = z;
            return this;
        }

        public a na(String str) {
            this.cac = str;
            return this;
        }
    }
}

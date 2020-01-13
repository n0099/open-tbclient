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
/* loaded from: classes10.dex */
public class InvoiceInfoItemView extends RelativeLayout {
    private View caf;
    private TextView cah;
    private EditText cai;
    private String caj;
    private boolean cak;
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
        this.mRootView.setBackground(getResources().getDrawable(b.C0308b.invoice_edit_view_bg));
        this.cah = (TextView) findViewById(b.e.invoice_info_desc);
        this.cai = (EditText) findViewById(b.e.invoice_info_content);
        this.caf = findViewById(b.e.divider_line);
        this.cah.setTextColor(getResources().getColor(b.C0308b.invoice_info_desc));
        this.cai.setTextColor(getResources().getColor(b.C0308b.invoice_info_content));
        this.cai.setHintTextColor(getResources().getColor(b.C0308b.invoice_info_content_hint));
        this.caf.setBackground(getResources().getDrawable(b.C0308b.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.cak = aVar.cak;
            this.cah.setText(aVar.mDesc);
            this.cai.setHint(aVar.cam);
            if (!aVar.can) {
                this.cai.setSingleLine();
            } else {
                aVar.cal |= 131072;
            }
            this.cai.setInputType(aVar.cal);
            if (!TextUtils.isEmpty(aVar.cao)) {
                this.cai.setKeyListener(DigitsKeyListener.getInstance(aVar.cao));
            }
            this.caj = aVar.caj;
            this.mErrorMessage = aVar.mErrorMessage;
        }
        return this;
    }

    public String getContent() {
        if (this.cai != null) {
            return this.cai.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.cai != null) {
            this.cai.setText(charSequence);
        }
    }

    public boolean agu() {
        return this.cak;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.cai != null && textWatcher != null) {
            this.cai.addTextChangedListener(textWatcher);
        }
    }

    public void a(TextWatcher textWatcher) {
        if (this.cai != null) {
            this.cai.removeTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        private String caj;
        private boolean cak = false;
        private int cal = 1;
        private String cam;
        private boolean can;
        private String cao;
        private String mDesc;
        private String mErrorMessage;

        public a ej(boolean z) {
            this.cak = z;
            return this;
        }

        public a mZ(String str) {
            this.mDesc = str;
            return this;
        }

        public a he(int i) {
            this.cal = i;
            return this;
        }

        public a na(String str) {
            this.cam = str;
            return this;
        }

        public a nb(String str) {
            this.caj = str;
            return this;
        }

        public a nc(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public a ek(boolean z) {
            this.can = z;
            return this;
        }

        public a nd(String str) {
            this.cao = str;
            return this;
        }
    }
}

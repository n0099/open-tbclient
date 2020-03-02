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
    private View cem;
    private TextView ceo;
    private EditText cep;
    private String ceq;
    private boolean cer;
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
        this.mRootView.setBackground(getResources().getDrawable(b.C0318b.invoice_edit_view_bg));
        this.ceo = (TextView) findViewById(b.e.invoice_info_desc);
        this.cep = (EditText) findViewById(b.e.invoice_info_content);
        this.cem = findViewById(b.e.divider_line);
        this.ceo.setTextColor(getResources().getColor(b.C0318b.invoice_info_desc));
        this.cep.setTextColor(getResources().getColor(b.C0318b.invoice_info_content));
        this.cep.setHintTextColor(getResources().getColor(b.C0318b.invoice_info_content_hint));
        this.cem.setBackground(getResources().getDrawable(b.C0318b.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.cer = aVar.cer;
            this.ceo.setText(aVar.mDesc);
            this.cep.setHint(aVar.cet);
            if (!aVar.ceu) {
                this.cep.setSingleLine();
            } else {
                aVar.ces |= 131072;
            }
            this.cep.setInputType(aVar.ces);
            if (!TextUtils.isEmpty(aVar.cev)) {
                this.cep.setKeyListener(DigitsKeyListener.getInstance(aVar.cev));
            }
            this.ceq = aVar.ceq;
            this.mErrorMessage = aVar.mErrorMessage;
        }
        return this;
    }

    public String getContent() {
        if (this.cep != null) {
            return this.cep.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.cep != null) {
            this.cep.setText(charSequence);
        }
    }

    public boolean aiK() {
        return this.cer;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.cep != null && textWatcher != null) {
            this.cep.addTextChangedListener(textWatcher);
        }
    }

    public void a(TextWatcher textWatcher) {
        if (this.cep != null) {
            this.cep.removeTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        private String ceq;
        private boolean cer = false;
        private int ces = 1;
        private String cet;
        private boolean ceu;
        private String cev;
        private String mDesc;
        private String mErrorMessage;

        public a eq(boolean z) {
            this.cer = z;
            return this;
        }

        public a no(String str) {
            this.mDesc = str;
            return this;
        }

        public a hv(int i) {
            this.ces = i;
            return this;
        }

        public a np(String str) {
            this.cet = str;
            return this;
        }

        public a nq(String str) {
            this.ceq = str;
            return this;
        }

        public a nr(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public a er(boolean z) {
            this.ceu = z;
            return this;
        }

        public a ns(String str) {
            this.cev = str;
            return this;
        }
    }
}

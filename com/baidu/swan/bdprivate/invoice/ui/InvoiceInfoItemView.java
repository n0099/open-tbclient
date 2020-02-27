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
    private View cel;
    private TextView cen;
    private EditText ceo;
    private String cep;
    private boolean ceq;
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
        this.cen = (TextView) findViewById(b.e.invoice_info_desc);
        this.ceo = (EditText) findViewById(b.e.invoice_info_content);
        this.cel = findViewById(b.e.divider_line);
        this.cen.setTextColor(getResources().getColor(b.C0318b.invoice_info_desc));
        this.ceo.setTextColor(getResources().getColor(b.C0318b.invoice_info_content));
        this.ceo.setHintTextColor(getResources().getColor(b.C0318b.invoice_info_content_hint));
        this.cel.setBackground(getResources().getDrawable(b.C0318b.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.ceq = aVar.ceq;
            this.cen.setText(aVar.mDesc);
            this.ceo.setHint(aVar.ces);
            if (!aVar.cet) {
                this.ceo.setSingleLine();
            } else {
                aVar.cer |= 131072;
            }
            this.ceo.setInputType(aVar.cer);
            if (!TextUtils.isEmpty(aVar.ceu)) {
                this.ceo.setKeyListener(DigitsKeyListener.getInstance(aVar.ceu));
            }
            this.cep = aVar.cep;
            this.mErrorMessage = aVar.mErrorMessage;
        }
        return this;
    }

    public String getContent() {
        if (this.ceo != null) {
            return this.ceo.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.ceo != null) {
            this.ceo.setText(charSequence);
        }
    }

    public boolean aiI() {
        return this.ceq;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.ceo != null && textWatcher != null) {
            this.ceo.addTextChangedListener(textWatcher);
        }
    }

    public void a(TextWatcher textWatcher) {
        if (this.ceo != null) {
            this.ceo.removeTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        private String cep;
        private boolean ceq = false;
        private int cer = 1;
        private String ces;
        private boolean cet;
        private String ceu;
        private String mDesc;
        private String mErrorMessage;

        public a eq(boolean z) {
            this.ceq = z;
            return this;
        }

        public a no(String str) {
            this.mDesc = str;
            return this;
        }

        public a hv(int i) {
            this.cer = i;
            return this;
        }

        public a np(String str) {
            this.ces = str;
            return this;
        }

        public a nq(String str) {
            this.cep = str;
            return this;
        }

        public a nr(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public a er(boolean z) {
            this.cet = z;
            return this;
        }

        public a ns(String str) {
            this.ceu = str;
            return this;
        }
    }
}

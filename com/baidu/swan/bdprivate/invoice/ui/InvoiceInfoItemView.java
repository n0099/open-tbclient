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
    private View cen;
    private TextView cep;
    private EditText ceq;
    private String cer;
    private boolean ces;
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
        this.cep = (TextView) findViewById(b.e.invoice_info_desc);
        this.ceq = (EditText) findViewById(b.e.invoice_info_content);
        this.cen = findViewById(b.e.divider_line);
        this.cep.setTextColor(getResources().getColor(b.C0318b.invoice_info_desc));
        this.ceq.setTextColor(getResources().getColor(b.C0318b.invoice_info_content));
        this.ceq.setHintTextColor(getResources().getColor(b.C0318b.invoice_info_content_hint));
        this.cen.setBackground(getResources().getDrawable(b.C0318b.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.ces = aVar.ces;
            this.cep.setText(aVar.mDesc);
            this.ceq.setHint(aVar.ceu);
            if (!aVar.cev) {
                this.ceq.setSingleLine();
            } else {
                aVar.cet |= 131072;
            }
            this.ceq.setInputType(aVar.cet);
            if (!TextUtils.isEmpty(aVar.cew)) {
                this.ceq.setKeyListener(DigitsKeyListener.getInstance(aVar.cew));
            }
            this.cer = aVar.cer;
            this.mErrorMessage = aVar.mErrorMessage;
        }
        return this;
    }

    public String getContent() {
        if (this.ceq != null) {
            return this.ceq.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.ceq != null) {
            this.ceq.setText(charSequence);
        }
    }

    public boolean aiK() {
        return this.ces;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.ceq != null && textWatcher != null) {
            this.ceq.addTextChangedListener(textWatcher);
        }
    }

    public void a(TextWatcher textWatcher) {
        if (this.ceq != null) {
            this.ceq.removeTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        private String cer;
        private boolean ces = false;
        private int cet = 1;
        private String ceu;
        private boolean cev;
        private String cew;
        private String mDesc;
        private String mErrorMessage;

        public a eq(boolean z) {
            this.ces = z;
            return this;
        }

        public a no(String str) {
            this.mDesc = str;
            return this;
        }

        public a hv(int i) {
            this.cet = i;
            return this;
        }

        public a np(String str) {
            this.ceu = str;
            return this;
        }

        public a nq(String str) {
            this.cer = str;
            return this;
        }

        public a nr(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public a er(boolean z) {
            this.cev = z;
            return this;
        }

        public a ns(String str) {
            this.cew = str;
            return this;
        }
    }
}

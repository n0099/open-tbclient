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
    private TextView ceA;
    private EditText ceB;
    private String ceC;
    private boolean ceD;
    private View cey;
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
        this.ceA = (TextView) findViewById(b.e.invoice_info_desc);
        this.ceB = (EditText) findViewById(b.e.invoice_info_content);
        this.cey = findViewById(b.e.divider_line);
        this.ceA.setTextColor(getResources().getColor(b.C0318b.invoice_info_desc));
        this.ceB.setTextColor(getResources().getColor(b.C0318b.invoice_info_content));
        this.ceB.setHintTextColor(getResources().getColor(b.C0318b.invoice_info_content_hint));
        this.cey.setBackground(getResources().getDrawable(b.C0318b.invoice_info_item_divider_line));
    }

    public InvoiceInfoItemView a(a aVar) {
        if (aVar != null) {
            this.ceD = aVar.ceD;
            this.ceA.setText(aVar.mDesc);
            this.ceB.setHint(aVar.ceF);
            if (!aVar.ceG) {
                this.ceB.setSingleLine();
            } else {
                aVar.ceE |= 131072;
            }
            this.ceB.setInputType(aVar.ceE);
            if (!TextUtils.isEmpty(aVar.ceH)) {
                this.ceB.setKeyListener(DigitsKeyListener.getInstance(aVar.ceH));
            }
            this.ceC = aVar.ceC;
            this.mErrorMessage = aVar.mErrorMessage;
        }
        return this;
    }

    public String getContent() {
        if (this.ceB != null) {
            return this.ceB.getText().toString().trim();
        }
        return null;
    }

    public void setContent(CharSequence charSequence) {
        if (this.ceB != null) {
            this.ceB.setText(charSequence);
        }
    }

    public boolean aiN() {
        return this.ceD;
    }

    public void setTextChangedListener(TextWatcher textWatcher) {
        if (this.ceB != null && textWatcher != null) {
            this.ceB.addTextChangedListener(textWatcher);
        }
    }

    public void a(TextWatcher textWatcher) {
        if (this.ceB != null) {
            this.ceB.removeTextChangedListener(textWatcher);
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        private String ceC;
        private boolean ceD = false;
        private int ceE = 1;
        private String ceF;
        private boolean ceG;
        private String ceH;
        private String mDesc;
        private String mErrorMessage;

        public a er(boolean z) {
            this.ceD = z;
            return this;
        }

        public a nn(String str) {
            this.mDesc = str;
            return this;
        }

        public a hv(int i) {
            this.ceE = i;
            return this;
        }

        public a no(String str) {
            this.ceF = str;
            return this;
        }

        public a np(String str) {
            this.ceC = str;
            return this;
        }

        public a nq(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public a es(boolean z) {
            this.ceG = z;
            return this;
        }

        public a nr(String str) {
            this.ceH = str;
            return this;
        }
    }
}

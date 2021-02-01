package com.baidu.live.tieba.yuyinala.e;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class a implements TextWatcher, View.OnClickListener {
    private TextView bNA;
    private EditText bNB;
    private TextView bNC;
    private String bNa;
    private InterfaceC0221a bNj;
    private String mLiveId;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private View mView;

    /* renamed from: com.baidu.live.tieba.yuyinala.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0221a {
        void afterTextChanged(Editable editable);
    }

    public a(TbPageContext tbPageContext, View.OnClickListener onClickListener, InterfaceC0221a interfaceC0221a) {
        this.mPageContext = tbPageContext;
        this.mOnClickListener = onClickListener;
        this.bNj = interfaceC0221a;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.yuyin_ala_activity_edit_feedback_reason_layout, (ViewGroup) null);
        this.bNA = (TextView) this.mView.findViewById(a.f.id_feenback_edit_confirm_btn);
        this.bNB = (EditText) this.mView.findViewById(a.f.id_feedback_edit_text);
        this.bNC = (TextView) this.mView.findViewById(a.f.id_feedback_real_textnum);
        this.bNB.setCursorVisible(false);
        this.bNA.setEnabled(false);
        this.bNB.addTextChangedListener(this);
        this.bNA.setOnClickListener(this);
    }

    public void aN(String str, String str2) {
        this.mLiveId = str;
        this.bNa = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mOnClickListener != null) {
            this.mOnClickListener.onClick(view);
        }
    }

    public View getView() {
        return this.mView;
    }

    public void onDestroy() {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable != null) {
            int length = editable.toString().length();
            this.bNC.setText(String.valueOf(length));
            if (length > 20) {
                this.bNC.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_color_FF1E66));
                this.bNA.setEnabled(false);
            } else {
                this.bNC.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_color_858585));
                if (length == 0) {
                    this.bNA.setEnabled(false);
                } else {
                    this.bNA.setEnabled(true);
                }
            }
        }
        if (this.bNj != null) {
            this.bNj.afterTextChanged(editable);
        }
    }

    public String Vh() {
        if (this.bNB.getText() != null) {
            return this.bNB.getText().toString();
        }
        return null;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.bNB.setCursorVisible(true);
        } else {
            this.bNB.setCursorVisible(false);
        }
    }
}

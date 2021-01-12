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
/* loaded from: classes10.dex */
public class a implements TextWatcher, View.OnClickListener {
    private TextView bJQ;
    private EditText bJR;
    private TextView bJS;
    private String bJq;
    private InterfaceC0219a bJz;
    private String mLiveId;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private View mView;

    /* renamed from: com.baidu.live.tieba.yuyinala.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0219a {
        void afterTextChanged(Editable editable);
    }

    public a(TbPageContext tbPageContext, View.OnClickListener onClickListener, InterfaceC0219a interfaceC0219a) {
        this.mPageContext = tbPageContext;
        this.mOnClickListener = onClickListener;
        this.bJz = interfaceC0219a;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.yuyin_ala_activity_edit_feedback_reason_layout, (ViewGroup) null);
        this.bJQ = (TextView) this.mView.findViewById(a.f.id_feenback_edit_confirm_btn);
        this.bJR = (EditText) this.mView.findViewById(a.f.id_feedback_edit_text);
        this.bJS = (TextView) this.mView.findViewById(a.f.id_feedback_real_textnum);
        this.bJR.setCursorVisible(false);
        this.bJQ.setEnabled(false);
        this.bJR.addTextChangedListener(this);
        this.bJQ.setOnClickListener(this);
    }

    public void aN(String str, String str2) {
        this.mLiveId = str;
        this.bJq = str2;
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
            this.bJS.setText(String.valueOf(length));
            if (length > 20) {
                this.bJS.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_color_FF1E66));
                this.bJQ.setEnabled(false);
            } else {
                this.bJS.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_color_858585));
                if (length == 0) {
                    this.bJQ.setEnabled(false);
                } else {
                    this.bJQ.setEnabled(true);
                }
            }
        }
        if (this.bJz != null) {
            this.bJz.afterTextChanged(editable);
        }
    }

    public String TA() {
        if (this.bJR.getText() != null) {
            return this.bJR.getText().toString();
        }
        return null;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.bJR.setCursorVisible(true);
        } else {
            this.bJR.setCursorVisible(false);
        }
    }
}

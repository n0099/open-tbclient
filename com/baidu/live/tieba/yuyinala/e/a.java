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
    private String bOA;
    private InterfaceC0227a bOJ;
    private TextView bPa;
    private EditText bPb;
    private TextView bPc;
    private String mLiveId;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private View mView;

    /* renamed from: com.baidu.live.tieba.yuyinala.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0227a {
        void afterTextChanged(Editable editable);
    }

    public a(TbPageContext tbPageContext, View.OnClickListener onClickListener, InterfaceC0227a interfaceC0227a) {
        this.mPageContext = tbPageContext;
        this.mOnClickListener = onClickListener;
        this.bOJ = interfaceC0227a;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.yuyin_ala_activity_edit_feedback_reason_layout, (ViewGroup) null);
        this.bPa = (TextView) this.mView.findViewById(a.f.id_feenback_edit_confirm_btn);
        this.bPb = (EditText) this.mView.findViewById(a.f.id_feedback_edit_text);
        this.bPc = (TextView) this.mView.findViewById(a.f.id_feedback_real_textnum);
        this.bPb.setCursorVisible(false);
        this.bPa.setEnabled(false);
        this.bPb.addTextChangedListener(this);
        this.bPa.setOnClickListener(this);
    }

    public void aN(String str, String str2) {
        this.mLiveId = str;
        this.bOA = str2;
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
            this.bPc.setText(String.valueOf(length));
            if (length > 20) {
                this.bPc.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_color_FF1E66));
                this.bPa.setEnabled(false);
            } else {
                this.bPc.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_color_858585));
                if (length == 0) {
                    this.bPa.setEnabled(false);
                } else {
                    this.bPa.setEnabled(true);
                }
            }
        }
        if (this.bOJ != null) {
            this.bOJ.afterTextChanged(editable);
        }
    }

    public String Vk() {
        if (this.bPb.getText() != null) {
            return this.bPb.getText().toString();
        }
        return null;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.bPb.setCursorVisible(true);
        } else {
            this.bPb.setCursorVisible(false);
        }
    }
}

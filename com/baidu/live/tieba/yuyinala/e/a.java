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
/* loaded from: classes4.dex */
public class a implements TextWatcher, View.OnClickListener {
    private TextView bAg;
    private EditText bAh;
    private TextView bAi;
    private InterfaceC0211a bzP;
    private String mLiveId;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private String mRoomID;
    private View mView;

    /* renamed from: com.baidu.live.tieba.yuyinala.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0211a {
        void afterTextChanged(Editable editable);
    }

    public a(TbPageContext tbPageContext, View.OnClickListener onClickListener, InterfaceC0211a interfaceC0211a) {
        this.mPageContext = tbPageContext;
        this.mOnClickListener = onClickListener;
        this.bzP = interfaceC0211a;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_activity_edit_feedback_reason_layout, (ViewGroup) null);
        this.bAg = (TextView) this.mView.findViewById(a.g.id_feenback_edit_confirm_btn);
        this.bAh = (EditText) this.mView.findViewById(a.g.id_feedback_edit_text);
        this.bAi = (TextView) this.mView.findViewById(a.g.id_feedback_real_textnum);
        this.bAh.setCursorVisible(false);
        this.bAg.setEnabled(false);
        this.bAh.addTextChangedListener(this);
        this.bAg.setOnClickListener(this);
    }

    public void aP(String str, String str2) {
        this.mLiveId = str;
        this.mRoomID = str2;
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
            this.bAi.setText(String.valueOf(length));
            if (length > 20) {
                this.bAi.setTextColor(this.mPageContext.getResources().getColor(a.d.sdk_color_FF1E66));
                this.bAg.setEnabled(false);
            } else {
                this.bAi.setTextColor(this.mPageContext.getResources().getColor(a.d.sdk_white_alpha30));
                if (length == 0) {
                    this.bAg.setEnabled(false);
                } else {
                    this.bAg.setEnabled(true);
                }
            }
        }
        if (this.bzP != null) {
            this.bzP.afterTextChanged(editable);
        }
    }

    public String RR() {
        if (this.bAh.getText() != null) {
            return this.bAh.getText().toString();
        }
        return null;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.bAh.setCursorVisible(true);
        } else {
            this.bAh.setCursorVisible(false);
        }
    }
}

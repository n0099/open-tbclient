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
    private TextView bOC;
    private EditText bOD;
    private TextView bOE;
    private String bOc;
    private InterfaceC0228a bOl;
    private String mLiveId;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private View mView;

    /* renamed from: com.baidu.live.tieba.yuyinala.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0228a {
        void afterTextChanged(Editable editable);
    }

    public a(TbPageContext tbPageContext, View.OnClickListener onClickListener, InterfaceC0228a interfaceC0228a) {
        this.mPageContext = tbPageContext;
        this.mOnClickListener = onClickListener;
        this.bOl = interfaceC0228a;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.yuyin_ala_activity_edit_feedback_reason_layout, (ViewGroup) null);
        this.bOC = (TextView) this.mView.findViewById(a.f.id_feenback_edit_confirm_btn);
        this.bOD = (EditText) this.mView.findViewById(a.f.id_feedback_edit_text);
        this.bOE = (TextView) this.mView.findViewById(a.f.id_feedback_real_textnum);
        this.bOD.setCursorVisible(false);
        this.bOC.setEnabled(false);
        this.bOD.addTextChangedListener(this);
        this.bOC.setOnClickListener(this);
    }

    public void aO(String str, String str2) {
        this.mLiveId = str;
        this.bOc = str2;
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
            this.bOE.setText(String.valueOf(length));
            if (length > 20) {
                this.bOE.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_color_FF1E66));
                this.bOC.setEnabled(false);
            } else {
                this.bOE.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_color_858585));
                if (length == 0) {
                    this.bOC.setEnabled(false);
                } else {
                    this.bOC.setEnabled(true);
                }
            }
        }
        if (this.bOl != null) {
            this.bOl.afterTextChanged(editable);
        }
    }

    public String Xs() {
        if (this.bOD.getText() != null) {
            return this.bOD.getText().toString();
        }
        return null;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.bOD.setCursorVisible(true);
        } else {
            this.bOD.setCursorVisible(false);
        }
    }
}

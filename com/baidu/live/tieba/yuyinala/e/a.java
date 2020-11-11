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
    private InterfaceC0223a bGa;
    private TextView bGr;
    private EditText bGs;
    private TextView bGt;
    private String mLiveId;
    private View.OnClickListener mOnClickListener;
    private TbPageContext mPageContext;
    private String mRoomID;
    private View mView;

    /* renamed from: com.baidu.live.tieba.yuyinala.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0223a {
        void afterTextChanged(Editable editable);
    }

    public a(TbPageContext tbPageContext, View.OnClickListener onClickListener, InterfaceC0223a interfaceC0223a) {
        this.mPageContext = tbPageContext;
        this.mOnClickListener = onClickListener;
        this.bGa = interfaceC0223a;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.yuyin_ala_activity_edit_feedback_reason_layout, (ViewGroup) null);
        this.bGr = (TextView) this.mView.findViewById(a.f.id_feenback_edit_confirm_btn);
        this.bGs = (EditText) this.mView.findViewById(a.f.id_feedback_edit_text);
        this.bGt = (TextView) this.mView.findViewById(a.f.id_feedback_real_textnum);
        this.bGs.setCursorVisible(false);
        this.bGr.setEnabled(false);
        this.bGs.addTextChangedListener(this);
        this.bGr.setOnClickListener(this);
    }

    public void aQ(String str, String str2) {
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
            this.bGt.setText(String.valueOf(length));
            if (length > 20) {
                this.bGt.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_color_FF1E66));
                this.bGr.setEnabled(false);
            } else {
                this.bGt.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_color_858585));
                if (length == 0) {
                    this.bGr.setEnabled(false);
                } else {
                    this.bGr.setEnabled(true);
                }
            }
        }
        if (this.bGa != null) {
            this.bGa.afterTextChanged(editable);
        }
    }

    public String Uz() {
        if (this.bGs.getText() != null) {
            return this.bGs.getText().toString();
        }
        return null;
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            this.bGs.setCursorVisible(true);
        } else {
            this.bGs.setCursorVisible(false);
        }
    }
}

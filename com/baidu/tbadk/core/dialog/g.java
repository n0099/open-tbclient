package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class g implements j {
    private String ama;
    private k bMQ;
    private View bMR;
    private int bMS;
    private int bMT;
    private k.b bMU;
    private boolean bMV;
    private int mId;
    private final View.OnClickListener mOnClickListener;
    private int mTextColor;
    public TextView mTextView;
    private View mView;

    public int getId() {
        return this.mId;
    }

    public g(k kVar) {
        this(null, kVar);
    }

    public g(String str, k kVar) {
        this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        this.bMS = R.color.cp_bg_line_d;
        this.bMT = 17;
        this.bMV = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.bMU != null) {
                    g.this.bMU.onClick();
                }
                if (g.this.bMQ != null && g.this.bMQ.afY() != null) {
                    g.this.bMQ.afY().a(g.this.bMQ, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.ama = str;
        this.bMQ = kVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public g(int i, String str, k kVar) {
        this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
        this.bMS = R.color.cp_bg_line_d;
        this.bMT = 17;
        this.bMV = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.bMU != null) {
                    g.this.bMU.onClick();
                }
                if (g.this.bMQ != null && g.this.bMQ.afY() != null) {
                    g.this.bMQ.afY().a(g.this.bMQ, g.this.mId, g.this.mTextView);
                }
            }
        };
        this.mId = i;
        this.ama = str;
        this.bMQ = kVar;
        initView();
        initListener();
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public View getView() {
        return this.mView;
    }

    public void setText(String str) {
        this.ama = str;
        this.mTextView.setText(this.ama);
    }

    public void a(k.b bVar) {
        this.bMU = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        al.j(this.mTextView, i);
    }

    @Override // com.baidu.tbadk.core.dialog.j
    public void onChangeSkinType() {
        al.k(this.mTextView, this.bMS);
        al.j(this.mTextView, this.mTextColor);
        al.l(this.bMR, R.color.cp_bg_line_c);
    }

    private void initView() {
        if (this.bMQ != null && this.bMQ.getContext() != null) {
            this.mView = LayoutInflater.from(this.bMQ.getContext()).inflate(R.layout.popup_dialog_view_item, this.bMQ.afX(), false);
            this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
            this.mTextView.setText(this.ama);
            this.mTextView.setGravity(this.bMT);
            this.bMR = this.mView.findViewById(R.id.divider_line);
            if (this.bMV) {
                this.bMR.setVisibility(0);
            } else {
                this.bMR.setVisibility(8);
            }
            onChangeSkinType();
        }
    }

    private void initListener() {
        if (this.mTextView != null) {
            this.mTextView.setOnClickListener(this.mOnClickListener);
        }
    }
}

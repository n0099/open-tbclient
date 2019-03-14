package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f implements h {
    private String alJ;
    private i bFp;
    private View bFq;
    private int bFr;
    private int bFs;
    private i.b bFt;
    private boolean bFu;
    private int mId;
    private final View.OnClickListener mOnClickListener;
    private int mTextColor;
    public TextView mTextView;
    private View mView;

    public int getId() {
        return this.mId;
    }

    public f(i iVar) {
        this(null, iVar);
    }

    public f(String str, i iVar) {
        this.mTextColor = d.f.person_more_pop_cancel_text_selector;
        this.bFr = d.C0277d.cp_bg_line_d;
        this.bFs = 17;
        this.bFu = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bFt != null) {
                    f.this.bFt.onClick();
                }
                if (f.this.bFp != null && f.this.bFp.abj() != null) {
                    f.this.bFp.abj().a(f.this.bFp, f.this.mId, f.this.mTextView);
                }
            }
        };
        this.alJ = str;
        this.bFp = iVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public f(int i, String str, i iVar) {
        this.mTextColor = d.f.person_more_pop_cancel_text_selector;
        this.bFr = d.C0277d.cp_bg_line_d;
        this.bFs = 17;
        this.bFu = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bFt != null) {
                    f.this.bFt.onClick();
                }
                if (f.this.bFp != null && f.this.bFp.abj() != null) {
                    f.this.bFp.abj().a(f.this.bFp, f.this.mId, f.this.mTextView);
                }
            }
        };
        this.mId = i;
        this.alJ = str;
        this.bFp = iVar;
        initView();
        initListener();
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public View getView() {
        return this.mView;
    }

    public void setText(String str) {
        this.alJ = str;
        this.mTextView.setText(this.alJ);
    }

    public void a(i.b bVar) {
        this.bFt = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        al.j(this.mTextView, i);
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void onChangeSkinType() {
        al.k(this.mTextView, this.bFr);
        al.j(this.mTextView, this.mTextColor);
        al.l(this.bFq, d.C0277d.cp_bg_line_c);
    }

    private void initView() {
        if (this.bFp != null && this.bFp.getContext() != null) {
            this.mView = LayoutInflater.from(this.bFp.getContext()).inflate(d.h.popup_dialog_view_item, this.bFp.abi(), false);
            this.mTextView = (TextView) this.mView.findViewById(d.g.item_view);
            this.mTextView.setText(this.alJ);
            this.mTextView.setGravity(this.bFs);
            this.bFq = this.mView.findViewById(d.g.divider_line);
            if (this.bFu) {
                this.bFq.setVisibility(0);
            } else {
                this.bFq.setVisibility(8);
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

package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f implements h {
    private String alI;
    private i bFn;
    private View bFo;
    private int bFp;
    private int bFq;
    private i.b bFr;
    private boolean bFs;
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
        this.bFp = d.C0236d.cp_bg_line_d;
        this.bFq = 17;
        this.bFs = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bFr != null) {
                    f.this.bFr.onClick();
                }
                if (f.this.bFn != null && f.this.bFn.abj() != null) {
                    f.this.bFn.abj().a(f.this.bFn, f.this.mId, f.this.mTextView);
                }
            }
        };
        this.alI = str;
        this.bFn = iVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public f(int i, String str, i iVar) {
        this.mTextColor = d.f.person_more_pop_cancel_text_selector;
        this.bFp = d.C0236d.cp_bg_line_d;
        this.bFq = 17;
        this.bFs = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bFr != null) {
                    f.this.bFr.onClick();
                }
                if (f.this.bFn != null && f.this.bFn.abj() != null) {
                    f.this.bFn.abj().a(f.this.bFn, f.this.mId, f.this.mTextView);
                }
            }
        };
        this.mId = i;
        this.alI = str;
        this.bFn = iVar;
        initView();
        initListener();
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public View getView() {
        return this.mView;
    }

    public void setText(String str) {
        this.alI = str;
        this.mTextView.setText(this.alI);
    }

    public void a(i.b bVar) {
        this.bFr = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        al.j(this.mTextView, i);
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void onChangeSkinType() {
        al.k(this.mTextView, this.bFp);
        al.j(this.mTextView, this.mTextColor);
        al.l(this.bFo, d.C0236d.cp_bg_line_c);
    }

    private void initView() {
        if (this.bFn != null && this.bFn.getContext() != null) {
            this.mView = LayoutInflater.from(this.bFn.getContext()).inflate(d.h.popup_dialog_view_item, this.bFn.abi(), false);
            this.mTextView = (TextView) this.mView.findViewById(d.g.item_view);
            this.mTextView.setText(this.alI);
            this.mTextView.setGravity(this.bFq);
            this.bFo = this.mView.findViewById(d.g.divider_line);
            if (this.bFs) {
                this.bFo.setVisibility(0);
            } else {
                this.bFo.setVisibility(8);
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

package com.baidu.tbadk.core.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f implements h {
    private String alN;
    private i bFr;
    private View bFs;
    private int bFt;
    private int bFu;
    private i.b bFv;
    private boolean bFw;
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
        this.bFt = d.C0277d.cp_bg_line_d;
        this.bFu = 17;
        this.bFw = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bFv != null) {
                    f.this.bFv.onClick();
                }
                if (f.this.bFr != null && f.this.bFr.abg() != null) {
                    f.this.bFr.abg().a(f.this.bFr, f.this.mId, f.this.mTextView);
                }
            }
        };
        this.alN = str;
        this.bFr = iVar;
        this.mId = hashCode();
        initView();
        initListener();
    }

    public f(int i, String str, i iVar) {
        this.mTextColor = d.f.person_more_pop_cancel_text_selector;
        this.bFt = d.C0277d.cp_bg_line_d;
        this.bFu = 17;
        this.bFw = false;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bFv != null) {
                    f.this.bFv.onClick();
                }
                if (f.this.bFr != null && f.this.bFr.abg() != null) {
                    f.this.bFr.abg().a(f.this.bFr, f.this.mId, f.this.mTextView);
                }
            }
        };
        this.mId = i;
        this.alN = str;
        this.bFr = iVar;
        initView();
        initListener();
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public View getView() {
        return this.mView;
    }

    public void setText(String str) {
        this.alN = str;
        this.mTextView.setText(this.alN);
    }

    public void a(i.b bVar) {
        this.bFv = bVar;
        initListener();
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
        al.j(this.mTextView, i);
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void onChangeSkinType() {
        al.k(this.mTextView, this.bFt);
        al.j(this.mTextView, this.mTextColor);
        al.l(this.bFs, d.C0277d.cp_bg_line_c);
    }

    private void initView() {
        if (this.bFr != null && this.bFr.getContext() != null) {
            this.mView = LayoutInflater.from(this.bFr.getContext()).inflate(d.h.popup_dialog_view_item, this.bFr.abf(), false);
            this.mTextView = (TextView) this.mView.findViewById(d.g.item_view);
            this.mTextView.setText(this.alN);
            this.mTextView.setGravity(this.bFu);
            this.bFs = this.mView.findViewById(d.g.divider_line);
            if (this.bFw) {
                this.bFs.setVisibility(0);
            } else {
                this.bFs.setVisibility(8);
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

package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.b;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ExtraLayout extends RelativeLayout {
    private com.baidu.tbadk.core.data.a agj;
    private TBSpecificationBtn aku;
    private TextView akv;
    private TextView akw;
    private View.OnClickListener akx;
    private final View.OnClickListener mOnClickListener;

    public ExtraLayout(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ExtraLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ExtraLayout.this.akx != null) {
                    ExtraLayout.this.akx.onClick(view);
                }
            }
        };
        init(context);
    }

    public ExtraLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ExtraLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ExtraLayout.this.akx != null) {
                    ExtraLayout.this.akx.onClick(view);
                }
            }
        };
        init(context);
    }

    public ExtraLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ExtraLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ExtraLayout.this.akx != null) {
                    ExtraLayout.this.akx.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_extra_item, (ViewGroup) this, true);
        this.akv = (TextView) inflate.findViewById(R.id.extra_text);
        this.akv.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.akw = (TextView) inflate.findViewById(R.id.extra_tag);
        this.aku = (TBSpecificationBtn) inflate.findViewById(R.id.extra_btn);
        this.aku.setOnClickListener(this.mOnClickListener);
        b bVar = new b();
        bVar.pR(R.color.CAM_X0302);
        this.aku.setConfig(bVar);
        this.aku.setText(getResources().getString(R.string.download_just_now));
    }

    public void setData(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        this.agj = aVar;
        cb bln = aVar.bln();
        if (!TextUtils.isEmpty(bln.eUe)) {
            this.akv.setVisibility(0);
            this.akv.setText(bln.eUe);
            this.akv.setOnClickListener(null);
            z = true;
        } else {
            this.akv.setVisibility(8);
            z = false;
        }
        if (!TextUtils.isEmpty(bln.eUf)) {
            this.akw.setVisibility(0);
            this.akw.setText(bln.eUf);
            this.akw.setOnClickListener(null);
            z = true;
        } else {
            this.akw.setVisibility(8);
        }
        if (!TextUtils.isEmpty(bln.buttonText)) {
            this.aku.setVisibility(0);
            this.aku.setText(bln.buttonText);
        } else {
            this.aku.setVisibility(4);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.akx = onClickListener;
    }
}

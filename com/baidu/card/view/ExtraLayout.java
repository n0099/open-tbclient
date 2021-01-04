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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.b;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ExtraLayout extends RelativeLayout {
    private com.baidu.tbadk.core.data.a ahi;
    private View.OnClickListener alA;
    private TBSpecificationBtn alx;
    private TextView aly;
    private TextView alz;
    private final View.OnClickListener mOnClickListener;

    public ExtraLayout(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ExtraLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ExtraLayout.this.alA != null) {
                    ExtraLayout.this.alA.onClick(view);
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
                if (ExtraLayout.this.alA != null) {
                    ExtraLayout.this.alA.onClick(view);
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
                if (ExtraLayout.this.alA != null) {
                    ExtraLayout.this.alA.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_extra_item, (ViewGroup) this, true);
        this.aly = (TextView) inflate.findViewById(R.id.extra_text);
        this.aly.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.alz = (TextView) inflate.findViewById(R.id.extra_tag);
        this.alx = (TBSpecificationBtn) inflate.findViewById(R.id.extra_btn);
        this.alx.setOnClickListener(this.mOnClickListener);
        b bVar = new b();
        bVar.rs(R.color.CAM_X0302);
        this.alx.setConfig(bVar);
        this.alx.setText(getResources().getString(R.string.download_just_now));
    }

    public void setData(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        this.ahi = aVar;
        bz boO = aVar.boO();
        if (!TextUtils.isEmpty(boO.eWB)) {
            this.aly.setVisibility(0);
            this.aly.setText(boO.eWB);
            this.aly.setOnClickListener(null);
            z = true;
        } else {
            this.aly.setVisibility(8);
            z = false;
        }
        if (!TextUtils.isEmpty(boO.eWC)) {
            this.alz.setVisibility(0);
            this.alz.setText(boO.eWC);
            this.alz.setOnClickListener(null);
            z = true;
        } else {
            this.alz.setVisibility(8);
        }
        if (!TextUtils.isEmpty(boO.buttonText)) {
            this.alx.setVisibility(0);
            this.alx.setText(boO.buttonText);
        } else {
            this.alx.setVisibility(4);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.alA = onClickListener;
    }
}

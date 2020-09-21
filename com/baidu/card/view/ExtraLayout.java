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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.b;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class ExtraLayout extends RelativeLayout {
    private AbsThreadDataSupport afq;
    private TextView ajA;
    private View.OnClickListener ajB;
    private TBSpecificationBtn ajy;
    private TextView ajz;
    private final View.OnClickListener mOnClickListener;

    public ExtraLayout(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ExtraLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ExtraLayout.this.ajB != null) {
                    ExtraLayout.this.ajB.onClick(view);
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
                if (ExtraLayout.this.ajB != null) {
                    ExtraLayout.this.ajB.onClick(view);
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
                if (ExtraLayout.this.ajB != null) {
                    ExtraLayout.this.ajB.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_extra_item, (ViewGroup) this, true);
        this.ajz = (TextView) inflate.findViewById(R.id.extra_text);
        this.ajz.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.ajA = (TextView) inflate.findViewById(R.id.extra_tag);
        this.ajy = (TBSpecificationBtn) inflate.findViewById(R.id.extra_btn);
        this.ajy.setOnClickListener(this.mOnClickListener);
        b bVar = new b();
        bVar.pp(R.color.cp_link_tip_a);
        this.ajy.setConfig(bVar);
        this.ajy.setText(getResources().getString(R.string.download_just_now));
    }

    public void setData(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        boolean z2 = true;
        this.afq = absThreadDataSupport;
        bw bcY = absThreadDataSupport.bcY();
        if (!TextUtils.isEmpty(bcY.egP)) {
            this.ajz.setVisibility(0);
            this.ajz.setText(bcY.egP);
            this.ajz.setOnClickListener(null);
            z = true;
        } else {
            this.ajz.setVisibility(8);
            z = false;
        }
        if (!TextUtils.isEmpty(bcY.egQ)) {
            this.ajA.setVisibility(0);
            this.ajA.setText(bcY.egQ);
            this.ajA.setOnClickListener(null);
            z = true;
        } else {
            this.ajA.setVisibility(8);
        }
        if (!TextUtils.isEmpty(bcY.buttonText)) {
            this.ajy.setVisibility(0);
            this.ajy.setText(bcY.buttonText);
        } else {
            this.ajy.setVisibility(4);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.ajB = onClickListener;
    }
}

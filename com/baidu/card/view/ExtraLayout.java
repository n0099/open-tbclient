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
/* loaded from: classes21.dex */
public class ExtraLayout extends RelativeLayout {
    private AbsThreadDataSupport afH;
    private TBSpecificationBtn ajQ;
    private TextView ajR;
    private TextView ajS;
    private View.OnClickListener ajT;
    private final View.OnClickListener mOnClickListener;

    public ExtraLayout(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ExtraLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ExtraLayout.this.ajT != null) {
                    ExtraLayout.this.ajT.onClick(view);
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
                if (ExtraLayout.this.ajT != null) {
                    ExtraLayout.this.ajT.onClick(view);
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
                if (ExtraLayout.this.ajT != null) {
                    ExtraLayout.this.ajT.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_extra_item, (ViewGroup) this, true);
        this.ajR = (TextView) inflate.findViewById(R.id.extra_text);
        this.ajR.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.ajS = (TextView) inflate.findViewById(R.id.extra_tag);
        this.ajQ = (TBSpecificationBtn) inflate.findViewById(R.id.extra_btn);
        this.ajQ.setOnClickListener(this.mOnClickListener);
        b bVar = new b();
        bVar.pN(R.color.cp_link_tip_a);
        this.ajQ.setConfig(bVar);
        this.ajQ.setText(getResources().getString(R.string.download_just_now));
    }

    public void setData(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        boolean z2 = true;
        this.afH = absThreadDataSupport;
        bw bfG = absThreadDataSupport.bfG();
        if (!TextUtils.isEmpty(bfG.esV)) {
            this.ajR.setVisibility(0);
            this.ajR.setText(bfG.esV);
            this.ajR.setOnClickListener(null);
            z = true;
        } else {
            this.ajR.setVisibility(8);
            z = false;
        }
        if (!TextUtils.isEmpty(bfG.esW)) {
            this.ajS.setVisibility(0);
            this.ajS.setText(bfG.esW);
            this.ajS.setOnClickListener(null);
            z = true;
        } else {
            this.ajS.setVisibility(8);
        }
        if (!TextUtils.isEmpty(bfG.buttonText)) {
            this.ajQ.setVisibility(0);
            this.ajQ.setText(bfG.buttonText);
        } else {
            this.ajQ.setVisibility(4);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.ajT = onClickListener;
    }
}

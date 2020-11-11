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
    private AbsThreadDataSupport afI;
    private TBSpecificationBtn ajR;
    private TextView ajS;
    private TextView ajT;
    private View.OnClickListener ajU;
    private final View.OnClickListener mOnClickListener;

    public ExtraLayout(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ExtraLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ExtraLayout.this.ajU != null) {
                    ExtraLayout.this.ajU.onClick(view);
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
                if (ExtraLayout.this.ajU != null) {
                    ExtraLayout.this.ajU.onClick(view);
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
                if (ExtraLayout.this.ajU != null) {
                    ExtraLayout.this.ajU.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_extra_item, (ViewGroup) this, true);
        this.ajS = (TextView) inflate.findViewById(R.id.extra_text);
        this.ajS.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.ajT = (TextView) inflate.findViewById(R.id.extra_tag);
        this.ajR = (TBSpecificationBtn) inflate.findViewById(R.id.extra_btn);
        this.ajR.setOnClickListener(this.mOnClickListener);
        b bVar = new b();
        bVar.qi(R.color.cp_link_tip_a);
        this.ajR.setConfig(bVar);
        this.ajR.setText(getResources().getString(R.string.download_just_now));
    }

    public void setData(AbsThreadDataSupport absThreadDataSupport) {
        boolean z;
        boolean z2 = true;
        this.afI = absThreadDataSupport;
        bw bjZ = absThreadDataSupport.bjZ();
        if (!TextUtils.isEmpty(bjZ.eHk)) {
            this.ajS.setVisibility(0);
            this.ajS.setText(bjZ.eHk);
            this.ajS.setOnClickListener(null);
            z = true;
        } else {
            this.ajS.setVisibility(8);
            z = false;
        }
        if (!TextUtils.isEmpty(bjZ.eHl)) {
            this.ajT.setVisibility(0);
            this.ajT.setText(bjZ.eHl);
            this.ajT.setOnClickListener(null);
            z = true;
        } else {
            this.ajT.setVisibility(8);
        }
        if (!TextUtils.isEmpty(bjZ.buttonText)) {
            this.ajR.setVisibility(0);
            this.ajR.setText(bjZ.buttonText);
        } else {
            this.ajR.setVisibility(4);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.ajU = onClickListener;
    }
}

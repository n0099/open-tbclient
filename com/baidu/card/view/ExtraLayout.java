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
    private com.baidu.tbadk.core.data.a agr;
    private TBSpecificationBtn akF;
    private TextView akG;
    private TextView akH;
    private View.OnClickListener akI;
    private final View.OnClickListener mOnClickListener;

    public ExtraLayout(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ExtraLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ExtraLayout.this.akI != null) {
                    ExtraLayout.this.akI.onClick(view);
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
                if (ExtraLayout.this.akI != null) {
                    ExtraLayout.this.akI.onClick(view);
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
                if (ExtraLayout.this.akI != null) {
                    ExtraLayout.this.akI.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_extra_item, (ViewGroup) this, true);
        this.akG = (TextView) inflate.findViewById(R.id.extra_text);
        this.akG.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.akH = (TextView) inflate.findViewById(R.id.extra_tag);
        this.akF = (TBSpecificationBtn) inflate.findViewById(R.id.extra_btn);
        this.akF.setOnClickListener(this.mOnClickListener);
        b bVar = new b();
        bVar.pM(R.color.CAM_X0302);
        this.akF.setConfig(bVar);
        this.akF.setText(getResources().getString(R.string.download_just_now));
    }

    public void setData(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        this.agr = aVar;
        bz bkV = aVar.bkV();
        if (!TextUtils.isEmpty(bkV.eRQ)) {
            this.akG.setVisibility(0);
            this.akG.setText(bkV.eRQ);
            this.akG.setOnClickListener(null);
            z = true;
        } else {
            this.akG.setVisibility(8);
            z = false;
        }
        if (!TextUtils.isEmpty(bkV.eRR)) {
            this.akH.setVisibility(0);
            this.akH.setText(bkV.eRR);
            this.akH.setOnClickListener(null);
            z = true;
        } else {
            this.akH.setVisibility(8);
        }
        if (!TextUtils.isEmpty(bkV.buttonText)) {
            this.akF.setVisibility(0);
            this.akF.setText(bkV.buttonText);
        } else {
            this.akF.setVisibility(4);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.akI = onClickListener;
    }
}

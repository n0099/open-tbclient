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
    private com.baidu.tbadk.core.data.a ahB;
    private TBSpecificationBtn alN;
    private TextView alO;
    private TextView alP;
    private View.OnClickListener alQ;
    private final View.OnClickListener mOnClickListener;

    public ExtraLayout(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ExtraLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ExtraLayout.this.alQ != null) {
                    ExtraLayout.this.alQ.onClick(view);
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
                if (ExtraLayout.this.alQ != null) {
                    ExtraLayout.this.alQ.onClick(view);
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
                if (ExtraLayout.this.alQ != null) {
                    ExtraLayout.this.alQ.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_extra_item, (ViewGroup) this, true);
        this.alO = (TextView) inflate.findViewById(R.id.extra_text);
        this.alO.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.alP = (TextView) inflate.findViewById(R.id.extra_tag);
        this.alN = (TBSpecificationBtn) inflate.findViewById(R.id.extra_btn);
        this.alN.setOnClickListener(this.mOnClickListener);
        b bVar = new b();
        bVar.pS(R.color.CAM_X0302);
        this.alN.setConfig(bVar);
        this.alN.setText(getResources().getString(R.string.download_just_now));
    }

    public void setData(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        this.ahB = aVar;
        cb blp = aVar.blp();
        if (!TextUtils.isEmpty(blp.eVD)) {
            this.alO.setVisibility(0);
            this.alO.setText(blp.eVD);
            this.alO.setOnClickListener(null);
            z = true;
        } else {
            this.alO.setVisibility(8);
            z = false;
        }
        if (!TextUtils.isEmpty(blp.eVE)) {
            this.alP.setVisibility(0);
            this.alP.setText(blp.eVE);
            this.alP.setOnClickListener(null);
            z = true;
        } else {
            this.alP.setVisibility(8);
        }
        if (!TextUtils.isEmpty(blp.buttonText)) {
            this.alN.setVisibility(0);
            this.alN.setText(blp.buttonText);
        } else {
            this.alN.setVisibility(4);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.alQ = onClickListener;
    }
}

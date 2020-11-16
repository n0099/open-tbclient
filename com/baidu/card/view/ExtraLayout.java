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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.b;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class ExtraLayout extends RelativeLayout {
    private com.baidu.tbadk.core.data.a afN;
    private TBSpecificationBtn ajU;
    private TextView ajV;
    private TextView ajW;
    private View.OnClickListener ajX;
    private final View.OnClickListener mOnClickListener;

    public ExtraLayout(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ExtraLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ExtraLayout.this.ajX != null) {
                    ExtraLayout.this.ajX.onClick(view);
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
                if (ExtraLayout.this.ajX != null) {
                    ExtraLayout.this.ajX.onClick(view);
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
                if (ExtraLayout.this.ajX != null) {
                    ExtraLayout.this.ajX.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_extra_item, (ViewGroup) this, true);
        this.ajV = (TextView) inflate.findViewById(R.id.extra_text);
        this.ajV.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.ajW = (TextView) inflate.findViewById(R.id.extra_tag);
        this.ajU = (TBSpecificationBtn) inflate.findViewById(R.id.extra_btn);
        this.ajU.setOnClickListener(this.mOnClickListener);
        b bVar = new b();
        bVar.qG(R.color.CAM_X0302);
        this.ajU.setConfig(bVar);
        this.ajU.setText(getResources().getString(R.string.download_just_now));
    }

    public void setData(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        this.afN = aVar;
        bx bjd = aVar.bjd();
        if (!TextUtils.isEmpty(bjd.eFC)) {
            this.ajV.setVisibility(0);
            this.ajV.setText(bjd.eFC);
            this.ajV.setOnClickListener(null);
            z = true;
        } else {
            this.ajV.setVisibility(8);
            z = false;
        }
        if (!TextUtils.isEmpty(bjd.eFD)) {
            this.ajW.setVisibility(0);
            this.ajW.setText(bjd.eFD);
            this.ajW.setOnClickListener(null);
            z = true;
        } else {
            this.ajW.setVisibility(8);
        }
        if (!TextUtils.isEmpty(bjd.buttonText)) {
            this.ajU.setVisibility(0);
            this.ajU.setText(bjd.buttonText);
        } else {
            this.ajU.setVisibility(4);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.ajX = onClickListener;
    }
}

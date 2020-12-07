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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.b;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ExtraLayout extends RelativeLayout {
    private com.baidu.tbadk.core.data.a agJ;
    private TBSpecificationBtn akU;
    private TextView akV;
    private TextView akW;
    private View.OnClickListener akX;
    private final View.OnClickListener mOnClickListener;

    public ExtraLayout(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.ExtraLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ExtraLayout.this.akX != null) {
                    ExtraLayout.this.akX.onClick(view);
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
                if (ExtraLayout.this.akX != null) {
                    ExtraLayout.this.akX.onClick(view);
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
                if (ExtraLayout.this.akX != null) {
                    ExtraLayout.this.akX.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_extra_item, (ViewGroup) this, true);
        this.akV = (TextView) inflate.findViewById(R.id.extra_text);
        this.akV.setCompoundDrawablePadding(l.getDimens(context, R.dimen.tbds10));
        this.akW = (TextView) inflate.findViewById(R.id.extra_tag);
        this.akU = (TBSpecificationBtn) inflate.findViewById(R.id.extra_btn);
        this.akU.setOnClickListener(this.mOnClickListener);
        b bVar = new b();
        bVar.rh(R.color.CAM_X0302);
        this.akU.setConfig(bVar);
        this.akU.setText(getResources().getString(R.string.download_just_now));
    }

    public void setData(com.baidu.tbadk.core.data.a aVar) {
        boolean z;
        boolean z2 = true;
        this.agJ = aVar;
        by bmn = aVar.bmn();
        if (!TextUtils.isEmpty(bmn.eME)) {
            this.akV.setVisibility(0);
            this.akV.setText(bmn.eME);
            this.akV.setOnClickListener(null);
            z = true;
        } else {
            this.akV.setVisibility(8);
            z = false;
        }
        if (!TextUtils.isEmpty(bmn.eMF)) {
            this.akW.setVisibility(0);
            this.akW.setText(bmn.eMF);
            this.akW.setOnClickListener(null);
            z = true;
        } else {
            this.akW.setVisibility(8);
        }
        if (!TextUtils.isEmpty(bmn.buttonText)) {
            this.akU.setVisibility(0);
            this.akU.setText(bmn.buttonText);
        } else {
            this.akU.setVisibility(4);
            z2 = z;
        }
        setVisibility(z2 ? 0 : 8);
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        this.akX = onClickListener;
    }
}

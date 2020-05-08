package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import tbclient.SmartApp;
/* loaded from: classes8.dex */
public class ThreadSmartAppLayout extends RelativeLayout implements View.OnClickListener, com.baidu.card.m<com.baidu.tbadk.core.data.a> {
    private View.OnClickListener afV;
    private HeadImageView dEQ;
    private TextView dJc;
    private SmartApp dJd;
    private TextView mTitleView;

    public ThreadSmartAppLayout(Context context) {
        this(context, null);
    }

    public ThreadSmartAppLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadSmartAppLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.thread_smart_app_layout, (ViewGroup) this, true);
        this.dEQ = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.dEQ.setIsRound(true);
        this.dEQ.setPlaceHolder(1);
        this.mTitleView = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.dJc = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this, R.drawable.applets_cell_bg);
        am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dJc, (int) R.color.cp_cont_j);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.afV = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dJd != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.dJd.id, this.dJd.link, "1191003900000000", this.dJd.is_game)) {
                if (!aq.isEmpty(this.dJd.h5_url)) {
                    ba.aOV().b(dt(getContext()), new String[]{this.dJd.h5_url});
                } else {
                    return;
                }
            }
            if (this.afV != null) {
                this.afV.onClick(view);
            }
        }
    }

    private TbPageContext dt(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.aIu() == null || aVar.aIu().aLo() == null) {
            setVisibility(8);
            return;
        }
        this.dJd = aVar.aIu().aLo();
        if (!aq.isEmpty(this.dJd.avatar)) {
            this.dEQ.startLoad(this.dJd.avatar, 10, false, false);
        }
        if (!aq.isEmpty(this.dJd.name)) {
            this.mTitleView.setText(this.dJd.name + " " + getContext().getResources().getString(R.string.smart_app_suffix));
        } else {
            this.mTitleView.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
        }
        if (!aq.isEmpty(this.dJd._abstract)) {
            this.dJc.setText(this.dJd._abstract);
        } else {
            this.dJc.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
        }
        setVisibility(0);
    }
}

package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.card.p;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import tbclient.SmartApp;
/* loaded from: classes20.dex */
public class ThreadSmartAppLayout extends RelativeLayout implements View.OnClickListener, p<AbsThreadDataSupport> {
    private View.OnClickListener aiW;
    private HeadImageView erW;
    private TextView exa;
    private SmartApp exb;
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
        this.erW = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.erW.setIsRound(true);
        this.erW.setPlaceHolder(1);
        this.mTitleView = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.exa = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.applets_cell_bg);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
        ap.setViewTextColor(this.exa, R.color.cp_cont_j);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiW = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.exb != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.exb.id, this.exb.link, "1191003900000000", this.exb.is_game)) {
                if (!at.isEmpty(this.exb.h5_url)) {
                    be.bkp().b(W(getContext()), new String[]{this.exb.h5_url});
                } else {
                    return;
                }
            }
            if (this.aiW != null) {
                this.aiW.onClick(view);
            }
        }
    }

    private TbPageContext W(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport == null || absThreadDataSupport.bcY() == null || absThreadDataSupport.bcY().bgn() == null) {
            setVisibility(8);
            return;
        }
        this.exb = absThreadDataSupport.bcY().bgn();
        if (!at.isEmpty(this.exb.avatar)) {
            this.erW.startLoad(this.exb.avatar, 10, false, false);
        }
        if (!at.isEmpty(this.exb.name)) {
            this.mTitleView.setText(this.exb.name + " " + getContext().getResources().getString(R.string.smart_app_suffix));
        } else {
            this.mTitleView.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
        }
        if (!at.isEmpty(this.exb._abstract)) {
            this.exa.setText(this.exb._abstract);
        } else {
            this.exa.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
        }
        setVisibility(0);
    }
}

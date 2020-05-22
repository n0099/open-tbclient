package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.card.n;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import tbclient.SmartApp;
/* loaded from: classes8.dex */
public class ThreadSmartAppLayout extends RelativeLayout implements View.OnClickListener, n<AbsThreadDataSupport> {
    private View.OnClickListener ags;
    private HeadImageView dTc;
    private TextView dXr;
    private SmartApp dXs;
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
        this.dTc = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.dTc.setIsRound(true);
        this.dTc.setPlaceHolder(1);
        this.mTitleView = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.dXr = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this, R.drawable.applets_cell_bg);
        am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dXr, (int) R.color.cp_cont_j);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ags = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dXs != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.dXs.id, this.dXs.link, "1191003900000000", this.dXs.is_game)) {
                if (!aq.isEmpty(this.dXs.h5_url)) {
                    ba.aUZ().b(S(getContext()), new String[]{this.dXs.h5_url});
                } else {
                    return;
                }
            }
            if (this.ags != null) {
                this.ags.onClick(view);
            }
        }
    }

    private TbPageContext S(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport == null || absThreadDataSupport.aOi() == null || absThreadDataSupport.aOi().aRn() == null) {
            setVisibility(8);
            return;
        }
        this.dXs = absThreadDataSupport.aOi().aRn();
        if (!aq.isEmpty(this.dXs.avatar)) {
            this.dTc.startLoad(this.dXs.avatar, 10, false, false);
        }
        if (!aq.isEmpty(this.dXs.name)) {
            this.mTitleView.setText(this.dXs.name + " " + getContext().getResources().getString(R.string.smart_app_suffix));
        } else {
            this.mTitleView.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
        }
        if (!aq.isEmpty(this.dXs._abstract)) {
            this.dXr.setText(this.dXs._abstract);
        } else {
            this.dXr.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
        }
        setVisibility(0);
    }
}

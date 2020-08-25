package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.card.o;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import tbclient.SmartApp;
/* loaded from: classes15.dex */
public class ThreadSmartAppLayout extends RelativeLayout implements View.OnClickListener, o<AbsThreadDataSupport> {
    private View.OnClickListener aiA;
    private HeadImageView epN;
    private TextView euS;
    private SmartApp euT;
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
        this.epN = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.epN.setIsRound(true);
        this.epN.setPlaceHolder(1);
        this.mTitleView = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.euS = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.applets_cell_bg);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
        ap.setViewTextColor(this.euS, R.color.cp_cont_j);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiA = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.euT != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.euT.id, this.euT.link, "1191003900000000", this.euT.is_game)) {
                if (!at.isEmpty(this.euT.h5_url)) {
                    be.bju().b(W(getContext()), new String[]{this.euT.h5_url});
                } else {
                    return;
                }
            }
            if (this.aiA != null) {
                this.aiA.onClick(view);
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
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport == null || absThreadDataSupport.bce() == null || absThreadDataSupport.bce().bft() == null) {
            setVisibility(8);
            return;
        }
        this.euT = absThreadDataSupport.bce().bft();
        if (!at.isEmpty(this.euT.avatar)) {
            this.epN.startLoad(this.euT.avatar, 10, false, false);
        }
        if (!at.isEmpty(this.euT.name)) {
            this.mTitleView.setText(this.euT.name + " " + getContext().getResources().getString(R.string.smart_app_suffix));
        } else {
            this.mTitleView.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
        }
        if (!at.isEmpty(this.euT._abstract)) {
            this.euS.setText(this.euT._abstract);
        } else {
            this.euS.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
        }
        setVisibility(0);
    }
}

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
    private View.OnClickListener aiC;
    private HeadImageView epR;
    private TextView euW;
    private SmartApp euX;
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
        this.epR = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.epR.setIsRound(true);
        this.epR.setPlaceHolder(1);
        this.mTitleView = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.euW = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.applets_cell_bg);
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
        ap.setViewTextColor(this.euW, R.color.cp_cont_j);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiC = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.euX != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.euX.id, this.euX.link, "1191003900000000", this.euX.is_game)) {
                if (!at.isEmpty(this.euX.h5_url)) {
                    be.bju().b(W(getContext()), new String[]{this.euX.h5_url});
                } else {
                    return;
                }
            }
            if (this.aiC != null) {
                this.aiC.onClick(view);
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
        this.euX = absThreadDataSupport.bce().bft();
        if (!at.isEmpty(this.euX.avatar)) {
            this.epR.startLoad(this.euX.avatar, 10, false, false);
        }
        if (!at.isEmpty(this.euX.name)) {
            this.mTitleView.setText(this.euX.name + " " + getContext().getResources().getString(R.string.smart_app_suffix));
        } else {
            this.mTitleView.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
        }
        if (!at.isEmpty(this.euX._abstract)) {
            this.euW.setText(this.euX._abstract);
        } else {
            this.euW.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
        }
        setVisibility(0);
    }
}

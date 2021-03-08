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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import tbclient.SmartApp;
/* loaded from: classes.dex */
public class ThreadSmartAppLayout extends RelativeLayout implements View.OnClickListener, p<com.baidu.tbadk.core.data.a> {
    private View.OnClickListener alm;
    private HeadImageView fht;
    private TextView fmQ;
    private SmartApp fmR;
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
        this.fht = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.fht.setIsRound(true);
        this.fht.setPlaceHolder(1);
        this.mTitleView = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.fmQ = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.applets_cell_bg);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        ap.setViewTextColor(this.fmQ, R.color.CAM_X0107);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.alm = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fmR != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.fmR.id, this.fmR.link, "1191003900000000", this.fmR.is_game)) {
                if (!au.isEmpty(this.fmR.h5_url)) {
                    bf.bsY().b(V(getContext()), new String[]{this.fmR.h5_url});
                } else {
                    return;
                }
            }
            if (this.alm != null) {
                this.alm.onClick(view);
            }
        }
    }

    private TbPageContext V(Context context) {
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
    public void E(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.blp() == null || aVar.blp().boG() == null) {
            setVisibility(8);
            return;
        }
        this.fmR = aVar.blp().boG();
        if (!au.isEmpty(this.fmR.avatar)) {
            this.fht.startLoad(this.fmR.avatar, 10, false, false);
        }
        if (!au.isEmpty(this.fmR.name)) {
            this.mTitleView.setText(this.fmR.name + " " + getContext().getResources().getString(R.string.smart_app_suffix));
        } else {
            this.mTitleView.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
        }
        if (!au.isEmpty(this.fmR._abstract)) {
            this.fmQ.setText(this.fmR._abstract);
        } else {
            this.fmQ.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
        }
        setVisibility(0);
    }
}

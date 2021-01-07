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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import tbclient.SmartApp;
/* loaded from: classes.dex */
public class ThreadSmartAppLayout extends RelativeLayout implements View.OnClickListener, p<com.baidu.tbadk.core.data.a> {
    private View.OnClickListener akV;
    private HeadImageView fio;
    private TextView fnI;
    private SmartApp fnJ;
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
        this.fio = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.fio.setIsRound(true);
        this.fio.setPlaceHolder(1);
        this.mTitleView = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.fnI = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this, R.drawable.applets_cell_bg);
        ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        ao.setViewTextColor(this.fnI, R.color.CAM_X0107);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.akV = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fnJ != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.fnJ.id, this.fnJ.link, "1191003900000000", this.fnJ.is_game)) {
                if (!at.isEmpty(this.fnJ.h5_url)) {
                    be.bwv().b(X(getContext()), new String[]{this.fnJ.h5_url});
                } else {
                    return;
                }
            }
            if (this.akV != null) {
                this.akV.onClick(view);
            }
        }
    }

    private TbPageContext X(Context context) {
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
    public void D(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.boP() == null || aVar.boP().bsg() == null) {
            setVisibility(8);
            return;
        }
        this.fnJ = aVar.boP().bsg();
        if (!at.isEmpty(this.fnJ.avatar)) {
            this.fio.startLoad(this.fnJ.avatar, 10, false, false);
        }
        if (!at.isEmpty(this.fnJ.name)) {
            this.mTitleView.setText(this.fnJ.name + " " + getContext().getResources().getString(R.string.smart_app_suffix));
        } else {
            this.mTitleView.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
        }
        if (!at.isEmpty(this.fnJ._abstract)) {
            this.fnI.setText(this.fnJ._abstract);
        } else {
            this.fnI.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
        }
        setVisibility(0);
    }
}

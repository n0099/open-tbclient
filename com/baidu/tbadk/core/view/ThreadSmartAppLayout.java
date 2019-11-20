package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class ThreadSmartAppLayout extends RelativeLayout implements View.OnClickListener, com.baidu.card.i<com.baidu.tbadk.core.data.a> {
    private View.OnClickListener clw;
    private HeadImageView cno;
    private TextView cqU;
    private SmartApp cqV;
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
        this.cno = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.cno.setIsRound(true);
        this.mTitleView = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.cqU = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this, R.drawable.applets_cell_bg);
        am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.cqU, (int) R.color.cp_cont_j);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.clw = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cqV != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.cqV.id, this.cqV.link, "1191003900000000", this.cqV.is_game)) {
                if (!aq.isEmpty(this.cqV.h5_url)) {
                    ba.amO().b(ct(getContext()), new String[]{this.cqV.h5_url});
                } else {
                    return;
                }
            }
            if (this.clw != null) {
                this.clw.onClick(view);
            }
        }
    }

    private TbPageContext ct(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.agG() == null || aVar.agG().ajq() == null) {
            setVisibility(8);
            return;
        }
        this.cqV = aVar.agG().ajq();
        if (!aq.isEmpty(this.cqV.avatar)) {
            this.cno.startLoad(this.cqV.avatar, 10, false, false);
        }
        if (!aq.isEmpty(this.cqV.name)) {
            this.mTitleView.setText(this.cqV.name + HanziToPinyin.Token.SEPARATOR + getContext().getResources().getString(R.string.smart_app_suffix));
        } else {
            this.mTitleView.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
        }
        if (!aq.isEmpty(this.cqV._abstract)) {
            this.cqU.setText(this.cqV._abstract);
        } else {
            this.cqU.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
        }
        setVisibility(0);
    }
}

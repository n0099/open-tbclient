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
/* loaded from: classes6.dex */
public class ThreadSmartAppLayout extends RelativeLayout implements View.OnClickListener, com.baidu.card.m<com.baidu.tbadk.core.data.a> {
    private View.OnClickListener MG;
    private HeadImageView daJ;
    private TextView dey;
    private SmartApp dez;
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
        this.daJ = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.daJ.setIsRound(true);
        this.daJ.setPlaceHolder(1);
        this.mTitleView = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.dey = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this, R.drawable.applets_cell_bg);
        am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dey, (int) R.color.cp_cont_j);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.MG = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dez != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.dez.id, this.dez.link, "1191003900000000", this.dez.is_game)) {
                if (!aq.isEmpty(this.dez.h5_url)) {
                    ba.aEt().b(dO(getContext()), new String[]{this.dez.h5_url});
                } else {
                    return;
                }
            }
            if (this.MG != null) {
                this.MG.onClick(view);
            }
        }
    }

    private TbPageContext dO(Context context) {
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
    public void A(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.axQ() == null || aVar.axQ().aAJ() == null) {
            setVisibility(8);
            return;
        }
        this.dez = aVar.axQ().aAJ();
        if (!aq.isEmpty(this.dez.avatar)) {
            this.daJ.startLoad(this.dez.avatar, 10, false, false);
        }
        if (!aq.isEmpty(this.dez.name)) {
            this.mTitleView.setText(this.dez.name + HanziToPinyin.Token.SEPARATOR + getContext().getResources().getString(R.string.smart_app_suffix));
        } else {
            this.mTitleView.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
        }
        if (!aq.isEmpty(this.dez._abstract)) {
            this.dey.setText(this.dez._abstract);
        } else {
            this.dey.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
        }
        setVisibility(0);
    }
}

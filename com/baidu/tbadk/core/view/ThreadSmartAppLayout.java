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
/* loaded from: classes8.dex */
public class ThreadSmartAppLayout extends RelativeLayout implements View.OnClickListener, com.baidu.card.m<com.baidu.tbadk.core.data.a> {
    private View.OnClickListener Nh;
    private HeadImageView deO;
    private TextView diE;
    private SmartApp diF;
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
        this.deO = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.deO.setIsRound(true);
        this.deO.setPlaceHolder(1);
        this.mTitleView = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.diE = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this, R.drawable.applets_cell_bg);
        am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.diE, (int) R.color.cp_cont_j);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Nh = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.diF != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.diF.id, this.diF.link, "1191003900000000", this.diF.is_game)) {
                if (!aq.isEmpty(this.diF.h5_url)) {
                    ba.aGE().b(dS(getContext()), new String[]{this.diF.h5_url});
                } else {
                    return;
                }
            }
            if (this.Nh != null) {
                this.Nh.onClick(view);
            }
        }
    }

    private TbPageContext dS(Context context) {
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
        if (aVar == null || aVar.aAe() == null || aVar.aAe().aCY() == null) {
            setVisibility(8);
            return;
        }
        this.diF = aVar.aAe().aCY();
        if (!aq.isEmpty(this.diF.avatar)) {
            this.deO.startLoad(this.diF.avatar, 10, false, false);
        }
        if (!aq.isEmpty(this.diF.name)) {
            this.mTitleView.setText(this.diF.name + HanziToPinyin.Token.SEPARATOR + getContext().getResources().getString(R.string.smart_app_suffix));
        } else {
            this.mTitleView.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
        }
        if (!aq.isEmpty(this.diF._abstract)) {
            this.diE.setText(this.diF._abstract);
        } else {
            this.diE.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
        }
        setVisibility(0);
    }
}

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
    private View.OnClickListener ajT;
    private HeadImageView ffU;
    private TextView flq;
    private SmartApp flr;
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
        this.ffU = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.ffU.setIsRound(true);
        this.ffU.setPlaceHolder(1);
        this.mTitleView = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.flq = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.applets_cell_bg);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        ap.setViewTextColor(this.flq, R.color.CAM_X0107);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajT = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.flr != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.flr.id, this.flr.link, "1191003900000000", this.flr.is_game)) {
                if (!au.isEmpty(this.flr.h5_url)) {
                    bf.bsV().b(W(getContext()), new String[]{this.flr.h5_url});
                } else {
                    return;
                }
            }
            if (this.ajT != null) {
                this.ajT.onClick(view);
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
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.bln() == null || aVar.bln().boE() == null) {
            setVisibility(8);
            return;
        }
        this.flr = aVar.bln().boE();
        if (!au.isEmpty(this.flr.avatar)) {
            this.ffU.startLoad(this.flr.avatar, 10, false, false);
        }
        if (!au.isEmpty(this.flr.name)) {
            this.mTitleView.setText(this.flr.name + " " + getContext().getResources().getString(R.string.smart_app_suffix));
        } else {
            this.mTitleView.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
        }
        if (!au.isEmpty(this.flr._abstract)) {
            this.flq.setText(this.flr._abstract);
        } else {
            this.flq.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
        }
        setVisibility(0);
    }
}

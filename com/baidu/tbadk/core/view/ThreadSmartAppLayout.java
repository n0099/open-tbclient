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
    private View.OnClickListener ake;
    private HeadImageView fdF;
    private TextView fiZ;
    private SmartApp fja;
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
        this.fdF = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.fdF.setIsRound(true);
        this.fdF.setPlaceHolder(1);
        this.mTitleView = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.fiZ = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this, R.drawable.applets_cell_bg);
        ao.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        ao.setViewTextColor(this.fiZ, R.color.CAM_X0107);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ake = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fja != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.fja.id, this.fja.link, "1191003900000000", this.fja.is_game)) {
                if (!at.isEmpty(this.fja.h5_url)) {
                    be.bsB().b(W(getContext()), new String[]{this.fja.h5_url});
                } else {
                    return;
                }
            }
            if (this.ake != null) {
                this.ake.onClick(view);
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
        if (aVar == null || aVar.bkV() == null || aVar.bkV().bom() == null) {
            setVisibility(8);
            return;
        }
        this.fja = aVar.bkV().bom();
        if (!at.isEmpty(this.fja.avatar)) {
            this.fdF.startLoad(this.fja.avatar, 10, false, false);
        }
        if (!at.isEmpty(this.fja.name)) {
            this.mTitleView.setText(this.fja.name + " " + getContext().getResources().getString(R.string.smart_app_suffix));
        } else {
            this.mTitleView.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
        }
        if (!at.isEmpty(this.fja._abstract)) {
            this.fiZ.setText(this.fja._abstract);
        } else {
            this.fiZ.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
        }
        setVisibility(0);
    }
}

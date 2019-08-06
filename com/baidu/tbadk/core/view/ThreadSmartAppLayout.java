package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.R;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class ThreadSmartAppLayout extends RelativeLayout implements View.OnClickListener, com.baidu.card.i<com.baidu.tbadk.core.data.a> {
    private View.OnClickListener bWq;
    private HeadImageView bYt;
    private TextView ccF;
    private SmartApp ccG;
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
        this.bYt = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.bYt.setIsRound(true);
        this.mTitleView = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.ccF = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        am.k(this, R.drawable.applets_cell_bg);
        am.j(this.mTitleView, R.color.cp_cont_b);
        am.j(this.ccF, R.color.cp_cont_j);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bWq = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ccG != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.ccG.id, this.ccG.link, "1191003900000000", this.ccG.is_game)) {
                if (!aq.isEmpty(this.ccG.h5_url)) {
                    bb.ajE().c(cH(getContext()), new String[]{this.ccG.h5_url});
                } else {
                    return;
                }
            }
            if (this.bWq != null) {
                this.bWq.onClick(view);
            }
        }
    }

    private TbPageContext cH(Context context) {
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
    public void C(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.acy() == null || aVar.acy().afk() == null) {
            setVisibility(8);
            return;
        }
        this.ccG = aVar.acy().afk();
        if (!aq.isEmpty(this.ccG.avatar)) {
            this.bYt.startLoad(this.ccG.avatar, 10, false, false);
        }
        if (!aq.isEmpty(this.ccG.name)) {
            this.mTitleView.setText(this.ccG.name + " " + getContext().getResources().getString(R.string.smart_app_suffix));
        } else {
            this.mTitleView.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
        }
        if (!aq.isEmpty(this.ccG._abstract)) {
            this.ccF.setText(this.ccG._abstract);
        } else {
            this.ccF.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
        }
        setVisibility(0);
    }
}

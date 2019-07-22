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
    private View.OnClickListener bWk;
    private HeadImageView bYn;
    private TextView ccy;
    private SmartApp ccz;
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
        this.bYn = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.bYn.setIsRound(true);
        this.mTitleView = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.ccy = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        am.k(this, R.drawable.applets_cell_bg);
        am.j(this.mTitleView, R.color.cp_cont_b);
        am.j(this.ccy, R.color.cp_cont_j);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bWk = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ccz != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.ccz.id, this.ccz.link, "1191003900000000", this.ccz.is_game)) {
                if (!aq.isEmpty(this.ccz.h5_url)) {
                    bb.ajC().c(cH(getContext()), new String[]{this.ccz.h5_url});
                } else {
                    return;
                }
            }
            if (this.bWk != null) {
                this.bWk.onClick(view);
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
        if (aVar == null || aVar.acx() == null || aVar.acx().afj() == null) {
            setVisibility(8);
            return;
        }
        this.ccz = aVar.acx().afj();
        if (!aq.isEmpty(this.ccz.avatar)) {
            this.bYn.startLoad(this.ccz.avatar, 10, false, false);
        }
        if (!aq.isEmpty(this.ccz.name)) {
            this.mTitleView.setText(this.ccz.name + " " + getContext().getResources().getString(R.string.smart_app_suffix));
        } else {
            this.mTitleView.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
        }
        if (!aq.isEmpty(this.ccz._abstract)) {
            this.ccy.setText(this.ccz._abstract);
        } else {
            this.ccy.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
        }
        setVisibility(0);
    }
}

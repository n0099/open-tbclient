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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class ThreadSmartAppLayout extends RelativeLayout implements View.OnClickListener, com.baidu.card.i<com.baidu.tbadk.core.data.a> {
    private View.OnClickListener bXj;
    private HeadImageView bZm;
    private TextView cdy;
    private SmartApp cdz;
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
        this.bZm = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.bZm.setIsRound(true);
        this.mTitleView = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.cdy = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        am.k(this, R.drawable.applets_cell_bg);
        am.j(this.mTitleView, R.color.cp_cont_b);
        am.j(this.cdy, R.color.cp_cont_j);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bXj = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cdz != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.cdz.id, this.cdz.link, "1191003900000000", this.cdz.is_game)) {
                if (!aq.isEmpty(this.cdz.h5_url)) {
                    ba.ajK().c(cH(getContext()), new String[]{this.cdz.h5_url});
                } else {
                    return;
                }
            }
            if (this.bXj != null) {
                this.bXj.onClick(view);
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
        if (aVar == null || aVar.acC() == null || aVar.acC().afo() == null) {
            setVisibility(8);
            return;
        }
        this.cdz = aVar.acC().afo();
        if (!aq.isEmpty(this.cdz.avatar)) {
            this.bZm.startLoad(this.cdz.avatar, 10, false, false);
        }
        if (!aq.isEmpty(this.cdz.name)) {
            this.mTitleView.setText(this.cdz.name + " " + getContext().getResources().getString(R.string.smart_app_suffix));
        } else {
            this.mTitleView.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
        }
        if (!aq.isEmpty(this.cdz._abstract)) {
            this.cdy.setText(this.cdz._abstract);
        } else {
            this.cdy.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
        }
        setVisibility(0);
    }
}

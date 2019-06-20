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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class ThreadSmartAppLayout extends RelativeLayout implements View.OnClickListener, com.baidu.card.i<com.baidu.tbadk.core.data.a> {
    private View.OnClickListener bVj;
    private HeadImageView bXl;
    private TextView cbv;
    private SmartApp cbw;
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
        this.bXl = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.bXl.setIsRound(true);
        this.mTitleView = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.cbv = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        al.k(this, R.drawable.applets_cell_bg);
        al.j(this.mTitleView, R.color.cp_cont_b);
        al.j(this.cbv, R.color.cp_cont_j);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bVj = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cbw != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.cbw.id, this.cbw.link, "1191003900000000", this.cbw.is_game)) {
                if (!ap.isEmpty(this.cbw.h5_url)) {
                    ba.aiz().c(cG(getContext()), new String[]{this.cbw.h5_url});
                } else {
                    return;
                }
            }
            if (this.bVj != null) {
                this.bVj.onClick(view);
            }
        }
    }

    private TbPageContext cG(Context context) {
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
        if (aVar == null || aVar.abv() == null || aVar.abv().aeh() == null) {
            setVisibility(8);
            return;
        }
        this.cbw = aVar.abv().aeh();
        if (!ap.isEmpty(this.cbw.avatar)) {
            this.bXl.startLoad(this.cbw.avatar, 10, false, false);
        }
        if (!ap.isEmpty(this.cbw.name)) {
            this.mTitleView.setText(this.cbw.name + " " + getContext().getResources().getString(R.string.smart_app_suffix));
        } else {
            this.mTitleView.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
        }
        if (!ap.isEmpty(this.cbw._abstract)) {
            this.cbv.setText(this.cbw._abstract);
        } else {
            this.cbv.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
        }
        setVisibility(0);
    }
}

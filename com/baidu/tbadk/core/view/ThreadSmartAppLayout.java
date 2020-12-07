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
/* loaded from: classes21.dex */
public class ThreadSmartAppLayout extends RelativeLayout implements View.OnClickListener, p<com.baidu.tbadk.core.data.a> {
    private View.OnClickListener akt;
    private HeadImageView eYM;
    private TextView fdZ;
    private SmartApp fea;
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
        this.eYM = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.eYM.setIsRound(true);
        this.eYM.setPlaceHolder(1);
        this.mTitleView = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.fdZ = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.applets_cell_bg);
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        ap.setViewTextColor(this.fdZ, R.color.CAM_X0107);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fea != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.fea.id, this.fea.link, "1191003900000000", this.fea.is_game)) {
                if (!au.isEmpty(this.fea.h5_url)) {
                    bf.bua().b(X(getContext()), new String[]{this.fea.h5_url});
                } else {
                    return;
                }
            }
            if (this.akt != null) {
                this.akt.onClick(view);
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
    public void H(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.bmn() == null || aVar.bmn().bpE() == null) {
            setVisibility(8);
            return;
        }
        this.fea = aVar.bmn().bpE();
        if (!au.isEmpty(this.fea.avatar)) {
            this.eYM.startLoad(this.fea.avatar, 10, false, false);
        }
        if (!au.isEmpty(this.fea.name)) {
            this.mTitleView.setText(this.fea.name + " " + getContext().getResources().getString(R.string.smart_app_suffix));
        } else {
            this.mTitleView.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
        }
        if (!au.isEmpty(this.fea._abstract)) {
            this.fdZ.setText(this.fea._abstract);
        } else {
            this.fdZ.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
        }
        setVisibility(0);
    }
}

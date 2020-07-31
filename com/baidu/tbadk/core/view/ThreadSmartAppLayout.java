package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.card.n;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
import tbclient.SmartApp;
/* loaded from: classes15.dex */
public class ThreadSmartAppLayout extends RelativeLayout implements View.OnClickListener, n<AbsThreadDataSupport> {
    private View.OnClickListener ahn;
    private HeadImageView egg;
    private TextView ekX;
    private SmartApp ekY;
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
        this.egg = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.egg.setIsRound(true);
        this.egg.setPlaceHolder(1);
        this.mTitleView = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.ekX = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this, R.drawable.applets_cell_bg);
        ao.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
        ao.setViewTextColor(this.ekX, R.color.cp_cont_j);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ahn = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ekY != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.ekY.id, this.ekY.link, "1191003900000000", this.ekY.is_game)) {
                if (!as.isEmpty(this.ekY.h5_url)) {
                    bd.baV().b(T(getContext()), new String[]{this.ekY.h5_url});
                } else {
                    return;
                }
            }
            if (this.ahn != null) {
                this.ahn.onClick(view);
            }
        }
    }

    private TbPageContext T(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport == null || absThreadDataSupport.aTN() == null || absThreadDataSupport.aTN().aXa() == null) {
            setVisibility(8);
            return;
        }
        this.ekY = absThreadDataSupport.aTN().aXa();
        if (!as.isEmpty(this.ekY.avatar)) {
            this.egg.startLoad(this.ekY.avatar, 10, false, false);
        }
        if (!as.isEmpty(this.ekY.name)) {
            this.mTitleView.setText(this.ekY.name + " " + getContext().getResources().getString(R.string.smart_app_suffix));
        } else {
            this.mTitleView.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
        }
        if (!as.isEmpty(this.ekY._abstract)) {
            this.ekX.setText(this.ekY._abstract);
        } else {
            this.ekX.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
        }
        setVisibility(0);
    }
}

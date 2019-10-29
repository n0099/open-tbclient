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
/* loaded from: classes3.dex */
public class ThreadSmartAppLayout extends RelativeLayout implements View.OnClickListener, com.baidu.card.i<com.baidu.tbadk.core.data.a> {
    private View.OnClickListener cmo;
    private HeadImageView cog;
    private TextView crM;
    private SmartApp crN;
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
        this.cog = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.cog.setIsRound(true);
        this.mTitleView = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.crM = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this, R.drawable.applets_cell_bg);
        am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.crM, (int) R.color.cp_cont_j);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.cmo = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.crN != null) {
            if (!com.baidu.tieba.aiapps.a.b(this.crN.id, this.crN.link, "1191003900000000", this.crN.is_game)) {
                if (!aq.isEmpty(this.crN.h5_url)) {
                    ba.amQ().b(ct(getContext()), new String[]{this.crN.h5_url});
                } else {
                    return;
                }
            }
            if (this.cmo != null) {
                this.cmo.onClick(view);
            }
        }
    }

    private TbPageContext ct(Context context) {
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
    public void z(com.baidu.tbadk.core.data.a aVar) {
        if (aVar == null || aVar.agI() == null || aVar.agI().ajs() == null) {
            setVisibility(8);
            return;
        }
        this.crN = aVar.agI().ajs();
        if (!aq.isEmpty(this.crN.avatar)) {
            this.cog.startLoad(this.crN.avatar, 10, false, false);
        }
        if (!aq.isEmpty(this.crN.name)) {
            this.mTitleView.setText(this.crN.name + HanziToPinyin.Token.SEPARATOR + getContext().getResources().getString(R.string.smart_app_suffix));
        } else {
            this.mTitleView.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
        }
        if (!aq.isEmpty(this.crN._abstract)) {
            this.crM.setText(this.crN._abstract);
        } else {
            this.crM.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
        }
        setVisibility(0);
    }
}

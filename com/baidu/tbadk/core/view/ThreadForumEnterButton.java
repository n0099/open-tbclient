package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumEnterButton extends RelativeLayout implements View.OnClickListener {
    private static final int FI = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds70) * 2);
    private bh cbq;
    private View.OnClickListener cmo;
    public final int crb;
    private TextView crd;
    private Context mContext;
    private int mFrom;
    private int mSkinType;
    private View mView;

    public ThreadForumEnterButton(Context context) {
        super(context);
        this.crb = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    public ThreadForumEnterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.crb = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_button, (ViewGroup) this, true);
        this.crd = (TextView) this.mView.findViewById(R.id.forum_name_text);
        this.crd.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.cbq.aiL())) {
            view.setTag(this.cbq);
            if (this.mFrom == 0) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.mContext).createNormalCfg(this.cbq.aiL(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            } else if (this.mFrom == 1) {
            }
            if (this.cmo != null) {
                this.cmo.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.cmo = onClickListener;
    }

    public void onChangeSkinType() {
        if (this.cbq != null) {
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            }
            int Vl = com.baidu.tbadk.util.e.Vl();
            am.setBackgroundColor(this.crd, Vl);
            if (this.mSkinType == 0) {
                am.setViewTextColor(this.crd, (int) R.color.cp_cont_b);
            } else {
                this.crd.setTextColor(com.baidu.tbadk.util.e.kn(Vl));
            }
        }
    }

    public void y(bh bhVar) {
        if (bhVar != null) {
            String aiL = bhVar.aiL();
            if (StringUtils.isNull(aiL)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.cbq = bhVar;
            this.crd.setText(((Object) TextUtils.ellipsize(aiL, this.crd.getPaint(), FI - this.crd.getPaint().measureText(getResources().getString(R.string.forum)), TextUtils.TruncateAt.END)) + getResources().getString(R.string.forum));
            onChangeSkinType();
            return;
        }
        setVisibility(8);
    }

    public void a(bh bhVar, int i) {
        if (this.crd != null && bhVar != null && i > 0) {
            this.cbq = bhVar;
            float paddingLeft = (i - (this.crd.getPaddingLeft() * 2)) - this.crd.getPaint().measureText(getResources().getString(R.string.forum));
            String aiL = bhVar.aiL();
            if (StringUtils.isNull(aiL)) {
                setVisibility(8);
                return;
            }
            this.crd.setText(((Object) TextUtils.ellipsize(aiL, this.crd.getPaint(), paddingLeft, TextUtils.TruncateAt.END)) + getResources().getString(R.string.forum));
            setVisibility(0);
            onChangeSkinType();
            return;
        }
        setVisibility(8);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}

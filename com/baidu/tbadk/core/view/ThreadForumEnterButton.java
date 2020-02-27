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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumEnterButton extends RelativeLayout implements View.OnClickListener {
    private static final int Ky = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds70) * 2);
    private View.OnClickListener Nh;
    private bj cRe;
    public final int dhR;
    private TextView dhS;
    private Context mContext;
    private int mFrom;
    private int mSkinType;
    private View mView;

    public ThreadForumEnterButton(Context context) {
        super(context);
        this.dhR = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    public ThreadForumEnterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dhR = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_button, (ViewGroup) this, true);
        this.dhS = (TextView) this.mView.findViewById(R.id.forum_name_text);
        this.dhS.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.cRe.aCr())) {
            view.setTag(this.cRe);
            if (this.mFrom == 0) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.mContext).createNormalCfg(this.cRe.aCr(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            } else if (this.mFrom == 1) {
            }
            if (this.Nh != null) {
                this.Nh.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Nh = onClickListener;
    }

    public void onChangeSkinType() {
        if (this.cRe != null) {
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            }
            int aRU = com.baidu.tbadk.util.f.aRU();
            am.setBackgroundColor(this.dhS, aRU);
            if (this.mSkinType == 0) {
                am.setViewTextColor(this.dhS, (int) R.color.cp_cont_b);
            } else {
                this.dhS.setTextColor(com.baidu.tbadk.util.f.mS(aRU));
            }
        }
    }

    public void q(bj bjVar) {
        if (bjVar != null) {
            String aCr = bjVar.aCr();
            if (StringUtils.isNull(aCr)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.cRe = bjVar;
            this.dhS.setText(((Object) TextUtils.ellipsize(aCr, this.dhS.getPaint(), Ky - this.dhS.getPaint().measureText(getResources().getString(R.string.forum)), TextUtils.TruncateAt.END)) + getResources().getString(R.string.forum));
            onChangeSkinType();
            return;
        }
        setVisibility(8);
    }

    public void a(bj bjVar, int i) {
        if (this.dhS != null && bjVar != null && i > 0) {
            this.cRe = bjVar;
            float paddingLeft = (i - (this.dhS.getPaddingLeft() * 2)) - this.dhS.getPaint().measureText(getResources().getString(R.string.forum));
            String aCr = bjVar.aCr();
            if (StringUtils.isNull(aCr)) {
                setVisibility(8);
                return;
            }
            this.dhS.setText(((Object) TextUtils.ellipsize(aCr, this.dhS.getPaint(), paddingLeft, TextUtils.TruncateAt.END)) + getResources().getString(R.string.forum));
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

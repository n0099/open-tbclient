package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumEnterButton extends RelativeLayout implements View.OnClickListener {
    private static final int ahn;
    private View.OnClickListener akt;
    private by eCR;
    public final int fdp;
    private TextView fdq;
    private Context mContext;
    private int mFrom;
    private Drawable mIconDrawable;
    private int mSkinType;
    private View mView;

    static {
        ahn = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.tbadk.a.d.bkA() ? com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public ThreadForumEnterButton(Context context) {
        super(context);
        this.fdp = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    public ThreadForumEnterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fdp = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnClickListener(this);
        this.mView = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_button, (ViewGroup) this, true);
        this.fdq = (TextView) this.mView.findViewById(R.id.forum_name_text);
        this.fdq.setCompoundDrawablePadding(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X002));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.eCR.boT())) {
            view.setTag(this.eCR);
            if (this.mFrom == 0) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.mContext).createNormalCfg(this.eCR.boT(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            } else if (this.mFrom == 1) {
            }
            if (this.akt != null) {
                this.akt.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }

    public void onChangeSkinType() {
        int skinType;
        if (this.eCR != null && this.mSkinType != (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            this.mSkinType = skinType;
            com.baidu.tbadk.core.elementsMaven.c.bm(this.fdq).pu(R.string.F_X01).pt(R.dimen.T_X09).ps(R.color.CAM_X0304).pE(R.string.A_X07).pA(R.string.J_X01).pD(R.dimen.L_X02).pC(R.color.CAM_X0304);
            this.mIconDrawable = WebPManager.a(R.drawable.icon_pure_ba12, ap.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL_PRESS);
            if (this.mIconDrawable != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.T_X09);
                this.mIconDrawable.setBounds(0, 0, dimens, dimens);
            }
            bvL();
        }
    }

    public void a(by byVar, int i) {
        this.eCR = byVar;
        if (byVar != null && i > 0) {
            int paddingLeft = this.fdq.getPaddingLeft();
            String boT = byVar.boT();
            if (StringUtils.isNull(boT)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            bvL();
            this.fdq.setText(((Object) TextUtils.ellipsize(boT, this.fdq.getPaint(), (i - (paddingLeft * 2)) - this.fdq.getPaint().measureText(getResources().getString(R.string.forum)), TextUtils.TruncateAt.END)) + getResources().getString(R.string.forum));
            this.fdq.setVisibility(0);
            onChangeSkinType();
            return;
        }
        setVisibility(8);
    }

    private void bvL() {
        this.fdq.setCompoundDrawables(this.mIconDrawable, null, null, null);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}

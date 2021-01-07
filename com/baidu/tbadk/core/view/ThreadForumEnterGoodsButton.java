package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumEnterGoodsButton extends RelativeLayout implements View.OnClickListener {
    private View.OnClickListener akV;
    private bz eMv;
    public final int fmY;
    private TextView fmZ;
    private Context mContext;
    private int mFrom;
    private Drawable mIconDrawable;
    private int mSkinType;
    private View mView;

    public ThreadForumEnterGoodsButton(Context context) {
        super(context);
        this.fmY = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    public ThreadForumEnterGoodsButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmY = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnClickListener(this);
        this.mView = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_button, (ViewGroup) this, true);
        this.fmZ = (TextView) this.mView.findViewById(R.id.forum_name_text);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.fmZ).pE(R.string.F_X01).pD(R.dimen.T_X09).pC(R.color.CAM_X0305).pO(R.string.A_X07).pK(R.string.J_X01).pN(R.dimen.L_X02).pM(R.color.CAM_X0305);
        this.fmZ.setCompoundDrawablePadding(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X002));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.eMv.brv())) {
            view.setTag(this.eMv);
            if (this.mFrom == 0) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.mContext).createNormalCfg(this.eMv.brv(), FrsActivityConfig.FROM_PB_OR_PERSON);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            } else if (this.mFrom == 1) {
                au("c13967", 2);
                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.mContext).createNormalCfg(this.eMv.brv(), FrsActivityConfig.FROM_PB_OR_PERSON);
                createNormalCfg2.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
            } else if (this.mFrom == 2) {
                au("c13967", 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921488));
            }
            if (this.akV != null) {
                this.akV.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.akV = onClickListener;
    }

    public void onChangeSkinType() {
        int skinType;
        if (this.eMv != null && this.mSkinType != (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            this.mSkinType = skinType;
            int color = ao.getColor(R.color.CAM_X0305);
            ao.a(this.fmZ, color);
            this.mIconDrawable = WebPManager.a(R.drawable.icon_pure_good12, color, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (this.mIconDrawable != null) {
                this.mIconDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.T_X09), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.T_X09));
            }
            byh();
        }
    }

    public void r(bz bzVar) {
        this.eMv = bzVar;
        if (bzVar != null) {
            String string = getResources().getString(R.string.frs_goods_tip_content);
            if (StringUtils.isNull(string)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            byh();
            this.fmZ.setText(string);
            this.fmZ.setVisibility(0);
            onChangeSkinType();
            byi();
            return;
        }
        setVisibility(8);
    }

    private void byi() {
        if (this.mFrom == 2) {
            au("c13966", 1);
        } else if (this.mFrom == 1) {
            au("c13966", 2);
        } else {
            if (this.mFrom == 0) {
            }
        }
    }

    private void au(String str, int i) {
        TiebaStatic.log(new aq(str).an("obj_locate", i).w("fid", this.eMv.getFid()).dX("fname", this.eMv.brv()).dX("tid", this.eMv.getTid()));
    }

    private void byh() {
        this.fmZ.setCompoundDrawables(this.mIconDrawable, null, null, null);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}

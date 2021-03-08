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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumEnterGoodsButton extends RelativeLayout implements View.OnClickListener {
    private View.OnClickListener alm;
    private cb eLr;
    public final int fmf;
    private TextView fmg;
    private Context mContext;
    private int mFrom;
    private Drawable mIconDrawable;
    private int mSkinType;
    private View mView;

    public ThreadForumEnterGoodsButton(Context context) {
        super(context);
        this.fmf = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    public ThreadForumEnterGoodsButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmf = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnClickListener(this);
        this.mView = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_button, (ViewGroup) this, true);
        this.fmg = (TextView) this.mView.findViewById(R.id.forum_name_text);
        com.baidu.tbadk.core.elementsMaven.c.br(this.fmg).ob(R.string.F_X01).oa(R.dimen.T_X09).nZ(R.color.CAM_X0305).om(R.string.A_X07).oh(R.string.J_X01).ol(R.dimen.L_X02).ok(R.color.CAM_X0305);
        this.fmg.setCompoundDrawablePadding(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X002));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.eLr.bnW())) {
            view.setTag(this.eLr);
            if (this.mFrom == 0) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.mContext).createNormalCfg(this.eLr.bnW(), FrsActivityConfig.FROM_PB_OR_PERSON);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            } else if (this.mFrom == 1) {
                aw("c13967", 2);
                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.mContext).createNormalCfg(this.eLr.bnW(), FrsActivityConfig.FROM_PB_OR_PERSON);
                createNormalCfg2.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
            } else if (this.mFrom == 2) {
                aw("c13967", 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921488));
            }
            if (this.alm != null) {
                this.alm.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.alm = onClickListener;
    }

    public void onChangeSkinType() {
        int skinType;
        if (this.eLr != null && this.mSkinType != (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            this.mSkinType = skinType;
            int color = ap.getColor(R.color.CAM_X0305);
            ap.a(this.fmg, color);
            this.mIconDrawable = WebPManager.a(R.drawable.icon_pure_good12, color, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (this.mIconDrawable != null) {
                this.mIconDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.T_X09), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.T_X09));
            }
            buK();
        }
    }

    public void r(cb cbVar) {
        this.eLr = cbVar;
        if (cbVar != null) {
            String string = getResources().getString(R.string.frs_goods_tip_content);
            if (StringUtils.isNull(string)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            buK();
            this.fmg.setText(string);
            this.fmg.setVisibility(0);
            onChangeSkinType();
            buL();
            return;
        }
        setVisibility(8);
    }

    private void buL() {
        if (this.mFrom == 2) {
            aw("c13966", 1);
        } else if (this.mFrom == 1) {
            aw("c13966", 2);
        } else {
            if (this.mFrom == 0) {
            }
        }
    }

    private void aw(String str, int i) {
        TiebaStatic.log(new ar(str).aq("obj_locate", i).v("fid", this.eLr.getFid()).dR("fname", this.eLr.bnW()).dR("tid", this.eLr.getTid()));
    }

    private void buK() {
        this.fmg.setCompoundDrawables(this.mIconDrawable, null, null, null);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}

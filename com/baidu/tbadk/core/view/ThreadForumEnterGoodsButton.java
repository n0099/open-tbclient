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
    private View.OnClickListener ajT;
    private cb eJQ;
    public final int fkG;
    private TextView fkH;
    private Context mContext;
    private int mFrom;
    private Drawable mIconDrawable;
    private int mSkinType;
    private View mView;

    public ThreadForumEnterGoodsButton(Context context) {
        super(context);
        this.fkG = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    public ThreadForumEnterGoodsButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fkG = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnClickListener(this);
        this.mView = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_button, (ViewGroup) this, true);
        this.fkH = (TextView) this.mView.findViewById(R.id.forum_name_text);
        com.baidu.tbadk.core.elementsMaven.c.br(this.fkH).oa(R.string.F_X01).nZ(R.dimen.T_X09).nY(R.color.CAM_X0305).ol(R.string.A_X07).og(R.string.J_X01).ok(R.dimen.L_X02).oj(R.color.CAM_X0305);
        this.fkH.setCompoundDrawablePadding(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X002));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.eJQ.bnU())) {
            view.setTag(this.eJQ);
            if (this.mFrom == 0) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.mContext).createNormalCfg(this.eJQ.bnU(), FrsActivityConfig.FROM_PB_OR_PERSON);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            } else if (this.mFrom == 1) {
                aw("c13967", 2);
                FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(this.mContext).createNormalCfg(this.eJQ.bnU(), FrsActivityConfig.FROM_PB_OR_PERSON);
                createNormalCfg2.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
            } else if (this.mFrom == 2) {
                aw("c13967", 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921488));
            }
            if (this.ajT != null) {
                this.ajT.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajT = onClickListener;
    }

    public void onChangeSkinType() {
        int skinType;
        if (this.eJQ != null && this.mSkinType != (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            this.mSkinType = skinType;
            int color = ap.getColor(R.color.CAM_X0305);
            ap.a(this.fkH, color);
            this.mIconDrawable = WebPManager.a(R.drawable.icon_pure_good12, color, WebPManager.ResourceStateType.NORMAL_PRESS);
            if (this.mIconDrawable != null) {
                this.mIconDrawable.setBounds(0, 0, com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.T_X09), com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.T_X09));
            }
            buH();
        }
    }

    public void r(cb cbVar) {
        this.eJQ = cbVar;
        if (cbVar != null) {
            String string = getResources().getString(R.string.frs_goods_tip_content);
            if (StringUtils.isNull(string)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            buH();
            this.fkH.setText(string);
            this.fkH.setVisibility(0);
            onChangeSkinType();
            buI();
            return;
        }
        setVisibility(8);
    }

    private void buI() {
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
        TiebaStatic.log(new ar(str).ap("obj_locate", i).v("fid", this.eJQ.getFid()).dR("fname", this.eJQ.bnU()).dR("tid", this.eJQ.getTid()));
    }

    private void buH() {
        this.fkH.setCompoundDrawables(this.mIconDrawable, null, null, null);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}

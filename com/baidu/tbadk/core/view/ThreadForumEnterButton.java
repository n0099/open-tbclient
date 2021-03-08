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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumEnterButton extends RelativeLayout implements View.OnClickListener {
    private static final int aip = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private View.OnClickListener alm;
    private cb eLr;
    public final int fmf;
    private TextView fmg;
    private Context mContext;
    private int mFrom;
    private Drawable mIconDrawable;
    private int mSkinType;
    private View mView;

    public ThreadForumEnterButton(Context context) {
        super(context);
        this.fmf = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    public ThreadForumEnterButton(Context context, AttributeSet attributeSet) {
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
        this.fmg.setCompoundDrawablePadding(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X002));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eLr.getType() == cb.eSE) {
            BdToast.b(this.mContext, this.mContext.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).bqF();
        } else if (!StringUtils.isNull(this.eLr.bnW())) {
            view.setTag(this.eLr);
            if (this.mFrom == 0) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.mContext).createNormalCfg(this.eLr.bnW(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            } else if (this.mFrom == 1) {
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
            com.baidu.tbadk.core.elementsMaven.c.br(this.fmg).ob(R.string.F_X01).oa(R.dimen.T_X09).nZ(R.color.CAM_X0304).om(R.string.A_X07).oh(R.string.J_X01).ol(R.dimen.L_X02).ok(R.color.CAM_X0304);
            this.mIconDrawable = WebPManager.a(R.drawable.icon_pure_ba12, ap.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL_PRESS);
            if (this.mIconDrawable != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.T_X09);
                this.mIconDrawable.setBounds(0, 0, dimens, dimens);
            }
            buK();
        }
    }

    public void a(cb cbVar, int i) {
        this.eLr = cbVar;
        if (cbVar != null && i > 0) {
            int paddingLeft = this.fmg.getPaddingLeft();
            String bnW = cbVar.bnW();
            if (StringUtils.isNull(bnW)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            buK();
            this.fmg.setText(((Object) TextUtils.ellipsize(bnW, this.fmg.getPaint(), (i - (paddingLeft * 2)) - this.fmg.getPaint().measureText(getResources().getString(R.string.forum)), TextUtils.TruncateAt.END)) + getResources().getString(R.string.forum));
            this.fmg.setVisibility(0);
            onChangeSkinType();
            return;
        }
        setVisibility(8);
    }

    private void buK() {
        this.fmg.setCompoundDrawables(this.mIconDrawable, null, null, null);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}

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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumEnterButton extends RelativeLayout implements View.OnClickListener {
    private static final int ahY = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private View.OnClickListener akV;
    private bz eMv;
    public final int fmY;
    private TextView fmZ;
    private Context mContext;
    private int mFrom;
    private Drawable mIconDrawable;
    private int mSkinType;
    private View mView;

    public ThreadForumEnterButton(Context context) {
        super(context);
        this.fmY = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        init(context);
    }

    public ThreadForumEnterButton(Context context, AttributeSet attributeSet) {
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
        this.fmZ.setCompoundDrawablePadding(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.M_W_X002));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eMv.getType() == bz.eTC) {
            BdToast.b(this.mContext, this.mContext.getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).bud();
        } else if (!StringUtils.isNull(this.eMv.bru())) {
            view.setTag(this.eMv);
            if (this.mFrom == 0) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.mContext).createNormalCfg(this.eMv.bru(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            } else if (this.mFrom == 1) {
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
            com.baidu.tbadk.core.elementsMaven.c.bv(this.fmZ).pE(R.string.F_X01).pD(R.dimen.T_X09).pC(R.color.CAM_X0304).pO(R.string.A_X07).pK(R.string.J_X01).pN(R.dimen.L_X02).pM(R.color.CAM_X0304);
            this.mIconDrawable = WebPManager.a(R.drawable.icon_pure_ba12, ao.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL_PRESS);
            if (this.mIconDrawable != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.T_X09);
                this.mIconDrawable.setBounds(0, 0, dimens, dimens);
            }
            byg();
        }
    }

    public void a(bz bzVar, int i) {
        this.eMv = bzVar;
        if (bzVar != null && i > 0) {
            int paddingLeft = this.fmZ.getPaddingLeft();
            String bru = bzVar.bru();
            if (StringUtils.isNull(bru)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            byg();
            this.fmZ.setText(((Object) TextUtils.ellipsize(bru, this.fmZ.getPaint(), (i - (paddingLeft * 2)) - this.fmZ.getPaint().measureText(getResources().getString(R.string.forum)), TextUtils.TruncateAt.END)) + getResources().getString(R.string.forum));
            this.fmZ.setVisibility(0);
            onChangeSkinType();
            return;
        }
        setVisibility(8);
    }

    private void byg() {
        this.fmZ.setCompoundDrawables(this.mIconDrawable, null, null, null);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}

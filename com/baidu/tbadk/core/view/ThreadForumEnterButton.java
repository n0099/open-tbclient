package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumEnterButton extends RelativeLayout implements View.OnClickListener {
    private static final int aeo = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds70) * 2);
    private View.OnClickListener ahn;
    private bv dLK;
    public final int ekn;
    private TextView eko;
    private Context mContext;
    private int mFrom;
    private Drawable mIconDrawable;
    private int mSkinType;
    private View mView;
    private int tbds20;
    private int tbds26;
    private int tbds30;

    public ThreadForumEnterButton(Context context) {
        super(context);
        this.ekn = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        this.tbds20 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        this.tbds30 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
        this.tbds26 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        init(context);
    }

    public ThreadForumEnterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ekn = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        this.tbds20 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        this.tbds30 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
        this.tbds26 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnClickListener(this);
        this.mView = LayoutInflater.from(context).inflate(R.layout.card_home_page_forum_enter_button, (ViewGroup) this, true);
        this.eko = (TextView) this.mView.findViewById(R.id.forum_name_text);
        this.eko.setCompoundDrawablePadding(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.dLK.aWp())) {
            view.setTag(this.dLK);
            if (this.mFrom == 0) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.mContext).createNormalCfg(this.dLK.aWp(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            } else if (this.mFrom == 1) {
            }
            if (this.ahn != null) {
                this.ahn.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ahn = onClickListener;
    }

    public void onChangeSkinType() {
        int skinType;
        if (this.dLK != null && this.mSkinType != (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            this.mSkinType = skinType;
            Drawable background = this.eko.getBackground();
            DrawableCompat.setTint(background, ao.getColor(R.color.cp_btn_d));
            this.eko.setBackgroundDrawable(background);
            int color = ao.getColor(R.color.cp_link_tip_b);
            ao.a(this.eko, color);
            this.mIconDrawable = SvgManager.baR().c(R.drawable.icon_pure_card_ba16_svg, color, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.mIconDrawable != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds42);
                this.mIconDrawable.setBounds(0, 0, dimens, dimens);
            }
            bcA();
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), com.baidu.adp.lib.util.l.getDimens(this.mContext, com.baidu.tbadk.a.b.a.aE(R.dimen.tbds0, R.dimen.tbds21)));
        }
    }

    public void a(bv bvVar, int i) {
        this.dLK = bvVar;
        if (bvVar != null && i > 0) {
            int paddingLeft = this.eko.getPaddingLeft();
            String aWp = bvVar.aWp();
            if (StringUtils.isNull(aWp)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            bcA();
            this.eko.setText(((Object) TextUtils.ellipsize(aWp, this.eko.getPaint(), (i - (paddingLeft * 2)) - this.eko.getPaint().measureText(getResources().getString(R.string.forum)), TextUtils.TruncateAt.END)) + getResources().getString(R.string.forum));
            this.eko.setVisibility(0);
            onChangeSkinType();
            return;
        }
        setVisibility(8);
    }

    private void bcA() {
        this.eko.setGravity(16);
        this.eko.setPadding(this.tbds20, 0, this.tbds30, 0);
        this.eko.setCompoundDrawables(this.mIconDrawable, null, null, null);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}

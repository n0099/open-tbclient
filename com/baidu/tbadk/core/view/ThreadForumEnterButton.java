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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumEnterButton extends RelativeLayout implements View.OnClickListener {
    private static final int afR = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds70) * 2);
    private View.OnClickListener aiW;
    private bw dXg;
    public final int ewq;
    private TextView ewr;
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
        this.ewq = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        this.tbds20 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        this.tbds30 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
        this.tbds26 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        init(context);
    }

    public ThreadForumEnterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ewq = 0;
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
        this.ewr = (TextView) this.mView.findViewById(R.id.forum_name_text);
        this.ewr.setCompoundDrawablePadding(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.dXg.bfC())) {
            view.setTag(this.dXg);
            if (this.mFrom == 0) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.mContext).createNormalCfg(this.dXg.bfC(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            } else if (this.mFrom == 1) {
            }
            if (this.aiW != null) {
                this.aiW.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiW = onClickListener;
    }

    public void onChangeSkinType() {
        int skinType;
        if (this.dXg != null && this.mSkinType != (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            this.mSkinType = skinType;
            Drawable background = this.ewr.getBackground();
            DrawableCompat.setTint(background, ap.getColor(R.color.cp_btn_d));
            this.ewr.setBackgroundDrawable(background);
            int color = ap.getColor(R.color.cp_link_tip_b);
            ap.a(this.ewr, color);
            this.mIconDrawable = SvgManager.bkl().c(R.drawable.icon_pure_card_ba16_svg, color, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.mIconDrawable != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds42);
                this.mIconDrawable.setBounds(0, 0, dimens, dimens);
            }
            blS();
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), com.baidu.adp.lib.util.l.getDimens(this.mContext, com.baidu.tbadk.a.b.a.aL(R.dimen.tbds0, R.dimen.tbds21)));
        }
    }

    public void a(bw bwVar, int i) {
        this.dXg = bwVar;
        if (bwVar != null && i > 0) {
            int paddingLeft = this.ewr.getPaddingLeft();
            String bfC = bwVar.bfC();
            if (StringUtils.isNull(bfC)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            blS();
            this.ewr.setText(((Object) TextUtils.ellipsize(bfC, this.ewr.getPaint(), (i - (paddingLeft * 2)) - this.ewr.getPaint().measureText(getResources().getString(R.string.forum)), TextUtils.TruncateAt.END)) + getResources().getString(R.string.forum));
            this.ewr.setVisibility(0);
            onChangeSkinType();
            return;
        }
        setVisibility(8);
    }

    private void blS() {
        this.ewr.setGravity(16);
        this.ewr.setPadding(this.tbds20, 0, this.tbds30, 0);
        this.ewr.setCompoundDrawables(this.mIconDrawable, null, null, null);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}

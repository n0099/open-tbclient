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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumEnterButton extends RelativeLayout implements View.OnClickListener {
    private static final int adT = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds70) * 2);
    private View.OnClickListener ags;
    private bk dEA;
    public final int dWH;
    private TextView dWI;
    private Context mContext;
    private int mFrom;
    private Drawable mIconDrawable;
    private int mSkinType;
    private int mTextColor;
    private View mView;
    private int tbds20;
    private int tbds26;
    private int tbds30;

    public ThreadForumEnterButton(Context context) {
        super(context);
        this.dWH = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        this.tbds20 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        this.tbds30 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
        this.tbds26 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        init(context);
    }

    public ThreadForumEnterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dWH = 0;
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
        this.dWI = (TextView) this.mView.findViewById(R.id.forum_name_text);
        this.dWI.setCompoundDrawablePadding(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.dEA.aQC())) {
            view.setTag(this.dEA);
            if (this.mFrom == 0) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.mContext).createNormalCfg(this.dEA.aQC(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            } else if (this.mFrom == 1) {
            }
            if (this.ags != null) {
                this.ags.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ags = onClickListener;
    }

    public void onChangeSkinType() {
        int skinType;
        if (this.dEA != null && this.mSkinType != (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            this.mSkinType = skinType;
            int bgt = com.baidu.tbadk.util.f.bgt();
            am.setBackgroundColor(this.dWI, bgt);
            if (this.mSkinType == 0) {
                this.mTextColor = am.getColor(R.color.cp_cont_b);
            } else {
                this.mTextColor = com.baidu.tbadk.util.f.nJ(bgt);
            }
            am.a(this.dWI, this.mTextColor);
            this.mIconDrawable = SvgManager.aUW().b(R.drawable.icon_pure_card_ba16_svg, this.mTextColor, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.mIconDrawable != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds42);
                this.mIconDrawable.setBounds(0, 0, dimens, dimens);
            }
            aWK();
        }
    }

    public void r(bk bkVar) {
        this.dEA = bkVar;
        if (bkVar != null) {
            String aQC = bkVar.aQC();
            if (StringUtils.isNull(aQC)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            aWK();
            this.dWI.setText(((Object) TextUtils.ellipsize(aQC, this.dWI.getPaint(), adT - this.dWI.getPaint().measureText(getResources().getString(R.string.forum)), TextUtils.TruncateAt.END)) + getResources().getString(R.string.forum));
            this.dWI.setVisibility(0);
            onChangeSkinType();
            return;
        }
        setVisibility(8);
    }

    public void a(bk bkVar, int i) {
        this.dEA = bkVar;
        if (bkVar != null && i > 0) {
            int paddingLeft = this.dWI.getPaddingLeft();
            String aQC = bkVar.aQC();
            if (StringUtils.isNull(aQC)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            aWK();
            this.dWI.setText(((Object) TextUtils.ellipsize(aQC, this.dWI.getPaint(), (i - (paddingLeft * 2)) - this.dWI.getPaint().measureText(getResources().getString(R.string.forum)), TextUtils.TruncateAt.END)) + getResources().getString(R.string.forum));
            this.dWI.setVisibility(0);
            onChangeSkinType();
            return;
        }
        setVisibility(8);
    }

    private void aWK() {
        if (this.dEA != null && this.dEA.aOo()) {
            this.dWI.setGravity(16);
            this.dWI.setPadding(this.tbds20, 0, this.tbds30, 0);
            this.dWI.setCompoundDrawables(this.mIconDrawable, null, null, null);
            return;
        }
        this.dWI.setGravity(17);
        this.dWI.setPadding(this.tbds26, 0, this.tbds26, 0);
        this.dWI.setCompoundDrawables(null, null, null, null);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}

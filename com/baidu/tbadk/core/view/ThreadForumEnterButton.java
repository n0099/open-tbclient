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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadForumEnterButton extends RelativeLayout implements View.OnClickListener {
    private static final int aey = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds70) * 2);
    private View.OnClickListener ahw;
    private bu dLi;
    public final int eed;
    private TextView eee;
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
        this.eed = 0;
        this.mFrom = 0;
        this.mSkinType = 3;
        this.tbds20 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        this.tbds30 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
        this.tbds26 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        init(context);
    }

    public ThreadForumEnterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eed = 0;
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
        this.eee = (TextView) this.mView.findViewById(R.id.forum_name_text);
        this.eee.setCompoundDrawablePadding(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.dLi.aSt())) {
            view.setTag(this.dLi);
            if (this.mFrom == 0) {
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.mContext).createNormalCfg(this.dLi.aSt(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
                createNormalCfg.setCallFrom(14);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            } else if (this.mFrom == 1) {
            }
            if (this.ahw != null) {
                this.ahw.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ahw = onClickListener;
    }

    public void onChangeSkinType() {
        int skinType;
        if (this.dLi != null && this.mSkinType != (skinType = TbadkCoreApplication.getInst().getSkinType())) {
            this.mSkinType = skinType;
            int biG = com.baidu.tbadk.util.f.biG();
            an.setBackgroundColor(this.eee, biG);
            if (this.mSkinType == 0) {
                this.mTextColor = an.getColor(R.color.cp_cont_b);
            } else {
                this.mTextColor = com.baidu.tbadk.util.f.of(biG);
            }
            an.a(this.eee, this.mTextColor);
            this.mIconDrawable = SvgManager.aWQ().b(R.drawable.icon_pure_card_ba16_svg, this.mTextColor, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.mIconDrawable != null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds42);
                this.mIconDrawable.setBounds(0, 0, dimens, dimens);
            }
            aYD();
        }
    }

    public void q(bu buVar) {
        this.dLi = buVar;
        if (buVar != null) {
            String aSt = buVar.aSt();
            if (StringUtils.isNull(aSt)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            aYD();
            this.eee.setText(((Object) TextUtils.ellipsize(aSt, this.eee.getPaint(), aey - this.eee.getPaint().measureText(getResources().getString(R.string.forum)), TextUtils.TruncateAt.END)) + getResources().getString(R.string.forum));
            this.eee.setVisibility(0);
            onChangeSkinType();
            return;
        }
        setVisibility(8);
    }

    public void a(bu buVar, int i) {
        this.dLi = buVar;
        if (buVar != null && i > 0) {
            int paddingLeft = this.eee.getPaddingLeft();
            String aSt = buVar.aSt();
            if (StringUtils.isNull(aSt)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            aYD();
            this.eee.setText(((Object) TextUtils.ellipsize(aSt, this.eee.getPaint(), (i - (paddingLeft * 2)) - this.eee.getPaint().measureText(getResources().getString(R.string.forum)), TextUtils.TruncateAt.END)) + getResources().getString(R.string.forum));
            this.eee.setVisibility(0);
            onChangeSkinType();
            return;
        }
        setVisibility(8);
    }

    private void aYD() {
        if (this.dLi != null && this.dLi.aPY()) {
            this.eee.setGravity(16);
            this.eee.setPadding(this.tbds20, 0, this.tbds30, 0);
            this.eee.setCompoundDrawables(this.mIconDrawable, null, null, null);
            return;
        }
        this.eee.setGravity(17);
        this.eee.setPadding(this.tbds26, 0, this.tbds26, 0);
        this.eee.setCompoundDrawables(null, null, null, null);
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }
}

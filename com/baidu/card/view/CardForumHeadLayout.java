package com.baidu.card.view;

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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.SingleLineEllipsizeTextView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {
    private BarImageView afN;
    private SingleLineEllipsizeTextView afO;
    private TextView afP;
    private TextView afQ;
    private String afR;
    private View.OnClickListener afS;
    private int afT;

    public CardForumHeadLayout(Context context) {
        super(context);
        this.afT = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afT = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afT = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
        this.afN = (BarImageView) findViewById(R.id.forum_head_image);
        this.afO = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
        this.afP = (TextView) findViewById(R.id.forum_head_info_attention);
        this.afQ = (TextView) findViewById(R.id.forum_head_info_thread);
        this.afN.setShowOval(true);
        this.afN.setAutoChangeStyle(true);
        this.afN.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.afN.setStrokeColorResId(R.color.cp_border_a);
        this.afN.setOnClickListener(this);
        this.afO.setOnClickListener(this);
        this.afP.setOnClickListener(this);
        this.afQ.setOnClickListener(this);
        this.afO.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
        onChangeSkinType();
    }

    public void setData(bj bjVar) {
        if (bjVar == null || bjVar.aMp() == null || StringUtils.isNull(bjVar.aMp().forumName)) {
            this.afN.setVisibility(8);
            this.afO.setVisibility(8);
            this.afQ.setVisibility(8);
            this.afP.setVisibility(8);
            return;
        }
        this.afN.setPlaceHolder(1);
        this.afN.setVisibility(0);
        this.afO.setVisibility(0);
        this.afQ.setVisibility(0);
        this.afP.setVisibility(0);
        this.afR = bjVar.aMp().forumName;
        this.afO.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.afR));
        this.afN.startLoad(bjVar.aMp().getAvatar(), 10, false);
        this.afQ.setText(String.format(getContext().getString(R.string.forum_thread_number), aq.numberUniformFormatExtra(bjVar.aMp().postNum)));
        this.afP.setText(String.format(getContext().getString(R.string.concern), aq.numberUniformFormatExtra(bjVar.aMp().memberNum)));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.afR)) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.afR, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            if (this.afS != null) {
                this.afS.onClick(view);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.afT) {
            this.afT = skinType;
            Drawable a = SvgManager.aOU().a(R.drawable.icon_pure_card_ba16_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            a.setBounds(0, 0, dimens, dimens);
            this.afO.setCompoundDrawables(null, null, a, null);
            this.afO.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds10));
            am.setViewTextColor(this.afO, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.afP, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.afQ, (int) R.color.cp_cont_d);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.afS = onClickListener;
    }
}

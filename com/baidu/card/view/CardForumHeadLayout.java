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
    private BarImageView afQ;
    private SingleLineEllipsizeTextView afR;
    private TextView afS;
    private TextView afT;
    private String afU;
    private View.OnClickListener afV;
    private int afW;

    public CardForumHeadLayout(Context context) {
        super(context);
        this.afW = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.afW = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.afW = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
        this.afQ = (BarImageView) findViewById(R.id.forum_head_image);
        this.afR = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
        this.afS = (TextView) findViewById(R.id.forum_head_info_attention);
        this.afT = (TextView) findViewById(R.id.forum_head_info_thread);
        this.afQ.setShowOval(true);
        this.afQ.setAutoChangeStyle(true);
        this.afQ.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.afQ.setStrokeColorResId(R.color.cp_border_a);
        this.afQ.setOnClickListener(this);
        this.afR.setOnClickListener(this);
        this.afS.setOnClickListener(this);
        this.afT.setOnClickListener(this);
        this.afR.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
        onChangeSkinType();
    }

    public void setData(bj bjVar) {
        if (bjVar == null || bjVar.aMn() == null || StringUtils.isNull(bjVar.aMn().forumName)) {
            this.afQ.setVisibility(8);
            this.afR.setVisibility(8);
            this.afT.setVisibility(8);
            this.afS.setVisibility(8);
            return;
        }
        this.afQ.setPlaceHolder(1);
        this.afQ.setVisibility(0);
        this.afR.setVisibility(0);
        this.afT.setVisibility(0);
        this.afS.setVisibility(0);
        this.afU = bjVar.aMn().forumName;
        this.afR.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.afU));
        this.afQ.startLoad(bjVar.aMn().getAvatar(), 10, false);
        this.afT.setText(String.format(getContext().getString(R.string.forum_thread_number), aq.numberUniformFormatExtra(bjVar.aMn().postNum)));
        this.afS.setText(String.format(getContext().getString(R.string.concern), aq.numberUniformFormatExtra(bjVar.aMn().memberNum)));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.afU)) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.afU, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            if (this.afV != null) {
                this.afV.onClick(view);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.afW) {
            this.afW = skinType;
            Drawable a = SvgManager.aOR().a(R.drawable.icon_pure_card_ba16_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            a.setBounds(0, 0, dimens, dimens);
            this.afR.setCompoundDrawables(null, null, a, null);
            this.afR.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds10));
            am.setViewTextColor(this.afR, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.afS, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.afT, (int) R.color.cp_cont_d);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.afV = onClickListener;
    }
}

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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.SingleLineEllipsizeTextView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {
    private BarImageView agn;
    private SingleLineEllipsizeTextView ago;
    private TextView agp;
    private TextView agq;
    private String agr;
    private View.OnClickListener ags;
    private int agt;

    public CardForumHeadLayout(Context context) {
        super(context);
        this.agt = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agt = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.agt = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
        this.agn = (BarImageView) findViewById(R.id.forum_head_image);
        this.ago = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
        this.agp = (TextView) findViewById(R.id.forum_head_info_attention);
        this.agq = (TextView) findViewById(R.id.forum_head_info_thread);
        this.agn.setShowOval(true);
        this.agn.setAutoChangeStyle(true);
        this.agn.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.agn.setStrokeColorResId(R.color.cp_border_a);
        this.agn.setOnClickListener(this);
        this.ago.setOnClickListener(this);
        this.agp.setOnClickListener(this);
        this.agq.setOnClickListener(this);
        this.ago.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
        onChangeSkinType();
    }

    private void rT() {
        this.agn.setVisibility(8);
        this.ago.setVisibility(8);
        this.agq.setVisibility(8);
        this.agp.setVisibility(8);
    }

    public void setData(String str, String str2, int i, int i2) {
        if (StringUtils.isNull(str)) {
            rT();
            return;
        }
        this.agn.setPlaceHolder(1);
        this.agn.setVisibility(0);
        this.ago.setVisibility(0);
        this.agq.setVisibility(0);
        this.agp.setVisibility(0);
        this.agr = str;
        this.ago.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.agr));
        this.agn.startLoad(str2, 10, false);
        this.agq.setText(String.format(getContext().getString(R.string.forum_thread_number), aq.numberUniformFormatExtra(i)));
        this.agp.setText(String.format(getContext().getString(R.string.concern), aq.numberUniformFormatExtra(i2)));
    }

    public void setData(bk bkVar) {
        if (bkVar == null || bkVar.aSm() == null) {
            rT();
        } else {
            setData(bkVar.aSm().forumName, bkVar.aSm().getAvatar(), bkVar.aSm().postNum, bkVar.aSm().memberNum);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.agr)) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.agr, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            if (this.ags != null) {
                this.ags.onClick(view);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.agt) {
            this.agt = skinType;
            Drawable a = SvgManager.aUW().a(R.drawable.icon_pure_card_ba16_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            a.setBounds(0, 0, dimens, dimens);
            this.ago.setCompoundDrawables(null, null, a, null);
            this.ago.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds10));
            am.setViewTextColor(this.ago, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.agp, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.agq, (int) R.color.cp_cont_d);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ags = onClickListener;
    }
}

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
    private BarImageView Nb;
    private SingleLineEllipsizeTextView Nc;
    private TextView Ne;
    private TextView Nf;
    private String Ng;
    private View.OnClickListener Nh;
    private int Ni;

    public CardForumHeadLayout(Context context) {
        super(context);
        this.Ni = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ni = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ni = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
        this.Nb = (BarImageView) findViewById(R.id.forum_head_image);
        this.Nc = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
        this.Ne = (TextView) findViewById(R.id.forum_head_info_attention);
        this.Nf = (TextView) findViewById(R.id.forum_head_info_thread);
        this.Nb.setShowOval(true);
        this.Nb.setAutoChangeStyle(true);
        this.Nb.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.Nb.setStrokeColorResId(R.color.cp_border_a);
        this.Nb.setOnClickListener(this);
        this.Nc.setOnClickListener(this);
        this.Ne.setOnClickListener(this);
        this.Nf.setOnClickListener(this);
        this.Nc.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
        onChangeSkinType();
    }

    public void setData(bj bjVar) {
        if (bjVar == null || bjVar.aDX() == null || StringUtils.isNull(bjVar.aDX().forumName)) {
            this.Nb.setVisibility(8);
            this.Nc.setVisibility(8);
            this.Nf.setVisibility(8);
            this.Ne.setVisibility(8);
            return;
        }
        this.Nb.setPlaceHolder(1);
        this.Nb.setVisibility(0);
        this.Nc.setVisibility(0);
        this.Nf.setVisibility(0);
        this.Ne.setVisibility(0);
        this.Ng = bjVar.aDX().forumName;
        this.Nc.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.Ng));
        this.Nb.startLoad(bjVar.aDX().getAvatar(), 10, false);
        this.Nf.setText(String.format(getContext().getString(R.string.forum_thread_number), aq.numberUniformFormatExtra(bjVar.aDX().postNum)));
        this.Ne.setText(String.format(getContext().getString(R.string.concern), aq.numberUniformFormatExtra(bjVar.aDX().memberNum)));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.Ng)) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.Ng, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            if (this.Nh != null) {
                this.Nh.onClick(view);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.Ni) {
            this.Ni = skinType;
            Drawable a = SvgManager.aGC().a(R.drawable.icon_pure_card_ba16_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            a.setBounds(0, 0, dimens, dimens);
            this.Nc.setCompoundDrawables(null, null, a, null);
            this.Nc.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds10));
            am.setViewTextColor(this.Nc, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.Ne, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.Nf, (int) R.color.cp_cont_d);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Nh = onClickListener;
    }
}

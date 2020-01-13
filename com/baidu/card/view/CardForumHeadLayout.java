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
/* loaded from: classes6.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {
    private SingleLineEllipsizeTextView MA;
    private TextView MC;
    private TextView ME;
    private String MF;
    private View.OnClickListener MG;
    private int MH;
    private BarImageView Mz;

    public CardForumHeadLayout(Context context) {
        super(context);
        this.MH = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MH = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MH = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
        this.Mz = (BarImageView) findViewById(R.id.forum_head_image);
        this.MA = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
        this.MC = (TextView) findViewById(R.id.forum_head_info_attention);
        this.ME = (TextView) findViewById(R.id.forum_head_info_thread);
        this.Mz.setShowOval(true);
        this.Mz.setAutoChangeStyle(true);
        this.Mz.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.Mz.setStrokeColorResId(R.color.cp_border_a);
        this.Mz.setOnClickListener(this);
        this.MA.setOnClickListener(this);
        this.MC.setOnClickListener(this);
        this.ME.setOnClickListener(this);
        this.MA.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
        onChangeSkinType();
    }

    public void setData(bj bjVar) {
        if (bjVar == null || bjVar.aBJ() == null || StringUtils.isNull(bjVar.aBJ().forumName)) {
            this.Mz.setVisibility(8);
            this.MA.setVisibility(8);
            this.ME.setVisibility(8);
            this.MC.setVisibility(8);
            return;
        }
        this.Mz.setPlaceHolder(1);
        this.Mz.setVisibility(0);
        this.MA.setVisibility(0);
        this.ME.setVisibility(0);
        this.MC.setVisibility(0);
        this.MF = bjVar.aBJ().forumName;
        this.MA.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.MF));
        this.Mz.startLoad(bjVar.aBJ().getAvatar(), 10, false);
        this.ME.setText(String.format(getContext().getString(R.string.forum_thread_number), aq.numberUniformFormatExtra(bjVar.aBJ().postNum)));
        this.MC.setText(String.format(getContext().getString(R.string.concern), aq.numberUniformFormatExtra(bjVar.aBJ().memberNum)));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.MF)) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.MF, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            if (this.MG != null) {
                this.MG.onClick(view);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.MH) {
            this.MH = skinType;
            Drawable a = SvgManager.aEp().a(R.drawable.icon_pure_card_ba16_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            a.setBounds(0, 0, dimens, dimens);
            this.MA.setCompoundDrawables(null, null, a, null);
            this.MA.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds10));
            am.setViewTextColor(this.MA, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.MC, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.ME, (int) R.color.cp_cont_d);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.MG = onClickListener;
    }
}

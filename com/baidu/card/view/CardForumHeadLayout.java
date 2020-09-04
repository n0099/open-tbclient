package com.baidu.card.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
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
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.SingleLineEllipsizeTextView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {
    private TextView aiA;
    private String aiB;
    private View.OnClickListener aiC;
    private int aiD;
    private bw aiE;
    private BarImageView aiu;
    private SingleLineEllipsizeTextView aiv;
    private TextView aiw;
    private TextView aix;
    private TextView aiy;
    private TextView aiz;

    public CardForumHeadLayout(Context context) {
        super(context);
        this.aiD = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiD = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiD = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
        this.aiu = (BarImageView) findViewById(R.id.forum_head_image);
        this.aiv = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
        this.aiw = (TextView) findViewById(R.id.forum_head_info_attention);
        this.aix = (TextView) findViewById(R.id.forum_head_info_thread);
        this.aiy = (TextView) findViewById(R.id.hot_rank_index);
        this.aiz = (TextView) findViewById(R.id.hot_rank_num);
        this.aiA = (TextView) findViewById(R.id.thread_extend_info);
        this.aiu.setShowOval(true);
        this.aiu.setAutoChangeStyle(true);
        this.aiu.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.aiu.setStrokeColorResId(R.color.cp_border_a);
        this.aiu.setOnClickListener(this);
        this.aiv.setOnClickListener(this);
        this.aiw.setOnClickListener(this);
        this.aix.setOnClickListener(this);
        this.aiv.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
        onChangeSkinType();
    }

    private void ub() {
        this.aiu.setVisibility(8);
        this.aiv.setVisibility(8);
        this.aix.setVisibility(8);
        this.aiw.setVisibility(8);
    }

    public void setData(String str, String str2, int i, int i2) {
        if (StringUtils.isNull(str)) {
            ub();
            return;
        }
        this.aiu.setPlaceHolder(1);
        this.aiu.setVisibility(0);
        this.aiv.setVisibility(0);
        this.aix.setVisibility(0);
        this.aiw.setVisibility(0);
        this.aiB = str;
        this.aiv.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.aiB));
        this.aiu.startLoad(str2, 10, false);
        this.aix.setText(String.format(getContext().getString(R.string.forum_thread_number), at.numberUniformFormatExtra(i)));
        this.aiw.setText(String.format(getContext().getString(R.string.concern), at.numberUniformFormatExtra(i2)));
        com.baidu.tbadk.a.b.a.a(this.aiv);
    }

    public void setData(bw bwVar) {
        this.aiE = bwVar;
        if (bwVar == null || bwVar.bgs() == null) {
            ub();
        } else if (bwVar.eeo) {
            this.aix.setVisibility(8);
            this.aiw.setVisibility(8);
            this.aiy.setVisibility(0);
            this.aiz.setVisibility(0);
            this.aiA.setVisibility(0);
            this.aiA.setText(bwVar.bec());
            int i = bwVar.eeD >= 1000 ? bwVar.eeD : 1000;
            this.aiz.setVisibility(0);
            this.aiz.setText(this.aiz.getContext().getResources().getString(R.string.thread_rank_tag, at.cR(i)));
            int i2 = bwVar.position + 1;
            this.aiy.setText(i2 >= 10 ? String.valueOf(i2) : "0" + i2);
            uc();
            bs bgs = bwVar.bgs();
            this.aiu.setPlaceHolder(1);
            this.aiu.setVisibility(0);
            this.aiu.startLoad(bgs.getAvatar(), 10, false);
            this.aiv.setVisibility(0);
            this.aiB = bgs.forumName;
            this.aiv.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.aiB));
            com.baidu.tbadk.a.b.a.a(this.aiv);
        } else {
            this.aiA.setVisibility(8);
            this.aiy.setVisibility(8);
            this.aiz.setVisibility(8);
            setData(bwVar.bgs().forumName, bwVar.bgs().getAvatar(), bwVar.bgs().postNum, bwVar.bgs().memberNum);
            if (bwVar.bcn()) {
                if (bwVar.beE() != null && !StringUtils.isNull(bwVar.beE().getName_show())) {
                    this.aiw.setText(bwVar.beE().getName_show());
                } else {
                    this.aiw.setText(R.string.user_name_default_txt);
                }
                this.aix.setText(bwVar.bec());
            }
        }
    }

    private void uc() {
        if (this.aiE != null) {
            int oa = TagTextHelper.oa(this.aiE.position + 1);
            this.aiy.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds10));
            int color = ap.getColor(oa);
            Drawable mutate = ap.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            mutate.setBounds(0, 0, dimens, dimens);
            DrawableCompat.setTint(mutate, color);
            this.aiy.setCompoundDrawables(mutate, null, null, null);
            this.aiy.setBackgroundDrawable(null);
            ap.setViewTextColor(this.aiy, oa);
            ap.setViewTextColor(this.aiz, oa);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.aiB)) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.aiB, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            if (this.aiC != null) {
                this.aiC.onClick(view);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aiD) {
            this.aiD = skinType;
            Drawable a = SvgManager.bjq().a(R.drawable.icon_pure_card_ba16_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            a.setBounds(0, 0, dimens, dimens);
            this.aiv.setCompoundDrawables(null, null, a, null);
            this.aiv.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds10));
            ap.setViewTextColor(this.aiv, R.color.cp_cont_b);
            ap.setViewTextColor(this.aiw, R.color.cp_cont_d);
            ap.setViewTextColor(this.aix, R.color.cp_cont_d);
            ap.setViewTextColor(this.aiA, R.color.cp_cont_d);
            ud();
            uc();
        }
    }

    private void ud() {
        com.baidu.tbadk.a.b.a.b(this.aiv);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiC = onClickListener;
    }
}

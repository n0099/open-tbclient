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
    private View.OnClickListener aiA;
    private int aiB;
    private bw aiC;
    private BarImageView ais;
    private SingleLineEllipsizeTextView ait;
    private TextView aiu;
    private TextView aiv;
    private TextView aiw;
    private TextView aix;
    private TextView aiy;
    private String aiz;

    public CardForumHeadLayout(Context context) {
        super(context);
        this.aiB = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiB = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiB = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
        this.ais = (BarImageView) findViewById(R.id.forum_head_image);
        this.ait = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
        this.aiu = (TextView) findViewById(R.id.forum_head_info_attention);
        this.aiv = (TextView) findViewById(R.id.forum_head_info_thread);
        this.aiw = (TextView) findViewById(R.id.hot_rank_index);
        this.aix = (TextView) findViewById(R.id.hot_rank_num);
        this.aiy = (TextView) findViewById(R.id.thread_extend_info);
        this.ais.setShowOval(true);
        this.ais.setAutoChangeStyle(true);
        this.ais.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.ais.setStrokeColorResId(R.color.cp_border_a);
        this.ais.setOnClickListener(this);
        this.ait.setOnClickListener(this);
        this.aiu.setOnClickListener(this);
        this.aiv.setOnClickListener(this);
        this.ait.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
        onChangeSkinType();
    }

    private void ub() {
        this.ais.setVisibility(8);
        this.ait.setVisibility(8);
        this.aiv.setVisibility(8);
        this.aiu.setVisibility(8);
    }

    public void setData(String str, String str2, int i, int i2) {
        if (StringUtils.isNull(str)) {
            ub();
            return;
        }
        this.ais.setPlaceHolder(1);
        this.ais.setVisibility(0);
        this.ait.setVisibility(0);
        this.aiv.setVisibility(0);
        this.aiu.setVisibility(0);
        this.aiz = str;
        this.ait.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.aiz));
        this.ais.startLoad(str2, 10, false);
        this.aiv.setText(String.format(getContext().getString(R.string.forum_thread_number), at.numberUniformFormatExtra(i)));
        this.aiu.setText(String.format(getContext().getString(R.string.concern), at.numberUniformFormatExtra(i2)));
        com.baidu.tbadk.a.b.a.a(this.ait);
    }

    public void setData(bw bwVar) {
        this.aiC = bwVar;
        if (bwVar == null || bwVar.bgs() == null) {
            ub();
        } else if (bwVar.eek) {
            this.aiv.setVisibility(8);
            this.aiu.setVisibility(8);
            this.aiw.setVisibility(0);
            this.aix.setVisibility(0);
            this.aiy.setVisibility(0);
            this.aiy.setText(bwVar.bec());
            int i = bwVar.eez >= 1000 ? bwVar.eez : 1000;
            this.aix.setVisibility(0);
            this.aix.setText(this.aix.getContext().getResources().getString(R.string.thread_rank_tag, at.cR(i)));
            int i2 = bwVar.position + 1;
            this.aiw.setText(i2 >= 10 ? String.valueOf(i2) : "0" + i2);
            uc();
            bs bgs = bwVar.bgs();
            this.ais.setPlaceHolder(1);
            this.ais.setVisibility(0);
            this.ais.startLoad(bgs.getAvatar(), 10, false);
            this.ait.setVisibility(0);
            this.aiz = bgs.forumName;
            this.ait.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.aiz));
            com.baidu.tbadk.a.b.a.a(this.ait);
        } else {
            this.aiy.setVisibility(8);
            this.aiw.setVisibility(8);
            this.aix.setVisibility(8);
            setData(bwVar.bgs().forumName, bwVar.bgs().getAvatar(), bwVar.bgs().postNum, bwVar.bgs().memberNum);
            if (bwVar.bcn()) {
                if (bwVar.beE() != null && !StringUtils.isNull(bwVar.beE().getName_show())) {
                    this.aiu.setText(bwVar.beE().getName_show());
                } else {
                    this.aiu.setText(R.string.user_name_default_txt);
                }
                this.aiv.setText(bwVar.bec());
            }
        }
    }

    private void uc() {
        if (this.aiC != null) {
            int oa = TagTextHelper.oa(this.aiC.position + 1);
            this.aiw.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds10));
            int color = ap.getColor(oa);
            Drawable mutate = ap.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            mutate.setBounds(0, 0, dimens, dimens);
            DrawableCompat.setTint(mutate, color);
            this.aiw.setCompoundDrawables(mutate, null, null, null);
            this.aiw.setBackgroundDrawable(null);
            ap.setViewTextColor(this.aiw, oa);
            ap.setViewTextColor(this.aix, oa);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.aiz)) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.aiz, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            if (this.aiA != null) {
                this.aiA.onClick(view);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aiB) {
            this.aiB = skinType;
            Drawable a = SvgManager.bjq().a(R.drawable.icon_pure_card_ba16_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            a.setBounds(0, 0, dimens, dimens);
            this.ait.setCompoundDrawables(null, null, a, null);
            this.ait.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds10));
            ap.setViewTextColor(this.ait, R.color.cp_cont_b);
            ap.setViewTextColor(this.aiu, R.color.cp_cont_d);
            ap.setViewTextColor(this.aiv, R.color.cp_cont_d);
            ap.setViewTextColor(this.aiy, R.color.cp_cont_d);
            ud();
            uc();
        }
    }

    private void ud() {
        com.baidu.tbadk.a.b.a.b(this.ait);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiA = onClickListener;
    }
}

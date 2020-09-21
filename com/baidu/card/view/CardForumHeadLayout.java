package com.baidu.card.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
/* loaded from: classes20.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {
    private BarImageView aiO;
    private SingleLineEllipsizeTextView aiP;
    private TextView aiQ;
    private TextView aiR;
    private TextView aiS;
    private TextView aiT;
    private TextView aiU;
    private String aiV;
    private View.OnClickListener aiW;
    private int aiX;
    private bw aiY;

    public CardForumHeadLayout(Context context) {
        super(context);
        this.aiX = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiX = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiX = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
        this.aiO = (BarImageView) findViewById(R.id.forum_head_image);
        this.aiP = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
        this.aiQ = (TextView) findViewById(R.id.forum_head_info_attention);
        this.aiR = (TextView) findViewById(R.id.forum_head_info_thread);
        this.aiS = (TextView) findViewById(R.id.hot_rank_index);
        this.aiT = (TextView) findViewById(R.id.hot_rank_num);
        this.aiU = (TextView) findViewById(R.id.thread_extend_info);
        this.aiO.setShowOval(true);
        this.aiO.setAutoChangeStyle(true);
        this.aiO.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.aiO.setStrokeColorResId(R.color.cp_border_a);
        this.aiO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aiO.setOnClickListener(this);
        this.aiP.setOnClickListener(this);
        this.aiQ.setOnClickListener(this);
        this.aiR.setOnClickListener(this);
        this.aiP.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
        onChangeSkinType();
    }

    private void uh() {
        this.aiO.setVisibility(8);
        this.aiP.setVisibility(8);
        this.aiR.setVisibility(8);
        this.aiQ.setVisibility(8);
    }

    public void setData(String str, String str2, int i, int i2) {
        if (StringUtils.isNull(str)) {
            uh();
            return;
        }
        this.aiO.setPlaceHolder(1);
        this.aiO.setVisibility(0);
        this.aiP.setVisibility(0);
        this.aiV = str;
        this.aiP.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.aiV));
        this.aiO.startLoad(str2, 10, false);
        this.aiR.setText(String.format(getContext().getString(R.string.forum_thread_number), at.numberUniformFormatExtra(i)));
        this.aiQ.setText(String.format(getContext().getString(R.string.concern), at.numberUniformFormatExtra(i2)));
        com.baidu.tbadk.a.b.a.a(this.aiP);
    }

    public void setData(bw bwVar) {
        this.aiY = bwVar;
        if (bwVar == null || bwVar.bhm() == null) {
            uh();
        } else if (bwVar.egy) {
            this.aiR.setVisibility(8);
            this.aiQ.setVisibility(8);
            this.aiS.setVisibility(0);
            this.aiT.setVisibility(0);
            this.aiU.setVisibility(0);
            this.aiU.setText(bwVar.beW());
            int i = bwVar.egM >= 1000 ? bwVar.egM : 1000;
            this.aiT.setVisibility(0);
            this.aiT.setText(this.aiT.getContext().getResources().getString(R.string.thread_rank_tag, at.cS(i)));
            int i2 = bwVar.position + 1;
            this.aiS.setText(i2 >= 10 ? String.valueOf(i2) : "0" + i2);
            ui();
            bs bhm = bwVar.bhm();
            this.aiO.setPlaceHolder(1);
            this.aiO.setVisibility(0);
            this.aiO.startLoad(bhm.getAvatar(), 10, false);
            this.aiP.setVisibility(0);
            this.aiV = bhm.forumName;
            this.aiP.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.aiV));
            com.baidu.tbadk.a.b.a.a(this.aiP);
        } else {
            if (bwVar.bhq()) {
                this.aiR.setVisibility(8);
                this.aiQ.setVisibility(8);
                this.aiS.setVisibility(8);
                this.aiT.setVisibility(8);
                this.aiU.setVisibility(0);
                this.aiU.setText(bwVar.beW());
            } else {
                this.aiU.setVisibility(8);
                this.aiS.setVisibility(8);
                this.aiT.setVisibility(8);
                this.aiR.setVisibility(0);
                this.aiQ.setVisibility(0);
            }
            setData(bwVar.bhm().forumName, bwVar.bhm().getAvatar(), bwVar.bhm().postNum, bwVar.bhm().memberNum);
            if (bwVar.bdh()) {
                if (bwVar.bfy() != null && !StringUtils.isNull(bwVar.bfy().getName_show())) {
                    this.aiQ.setText(bwVar.bfy().getName_show());
                } else {
                    this.aiQ.setText(R.string.user_name_default_txt);
                }
                this.aiR.setText(bwVar.beW());
            }
        }
    }

    private void ui() {
        if (this.aiY != null) {
            int om = TagTextHelper.om(this.aiY.position + 1);
            this.aiS.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds10));
            int color = ap.getColor(om);
            Drawable mutate = ap.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            mutate.setBounds(0, 0, dimens, dimens);
            DrawableCompat.setTint(mutate, color);
            this.aiS.setCompoundDrawables(mutate, null, null, null);
            this.aiS.setBackgroundDrawable(null);
            ap.setViewTextColor(this.aiS, om);
            ap.setViewTextColor(this.aiT, om);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.aiV)) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.aiV, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            if (this.aiW != null) {
                this.aiW.onClick(view);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aiX) {
            this.aiX = skinType;
            Drawable a = SvgManager.bkl().a(R.drawable.icon_pure_card_ba16_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            a.setBounds(0, 0, dimens, dimens);
            this.aiP.setCompoundDrawables(null, null, a, null);
            this.aiP.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds10));
            ap.setViewTextColor(this.aiP, R.color.cp_cont_b);
            ap.setViewTextColor(this.aiQ, R.color.cp_cont_d);
            ap.setViewTextColor(this.aiR, R.color.cp_cont_d);
            ap.setViewTextColor(this.aiU, R.color.cp_cont_d);
            uj();
            ui();
        }
    }

    private void uj() {
        com.baidu.tbadk.a.b.a.b(this.aiP);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiW = onClickListener;
    }
}

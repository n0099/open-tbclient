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
/* loaded from: classes21.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {
    private BarImageView ajg;
    private SingleLineEllipsizeTextView ajh;
    private TextView aji;
    private TextView ajj;
    private TextView ajk;
    private TextView ajl;
    private TextView ajm;
    private String ajn;
    private View.OnClickListener ajo;
    private int ajp;
    private bw ajq;

    public CardForumHeadLayout(Context context) {
        super(context);
        this.ajp = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajp = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajp = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
        this.ajg = (BarImageView) findViewById(R.id.forum_head_image);
        this.ajh = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
        this.aji = (TextView) findViewById(R.id.forum_head_info_attention);
        this.ajj = (TextView) findViewById(R.id.forum_head_info_thread);
        this.ajk = (TextView) findViewById(R.id.hot_rank_index);
        this.ajl = (TextView) findViewById(R.id.hot_rank_num);
        this.ajm = (TextView) findViewById(R.id.thread_extend_info);
        this.ajg.setShowOval(true);
        this.ajg.setAutoChangeStyle(true);
        this.ajg.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.ajg.setStrokeColorResId(R.color.cp_border_a);
        this.ajg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ajg.setOnClickListener(this);
        this.ajh.setOnClickListener(this);
        this.aji.setOnClickListener(this);
        this.ajj.setOnClickListener(this);
        this.ajh.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
        onChangeSkinType();
    }

    private void uh() {
        this.ajg.setVisibility(8);
        this.ajh.setVisibility(8);
        this.ajj.setVisibility(8);
        this.aji.setVisibility(8);
    }

    public void setData(String str, String str2, int i, int i2) {
        if (StringUtils.isNull(str)) {
            uh();
            return;
        }
        this.ajg.setPlaceHolder(1);
        this.ajg.setVisibility(0);
        this.ajh.setVisibility(0);
        this.ajn = str;
        this.ajh.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.ajn));
        this.ajg.startLoad(str2, 10, false);
        this.ajj.setText(String.format(getContext().getString(R.string.forum_thread_number), at.numberUniformFormatExtra(i)));
        this.aji.setText(String.format(getContext().getString(R.string.concern), at.numberUniformFormatExtra(i2)));
        com.baidu.tbadk.a.b.a.a(this.ajh);
    }

    public void setData(bw bwVar) {
        this.ajq = bwVar;
        if (bwVar == null || bwVar.bjV() == null) {
            uh();
        } else if (bwVar.esE) {
            this.ajj.setVisibility(8);
            this.aji.setVisibility(8);
            this.ajk.setVisibility(0);
            this.ajl.setVisibility(0);
            this.ajm.setVisibility(0);
            this.ajm.setText(bwVar.bhF());
            int i = bwVar.esS >= 1000 ? bwVar.esS : 1000;
            this.ajl.setVisibility(0);
            this.ajl.setText(this.ajl.getContext().getResources().getString(R.string.thread_rank_tag, at.da(i)));
            int i2 = bwVar.position + 1;
            this.ajk.setText(i2 >= 10 ? String.valueOf(i2) : "0" + i2);
            ui();
            bs bjV = bwVar.bjV();
            this.ajg.setPlaceHolder(1);
            this.ajg.setVisibility(0);
            this.ajg.startLoad(bjV.getAvatar(), 10, false);
            this.ajh.setVisibility(0);
            this.ajn = bjV.forumName;
            this.ajh.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.ajn));
            com.baidu.tbadk.a.b.a.a(this.ajh);
        } else {
            if (bwVar.bjZ()) {
                this.ajj.setVisibility(8);
                this.aji.setVisibility(8);
                this.ajk.setVisibility(8);
                this.ajl.setVisibility(8);
                this.ajm.setVisibility(0);
                this.ajm.setText(bwVar.bhF());
            } else {
                this.ajm.setVisibility(8);
                this.ajk.setVisibility(8);
                this.ajl.setVisibility(8);
                this.ajj.setVisibility(0);
                this.aji.setVisibility(0);
            }
            setData(bwVar.bjV().forumName, bwVar.bjV().getAvatar(), bwVar.bjV().postNum, bwVar.bjV().memberNum);
            if (bwVar.bfQ()) {
                if (bwVar.bih() != null && !StringUtils.isNull(bwVar.bih().getName_show())) {
                    this.aji.setText(bwVar.bih().getName_show());
                } else {
                    this.aji.setText(R.string.user_name_default_txt);
                }
                this.ajj.setText(bwVar.bhF());
            }
        }
    }

    private void ui() {
        if (this.ajq != null) {
            int oJ = TagTextHelper.oJ(this.ajq.position + 1);
            this.ajk.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds10));
            int color = ap.getColor(oJ);
            Drawable mutate = ap.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            mutate.setBounds(0, 0, dimens, dimens);
            DrawableCompat.setTint(mutate, color);
            this.ajk.setCompoundDrawables(mutate, null, null, null);
            this.ajk.setBackgroundDrawable(null);
            ap.setViewTextColor(this.ajk, oJ);
            ap.setViewTextColor(this.ajl, oJ);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.ajn)) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.ajn, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            if (this.ajo != null) {
                this.ajo.onClick(view);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.ajp) {
            this.ajp = skinType;
            Drawable a2 = SvgManager.bmU().a(R.drawable.icon_pure_card_ba16_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            a2.setBounds(0, 0, dimens, dimens);
            this.ajh.setCompoundDrawables(null, null, a2, null);
            this.ajh.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds10));
            ap.setViewTextColor(this.ajh, R.color.cp_cont_b);
            ap.setViewTextColor(this.aji, R.color.cp_cont_d);
            ap.setViewTextColor(this.ajj, R.color.cp_cont_d);
            ap.setViewTextColor(this.ajm, R.color.cp_cont_d);
            uj();
            ui();
        }
    }

    private void uj() {
        com.baidu.tbadk.a.b.a.b(this.ajh);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajo = onClickListener;
    }
}

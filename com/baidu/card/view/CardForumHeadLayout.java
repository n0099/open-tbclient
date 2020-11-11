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
    private BarImageView ajh;
    private SingleLineEllipsizeTextView aji;
    private TextView ajj;
    private TextView ajk;
    private TextView ajl;
    private TextView ajm;
    private TextView ajn;
    private String ajo;
    private View.OnClickListener ajp;
    private int ajq;
    private bw ajr;

    public CardForumHeadLayout(Context context) {
        super(context);
        this.ajq = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajq = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajq = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
        this.ajh = (BarImageView) findViewById(R.id.forum_head_image);
        this.aji = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
        this.ajj = (TextView) findViewById(R.id.forum_head_info_attention);
        this.ajk = (TextView) findViewById(R.id.forum_head_info_thread);
        this.ajl = (TextView) findViewById(R.id.hot_rank_index);
        this.ajm = (TextView) findViewById(R.id.hot_rank_num);
        this.ajn = (TextView) findViewById(R.id.thread_extend_info);
        this.ajh.setShowOval(true);
        this.ajh.setAutoChangeStyle(true);
        this.ajh.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.ajh.setStrokeColorResId(R.color.cp_border_a);
        this.ajh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ajh.setOnClickListener(this);
        this.aji.setOnClickListener(this);
        this.ajj.setOnClickListener(this);
        this.ajk.setOnClickListener(this);
        this.aji.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
        onChangeSkinType();
    }

    private void uh() {
        this.ajh.setVisibility(8);
        this.aji.setVisibility(8);
        this.ajk.setVisibility(8);
        this.ajj.setVisibility(8);
    }

    public void setData(String str, String str2, int i, int i2) {
        if (StringUtils.isNull(str)) {
            uh();
            return;
        }
        this.ajh.setPlaceHolder(1);
        this.ajh.setVisibility(0);
        this.aji.setVisibility(0);
        this.ajo = str;
        this.aji.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.ajo));
        this.ajh.startLoad(str2, 10, false);
        this.ajk.setText(String.format(getContext().getString(R.string.forum_thread_number), at.numberUniformFormatExtra(i)));
        this.ajj.setText(String.format(getContext().getString(R.string.concern), at.numberUniformFormatExtra(i2)));
        com.baidu.tbadk.a.b.a.e(this.aji);
    }

    public void setData(bw bwVar) {
        this.ajr = bwVar;
        if (bwVar == null || bwVar.boo() == null) {
            uh();
        } else if (bwVar.eGT) {
            this.ajk.setVisibility(8);
            this.ajj.setVisibility(8);
            this.ajl.setVisibility(0);
            this.ajm.setVisibility(0);
            this.ajn.setVisibility(0);
            this.ajn.setText(bwVar.blY());
            int i = bwVar.eHh >= 1000 ? bwVar.eHh : 1000;
            this.ajm.setVisibility(0);
            this.ajm.setText(this.ajm.getContext().getResources().getString(R.string.thread_rank_tag, at.dy(i)));
            int i2 = bwVar.position + 1;
            this.ajl.setText(i2 >= 10 ? String.valueOf(i2) : "0" + i2);
            ui();
            bs boo = bwVar.boo();
            this.ajh.setPlaceHolder(1);
            this.ajh.setVisibility(0);
            this.ajh.startLoad(boo.getAvatar(), 10, false);
            this.aji.setVisibility(0);
            this.ajo = boo.forumName;
            this.aji.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.ajo));
            com.baidu.tbadk.a.b.a.e(this.aji);
        } else {
            if (bwVar.bos()) {
                this.ajk.setVisibility(8);
                this.ajj.setVisibility(8);
                this.ajl.setVisibility(8);
                this.ajm.setVisibility(8);
                this.ajn.setVisibility(0);
                this.ajn.setText(bwVar.blY());
            } else {
                this.ajn.setVisibility(8);
                this.ajl.setVisibility(8);
                this.ajm.setVisibility(8);
                this.ajk.setVisibility(0);
                this.ajj.setVisibility(0);
            }
            setData(bwVar.boo().forumName, bwVar.boo().getAvatar(), bwVar.boo().postNum, bwVar.boo().memberNum);
            if (bwVar.bkj()) {
                if (bwVar.bmA() != null && !StringUtils.isNull(bwVar.bmA().getName_show())) {
                    this.ajj.setText(bwVar.bmA().getName_show());
                } else {
                    this.ajj.setText(R.string.user_name_default_txt);
                }
                this.ajk.setText(bwVar.blY());
            }
        }
    }

    private void ui() {
        if (this.ajr != null) {
            int pe = TagTextHelper.pe(this.ajr.position + 1);
            this.ajl.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds10));
            int color = ap.getColor(pe);
            Drawable mutate = ap.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            mutate.setBounds(0, 0, dimens, dimens);
            DrawableCompat.setTint(mutate, color);
            this.ajl.setCompoundDrawables(mutate, null, null, null);
            this.ajl.setBackgroundDrawable(null);
            ap.setViewTextColor(this.ajl, pe);
            ap.setViewTextColor(this.ajm, pe);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.ajo)) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.ajo, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            if (this.ajp != null) {
                this.ajp.onClick(view);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.ajq) {
            this.ajq = skinType;
            Drawable a2 = SvgManager.brn().a(R.drawable.icon_pure_card_ba16_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            a2.setBounds(0, 0, dimens, dimens);
            this.aji.setCompoundDrawables(null, null, a2, null);
            this.aji.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds10));
            ap.setViewTextColor(this.aji, R.color.cp_cont_b);
            ap.setViewTextColor(this.ajj, R.color.cp_cont_d);
            ap.setViewTextColor(this.ajk, R.color.cp_cont_d);
            ap.setViewTextColor(this.ajn, R.color.cp_cont_d);
            uj();
            ui();
        }
    }

    private void uj() {
        com.baidu.tbadk.a.b.a.f(this.aji);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajp = onClickListener;
    }
}

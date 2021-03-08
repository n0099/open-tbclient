package com.baidu.card.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.a.b.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.SingleLineEllipsizeTextView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {
    private BarImageView ald;
    private SingleLineEllipsizeTextView ale;
    private TextView alf;
    private TextView alg;
    private TextView alh;
    private TextView ali;
    private TextView alj;
    private String alk;
    private View.OnClickListener alm;
    private int aln;
    private cb alo;

    public CardForumHeadLayout(Context context) {
        super(context);
        this.aln = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aln = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aln = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
        this.ald = (BarImageView) findViewById(R.id.forum_head_image);
        this.ale = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
        this.alf = (TextView) findViewById(R.id.forum_head_info_attention);
        this.alg = (TextView) findViewById(R.id.forum_head_info_thread);
        this.alh = (TextView) findViewById(R.id.hot_rank_index);
        this.ali = (TextView) findViewById(R.id.hot_rank_num);
        this.alj = (TextView) findViewById(R.id.thread_extend_info);
        this.ald.setShowOval(true);
        this.ald.setAutoChangeStyle(true);
        this.ald.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.ald.setStrokeColorResId(R.color.CAM_X0401);
        this.ald.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ald.setOnClickListener(this);
        this.ale.setOnClickListener(this);
        this.alf.setOnClickListener(this);
        this.alg.setOnClickListener(this);
        this.ale.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        this.ale.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize, 0, 0);
        onChangeSkinType();
    }

    private void tv() {
        this.ald.setVisibility(8);
        this.ale.setVisibility(8);
        this.alg.setVisibility(8);
        this.alf.setVisibility(8);
    }

    public void setData(String str, String str2, int i, int i2) {
        if (StringUtils.isNull(str)) {
            tv();
            return;
        }
        this.ald.setPlaceHolder(1);
        this.ald.setVisibility(0);
        this.ale.setVisibility(0);
        this.alk = str;
        this.ale.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.alk));
        this.ald.startLoad(str2, 10, false);
        this.alg.setText(String.format(getContext().getString(R.string.forum_thread_number), au.numberUniformFormatExtra(i)));
        this.alf.setText(String.format(getContext().getString(R.string.concern), au.numberUniformFormatExtra(i2)));
        b.g(this.ale);
    }

    public void setData(cb cbVar) {
        this.alo = cbVar;
        if (cbVar == null || cbVar.bpI() == null) {
            tv();
        } else if (cbVar.eVk) {
            this.alg.setVisibility(8);
            this.alf.setVisibility(8);
            this.alh.setVisibility(0);
            this.ali.setVisibility(0);
            this.alj.setVisibility(0);
            this.alj.setText(cbVar.bnq());
            int i = cbVar.eVA >= 1000 ? cbVar.eVA : 1000;
            this.ali.setVisibility(0);
            this.ali.setText(this.ali.getContext().getResources().getString(R.string.thread_rank_tag, au.ed(i)));
            int i2 = cbVar.position + 1;
            this.alh.setText(i2 >= 10 ? String.valueOf(i2) : "0" + i2);
            tw();
            bx bpI = cbVar.bpI();
            this.ald.setPlaceHolder(1);
            this.ald.setVisibility(0);
            this.ald.startLoad(bpI.getAvatar(), 10, false);
            this.ale.setVisibility(0);
            this.alk = bpI.forumName;
            this.ale.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.alk));
            b.g(this.ale);
        } else if (cbVar.eVl) {
            this.alj.setVisibility(8);
            if ("agree_num".equals(cbVar.eVm) || "comment_num".equals(cbVar.eVm) || "share_num".equals(cbVar.eVm)) {
                this.alh.setVisibility(0);
                this.ali.setVisibility(0);
                if ("agree_num".equals(cbVar.eVm)) {
                    long j = 0;
                    if (cbVar.bpL() != null) {
                        j = cbVar.bpL().agreeNum;
                    }
                    this.ali.setText(this.ali.getContext().getResources().getString(R.string.thread_like_rank_tag, au.ed(j)));
                } else if ("comment_num".equals(cbVar.eVm)) {
                    this.ali.setText(this.ali.getContext().getResources().getString(R.string.thread_discuss_rank_tag, au.ed(cbVar.bnJ())));
                } else if ("share_num".equals(cbVar.eVm)) {
                    this.ali.setText(this.ali.getContext().getResources().getString(R.string.thread_spread_rank_tag, au.ed(cbVar.bpw())));
                }
                int i3 = cbVar.position + 1;
                this.alh.setText(i3 >= 10 ? String.valueOf(i3) : "0" + i3);
                tw();
            } else {
                this.alh.setVisibility(8);
                this.ali.setVisibility(8);
            }
            setData(cbVar.bpI().forumName, cbVar.bpI().getAvatar(), cbVar.bpI().postNum, cbVar.bpI().memberNum);
        } else {
            if (cbVar.bpM()) {
                this.alg.setVisibility(8);
                this.alf.setVisibility(8);
                this.alh.setVisibility(8);
                this.ali.setVisibility(8);
                this.alj.setVisibility(0);
                this.alj.setText(cbVar.bnq());
            } else {
                this.alj.setVisibility(8);
                this.alh.setVisibility(8);
                this.ali.setVisibility(8);
                this.alg.setVisibility(0);
                this.alf.setVisibility(0);
            }
            setData(cbVar.bpI().forumName, cbVar.bpI().getAvatar(), cbVar.bpI().postNum, cbVar.bpI().memberNum);
            if (cbVar.blx()) {
                if (cbVar.bnS() != null && !StringUtils.isNull(cbVar.bnS().getName_show())) {
                    this.alf.setText(cbVar.bnS().getName_show());
                } else {
                    this.alf.setText(R.string.user_name_default_txt);
                }
                this.alg.setText(cbVar.bnq());
            }
        }
    }

    private void tw() {
        Drawable mutate;
        if (this.alo != null) {
            int oK = TagTextHelper.oK(this.alo.position + 1);
            this.alh.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.M_W_X002));
            int color = ap.getColor(oK);
            if (this.alo.eVl) {
                if ("agree_num".equals(this.alo.eVm)) {
                    mutate = ap.getDrawable(R.drawable.icon_pure_tiebatreasure_like).mutate();
                } else if ("comment_num".equals(this.alo.eVm)) {
                    mutate = ap.getDrawable(R.drawable.icon_pure_tiebatreasure_discuss).mutate();
                } else {
                    mutate = "share_num".equals(this.alo.eVm) ? ap.getDrawable(R.drawable.icon_pure_tiebatreasure_spread).mutate() : null;
                }
            } else {
                mutate = ap.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            }
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            if (mutate != null) {
                mutate.setBounds(0, 0, dimens, dimens);
                DrawableCompat.setTint(mutate, color);
                this.alh.setCompoundDrawables(mutate, null, null, null);
                this.alh.setBackgroundDrawable(null);
                ap.setViewTextColor(this.alh, oK);
                ap.setViewTextColor(this.ali, oK);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.alk)) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.alk, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            if (this.alm != null) {
                this.alm.onClick(view);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aln) {
            this.aln = skinType;
            Drawable a2 = WebPManager.a(R.drawable.icon_pure_ba16, ap.getColor(R.color.CAM_X0105), (WebPManager.ResourceStateType) null);
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            a2.setBounds(0, 0, dimens, dimens);
            this.ale.setCompoundDrawables(null, null, a2, null);
            this.ale.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.M_W_X002));
            ap.setViewTextColor(this.ale, R.color.CAM_X0105);
            ap.setViewTextColor(this.alf, R.color.CAM_X0109);
            ap.setViewTextColor(this.alg, R.color.CAM_X0109);
            ap.setViewTextColor(this.alj, R.color.CAM_X0109);
            tx();
            tw();
        }
    }

    private void tx() {
        b.h(this.ale);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.alm = onClickListener;
    }
}

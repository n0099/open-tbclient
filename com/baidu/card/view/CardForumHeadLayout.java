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
    private BarImageView ajL;
    private SingleLineEllipsizeTextView ajM;
    private TextView ajN;
    private TextView ajO;
    private TextView ajP;
    private TextView ajQ;
    private TextView ajR;
    private String ajS;
    private View.OnClickListener ajT;
    private int ajU;
    private cb ajV;

    public CardForumHeadLayout(Context context) {
        super(context);
        this.ajU = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajU = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajU = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
        this.ajL = (BarImageView) findViewById(R.id.forum_head_image);
        this.ajM = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
        this.ajN = (TextView) findViewById(R.id.forum_head_info_attention);
        this.ajO = (TextView) findViewById(R.id.forum_head_info_thread);
        this.ajP = (TextView) findViewById(R.id.hot_rank_index);
        this.ajQ = (TextView) findViewById(R.id.hot_rank_num);
        this.ajR = (TextView) findViewById(R.id.thread_extend_info);
        this.ajL.setShowOval(true);
        this.ajL.setAutoChangeStyle(true);
        this.ajL.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.ajL.setStrokeColorResId(R.color.CAM_X0401);
        this.ajL.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ajL.setOnClickListener(this);
        this.ajM.setOnClickListener(this);
        this.ajN.setOnClickListener(this);
        this.ajO.setOnClickListener(this);
        this.ajM.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        this.ajM.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize, 0, 0);
        onChangeSkinType();
    }

    private void tv() {
        this.ajL.setVisibility(8);
        this.ajM.setVisibility(8);
        this.ajO.setVisibility(8);
        this.ajN.setVisibility(8);
    }

    public void setData(String str, String str2, int i, int i2) {
        if (StringUtils.isNull(str)) {
            tv();
            return;
        }
        this.ajL.setPlaceHolder(1);
        this.ajL.setVisibility(0);
        this.ajM.setVisibility(0);
        this.ajS = str;
        this.ajM.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.ajS));
        this.ajL.startLoad(str2, 10, false);
        this.ajO.setText(String.format(getContext().getString(R.string.forum_thread_number), au.numberUniformFormatExtra(i)));
        this.ajN.setText(String.format(getContext().getString(R.string.concern), au.numberUniformFormatExtra(i2)));
        b.g(this.ajM);
    }

    public void setData(cb cbVar) {
        this.ajV = cbVar;
        if (cbVar == null || cbVar.bpG() == null) {
            tv();
        } else if (cbVar.eTJ) {
            this.ajO.setVisibility(8);
            this.ajN.setVisibility(8);
            this.ajP.setVisibility(0);
            this.ajQ.setVisibility(0);
            this.ajR.setVisibility(0);
            this.ajR.setText(cbVar.bno());
            int i = cbVar.eTZ >= 1000 ? cbVar.eTZ : 1000;
            this.ajQ.setVisibility(0);
            this.ajQ.setText(this.ajQ.getContext().getResources().getString(R.string.thread_rank_tag, au.ed(i)));
            int i2 = cbVar.position + 1;
            this.ajP.setText(i2 >= 10 ? String.valueOf(i2) : "0" + i2);
            tw();
            bx bpG = cbVar.bpG();
            this.ajL.setPlaceHolder(1);
            this.ajL.setVisibility(0);
            this.ajL.startLoad(bpG.getAvatar(), 10, false);
            this.ajM.setVisibility(0);
            this.ajS = bpG.forumName;
            this.ajM.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.ajS));
            b.g(this.ajM);
        } else if (cbVar.eTK) {
            this.ajR.setVisibility(8);
            if ("agree_num".equals(cbVar.eTL) || "comment_num".equals(cbVar.eTL) || "share_num".equals(cbVar.eTL)) {
                this.ajP.setVisibility(0);
                this.ajQ.setVisibility(0);
                if ("agree_num".equals(cbVar.eTL)) {
                    long j = 0;
                    if (cbVar.bpJ() != null) {
                        j = cbVar.bpJ().agreeNum;
                    }
                    this.ajQ.setText(this.ajQ.getContext().getResources().getString(R.string.thread_like_rank_tag, au.ed(j)));
                } else if ("comment_num".equals(cbVar.eTL)) {
                    this.ajQ.setText(this.ajQ.getContext().getResources().getString(R.string.thread_discuss_rank_tag, au.ed(cbVar.bnH())));
                } else if ("share_num".equals(cbVar.eTL)) {
                    this.ajQ.setText(this.ajQ.getContext().getResources().getString(R.string.thread_spread_rank_tag, au.ed(cbVar.bpu())));
                }
                int i3 = cbVar.position + 1;
                this.ajP.setText(i3 >= 10 ? String.valueOf(i3) : "0" + i3);
                tw();
            } else {
                this.ajP.setVisibility(8);
                this.ajQ.setVisibility(8);
            }
            setData(cbVar.bpG().forumName, cbVar.bpG().getAvatar(), cbVar.bpG().postNum, cbVar.bpG().memberNum);
        } else {
            if (cbVar.bpK()) {
                this.ajO.setVisibility(8);
                this.ajN.setVisibility(8);
                this.ajP.setVisibility(8);
                this.ajQ.setVisibility(8);
                this.ajR.setVisibility(0);
                this.ajR.setText(cbVar.bno());
            } else {
                this.ajR.setVisibility(8);
                this.ajP.setVisibility(8);
                this.ajQ.setVisibility(8);
                this.ajO.setVisibility(0);
                this.ajN.setVisibility(0);
            }
            setData(cbVar.bpG().forumName, cbVar.bpG().getAvatar(), cbVar.bpG().postNum, cbVar.bpG().memberNum);
            if (cbVar.blv()) {
                if (cbVar.bnQ() != null && !StringUtils.isNull(cbVar.bnQ().getName_show())) {
                    this.ajN.setText(cbVar.bnQ().getName_show());
                } else {
                    this.ajN.setText(R.string.user_name_default_txt);
                }
                this.ajO.setText(cbVar.bno());
            }
        }
    }

    private void tw() {
        Drawable mutate;
        if (this.ajV != null) {
            int oJ = TagTextHelper.oJ(this.ajV.position + 1);
            this.ajP.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.M_W_X002));
            int color = ap.getColor(oJ);
            if (this.ajV.eTK) {
                if ("agree_num".equals(this.ajV.eTL)) {
                    mutate = ap.getDrawable(R.drawable.icon_pure_tiebatreasure_like).mutate();
                } else if ("comment_num".equals(this.ajV.eTL)) {
                    mutate = ap.getDrawable(R.drawable.icon_pure_tiebatreasure_discuss).mutate();
                } else {
                    mutate = "share_num".equals(this.ajV.eTL) ? ap.getDrawable(R.drawable.icon_pure_tiebatreasure_spread).mutate() : null;
                }
            } else {
                mutate = ap.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            }
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            if (mutate != null) {
                mutate.setBounds(0, 0, dimens, dimens);
                DrawableCompat.setTint(mutate, color);
                this.ajP.setCompoundDrawables(mutate, null, null, null);
                this.ajP.setBackgroundDrawable(null);
                ap.setViewTextColor(this.ajP, oJ);
                ap.setViewTextColor(this.ajQ, oJ);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.ajS)) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.ajS, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            if (this.ajT != null) {
                this.ajT.onClick(view);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.ajU) {
            this.ajU = skinType;
            Drawable a2 = WebPManager.a(R.drawable.icon_pure_ba16, ap.getColor(R.color.CAM_X0105), (WebPManager.ResourceStateType) null);
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            a2.setBounds(0, 0, dimens, dimens);
            this.ajM.setCompoundDrawables(null, null, a2, null);
            this.ajM.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.M_W_X002));
            ap.setViewTextColor(this.ajM, R.color.CAM_X0105);
            ap.setViewTextColor(this.ajN, R.color.CAM_X0109);
            ap.setViewTextColor(this.ajO, R.color.CAM_X0109);
            ap.setViewTextColor(this.ajR, R.color.CAM_X0109);
            tx();
            tw();
        }
    }

    private void tx() {
        b.h(this.ajM);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajT = onClickListener;
    }
}

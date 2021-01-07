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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.SingleLineEllipsizeTextView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {
    private BarImageView akN;
    private SingleLineEllipsizeTextView akO;
    private TextView akP;
    private TextView akQ;
    private TextView akR;
    private TextView akS;
    private TextView akT;
    private String akU;
    private View.OnClickListener akV;
    private int akW;
    private bz akX;

    public CardForumHeadLayout(Context context) {
        super(context);
        this.akW = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akW = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akW = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
        this.akN = (BarImageView) findViewById(R.id.forum_head_image);
        this.akO = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
        this.akP = (TextView) findViewById(R.id.forum_head_info_attention);
        this.akQ = (TextView) findViewById(R.id.forum_head_info_thread);
        this.akR = (TextView) findViewById(R.id.hot_rank_index);
        this.akS = (TextView) findViewById(R.id.hot_rank_num);
        this.akT = (TextView) findViewById(R.id.thread_extend_info);
        this.akN.setShowOval(true);
        this.akN.setAutoChangeStyle(true);
        this.akN.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.akN.setStrokeColorResId(R.color.CAM_X0401);
        this.akN.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.akN.setOnClickListener(this);
        this.akO.setOnClickListener(this);
        this.akP.setOnClickListener(this);
        this.akQ.setOnClickListener(this);
        this.akO.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        this.akO.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize, 0, 0);
        onChangeSkinType();
    }

    private void tJ() {
        this.akN.setVisibility(8);
        this.akO.setVisibility(8);
        this.akQ.setVisibility(8);
        this.akP.setVisibility(8);
    }

    public void setData(String str, String str2, int i, int i2) {
        if (StringUtils.isNull(str)) {
            tJ();
            return;
        }
        this.akN.setPlaceHolder(1);
        this.akN.setVisibility(0);
        this.akO.setVisibility(0);
        this.akU = str;
        this.akO.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.akU));
        this.akN.startLoad(str2, 10, false);
        this.akQ.setText(String.format(getContext().getString(R.string.forum_thread_number), at.numberUniformFormatExtra(i)));
        this.akP.setText(String.format(getContext().getString(R.string.concern), at.numberUniformFormatExtra(i2)));
        b.g(this.akO);
    }

    public void setData(bz bzVar) {
        this.akX = bzVar;
        if (bzVar == null || bzVar.bti() == null) {
            tJ();
        } else if (bzVar.eWi) {
            this.akQ.setVisibility(8);
            this.akP.setVisibility(8);
            this.akR.setVisibility(0);
            this.akS.setVisibility(0);
            this.akT.setVisibility(0);
            this.akT.setText(bzVar.bqP());
            int i = bzVar.eWw >= 1000 ? bzVar.eWw : 1000;
            this.akS.setVisibility(0);
            this.akS.setText(this.akS.getContext().getResources().getString(R.string.thread_rank_tag, at.dX(i)));
            int i2 = bzVar.position + 1;
            this.akR.setText(i2 >= 10 ? String.valueOf(i2) : "0" + i2);
            tK();
            bv bti = bzVar.bti();
            this.akN.setPlaceHolder(1);
            this.akN.setVisibility(0);
            this.akN.startLoad(bti.getAvatar(), 10, false);
            this.akO.setVisibility(0);
            this.akU = bti.forumName;
            this.akO.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.akU));
            b.g(this.akO);
        } else {
            if (bzVar.btm()) {
                this.akQ.setVisibility(8);
                this.akP.setVisibility(8);
                this.akR.setVisibility(8);
                this.akS.setVisibility(8);
                this.akT.setVisibility(0);
                this.akT.setText(bzVar.bqP());
            } else {
                this.akT.setVisibility(8);
                this.akR.setVisibility(8);
                this.akS.setVisibility(8);
                this.akQ.setVisibility(0);
                this.akP.setVisibility(0);
            }
            setData(bzVar.bti().forumName, bzVar.bti().getAvatar(), bzVar.bti().postNum, bzVar.bti().memberNum);
            if (bzVar.boX()) {
                if (bzVar.brr() != null && !StringUtils.isNull(bzVar.brr().getName_show())) {
                    this.akP.setText(bzVar.brr().getName_show());
                } else {
                    this.akP.setText(R.string.user_name_default_txt);
                }
                this.akQ.setText(bzVar.bqP());
            }
        }
    }

    private void tK() {
        if (this.akX != null) {
            int ql = TagTextHelper.ql(this.akX.position + 1);
            this.akR.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.M_W_X002));
            int color = ao.getColor(ql);
            Drawable mutate = ao.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            mutate.setBounds(0, 0, dimens, dimens);
            DrawableCompat.setTint(mutate, color);
            this.akR.setCompoundDrawables(mutate, null, null, null);
            this.akR.setBackgroundDrawable(null);
            ao.setViewTextColor(this.akR, ql);
            ao.setViewTextColor(this.akS, ql);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.akU)) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.akU, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            if (this.akV != null) {
                this.akV.onClick(view);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.akW) {
            this.akW = skinType;
            Drawable a2 = WebPManager.a(R.drawable.icon_pure_ba16, ao.getColor(R.color.CAM_X0105), (WebPManager.ResourceStateType) null);
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            a2.setBounds(0, 0, dimens, dimens);
            this.akO.setCompoundDrawables(null, null, a2, null);
            this.akO.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.M_W_X002));
            ao.setViewTextColor(this.akO, R.color.CAM_X0105);
            ao.setViewTextColor(this.akP, R.color.CAM_X0109);
            ao.setViewTextColor(this.akQ, R.color.CAM_X0109);
            ao.setViewTextColor(this.akT, R.color.CAM_X0109);
            tL();
            tK();
        }
    }

    private void tL() {
        b.h(this.akO);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.akV = onClickListener;
    }
}

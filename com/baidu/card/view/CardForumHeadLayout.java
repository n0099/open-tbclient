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
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.SingleLineEllipsizeTextView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {
    private BarImageView ajm;
    private SingleLineEllipsizeTextView ajn;
    private TextView ajo;
    private TextView ajp;
    private TextView ajq;
    private TextView ajr;
    private TextView ajs;
    private String ajt;
    private View.OnClickListener aju;
    private int ajv;
    private bx ajw;

    public CardForumHeadLayout(Context context) {
        super(context);
        this.ajv = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajv = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajv = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
        this.ajm = (BarImageView) findViewById(R.id.forum_head_image);
        this.ajn = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
        this.ajo = (TextView) findViewById(R.id.forum_head_info_attention);
        this.ajp = (TextView) findViewById(R.id.forum_head_info_thread);
        this.ajq = (TextView) findViewById(R.id.hot_rank_index);
        this.ajr = (TextView) findViewById(R.id.hot_rank_num);
        this.ajs = (TextView) findViewById(R.id.thread_extend_info);
        this.ajm.setShowOval(true);
        this.ajm.setAutoChangeStyle(true);
        this.ajm.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.ajm.setStrokeColorResId(R.color.CAM_X0401);
        this.ajm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ajm.setOnClickListener(this);
        this.ajn.setOnClickListener(this);
        this.ajo.setOnClickListener(this);
        this.ajp.setOnClickListener(this);
        this.ajn.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        this.ajn.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize, 0, 0);
        onChangeSkinType();
    }

    private void uh() {
        this.ajm.setVisibility(8);
        this.ajn.setVisibility(8);
        this.ajp.setVisibility(8);
        this.ajo.setVisibility(8);
    }

    public void setData(String str, String str2, int i, int i2) {
        if (StringUtils.isNull(str)) {
            uh();
            return;
        }
        this.ajm.setPlaceHolder(1);
        this.ajm.setVisibility(0);
        this.ajn.setVisibility(0);
        this.ajt = str;
        this.ajn.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.ajt));
        this.ajm.startLoad(str2, 10, false);
        this.ajp.setText(String.format(getContext().getString(R.string.forum_thread_number), au.numberUniformFormatExtra(i)));
        this.ajo.setText(String.format(getContext().getString(R.string.concern), au.numberUniformFormatExtra(i2)));
        com.baidu.tbadk.a.b.a.e(this.ajn);
    }

    public void setData(bx bxVar) {
        this.ajw = bxVar;
        if (bxVar == null || bxVar.bns() == null) {
            uh();
        } else if (bxVar.eFl) {
            this.ajp.setVisibility(8);
            this.ajo.setVisibility(8);
            this.ajq.setVisibility(0);
            this.ajr.setVisibility(0);
            this.ajs.setVisibility(0);
            this.ajs.setText(bxVar.bla());
            int i = bxVar.eFz >= 1000 ? bxVar.eFz : 1000;
            this.ajr.setVisibility(0);
            this.ajr.setText(this.ajr.getContext().getResources().getString(R.string.thread_rank_tag, au.dy(i)));
            int i2 = bxVar.position + 1;
            this.ajq.setText(i2 >= 10 ? String.valueOf(i2) : "0" + i2);
            ui();
            bt bns = bxVar.bns();
            this.ajm.setPlaceHolder(1);
            this.ajm.setVisibility(0);
            this.ajm.startLoad(bns.getAvatar(), 10, false);
            this.ajn.setVisibility(0);
            this.ajt = bns.forumName;
            this.ajn.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.ajt));
            com.baidu.tbadk.a.b.a.e(this.ajn);
        } else {
            if (bxVar.bnw()) {
                this.ajp.setVisibility(8);
                this.ajo.setVisibility(8);
                this.ajq.setVisibility(8);
                this.ajr.setVisibility(8);
                this.ajs.setVisibility(0);
                this.ajs.setText(bxVar.bla());
            } else {
                this.ajs.setVisibility(8);
                this.ajq.setVisibility(8);
                this.ajr.setVisibility(8);
                this.ajp.setVisibility(0);
                this.ajo.setVisibility(0);
            }
            setData(bxVar.bns().forumName, bxVar.bns().getAvatar(), bxVar.bns().postNum, bxVar.bns().memberNum);
            if (bxVar.bjl()) {
                if (bxVar.blC() != null && !StringUtils.isNull(bxVar.blC().getName_show())) {
                    this.ajo.setText(bxVar.blC().getName_show());
                } else {
                    this.ajo.setText(R.string.user_name_default_txt);
                }
                this.ajp.setText(bxVar.bla());
            }
        }
    }

    private void ui() {
        if (this.ajw != null) {
            int pA = TagTextHelper.pA(this.ajw.position + 1);
            this.ajq.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.M_W_X002));
            int color = ap.getColor(pA);
            Drawable mutate = ap.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            mutate.setBounds(0, 0, dimens, dimens);
            DrawableCompat.setTint(mutate, color);
            this.ajq.setCompoundDrawables(mutate, null, null, null);
            this.ajq.setBackgroundDrawable(null);
            ap.setViewTextColor(this.ajq, pA);
            ap.setViewTextColor(this.ajr, pA);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.ajt)) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.ajt, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            if (this.aju != null) {
                this.aju.onClick(view);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.ajv) {
            this.ajv = skinType;
            Drawable a2 = WebPManager.a(R.drawable.icon_pure_ba16, ap.getColor(R.color.CAM_X0105), (WebPManager.ResourceStateType) null);
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            a2.setBounds(0, 0, dimens, dimens);
            this.ajn.setCompoundDrawables(null, null, a2, null);
            this.ajn.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.M_W_X002));
            ap.setViewTextColor(this.ajn, R.color.CAM_X0105);
            ap.setViewTextColor(this.ajo, R.color.CAM_X0109);
            ap.setViewTextColor(this.ajp, R.color.CAM_X0109);
            ap.setViewTextColor(this.ajs, R.color.CAM_X0109);
            uj();
            ui();
        }
    }

    private void uj() {
        com.baidu.tbadk.a.b.a.f(this.ajn);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aju = onClickListener;
    }
}

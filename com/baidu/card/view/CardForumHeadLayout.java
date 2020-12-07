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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.SingleLineEllipsizeTextView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {
    private BarImageView akl;
    private SingleLineEllipsizeTextView akm;
    private TextView akn;
    private TextView ako;
    private TextView akp;
    private TextView akq;
    private TextView akr;
    private String aks;
    private View.OnClickListener akt;
    private int aku;
    private by akv;

    public CardForumHeadLayout(Context context) {
        super(context);
        this.aku = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aku = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aku = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
        this.akl = (BarImageView) findViewById(R.id.forum_head_image);
        this.akm = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
        this.akn = (TextView) findViewById(R.id.forum_head_info_attention);
        this.ako = (TextView) findViewById(R.id.forum_head_info_thread);
        this.akp = (TextView) findViewById(R.id.hot_rank_index);
        this.akq = (TextView) findViewById(R.id.hot_rank_num);
        this.akr = (TextView) findViewById(R.id.thread_extend_info);
        this.akl.setShowOval(true);
        this.akl.setAutoChangeStyle(true);
        this.akl.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.akl.setStrokeColorResId(R.color.CAM_X0401);
        this.akl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.akl.setOnClickListener(this);
        this.akm.setOnClickListener(this);
        this.akn.setOnClickListener(this);
        this.ako.setOnClickListener(this);
        this.akm.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        this.akm.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize, 0, 0);
        onChangeSkinType();
    }

    private void uk() {
        this.akl.setVisibility(8);
        this.akm.setVisibility(8);
        this.ako.setVisibility(8);
        this.akn.setVisibility(8);
    }

    public void setData(String str, String str2, int i, int i2) {
        if (StringUtils.isNull(str)) {
            uk();
            return;
        }
        this.akl.setPlaceHolder(1);
        this.akl.setVisibility(0);
        this.akm.setVisibility(0);
        this.aks = str;
        this.akm.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.aks));
        this.akl.startLoad(str2, 10, false);
        this.ako.setText(String.format(getContext().getString(R.string.forum_thread_number), au.numberUniformFormatExtra(i)));
        this.akn.setText(String.format(getContext().getString(R.string.concern), au.numberUniformFormatExtra(i2)));
        com.baidu.tbadk.a.b.a.e(this.akm);
    }

    public void setData(by byVar) {
        this.akv = byVar;
        if (byVar == null || byVar.bqF() == null) {
            uk();
        } else if (byVar.eMn) {
            this.ako.setVisibility(8);
            this.akn.setVisibility(8);
            this.akp.setVisibility(0);
            this.akq.setVisibility(0);
            this.akr.setVisibility(0);
            this.akr.setText(byVar.bon());
            int i = byVar.eMB >= 1000 ? byVar.eMB : 1000;
            this.akq.setVisibility(0);
            this.akq.setText(this.akq.getContext().getResources().getString(R.string.thread_rank_tag, au.dX(i)));
            int i2 = byVar.position + 1;
            this.akp.setText(i2 >= 10 ? String.valueOf(i2) : "0" + i2);
            ul();
            bu bqF = byVar.bqF();
            this.akl.setPlaceHolder(1);
            this.akl.setVisibility(0);
            this.akl.startLoad(bqF.getAvatar(), 10, false);
            this.akm.setVisibility(0);
            this.aks = bqF.forumName;
            this.akm.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.aks));
            com.baidu.tbadk.a.b.a.e(this.akm);
        } else {
            if (byVar.bqJ()) {
                this.ako.setVisibility(8);
                this.akn.setVisibility(8);
                this.akp.setVisibility(8);
                this.akq.setVisibility(8);
                this.akr.setVisibility(0);
                this.akr.setText(byVar.bon());
            } else {
                this.akr.setVisibility(8);
                this.akp.setVisibility(8);
                this.akq.setVisibility(8);
                this.ako.setVisibility(0);
                this.akn.setVisibility(0);
            }
            setData(byVar.bqF().forumName, byVar.bqF().getAvatar(), byVar.bqF().postNum, byVar.bqF().memberNum);
            if (byVar.bmv()) {
                if (byVar.boP() != null && !StringUtils.isNull(byVar.boP().getName_show())) {
                    this.akn.setText(byVar.boP().getName_show());
                } else {
                    this.akn.setText(R.string.user_name_default_txt);
                }
                this.ako.setText(byVar.bon());
            }
        }
    }

    private void ul() {
        if (this.akv != null) {
            int qa = TagTextHelper.qa(this.akv.position + 1);
            this.akp.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.M_W_X002));
            int color = ap.getColor(qa);
            Drawable mutate = ap.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            mutate.setBounds(0, 0, dimens, dimens);
            DrawableCompat.setTint(mutate, color);
            this.akp.setCompoundDrawables(mutate, null, null, null);
            this.akp.setBackgroundDrawable(null);
            ap.setViewTextColor(this.akp, qa);
            ap.setViewTextColor(this.akq, qa);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.aks)) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.aks, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            if (this.akt != null) {
                this.akt.onClick(view);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aku) {
            this.aku = skinType;
            Drawable a2 = WebPManager.a(R.drawable.icon_pure_ba16, ap.getColor(R.color.CAM_X0105), (WebPManager.ResourceStateType) null);
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            a2.setBounds(0, 0, dimens, dimens);
            this.akm.setCompoundDrawables(null, null, a2, null);
            this.akm.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.M_W_X002));
            ap.setViewTextColor(this.akm, R.color.CAM_X0105);
            ap.setViewTextColor(this.akn, R.color.CAM_X0109);
            ap.setViewTextColor(this.ako, R.color.CAM_X0109);
            ap.setViewTextColor(this.akr, R.color.CAM_X0109);
            um();
            ul();
        }
    }

    private void um() {
        com.baidu.tbadk.a.b.a.f(this.akm);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }
}

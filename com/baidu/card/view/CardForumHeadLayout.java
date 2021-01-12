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
    private BarImageView ajW;
    private SingleLineEllipsizeTextView ajX;
    private TextView ajY;
    private TextView ajZ;
    private TextView aka;
    private TextView akb;
    private TextView akc;
    private String akd;
    private View.OnClickListener ake;
    private int akf;
    private bz akg;

    public CardForumHeadLayout(Context context) {
        super(context);
        this.akf = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akf = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.akf = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
        this.ajW = (BarImageView) findViewById(R.id.forum_head_image);
        this.ajX = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
        this.ajY = (TextView) findViewById(R.id.forum_head_info_attention);
        this.ajZ = (TextView) findViewById(R.id.forum_head_info_thread);
        this.aka = (TextView) findViewById(R.id.hot_rank_index);
        this.akb = (TextView) findViewById(R.id.hot_rank_num);
        this.akc = (TextView) findViewById(R.id.thread_extend_info);
        this.ajW.setShowOval(true);
        this.ajW.setAutoChangeStyle(true);
        this.ajW.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.ajW.setStrokeColorResId(R.color.CAM_X0401);
        this.ajW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ajW.setOnClickListener(this);
        this.ajX.setOnClickListener(this);
        this.ajY.setOnClickListener(this);
        this.ajZ.setOnClickListener(this);
        this.ajX.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        this.ajX.setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X006) - dimenPixelSize, 0, 0);
        onChangeSkinType();
    }

    private void ty() {
        this.ajW.setVisibility(8);
        this.ajX.setVisibility(8);
        this.ajZ.setVisibility(8);
        this.ajY.setVisibility(8);
    }

    public void setData(String str, String str2, int i, int i2) {
        if (StringUtils.isNull(str)) {
            ty();
            return;
        }
        this.ajW.setPlaceHolder(1);
        this.ajW.setVisibility(0);
        this.ajX.setVisibility(0);
        this.akd = str;
        this.ajX.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.akd));
        this.ajW.startLoad(str2, 10, false);
        this.ajZ.setText(String.format(getContext().getString(R.string.forum_thread_number), at.numberUniformFormatExtra(i)));
        this.ajY.setText(String.format(getContext().getString(R.string.concern), at.numberUniformFormatExtra(i2)));
        b.g(this.ajX);
    }

    public void setData(bz bzVar) {
        this.akg = bzVar;
        if (bzVar == null || bzVar.bpo() == null) {
            ty();
        } else if (bzVar.eRx) {
            this.ajZ.setVisibility(8);
            this.ajY.setVisibility(8);
            this.aka.setVisibility(0);
            this.akb.setVisibility(0);
            this.akc.setVisibility(0);
            this.akc.setText(bzVar.bmV());
            int i = bzVar.eRL >= 1000 ? bzVar.eRL : 1000;
            this.akb.setVisibility(0);
            this.akb.setText(this.akb.getContext().getResources().getString(R.string.thread_rank_tag, at.dX(i)));
            int i2 = bzVar.position + 1;
            this.aka.setText(i2 >= 10 ? String.valueOf(i2) : "0" + i2);
            tz();
            bv bpo = bzVar.bpo();
            this.ajW.setPlaceHolder(1);
            this.ajW.setVisibility(0);
            this.ajW.startLoad(bpo.getAvatar(), 10, false);
            this.ajX.setVisibility(0);
            this.akd = bpo.forumName;
            this.ajX.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.akd));
            b.g(this.ajX);
        } else {
            if (bzVar.bps()) {
                this.ajZ.setVisibility(8);
                this.ajY.setVisibility(8);
                this.aka.setVisibility(8);
                this.akb.setVisibility(8);
                this.akc.setVisibility(0);
                this.akc.setText(bzVar.bmV());
            } else {
                this.akc.setVisibility(8);
                this.aka.setVisibility(8);
                this.akb.setVisibility(8);
                this.ajZ.setVisibility(0);
                this.ajY.setVisibility(0);
            }
            setData(bzVar.bpo().forumName, bzVar.bpo().getAvatar(), bzVar.bpo().postNum, bzVar.bpo().memberNum);
            if (bzVar.bld()) {
                if (bzVar.bnx() != null && !StringUtils.isNull(bzVar.bnx().getName_show())) {
                    this.ajY.setText(bzVar.bnx().getName_show());
                } else {
                    this.ajY.setText(R.string.user_name_default_txt);
                }
                this.ajZ.setText(bzVar.bmV());
            }
        }
    }

    private void tz() {
        if (this.akg != null) {
            int oE = TagTextHelper.oE(this.akg.position + 1);
            this.aka.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.M_W_X002));
            int color = ao.getColor(oE);
            Drawable mutate = ao.getDrawable(R.drawable.icon_pure_topic_hot).mutate();
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            mutate.setBounds(0, 0, dimens, dimens);
            DrawableCompat.setTint(mutate, color);
            this.aka.setCompoundDrawables(mutate, null, null, null);
            this.aka.setBackgroundDrawable(null);
            ao.setViewTextColor(this.aka, oE);
            ao.setViewTextColor(this.akb, oE);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.akd)) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.akd, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            if (this.ake != null) {
                this.ake.onClick(view);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.akf) {
            this.akf = skinType;
            Drawable a2 = WebPManager.a(R.drawable.icon_pure_ba16, ao.getColor(R.color.CAM_X0105), (WebPManager.ResourceStateType) null);
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            a2.setBounds(0, 0, dimens, dimens);
            this.ajX.setCompoundDrawables(null, null, a2, null);
            this.ajX.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.M_W_X002));
            ao.setViewTextColor(this.ajX, R.color.CAM_X0105);
            ao.setViewTextColor(this.ajY, R.color.CAM_X0109);
            ao.setViewTextColor(this.ajZ, R.color.CAM_X0109);
            ao.setViewTextColor(this.akc, R.color.CAM_X0109);
            tA();
            tz();
        }
    }

    private void tA() {
        b.h(this.ajX);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ake = onClickListener;
    }
}

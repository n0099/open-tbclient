package com.baidu.card.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.SingleLineEllipsizeTextView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {
    private BarImageView ahi;
    private SingleLineEllipsizeTextView ahj;
    private TextView ahk;
    private TextView ahl;
    private String ahm;
    private View.OnClickListener ahn;
    private int aho;

    public CardForumHeadLayout(Context context) {
        super(context);
        this.aho = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aho = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aho = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
        this.ahi = (BarImageView) findViewById(R.id.forum_head_image);
        this.ahj = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
        this.ahk = (TextView) findViewById(R.id.forum_head_info_attention);
        this.ahl = (TextView) findViewById(R.id.forum_head_info_thread);
        this.ahi.setShowOval(true);
        this.ahi.setAutoChangeStyle(true);
        this.ahi.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.ahi.setStrokeColorResId(R.color.cp_border_a);
        this.ahi.setOnClickListener(this);
        this.ahj.setOnClickListener(this);
        this.ahk.setOnClickListener(this);
        this.ahl.setOnClickListener(this);
        this.ahj.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
        onChangeSkinType();
    }

    private void sq() {
        this.ahi.setVisibility(8);
        this.ahj.setVisibility(8);
        this.ahl.setVisibility(8);
        this.ahk.setVisibility(8);
    }

    public void setData(String str, String str2, int i, int i2) {
        if (StringUtils.isNull(str)) {
            sq();
            return;
        }
        this.ahi.setPlaceHolder(1);
        this.ahi.setVisibility(0);
        this.ahj.setVisibility(0);
        this.ahl.setVisibility(0);
        this.ahk.setVisibility(0);
        this.ahm = str;
        this.ahj.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.ahm));
        this.ahi.startLoad(str2, 10, false);
        this.ahl.setText(String.format(getContext().getString(R.string.forum_thread_number), as.numberUniformFormatExtra(i)));
        this.ahk.setText(String.format(getContext().getString(R.string.concern), as.numberUniformFormatExtra(i2)));
        com.baidu.tbadk.a.b.a.a(this.ahj);
    }

    public void setData(bv bvVar) {
        if (bvVar == null || bvVar.aXZ() == null) {
            sq();
            return;
        }
        setData(bvVar.aXZ().forumName, bvVar.aXZ().getAvatar(), bvVar.aXZ().postNum, bvVar.aXZ().memberNum);
        if (bvVar.aTW()) {
            if (bvVar.aWl() != null && !StringUtils.isNull(bvVar.aWl().getName_show())) {
                this.ahk.setText(bvVar.aWl().getName_show());
            } else {
                this.ahk.setText(R.string.user_name_default_txt);
            }
            this.ahl.setText(bvVar.aVJ());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.ahm)) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.ahm, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            if (this.ahn != null) {
                this.ahn.onClick(view);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.aho) {
            this.aho = skinType;
            Drawable a = SvgManager.baR().a(R.drawable.icon_pure_card_ba16_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            a.setBounds(0, 0, dimens, dimens);
            this.ahj.setCompoundDrawables(null, null, a, null);
            this.ahj.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds10));
            ao.setViewTextColor(this.ahj, R.color.cp_cont_b);
            com.baidu.tbadk.a.b.a.b(this.ahj);
            ao.setViewTextColor(this.ahk, R.color.cp_cont_d);
            ao.setViewTextColor(this.ahl, R.color.cp_cont_d);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ahn = onClickListener;
    }
}

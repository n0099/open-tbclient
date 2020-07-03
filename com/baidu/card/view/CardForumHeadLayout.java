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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.SingleLineEllipsizeTextView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class CardForumHeadLayout extends RelativeLayout implements View.OnClickListener {
    private BarImageView ahr;
    private SingleLineEllipsizeTextView ahs;
    private TextView aht;
    private TextView ahu;
    private String ahv;
    private View.OnClickListener ahw;
    private int ahx;

    public CardForumHeadLayout(Context context) {
        super(context);
        this.ahx = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahx = 3;
        init(context);
    }

    public CardForumHeadLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahx = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.card_forum_head_layout, (ViewGroup) this, true);
        this.ahr = (BarImageView) findViewById(R.id.forum_head_image);
        this.ahs = (SingleLineEllipsizeTextView) findViewById(R.id.forum_head_barname);
        this.aht = (TextView) findViewById(R.id.forum_head_info_attention);
        this.ahu = (TextView) findViewById(R.id.forum_head_info_thread);
        this.ahr.setShowOval(true);
        this.ahr.setAutoChangeStyle(true);
        this.ahr.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.ahr.setStrokeColorResId(R.color.cp_border_a);
        this.ahr.setOnClickListener(this);
        this.ahs.setOnClickListener(this);
        this.aht.setOnClickListener(this);
        this.ahu.setOnClickListener(this);
        this.ahs.setEllipsisSuffix(getResources().getString(R.string.ellipsis_suffix_bar));
        onChangeSkinType();
    }

    private void so() {
        this.ahr.setVisibility(8);
        this.ahs.setVisibility(8);
        this.ahu.setVisibility(8);
        this.aht.setVisibility(8);
    }

    public void setData(String str, String str2, int i, int i2) {
        if (StringUtils.isNull(str)) {
            so();
            return;
        }
        this.ahr.setPlaceHolder(1);
        this.ahr.setVisibility(0);
        this.ahs.setVisibility(0);
        this.ahu.setVisibility(0);
        this.aht.setVisibility(0);
        this.ahv = str;
        this.ahs.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), this.ahv));
        this.ahr.startLoad(str2, 10, false);
        this.ahu.setText(String.format(getContext().getString(R.string.forum_thread_number), ar.numberUniformFormatExtra(i)));
        this.aht.setText(String.format(getContext().getString(R.string.concern), ar.numberUniformFormatExtra(i2)));
    }

    public void setData(bu buVar) {
        if (buVar == null || buVar.aUd() == null) {
            so();
        } else {
            setData(buVar.aUd().forumName, buVar.aUd().getAvatar(), buVar.aUd().postNum, buVar.aUd().memberNum);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!StringUtils.isNull(this.ahv)) {
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(getContext()).createNormalCfg(this.ahv, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
            createNormalCfg.setCallFrom(14);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
            if (this.ahw != null) {
                this.ahw.onClick(view);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.ahx) {
            this.ahx = skinType;
            Drawable a = SvgManager.aWQ().a(R.drawable.icon_pure_card_ba16_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
            int dimens = l.getDimens(getContext(), R.dimen.tbds42);
            a.setBounds(0, 0, dimens, dimens);
            this.ahs.setCompoundDrawables(null, null, a, null);
            this.ahs.setCompoundDrawablePadding(l.getDimens(getContext(), R.dimen.tbds10));
            an.setViewTextColor(this.ahs, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.aht, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.ahu, (int) R.color.cp_cont_d);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ahw = onClickListener;
    }
}

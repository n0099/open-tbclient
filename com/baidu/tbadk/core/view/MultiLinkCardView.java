package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class MultiLinkCardView extends RelativeLayout {
    private TbImageView ehp;
    private TbImageView ehq;
    private TbImageView ehr;
    private TextView ehs;
    private TextView eht;
    private ImageView ehu;
    private static final int eho = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds136);
    private static final int aTp = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);

    public MultiLinkCardView(Context context) {
        this(context, null);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.multi_link_card_layout, this);
        this.ehp = (TbImageView) findViewById(R.id.iv_multi_link_first_icon);
        this.ehp.setDrawCorner(true);
        this.ehp.setConrers(15);
        this.ehp.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.ehq = (TbImageView) findViewById(R.id.iv_multi_link_second_icon);
        this.ehq.setDrawCorner(true);
        this.ehq.setConrers(15);
        this.ehq.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.ehr = (TbImageView) findViewById(R.id.iv_multi_link_third_icon);
        this.ehr.setDrawCorner(true);
        this.ehr.setConrers(15);
        this.ehr.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.ehs = (TextView) findViewById(R.id.tv_multi_link_more_link_count);
        this.eht = (TextView) findViewById(R.id.tv_multi_link_count);
        this.ehu = (ImageView) findViewById(R.id.iv_multi_link_right_arrow);
        onChangeSkinType();
    }

    public void aV(List<PbLinkData> list) {
        if (!x.isEmpty(list)) {
            this.ehp.setVisibility(8);
            this.ehq.setVisibility(8);
            this.ehr.setVisibility(8);
            if (com.baidu.tbadk.a.d.aRL()) {
                com.baidu.tbadk.core.util.e.a.bbr().i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha42).Q(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).aX(this.ehs);
            }
            this.ehs.setVisibility(8);
            int size = list.size() > 3 ? 3 : list.size();
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    this.ehp.startLoad(list.get(i).picUrl, 10, false);
                    this.ehp.setVisibility(0);
                }
                if (i == 1) {
                    this.ehq.startLoad(list.get(i).picUrl, 10, false);
                    this.ehq.setVisibility(0);
                }
                if (i == 2) {
                    this.ehr.startLoad(list.get(i).picUrl, 10, false);
                    this.ehr.setVisibility(0);
                }
                if (list.size() > 3 && i == 2) {
                    this.ehs.setText(getContext().getString(R.string.constrain_image_extra_text, Integer.valueOf(list.size() - 3)));
                    this.ehs.setVisibility(0);
                }
            }
            this.eht.setText(getContext().getString(R.string.multi_link_count, Integer.valueOf(list.size())));
        }
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this, R.drawable.bg_link_card);
        ao.setViewTextColor(this.eht, R.color.cp_cont_j);
        SvgManager.baR().a(this.ehu, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
    }
}

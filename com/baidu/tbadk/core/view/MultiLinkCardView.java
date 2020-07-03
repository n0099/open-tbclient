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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class MultiLinkCardView extends RelativeLayout {
    private TbImageView ebd;
    private TbImageView ebe;
    private TbImageView ebf;
    private TextView ebg;
    private TextView ebh;
    private ImageView ebi;
    private static final int ebc = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds136);
    private static final int aRW = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);

    public MultiLinkCardView(Context context) {
        this(context, null);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.multi_link_card_layout, this);
        this.ebd = (TbImageView) findViewById(R.id.iv_multi_link_first_icon);
        this.ebd.setDrawCorner(true);
        this.ebd.setConrers(15);
        this.ebd.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.ebe = (TbImageView) findViewById(R.id.iv_multi_link_second_icon);
        this.ebe.setDrawCorner(true);
        this.ebe.setConrers(15);
        this.ebe.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.ebf = (TbImageView) findViewById(R.id.iv_multi_link_third_icon);
        this.ebf.setDrawCorner(true);
        this.ebf.setConrers(15);
        this.ebf.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.ebg = (TextView) findViewById(R.id.tv_multi_link_more_link_count);
        this.ebh = (TextView) findViewById(R.id.tv_multi_link_count);
        this.ebi = (ImageView) findViewById(R.id.iv_multi_link_right_arrow);
        onChangeSkinType();
    }

    public void aP(List<PbLinkData> list) {
        if (!w.isEmpty(list)) {
            this.ebd.setVisibility(8);
            this.ebe.setVisibility(8);
            this.ebf.setVisibility(8);
            this.ebg.setVisibility(8);
            int size = list.size() > 3 ? 3 : list.size();
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    this.ebd.startLoad(list.get(i).picUrl, 10, false);
                    this.ebd.setVisibility(0);
                }
                if (i == 1) {
                    this.ebe.startLoad(list.get(i).picUrl, 10, false);
                    this.ebe.setVisibility(0);
                }
                if (i == 2) {
                    this.ebf.startLoad(list.get(i).picUrl, 10, false);
                    this.ebf.setVisibility(0);
                }
                if (list.size() > 3 && i == 2) {
                    this.ebg.setText(getContext().getString(R.string.constrain_image_extra_text, Integer.valueOf(list.size() - 3)));
                    this.ebg.setVisibility(0);
                }
            }
            this.ebh.setText(getContext().getString(R.string.multi_link_count, Integer.valueOf(list.size())));
        }
    }

    public void onChangeSkinType() {
        an.setBackgroundResource(this, R.drawable.bg_link_card);
        an.setViewTextColor(this.ebh, (int) R.color.cp_cont_j);
        SvgManager.aWQ().a(this.ebi, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
    }
}

package com.baidu.tbadk.core.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MultiLinkCardView extends RelativeLayout {
    private TextView eNM;
    private TextView eNN;
    private TextView eNO;
    private RelativeLayout eNP;
    private RelativeLayout eNQ;
    private RelativeLayout eNR;
    private TbImageView eNS;
    private TbImageView eNT;
    private TbImageView eNU;
    private TextView eNV;
    private TextView eNW;
    private ImageView eNX;
    private List<RelativeLayout> eNY;
    private List<TbImageView> eNZ;
    private List<TextView> eOa;
    private static final int eNL = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds136);
    private static final int bgc = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);

    public MultiLinkCardView(Context context) {
        this(context, null);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.multi_link_card_layout, this);
        this.eNP = (RelativeLayout) findViewById(R.id.rl_multi_link_first);
        this.eNQ = (RelativeLayout) findViewById(R.id.rl_multi_link_second);
        this.eNR = (RelativeLayout) findViewById(R.id.rl_multi_link_third);
        this.eNM = (TextView) findViewById(R.id.goods_from_tag_first);
        this.eNN = (TextView) findViewById(R.id.goods_from_tag_second);
        this.eNO = (TextView) findViewById(R.id.goods_from_tag_third);
        this.eNS = (TbImageView) findViewById(R.id.iv_multi_link_first_icon);
        this.eNS.setDrawCorner(true);
        this.eNS.setGifIconSupport(false);
        this.eNS.setLongIconSupport(false);
        this.eNS.setConrers(15);
        this.eNS.setPlaceHolder(2);
        this.eNS.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.eNT = (TbImageView) findViewById(R.id.iv_multi_link_second_icon);
        this.eNT.setDrawCorner(true);
        this.eNT.setGifIconSupport(false);
        this.eNT.setLongIconSupport(false);
        this.eNT.setConrers(15);
        this.eNT.setPlaceHolder(2);
        this.eNT.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.eNU = (TbImageView) findViewById(R.id.iv_multi_link_third_icon);
        this.eNU.setDrawCorner(true);
        this.eNU.setGifIconSupport(false);
        this.eNU.setLongIconSupport(false);
        this.eNU.setPlaceHolder(2);
        this.eNU.setConrers(15);
        this.eNU.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.eNV = (TextView) findViewById(R.id.tv_multi_link_more_link_count);
        this.eNW = (TextView) findViewById(R.id.tv_multi_link_count);
        this.eNX = (ImageView) findViewById(R.id.iv_multi_link_right_arrow);
        this.eOa = new ArrayList();
        this.eNZ = new ArrayList();
        this.eNY = new ArrayList();
        this.eNY.add(this.eNP);
        this.eNY.add(this.eNQ);
        this.eNY.add(this.eNR);
        this.eNZ.add(this.eNS);
        this.eNZ.add(this.eNT);
        this.eNZ.add(this.eNU);
        this.eOa.add(this.eNM);
        this.eOa.add(this.eNN);
        this.eOa.add(this.eNO);
        onChangeSkinType();
    }

    public void k(List<PbLinkData> list, List<PbGoodsData> list2) {
        new ArrayList();
        ag agVar = new ag();
        List<com.baidu.tieba.card.data.d> m = agVar.m(list, list2);
        boolean bBx = agVar.bBx();
        if (!y.isEmpty(m)) {
            if (com.baidu.tbadk.a.d.bfu()) {
                com.baidu.tbadk.core.util.e.a.bpo().i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha42).Z(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).bg(this.eNV);
            }
            this.eNP.setVisibility(8);
            this.eNQ.setVisibility(8);
            this.eNR.setVisibility(8);
            this.eNV.setVisibility(8);
            int size = m.size() > 3 ? 3 : m.size();
            for (int i = 0; i < size; i++) {
                if (m.get(i) instanceof PbLinkData) {
                    PbLinkData pbLinkData = (PbLinkData) m.get(i);
                    if (i < m.size() && pbLinkData != null) {
                        this.eNY.get(i).setVisibility(0);
                        this.eNZ.get(i).startLoad(pbLinkData.picUrl, 10, false);
                        if (pbLinkData.urlType == 2 && !TextUtils.isEmpty(pbLinkData.linkFrom)) {
                            this.eOa.get(i).setText(pbLinkData.linkFrom);
                            this.eOa.get(i).setVisibility(0);
                        }
                    }
                } else if (m.get(i) instanceof PbGoodsData) {
                    PbGoodsData pbGoodsData = (PbGoodsData) m.get(i);
                    if (i < m.size() && pbGoodsData != null) {
                        this.eNY.get(i).setVisibility(0);
                        this.eNZ.get(i).startLoad(pbGoodsData.picUrl, 10, false);
                    }
                }
                if (m.size() > 3 && i == 2) {
                    this.eNV.setText(getContext().getString(R.string.constrain_image_extra_text, Integer.valueOf(m.size() - 3)));
                    this.eNV.setVisibility(0);
                }
            }
            this.eNW.setText(getContext().getString(bBx ? R.string.multi_goods_count : R.string.multi_link_count, Integer.valueOf(m.size())));
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.bg_link_card);
        ap.setViewTextColor(this.eNW, R.color.cp_cont_j);
        SvgManager.boN().a(this.eNX, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        for (int i = 0; i < this.eOa.size(); i++) {
            ap.setViewTextColor(this.eOa.get(i), R.color.cp_cont_a);
            com.baidu.tbadk.core.util.e.a.bpo().oZ(0).pa(R.color.cp_link_tip_d_alpha66).ad(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).ac(UtilHelper.getDimenPixelSize(R.dimen.tbds10)).ab(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).aa(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).bg(this.eOa.get(i));
        }
    }
}

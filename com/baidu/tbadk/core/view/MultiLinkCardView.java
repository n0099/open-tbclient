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
import com.baidu.tbadk.util.ah;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MultiLinkCardView extends RelativeLayout {
    private TextView fiJ;
    private TextView fiK;
    private TextView fiL;
    private RelativeLayout fiM;
    private RelativeLayout fiN;
    private RelativeLayout fiO;
    private TbImageView fiP;
    private TbImageView fiQ;
    private TbImageView fiR;
    private TextView fiS;
    private TextView fiT;
    private ImageView fiU;
    private List<RelativeLayout> fiV;
    private List<TbImageView> fiW;
    private List<TextView> fiX;
    private static final int fiI = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds136);
    private static final int blG = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);

    public MultiLinkCardView(Context context) {
        this(context, null);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.multi_link_card_layout, this);
        this.fiM = (RelativeLayout) findViewById(R.id.rl_multi_link_first);
        this.fiN = (RelativeLayout) findViewById(R.id.rl_multi_link_second);
        this.fiO = (RelativeLayout) findViewById(R.id.rl_multi_link_third);
        this.fiJ = (TextView) findViewById(R.id.goods_from_tag_first);
        this.fiK = (TextView) findViewById(R.id.goods_from_tag_second);
        this.fiL = (TextView) findViewById(R.id.goods_from_tag_third);
        this.fiP = (TbImageView) findViewById(R.id.iv_multi_link_first_icon);
        this.fiP.setDrawCorner(true);
        this.fiP.setGifIconSupport(false);
        this.fiP.setLongIconSupport(false);
        this.fiP.setConrers(15);
        this.fiP.setPlaceHolder(1);
        this.fiP.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.fiQ = (TbImageView) findViewById(R.id.iv_multi_link_second_icon);
        this.fiQ.setDrawCorner(true);
        this.fiQ.setGifIconSupport(false);
        this.fiQ.setLongIconSupport(false);
        this.fiQ.setConrers(15);
        this.fiQ.setPlaceHolder(1);
        this.fiQ.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.fiR = (TbImageView) findViewById(R.id.iv_multi_link_third_icon);
        this.fiR.setDrawCorner(true);
        this.fiR.setGifIconSupport(false);
        this.fiR.setLongIconSupport(false);
        this.fiR.setPlaceHolder(1);
        this.fiR.setConrers(15);
        this.fiR.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.fiS = (TextView) findViewById(R.id.tv_multi_link_more_link_count);
        com.baidu.tbadk.core.elementsMaven.c.br(this.fiS).oj(R.array.S_O_X001);
        this.fiT = (TextView) findViewById(R.id.tv_multi_link_count);
        this.fiU = (ImageView) findViewById(R.id.iv_multi_link_right_arrow);
        this.fiX = new ArrayList();
        this.fiW = new ArrayList();
        this.fiV = new ArrayList();
        this.fiV.add(this.fiM);
        this.fiV.add(this.fiN);
        this.fiV.add(this.fiO);
        this.fiW.add(this.fiP);
        this.fiW.add(this.fiQ);
        this.fiW.add(this.fiR);
        this.fiX.add(this.fiJ);
        this.fiX.add(this.fiK);
        this.fiX.add(this.fiL);
        onChangeSkinType();
    }

    public void l(List<PbLinkData> list, List<PbGoodsData> list2) {
        new ArrayList();
        ah ahVar = new ah();
        List<com.baidu.tieba.card.data.c> n = ahVar.n(list, list2);
        boolean bFQ = ahVar.bFQ();
        if (!y.isEmpty(n)) {
            if (com.baidu.tbadk.a.d.biZ()) {
                com.baidu.tbadk.core.util.f.a.bty().m(R.color.CAM_X0601, R.color.CAM_X0606).aj(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).bv(this.fiS);
            }
            this.fiM.setVisibility(8);
            this.fiN.setVisibility(8);
            this.fiO.setVisibility(8);
            this.fiS.setVisibility(8);
            int size = n.size() > 3 ? 3 : n.size();
            for (int i = 0; i < size; i++) {
                if (n.get(i) instanceof PbLinkData) {
                    PbLinkData pbLinkData = (PbLinkData) n.get(i);
                    if (i < n.size() && pbLinkData != null) {
                        this.fiV.get(i).setVisibility(0);
                        this.fiW.get(i).startLoad(pbLinkData.picUrl, 10, false);
                        if (pbLinkData.urlType == 2 && !TextUtils.isEmpty(pbLinkData.linkFrom)) {
                            this.fiX.get(i).setText(pbLinkData.linkFrom);
                            this.fiX.get(i).setVisibility(0);
                        }
                    }
                } else if (n.get(i) instanceof PbGoodsData) {
                    PbGoodsData pbGoodsData = (PbGoodsData) n.get(i);
                    if (i < n.size() && pbGoodsData != null) {
                        this.fiV.get(i).setVisibility(0);
                        this.fiW.get(i).startLoad(pbGoodsData.picUrl, 10, false);
                    }
                }
                if (n.size() > 3 && i == 2) {
                    this.fiS.setText(getContext().getString(R.string.constrain_image_extra_text, Integer.valueOf(n.size() - 3)));
                    this.fiS.setVisibility(0);
                }
            }
            this.fiT.setText(getContext().getString(bFQ ? R.string.multi_goods_count : R.string.multi_link_count, Integer.valueOf(n.size())));
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.bg_link_card);
        ap.setViewTextColor(this.fiT, R.color.CAM_X0107);
        SvgManager.bsU().a(this.fiU, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        for (int i = 0; i < this.fiX.size(); i++) {
            ap.setViewTextColor(this.fiX.get(i), R.color.CAM_X0101);
            com.baidu.tbadk.core.util.f.a.bty().oP(0).oQ(R.color.cp_link_tip_d_alpha66).an(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).am(UtilHelper.getDimenPixelSize(R.dimen.tbds10)).al(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).ak(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).bv(this.fiX.get(i));
        }
    }
}

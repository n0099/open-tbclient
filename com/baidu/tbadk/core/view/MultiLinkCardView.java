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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MultiLinkCardView extends RelativeLayout {
    private TextView feR;
    private TextView feS;
    private TextView feT;
    private RelativeLayout feU;
    private RelativeLayout feV;
    private RelativeLayout feW;
    private TbImageView feX;
    private TbImageView feY;
    private TbImageView feZ;
    private TextView ffa;
    private TextView ffb;
    private ImageView ffc;
    private List<RelativeLayout> ffd;
    private List<TbImageView> ffe;
    private List<TextView> fff;
    private static final int feQ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds136);
    private static final int bgP = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);

    public MultiLinkCardView(Context context) {
        this(context, null);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.multi_link_card_layout, this);
        this.feU = (RelativeLayout) findViewById(R.id.rl_multi_link_first);
        this.feV = (RelativeLayout) findViewById(R.id.rl_multi_link_second);
        this.feW = (RelativeLayout) findViewById(R.id.rl_multi_link_third);
        this.feR = (TextView) findViewById(R.id.goods_from_tag_first);
        this.feS = (TextView) findViewById(R.id.goods_from_tag_second);
        this.feT = (TextView) findViewById(R.id.goods_from_tag_third);
        this.feX = (TbImageView) findViewById(R.id.iv_multi_link_first_icon);
        this.feX.setDrawCorner(true);
        this.feX.setGifIconSupport(false);
        this.feX.setLongIconSupport(false);
        this.feX.setConrers(15);
        this.feX.setPlaceHolder(1);
        this.feX.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.feY = (TbImageView) findViewById(R.id.iv_multi_link_second_icon);
        this.feY.setDrawCorner(true);
        this.feY.setGifIconSupport(false);
        this.feY.setLongIconSupport(false);
        this.feY.setConrers(15);
        this.feY.setPlaceHolder(1);
        this.feY.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.feZ = (TbImageView) findViewById(R.id.iv_multi_link_third_icon);
        this.feZ.setDrawCorner(true);
        this.feZ.setGifIconSupport(false);
        this.feZ.setLongIconSupport(false);
        this.feZ.setPlaceHolder(1);
        this.feZ.setConrers(15);
        this.feZ.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.ffa = (TextView) findViewById(R.id.tv_multi_link_more_link_count);
        float[] nL = com.baidu.tbadk.core.elementsMaven.a.nL(R.array.S_O_X001);
        this.ffa.setShadowLayer(nL[1], nL[2], nL[3], (int) nL[0]);
        this.ffb = (TextView) findViewById(R.id.tv_multi_link_count);
        this.ffc = (ImageView) findViewById(R.id.iv_multi_link_right_arrow);
        this.fff = new ArrayList();
        this.ffe = new ArrayList();
        this.ffd = new ArrayList();
        this.ffd.add(this.feU);
        this.ffd.add(this.feV);
        this.ffd.add(this.feW);
        this.ffe.add(this.feX);
        this.ffe.add(this.feY);
        this.ffe.add(this.feZ);
        this.fff.add(this.feR);
        this.fff.add(this.feS);
        this.fff.add(this.feT);
        onChangeSkinType();
    }

    public void n(List<PbLinkData> list, List<PbGoodsData> list2) {
        new ArrayList();
        ae aeVar = new ae();
        List<com.baidu.tieba.card.data.c> p = aeVar.p(list, list2);
        boolean bFs = aeVar.bFs();
        if (!x.isEmpty(p)) {
            if (com.baidu.tbadk.a.d.biL()) {
                com.baidu.tbadk.core.util.f.a.btb().m(R.color.CAM_X0601, R.color.CAM_X0606).ae(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).bz(this.ffa);
            }
            this.feU.setVisibility(8);
            this.feV.setVisibility(8);
            this.feW.setVisibility(8);
            this.ffa.setVisibility(8);
            int size = p.size() > 3 ? 3 : p.size();
            for (int i = 0; i < size; i++) {
                if (p.get(i) instanceof PbLinkData) {
                    PbLinkData pbLinkData = (PbLinkData) p.get(i);
                    if (i < p.size() && pbLinkData != null) {
                        this.ffd.get(i).setVisibility(0);
                        this.ffe.get(i).startLoad(pbLinkData.picUrl, 10, false);
                        if (pbLinkData.urlType == 2 && !TextUtils.isEmpty(pbLinkData.linkFrom)) {
                            this.fff.get(i).setText(pbLinkData.linkFrom);
                            this.fff.get(i).setVisibility(0);
                        }
                    }
                } else if (p.get(i) instanceof PbGoodsData) {
                    PbGoodsData pbGoodsData = (PbGoodsData) p.get(i);
                    if (i < p.size() && pbGoodsData != null) {
                        this.ffd.get(i).setVisibility(0);
                        this.ffe.get(i).startLoad(pbGoodsData.picUrl, 10, false);
                    }
                }
                if (p.size() > 3 && i == 2) {
                    this.ffa.setText(getContext().getString(R.string.constrain_image_extra_text, Integer.valueOf(p.size() - 3)));
                    this.ffa.setVisibility(0);
                }
            }
            this.ffb.setText(getContext().getString(bFs ? R.string.multi_goods_count : R.string.multi_link_count, Integer.valueOf(p.size())));
        }
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this, R.drawable.bg_link_card);
        ao.setViewTextColor(this.ffb, R.color.CAM_X0107);
        SvgManager.bsx().a(this.ffc, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        for (int i = 0; i < this.fff.size(); i++) {
            ao.setViewTextColor(this.fff.get(i), R.color.CAM_X0101);
            com.baidu.tbadk.core.util.f.a.btb().oJ(0).oK(R.color.cp_link_tip_d_alpha66).ai(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).ah(UtilHelper.getDimenPixelSize(R.dimen.tbds10)).ag(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).af(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).bz(this.fff.get(i));
        }
    }
}

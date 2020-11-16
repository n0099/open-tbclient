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
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MultiLinkCardView extends RelativeLayout {
    private TextView eSD;
    private TextView eSE;
    private TextView eSF;
    private RelativeLayout eSG;
    private RelativeLayout eSH;
    private RelativeLayout eSI;
    private TbImageView eSJ;
    private TbImageView eSK;
    private TbImageView eSL;
    private TextView eSM;
    private TextView eSN;
    private ImageView eSO;
    private List<RelativeLayout> eSP;
    private List<TbImageView> eSQ;
    private List<TextView> eSR;
    private static final int eSC = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds136);
    private static final int bfK = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);

    public MultiLinkCardView(Context context) {
        this(context, null);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.multi_link_card_layout, this);
        this.eSG = (RelativeLayout) findViewById(R.id.rl_multi_link_first);
        this.eSH = (RelativeLayout) findViewById(R.id.rl_multi_link_second);
        this.eSI = (RelativeLayout) findViewById(R.id.rl_multi_link_third);
        this.eSD = (TextView) findViewById(R.id.goods_from_tag_first);
        this.eSE = (TextView) findViewById(R.id.goods_from_tag_second);
        this.eSF = (TextView) findViewById(R.id.goods_from_tag_third);
        this.eSJ = (TbImageView) findViewById(R.id.iv_multi_link_first_icon);
        this.eSJ.setDrawCorner(true);
        this.eSJ.setGifIconSupport(false);
        this.eSJ.setLongIconSupport(false);
        this.eSJ.setConrers(15);
        this.eSJ.setPlaceHolder(1);
        this.eSJ.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.eSK = (TbImageView) findViewById(R.id.iv_multi_link_second_icon);
        this.eSK.setDrawCorner(true);
        this.eSK.setGifIconSupport(false);
        this.eSK.setLongIconSupport(false);
        this.eSK.setConrers(15);
        this.eSK.setPlaceHolder(1);
        this.eSK.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.eSL = (TbImageView) findViewById(R.id.iv_multi_link_third_icon);
        this.eSL.setDrawCorner(true);
        this.eSL.setGifIconSupport(false);
        this.eSL.setLongIconSupport(false);
        this.eSL.setPlaceHolder(1);
        this.eSL.setConrers(15);
        this.eSL.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.eSM = (TextView) findViewById(R.id.tv_multi_link_more_link_count);
        float[] oJ = com.baidu.tbadk.core.elementsMaven.a.oJ(R.array.S_O_X001);
        this.eSM.setShadowLayer(oJ[1], oJ[2], oJ[3], (int) oJ[0]);
        this.eSN = (TextView) findViewById(R.id.tv_multi_link_count);
        this.eSO = (ImageView) findViewById(R.id.iv_multi_link_right_arrow);
        this.eSR = new ArrayList();
        this.eSQ = new ArrayList();
        this.eSP = new ArrayList();
        this.eSP.add(this.eSG);
        this.eSP.add(this.eSH);
        this.eSP.add(this.eSI);
        this.eSQ.add(this.eSJ);
        this.eSQ.add(this.eSK);
        this.eSQ.add(this.eSL);
        this.eSR.add(this.eSD);
        this.eSR.add(this.eSE);
        this.eSR.add(this.eSF);
        onChangeSkinType();
    }

    public void l(List<PbLinkData> list, List<PbGoodsData> list2) {
        new ArrayList();
        af afVar = new af();
        List<com.baidu.tieba.card.data.c> n = afVar.n(list, list2);
        boolean bDp = afVar.bDp();
        if (!y.isEmpty(n)) {
            if (com.baidu.tbadk.a.d.bhm()) {
                com.baidu.tbadk.core.util.e.a.brc().l(R.color.CAM_X0601, R.color.CAM_X0606).ac(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).bn(this.eSM);
            }
            this.eSG.setVisibility(8);
            this.eSH.setVisibility(8);
            this.eSI.setVisibility(8);
            this.eSM.setVisibility(8);
            int size = n.size() > 3 ? 3 : n.size();
            for (int i = 0; i < size; i++) {
                if (n.get(i) instanceof PbLinkData) {
                    PbLinkData pbLinkData = (PbLinkData) n.get(i);
                    if (i < n.size() && pbLinkData != null) {
                        this.eSP.get(i).setVisibility(0);
                        this.eSQ.get(i).startLoad(pbLinkData.picUrl, 10, false);
                        if (pbLinkData.urlType == 2 && !TextUtils.isEmpty(pbLinkData.linkFrom)) {
                            this.eSR.get(i).setText(pbLinkData.linkFrom);
                            this.eSR.get(i).setVisibility(0);
                        }
                    }
                } else if (n.get(i) instanceof PbGoodsData) {
                    PbGoodsData pbGoodsData = (PbGoodsData) n.get(i);
                    if (i < n.size() && pbGoodsData != null) {
                        this.eSP.get(i).setVisibility(0);
                        this.eSQ.get(i).startLoad(pbGoodsData.picUrl, 10, false);
                    }
                }
                if (n.size() > 3 && i == 2) {
                    this.eSM.setText(getContext().getString(R.string.constrain_image_extra_text, Integer.valueOf(n.size() - 3)));
                    this.eSM.setVisibility(0);
                }
            }
            this.eSN.setText(getContext().getString(bDp ? R.string.multi_goods_count : R.string.multi_link_count, Integer.valueOf(n.size())));
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.bg_link_card);
        ap.setViewTextColor(this.eSN, R.color.CAM_X0107);
        SvgManager.bqB().a(this.eSO, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        for (int i = 0; i < this.eSR.size(); i++) {
            ap.setViewTextColor(this.eSR.get(i), R.color.CAM_X0101);
            com.baidu.tbadk.core.util.e.a.brc().pF(0).pG(R.color.cp_link_tip_d_alpha66).ag(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).af(UtilHelper.getDimenPixelSize(R.dimen.tbds10)).ae(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).ad(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).bn(this.eSR.get(i));
        }
    }
}

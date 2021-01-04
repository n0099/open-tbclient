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
    private TextView fjC;
    private TextView fjD;
    private TextView fjE;
    private RelativeLayout fjF;
    private RelativeLayout fjG;
    private RelativeLayout fjH;
    private TbImageView fjI;
    private TbImageView fjJ;
    private TbImageView fjK;
    private TextView fjL;
    private TextView fjM;
    private ImageView fjN;
    private List<RelativeLayout> fjO;
    private List<TbImageView> fjP;
    private List<TextView> fjQ;
    private static final int fjB = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds136);
    private static final int blE = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);

    public MultiLinkCardView(Context context) {
        this(context, null);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.multi_link_card_layout, this);
        this.fjF = (RelativeLayout) findViewById(R.id.rl_multi_link_first);
        this.fjG = (RelativeLayout) findViewById(R.id.rl_multi_link_second);
        this.fjH = (RelativeLayout) findViewById(R.id.rl_multi_link_third);
        this.fjC = (TextView) findViewById(R.id.goods_from_tag_first);
        this.fjD = (TextView) findViewById(R.id.goods_from_tag_second);
        this.fjE = (TextView) findViewById(R.id.goods_from_tag_third);
        this.fjI = (TbImageView) findViewById(R.id.iv_multi_link_first_icon);
        this.fjI.setDrawCorner(true);
        this.fjI.setGifIconSupport(false);
        this.fjI.setLongIconSupport(false);
        this.fjI.setConrers(15);
        this.fjI.setPlaceHolder(1);
        this.fjI.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.fjJ = (TbImageView) findViewById(R.id.iv_multi_link_second_icon);
        this.fjJ.setDrawCorner(true);
        this.fjJ.setGifIconSupport(false);
        this.fjJ.setLongIconSupport(false);
        this.fjJ.setConrers(15);
        this.fjJ.setPlaceHolder(1);
        this.fjJ.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.fjK = (TbImageView) findViewById(R.id.iv_multi_link_third_icon);
        this.fjK.setDrawCorner(true);
        this.fjK.setGifIconSupport(false);
        this.fjK.setLongIconSupport(false);
        this.fjK.setPlaceHolder(1);
        this.fjK.setConrers(15);
        this.fjK.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.fjL = (TextView) findViewById(R.id.tv_multi_link_more_link_count);
        float[] ps = com.baidu.tbadk.core.elementsMaven.a.ps(R.array.S_O_X001);
        this.fjL.setShadowLayer(ps[1], ps[2], ps[3], (int) ps[0]);
        this.fjM = (TextView) findViewById(R.id.tv_multi_link_count);
        this.fjN = (ImageView) findViewById(R.id.iv_multi_link_right_arrow);
        this.fjQ = new ArrayList();
        this.fjP = new ArrayList();
        this.fjO = new ArrayList();
        this.fjO.add(this.fjF);
        this.fjO.add(this.fjG);
        this.fjO.add(this.fjH);
        this.fjP.add(this.fjI);
        this.fjP.add(this.fjJ);
        this.fjP.add(this.fjK);
        this.fjQ.add(this.fjC);
        this.fjQ.add(this.fjD);
        this.fjQ.add(this.fjE);
        onChangeSkinType();
    }

    public void n(List<PbLinkData> list, List<PbGoodsData> list2) {
        new ArrayList();
        ae aeVar = new ae();
        List<com.baidu.tieba.card.data.c> p = aeVar.p(list, list2);
        boolean bJj = aeVar.bJj();
        if (!x.isEmpty(p)) {
            if (com.baidu.tbadk.a.d.bmE()) {
                com.baidu.tbadk.core.util.f.a.bwU().m(R.color.CAM_X0601, R.color.CAM_X0606).ae(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).bz(this.fjL);
            }
            this.fjF.setVisibility(8);
            this.fjG.setVisibility(8);
            this.fjH.setVisibility(8);
            this.fjL.setVisibility(8);
            int size = p.size() > 3 ? 3 : p.size();
            for (int i = 0; i < size; i++) {
                if (p.get(i) instanceof PbLinkData) {
                    PbLinkData pbLinkData = (PbLinkData) p.get(i);
                    if (i < p.size() && pbLinkData != null) {
                        this.fjO.get(i).setVisibility(0);
                        this.fjP.get(i).startLoad(pbLinkData.picUrl, 10, false);
                        if (pbLinkData.urlType == 2 && !TextUtils.isEmpty(pbLinkData.linkFrom)) {
                            this.fjQ.get(i).setText(pbLinkData.linkFrom);
                            this.fjQ.get(i).setVisibility(0);
                        }
                    }
                } else if (p.get(i) instanceof PbGoodsData) {
                    PbGoodsData pbGoodsData = (PbGoodsData) p.get(i);
                    if (i < p.size() && pbGoodsData != null) {
                        this.fjO.get(i).setVisibility(0);
                        this.fjP.get(i).startLoad(pbGoodsData.picUrl, 10, false);
                    }
                }
                if (p.size() > 3 && i == 2) {
                    this.fjL.setText(getContext().getString(R.string.constrain_image_extra_text, Integer.valueOf(p.size() - 3)));
                    this.fjL.setVisibility(0);
                }
            }
            this.fjM.setText(getContext().getString(bJj ? R.string.multi_goods_count : R.string.multi_link_count, Integer.valueOf(p.size())));
        }
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this, R.drawable.bg_link_card);
        ao.setViewTextColor(this.fjM, R.color.CAM_X0107);
        SvgManager.bwq().a(this.fjN, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        for (int i = 0; i < this.fjQ.size(); i++) {
            ao.setViewTextColor(this.fjQ.get(i), R.color.CAM_X0101);
            com.baidu.tbadk.core.util.f.a.bwU().qq(0).qr(R.color.cp_link_tip_d_alpha66).ai(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).ah(UtilHelper.getDimenPixelSize(R.dimen.tbds10)).ag(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).af(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).bz(this.fjQ.get(i));
        }
    }
}

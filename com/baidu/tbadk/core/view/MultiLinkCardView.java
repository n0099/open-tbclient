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
    private TextView eFA;
    private ImageView eFB;
    private List<RelativeLayout> eFC;
    private List<TbImageView> eFD;
    private List<TextView> eFE;
    private TextView eFq;
    private TextView eFr;
    private TextView eFs;
    private RelativeLayout eFt;
    private RelativeLayout eFu;
    private RelativeLayout eFv;
    private TbImageView eFw;
    private TbImageView eFx;
    private TbImageView eFy;
    private TextView eFz;
    private static final int eFp = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds136);
    private static final int beM = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);

    public MultiLinkCardView(Context context) {
        this(context, null);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.multi_link_card_layout, this);
        this.eFt = (RelativeLayout) findViewById(R.id.rl_multi_link_first);
        this.eFu = (RelativeLayout) findViewById(R.id.rl_multi_link_second);
        this.eFv = (RelativeLayout) findViewById(R.id.rl_multi_link_third);
        this.eFq = (TextView) findViewById(R.id.goods_from_tag_first);
        this.eFr = (TextView) findViewById(R.id.goods_from_tag_second);
        this.eFs = (TextView) findViewById(R.id.goods_from_tag_third);
        this.eFw = (TbImageView) findViewById(R.id.iv_multi_link_first_icon);
        this.eFw.setDrawCorner(true);
        this.eFw.setGifIconSupport(false);
        this.eFw.setLongIconSupport(false);
        this.eFw.setConrers(15);
        this.eFw.setPlaceHolder(2);
        this.eFw.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.eFx = (TbImageView) findViewById(R.id.iv_multi_link_second_icon);
        this.eFx.setDrawCorner(true);
        this.eFx.setGifIconSupport(false);
        this.eFx.setLongIconSupport(false);
        this.eFx.setConrers(15);
        this.eFx.setPlaceHolder(2);
        this.eFx.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.eFy = (TbImageView) findViewById(R.id.iv_multi_link_third_icon);
        this.eFy.setDrawCorner(true);
        this.eFy.setGifIconSupport(false);
        this.eFy.setLongIconSupport(false);
        this.eFy.setPlaceHolder(2);
        this.eFy.setConrers(15);
        this.eFy.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.eFz = (TextView) findViewById(R.id.tv_multi_link_more_link_count);
        this.eFA = (TextView) findViewById(R.id.tv_multi_link_count);
        this.eFB = (ImageView) findViewById(R.id.iv_multi_link_right_arrow);
        this.eFE = new ArrayList();
        this.eFD = new ArrayList();
        this.eFC = new ArrayList();
        this.eFC.add(this.eFt);
        this.eFC.add(this.eFu);
        this.eFC.add(this.eFv);
        this.eFD.add(this.eFw);
        this.eFD.add(this.eFx);
        this.eFD.add(this.eFy);
        this.eFE.add(this.eFq);
        this.eFE.add(this.eFr);
        this.eFE.add(this.eFs);
        onChangeSkinType();
    }

    public void i(List<PbLinkData> list, List<PbGoodsData> list2) {
        new ArrayList();
        ag agVar = new ag();
        List<com.baidu.tieba.card.data.d> k = agVar.k(list, list2);
        boolean bzE = agVar.bzE();
        if (!y.isEmpty(k)) {
            if (com.baidu.tbadk.a.d.bdB()) {
                com.baidu.tbadk.core.util.e.a.bnv().i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha42).X(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).bf(this.eFz);
            }
            this.eFt.setVisibility(8);
            this.eFu.setVisibility(8);
            this.eFv.setVisibility(8);
            this.eFz.setVisibility(8);
            int size = k.size() > 3 ? 3 : k.size();
            for (int i = 0; i < size; i++) {
                if (k.get(i) instanceof PbLinkData) {
                    PbLinkData pbLinkData = (PbLinkData) k.get(i);
                    if (i < k.size() && pbLinkData != null) {
                        this.eFC.get(i).setVisibility(0);
                        this.eFD.get(i).startLoad(pbLinkData.picUrl, 10, false);
                        if (pbLinkData.urlType == 2 && !TextUtils.isEmpty(pbLinkData.linkFrom)) {
                            this.eFE.get(i).setText(pbLinkData.linkFrom);
                            this.eFE.get(i).setVisibility(0);
                        }
                    }
                } else if (k.get(i) instanceof PbGoodsData) {
                    PbGoodsData pbGoodsData = (PbGoodsData) k.get(i);
                    if (i < k.size() && pbGoodsData != null) {
                        this.eFC.get(i).setVisibility(0);
                        this.eFD.get(i).startLoad(pbGoodsData.picUrl, 10, false);
                    }
                }
                if (k.size() > 3 && i == 2) {
                    this.eFz.setText(getContext().getString(R.string.constrain_image_extra_text, Integer.valueOf(k.size() - 3)));
                    this.eFz.setVisibility(0);
                }
            }
            this.eFA.setText(getContext().getString(bzE ? R.string.multi_goods_count : R.string.multi_link_count, Integer.valueOf(k.size())));
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.bg_link_card);
        ap.setViewTextColor(this.eFA, R.color.cp_cont_j);
        SvgManager.bmU().a(this.eFB, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        for (int i = 0; i < this.eFE.size(); i++) {
            ap.setViewTextColor(this.eFE.get(i), R.color.cp_cont_a);
            com.baidu.tbadk.core.util.e.a.bnv().oO(0).oP(R.color.cp_link_tip_d_alpha66).ab(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).aa(UtilHelper.getDimenPixelSize(R.dimen.tbds10)).Z(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).Y(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).bf(this.eFE.get(i));
        }
    }
}

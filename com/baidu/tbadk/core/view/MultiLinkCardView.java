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
/* loaded from: classes2.dex */
public class MultiLinkCardView extends RelativeLayout {
    private TextView eqW;
    private TextView eqX;
    private TextView eqY;
    private RelativeLayout eqZ;
    private RelativeLayout era;
    private RelativeLayout erb;
    private TbImageView erc;
    private TbImageView erd;
    private TbImageView ere;
    private TextView erf;
    private TextView erg;
    private ImageView erh;
    private List<RelativeLayout> eri;
    private List<TbImageView> erj;
    private List<TextView> erk;
    private static final int eqV = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds136);
    private static final int aYD = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);

    public MultiLinkCardView(Context context) {
        this(context, null);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.multi_link_card_layout, this);
        this.eqZ = (RelativeLayout) findViewById(R.id.rl_multi_link_first);
        this.era = (RelativeLayout) findViewById(R.id.rl_multi_link_second);
        this.erb = (RelativeLayout) findViewById(R.id.rl_multi_link_third);
        this.eqW = (TextView) findViewById(R.id.goods_from_tag_first);
        this.eqX = (TextView) findViewById(R.id.goods_from_tag_second);
        this.eqY = (TextView) findViewById(R.id.goods_from_tag_third);
        this.erc = (TbImageView) findViewById(R.id.iv_multi_link_first_icon);
        this.erc.setDrawCorner(true);
        this.erc.setGifIconSupport(false);
        this.erc.setLongIconSupport(false);
        this.erc.setConrers(15);
        this.erc.setPlaceHolder(2);
        this.erc.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.erd = (TbImageView) findViewById(R.id.iv_multi_link_second_icon);
        this.erd.setDrawCorner(true);
        this.erd.setGifIconSupport(false);
        this.erd.setLongIconSupport(false);
        this.erd.setConrers(15);
        this.erd.setPlaceHolder(2);
        this.erd.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.ere = (TbImageView) findViewById(R.id.iv_multi_link_third_icon);
        this.ere.setDrawCorner(true);
        this.ere.setGifIconSupport(false);
        this.ere.setLongIconSupport(false);
        this.ere.setPlaceHolder(2);
        this.ere.setConrers(15);
        this.ere.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.erf = (TextView) findViewById(R.id.tv_multi_link_more_link_count);
        this.erg = (TextView) findViewById(R.id.tv_multi_link_count);
        this.erh = (ImageView) findViewById(R.id.iv_multi_link_right_arrow);
        this.erk = new ArrayList();
        this.erj = new ArrayList();
        this.eri = new ArrayList();
        this.eri.add(this.eqZ);
        this.eri.add(this.era);
        this.eri.add(this.erb);
        this.erj.add(this.erc);
        this.erj.add(this.erd);
        this.erj.add(this.ere);
        this.erk.add(this.eqW);
        this.erk.add(this.eqX);
        this.erk.add(this.eqY);
        onChangeSkinType();
    }

    public void h(List<PbLinkData> list, List<PbGoodsData> list2) {
        new ArrayList();
        af afVar = new af();
        List<com.baidu.tieba.card.data.d> j = afVar.j(list, list2);
        boolean bvK = afVar.bvK();
        if (!y.isEmpty(j)) {
            if (com.baidu.tbadk.a.d.bad()) {
                com.baidu.tbadk.core.util.e.a.bjQ().i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha42).V(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).aZ(this.erf);
            }
            this.eqZ.setVisibility(8);
            this.era.setVisibility(8);
            this.erb.setVisibility(8);
            this.erf.setVisibility(8);
            int size = j.size() > 3 ? 3 : j.size();
            for (int i = 0; i < size; i++) {
                if (j.get(i) instanceof PbLinkData) {
                    PbLinkData pbLinkData = (PbLinkData) j.get(i);
                    if (i < j.size() && pbLinkData != null) {
                        this.eri.get(i).setVisibility(0);
                        this.erj.get(i).startLoad(pbLinkData.picUrl, 10, false);
                        if (pbLinkData.urlType == 2 && !TextUtils.isEmpty(pbLinkData.linkFrom)) {
                            this.erk.get(i).setText(pbLinkData.linkFrom);
                            this.erk.get(i).setVisibility(0);
                        }
                    }
                } else if (j.get(i) instanceof PbGoodsData) {
                    PbGoodsData pbGoodsData = (PbGoodsData) j.get(i);
                    if (i < j.size() && pbGoodsData != null) {
                        this.eri.get(i).setVisibility(0);
                        this.erj.get(i).startLoad(pbGoodsData.picUrl, 10, false);
                    }
                }
                if (j.size() > 3 && i == 2) {
                    this.erf.setText(getContext().getString(R.string.constrain_image_extra_text, Integer.valueOf(j.size() - 3)));
                    this.erf.setVisibility(0);
                }
            }
            this.erg.setText(getContext().getString(bvK ? R.string.multi_goods_count : R.string.multi_link_count, Integer.valueOf(j.size())));
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.bg_link_card);
        ap.setViewTextColor(this.erg, R.color.cp_cont_j);
        SvgManager.bjq().a(this.erh, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        for (int i = 0; i < this.erk.size(); i++) {
            ap.setViewTextColor(this.erk.get(i), R.color.cp_cont_a);
            com.baidu.tbadk.core.util.e.a.bjQ().oe(0).of(R.color.cp_link_tip_d_alpha66).Z(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).Y(UtilHelper.getDimenPixelSize(R.dimen.tbds10)).X(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).W(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).aZ(this.erk.get(i));
        }
    }
}

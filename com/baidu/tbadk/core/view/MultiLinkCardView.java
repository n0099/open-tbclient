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
    private TextView era;
    private TextView erb;
    private TextView erc;
    private RelativeLayout erd;
    private RelativeLayout ere;
    private RelativeLayout erf;
    private TbImageView erg;
    private TbImageView erh;
    private TbImageView eri;
    private TextView erj;
    private TextView erk;
    private ImageView erl;
    private List<RelativeLayout> erm;
    private List<TbImageView> ern;
    private List<TextView> ero;
    private static final int eqZ = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds136);
    private static final int aYF = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);

    public MultiLinkCardView(Context context) {
        this(context, null);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.multi_link_card_layout, this);
        this.erd = (RelativeLayout) findViewById(R.id.rl_multi_link_first);
        this.ere = (RelativeLayout) findViewById(R.id.rl_multi_link_second);
        this.erf = (RelativeLayout) findViewById(R.id.rl_multi_link_third);
        this.era = (TextView) findViewById(R.id.goods_from_tag_first);
        this.erb = (TextView) findViewById(R.id.goods_from_tag_second);
        this.erc = (TextView) findViewById(R.id.goods_from_tag_third);
        this.erg = (TbImageView) findViewById(R.id.iv_multi_link_first_icon);
        this.erg.setDrawCorner(true);
        this.erg.setGifIconSupport(false);
        this.erg.setLongIconSupport(false);
        this.erg.setConrers(15);
        this.erg.setPlaceHolder(2);
        this.erg.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.erh = (TbImageView) findViewById(R.id.iv_multi_link_second_icon);
        this.erh.setDrawCorner(true);
        this.erh.setGifIconSupport(false);
        this.erh.setLongIconSupport(false);
        this.erh.setConrers(15);
        this.erh.setPlaceHolder(2);
        this.erh.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.eri = (TbImageView) findViewById(R.id.iv_multi_link_third_icon);
        this.eri.setDrawCorner(true);
        this.eri.setGifIconSupport(false);
        this.eri.setLongIconSupport(false);
        this.eri.setPlaceHolder(2);
        this.eri.setConrers(15);
        this.eri.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.erj = (TextView) findViewById(R.id.tv_multi_link_more_link_count);
        this.erk = (TextView) findViewById(R.id.tv_multi_link_count);
        this.erl = (ImageView) findViewById(R.id.iv_multi_link_right_arrow);
        this.ero = new ArrayList();
        this.ern = new ArrayList();
        this.erm = new ArrayList();
        this.erm.add(this.erd);
        this.erm.add(this.ere);
        this.erm.add(this.erf);
        this.ern.add(this.erg);
        this.ern.add(this.erh);
        this.ern.add(this.eri);
        this.ero.add(this.era);
        this.ero.add(this.erb);
        this.ero.add(this.erc);
        onChangeSkinType();
    }

    public void h(List<PbLinkData> list, List<PbGoodsData> list2) {
        new ArrayList();
        af afVar = new af();
        List<com.baidu.tieba.card.data.d> j = afVar.j(list, list2);
        boolean bvL = afVar.bvL();
        if (!y.isEmpty(j)) {
            if (com.baidu.tbadk.a.d.bad()) {
                com.baidu.tbadk.core.util.e.a.bjQ().i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha42).V(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).aZ(this.erj);
            }
            this.erd.setVisibility(8);
            this.ere.setVisibility(8);
            this.erf.setVisibility(8);
            this.erj.setVisibility(8);
            int size = j.size() > 3 ? 3 : j.size();
            for (int i = 0; i < size; i++) {
                if (j.get(i) instanceof PbLinkData) {
                    PbLinkData pbLinkData = (PbLinkData) j.get(i);
                    if (i < j.size() && pbLinkData != null) {
                        this.erm.get(i).setVisibility(0);
                        this.ern.get(i).startLoad(pbLinkData.picUrl, 10, false);
                        if (pbLinkData.urlType == 2 && !TextUtils.isEmpty(pbLinkData.linkFrom)) {
                            this.ero.get(i).setText(pbLinkData.linkFrom);
                            this.ero.get(i).setVisibility(0);
                        }
                    }
                } else if (j.get(i) instanceof PbGoodsData) {
                    PbGoodsData pbGoodsData = (PbGoodsData) j.get(i);
                    if (i < j.size() && pbGoodsData != null) {
                        this.erm.get(i).setVisibility(0);
                        this.ern.get(i).startLoad(pbGoodsData.picUrl, 10, false);
                    }
                }
                if (j.size() > 3 && i == 2) {
                    this.erj.setText(getContext().getString(R.string.constrain_image_extra_text, Integer.valueOf(j.size() - 3)));
                    this.erj.setVisibility(0);
                }
            }
            this.erk.setText(getContext().getString(bvL ? R.string.multi_goods_count : R.string.multi_link_count, Integer.valueOf(j.size())));
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.bg_link_card);
        ap.setViewTextColor(this.erk, R.color.cp_cont_j);
        SvgManager.bjq().a(this.erl, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        for (int i = 0; i < this.ero.size(); i++) {
            ap.setViewTextColor(this.ero.get(i), R.color.cp_cont_a);
            com.baidu.tbadk.core.util.e.a.bjQ().oe(0).of(R.color.cp_link_tip_d_alpha66).Z(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).Y(UtilHelper.getDimenPixelSize(R.dimen.tbds10)).X(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).W(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).aZ(this.ero.get(i));
        }
    }
}

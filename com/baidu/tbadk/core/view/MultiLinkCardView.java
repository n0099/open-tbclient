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
    private TextView eZY;
    private TextView eZZ;
    private TextView faa;
    private RelativeLayout fab;
    private RelativeLayout fac;
    private RelativeLayout fad;
    private TbImageView fae;
    private TbImageView faf;
    private TbImageView fag;
    private TextView fah;
    private TextView fai;
    private ImageView faj;
    private List<RelativeLayout> fak;
    private List<TbImageView> fal;
    private List<TextView> fam;
    private static final int eZX = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds136);
    private static final int bka = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);

    public MultiLinkCardView(Context context) {
        this(context, null);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.multi_link_card_layout, this);
        this.fab = (RelativeLayout) findViewById(R.id.rl_multi_link_first);
        this.fac = (RelativeLayout) findViewById(R.id.rl_multi_link_second);
        this.fad = (RelativeLayout) findViewById(R.id.rl_multi_link_third);
        this.eZY = (TextView) findViewById(R.id.goods_from_tag_first);
        this.eZZ = (TextView) findViewById(R.id.goods_from_tag_second);
        this.faa = (TextView) findViewById(R.id.goods_from_tag_third);
        this.fae = (TbImageView) findViewById(R.id.iv_multi_link_first_icon);
        this.fae.setDrawCorner(true);
        this.fae.setGifIconSupport(false);
        this.fae.setLongIconSupport(false);
        this.fae.setConrers(15);
        this.fae.setPlaceHolder(1);
        this.fae.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.faf = (TbImageView) findViewById(R.id.iv_multi_link_second_icon);
        this.faf.setDrawCorner(true);
        this.faf.setGifIconSupport(false);
        this.faf.setLongIconSupport(false);
        this.faf.setConrers(15);
        this.faf.setPlaceHolder(1);
        this.faf.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.fag = (TbImageView) findViewById(R.id.iv_multi_link_third_icon);
        this.fag.setDrawCorner(true);
        this.fag.setGifIconSupport(false);
        this.fag.setLongIconSupport(false);
        this.fag.setPlaceHolder(1);
        this.fag.setConrers(15);
        this.fag.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.fah = (TextView) findViewById(R.id.tv_multi_link_more_link_count);
        float[] ph = com.baidu.tbadk.core.elementsMaven.a.ph(R.array.S_O_X001);
        this.fah.setShadowLayer(ph[1], ph[2], ph[3], (int) ph[0]);
        this.fai = (TextView) findViewById(R.id.tv_multi_link_count);
        this.faj = (ImageView) findViewById(R.id.iv_multi_link_right_arrow);
        this.fam = new ArrayList();
        this.fal = new ArrayList();
        this.fak = new ArrayList();
        this.fak.add(this.fab);
        this.fak.add(this.fac);
        this.fak.add(this.fad);
        this.fal.add(this.fae);
        this.fal.add(this.faf);
        this.fal.add(this.fag);
        this.fam.add(this.eZY);
        this.fam.add(this.eZZ);
        this.fam.add(this.faa);
        onChangeSkinType();
    }

    public void l(List<PbLinkData> list, List<PbGoodsData> list2) {
        new ArrayList();
        af afVar = new af();
        List<com.baidu.tieba.card.data.c> n = afVar.n(list, list2);
        boolean bGQ = afVar.bGQ();
        if (!y.isEmpty(n)) {
            if (com.baidu.tbadk.a.d.bkq()) {
                com.baidu.tbadk.core.util.e.a.buz().l(R.color.CAM_X0601, R.color.CAM_X0606).ac(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).bq(this.fah);
            }
            this.fab.setVisibility(8);
            this.fac.setVisibility(8);
            this.fad.setVisibility(8);
            this.fah.setVisibility(8);
            int size = n.size() > 3 ? 3 : n.size();
            for (int i = 0; i < size; i++) {
                if (n.get(i) instanceof PbLinkData) {
                    PbLinkData pbLinkData = (PbLinkData) n.get(i);
                    if (i < n.size() && pbLinkData != null) {
                        this.fak.get(i).setVisibility(0);
                        this.fal.get(i).startLoad(pbLinkData.picUrl, 10, false);
                        if (pbLinkData.urlType == 2 && !TextUtils.isEmpty(pbLinkData.linkFrom)) {
                            this.fam.get(i).setText(pbLinkData.linkFrom);
                            this.fam.get(i).setVisibility(0);
                        }
                    }
                } else if (n.get(i) instanceof PbGoodsData) {
                    PbGoodsData pbGoodsData = (PbGoodsData) n.get(i);
                    if (i < n.size() && pbGoodsData != null) {
                        this.fak.get(i).setVisibility(0);
                        this.fal.get(i).startLoad(pbGoodsData.picUrl, 10, false);
                    }
                }
                if (n.size() > 3 && i == 2) {
                    this.fah.setText(getContext().getString(R.string.constrain_image_extra_text, Integer.valueOf(n.size() - 3)));
                    this.fah.setVisibility(0);
                }
            }
            this.fai.setText(getContext().getString(bGQ ? R.string.multi_goods_count : R.string.multi_link_count, Integer.valueOf(n.size())));
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.bg_link_card);
        ap.setViewTextColor(this.fai, R.color.CAM_X0107);
        SvgManager.btW().a(this.faj, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        for (int i = 0; i < this.fam.size(); i++) {
            ap.setViewTextColor(this.fam.get(i), R.color.CAM_X0101);
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qg(R.color.cp_link_tip_d_alpha66).ag(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).af(UtilHelper.getDimenPixelSize(R.dimen.tbds10)).ae(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).ad(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).bq(this.fam.get(i));
        }
    }
}

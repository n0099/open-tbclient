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
    private TextView etg;
    private TextView eth;
    private TextView eti;
    private RelativeLayout etj;
    private RelativeLayout etk;
    private RelativeLayout etl;
    private TbImageView etm;
    private TbImageView etn;
    private TbImageView eto;
    private TextView etp;
    private TextView etq;
    private ImageView etr;
    private List<RelativeLayout> ets;
    private List<TbImageView> ett;
    private List<TextView> etu;
    private static final int etf = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds136);
    private static final int bbc = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);

    public MultiLinkCardView(Context context) {
        this(context, null);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.multi_link_card_layout, this);
        this.etj = (RelativeLayout) findViewById(R.id.rl_multi_link_first);
        this.etk = (RelativeLayout) findViewById(R.id.rl_multi_link_second);
        this.etl = (RelativeLayout) findViewById(R.id.rl_multi_link_third);
        this.etg = (TextView) findViewById(R.id.goods_from_tag_first);
        this.eth = (TextView) findViewById(R.id.goods_from_tag_second);
        this.eti = (TextView) findViewById(R.id.goods_from_tag_third);
        this.etm = (TbImageView) findViewById(R.id.iv_multi_link_first_icon);
        this.etm.setDrawCorner(true);
        this.etm.setGifIconSupport(false);
        this.etm.setLongIconSupport(false);
        this.etm.setConrers(15);
        this.etm.setPlaceHolder(2);
        this.etm.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.etn = (TbImageView) findViewById(R.id.iv_multi_link_second_icon);
        this.etn.setDrawCorner(true);
        this.etn.setGifIconSupport(false);
        this.etn.setLongIconSupport(false);
        this.etn.setConrers(15);
        this.etn.setPlaceHolder(2);
        this.etn.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.eto = (TbImageView) findViewById(R.id.iv_multi_link_third_icon);
        this.eto.setDrawCorner(true);
        this.eto.setGifIconSupport(false);
        this.eto.setLongIconSupport(false);
        this.eto.setPlaceHolder(2);
        this.eto.setConrers(15);
        this.eto.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.etp = (TextView) findViewById(R.id.tv_multi_link_more_link_count);
        this.etq = (TextView) findViewById(R.id.tv_multi_link_count);
        this.etr = (ImageView) findViewById(R.id.iv_multi_link_right_arrow);
        this.etu = new ArrayList();
        this.ett = new ArrayList();
        this.ets = new ArrayList();
        this.ets.add(this.etj);
        this.ets.add(this.etk);
        this.ets.add(this.etl);
        this.ett.add(this.etm);
        this.ett.add(this.etn);
        this.ett.add(this.eto);
        this.etu.add(this.etg);
        this.etu.add(this.eth);
        this.etu.add(this.eti);
        onChangeSkinType();
    }

    public void i(List<PbLinkData> list, List<PbGoodsData> list2) {
        new ArrayList();
        ag agVar = new ag();
        List<com.baidu.tieba.card.data.d> k = agVar.k(list, list2);
        boolean bwU = agVar.bwU();
        if (!y.isEmpty(k)) {
            if (com.baidu.tbadk.a.d.baT()) {
                com.baidu.tbadk.core.util.e.a.bkL().i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha42).V(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).bb(this.etp);
            }
            this.etj.setVisibility(8);
            this.etk.setVisibility(8);
            this.etl.setVisibility(8);
            this.etp.setVisibility(8);
            int size = k.size() > 3 ? 3 : k.size();
            for (int i = 0; i < size; i++) {
                if (k.get(i) instanceof PbLinkData) {
                    PbLinkData pbLinkData = (PbLinkData) k.get(i);
                    if (i < k.size() && pbLinkData != null) {
                        this.ets.get(i).setVisibility(0);
                        this.ett.get(i).startLoad(pbLinkData.picUrl, 10, false);
                        if (pbLinkData.urlType == 2 && !TextUtils.isEmpty(pbLinkData.linkFrom)) {
                            this.etu.get(i).setText(pbLinkData.linkFrom);
                            this.etu.get(i).setVisibility(0);
                        }
                    }
                } else if (k.get(i) instanceof PbGoodsData) {
                    PbGoodsData pbGoodsData = (PbGoodsData) k.get(i);
                    if (i < k.size() && pbGoodsData != null) {
                        this.ets.get(i).setVisibility(0);
                        this.ett.get(i).startLoad(pbGoodsData.picUrl, 10, false);
                    }
                }
                if (k.size() > 3 && i == 2) {
                    this.etp.setText(getContext().getString(R.string.constrain_image_extra_text, Integer.valueOf(k.size() - 3)));
                    this.etp.setVisibility(0);
                }
            }
            this.etq.setText(getContext().getString(bwU ? R.string.multi_goods_count : R.string.multi_link_count, Integer.valueOf(k.size())));
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.bg_link_card);
        ap.setViewTextColor(this.etq, R.color.cp_cont_j);
        SvgManager.bkl().a(this.etr, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        for (int i = 0; i < this.etu.size(); i++) {
            ap.setViewTextColor(this.etu.get(i), R.color.cp_cont_a);
            com.baidu.tbadk.core.util.e.a.bkL().oq(0).or(R.color.cp_link_tip_d_alpha66).Z(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).Y(UtilHelper.getDimenPixelSize(R.dimen.tbds10)).X(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).W(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).bb(this.etu.get(i));
        }
    }
}

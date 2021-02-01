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
    private TextView fhh;
    private TextView fhi;
    private TextView fhj;
    private RelativeLayout fhk;
    private RelativeLayout fhl;
    private RelativeLayout fhm;
    private TbImageView fhn;
    private TbImageView fho;
    private TbImageView fhp;
    private TextView fhq;
    private TextView fhr;
    private ImageView fhs;
    private List<RelativeLayout> fht;
    private List<TbImageView> fhu;
    private List<TextView> fhv;
    private static final int fhg = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds136);
    private static final int bkg = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);

    public MultiLinkCardView(Context context) {
        this(context, null);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.multi_link_card_layout, this);
        this.fhk = (RelativeLayout) findViewById(R.id.rl_multi_link_first);
        this.fhl = (RelativeLayout) findViewById(R.id.rl_multi_link_second);
        this.fhm = (RelativeLayout) findViewById(R.id.rl_multi_link_third);
        this.fhh = (TextView) findViewById(R.id.goods_from_tag_first);
        this.fhi = (TextView) findViewById(R.id.goods_from_tag_second);
        this.fhj = (TextView) findViewById(R.id.goods_from_tag_third);
        this.fhn = (TbImageView) findViewById(R.id.iv_multi_link_first_icon);
        this.fhn.setDrawCorner(true);
        this.fhn.setGifIconSupport(false);
        this.fhn.setLongIconSupport(false);
        this.fhn.setConrers(15);
        this.fhn.setPlaceHolder(1);
        this.fhn.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.fho = (TbImageView) findViewById(R.id.iv_multi_link_second_icon);
        this.fho.setDrawCorner(true);
        this.fho.setGifIconSupport(false);
        this.fho.setLongIconSupport(false);
        this.fho.setConrers(15);
        this.fho.setPlaceHolder(1);
        this.fho.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.fhp = (TbImageView) findViewById(R.id.iv_multi_link_third_icon);
        this.fhp.setDrawCorner(true);
        this.fhp.setGifIconSupport(false);
        this.fhp.setLongIconSupport(false);
        this.fhp.setPlaceHolder(1);
        this.fhp.setConrers(15);
        this.fhp.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.fhq = (TextView) findViewById(R.id.tv_multi_link_more_link_count);
        com.baidu.tbadk.core.elementsMaven.c.br(this.fhq).oi(R.array.S_O_X001);
        this.fhr = (TextView) findViewById(R.id.tv_multi_link_count);
        this.fhs = (ImageView) findViewById(R.id.iv_multi_link_right_arrow);
        this.fhv = new ArrayList();
        this.fhu = new ArrayList();
        this.fht = new ArrayList();
        this.fht.add(this.fhk);
        this.fht.add(this.fhl);
        this.fht.add(this.fhm);
        this.fhu.add(this.fhn);
        this.fhu.add(this.fho);
        this.fhu.add(this.fhp);
        this.fhv.add(this.fhh);
        this.fhv.add(this.fhi);
        this.fhv.add(this.fhj);
        onChangeSkinType();
    }

    public void m(List<PbLinkData> list, List<PbGoodsData> list2) {
        new ArrayList();
        ah ahVar = new ah();
        List<com.baidu.tieba.card.data.c> o = ahVar.o(list, list2);
        boolean bFM = ahVar.bFM();
        if (!y.isEmpty(o)) {
            if (com.baidu.tbadk.a.d.biX()) {
                com.baidu.tbadk.core.util.f.a.btv().m(R.color.CAM_X0601, R.color.CAM_X0606).af(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).bv(this.fhq);
            }
            this.fhk.setVisibility(8);
            this.fhl.setVisibility(8);
            this.fhm.setVisibility(8);
            this.fhq.setVisibility(8);
            int size = o.size() > 3 ? 3 : o.size();
            for (int i = 0; i < size; i++) {
                if (o.get(i) instanceof PbLinkData) {
                    PbLinkData pbLinkData = (PbLinkData) o.get(i);
                    if (i < o.size() && pbLinkData != null) {
                        this.fht.get(i).setVisibility(0);
                        this.fhu.get(i).startLoad(pbLinkData.picUrl, 10, false);
                        if (pbLinkData.urlType == 2 && !TextUtils.isEmpty(pbLinkData.linkFrom)) {
                            this.fhv.get(i).setText(pbLinkData.linkFrom);
                            this.fhv.get(i).setVisibility(0);
                        }
                    }
                } else if (o.get(i) instanceof PbGoodsData) {
                    PbGoodsData pbGoodsData = (PbGoodsData) o.get(i);
                    if (i < o.size() && pbGoodsData != null) {
                        this.fht.get(i).setVisibility(0);
                        this.fhu.get(i).startLoad(pbGoodsData.picUrl, 10, false);
                    }
                }
                if (o.size() > 3 && i == 2) {
                    this.fhq.setText(getContext().getString(R.string.constrain_image_extra_text, Integer.valueOf(o.size() - 3)));
                    this.fhq.setVisibility(0);
                }
            }
            this.fhr.setText(getContext().getString(bFM ? R.string.multi_goods_count : R.string.multi_link_count, Integer.valueOf(o.size())));
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.bg_link_card);
        ap.setViewTextColor(this.fhr, R.color.CAM_X0107);
        SvgManager.bsR().a(this.fhs, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        for (int i = 0; i < this.fhv.size(); i++) {
            ap.setViewTextColor(this.fhv.get(i), R.color.CAM_X0101);
            com.baidu.tbadk.core.util.f.a.btv().oO(0).oP(R.color.cp_link_tip_d_alpha66).aj(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).ai(UtilHelper.getDimenPixelSize(R.dimen.tbds10)).ah(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).ag(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).bv(this.fhv.get(i));
        }
    }
}

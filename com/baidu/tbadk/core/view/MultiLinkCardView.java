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
    private TextView eTB;
    private TextView eTC;
    private TextView eTD;
    private RelativeLayout eTE;
    private RelativeLayout eTF;
    private RelativeLayout eTG;
    private TbImageView eTH;
    private TbImageView eTI;
    private TbImageView eTJ;
    private TextView eTK;
    private TextView eTL;
    private ImageView eTM;
    private List<RelativeLayout> eTN;
    private List<TbImageView> eTO;
    private List<TextView> eTP;
    private static final int eTA = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds136);
    private static final int bhw = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);

    public MultiLinkCardView(Context context) {
        this(context, null);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiLinkCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.multi_link_card_layout, this);
        this.eTE = (RelativeLayout) findViewById(R.id.rl_multi_link_first);
        this.eTF = (RelativeLayout) findViewById(R.id.rl_multi_link_second);
        this.eTG = (RelativeLayout) findViewById(R.id.rl_multi_link_third);
        this.eTB = (TextView) findViewById(R.id.goods_from_tag_first);
        this.eTC = (TextView) findViewById(R.id.goods_from_tag_second);
        this.eTD = (TextView) findViewById(R.id.goods_from_tag_third);
        this.eTH = (TbImageView) findViewById(R.id.iv_multi_link_first_icon);
        this.eTH.setDrawCorner(true);
        this.eTH.setGifIconSupport(false);
        this.eTH.setLongIconSupport(false);
        this.eTH.setConrers(15);
        this.eTH.setPlaceHolder(2);
        this.eTH.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.eTI = (TbImageView) findViewById(R.id.iv_multi_link_second_icon);
        this.eTI.setDrawCorner(true);
        this.eTI.setGifIconSupport(false);
        this.eTI.setLongIconSupport(false);
        this.eTI.setConrers(15);
        this.eTI.setPlaceHolder(2);
        this.eTI.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.eTJ = (TbImageView) findViewById(R.id.iv_multi_link_third_icon);
        this.eTJ.setDrawCorner(true);
        this.eTJ.setGifIconSupport(false);
        this.eTJ.setLongIconSupport(false);
        this.eTJ.setPlaceHolder(2);
        this.eTJ.setConrers(15);
        this.eTJ.setRadius(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10));
        this.eTK = (TextView) findViewById(R.id.tv_multi_link_more_link_count);
        this.eTL = (TextView) findViewById(R.id.tv_multi_link_count);
        this.eTM = (ImageView) findViewById(R.id.iv_multi_link_right_arrow);
        this.eTP = new ArrayList();
        this.eTO = new ArrayList();
        this.eTN = new ArrayList();
        this.eTN.add(this.eTE);
        this.eTN.add(this.eTF);
        this.eTN.add(this.eTG);
        this.eTO.add(this.eTH);
        this.eTO.add(this.eTI);
        this.eTO.add(this.eTJ);
        this.eTP.add(this.eTB);
        this.eTP.add(this.eTC);
        this.eTP.add(this.eTD);
        onChangeSkinType();
    }

    public void l(List<PbLinkData> list, List<PbGoodsData> list2) {
        new ArrayList();
        ag agVar = new ag();
        List<com.baidu.tieba.card.data.d> n = agVar.n(list, list2);
        boolean bDW = agVar.bDW();
        if (!y.isEmpty(n)) {
            if (com.baidu.tbadk.a.d.bhU()) {
                com.baidu.tbadk.core.util.e.a.brO().i(R.color.cp_mask_b_alpha0, R.color.cp_mask_b_alpha42).ab(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).bk(this.eTK);
            }
            this.eTE.setVisibility(8);
            this.eTF.setVisibility(8);
            this.eTG.setVisibility(8);
            this.eTK.setVisibility(8);
            int size = n.size() > 3 ? 3 : n.size();
            for (int i = 0; i < size; i++) {
                if (n.get(i) instanceof PbLinkData) {
                    PbLinkData pbLinkData = (PbLinkData) n.get(i);
                    if (i < n.size() && pbLinkData != null) {
                        this.eTN.get(i).setVisibility(0);
                        this.eTO.get(i).startLoad(pbLinkData.picUrl, 10, false);
                        if (pbLinkData.urlType == 2 && !TextUtils.isEmpty(pbLinkData.linkFrom)) {
                            this.eTP.get(i).setText(pbLinkData.linkFrom);
                            this.eTP.get(i).setVisibility(0);
                        }
                    }
                } else if (n.get(i) instanceof PbGoodsData) {
                    PbGoodsData pbGoodsData = (PbGoodsData) n.get(i);
                    if (i < n.size() && pbGoodsData != null) {
                        this.eTN.get(i).setVisibility(0);
                        this.eTO.get(i).startLoad(pbGoodsData.picUrl, 10, false);
                    }
                }
                if (n.size() > 3 && i == 2) {
                    this.eTK.setText(getContext().getString(R.string.constrain_image_extra_text, Integer.valueOf(n.size() - 3)));
                    this.eTK.setVisibility(0);
                }
            }
            this.eTL.setText(getContext().getString(bDW ? R.string.multi_goods_count : R.string.multi_link_count, Integer.valueOf(n.size())));
        }
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this, R.drawable.bg_link_card);
        ap.setViewTextColor(this.eTL, R.color.cp_cont_j);
        SvgManager.brn().a(this.eTM, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        for (int i = 0; i < this.eTP.size(); i++) {
            ap.setViewTextColor(this.eTP.get(i), R.color.cp_cont_a);
            com.baidu.tbadk.core.util.e.a.brO().pj(0).pk(R.color.cp_link_tip_d_alpha66).af(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).ae(UtilHelper.getDimenPixelSize(R.dimen.tbds10)).ad(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).ac(UtilHelper.getDimenPixelSize(R.dimen.tbds5)).bk(this.eTP.get(i));
        }
    }
}

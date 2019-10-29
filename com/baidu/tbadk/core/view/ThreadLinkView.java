package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView crG;
    private TextView crH;
    private TextView crI;
    private TextView crJ;
    private ViewGroup crK;
    private View crL;
    private Context mContext;
    private BdUniqueId mTag;

    public ThreadLinkView(Context context) {
        super(context);
        init(context);
    }

    public ThreadLinkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ThreadLinkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.link_thread_item, (ViewGroup) this, true);
        this.crK = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.crG = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.crG.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.crG.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.crH = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.crI = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.crJ = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.crL = inflate.findViewById(R.id.link_thread_content);
        this.crG.setLongIconSupport(false);
        this.crG.setGifIconSupport(false);
        this.crG.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds20));
        this.crG.setConrers(5);
        aY(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bh bhVar) {
        if (bhVar == null || bhVar.ake() == null || aq.isEmpty(bhVar.ake().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        af ake = bhVar.ake();
        if (!ake.ahq() && ake.ahp() != af.bZH) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.crG.setPageId(this.mTag);
        if (ake.ahq()) {
            this.crJ.setVisibility(0);
            this.crH.setVisibility(8);
            this.crI.setVisibility(8);
            this.crJ.setText(ake.getLinkUrl());
            this.crG.reset();
        } else {
            this.crJ.setVisibility(8);
            String ahm = ake.ahm();
            String ahn = ake.ahn();
            if (!aq.isEmpty(ahm)) {
                this.crH.setText(ahm);
                this.crH.setVisibility(0);
                this.crI.setVisibility(8);
            } else {
                this.crH.setVisibility(8);
                if (!aq.isEmpty(ahn)) {
                    this.crI.setText(ahn);
                    this.crI.setVisibility(0);
                } else {
                    this.crI.setVisibility(4);
                }
            }
            if (!aq.isEmpty(ake.aho())) {
                this.crG.startLoad(ake.aho(), 10, false);
            } else {
                this.crG.reset();
            }
        }
        oB(bhVar.getId());
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.crL, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.crG, R.drawable.shape_link_thread_head_bg);
    }

    public void oB(String str) {
        com.baidu.tieba.card.n.a(this.crH, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.n.a(this.crJ, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.n.a(this.crI, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
    }

    private void aY(View view) {
        if (this.crK != null && this.crG != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.crK.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.crK.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.crG.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.crG.setLayoutParams(layoutParams2);
        }
    }
}

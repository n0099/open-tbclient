package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView dIS;
    private TextView dIT;
    private TextView dIU;
    private TextView dIV;
    private ViewGroup dIW;
    private View dIX;
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
        this.dIW = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.dIS = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.dIS.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.dIS.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.dIT = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.dIU = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.dIV = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.dIX = inflate.findViewById(R.id.link_thread_content);
        this.dIS.setLongIconSupport(false);
        this.dIS.setGifIconSupport(false);
        this.dIS.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.dIS.setConrers(5);
        ba(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bj bjVar) {
        if (bjVar == null || bjVar.aMf() == null || aq.isEmpty(bjVar.aMf().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ag aMf = bjVar.aMf();
        if (!aMf.aJh() && aMf.aJg() != ag.doJ) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.dIS.setPageId(this.mTag);
        if (aMf.aJh()) {
            this.dIV.setVisibility(0);
            this.dIT.setVisibility(8);
            this.dIU.setVisibility(8);
            this.dIV.setText(aMf.getLinkUrl());
            this.dIS.reset();
        } else {
            this.dIV.setVisibility(8);
            String aJd = aMf.aJd();
            String aJe = aMf.aJe();
            if (!aq.isEmpty(aJd)) {
                this.dIT.setText(aJd);
                this.dIT.setVisibility(0);
                this.dIU.setVisibility(8);
            } else {
                this.dIT.setVisibility(8);
                if (!aq.isEmpty(aJe)) {
                    this.dIU.setText(aJe);
                    this.dIU.setVisibility(0);
                } else {
                    this.dIU.setVisibility(4);
                }
            }
            if (!aq.isEmpty(aMf.aJf())) {
                this.dIS.startLoad(aMf.aJf(), 10, false);
            } else {
                this.dIS.reset();
            }
        }
        vn(bjVar.getId());
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.dIX, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.dIS, R.drawable.shape_link_thread_head_bg);
    }

    public void vn(String str) {
        com.baidu.tieba.card.l.a(this.dIT, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(this.dIV, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(this.dIU, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
    }

    private void ba(View view) {
        if (this.dIW != null && this.dIS != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.dIW.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.dIW.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.dIS.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.dIS.setLayoutParams(layoutParams2);
        }
    }
}

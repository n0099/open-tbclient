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
    private TbImageView dIW;
    private TextView dIX;
    private TextView dIY;
    private TextView dIZ;
    private ViewGroup dJa;
    private View dJb;
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
        this.dJa = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.dIW = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.dIW.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.dIW.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.dIX = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.dIY = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.dIZ = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.dJb = inflate.findViewById(R.id.link_thread_content);
        this.dIW.setLongIconSupport(false);
        this.dIW.setGifIconSupport(false);
        this.dIW.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.dIW.setConrers(5);
        ba(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bj bjVar) {
        if (bjVar == null || bjVar.aMd() == null || aq.isEmpty(bjVar.aMd().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ag aMd = bjVar.aMd();
        if (!aMd.aJf() && aMd.aJe() != ag.doN) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.dIW.setPageId(this.mTag);
        if (aMd.aJf()) {
            this.dIZ.setVisibility(0);
            this.dIX.setVisibility(8);
            this.dIY.setVisibility(8);
            this.dIZ.setText(aMd.getLinkUrl());
            this.dIW.reset();
        } else {
            this.dIZ.setVisibility(8);
            String aJb = aMd.aJb();
            String aJc = aMd.aJc();
            if (!aq.isEmpty(aJb)) {
                this.dIX.setText(aJb);
                this.dIX.setVisibility(0);
                this.dIY.setVisibility(8);
            } else {
                this.dIX.setVisibility(8);
                if (!aq.isEmpty(aJc)) {
                    this.dIY.setText(aJc);
                    this.dIY.setVisibility(0);
                } else {
                    this.dIY.setVisibility(4);
                }
            }
            if (!aq.isEmpty(aMd.aJd())) {
                this.dIW.startLoad(aMd.aJd(), 10, false);
            } else {
                this.dIW.reset();
            }
        }
        vq(bjVar.getId());
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.dJb, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.dIW, R.drawable.shape_link_thread_head_bg);
    }

    public void vq(String str) {
        com.baidu.tieba.card.l.a(this.dIX, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(this.dIZ, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(this.dIY, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
    }

    private void ba(View view) {
        if (this.dJa != null && this.dIW != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.dJa.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.dJa.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.dIW.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.dIW.setLayoutParams(layoutParams2);
        }
    }
}

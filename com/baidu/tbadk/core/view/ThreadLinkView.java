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
    private TbImageView cqO;
    private TextView cqP;
    private TextView cqQ;
    private TextView cqR;
    private ViewGroup cqS;
    private View cqT;
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
        this.cqS = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.cqO = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.cqO.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.cqO.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.cqP = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.cqQ = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.cqR = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.cqT = inflate.findViewById(R.id.link_thread_content);
        this.cqO.setLongIconSupport(false);
        this.cqO.setGifIconSupport(false);
        this.cqO.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds20));
        this.cqO.setConrers(5);
        aY(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bh bhVar) {
        if (bhVar == null || bhVar.akc() == null || aq.isEmpty(bhVar.akc().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        af akc = bhVar.akc();
        if (!akc.aho() && akc.ahn() != af.bYQ) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.cqO.setPageId(this.mTag);
        if (akc.aho()) {
            this.cqR.setVisibility(0);
            this.cqP.setVisibility(8);
            this.cqQ.setVisibility(8);
            this.cqR.setText(akc.getLinkUrl());
            this.cqO.reset();
        } else {
            this.cqR.setVisibility(8);
            String ahk = akc.ahk();
            String ahl = akc.ahl();
            if (!aq.isEmpty(ahk)) {
                this.cqP.setText(ahk);
                this.cqP.setVisibility(0);
                this.cqQ.setVisibility(8);
            } else {
                this.cqP.setVisibility(8);
                if (!aq.isEmpty(ahl)) {
                    this.cqQ.setText(ahl);
                    this.cqQ.setVisibility(0);
                } else {
                    this.cqQ.setVisibility(4);
                }
            }
            if (!aq.isEmpty(akc.ahm())) {
                this.cqO.startLoad(akc.ahm(), 10, false);
            } else {
                this.cqO.reset();
            }
        }
        oB(bhVar.getId());
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.cqT, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.cqO, R.drawable.shape_link_thread_head_bg);
    }

    public void oB(String str) {
        com.baidu.tieba.card.n.a(this.cqP, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.n.a(this.cqR, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.n.a(this.cqQ, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
    }

    private void aY(View view) {
        if (this.cqS != null && this.cqO != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.cqS.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.cqS.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.cqO.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.cqO.setLayoutParams(layoutParams2);
        }
    }
}

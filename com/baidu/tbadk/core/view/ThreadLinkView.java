package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.o;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView axH;
    private TextView axI;
    private TextView axJ;
    private TextView axK;
    private ViewGroup axL;
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
        View inflate = LayoutInflater.from(context).inflate(d.i.link_thread_item, (ViewGroup) this, true);
        this.axL = (ViewGroup) inflate.findViewById(d.g.root_layout);
        this.axH = (TbImageView) inflate.findViewById(d.g.link_thread_head_img);
        this.axH.setDefaultBgResource(d.f.icon_card_url_n);
        this.axH.setDefaultErrorResource(d.f.icon_card_url_n);
        this.axI = (TextView) inflate.findViewById(d.g.link_thread_title);
        this.axJ = (TextView) inflate.findViewById(d.g.link_thread_abstract);
        this.axK = (TextView) inflate.findViewById(d.g.link_thread_url);
        this.axH.setLongIconSupport(false);
        this.axH.setGifIconSupport(false);
        J(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bd bdVar) {
        if (bdVar == null || bdVar.wz() == null || ao.isEmpty(bdVar.wz().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ae wz = bdVar.wz();
        if (!wz.un() && wz.um() != ae.agw) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.axH.setPageId(this.mTag);
        if (wz.un()) {
            this.axK.setVisibility(0);
            this.axI.setVisibility(8);
            this.axJ.setVisibility(8);
            this.axK.setText(wz.getLinkUrl());
            this.axH.reset();
        } else {
            this.axK.setVisibility(8);
            String uj = wz.uj();
            String uk = wz.uk();
            if (!ao.isEmpty(uj)) {
                this.axI.setText(uj);
                this.axI.setVisibility(0);
                this.axJ.setVisibility(8);
            } else {
                this.axI.setVisibility(8);
                if (!ao.isEmpty(uk)) {
                    this.axJ.setText(uk);
                    this.axJ.setVisibility(0);
                } else {
                    this.axJ.setVisibility(4);
                }
            }
            if (!ao.isEmpty(wz.ul())) {
                this.axH.startLoad(wz.ul(), 10, false);
            } else {
                this.axH.reset();
            }
        }
        fn(bdVar.getId());
    }

    public void onChangeSkinType() {
        al.j(this, d.C0141d.cp_bg_line_e);
        al.j(this.axH, d.C0141d.cp_bg_line_b);
    }

    public void fn(String str) {
        o.a(this.axI, str, d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
        o.a(this.axK, str, d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
        o.a(this.axJ, str, d.C0141d.cp_cont_j, d.C0141d.cp_cont_d);
    }

    private void J(View view) {
        if (this.axL != null && this.axH != null) {
            int ah = ((com.baidu.adp.lib.util.l.ah(this.mContext) - (com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds44) * 2)) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds120)) / 5;
            ViewGroup.LayoutParams layoutParams = this.axL.getLayoutParams();
            layoutParams.height = ah;
            this.axL.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.axH.getLayoutParams();
            layoutParams2.width = ah;
            layoutParams2.height = ah;
            this.axH.setLayoutParams(layoutParams2);
        }
    }
}

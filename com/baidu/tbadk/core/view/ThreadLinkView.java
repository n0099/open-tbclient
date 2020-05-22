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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView dXl;
    private TextView dXm;
    private TextView dXn;
    private TextView dXo;
    private ViewGroup dXp;
    private View dXq;
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
        this.dXp = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.dXl = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.dXl.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.dXl.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.dXm = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.dXn = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.dXo = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.dXq = inflate.findViewById(R.id.link_thread_content);
        this.dXl.setLongIconSupport(false);
        this.dXl.setGifIconSupport(false);
        this.dXl.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.dXl.setConrers(5);
        bb(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bk bkVar) {
        if (bkVar == null || bkVar.aSc() == null || aq.isEmpty(bkVar.aSc().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        af aSc = bkVar.aSc();
        if (!aSc.aPa() && aSc.aOZ() != af.dCM) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.dXl.setPageId(this.mTag);
        if (aSc.aPa()) {
            this.dXo.setVisibility(0);
            this.dXm.setVisibility(8);
            this.dXn.setVisibility(8);
            this.dXo.setText(aSc.getLinkUrl());
            this.dXl.reset();
        } else {
            this.dXo.setVisibility(8);
            String aOW = aSc.aOW();
            String aOX = aSc.aOX();
            if (!aq.isEmpty(aOW)) {
                this.dXm.setText(aOW);
                this.dXm.setVisibility(0);
                this.dXn.setVisibility(8);
            } else {
                this.dXm.setVisibility(8);
                if (!aq.isEmpty(aOX)) {
                    this.dXn.setText(aOX);
                    this.dXn.setVisibility(0);
                } else {
                    this.dXn.setVisibility(4);
                }
            }
            if (!aq.isEmpty(aSc.aOY())) {
                this.dXl.startLoad(aSc.aOY(), 10, false);
            } else {
                this.dXl.reset();
            }
        }
        wW(bkVar.getId());
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.dXq, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.dXl, R.drawable.shape_link_thread_head_bg);
    }

    public void wW(String str) {
        m.a(this.dXm, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        m.a(this.dXo, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        m.a(this.dXn, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
    }

    private void bb(View view) {
        if (this.dXp != null && this.dXl != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.dXp.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.dXp.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.dXl.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.dXl.setLayoutParams(layoutParams2);
        }
    }
}

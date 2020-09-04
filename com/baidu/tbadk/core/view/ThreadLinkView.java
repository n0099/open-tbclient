package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView euQ;
    private TextView euR;
    private TextView euS;
    private TextView euT;
    private ViewGroup euU;
    private View euV;
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
        this.euU = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.euQ = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.euQ.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.euQ.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.euR = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.euS = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.euT = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.euV = inflate.findViewById(R.id.link_thread_content);
        this.euQ.setLongIconSupport(false);
        this.euQ.setGifIconSupport(false);
        this.euQ.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.euQ.setConrers(5);
        bj(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bw bwVar) {
        if (bwVar == null || bwVar.bgi() == null || at.isEmpty(bwVar.bgi().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        am bgi = bwVar.bgi();
        if (!bgi.bda() && bgi.bcZ() != am.dYP) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.euQ.setPageId(this.mTag);
        if (bgi.bda()) {
            this.euT.setVisibility(0);
            this.euR.setVisibility(8);
            this.euS.setVisibility(8);
            this.euT.setText(bgi.getLinkUrl());
            this.euQ.reset();
        } else {
            this.euT.setVisibility(8);
            String bcW = bgi.bcW();
            String bcX = bgi.bcX();
            if (!at.isEmpty(bcW)) {
                this.euR.setText(bcW);
                this.euR.setVisibility(0);
                this.euS.setVisibility(8);
            } else {
                this.euR.setVisibility(8);
                if (!at.isEmpty(bcX)) {
                    this.euS.setText(bcX);
                    this.euS.setVisibility(0);
                } else {
                    this.euS.setVisibility(4);
                }
            }
            if (!at.isEmpty(bgi.bcY())) {
                this.euQ.startLoad(bgi.bcY(), 10, false);
            } else {
                this.euQ.reset();
            }
        }
        AH(bwVar.getId());
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.euV, R.color.cp_bg_line_e);
        ap.setBackgroundResource(this.euQ, R.drawable.shape_link_thread_head_bg);
    }

    public void AH(String str) {
        m.a(this.euR, str, R.color.cp_cont_j, R.color.cp_cont_d);
        m.a(this.euT, str, R.color.cp_cont_j, R.color.cp_cont_d);
        m.a(this.euS, str, R.color.cp_cont_j, R.color.cp_cont_d);
    }

    private void bj(View view) {
        if (this.euU != null && this.euQ != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.euU.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.euU.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.euQ.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.euQ.setLayoutParams(layoutParams2);
        }
    }
}

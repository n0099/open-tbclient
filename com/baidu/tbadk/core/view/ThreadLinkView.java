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
import com.baidu.tieba.card.n;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView eRA;
    private TextView eRB;
    private TextView eRC;
    private TextView eRD;
    private ViewGroup eRE;
    private View eRF;
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
        this.eRE = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.eRA = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.eRA.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.eRA.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.eRB = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.eRC = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.eRD = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.eRF = inflate.findViewById(R.id.link_thread_content);
        this.eRA.setLongIconSupport(false);
        this.eRA.setGifIconSupport(false);
        this.eRA.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.eRA.setConrers(5);
        bq(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bw bwVar) {
        if (bwVar == null || bwVar.blE() == null || at.isEmpty(bwVar.blE().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        am blE = bwVar.blE();
        if (!blE.biw() && blE.biv() != am.evB) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.eRA.setPageId(this.mTag);
        if (blE.biw()) {
            this.eRD.setVisibility(0);
            this.eRB.setVisibility(8);
            this.eRC.setVisibility(8);
            this.eRD.setText(blE.getLinkUrl());
            this.eRA.reset();
        } else {
            this.eRD.setVisibility(8);
            String bis = blE.bis();
            String bit = blE.bit();
            if (!at.isEmpty(bis)) {
                this.eRB.setText(bis);
                this.eRB.setVisibility(0);
                this.eRC.setVisibility(8);
            } else {
                this.eRB.setVisibility(8);
                if (!at.isEmpty(bit)) {
                    this.eRC.setText(bit);
                    this.eRC.setVisibility(0);
                } else {
                    this.eRC.setVisibility(4);
                }
            }
            if (!at.isEmpty(blE.biu())) {
                this.eRA.startLoad(blE.biu(), 10, false);
            } else {
                this.eRA.reset();
            }
        }
        Ci(bwVar.getId());
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.eRF, R.color.cp_bg_line_e);
        ap.setBackgroundResource(this.eRA, R.drawable.shape_link_thread_head_bg);
    }

    public void Ci(String str) {
        n.a(this.eRB, str, R.color.cp_cont_j, R.color.cp_cont_d);
        n.a(this.eRD, str, R.color.cp_cont_j, R.color.cp_cont_d);
        n.a(this.eRC, str, R.color.cp_cont_j, R.color.cp_cont_d);
    }

    private void bq(View view) {
        if (this.eRE != null && this.eRA != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.eRE.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.eRE.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.eRA.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.eRA.setLayoutParams(layoutParams2);
        }
    }
}

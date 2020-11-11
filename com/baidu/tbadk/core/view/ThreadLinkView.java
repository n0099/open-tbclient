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
    private TbImageView eXp;
    private TextView eXq;
    private TextView eXr;
    private TextView eXs;
    private ViewGroup eXt;
    private View eXu;
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
        this.eXt = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.eXp = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.eXp.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.eXp.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.eXq = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.eXr = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.eXs = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.eXu = inflate.findViewById(R.id.link_thread_content);
        this.eXp.setLongIconSupport(false);
        this.eXp.setGifIconSupport(false);
        this.eXp.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.eXp.setConrers(5);
        bu(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bw bwVar) {
        if (bwVar == null || bwVar.boe() == null || at.isEmpty(bwVar.boe().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        am boe = bwVar.boe();
        if (!boe.bkW() && boe.bkV() != am.eBu) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.eXp.setPageId(this.mTag);
        if (boe.bkW()) {
            this.eXs.setVisibility(0);
            this.eXq.setVisibility(8);
            this.eXr.setVisibility(8);
            this.eXs.setText(boe.getLinkUrl());
            this.eXp.reset();
        } else {
            this.eXs.setVisibility(8);
            String bkS = boe.bkS();
            String bkT = boe.bkT();
            if (!at.isEmpty(bkS)) {
                this.eXq.setText(bkS);
                this.eXq.setVisibility(0);
                this.eXr.setVisibility(8);
            } else {
                this.eXq.setVisibility(8);
                if (!at.isEmpty(bkT)) {
                    this.eXr.setText(bkT);
                    this.eXr.setVisibility(0);
                } else {
                    this.eXr.setVisibility(4);
                }
            }
            if (!at.isEmpty(boe.bkU())) {
                this.eXp.startLoad(boe.bkU(), 10, false);
            } else {
                this.eXp.reset();
            }
        }
        Cw(bwVar.getId());
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.eXu, R.color.cp_bg_line_e);
        ap.setBackgroundResource(this.eXp, R.drawable.shape_link_thread_head_bg);
    }

    public void Cw(String str) {
        n.a(this.eXq, str, R.color.cp_cont_j, R.color.cp_cont_d);
        n.a(this.eXs, str, R.color.cp_cont_j, R.color.cp_cont_d);
        n.a(this.eXr, str, R.color.cp_cont_j, R.color.cp_cont_d);
    }

    private void bu(View view) {
        if (this.eXt != null && this.eXp != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.eXt.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.eXt.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.eXp.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.eXp.setLayoutParams(layoutParams2);
        }
    }
}

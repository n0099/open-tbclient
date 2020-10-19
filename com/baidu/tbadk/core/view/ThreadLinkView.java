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
    private TbImageView eJe;
    private TextView eJf;
    private TextView eJg;
    private TextView eJh;
    private ViewGroup eJi;
    private View eJj;
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
        this.eJi = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.eJe = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.eJe.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.eJe.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.eJf = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.eJg = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.eJh = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.eJj = inflate.findViewById(R.id.link_thread_content);
        this.eJe.setLongIconSupport(false);
        this.eJe.setGifIconSupport(false);
        this.eJe.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.eJe.setConrers(5);
        bp(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bw bwVar) {
        if (bwVar == null || bwVar.bjL() == null || at.isEmpty(bwVar.bjL().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        am bjL = bwVar.bjL();
        if (!bjL.bgD() && bjL.bgC() != am.enb) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.eJe.setPageId(this.mTag);
        if (bjL.bgD()) {
            this.eJh.setVisibility(0);
            this.eJf.setVisibility(8);
            this.eJg.setVisibility(8);
            this.eJh.setText(bjL.getLinkUrl());
            this.eJe.reset();
        } else {
            this.eJh.setVisibility(8);
            String bgz = bjL.bgz();
            String bgA = bjL.bgA();
            if (!at.isEmpty(bgz)) {
                this.eJf.setText(bgz);
                this.eJf.setVisibility(0);
                this.eJg.setVisibility(8);
            } else {
                this.eJf.setVisibility(8);
                if (!at.isEmpty(bgA)) {
                    this.eJg.setText(bgA);
                    this.eJg.setVisibility(0);
                } else {
                    this.eJg.setVisibility(4);
                }
            }
            if (!at.isEmpty(bjL.bgB())) {
                this.eJe.startLoad(bjL.bgB(), 10, false);
            } else {
                this.eJe.reset();
            }
        }
        BP(bwVar.getId());
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.eJj, R.color.cp_bg_line_e);
        ap.setBackgroundResource(this.eJe, R.drawable.shape_link_thread_head_bg);
    }

    public void BP(String str) {
        m.a(this.eJf, str, R.color.cp_cont_j, R.color.cp_cont_d);
        m.a(this.eJh, str, R.color.cp_cont_j, R.color.cp_cont_d);
        m.a(this.eJg, str, R.color.cp_cont_j, R.color.cp_cont_d);
    }

    private void bp(View view) {
        if (this.eJi != null && this.eJe != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.eJi.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.eJi.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.eJe.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.eJe.setLayoutParams(layoutParams2);
        }
    }
}

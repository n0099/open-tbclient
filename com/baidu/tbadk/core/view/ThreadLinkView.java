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
/* loaded from: classes2.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView euM;
    private TextView euN;
    private TextView euO;
    private TextView euP;
    private ViewGroup euQ;
    private View euR;
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
        this.euQ = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.euM = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.euM.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.euM.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.euN = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.euO = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.euP = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.euR = inflate.findViewById(R.id.link_thread_content);
        this.euM.setLongIconSupport(false);
        this.euM.setGifIconSupport(false);
        this.euM.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.euM.setConrers(5);
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
        if (!bgi.bda() && bgi.bcZ() != am.dYL) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.euM.setPageId(this.mTag);
        if (bgi.bda()) {
            this.euP.setVisibility(0);
            this.euN.setVisibility(8);
            this.euO.setVisibility(8);
            this.euP.setText(bgi.getLinkUrl());
            this.euM.reset();
        } else {
            this.euP.setVisibility(8);
            String bcW = bgi.bcW();
            String bcX = bgi.bcX();
            if (!at.isEmpty(bcW)) {
                this.euN.setText(bcW);
                this.euN.setVisibility(0);
                this.euO.setVisibility(8);
            } else {
                this.euN.setVisibility(8);
                if (!at.isEmpty(bcX)) {
                    this.euO.setText(bcX);
                    this.euO.setVisibility(0);
                } else {
                    this.euO.setVisibility(4);
                }
            }
            if (!at.isEmpty(bgi.bcY())) {
                this.euM.startLoad(bgi.bcY(), 10, false);
            } else {
                this.euM.reset();
            }
        }
        AG(bwVar.getId());
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.euR, R.color.cp_bg_line_e);
        ap.setBackgroundResource(this.euM, R.drawable.shape_link_thread_head_bg);
    }

    public void AG(String str) {
        m.a(this.euN, str, R.color.cp_cont_j, R.color.cp_cont_d);
        m.a(this.euP, str, R.color.cp_cont_j, R.color.cp_cont_d);
        m.a(this.euO, str, R.color.cp_cont_j, R.color.cp_cont_d);
    }

    private void bj(View view) {
        if (this.euQ != null && this.euM != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.euQ.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.euQ.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.euM.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.euM.setLayoutParams(layoutParams2);
        }
    }
}

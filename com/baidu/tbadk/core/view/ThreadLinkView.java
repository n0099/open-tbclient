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
    private TbImageView ewU;
    private TextView ewV;
    private TextView ewW;
    private TextView ewX;
    private ViewGroup ewY;
    private View ewZ;
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
        this.ewY = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.ewU = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.ewU.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.ewU.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.ewV = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.ewW = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.ewX = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.ewZ = inflate.findViewById(R.id.link_thread_content);
        this.ewU.setLongIconSupport(false);
        this.ewU.setGifIconSupport(false);
        this.ewU.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.ewU.setConrers(5);
        bl(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bw bwVar) {
        if (bwVar == null || bwVar.bhc() == null || at.isEmpty(bwVar.bhc().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        am bhc = bwVar.bhc();
        if (!bhc.bdU() && bhc.bdT() != am.eaZ) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.ewU.setPageId(this.mTag);
        if (bhc.bdU()) {
            this.ewX.setVisibility(0);
            this.ewV.setVisibility(8);
            this.ewW.setVisibility(8);
            this.ewX.setText(bhc.getLinkUrl());
            this.ewU.reset();
        } else {
            this.ewX.setVisibility(8);
            String bdQ = bhc.bdQ();
            String bdR = bhc.bdR();
            if (!at.isEmpty(bdQ)) {
                this.ewV.setText(bdQ);
                this.ewV.setVisibility(0);
                this.ewW.setVisibility(8);
            } else {
                this.ewV.setVisibility(8);
                if (!at.isEmpty(bdR)) {
                    this.ewW.setText(bdR);
                    this.ewW.setVisibility(0);
                } else {
                    this.ewW.setVisibility(4);
                }
            }
            if (!at.isEmpty(bhc.bdS())) {
                this.ewU.startLoad(bhc.bdS(), 10, false);
            } else {
                this.ewU.reset();
            }
        }
        Bd(bwVar.getId());
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.ewZ, R.color.cp_bg_line_e);
        ap.setBackgroundResource(this.ewU, R.drawable.shape_link_thread_head_bg);
    }

    public void Bd(String str) {
        m.a(this.ewV, str, R.color.cp_cont_j, R.color.cp_cont_d);
        m.a(this.ewX, str, R.color.cp_cont_j, R.color.cp_cont_d);
        m.a(this.ewW, str, R.color.cp_cont_j, R.color.cp_cont_d);
    }

    private void bl(View view) {
        if (this.ewY != null && this.ewU != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.ewY.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.ewY.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.ewU.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.ewU.setLayoutParams(layoutParams2);
        }
    }
}

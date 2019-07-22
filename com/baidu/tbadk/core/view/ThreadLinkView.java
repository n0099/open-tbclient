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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView ccr;
    private TextView cct;
    private TextView ccu;
    private TextView ccv;
    private ViewGroup ccw;
    private View ccx;
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
        this.ccw = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.ccr = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.ccr.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.ccr.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.cct = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.ccu = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.ccv = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.ccx = inflate.findViewById(R.id.link_thread_content);
        this.ccr.setLongIconSupport(false);
        this.ccr.setGifIconSupport(false);
        this.ccr.setRadius(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds20));
        this.ccr.setConrers(5);
        aY(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bg bgVar) {
        if (bgVar == null || bgVar.afW() == null || aq.isEmpty(bgVar.afW().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        af afW = bgVar.afW();
        if (!afW.adf() && afW.ade() != af.bHx) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.ccr.setPageId(this.mTag);
        if (afW.adf()) {
            this.ccv.setVisibility(0);
            this.cct.setVisibility(8);
            this.ccu.setVisibility(8);
            this.ccv.setText(afW.getLinkUrl());
            this.ccr.reset();
        } else {
            this.ccv.setVisibility(8);
            String adb = afW.adb();
            String adc = afW.adc();
            if (!aq.isEmpty(adb)) {
                this.cct.setText(adb);
                this.cct.setVisibility(0);
                this.ccu.setVisibility(8);
            } else {
                this.cct.setVisibility(8);
                if (!aq.isEmpty(adc)) {
                    this.ccu.setText(adc);
                    this.ccu.setVisibility(0);
                } else {
                    this.ccu.setVisibility(4);
                }
            }
            if (!aq.isEmpty(afW.add())) {
                this.ccr.startLoad(afW.add(), 10, false);
            } else {
                this.ccr.reset();
            }
        }
        oU(bgVar.getId());
    }

    public void onChangeSkinType() {
        am.l(this.ccx, R.color.cp_bg_line_e);
        am.k(this.ccr, R.drawable.shape_link_thread_head_bg);
    }

    public void oU(String str) {
        com.baidu.tieba.card.n.a(this.cct, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.n.a(this.ccv, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.n.a(this.ccu, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
    }

    private void aY(View view) {
        if (this.ccw != null && this.ccr != null) {
            int af = (((com.baidu.adp.lib.util.l.af(this.mContext) - (com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.ccw.getLayoutParams();
            layoutParams.height = af;
            this.ccw.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.ccr.getLayoutParams();
            layoutParams2.width = af;
            layoutParams2.height = af;
            this.ccr.setLayoutParams(layoutParams2);
        }
    }
}

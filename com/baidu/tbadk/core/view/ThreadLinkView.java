package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView flk;
    private TextView fll;
    private TextView flm;
    private TextView fln;
    private ViewGroup flo;
    private View flp;
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
        this.flo = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.flk = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.flk.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.fll = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.flm = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.fln = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.flp = inflate.findViewById(R.id.link_thread_content);
        this.flk.setLongIconSupport(false);
        this.flk.setGifIconSupport(false);
        this.flk.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.flk.setConrers(5);
        bF(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(cb cbVar) {
        if (cbVar == null || cbVar.bpw() == null || au.isEmpty(cbVar.bpw().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ap bpw = cbVar.bpw();
        if (!bpw.bmj() && bpw.bmi() != ap.eOa) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.flk.setPageId(this.mTag);
        if (bpw.bmj()) {
            this.fln.setVisibility(0);
            this.fll.setVisibility(8);
            this.flm.setVisibility(8);
            this.fln.setText(bpw.getLinkUrl());
            this.flk.reset();
        } else {
            this.fln.setVisibility(8);
            String bmf = bpw.bmf();
            String bmg = bpw.bmg();
            if (!au.isEmpty(bmf)) {
                this.fll.setText(bmf);
                this.fll.setVisibility(0);
                this.flm.setVisibility(8);
            } else {
                this.fll.setVisibility(8);
                if (!au.isEmpty(bmg)) {
                    this.flm.setText(bmg);
                    this.flm.setVisibility(0);
                } else {
                    this.flm.setVisibility(4);
                }
            }
            if (!au.isEmpty(bpw.bmh())) {
                this.flk.startLoad(bpw.bmh(), 10, false);
            } else {
                this.flk.reset();
            }
        }
        BG(cbVar.getId());
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.flp, R.color.CAM_X0205);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.flk, R.drawable.shape_link_thread_head_bg);
    }

    public void BG(String str) {
        m.a(this.fll, str, R.color.CAM_X0107, R.color.CAM_X0109);
        m.a(this.fln, str, R.color.CAM_X0107, R.color.CAM_X0109);
        m.a(this.flm, str, R.color.CAM_X0107, R.color.CAM_X0109);
    }

    private void bF(View view) {
        if (this.flo != null && this.flk != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.flo.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.flo.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.flk.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.flk.setLayoutParams(layoutParams2);
        }
    }
}

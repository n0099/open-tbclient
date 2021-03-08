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
    private TbImageView fmK;
    private TextView fmL;
    private TextView fmM;
    private TextView fmN;
    private ViewGroup fmO;
    private View fmP;
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
        this.fmO = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.fmK = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.fmK.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.fmL = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.fmM = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.fmN = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.fmP = inflate.findViewById(R.id.link_thread_content);
        this.fmK.setLongIconSupport(false);
        this.fmK.setGifIconSupport(false);
        this.fmK.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.fmK.setConrers(5);
        bF(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(cb cbVar) {
        if (cbVar == null || cbVar.bpy() == null || au.isEmpty(cbVar.bpy().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ap bpy = cbVar.bpy();
        if (!bpy.bml() && bpy.bmk() != ap.ePB) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.fmK.setPageId(this.mTag);
        if (bpy.bml()) {
            this.fmN.setVisibility(0);
            this.fmL.setVisibility(8);
            this.fmM.setVisibility(8);
            this.fmN.setText(bpy.getLinkUrl());
            this.fmK.reset();
        } else {
            this.fmN.setVisibility(8);
            String bmh = bpy.bmh();
            String bmi = bpy.bmi();
            if (!au.isEmpty(bmh)) {
                this.fmL.setText(bmh);
                this.fmL.setVisibility(0);
                this.fmM.setVisibility(8);
            } else {
                this.fmL.setVisibility(8);
                if (!au.isEmpty(bmi)) {
                    this.fmM.setText(bmi);
                    this.fmM.setVisibility(0);
                } else {
                    this.fmM.setVisibility(4);
                }
            }
            if (!au.isEmpty(bpy.bmj())) {
                this.fmK.startLoad(bpy.bmj(), 10, false);
            } else {
                this.fmK.reset();
            }
        }
        BN(cbVar.getId());
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.ap.setBackgroundColor(this.fmP, R.color.CAM_X0205);
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.fmK, R.drawable.shape_link_thread_head_bg);
    }

    public void BN(String str) {
        m.a(this.fmL, str, R.color.CAM_X0107, R.color.CAM_X0109);
        m.a(this.fmN, str, R.color.CAM_X0107, R.color.CAM_X0109);
        m.a(this.fmM, str, R.color.CAM_X0107, R.color.CAM_X0109);
    }

    private void bF(View view) {
        if (this.fmO != null && this.fmK != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.fmO.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.fmO.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.fmK.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.fmK.setLayoutParams(layoutParams2);
        }
    }
}

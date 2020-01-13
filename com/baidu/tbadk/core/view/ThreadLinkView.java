package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ThreadLinkView extends RelativeLayout {
    private TbImageView der;
    private TextView det;
    private TextView deu;
    private TextView dev;
    private ViewGroup dew;
    private View dex;
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
        this.dew = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.der = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.der.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.der.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.det = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.deu = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.dev = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.dex = inflate.findViewById(R.id.link_thread_content);
        this.der.setLongIconSupport(false);
        this.der.setGifIconSupport(false);
        this.der.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.der.setConrers(5);
        aZ(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bj bjVar) {
        if (bjVar == null || bjVar.aBy() == null || aq.isEmpty(bjVar.aBy().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ag aBy = bjVar.aBy();
        if (!aBy.ayB() && aBy.ayA() != ag.cLl) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.der.setPageId(this.mTag);
        if (aBy.ayB()) {
            this.dev.setVisibility(0);
            this.det.setVisibility(8);
            this.deu.setVisibility(8);
            this.dev.setText(aBy.getLinkUrl());
            this.der.reset();
        } else {
            this.dev.setVisibility(8);
            String ayx = aBy.ayx();
            String ayy = aBy.ayy();
            if (!aq.isEmpty(ayx)) {
                this.det.setText(ayx);
                this.det.setVisibility(0);
                this.deu.setVisibility(8);
            } else {
                this.det.setVisibility(8);
                if (!aq.isEmpty(ayy)) {
                    this.deu.setText(ayy);
                    this.deu.setVisibility(0);
                } else {
                    this.deu.setVisibility(4);
                }
            }
            if (!aq.isEmpty(aBy.ayz())) {
                this.der.startLoad(aBy.ayz(), 10, false);
            } else {
                this.der.reset();
            }
        }
        tJ(bjVar.getId());
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.dex, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.der, R.drawable.shape_link_thread_head_bg);
    }

    public void tJ(String str) {
        com.baidu.tieba.card.l.a(this.det, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(this.dev, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(this.deu, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
    }

    private void aZ(View view) {
        if (this.dew != null && this.der != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.dew.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.dew.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.der.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.der.setLayoutParams(layoutParams2);
        }
    }
}

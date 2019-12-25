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
    private TbImageView deh;
    private TextView dei;
    private TextView dej;
    private TextView dek;
    private ViewGroup del;
    private View dem;
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
        this.del = (ViewGroup) inflate.findViewById(R.id.root_layout);
        this.deh = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
        this.deh.setDefaultBgResource(R.drawable.icon_card_url_n);
        this.deh.setDefaultErrorResource(R.drawable.icon_card_url_n);
        this.dei = (TextView) inflate.findViewById(R.id.link_thread_title);
        this.dej = (TextView) inflate.findViewById(R.id.link_thread_abstract);
        this.dek = (TextView) inflate.findViewById(R.id.link_thread_url);
        this.dem = inflate.findViewById(R.id.link_thread_content);
        this.deh.setLongIconSupport(false);
        this.deh.setGifIconSupport(false);
        this.deh.setRadius(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds10));
        this.deh.setConrers(5);
        aV(inflate);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public void setData(bj bjVar) {
        if (bjVar == null || bjVar.aBf() == null || aq.isEmpty(bjVar.aBf().getLinkUrl())) {
            setVisibility(8);
            return;
        }
        ag aBf = bjVar.aBf();
        if (!aBf.ayi() && aBf.ayh() != ag.cLb) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.deh.setPageId(this.mTag);
        if (aBf.ayi()) {
            this.dek.setVisibility(0);
            this.dei.setVisibility(8);
            this.dej.setVisibility(8);
            this.dek.setText(aBf.getLinkUrl());
            this.deh.reset();
        } else {
            this.dek.setVisibility(8);
            String aye = aBf.aye();
            String ayf = aBf.ayf();
            if (!aq.isEmpty(aye)) {
                this.dei.setText(aye);
                this.dei.setVisibility(0);
                this.dej.setVisibility(8);
            } else {
                this.dei.setVisibility(8);
                if (!aq.isEmpty(ayf)) {
                    this.dej.setText(ayf);
                    this.dej.setVisibility(0);
                } else {
                    this.dej.setVisibility(4);
                }
            }
            if (!aq.isEmpty(aBf.ayg())) {
                this.deh.startLoad(aBf.ayg(), 10, false);
            } else {
                this.deh.reset();
            }
        }
        tF(bjVar.getId());
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.dem, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.deh, R.drawable.shape_link_thread_head_bg);
    }

    public void tF(String str) {
        com.baidu.tieba.card.l.a(this.dei, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(this.dek, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
        com.baidu.tieba.card.l.a(this.dej, str, (int) R.color.cp_cont_j, (int) R.color.cp_cont_d);
    }

    private void aV(View view) {
        if (this.del != null && this.deh != null) {
            int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.del.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.del.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.deh.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.deh.setLayoutParams(layoutParams2);
        }
    }
}

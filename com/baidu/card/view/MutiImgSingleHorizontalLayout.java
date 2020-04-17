package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.a.b;
import com.baidu.card.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class MutiImgSingleHorizontalLayout extends LinearLayout implements m<com.baidu.tbadk.core.data.a> {
    private static final int afq = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static final int afr = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static final int afs = afr - afq;
    private static final int aft = afs / 2;
    private com.baidu.tbadk.core.data.a ada;
    private z<com.baidu.tbadk.core.data.a> aez;
    private boolean agI;
    private LinkedList<MediaData> agK;
    private boolean agt;
    public TbImageView ahc;
    public ImageView ahd;
    public TextView mTitle;

    public MutiImgSingleHorizontalLayout(Context context) {
        this(context, null);
    }

    public MutiImgSingleHorizontalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agt = true;
        this.ada = null;
        this.agI = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_single_h_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, aft));
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.ahc = (TbImageView) findViewById(R.id.thread_card_img_singal);
        this.ahd = (ImageView) findViewById(R.id.play_btn);
    }

    private void setImageData(bj bjVar) {
        ArrayList<MediaData> aKO = bjVar.aKO();
        if (i.aIe().isShowImages() && v.getCount(aKO) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aKO.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aKO, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.agK = linkedList;
            this.agI = true;
            this.ahc.setVisibility(8);
            this.ahd.setVisibility(8);
            if (v.getCount(linkedList) > 0) {
                this.ahc.setVisibility(0);
                this.ahd.setVisibility(0);
                this.ahc.setConrers(15);
                a((MediaData) v.getItem(aKO, 0), this.ahc, true, false, true, 0);
                return;
            }
            this.ahc.setVisibility(8);
            this.ahd.setVisibility(8);
            this.agI = false;
            return;
        }
        this.ahc.setVisibility(8);
        this.ahd.setVisibility(8);
        this.agI = false;
    }

    public void setFromCDN(boolean z) {
        this.agt = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.ada = aVar;
        bj aIw = aVar.aIw();
        au.a(this.mTitle, aIw);
        setImageData(aIw);
    }

    public void setMarginsTop(View view, int i) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public z<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.aez;
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.aez = zVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a = a(mediaData);
        int i2 = this.agt ? 13 : 14;
        if (!aq.equals(a, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(am.getColor(R.color.cp_border_a));
            tbImageView.setBorderSurroundContent(true);
        }
        tbImageView.startLoad(a, i2, false);
    }

    private String a(MediaData mediaData) {
        if (mediaData == null) {
            return "";
        }
        String picUrl = mediaData.getPicUrl();
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getSmallUrl();
        }
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getThumbnails_url();
        }
        if (TextUtils.isEmpty(picUrl)) {
            return mediaData.getSrc_pic();
        }
        return picUrl;
    }
}

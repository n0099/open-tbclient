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
import com.baidu.tbadk.core.data.a;
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
/* loaded from: classes5.dex */
public class MutiImgSingleHorizontalLayout extends LinearLayout implements m<a> {
    private static final int LX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static final int LY = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static final int LZ = LY - LX;
    private static final int Ma = LZ / 2;
    private a JB;
    private z<a> Lb;
    public TbImageView NQ;
    public ImageView NR;
    private boolean Nf;
    private boolean Nu;
    private LinkedList<MediaData> Nw;
    public TextView mTitle;

    public MutiImgSingleHorizontalLayout(Context context) {
        this(context, null);
    }

    public MutiImgSingleHorizontalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nf = true;
        this.JB = null;
        this.Nu = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_single_h_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, Ma));
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.NQ = (TbImageView) findViewById(R.id.thread_card_img_singal);
        this.NR = (ImageView) findViewById(R.id.play_btn);
    }

    private void setImageData(bj bjVar) {
        ArrayList<MediaData> azO = bjVar.azO();
        if (i.axf().isShowImages() && v.getCount(azO) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < azO.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(azO, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.Nw = linkedList;
            this.Nu = true;
            this.NQ.setVisibility(8);
            this.NR.setVisibility(8);
            if (v.getCount(linkedList) > 0) {
                this.NQ.setVisibility(0);
                this.NR.setVisibility(0);
                this.NQ.setConrers(15);
                a((MediaData) v.getItem(azO, 0), this.NQ, true, false, true, 0);
                return;
            }
            this.NQ.setVisibility(8);
            this.NR.setVisibility(8);
            this.Nu = false;
            return;
        }
        this.NQ.setVisibility(8);
        this.NR.setVisibility(8);
        this.Nu = false;
    }

    public void setFromCDN(boolean z) {
        this.Nf = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(a aVar) {
        this.JB = aVar;
        bj axx = aVar.axx();
        au.a(this.mTitle, axx);
        setImageData(axx);
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

    public z<a> getSubClickListener() {
        return this.Lb;
    }

    public void setSubClickListener(z<a> zVar) {
        this.Lb = zVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a = a(mediaData);
        int i2 = this.Nf ? 13 : 14;
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

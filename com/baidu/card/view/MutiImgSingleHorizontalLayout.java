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
import com.baidu.card.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MutiImgSingleHorizontalLayout extends LinearLayout implements i<a> {
    private static final int GO = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static final int GP = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static final int GQ = GP - GO;
    private static final int GR = GQ / 2;
    private a EX;
    private ab<a> Gd;
    private boolean HJ;
    private LinkedList<MediaData> HL;
    private boolean Hx;
    public TbImageView Ie;
    public ImageView If;
    public TextView mTitle;

    public MutiImgSingleHorizontalLayout(Context context) {
        this(context, null);
    }

    public MutiImgSingleHorizontalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hx = true;
        this.EX = null;
        this.HJ = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_single_h_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, GR));
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.Ie = (TbImageView) findViewById(R.id.thread_card_img_singal);
        this.If = (ImageView) findViewById(R.id.play_btn);
    }

    private void setImageData(bh bhVar) {
        ArrayList<MediaData> aiO = bhVar.aiO();
        if (com.baidu.tbadk.core.i.ago().isShowImages() && v.getCount(aiO) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aiO.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aiO, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.HL = linkedList;
            this.HJ = true;
            this.Ie.setVisibility(8);
            this.If.setVisibility(8);
            if (v.getCount(linkedList) > 0) {
                this.Ie.setVisibility(0);
                this.If.setVisibility(0);
                this.Ie.setConrers(15);
                a((MediaData) v.getItem(aiO, 0), this.Ie, true, false, true, 0);
                return;
            }
            this.Ie.setVisibility(8);
            this.If.setVisibility(8);
            this.HJ = false;
            return;
        }
        this.Ie.setVisibility(8);
        this.If.setVisibility(8);
        this.HJ = false;
    }

    public void setFromCDN(boolean z) {
        this.Hx = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(a aVar) {
        this.EX = aVar;
        bh agG = aVar.agG();
        au.a(this.mTitle, agG);
        setImageData(agG);
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

    public ab<a> getSubClickListener() {
        return this.Gd;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.Gd = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a = a(mediaData);
        int i2 = this.Hx ? 13 : 14;
        if (!aq.equals(a, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.getDimens(getContext(), R.dimen.tbds20));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(am.getColor(R.color.black_alpha8));
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

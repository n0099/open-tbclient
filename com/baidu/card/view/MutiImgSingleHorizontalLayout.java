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
import com.baidu.card.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes15.dex */
public class MutiImgSingleHorizontalLayout extends LinearLayout implements n<AbsThreadDataSupport> {
    private static final int agr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static final int ags = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static final int agt = ags - agr;
    private static final int agu = agt / 2;
    private AbsThreadDataSupport adQ;
    private aa<AbsThreadDataSupport> afy;
    public TbImageView aiK;
    public ImageView aiL;
    private boolean aib;
    private boolean aiq;
    private LinkedList<MediaData> ais;
    public TextView mTitle;

    public MutiImgSingleHorizontalLayout(Context context) {
        this(context, null);
    }

    public MutiImgSingleHorizontalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aib = true;
        this.adQ = null;
        this.aiq = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_single_h_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, agu));
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        this.aiK = (TbImageView) findViewById(R.id.thread_card_img_singal);
        com.baidu.tbadk.a.b.a.e(this.aiK, R.dimen.tbds26, R.dimen.tbds14);
        this.aiL = (ImageView) findViewById(R.id.play_btn);
    }

    private void setImageData(bv bvVar) {
        ArrayList<MediaData> aWu = bvVar.aWu();
        if (k.aTv().isShowImages() && x.getCount(aWu) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aWu.size(); i++) {
                MediaData mediaData = (MediaData) x.getItem(aWu, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.ais = linkedList;
            this.aiq = true;
            this.aiK.setVisibility(8);
            this.aiL.setVisibility(8);
            if (x.getCount(linkedList) > 0) {
                this.aiK.setVisibility(0);
                this.aiL.setVisibility(0);
                this.aiK.setConrers(15);
                a((MediaData) x.getItem(aWu, 0), this.aiK, true, false, true, 0);
                return;
            }
            this.aiK.setVisibility(8);
            this.aiL.setVisibility(8);
            this.aiq = false;
            return;
        }
        this.aiK.setVisibility(8);
        this.aiL.setVisibility(8);
        this.aiq = false;
    }

    public void setFromCDN(boolean z) {
        this.aib = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adQ = absThreadDataSupport;
        bv aTN = absThreadDataSupport.aTN();
        ax.a(this.mTitle, aTN);
        setImageData(aTN);
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

    public aa<AbsThreadDataSupport> getSubClickListener() {
        return this.afy;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.afy = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a = a(mediaData);
        int i2 = this.aib ? 13 : 14;
        if (!as.equals(a, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ao.getColor(R.color.cp_border_a));
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

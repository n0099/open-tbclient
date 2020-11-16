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
import com.baidu.card.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes20.dex */
public class MutiImgSingleHorizontalLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private static final int air = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static final int ais = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static final int aiy = ais - air;
    private static final int aiz = aiy / 2;
    private com.baidu.tbadk.core.data.a afN;
    private ab<com.baidu.tbadk.core.data.a> ahx;
    private boolean akC;
    private LinkedList<MediaData> akE;
    public TbImageView akM;
    public ImageView akY;
    private boolean akn;
    public TextView mTitle;

    public MutiImgSingleHorizontalLayout(Context context) {
        this(context, null);
    }

    public MutiImgSingleHorizontalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akn = true;
        this.afN = null;
        this.akC = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_single_h_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, aiz));
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        this.akM = (TbImageView) findViewById(R.id.thread_card_img_singal);
        com.baidu.tbadk.a.b.a.d(this.akM, R.dimen.tbds26, R.dimen.tbds14);
        this.akY = (ImageView) findViewById(R.id.play_btn);
    }

    private void setImageData(bx bxVar) {
        ArrayList<MediaData> blL = bxVar.blL();
        if (k.biL().isShowImages() && y.getCount(blL) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < blL.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(blL, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.akE = linkedList;
            this.akC = true;
            this.akM.setVisibility(8);
            this.akY.setVisibility(8);
            if (y.getCount(linkedList) > 0) {
                this.akM.setVisibility(0);
                this.akY.setVisibility(0);
                this.akM.setConrers(15);
                a((MediaData) y.getItem(blL, 0), this.akM, true, false, true, 0);
                return;
            }
            this.akM.setVisibility(8);
            this.akY.setVisibility(8);
            this.akC = false;
            return;
        }
        this.akM.setVisibility(8);
        this.akY.setVisibility(8);
        this.akC = false;
    }

    public void setFromCDN(boolean z) {
        this.akn = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.afN = aVar;
        bx bjd = aVar.bjd();
        az.a(this.mTitle, bjd);
        setImageData(bjd);
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

    public ab<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.ahx;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.ahx = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.akn ? 13 : 14;
        if (!au.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ap.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
        }
        tbImageView.startLoad(a2, i2, false);
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

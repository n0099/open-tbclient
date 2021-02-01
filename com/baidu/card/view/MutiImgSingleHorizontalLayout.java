package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.card.p;
import com.baidu.tbadk.a.b.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.cb;
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
/* loaded from: classes.dex */
public class MutiImgSingleHorizontalLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private static final int agv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static final int agw = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static final int agx = agw - agv;
    private static final int agy = agx / 2;
    private com.baidu.tbadk.core.data.a agj;
    private ab<com.baidu.tbadk.core.data.a> aig;
    private boolean akO;
    public ImageView alA;
    private boolean ald;
    private LinkedList<MediaData> alf;
    public TbImageView alo;
    public TextView mTitle;

    public MutiImgSingleHorizontalLayout(Context context) {
        this(context, null);
    }

    public MutiImgSingleHorizontalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akO = true;
        this.agj = null;
        this.ald = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_single_h_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, agy));
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        b.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        this.alo = (TbImageView) findViewById(R.id.thread_card_img_singal);
        b.j(this.alo, R.dimen.tbds26, R.dimen.tbds14);
        this.alA = (ImageView) findViewById(R.id.play_btn);
    }

    private void setImageData(cb cbVar) {
        ArrayList<MediaData> bnZ = cbVar.bnZ();
        if (k.bkT().isShowImages() && y.getCount(bnZ) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < bnZ.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bnZ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.alf = linkedList;
            this.ald = true;
            this.alo.setVisibility(8);
            this.alA.setVisibility(8);
            if (y.getCount(linkedList) > 0) {
                this.alo.setVisibility(0);
                this.alA.setVisibility(0);
                this.alo.setConrers(15);
                a((MediaData) y.getItem(bnZ, 0), this.alo, true, false, true, 0);
                return;
            }
            this.alo.setVisibility(8);
            this.alA.setVisibility(8);
            this.ald = false;
            return;
        }
        this.alo.setVisibility(8);
        this.alA.setVisibility(8);
        this.ald = false;
    }

    public void setFromCDN(boolean z) {
        this.akO = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agj = aVar;
        cb bln = aVar.bln();
        az.a(this.mTitle, bln);
        setImageData(bln);
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
        return this.aig;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.aig = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.akO ? 13 : 14;
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

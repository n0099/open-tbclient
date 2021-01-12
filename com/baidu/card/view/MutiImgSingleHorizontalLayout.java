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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MutiImgSingleHorizontalLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private static final int agG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static final int agH = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static final int agI = agH - agG;
    private static final int agJ = agI / 2;
    private com.baidu.tbadk.core.data.a agr;
    private aa<com.baidu.tbadk.core.data.a> ais;
    private boolean akY;
    public ImageView alK;
    private boolean alo;
    private LinkedList<MediaData> alq;
    public TbImageView aly;
    public TextView mTitle;

    public MutiImgSingleHorizontalLayout(Context context) {
        this(context, null);
    }

    public MutiImgSingleHorizontalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akY = true;
        this.agr = null;
        this.alo = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_single_h_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, agJ));
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        b.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        this.aly = (TbImageView) findViewById(R.id.thread_card_img_singal);
        b.j(this.aly, R.dimen.tbds26, R.dimen.tbds14);
        this.alK = (ImageView) findViewById(R.id.play_btn);
    }

    private void setImageData(bz bzVar) {
        ArrayList<MediaData> bnG = bzVar.bnG();
        if (k.bkB().isShowImages() && x.getCount(bnG) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < bnG.size(); i++) {
                MediaData mediaData = (MediaData) x.getItem(bnG, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.alq = linkedList;
            this.alo = true;
            this.aly.setVisibility(8);
            this.alK.setVisibility(8);
            if (x.getCount(linkedList) > 0) {
                this.aly.setVisibility(0);
                this.alK.setVisibility(0);
                this.aly.setConrers(15);
                a((MediaData) x.getItem(bnG, 0), this.aly, true, false, true, 0);
                return;
            }
            this.aly.setVisibility(8);
            this.alK.setVisibility(8);
            this.alo = false;
            return;
        }
        this.aly.setVisibility(8);
        this.alK.setVisibility(8);
        this.alo = false;
    }

    public void setFromCDN(boolean z) {
        this.akY = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agr = aVar;
        bz bkV = aVar.bkV();
        ay.a(this.mTitle, bkV);
        setImageData(bkV);
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

    public aa<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.ais;
    }

    public void setSubClickListener(aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.ais = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.akY ? 13 : 14;
        if (!at.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ao.getColor(R.color.CAM_X0401));
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

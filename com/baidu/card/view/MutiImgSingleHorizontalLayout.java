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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes21.dex */
public class MutiImgSingleHorizontalLayout extends LinearLayout implements p<AbsThreadDataSupport> {
    private static final int aio = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static final int aip = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static final int aiq = aip - aio;
    private static final int air = aiq / 2;
    private AbsThreadDataSupport afI;
    private ab<AbsThreadDataSupport> ahv;
    private LinkedList<MediaData> akA;
    public TbImageView akI;
    public ImageView akU;
    private boolean akk;
    private boolean aky;
    public TextView mTitle;

    public MutiImgSingleHorizontalLayout(Context context) {
        this(context, null);
    }

    public MutiImgSingleHorizontalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akk = true;
        this.afI = null;
        this.aky = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_single_h_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, air));
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        this.akI = (TbImageView) findViewById(R.id.thread_card_img_singal);
        com.baidu.tbadk.a.b.a.d(this.akI, R.dimen.tbds26, R.dimen.tbds14);
        this.akU = (ImageView) findViewById(R.id.play_btn);
    }

    private void setImageData(bw bwVar) {
        ArrayList<MediaData> bmJ = bwVar.bmJ();
        if (k.bjH().isShowImages() && y.getCount(bmJ) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < bmJ.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bmJ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.akA = linkedList;
            this.aky = true;
            this.akI.setVisibility(8);
            this.akU.setVisibility(8);
            if (y.getCount(linkedList) > 0) {
                this.akI.setVisibility(0);
                this.akU.setVisibility(0);
                this.akI.setConrers(15);
                a((MediaData) y.getItem(bmJ, 0), this.akI, true, false, true, 0);
                return;
            }
            this.akI.setVisibility(8);
            this.akU.setVisibility(8);
            this.aky = false;
            return;
        }
        this.akI.setVisibility(8);
        this.akU.setVisibility(8);
        this.aky = false;
    }

    public void setFromCDN(boolean z) {
        this.akk = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afI = absThreadDataSupport;
        bw bjZ = absThreadDataSupport.bjZ();
        ay.a(this.mTitle, bjZ);
        setImageData(bjZ);
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

    public ab<AbsThreadDataSupport> getSubClickListener() {
        return this.ahv;
    }

    public void setSubClickListener(ab<AbsThreadDataSupport> abVar) {
        this.ahv = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.akk ? 13 : 14;
        if (!at.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ap.getColor(R.color.cp_border_a));
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

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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class MutiImgSingleHorizontalLayout extends LinearLayout implements n<AbsThreadDataSupport> {
    private static final int agA = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static final int agB = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static final int agC = agB - agA;
    private static final int agD = agC / 2;
    private AbsThreadDataSupport aea;
    private aa<AbsThreadDataSupport> afH;
    private LinkedList<MediaData> aiA;
    public TbImageView aiS;
    public ImageView aiT;
    private boolean aik;
    private boolean aiy;
    public TextView mTitle;

    public MutiImgSingleHorizontalLayout(Context context) {
        this(context, null);
    }

    public MutiImgSingleHorizontalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aik = true;
        this.aea = null;
        this.aiy = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_single_h_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, agD));
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.aiS = (TbImageView) findViewById(R.id.thread_card_img_singal);
        this.aiT = (ImageView) findViewById(R.id.play_btn);
    }

    private void setImageData(bu buVar) {
        ArrayList<MediaData> aSy = buVar.aSy();
        if (k.aPA().isShowImages() && w.getCount(aSy) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aSy.size(); i++) {
                MediaData mediaData = (MediaData) w.getItem(aSy, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.aiA = linkedList;
            this.aiy = true;
            this.aiS.setVisibility(8);
            this.aiT.setVisibility(8);
            if (w.getCount(linkedList) > 0) {
                this.aiS.setVisibility(0);
                this.aiT.setVisibility(0);
                this.aiS.setConrers(15);
                a((MediaData) w.getItem(aSy, 0), this.aiS, true, false, true, 0);
                return;
            }
            this.aiS.setVisibility(8);
            this.aiT.setVisibility(8);
            this.aiy = false;
            return;
        }
        this.aiS.setVisibility(8);
        this.aiT.setVisibility(8);
        this.aiy = false;
    }

    public void setFromCDN(boolean z) {
        this.aik = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.aea = absThreadDataSupport;
        bu aPS = absThreadDataSupport.aPS();
        aw.a(this.mTitle, aPS);
        setImageData(aPS);
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
        return this.afH;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.afH = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a = a(mediaData);
        int i2 = this.aik ? 13 : 14;
        if (!ar.equals(a, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(an.getColor(R.color.cp_border_a));
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

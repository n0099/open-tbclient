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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MutiImgSingleHorizontalLayout extends LinearLayout implements i<a> {
    private a Xy;
    private ab<a> YB;
    private boolean ZQ;
    private boolean aab;
    private LinkedList<MediaData> aaf;
    public TbImageView aav;
    public ImageView aaw;
    public TextView mTitle;
    private static final int Zl = l.h(TbadkCoreApplication.getInst(), d.e.tbds88);
    private static final int SCREEN_WIDTH = l.aO(TbadkCoreApplication.getInst());
    private static final int Zm = SCREEN_WIDTH - Zl;
    private static final int Zn = Zm / 2;

    public MutiImgSingleHorizontalLayout(Context context) {
        this(context, null);
    }

    public MutiImgSingleHorizontalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZQ = true;
        this.Xy = null;
        this.aab = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.multi_image_single_h_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, Zn));
        this.mTitle = (TextView) findViewById(d.g.thread_card_title);
        this.aav = (TbImageView) findViewById(d.g.thread_card_img_singal);
        this.aaw = (ImageView) findViewById(d.g.play_btn);
    }

    private void setImageData(bg bgVar) {
        ArrayList<MediaData> YY = bgVar.YY();
        if (com.baidu.tbadk.core.i.Wv().Wz() && v.S(YY) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < YY.size(); i++) {
                MediaData mediaData = (MediaData) v.c(YY, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.aaf = linkedList;
            this.aab = true;
            this.aav.setVisibility(8);
            this.aaw.setVisibility(8);
            if (v.S(linkedList) > 0) {
                this.aav.setVisibility(0);
                this.aaw.setVisibility(0);
                this.aav.setConrers(15);
                a((MediaData) v.c(YY, 0), this.aav, true, false, true, 0);
                return;
            }
            this.aav.setVisibility(8);
            this.aaw.setVisibility(8);
            this.aab = false;
            return;
        }
        this.aav.setVisibility(8);
        this.aaw.setVisibility(8);
        this.aab = false;
    }

    public void setFromCDN(boolean z) {
        this.ZQ = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(a aVar) {
        this.Xy = aVar;
        bg WO = aVar.WO();
        au.a(this.mTitle, WO);
        setImageData(WO);
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
        return this.YB;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.YB = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a = a(mediaData);
        int i2 = this.ZQ ? 13 : 14;
        if (!ap.equals(a, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.h(getContext(), d.e.tbds20));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
            tbImageView.setBorderColor(al.getColor(d.C0277d.black_alpha8));
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

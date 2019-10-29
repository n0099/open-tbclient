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
    private static final int Hq = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static final int Hr = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static final int Hs = Hr - Hq;
    private static final int Ht = Hs / 2;
    private a Fx;
    private ab<a> GD;
    private boolean HY;
    public TbImageView IF;
    public ImageView IG;
    private boolean Ik;
    private LinkedList<MediaData> Im;
    public TextView mTitle;

    public MutiImgSingleHorizontalLayout(Context context) {
        this(context, null);
    }

    public MutiImgSingleHorizontalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HY = true;
        this.Fx = null;
        this.Ik = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_single_h_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, Ht));
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.IF = (TbImageView) findViewById(R.id.thread_card_img_singal);
        this.IG = (ImageView) findViewById(R.id.play_btn);
    }

    private void setImageData(bh bhVar) {
        ArrayList<MediaData> aiQ = bhVar.aiQ();
        if (com.baidu.tbadk.core.i.agq().isShowImages() && v.getCount(aiQ) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aiQ.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aiQ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.Im = linkedList;
            this.Ik = true;
            this.IF.setVisibility(8);
            this.IG.setVisibility(8);
            if (v.getCount(linkedList) > 0) {
                this.IF.setVisibility(0);
                this.IG.setVisibility(0);
                this.IF.setConrers(15);
                a((MediaData) v.getItem(aiQ, 0), this.IF, true, false, true, 0);
                return;
            }
            this.IF.setVisibility(8);
            this.IG.setVisibility(8);
            this.Ik = false;
            return;
        }
        this.IF.setVisibility(8);
        this.IG.setVisibility(8);
        this.Ik = false;
    }

    public void setFromCDN(boolean z) {
        this.HY = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(a aVar) {
        this.Fx = aVar;
        bh agI = aVar.agI();
        au.a(this.mTitle, agI);
        setImageData(agI);
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
        return this.GD;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.GD = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a = a(mediaData);
        int i2 = this.HY ? 13 : 14;
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

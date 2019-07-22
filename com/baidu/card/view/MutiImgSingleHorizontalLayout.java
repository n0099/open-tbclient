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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MutiImgSingleHorizontalLayout extends LinearLayout implements i<a> {
    private a VJ;
    private ab<a> WO;
    public TbImageView YI;
    public ImageView YJ;
    private boolean Yd;
    private boolean Yo;
    private LinkedList<MediaData> Yq;
    public TextView mTitle;
    private static final int Xy = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static final int SCREEN_WIDTH = l.af(TbadkCoreApplication.getInst());
    private static final int Xz = SCREEN_WIDTH - Xy;
    private static final int XA = Xz / 2;

    public MutiImgSingleHorizontalLayout(Context context) {
        this(context, null);
    }

    public MutiImgSingleHorizontalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Yd = true;
        this.VJ = null;
        this.Yo = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_single_h_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, XA));
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.YI = (TbImageView) findViewById(R.id.thread_card_img_singal);
        this.YJ = (ImageView) findViewById(R.id.play_btn);
    }

    private void setImageData(bg bgVar) {
        ArrayList<MediaData> aeH = bgVar.aeH();
        if (com.baidu.tbadk.core.i.aca().ace() && v.Z(aeH) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aeH.size(); i++) {
                MediaData mediaData = (MediaData) v.c(aeH, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.Yq = linkedList;
            this.Yo = true;
            this.YI.setVisibility(8);
            this.YJ.setVisibility(8);
            if (v.Z(linkedList) > 0) {
                this.YI.setVisibility(0);
                this.YJ.setVisibility(0);
                this.YI.setConrers(15);
                a((MediaData) v.c(aeH, 0), this.YI, true, false, true, 0);
                return;
            }
            this.YI.setVisibility(8);
            this.YJ.setVisibility(8);
            this.Yo = false;
            return;
        }
        this.YI.setVisibility(8);
        this.YJ.setVisibility(8);
        this.Yo = false;
    }

    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(a aVar) {
        this.VJ = aVar;
        bg acx = aVar.acx();
        av.a(this.mTitle, acx);
        setImageData(acx);
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
        return this.WO;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.WO = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a = a(mediaData);
        int i2 = this.Yd ? 13 : 14;
        if (!aq.bV(a, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.g(getContext(), R.dimen.tbds20));
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

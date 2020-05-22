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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class MutiImgSingleHorizontalLayout extends LinearLayout implements n<AbsThreadDataSupport> {
    private static final int afP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds88);
    private static final int afQ = l.getEquipmentWidth(TbadkCoreApplication.getInst());
    private static final int afR = afQ - afP;
    private static final int afS = afR / 2;
    private AbsThreadDataSupport adw;
    private aa<AbsThreadDataSupport> aeY;
    public TbImageView ahI;
    public ImageView ahJ;
    private boolean aha;
    private boolean aho;
    private LinkedList<MediaData> ahq;
    public TextView mTitle;

    public MutiImgSingleHorizontalLayout(Context context) {
        this(context, null);
    }

    public MutiImgSingleHorizontalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aha = true;
        this.adw = null;
        this.aho = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_single_h_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, afS));
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.ahI = (TbImageView) findViewById(R.id.thread_card_img_singal);
        this.ahJ = (ImageView) findViewById(R.id.play_btn);
    }

    private void setImageData(bk bkVar) {
        ArrayList<MediaData> aQH = bkVar.aQH();
        if (k.aNQ().isShowImages() && v.getCount(aQH) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aQH.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aQH, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.ahq = linkedList;
            this.aho = true;
            this.ahI.setVisibility(8);
            this.ahJ.setVisibility(8);
            if (v.getCount(linkedList) > 0) {
                this.ahI.setVisibility(0);
                this.ahJ.setVisibility(0);
                this.ahI.setConrers(15);
                a((MediaData) v.getItem(aQH, 0), this.ahI, true, false, true, 0);
                return;
            }
            this.ahI.setVisibility(8);
            this.ahJ.setVisibility(8);
            this.aho = false;
            return;
        }
        this.ahI.setVisibility(8);
        this.ahJ.setVisibility(8);
        this.aho = false;
    }

    public void setFromCDN(boolean z) {
        this.aha = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adw = absThreadDataSupport;
        bk aOi = absThreadDataSupport.aOi();
        au.a(this.mTitle, aOi);
        setImageData(aOi);
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
        return this.aeY;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.aeY = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a = a(mediaData);
        int i2 = this.aha ? 13 : 14;
        if (!aq.equals(a, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(am.getColor(R.color.cp_border_a));
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

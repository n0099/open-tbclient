package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.a.b;
import com.baidu.card.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes20.dex */
public class MutiImgDoubleLayout extends LinearLayout implements p<AbsThreadDataSupport> {
    public TextView afT;
    private AbsThreadDataSupport afq;
    private aa<AbsThreadDataSupport> ahd;
    private boolean ajR;
    public PlayVoiceBntNew akd;
    private boolean akf;
    private boolean akg;
    private LinkedList<MediaData> akh;
    private int akq;
    private d akr;
    public RelativeLayout akv;
    public TbImageView akw;
    public TbImageView akx;
    private String mFrom;
    public TextView mTitle;
    private static final int akb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int afY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int akc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int afR = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgDoubleLayout(Context context) {
        this(context, null);
    }

    public MutiImgDoubleLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajR = true;
        this.afq = null;
        this.akf = false;
        this.akg = false;
        this.akq = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_double_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.afT = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.akd = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.akd.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgDoubleLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgDoubleLayout.this.afq);
                }
            }
        });
        com.baidu.tbadk.a.b.a.d(this.akd, R.dimen.tbds28, R.dimen.tbds14);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.afT, R.dimen.tbds7, R.dimen.tbds10);
        this.akv = (RelativeLayout) findViewById(R.id.thread_card_img_double_container);
        com.baidu.tbadk.a.b.a.d(this.akv, R.dimen.tbds20, R.dimen.tbds14);
        this.akw = (TbImageView) findViewById(R.id.thread_card_img_double_one);
        this.akx = (TbImageView) findViewById(R.id.thread_card_img_double_two);
        this.akr = new d() { // from class: com.baidu.card.view.MutiImgDoubleLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgDoubleLayout.this.afq.objType = 2;
                    subClickListener.a(view, MutiImgDoubleLayout.this.afq);
                    MutiImgDoubleLayout.this.afq.objType = 1;
                }
                ay.a(view, MutiImgDoubleLayout.this.ajR, MutiImgDoubleLayout.this.akh, i, MutiImgDoubleLayout.this.afq.bcY(), MutiImgDoubleLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bw bwVar) {
        ArrayList<VoiceData.VoiceModel> bfL = bwVar.bfL();
        if (y.isEmpty(bfL)) {
            this.akd.setVisibility(8);
            this.akg = false;
            return;
        }
        this.akd.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bfL.get(0);
        this.akd.setVoiceModel(voiceModel);
        this.akd.setTag(voiceModel);
        this.akd.changeSkin();
        if (voiceModel != null) {
            this.akd.Cn(voiceModel.voice_status.intValue());
        }
        this.akd.bQr();
        this.akg = true;
    }

    private void setImageData(bw bwVar) {
        ArrayList<MediaData> bfH = bwVar.bfH();
        if (k.bcG().isShowImages() && y.getCount(bfH) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < bfH.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bfH, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.akh = linkedList;
            this.akf = true;
            this.akv.setVisibility(8);
            if (y.getCount(linkedList) == 2) {
                this.akv.setVisibility(0);
                this.akw.setConrers(15);
                a((MediaData) y.getItem(bfH, 0), this.akw, true, false, false, 0);
                this.akx.setConrers(15);
                a((MediaData) y.getItem(bfH, 1), this.akx, true, false, true, 1);
                return;
            }
            this.akv.setVisibility(8);
            this.akf = false;
            return;
        }
        this.akv.setVisibility(8);
        this.akf = false;
    }

    public void setFromCDN(boolean z) {
        this.ajR = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        this.afq = absThreadDataSupport;
        bw bcY = absThreadDataSupport.bcY();
        ay.a(this.mTitle, bcY);
        ay.a(this.afT, this.mTitle, bcY, afR);
        setImageData(bcY);
        setVoiceData(bcY);
        ua();
    }

    private void ua() {
        if (this.afT.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.akf) {
                setMarginsTop(this.akd, akb);
            } else if (this.akg) {
                setMarginsTop(this.akd, akc);
            }
        } else if (this.akd != null && this.akd.getLayoutParams() != null) {
            if (this.akf) {
                setMarginsTop(this.akd, akb);
            } else if (this.akg) {
                setMarginsTop(this.akd, afY);
            }
        }
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
        return this.ahd;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.ahd = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bE = bE(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akw.getLayoutParams();
        layoutParams.width = bE;
        layoutParams.height = bE;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.akx.getLayoutParams();
        layoutParams2.width = bE;
        layoutParams2.height = bE;
        if (this.akv.getVisibility() != 8) {
            this.akw.setLayoutParams(layoutParams);
            this.akx.setLayoutParams(layoutParams2);
        }
    }

    private int bE(int i) {
        if (this.akq > 0) {
            return this.akq;
        }
        this.akq = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.akq;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.ajR ? 13 : 14;
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
        a(tbImageView, i, z2, z3);
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

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.akr != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.akr == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        private boolean aku;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.aku = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgDoubleLayout.this.akr != null) {
                MutiImgDoubleLayout.this.akr.b(view, this.currentIndex, this.hasMore && this.aku);
            }
        }
    }
}

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
import com.baidu.card.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MutiImgDoubleLayout extends LinearLayout implements i<com.baidu.tbadk.core.data.a> {
    public TextView XJ;
    private com.baidu.tbadk.core.data.a Xx;
    private ab<com.baidu.tbadk.core.data.a> YA;
    private boolean ZO;
    public PlayVoiceBntNew ZX;
    private boolean ZZ;
    private boolean aaa;
    private d aac;
    private LinkedList<MediaData> aad;
    public RelativeLayout aag;
    public TbImageView aah;
    public TbImageView aai;
    private int aaj;
    private String mFrom;
    public TextView mTitle;
    private static final int ZU = l.h(TbadkCoreApplication.getInst(), d.e.tbds26);
    private static final int ZV = l.h(TbadkCoreApplication.getInst(), d.e.tbds20);
    private static final int ZW = l.h(TbadkCoreApplication.getInst(), d.e.tbds7);
    private static final int XH = l.aO(TbadkCoreApplication.getInst()) - (l.h(TbadkCoreApplication.getInst(), d.e.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgDoubleLayout(Context context) {
        this(context, null);
    }

    public MutiImgDoubleLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZO = true;
        this.Xx = null;
        this.ZZ = false;
        this.aaa = false;
        this.aaj = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.multi_image_double_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.XJ = (TextView) findViewById(d.g.thread_card_abstract);
        this.mTitle = (TextView) findViewById(d.g.thread_card_title);
        this.ZX = (PlayVoiceBntNew) findViewById(d.g.thread_card_voice);
        this.ZX.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgDoubleLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgDoubleLayout.this.Xx);
                }
            }
        });
        this.aag = (RelativeLayout) findViewById(d.g.thread_card_img_double_container);
        this.aah = (TbImageView) findViewById(d.g.thread_card_img_double_one);
        this.aai = (TbImageView) findViewById(d.g.thread_card_img_double_two);
        this.aac = new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.card.view.MutiImgDoubleLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgDoubleLayout.this.Xx.objType = 2;
                    subClickListener.a(view, MutiImgDoubleLayout.this.Xx);
                    MutiImgDoubleLayout.this.Xx.objType = 1;
                }
                au.a(view, MutiImgDoubleLayout.this.ZO, MutiImgDoubleLayout.this.aad, i, MutiImgDoubleLayout.this.Xx.WR(), MutiImgDoubleLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bg bgVar) {
        ArrayList<VoiceData.VoiceModel> Zf = bgVar.Zf();
        if (v.T(Zf)) {
            this.ZX.setVisibility(8);
            this.aaa = false;
            return;
        }
        this.ZX.setVisibility(0);
        VoiceData.VoiceModel voiceModel = Zf.get(0);
        this.ZX.setVoiceModel(voiceModel);
        this.ZX.setTag(voiceModel);
        this.ZX.bxV();
        if (voiceModel != null) {
            this.ZX.uu(voiceModel.voice_status.intValue());
        }
        this.ZX.cfA();
        this.aaa = true;
    }

    private void setImageData(bg bgVar) {
        ArrayList<MediaData> Zb = bgVar.Zb();
        if (com.baidu.tbadk.core.i.Wy().WC() && v.S(Zb) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < Zb.size(); i++) {
                MediaData mediaData = (MediaData) v.c(Zb, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.aad = linkedList;
            this.ZZ = true;
            this.aag.setVisibility(8);
            if (v.S(linkedList) == 2) {
                this.aag.setVisibility(0);
                this.aah.setConrers(5);
                a((MediaData) v.c(Zb, 0), this.aah, true, false, false, 0);
                this.aai.setConrers(10);
                a((MediaData) v.c(Zb, 1), this.aai, true, false, true, 1);
                return;
            }
            this.aag.setVisibility(8);
            this.ZZ = false;
            return;
        }
        this.aag.setVisibility(8);
        this.ZZ = false;
    }

    public void setFromCDN(boolean z) {
        this.ZO = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Xx = aVar;
        bg WR = aVar.WR();
        au.a(this.mTitle, WR);
        au.a(this.XJ, this.mTitle, WR, XH);
        setImageData(WR);
        setVoiceData(WR);
        rB();
    }

    private void rB() {
        if (this.XJ.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.ZZ) {
                setMarginsTop(this.ZX, ZU);
            } else if (this.aaa) {
                setMarginsTop(this.ZX, ZW);
            }
        } else if (this.ZX != null && this.ZX.getLayoutParams() != null) {
            if (this.ZZ) {
                setMarginsTop(this.ZX, ZU);
            } else if (this.aaa) {
                setMarginsTop(this.ZX, ZV);
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

    public ab<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.YA;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.YA = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bD = bD(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aah.getLayoutParams();
        layoutParams.width = bD;
        layoutParams.height = bD;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aai.getLayoutParams();
        layoutParams2.width = bD;
        layoutParams2.height = bD;
        if (this.aag.getVisibility() != 8) {
            this.aah.setLayoutParams(layoutParams);
            this.aai.setLayoutParams(layoutParams2);
        }
    }

    private int bD(int i) {
        if (this.aaj > 0) {
            return this.aaj;
        }
        this.aaj = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds10) * 2)) / 3;
        return this.aaj;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.ZO ? 13 : 14;
        if (!ap.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.h(getContext(), d.e.tbds20));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
            tbImageView.setBorderColor(al.getColor(d.C0236d.black_alpha8));
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
        if (this.aac != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.aac == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private boolean aal;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.aal = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgDoubleLayout.this.aac != null) {
                MutiImgDoubleLayout.this.aac.a(view, this.currentIndex, this.hasMore && this.aal);
            }
        }
    }
}

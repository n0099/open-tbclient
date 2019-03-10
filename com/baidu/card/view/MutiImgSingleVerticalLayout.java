package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
import com.baidu.tbadk.util.e;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MutiImgSingleVerticalLayout extends LinearLayout implements i<com.baidu.tbadk.core.data.a> {
    public TextView XJ;
    private com.baidu.tbadk.core.data.a Xx;
    private ab<com.baidu.tbadk.core.data.a> YA;
    private boolean ZO;
    public PlayVoiceBntNew ZX;
    private boolean ZZ;
    private boolean aaa;
    private d aac;
    private LinkedList<MediaData> aad;
    private int aaj;
    public TbImageView aat;
    private MediaData aav;
    private int aaw;
    private int aax;
    private String mFrom;
    public TextView mTitle;
    private static final int ZU = l.h(TbadkCoreApplication.getInst(), d.e.tbds26);
    private static final int ZV = l.h(TbadkCoreApplication.getInst(), d.e.tbds20);
    private static final int ZW = l.h(TbadkCoreApplication.getInst(), d.e.tbds7);
    private static final int XH = l.aO(TbadkCoreApplication.getInst()) - (l.h(TbadkCoreApplication.getInst(), d.e.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgSingleVerticalLayout(Context context) {
        this(context, null);
    }

    public MutiImgSingleVerticalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZO = true;
        this.Xx = null;
        this.ZZ = false;
        this.aaa = false;
        this.aaj = 0;
        this.aaw = 0;
        this.aax = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.multi_image_single_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.XJ = (TextView) findViewById(d.g.thread_card_abstract);
        this.mTitle = (TextView) findViewById(d.g.thread_card_title);
        this.ZX = (PlayVoiceBntNew) findViewById(d.g.thread_card_voice);
        this.ZX.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgSingleVerticalLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgSingleVerticalLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgSingleVerticalLayout.this.Xx);
                }
            }
        });
        this.aat = (TbImageView) findViewById(d.g.thread_card_img_singal);
        this.aat.setRadius(l.h(getContext(), d.e.tbds20));
        this.aat.setConrers(15);
        this.aat.setDrawCorner(true);
        this.aat.setDefaultBgResource(e.get());
        this.aat.setLongIconSupport(true);
        this.aat.setGifIconSupport(true);
        this.aac = new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.card.view.MutiImgSingleVerticalLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgSingleVerticalLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgSingleVerticalLayout.this.Xx.objType = 2;
                    subClickListener.a(view, MutiImgSingleVerticalLayout.this.Xx);
                    MutiImgSingleVerticalLayout.this.Xx.objType = 1;
                }
                au.a(view, MutiImgSingleVerticalLayout.this.ZO, MutiImgSingleVerticalLayout.this.aad, i, MutiImgSingleVerticalLayout.this.Xx.WR(), MutiImgSingleVerticalLayout.this.mFrom);
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
        this.ZX.bxW();
        if (voiceModel != null) {
            this.ZX.uu(voiceModel.voice_status.intValue());
        }
        this.ZX.cfB();
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
            this.aat.setVisibility(8);
            if (v.S(linkedList) == 1) {
                this.aat.setVisibility(0);
                this.aav = (MediaData) v.c(Zb, 0);
                a((MediaData) v.c(Zb, 0), this.aat, true, false, true, 0);
                return;
            }
            this.aat.setVisibility(8);
            this.ZZ = false;
            return;
        }
        this.aat.setVisibility(8);
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
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.ZO ? 13 : 14;
        if (!ap.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        boolean isLongPic = mediaData.isLongPic();
        boolean isSmartCrop = mediaData.isSmartCrop();
        tbImageView.setIsLongPic(isLongPic);
        tbImageView.setIsSmartCrop(isSmartCrop);
        tbImageView.setSmartCropCenterPointWidthRatio((float) mediaData.getSmartCropCenterPointWidthRatio());
        tbImageView.setSmartCropCenterPointHeightRatio((float) mediaData.getSmartCropCenterPointHeightRatio());
        tbImageView.setDrawBorder(true);
        tbImageView.setForegroundColor(0);
        tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
        tbImageView.setBorderColor(al.getColor(d.C0236d.black_alpha8));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.setDefaultBgResource(e.get());
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
            if (MutiImgSingleVerticalLayout.this.aac != null) {
                MutiImgSingleVerticalLayout.this.aac.a(view, this.currentIndex, this.hasMore && this.aal);
            }
        }
    }
}

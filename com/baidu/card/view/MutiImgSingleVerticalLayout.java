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
    public TextView XL;
    private com.baidu.tbadk.core.data.a Xz;
    private ab<com.baidu.tbadk.core.data.a> YC;
    private boolean ZR;
    private int aaA;
    public PlayVoiceBntNew aaa;
    private boolean aac;
    private boolean aad;
    private d aaf;
    private LinkedList<MediaData> aag;
    private int aam;
    public TbImageView aaw;
    private MediaData aay;
    private int aaz;
    private String mFrom;
    public TextView mTitle;
    private static final int ZX = l.h(TbadkCoreApplication.getInst(), d.e.tbds26);
    private static final int ZY = l.h(TbadkCoreApplication.getInst(), d.e.tbds20);
    private static final int ZZ = l.h(TbadkCoreApplication.getInst(), d.e.tbds7);
    private static final int XJ = l.aO(TbadkCoreApplication.getInst()) - (l.h(TbadkCoreApplication.getInst(), d.e.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgSingleVerticalLayout(Context context) {
        this(context, null);
    }

    public MutiImgSingleVerticalLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZR = true;
        this.Xz = null;
        this.aac = false;
        this.aad = false;
        this.aam = 0;
        this.aaz = 0;
        this.aaA = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.multi_image_single_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.XL = (TextView) findViewById(d.g.thread_card_abstract);
        this.mTitle = (TextView) findViewById(d.g.thread_card_title);
        this.aaa = (PlayVoiceBntNew) findViewById(d.g.thread_card_voice);
        this.aaa.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgSingleVerticalLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgSingleVerticalLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgSingleVerticalLayout.this.Xz);
                }
            }
        });
        this.aaw = (TbImageView) findViewById(d.g.thread_card_img_singal);
        this.aaw.setRadius(l.h(getContext(), d.e.tbds20));
        this.aaw.setConrers(15);
        this.aaw.setDrawCorner(true);
        this.aaw.setDefaultBgResource(e.get());
        this.aaw.setLongIconSupport(true);
        this.aaw.setGifIconSupport(true);
        this.aaf = new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.card.view.MutiImgSingleVerticalLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgSingleVerticalLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgSingleVerticalLayout.this.Xz.objType = 2;
                    subClickListener.Zx = false;
                    subClickListener.a(view, MutiImgSingleVerticalLayout.this.Xz);
                }
                au.a(view, MutiImgSingleVerticalLayout.this.ZR, MutiImgSingleVerticalLayout.this.aag, i, MutiImgSingleVerticalLayout.this.Xz.WO(), MutiImgSingleVerticalLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bg bgVar) {
        ArrayList<VoiceData.VoiceModel> Zc = bgVar.Zc();
        if (v.T(Zc)) {
            this.aaa.setVisibility(8);
            this.aad = false;
            return;
        }
        this.aaa.setVisibility(0);
        VoiceData.VoiceModel voiceModel = Zc.get(0);
        this.aaa.setVoiceModel(voiceModel);
        this.aaa.setTag(voiceModel);
        this.aaa.bxS();
        if (voiceModel != null) {
            this.aaa.uq(voiceModel.voice_status.intValue());
        }
        this.aaa.cfz();
        this.aad = true;
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
            this.aag = linkedList;
            this.aac = true;
            this.aaw.setVisibility(8);
            if (v.S(linkedList) == 1) {
                this.aaw.setVisibility(0);
                this.aay = (MediaData) v.c(YY, 0);
                a((MediaData) v.c(YY, 0), this.aaw, true, false, true, 0);
                return;
            }
            this.aaw.setVisibility(8);
            this.aac = false;
            return;
        }
        this.aaw.setVisibility(8);
        this.aac = false;
    }

    public void setFromCDN(boolean z) {
        this.ZR = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Xz = aVar;
        bg WO = aVar.WO();
        au.a(this.mTitle, WO);
        au.a(this.XL, this.mTitle, WO, XJ);
        setImageData(WO);
        setVoiceData(WO);
        rB();
    }

    private void rB() {
        if (this.XL.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.aac) {
                setMarginsTop(this.aaa, ZX);
            } else if (this.aad) {
                setMarginsTop(this.aaa, ZZ);
            }
        } else if (this.aaa != null && this.aaa.getLayoutParams() != null) {
            if (this.aac) {
                setMarginsTop(this.aaa, ZX);
            } else if (this.aad) {
                setMarginsTop(this.aaa, ZY);
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
        return this.YC;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.YC = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.ZR ? 13 : 14;
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
        tbImageView.setBorderColor(al.getColor(d.C0277d.black_alpha8));
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
        if (this.aaf != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.aaf == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private boolean aao;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.aao = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgSingleVerticalLayout.this.aaf != null) {
                MutiImgSingleVerticalLayout.this.aaf.a(view, this.currentIndex, this.hasMore && this.aao);
            }
        }
    }
}

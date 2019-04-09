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
import com.baidu.tbadk.util.e;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MutiImgMutiPicLayout extends LinearLayout implements i<com.baidu.tbadk.core.data.a> {
    public TextView XL;
    private com.baidu.tbadk.core.data.a Xz;
    private ab<com.baidu.tbadk.core.data.a> YC;
    private boolean ZR;
    public PlayVoiceBntNew aaa;
    private boolean aac;
    private boolean aad;
    private d aaf;
    private LinkedList<MediaData> aag;
    private int aam;
    public RelativeLayout aap;
    public TbImageView aaq;
    public TbImageView aar;
    public TbImageView aas;
    private TextView aau;
    private String mFrom;
    public TextView mTitle;
    private static final int ZX = l.h(TbadkCoreApplication.getInst(), d.e.tbds26);
    private static final int ZY = l.h(TbadkCoreApplication.getInst(), d.e.tbds20);
    private static final int ZZ = l.h(TbadkCoreApplication.getInst(), d.e.tbds7);
    private static final int XJ = l.aO(TbadkCoreApplication.getInst()) - (l.h(TbadkCoreApplication.getInst(), d.e.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMutiPicLayout(Context context) {
        this(context, null);
    }

    public MutiImgMutiPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZR = true;
        this.Xz = null;
        this.aac = false;
        this.aad = false;
        this.aam = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.XL = (TextView) findViewById(d.g.thread_card_abstract);
        this.mTitle = (TextView) findViewById(d.g.thread_card_title);
        this.aaa = (PlayVoiceBntNew) findViewById(d.g.thread_card_voice);
        this.aaa.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMutiPicLayout.this.Xz);
                }
            }
        });
        this.aap = (RelativeLayout) findViewById(d.g.thread_card_img_more_container);
        this.aaq = (TbImageView) findViewById(d.g.thread_card_img_more_one);
        this.aaq.setDrawCorner(true);
        this.aaq.setRadius(l.h(getContext(), d.e.tbds20));
        this.aaq.setDefaultBgResource(e.get());
        this.aaq.setConrers(5);
        this.aar = (TbImageView) findViewById(d.g.thread_card_img_more_two);
        this.aar.setDrawCorner(false);
        this.aar.setDefaultBgResource(e.get());
        this.aar.setRadius(0);
        this.aar.setConrers(0);
        this.aas = (TbImageView) findViewById(d.g.thread_card_img_more_three);
        this.aas.setDrawCorner(true);
        this.aas.setDefaultBgResource(e.get());
        this.aas.setRadius(l.h(getContext(), d.e.tbds20));
        this.aas.setConrers(10);
        this.aau = (TextView) findViewById(d.g.thread_card_img_more_label);
        this.aaf = new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMutiPicLayout.this.Xz.objType = 2;
                    subClickListener.Zx = Boolean.valueOf(z);
                    subClickListener.a(view, MutiImgMutiPicLayout.this.Xz);
                }
                au.a(view, MutiImgMutiPicLayout.this.ZR, MutiImgMutiPicLayout.this.aag, i, MutiImgMutiPicLayout.this.Xz.WO(), MutiImgMutiPicLayout.this.mFrom);
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
        boolean z;
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
            if (linkedList.size() > 3) {
                this.aau.setText(TbadkCoreApplication.getInst().getString(d.j.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.aau.setVisibility(0);
                z = true;
            } else {
                this.aau.setVisibility(8);
                z = false;
            }
            this.aap.setVisibility(8);
            if (v.S(linkedList) == 2) {
                this.aap.setVisibility(0);
                a((MediaData) v.c(YY, 0), this.aaq, z, false, 0);
                this.aar.setVisibility(8);
                a((MediaData) v.c(YY, 1), this.aas, z, false, 1);
                return;
            } else if (v.S(linkedList) >= 3) {
                this.aap.setVisibility(0);
                this.aar.setVisibility(0);
                a((MediaData) v.c(YY, 0), this.aaq, z, false, 0);
                a((MediaData) v.c(YY, 1), this.aar, z, false, 1);
                a((MediaData) v.c(YY, 2), this.aas, z, true, 2);
                return;
            } else {
                this.aap.setVisibility(8);
                this.aac = false;
                return;
            }
        }
        this.aap.setVisibility(8);
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
        int bC = bC(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aaq.getLayoutParams();
        layoutParams.width = bC;
        layoutParams.height = bC;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aar.getLayoutParams();
        layoutParams2.width = bC;
        layoutParams2.height = bC;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.aas.getLayoutParams();
        layoutParams3.width = bC;
        layoutParams3.height = bC;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.aau.getLayoutParams();
        layoutParams4.width = bC;
        layoutParams4.height = bC;
        if (this.aap.getVisibility() != 8) {
            this.aaq.setLayoutParams(layoutParams);
            this.aar.setLayoutParams(layoutParams2);
            this.aas.setLayoutParams(layoutParams3);
            this.aau.setLayoutParams(layoutParams4);
        }
    }

    private int bC(int i) {
        if (this.aam > 0) {
            return this.aam;
        }
        this.aam = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds10) * 2)) / 3;
        return this.aam;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
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
        if (z2 && z) {
            tbImageView.setLongIconSupport(false);
            tbImageView.setGifIconSupport(false);
        } else {
            tbImageView.setLongIconSupport(true);
            tbImageView.setGifIconSupport(true);
        }
        tbImageView.startLoad(a2, i2, false);
        a(tbImageView, i, z, z2);
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
            if (MutiImgMutiPicLayout.this.aaf != null) {
                MutiImgMutiPicLayout.this.aaf.a(view, this.currentIndex, this.hasMore && this.aao);
            }
        }
    }
}

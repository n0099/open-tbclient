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
    public TextView XK;
    private com.baidu.tbadk.core.data.a Xy;
    private ab<com.baidu.tbadk.core.data.a> YB;
    private boolean ZP;
    public PlayVoiceBntNew ZY;
    private boolean aaa;
    private boolean aab;
    private d aad;
    private LinkedList<MediaData> aae;
    private int aak;
    public RelativeLayout aan;
    public TbImageView aao;
    public TbImageView aap;
    public TbImageView aaq;
    private TextView aas;
    private String mFrom;
    public TextView mTitle;
    private static final int ZV = l.h(TbadkCoreApplication.getInst(), d.e.tbds26);
    private static final int ZW = l.h(TbadkCoreApplication.getInst(), d.e.tbds20);
    private static final int ZX = l.h(TbadkCoreApplication.getInst(), d.e.tbds7);
    private static final int XI = l.aO(TbadkCoreApplication.getInst()) - (l.h(TbadkCoreApplication.getInst(), d.e.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMutiPicLayout(Context context) {
        this(context, null);
    }

    public MutiImgMutiPicLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZP = true;
        this.Xy = null;
        this.aaa = false;
        this.aab = false;
        this.aak = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.XK = (TextView) findViewById(d.g.thread_card_abstract);
        this.mTitle = (TextView) findViewById(d.g.thread_card_title);
        this.ZY = (PlayVoiceBntNew) findViewById(d.g.thread_card_voice);
        this.ZY.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMutiPicLayout.this.Xy);
                }
            }
        });
        this.aan = (RelativeLayout) findViewById(d.g.thread_card_img_more_container);
        this.aao = (TbImageView) findViewById(d.g.thread_card_img_more_one);
        this.aao.setDrawCorner(true);
        this.aao.setRadius(l.h(getContext(), d.e.tbds20));
        this.aao.setDefaultBgResource(e.get());
        this.aao.setConrers(5);
        this.aap = (TbImageView) findViewById(d.g.thread_card_img_more_two);
        this.aap.setDrawCorner(false);
        this.aap.setDefaultBgResource(e.get());
        this.aap.setRadius(0);
        this.aap.setConrers(0);
        this.aaq = (TbImageView) findViewById(d.g.thread_card_img_more_three);
        this.aaq.setDrawCorner(true);
        this.aaq.setDefaultBgResource(e.get());
        this.aaq.setRadius(l.h(getContext(), d.e.tbds20));
        this.aaq.setConrers(10);
        this.aas = (TextView) findViewById(d.g.thread_card_img_more_label);
        this.aad = new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.card.view.MutiImgMutiPicLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMutiPicLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMutiPicLayout.this.Xy.objType = 2;
                    subClickListener.Zw = Boolean.valueOf(z);
                    subClickListener.a(view, MutiImgMutiPicLayout.this.Xy);
                }
                au.a(view, MutiImgMutiPicLayout.this.ZP, MutiImgMutiPicLayout.this.aae, i, MutiImgMutiPicLayout.this.Xy.WR(), MutiImgMutiPicLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bg bgVar) {
        ArrayList<VoiceData.VoiceModel> Zf = bgVar.Zf();
        if (v.T(Zf)) {
            this.ZY.setVisibility(8);
            this.aab = false;
            return;
        }
        this.ZY.setVisibility(0);
        VoiceData.VoiceModel voiceModel = Zf.get(0);
        this.ZY.setVoiceModel(voiceModel);
        this.ZY.setTag(voiceModel);
        this.ZY.bxV();
        if (voiceModel != null) {
            this.ZY.uu(voiceModel.voice_status.intValue());
        }
        this.ZY.cfD();
        this.aab = true;
    }

    private void setImageData(bg bgVar) {
        boolean z;
        ArrayList<MediaData> Zb = bgVar.Zb();
        if (com.baidu.tbadk.core.i.Wy().WC() && v.S(Zb) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < Zb.size(); i++) {
                MediaData mediaData = (MediaData) v.c(Zb, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.aae = linkedList;
            this.aaa = true;
            if (linkedList.size() > 3) {
                this.aas.setText(TbadkCoreApplication.getInst().getString(d.j.constrain_image_extra_text, new Object[]{Integer.valueOf(linkedList.size() - 3)}));
                this.aas.setVisibility(0);
                z = true;
            } else {
                this.aas.setVisibility(8);
                z = false;
            }
            this.aan.setVisibility(8);
            if (v.S(linkedList) == 2) {
                this.aan.setVisibility(0);
                a((MediaData) v.c(Zb, 0), this.aao, z, false, 0);
                this.aap.setVisibility(8);
                a((MediaData) v.c(Zb, 1), this.aaq, z, false, 1);
                return;
            } else if (v.S(linkedList) >= 3) {
                this.aan.setVisibility(0);
                this.aap.setVisibility(0);
                a((MediaData) v.c(Zb, 0), this.aao, z, false, 0);
                a((MediaData) v.c(Zb, 1), this.aap, z, false, 1);
                a((MediaData) v.c(Zb, 2), this.aaq, z, true, 2);
                return;
            } else {
                this.aan.setVisibility(8);
                this.aaa = false;
                return;
            }
        }
        this.aan.setVisibility(8);
        this.aaa = false;
    }

    public void setFromCDN(boolean z) {
        this.ZP = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Xy = aVar;
        bg WR = aVar.WR();
        au.a(this.mTitle, WR);
        au.a(this.XK, this.mTitle, WR, XI);
        setImageData(WR);
        setVoiceData(WR);
        rB();
    }

    private void rB() {
        if (this.XK.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.aaa) {
                setMarginsTop(this.ZY, ZV);
            } else if (this.aab) {
                setMarginsTop(this.ZY, ZX);
            }
        } else if (this.ZY != null && this.ZY.getLayoutParams() != null) {
            if (this.aaa) {
                setMarginsTop(this.ZY, ZV);
            } else if (this.aab) {
                setMarginsTop(this.ZY, ZW);
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
        return this.YB;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.YB = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bD = bD(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aao.getLayoutParams();
        layoutParams.width = bD;
        layoutParams.height = bD;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aap.getLayoutParams();
        layoutParams2.width = bD;
        layoutParams2.height = bD;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.aaq.getLayoutParams();
        layoutParams3.width = bD;
        layoutParams3.height = bD;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.aas.getLayoutParams();
        layoutParams4.width = bD;
        layoutParams4.height = bD;
        if (this.aan.getVisibility() != 8) {
            this.aao.setLayoutParams(layoutParams);
            this.aap.setLayoutParams(layoutParams2);
            this.aaq.setLayoutParams(layoutParams3);
            this.aas.setLayoutParams(layoutParams4);
        }
    }

    private int bD(int i) {
        if (this.aak > 0) {
            return this.aak;
        }
        this.aak = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds10) * 2)) / 3;
        return this.aak;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, int i) {
        String a2 = a(mediaData);
        int i2 = this.ZP ? 13 : 14;
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
        if (this.aad != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.aad == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private boolean aam;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.aam = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMutiPicLayout.this.aad != null) {
                MutiImgMutiPicLayout.this.aad.a(view, this.currentIndex, this.hasMore && this.aam);
            }
        }
    }
}

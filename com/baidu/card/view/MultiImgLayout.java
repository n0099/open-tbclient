package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.e.b;
import com.baidu.adp.lib.util.l;
import com.baidu.card.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImgLayout extends LinearLayout implements i<a> {
    public TextView XL;
    private a Xz;
    private ab<a> YC;
    private boolean ZR;
    public PlayVoiceBntNew aaa;
    public ConstrainImageGroup aab;
    private boolean aac;
    private boolean aad;
    private boolean aae;
    private d aaf;
    private LinkedList<MediaData> aag;
    private String mFrom;
    public TextView mTitle;
    private static final int ZX = l.h(TbadkCoreApplication.getInst(), d.e.tbds26);
    private static final int ZY = l.h(TbadkCoreApplication.getInst(), d.e.tbds20);
    private static final int ZZ = l.h(TbadkCoreApplication.getInst(), d.e.tbds7);
    private static final int XJ = l.aO(TbadkCoreApplication.getInst()) - (l.h(TbadkCoreApplication.getInst(), d.e.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZR = true;
        this.Xz = null;
        this.aac = false;
        this.aad = false;
        this.aae = true;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.XL = (TextView) findViewById(d.g.thread_card_abstract);
        this.mTitle = (TextView) findViewById(d.g.thread_card_title);
        this.aaa = (PlayVoiceBntNew) findViewById(d.g.thread_card_voice);
        this.aaa.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.Xz);
                }
            }
        });
        this.aaf = new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.card.view.MultiImgLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, boolean z) {
                ab<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MultiImgLayout.this.Xz.objType = 2;
                    subClickListener.Zx = Boolean.valueOf(z);
                    subClickListener.a(view, MultiImgLayout.this.Xz);
                    MultiImgLayout.this.Xz.objType = 1;
                }
                au.a(view, MultiImgLayout.this.ZR, MultiImgLayout.this.aag, i, MultiImgLayout.this.Xz.WO(), MultiImgLayout.this.mFrom);
            }
        };
        this.aab = (ConstrainImageGroup) findViewById(d.g.thread_card_img_group);
        this.aab.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds10));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.aab.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.aab != null) {
            this.aab.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.aab != null) {
            this.aab.setImageViewPool(bVar);
        }
    }

    public void setConstrainImageClick(boolean z) {
        this.aae = z;
    }

    public void setSingleImageRatio(double d) {
        if (this.aab != null) {
            this.aab.setSingleImageRatio(d);
        }
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
        this.aab.setFromCDN(this.ZR);
        this.aab.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> YY = bgVar.YY();
        if (com.baidu.tbadk.core.i.Wv().Wz() && v.S(YY) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < YY.size(); i++) {
                MediaData mediaData = (MediaData) v.c(YY, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.S(linkedList) > 0) {
                this.aab.setVisibility(0);
                this.aab.setFromCDN(this.ZR);
                this.aab.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.card.view.MultiImgLayout.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.YC == null || !MultiImgLayout.this.YC.a(view, (View) MultiImgLayout.this.Xz, "")) {
                            ab<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.Xz.objType = 2;
                                subClickListener.Zx = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.Xz);
                                MultiImgLayout.this.Xz.objType = 1;
                            }
                            au.a(view, MultiImgLayout.this.ZR, linkedList, i2, MultiImgLayout.this.Xz.WO(), MultiImgLayout.this.mFrom);
                        }
                    }
                });
                this.aab.setImageMediaList(linkedList);
                this.aac = true;
            } else {
                this.aab.setVisibility(8);
                this.aac = false;
            }
            this.aag = linkedList;
            return;
        }
        this.aab.setVisibility(8);
        this.aac = false;
    }

    public void setFromCDN(boolean z) {
        this.ZR = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.aab.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(a aVar) {
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
                setMarginsTop(this.aab, ZZ);
            } else if (this.aad) {
                setMarginsTop(this.aaa, ZZ);
                setMarginsTop(this.aab, ZY);
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

    public ab<a> getSubClickListener() {
        return this.YC;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.YC = abVar;
    }
}

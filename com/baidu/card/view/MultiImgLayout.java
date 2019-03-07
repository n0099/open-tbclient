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
    public TextView XJ;
    private a Xx;
    private ab<a> YA;
    private boolean ZO;
    public PlayVoiceBntNew ZX;
    public ConstrainImageGroup ZY;
    private boolean ZZ;
    private boolean aaa;
    private boolean aab;
    private d aac;
    private LinkedList<MediaData> aad;
    private String mFrom;
    public TextView mTitle;
    private static final int ZU = l.h(TbadkCoreApplication.getInst(), d.e.tbds26);
    private static final int ZV = l.h(TbadkCoreApplication.getInst(), d.e.tbds20);
    private static final int ZW = l.h(TbadkCoreApplication.getInst(), d.e.tbds7);
    private static final int XH = l.aO(TbadkCoreApplication.getInst()) - (l.h(TbadkCoreApplication.getInst(), d.e.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZO = true;
        this.Xx = null;
        this.ZZ = false;
        this.aaa = false;
        this.aab = true;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.XJ = (TextView) findViewById(d.g.thread_card_abstract);
        this.mTitle = (TextView) findViewById(d.g.thread_card_title);
        this.ZX = (PlayVoiceBntNew) findViewById(d.g.thread_card_voice);
        this.ZX.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.Xx);
                }
            }
        });
        this.aac = new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.card.view.MultiImgLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, boolean z) {
                ab<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MultiImgLayout.this.Xx.objType = 2;
                    subClickListener.a(view, MultiImgLayout.this.Xx);
                    MultiImgLayout.this.Xx.objType = 1;
                }
                au.a(view, MultiImgLayout.this.ZO, MultiImgLayout.this.aad, i, MultiImgLayout.this.Xx.WR(), MultiImgLayout.this.mFrom);
            }
        };
        this.ZY = (ConstrainImageGroup) findViewById(d.g.thread_card_img_group);
        this.ZY.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds10));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.ZY.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.ZY != null) {
            this.ZY.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.ZY != null) {
            this.ZY.setImageViewPool(bVar);
        }
    }

    public void setConstrainImageClick(boolean z) {
        this.aab = z;
    }

    public void setSingleImageRatio(double d) {
        if (this.ZY != null) {
            this.ZY.setSingleImageRatio(d);
        }
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
        this.ZY.setFromCDN(this.ZO);
        this.ZY.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> Zb = bgVar.Zb();
        if (com.baidu.tbadk.core.i.Wy().WC() && v.S(Zb) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < Zb.size(); i++) {
                MediaData mediaData = (MediaData) v.c(Zb, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.S(linkedList) > 0) {
                this.ZY.setVisibility(0);
                this.ZY.setFromCDN(this.ZO);
                this.ZY.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.card.view.MultiImgLayout.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.YA == null || !MultiImgLayout.this.YA.a(view, (View) MultiImgLayout.this.Xx, "")) {
                            ab<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.Xx.objType = 2;
                                subClickListener.a(view, MultiImgLayout.this.Xx);
                                MultiImgLayout.this.Xx.objType = 1;
                            }
                            au.a(view, MultiImgLayout.this.ZO, linkedList, i2, MultiImgLayout.this.Xx.WR(), MultiImgLayout.this.mFrom);
                        }
                    }
                });
                this.ZY.setImageMediaList(linkedList);
                this.ZZ = true;
            } else {
                this.ZY.setVisibility(8);
                this.ZZ = false;
            }
            this.aad = linkedList;
            return;
        }
        this.ZY.setVisibility(8);
        this.ZZ = false;
    }

    public void setFromCDN(boolean z) {
        this.ZO = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.ZY.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(a aVar) {
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
                setMarginsTop(this.ZY, ZW);
            } else if (this.aaa) {
                setMarginsTop(this.ZX, ZW);
                setMarginsTop(this.ZY, ZV);
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

    public ab<a> getSubClickListener() {
        return this.YA;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.YA = abVar;
    }
}

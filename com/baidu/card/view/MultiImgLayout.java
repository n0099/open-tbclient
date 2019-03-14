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
    public TextView XK;
    private a Xy;
    private ab<a> YB;
    private boolean ZP;
    public PlayVoiceBntNew ZY;
    public ConstrainImageGroup ZZ;
    private boolean aaa;
    private boolean aab;
    private boolean aac;
    private d aad;
    private LinkedList<MediaData> aae;
    private String mFrom;
    public TextView mTitle;
    private static final int ZV = l.h(TbadkCoreApplication.getInst(), d.e.tbds26);
    private static final int ZW = l.h(TbadkCoreApplication.getInst(), d.e.tbds20);
    private static final int ZX = l.h(TbadkCoreApplication.getInst(), d.e.tbds7);
    private static final int XI = l.aO(TbadkCoreApplication.getInst()) - (l.h(TbadkCoreApplication.getInst(), d.e.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZP = true;
        this.Xy = null;
        this.aaa = false;
        this.aab = false;
        this.aac = true;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.XK = (TextView) findViewById(d.g.thread_card_abstract);
        this.mTitle = (TextView) findViewById(d.g.thread_card_title);
        this.ZY = (PlayVoiceBntNew) findViewById(d.g.thread_card_voice);
        this.ZY.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.Xy);
                }
            }
        });
        this.aad = new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.card.view.MultiImgLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, boolean z) {
                ab<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MultiImgLayout.this.Xy.objType = 2;
                    subClickListener.Zw = Boolean.valueOf(z);
                    subClickListener.a(view, MultiImgLayout.this.Xy);
                    MultiImgLayout.this.Xy.objType = 1;
                }
                au.a(view, MultiImgLayout.this.ZP, MultiImgLayout.this.aae, i, MultiImgLayout.this.Xy.WR(), MultiImgLayout.this.mFrom);
            }
        };
        this.ZZ = (ConstrainImageGroup) findViewById(d.g.thread_card_img_group);
        this.ZZ.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds10));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.ZZ.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.ZZ != null) {
            this.ZZ.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.ZZ != null) {
            this.ZZ.setImageViewPool(bVar);
        }
    }

    public void setConstrainImageClick(boolean z) {
        this.aac = z;
    }

    public void setSingleImageRatio(double d) {
        if (this.ZZ != null) {
            this.ZZ.setSingleImageRatio(d);
        }
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
        this.ZZ.setFromCDN(this.ZP);
        this.ZZ.setSinglePicUseStyleV10(true);
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
                this.ZZ.setVisibility(0);
                this.ZZ.setFromCDN(this.ZP);
                this.ZZ.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.card.view.MultiImgLayout.3
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.YB == null || !MultiImgLayout.this.YB.a(view, (View) MultiImgLayout.this.Xy, "")) {
                            ab<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.Xy.objType = 2;
                                subClickListener.Zw = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.Xy);
                                MultiImgLayout.this.Xy.objType = 1;
                            }
                            au.a(view, MultiImgLayout.this.ZP, linkedList, i2, MultiImgLayout.this.Xy.WR(), MultiImgLayout.this.mFrom);
                        }
                    }
                });
                this.ZZ.setImageMediaList(linkedList);
                this.aaa = true;
            } else {
                this.ZZ.setVisibility(8);
                this.aaa = false;
            }
            this.aae = linkedList;
            return;
        }
        this.ZZ.setVisibility(8);
        this.aaa = false;
    }

    public void setFromCDN(boolean z) {
        this.ZP = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.ZZ.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(a aVar) {
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
                setMarginsTop(this.ZZ, ZX);
            } else if (this.aab) {
                setMarginsTop(this.ZY, ZX);
                setMarginsTop(this.ZZ, ZW);
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

    public ab<a> getSubClickListener() {
        return this.YB;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.YB = abVar;
    }
}

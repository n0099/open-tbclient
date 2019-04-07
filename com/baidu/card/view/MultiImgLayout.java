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
    private boolean ZQ;
    public PlayVoiceBntNew ZZ;
    public ConstrainImageGroup aaa;
    private boolean aab;
    private boolean aac;
    private boolean aad;
    private d aae;
    private LinkedList<MediaData> aaf;
    private String mFrom;
    public TextView mTitle;
    private static final int ZW = l.h(TbadkCoreApplication.getInst(), d.e.tbds26);
    private static final int ZX = l.h(TbadkCoreApplication.getInst(), d.e.tbds20);
    private static final int ZY = l.h(TbadkCoreApplication.getInst(), d.e.tbds7);
    private static final int XI = l.aO(TbadkCoreApplication.getInst()) - (l.h(TbadkCoreApplication.getInst(), d.e.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZQ = true;
        this.Xy = null;
        this.aab = false;
        this.aac = false;
        this.aad = true;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.XK = (TextView) findViewById(d.g.thread_card_abstract);
        this.mTitle = (TextView) findViewById(d.g.thread_card_title);
        this.ZZ = (PlayVoiceBntNew) findViewById(d.g.thread_card_voice);
        this.ZZ.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.Xy);
                }
            }
        });
        this.aae = new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.card.view.MultiImgLayout.2
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
                au.a(view, MultiImgLayout.this.ZQ, MultiImgLayout.this.aaf, i, MultiImgLayout.this.Xy.WO(), MultiImgLayout.this.mFrom);
            }
        };
        this.aaa = (ConstrainImageGroup) findViewById(d.g.thread_card_img_group);
        this.aaa.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds10));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.aaa.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.aaa != null) {
            this.aaa.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.aaa != null) {
            this.aaa.setImageViewPool(bVar);
        }
    }

    public void setConstrainImageClick(boolean z) {
        this.aad = z;
    }

    public void setSingleImageRatio(double d) {
        if (this.aaa != null) {
            this.aaa.setSingleImageRatio(d);
        }
    }

    private void setVoiceData(bg bgVar) {
        ArrayList<VoiceData.VoiceModel> Zc = bgVar.Zc();
        if (v.T(Zc)) {
            this.ZZ.setVisibility(8);
            this.aac = false;
            return;
        }
        this.ZZ.setVisibility(0);
        VoiceData.VoiceModel voiceModel = Zc.get(0);
        this.ZZ.setVoiceModel(voiceModel);
        this.ZZ.setTag(voiceModel);
        this.ZZ.bxS();
        if (voiceModel != null) {
            this.ZZ.uq(voiceModel.voice_status.intValue());
        }
        this.ZZ.cfz();
        this.aac = true;
    }

    private void setImageData(bg bgVar) {
        this.aaa.setFromCDN(this.ZQ);
        this.aaa.setSinglePicUseStyleV10(true);
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
                this.aaa.setVisibility(0);
                this.aaa.setFromCDN(this.ZQ);
                this.aaa.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.card.view.MultiImgLayout.3
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
                            au.a(view, MultiImgLayout.this.ZQ, linkedList, i2, MultiImgLayout.this.Xy.WO(), MultiImgLayout.this.mFrom);
                        }
                    }
                });
                this.aaa.setImageMediaList(linkedList);
                this.aab = true;
            } else {
                this.aaa.setVisibility(8);
                this.aab = false;
            }
            this.aaf = linkedList;
            return;
        }
        this.aaa.setVisibility(8);
        this.aab = false;
    }

    public void setFromCDN(boolean z) {
        this.ZQ = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.aaa.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(a aVar) {
        this.Xy = aVar;
        bg WO = aVar.WO();
        au.a(this.mTitle, WO);
        au.a(this.XK, this.mTitle, WO, XI);
        setImageData(WO);
        setVoiceData(WO);
        rB();
    }

    private void rB() {
        if (this.XK.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.aab) {
                setMarginsTop(this.ZZ, ZW);
                setMarginsTop(this.aaa, ZY);
            } else if (this.aac) {
                setMarginsTop(this.ZZ, ZY);
                setMarginsTop(this.aaa, ZX);
            }
        } else if (this.ZZ != null && this.ZZ.getLayoutParams() != null) {
            if (this.aab) {
                setMarginsTop(this.ZZ, ZW);
            } else if (this.aac) {
                setMarginsTop(this.ZZ, ZX);
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

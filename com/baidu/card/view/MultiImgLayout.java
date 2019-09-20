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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImgLayout extends LinearLayout implements i<a> {
    private a VI;
    public TextView VV;
    private ab<a> WN;
    private boolean Yd;
    public PlayVoiceBntNew Ym;
    public ConstrainImageGroup Yn;
    private boolean Yo;
    private boolean Yp;
    private LinkedList<MediaData> Yq;
    private String mFrom;
    public TextView mTitle;
    private static final int Yj = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int Yk = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int Yl = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int VT = l.af(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Yd = true;
        this.VI = null;
        this.Yo = false;
        this.Yp = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.VV = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.Ym = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.Ym.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.VI);
                }
            }
        });
        this.Yn = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.Yn.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.Yn.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.Yn != null) {
            this.Yn.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.Yn != null) {
            this.Yn.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.Yn != null) {
            this.Yn.setSingleImageRatio(d);
        }
    }

    private void setVoiceData(bh bhVar) {
        ArrayList<VoiceData.VoiceModel> aeQ = bhVar.aeQ();
        if (v.aa(aeQ)) {
            this.Ym.setVisibility(8);
            this.Yp = false;
            return;
        }
        this.Ym.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aeQ.get(0);
        this.Ym.setVoiceModel(voiceModel);
        this.Ym.setTag(voiceModel);
        this.Ym.bql();
        if (voiceModel != null) {
            this.Ym.we(voiceModel.voice_status.intValue());
        }
        this.Ym.crJ();
        this.Yp = true;
    }

    private void setImageData(bh bhVar) {
        this.Yn.setFromCDN(this.Yd);
        this.Yn.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> aeM = bhVar.aeM();
        if (com.baidu.tbadk.core.i.ace().aci() && v.Z(aeM) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aeM.size(); i++) {
                MediaData mediaData = (MediaData) v.c(aeM, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.Z(linkedList) > 0) {
                this.Yn.setVisibility(0);
                this.Yn.setFromCDN(this.Yd);
                this.Yn.setImageClickListener(new d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.WN == null || !MultiImgLayout.this.WN.a(view, (View) MultiImgLayout.this.VI, "")) {
                            ab<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.VI.objType = 2;
                                subClickListener.XI = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.VI);
                                MultiImgLayout.this.VI.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().cgL) {
                                au.a(view, MultiImgLayout.this.Yd, linkedList, i2, MultiImgLayout.this.VI.acC(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                au.a(MultiImgLayout.this.VI, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                au.a(MultiImgLayout.this.VI, view.getContext(), 2, false);
                            } else {
                                au.a(view, MultiImgLayout.this.Yd, linkedList, i2, MultiImgLayout.this.VI.acC(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.Yn.setImageMediaList(linkedList);
                this.Yo = true;
            } else {
                this.Yn.setVisibility(8);
                this.Yo = false;
            }
            this.Yq = linkedList;
            return;
        }
        this.Yn.setVisibility(8);
        this.Yo = false;
    }

    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.Yn.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(a aVar) {
        this.VI = aVar;
        bh acC = aVar.acC();
        au.a(this.mTitle, acC);
        au.a(this.VV, this.mTitle, acC, VT);
        setImageData(acC);
        setVoiceData(acC);
        qU();
    }

    private void qU() {
        if (this.VV.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Yo) {
                setMarginsTop(this.Ym, Yj);
                setMarginsTop(this.Yn, Yl);
            } else if (this.Yp) {
                setMarginsTop(this.Ym, Yl);
                setMarginsTop(this.Yn, Yk);
            }
        } else if (this.Ym != null && this.Ym.getLayoutParams() != null) {
            if (this.Yo) {
                setMarginsTop(this.Ym, Yj);
            } else if (this.Yp) {
                setMarginsTop(this.Ym, Yk);
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
        return this.WN;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.WN = abVar;
    }
}

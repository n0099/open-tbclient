package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.d.b;
import com.baidu.adp.lib.util.l;
import com.baidu.card.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class MultiImgLayout extends LinearLayout implements m<com.baidu.tbadk.core.data.a> {
    public TextView KA;
    private com.baidu.tbadk.core.data.a Kc;
    private z<com.baidu.tbadk.core.data.a> LD;
    private boolean NJ;
    public PlayVoiceBntNew NY;
    public ConstrainImageGroup NZ;
    private boolean Oa;
    private boolean Ob;
    private LinkedList<MediaData> Oc;
    private String mFrom;
    public TextView mTitle;
    private static final int NV = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int NW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int NX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int Ky = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NJ = true;
        this.Kc = null;
        this.Oa = false;
        this.Ob = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.KA = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.NY = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.NY.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.Kc);
                }
            }
        });
        this.NZ = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.NZ.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.NZ.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.NZ != null) {
            this.NZ.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.NZ != null) {
            this.NZ.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.NZ != null) {
            this.NZ.setSingleImageRatio(d);
        }
    }

    private void setVoiceData(bj bjVar) {
        ArrayList<VoiceData.VoiceModel> aCC = bjVar.aCC();
        if (v.isEmpty(aCC)) {
            this.NY.setVisibility(8);
            this.Ob = false;
            return;
        }
        this.NY.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aCC.get(0);
        this.NY.setVoiceModel(voiceModel);
        this.NY.setTag(voiceModel);
        this.NY.bHt();
        if (voiceModel != null) {
            this.NY.wW(voiceModel.voice_status.intValue());
        }
        this.NY.cMi();
        this.Ob = true;
    }

    private void setImageData(bj bjVar) {
        this.NZ.setFromCDN(this.NJ);
        this.NZ.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> aCy = bjVar.aCy();
        if (i.azO().isShowImages() && v.getCount(aCy) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aCy.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aCy, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.NZ.setVisibility(0);
                this.NZ.setFromCDN(this.NJ);
                this.NZ.setImageClickListener(new d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.LD == null || !MultiImgLayout.this.LD.a(view, (View) MultiImgLayout.this.Kc, "")) {
                            z<com.baidu.tbadk.core.data.a> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.Kc.objType = 2;
                                subClickListener.MU = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.Kc);
                                MultiImgLayout.this.Kc.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().dmk) {
                                au.a(view, MultiImgLayout.this.NJ, linkedList, i2, MultiImgLayout.this.Kc.aAg(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                au.a(MultiImgLayout.this.Kc, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                au.a(MultiImgLayout.this.Kc, view.getContext(), 2, false);
                            } else {
                                au.a(view, MultiImgLayout.this.NJ, linkedList, i2, MultiImgLayout.this.Kc.aAg(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.NZ.setImageMediaList(linkedList);
                this.Oa = true;
            } else {
                this.NZ.setVisibility(8);
                this.Oa = false;
            }
            this.Oc = linkedList;
            return;
        }
        this.NZ.setVisibility(8);
        this.Oa = false;
    }

    public void setFromCDN(boolean z) {
        this.NJ = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.NZ.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.Kc = aVar;
        bj aAg = aVar.aAg();
        au.a(this.mTitle, aAg);
        au.a(this.KA, this.mTitle, aAg, Ky);
        setImageData(aAg);
        setVoiceData(aAg);
        nn();
    }

    private void nn() {
        if (this.KA.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Oa) {
                setMarginsTop(this.NY, NV);
                setMarginsTop(this.NZ, NX);
            } else if (this.Ob) {
                setMarginsTop(this.NY, NX);
                setMarginsTop(this.NZ, NW);
            }
        } else if (this.NY != null && this.NY.getLayoutParams() != null) {
            if (this.Oa) {
                setMarginsTop(this.NY, NV);
            } else if (this.Ob) {
                setMarginsTop(this.NY, NW);
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

    public z<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.LD;
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.LD = zVar;
    }
}

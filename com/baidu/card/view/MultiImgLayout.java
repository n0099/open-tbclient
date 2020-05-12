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
    public TextView adB;
    private com.baidu.tbadk.core.data.a ade;
    private z<com.baidu.tbadk.core.data.a> aeC;
    private boolean afo;
    public PlayVoiceBntNew agJ;
    public ConstrainImageGroup agK;
    private boolean agL;
    private boolean agM;
    private LinkedList<MediaData> agN;
    private boolean agw;
    private String mFrom;
    public TextView mTitle;
    private static final int agG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int agH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int agI = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int adz = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agw = true;
        this.ade = null;
        this.agL = false;
        this.agM = false;
        this.afo = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.adB = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.agJ = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.agJ.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.ade);
                }
            }
        });
        this.agK = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.agK.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.n(1.0d);
        this.agK.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.agK != null) {
            this.agK.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.agK != null) {
            this.agK.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.agK != null) {
            this.agK.setSingleImageRatio(d);
        }
    }

    private void setVoiceData(bj bjVar) {
        ArrayList<VoiceData.VoiceModel> aKQ = bjVar.aKQ();
        if (v.isEmpty(aKQ)) {
            this.agJ.setVisibility(8);
            this.agM = false;
            return;
        }
        this.agJ.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aKQ.get(0);
        this.agJ.setVoiceModel(voiceModel);
        this.agJ.setTag(voiceModel);
        this.agJ.ckN();
        if (voiceModel != null) {
            this.agJ.xC(voiceModel.voice_status.intValue());
        }
        this.agJ.cXx();
        this.agM = true;
    }

    private void setImageData(bj bjVar) {
        this.agK.setFromCDN(this.agw);
        this.agK.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> aKM = bjVar.aKM();
        if (i.aIc().isShowImages() && v.getCount(aKM) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aKM.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aKM, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.agK.setVisibility(0);
                this.agK.setFromCDN(this.agw);
                this.agK.setImageClickListener(new d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.aeC == null || !MultiImgLayout.this.aeC.a(view, (View) MultiImgLayout.this.ade, "")) {
                            z<com.baidu.tbadk.core.data.a> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.ade.objType = 2;
                                subClickListener.afJ = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.ade);
                                MultiImgLayout.this.ade.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().dMw) {
                                au.a(view, MultiImgLayout.this.agw, linkedList, i2, MultiImgLayout.this.ade.aIu(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                au.a(MultiImgLayout.this.ade, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                au.a(MultiImgLayout.this.ade, view.getContext(), 2, false);
                            } else {
                                au.a(view, MultiImgLayout.this.agw, linkedList, i2, MultiImgLayout.this.ade.aIu(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.agK.setImageMediaList(linkedList);
                this.agL = true;
            } else {
                this.agK.setVisibility(8);
                this.agL = false;
            }
            this.agN = linkedList;
            return;
        }
        this.agK.setVisibility(8);
        this.agL = false;
    }

    public void setFromCDN(boolean z) {
        this.agw = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.agK.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        this.ade = aVar;
        bj aIu = aVar.aIu();
        au.a(this.mTitle, aIu, this.afo);
        au.a(this.adB, this.mTitle, aIu, adz, this.afo);
        setImageData(aIu);
        setVoiceData(aIu);
        rG();
    }

    private void rG() {
        if (this.adB.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.agL) {
                setMarginsTop(this.agJ, agG);
                setMarginsTop(this.agK, agI);
            } else if (this.agM) {
                setMarginsTop(this.agJ, agI);
                setMarginsTop(this.agK, agH);
            }
        } else if (this.agJ != null && this.agJ.getLayoutParams() != null) {
            if (this.agL) {
                setMarginsTop(this.agJ, agG);
            } else if (this.agM) {
                setMarginsTop(this.agJ, agH);
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
        return this.aeC;
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.aeC = zVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.afo = z;
    }
}

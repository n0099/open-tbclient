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
    private com.baidu.tbadk.core.data.a ada;
    public TextView ady;
    private z<com.baidu.tbadk.core.data.a> aez;
    private boolean afl;
    public PlayVoiceBntNew agG;
    public ConstrainImageGroup agH;
    private boolean agI;
    private boolean agJ;
    private LinkedList<MediaData> agK;
    private boolean agt;
    private String mFrom;
    public TextView mTitle;
    private static final int agD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int agE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int agF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int adw = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agt = true;
        this.ada = null;
        this.agI = false;
        this.agJ = false;
        this.afl = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ady = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.agG = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.agG.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.ada);
                }
            }
        });
        this.agH = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.agH.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.n(1.0d);
        this.agH.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.agH != null) {
            this.agH.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.agH != null) {
            this.agH.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.agH != null) {
            this.agH.setSingleImageRatio(d);
        }
    }

    private void setVoiceData(bj bjVar) {
        ArrayList<VoiceData.VoiceModel> aKS = bjVar.aKS();
        if (v.isEmpty(aKS)) {
            this.agG.setVisibility(8);
            this.agJ = false;
            return;
        }
        this.agG.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aKS.get(0);
        this.agG.setVoiceModel(voiceModel);
        this.agG.setTag(voiceModel);
        this.agG.ckO();
        if (voiceModel != null) {
            this.agG.xC(voiceModel.voice_status.intValue());
        }
        this.agG.cXz();
        this.agJ = true;
    }

    private void setImageData(bj bjVar) {
        this.agH.setFromCDN(this.agt);
        this.agH.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> aKO = bjVar.aKO();
        if (i.aIe().isShowImages() && v.getCount(aKO) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aKO.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aKO, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.agH.setVisibility(0);
                this.agH.setFromCDN(this.agt);
                this.agH.setImageClickListener(new d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.aez == null || !MultiImgLayout.this.aez.a(view, (View) MultiImgLayout.this.ada, "")) {
                            z<com.baidu.tbadk.core.data.a> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.ada.objType = 2;
                                subClickListener.afG = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.ada);
                                MultiImgLayout.this.ada.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().dMs) {
                                au.a(view, MultiImgLayout.this.agt, linkedList, i2, MultiImgLayout.this.ada.aIw(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                au.a(MultiImgLayout.this.ada, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                au.a(MultiImgLayout.this.ada, view.getContext(), 2, false);
                            } else {
                                au.a(view, MultiImgLayout.this.agt, linkedList, i2, MultiImgLayout.this.ada.aIw(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.agH.setImageMediaList(linkedList);
                this.agI = true;
            } else {
                this.agH.setVisibility(8);
                this.agI = false;
            }
            this.agK = linkedList;
            return;
        }
        this.agH.setVisibility(8);
        this.agI = false;
    }

    public void setFromCDN(boolean z) {
        this.agt = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.agH.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.ada = aVar;
        bj aIw = aVar.aIw();
        au.a(this.mTitle, aIw, this.afl);
        au.a(this.ady, this.mTitle, aIw, adw, this.afl);
        setImageData(aIw);
        setVoiceData(aIw);
        rG();
    }

    private void rG() {
        if (this.ady.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.agI) {
                setMarginsTop(this.agG, agD);
                setMarginsTop(this.agH, agF);
            } else if (this.agJ) {
                setMarginsTop(this.agG, agF);
                setMarginsTop(this.agH, agE);
            }
        } else if (this.agG != null && this.agG.getLayoutParams() != null) {
            if (this.agI) {
                setMarginsTop(this.agG, agD);
            } else if (this.agJ) {
                setMarginsTop(this.agG, agE);
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
        return this.aez;
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.aez = zVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.afl = z;
    }
}

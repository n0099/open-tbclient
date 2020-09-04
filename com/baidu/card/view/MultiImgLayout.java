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
import com.baidu.card.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes15.dex */
public class MultiImgLayout extends LinearLayout implements o<AbsThreadDataSupport> {
    private AbsThreadDataSupport aeY;
    public TextView afB;
    private aa<AbsThreadDataSupport> agK;
    private boolean ahx;
    public PlayVoiceBntNew ajF;
    public ConstrainImageGroup ajG;
    private boolean ajH;
    private boolean ajI;
    private LinkedList<MediaData> ajJ;
    private boolean ajt;
    private String mFrom;
    public TextView mTitle;
    private static final int ajD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int afG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int ajE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int afz = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajt = true;
        this.aeY = null;
        this.ajH = false;
        this.ajI = false;
        this.ahx = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.afB = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.ajF = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.ajF.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.aeY);
                }
            }
        });
        this.ajG = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.ajG.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.u(1.0d);
        this.ajG.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.ajG != null) {
            this.ajG.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.ajG != null) {
            this.ajG.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.ajG != null) {
            this.ajG.setSingleImageRatio(d);
        }
    }

    private void setVoiceData(bw bwVar) {
        ArrayList<VoiceData.VoiceModel> beR = bwVar.beR();
        if (y.isEmpty(beR)) {
            this.ajF.setVisibility(8);
            this.ajI = false;
            return;
        }
        this.ajF.setVisibility(0);
        VoiceData.VoiceModel voiceModel = beR.get(0);
        this.ajF.setVoiceModel(voiceModel);
        this.ajF.setTag(voiceModel);
        this.ajF.changeSkin();
        if (voiceModel != null) {
            this.ajF.BM(voiceModel.voice_status.intValue());
        }
        this.ajF.bPf();
        this.ajI = true;
    }

    private void setImageData(bw bwVar) {
        this.ajG.setFromCDN(this.ajt);
        this.ajG.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> beN = bwVar.beN();
        if (k.bbM().isShowImages() && y.getCount(beN) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < beN.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(beN, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.ajG.setVisibility(0);
                this.ajG.setFromCDN(this.ajt);
                this.ajG.setImageClickListener(new d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.agK == null || !MultiImgLayout.this.agK.a(view, (View) MultiImgLayout.this.aeY, "")) {
                            aa<AbsThreadDataSupport> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.aeY.objType = 2;
                                subClickListener.ahV = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.aeY);
                                MultiImgLayout.this.aeY.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().ezZ) {
                                ay.a(view, MultiImgLayout.this.ajt, linkedList, i2, MultiImgLayout.this.aeY.bce(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                ay.a(MultiImgLayout.this.aeY, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                ay.a(MultiImgLayout.this.aeY, view.getContext(), 2, false);
                            } else {
                                ay.a(view, MultiImgLayout.this.ajt, linkedList, i2, MultiImgLayout.this.aeY.bce(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.ajG.setImageMediaList(linkedList);
                this.ajH = true;
            } else {
                this.ajG.setVisibility(8);
                this.ajH = false;
            }
            this.ajJ = linkedList;
            return;
        }
        this.ajG.setVisibility(8);
        this.ajH = false;
    }

    public void setFromCDN(boolean z) {
        this.ajt = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.ajG.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeY = absThreadDataSupport;
        bw bce = absThreadDataSupport.bce();
        ay.a(this.mTitle, bce, this.ahx);
        ay.a(this.afB, this.mTitle, bce, afz, this.ahx);
        setImageData(bce);
        setVoiceData(bce);
        tU();
    }

    private void tU() {
        if (this.afB.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.ajH) {
                setMarginsTop(this.ajF, ajD);
                setMarginsTop(this.ajG, ajE);
            } else if (this.ajI) {
                setMarginsTop(this.ajF, ajE);
                setMarginsTop(this.ajG, afG);
            }
        } else if (this.ajF != null && this.ajF.getLayoutParams() != null) {
            if (this.ajH) {
                setMarginsTop(this.ajF, ajD);
            } else if (this.ajI) {
                setMarginsTop(this.ajF, afG);
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

    public aa<AbsThreadDataSupport> getSubClickListener() {
        return this.agK;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.agK = aaVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahx = z;
    }
}

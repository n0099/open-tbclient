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
    private AbsThreadDataSupport aeW;
    public TextView afz;
    private aa<AbsThreadDataSupport> agI;
    private boolean ahv;
    public PlayVoiceBntNew ajD;
    public ConstrainImageGroup ajE;
    private boolean ajF;
    private boolean ajG;
    private LinkedList<MediaData> ajH;
    private boolean ajr;
    private String mFrom;
    public TextView mTitle;
    private static final int ajB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int afE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int ajC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int afx = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajr = true;
        this.aeW = null;
        this.ajF = false;
        this.ajG = false;
        this.ahv = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.afz = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.ajD = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.ajD.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.aeW);
                }
            }
        });
        this.ajE = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.ajE.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.u(1.0d);
        this.ajE.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.ajE != null) {
            this.ajE.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.ajE != null) {
            this.ajE.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.ajE != null) {
            this.ajE.setSingleImageRatio(d);
        }
    }

    private void setVoiceData(bw bwVar) {
        ArrayList<VoiceData.VoiceModel> beR = bwVar.beR();
        if (y.isEmpty(beR)) {
            this.ajD.setVisibility(8);
            this.ajG = false;
            return;
        }
        this.ajD.setVisibility(0);
        VoiceData.VoiceModel voiceModel = beR.get(0);
        this.ajD.setVoiceModel(voiceModel);
        this.ajD.setTag(voiceModel);
        this.ajD.changeSkin();
        if (voiceModel != null) {
            this.ajD.BM(voiceModel.voice_status.intValue());
        }
        this.ajD.bPe();
        this.ajG = true;
    }

    private void setImageData(bw bwVar) {
        this.ajE.setFromCDN(this.ajr);
        this.ajE.setSinglePicUseStyleV10(true);
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
                this.ajE.setVisibility(0);
                this.ajE.setFromCDN(this.ajr);
                this.ajE.setImageClickListener(new d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.agI == null || !MultiImgLayout.this.agI.a(view, (View) MultiImgLayout.this.aeW, "")) {
                            aa<AbsThreadDataSupport> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.aeW.objType = 2;
                                subClickListener.ahT = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.aeW);
                                MultiImgLayout.this.aeW.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().ezV) {
                                ay.a(view, MultiImgLayout.this.ajr, linkedList, i2, MultiImgLayout.this.aeW.bce(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                ay.a(MultiImgLayout.this.aeW, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                ay.a(MultiImgLayout.this.aeW, view.getContext(), 2, false);
                            } else {
                                ay.a(view, MultiImgLayout.this.ajr, linkedList, i2, MultiImgLayout.this.aeW.bce(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.ajE.setImageMediaList(linkedList);
                this.ajF = true;
            } else {
                this.ajE.setVisibility(8);
                this.ajF = false;
            }
            this.ajH = linkedList;
            return;
        }
        this.ajE.setVisibility(8);
        this.ajF = false;
    }

    public void setFromCDN(boolean z) {
        this.ajr = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.ajE.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeW = absThreadDataSupport;
        bw bce = absThreadDataSupport.bce();
        ay.a(this.mTitle, bce, this.ahv);
        ay.a(this.afz, this.mTitle, bce, afx, this.ahv);
        setImageData(bce);
        setVoiceData(bce);
        tU();
    }

    private void tU() {
        if (this.afz.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.ajF) {
                setMarginsTop(this.ajD, ajB);
                setMarginsTop(this.ajE, ajC);
            } else if (this.ajG) {
                setMarginsTop(this.ajD, ajC);
                setMarginsTop(this.ajE, afE);
            }
        } else if (this.ajD != null && this.ajD.getLayoutParams() != null) {
            if (this.ajF) {
                setMarginsTop(this.ajD, ajB);
            } else if (this.ajG) {
                setMarginsTop(this.ajD, afE);
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
        return this.agI;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.agI = aaVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahv = z;
    }
}

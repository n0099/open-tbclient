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
    private a EX;
    public TextView Fk;
    private ab<a> Gd;
    public PlayVoiceBntNew HH;
    public ConstrainImageGroup HI;
    private boolean HJ;
    private boolean HK;
    private LinkedList<MediaData> HL;
    private boolean Hx;
    private String mFrom;
    public TextView mTitle;
    private static final int HE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int HF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int HG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int Fi = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hx = true;
        this.EX = null;
        this.HJ = false;
        this.HK = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Fk = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.HH = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.HH.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.EX);
                }
            }
        });
        this.HI = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.HI.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.g(1.0d);
        this.HI.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.HI != null) {
            this.HI.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.HI != null) {
            this.HI.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.HI != null) {
            this.HI.setSingleImageRatio(d);
        }
    }

    private void setVoiceData(bh bhVar) {
        ArrayList<VoiceData.VoiceModel> aiS = bhVar.aiS();
        if (v.isEmpty(aiS)) {
            this.HH.setVisibility(8);
            this.HK = false;
            return;
        }
        this.HH.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aiS.get(0);
        this.HH.setVoiceModel(voiceModel);
        this.HH.setTag(voiceModel);
        this.HH.bno();
        if (voiceModel != null) {
            this.HH.uJ(voiceModel.voice_status.intValue());
        }
        this.HH.cpA();
        this.HK = true;
    }

    private void setImageData(bh bhVar) {
        this.HI.setFromCDN(this.Hx);
        this.HI.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> aiO = bhVar.aiO();
        if (com.baidu.tbadk.core.i.ago().isShowImages() && v.getCount(aiO) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aiO.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aiO, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.HI.setVisibility(0);
                this.HI.setFromCDN(this.Hx);
                this.HI.setImageClickListener(new d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.Gd == null || !MultiImgLayout.this.Gd.a(view, (View) MultiImgLayout.this.EX, "")) {
                            ab<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.EX.objType = 2;
                                subClickListener.Hc = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.EX);
                                MultiImgLayout.this.EX.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().ctS) {
                                au.a(view, MultiImgLayout.this.Hx, linkedList, i2, MultiImgLayout.this.EX.agG(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                au.a(MultiImgLayout.this.EX, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                au.a(MultiImgLayout.this.EX, view.getContext(), 2, false);
                            } else {
                                au.a(view, MultiImgLayout.this.Hx, linkedList, i2, MultiImgLayout.this.EX.agG(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.HI.setImageMediaList(linkedList);
                this.HJ = true;
            } else {
                this.HI.setVisibility(8);
                this.HJ = false;
            }
            this.HL = linkedList;
            return;
        }
        this.HI.setVisibility(8);
        this.HJ = false;
    }

    public void setFromCDN(boolean z) {
        this.Hx = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.HI.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(a aVar) {
        this.EX = aVar;
        bh agG = aVar.agG();
        au.a(this.mTitle, agG);
        au.a(this.Fk, this.mTitle, agG, Fi);
        setImageData(agG);
        setVoiceData(agG);
        lZ();
    }

    private void lZ() {
        if (this.Fk.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.HJ) {
                setMarginsTop(this.HH, HE);
                setMarginsTop(this.HI, HG);
            } else if (this.HK) {
                setMarginsTop(this.HH, HG);
                setMarginsTop(this.HI, HF);
            }
        } else if (this.HH != null && this.HH.getLayoutParams() != null) {
            if (this.HJ) {
                setMarginsTop(this.HH, HE);
            } else if (this.HK) {
                setMarginsTop(this.HH, HF);
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
        return this.Gd;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.Gd = abVar;
    }
}

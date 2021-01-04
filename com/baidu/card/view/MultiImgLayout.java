package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.d.b;
import com.baidu.adp.lib.util.l;
import com.baidu.card.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private boolean ahF;
    private com.baidu.tbadk.core.data.a ahi;
    public TextView aia;
    private aa<com.baidu.tbadk.core.data.a> ajj;
    private boolean alQ;
    public PlayVoiceBntNew amd;
    public ConstrainImageGroup ame;
    private boolean amf;
    private boolean amg;
    private LinkedList<MediaData> amh;
    private String mFrom;
    public TextView mTitle;
    private static final int ama = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int amb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int amc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int ahY = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alQ = true;
        this.ahi = null;
        this.amf = false;
        this.amg = false;
        this.ahF = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aia = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.amd = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.amd.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<com.baidu.tbadk.core.data.a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.ahi);
                }
            }
        });
        this.ame = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.ame.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.x(1.0d);
        this.ame.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.ame != null) {
            this.ame.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.ame != null) {
            this.ame.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.ame != null) {
            this.ame.setSingleImageRatio(d);
        }
    }

    private void setVoiceData(bz bzVar) {
        ArrayList<VoiceData.VoiceModel> brD = bzVar.brD();
        if (x.isEmpty(brD)) {
            this.amd.setVisibility(8);
            this.amg = false;
            return;
        }
        this.amd.setVisibility(0);
        VoiceData.VoiceModel voiceModel = brD.get(0);
        this.amd.setVoiceModel(voiceModel);
        this.amd.setTag(voiceModel);
        this.amd.bxN();
        if (voiceModel != null) {
            this.amd.EE(voiceModel.voice_status.intValue());
        }
        this.amd.cfq();
        this.amg = true;
    }

    private void setImageData(bz bzVar) {
        this.ame.setFromCDN(this.alQ);
        this.ame.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> brz = bzVar.brz();
        if (k.bou().isShowImages() && x.getCount(brz) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < brz.size(); i++) {
                MediaData mediaData = (MediaData) x.getItem(brz, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (x.getCount(linkedList) > 0) {
                this.ame.setVisibility(0);
                this.ame.setFromCDN(this.alQ);
                this.ame.setImageClickListener(new d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.ajj == null || !MultiImgLayout.this.ajj.a(view, (View) MultiImgLayout.this.ahi, "")) {
                            aa<com.baidu.tbadk.core.data.a> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.ahi.objType = 2;
                                subClickListener.akp = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.ahi);
                                MultiImgLayout.this.ahi.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().fsM) {
                                ay.a(view, MultiImgLayout.this.alQ, linkedList, i2, MultiImgLayout.this.ahi.boO(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                ay.a(MultiImgLayout.this.ahi, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                ay.a(MultiImgLayout.this.ahi, view.getContext(), 2, false);
                            } else {
                                ay.a(view, MultiImgLayout.this.alQ, linkedList, i2, MultiImgLayout.this.ahi.boO(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.ame.setImageMediaList(linkedList);
                this.amf = true;
            } else {
                this.ame.setVisibility(8);
                this.amf = false;
            }
            this.amh = linkedList;
            return;
        }
        this.ame.setVisibility(8);
        this.amf = false;
    }

    public void setFromCDN(boolean z) {
        this.alQ = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.ame.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        boolean z = true;
        this.ahi = aVar;
        bz boO = aVar.boO();
        ay.a(this.mTitle, boO, this.ahF);
        ay.a(this.aia, this.mTitle, boO, ahY, this.ahF);
        boolean z2 = this.mTitle == null || this.mTitle.getVisibility() != 0;
        boolean z3 = this.aia == null || this.aia.getVisibility() != 0;
        ConstrainImageGroup constrainImageGroup = this.ame;
        if (!z2 || !z3) {
            z = false;
        }
        ay.a(constrainImageGroup, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setImageData(boO);
        setVoiceData(boO);
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

    public aa<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.ajj;
    }

    public void setSubClickListener(aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.ajj = aaVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahF = z;
    }
}

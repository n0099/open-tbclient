package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.a.b;
import com.baidu.card.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MutiImgTextLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private static final int ahY = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private boolean ahF;
    private com.baidu.tbadk.core.data.a ahi;
    public TextView aia;
    private aa<com.baidu.tbadk.core.data.a> ajj;
    private boolean alQ;
    public PlayVoiceBntNew amd;
    private boolean amg;
    private String mFrom;
    public TextView mTitle;

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgTextLayout(Context context) {
        this(context, null);
    }

    public MutiImgTextLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alQ = true;
        this.ahi = null;
        this.amg = false;
        this.ahF = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_text_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aia = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.amd = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.amd.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<com.baidu.tbadk.core.data.a> subClickListener = MutiImgTextLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgTextLayout.this.ahi);
                }
            }
        });
    }

    private void setVoiceData(bz bzVar) {
        ArrayList<VoiceData.VoiceModel> brE = bzVar.brE();
        if (x.isEmpty(brE)) {
            this.amd.setVisibility(8);
            this.amg = false;
            return;
        }
        this.amd.setVisibility(0);
        VoiceData.VoiceModel voiceModel = brE.get(0);
        this.amd.setVoiceModel(voiceModel);
        this.amd.setTag(voiceModel);
        this.amd.bxO();
        if (voiceModel != null) {
            this.amd.EE(voiceModel.voice_status.intValue());
        }
        this.amd.cfr();
        this.amg = true;
    }

    public void setFromCDN(boolean z) {
        this.alQ = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        boolean z = true;
        this.ahi = aVar;
        bz boP = aVar.boP();
        ay.a(this.mTitle, boP, this.ahF);
        ay.a(this.aia, this.mTitle, boP, ahY, this.ahF);
        ay.a(this.amd, (this.mTitle == null || this.mTitle.getVisibility() != 0) && (this.aia == null || this.aia.getVisibility() != 0), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setVoiceData(boP);
        if (this.amd != null && this.amd.getVisibility() == 0) {
            z = false;
        }
        if (z) {
            if (this.aia != null && this.aia.getVisibility() == 0) {
                this.aia.setPadding(0, 0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds3));
                return;
            } else if (this.mTitle != null && this.mTitle.getVisibility() == 0) {
                this.mTitle.setPadding(0, 0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds3));
                return;
            } else {
                return;
            }
        }
        if (this.mTitle != null) {
            this.mTitle.setPadding(0, 0, 0, 0);
        }
        if (this.aia != null) {
            this.aia.setPadding(0, 0, 0, 0);
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

    public aa<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.ajj;
    }

    public void setSubClickListener(aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.ajj = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahF = z;
    }
}

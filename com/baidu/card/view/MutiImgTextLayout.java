package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.a.b;
import com.baidu.card.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class MutiImgTextLayout extends LinearLayout implements m<com.baidu.tbadk.core.data.a> {
    public TextView KA;
    private com.baidu.tbadk.core.data.a Kc;
    private z<com.baidu.tbadk.core.data.a> LD;
    private boolean Mw;
    private boolean NK;
    public PlayVoiceBntNew NZ;
    private boolean Ob;
    private boolean Oc;
    private String mFrom;
    public TextView mTitle;
    private static final int NW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int NX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int NY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int Ky = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgTextLayout(Context context) {
        this(context, null);
    }

    public MutiImgTextLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NK = true;
        this.Kc = null;
        this.Ob = false;
        this.Oc = false;
        this.Mw = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_text_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.KA = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.NZ = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.NZ.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgTextLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgTextLayout.this.Kc);
                }
            }
        });
    }

    private void setVoiceData(bj bjVar) {
        ArrayList<VoiceData.VoiceModel> aCF = bjVar.aCF();
        if (v.isEmpty(aCF)) {
            this.NZ.setVisibility(8);
            this.Oc = false;
            return;
        }
        this.NZ.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aCF.get(0);
        this.NZ.setVoiceModel(voiceModel);
        this.NZ.setTag(voiceModel);
        this.NZ.can();
        if (voiceModel != null) {
            this.NZ.xe(voiceModel.voice_status.intValue());
        }
        this.NZ.cMC();
        this.Oc = true;
    }

    public void setFromCDN(boolean z) {
        this.NK = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.Kc = aVar;
        bj aAj = aVar.aAj();
        au.a(this.mTitle, aAj, this.Mw);
        au.a(this.KA, this.mTitle, aAj, Ky, this.Mw);
        setVoiceData(aAj);
        nn();
    }

    private void nn() {
        if (this.KA.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Ob) {
                setMarginsTop(this.NZ, NW);
            } else if (this.Oc) {
                setMarginsTop(this.NZ, NY);
            }
        } else if (this.NZ != null && this.NZ.getLayoutParams() != null) {
            if (this.Ob) {
                setMarginsTop(this.NZ, NW);
            } else if (this.Oc) {
                setMarginsTop(this.NZ, NX);
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

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setNeedFrsTabName(boolean z) {
        this.Mw = z;
    }
}

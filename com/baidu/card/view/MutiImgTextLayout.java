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
    private com.baidu.tbadk.core.data.a ada;
    public TextView ady;
    private z<com.baidu.tbadk.core.data.a> aez;
    private boolean afl;
    public PlayVoiceBntNew agG;
    private boolean agI;
    private boolean agJ;
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

    public MutiImgTextLayout(Context context) {
        this(context, null);
    }

    public MutiImgTextLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agt = true;
        this.ada = null;
        this.agI = false;
        this.agJ = false;
        this.afl = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_text_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ady = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.agG = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.agG.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgTextLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgTextLayout.this.ada);
                }
            }
        });
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

    public void setFromCDN(boolean z) {
        this.agt = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.ada = aVar;
        bj aIw = aVar.aIw();
        au.a(this.mTitle, aIw, this.afl);
        au.a(this.ady, this.mTitle, aIw, adw, this.afl);
        setVoiceData(aIw);
        rG();
    }

    private void rG() {
        if (this.ady.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.agI) {
                setMarginsTop(this.agG, agD);
            } else if (this.agJ) {
                setMarginsTop(this.agG, agF);
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

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setNeedFrsTabName(boolean z) {
        this.afl = z;
    }
}

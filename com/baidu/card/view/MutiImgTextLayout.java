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
import com.baidu.card.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
/* loaded from: classes15.dex */
public class MutiImgTextLayout extends LinearLayout implements o<AbsThreadDataSupport> {
    private AbsThreadDataSupport aeY;
    public TextView afB;
    private aa<AbsThreadDataSupport> agK;
    private boolean ahx;
    public PlayVoiceBntNew ajF;
    private boolean ajI;
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

    public MutiImgTextLayout(Context context) {
        this(context, null);
    }

    public MutiImgTextLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajt = true;
        this.aeY = null;
        this.ajI = false;
        this.ahx = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_text_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.afB = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.ajF = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.ajF.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgTextLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgTextLayout.this.aeY);
                }
            }
        });
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.afB, R.dimen.tbds7, R.dimen.tbds10);
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

    public void setFromCDN(boolean z) {
        this.ajt = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeY = absThreadDataSupport;
        bw bce = absThreadDataSupport.bce();
        ay.a(this.mTitle, bce, this.ahx);
        ay.a(this.afB, this.mTitle, bce, afz, this.ahx);
        setVoiceData(bce);
        tU();
    }

    private void tU() {
        if (this.afB.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.ajI) {
                setMarginsTop(this.ajF, ajE);
            }
        } else if (this.ajF != null && this.ajF.getLayoutParams() != null && this.ajI) {
            setMarginsTop(this.ajF, afG);
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

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahx = z;
    }
}

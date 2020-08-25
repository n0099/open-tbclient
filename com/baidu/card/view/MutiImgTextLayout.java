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
    private AbsThreadDataSupport aeW;
    public TextView afz;
    private aa<AbsThreadDataSupport> agI;
    private boolean ahv;
    public PlayVoiceBntNew ajD;
    private boolean ajG;
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

    public MutiImgTextLayout(Context context) {
        this(context, null);
    }

    public MutiImgTextLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajr = true;
        this.aeW = null;
        this.ajG = false;
        this.ahv = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_text_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.afz = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.ajD = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.ajD.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgTextLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgTextLayout.this.aeW);
                }
            }
        });
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.afz, R.dimen.tbds7, R.dimen.tbds10);
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

    public void setFromCDN(boolean z) {
        this.ajr = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeW = absThreadDataSupport;
        bw bce = absThreadDataSupport.bce();
        ay.a(this.mTitle, bce, this.ahv);
        ay.a(this.afz, this.mTitle, bce, afx, this.ahv);
        setVoiceData(bce);
        tU();
    }

    private void tU() {
        if (this.afz.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.ajG) {
                setMarginsTop(this.ajD, ajC);
            }
        } else if (this.ajD != null && this.ajD.getLayoutParams() != null && this.ajG) {
            setMarginsTop(this.ajD, afE);
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

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahv = z;
    }
}

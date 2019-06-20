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
import com.baidu.card.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MutiImgTextLayout extends LinearLayout implements i<a> {
    public TextView VB;
    private a Vp;
    private ab<a> Wt;
    private boolean XI;
    public PlayVoiceBntNew XR;
    private boolean XT;
    private boolean XU;
    private String mFrom;
    public TextView mTitle;
    private static final int XO = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int XP = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int XQ = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int Vz = l.af(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgTextLayout(Context context) {
        this(context, null);
    }

    public MutiImgTextLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.XI = true;
        this.Vp = null;
        this.XT = false;
        this.XU = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_text_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.VB = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.XR = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.XR.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<a> subClickListener = MutiImgTextLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgTextLayout.this.Vp);
                }
            }
        });
    }

    private void setVoiceData(bg bgVar) {
        ArrayList<VoiceData.VoiceModel> adJ = bgVar.adJ();
        if (v.aa(adJ)) {
            this.XR.setVisibility(8);
            this.XU = false;
            return;
        }
        this.XR.setVisibility(0);
        VoiceData.VoiceModel voiceModel = adJ.get(0);
        this.XR.setVoiceModel(voiceModel);
        this.XR.setTag(voiceModel);
        this.XR.bFE();
        if (voiceModel != null) {
            this.XR.vx(voiceModel.voice_status.intValue());
        }
        this.XR.cnG();
        this.XU = true;
    }

    public void setFromCDN(boolean z) {
        this.XI = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(a aVar) {
        this.Vp = aVar;
        bg abv = aVar.abv();
        au.a(this.mTitle, abv);
        au.a(this.VB, this.mTitle, abv, Vz);
        setVoiceData(abv);
        qw();
    }

    private void qw() {
        if (this.VB.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.XT) {
                setMarginsTop(this.XR, XO);
            } else if (this.XU) {
                setMarginsTop(this.XR, XQ);
            }
        } else if (this.XR != null && this.XR.getLayoutParams() != null) {
            if (this.XT) {
                setMarginsTop(this.XR, XO);
            } else if (this.XU) {
                setMarginsTop(this.XR, XP);
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
        return this.Wt;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.Wt = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}

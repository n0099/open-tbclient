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
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MutiImgTextLayout extends LinearLayout implements i<a> {
    public TextView XJ;
    private a Xx;
    private ab<a> YA;
    private boolean ZO;
    public PlayVoiceBntNew ZX;
    private boolean ZZ;
    private boolean aaa;
    private String mFrom;
    public TextView mTitle;
    private static final int ZU = l.h(TbadkCoreApplication.getInst(), d.e.tbds26);
    private static final int ZV = l.h(TbadkCoreApplication.getInst(), d.e.tbds20);
    private static final int ZW = l.h(TbadkCoreApplication.getInst(), d.e.tbds7);
    private static final int XH = l.aO(TbadkCoreApplication.getInst()) - (l.h(TbadkCoreApplication.getInst(), d.e.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgTextLayout(Context context) {
        this(context, null);
    }

    public MutiImgTextLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZO = true;
        this.Xx = null;
        this.ZZ = false;
        this.aaa = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.multi_image_text_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.XJ = (TextView) findViewById(d.g.thread_card_abstract);
        this.mTitle = (TextView) findViewById(d.g.thread_card_title);
        this.ZX = (PlayVoiceBntNew) findViewById(d.g.thread_card_voice);
        this.ZX.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<a> subClickListener = MutiImgTextLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgTextLayout.this.Xx);
                }
            }
        });
    }

    private void setVoiceData(bg bgVar) {
        ArrayList<VoiceData.VoiceModel> Zf = bgVar.Zf();
        if (v.T(Zf)) {
            this.ZX.setVisibility(8);
            this.aaa = false;
            return;
        }
        this.ZX.setVisibility(0);
        VoiceData.VoiceModel voiceModel = Zf.get(0);
        this.ZX.setVoiceModel(voiceModel);
        this.ZX.setTag(voiceModel);
        this.ZX.bxV();
        if (voiceModel != null) {
            this.ZX.uu(voiceModel.voice_status.intValue());
        }
        this.ZX.cfA();
        this.aaa = true;
    }

    public void setFromCDN(boolean z) {
        this.ZO = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(a aVar) {
        this.Xx = aVar;
        bg WR = aVar.WR();
        au.a(this.mTitle, WR);
        au.a(this.XJ, this.mTitle, WR, XH);
        setVoiceData(WR);
        rB();
    }

    private void rB() {
        if (this.XJ.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.ZZ) {
                setMarginsTop(this.ZX, ZU);
            } else if (this.aaa) {
                setMarginsTop(this.ZX, ZW);
            }
        } else if (this.ZX != null && this.ZX.getLayoutParams() != null) {
            if (this.ZZ) {
                setMarginsTop(this.ZX, ZU);
            } else if (this.aaa) {
                setMarginsTop(this.ZX, ZV);
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
        return this.YA;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.YA = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}

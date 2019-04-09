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
    public TextView XL;
    private a Xz;
    private ab<a> YC;
    private boolean ZR;
    public PlayVoiceBntNew aaa;
    private boolean aac;
    private boolean aad;
    private String mFrom;
    public TextView mTitle;
    private static final int ZX = l.h(TbadkCoreApplication.getInst(), d.e.tbds26);
    private static final int ZY = l.h(TbadkCoreApplication.getInst(), d.e.tbds20);
    private static final int ZZ = l.h(TbadkCoreApplication.getInst(), d.e.tbds7);
    private static final int XJ = l.aO(TbadkCoreApplication.getInst()) - (l.h(TbadkCoreApplication.getInst(), d.e.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgTextLayout(Context context) {
        this(context, null);
    }

    public MutiImgTextLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZR = true;
        this.Xz = null;
        this.aac = false;
        this.aad = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.multi_image_text_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.XL = (TextView) findViewById(d.g.thread_card_abstract);
        this.mTitle = (TextView) findViewById(d.g.thread_card_title);
        this.aaa = (PlayVoiceBntNew) findViewById(d.g.thread_card_voice);
        this.aaa.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<a> subClickListener = MutiImgTextLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgTextLayout.this.Xz);
                }
            }
        });
    }

    private void setVoiceData(bg bgVar) {
        ArrayList<VoiceData.VoiceModel> Zc = bgVar.Zc();
        if (v.T(Zc)) {
            this.aaa.setVisibility(8);
            this.aad = false;
            return;
        }
        this.aaa.setVisibility(0);
        VoiceData.VoiceModel voiceModel = Zc.get(0);
        this.aaa.setVoiceModel(voiceModel);
        this.aaa.setTag(voiceModel);
        this.aaa.bxS();
        if (voiceModel != null) {
            this.aaa.uq(voiceModel.voice_status.intValue());
        }
        this.aaa.cfz();
        this.aad = true;
    }

    public void setFromCDN(boolean z) {
        this.ZR = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(a aVar) {
        this.Xz = aVar;
        bg WO = aVar.WO();
        au.a(this.mTitle, WO);
        au.a(this.XL, this.mTitle, WO, XJ);
        setVoiceData(WO);
        rB();
    }

    private void rB() {
        if (this.XL.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.aac) {
                setMarginsTop(this.aaa, ZX);
            } else if (this.aad) {
                setMarginsTop(this.aaa, ZZ);
            }
        } else if (this.aaa != null && this.aaa.getLayoutParams() != null) {
            if (this.aac) {
                setMarginsTop(this.aaa, ZX);
            } else if (this.aad) {
                setMarginsTop(this.aaa, ZY);
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
        return this.YC;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.YC = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}

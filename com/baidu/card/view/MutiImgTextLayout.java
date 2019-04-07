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
    public TextView XK;
    private a Xy;
    private ab<a> YB;
    private boolean ZQ;
    public PlayVoiceBntNew ZZ;
    private boolean aab;
    private boolean aac;
    private String mFrom;
    public TextView mTitle;
    private static final int ZW = l.h(TbadkCoreApplication.getInst(), d.e.tbds26);
    private static final int ZX = l.h(TbadkCoreApplication.getInst(), d.e.tbds20);
    private static final int ZY = l.h(TbadkCoreApplication.getInst(), d.e.tbds7);
    private static final int XI = l.aO(TbadkCoreApplication.getInst()) - (l.h(TbadkCoreApplication.getInst(), d.e.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgTextLayout(Context context) {
        this(context, null);
    }

    public MutiImgTextLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZQ = true;
        this.Xy = null;
        this.aab = false;
        this.aac = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.multi_image_text_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.XK = (TextView) findViewById(d.g.thread_card_abstract);
        this.mTitle = (TextView) findViewById(d.g.thread_card_title);
        this.ZZ = (PlayVoiceBntNew) findViewById(d.g.thread_card_voice);
        this.ZZ.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<a> subClickListener = MutiImgTextLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgTextLayout.this.Xy);
                }
            }
        });
    }

    private void setVoiceData(bg bgVar) {
        ArrayList<VoiceData.VoiceModel> Zc = bgVar.Zc();
        if (v.T(Zc)) {
            this.ZZ.setVisibility(8);
            this.aac = false;
            return;
        }
        this.ZZ.setVisibility(0);
        VoiceData.VoiceModel voiceModel = Zc.get(0);
        this.ZZ.setVoiceModel(voiceModel);
        this.ZZ.setTag(voiceModel);
        this.ZZ.bxS();
        if (voiceModel != null) {
            this.ZZ.uq(voiceModel.voice_status.intValue());
        }
        this.ZZ.cfz();
        this.aac = true;
    }

    public void setFromCDN(boolean z) {
        this.ZQ = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(a aVar) {
        this.Xy = aVar;
        bg WO = aVar.WO();
        au.a(this.mTitle, WO);
        au.a(this.XK, this.mTitle, WO, XI);
        setVoiceData(WO);
        rB();
    }

    private void rB() {
        if (this.XK.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.aab) {
                setMarginsTop(this.ZZ, ZW);
            } else if (this.aac) {
                setMarginsTop(this.ZZ, ZY);
            }
        } else if (this.ZZ != null && this.ZZ.getLayoutParams() != null) {
            if (this.aab) {
                setMarginsTop(this.ZZ, ZW);
            } else if (this.aac) {
                setMarginsTop(this.ZZ, ZX);
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
        return this.YB;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.YB = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}

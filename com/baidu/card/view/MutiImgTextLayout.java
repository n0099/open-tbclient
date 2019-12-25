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
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class MutiImgTextLayout extends LinearLayout implements m<a> {
    private a JB;
    public TextView JZ;
    private z<a> Lb;
    private boolean Nf;
    public PlayVoiceBntNew Ns;
    private boolean Nu;
    private boolean Nv;
    private String mFrom;
    public TextView mTitle;
    private static final int Np = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int Nq = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int Nr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int JX = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgTextLayout(Context context) {
        this(context, null);
    }

    public MutiImgTextLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nf = true;
        this.JB = null;
        this.Nu = false;
        this.Nv = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_text_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.JZ = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.Ns = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.Ns.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<a> subClickListener = MutiImgTextLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgTextLayout.this.JB);
                }
            }
        });
    }

    private void setVoiceData(bj bjVar) {
        ArrayList<VoiceData.VoiceModel> azS = bjVar.azS();
        if (v.isEmpty(azS)) {
            this.Ns.setVisibility(8);
            this.Nv = false;
            return;
        }
        this.Ns.setVisibility(0);
        VoiceData.VoiceModel voiceModel = azS.get(0);
        this.Ns.setVoiceModel(voiceModel);
        this.Ns.setTag(voiceModel);
        this.Ns.bEM();
        if (voiceModel != null) {
            this.Ns.wL(voiceModel.voice_status.intValue());
        }
        this.Ns.cJE();
        this.Nv = true;
    }

    public void setFromCDN(boolean z) {
        this.Nf = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(a aVar) {
        this.JB = aVar;
        bj axx = aVar.axx();
        au.a(this.mTitle, axx);
        au.a(this.JZ, this.mTitle, axx, JX);
        setVoiceData(axx);
        mW();
    }

    private void mW() {
        if (this.JZ.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Nu) {
                setMarginsTop(this.Ns, Np);
            } else if (this.Nv) {
                setMarginsTop(this.Ns, Nr);
            }
        } else if (this.Ns != null && this.Ns.getLayoutParams() != null) {
            if (this.Nu) {
                setMarginsTop(this.Ns, Np);
            } else if (this.Nv) {
                setMarginsTop(this.Ns, Nq);
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

    public z<a> getSubClickListener() {
        return this.Lb;
    }

    public void setSubClickListener(z<a> zVar) {
        this.Lb = zVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}

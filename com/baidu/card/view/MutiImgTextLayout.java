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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MutiImgTextLayout extends LinearLayout implements i<a> {
    private a VJ;
    public TextView VW;
    private ab<a> WO;
    private boolean Yd;
    public PlayVoiceBntNew Ym;
    private boolean Yo;
    private boolean Yp;
    private String mFrom;
    public TextView mTitle;
    private static final int Yj = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int Yk = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int Yl = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int VU = l.af(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgTextLayout(Context context) {
        this(context, null);
    }

    public MutiImgTextLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Yd = true;
        this.VJ = null;
        this.Yo = false;
        this.Yp = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_text_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.VW = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.Ym = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.Ym.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<a> subClickListener = MutiImgTextLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgTextLayout.this.VJ);
                }
            }
        });
    }

    private void setVoiceData(bg bgVar) {
        ArrayList<VoiceData.VoiceModel> aeL = bgVar.aeL();
        if (v.aa(aeL)) {
            this.Ym.setVisibility(8);
            this.Yp = false;
            return;
        }
        this.Ym.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aeL.get(0);
        this.Ym.setVoiceModel(voiceModel);
        this.Ym.setTag(voiceModel);
        this.Ym.bIl();
        if (voiceModel != null) {
            this.Ym.vY(voiceModel.voice_status.intValue());
        }
        this.Ym.cqz();
        this.Yp = true;
    }

    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(a aVar) {
        this.VJ = aVar;
        bg acx = aVar.acx();
        av.a(this.mTitle, acx);
        av.a(this.VW, this.mTitle, acx, VU);
        setVoiceData(acx);
        qT();
    }

    private void qT() {
        if (this.VW.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Yo) {
                setMarginsTop(this.Ym, Yj);
            } else if (this.Yp) {
                setMarginsTop(this.Ym, Yl);
            }
        } else if (this.Ym != null && this.Ym.getLayoutParams() != null) {
            if (this.Yo) {
                setMarginsTop(this.Ym, Yj);
            } else if (this.Yp) {
                setMarginsTop(this.Ym, Yk);
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
        return this.WO;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.WO = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}

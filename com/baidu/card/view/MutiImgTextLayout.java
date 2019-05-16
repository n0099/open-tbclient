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
    public TextView VC;
    private a Vq;
    private ab<a> Wu;
    private boolean XJ;
    public PlayVoiceBntNew XS;
    private boolean XU;
    private boolean XV;
    private String mFrom;
    public TextView mTitle;
    private static final int XP = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int XQ = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int XR = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int VA = l.af(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgTextLayout(Context context) {
        this(context, null);
    }

    public MutiImgTextLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.XJ = true;
        this.Vq = null;
        this.XU = false;
        this.XV = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_text_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.VC = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.XS = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.XS.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<a> subClickListener = MutiImgTextLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgTextLayout.this.Vq);
                }
            }
        });
    }

    private void setVoiceData(bg bgVar) {
        ArrayList<VoiceData.VoiceModel> adJ = bgVar.adJ();
        if (v.aa(adJ)) {
            this.XS.setVisibility(8);
            this.XV = false;
            return;
        }
        this.XS.setVisibility(0);
        VoiceData.VoiceModel voiceModel = adJ.get(0);
        this.XS.setVoiceModel(voiceModel);
        this.XS.setTag(voiceModel);
        this.XS.bFA();
        if (voiceModel != null) {
            this.XS.vx(voiceModel.voice_status.intValue());
        }
        this.XS.cnD();
        this.XV = true;
    }

    public void setFromCDN(boolean z) {
        this.XJ = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(a aVar) {
        this.Vq = aVar;
        bg abv = aVar.abv();
        au.a(this.mTitle, abv);
        au.a(this.VC, this.mTitle, abv, VA);
        setVoiceData(abv);
        qw();
    }

    private void qw() {
        if (this.VC.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.XU) {
                setMarginsTop(this.XS, XP);
            } else if (this.XV) {
                setMarginsTop(this.XS, XR);
            }
        } else if (this.XS != null && this.XS.getLayoutParams() != null) {
            if (this.XU) {
                setMarginsTop(this.XS, XP);
            } else if (this.XV) {
                setMarginsTop(this.XS, XQ);
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
        return this.Wu;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.Wu = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}

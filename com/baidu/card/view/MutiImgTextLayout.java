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
import com.baidu.card.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class MutiImgTextLayout extends LinearLayout implements n<AbsThreadDataSupport> {
    public TextView adV;
    private AbsThreadDataSupport adw;
    private aa<AbsThreadDataSupport> aeY;
    private boolean afL;
    private boolean aha;
    public PlayVoiceBntNew ahm;
    private boolean aho;
    private boolean ahp;
    private String mFrom;
    public TextView mTitle;
    private static final int ahk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int adZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int ahl = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int adT = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgTextLayout(Context context) {
        this(context, null);
    }

    public MutiImgTextLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aha = true;
        this.adw = null;
        this.aho = false;
        this.ahp = false;
        this.afL = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_text_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.adV = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.ahm = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.ahm.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgTextLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgTextLayout.this.adw);
                }
            }
        });
    }

    private void setVoiceData(bk bkVar) {
        ArrayList<VoiceData.VoiceModel> aQL = bkVar.aQL();
        if (v.isEmpty(aQL)) {
            this.ahm.setVisibility(8);
            this.ahp = false;
            return;
        }
        this.ahm.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aQL.get(0);
        this.ahm.setVoiceModel(voiceModel);
        this.ahm.setTag(voiceModel);
        this.ahm.crm();
        if (voiceModel != null) {
            this.ahm.yi(voiceModel.voice_status.intValue());
        }
        this.ahm.deL();
        this.ahp = true;
    }

    public void setFromCDN(boolean z) {
        this.aha = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adw = absThreadDataSupport;
        bk aOi = absThreadDataSupport.aOi();
        au.a(this.mTitle, aOi, this.afL);
        au.a(this.adV, this.mTitle, aOi, adT, this.afL);
        setVoiceData(aOi);
        rP();
    }

    private void rP() {
        if (this.adV.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.aho) {
                setMarginsTop(this.ahm, ahk);
            } else if (this.ahp) {
                setMarginsTop(this.ahm, ahl);
            }
        } else if (this.ahm != null && this.ahm.getLayoutParams() != null) {
            if (this.aho) {
                setMarginsTop(this.ahm, ahk);
            } else if (this.ahp) {
                setMarginsTop(this.ahm, adZ);
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

    public aa<AbsThreadDataSupport> getSubClickListener() {
        return this.aeY;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.aeY = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setNeedFrsTabName(boolean z) {
        this.afL = z;
    }
}

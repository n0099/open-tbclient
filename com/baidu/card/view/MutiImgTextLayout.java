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
import com.baidu.card.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class MutiImgTextLayout extends LinearLayout implements p<AbsThreadDataSupport> {
    private AbsThreadDataSupport afI;
    public TextView agm;
    private ab<AbsThreadDataSupport> ahv;
    private boolean aik;
    private boolean akk;
    public PlayVoiceBntNew akw;
    private boolean akz;
    private String mFrom;
    public TextView mTitle;
    private static final int aku = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int agr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int akv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int agk = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgTextLayout(Context context) {
        this(context, null);
    }

    public MutiImgTextLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akk = true;
        this.afI = null;
        this.akz = false;
        this.aik = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_text_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.agm = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.akw = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.akw.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<AbsThreadDataSupport> subClickListener = MutiImgTextLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgTextLayout.this.afI);
                }
            }
        });
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.agm, R.dimen.tbds7, R.dimen.tbds10);
    }

    private void setVoiceData(bw bwVar) {
        ArrayList<VoiceData.VoiceModel> bkn = bwVar.bkn();
        if (y.isEmpty(bkn)) {
            this.akw.setVisibility(8);
            this.akz = false;
            return;
        }
        this.akw.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bkn.get(0);
        this.akw.setVoiceModel(voiceModel);
        this.akw.setTag(voiceModel);
        this.akw.changeSkin();
        if (voiceModel != null) {
            this.akw.Dm(voiceModel.voice_status.intValue());
        }
        this.akw.bWJ();
        this.akz = true;
    }

    public void setFromCDN(boolean z) {
        this.akk = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afI = absThreadDataSupport;
        bw bhz = absThreadDataSupport.bhz();
        ay.a(this.mTitle, bhz, this.aik);
        ay.a(this.agm, this.mTitle, bhz, agk, this.aik);
        setVoiceData(bhz);
        ua();
    }

    private void ua() {
        if (this.agm.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.akz) {
                setMarginsTop(this.akw, akv);
            }
        } else if (this.akw != null && this.akw.getLayoutParams() != null && this.akz) {
            setMarginsTop(this.akw, agr);
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

    public ab<AbsThreadDataSupport> getSubClickListener() {
        return this.ahv;
    }

    public void setSubClickListener(ab<AbsThreadDataSupport> abVar) {
        this.ahv = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setNeedFrsTabName(boolean z) {
        this.aik = z;
    }
}

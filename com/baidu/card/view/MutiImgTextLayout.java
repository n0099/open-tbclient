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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
/* loaded from: classes15.dex */
public class MutiImgTextLayout extends LinearLayout implements n<AbsThreadDataSupport> {
    private AbsThreadDataSupport adQ;
    public TextView aeq;
    private aa<AbsThreadDataSupport> afy;
    private boolean agn;
    private boolean aib;
    public PlayVoiceBntNew aio;
    private boolean air;
    private String mFrom;
    public TextView mTitle;
    private static final int aim = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int aev = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int ain = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int aeo = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgTextLayout(Context context) {
        this(context, null);
    }

    public MutiImgTextLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aib = true;
        this.adQ = null;
        this.air = false;
        this.agn = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_text_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aeq = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.aio = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.aio.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgTextLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgTextLayout.this.adQ);
                }
            }
        });
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.aeq, R.dimen.tbds7, R.dimen.tbds10);
    }

    private void setVoiceData(bv bvVar) {
        ArrayList<VoiceData.VoiceModel> aWy = bvVar.aWy();
        if (x.isEmpty(aWy)) {
            this.aio.setVisibility(8);
            this.air = false;
            return;
        }
        this.aio.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aWy.get(0);
        this.aio.setVoiceModel(voiceModel);
        this.aio.setTag(voiceModel);
        this.aio.changeSkin();
        if (voiceModel != null) {
            this.aio.zt(voiceModel.voice_status.intValue());
        }
        this.aio.bFz();
        this.air = true;
    }

    public void setFromCDN(boolean z) {
        this.aib = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adQ = absThreadDataSupport;
        bv aTN = absThreadDataSupport.aTN();
        ax.a(this.mTitle, aTN, this.agn);
        ax.a(this.aeq, this.mTitle, aTN, aeo, this.agn);
        setVoiceData(aTN);
        sj();
    }

    private void sj() {
        if (this.aeq.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.air) {
                setMarginsTop(this.aio, ain);
            }
        } else if (this.aio != null && this.aio.getLayoutParams() != null && this.air) {
            setMarginsTop(this.aio, aev);
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
        return this.afy;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.afy = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setNeedFrsTabName(boolean z) {
        this.agn = z;
    }
}

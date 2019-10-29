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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class MutiImgTextLayout extends LinearLayout implements i<a> {
    public TextView FK;
    private a Fx;
    private ab<a> GD;
    private boolean HY;
    public PlayVoiceBntNew Ii;
    private boolean Ik;
    private boolean Il;
    private String mFrom;
    public TextView mTitle;
    private static final int If = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int Ig = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int Ih = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int FI = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgTextLayout(Context context) {
        this(context, null);
    }

    public MutiImgTextLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HY = true;
        this.Fx = null;
        this.Ik = false;
        this.Il = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_text_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.FK = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.Ii = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.Ii.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<a> subClickListener = MutiImgTextLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgTextLayout.this.Fx);
                }
            }
        });
    }

    private void setVoiceData(bh bhVar) {
        ArrayList<VoiceData.VoiceModel> aiU = bhVar.aiU();
        if (v.isEmpty(aiU)) {
            this.Ii.setVisibility(8);
            this.Il = false;
            return;
        }
        this.Ii.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aiU.get(0);
        this.Ii.setVoiceModel(voiceModel);
        this.Ii.setTag(voiceModel);
        this.Ii.bnq();
        if (voiceModel != null) {
            this.Ii.uK(voiceModel.voice_status.intValue());
        }
        this.Ii.cpC();
        this.Il = true;
    }

    public void setFromCDN(boolean z) {
        this.HY = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(a aVar) {
        this.Fx = aVar;
        bh agI = aVar.agI();
        au.a(this.mTitle, agI);
        au.a(this.FK, this.mTitle, agI, FI);
        setVoiceData(agI);
        lZ();
    }

    private void lZ() {
        if (this.FK.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Ik) {
                setMarginsTop(this.Ii, If);
            } else if (this.Il) {
                setMarginsTop(this.Ii, Ih);
            }
        } else if (this.Ii != null && this.Ii.getLayoutParams() != null) {
            if (this.Ik) {
                setMarginsTop(this.Ii, If);
            } else if (this.Il) {
                setMarginsTop(this.Ii, Ig);
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
        return this.GD;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.GD = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}

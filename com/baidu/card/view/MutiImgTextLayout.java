package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.a.b;
import com.baidu.card.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MutiImgTextLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private static final int agW = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private boolean agD;
    public TextView agY;
    private com.baidu.tbadk.core.data.a agj;
    private ab<com.baidu.tbadk.core.data.a> aig;
    private boolean akO;
    public PlayVoiceBntNew alb;
    private boolean ale;
    private String mFrom;
    public TextView mTitle;

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgTextLayout(Context context) {
        this(context, null);
    }

    public MutiImgTextLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akO = true;
        this.agj = null;
        this.ale = false;
        this.agD = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_text_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.agY = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.alb = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.alb.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgTextLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgTextLayout.this.agj);
                }
            }
        });
    }

    private void setVoiceData(cb cbVar) {
        ArrayList<VoiceData.VoiceModel> bod = cbVar.bod();
        if (y.isEmpty(bod)) {
            this.alb.setVisibility(8);
            this.ale = false;
            return;
        }
        this.alb.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bod.get(0);
        this.alb.setVoiceModel(voiceModel);
        this.alb.setTag(voiceModel);
        this.alb.buo();
        if (voiceModel != null) {
            this.alb.Dp(voiceModel.voice_status.intValue());
        }
        this.alb.ccu();
        this.ale = true;
    }

    public void setFromCDN(boolean z) {
        this.akO = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        boolean z = true;
        this.agj = aVar;
        cb bln = aVar.bln();
        az.a(this.mTitle, bln, this.agD);
        az.a(this.agY, this.mTitle, bln, agW, this.agD);
        az.a(this.alb, (this.mTitle == null || this.mTitle.getVisibility() != 0) && (this.agY == null || this.agY.getVisibility() != 0), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setVoiceData(bln);
        if (this.alb != null && this.alb.getVisibility() == 0) {
            z = false;
        }
        if (z) {
            if (this.agY != null && this.agY.getVisibility() == 0) {
                this.agY.setPadding(0, 0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds3));
                return;
            } else if (this.mTitle != null && this.mTitle.getVisibility() == 0) {
                this.mTitle.setPadding(0, 0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds3));
                return;
            } else {
                return;
            }
        }
        if (this.mTitle != null) {
            this.mTitle.setPadding(0, 0, 0, 0);
        }
        if (this.agY != null) {
            this.agY.setPadding(0, 0, 0, 0);
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

    public ab<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.aig;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.aig = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setNeedFrsTabName(boolean z) {
        this.agD = z;
    }
}

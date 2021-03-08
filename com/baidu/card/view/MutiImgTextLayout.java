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
    private static final int aip = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private com.baidu.tbadk.core.data.a ahB;
    private boolean ahV;
    public TextView air;
    private ab<com.baidu.tbadk.core.data.a> ajy;
    private boolean amh;
    public PlayVoiceBntNew amu;
    private boolean amx;
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
        this.amh = true;
        this.ahB = null;
        this.amx = false;
        this.ahV = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_text_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.air = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.amu = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.amu.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgTextLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgTextLayout.this.ahB);
                }
            }
        });
    }

    private void setVoiceData(cb cbVar) {
        ArrayList<VoiceData.VoiceModel> bof = cbVar.bof();
        if (y.isEmpty(bof)) {
            this.amu.setVisibility(8);
            this.amx = false;
            return;
        }
        this.amu.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bof.get(0);
        this.amu.setVoiceModel(voiceModel);
        this.amu.setTag(voiceModel);
        this.amu.bur();
        if (voiceModel != null) {
            this.amu.Ds(voiceModel.voice_status.intValue());
        }
        this.amu.ccH();
        this.amx = true;
    }

    public void setFromCDN(boolean z) {
        this.amh = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        boolean z = true;
        this.ahB = aVar;
        cb blp = aVar.blp();
        az.a(this.mTitle, blp, this.ahV);
        az.a(this.air, this.mTitle, blp, aip, this.ahV);
        az.a(this.amu, (this.mTitle == null || this.mTitle.getVisibility() != 0) && (this.air == null || this.air.getVisibility() != 0), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setVoiceData(blp);
        if (this.amu != null && this.amu.getVisibility() == 0) {
            z = false;
        }
        if (z) {
            if (this.air != null && this.air.getVisibility() == 0) {
                this.air.setPadding(0, 0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds3));
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
        if (this.air != null) {
            this.air.setPadding(0, 0, 0, 0);
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
        return this.ajy;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.ajy = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahV = z;
    }
}

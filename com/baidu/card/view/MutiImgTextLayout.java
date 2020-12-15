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
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class MutiImgTextLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private static final int ahn;
    private com.baidu.tbadk.core.data.a agJ;
    public TextView ahp;
    private ab<com.baidu.tbadk.core.data.a> aix;
    private boolean ajm;
    public PlayVoiceBntNew alB;
    private boolean alE;
    private boolean alo;
    private String mFrom;
    public TextView mTitle;

    public void setFrom(String str) {
        this.mFrom = str;
    }

    static {
        ahn = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (d.bkA() ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public MutiImgTextLayout(Context context) {
        this(context, null);
    }

    public MutiImgTextLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alo = true;
        this.agJ = null;
        this.alE = false;
        this.ajm = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_text_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ahp = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.alB = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.alB.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgTextLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgTextLayout.this.agJ);
                }
            }
        });
    }

    private void setVoiceData(by byVar) {
        ArrayList<VoiceData.VoiceModel> bpc = byVar.bpc();
        if (y.isEmpty(bpc)) {
            this.alB.setVisibility(8);
            this.alE = false;
            return;
        }
        this.alB.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bpc.get(0);
        this.alB.setVoiceModel(voiceModel);
        this.alB.setTag(voiceModel);
        this.alB.bvs();
        if (voiceModel != null) {
            this.alB.EM(voiceModel.voice_status.intValue());
        }
        this.alB.ccA();
        this.alE = true;
    }

    public void setFromCDN(boolean z) {
        this.alo = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        boolean z = true;
        this.agJ = aVar;
        by bmn = aVar.bmn();
        az.a(this.mTitle, bmn, this.ajm);
        az.a(this.ahp, this.mTitle, bmn, ahn, this.ajm);
        az.a(this.alB, (this.mTitle == null || this.mTitle.getVisibility() != 0) && (this.ahp == null || this.ahp.getVisibility() != 0), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setVoiceData(bmn);
        if (this.alB != null && this.alB.getVisibility() == 0) {
            z = false;
        }
        if (z) {
            if (this.ahp != null && this.ahp.getVisibility() == 0) {
                this.ahp.setPadding(0, 0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds3));
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
        if (this.ahp != null) {
            this.ahp.setPadding(0, 0, 0, 0);
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
        return this.aix;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.aix = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setNeedFrsTabName(boolean z) {
        this.ajm = z;
    }
}

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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MutiImgTextLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private static final int ahh = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    private boolean agO;
    private com.baidu.tbadk.core.data.a agr;
    public TextView ahj;
    private aa<com.baidu.tbadk.core.data.a> ais;
    private boolean akY;
    public PlayVoiceBntNew alm;
    private boolean alp;
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
        this.akY = true;
        this.agr = null;
        this.alp = false;
        this.agO = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_text_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ahj = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.alm = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.alm.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgTextLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<com.baidu.tbadk.core.data.a> subClickListener = MutiImgTextLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgTextLayout.this.agr);
                }
            }
        });
    }

    private void setVoiceData(bz bzVar) {
        ArrayList<VoiceData.VoiceModel> bnK = bzVar.bnK();
        if (x.isEmpty(bnK)) {
            this.alm.setVisibility(8);
            this.alp = false;
            return;
        }
        this.alm.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bnK.get(0);
        this.alm.setVoiceModel(voiceModel);
        this.alm.setTag(voiceModel);
        this.alm.btU();
        if (voiceModel != null) {
            this.alm.CX(voiceModel.voice_status.intValue());
        }
        this.alm.cbz();
        this.alp = true;
    }

    public void setFromCDN(boolean z) {
        this.akY = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        boolean z = true;
        this.agr = aVar;
        bz bkV = aVar.bkV();
        ay.a(this.mTitle, bkV, this.agO);
        ay.a(this.ahj, this.mTitle, bkV, ahh, this.agO);
        ay.a(this.alm, (this.mTitle == null || this.mTitle.getVisibility() != 0) && (this.ahj == null || this.ahj.getVisibility() != 0), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setVoiceData(bkV);
        if (this.alm != null && this.alm.getVisibility() == 0) {
            z = false;
        }
        if (z) {
            if (this.ahj != null && this.ahj.getVisibility() == 0) {
                this.ahj.setPadding(0, 0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds3));
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
        if (this.ahj != null) {
            this.ahj.setPadding(0, 0, 0, 0);
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

    public aa<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.ais;
    }

    public void setSubClickListener(aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.ais = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setNeedFrsTabName(boolean z) {
        this.agO = z;
    }
}

package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.d.b;
import com.baidu.adp.lib.util.l;
import com.baidu.card.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private boolean agD;
    public TextView agY;
    private com.baidu.tbadk.core.data.a agj;
    private ab<com.baidu.tbadk.core.data.a> aig;
    private boolean akO;
    public PlayVoiceBntNew alb;
    public ConstrainImageGroup alc;
    private boolean ald;
    private boolean ale;
    private LinkedList<MediaData> alf;
    private String mFrom;
    public TextView mTitle;
    private static final int akY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int akZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int ala = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int agW = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akO = true;
        this.agj = null;
        this.ald = false;
        this.ale = false;
        this.agD = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.agY = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.alb = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.alb.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.agj);
                }
            }
        });
        this.alc = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.alc.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.r(1.0d);
        this.alc.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.alc != null) {
            this.alc.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.alc != null) {
            this.alc.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.alc != null) {
            this.alc.setSingleImageRatio(d);
        }
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

    private void setImageData(cb cbVar) {
        this.alc.setFromCDN(this.akO);
        this.alc.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> bnZ = cbVar.bnZ();
        if (k.bkT().isShowImages() && y.getCount(bnZ) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < bnZ.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bnZ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.alc.setVisibility(0);
                this.alc.setFromCDN(this.akO);
                this.alc.setImageClickListener(new d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.aig == null || !MultiImgLayout.this.aig.a(view, (View) MultiImgLayout.this.agj, "")) {
                            ab<com.baidu.tbadk.core.data.a> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.agj.objType = 2;
                                subClickListener.ajn = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.agj);
                                MultiImgLayout.this.agj.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().fqu) {
                                az.a(view, MultiImgLayout.this.akO, linkedList, i2, MultiImgLayout.this.agj.bln(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                az.a(MultiImgLayout.this.agj, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                az.a(MultiImgLayout.this.agj, view.getContext(), 2, false);
                            } else {
                                az.a(view, MultiImgLayout.this.akO, linkedList, i2, MultiImgLayout.this.agj.bln(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.alc.setImageMediaList(linkedList);
                this.ald = true;
            } else {
                this.alc.setVisibility(8);
                this.ald = false;
            }
            this.alf = linkedList;
            return;
        }
        this.alc.setVisibility(8);
        this.ald = false;
    }

    public void setFromCDN(boolean z) {
        this.akO = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.alc.setPreloadSizeReadyCallback(bVar);
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
        boolean z2 = this.mTitle == null || this.mTitle.getVisibility() != 0;
        boolean z3 = this.agY == null || this.agY.getVisibility() != 0;
        ConstrainImageGroup constrainImageGroup = this.alc;
        if (!z2 || !z3) {
            z = false;
        }
        az.a(constrainImageGroup, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setImageData(bln);
        setVoiceData(bln);
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

    public void setNeedFrsTabName(boolean z) {
        this.agD = z;
    }
}

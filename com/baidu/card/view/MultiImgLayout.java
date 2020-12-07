package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.d.b;
import com.baidu.adp.lib.util.l;
import com.baidu.card.p;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes21.dex */
public class MultiImgLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private static final int ahn;
    private com.baidu.tbadk.core.data.a agJ;
    public TextView ahp;
    private ab<com.baidu.tbadk.core.data.a> aix;
    private boolean ajm;
    public PlayVoiceBntNew alB;
    public ConstrainImageGroup alC;
    private boolean alD;
    private boolean alE;
    private LinkedList<MediaData> alF;
    private boolean alo;
    private String mFrom;
    public TextView mTitle;
    private static final int aly = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int alz = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int alA = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);

    static {
        ahn = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (d.bkA() ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alo = true;
        this.agJ = null;
        this.alD = false;
        this.alE = false;
        this.ajm = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ahp = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.alB = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.alB.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.agJ);
                }
            }
        });
        this.alC = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.alC.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.x(1.0d);
        this.alC.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.alC != null) {
            this.alC.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.alC != null) {
            this.alC.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.alC != null) {
            this.alC.setSingleImageRatio(d);
        }
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
        this.alB.ccz();
        this.alE = true;
    }

    private void setImageData(by byVar) {
        this.alC.setFromCDN(this.alo);
        this.alC.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> boY = byVar.boY();
        if (k.blV().isShowImages() && y.getCount(boY) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < boY.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(boY, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.alC.setVisibility(0);
                this.alC.setFromCDN(this.alo);
                this.alC.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.aix == null || !MultiImgLayout.this.aix.a(view, (View) MultiImgLayout.this.agJ, "")) {
                            ab<com.baidu.tbadk.core.data.a> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.agJ.objType = 2;
                                subClickListener.ajN = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.agJ);
                                MultiImgLayout.this.agJ.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().fjd) {
                                az.a(view, MultiImgLayout.this.alo, linkedList, i2, MultiImgLayout.this.agJ.bmn(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                az.a(MultiImgLayout.this.agJ, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                az.a(MultiImgLayout.this.agJ, view.getContext(), 2, false);
                            } else {
                                az.a(view, MultiImgLayout.this.alo, linkedList, i2, MultiImgLayout.this.agJ.bmn(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.alC.setImageMediaList(linkedList);
                this.alD = true;
            } else {
                this.alC.setVisibility(8);
                this.alD = false;
            }
            this.alF = linkedList;
            return;
        }
        this.alC.setVisibility(8);
        this.alD = false;
    }

    public void setFromCDN(boolean z) {
        this.alo = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.alC.setPreloadSizeReadyCallback(bVar);
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
        boolean z2 = this.mTitle == null || this.mTitle.getVisibility() != 0;
        boolean z3 = this.ahp == null || this.ahp.getVisibility() != 0;
        ConstrainImageGroup constrainImageGroup = this.alC;
        if (!z2 || !z3) {
            z = false;
        }
        az.a(constrainImageGroup, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setImageData(bmn);
        setVoiceData(bmn);
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

    public void setNeedFrsTabName(boolean z) {
        this.ajm = z;
    }
}

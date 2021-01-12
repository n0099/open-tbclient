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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MultiImgLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private boolean agO;
    private com.baidu.tbadk.core.data.a agr;
    public TextView ahj;
    private aa<com.baidu.tbadk.core.data.a> ais;
    private boolean akY;
    public PlayVoiceBntNew alm;
    public ConstrainImageGroup aln;
    private boolean alo;
    private boolean alp;
    private LinkedList<MediaData> alq;
    private String mFrom;
    public TextView mTitle;
    private static final int ali = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int alj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int alk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int ahh = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akY = true;
        this.agr = null;
        this.alo = false;
        this.alp = false;
        this.agO = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ahj = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.alm = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.alm.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<com.baidu.tbadk.core.data.a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.agr);
                }
            }
        });
        this.aln = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.aln.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.r(1.0d);
        this.aln.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.aln != null) {
            this.aln.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.aln != null) {
            this.aln.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.aln != null) {
            this.aln.setSingleImageRatio(d);
        }
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
            this.alm.CY(voiceModel.voice_status.intValue());
        }
        this.alm.cbz();
        this.alp = true;
    }

    private void setImageData(bz bzVar) {
        this.aln.setFromCDN(this.akY);
        this.aln.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> bnG = bzVar.bnG();
        if (k.bkB().isShowImages() && x.getCount(bnG) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < bnG.size(); i++) {
                MediaData mediaData = (MediaData) x.getItem(bnG, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (x.getCount(linkedList) > 0) {
                this.aln.setVisibility(0);
                this.aln.setFromCDN(this.akY);
                this.aln.setImageClickListener(new d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.ais == null || !MultiImgLayout.this.ais.a(view, (View) MultiImgLayout.this.agr, "")) {
                            aa<com.baidu.tbadk.core.data.a> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.agr.objType = 2;
                                subClickListener.ajy = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.agr);
                                MultiImgLayout.this.agr.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().fob) {
                                ay.a(view, MultiImgLayout.this.akY, linkedList, i2, MultiImgLayout.this.agr.bkV(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                ay.a(MultiImgLayout.this.agr, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                ay.a(MultiImgLayout.this.agr, view.getContext(), 2, false);
                            } else {
                                ay.a(view, MultiImgLayout.this.akY, linkedList, i2, MultiImgLayout.this.agr.bkV(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.aln.setImageMediaList(linkedList);
                this.alo = true;
            } else {
                this.aln.setVisibility(8);
                this.alo = false;
            }
            this.alq = linkedList;
            return;
        }
        this.aln.setVisibility(8);
        this.alo = false;
    }

    public void setFromCDN(boolean z) {
        this.akY = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.aln.setPreloadSizeReadyCallback(bVar);
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
        boolean z2 = this.mTitle == null || this.mTitle.getVisibility() != 0;
        boolean z3 = this.ahj == null || this.ahj.getVisibility() != 0;
        ConstrainImageGroup constrainImageGroup = this.aln;
        if (!z2 || !z3) {
            z = false;
        }
        ay.a(constrainImageGroup, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setImageData(bkV);
        setVoiceData(bkV);
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

    public void setNeedFrsTabName(boolean z) {
        this.agO = z;
    }
}

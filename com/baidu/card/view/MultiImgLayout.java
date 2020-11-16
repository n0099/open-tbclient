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
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes20.dex */
public class MultiImgLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private static final int agp;
    private static final int akx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int aky = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int akz = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private com.baidu.tbadk.core.data.a afN;
    public TextView agr;
    private ab<com.baidu.tbadk.core.data.a> ahx;
    private boolean ain;
    public PlayVoiceBntNew akA;
    public ConstrainImageGroup akB;
    private boolean akC;
    private boolean akD;
    private LinkedList<MediaData> akE;
    private boolean akn;
    private String mFrom;
    public TextView mTitle;

    static {
        agp = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (d.bhw() ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akn = true;
        this.afN = null;
        this.akC = false;
        this.akD = false;
        this.ain = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.agr = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.akA = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.akA.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.afN);
                }
            }
        });
        this.akB = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.akB.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.x(1.0d);
        this.akB.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.akB != null) {
            this.akB.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.akB != null) {
            this.akB.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.akB != null) {
            this.akB.setSingleImageRatio(d);
        }
    }

    private void setVoiceData(bx bxVar) {
        ArrayList<VoiceData.VoiceModel> blP = bxVar.blP();
        if (y.isEmpty(blP)) {
            this.akA.setVisibility(8);
            this.akD = false;
            return;
        }
        this.akA.setVisibility(0);
        VoiceData.VoiceModel voiceModel = blP.get(0);
        this.akA.setVoiceModel(voiceModel);
        this.akA.setTag(voiceModel);
        this.akA.changeSkin();
        if (voiceModel != null) {
            this.akA.DX(voiceModel.voice_status.intValue());
        }
        this.akA.bYE();
        this.akD = true;
    }

    private void setImageData(bx bxVar) {
        this.akB.setFromCDN(this.akn);
        this.akB.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> blL = bxVar.blL();
        if (k.biL().isShowImages() && y.getCount(blL) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < blL.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(blL, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.akB.setVisibility(0);
                this.akB.setFromCDN(this.akn);
                this.akB.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.ahx == null || !MultiImgLayout.this.ahx.a(view, (View) MultiImgLayout.this.afN, "")) {
                            ab<com.baidu.tbadk.core.data.a> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.afN.objType = 2;
                                subClickListener.aiO = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.afN);
                                MultiImgLayout.this.afN.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().fbD) {
                                az.a(view, MultiImgLayout.this.akn, linkedList, i2, MultiImgLayout.this.afN.bjd(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                az.a(MultiImgLayout.this.afN, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                az.a(MultiImgLayout.this.afN, view.getContext(), 2, false);
                            } else {
                                az.a(view, MultiImgLayout.this.akn, linkedList, i2, MultiImgLayout.this.afN.bjd(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.akB.setImageMediaList(linkedList);
                this.akC = true;
            } else {
                this.akB.setVisibility(8);
                this.akC = false;
            }
            this.akE = linkedList;
            return;
        }
        this.akB.setVisibility(8);
        this.akC = false;
    }

    public void setFromCDN(boolean z) {
        this.akn = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.akB.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        boolean z = true;
        this.afN = aVar;
        bx bjd = aVar.bjd();
        az.a(this.mTitle, bjd, this.ain);
        az.a(this.agr, this.mTitle, bjd, agp, this.ain);
        boolean z2 = this.mTitle == null || this.mTitle.getVisibility() != 0;
        boolean z3 = this.agr == null || this.agr.getVisibility() != 0;
        ConstrainImageGroup constrainImageGroup = this.akB;
        if (!z2 || !z3) {
            z = false;
        }
        az.a(constrainImageGroup, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setImageData(bjd);
        setVoiceData(bjd);
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
        return this.ahx;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.ahx = abVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ain = z;
    }
}

package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.e.b;
import com.baidu.adp.lib.util.l;
import com.baidu.card.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MultiImgLayout extends LinearLayout implements i<a> {
    public TextView FK;
    private a Fx;
    private ab<a> GD;
    private boolean HY;
    public PlayVoiceBntNew Ii;
    public ConstrainImageGroup Ij;
    private boolean Ik;
    private boolean Il;
    private LinkedList<MediaData> Im;
    private String mFrom;
    public TextView mTitle;
    private static final int If = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int Ig = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int Ih = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int FI = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HY = true;
        this.Fx = null;
        this.Ik = false;
        this.Il = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.FK = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.Ii = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.Ii.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.Fx);
                }
            }
        });
        this.Ij = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.Ij.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.g(1.0d);
        this.Ij.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.Ij != null) {
            this.Ij.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.Ij != null) {
            this.Ij.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.Ij != null) {
            this.Ij.setSingleImageRatio(d);
        }
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

    private void setImageData(bh bhVar) {
        this.Ij.setFromCDN(this.HY);
        this.Ij.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> aiQ = bhVar.aiQ();
        if (com.baidu.tbadk.core.i.agq().isShowImages() && v.getCount(aiQ) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aiQ.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aiQ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.Ij.setVisibility(0);
                this.Ij.setFromCDN(this.HY);
                this.Ij.setImageClickListener(new d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.GD == null || !MultiImgLayout.this.GD.a(view, (View) MultiImgLayout.this.Fx, "")) {
                            ab<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.Fx.objType = 2;
                                subClickListener.HC = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.Fx);
                                MultiImgLayout.this.Fx.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().cuK) {
                                au.a(view, MultiImgLayout.this.HY, linkedList, i2, MultiImgLayout.this.Fx.agI(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                au.a(MultiImgLayout.this.Fx, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                au.a(MultiImgLayout.this.Fx, view.getContext(), 2, false);
                            } else {
                                au.a(view, MultiImgLayout.this.HY, linkedList, i2, MultiImgLayout.this.Fx.agI(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.Ij.setImageMediaList(linkedList);
                this.Ik = true;
            } else {
                this.Ij.setVisibility(8);
                this.Ik = false;
            }
            this.Im = linkedList;
            return;
        }
        this.Ij.setVisibility(8);
        this.Ik = false;
    }

    public void setFromCDN(boolean z) {
        this.HY = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.Ij.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(a aVar) {
        this.Fx = aVar;
        bh agI = aVar.agI();
        au.a(this.mTitle, agI);
        au.a(this.FK, this.mTitle, agI, FI);
        setImageData(agI);
        setVoiceData(agI);
        lZ();
    }

    private void lZ() {
        if (this.FK.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Ik) {
                setMarginsTop(this.Ii, If);
                setMarginsTop(this.Ij, Ih);
            } else if (this.Il) {
                setMarginsTop(this.Ii, Ih);
                setMarginsTop(this.Ij, Ig);
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
}

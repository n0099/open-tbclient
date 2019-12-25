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
import com.baidu.card.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class MultiImgLayout extends LinearLayout implements m<a> {
    private a JB;
    public TextView JZ;
    private z<a> Lb;
    private boolean Nf;
    public PlayVoiceBntNew Ns;
    public ConstrainImageGroup Nt;
    private boolean Nu;
    private boolean Nv;
    private LinkedList<MediaData> Nw;
    private String mFrom;
    public TextView mTitle;
    private static final int Np = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int Nq = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int Nr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int JX = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nf = true;
        this.JB = null;
        this.Nu = false;
        this.Nv = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.JZ = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.Ns = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.Ns.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.JB);
                }
            }
        });
        this.Nt = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.Nt.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.Nt.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.Nt != null) {
            this.Nt.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.Nt != null) {
            this.Nt.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.Nt != null) {
            this.Nt.setSingleImageRatio(d);
        }
    }

    private void setVoiceData(bj bjVar) {
        ArrayList<VoiceData.VoiceModel> azS = bjVar.azS();
        if (v.isEmpty(azS)) {
            this.Ns.setVisibility(8);
            this.Nv = false;
            return;
        }
        this.Ns.setVisibility(0);
        VoiceData.VoiceModel voiceModel = azS.get(0);
        this.Ns.setVoiceModel(voiceModel);
        this.Ns.setTag(voiceModel);
        this.Ns.bEM();
        if (voiceModel != null) {
            this.Ns.wL(voiceModel.voice_status.intValue());
        }
        this.Ns.cJE();
        this.Nv = true;
    }

    private void setImageData(bj bjVar) {
        this.Nt.setFromCDN(this.Nf);
        this.Nt.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> azO = bjVar.azO();
        if (i.axf().isShowImages() && v.getCount(azO) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < azO.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(azO, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.Nt.setVisibility(0);
                this.Nt.setFromCDN(this.Nf);
                this.Nt.setImageClickListener(new d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.Lb == null || !MultiImgLayout.this.Lb.a(view, (View) MultiImgLayout.this.JB, "")) {
                            z<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.JB.objType = 2;
                                subClickListener.Mn = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.JB);
                                MultiImgLayout.this.JB.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().dhE) {
                                au.a(view, MultiImgLayout.this.Nf, linkedList, i2, MultiImgLayout.this.JB.axx(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                au.a(MultiImgLayout.this.JB, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                au.a(MultiImgLayout.this.JB, view.getContext(), 2, false);
                            } else {
                                au.a(view, MultiImgLayout.this.Nf, linkedList, i2, MultiImgLayout.this.JB.axx(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.Nt.setImageMediaList(linkedList);
                this.Nu = true;
            } else {
                this.Nt.setVisibility(8);
                this.Nu = false;
            }
            this.Nw = linkedList;
            return;
        }
        this.Nt.setVisibility(8);
        this.Nu = false;
    }

    public void setFromCDN(boolean z) {
        this.Nf = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.Nt.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(a aVar) {
        this.JB = aVar;
        bj axx = aVar.axx();
        au.a(this.mTitle, axx);
        au.a(this.JZ, this.mTitle, axx, JX);
        setImageData(axx);
        setVoiceData(axx);
        mW();
    }

    private void mW() {
        if (this.JZ.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Nu) {
                setMarginsTop(this.Ns, Np);
                setMarginsTop(this.Nt, Nr);
            } else if (this.Nv) {
                setMarginsTop(this.Ns, Nr);
                setMarginsTop(this.Nt, Nq);
            }
        } else if (this.Ns != null && this.Ns.getLayoutParams() != null) {
            if (this.Nu) {
                setMarginsTop(this.Ns, Np);
            } else if (this.Nv) {
                setMarginsTop(this.Ns, Nq);
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

    public z<a> getSubClickListener() {
        return this.Lb;
    }

    public void setSubClickListener(z<a> zVar) {
        this.Lb = zVar;
    }
}

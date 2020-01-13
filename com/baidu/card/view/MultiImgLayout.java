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
/* loaded from: classes6.dex */
public class MultiImgLayout extends LinearLayout implements m<a> {
    private a JH;
    public TextView Kf;
    private z<a> Lh;
    private LinkedList<MediaData> NB;
    private boolean Nj;
    public PlayVoiceBntNew Nw;
    public ConstrainImageGroup Nx;
    private boolean Ny;
    private boolean Nz;
    private String mFrom;
    public TextView mTitle;
    private static final int Nt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int Nu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int Nv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int Kc = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nj = true;
        this.JH = null;
        this.Ny = false;
        this.Nz = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Kf = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.Nw = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.Nw.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.JH);
                }
            }
        });
        this.Nx = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.Nx.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.Nx.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.Nx != null) {
            this.Nx.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.Nx != null) {
            this.Nx.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.Nx != null) {
            this.Nx.setSingleImageRatio(d);
        }
    }

    private void setVoiceData(bj bjVar) {
        ArrayList<VoiceData.VoiceModel> aAl = bjVar.aAl();
        if (v.isEmpty(aAl)) {
            this.Nw.setVisibility(8);
            this.Nz = false;
            return;
        }
        this.Nw.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aAl.get(0);
        this.Nw.setVoiceModel(voiceModel);
        this.Nw.setTag(voiceModel);
        this.Nw.bFO();
        if (voiceModel != null) {
            this.Nw.wQ(voiceModel.voice_status.intValue());
        }
        this.Nw.cKI();
        this.Nz = true;
    }

    private void setImageData(bj bjVar) {
        this.Nx.setFromCDN(this.Nj);
        this.Nx.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> aAh = bjVar.aAh();
        if (i.axy().isShowImages() && v.getCount(aAh) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aAh.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aAh, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.Nx.setVisibility(0);
                this.Nx.setFromCDN(this.Nj);
                this.Nx.setImageClickListener(new d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.Lh == null || !MultiImgLayout.this.Lh.a(view, (View) MultiImgLayout.this.JH, "")) {
                            z<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.JH.objType = 2;
                                subClickListener.Ms = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.JH);
                                MultiImgLayout.this.JH.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().dhQ) {
                                au.a(view, MultiImgLayout.this.Nj, linkedList, i2, MultiImgLayout.this.JH.axQ(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                au.a(MultiImgLayout.this.JH, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                au.a(MultiImgLayout.this.JH, view.getContext(), 2, false);
                            } else {
                                au.a(view, MultiImgLayout.this.Nj, linkedList, i2, MultiImgLayout.this.JH.axQ(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.Nx.setImageMediaList(linkedList);
                this.Ny = true;
            } else {
                this.Nx.setVisibility(8);
                this.Ny = false;
            }
            this.NB = linkedList;
            return;
        }
        this.Nx.setVisibility(8);
        this.Ny = false;
    }

    public void setFromCDN(boolean z) {
        this.Nj = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.Nx.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(a aVar) {
        this.JH = aVar;
        bj axQ = aVar.axQ();
        au.a(this.mTitle, axQ);
        au.a(this.Kf, this.mTitle, axQ, Kc);
        setImageData(axQ);
        setVoiceData(axQ);
        mX();
    }

    private void mX() {
        if (this.Kf.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Ny) {
                setMarginsTop(this.Nw, Nt);
                setMarginsTop(this.Nx, Nv);
            } else if (this.Nz) {
                setMarginsTop(this.Nw, Nv);
                setMarginsTop(this.Nx, Nu);
            }
        } else if (this.Nw != null && this.Nw.getLayoutParams() != null) {
            if (this.Ny) {
                setMarginsTop(this.Nw, Nt);
            } else if (this.Nz) {
                setMarginsTop(this.Nw, Nu);
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
        return this.Lh;
    }

    public void setSubClickListener(z<a> zVar) {
        this.Lh = zVar;
    }
}

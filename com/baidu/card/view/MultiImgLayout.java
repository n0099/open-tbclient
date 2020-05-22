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
import com.baidu.card.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class MultiImgLayout extends LinearLayout implements n<AbsThreadDataSupport> {
    public TextView adV;
    private AbsThreadDataSupport adw;
    private aa<AbsThreadDataSupport> aeY;
    private boolean afL;
    private boolean aha;
    public PlayVoiceBntNew ahm;
    public ConstrainImageGroup ahn;
    private boolean aho;
    private boolean ahp;
    private LinkedList<MediaData> ahq;
    private String mFrom;
    public TextView mTitle;
    private static final int ahk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int adZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int ahl = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int adT = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aha = true;
        this.adw = null;
        this.aho = false;
        this.ahp = false;
        this.afL = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.adV = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.ahm = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.ahm.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.adw);
                }
            }
        });
        this.ahn = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.ahn.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.o(1.0d);
        this.ahn.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.ahn != null) {
            this.ahn.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.ahn != null) {
            this.ahn.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.ahn != null) {
            this.ahn.setSingleImageRatio(d);
        }
    }

    private void setVoiceData(bk bkVar) {
        ArrayList<VoiceData.VoiceModel> aQL = bkVar.aQL();
        if (v.isEmpty(aQL)) {
            this.ahm.setVisibility(8);
            this.ahp = false;
            return;
        }
        this.ahm.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aQL.get(0);
        this.ahm.setVoiceModel(voiceModel);
        this.ahm.setTag(voiceModel);
        this.ahm.crm();
        if (voiceModel != null) {
            this.ahm.yi(voiceModel.voice_status.intValue());
        }
        this.ahm.deL();
        this.ahp = true;
    }

    private void setImageData(bk bkVar) {
        this.ahn.setFromCDN(this.aha);
        this.ahn.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> aQH = bkVar.aQH();
        if (k.aNQ().isShowImages() && v.getCount(aQH) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aQH.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aQH, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.ahn.setVisibility(0);
                this.ahn.setFromCDN(this.aha);
                this.ahn.setImageClickListener(new d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.aeY == null || !MultiImgLayout.this.aeY.a(view, (View) MultiImgLayout.this.adw, "")) {
                            aa<AbsThreadDataSupport> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.adw.objType = 2;
                                subClickListener.agg = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.adw);
                                MultiImgLayout.this.adw.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().eaN) {
                                au.a(view, MultiImgLayout.this.aha, linkedList, i2, MultiImgLayout.this.adw.aOi(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                au.a(MultiImgLayout.this.adw, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                au.a(MultiImgLayout.this.adw, view.getContext(), 2, false);
                            } else {
                                au.a(view, MultiImgLayout.this.aha, linkedList, i2, MultiImgLayout.this.adw.aOi(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.ahn.setImageMediaList(linkedList);
                this.aho = true;
            } else {
                this.ahn.setVisibility(8);
                this.aho = false;
            }
            this.ahq = linkedList;
            return;
        }
        this.ahn.setVisibility(8);
        this.aho = false;
    }

    public void setFromCDN(boolean z) {
        this.aha = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.ahn.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adw = absThreadDataSupport;
        bk aOi = absThreadDataSupport.aOi();
        au.a(this.mTitle, aOi, this.afL);
        au.a(this.adV, this.mTitle, aOi, adT, this.afL);
        setImageData(aOi);
        setVoiceData(aOi);
        rP();
    }

    private void rP() {
        if (this.adV.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.aho) {
                setMarginsTop(this.ahm, ahk);
                setMarginsTop(this.ahn, ahl);
            } else if (this.ahp) {
                setMarginsTop(this.ahm, ahl);
                setMarginsTop(this.ahn, adZ);
            }
        } else if (this.ahm != null && this.ahm.getLayoutParams() != null) {
            if (this.aho) {
                setMarginsTop(this.ahm, ahk);
            } else if (this.ahp) {
                setMarginsTop(this.ahm, adZ);
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

    public aa<AbsThreadDataSupport> getSubClickListener() {
        return this.aeY;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.aeY = aaVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.afL = z;
    }
}

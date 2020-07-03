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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.w;
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
    public TextView aeA;
    private AbsThreadDataSupport aea;
    private aa<AbsThreadDataSupport> afH;
    private boolean agw;
    private LinkedList<MediaData> aiA;
    private boolean aik;
    public PlayVoiceBntNew aiw;
    public ConstrainImageGroup aix;
    private boolean aiy;
    private boolean aiz;
    private String mFrom;
    public TextView mTitle;
    private static final int aiu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int aeF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int aiv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int aey = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aik = true;
        this.aea = null;
        this.aiy = false;
        this.aiz = false;
        this.agw = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aeA = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.aiw = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.aiw.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.aea);
                }
            }
        });
        this.aix = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.aix.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.o(1.0d);
        this.aix.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.aix != null) {
            this.aix.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.aix != null) {
            this.aix.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.aix != null) {
            this.aix.setSingleImageRatio(d);
        }
    }

    private void setVoiceData(bu buVar) {
        ArrayList<VoiceData.VoiceModel> aSC = buVar.aSC();
        if (w.isEmpty(aSC)) {
            this.aiw.setVisibility(8);
            this.aiz = false;
            return;
        }
        this.aiw.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aSC.get(0);
        this.aiw.setVoiceModel(voiceModel);
        this.aiw.setTag(voiceModel);
        this.aiw.aYi();
        if (voiceModel != null) {
            this.aiw.yU(voiceModel.voice_status.intValue());
        }
        this.aiw.bCn();
        this.aiz = true;
    }

    private void setImageData(bu buVar) {
        this.aix.setFromCDN(this.aik);
        this.aix.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> aSy = buVar.aSy();
        if (k.aPA().isShowImages() && w.getCount(aSy) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aSy.size(); i++) {
                MediaData mediaData = (MediaData) w.getItem(aSy, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (w.getCount(linkedList) > 0) {
                this.aix.setVisibility(0);
                this.aix.setFromCDN(this.aik);
                this.aix.setImageClickListener(new d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.afH == null || !MultiImgLayout.this.afH.a(view, (View) MultiImgLayout.this.aea, "")) {
                            aa<AbsThreadDataSupport> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.aea.objType = 2;
                                subClickListener.agT = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.aea);
                                MultiImgLayout.this.aea.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().ejx) {
                                aw.a(view, MultiImgLayout.this.aik, linkedList, i2, MultiImgLayout.this.aea.aPS(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                aw.a(MultiImgLayout.this.aea, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                aw.a(MultiImgLayout.this.aea, view.getContext(), 2, false);
                            } else {
                                aw.a(view, MultiImgLayout.this.aik, linkedList, i2, MultiImgLayout.this.aea.aPS(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.aix.setImageMediaList(linkedList);
                this.aiy = true;
            } else {
                this.aix.setVisibility(8);
                this.aiy = false;
            }
            this.aiA = linkedList;
            return;
        }
        this.aix.setVisibility(8);
        this.aiy = false;
    }

    public void setFromCDN(boolean z) {
        this.aik = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.aix.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.aea = absThreadDataSupport;
        bu aPS = absThreadDataSupport.aPS();
        aw.a(this.mTitle, aPS, this.agw);
        aw.a(this.aeA, this.mTitle, aPS, aey, this.agw);
        setImageData(aPS);
        setVoiceData(aPS);
        sh();
    }

    private void sh() {
        if (this.aeA.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.aiy) {
                setMarginsTop(this.aiw, aiu);
                setMarginsTop(this.aix, aiv);
            } else if (this.aiz) {
                setMarginsTop(this.aiw, aiv);
                setMarginsTop(this.aix, aeF);
            }
        } else if (this.aiw != null && this.aiw.getLayoutParams() != null) {
            if (this.aiy) {
                setMarginsTop(this.aiw, aiu);
            } else if (this.aiz) {
                setMarginsTop(this.aiw, aeF);
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
        return this.afH;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.afH = aaVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.agw = z;
    }
}

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
import com.baidu.tbadk.core.data.bg;
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
    public TextView VC;
    private a Vq;
    private ab<a> Wu;
    private boolean XJ;
    public PlayVoiceBntNew XS;
    public ConstrainImageGroup XT;
    private boolean XU;
    private boolean XV;
    private LinkedList<MediaData> XW;
    private String mFrom;
    public TextView mTitle;
    private static final int XP = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int XQ = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int XR = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int VA = l.af(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.XJ = true;
        this.Vq = null;
        this.XU = false;
        this.XV = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.VC = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.XS = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.XS.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.Vq);
                }
            }
        });
        this.XT = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.XT.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.h(1.0d);
        this.XT.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.XT != null) {
            this.XT.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.XT != null) {
            this.XT.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.XT != null) {
            this.XT.setSingleImageRatio(d);
        }
    }

    private void setVoiceData(bg bgVar) {
        ArrayList<VoiceData.VoiceModel> adJ = bgVar.adJ();
        if (v.aa(adJ)) {
            this.XS.setVisibility(8);
            this.XV = false;
            return;
        }
        this.XS.setVisibility(0);
        VoiceData.VoiceModel voiceModel = adJ.get(0);
        this.XS.setVoiceModel(voiceModel);
        this.XS.setTag(voiceModel);
        this.XS.bFA();
        if (voiceModel != null) {
            this.XS.vx(voiceModel.voice_status.intValue());
        }
        this.XS.cnD();
        this.XV = true;
    }

    private void setImageData(bg bgVar) {
        this.XT.setFromCDN(this.XJ);
        this.XT.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> adF = bgVar.adF();
        if (com.baidu.tbadk.core.i.abb().abf() && v.Z(adF) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < adF.size(); i++) {
                MediaData mediaData = (MediaData) v.c(adF, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.Z(linkedList) > 0) {
                this.XT.setVisibility(0);
                this.XT.setFromCDN(this.XJ);
                this.XT.setImageClickListener(new d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.Wu == null || !MultiImgLayout.this.Wu.a(view, (View) MultiImgLayout.this.Vq, "")) {
                            ab<a> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.Vq.objType = 2;
                                subClickListener.Xp = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.Vq);
                                MultiImgLayout.this.Vq.objType = 1;
                            }
                            au.a(view, MultiImgLayout.this.XJ, linkedList, i2, MultiImgLayout.this.Vq.abv(), MultiImgLayout.this.mFrom);
                        }
                    }
                });
                this.XT.setImageMediaList(linkedList);
                this.XU = true;
            } else {
                this.XT.setVisibility(8);
                this.XU = false;
            }
            this.XW = linkedList;
            return;
        }
        this.XT.setVisibility(8);
        this.XU = false;
    }

    public void setFromCDN(boolean z) {
        this.XJ = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.XT.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(a aVar) {
        this.Vq = aVar;
        bg abv = aVar.abv();
        au.a(this.mTitle, abv);
        au.a(this.VC, this.mTitle, abv, VA);
        setImageData(abv);
        setVoiceData(abv);
        qw();
    }

    private void qw() {
        if (this.VC.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.XU) {
                setMarginsTop(this.XS, XP);
                setMarginsTop(this.XT, XR);
            } else if (this.XV) {
                setMarginsTop(this.XS, XR);
                setMarginsTop(this.XT, XQ);
            }
        } else if (this.XS != null && this.XS.getLayoutParams() != null) {
            if (this.XU) {
                setMarginsTop(this.XS, XP);
            } else if (this.XV) {
                setMarginsTop(this.XS, XQ);
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
        return this.Wu;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.Wu = abVar;
    }
}

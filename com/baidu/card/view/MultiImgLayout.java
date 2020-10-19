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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes21.dex */
public class MultiImgLayout extends LinearLayout implements p<AbsThreadDataSupport> {
    private AbsThreadDataSupport afH;
    public TextView agl;
    private aa<AbsThreadDataSupport> ahu;
    private boolean aij;
    private boolean akj;
    public PlayVoiceBntNew akv;
    public ConstrainImageGroup akw;
    private boolean akx;
    private boolean aky;
    private LinkedList<MediaData> akz;
    private String mFrom;
    public TextView mTitle;
    private static final int akt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int agq = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int aku = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int agj = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akj = true;
        this.afH = null;
        this.akx = false;
        this.aky = false;
        this.aij = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.agl = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.akv = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.akv.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.afH);
                }
            }
        });
        this.akw = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.akw.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.x(1.0d);
        this.akw.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.akw != null) {
            this.akw.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.akw != null) {
            this.akw.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.akw != null) {
            this.akw.setSingleImageRatio(d);
        }
    }

    private void setVoiceData(bw bwVar) {
        ArrayList<VoiceData.VoiceModel> biu = bwVar.biu();
        if (y.isEmpty(biu)) {
            this.akv.setVisibility(8);
            this.aky = false;
            return;
        }
        this.akv.setVisibility(0);
        VoiceData.VoiceModel voiceModel = biu.get(0);
        this.akv.setVoiceModel(voiceModel);
        this.akv.setTag(voiceModel);
        this.akv.changeSkin();
        if (voiceModel != null) {
            this.akv.CT(voiceModel.voice_status.intValue());
        }
        this.akv.bTK();
        this.aky = true;
    }

    private void setImageData(bw bwVar) {
        this.akw.setFromCDN(this.akj);
        this.akw.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> biq = bwVar.biq();
        if (k.bfo().isShowImages() && y.getCount(biq) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < biq.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(biq, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.akw.setVisibility(0);
                this.akw.setFromCDN(this.akj);
                this.akw.setImageClickListener(new d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.ahu == null || !MultiImgLayout.this.ahu.a(view, (View) MultiImgLayout.this.afH, "")) {
                            aa<AbsThreadDataSupport> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.afH.objType = 2;
                                subClickListener.aiI = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.afH);
                                MultiImgLayout.this.afH.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().eOk) {
                                ay.a(view, MultiImgLayout.this.akj, linkedList, i2, MultiImgLayout.this.afH.bfG(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                ay.a(MultiImgLayout.this.afH, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                ay.a(MultiImgLayout.this.afH, view.getContext(), 2, false);
                            } else {
                                ay.a(view, MultiImgLayout.this.akj, linkedList, i2, MultiImgLayout.this.afH.bfG(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.akw.setImageMediaList(linkedList);
                this.akx = true;
            } else {
                this.akw.setVisibility(8);
                this.akx = false;
            }
            this.akz = linkedList;
            return;
        }
        this.akw.setVisibility(8);
        this.akx = false;
    }

    public void setFromCDN(boolean z) {
        this.akj = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.akw.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afH = absThreadDataSupport;
        bw bfG = absThreadDataSupport.bfG();
        ay.a(this.mTitle, bfG, this.aij);
        ay.a(this.agl, this.mTitle, bfG, agj, this.aij);
        setImageData(bfG);
        setVoiceData(bfG);
        ua();
    }

    private void ua() {
        if (this.agl.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.akx) {
                setMarginsTop(this.akv, akt);
                setMarginsTop(this.akw, aku);
            } else if (this.aky) {
                setMarginsTop(this.akv, aku);
                setMarginsTop(this.akw, agq);
            }
        } else if (this.akv != null && this.akv.getLayoutParams() != null) {
            if (this.akx) {
                setMarginsTop(this.akv, akt);
            } else if (this.aky) {
                setMarginsTop(this.akv, agq);
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
        return this.ahu;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.ahu = aaVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.aij = z;
    }
}

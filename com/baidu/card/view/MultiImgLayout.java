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
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes21.dex */
public class MultiImgLayout extends LinearLayout implements p<AbsThreadDataSupport> {
    private AbsThreadDataSupport afI;
    public TextView agm;
    private ab<AbsThreadDataSupport> ahv;
    private boolean aik;
    private LinkedList<MediaData> akA;
    private boolean akk;
    public PlayVoiceBntNew akw;
    public ConstrainImageGroup akx;
    private boolean aky;
    private boolean akz;
    private String mFrom;
    public TextView mTitle;
    private static final int aku = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int agr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int akv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int agk = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akk = true;
        this.afI = null;
        this.aky = false;
        this.akz = false;
        this.aik = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.agm = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.akw = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.akw.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<AbsThreadDataSupport> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.afI);
                }
            }
        });
        this.akx = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.akx.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.y(1.0d);
        this.akx.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.akx != null) {
            this.akx.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.akx != null) {
            this.akx.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.akx != null) {
            this.akx.setSingleImageRatio(d);
        }
    }

    private void setVoiceData(bw bwVar) {
        ArrayList<VoiceData.VoiceModel> bkn = bwVar.bkn();
        if (y.isEmpty(bkn)) {
            this.akw.setVisibility(8);
            this.akz = false;
            return;
        }
        this.akw.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bkn.get(0);
        this.akw.setVoiceModel(voiceModel);
        this.akw.setTag(voiceModel);
        this.akw.changeSkin();
        if (voiceModel != null) {
            this.akw.Dm(voiceModel.voice_status.intValue());
        }
        this.akw.bWJ();
        this.akz = true;
    }

    private void setImageData(bw bwVar) {
        this.akx.setFromCDN(this.akk);
        this.akx.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> bkj = bwVar.bkj();
        if (k.bhh().isShowImages() && y.getCount(bkj) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < bkj.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bkj, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.akx.setVisibility(0);
                this.akx.setFromCDN(this.akk);
                this.akx.setImageClickListener(new d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.ahv == null || !MultiImgLayout.this.ahv.a(view, (View) MultiImgLayout.this.afI, "")) {
                            ab<AbsThreadDataSupport> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.afI.objType = 2;
                                subClickListener.aiJ = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.afI);
                                MultiImgLayout.this.afI.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().eWG) {
                                ay.a(view, MultiImgLayout.this.akk, linkedList, i2, MultiImgLayout.this.afI.bhz(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                ay.a(MultiImgLayout.this.afI, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                ay.a(MultiImgLayout.this.afI, view.getContext(), 2, false);
                            } else {
                                ay.a(view, MultiImgLayout.this.akk, linkedList, i2, MultiImgLayout.this.afI.bhz(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.akx.setImageMediaList(linkedList);
                this.aky = true;
            } else {
                this.akx.setVisibility(8);
                this.aky = false;
            }
            this.akA = linkedList;
            return;
        }
        this.akx.setVisibility(8);
        this.aky = false;
    }

    public void setFromCDN(boolean z) {
        this.akk = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.akx.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afI = absThreadDataSupport;
        bw bhz = absThreadDataSupport.bhz();
        ay.a(this.mTitle, bhz, this.aik);
        ay.a(this.agm, this.mTitle, bhz, agk, this.aik);
        setImageData(bhz);
        setVoiceData(bhz);
        ua();
    }

    private void ua() {
        if (this.agm.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.aky) {
                setMarginsTop(this.akw, aku);
                setMarginsTop(this.akx, akv);
            } else if (this.akz) {
                setMarginsTop(this.akw, akv);
                setMarginsTop(this.akx, agr);
            }
        } else if (this.akw != null && this.akw.getLayoutParams() != null) {
            if (this.aky) {
                setMarginsTop(this.akw, aku);
            } else if (this.akz) {
                setMarginsTop(this.akw, agr);
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

    public ab<AbsThreadDataSupport> getSubClickListener() {
        return this.ahv;
    }

    public void setSubClickListener(ab<AbsThreadDataSupport> abVar) {
        this.ahv = abVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.aik = z;
    }
}

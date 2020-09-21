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
/* loaded from: classes20.dex */
public class MultiImgLayout extends LinearLayout implements p<AbsThreadDataSupport> {
    public TextView afT;
    private AbsThreadDataSupport afq;
    private boolean ahR;
    private aa<AbsThreadDataSupport> ahd;
    private boolean ajR;
    public PlayVoiceBntNew akd;
    public ConstrainImageGroup ake;
    private boolean akf;
    private boolean akg;
    private LinkedList<MediaData> akh;
    private String mFrom;
    public TextView mTitle;
    private static final int akb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int afY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int akc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int afR = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajR = true;
        this.afq = null;
        this.akf = false;
        this.akg = false;
        this.ahR = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.afT = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.akd = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.akd.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.afq);
                }
            }
        });
        this.ake = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.ake.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.u(1.0d);
        this.ake.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.ake != null) {
            this.ake.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.ake != null) {
            this.ake.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.ake != null) {
            this.ake.setSingleImageRatio(d);
        }
    }

    private void setVoiceData(bw bwVar) {
        ArrayList<VoiceData.VoiceModel> bfL = bwVar.bfL();
        if (y.isEmpty(bfL)) {
            this.akd.setVisibility(8);
            this.akg = false;
            return;
        }
        this.akd.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bfL.get(0);
        this.akd.setVoiceModel(voiceModel);
        this.akd.setTag(voiceModel);
        this.akd.changeSkin();
        if (voiceModel != null) {
            this.akd.Cn(voiceModel.voice_status.intValue());
        }
        this.akd.bQr();
        this.akg = true;
    }

    private void setImageData(bw bwVar) {
        this.ake.setFromCDN(this.ajR);
        this.ake.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> bfH = bwVar.bfH();
        if (k.bcG().isShowImages() && y.getCount(bfH) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < bfH.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bfH, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.ake.setVisibility(0);
                this.ake.setFromCDN(this.ajR);
                this.ake.setImageClickListener(new d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.ahd == null || !MultiImgLayout.this.ahd.a(view, (View) MultiImgLayout.this.afq, "")) {
                            aa<AbsThreadDataSupport> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.afq.objType = 2;
                                subClickListener.aiq = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.afq);
                                MultiImgLayout.this.afq.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().eCd) {
                                ay.a(view, MultiImgLayout.this.ajR, linkedList, i2, MultiImgLayout.this.afq.bcY(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                ay.a(MultiImgLayout.this.afq, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                ay.a(MultiImgLayout.this.afq, view.getContext(), 2, false);
                            } else {
                                ay.a(view, MultiImgLayout.this.ajR, linkedList, i2, MultiImgLayout.this.afq.bcY(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.ake.setImageMediaList(linkedList);
                this.akf = true;
            } else {
                this.ake.setVisibility(8);
                this.akf = false;
            }
            this.akh = linkedList;
            return;
        }
        this.ake.setVisibility(8);
        this.akf = false;
    }

    public void setFromCDN(boolean z) {
        this.ajR = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.ake.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        this.afq = absThreadDataSupport;
        bw bcY = absThreadDataSupport.bcY();
        ay.a(this.mTitle, bcY, this.ahR);
        ay.a(this.afT, this.mTitle, bcY, afR, this.ahR);
        setImageData(bcY);
        setVoiceData(bcY);
        ua();
    }

    private void ua() {
        if (this.afT.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.akf) {
                setMarginsTop(this.akd, akb);
                setMarginsTop(this.ake, akc);
            } else if (this.akg) {
                setMarginsTop(this.akd, akc);
                setMarginsTop(this.ake, afY);
            }
        } else if (this.akd != null && this.akd.getLayoutParams() != null) {
            if (this.akf) {
                setMarginsTop(this.akd, akb);
            } else if (this.akg) {
                setMarginsTop(this.akd, afY);
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
        return this.ahd;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.ahd = aaVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahR = z;
    }
}

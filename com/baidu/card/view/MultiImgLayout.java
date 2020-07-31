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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes15.dex */
public class MultiImgLayout extends LinearLayout implements n<AbsThreadDataSupport> {
    private AbsThreadDataSupport adQ;
    public TextView aeq;
    private aa<AbsThreadDataSupport> afy;
    private boolean agn;
    private boolean aib;
    public PlayVoiceBntNew aio;
    public ConstrainImageGroup aip;
    private boolean aiq;
    private boolean air;
    private LinkedList<MediaData> ais;
    private String mFrom;
    public TextView mTitle;
    private static final int aim = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int aev = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int ain = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int aeo = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aib = true;
        this.adQ = null;
        this.aiq = false;
        this.air = false;
        this.agn = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aeq = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.aio = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.aio.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.adQ);
                }
            }
        });
        this.aip = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.aip.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.o(1.0d);
        this.aip.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.aip != null) {
            this.aip.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.aip != null) {
            this.aip.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.aip != null) {
            this.aip.setSingleImageRatio(d);
        }
    }

    private void setVoiceData(bv bvVar) {
        ArrayList<VoiceData.VoiceModel> aWy = bvVar.aWy();
        if (x.isEmpty(aWy)) {
            this.aio.setVisibility(8);
            this.air = false;
            return;
        }
        this.aio.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aWy.get(0);
        this.aio.setVoiceModel(voiceModel);
        this.aio.setTag(voiceModel);
        this.aio.changeSkin();
        if (voiceModel != null) {
            this.aio.zt(voiceModel.voice_status.intValue());
        }
        this.aio.bFz();
        this.air = true;
    }

    private void setImageData(bv bvVar) {
        this.aip.setFromCDN(this.aib);
        this.aip.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> aWu = bvVar.aWu();
        if (k.aTv().isShowImages() && x.getCount(aWu) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aWu.size(); i++) {
                MediaData mediaData = (MediaData) x.getItem(aWu, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (x.getCount(linkedList) > 0) {
                this.aip.setVisibility(0);
                this.aip.setFromCDN(this.aib);
                this.aip.setImageClickListener(new d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.afy == null || !MultiImgLayout.this.afy.a(view, (View) MultiImgLayout.this.adQ, "")) {
                            aa<AbsThreadDataSupport> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.adQ.objType = 2;
                                subClickListener.agK = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.adQ);
                                MultiImgLayout.this.adQ.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().epJ) {
                                ax.a(view, MultiImgLayout.this.aib, linkedList, i2, MultiImgLayout.this.adQ.aTN(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                ax.a(MultiImgLayout.this.adQ, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                ax.a(MultiImgLayout.this.adQ, view.getContext(), 2, false);
                            } else {
                                ax.a(view, MultiImgLayout.this.aib, linkedList, i2, MultiImgLayout.this.adQ.aTN(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.aip.setImageMediaList(linkedList);
                this.aiq = true;
            } else {
                this.aip.setVisibility(8);
                this.aiq = false;
            }
            this.ais = linkedList;
            return;
        }
        this.aip.setVisibility(8);
        this.aiq = false;
    }

    public void setFromCDN(boolean z) {
        this.aib = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.aip.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adQ = absThreadDataSupport;
        bv aTN = absThreadDataSupport.aTN();
        ax.a(this.mTitle, aTN, this.agn);
        ax.a(this.aeq, this.mTitle, aTN, aeo, this.agn);
        setImageData(aTN);
        setVoiceData(aTN);
        sj();
    }

    private void sj() {
        if (this.aeq.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.aiq) {
                setMarginsTop(this.aio, aim);
                setMarginsTop(this.aip, ain);
            } else if (this.air) {
                setMarginsTop(this.aio, ain);
                setMarginsTop(this.aip, aev);
            }
        } else if (this.aio != null && this.aio.getLayoutParams() != null) {
            if (this.aiq) {
                setMarginsTop(this.aio, aim);
            } else if (this.air) {
                setMarginsTop(this.aio, aev);
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
        return this.afy;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.afy = aaVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.agn = z;
    }
}

package com.baidu.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.d.b;
import com.baidu.adp.lib.util.l;
import com.baidu.card.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
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
/* loaded from: classes.dex */
public class MultiImgLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a ahB;
    private boolean ahV;
    public TextView air;
    private ab<com.baidu.tbadk.core.data.a> ajy;
    private boolean amh;
    public PlayVoiceBntNew amu;
    public ConstrainImageGroup amv;
    private boolean amw;
    private boolean amx;
    private LinkedList<MediaData> amy;
    private String mFrom;
    public TextView mTitle;
    private static final int amr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int ams = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int amt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int aip = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MultiImgLayout(Context context) {
        this(context, null);
    }

    public MultiImgLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amh = true;
        this.ahB = null;
        this.amw = false;
        this.amx = false;
        this.ahV = false;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.air = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.amu = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.amu.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MultiImgLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MultiImgLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MultiImgLayout.this.ahB);
                }
            }
        });
        this.amv = (ConstrainImageGroup) findViewById(R.id.thread_card_img_group);
        this.amv.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002));
        com.baidu.tbadk.widget.layout.a aVar = new com.baidu.tbadk.widget.layout.a(3);
        aVar.r(1.0d);
        this.amv.setImageProcessor(aVar);
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        if (this.amv != null) {
            this.amv.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        if (this.amv != null) {
            this.amv.setImageViewPool(bVar);
        }
    }

    public void setSingleImageRatio(double d) {
        if (this.amv != null) {
            this.amv.setSingleImageRatio(d);
        }
    }

    private void setVoiceData(cb cbVar) {
        ArrayList<VoiceData.VoiceModel> bof = cbVar.bof();
        if (y.isEmpty(bof)) {
            this.amu.setVisibility(8);
            this.amx = false;
            return;
        }
        this.amu.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bof.get(0);
        this.amu.setVoiceModel(voiceModel);
        this.amu.setTag(voiceModel);
        this.amu.bur();
        if (voiceModel != null) {
            this.amu.Ds(voiceModel.voice_status.intValue());
        }
        this.amu.ccH();
        this.amx = true;
    }

    private void setImageData(cb cbVar) {
        this.amv.setFromCDN(this.amh);
        this.amv.setSinglePicUseStyleV10(true);
        ArrayList<MediaData> bob = cbVar.bob();
        if (k.bkV().isShowImages() && y.getCount(bob) != 0) {
            final LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < bob.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bob, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.amv.setVisibility(0);
                this.amv.setFromCDN(this.amh);
                this.amv.setImageClickListener(new d() { // from class: com.baidu.card.view.MultiImgLayout.2
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z) {
                        if (MultiImgLayout.this.ajy == null || !MultiImgLayout.this.ajy.a(view, (View) MultiImgLayout.this.ahB, "")) {
                            ab<com.baidu.tbadk.core.data.a> subClickListener = MultiImgLayout.this.getSubClickListener();
                            if (subClickListener != null) {
                                view.setTag("1");
                                MultiImgLayout.this.ahB.objType = 2;
                                subClickListener.akF = Boolean.valueOf(z);
                                subClickListener.a(view, MultiImgLayout.this.ahB);
                                MultiImgLayout.this.ahB.objType = 1;
                            }
                            if (TbadkCoreApplication.getInst().getAdAdSense() == null || !TbadkCoreApplication.getInst().getAdAdSense().frV) {
                                az.a(view, MultiImgLayout.this.amh, linkedList, i2, MultiImgLayout.this.ahB.blp(), MultiImgLayout.this.mFrom);
                            } else if ("frs".equals(MultiImgLayout.this.mFrom)) {
                                az.a(MultiImgLayout.this.ahB, view.getContext(), 3, false);
                            } else if ("index".equals(MultiImgLayout.this.mFrom)) {
                                az.a(MultiImgLayout.this.ahB, view.getContext(), 2, false);
                            } else {
                                az.a(view, MultiImgLayout.this.amh, linkedList, i2, MultiImgLayout.this.ahB.blp(), MultiImgLayout.this.mFrom);
                            }
                        }
                    }
                });
                this.amv.setImageMediaList(linkedList);
                this.amw = true;
            } else {
                this.amv.setVisibility(8);
                this.amw = false;
            }
            this.amy = linkedList;
            return;
        }
        this.amv.setVisibility(8);
        this.amw = false;
    }

    public void setFromCDN(boolean z) {
        this.amh = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        this.amv.setPreloadSizeReadyCallback(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        boolean z = true;
        this.ahB = aVar;
        cb blp = aVar.blp();
        az.a(this.mTitle, blp, this.ahV);
        az.a(this.air, this.mTitle, blp, aip, this.ahV);
        boolean z2 = this.mTitle == null || this.mTitle.getVisibility() != 0;
        boolean z3 = this.air == null || this.air.getVisibility() != 0;
        ConstrainImageGroup constrainImageGroup = this.amv;
        if (!z2 || !z3) {
            z = false;
        }
        az.a(constrainImageGroup, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setImageData(blp);
        setVoiceData(blp);
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

    public ab<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.ajy;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.ajy = abVar;
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahV = z;
    }
}

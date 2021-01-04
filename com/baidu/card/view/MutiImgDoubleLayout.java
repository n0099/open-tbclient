package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.card.p;
import com.baidu.tbadk.a.b.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MutiImgDoubleLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a ahi;
    public TextView aia;
    private aa<com.baidu.tbadk.core.data.a> ajj;
    private boolean alQ;
    public PlayVoiceBntNew amd;
    private boolean amf;
    private boolean amg;
    private LinkedList<MediaData> amh;
    private int amq;
    private d amr;
    public RelativeLayout amv;
    public TbImageView amw;
    public TbImageView amx;
    private String mFrom;
    public TextView mTitle;
    private static final int ama = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int amb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int amc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int ahY = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgDoubleLayout(Context context) {
        this(context, null);
    }

    public MutiImgDoubleLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alQ = true;
        this.ahi = null;
        this.amf = false;
        this.amg = false;
        this.amq = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_double_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aia = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.amd = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.amd.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgDoubleLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgDoubleLayout.this.ahi);
                }
            }
        });
        b.j(this.amd, R.dimen.tbds28, R.dimen.tbds14);
        b.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        b.a(this.aia, R.dimen.tbds7, R.dimen.tbds10);
        this.amv = (RelativeLayout) findViewById(R.id.thread_card_img_double_container);
        b.j(this.amv, R.dimen.tbds20, R.dimen.tbds14);
        this.amw = (TbImageView) findViewById(R.id.thread_card_img_double_one);
        this.amx = (TbImageView) findViewById(R.id.thread_card_img_double_two);
        this.amr = new d() { // from class: com.baidu.card.view.MutiImgDoubleLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void c(View view, int i, boolean z) {
                aa<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgDoubleLayout.this.ahi.objType = 2;
                    subClickListener.a(view, MutiImgDoubleLayout.this.ahi);
                    MutiImgDoubleLayout.this.ahi.objType = 1;
                }
                ay.a(view, MutiImgDoubleLayout.this.alQ, MutiImgDoubleLayout.this.amh, i, MutiImgDoubleLayout.this.ahi.boO(), MutiImgDoubleLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bz bzVar) {
        ArrayList<VoiceData.VoiceModel> brD = bzVar.brD();
        if (x.isEmpty(brD)) {
            this.amd.setVisibility(8);
            this.amg = false;
            return;
        }
        this.amd.setVisibility(0);
        VoiceData.VoiceModel voiceModel = brD.get(0);
        this.amd.setVoiceModel(voiceModel);
        this.amd.setTag(voiceModel);
        this.amd.bxN();
        if (voiceModel != null) {
            this.amd.EE(voiceModel.voice_status.intValue());
        }
        this.amd.cfq();
        this.amg = true;
    }

    private void setImageData(bz bzVar) {
        ArrayList<MediaData> brz = bzVar.brz();
        if (k.bou().isShowImages() && x.getCount(brz) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < brz.size(); i++) {
                MediaData mediaData = (MediaData) x.getItem(brz, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.amh = linkedList;
            this.amf = true;
            this.amv.setVisibility(8);
            if (x.getCount(linkedList) == 2) {
                this.amv.setVisibility(0);
                this.amw.setConrers(15);
                a((MediaData) x.getItem(brz, 0), this.amw, true, false, false, 0);
                this.amx.setConrers(15);
                a((MediaData) x.getItem(brz, 1), this.amx, true, false, true, 1);
                return;
            }
            this.amv.setVisibility(8);
            this.amf = false;
            return;
        }
        this.amv.setVisibility(8);
        this.amf = false;
    }

    public void setFromCDN(boolean z) {
        this.alQ = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(com.baidu.tbadk.core.data.a aVar) {
        this.ahi = aVar;
        bz boO = aVar.boO();
        ay.a(this.mTitle, boO);
        ay.a(this.aia, this.mTitle, boO, ahY);
        setImageData(boO);
        setVoiceData(boO);
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

    public aa<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.ajj;
    }

    public void setSubClickListener(aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.ajj = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bG = bG(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.amw.getLayoutParams();
        layoutParams.width = bG;
        layoutParams.height = bG;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.amx.getLayoutParams();
        layoutParams2.width = bG;
        layoutParams2.height = bG;
        if (this.amv.getVisibility() != 8) {
            this.amw.setLayoutParams(layoutParams);
            this.amx.setLayoutParams(layoutParams2);
        }
    }

    private int bG(int i) {
        if (this.amq > 0) {
            return this.amq;
        }
        this.amq = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.amq;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.alQ ? 13 : 14;
        if (!at.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ao.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
        }
        tbImageView.startLoad(a2, i2, false);
        a(tbImageView, i, z2, z3);
    }

    private String a(MediaData mediaData) {
        if (mediaData == null) {
            return "";
        }
        String picUrl = mediaData.getPicUrl();
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getSmallUrl();
        }
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getThumbnails_url();
        }
        if (TextUtils.isEmpty(picUrl)) {
            return mediaData.getSrc_pic();
        }
        return picUrl;
    }

    private void a(TbImageView tbImageView, int i, boolean z, boolean z2) {
        if (this.amr != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.amr == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private boolean amu;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.amu = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgDoubleLayout.this.amr != null) {
                MutiImgDoubleLayout.this.amr.c(view, this.currentIndex, this.hasMore && this.amu);
            }
        }
    }
}

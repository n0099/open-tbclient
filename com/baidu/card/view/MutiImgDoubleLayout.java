package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.a.b;
import com.baidu.card.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes21.dex */
public class MutiImgDoubleLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private static final int ahn;
    private com.baidu.tbadk.core.data.a agJ;
    public TextView ahp;
    private ab<com.baidu.tbadk.core.data.a> aix;
    public PlayVoiceBntNew alB;
    private boolean alD;
    private boolean alE;
    private LinkedList<MediaData> alF;
    private int alO;
    private d alP;
    public RelativeLayout alT;
    public TbImageView alU;
    public TbImageView alV;
    private boolean alo;
    private String mFrom;
    public TextView mTitle;
    private static final int aly = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int alz = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int alA = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);

    static {
        ahn = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.tbadk.a.d.bkA() ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgDoubleLayout(Context context) {
        this(context, null);
    }

    public MutiImgDoubleLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alo = true;
        this.agJ = null;
        this.alD = false;
        this.alE = false;
        this.alO = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_double_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ahp = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.alB = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.alB.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgDoubleLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgDoubleLayout.this.agJ);
                }
            }
        });
        com.baidu.tbadk.a.b.a.d(this.alB, R.dimen.tbds28, R.dimen.tbds14);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.ahp, R.dimen.tbds7, R.dimen.tbds10);
        this.alT = (RelativeLayout) findViewById(R.id.thread_card_img_double_container);
        com.baidu.tbadk.a.b.a.d(this.alT, R.dimen.tbds20, R.dimen.tbds14);
        this.alU = (TbImageView) findViewById(R.id.thread_card_img_double_one);
        this.alV = (TbImageView) findViewById(R.id.thread_card_img_double_two);
        this.alP = new d() { // from class: com.baidu.card.view.MutiImgDoubleLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgDoubleLayout.this.agJ.objType = 2;
                    subClickListener.a(view, MutiImgDoubleLayout.this.agJ);
                    MutiImgDoubleLayout.this.agJ.objType = 1;
                }
                az.a(view, MutiImgDoubleLayout.this.alo, MutiImgDoubleLayout.this.alF, i, MutiImgDoubleLayout.this.agJ.bmn(), MutiImgDoubleLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(by byVar) {
        ArrayList<VoiceData.VoiceModel> bpc = byVar.bpc();
        if (y.isEmpty(bpc)) {
            this.alB.setVisibility(8);
            this.alE = false;
            return;
        }
        this.alB.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bpc.get(0);
        this.alB.setVoiceModel(voiceModel);
        this.alB.setTag(voiceModel);
        this.alB.bvs();
        if (voiceModel != null) {
            this.alB.EM(voiceModel.voice_status.intValue());
        }
        this.alB.ccz();
        this.alE = true;
    }

    private void setImageData(by byVar) {
        ArrayList<MediaData> boY = byVar.boY();
        if (k.blV().isShowImages() && y.getCount(boY) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < boY.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(boY, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.alF = linkedList;
            this.alD = true;
            this.alT.setVisibility(8);
            if (y.getCount(linkedList) == 2) {
                this.alT.setVisibility(0);
                this.alU.setConrers(15);
                a((MediaData) y.getItem(boY, 0), this.alU, true, false, false, 0);
                this.alV.setConrers(15);
                a((MediaData) y.getItem(boY, 1), this.alV, true, false, true, 1);
                return;
            }
            this.alT.setVisibility(8);
            this.alD = false;
            return;
        }
        this.alT.setVisibility(8);
        this.alD = false;
    }

    public void setFromCDN(boolean z) {
        this.alo = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.agJ = aVar;
        by bmn = aVar.bmn();
        az.a(this.mTitle, bmn);
        az.a(this.ahp, this.mTitle, bmn, ahn);
        setImageData(bmn);
        setVoiceData(bmn);
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
        return this.aix;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.aix = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bG = bG(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.alU.getLayoutParams();
        layoutParams.width = bG;
        layoutParams.height = bG;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.alV.getLayoutParams();
        layoutParams2.width = bG;
        layoutParams2.height = bG;
        if (this.alT.getVisibility() != 8) {
            this.alU.setLayoutParams(layoutParams);
            this.alV.setLayoutParams(layoutParams2);
        }
    }

    private int bG(int i) {
        if (this.alO > 0) {
            return this.alO;
        }
        this.alO = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.alO;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.alo ? 13 : 14;
        if (!au.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ap.getColor(R.color.CAM_X0401));
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
        if (this.alP != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.alP == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements View.OnClickListener {
        private boolean alS;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.alS = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgDoubleLayout.this.alP != null) {
                MutiImgDoubleLayout.this.alP.b(view, this.currentIndex, this.hasMore && this.alS);
            }
        }
    }
}

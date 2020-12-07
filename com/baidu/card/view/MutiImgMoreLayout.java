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
import com.baidu.tbadk.core.util.UtilHelper;
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
public class MutiImgMoreLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private static final int ahn;
    private com.baidu.tbadk.core.data.a agJ;
    public TextView ahp;
    private ab<com.baidu.tbadk.core.data.a> aix;
    public PlayVoiceBntNew alB;
    private boolean alD;
    private boolean alE;
    private LinkedList<MediaData> alF;
    public RelativeLayout alI;
    public TbImageView alJ;
    public TbImageView alK;
    public TbImageView alL;
    private int alO;
    private d alP;
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

    public MutiImgMoreLayout(Context context) {
        this(context, null);
    }

    public MutiImgMoreLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alo = true;
        this.agJ = null;
        this.alD = false;
        this.alE = false;
        this.alO = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ahp = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.alB = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.alB.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMoreLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMoreLayout.this.agJ);
                }
            }
        });
        this.alI = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        com.baidu.tbadk.a.b.a.d(this.alI, R.dimen.tbds26, R.dimen.tbds14);
        this.alJ = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.alK = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.alL = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.alP = new d() { // from class: com.baidu.card.view.MutiImgMoreLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMoreLayout.this.agJ.objType = 2;
                    subClickListener.a(view, MutiImgMoreLayout.this.agJ);
                    MutiImgMoreLayout.this.agJ.objType = 1;
                }
                az.a(view, MutiImgMoreLayout.this.alo, MutiImgMoreLayout.this.alF, i, MutiImgMoreLayout.this.agJ.bmn(), MutiImgMoreLayout.this.mFrom);
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
            boolean z = linkedList.size() > 3;
            this.alI.setVisibility(8);
            if (y.getCount(linkedList) >= 3) {
                this.alI.setVisibility(0);
                this.alJ.setConrers(15);
                a((MediaData) y.getItem(boY, 0), this.alJ, R.string.J_X12, false, false, 0);
                this.alK.setConrers(15);
                a((MediaData) y.getItem(boY, 1), this.alK, R.string.J_X02, false, false, 1);
                this.alL.setConrers(15);
                a((MediaData) y.getItem(boY, 2), this.alL, R.string.J_X11, z, true, 2);
                return;
            }
            this.alI.setVisibility(8);
            this.alD = false;
            return;
        }
        this.alI.setVisibility(8);
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
        boolean z = true;
        this.agJ = aVar;
        by bmn = aVar.bmn();
        az.a(this.mTitle, bmn);
        az.a(this.ahp, this.mTitle, bmn, ahn);
        boolean z2 = this.mTitle == null || this.mTitle.getVisibility() != 0;
        boolean z3 = this.ahp == null || this.ahp.getVisibility() != 0;
        RelativeLayout relativeLayout = this.alI;
        if (!z2 || !z3) {
            z = false;
        }
        az.a(relativeLayout, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.alJ.getLayoutParams();
        layoutParams.width = bG;
        layoutParams.height = bG;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.alK.getLayoutParams();
        layoutParams2.width = bG;
        layoutParams2.height = bG;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.alL.getLayoutParams();
        layoutParams3.width = bG;
        layoutParams3.height = bG;
        if (this.alI.getVisibility() != 8) {
            this.alJ.setLayoutParams(layoutParams);
            this.alK.setLayoutParams(layoutParams2);
            this.alL.setLayoutParams(layoutParams3);
        }
    }

    private int bG(int i) {
        if (this.alO > 0) {
            return this.alO;
        }
        this.alO = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.alO;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, int i, boolean z, boolean z2, int i2) {
        String a2 = a(mediaData);
        int i3 = this.alo ? 13 : 14;
        if (!au.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        tbImageView.setRadiusById(i);
        tbImageView.setDrawBorder(true);
        tbImageView.setForegroundColor(0);
        tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        tbImageView.setBorderColor(ap.getColor(R.color.CAM_X0401));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.startLoad(a2, i3, false);
        a(tbImageView, i2, z, z2);
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
            if (MutiImgMoreLayout.this.alP != null) {
                MutiImgMoreLayout.this.alP.b(view, this.currentIndex, this.hasMore && this.alS);
            }
        }
    }
}

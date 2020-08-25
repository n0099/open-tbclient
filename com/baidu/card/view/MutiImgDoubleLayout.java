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
import com.baidu.card.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes15.dex */
public class MutiImgDoubleLayout extends LinearLayout implements o<AbsThreadDataSupport> {
    private AbsThreadDataSupport aeW;
    public TextView afz;
    private aa<AbsThreadDataSupport> agI;
    public PlayVoiceBntNew ajD;
    private boolean ajF;
    private boolean ajG;
    private LinkedList<MediaData> ajH;
    public RelativeLayout ajK;
    public TbImageView ajL;
    public TbImageView ajM;
    private int ajN;
    private d ajO;
    private boolean ajr;
    private String mFrom;
    public TextView mTitle;
    private static final int ajB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int afE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int ajC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int afx = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgDoubleLayout(Context context) {
        this(context, null);
    }

    public MutiImgDoubleLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajr = true;
        this.aeW = null;
        this.ajF = false;
        this.ajG = false;
        this.ajN = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_double_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.afz = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.ajD = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.ajD.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgDoubleLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgDoubleLayout.this.aeW);
                }
            }
        });
        com.baidu.tbadk.a.b.a.d(this.ajD, R.dimen.tbds28, R.dimen.tbds14);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.afz, R.dimen.tbds7, R.dimen.tbds10);
        this.ajK = (RelativeLayout) findViewById(R.id.thread_card_img_double_container);
        com.baidu.tbadk.a.b.a.d(this.ajK, R.dimen.tbds20, R.dimen.tbds14);
        this.ajL = (TbImageView) findViewById(R.id.thread_card_img_double_one);
        this.ajM = (TbImageView) findViewById(R.id.thread_card_img_double_two);
        this.ajO = new d() { // from class: com.baidu.card.view.MutiImgDoubleLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgDoubleLayout.this.aeW.objType = 2;
                    subClickListener.a(view, MutiImgDoubleLayout.this.aeW);
                    MutiImgDoubleLayout.this.aeW.objType = 1;
                }
                ay.a(view, MutiImgDoubleLayout.this.ajr, MutiImgDoubleLayout.this.ajH, i, MutiImgDoubleLayout.this.aeW.bce(), MutiImgDoubleLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bw bwVar) {
        ArrayList<VoiceData.VoiceModel> beR = bwVar.beR();
        if (y.isEmpty(beR)) {
            this.ajD.setVisibility(8);
            this.ajG = false;
            return;
        }
        this.ajD.setVisibility(0);
        VoiceData.VoiceModel voiceModel = beR.get(0);
        this.ajD.setVoiceModel(voiceModel);
        this.ajD.setTag(voiceModel);
        this.ajD.changeSkin();
        if (voiceModel != null) {
            this.ajD.BM(voiceModel.voice_status.intValue());
        }
        this.ajD.bPe();
        this.ajG = true;
    }

    private void setImageData(bw bwVar) {
        ArrayList<MediaData> beN = bwVar.beN();
        if (k.bbM().isShowImages() && y.getCount(beN) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < beN.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(beN, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.ajH = linkedList;
            this.ajF = true;
            this.ajK.setVisibility(8);
            if (y.getCount(linkedList) == 2) {
                this.ajK.setVisibility(0);
                this.ajL.setConrers(15);
                a((MediaData) y.getItem(beN, 0), this.ajL, true, false, false, 0);
                this.ajM.setConrers(15);
                a((MediaData) y.getItem(beN, 1), this.ajM, true, false, true, 1);
                return;
            }
            this.ajK.setVisibility(8);
            this.ajF = false;
            return;
        }
        this.ajK.setVisibility(8);
        this.ajF = false;
    }

    public void setFromCDN(boolean z) {
        this.ajr = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(AbsThreadDataSupport absThreadDataSupport) {
        this.aeW = absThreadDataSupport;
        bw bce = absThreadDataSupport.bce();
        ay.a(this.mTitle, bce);
        ay.a(this.afz, this.mTitle, bce, afx);
        setImageData(bce);
        setVoiceData(bce);
        tU();
    }

    private void tU() {
        if (this.afz.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.ajF) {
                setMarginsTop(this.ajD, ajB);
            } else if (this.ajG) {
                setMarginsTop(this.ajD, ajC);
            }
        } else if (this.ajD != null && this.ajD.getLayoutParams() != null) {
            if (this.ajF) {
                setMarginsTop(this.ajD, ajB);
            } else if (this.ajG) {
                setMarginsTop(this.ajD, afE);
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
        return this.agI;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.agI = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bA = bA(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ajL.getLayoutParams();
        layoutParams.width = bA;
        layoutParams.height = bA;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ajM.getLayoutParams();
        layoutParams2.width = bA;
        layoutParams2.height = bA;
        if (this.ajK.getVisibility() != 8) {
            this.ajL.setLayoutParams(layoutParams);
            this.ajM.setLayoutParams(layoutParams2);
        }
    }

    private int bA(int i) {
        if (this.ajN > 0) {
            return this.ajN;
        }
        this.ajN = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.ajN;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.ajr ? 13 : 14;
        if (!at.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ap.getColor(R.color.cp_border_a));
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
        if (this.ajO != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.ajO == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        private boolean ajQ;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.ajQ = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgDoubleLayout.this.ajO != null) {
                MutiImgDoubleLayout.this.ajO.b(view, this.currentIndex, this.hasMore && this.ajQ);
            }
        }
    }
}

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
    private com.baidu.tbadk.core.data.a agr;
    public TextView ahj;
    private aa<com.baidu.tbadk.core.data.a> ais;
    private boolean akY;
    private d alA;
    public RelativeLayout alE;
    public TbImageView alF;
    public TbImageView alG;
    public PlayVoiceBntNew alm;
    private boolean alo;
    private boolean alp;
    private LinkedList<MediaData> alq;
    private int alz;
    private String mFrom;
    public TextView mTitle;
    private static final int ali = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int alj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int alk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int ahh = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgDoubleLayout(Context context) {
        this(context, null);
    }

    public MutiImgDoubleLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akY = true;
        this.agr = null;
        this.alo = false;
        this.alp = false;
        this.alz = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_double_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ahj = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.alm = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.alm.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgDoubleLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgDoubleLayout.this.agr);
                }
            }
        });
        b.j(this.alm, R.dimen.tbds28, R.dimen.tbds14);
        b.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        b.a(this.ahj, R.dimen.tbds7, R.dimen.tbds10);
        this.alE = (RelativeLayout) findViewById(R.id.thread_card_img_double_container);
        b.j(this.alE, R.dimen.tbds20, R.dimen.tbds14);
        this.alF = (TbImageView) findViewById(R.id.thread_card_img_double_one);
        this.alG = (TbImageView) findViewById(R.id.thread_card_img_double_two);
        this.alA = new d() { // from class: com.baidu.card.view.MutiImgDoubleLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void c(View view, int i, boolean z) {
                aa<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgDoubleLayout.this.agr.objType = 2;
                    subClickListener.a(view, MutiImgDoubleLayout.this.agr);
                    MutiImgDoubleLayout.this.agr.objType = 1;
                }
                ay.a(view, MutiImgDoubleLayout.this.akY, MutiImgDoubleLayout.this.alq, i, MutiImgDoubleLayout.this.agr.bkV(), MutiImgDoubleLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bz bzVar) {
        ArrayList<VoiceData.VoiceModel> bnK = bzVar.bnK();
        if (x.isEmpty(bnK)) {
            this.alm.setVisibility(8);
            this.alp = false;
            return;
        }
        this.alm.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bnK.get(0);
        this.alm.setVoiceModel(voiceModel);
        this.alm.setTag(voiceModel);
        this.alm.btU();
        if (voiceModel != null) {
            this.alm.CX(voiceModel.voice_status.intValue());
        }
        this.alm.cbz();
        this.alp = true;
    }

    private void setImageData(bz bzVar) {
        ArrayList<MediaData> bnG = bzVar.bnG();
        if (k.bkB().isShowImages() && x.getCount(bnG) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < bnG.size(); i++) {
                MediaData mediaData = (MediaData) x.getItem(bnG, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.alq = linkedList;
            this.alo = true;
            this.alE.setVisibility(8);
            if (x.getCount(linkedList) == 2) {
                this.alE.setVisibility(0);
                this.alF.setConrers(15);
                a((MediaData) x.getItem(bnG, 0), this.alF, true, false, false, 0);
                this.alG.setConrers(15);
                a((MediaData) x.getItem(bnG, 1), this.alG, true, false, true, 1);
                return;
            }
            this.alE.setVisibility(8);
            this.alo = false;
            return;
        }
        this.alE.setVisibility(8);
        this.alo = false;
    }

    public void setFromCDN(boolean z) {
        this.akY = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agr = aVar;
        bz bkV = aVar.bkV();
        ay.a(this.mTitle, bkV);
        ay.a(this.ahj, this.mTitle, bkV, ahh);
        setImageData(bkV);
        setVoiceData(bkV);
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
        return this.ais;
    }

    public void setSubClickListener(aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.ais = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bE = bE(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.alF.getLayoutParams();
        layoutParams.width = bE;
        layoutParams.height = bE;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.alG.getLayoutParams();
        layoutParams2.width = bE;
        layoutParams2.height = bE;
        if (this.alE.getVisibility() != 8) {
            this.alF.setLayoutParams(layoutParams);
            this.alG.setLayoutParams(layoutParams2);
        }
    }

    private int bE(int i) {
        if (this.alz > 0) {
            return this.alz;
        }
        this.alz = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.alz;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.akY ? 13 : 14;
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
        if (this.alA != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.alA == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private boolean alD;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.alD = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgDoubleLayout.this.alA != null) {
                MutiImgDoubleLayout.this.alA.c(view, this.currentIndex, this.hasMore && this.alD);
            }
        }
    }
}

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
import com.baidu.tbadk.core.util.UtilHelper;
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
public class MutiImgMoreLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a agr;
    public TextView ahj;
    private aa<com.baidu.tbadk.core.data.a> ais;
    private boolean akY;
    private d alA;
    public PlayVoiceBntNew alm;
    private boolean alo;
    private boolean alp;
    private LinkedList<MediaData> alq;
    public RelativeLayout alt;
    public TbImageView alu;
    public TbImageView alv;
    public TbImageView alw;
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

    public MutiImgMoreLayout(Context context) {
        this(context, null);
    }

    public MutiImgMoreLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akY = true;
        this.agr = null;
        this.alo = false;
        this.alp = false;
        this.alz = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ahj = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.alm = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.alm.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMoreLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMoreLayout.this.agr);
                }
            }
        });
        this.alt = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        b.j(this.alt, R.dimen.tbds26, R.dimen.tbds14);
        this.alu = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.alv = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.alw = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.alA = new d() { // from class: com.baidu.card.view.MutiImgMoreLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void c(View view, int i, boolean z) {
                aa<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMoreLayout.this.agr.objType = 2;
                    subClickListener.a(view, MutiImgMoreLayout.this.agr);
                    MutiImgMoreLayout.this.agr.objType = 1;
                }
                ay.a(view, MutiImgMoreLayout.this.akY, MutiImgMoreLayout.this.alq, i, MutiImgMoreLayout.this.agr.bkV(), MutiImgMoreLayout.this.mFrom);
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
            boolean z = linkedList.size() > 3;
            this.alt.setVisibility(8);
            if (x.getCount(linkedList) >= 3) {
                this.alt.setVisibility(0);
                this.alu.setConrers(15);
                a((MediaData) x.getItem(bnG, 0), this.alu, R.string.J_X12, false, false, 0);
                this.alv.setConrers(15);
                a((MediaData) x.getItem(bnG, 1), this.alv, R.string.J_X02, false, false, 1);
                this.alw.setConrers(15);
                a((MediaData) x.getItem(bnG, 2), this.alw, R.string.J_X11, z, true, 2);
                return;
            }
            this.alt.setVisibility(8);
            this.alo = false;
            return;
        }
        this.alt.setVisibility(8);
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
        boolean z = true;
        this.agr = aVar;
        bz bkV = aVar.bkV();
        ay.a(this.mTitle, bkV);
        ay.a(this.ahj, this.mTitle, bkV, ahh);
        boolean z2 = this.mTitle == null || this.mTitle.getVisibility() != 0;
        boolean z3 = this.ahj == null || this.ahj.getVisibility() != 0;
        RelativeLayout relativeLayout = this.alt;
        if (!z2 || !z3) {
            z = false;
        }
        ay.a(relativeLayout, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.alu.getLayoutParams();
        layoutParams.width = bE;
        layoutParams.height = bE;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.alv.getLayoutParams();
        layoutParams2.width = bE;
        layoutParams2.height = bE;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.alw.getLayoutParams();
        layoutParams3.width = bE;
        layoutParams3.height = bE;
        if (this.alt.getVisibility() != 8) {
            this.alu.setLayoutParams(layoutParams);
            this.alv.setLayoutParams(layoutParams2);
            this.alw.setLayoutParams(layoutParams3);
        }
    }

    private int bE(int i) {
        if (this.alz > 0) {
            return this.alz;
        }
        this.alz = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.alz;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, int i, boolean z, boolean z2, int i2) {
        String a2 = a(mediaData);
        int i3 = this.akY ? 13 : 14;
        if (!at.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        tbImageView.setRadiusById(i);
        tbImageView.setDrawBorder(true);
        tbImageView.setForegroundColor(0);
        tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        tbImageView.setBorderColor(ao.getColor(R.color.CAM_X0401));
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
            if (MutiImgMoreLayout.this.alA != null) {
                MutiImgMoreLayout.this.alA.c(view, this.currentIndex, this.hasMore && this.alD);
            }
        }
    }
}

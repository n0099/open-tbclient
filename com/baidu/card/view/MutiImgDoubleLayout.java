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
import com.baidu.card.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MutiImgDoubleLayout extends LinearLayout implements i<com.baidu.tbadk.core.data.a> {
    public TextView VC;
    private com.baidu.tbadk.core.data.a Vq;
    private ab<com.baidu.tbadk.core.data.a> Wu;
    private boolean XJ;
    public PlayVoiceBntNew XS;
    private boolean XU;
    private boolean XV;
    private LinkedList<MediaData> XW;
    public RelativeLayout XZ;
    public TbImageView Ya;
    public TbImageView Yb;
    private int Yc;
    private d Yd;
    private String mFrom;
    public TextView mTitle;
    private static final int XP = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int XQ = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int XR = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int VA = l.af(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgDoubleLayout(Context context) {
        this(context, null);
    }

    public MutiImgDoubleLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.XJ = true;
        this.Vq = null;
        this.XU = false;
        this.XV = false;
        this.Yc = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_double_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.VC = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.XS = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.XS.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgDoubleLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgDoubleLayout.this.Vq);
                }
            }
        });
        this.XZ = (RelativeLayout) findViewById(R.id.thread_card_img_double_container);
        this.Ya = (TbImageView) findViewById(R.id.thread_card_img_double_one);
        this.Yb = (TbImageView) findViewById(R.id.thread_card_img_double_two);
        this.Yd = new d() { // from class: com.baidu.card.view.MutiImgDoubleLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgDoubleLayout.this.Vq.objType = 2;
                    subClickListener.a(view, MutiImgDoubleLayout.this.Vq);
                    MutiImgDoubleLayout.this.Vq.objType = 1;
                }
                au.a(view, MutiImgDoubleLayout.this.XJ, MutiImgDoubleLayout.this.XW, i, MutiImgDoubleLayout.this.Vq.abv(), MutiImgDoubleLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bg bgVar) {
        ArrayList<VoiceData.VoiceModel> adJ = bgVar.adJ();
        if (v.aa(adJ)) {
            this.XS.setVisibility(8);
            this.XV = false;
            return;
        }
        this.XS.setVisibility(0);
        VoiceData.VoiceModel voiceModel = adJ.get(0);
        this.XS.setVoiceModel(voiceModel);
        this.XS.setTag(voiceModel);
        this.XS.bFA();
        if (voiceModel != null) {
            this.XS.vx(voiceModel.voice_status.intValue());
        }
        this.XS.cnD();
        this.XV = true;
    }

    private void setImageData(bg bgVar) {
        ArrayList<MediaData> adF = bgVar.adF();
        if (com.baidu.tbadk.core.i.abb().abf() && v.Z(adF) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < adF.size(); i++) {
                MediaData mediaData = (MediaData) v.c(adF, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.XW = linkedList;
            this.XU = true;
            this.XZ.setVisibility(8);
            if (v.Z(linkedList) == 2) {
                this.XZ.setVisibility(0);
                this.Ya.setConrers(5);
                a((MediaData) v.c(adF, 0), this.Ya, true, false, false, 0);
                this.Yb.setConrers(10);
                a((MediaData) v.c(adF, 1), this.Yb, true, false, true, 1);
                return;
            }
            this.XZ.setVisibility(8);
            this.XU = false;
            return;
        }
        this.XZ.setVisibility(8);
        this.XU = false;
    }

    public void setFromCDN(boolean z) {
        this.XJ = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Vq = aVar;
        bg abv = aVar.abv();
        au.a(this.mTitle, abv);
        au.a(this.VC, this.mTitle, abv, VA);
        setImageData(abv);
        setVoiceData(abv);
        qw();
    }

    private void qw() {
        if (this.VC.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.XU) {
                setMarginsTop(this.XS, XP);
            } else if (this.XV) {
                setMarginsTop(this.XS, XR);
            }
        } else if (this.XS != null && this.XS.getLayoutParams() != null) {
            if (this.XU) {
                setMarginsTop(this.XS, XP);
            } else if (this.XV) {
                setMarginsTop(this.XS, XQ);
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

    public ab<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.Wu;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.Wu = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bz = bz(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Ya.getLayoutParams();
        layoutParams.width = bz;
        layoutParams.height = bz;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.Yb.getLayoutParams();
        layoutParams2.width = bz;
        layoutParams2.height = bz;
        if (this.XZ.getVisibility() != 8) {
            this.Ya.setLayoutParams(layoutParams);
            this.Yb.setLayoutParams(layoutParams2);
        }
    }

    private int bz(int i) {
        if (this.Yc > 0) {
            return this.Yc;
        }
        this.Yc = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.Yc;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.XJ ? 13 : 14;
        if (!ap.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.g(getContext(), R.dimen.tbds20));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(al.getColor(R.color.black_alpha8));
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
        if (this.Yd != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.Yd == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private boolean Yf;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.Yf = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgDoubleLayout.this.Yd != null) {
                MutiImgDoubleLayout.this.Yd.a(view, this.currentIndex, this.hasMore && this.Yf);
            }
        }
    }
}

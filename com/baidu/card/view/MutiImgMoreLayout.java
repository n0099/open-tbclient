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
public class MutiImgMoreLayout extends LinearLayout implements i<com.baidu.tbadk.core.data.a> {
    public TextView VB;
    private com.baidu.tbadk.core.data.a Vp;
    private ab<com.baidu.tbadk.core.data.a> Wt;
    private boolean XI;
    public PlayVoiceBntNew XR;
    private boolean XT;
    private boolean XU;
    private LinkedList<MediaData> XV;
    private int Yb;
    private d Yc;
    public RelativeLayout Yf;
    public TbImageView Yg;
    public TbImageView Yh;
    public TbImageView Yi;
    private String mFrom;
    public TextView mTitle;
    private static final int XO = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int XP = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int XQ = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int Vz = l.af(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMoreLayout(Context context) {
        this(context, null);
    }

    public MutiImgMoreLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.XI = true;
        this.Vp = null;
        this.XT = false;
        this.XU = false;
        this.Yb = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.VB = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.XR = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.XR.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMoreLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMoreLayout.this.Vp);
                }
            }
        });
        this.Yf = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        this.Yg = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.Yh = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.Yi = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.Yc = new d() { // from class: com.baidu.card.view.MutiImgMoreLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMoreLayout.this.Vp.objType = 2;
                    subClickListener.a(view, MutiImgMoreLayout.this.Vp);
                    MutiImgMoreLayout.this.Vp.objType = 1;
                }
                au.a(view, MutiImgMoreLayout.this.XI, MutiImgMoreLayout.this.XV, i, MutiImgMoreLayout.this.Vp.abv(), MutiImgMoreLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bg bgVar) {
        ArrayList<VoiceData.VoiceModel> adJ = bgVar.adJ();
        if (v.aa(adJ)) {
            this.XR.setVisibility(8);
            this.XU = false;
            return;
        }
        this.XR.setVisibility(0);
        VoiceData.VoiceModel voiceModel = adJ.get(0);
        this.XR.setVoiceModel(voiceModel);
        this.XR.setTag(voiceModel);
        this.XR.bFE();
        if (voiceModel != null) {
            this.XR.vx(voiceModel.voice_status.intValue());
        }
        this.XR.cnG();
        this.XU = true;
    }

    private void setImageData(bg bgVar) {
        boolean z;
        ArrayList<MediaData> adF = bgVar.adF();
        if (com.baidu.tbadk.core.i.abb().abf() && v.Z(adF) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= adF.size()) {
                    break;
                }
                MediaData mediaData = (MediaData) v.c(adF, i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            }
            this.XV = linkedList;
            this.XT = true;
            if (linkedList.size() <= 3) {
                z = false;
            } else {
                z = true;
            }
            this.Yf.setVisibility(8);
            if (v.Z(linkedList) >= 3) {
                this.Yf.setVisibility(0);
                this.Yg.setConrers(5);
                a((MediaData) v.c(adF, 0), this.Yg, true, false, false, 0);
                a((MediaData) v.c(adF, 1), this.Yh, false, false, false, 1);
                this.Yi.setConrers(10);
                a((MediaData) v.c(adF, 2), this.Yi, true, z, true, 2);
                return;
            }
            this.Yf.setVisibility(8);
            this.XT = false;
            return;
        }
        this.Yf.setVisibility(8);
        this.XT = false;
    }

    public void setFromCDN(boolean z) {
        this.XI = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Vp = aVar;
        bg abv = aVar.abv();
        au.a(this.mTitle, abv);
        au.a(this.VB, this.mTitle, abv, Vz);
        setImageData(abv);
        setVoiceData(abv);
        qw();
    }

    private void qw() {
        if (this.VB.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.XT) {
                setMarginsTop(this.XR, XO);
            } else if (this.XU) {
                setMarginsTop(this.XR, XQ);
            }
        } else if (this.XR != null && this.XR.getLayoutParams() != null) {
            if (this.XT) {
                setMarginsTop(this.XR, XO);
            } else if (this.XU) {
                setMarginsTop(this.XR, XP);
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
        return this.Wt;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.Wt = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bz = bz(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Yg.getLayoutParams();
        layoutParams.width = bz;
        layoutParams.height = bz;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.Yh.getLayoutParams();
        layoutParams2.width = bz;
        layoutParams2.height = bz;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.Yi.getLayoutParams();
        layoutParams3.width = bz;
        layoutParams3.height = bz;
        if (this.Yf.getVisibility() != 8) {
            this.Yg.setLayoutParams(layoutParams);
            this.Yh.setLayoutParams(layoutParams2);
            this.Yi.setLayoutParams(layoutParams3);
        }
    }

    private int bz(int i) {
        if (this.Yb > 0) {
            return this.Yb;
        }
        this.Yb = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.Yb;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.XI ? 13 : 14;
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
        if (this.Yc != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.Yc == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private boolean Ye;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.Ye = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMoreLayout.this.Yc != null) {
                MutiImgMoreLayout.this.Yc.a(view, this.currentIndex, this.hasMore && this.Ye);
            }
        }
    }
}

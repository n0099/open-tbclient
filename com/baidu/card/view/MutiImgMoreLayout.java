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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
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
    private com.baidu.tbadk.core.data.a VI;
    public TextView VV;
    private ab<com.baidu.tbadk.core.data.a> WN;
    public RelativeLayout YA;
    public TbImageView YB;
    public TbImageView YC;
    public TbImageView YD;
    private boolean Yd;
    public PlayVoiceBntNew Ym;
    private boolean Yo;
    private boolean Yp;
    private LinkedList<MediaData> Yq;
    private int Yw;
    private d Yx;
    private String mFrom;
    public TextView mTitle;
    private static final int Yj = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int Yk = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int Yl = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int VT = l.af(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMoreLayout(Context context) {
        this(context, null);
    }

    public MutiImgMoreLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Yd = true;
        this.VI = null;
        this.Yo = false;
        this.Yp = false;
        this.Yw = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.VV = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.Ym = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.Ym.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMoreLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMoreLayout.this.VI);
                }
            }
        });
        this.YA = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        this.YB = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.YC = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.YD = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.Yx = new d() { // from class: com.baidu.card.view.MutiImgMoreLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMoreLayout.this.VI.objType = 2;
                    subClickListener.a(view, MutiImgMoreLayout.this.VI);
                    MutiImgMoreLayout.this.VI.objType = 1;
                }
                au.a(view, MutiImgMoreLayout.this.Yd, MutiImgMoreLayout.this.Yq, i, MutiImgMoreLayout.this.VI.acC(), MutiImgMoreLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bh bhVar) {
        ArrayList<VoiceData.VoiceModel> aeQ = bhVar.aeQ();
        if (v.aa(aeQ)) {
            this.Ym.setVisibility(8);
            this.Yp = false;
            return;
        }
        this.Ym.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aeQ.get(0);
        this.Ym.setVoiceModel(voiceModel);
        this.Ym.setTag(voiceModel);
        this.Ym.bql();
        if (voiceModel != null) {
            this.Ym.we(voiceModel.voice_status.intValue());
        }
        this.Ym.crJ();
        this.Yp = true;
    }

    private void setImageData(bh bhVar) {
        boolean z;
        ArrayList<MediaData> aeM = bhVar.aeM();
        if (com.baidu.tbadk.core.i.ace().aci() && v.Z(aeM) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aeM.size()) {
                    break;
                }
                MediaData mediaData = (MediaData) v.c(aeM, i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            }
            this.Yq = linkedList;
            this.Yo = true;
            if (linkedList.size() <= 3) {
                z = false;
            } else {
                z = true;
            }
            this.YA.setVisibility(8);
            if (v.Z(linkedList) >= 3) {
                this.YA.setVisibility(0);
                this.YB.setConrers(5);
                a((MediaData) v.c(aeM, 0), this.YB, true, false, false, 0);
                a((MediaData) v.c(aeM, 1), this.YC, false, false, false, 1);
                this.YD.setConrers(10);
                a((MediaData) v.c(aeM, 2), this.YD, true, z, true, 2);
                return;
            }
            this.YA.setVisibility(8);
            this.Yo = false;
            return;
        }
        this.YA.setVisibility(8);
        this.Yo = false;
    }

    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.VI = aVar;
        bh acC = aVar.acC();
        au.a(this.mTitle, acC);
        au.a(this.VV, this.mTitle, acC, VT);
        setImageData(acC);
        setVoiceData(acC);
        qU();
    }

    private void qU() {
        if (this.VV.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Yo) {
                setMarginsTop(this.Ym, Yj);
            } else if (this.Yp) {
                setMarginsTop(this.Ym, Yl);
            }
        } else if (this.Ym != null && this.Ym.getLayoutParams() != null) {
            if (this.Yo) {
                setMarginsTop(this.Ym, Yj);
            } else if (this.Yp) {
                setMarginsTop(this.Ym, Yk);
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
        return this.WN;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.WN = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bz = bz(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.YB.getLayoutParams();
        layoutParams.width = bz;
        layoutParams.height = bz;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.YC.getLayoutParams();
        layoutParams2.width = bz;
        layoutParams2.height = bz;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.YD.getLayoutParams();
        layoutParams3.width = bz;
        layoutParams3.height = bz;
        if (this.YA.getVisibility() != 8) {
            this.YB.setLayoutParams(layoutParams);
            this.YC.setLayoutParams(layoutParams2);
            this.YD.setLayoutParams(layoutParams3);
        }
    }

    private int bz(int i) {
        if (this.Yw > 0) {
            return this.Yw;
        }
        this.Yw = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.Yw;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.Yd ? 13 : 14;
        if (!aq.bV(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.g(getContext(), R.dimen.tbds20));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(am.getColor(R.color.black_alpha8));
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
        if (this.Yx != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.Yx == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private boolean Yz;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.Yz = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMoreLayout.this.Yx != null) {
                MutiImgMoreLayout.this.Yx.a(view, this.currentIndex, this.hasMore && this.Yz);
            }
        }
    }
}

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
import com.baidu.card.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class MutiImgDoubleLayout extends LinearLayout implements m<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a JH;
    public TextView Kf;
    private z<com.baidu.tbadk.core.data.a> Lh;
    private LinkedList<MediaData> NB;
    public RelativeLayout NE;
    public TbImageView NF;
    public TbImageView NG;
    private int NH;
    private d NI;
    private boolean Nj;
    public PlayVoiceBntNew Nw;
    private boolean Ny;
    private boolean Nz;
    private String mFrom;
    public TextView mTitle;
    private static final int Nt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int Nu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int Nv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int Kc = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgDoubleLayout(Context context) {
        this(context, null);
    }

    public MutiImgDoubleLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nj = true;
        this.JH = null;
        this.Ny = false;
        this.Nz = false;
        this.NH = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_double_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Kf = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.Nw = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.Nw.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgDoubleLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgDoubleLayout.this.JH);
                }
            }
        });
        this.NE = (RelativeLayout) findViewById(R.id.thread_card_img_double_container);
        this.NF = (TbImageView) findViewById(R.id.thread_card_img_double_one);
        this.NG = (TbImageView) findViewById(R.id.thread_card_img_double_two);
        this.NI = new d() { // from class: com.baidu.card.view.MutiImgDoubleLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgDoubleLayout.this.JH.objType = 2;
                    subClickListener.a(view, MutiImgDoubleLayout.this.JH);
                    MutiImgDoubleLayout.this.JH.objType = 1;
                }
                au.a(view, MutiImgDoubleLayout.this.Nj, MutiImgDoubleLayout.this.NB, i, MutiImgDoubleLayout.this.JH.axQ(), MutiImgDoubleLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bj bjVar) {
        ArrayList<VoiceData.VoiceModel> aAl = bjVar.aAl();
        if (v.isEmpty(aAl)) {
            this.Nw.setVisibility(8);
            this.Nz = false;
            return;
        }
        this.Nw.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aAl.get(0);
        this.Nw.setVoiceModel(voiceModel);
        this.Nw.setTag(voiceModel);
        this.Nw.bFO();
        if (voiceModel != null) {
            this.Nw.wQ(voiceModel.voice_status.intValue());
        }
        this.Nw.cKK();
        this.Nz = true;
    }

    private void setImageData(bj bjVar) {
        ArrayList<MediaData> aAh = bjVar.aAh();
        if (i.axy().isShowImages() && v.getCount(aAh) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aAh.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aAh, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.NB = linkedList;
            this.Ny = true;
            this.NE.setVisibility(8);
            if (v.getCount(linkedList) == 2) {
                this.NE.setVisibility(0);
                this.NF.setConrers(15);
                a((MediaData) v.getItem(aAh, 0), this.NF, true, false, false, 0);
                this.NG.setConrers(15);
                a((MediaData) v.getItem(aAh, 1), this.NG, true, false, true, 1);
                return;
            }
            this.NE.setVisibility(8);
            this.Ny = false;
            return;
        }
        this.NE.setVisibility(8);
        this.Ny = false;
    }

    public void setFromCDN(boolean z) {
        this.Nj = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.JH = aVar;
        bj axQ = aVar.axQ();
        au.a(this.mTitle, axQ);
        au.a(this.Kf, this.mTitle, axQ, Kc);
        setImageData(axQ);
        setVoiceData(axQ);
        mX();
    }

    private void mX() {
        if (this.Kf.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Ny) {
                setMarginsTop(this.Nw, Nt);
            } else if (this.Nz) {
                setMarginsTop(this.Nw, Nv);
            }
        } else if (this.Nw != null && this.Nw.getLayoutParams() != null) {
            if (this.Ny) {
                setMarginsTop(this.Nw, Nt);
            } else if (this.Nz) {
                setMarginsTop(this.Nw, Nu);
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

    public z<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.Lh;
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.Lh = zVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int aX = aX(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.NF.getLayoutParams();
        layoutParams.width = aX;
        layoutParams.height = aX;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.NG.getLayoutParams();
        layoutParams2.width = aX;
        layoutParams2.height = aX;
        if (this.NE.getVisibility() != 8) {
            this.NF.setLayoutParams(layoutParams);
            this.NG.setLayoutParams(layoutParams2);
        }
    }

    private int aX(int i) {
        if (this.NH > 0) {
            return this.NH;
        }
        this.NH = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.NH;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.Nj ? 13 : 14;
        if (!aq.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(am.getColor(R.color.cp_border_a));
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
        if (this.NI != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.NI == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        private boolean NK;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.NK = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgDoubleLayout.this.NI != null) {
                MutiImgDoubleLayout.this.NI.b(view, this.currentIndex, this.hasMore && this.NK);
            }
        }
    }
}

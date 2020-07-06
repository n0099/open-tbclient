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
import com.baidu.card.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class MutiImgDoubleLayout extends LinearLayout implements n<AbsThreadDataSupport> {
    public TextView aeA;
    private AbsThreadDataSupport aea;
    private aa<AbsThreadDataSupport> afH;
    private LinkedList<MediaData> aiA;
    public RelativeLayout aiD;
    public TbImageView aiE;
    public TbImageView aiF;
    private int aiG;
    private d aiH;
    private boolean aik;
    public PlayVoiceBntNew aiw;
    private boolean aiy;
    private boolean aiz;
    private String mFrom;
    public TextView mTitle;
    private static final int aiu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int aeF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int aiv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int aey = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgDoubleLayout(Context context) {
        this(context, null);
    }

    public MutiImgDoubleLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aik = true;
        this.aea = null;
        this.aiy = false;
        this.aiz = false;
        this.aiG = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_double_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aeA = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.aiw = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.aiw.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgDoubleLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgDoubleLayout.this.aea);
                }
            }
        });
        this.aiD = (RelativeLayout) findViewById(R.id.thread_card_img_double_container);
        this.aiE = (TbImageView) findViewById(R.id.thread_card_img_double_one);
        this.aiF = (TbImageView) findViewById(R.id.thread_card_img_double_two);
        this.aiH = new d() { // from class: com.baidu.card.view.MutiImgDoubleLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgDoubleLayout.this.aea.objType = 2;
                    subClickListener.a(view, MutiImgDoubleLayout.this.aea);
                    MutiImgDoubleLayout.this.aea.objType = 1;
                }
                aw.a(view, MutiImgDoubleLayout.this.aik, MutiImgDoubleLayout.this.aiA, i, MutiImgDoubleLayout.this.aea.aPS(), MutiImgDoubleLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bu buVar) {
        ArrayList<VoiceData.VoiceModel> aSC = buVar.aSC();
        if (w.isEmpty(aSC)) {
            this.aiw.setVisibility(8);
            this.aiz = false;
            return;
        }
        this.aiw.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aSC.get(0);
        this.aiw.setVoiceModel(voiceModel);
        this.aiw.setTag(voiceModel);
        this.aiw.aYi();
        if (voiceModel != null) {
            this.aiw.yU(voiceModel.voice_status.intValue());
        }
        this.aiw.bCo();
        this.aiz = true;
    }

    private void setImageData(bu buVar) {
        ArrayList<MediaData> aSy = buVar.aSy();
        if (k.aPA().isShowImages() && w.getCount(aSy) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aSy.size(); i++) {
                MediaData mediaData = (MediaData) w.getItem(aSy, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.aiA = linkedList;
            this.aiy = true;
            this.aiD.setVisibility(8);
            if (w.getCount(linkedList) == 2) {
                this.aiD.setVisibility(0);
                this.aiE.setConrers(15);
                a((MediaData) w.getItem(aSy, 0), this.aiE, true, false, false, 0);
                this.aiF.setConrers(15);
                a((MediaData) w.getItem(aSy, 1), this.aiF, true, false, true, 1);
                return;
            }
            this.aiD.setVisibility(8);
            this.aiy = false;
            return;
        }
        this.aiD.setVisibility(8);
        this.aiy = false;
    }

    public void setFromCDN(boolean z) {
        this.aik = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.aea = absThreadDataSupport;
        bu aPS = absThreadDataSupport.aPS();
        aw.a(this.mTitle, aPS);
        aw.a(this.aeA, this.mTitle, aPS, aey);
        setImageData(aPS);
        setVoiceData(aPS);
        sh();
    }

    private void sh() {
        if (this.aeA.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.aiy) {
                setMarginsTop(this.aiw, aiu);
            } else if (this.aiz) {
                setMarginsTop(this.aiw, aiv);
            }
        } else if (this.aiw != null && this.aiw.getLayoutParams() != null) {
            if (this.aiy) {
                setMarginsTop(this.aiw, aiu);
            } else if (this.aiz) {
                setMarginsTop(this.aiw, aeF);
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
        return this.afH;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.afH = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bt = bt(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aiE.getLayoutParams();
        layoutParams.width = bt;
        layoutParams.height = bt;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aiF.getLayoutParams();
        layoutParams2.width = bt;
        layoutParams2.height = bt;
        if (this.aiD.getVisibility() != 8) {
            this.aiE.setLayoutParams(layoutParams);
            this.aiF.setLayoutParams(layoutParams2);
        }
    }

    private int bt(int i) {
        if (this.aiG > 0) {
            return this.aiG;
        }
        this.aiG = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.aiG;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.aik ? 13 : 14;
        if (!ar.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(an.getColor(R.color.cp_border_a));
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
        if (this.aiH != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.aiH == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private boolean aiJ;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.aiJ = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgDoubleLayout.this.aiH != null) {
                MutiImgDoubleLayout.this.aiH.b(view, this.currentIndex, this.hasMore && this.aiJ);
            }
        }
    }
}

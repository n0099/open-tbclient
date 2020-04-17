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
/* loaded from: classes8.dex */
public class MutiImgDoubleLayout extends LinearLayout implements m<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a ada;
    public TextView ady;
    private z<com.baidu.tbadk.core.data.a> aez;
    public PlayVoiceBntNew agG;
    private boolean agI;
    private boolean agJ;
    private LinkedList<MediaData> agK;
    public RelativeLayout agN;
    public TbImageView agO;
    public TbImageView agP;
    private int agQ;
    private d agR;
    private boolean agt;
    private String mFrom;
    public TextView mTitle;
    private static final int agD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int agE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int agF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int adw = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgDoubleLayout(Context context) {
        this(context, null);
    }

    public MutiImgDoubleLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agt = true;
        this.ada = null;
        this.agI = false;
        this.agJ = false;
        this.agQ = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_double_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ady = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.agG = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.agG.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgDoubleLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgDoubleLayout.this.ada);
                }
            }
        });
        this.agN = (RelativeLayout) findViewById(R.id.thread_card_img_double_container);
        this.agO = (TbImageView) findViewById(R.id.thread_card_img_double_one);
        this.agP = (TbImageView) findViewById(R.id.thread_card_img_double_two);
        this.agR = new d() { // from class: com.baidu.card.view.MutiImgDoubleLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgDoubleLayout.this.ada.objType = 2;
                    subClickListener.a(view, MutiImgDoubleLayout.this.ada);
                    MutiImgDoubleLayout.this.ada.objType = 1;
                }
                au.a(view, MutiImgDoubleLayout.this.agt, MutiImgDoubleLayout.this.agK, i, MutiImgDoubleLayout.this.ada.aIw(), MutiImgDoubleLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bj bjVar) {
        ArrayList<VoiceData.VoiceModel> aKS = bjVar.aKS();
        if (v.isEmpty(aKS)) {
            this.agG.setVisibility(8);
            this.agJ = false;
            return;
        }
        this.agG.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aKS.get(0);
        this.agG.setVoiceModel(voiceModel);
        this.agG.setTag(voiceModel);
        this.agG.ckO();
        if (voiceModel != null) {
            this.agG.xC(voiceModel.voice_status.intValue());
        }
        this.agG.cXz();
        this.agJ = true;
    }

    private void setImageData(bj bjVar) {
        ArrayList<MediaData> aKO = bjVar.aKO();
        if (i.aIe().isShowImages() && v.getCount(aKO) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aKO.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aKO, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.agK = linkedList;
            this.agI = true;
            this.agN.setVisibility(8);
            if (v.getCount(linkedList) == 2) {
                this.agN.setVisibility(0);
                this.agO.setConrers(15);
                a((MediaData) v.getItem(aKO, 0), this.agO, true, false, false, 0);
                this.agP.setConrers(15);
                a((MediaData) v.getItem(aKO, 1), this.agP, true, false, true, 1);
                return;
            }
            this.agN.setVisibility(8);
            this.agI = false;
            return;
        }
        this.agN.setVisibility(8);
        this.agI = false;
    }

    public void setFromCDN(boolean z) {
        this.agt = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.ada = aVar;
        bj aIw = aVar.aIw();
        au.a(this.mTitle, aIw);
        au.a(this.ady, this.mTitle, aIw, adw);
        setImageData(aIw);
        setVoiceData(aIw);
        rG();
    }

    private void rG() {
        if (this.ady.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.agI) {
                setMarginsTop(this.agG, agD);
            } else if (this.agJ) {
                setMarginsTop(this.agG, agF);
            }
        } else if (this.agG != null && this.agG.getLayoutParams() != null) {
            if (this.agI) {
                setMarginsTop(this.agG, agD);
            } else if (this.agJ) {
                setMarginsTop(this.agG, agE);
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
        return this.aez;
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.aez = zVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bn = bn(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.agO.getLayoutParams();
        layoutParams.width = bn;
        layoutParams.height = bn;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.agP.getLayoutParams();
        layoutParams2.width = bn;
        layoutParams2.height = bn;
        if (this.agN.getVisibility() != 8) {
            this.agO.setLayoutParams(layoutParams);
            this.agP.setLayoutParams(layoutParams2);
        }
    }

    private int bn(int i) {
        if (this.agQ > 0) {
            return this.agQ;
        }
        this.agQ = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.agQ;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.agt ? 13 : 14;
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
        if (this.agR != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.agR == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private boolean agT;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.agT = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgDoubleLayout.this.agR != null) {
                MutiImgDoubleLayout.this.agR.b(view, this.currentIndex, this.hasMore && this.agT);
            }
        }
    }
}

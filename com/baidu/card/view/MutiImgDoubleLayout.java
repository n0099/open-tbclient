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
    public TextView KA;
    private com.baidu.tbadk.core.data.a Kc;
    private z<com.baidu.tbadk.core.data.a> LD;
    private boolean NK;
    public PlayVoiceBntNew NZ;
    private boolean Ob;
    private boolean Oc;
    private LinkedList<MediaData> Oe;
    public RelativeLayout Oh;
    public TbImageView Oi;
    public TbImageView Oj;
    private int Ok;
    private d Ol;
    private String mFrom;
    public TextView mTitle;
    private static final int NW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int NX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int NY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int Ky = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgDoubleLayout(Context context) {
        this(context, null);
    }

    public MutiImgDoubleLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NK = true;
        this.Kc = null;
        this.Ob = false;
        this.Oc = false;
        this.Ok = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_double_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.KA = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.NZ = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.NZ.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgDoubleLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgDoubleLayout.this.Kc);
                }
            }
        });
        this.Oh = (RelativeLayout) findViewById(R.id.thread_card_img_double_container);
        this.Oi = (TbImageView) findViewById(R.id.thread_card_img_double_one);
        this.Oj = (TbImageView) findViewById(R.id.thread_card_img_double_two);
        this.Ol = new d() { // from class: com.baidu.card.view.MutiImgDoubleLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgDoubleLayout.this.Kc.objType = 2;
                    subClickListener.a(view, MutiImgDoubleLayout.this.Kc);
                    MutiImgDoubleLayout.this.Kc.objType = 1;
                }
                au.a(view, MutiImgDoubleLayout.this.NK, MutiImgDoubleLayout.this.Oe, i, MutiImgDoubleLayout.this.Kc.aAj(), MutiImgDoubleLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bj bjVar) {
        ArrayList<VoiceData.VoiceModel> aCF = bjVar.aCF();
        if (v.isEmpty(aCF)) {
            this.NZ.setVisibility(8);
            this.Oc = false;
            return;
        }
        this.NZ.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aCF.get(0);
        this.NZ.setVoiceModel(voiceModel);
        this.NZ.setTag(voiceModel);
        this.NZ.can();
        if (voiceModel != null) {
            this.NZ.xe(voiceModel.voice_status.intValue());
        }
        this.NZ.cMC();
        this.Oc = true;
    }

    private void setImageData(bj bjVar) {
        ArrayList<MediaData> aCB = bjVar.aCB();
        if (i.azR().isShowImages() && v.getCount(aCB) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aCB.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aCB, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.Oe = linkedList;
            this.Ob = true;
            this.Oh.setVisibility(8);
            if (v.getCount(linkedList) == 2) {
                this.Oh.setVisibility(0);
                this.Oi.setConrers(15);
                a((MediaData) v.getItem(aCB, 0), this.Oi, true, false, false, 0);
                this.Oj.setConrers(15);
                a((MediaData) v.getItem(aCB, 1), this.Oj, true, false, true, 1);
                return;
            }
            this.Oh.setVisibility(8);
            this.Ob = false;
            return;
        }
        this.Oh.setVisibility(8);
        this.Ob = false;
    }

    public void setFromCDN(boolean z) {
        this.NK = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.Kc = aVar;
        bj aAj = aVar.aAj();
        au.a(this.mTitle, aAj);
        au.a(this.KA, this.mTitle, aAj, Ky);
        setImageData(aAj);
        setVoiceData(aAj);
        nn();
    }

    private void nn() {
        if (this.KA.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Ob) {
                setMarginsTop(this.NZ, NW);
            } else if (this.Oc) {
                setMarginsTop(this.NZ, NY);
            }
        } else if (this.NZ != null && this.NZ.getLayoutParams() != null) {
            if (this.Ob) {
                setMarginsTop(this.NZ, NW);
            } else if (this.Oc) {
                setMarginsTop(this.NZ, NX);
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
        return this.LD;
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.LD = zVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bb = bb(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Oi.getLayoutParams();
        layoutParams.width = bb;
        layoutParams.height = bb;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.Oj.getLayoutParams();
        layoutParams2.width = bb;
        layoutParams2.height = bb;
        if (this.Oh.getVisibility() != 8) {
            this.Oi.setLayoutParams(layoutParams);
            this.Oj.setLayoutParams(layoutParams2);
        }
    }

    private int bb(int i) {
        if (this.Ok > 0) {
            return this.Ok;
        }
        this.Ok = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.Ok;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.NK ? 13 : 14;
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
        if (this.Ol != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.Ol == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private boolean Oo;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.Oo = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgDoubleLayout.this.Ol != null) {
                MutiImgDoubleLayout.this.Ol.b(view, this.currentIndex, this.hasMore && this.Oo);
            }
        }
    }
}

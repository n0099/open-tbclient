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
public class MutiImgDoubleLayout extends LinearLayout implements i<com.baidu.tbadk.core.data.a> {
    public TextView FK;
    private com.baidu.tbadk.core.data.a Fx;
    private ab<com.baidu.tbadk.core.data.a> GD;
    private boolean HY;
    public PlayVoiceBntNew Ii;
    private boolean Ik;
    private boolean Il;
    private LinkedList<MediaData> Im;
    public RelativeLayout Ip;
    public TbImageView Iq;
    public TbImageView Ir;
    private int Is;
    private d It;
    private String mFrom;
    public TextView mTitle;
    private static final int If = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int Ig = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int Ih = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int FI = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgDoubleLayout(Context context) {
        this(context, null);
    }

    public MutiImgDoubleLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HY = true;
        this.Fx = null;
        this.Ik = false;
        this.Il = false;
        this.Is = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_double_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.FK = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.Ii = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.Ii.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgDoubleLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgDoubleLayout.this.Fx);
                }
            }
        });
        this.Ip = (RelativeLayout) findViewById(R.id.thread_card_img_double_container);
        this.Iq = (TbImageView) findViewById(R.id.thread_card_img_double_one);
        this.Ir = (TbImageView) findViewById(R.id.thread_card_img_double_two);
        this.It = new d() { // from class: com.baidu.card.view.MutiImgDoubleLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgDoubleLayout.this.Fx.objType = 2;
                    subClickListener.a(view, MutiImgDoubleLayout.this.Fx);
                    MutiImgDoubleLayout.this.Fx.objType = 1;
                }
                au.a(view, MutiImgDoubleLayout.this.HY, MutiImgDoubleLayout.this.Im, i, MutiImgDoubleLayout.this.Fx.agI(), MutiImgDoubleLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bh bhVar) {
        ArrayList<VoiceData.VoiceModel> aiU = bhVar.aiU();
        if (v.isEmpty(aiU)) {
            this.Ii.setVisibility(8);
            this.Il = false;
            return;
        }
        this.Ii.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aiU.get(0);
        this.Ii.setVoiceModel(voiceModel);
        this.Ii.setTag(voiceModel);
        this.Ii.bnq();
        if (voiceModel != null) {
            this.Ii.uK(voiceModel.voice_status.intValue());
        }
        this.Ii.cpC();
        this.Il = true;
    }

    private void setImageData(bh bhVar) {
        ArrayList<MediaData> aiQ = bhVar.aiQ();
        if (com.baidu.tbadk.core.i.agq().isShowImages() && v.getCount(aiQ) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aiQ.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aiQ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.Im = linkedList;
            this.Ik = true;
            this.Ip.setVisibility(8);
            if (v.getCount(linkedList) == 2) {
                this.Ip.setVisibility(0);
                this.Iq.setConrers(5);
                a((MediaData) v.getItem(aiQ, 0), this.Iq, true, false, false, 0);
                this.Ir.setConrers(10);
                a((MediaData) v.getItem(aiQ, 1), this.Ir, true, false, true, 1);
                return;
            }
            this.Ip.setVisibility(8);
            this.Ik = false;
            return;
        }
        this.Ip.setVisibility(8);
        this.Ik = false;
    }

    public void setFromCDN(boolean z) {
        this.HY = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        this.Fx = aVar;
        bh agI = aVar.agI();
        au.a(this.mTitle, agI);
        au.a(this.FK, this.mTitle, agI, FI);
        setImageData(agI);
        setVoiceData(agI);
        lZ();
    }

    private void lZ() {
        if (this.FK.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Ik) {
                setMarginsTop(this.Ii, If);
            } else if (this.Il) {
                setMarginsTop(this.Ii, Ih);
            }
        } else if (this.Ii != null && this.Ii.getLayoutParams() != null) {
            if (this.Ik) {
                setMarginsTop(this.Ii, If);
            } else if (this.Il) {
                setMarginsTop(this.Ii, Ig);
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
        return this.GD;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.GD = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int aO = aO(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Iq.getLayoutParams();
        layoutParams.width = aO;
        layoutParams.height = aO;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.Ir.getLayoutParams();
        layoutParams2.width = aO;
        layoutParams2.height = aO;
        if (this.Ip.getVisibility() != 8) {
            this.Iq.setLayoutParams(layoutParams);
            this.Ir.setLayoutParams(layoutParams2);
        }
    }

    private int aO(int i) {
        if (this.Is > 0) {
            return this.Is;
        }
        this.Is = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.Is;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.HY ? 13 : 14;
        if (!aq.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.getDimens(getContext(), R.dimen.tbds20));
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
        if (this.It != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.It == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private boolean Iv;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.Iv = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgDoubleLayout.this.It != null) {
                MutiImgDoubleLayout.this.It.b(view, this.currentIndex, this.hasMore && this.Iv);
            }
        }
    }
}

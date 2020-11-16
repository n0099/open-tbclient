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
import com.baidu.card.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes20.dex */
public class MutiImgDoubleLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private static final int agp;
    private static final int akx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int aky = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int akz = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private com.baidu.tbadk.core.data.a afN;
    public TextView agr;
    private ab<com.baidu.tbadk.core.data.a> ahx;
    public PlayVoiceBntNew akA;
    private boolean akC;
    private boolean akD;
    private LinkedList<MediaData> akE;
    private int akN;
    private d akO;
    public RelativeLayout akS;
    public TbImageView akT;
    public TbImageView akU;
    private boolean akn;
    private String mFrom;
    public TextView mTitle;

    static {
        agp = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.tbadk.a.d.bhw() ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgDoubleLayout(Context context) {
        this(context, null);
    }

    public MutiImgDoubleLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akn = true;
        this.afN = null;
        this.akC = false;
        this.akD = false;
        this.akN = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_double_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.agr = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.akA = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.akA.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgDoubleLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgDoubleLayout.this.afN);
                }
            }
        });
        com.baidu.tbadk.a.b.a.d(this.akA, R.dimen.tbds28, R.dimen.tbds14);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.agr, R.dimen.tbds7, R.dimen.tbds10);
        this.akS = (RelativeLayout) findViewById(R.id.thread_card_img_double_container);
        com.baidu.tbadk.a.b.a.d(this.akS, R.dimen.tbds20, R.dimen.tbds14);
        this.akT = (TbImageView) findViewById(R.id.thread_card_img_double_one);
        this.akU = (TbImageView) findViewById(R.id.thread_card_img_double_two);
        this.akO = new d() { // from class: com.baidu.card.view.MutiImgDoubleLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgDoubleLayout.this.afN.objType = 2;
                    subClickListener.a(view, MutiImgDoubleLayout.this.afN);
                    MutiImgDoubleLayout.this.afN.objType = 1;
                }
                az.a(view, MutiImgDoubleLayout.this.akn, MutiImgDoubleLayout.this.akE, i, MutiImgDoubleLayout.this.afN.bjd(), MutiImgDoubleLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bx bxVar) {
        ArrayList<VoiceData.VoiceModel> blP = bxVar.blP();
        if (y.isEmpty(blP)) {
            this.akA.setVisibility(8);
            this.akD = false;
            return;
        }
        this.akA.setVisibility(0);
        VoiceData.VoiceModel voiceModel = blP.get(0);
        this.akA.setVoiceModel(voiceModel);
        this.akA.setTag(voiceModel);
        this.akA.changeSkin();
        if (voiceModel != null) {
            this.akA.DX(voiceModel.voice_status.intValue());
        }
        this.akA.bYE();
        this.akD = true;
    }

    private void setImageData(bx bxVar) {
        ArrayList<MediaData> blL = bxVar.blL();
        if (k.biL().isShowImages() && y.getCount(blL) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < blL.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(blL, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.akE = linkedList;
            this.akC = true;
            this.akS.setVisibility(8);
            if (y.getCount(linkedList) == 2) {
                this.akS.setVisibility(0);
                this.akT.setConrers(15);
                a((MediaData) y.getItem(blL, 0), this.akT, true, false, false, 0);
                this.akU.setConrers(15);
                a((MediaData) y.getItem(blL, 1), this.akU, true, false, true, 1);
                return;
            }
            this.akS.setVisibility(8);
            this.akC = false;
            return;
        }
        this.akS.setVisibility(8);
        this.akC = false;
    }

    public void setFromCDN(boolean z) {
        this.akn = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(com.baidu.tbadk.core.data.a aVar) {
        this.afN = aVar;
        bx bjd = aVar.bjd();
        az.a(this.mTitle, bjd);
        az.a(this.agr, this.mTitle, bjd, agp);
        setImageData(bjd);
        setVoiceData(bjd);
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
        return this.ahx;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.ahx = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bC = bC(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akT.getLayoutParams();
        layoutParams.width = bC;
        layoutParams.height = bC;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.akU.getLayoutParams();
        layoutParams2.width = bC;
        layoutParams2.height = bC;
        if (this.akS.getVisibility() != 8) {
            this.akT.setLayoutParams(layoutParams);
            this.akU.setLayoutParams(layoutParams2);
        }
    }

    private int bC(int i) {
        if (this.akN > 0) {
            return this.akN;
        }
        this.akN = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.akN;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.akn ? 13 : 14;
        if (!au.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ap.getColor(R.color.CAM_X0401));
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
        if (this.akO != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.akO == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        private boolean akR;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.akR = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgDoubleLayout.this.akO != null) {
                MutiImgDoubleLayout.this.akO.b(view, this.currentIndex, this.hasMore && this.akR);
            }
        }
    }
}

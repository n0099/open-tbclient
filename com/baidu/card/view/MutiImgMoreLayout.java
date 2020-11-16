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
import com.baidu.tbadk.core.util.UtilHelper;
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
public class MutiImgMoreLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
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
    public RelativeLayout akH;
    public TbImageView akI;
    public TbImageView akJ;
    public TbImageView akK;
    private int akN;
    private d akO;
    private boolean akn;
    private String mFrom;
    public TextView mTitle;

    static {
        agp = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (com.baidu.tbadk.a.d.bhw() ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMoreLayout(Context context) {
        this(context, null);
    }

    public MutiImgMoreLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akn = true;
        this.afN = null;
        this.akC = false;
        this.akD = false;
        this.akN = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.agr = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.akA = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.akA.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMoreLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMoreLayout.this.afN);
                }
            }
        });
        this.akH = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        com.baidu.tbadk.a.b.a.d(this.akH, R.dimen.tbds26, R.dimen.tbds14);
        this.akI = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.akJ = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.akK = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.akO = new d() { // from class: com.baidu.card.view.MutiImgMoreLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMoreLayout.this.afN.objType = 2;
                    subClickListener.a(view, MutiImgMoreLayout.this.afN);
                    MutiImgMoreLayout.this.afN.objType = 1;
                }
                az.a(view, MutiImgMoreLayout.this.akn, MutiImgMoreLayout.this.akE, i, MutiImgMoreLayout.this.afN.bjd(), MutiImgMoreLayout.this.mFrom);
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
            boolean z = linkedList.size() > 3;
            this.akH.setVisibility(8);
            if (y.getCount(linkedList) >= 3) {
                this.akH.setVisibility(0);
                this.akI.setConrers(15);
                a((MediaData) y.getItem(blL, 0), this.akI, R.string.J_X12, false, false, 0);
                this.akJ.setConrers(15);
                a((MediaData) y.getItem(blL, 1), this.akJ, R.string.J_X02, false, false, 1);
                this.akK.setConrers(15);
                a((MediaData) y.getItem(blL, 2), this.akK, R.string.J_X11, z, true, 2);
                return;
            }
            this.akH.setVisibility(8);
            this.akC = false;
            return;
        }
        this.akH.setVisibility(8);
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
        boolean z = true;
        this.afN = aVar;
        bx bjd = aVar.bjd();
        az.a(this.mTitle, bjd);
        az.a(this.agr, this.mTitle, bjd, agp);
        boolean z2 = this.mTitle == null || this.mTitle.getVisibility() != 0;
        boolean z3 = this.agr == null || this.agr.getVisibility() != 0;
        RelativeLayout relativeLayout = this.akH;
        if (!z2 || !z3) {
            z = false;
        }
        az.a(relativeLayout, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akI.getLayoutParams();
        layoutParams.width = bC;
        layoutParams.height = bC;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.akJ.getLayoutParams();
        layoutParams2.width = bC;
        layoutParams2.height = bC;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.akK.getLayoutParams();
        layoutParams3.width = bC;
        layoutParams3.height = bC;
        if (this.akH.getVisibility() != 8) {
            this.akI.setLayoutParams(layoutParams);
            this.akJ.setLayoutParams(layoutParams2);
            this.akK.setLayoutParams(layoutParams3);
        }
    }

    private int bC(int i) {
        if (this.akN > 0) {
            return this.akN;
        }
        this.akN = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.akN;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, int i, boolean z, boolean z2, int i2) {
        String a2 = a(mediaData);
        int i3 = this.akn ? 13 : 14;
        if (!au.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        tbImageView.setRadiusById(i);
        tbImageView.setDrawBorder(true);
        tbImageView.setForegroundColor(0);
        tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        tbImageView.setBorderColor(ap.getColor(R.color.CAM_X0401));
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
            if (MutiImgMoreLayout.this.akO != null) {
                MutiImgMoreLayout.this.akO.b(view, this.currentIndex, this.hasMore && this.akR);
            }
        }
    }
}

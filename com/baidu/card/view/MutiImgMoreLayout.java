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
    private com.baidu.tbadk.core.data.a EX;
    public TextView Fk;
    private ab<com.baidu.tbadk.core.data.a> Gd;
    public PlayVoiceBntNew HH;
    private boolean HJ;
    private boolean HK;
    private LinkedList<MediaData> HL;
    private int HR;
    private d HS;
    public RelativeLayout HW;
    public TbImageView HX;
    public TbImageView HY;
    public TbImageView HZ;
    private boolean Hx;
    private String mFrom;
    public TextView mTitle;
    private static final int HE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int HF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int HG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int Fi = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMoreLayout(Context context) {
        this(context, null);
    }

    public MutiImgMoreLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hx = true;
        this.EX = null;
        this.HJ = false;
        this.HK = false;
        this.HR = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Fk = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.HH = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.HH.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMoreLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMoreLayout.this.EX);
                }
            }
        });
        this.HW = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        this.HX = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.HY = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.HZ = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.HS = new d() { // from class: com.baidu.card.view.MutiImgMoreLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMoreLayout.this.EX.objType = 2;
                    subClickListener.a(view, MutiImgMoreLayout.this.EX);
                    MutiImgMoreLayout.this.EX.objType = 1;
                }
                au.a(view, MutiImgMoreLayout.this.Hx, MutiImgMoreLayout.this.HL, i, MutiImgMoreLayout.this.EX.agG(), MutiImgMoreLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bh bhVar) {
        ArrayList<VoiceData.VoiceModel> aiS = bhVar.aiS();
        if (v.isEmpty(aiS)) {
            this.HH.setVisibility(8);
            this.HK = false;
            return;
        }
        this.HH.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aiS.get(0);
        this.HH.setVoiceModel(voiceModel);
        this.HH.setTag(voiceModel);
        this.HH.bno();
        if (voiceModel != null) {
            this.HH.uJ(voiceModel.voice_status.intValue());
        }
        this.HH.cpA();
        this.HK = true;
    }

    private void setImageData(bh bhVar) {
        boolean z;
        ArrayList<MediaData> aiO = bhVar.aiO();
        if (com.baidu.tbadk.core.i.ago().isShowImages() && v.getCount(aiO) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aiO.size()) {
                    break;
                }
                MediaData mediaData = (MediaData) v.getItem(aiO, i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            }
            this.HL = linkedList;
            this.HJ = true;
            if (linkedList.size() <= 3) {
                z = false;
            } else {
                z = true;
            }
            this.HW.setVisibility(8);
            if (v.getCount(linkedList) >= 3) {
                this.HW.setVisibility(0);
                this.HX.setConrers(5);
                a((MediaData) v.getItem(aiO, 0), this.HX, true, false, false, 0);
                a((MediaData) v.getItem(aiO, 1), this.HY, false, false, false, 1);
                this.HZ.setConrers(10);
                a((MediaData) v.getItem(aiO, 2), this.HZ, true, z, true, 2);
                return;
            }
            this.HW.setVisibility(8);
            this.HJ = false;
            return;
        }
        this.HW.setVisibility(8);
        this.HJ = false;
    }

    public void setFromCDN(boolean z) {
        this.Hx = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(com.baidu.tbadk.core.data.a aVar) {
        this.EX = aVar;
        bh agG = aVar.agG();
        au.a(this.mTitle, agG);
        au.a(this.Fk, this.mTitle, agG, Fi);
        setImageData(agG);
        setVoiceData(agG);
        lZ();
    }

    private void lZ() {
        if (this.Fk.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.HJ) {
                setMarginsTop(this.HH, HE);
            } else if (this.HK) {
                setMarginsTop(this.HH, HG);
            }
        } else if (this.HH != null && this.HH.getLayoutParams() != null) {
            if (this.HJ) {
                setMarginsTop(this.HH, HE);
            } else if (this.HK) {
                setMarginsTop(this.HH, HF);
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
        return this.Gd;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.Gd = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int aO = aO(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.HX.getLayoutParams();
        layoutParams.width = aO;
        layoutParams.height = aO;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.HY.getLayoutParams();
        layoutParams2.width = aO;
        layoutParams2.height = aO;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.HZ.getLayoutParams();
        layoutParams3.width = aO;
        layoutParams3.height = aO;
        if (this.HW.getVisibility() != 8) {
            this.HX.setLayoutParams(layoutParams);
            this.HY.setLayoutParams(layoutParams2);
            this.HZ.setLayoutParams(layoutParams3);
        }
    }

    private int aO(int i) {
        if (this.HR > 0) {
            return this.HR;
        }
        this.HR = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.HR;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.Hx ? 13 : 14;
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
        if (this.HS != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.HS == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private boolean HV;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.HV = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMoreLayout.this.HS != null) {
                MutiImgMoreLayout.this.HS.b(view, this.currentIndex, this.hasMore && this.HV);
            }
        }
    }
}

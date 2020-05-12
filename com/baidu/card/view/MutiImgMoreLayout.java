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
public class MutiImgMoreLayout extends LinearLayout implements m<com.baidu.tbadk.core.data.a> {
    public TextView adB;
    private com.baidu.tbadk.core.data.a ade;
    private z<com.baidu.tbadk.core.data.a> aeC;
    public PlayVoiceBntNew agJ;
    private boolean agL;
    private boolean agM;
    private LinkedList<MediaData> agN;
    private int agT;
    private d agU;
    public RelativeLayout agX;
    public TbImageView agY;
    public TbImageView agZ;
    private boolean agw;
    public TbImageView aha;
    private String mFrom;
    public TextView mTitle;
    private static final int agG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int agH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int agI = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int adz = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMoreLayout(Context context) {
        this(context, null);
    }

    public MutiImgMoreLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.agw = true;
        this.ade = null;
        this.agL = false;
        this.agM = false;
        this.agT = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.adB = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.agJ = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.agJ.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMoreLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMoreLayout.this.ade);
                }
            }
        });
        this.agX = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        this.agY = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.agZ = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.aha = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.agU = new d() { // from class: com.baidu.card.view.MutiImgMoreLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMoreLayout.this.ade.objType = 2;
                    subClickListener.a(view, MutiImgMoreLayout.this.ade);
                    MutiImgMoreLayout.this.ade.objType = 1;
                }
                au.a(view, MutiImgMoreLayout.this.agw, MutiImgMoreLayout.this.agN, i, MutiImgMoreLayout.this.ade.aIu(), MutiImgMoreLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bj bjVar) {
        ArrayList<VoiceData.VoiceModel> aKQ = bjVar.aKQ();
        if (v.isEmpty(aKQ)) {
            this.agJ.setVisibility(8);
            this.agM = false;
            return;
        }
        this.agJ.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aKQ.get(0);
        this.agJ.setVoiceModel(voiceModel);
        this.agJ.setTag(voiceModel);
        this.agJ.ckN();
        if (voiceModel != null) {
            this.agJ.xC(voiceModel.voice_status.intValue());
        }
        this.agJ.cXx();
        this.agM = true;
    }

    private void setImageData(bj bjVar) {
        boolean z;
        ArrayList<MediaData> aKM = bjVar.aKM();
        if (i.aIc().isShowImages() && v.getCount(aKM) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aKM.size()) {
                    break;
                }
                MediaData mediaData = (MediaData) v.getItem(aKM, i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            }
            this.agN = linkedList;
            this.agL = true;
            if (linkedList.size() <= 3) {
                z = false;
            } else {
                z = true;
            }
            this.agX.setVisibility(8);
            if (v.getCount(linkedList) >= 3) {
                this.agX.setVisibility(0);
                this.agY.setConrers(15);
                a((MediaData) v.getItem(aKM, 0), this.agY, true, false, false, 0);
                this.agZ.setConrers(15);
                a((MediaData) v.getItem(aKM, 1), this.agZ, false, false, false, 1);
                this.aha.setConrers(15);
                a((MediaData) v.getItem(aKM, 2), this.aha, true, z, true, 2);
                return;
            }
            this.agX.setVisibility(8);
            this.agL = false;
            return;
        }
        this.agX.setVisibility(8);
        this.agL = false;
    }

    public void setFromCDN(boolean z) {
        this.agw = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        this.ade = aVar;
        bj aIu = aVar.aIu();
        au.a(this.mTitle, aIu);
        au.a(this.adB, this.mTitle, aIu, adz);
        setImageData(aIu);
        setVoiceData(aIu);
        rG();
    }

    private void rG() {
        if (this.adB.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.agL) {
                setMarginsTop(this.agJ, agG);
            } else if (this.agM) {
                setMarginsTop(this.agJ, agI);
            }
        } else if (this.agJ != null && this.agJ.getLayoutParams() != null) {
            if (this.agL) {
                setMarginsTop(this.agJ, agG);
            } else if (this.agM) {
                setMarginsTop(this.agJ, agH);
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
        return this.aeC;
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.aeC = zVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bn = bn(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.agY.getLayoutParams();
        layoutParams.width = bn;
        layoutParams.height = bn;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.agZ.getLayoutParams();
        layoutParams2.width = bn;
        layoutParams2.height = bn;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.aha.getLayoutParams();
        layoutParams3.width = bn;
        layoutParams3.height = bn;
        if (this.agX.getVisibility() != 8) {
            this.agY.setLayoutParams(layoutParams);
            this.agZ.setLayoutParams(layoutParams2);
            this.aha.setLayoutParams(layoutParams3);
        }
    }

    private int bn(int i) {
        if (this.agT > 0) {
            return this.agT;
        }
        this.agT = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.agT;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.agw ? 13 : 14;
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
        if (this.agU != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.agU == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private boolean agW;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.agW = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMoreLayout.this.agU != null) {
                MutiImgMoreLayout.this.agU.b(view, this.currentIndex, this.hasMore && this.agW);
            }
        }
    }
}

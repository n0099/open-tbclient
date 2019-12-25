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
/* loaded from: classes5.dex */
public class MutiImgMoreLayout extends LinearLayout implements m<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a JB;
    public TextView JZ;
    private z<com.baidu.tbadk.core.data.a> Lb;
    private int ND;
    private d NE;
    public RelativeLayout NH;
    public TbImageView NI;
    public TbImageView NJ;
    public TbImageView NK;
    private boolean Nf;
    public PlayVoiceBntNew Ns;
    private boolean Nu;
    private boolean Nv;
    private LinkedList<MediaData> Nw;
    private String mFrom;
    public TextView mTitle;
    private static final int Np = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int Nq = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int Nr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int JX = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMoreLayout(Context context) {
        this(context, null);
    }

    public MutiImgMoreLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nf = true;
        this.JB = null;
        this.Nu = false;
        this.Nv = false;
        this.ND = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.JZ = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.Ns = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.Ns.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMoreLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMoreLayout.this.JB);
                }
            }
        });
        this.NH = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        this.NI = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.NJ = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.NK = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.NE = new d() { // from class: com.baidu.card.view.MutiImgMoreLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMoreLayout.this.JB.objType = 2;
                    subClickListener.a(view, MutiImgMoreLayout.this.JB);
                    MutiImgMoreLayout.this.JB.objType = 1;
                }
                au.a(view, MutiImgMoreLayout.this.Nf, MutiImgMoreLayout.this.Nw, i, MutiImgMoreLayout.this.JB.axx(), MutiImgMoreLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bj bjVar) {
        ArrayList<VoiceData.VoiceModel> azS = bjVar.azS();
        if (v.isEmpty(azS)) {
            this.Ns.setVisibility(8);
            this.Nv = false;
            return;
        }
        this.Ns.setVisibility(0);
        VoiceData.VoiceModel voiceModel = azS.get(0);
        this.Ns.setVoiceModel(voiceModel);
        this.Ns.setTag(voiceModel);
        this.Ns.bEM();
        if (voiceModel != null) {
            this.Ns.wL(voiceModel.voice_status.intValue());
        }
        this.Ns.cJE();
        this.Nv = true;
    }

    private void setImageData(bj bjVar) {
        boolean z;
        ArrayList<MediaData> azO = bjVar.azO();
        if (i.axf().isShowImages() && v.getCount(azO) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= azO.size()) {
                    break;
                }
                MediaData mediaData = (MediaData) v.getItem(azO, i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            }
            this.Nw = linkedList;
            this.Nu = true;
            if (linkedList.size() <= 3) {
                z = false;
            } else {
                z = true;
            }
            this.NH.setVisibility(8);
            if (v.getCount(linkedList) >= 3) {
                this.NH.setVisibility(0);
                this.NI.setConrers(15);
                a((MediaData) v.getItem(azO, 0), this.NI, true, false, false, 0);
                this.NJ.setConrers(15);
                a((MediaData) v.getItem(azO, 1), this.NJ, false, false, false, 1);
                this.NK.setConrers(15);
                a((MediaData) v.getItem(azO, 2), this.NK, true, z, true, 2);
                return;
            }
            this.NH.setVisibility(8);
            this.Nu = false;
            return;
        }
        this.NH.setVisibility(8);
        this.Nu = false;
    }

    public void setFromCDN(boolean z) {
        this.Nf = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.JB = aVar;
        bj axx = aVar.axx();
        au.a(this.mTitle, axx);
        au.a(this.JZ, this.mTitle, axx, JX);
        setImageData(axx);
        setVoiceData(axx);
        mW();
    }

    private void mW() {
        if (this.JZ.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Nu) {
                setMarginsTop(this.Ns, Np);
            } else if (this.Nv) {
                setMarginsTop(this.Ns, Nr);
            }
        } else if (this.Ns != null && this.Ns.getLayoutParams() != null) {
            if (this.Nu) {
                setMarginsTop(this.Ns, Np);
            } else if (this.Nv) {
                setMarginsTop(this.Ns, Nq);
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
        return this.Lb;
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.Lb = zVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int aX = aX(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.NI.getLayoutParams();
        layoutParams.width = aX;
        layoutParams.height = aX;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.NJ.getLayoutParams();
        layoutParams2.width = aX;
        layoutParams2.height = aX;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.NK.getLayoutParams();
        layoutParams3.width = aX;
        layoutParams3.height = aX;
        if (this.NH.getVisibility() != 8) {
            this.NI.setLayoutParams(layoutParams);
            this.NJ.setLayoutParams(layoutParams2);
            this.NK.setLayoutParams(layoutParams3);
        }
    }

    private int aX(int i) {
        if (this.ND > 0) {
            return this.ND;
        }
        this.ND = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.ND;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.Nf ? 13 : 14;
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
        if (this.NE != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.NE == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        private boolean NG;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.NG = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMoreLayout.this.NE != null) {
                MutiImgMoreLayout.this.NE.b(view, this.currentIndex, this.hasMore && this.NG);
            }
        }
    }
}

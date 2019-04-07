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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MutiImgMoreLayout extends LinearLayout implements i<com.baidu.tbadk.core.data.a> {
    public TextView XK;
    private com.baidu.tbadk.core.data.a Xy;
    private ab<com.baidu.tbadk.core.data.a> YB;
    private boolean ZQ;
    public PlayVoiceBntNew ZZ;
    private boolean aab;
    private boolean aac;
    private d aae;
    private LinkedList<MediaData> aaf;
    private int aal;
    public RelativeLayout aao;
    public TbImageView aap;
    public TbImageView aaq;
    public TbImageView aar;
    private String mFrom;
    public TextView mTitle;
    private static final int ZW = l.h(TbadkCoreApplication.getInst(), d.e.tbds26);
    private static final int ZX = l.h(TbadkCoreApplication.getInst(), d.e.tbds20);
    private static final int ZY = l.h(TbadkCoreApplication.getInst(), d.e.tbds7);
    private static final int XI = l.aO(TbadkCoreApplication.getInst()) - (l.h(TbadkCoreApplication.getInst(), d.e.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMoreLayout(Context context) {
        this(context, null);
    }

    public MutiImgMoreLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZQ = true;
        this.Xy = null;
        this.aab = false;
        this.aac = false;
        this.aal = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.XK = (TextView) findViewById(d.g.thread_card_abstract);
        this.mTitle = (TextView) findViewById(d.g.thread_card_title);
        this.ZZ = (PlayVoiceBntNew) findViewById(d.g.thread_card_voice);
        this.ZZ.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMoreLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMoreLayout.this.Xy);
                }
            }
        });
        this.aao = (RelativeLayout) findViewById(d.g.thread_card_img_more_container);
        this.aap = (TbImageView) findViewById(d.g.thread_card_img_more_one);
        this.aaq = (TbImageView) findViewById(d.g.thread_card_img_more_two);
        this.aar = (TbImageView) findViewById(d.g.thread_card_img_more_three);
        this.aae = new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.card.view.MutiImgMoreLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMoreLayout.this.Xy.objType = 2;
                    subClickListener.a(view, MutiImgMoreLayout.this.Xy);
                    MutiImgMoreLayout.this.Xy.objType = 1;
                }
                au.a(view, MutiImgMoreLayout.this.ZQ, MutiImgMoreLayout.this.aaf, i, MutiImgMoreLayout.this.Xy.WO(), MutiImgMoreLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bg bgVar) {
        ArrayList<VoiceData.VoiceModel> Zc = bgVar.Zc();
        if (v.T(Zc)) {
            this.ZZ.setVisibility(8);
            this.aac = false;
            return;
        }
        this.ZZ.setVisibility(0);
        VoiceData.VoiceModel voiceModel = Zc.get(0);
        this.ZZ.setVoiceModel(voiceModel);
        this.ZZ.setTag(voiceModel);
        this.ZZ.bxS();
        if (voiceModel != null) {
            this.ZZ.uq(voiceModel.voice_status.intValue());
        }
        this.ZZ.cfz();
        this.aac = true;
    }

    private void setImageData(bg bgVar) {
        boolean z;
        ArrayList<MediaData> YY = bgVar.YY();
        if (com.baidu.tbadk.core.i.Wv().Wz() && v.S(YY) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= YY.size()) {
                    break;
                }
                MediaData mediaData = (MediaData) v.c(YY, i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            }
            this.aaf = linkedList;
            this.aab = true;
            if (linkedList.size() <= 3) {
                z = false;
            } else {
                z = true;
            }
            this.aao.setVisibility(8);
            if (v.S(linkedList) >= 3) {
                this.aao.setVisibility(0);
                this.aap.setConrers(5);
                a((MediaData) v.c(YY, 0), this.aap, true, false, false, 0);
                a((MediaData) v.c(YY, 1), this.aaq, false, false, false, 1);
                this.aar.setConrers(10);
                a((MediaData) v.c(YY, 2), this.aar, true, z, true, 2);
                return;
            }
            this.aao.setVisibility(8);
            this.aab = false;
            return;
        }
        this.aao.setVisibility(8);
        this.aab = false;
    }

    public void setFromCDN(boolean z) {
        this.ZQ = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Xy = aVar;
        bg WO = aVar.WO();
        au.a(this.mTitle, WO);
        au.a(this.XK, this.mTitle, WO, XI);
        setImageData(WO);
        setVoiceData(WO);
        rB();
    }

    private void rB() {
        if (this.XK.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.aab) {
                setMarginsTop(this.ZZ, ZW);
            } else if (this.aac) {
                setMarginsTop(this.ZZ, ZY);
            }
        } else if (this.ZZ != null && this.ZZ.getLayoutParams() != null) {
            if (this.aab) {
                setMarginsTop(this.ZZ, ZW);
            } else if (this.aac) {
                setMarginsTop(this.ZZ, ZX);
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
        return this.YB;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.YB = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bC = bC(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aap.getLayoutParams();
        layoutParams.width = bC;
        layoutParams.height = bC;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aaq.getLayoutParams();
        layoutParams2.width = bC;
        layoutParams2.height = bC;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.aar.getLayoutParams();
        layoutParams3.width = bC;
        layoutParams3.height = bC;
        if (this.aao.getVisibility() != 8) {
            this.aap.setLayoutParams(layoutParams);
            this.aaq.setLayoutParams(layoutParams2);
            this.aar.setLayoutParams(layoutParams3);
        }
    }

    private int bC(int i) {
        if (this.aal > 0) {
            return this.aal;
        }
        this.aal = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds10) * 2)) / 3;
        return this.aal;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.ZQ ? 13 : 14;
        if (!ap.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.h(getContext(), d.e.tbds20));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
            tbImageView.setBorderColor(al.getColor(d.C0277d.black_alpha8));
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
        if (this.aae != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.aae == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private boolean aan;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.aan = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMoreLayout.this.aae != null) {
                MutiImgMoreLayout.this.aae.a(view, this.currentIndex, this.hasMore && this.aan);
            }
        }
    }
}

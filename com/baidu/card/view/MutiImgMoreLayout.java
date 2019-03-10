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
    public TextView XJ;
    private com.baidu.tbadk.core.data.a Xx;
    private ab<com.baidu.tbadk.core.data.a> YA;
    private boolean ZO;
    public PlayVoiceBntNew ZX;
    private boolean ZZ;
    private boolean aaa;
    private d aac;
    private LinkedList<MediaData> aad;
    private int aaj;
    public RelativeLayout aam;
    public TbImageView aan;
    public TbImageView aao;
    public TbImageView aap;
    private String mFrom;
    public TextView mTitle;
    private static final int ZU = l.h(TbadkCoreApplication.getInst(), d.e.tbds26);
    private static final int ZV = l.h(TbadkCoreApplication.getInst(), d.e.tbds20);
    private static final int ZW = l.h(TbadkCoreApplication.getInst(), d.e.tbds7);
    private static final int XH = l.aO(TbadkCoreApplication.getInst()) - (l.h(TbadkCoreApplication.getInst(), d.e.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMoreLayout(Context context) {
        this(context, null);
    }

    public MutiImgMoreLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZO = true;
        this.Xx = null;
        this.ZZ = false;
        this.aaa = false;
        this.aaj = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(d.h.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.XJ = (TextView) findViewById(d.g.thread_card_abstract);
        this.mTitle = (TextView) findViewById(d.g.thread_card_title);
        this.ZX = (PlayVoiceBntNew) findViewById(d.g.thread_card_voice);
        this.ZX.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMoreLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMoreLayout.this.Xx);
                }
            }
        });
        this.aam = (RelativeLayout) findViewById(d.g.thread_card_img_more_container);
        this.aan = (TbImageView) findViewById(d.g.thread_card_img_more_one);
        this.aao = (TbImageView) findViewById(d.g.thread_card_img_more_two);
        this.aap = (TbImageView) findViewById(d.g.thread_card_img_more_three);
        this.aac = new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.card.view.MutiImgMoreLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMoreLayout.this.Xx.objType = 2;
                    subClickListener.a(view, MutiImgMoreLayout.this.Xx);
                    MutiImgMoreLayout.this.Xx.objType = 1;
                }
                au.a(view, MutiImgMoreLayout.this.ZO, MutiImgMoreLayout.this.aad, i, MutiImgMoreLayout.this.Xx.WR(), MutiImgMoreLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bg bgVar) {
        ArrayList<VoiceData.VoiceModel> Zf = bgVar.Zf();
        if (v.T(Zf)) {
            this.ZX.setVisibility(8);
            this.aaa = false;
            return;
        }
        this.ZX.setVisibility(0);
        VoiceData.VoiceModel voiceModel = Zf.get(0);
        this.ZX.setVoiceModel(voiceModel);
        this.ZX.setTag(voiceModel);
        this.ZX.bxW();
        if (voiceModel != null) {
            this.ZX.uu(voiceModel.voice_status.intValue());
        }
        this.ZX.cfB();
        this.aaa = true;
    }

    private void setImageData(bg bgVar) {
        boolean z;
        ArrayList<MediaData> Zb = bgVar.Zb();
        if (com.baidu.tbadk.core.i.Wy().WC() && v.S(Zb) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= Zb.size()) {
                    break;
                }
                MediaData mediaData = (MediaData) v.c(Zb, i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            }
            this.aad = linkedList;
            this.ZZ = true;
            if (linkedList.size() <= 3) {
                z = false;
            } else {
                z = true;
            }
            this.aam.setVisibility(8);
            if (v.S(linkedList) >= 3) {
                this.aam.setVisibility(0);
                this.aan.setConrers(5);
                a((MediaData) v.c(Zb, 0), this.aan, true, false, false, 0);
                a((MediaData) v.c(Zb, 1), this.aao, false, false, false, 1);
                this.aap.setConrers(10);
                a((MediaData) v.c(Zb, 2), this.aap, true, z, true, 2);
                return;
            }
            this.aam.setVisibility(8);
            this.ZZ = false;
            return;
        }
        this.aam.setVisibility(8);
        this.ZZ = false;
    }

    public void setFromCDN(boolean z) {
        this.ZO = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.Xx = aVar;
        bg WR = aVar.WR();
        au.a(this.mTitle, WR);
        au.a(this.XJ, this.mTitle, WR, XH);
        setImageData(WR);
        setVoiceData(WR);
        rB();
    }

    private void rB() {
        if (this.XJ.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.ZZ) {
                setMarginsTop(this.ZX, ZU);
            } else if (this.aaa) {
                setMarginsTop(this.ZX, ZW);
            }
        } else if (this.ZX != null && this.ZX.getLayoutParams() != null) {
            if (this.ZZ) {
                setMarginsTop(this.ZX, ZU);
            } else if (this.aaa) {
                setMarginsTop(this.ZX, ZV);
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
        return this.YA;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.YA = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bD = bD(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aan.getLayoutParams();
        layoutParams.width = bD;
        layoutParams.height = bD;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aao.getLayoutParams();
        layoutParams2.width = bD;
        layoutParams2.height = bD;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.aap.getLayoutParams();
        layoutParams3.width = bD;
        layoutParams3.height = bD;
        if (this.aam.getVisibility() != 8) {
            this.aan.setLayoutParams(layoutParams);
            this.aao.setLayoutParams(layoutParams2);
            this.aap.setLayoutParams(layoutParams3);
        }
    }

    private int bD(int i) {
        if (this.aaj > 0) {
            return this.aaj;
        }
        this.aaj = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds10) * 2)) / 3;
        return this.aaj;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.ZO ? 13 : 14;
        if (!ap.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.h(getContext(), d.e.tbds20));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
            tbImageView.setBorderColor(al.getColor(d.C0236d.black_alpha8));
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
        if (this.aac != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.aac == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private boolean aal;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.aal = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMoreLayout.this.aac != null) {
                MutiImgMoreLayout.this.aac.a(view, this.currentIndex, this.hasMore && this.aal);
            }
        }
    }
}

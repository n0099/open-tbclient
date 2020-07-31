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
import com.baidu.card.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes15.dex */
public class MutiImgDoubleLayout extends LinearLayout implements n<AbsThreadDataSupport> {
    private AbsThreadDataSupport adQ;
    public TextView aeq;
    private aa<AbsThreadDataSupport> afy;
    private boolean aib;
    public PlayVoiceBntNew aio;
    private boolean aiq;
    private boolean air;
    private LinkedList<MediaData> ais;
    public RelativeLayout aiv;
    public TbImageView aiw;
    public TbImageView aix;
    private int aiy;
    private d aiz;
    private String mFrom;
    public TextView mTitle;
    private static final int aim = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int aev = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int ain = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int aeo = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgDoubleLayout(Context context) {
        this(context, null);
    }

    public MutiImgDoubleLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aib = true;
        this.adQ = null;
        this.aiq = false;
        this.air = false;
        this.aiy = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_double_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aeq = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.aio = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.aio.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgDoubleLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgDoubleLayout.this.adQ);
                }
            }
        });
        com.baidu.tbadk.a.b.a.e(this.aio, R.dimen.tbds28, R.dimen.tbds14);
        com.baidu.tbadk.a.b.a.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        com.baidu.tbadk.a.b.a.a(this.aeq, R.dimen.tbds7, R.dimen.tbds10);
        this.aiv = (RelativeLayout) findViewById(R.id.thread_card_img_double_container);
        com.baidu.tbadk.a.b.a.e(this.aiv, R.dimen.tbds20, R.dimen.tbds14);
        this.aiw = (TbImageView) findViewById(R.id.thread_card_img_double_one);
        this.aix = (TbImageView) findViewById(R.id.thread_card_img_double_two);
        this.aiz = new d() { // from class: com.baidu.card.view.MutiImgDoubleLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgDoubleLayout.this.adQ.objType = 2;
                    subClickListener.a(view, MutiImgDoubleLayout.this.adQ);
                    MutiImgDoubleLayout.this.adQ.objType = 1;
                }
                ax.a(view, MutiImgDoubleLayout.this.aib, MutiImgDoubleLayout.this.ais, i, MutiImgDoubleLayout.this.adQ.aTN(), MutiImgDoubleLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bv bvVar) {
        ArrayList<VoiceData.VoiceModel> aWy = bvVar.aWy();
        if (x.isEmpty(aWy)) {
            this.aio.setVisibility(8);
            this.air = false;
            return;
        }
        this.aio.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aWy.get(0);
        this.aio.setVoiceModel(voiceModel);
        this.aio.setTag(voiceModel);
        this.aio.changeSkin();
        if (voiceModel != null) {
            this.aio.zt(voiceModel.voice_status.intValue());
        }
        this.aio.bFz();
        this.air = true;
    }

    private void setImageData(bv bvVar) {
        ArrayList<MediaData> aWu = bvVar.aWu();
        if (k.aTv().isShowImages() && x.getCount(aWu) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < aWu.size(); i++) {
                MediaData mediaData = (MediaData) x.getItem(aWu, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.ais = linkedList;
            this.aiq = true;
            this.aiv.setVisibility(8);
            if (x.getCount(linkedList) == 2) {
                this.aiv.setVisibility(0);
                this.aiw.setConrers(15);
                a((MediaData) x.getItem(aWu, 0), this.aiw, true, false, false, 0);
                this.aix.setConrers(15);
                a((MediaData) x.getItem(aWu, 1), this.aix, true, false, true, 1);
                return;
            }
            this.aiv.setVisibility(8);
            this.aiq = false;
            return;
        }
        this.aiv.setVisibility(8);
        this.aiq = false;
    }

    public void setFromCDN(boolean z) {
        this.aib = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        this.adQ = absThreadDataSupport;
        bv aTN = absThreadDataSupport.aTN();
        ax.a(this.mTitle, aTN);
        ax.a(this.aeq, this.mTitle, aTN, aeo);
        setImageData(aTN);
        setVoiceData(aTN);
        sj();
    }

    private void sj() {
        if (this.aeq.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.aiq) {
                setMarginsTop(this.aio, aim);
            } else if (this.air) {
                setMarginsTop(this.aio, ain);
            }
        } else if (this.aio != null && this.aio.getLayoutParams() != null) {
            if (this.aiq) {
                setMarginsTop(this.aio, aim);
            } else if (this.air) {
                setMarginsTop(this.aio, aev);
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

    public aa<AbsThreadDataSupport> getSubClickListener() {
        return this.afy;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.afy = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bv = bv(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aiw.getLayoutParams();
        layoutParams.width = bv;
        layoutParams.height = bv;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.aix.getLayoutParams();
        layoutParams2.width = bv;
        layoutParams2.height = bv;
        if (this.aiv.getVisibility() != 8) {
            this.aiw.setLayoutParams(layoutParams);
            this.aix.setLayoutParams(layoutParams2);
        }
    }

    private int bv(int i) {
        if (this.aiy > 0) {
            return this.aiy;
        }
        this.aiy = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.aiy;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.aib ? 13 : 14;
        if (!as.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ao.getColor(R.color.cp_border_a));
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
        if (this.aiz != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.aiz == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        private boolean aiB;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.aiB = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgDoubleLayout.this.aiz != null) {
                MutiImgDoubleLayout.this.aiz.b(view, this.currentIndex, this.hasMore && this.aiB);
            }
        }
    }
}

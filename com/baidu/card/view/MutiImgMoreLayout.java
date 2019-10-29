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
    public TextView FK;
    private com.baidu.tbadk.core.data.a Fx;
    private ab<com.baidu.tbadk.core.data.a> GD;
    private boolean HY;
    public PlayVoiceBntNew Ii;
    private boolean Ik;
    private boolean Il;
    private LinkedList<MediaData> Im;
    private int Is;
    private d It;
    public RelativeLayout Iw;
    public TbImageView Ix;
    public TbImageView Iy;
    public TbImageView Iz;
    private String mFrom;
    public TextView mTitle;
    private static final int If = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int Ig = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int Ih = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int FI = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMoreLayout(Context context) {
        this(context, null);
    }

    public MutiImgMoreLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HY = true;
        this.Fx = null;
        this.Ik = false;
        this.Il = false;
        this.Is = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.FK = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.Ii = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.Ii.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMoreLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMoreLayout.this.Fx);
                }
            }
        });
        this.Iw = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        this.Ix = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.Iy = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.Iz = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.It = new d() { // from class: com.baidu.card.view.MutiImgMoreLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMoreLayout.this.Fx.objType = 2;
                    subClickListener.a(view, MutiImgMoreLayout.this.Fx);
                    MutiImgMoreLayout.this.Fx.objType = 1;
                }
                au.a(view, MutiImgMoreLayout.this.HY, MutiImgMoreLayout.this.Im, i, MutiImgMoreLayout.this.Fx.agI(), MutiImgMoreLayout.this.mFrom);
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
        boolean z;
        ArrayList<MediaData> aiQ = bhVar.aiQ();
        if (com.baidu.tbadk.core.i.agq().isShowImages() && v.getCount(aiQ) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aiQ.size()) {
                    break;
                }
                MediaData mediaData = (MediaData) v.getItem(aiQ, i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            }
            this.Im = linkedList;
            this.Ik = true;
            if (linkedList.size() <= 3) {
                z = false;
            } else {
                z = true;
            }
            this.Iw.setVisibility(8);
            if (v.getCount(linkedList) >= 3) {
                this.Iw.setVisibility(0);
                this.Ix.setConrers(5);
                a((MediaData) v.getItem(aiQ, 0), this.Ix, true, false, false, 0);
                a((MediaData) v.getItem(aiQ, 1), this.Iy, false, false, false, 1);
                this.Iz.setConrers(10);
                a((MediaData) v.getItem(aiQ, 2), this.Iz, true, z, true, 2);
                return;
            }
            this.Iw.setVisibility(8);
            this.Ik = false;
            return;
        }
        this.Iw.setVisibility(8);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Ix.getLayoutParams();
        layoutParams.width = aO;
        layoutParams.height = aO;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.Iy.getLayoutParams();
        layoutParams2.width = aO;
        layoutParams2.height = aO;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.Iz.getLayoutParams();
        layoutParams3.width = aO;
        layoutParams3.height = aO;
        if (this.Iw.getVisibility() != 8) {
            this.Ix.setLayoutParams(layoutParams);
            this.Iy.setLayoutParams(layoutParams2);
            this.Iz.setLayoutParams(layoutParams3);
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
            if (MutiImgMoreLayout.this.It != null) {
                MutiImgMoreLayout.this.It.b(view, this.currentIndex, this.hasMore && this.Iv);
            }
        }
    }
}

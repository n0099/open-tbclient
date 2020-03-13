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
    public TextView KA;
    private com.baidu.tbadk.core.data.a Kc;
    private z<com.baidu.tbadk.core.data.a> LD;
    private boolean NJ;
    public PlayVoiceBntNew NY;
    private boolean Oa;
    private boolean Ob;
    private LinkedList<MediaData> Oc;
    private int Oj;
    private d Ok;
    public RelativeLayout Oo;
    public TbImageView Op;
    public TbImageView Oq;
    public TbImageView Or;
    private String mFrom;
    public TextView mTitle;
    private static final int NV = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int NW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int NX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int Ky = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMoreLayout(Context context) {
        this(context, null);
    }

    public MutiImgMoreLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NJ = true;
        this.Kc = null;
        this.Oa = false;
        this.Ob = false;
        this.Oj = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.KA = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.NY = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.NY.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMoreLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMoreLayout.this.Kc);
                }
            }
        });
        this.Oo = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        this.Op = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.Oq = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.Or = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.Ok = new d() { // from class: com.baidu.card.view.MutiImgMoreLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                z<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMoreLayout.this.Kc.objType = 2;
                    subClickListener.a(view, MutiImgMoreLayout.this.Kc);
                    MutiImgMoreLayout.this.Kc.objType = 1;
                }
                au.a(view, MutiImgMoreLayout.this.NJ, MutiImgMoreLayout.this.Oc, i, MutiImgMoreLayout.this.Kc.aAg(), MutiImgMoreLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bj bjVar) {
        ArrayList<VoiceData.VoiceModel> aCC = bjVar.aCC();
        if (v.isEmpty(aCC)) {
            this.NY.setVisibility(8);
            this.Ob = false;
            return;
        }
        this.NY.setVisibility(0);
        VoiceData.VoiceModel voiceModel = aCC.get(0);
        this.NY.setVoiceModel(voiceModel);
        this.NY.setTag(voiceModel);
        this.NY.bHt();
        if (voiceModel != null) {
            this.NY.wW(voiceModel.voice_status.intValue());
        }
        this.NY.cMi();
        this.Ob = true;
    }

    private void setImageData(bj bjVar) {
        boolean z;
        ArrayList<MediaData> aCy = bjVar.aCy();
        if (i.azO().isShowImages() && v.getCount(aCy) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= aCy.size()) {
                    break;
                }
                MediaData mediaData = (MediaData) v.getItem(aCy, i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            }
            this.Oc = linkedList;
            this.Oa = true;
            if (linkedList.size() <= 3) {
                z = false;
            } else {
                z = true;
            }
            this.Oo.setVisibility(8);
            if (v.getCount(linkedList) >= 3) {
                this.Oo.setVisibility(0);
                this.Op.setConrers(15);
                a((MediaData) v.getItem(aCy, 0), this.Op, true, false, false, 0);
                this.Oq.setConrers(15);
                a((MediaData) v.getItem(aCy, 1), this.Oq, false, false, false, 1);
                this.Or.setConrers(15);
                a((MediaData) v.getItem(aCy, 2), this.Or, true, z, true, 2);
                return;
            }
            this.Oo.setVisibility(8);
            this.Oa = false;
            return;
        }
        this.Oo.setVisibility(8);
        this.Oa = false;
    }

    public void setFromCDN(boolean z) {
        this.NJ = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        this.Kc = aVar;
        bj aAg = aVar.aAg();
        au.a(this.mTitle, aAg);
        au.a(this.KA, this.mTitle, aAg, Ky);
        setImageData(aAg);
        setVoiceData(aAg);
        nn();
    }

    private void nn() {
        if (this.KA.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Oa) {
                setMarginsTop(this.NY, NV);
            } else if (this.Ob) {
                setMarginsTop(this.NY, NX);
            }
        } else if (this.NY != null && this.NY.getLayoutParams() != null) {
            if (this.Oa) {
                setMarginsTop(this.NY, NV);
            } else if (this.Ob) {
                setMarginsTop(this.NY, NW);
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
        return this.LD;
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.LD = zVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bb = bb(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Op.getLayoutParams();
        layoutParams.width = bb;
        layoutParams.height = bb;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.Oq.getLayoutParams();
        layoutParams2.width = bb;
        layoutParams2.height = bb;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.Or.getLayoutParams();
        layoutParams3.width = bb;
        layoutParams3.height = bb;
        if (this.Oo.getVisibility() != 8) {
            this.Op.setLayoutParams(layoutParams);
            this.Oq.setLayoutParams(layoutParams2);
            this.Or.setLayoutParams(layoutParams3);
        }
    }

    private int bb(int i) {
        if (this.Oj > 0) {
            return this.Oj;
        }
        this.Oj = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.Oj;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.NJ ? 13 : 14;
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
        if (this.Ok != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.Ok == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private boolean Om;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.Om = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMoreLayout.this.Ok != null) {
                MutiImgMoreLayout.this.Ok.b(view, this.currentIndex, this.hasMore && this.Om);
            }
        }
    }
}

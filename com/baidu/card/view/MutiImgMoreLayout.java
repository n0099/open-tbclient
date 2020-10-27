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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes21.dex */
public class MutiImgMoreLayout extends LinearLayout implements p<AbsThreadDataSupport> {
    private AbsThreadDataSupport afI;
    public TextView agm;
    private ab<AbsThreadDataSupport> ahv;
    private LinkedList<MediaData> akA;
    public RelativeLayout akD;
    public TbImageView akE;
    public TbImageView akF;
    public TbImageView akG;
    private int akJ;
    private d akK;
    private boolean akk;
    public PlayVoiceBntNew akw;
    private boolean aky;
    private boolean akz;
    private String mFrom;
    public TextView mTitle;
    private static final int aku = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int agr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int akv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int agk = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMoreLayout(Context context) {
        this(context, null);
    }

    public MutiImgMoreLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akk = true;
        this.afI = null;
        this.aky = false;
        this.akz = false;
        this.akJ = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.agm = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.akw = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.akw.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMoreLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<AbsThreadDataSupport> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMoreLayout.this.afI);
                }
            }
        });
        this.akD = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        com.baidu.tbadk.a.b.a.d(this.akD, R.dimen.tbds26, R.dimen.tbds14);
        this.akE = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.akF = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.akG = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.akK = new d() { // from class: com.baidu.card.view.MutiImgMoreLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                ab<AbsThreadDataSupport> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMoreLayout.this.afI.objType = 2;
                    subClickListener.a(view, MutiImgMoreLayout.this.afI);
                    MutiImgMoreLayout.this.afI.objType = 1;
                }
                ay.a(view, MutiImgMoreLayout.this.akk, MutiImgMoreLayout.this.akA, i, MutiImgMoreLayout.this.afI.bhz(), MutiImgMoreLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bw bwVar) {
        ArrayList<VoiceData.VoiceModel> bkn = bwVar.bkn();
        if (y.isEmpty(bkn)) {
            this.akw.setVisibility(8);
            this.akz = false;
            return;
        }
        this.akw.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bkn.get(0);
        this.akw.setVoiceModel(voiceModel);
        this.akw.setTag(voiceModel);
        this.akw.changeSkin();
        if (voiceModel != null) {
            this.akw.Dm(voiceModel.voice_status.intValue());
        }
        this.akw.bWJ();
        this.akz = true;
    }

    private void setImageData(bw bwVar) {
        boolean z;
        ArrayList<MediaData> bkj = bwVar.bkj();
        if (k.bhh().isShowImages() && y.getCount(bkj) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= bkj.size()) {
                    break;
                }
                MediaData mediaData = (MediaData) y.getItem(bkj, i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            }
            this.akA = linkedList;
            this.aky = true;
            if (linkedList.size() <= 3) {
                z = false;
            } else {
                z = true;
            }
            this.akD.setVisibility(8);
            if (y.getCount(linkedList) >= 3) {
                this.akD.setVisibility(0);
                this.akE.setConrers(15);
                a((MediaData) y.getItem(bkj, 0), this.akE, true, false, false, 0);
                this.akF.setConrers(15);
                a((MediaData) y.getItem(bkj, 1), this.akF, false, false, false, 1);
                this.akG.setConrers(15);
                a((MediaData) y.getItem(bkj, 2), this.akG, true, z, true, 2);
                return;
            }
            this.akD.setVisibility(8);
            this.aky = false;
            return;
        }
        this.akD.setVisibility(8);
        this.aky = false;
    }

    public void setFromCDN(boolean z) {
        this.akk = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afI = absThreadDataSupport;
        bw bhz = absThreadDataSupport.bhz();
        ay.a(this.mTitle, bhz);
        ay.a(this.agm, this.mTitle, bhz, agk);
        setImageData(bhz);
        setVoiceData(bhz);
        ua();
    }

    private void ua() {
        if (this.agm.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.aky) {
                setMarginsTop(this.akw, aku);
            } else if (this.akz) {
                setMarginsTop(this.akw, akv);
            }
        } else if (this.akw != null && this.akw.getLayoutParams() != null) {
            if (this.aky) {
                setMarginsTop(this.akw, aku);
            } else if (this.akz) {
                setMarginsTop(this.akw, agr);
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

    public ab<AbsThreadDataSupport> getSubClickListener() {
        return this.ahv;
    }

    public void setSubClickListener(ab<AbsThreadDataSupport> abVar) {
        this.ahv = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bE = bE(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akE.getLayoutParams();
        layoutParams.width = bE;
        layoutParams.height = bE;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.akF.getLayoutParams();
        layoutParams2.width = bE;
        layoutParams2.height = bE;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.akG.getLayoutParams();
        layoutParams3.width = bE;
        layoutParams3.height = bE;
        if (this.akD.getVisibility() != 8) {
            this.akE.setLayoutParams(layoutParams);
            this.akF.setLayoutParams(layoutParams2);
            this.akG.setLayoutParams(layoutParams3);
        }
    }

    private int bE(int i) {
        if (this.akJ > 0) {
            return this.akJ;
        }
        this.akJ = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.akJ;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.akk ? 13 : 14;
        if (!at.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ap.getColor(R.color.cp_border_a));
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
        if (this.akK != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.akK == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements View.OnClickListener {
        private boolean akN;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.akN = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMoreLayout.this.akK != null) {
                MutiImgMoreLayout.this.akK.b(view, this.currentIndex, this.hasMore && this.akN);
            }
        }
    }
}

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
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes20.dex */
public class MutiImgMoreLayout extends LinearLayout implements p<AbsThreadDataSupport> {
    public TextView afT;
    private AbsThreadDataSupport afq;
    private aa<AbsThreadDataSupport> ahd;
    private boolean ajR;
    public PlayVoiceBntNew akd;
    private boolean akf;
    private boolean akg;
    private LinkedList<MediaData> akh;
    public RelativeLayout akk;
    public TbImageView akl;
    public TbImageView akm;
    public TbImageView akn;
    private int akq;
    private d akr;
    private String mFrom;
    public TextView mTitle;
    private static final int akb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int afY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int akc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int afR = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMoreLayout(Context context) {
        this(context, null);
    }

    public MutiImgMoreLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajR = true;
        this.afq = null;
        this.akf = false;
        this.akg = false;
        this.akq = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.afT = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.akd = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.akd.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMoreLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMoreLayout.this.afq);
                }
            }
        });
        this.akk = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        com.baidu.tbadk.a.b.a.d(this.akk, R.dimen.tbds26, R.dimen.tbds14);
        this.akl = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.akm = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.akn = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.akr = new d() { // from class: com.baidu.card.view.MutiImgMoreLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMoreLayout.this.afq.objType = 2;
                    subClickListener.a(view, MutiImgMoreLayout.this.afq);
                    MutiImgMoreLayout.this.afq.objType = 1;
                }
                ay.a(view, MutiImgMoreLayout.this.ajR, MutiImgMoreLayout.this.akh, i, MutiImgMoreLayout.this.afq.bcY(), MutiImgMoreLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bw bwVar) {
        ArrayList<VoiceData.VoiceModel> bfL = bwVar.bfL();
        if (y.isEmpty(bfL)) {
            this.akd.setVisibility(8);
            this.akg = false;
            return;
        }
        this.akd.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bfL.get(0);
        this.akd.setVoiceModel(voiceModel);
        this.akd.setTag(voiceModel);
        this.akd.changeSkin();
        if (voiceModel != null) {
            this.akd.Cn(voiceModel.voice_status.intValue());
        }
        this.akd.bQr();
        this.akg = true;
    }

    private void setImageData(bw bwVar) {
        boolean z;
        ArrayList<MediaData> bfH = bwVar.bfH();
        if (k.bcG().isShowImages() && y.getCount(bfH) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= bfH.size()) {
                    break;
                }
                MediaData mediaData = (MediaData) y.getItem(bfH, i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            }
            this.akh = linkedList;
            this.akf = true;
            if (linkedList.size() <= 3) {
                z = false;
            } else {
                z = true;
            }
            this.akk.setVisibility(8);
            if (y.getCount(linkedList) >= 3) {
                this.akk.setVisibility(0);
                this.akl.setConrers(15);
                a((MediaData) y.getItem(bfH, 0), this.akl, true, false, false, 0);
                this.akm.setConrers(15);
                a((MediaData) y.getItem(bfH, 1), this.akm, false, false, false, 1);
                this.akn.setConrers(15);
                a((MediaData) y.getItem(bfH, 2), this.akn, true, z, true, 2);
                return;
            }
            this.akk.setVisibility(8);
            this.akf = false;
            return;
        }
        this.akk.setVisibility(8);
        this.akf = false;
    }

    public void setFromCDN(boolean z) {
        this.ajR = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(AbsThreadDataSupport absThreadDataSupport) {
        this.afq = absThreadDataSupport;
        bw bcY = absThreadDataSupport.bcY();
        ay.a(this.mTitle, bcY);
        ay.a(this.afT, this.mTitle, bcY, afR);
        setImageData(bcY);
        setVoiceData(bcY);
        ua();
    }

    private void ua() {
        if (this.afT.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.akf) {
                setMarginsTop(this.akd, akb);
            } else if (this.akg) {
                setMarginsTop(this.akd, akc);
            }
        } else if (this.akd != null && this.akd.getLayoutParams() != null) {
            if (this.akf) {
                setMarginsTop(this.akd, akb);
            } else if (this.akg) {
                setMarginsTop(this.akd, afY);
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
        return this.ahd;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.ahd = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bE = bE(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akl.getLayoutParams();
        layoutParams.width = bE;
        layoutParams.height = bE;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.akm.getLayoutParams();
        layoutParams2.width = bE;
        layoutParams2.height = bE;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.akn.getLayoutParams();
        layoutParams3.width = bE;
        layoutParams3.height = bE;
        if (this.akk.getVisibility() != 8) {
            this.akl.setLayoutParams(layoutParams);
            this.akm.setLayoutParams(layoutParams2);
            this.akn.setLayoutParams(layoutParams3);
        }
    }

    private int bE(int i) {
        if (this.akq > 0) {
            return this.akq;
        }
        this.akq = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.akq;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.ajR ? 13 : 14;
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
        if (this.akr != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.akr == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a implements View.OnClickListener {
        private boolean aku;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.aku = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMoreLayout.this.akr != null) {
                MutiImgMoreLayout.this.akr.b(view, this.currentIndex, this.hasMore && this.aku);
            }
        }
    }
}

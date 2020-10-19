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
/* loaded from: classes21.dex */
public class MutiImgMoreLayout extends LinearLayout implements p<AbsThreadDataSupport> {
    private AbsThreadDataSupport afH;
    public TextView agl;
    private aa<AbsThreadDataSupport> ahu;
    public RelativeLayout akC;
    public TbImageView akD;
    public TbImageView akE;
    public TbImageView akF;
    private int akI;
    private d akJ;
    private boolean akj;
    public PlayVoiceBntNew akv;
    private boolean akx;
    private boolean aky;
    private LinkedList<MediaData> akz;
    private String mFrom;
    public TextView mTitle;
    private static final int akt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int agq = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int aku = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int agj = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMoreLayout(Context context) {
        this(context, null);
    }

    public MutiImgMoreLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akj = true;
        this.afH = null;
        this.akx = false;
        this.aky = false;
        this.akI = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.agl = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.akv = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.akv.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMoreLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMoreLayout.this.afH);
                }
            }
        });
        this.akC = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        com.baidu.tbadk.a.b.a.d(this.akC, R.dimen.tbds26, R.dimen.tbds14);
        this.akD = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.akE = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.akF = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.akJ = new d() { // from class: com.baidu.card.view.MutiImgMoreLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void b(View view, int i, boolean z) {
                aa<AbsThreadDataSupport> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMoreLayout.this.afH.objType = 2;
                    subClickListener.a(view, MutiImgMoreLayout.this.afH);
                    MutiImgMoreLayout.this.afH.objType = 1;
                }
                ay.a(view, MutiImgMoreLayout.this.akj, MutiImgMoreLayout.this.akz, i, MutiImgMoreLayout.this.afH.bfG(), MutiImgMoreLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(bw bwVar) {
        ArrayList<VoiceData.VoiceModel> biu = bwVar.biu();
        if (y.isEmpty(biu)) {
            this.akv.setVisibility(8);
            this.aky = false;
            return;
        }
        this.akv.setVisibility(0);
        VoiceData.VoiceModel voiceModel = biu.get(0);
        this.akv.setVoiceModel(voiceModel);
        this.akv.setTag(voiceModel);
        this.akv.changeSkin();
        if (voiceModel != null) {
            this.akv.CT(voiceModel.voice_status.intValue());
        }
        this.akv.bTK();
        this.aky = true;
    }

    private void setImageData(bw bwVar) {
        boolean z;
        ArrayList<MediaData> biq = bwVar.biq();
        if (k.bfo().isShowImages() && y.getCount(biq) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= biq.size()) {
                    break;
                }
                MediaData mediaData = (MediaData) y.getItem(biq, i2);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
                i = i2 + 1;
            }
            this.akz = linkedList;
            this.akx = true;
            if (linkedList.size() <= 3) {
                z = false;
            } else {
                z = true;
            }
            this.akC.setVisibility(8);
            if (y.getCount(linkedList) >= 3) {
                this.akC.setVisibility(0);
                this.akD.setConrers(15);
                a((MediaData) y.getItem(biq, 0), this.akD, true, false, false, 0);
                this.akE.setConrers(15);
                a((MediaData) y.getItem(biq, 1), this.akE, false, false, false, 1);
                this.akF.setConrers(15);
                a((MediaData) y.getItem(biq, 2), this.akF, true, z, true, 2);
                return;
            }
            this.akC.setVisibility(8);
            this.akx = false;
            return;
        }
        this.akC.setVisibility(8);
        this.akx = false;
    }

    public void setFromCDN(boolean z) {
        this.akj = z;
    }

    public void setPreloadSizeReadyCallback(b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(AbsThreadDataSupport absThreadDataSupport) {
        this.afH = absThreadDataSupport;
        bw bfG = absThreadDataSupport.bfG();
        ay.a(this.mTitle, bfG);
        ay.a(this.agl, this.mTitle, bfG, agj);
        setImageData(bfG);
        setVoiceData(bfG);
        ua();
    }

    private void ua() {
        if (this.agl.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.akx) {
                setMarginsTop(this.akv, akt);
            } else if (this.aky) {
                setMarginsTop(this.akv, aku);
            }
        } else if (this.akv != null && this.akv.getLayoutParams() != null) {
            if (this.akx) {
                setMarginsTop(this.akv, akt);
            } else if (this.aky) {
                setMarginsTop(this.akv, agq);
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
        return this.ahu;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.ahu = aaVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bE = bE(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akD.getLayoutParams();
        layoutParams.width = bE;
        layoutParams.height = bE;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.akE.getLayoutParams();
        layoutParams2.width = bE;
        layoutParams2.height = bE;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.akF.getLayoutParams();
        layoutParams3.width = bE;
        layoutParams3.height = bE;
        if (this.akC.getVisibility() != 8) {
            this.akD.setLayoutParams(layoutParams);
            this.akE.setLayoutParams(layoutParams2);
            this.akF.setLayoutParams(layoutParams3);
        }
    }

    private int bE(int i) {
        if (this.akI > 0) {
            return this.akI;
        }
        this.akI = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.akI;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.akj ? 13 : 14;
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
        if (this.akJ != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.akJ == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements View.OnClickListener {
        private boolean akM;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.akM = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMoreLayout.this.akJ != null) {
                MutiImgMoreLayout.this.akJ.b(view, this.currentIndex, this.hasMore && this.akM);
            }
        }
    }
}

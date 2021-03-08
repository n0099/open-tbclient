package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.card.p;
import com.baidu.tbadk.a.b.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class MutiImgMoreLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a ahB;
    public TextView air;
    private ab<com.baidu.tbadk.core.data.a> ajy;
    public RelativeLayout amB;
    public TbImageView amC;
    public TbImageView amD;
    public TbImageView amE;
    private int amH;
    private d amI;
    private boolean amh;
    public PlayVoiceBntNew amu;
    private boolean amw;
    private boolean amx;
    private LinkedList<MediaData> amy;
    private String mFrom;
    public TextView mTitle;
    private static final int amr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int ams = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int amt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int aip = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgMoreLayout(Context context) {
        this(context, null);
    }

    public MutiImgMoreLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amh = true;
        this.ahB = null;
        this.amw = false;
        this.amx = false;
        this.amH = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_more_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.air = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.amu = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.amu.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgMoreLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgMoreLayout.this.ahB);
                }
            }
        });
        this.amB = (RelativeLayout) findViewById(R.id.thread_card_img_more_container);
        b.j(this.amB, R.dimen.tbds26, R.dimen.tbds14);
        this.amC = (TbImageView) findViewById(R.id.thread_card_img_more_one);
        this.amD = (TbImageView) findViewById(R.id.thread_card_img_more_two);
        this.amE = (TbImageView) findViewById(R.id.thread_card_img_more_three);
        this.amI = new d() { // from class: com.baidu.card.view.MutiImgMoreLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void c(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgMoreLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgMoreLayout.this.ahB.objType = 2;
                    subClickListener.a(view, MutiImgMoreLayout.this.ahB);
                    MutiImgMoreLayout.this.ahB.objType = 1;
                }
                az.a(view, MutiImgMoreLayout.this.amh, MutiImgMoreLayout.this.amy, i, MutiImgMoreLayout.this.ahB.blp(), MutiImgMoreLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(cb cbVar) {
        ArrayList<VoiceData.VoiceModel> bof = cbVar.bof();
        if (y.isEmpty(bof)) {
            this.amu.setVisibility(8);
            this.amx = false;
            return;
        }
        this.amu.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bof.get(0);
        this.amu.setVoiceModel(voiceModel);
        this.amu.setTag(voiceModel);
        this.amu.bur();
        if (voiceModel != null) {
            this.amu.Ds(voiceModel.voice_status.intValue());
        }
        this.amu.ccH();
        this.amx = true;
    }

    private void setImageData(cb cbVar) {
        ArrayList<MediaData> bob = cbVar.bob();
        if (k.bkV().isShowImages() && y.getCount(bob) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < bob.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bob, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.amy = linkedList;
            this.amw = true;
            boolean z = linkedList.size() > 3;
            this.amB.setVisibility(8);
            if (y.getCount(linkedList) >= 3) {
                this.amB.setVisibility(0);
                this.amC.setConrers(15);
                a((MediaData) y.getItem(bob, 0), this.amC, R.string.J_X12, false, false, 0);
                this.amD.setConrers(15);
                a((MediaData) y.getItem(bob, 1), this.amD, R.string.J_X02, false, false, 1);
                this.amE.setConrers(15);
                a((MediaData) y.getItem(bob, 2), this.amE, R.string.J_X11, z, true, 2);
                return;
            }
            this.amB.setVisibility(8);
            this.amw = false;
            return;
        }
        this.amB.setVisibility(8);
        this.amw = false;
    }

    public void setFromCDN(boolean z) {
        this.amh = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(com.baidu.tbadk.core.data.a aVar) {
        boolean z = true;
        this.ahB = aVar;
        cb blp = aVar.blp();
        az.a(this.mTitle, blp);
        az.a(this.air, this.mTitle, blp, aip);
        boolean z2 = this.mTitle == null || this.mTitle.getVisibility() != 0;
        boolean z3 = this.air == null || this.air.getVisibility() != 0;
        RelativeLayout relativeLayout = this.amB;
        if (!z2 || !z3) {
            z = false;
        }
        az.a(relativeLayout, z, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        setImageData(blp);
        setVoiceData(blp);
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
        return this.ajy;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.ajy = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bF = bF(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.amC.getLayoutParams();
        layoutParams.width = bF;
        layoutParams.height = bF;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.amD.getLayoutParams();
        layoutParams2.width = bF;
        layoutParams2.height = bF;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.amE.getLayoutParams();
        layoutParams3.width = bF;
        layoutParams3.height = bF;
        if (this.amB.getVisibility() != 8) {
            this.amC.setLayoutParams(layoutParams);
            this.amD.setLayoutParams(layoutParams2);
            this.amE.setLayoutParams(layoutParams3);
        }
    }

    private int bF(int i) {
        if (this.amH > 0) {
            return this.amH;
        }
        this.amH = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.amH;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, int i, boolean z, boolean z2, int i2) {
        String a2 = a(mediaData);
        int i3 = this.amh ? 13 : 14;
        if (!au.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        tbImageView.setRadiusById(i);
        tbImageView.setDrawBorder(true);
        tbImageView.setForegroundColor(0);
        tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        tbImageView.setBorderColor(ap.getColor(R.color.CAM_X0401));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.startLoad(a2, i3, false);
        a(tbImageView, i2, z, z2);
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
        if (this.amI != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.amI == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private boolean amL;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.amL = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgMoreLayout.this.amI != null) {
                MutiImgMoreLayout.this.amI.c(view, this.currentIndex, this.hasMore && this.amL);
            }
        }
    }
}

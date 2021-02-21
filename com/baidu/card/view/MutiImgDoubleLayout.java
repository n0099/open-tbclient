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
public class MutiImgDoubleLayout extends LinearLayout implements p<com.baidu.tbadk.core.data.a> {
    public TextView agY;
    private com.baidu.tbadk.core.data.a agj;
    private ab<com.baidu.tbadk.core.data.a> aig;
    private boolean akO;
    public PlayVoiceBntNew alb;
    private boolean ald;
    private boolean ale;
    private LinkedList<MediaData> alf;
    private int alp;
    private d alq;
    public RelativeLayout alu;
    public TbImageView alv;
    public TbImageView alw;
    private String mFrom;
    public TextView mTitle;
    private static final int akY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int akZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int ala = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int agW = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public MutiImgDoubleLayout(Context context) {
        this(context, null);
    }

    public MutiImgDoubleLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akO = true;
        this.agj = null;
        this.ald = false;
        this.ale = false;
        this.alp = 0;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_image_double_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.agY = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.alb = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.alb.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.MutiImgDoubleLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, MutiImgDoubleLayout.this.agj);
                }
            }
        });
        b.j(this.alb, R.dimen.tbds28, R.dimen.tbds14);
        b.a(this.mTitle, R.dimen.tbds7, R.dimen.tbds10);
        b.a(this.agY, R.dimen.tbds7, R.dimen.tbds10);
        this.alu = (RelativeLayout) findViewById(R.id.thread_card_img_double_container);
        b.j(this.alu, R.dimen.tbds20, R.dimen.tbds14);
        this.alv = (TbImageView) findViewById(R.id.thread_card_img_double_one);
        this.alw = (TbImageView) findViewById(R.id.thread_card_img_double_two);
        this.alq = new d() { // from class: com.baidu.card.view.MutiImgDoubleLayout.2
            @Override // com.baidu.tbadk.widget.layout.d
            public void c(View view, int i, boolean z) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = MutiImgDoubleLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    MutiImgDoubleLayout.this.agj.objType = 2;
                    subClickListener.a(view, MutiImgDoubleLayout.this.agj);
                    MutiImgDoubleLayout.this.agj.objType = 1;
                }
                az.a(view, MutiImgDoubleLayout.this.akO, MutiImgDoubleLayout.this.alf, i, MutiImgDoubleLayout.this.agj.bln(), MutiImgDoubleLayout.this.mFrom);
            }
        };
    }

    private void setVoiceData(cb cbVar) {
        ArrayList<VoiceData.VoiceModel> bod = cbVar.bod();
        if (y.isEmpty(bod)) {
            this.alb.setVisibility(8);
            this.ale = false;
            return;
        }
        this.alb.setVisibility(0);
        VoiceData.VoiceModel voiceModel = bod.get(0);
        this.alb.setVoiceModel(voiceModel);
        this.alb.setTag(voiceModel);
        this.alb.buo();
        if (voiceModel != null) {
            this.alb.Dp(voiceModel.voice_status.intValue());
        }
        this.alb.ccB();
        this.ale = true;
    }

    private void setImageData(cb cbVar) {
        ArrayList<MediaData> bnZ = cbVar.bnZ();
        if (k.bkT().isShowImages() && y.getCount(bnZ) != 0) {
            LinkedList<MediaData> linkedList = new LinkedList<>();
            for (int i = 0; i < bnZ.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bnZ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            this.alf = linkedList;
            this.ald = true;
            this.alu.setVisibility(8);
            if (y.getCount(linkedList) == 2) {
                this.alu.setVisibility(0);
                this.alv.setConrers(15);
                a((MediaData) y.getItem(bnZ, 0), this.alv, true, false, false, 0);
                this.alw.setConrers(15);
                a((MediaData) y.getItem(bnZ, 1), this.alw, true, false, true, 1);
                return;
            }
            this.alu.setVisibility(8);
            this.ald = false;
            return;
        }
        this.alu.setVisibility(8);
        this.ald = false;
    }

    public void setFromCDN(boolean z) {
        this.akO = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(com.baidu.tbadk.core.data.a aVar) {
        this.agj = aVar;
        cb bln = aVar.bln();
        az.a(this.mTitle, bln);
        az.a(this.agY, this.mTitle, bln, agW);
        setImageData(bln);
        setVoiceData(bln);
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
        return this.aig;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.aig = abVar;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int bE = bE(i);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.alv.getLayoutParams();
        layoutParams.width = bE;
        layoutParams.height = bE;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.alw.getLayoutParams();
        layoutParams2.width = bE;
        layoutParams2.height = bE;
        if (this.alu.getVisibility() != 8) {
            this.alv.setLayoutParams(layoutParams);
            this.alw.setLayoutParams(layoutParams2);
        }
    }

    private int bE(int i) {
        if (this.alp > 0) {
            return this.alp;
        }
        this.alp = (View.MeasureSpec.getSize(i) - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3;
        return this.alp;
    }

    private void a(MediaData mediaData, TbImageView tbImageView, boolean z, boolean z2, boolean z3, int i) {
        String a2 = a(mediaData);
        int i2 = this.akO ? 13 : 14;
        if (!au.equals(a2, tbImageView.getUrl())) {
            tbImageView.reset();
        }
        if (z) {
            tbImageView.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
            tbImageView.setDrawBorder(true);
            tbImageView.setForegroundColor(0);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ap.getColor(R.color.CAM_X0401));
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
        if (this.alq != null && tbImageView != null) {
            View.OnClickListener onClickListener = tbImageView.getOnClickListener();
            if (onClickListener instanceof a) {
                ((a) onClickListener).b(i, z, z2);
            } else {
                tbImageView.setOnClickListener(new a(i, z, z2));
            }
        } else if (this.alq == null && tbImageView != null) {
            tbImageView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private boolean alt;
        private int currentIndex;
        private boolean hasMore;

        public a(int i, boolean z, boolean z2) {
            b(i, z, z2);
        }

        public void b(int i, boolean z, boolean z2) {
            this.currentIndex = i;
            this.hasMore = z;
            this.alt = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MutiImgDoubleLayout.this.alq != null) {
                MutiImgDoubleLayout.this.alq.c(view, this.currentIndex, this.hasMore && this.alt);
            }
        }
    }
}

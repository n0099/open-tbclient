package com.baidu.card.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.d.b;
import com.baidu.adp.lib.util.l;
import com.baidu.card.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class NewGridImageLayout extends LinearLayout implements View.OnClickListener, p<com.baidu.tbadk.core.data.a> {
    private boolean ahF;
    private int ahW;
    private com.baidu.tbadk.core.data.a ahi;
    private View.OnClickListener ahj;
    public TextView aia;
    private aa<com.baidu.tbadk.core.data.a> ajj;
    public VoteView akk;
    private boolean alQ;
    private final int amG;
    public GridImageLayout amH;
    private boolean amI;
    public boolean amJ;
    private LinkedList<MediaData> amK;
    private com.baidu.tbadk.widget.richText.a amL;
    public PlayVoiceBntNew amd;
    private boolean amf;
    private boolean amg;
    private int amq;
    protected boolean ams;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;
    private static final int ama = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int amb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int amE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31);
    private static final int amF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
    private static final int amc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int M_H_X004 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);

    public NewGridImageLayout(Context context) {
        this(context, null);
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amG = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.alQ = true;
        this.amf = false;
        this.amg = false;
        this.amI = false;
        this.amJ = true;
        this.amq = 0;
        this.ams = false;
        this.ahF = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aia = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.amd = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.amd.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<com.baidu.tbadk.core.data.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, NewGridImageLayout.this.ahi);
                }
            }
        });
        this.amH = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        this.amH.setSupportGifPlay(false);
        this.amH.setCornerStyle(1);
        this.amH.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<com.baidu.tbadk.core.data.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    subClickListener.a(view, NewGridImageLayout.this.ahi);
                }
            }
        });
        this.amL = new com.baidu.tbadk.widget.richText.a();
        int i = l.getScreenDimensions(this.mContext)[0];
        this.amL.fYR = i - (l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004) * 2);
        this.amL.fYS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.amH.setLayoutStrategy(this.amL);
        this.amK = new LinkedList<>();
        this.amH.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.3
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i2, boolean z, boolean z2) {
                ay.a(view, NewGridImageLayout.this.amL.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.amK, i2, NewGridImageLayout.this.ahi.boO(), NewGridImageLayout.this.mFrom, true);
            }
        });
        this.akk = (VoteView) findViewById(R.id.thread_card_vote);
        this.akk.setBgColor(R.color.CAM_X0207);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setCornerStyle(int i) {
        this.amH.setCornerStyle(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void D(final com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.boO() != null) {
            bz boO = aVar.boO();
            OriginalThreadInfo originalThreadInfo = boO.eVB;
            if (originalThreadInfo != null && this.amI) {
                setMarginsTop(this.amH, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                c.bv(this.aia).pE(R.string.F_X01).pD(R.dimen.T_X07);
                c.bv(this.mTitle).pD(R.dimen.T_X07);
                this.mTitle.setVisibility(8);
                if (originalThreadInfo.ePW) {
                    ay.a(this.aia, this.mTitle, new SpannableString(originalThreadInfo.title), boO, this.amG, this.amI, this.ahF);
                    ao.setViewTextColor(this.aia, R.color.CAM_X0108);
                } else {
                    ay.a(this.aia, this.mTitle, originalThreadInfo.eQX, boO, this.amG, this.amI, this.ahF);
                }
                if (a(originalThreadInfo.pollData)) {
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ay.a(aVar.boO().eVB, NewGridImageLayout.this.mContext, NewGridImageLayout.this.ahW);
                        }
                    };
                    this.akk.setOnClickListener(onClickListener);
                    this.akk.setOnItemClickListener(onClickListener);
                    this.akk.setIsTransmit(true);
                    this.akk.setData(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
                    this.akk.setVisibility(0);
                } else {
                    this.akk.setVisibility(8);
                }
            } else {
                setMarginsTop(this.amH, UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
                this.akk.setVisibility(8);
                this.aia.setTextSize(0, l.getDimens(this.mContext, R.dimen.T_X06));
                this.aia.setLineSpacing(l.getDimens(this.mContext, R.dimen.M_T_X002), 1.0f);
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.T_X06));
                ay.a(this.mTitle, boO, this.ahF);
                ay.a(this.aia, this.mTitle, boO.bqR(), boO, this.amG, this.amI, this.ahF);
            }
            if (p(boO)) {
                q(boO);
            }
            setVoiceData(boO);
            this.ahi = aVar;
            if (this.ahi.boO().eVB != null) {
                if (boO.isShareThread) {
                    if (this.ahi.boO().eVB != null) {
                        if (!this.ahi.boO().eVB.ePW) {
                            this.amH.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.5
                                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                                public void a(View view, String str, int i, boolean z, boolean z2) {
                                    ay.a(NewGridImageLayout.this.ahi.boO().eVB, NewGridImageLayout.this.mContext, 2);
                                }
                            });
                        }
                    } else {
                        return;
                    }
                }
                if (!this.ahi.boO().eVB.ePW) {
                    this.amH.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.6
                        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                        public void a(View view, String str, int i, boolean z, boolean z2) {
                            ay.a(view, true, (List<MediaData>) NewGridImageLayout.this.amK, i, NewGridImageLayout.this.ahi.boO().eVB.bpQ(), NewGridImageLayout.this.mFrom, NewGridImageLayout.this.ahi.boO().eVB.eQV);
                        }
                    });
                }
                if (this.amI) {
                    if (this.ahi.boO().eVB == null || this.ahi.boO().eVB.ePW) {
                        setOnClickListener(null);
                    } else {
                        setOnClickListener(this);
                    }
                    setClickable(true);
                    return;
                }
                setOnClickListener(null);
                setClickable(false);
            }
        }
    }

    private void setVoiceData(bz bzVar) {
        if (bzVar != null) {
            if (this.amI) {
                this.amd.am(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NewGridImageLayout.this.ahj != null) {
                            NewGridImageLayout.this.ahj.onClick(view);
                        }
                    }
                });
            }
            ArrayList<VoiceData.VoiceModel> brD = (!bzVar.isShareThread || bzVar.eVB == null) ? bzVar.brD() : bzVar.eVB.eQW;
            if (x.isEmpty(brD)) {
                this.amd.setVisibility(8);
                this.amg = false;
                return;
            }
            this.amd.setVisibility(0);
            VoiceData.VoiceModel voiceModel = brD.get(0);
            this.amd.setVoiceModel(voiceModel);
            this.amd.setTag(voiceModel);
            this.amd.bxN();
            if (voiceModel != null) {
                this.amd.EE(voiceModel.voice_status.intValue());
            }
            this.amd.cfq();
            this.amg = true;
        }
    }

    public void setObjectPool(b<ImageView> bVar, b<GifView> bVar2) {
        if (this.amH != null) {
            this.amH.setObjectPool(bVar, bVar2);
        }
    }

    private void setMarginsTop(View view, int i) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public aa<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.ajj;
    }

    public void setSubClickListener(aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.ajj = aaVar;
    }

    private boolean p(bz bzVar) {
        if (this.ahi == null || this.ahi.boO() == null) {
            return true;
        }
        if (this.ahi.boO().getTid() == null || this.ahi.boO().getTid().equals(bzVar.getTid())) {
            return (!bzVar.isShareThread || bzVar.eVB == null) ? !c(bzVar.brz(), this.ahi.boO().brz()) : this.ahi.boO().eVB == null || !c(bzVar.eVB.eQS, this.ahi.boO().eVB.eQS);
        }
        return true;
    }

    private void q(bz bzVar) {
        boolean z;
        ArrayList<MediaData> arrayList;
        String b2;
        ArrayList<MediaData> brz = bzVar.brz();
        String bra = bzVar.bra();
        if (!bzVar.isShareThread || bzVar.eVB == null) {
            z = false;
            arrayList = brz;
        } else if (bzVar.eVB.ePW) {
            this.amH.setVisibility(8);
            return;
        } else {
            z = true;
            arrayList = bzVar.eVB.eQS;
        }
        if (k.bou().isShowImages() && x.getCount(arrayList) != 0) {
            this.amK.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                MediaData mediaData = (MediaData) x.getItem(arrayList, i);
                if (mediaData != null && mediaData.getType() == 3 && (z || (bra != null && bra.equals(mediaData.getPostId() + "")))) {
                    this.amK.add(mediaData);
                }
            }
            if (x.getCount(this.amK) > 0) {
                this.amf = true;
                this.amH.setVisibility(0);
                ArrayList<TbRichTextImageInfo> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < this.amK.size(); i2++) {
                    MediaData mediaData2 = (MediaData) x.getItem(this.amK, i2);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.amK.size() > 1) {
                        b2 = a(mediaData2);
                    } else {
                        b2 = b(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.setSrc(b2);
                    tbRichTextImageInfo.ET(originalUrl);
                    tbRichTextImageInfo.lM(mediaData2.isLongPic());
                    if (mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(mediaData2.picWidth);
                        tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                    }
                    arrayList2.add(tbRichTextImageInfo);
                }
                this.amH.setData(arrayList2);
                return;
            }
            this.amf = false;
            this.amH.setVisibility(8);
            return;
        }
        this.amf = false;
        this.amH.setVisibility(8);
    }

    private String a(MediaData mediaData) {
        if (mediaData == null) {
            return "";
        }
        String smallPicUrl = mediaData.getSmallPicUrl();
        if (TextUtils.isEmpty(smallPicUrl)) {
            smallPicUrl = mediaData.getThumbnails_url();
        }
        if (TextUtils.isEmpty(smallPicUrl)) {
            smallPicUrl = mediaData.getPicUrl();
        }
        if (TextUtils.isEmpty(smallPicUrl)) {
            return mediaData.getSrc_pic();
        }
        return smallPicUrl;
    }

    private String b(MediaData mediaData) {
        if (mediaData == null) {
            return "";
        }
        String picUrl = mediaData.getPicUrl();
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getThumbnails_url();
        }
        if (TextUtils.isEmpty(picUrl)) {
            picUrl = mediaData.getSmallPicUrl();
        }
        if (TextUtils.isEmpty(picUrl)) {
            return mediaData.getSrc_pic();
        }
        return picUrl;
    }

    private boolean c(ArrayList<MediaData> arrayList, ArrayList<MediaData> arrayList2) {
        String b2;
        String str;
        if (arrayList == arrayList2) {
            return true;
        }
        if (arrayList == null || arrayList2 == null) {
            return false;
        }
        if (arrayList.size() != arrayList2.size()) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = arrayList.get(i);
            MediaData mediaData2 = arrayList2.get(i);
            if (size > 1) {
                String a2 = a(mediaData);
                b2 = a(mediaData2);
                str = a2;
            } else {
                String b3 = b(mediaData);
                b2 = b(mediaData2);
                str = b3;
            }
            if (str != b2) {
                if (str == null || b2 == null) {
                    return false;
                }
                if (!str.equals(b2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setFromCDN(boolean z) {
        this.alQ = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    public void setTransmit(boolean z) {
        this.amI = z;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.ahj = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ahj != null) {
            this.ahj.onClick(view);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.amH != null) {
            this.amH.onChangeSkinType();
        }
        if (this.akk != null) {
            this.akk.onChangeSkinType(i);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahF = z;
    }

    public void setFromForPb(int i) {
        this.ahW = i;
    }

    private boolean a(PollData pollData) {
        return (pollData == null || pollData.getOptions() == null || pollData.getOptions().size() <= 0) ? false : true;
    }
}

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
    private boolean agO;
    private com.baidu.tbadk.core.data.a agr;
    private View.OnClickListener ags;
    private int ahf;
    public TextView ahj;
    private aa<com.baidu.tbadk.core.data.a> ais;
    public VoteView ajt;
    private boolean akY;
    protected boolean alB;
    private final int alP;
    public GridImageLayout alQ;
    private boolean alR;
    public boolean alS;
    private LinkedList<MediaData> alT;
    private com.baidu.tbadk.widget.richText.a alU;
    public PlayVoiceBntNew alm;
    private boolean alo;
    private boolean alp;
    private int alz;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;
    private static final int ali = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int alj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int alN = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31);
    private static final int alO = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
    private static final int alk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int M_H_X004 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);

    public NewGridImageLayout(Context context) {
        this(context, null);
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alP = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.akY = true;
        this.alo = false;
        this.alp = false;
        this.alR = false;
        this.alS = true;
        this.alz = 0;
        this.alB = false;
        this.agO = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ahj = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.alm = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.alm.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<com.baidu.tbadk.core.data.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, NewGridImageLayout.this.agr);
                }
            }
        });
        this.alQ = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        this.alQ.setSupportGifPlay(false);
        this.alQ.setCornerStyle(1);
        this.alQ.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<com.baidu.tbadk.core.data.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    subClickListener.a(view, NewGridImageLayout.this.agr);
                }
            }
        });
        this.alU = new com.baidu.tbadk.widget.richText.a();
        int i = l.getScreenDimensions(this.mContext)[0];
        this.alU.fUk = i - (l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004) * 2);
        this.alU.fUl = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.alQ.setLayoutStrategy(this.alU);
        this.alT = new LinkedList<>();
        this.alQ.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.3
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i2, boolean z, boolean z2) {
                ay.a(view, NewGridImageLayout.this.alU.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.alT, i2, NewGridImageLayout.this.agr.bkV(), NewGridImageLayout.this.mFrom, true);
            }
        });
        this.ajt = (VoteView) findViewById(R.id.thread_card_vote);
        this.ajt.setBgColor(R.color.CAM_X0207);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setCornerStyle(int i) {
        this.alQ.setCornerStyle(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(final com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.bkV() != null) {
            bz bkV = aVar.bkV();
            OriginalThreadInfo originalThreadInfo = bkV.eQQ;
            if (originalThreadInfo != null && this.alR) {
                setMarginsTop(this.alQ, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                c.bv(this.ahj).nX(R.string.F_X01).nW(R.dimen.T_X07);
                c.bv(this.mTitle).nW(R.dimen.T_X07);
                this.mTitle.setVisibility(8);
                if (originalThreadInfo.eLl) {
                    ay.a(this.ahj, this.mTitle, new SpannableString(originalThreadInfo.title), bkV, this.alP, this.alR, this.agO);
                    ao.setViewTextColor(this.ahj, R.color.CAM_X0108);
                } else {
                    ay.a(this.ahj, this.mTitle, originalThreadInfo.eMm, bkV, this.alP, this.alR, this.agO);
                }
                if (a(originalThreadInfo.pollData)) {
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ay.a(aVar.bkV().eQQ, NewGridImageLayout.this.mContext, NewGridImageLayout.this.ahf);
                        }
                    };
                    this.ajt.setOnClickListener(onClickListener);
                    this.ajt.setOnItemClickListener(onClickListener);
                    this.ajt.setIsTransmit(true);
                    this.ajt.setData(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
                    this.ajt.setVisibility(0);
                } else {
                    this.ajt.setVisibility(8);
                }
            } else {
                setMarginsTop(this.alQ, UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
                this.ajt.setVisibility(8);
                this.ahj.setTextSize(0, l.getDimens(this.mContext, R.dimen.T_X06));
                this.ahj.setLineSpacing(l.getDimens(this.mContext, R.dimen.M_T_X002), 1.0f);
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.T_X06));
                ay.a(this.mTitle, bkV, this.agO);
                ay.a(this.ahj, this.mTitle, bkV.bmY(), bkV, this.alP, this.alR, this.agO);
            }
            if (p(bkV)) {
                q(bkV);
            }
            setVoiceData(bkV);
            this.agr = aVar;
            if (this.agr.bkV().eQQ != null) {
                if (bkV.isShareThread) {
                    if (this.agr.bkV().eQQ != null) {
                        if (!this.agr.bkV().eQQ.eLl) {
                            this.alQ.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.5
                                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                                public void a(View view, String str, int i, boolean z, boolean z2) {
                                    ay.a(NewGridImageLayout.this.agr.bkV().eQQ, NewGridImageLayout.this.mContext, 2);
                                }
                            });
                        }
                    } else {
                        return;
                    }
                }
                if (!this.agr.bkV().eQQ.eLl) {
                    this.alQ.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.6
                        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                        public void a(View view, String str, int i, boolean z, boolean z2) {
                            ay.a(view, true, (List<MediaData>) NewGridImageLayout.this.alT, i, NewGridImageLayout.this.agr.bkV().eQQ.blX(), NewGridImageLayout.this.mFrom, NewGridImageLayout.this.agr.bkV().eQQ.eMk);
                        }
                    });
                }
                if (this.alR) {
                    if (this.agr.bkV().eQQ == null || this.agr.bkV().eQQ.eLl) {
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
            if (this.alR) {
                this.alm.am(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NewGridImageLayout.this.ags != null) {
                            NewGridImageLayout.this.ags.onClick(view);
                        }
                    }
                });
            }
            ArrayList<VoiceData.VoiceModel> bnK = (!bzVar.isShareThread || bzVar.eQQ == null) ? bzVar.bnK() : bzVar.eQQ.eMl;
            if (x.isEmpty(bnK)) {
                this.alm.setVisibility(8);
                this.alp = false;
                return;
            }
            this.alm.setVisibility(0);
            VoiceData.VoiceModel voiceModel = bnK.get(0);
            this.alm.setVoiceModel(voiceModel);
            this.alm.setTag(voiceModel);
            this.alm.btU();
            if (voiceModel != null) {
                this.alm.CX(voiceModel.voice_status.intValue());
            }
            this.alm.cbz();
            this.alp = true;
        }
    }

    public void setObjectPool(b<ImageView> bVar, b<GifView> bVar2) {
        if (this.alQ != null) {
            this.alQ.setObjectPool(bVar, bVar2);
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
        return this.ais;
    }

    public void setSubClickListener(aa<com.baidu.tbadk.core.data.a> aaVar) {
        this.ais = aaVar;
    }

    private boolean p(bz bzVar) {
        if (this.agr == null || this.agr.bkV() == null) {
            return true;
        }
        if (this.agr.bkV().getTid() == null || this.agr.bkV().getTid().equals(bzVar.getTid())) {
            return (!bzVar.isShareThread || bzVar.eQQ == null) ? !c(bzVar.bnG(), this.agr.bkV().bnG()) : this.agr.bkV().eQQ == null || !c(bzVar.eQQ.eMh, this.agr.bkV().eQQ.eMh);
        }
        return true;
    }

    private void q(bz bzVar) {
        boolean z;
        ArrayList<MediaData> arrayList;
        String b2;
        ArrayList<MediaData> bnG = bzVar.bnG();
        String bnh = bzVar.bnh();
        if (!bzVar.isShareThread || bzVar.eQQ == null) {
            z = false;
            arrayList = bnG;
        } else if (bzVar.eQQ.eLl) {
            this.alQ.setVisibility(8);
            return;
        } else {
            z = true;
            arrayList = bzVar.eQQ.eMh;
        }
        if (k.bkB().isShowImages() && x.getCount(arrayList) != 0) {
            this.alT.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                MediaData mediaData = (MediaData) x.getItem(arrayList, i);
                if (mediaData != null && mediaData.getType() == 3 && (z || (bnh != null && bnh.equals(mediaData.getPostId() + "")))) {
                    this.alT.add(mediaData);
                }
            }
            if (x.getCount(this.alT) > 0) {
                this.alo = true;
                this.alQ.setVisibility(0);
                ArrayList<TbRichTextImageInfo> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < this.alT.size(); i2++) {
                    MediaData mediaData2 = (MediaData) x.getItem(this.alT, i2);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.alT.size() > 1) {
                        b2 = a(mediaData2);
                    } else {
                        b2 = b(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.setSrc(b2);
                    tbRichTextImageInfo.DH(originalUrl);
                    tbRichTextImageInfo.lI(mediaData2.isLongPic());
                    if (mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(mediaData2.picWidth);
                        tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                    }
                    arrayList2.add(tbRichTextImageInfo);
                }
                this.alQ.setData(arrayList2);
                return;
            }
            this.alo = false;
            this.alQ.setVisibility(8);
            return;
        }
        this.alo = false;
        this.alQ.setVisibility(8);
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
        this.akY = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    public void setTransmit(boolean z) {
        this.alR = z;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.ags = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ags != null) {
            this.ags.onClick(view);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.alQ != null) {
            this.alQ.onChangeSkinType();
        }
        if (this.ajt != null) {
            this.ajt.onChangeSkinType(i);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.agO = z;
    }

    public void setFromForPb(int i) {
        this.ahf = i;
    }

    private boolean a(PollData pollData) {
        return (pollData == null || pollData.getOptions() == null || pollData.getOptions().size() <= 0) ? false : true;
    }
}

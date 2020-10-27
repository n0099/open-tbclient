package com.baidu.card.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.d.b;
import com.baidu.adp.lib.util.l;
import com.baidu.card.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes21.dex */
public class NewGridImageLayout extends LinearLayout implements View.OnClickListener, p<AbsThreadDataSupport> {
    private AbsThreadDataSupport afI;
    private View.OnClickListener afJ;
    private int agi;
    public TextView agm;
    private ab<AbsThreadDataSupport> ahv;
    public VoteView aiE;
    private boolean aik;
    private int akJ;
    protected boolean akL;
    private final int akZ;
    private boolean akk;
    public PlayVoiceBntNew akw;
    private boolean aky;
    private boolean akz;
    public GridImageLayout ala;
    private boolean alb;
    public boolean alc;
    private LinkedList<MediaData> ald;
    private com.baidu.tbadk.widget.richText.a ale;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;
    private static final int aku = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int agr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int akX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31);
    private static final int akY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
    private static final int akv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);

    public NewGridImageLayout(Context context) {
        this(context, null);
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akZ = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.akk = true;
        this.aky = false;
        this.akz = false;
        this.alb = false;
        this.alc = true;
        this.akJ = 0;
        this.akL = false;
        this.aik = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.agm = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.akw = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.akw.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<AbsThreadDataSupport> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, NewGridImageLayout.this.afI);
                }
            }
        });
        this.ala = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        com.baidu.tbadk.a.b.a.d(this.ala, R.dimen.tbds23, R.dimen.tbds14);
        this.ala.setSupportGifPlay(false);
        this.ala.setCornerStyle(1);
        this.ala.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<AbsThreadDataSupport> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    subClickListener.a(view, NewGridImageLayout.this.afI);
                }
            }
        });
        this.ale = new com.baidu.tbadk.widget.richText.a();
        int i = l.getScreenDimensions(this.mContext)[0];
        this.ale.fCj = i - l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds88);
        this.ale.fCk = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.ala.setLayoutStrategy(this.ale);
        this.ald = new LinkedList<>();
        this.ala.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.3
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i2, boolean z, boolean z2) {
                ay.a(view, NewGridImageLayout.this.ale.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.ald, i2, NewGridImageLayout.this.afI.bhz(), NewGridImageLayout.this.mFrom, true);
            }
        });
        this.aiE = (VoteView) findViewById(R.id.thread_card_vote);
        this.aiE.setBgColor(R.color.cp_bg_line_e);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setCornerStyle(int i) {
        this.ala.setCornerStyle(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(final AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bhz() != null) {
            bw bhz = absThreadDataSupport.bhz();
            OriginalThreadInfo originalThreadInfo = bhz.eAy;
            if (originalThreadInfo != null && this.alb) {
                this.agm.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.agm.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds15), 1.0f);
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setVisibility(8);
                if (originalThreadInfo.euX) {
                    ay.a(this.agm, this.mTitle, new SpannableString(originalThreadInfo.title), bhz, this.akZ, this.alb, this.aik);
                    ap.setViewTextColor(this.agm, R.color.cp_cont_c);
                } else {
                    ay.a(this.agm, this.mTitle, originalThreadInfo.evX, bhz, this.akZ, this.alb, this.aik);
                }
                if (a(originalThreadInfo.pollData)) {
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ay.a(absThreadDataSupport.bhz().eAy, NewGridImageLayout.this.mContext, NewGridImageLayout.this.agi);
                        }
                    };
                    this.aiE.setOnClickListener(onClickListener);
                    this.aiE.setOnItemClickListener(onClickListener);
                    this.aiE.setIsTransmit(true);
                    this.aiE.setData(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
                    this.aiE.setVisibility(0);
                } else {
                    this.aiE.setVisibility(8);
                }
            } else {
                this.aiE.setVisibility(8);
                this.agm.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                this.agm.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds17), 1.0f);
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                ay.a(this.mTitle, bhz, this.aik);
                ay.a(this.agm, this.mTitle, bhz.bjB(), bhz, this.akZ, this.alb, this.aik);
            }
            if (p(bhz)) {
                q(bhz);
            }
            setVoiceData(bhz);
            ua();
            this.afI = absThreadDataSupport;
            if (this.afI.bhz().eAy != null) {
                if (bhz.isShareThread) {
                    if (this.afI.bhz().eAy != null) {
                        if (!this.afI.bhz().eAy.euX) {
                            this.ala.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.5
                                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                                public void a(View view, String str, int i, boolean z, boolean z2) {
                                    ay.a(NewGridImageLayout.this.afI.bhz().eAy, NewGridImageLayout.this.mContext, 2);
                                }
                            });
                        }
                    } else {
                        return;
                    }
                }
                if (!this.afI.bhz().eAy.euX) {
                    this.ala.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.6
                        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                        public void a(View view, String str, int i, boolean z, boolean z2) {
                            ay.a(view, true, (List<MediaData>) NewGridImageLayout.this.ald, i, NewGridImageLayout.this.afI.bhz().eAy.biB(), NewGridImageLayout.this.mFrom, NewGridImageLayout.this.afI.bhz().eAy.evV);
                        }
                    });
                }
                if (this.alb) {
                    if (this.afI.bhz().eAy == null || this.afI.bhz().eAy.euX) {
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

    private void setVoiceData(bw bwVar) {
        if (bwVar != null) {
            if (this.alb) {
                this.akw.aj(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NewGridImageLayout.this.afJ != null) {
                            NewGridImageLayout.this.afJ.onClick(view);
                        }
                    }
                });
            }
            ArrayList<VoiceData.VoiceModel> bkn = (!bwVar.isShareThread || bwVar.eAy == null) ? bwVar.bkn() : bwVar.eAy.evW;
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
    }

    private void ua() {
        if (this.alb && this.alc) {
            if (this.agm.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
                if (this.aky) {
                    setMarginsTop(this.ala, 0);
                    setMarginsTop(this.akw, akX);
                    setMarginsTop(this.aiE, akX);
                    return;
                } else if (this.akz) {
                    setMarginsTop(this.ala, 0);
                    setMarginsTop(this.akw, 0);
                    setMarginsTop(this.aiE, akX);
                    return;
                } else {
                    setMarginsTop(this.ala, 0);
                    setMarginsTop(this.akw, 0);
                    setMarginsTop(this.aiE, 0);
                    return;
                }
            }
            setMarginsTop(this.ala, akY);
            setMarginsTop(this.akw, akX);
            setMarginsTop(this.aiE, akX);
        } else if (this.agm.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
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

    public void setObjectPool(b<ImageView> bVar, b<GifView> bVar2) {
        if (this.ala != null) {
            this.ala.setObjectPool(bVar, bVar2);
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

    private boolean p(bw bwVar) {
        if (this.afI == null || this.afI.bhz() == null) {
            return true;
        }
        if (this.afI.bhz().getTid() == null || this.afI.bhz().getTid().equals(bwVar.getTid())) {
            return (!bwVar.isShareThread || bwVar.eAy == null) ? !c(bwVar.bkj(), this.afI.bhz().bkj()) : this.afI.bhz().eAy == null || !c(bwVar.eAy.evS, this.afI.bhz().eAy.evS);
        }
        return true;
    }

    private void q(bw bwVar) {
        boolean z;
        ArrayList<MediaData> arrayList;
        String b;
        ArrayList<MediaData> bkj = bwVar.bkj();
        String bjK = bwVar.bjK();
        if (!bwVar.isShareThread || bwVar.eAy == null) {
            z = false;
            arrayList = bkj;
        } else if (bwVar.eAy.euX) {
            this.ala.setVisibility(8);
            return;
        } else {
            z = true;
            arrayList = bwVar.eAy.evS;
        }
        if (k.bhh().isShowImages() && y.getCount(arrayList) != 0) {
            this.ald.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(arrayList, i);
                if (mediaData != null && mediaData.getType() == 3 && (z || (bjK != null && bjK.equals(mediaData.getPostId() + "")))) {
                    this.ald.add(mediaData);
                }
            }
            if (y.getCount(this.ald) > 0) {
                this.aky = true;
                this.ala.setVisibility(0);
                ArrayList<TbRichTextImageInfo> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < this.ald.size(); i2++) {
                    MediaData mediaData2 = (MediaData) y.getItem(this.ald, i2);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.ald.size() > 1) {
                        b = a(mediaData2);
                    } else {
                        b = b(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.setSrc(b);
                    tbRichTextImageInfo.Et(originalUrl);
                    tbRichTextImageInfo.kM(mediaData2.isLongPic());
                    if (mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(mediaData2.picWidth);
                        tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                    }
                    arrayList2.add(tbRichTextImageInfo);
                }
                this.ala.setData(arrayList2);
                return;
            }
            this.aky = false;
            this.ala.setVisibility(8);
            return;
        }
        this.aky = false;
        this.ala.setVisibility(8);
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
        String b;
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
                b = a(mediaData2);
                str = a2;
            } else {
                String b2 = b(mediaData);
                b = b(mediaData2);
                str = b2;
            }
            if (str != b) {
                if (str == null || b == null) {
                    return false;
                }
                if (!str.equals(b)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setFromCDN(boolean z) {
        this.akk = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    public void setTransmit(boolean z) {
        this.alb = z;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.afJ = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.afJ != null) {
            this.afJ.onClick(view);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ala != null) {
            this.ala.onChangeSkinType();
        }
        if (this.aiE != null) {
            this.aiE.onChangeSkinType(i);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.aik = z;
    }

    public void setFromForPb(int i) {
        this.agi = i;
    }

    private boolean a(PollData pollData) {
        return (pollData == null || pollData.getOptions() == null || pollData.getOptions().size() <= 0) ? false : true;
    }
}

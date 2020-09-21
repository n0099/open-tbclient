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
import com.baidu.tieba.card.aa;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes20.dex */
public class NewGridImageLayout extends LinearLayout implements View.OnClickListener, p<AbsThreadDataSupport> {
    private int afP;
    public TextView afT;
    private AbsThreadDataSupport afq;
    private View.OnClickListener afr;
    private boolean ahR;
    private aa<AbsThreadDataSupport> ahd;
    public VoteView ail;
    private boolean ajR;
    private final int akG;
    public GridImageLayout akH;
    private boolean akI;
    public boolean akJ;
    private LinkedList<MediaData> akK;
    private com.baidu.tbadk.widget.richText.a akL;
    public PlayVoiceBntNew akd;
    private boolean akf;
    private boolean akg;
    private int akq;
    protected boolean aks;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;
    private static final int akb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int afY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int akE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31);
    private static final int akF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
    private static final int akc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);

    public NewGridImageLayout(Context context) {
        this(context, null);
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akG = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.ajR = true;
        this.akf = false;
        this.akg = false;
        this.akI = false;
        this.akJ = true;
        this.akq = 0;
        this.aks = false;
        this.ahR = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.afT = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.akd = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.akd.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, NewGridImageLayout.this.afq);
                }
            }
        });
        this.akH = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        com.baidu.tbadk.a.b.a.d(this.akH, R.dimen.tbds23, R.dimen.tbds14);
        this.akH.setSupportGifPlay(false);
        this.akH.setCornerStyle(1);
        this.akH.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    subClickListener.a(view, NewGridImageLayout.this.afq);
                }
            }
        });
        this.akL = new com.baidu.tbadk.widget.richText.a();
        int i = l.getScreenDimensions(this.mContext)[0];
        this.akL.fhx = i - l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds88);
        this.akL.fhy = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.akH.setLayoutStrategy(this.akL);
        this.akK = new LinkedList<>();
        this.akH.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.3
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i2, boolean z, boolean z2) {
                ay.a(view, NewGridImageLayout.this.akL.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.akK, i2, NewGridImageLayout.this.afq.bcY(), NewGridImageLayout.this.mFrom, true);
            }
        });
        this.ail = (VoteView) findViewById(R.id.thread_card_vote);
        this.ail.setBgColor(R.color.cp_bg_line_e);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setCornerStyle(int i) {
        this.akH.setCornerStyle(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void G(final AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bcY() != null) {
            bw bcY = absThreadDataSupport.bcY();
            OriginalThreadInfo originalThreadInfo = bcY.efS;
            if (originalThreadInfo != null && this.akI) {
                this.afT.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.afT.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds15), 1.0f);
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setVisibility(8);
                if (originalThreadInfo.eav) {
                    ay.a(this.afT, this.mTitle, new SpannableString(originalThreadInfo.title), bcY, this.akG, this.akI, this.ahR);
                    ap.setViewTextColor(this.afT, R.color.cp_cont_c);
                } else {
                    ay.a(this.afT, this.mTitle, originalThreadInfo.ebv, bcY, this.akG, this.akI, this.ahR);
                }
                if (a(originalThreadInfo.pollData)) {
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ay.a(absThreadDataSupport.bcY().efS, NewGridImageLayout.this.mContext, NewGridImageLayout.this.afP);
                        }
                    };
                    this.ail.setOnClickListener(onClickListener);
                    this.ail.setOnItemClickListener(onClickListener);
                    this.ail.setIsTransmit(true);
                    this.ail.setData(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
                    this.ail.setVisibility(0);
                } else {
                    this.ail.setVisibility(8);
                }
            } else {
                this.ail.setVisibility(8);
                this.afT.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                this.afT.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds17), 1.0f);
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                ay.a(this.mTitle, bcY, this.ahR);
                ay.a(this.afT, this.mTitle, bcY.beZ(), bcY, this.akG, this.akI, this.ahR);
            }
            if (p(bcY)) {
                q(bcY);
            }
            setVoiceData(bcY);
            ua();
            this.afq = absThreadDataSupport;
            if (this.afq.bcY().efS != null) {
                if (bcY.isShareThread) {
                    if (this.afq.bcY().efS != null) {
                        if (!this.afq.bcY().efS.eav) {
                            this.akH.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.5
                                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                                public void a(View view, String str, int i, boolean z, boolean z2) {
                                    ay.a(NewGridImageLayout.this.afq.bcY().efS, NewGridImageLayout.this.mContext, 2);
                                }
                            });
                        }
                    } else {
                        return;
                    }
                }
                if (!this.afq.bcY().efS.eav) {
                    this.akH.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.6
                        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                        public void a(View view, String str, int i, boolean z, boolean z2) {
                            ay.a(view, true, (List<MediaData>) NewGridImageLayout.this.akK, i, NewGridImageLayout.this.afq.bcY().efS.bdZ(), NewGridImageLayout.this.mFrom, NewGridImageLayout.this.afq.bcY().efS.ebt);
                        }
                    });
                }
                if (this.akI) {
                    if (this.afq.bcY().efS == null || this.afq.bcY().efS.eav) {
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
            if (this.akI) {
                this.akd.aj(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NewGridImageLayout.this.afr != null) {
                            NewGridImageLayout.this.afr.onClick(view);
                        }
                    }
                });
            }
            ArrayList<VoiceData.VoiceModel> bfL = (!bwVar.isShareThread || bwVar.efS == null) ? bwVar.bfL() : bwVar.efS.ebu;
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
    }

    private void ua() {
        if (this.akI && this.akJ) {
            if (this.afT.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
                if (this.akf) {
                    setMarginsTop(this.akH, 0);
                    setMarginsTop(this.akd, akE);
                    setMarginsTop(this.ail, akE);
                    return;
                } else if (this.akg) {
                    setMarginsTop(this.akH, 0);
                    setMarginsTop(this.akd, 0);
                    setMarginsTop(this.ail, akE);
                    return;
                } else {
                    setMarginsTop(this.akH, 0);
                    setMarginsTop(this.akd, 0);
                    setMarginsTop(this.ail, 0);
                    return;
                }
            }
            setMarginsTop(this.akH, akF);
            setMarginsTop(this.akd, akE);
            setMarginsTop(this.ail, akE);
        } else if (this.afT.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
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

    public void setObjectPool(b<ImageView> bVar, b<GifView> bVar2) {
        if (this.akH != null) {
            this.akH.setObjectPool(bVar, bVar2);
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

    private boolean p(bw bwVar) {
        if (this.afq == null || this.afq.bcY() == null) {
            return true;
        }
        if (this.afq.bcY().getTid() == null || this.afq.bcY().getTid().equals(bwVar.getTid())) {
            return (!bwVar.isShareThread || bwVar.efS == null) ? !c(bwVar.bfH(), this.afq.bcY().bfH()) : this.afq.bcY().efS == null || !c(bwVar.efS.ebq, this.afq.bcY().efS.ebq);
        }
        return true;
    }

    private void q(bw bwVar) {
        boolean z;
        ArrayList<MediaData> arrayList;
        String b;
        ArrayList<MediaData> bfH = bwVar.bfH();
        String bfi = bwVar.bfi();
        if (!bwVar.isShareThread || bwVar.efS == null) {
            z = false;
            arrayList = bfH;
        } else if (bwVar.efS.eav) {
            this.akH.setVisibility(8);
            return;
        } else {
            z = true;
            arrayList = bwVar.efS.ebq;
        }
        if (k.bcG().isShowImages() && y.getCount(arrayList) != 0) {
            this.akK.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(arrayList, i);
                if (mediaData != null && mediaData.getType() == 3 && (z || (bfi != null && bfi.equals(mediaData.getPostId() + "")))) {
                    this.akK.add(mediaData);
                }
            }
            if (y.getCount(this.akK) > 0) {
                this.akf = true;
                this.akH.setVisibility(0);
                ArrayList<TbRichTextImageInfo> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < this.akK.size(); i2++) {
                    MediaData mediaData2 = (MediaData) y.getItem(this.akK, i2);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.akK.size() > 1) {
                        b = a(mediaData2);
                    } else {
                        b = b(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.setSrc(b);
                    tbRichTextImageInfo.Do(originalUrl);
                    tbRichTextImageInfo.kb(mediaData2.isLongPic());
                    if (mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(mediaData2.picWidth);
                        tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                    }
                    arrayList2.add(tbRichTextImageInfo);
                }
                this.akH.setData(arrayList2);
                return;
            }
            this.akf = false;
            this.akH.setVisibility(8);
            return;
        }
        this.akf = false;
        this.akH.setVisibility(8);
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
                String a = a(mediaData);
                b = a(mediaData2);
                str = a;
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
        this.ajR = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    public void setTransmit(boolean z) {
        this.akI = z;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.afr = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.afr != null) {
            this.afr.onClick(view);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.akH != null) {
            this.akH.onChangeSkinType();
        }
        if (this.ail != null) {
            this.ail.onChangeSkinType(i);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahR = z;
    }

    public void setFromForPb(int i) {
        this.afP = i;
    }

    private boolean a(PollData pollData) {
        return (pollData == null || pollData.getOptions() == null || pollData.getOptions().size() <= 0) ? false : true;
    }
}

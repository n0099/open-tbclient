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
import com.baidu.card.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes8.dex */
public class NewGridImageLayout extends LinearLayout implements View.OnClickListener, n<AbsThreadDataSupport> {
    public TextView aeA;
    private AbsThreadDataSupport aea;
    private View.OnClickListener aeb;
    private int aew;
    private aa<AbsThreadDataSupport> afH;
    public VoteView agO;
    private boolean agw;
    private int aiG;
    protected boolean aiQ;
    private final int aiW;
    public GridImageLayout aiX;
    private boolean aiY;
    private LinkedList<MediaData> aiZ;
    private boolean aik;
    public PlayVoiceBntNew aiw;
    private boolean aiy;
    private boolean aiz;
    private com.baidu.tbadk.widget.richText.a aja;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;
    private static final int aiu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int aeF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int aiv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);

    public NewGridImageLayout(Context context) {
        this(context, null);
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiW = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.aik = true;
        this.aiy = false;
        this.aiz = false;
        this.aiY = false;
        this.aiG = 0;
        this.aiQ = false;
        this.agw = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aeA = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.aiw = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.aiw.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, NewGridImageLayout.this.aea);
                }
            }
        });
        this.aiX = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        this.aiX.setSupportGifPlay(false);
        this.aiX.setCornerStyle(1);
        this.aiX.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    subClickListener.a(view, NewGridImageLayout.this.aea);
                }
            }
        });
        this.aja = new com.baidu.tbadk.widget.richText.a();
        int i = l.getScreenDimensions(this.mContext)[0];
        this.aja.eNz = i - l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds88);
        this.aja.eNA = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.aiX.setLayoutStrategy(this.aja);
        this.aiZ = new LinkedList<>();
        this.aiX.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.3
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i2, boolean z, boolean z2) {
                aw.a(view, NewGridImageLayout.this.aja.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.aiZ, i2, NewGridImageLayout.this.aea.aPS(), NewGridImageLayout.this.mFrom, true);
            }
        });
        this.agO = (VoteView) findViewById(R.id.thread_card_vote);
        this.agO.setBgColor(R.color.cp_bg_line_e);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setCornerStyle(int i) {
        this.aiX.setCornerStyle(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(final AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.aPS() != null) {
            bu aPS = absThreadDataSupport.aPS();
            OriginalThreadInfo originalThreadInfo = aPS.dNX;
            if (originalThreadInfo != null && this.aiY) {
                this.aeA.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setVisibility(8);
                if (originalThreadInfo.dID) {
                    aw.a(this.aeA, this.mTitle, new SpannableString(originalThreadInfo.title), aPS, this.aiW, this.aiY, this.agw);
                    an.setViewTextColor(this.aeA, (int) R.color.cp_cont_c);
                } else {
                    aw.a(this.aeA, this.mTitle, originalThreadInfo.dJC, aPS, this.aiW, this.aiY, this.agw);
                }
                if (a(originalThreadInfo.pollData)) {
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            aw.a(absThreadDataSupport.aPS().dNX, NewGridImageLayout.this.mContext, NewGridImageLayout.this.aew);
                        }
                    };
                    this.agO.setOnClickListener(onClickListener);
                    this.agO.setOnItemClickListener(onClickListener);
                    this.agO.setIsTransmit(true);
                    this.agO.setData(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
                    this.agO.setVisibility(0);
                } else {
                    this.agO.setVisibility(8);
                }
            } else {
                this.agO.setVisibility(8);
                this.aeA.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                aw.a(this.mTitle, aPS, this.agw);
                aw.a(this.aeA, this.mTitle, aPS.aRQ(), aPS, this.aiW, this.aiY, this.agw);
            }
            if (o(aPS)) {
                p(aPS);
            }
            setVoiceData(aPS);
            sh();
            this.aea = absThreadDataSupport;
            if (this.aea.aPS().dNX != null) {
                if (aPS.isShareThread) {
                    if (this.aea.aPS().dNX != null) {
                        if (!this.aea.aPS().dNX.dID) {
                            this.aiX.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.5
                                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                                public void a(View view, String str, int i, boolean z, boolean z2) {
                                    aw.a(NewGridImageLayout.this.aea.aPS().dNX, NewGridImageLayout.this.mContext, 2);
                                }
                            });
                        }
                    } else {
                        return;
                    }
                }
                if (!this.aea.aPS().dNX.dID) {
                    this.aiX.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.6
                        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                        public void a(View view, String str, int i, boolean z, boolean z2) {
                            aw.a(view, true, (List<MediaData>) NewGridImageLayout.this.aiZ, i, NewGridImageLayout.this.aea.aPS().dNX.aQQ(), NewGridImageLayout.this.mFrom, NewGridImageLayout.this.aea.aPS().dNX.dJA);
                        }
                    });
                }
                if (this.aiY) {
                    if (this.aea.aPS().dNX == null || this.aea.aPS().dNX.dID) {
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

    private void setVoiceData(bu buVar) {
        if (buVar != null) {
            if (this.aiY) {
                this.aiw.ah(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NewGridImageLayout.this.aeb != null) {
                            NewGridImageLayout.this.aeb.onClick(view);
                        }
                    }
                });
            }
            ArrayList<VoiceData.VoiceModel> aSC = (!buVar.isShareThread || buVar.dNX == null) ? buVar.aSC() : buVar.dNX.dJB;
            if (w.isEmpty(aSC)) {
                this.aiw.setVisibility(8);
                this.aiz = false;
                return;
            }
            this.aiw.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aSC.get(0);
            this.aiw.setVoiceModel(voiceModel);
            this.aiw.setTag(voiceModel);
            this.aiw.aYi();
            if (voiceModel != null) {
                this.aiw.yU(voiceModel.voice_status.intValue());
            }
            this.aiw.bCo();
            this.aiz = true;
        }
    }

    private void sh() {
        if (this.aeA.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.aiy) {
                setMarginsTop(this.aiw, aiu);
            } else if (this.aiz) {
                setMarginsTop(this.aiw, aiv);
            }
        } else if (this.aiw != null && this.aiw.getLayoutParams() != null) {
            if (this.aiy) {
                setMarginsTop(this.aiw, aiu);
            } else if (this.aiz) {
                setMarginsTop(this.aiw, aeF);
            }
        }
    }

    public void setObjectPool(b<ImageView> bVar, b<GifView> bVar2) {
        if (this.aiX != null) {
            this.aiX.setObjectPool(bVar, bVar2);
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
        return this.afH;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.afH = aaVar;
    }

    private boolean o(bu buVar) {
        if (this.aea == null || this.aea.aPS() == null) {
            return true;
        }
        if (this.aea.aPS().getTid() == null || this.aea.aPS().getTid().equals(buVar.getTid())) {
            return (!buVar.isShareThread || buVar.dNX == null) ? !c(buVar.aSy(), this.aea.aPS().aSy()) : this.aea.aPS().dNX == null || !c(buVar.dNX.dJx, this.aea.aPS().dNX.dJx);
        }
        return true;
    }

    private void p(bu buVar) {
        boolean z;
        ArrayList<MediaData> arrayList;
        String b;
        ArrayList<MediaData> aSy = buVar.aSy();
        String aRZ = buVar.aRZ();
        if (!buVar.isShareThread || buVar.dNX == null) {
            z = false;
            arrayList = aSy;
        } else if (buVar.dNX.dID) {
            this.aiX.setVisibility(8);
            return;
        } else {
            z = true;
            arrayList = buVar.dNX.dJx;
        }
        if (k.aPA().isShowImages() && w.getCount(arrayList) != 0) {
            this.aiZ.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                MediaData mediaData = (MediaData) w.getItem(arrayList, i);
                if (mediaData != null && mediaData.getType() == 3 && (z || (aRZ != null && aRZ.equals(mediaData.getPostId() + "")))) {
                    this.aiZ.add(mediaData);
                }
            }
            if (w.getCount(this.aiZ) > 0) {
                this.aiX.setVisibility(0);
                ArrayList<TbRichTextImageInfo> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < this.aiZ.size(); i2++) {
                    MediaData mediaData2 = (MediaData) w.getItem(this.aiZ, i2);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.aiZ.size() > 1) {
                        b = a(mediaData2);
                    } else {
                        b = b(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.setSrc(b);
                    tbRichTextImageInfo.zu(originalUrl);
                    tbRichTextImageInfo.iV(mediaData2.isLongPic());
                    if (mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(mediaData2.picWidth);
                        tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                    }
                    arrayList2.add(tbRichTextImageInfo);
                }
                this.aiX.setData(arrayList2);
                return;
            }
            this.aiX.setVisibility(8);
            return;
        }
        this.aiX.setVisibility(8);
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
        this.aik = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    public void setTransmit(boolean z) {
        this.aiY = z;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.aeb = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aeb != null) {
            this.aeb.onClick(view);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aiX != null) {
            this.aiX.onChangeSkinType();
        }
        if (this.agO != null) {
            this.agO.onChangeSkinType(i);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.agw = z;
    }

    public void setFromForPb(int i) {
        this.aew = i;
    }

    private boolean a(PollData pollData) {
        return (pollData == null || pollData.getOptions() == null || pollData.getOptions().size() <= 0) ? false : true;
    }
}

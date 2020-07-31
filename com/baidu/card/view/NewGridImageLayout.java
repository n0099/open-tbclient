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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ax;
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
/* loaded from: classes15.dex */
public class NewGridImageLayout extends LinearLayout implements View.OnClickListener, n<AbsThreadDataSupport> {
    private AbsThreadDataSupport adQ;
    private View.OnClickListener adR;
    private int aem;
    public TextView aeq;
    private aa<AbsThreadDataSupport> afy;
    public VoteView agF;
    private boolean agn;
    protected boolean aiI;
    private final int aiQ;
    public GridImageLayout aiR;
    private boolean aiS;
    public boolean aiT;
    private LinkedList<MediaData> aiU;
    private com.baidu.tbadk.widget.richText.a aiV;
    private boolean aib;
    public PlayVoiceBntNew aio;
    private boolean aiq;
    private boolean air;
    private int aiy;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;
    private static final int aim = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int aev = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int aiO = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31);
    private static final int aiP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
    private static final int ain = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);

    public NewGridImageLayout(Context context) {
        this(context, null);
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiQ = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.aib = true;
        this.aiq = false;
        this.air = false;
        this.aiS = false;
        this.aiT = true;
        this.aiy = 0;
        this.aiI = false;
        this.agn = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.aeq = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.aio = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.aio.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, NewGridImageLayout.this.adQ);
                }
            }
        });
        this.aiR = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        com.baidu.tbadk.a.b.a.e(this.aiR, R.dimen.tbds23, R.dimen.tbds14);
        this.aiR.setSupportGifPlay(false);
        this.aiR.setCornerStyle(1);
        this.aiR.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    subClickListener.a(view, NewGridImageLayout.this.adQ);
                }
            }
        });
        this.aiV = new com.baidu.tbadk.widget.richText.a();
        int i = l.getScreenDimensions(this.mContext)[0];
        this.aiV.eTU = i - l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds88);
        this.aiV.eTV = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.aiR.setLayoutStrategy(this.aiV);
        this.aiU = new LinkedList<>();
        this.aiR.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.3
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i2, boolean z, boolean z2) {
                ax.a(view, NewGridImageLayout.this.aiV.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.aiU, i2, NewGridImageLayout.this.adQ.aTN(), NewGridImageLayout.this.mFrom, true);
            }
        });
        this.agF = (VoteView) findViewById(R.id.thread_card_vote);
        this.agF.setBgColor(R.color.cp_bg_line_e);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setCornerStyle(int i) {
        this.aiR.setCornerStyle(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(final AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null) {
            bv aTN = absThreadDataSupport.aTN();
            OriginalThreadInfo originalThreadInfo = aTN.dUi;
            if (originalThreadInfo != null && this.aiS) {
                this.aeq.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.aeq.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds15), 1.0f);
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setVisibility(8);
                if (originalThreadInfo.dOO) {
                    ax.a(this.aeq, this.mTitle, new SpannableString(originalThreadInfo.title), aTN, this.aiQ, this.aiS, this.agn);
                    ao.setViewTextColor(this.aeq, R.color.cp_cont_c);
                } else {
                    ax.a(this.aeq, this.mTitle, originalThreadInfo.dPO, aTN, this.aiQ, this.aiS, this.agn);
                }
                if (a(originalThreadInfo.pollData)) {
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ax.a(absThreadDataSupport.aTN().dUi, NewGridImageLayout.this.mContext, NewGridImageLayout.this.aem);
                        }
                    };
                    this.agF.setOnClickListener(onClickListener);
                    this.agF.setOnItemClickListener(onClickListener);
                    this.agF.setIsTransmit(true);
                    this.agF.setData(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
                    this.agF.setVisibility(0);
                } else {
                    this.agF.setVisibility(8);
                }
            } else {
                this.agF.setVisibility(8);
                this.aeq.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                this.aeq.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds17), 1.0f);
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                ax.a(this.mTitle, aTN, this.agn);
                ax.a(this.aeq, this.mTitle, aTN.aVM(), aTN, this.aiQ, this.aiS, this.agn);
            }
            if (o(aTN)) {
                p(aTN);
            }
            setVoiceData(aTN);
            sj();
            this.adQ = absThreadDataSupport;
            if (this.adQ.aTN().dUi != null) {
                if (aTN.isShareThread) {
                    if (this.adQ.aTN().dUi != null) {
                        if (!this.adQ.aTN().dUi.dOO) {
                            this.aiR.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.5
                                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                                public void a(View view, String str, int i, boolean z, boolean z2) {
                                    ax.a(NewGridImageLayout.this.adQ.aTN().dUi, NewGridImageLayout.this.mContext, 2);
                                }
                            });
                        }
                    } else {
                        return;
                    }
                }
                if (!this.adQ.aTN().dUi.dOO) {
                    this.aiR.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.6
                        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                        public void a(View view, String str, int i, boolean z, boolean z2) {
                            ax.a(view, true, (List<MediaData>) NewGridImageLayout.this.aiU, i, NewGridImageLayout.this.adQ.aTN().dUi.aUM(), NewGridImageLayout.this.mFrom, NewGridImageLayout.this.adQ.aTN().dUi.dPM);
                        }
                    });
                }
                if (this.aiS) {
                    if (this.adQ.aTN().dUi == null || this.adQ.aTN().dUi.dOO) {
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

    private void setVoiceData(bv bvVar) {
        if (bvVar != null) {
            if (this.aiS) {
                this.aio.ai(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NewGridImageLayout.this.adR != null) {
                            NewGridImageLayout.this.adR.onClick(view);
                        }
                    }
                });
            }
            ArrayList<VoiceData.VoiceModel> aWy = (!bvVar.isShareThread || bvVar.dUi == null) ? bvVar.aWy() : bvVar.dUi.dPN;
            if (x.isEmpty(aWy)) {
                this.aio.setVisibility(8);
                this.air = false;
                return;
            }
            this.aio.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aWy.get(0);
            this.aio.setVoiceModel(voiceModel);
            this.aio.setTag(voiceModel);
            this.aio.changeSkin();
            if (voiceModel != null) {
                this.aio.zt(voiceModel.voice_status.intValue());
            }
            this.aio.bFz();
            this.air = true;
        }
    }

    private void sj() {
        if (this.aiS && this.aiT) {
            if (this.aeq.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
                if (this.aiq) {
                    setMarginsTop(this.aiR, 0);
                    setMarginsTop(this.aio, aiO);
                    setMarginsTop(this.agF, aiO);
                    return;
                } else if (this.air) {
                    setMarginsTop(this.aiR, 0);
                    setMarginsTop(this.aio, 0);
                    setMarginsTop(this.agF, aiO);
                    return;
                } else {
                    setMarginsTop(this.aiR, 0);
                    setMarginsTop(this.aio, 0);
                    setMarginsTop(this.agF, 0);
                    return;
                }
            }
            setMarginsTop(this.aiR, aiP);
            setMarginsTop(this.aio, aiO);
            setMarginsTop(this.agF, aiO);
        } else if (this.aeq.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.aiq) {
                setMarginsTop(this.aio, aim);
            } else if (this.air) {
                setMarginsTop(this.aio, ain);
            }
        } else if (this.aio != null && this.aio.getLayoutParams() != null) {
            if (this.aiq) {
                setMarginsTop(this.aio, aim);
            } else if (this.air) {
                setMarginsTop(this.aio, aev);
            }
        }
    }

    public void setObjectPool(b<ImageView> bVar, b<GifView> bVar2) {
        if (this.aiR != null) {
            this.aiR.setObjectPool(bVar, bVar2);
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
        return this.afy;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.afy = aaVar;
    }

    private boolean o(bv bvVar) {
        if (this.adQ == null || this.adQ.aTN() == null) {
            return true;
        }
        if (this.adQ.aTN().getTid() == null || this.adQ.aTN().getTid().equals(bvVar.getTid())) {
            return (!bvVar.isShareThread || bvVar.dUi == null) ? !c(bvVar.aWu(), this.adQ.aTN().aWu()) : this.adQ.aTN().dUi == null || !c(bvVar.dUi.dPJ, this.adQ.aTN().dUi.dPJ);
        }
        return true;
    }

    private void p(bv bvVar) {
        boolean z;
        ArrayList<MediaData> arrayList;
        String b;
        ArrayList<MediaData> aWu = bvVar.aWu();
        String aVV = bvVar.aVV();
        if (!bvVar.isShareThread || bvVar.dUi == null) {
            z = false;
            arrayList = aWu;
        } else if (bvVar.dUi.dOO) {
            this.aiR.setVisibility(8);
            return;
        } else {
            z = true;
            arrayList = bvVar.dUi.dPJ;
        }
        if (k.aTv().isShowImages() && x.getCount(arrayList) != 0) {
            this.aiU.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                MediaData mediaData = (MediaData) x.getItem(arrayList, i);
                if (mediaData != null && mediaData.getType() == 3 && (z || (aVV != null && aVV.equals(mediaData.getPostId() + "")))) {
                    this.aiU.add(mediaData);
                }
            }
            if (x.getCount(this.aiU) > 0) {
                this.aiq = true;
                this.aiR.setVisibility(0);
                ArrayList<TbRichTextImageInfo> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < this.aiU.size(); i2++) {
                    MediaData mediaData2 = (MediaData) x.getItem(this.aiU, i2);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.aiU.size() > 1) {
                        b = a(mediaData2);
                    } else {
                        b = b(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.setSrc(b);
                    tbRichTextImageInfo.AC(originalUrl);
                    tbRichTextImageInfo.jA(mediaData2.isLongPic());
                    if (mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(mediaData2.picWidth);
                        tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                    }
                    arrayList2.add(tbRichTextImageInfo);
                }
                this.aiR.setData(arrayList2);
                return;
            }
            this.aiq = false;
            this.aiR.setVisibility(8);
            return;
        }
        this.aiq = false;
        this.aiR.setVisibility(8);
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
        this.aib = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    public void setTransmit(boolean z) {
        this.aiS = z;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.adR = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.adR != null) {
            this.adR.onClick(view);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aiR != null) {
            this.aiR.onChangeSkinType();
        }
        if (this.agF != null) {
            this.agF.onChangeSkinType(i);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.agn = z;
    }

    public void setFromForPb(int i) {
        this.aem = i;
    }

    private boolean a(PollData pollData) {
        return (pollData == null || pollData.getOptions() == null || pollData.getOptions().size() <= 0) ? false : true;
    }
}

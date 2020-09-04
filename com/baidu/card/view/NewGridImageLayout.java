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
import com.baidu.card.o;
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
/* loaded from: classes15.dex */
public class NewGridImageLayout extends LinearLayout implements View.OnClickListener, o<AbsThreadDataSupport> {
    private AbsThreadDataSupport aeY;
    private View.OnClickListener aeZ;
    public TextView afB;
    private int afx;
    private aa<AbsThreadDataSupport> agK;
    public VoteView ahQ;
    private boolean ahx;
    public PlayVoiceBntNew ajF;
    private boolean ajH;
    private boolean ajI;
    private int ajP;
    protected boolean ajZ;
    private boolean ajt;
    private final int akh;
    public GridImageLayout aki;
    private boolean akj;
    public boolean akk;
    private LinkedList<MediaData> akl;
    private com.baidu.tbadk.widget.richText.a akm;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;
    private static final int ajD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int afG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int akf = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31);
    private static final int akg = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
    private static final int ajE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);

    public NewGridImageLayout(Context context) {
        this(context, null);
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akh = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.ajt = true;
        this.ajH = false;
        this.ajI = false;
        this.akj = false;
        this.akk = true;
        this.ajP = 0;
        this.ajZ = false;
        this.ahx = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.afB = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.ajF = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.ajF.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, NewGridImageLayout.this.aeY);
                }
            }
        });
        this.aki = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        com.baidu.tbadk.a.b.a.d(this.aki, R.dimen.tbds23, R.dimen.tbds14);
        this.aki.setSupportGifPlay(false);
        this.aki.setCornerStyle(1);
        this.aki.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    subClickListener.a(view, NewGridImageLayout.this.aeY);
                }
            }
        });
        this.akm = new com.baidu.tbadk.widget.richText.a();
        int i = l.getScreenDimensions(this.mContext)[0];
        this.akm.feF = i - l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds88);
        this.akm.feG = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.aki.setLayoutStrategy(this.akm);
        this.akl = new LinkedList<>();
        this.aki.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.3
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i2, boolean z, boolean z2) {
                ay.a(view, NewGridImageLayout.this.akm.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.akl, i2, NewGridImageLayout.this.aeY.bce(), NewGridImageLayout.this.mFrom, true);
            }
        });
        this.ahQ = (VoteView) findViewById(R.id.thread_card_vote);
        this.ahQ.setBgColor(R.color.cp_bg_line_e);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setCornerStyle(int i) {
        this.aki.setCornerStyle(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(final AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bce() != null) {
            bw bce = absThreadDataSupport.bce();
            OriginalThreadInfo originalThreadInfo = bce.edI;
            if (originalThreadInfo != null && this.akj) {
                this.afB.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.afB.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds15), 1.0f);
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setVisibility(8);
                if (originalThreadInfo.dYl) {
                    ay.a(this.afB, this.mTitle, new SpannableString(originalThreadInfo.title), bce, this.akh, this.akj, this.ahx);
                    ap.setViewTextColor(this.afB, R.color.cp_cont_c);
                } else {
                    ay.a(this.afB, this.mTitle, originalThreadInfo.dZl, bce, this.akh, this.akj, this.ahx);
                }
                if (a(originalThreadInfo.pollData)) {
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ay.a(absThreadDataSupport.bce().edI, NewGridImageLayout.this.mContext, NewGridImageLayout.this.afx);
                        }
                    };
                    this.ahQ.setOnClickListener(onClickListener);
                    this.ahQ.setOnItemClickListener(onClickListener);
                    this.ahQ.setIsTransmit(true);
                    this.ahQ.setData(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
                    this.ahQ.setVisibility(0);
                } else {
                    this.ahQ.setVisibility(8);
                }
            } else {
                this.ahQ.setVisibility(8);
                this.afB.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                this.afB.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds17), 1.0f);
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                ay.a(this.mTitle, bce, this.ahx);
                ay.a(this.afB, this.mTitle, bce.bef(), bce, this.akh, this.akj, this.ahx);
            }
            if (o(bce)) {
                p(bce);
            }
            setVoiceData(bce);
            tU();
            this.aeY = absThreadDataSupport;
            if (this.aeY.bce().edI != null) {
                if (bce.isShareThread) {
                    if (this.aeY.bce().edI != null) {
                        if (!this.aeY.bce().edI.dYl) {
                            this.aki.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.5
                                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                                public void a(View view, String str, int i, boolean z, boolean z2) {
                                    ay.a(NewGridImageLayout.this.aeY.bce().edI, NewGridImageLayout.this.mContext, 2);
                                }
                            });
                        }
                    } else {
                        return;
                    }
                }
                if (!this.aeY.bce().edI.dYl) {
                    this.aki.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.6
                        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                        public void a(View view, String str, int i, boolean z, boolean z2) {
                            ay.a(view, true, (List<MediaData>) NewGridImageLayout.this.akl, i, NewGridImageLayout.this.aeY.bce().edI.bdf(), NewGridImageLayout.this.mFrom, NewGridImageLayout.this.aeY.bce().edI.dZj);
                        }
                    });
                }
                if (this.akj) {
                    if (this.aeY.bce().edI == null || this.aeY.bce().edI.dYl) {
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
            if (this.akj) {
                this.ajF.aj(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NewGridImageLayout.this.aeZ != null) {
                            NewGridImageLayout.this.aeZ.onClick(view);
                        }
                    }
                });
            }
            ArrayList<VoiceData.VoiceModel> beR = (!bwVar.isShareThread || bwVar.edI == null) ? bwVar.beR() : bwVar.edI.dZk;
            if (y.isEmpty(beR)) {
                this.ajF.setVisibility(8);
                this.ajI = false;
                return;
            }
            this.ajF.setVisibility(0);
            VoiceData.VoiceModel voiceModel = beR.get(0);
            this.ajF.setVoiceModel(voiceModel);
            this.ajF.setTag(voiceModel);
            this.ajF.changeSkin();
            if (voiceModel != null) {
                this.ajF.BM(voiceModel.voice_status.intValue());
            }
            this.ajF.bPf();
            this.ajI = true;
        }
    }

    private void tU() {
        if (this.akj && this.akk) {
            if (this.afB.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
                if (this.ajH) {
                    setMarginsTop(this.aki, 0);
                    setMarginsTop(this.ajF, akf);
                    setMarginsTop(this.ahQ, akf);
                    return;
                } else if (this.ajI) {
                    setMarginsTop(this.aki, 0);
                    setMarginsTop(this.ajF, 0);
                    setMarginsTop(this.ahQ, akf);
                    return;
                } else {
                    setMarginsTop(this.aki, 0);
                    setMarginsTop(this.ajF, 0);
                    setMarginsTop(this.ahQ, 0);
                    return;
                }
            }
            setMarginsTop(this.aki, akg);
            setMarginsTop(this.ajF, akf);
            setMarginsTop(this.ahQ, akf);
        } else if (this.afB.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.ajH) {
                setMarginsTop(this.ajF, ajD);
            } else if (this.ajI) {
                setMarginsTop(this.ajF, ajE);
            }
        } else if (this.ajF != null && this.ajF.getLayoutParams() != null) {
            if (this.ajH) {
                setMarginsTop(this.ajF, ajD);
            } else if (this.ajI) {
                setMarginsTop(this.ajF, afG);
            }
        }
    }

    public void setObjectPool(b<ImageView> bVar, b<GifView> bVar2) {
        if (this.aki != null) {
            this.aki.setObjectPool(bVar, bVar2);
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
        return this.agK;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.agK = aaVar;
    }

    private boolean o(bw bwVar) {
        if (this.aeY == null || this.aeY.bce() == null) {
            return true;
        }
        if (this.aeY.bce().getTid() == null || this.aeY.bce().getTid().equals(bwVar.getTid())) {
            return (!bwVar.isShareThread || bwVar.edI == null) ? !c(bwVar.beN(), this.aeY.bce().beN()) : this.aeY.bce().edI == null || !c(bwVar.edI.dZg, this.aeY.bce().edI.dZg);
        }
        return true;
    }

    private void p(bw bwVar) {
        boolean z;
        ArrayList<MediaData> arrayList;
        String b;
        ArrayList<MediaData> beN = bwVar.beN();
        String beo = bwVar.beo();
        if (!bwVar.isShareThread || bwVar.edI == null) {
            z = false;
            arrayList = beN;
        } else if (bwVar.edI.dYl) {
            this.aki.setVisibility(8);
            return;
        } else {
            z = true;
            arrayList = bwVar.edI.dZg;
        }
        if (k.bbM().isShowImages() && y.getCount(arrayList) != 0) {
            this.akl.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(arrayList, i);
                if (mediaData != null && mediaData.getType() == 3 && (z || (beo != null && beo.equals(mediaData.getPostId() + "")))) {
                    this.akl.add(mediaData);
                }
            }
            if (y.getCount(this.akl) > 0) {
                this.ajH = true;
                this.aki.setVisibility(0);
                ArrayList<TbRichTextImageInfo> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < this.akl.size(); i2++) {
                    MediaData mediaData2 = (MediaData) y.getItem(this.akl, i2);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.akl.size() > 1) {
                        b = a(mediaData2);
                    } else {
                        b = b(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.setSrc(b);
                    tbRichTextImageInfo.CS(originalUrl);
                    tbRichTextImageInfo.ka(mediaData2.isLongPic());
                    if (mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(mediaData2.picWidth);
                        tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                    }
                    arrayList2.add(tbRichTextImageInfo);
                }
                this.aki.setData(arrayList2);
                return;
            }
            this.ajH = false;
            this.aki.setVisibility(8);
            return;
        }
        this.ajH = false;
        this.aki.setVisibility(8);
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
        this.ajt = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    public void setTransmit(boolean z) {
        this.akj = z;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.aeZ = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aeZ != null) {
            this.aeZ.onClick(view);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aki != null) {
            this.aki.onChangeSkinType();
        }
        if (this.ahQ != null) {
            this.ahQ.onChangeSkinType(i);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahx = z;
    }

    public void setFromForPb(int i) {
        this.afx = i;
    }

    private boolean a(PollData pollData) {
        return (pollData == null || pollData.getOptions() == null || pollData.getOptions().size() <= 0) ? false : true;
    }
}

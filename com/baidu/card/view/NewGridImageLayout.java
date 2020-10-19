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
/* loaded from: classes21.dex */
public class NewGridImageLayout extends LinearLayout implements View.OnClickListener, p<AbsThreadDataSupport> {
    private AbsThreadDataSupport afH;
    private View.OnClickListener afI;
    private int agh;
    public TextView agl;
    private aa<AbsThreadDataSupport> ahu;
    public VoteView aiD;
    private boolean aij;
    private int akI;
    protected boolean akK;
    private final int akY;
    public GridImageLayout akZ;
    private boolean akj;
    public PlayVoiceBntNew akv;
    private boolean akx;
    private boolean aky;
    private boolean ala;
    public boolean alb;
    private LinkedList<MediaData> alc;
    private com.baidu.tbadk.widget.richText.a ald;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;
    private static final int akt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int agq = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int akW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31);
    private static final int akX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
    private static final int aku = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);

    public NewGridImageLayout(Context context) {
        this(context, null);
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akY = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.akj = true;
        this.akx = false;
        this.aky = false;
        this.ala = false;
        this.alb = true;
        this.akI = 0;
        this.akK = false;
        this.aij = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.agl = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.akv = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.akv.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, NewGridImageLayout.this.afH);
                }
            }
        });
        this.akZ = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        com.baidu.tbadk.a.b.a.d(this.akZ, R.dimen.tbds23, R.dimen.tbds14);
        this.akZ.setSupportGifPlay(false);
        this.akZ.setCornerStyle(1);
        this.akZ.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    subClickListener.a(view, NewGridImageLayout.this.afH);
                }
            }
        });
        this.ald = new com.baidu.tbadk.widget.richText.a();
        int i = l.getScreenDimensions(this.mContext)[0];
        this.ald.ftO = i - l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds88);
        this.ald.ftP = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.akZ.setLayoutStrategy(this.ald);
        this.alc = new LinkedList<>();
        this.akZ.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.3
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i2, boolean z, boolean z2) {
                ay.a(view, NewGridImageLayout.this.ald.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.alc, i2, NewGridImageLayout.this.afH.bfG(), NewGridImageLayout.this.mFrom, true);
            }
        });
        this.aiD = (VoteView) findViewById(R.id.thread_card_vote);
        this.aiD.setBgColor(R.color.cp_bg_line_e);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setCornerStyle(int i) {
        this.akZ.setCornerStyle(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(final AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bfG() != null) {
            bw bfG = absThreadDataSupport.bfG();
            OriginalThreadInfo originalThreadInfo = bfG.erY;
            if (originalThreadInfo != null && this.ala) {
                this.agl.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.agl.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds15), 1.0f);
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setVisibility(8);
                if (originalThreadInfo.emx) {
                    ay.a(this.agl, this.mTitle, new SpannableString(originalThreadInfo.title), bfG, this.akY, this.ala, this.aij);
                    ap.setViewTextColor(this.agl, R.color.cp_cont_c);
                } else {
                    ay.a(this.agl, this.mTitle, originalThreadInfo.enz, bfG, this.akY, this.ala, this.aij);
                }
                if (a(originalThreadInfo.pollData)) {
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ay.a(absThreadDataSupport.bfG().erY, NewGridImageLayout.this.mContext, NewGridImageLayout.this.agh);
                        }
                    };
                    this.aiD.setOnClickListener(onClickListener);
                    this.aiD.setOnItemClickListener(onClickListener);
                    this.aiD.setIsTransmit(true);
                    this.aiD.setData(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
                    this.aiD.setVisibility(0);
                } else {
                    this.aiD.setVisibility(8);
                }
            } else {
                this.aiD.setVisibility(8);
                this.agl.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                this.agl.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds17), 1.0f);
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                ay.a(this.mTitle, bfG, this.aij);
                ay.a(this.agl, this.mTitle, bfG.bhI(), bfG, this.akY, this.ala, this.aij);
            }
            if (p(bfG)) {
                q(bfG);
            }
            setVoiceData(bfG);
            ua();
            this.afH = absThreadDataSupport;
            if (this.afH.bfG().erY != null) {
                if (bfG.isShareThread) {
                    if (this.afH.bfG().erY != null) {
                        if (!this.afH.bfG().erY.emx) {
                            this.akZ.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.5
                                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                                public void a(View view, String str, int i, boolean z, boolean z2) {
                                    ay.a(NewGridImageLayout.this.afH.bfG().erY, NewGridImageLayout.this.mContext, 2);
                                }
                            });
                        }
                    } else {
                        return;
                    }
                }
                if (!this.afH.bfG().erY.emx) {
                    this.akZ.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.6
                        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                        public void a(View view, String str, int i, boolean z, boolean z2) {
                            ay.a(view, true, (List<MediaData>) NewGridImageLayout.this.alc, i, NewGridImageLayout.this.afH.bfG().erY.bgI(), NewGridImageLayout.this.mFrom, NewGridImageLayout.this.afH.bfG().erY.enx);
                        }
                    });
                }
                if (this.ala) {
                    if (this.afH.bfG().erY == null || this.afH.bfG().erY.emx) {
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
            if (this.ala) {
                this.akv.aj(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NewGridImageLayout.this.afI != null) {
                            NewGridImageLayout.this.afI.onClick(view);
                        }
                    }
                });
            }
            ArrayList<VoiceData.VoiceModel> biu = (!bwVar.isShareThread || bwVar.erY == null) ? bwVar.biu() : bwVar.erY.eny;
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
    }

    private void ua() {
        if (this.ala && this.alb) {
            if (this.agl.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
                if (this.akx) {
                    setMarginsTop(this.akZ, 0);
                    setMarginsTop(this.akv, akW);
                    setMarginsTop(this.aiD, akW);
                    return;
                } else if (this.aky) {
                    setMarginsTop(this.akZ, 0);
                    setMarginsTop(this.akv, 0);
                    setMarginsTop(this.aiD, akW);
                    return;
                } else {
                    setMarginsTop(this.akZ, 0);
                    setMarginsTop(this.akv, 0);
                    setMarginsTop(this.aiD, 0);
                    return;
                }
            }
            setMarginsTop(this.akZ, akX);
            setMarginsTop(this.akv, akW);
            setMarginsTop(this.aiD, akW);
        } else if (this.agl.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
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

    public void setObjectPool(b<ImageView> bVar, b<GifView> bVar2) {
        if (this.akZ != null) {
            this.akZ.setObjectPool(bVar, bVar2);
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

    private boolean p(bw bwVar) {
        if (this.afH == null || this.afH.bfG() == null) {
            return true;
        }
        if (this.afH.bfG().getTid() == null || this.afH.bfG().getTid().equals(bwVar.getTid())) {
            return (!bwVar.isShareThread || bwVar.erY == null) ? !c(bwVar.biq(), this.afH.bfG().biq()) : this.afH.bfG().erY == null || !c(bwVar.erY.ent, this.afH.bfG().erY.ent);
        }
        return true;
    }

    private void q(bw bwVar) {
        boolean z;
        ArrayList<MediaData> arrayList;
        String b;
        ArrayList<MediaData> biq = bwVar.biq();
        String bhR = bwVar.bhR();
        if (!bwVar.isShareThread || bwVar.erY == null) {
            z = false;
            arrayList = biq;
        } else if (bwVar.erY.emx) {
            this.akZ.setVisibility(8);
            return;
        } else {
            z = true;
            arrayList = bwVar.erY.ent;
        }
        if (k.bfo().isShowImages() && y.getCount(arrayList) != 0) {
            this.alc.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(arrayList, i);
                if (mediaData != null && mediaData.getType() == 3 && (z || (bhR != null && bhR.equals(mediaData.getPostId() + "")))) {
                    this.alc.add(mediaData);
                }
            }
            if (y.getCount(this.alc) > 0) {
                this.akx = true;
                this.akZ.setVisibility(0);
                ArrayList<TbRichTextImageInfo> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < this.alc.size(); i2++) {
                    MediaData mediaData2 = (MediaData) y.getItem(this.alc, i2);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.alc.size() > 1) {
                        b = a(mediaData2);
                    } else {
                        b = b(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.setSrc(b);
                    tbRichTextImageInfo.Ea(originalUrl);
                    tbRichTextImageInfo.kz(mediaData2.isLongPic());
                    if (mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(mediaData2.picWidth);
                        tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                    }
                    arrayList2.add(tbRichTextImageInfo);
                }
                this.akZ.setData(arrayList2);
                return;
            }
            this.akx = false;
            this.akZ.setVisibility(8);
            return;
        }
        this.akx = false;
        this.akZ.setVisibility(8);
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
        this.akj = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    public void setTransmit(boolean z) {
        this.ala = z;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.afI = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.afI != null) {
            this.afI.onClick(view);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.akZ != null) {
            this.akZ.onChangeSkinType();
        }
        if (this.aiD != null) {
            this.aiD.onChangeSkinType(i);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.aij = z;
    }

    public void setFromForPb(int i) {
        this.agh = i;
    }

    private boolean a(PollData pollData) {
        return (pollData == null || pollData.getOptions() == null || pollData.getOptions().size() <= 0) ? false : true;
    }
}

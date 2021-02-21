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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
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
/* loaded from: classes.dex */
public class NewGridImageLayout extends LinearLayout implements View.OnClickListener, p<com.baidu.tbadk.core.data.a> {
    private boolean agD;
    private int agU;
    public TextView agY;
    private com.baidu.tbadk.core.data.a agj;
    private View.OnClickListener agk;
    private ab<com.baidu.tbadk.core.data.a> aig;
    public VoteView aji;
    private boolean akO;
    private final int alF;
    public GridImageLayout alG;
    private boolean alH;
    public boolean alI;
    private LinkedList<MediaData> alJ;
    private com.baidu.tbadk.widget.richText.a alK;
    public PlayVoiceBntNew alb;
    private boolean ald;
    private boolean ale;
    private int alp;
    protected boolean alr;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;
    private static final int akY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int akZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int alD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31);
    private static final int alE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
    private static final int ala = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int M_H_X004 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);

    public NewGridImageLayout(Context context) {
        this(context, null);
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alF = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.akO = true;
        this.ald = false;
        this.ale = false;
        this.alH = false;
        this.alI = true;
        this.alp = 0;
        this.alr = false;
        this.agD = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.agY = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.alb = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.alb.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, NewGridImageLayout.this.agj);
                }
            }
        });
        this.alG = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        this.alG.setSupportGifPlay(false);
        this.alG.setCornerStyle(1);
        this.alG.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    subClickListener.a(view, NewGridImageLayout.this.agj);
                }
            }
        });
        this.alK = new com.baidu.tbadk.widget.richText.a();
        int i = l.getScreenDimensions(this.mContext)[0];
        this.alK.fWz = i - (l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004) * 2);
        this.alK.fWA = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.alG.setLayoutStrategy(this.alK);
        this.alJ = new LinkedList<>();
        this.alG.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.3
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i2, boolean z, boolean z2) {
                az.a(view, NewGridImageLayout.this.alK.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.alJ, i2, NewGridImageLayout.this.agj.bln(), NewGridImageLayout.this.mFrom, true);
            }
        });
        this.aji = (VoteView) findViewById(R.id.thread_card_vote);
        this.aji.setBgColor(R.color.CAM_X0207);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setCornerStyle(int i) {
        this.alG.setCornerStyle(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void C(final com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.bln() != null) {
            cb bln = aVar.bln();
            OriginalThreadInfo originalThreadInfo = bln.eTc;
            if (originalThreadInfo != null && this.alH) {
                setMarginsTop(this.alG, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                c.br(this.agY).oa(R.string.F_X01).nZ(R.dimen.T_X07);
                c.br(this.mTitle).nZ(R.dimen.T_X07);
                this.mTitle.setVisibility(8);
                if (originalThreadInfo.eNx) {
                    az.a(this.agY, this.mTitle, new SpannableString(originalThreadInfo.title), bln, this.alF, this.alH, this.agD);
                    ap.setViewTextColor(this.agY, R.color.CAM_X0108);
                } else {
                    az.a(this.agY, this.mTitle, originalThreadInfo.eOy, bln, this.alF, this.alH, this.agD);
                }
                if (a(originalThreadInfo.pollData)) {
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            az.a(aVar.bln().eTc, NewGridImageLayout.this.mContext, NewGridImageLayout.this.agU);
                        }
                    };
                    this.aji.setOnClickListener(onClickListener);
                    this.aji.setOnItemClickListener(onClickListener);
                    this.aji.setIsTransmit(true);
                    this.aji.setData(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
                    this.aji.setVisibility(0);
                } else {
                    this.aji.setVisibility(8);
                }
            } else {
                setMarginsTop(this.alG, UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
                this.aji.setVisibility(8);
                this.agY.setTextSize(0, l.getDimens(this.mContext, R.dimen.T_X06));
                this.agY.setLineSpacing(l.getDimens(this.mContext, R.dimen.M_T_X002), 1.0f);
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.T_X06));
                az.a(this.mTitle, bln, this.agD);
                az.a(this.agY, this.mTitle, bln.bnr(), bln, this.alF, this.alH, this.agD);
            }
            if (p(bln)) {
                q(bln);
            }
            setVoiceData(bln);
            this.agj = aVar;
            if (this.agj.bln().eTc != null) {
                if (bln.isShareThread) {
                    if (this.agj.bln().eTc != null) {
                        if (!this.agj.bln().eTc.eNx) {
                            this.alG.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.5
                                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                                public void a(View view, String str, int i, boolean z, boolean z2) {
                                    az.a(NewGridImageLayout.this.agj.bln().eTc, NewGridImageLayout.this.mContext, 2);
                                }
                            });
                        }
                    } else {
                        return;
                    }
                }
                if (!this.agj.bln().eTc.eNx) {
                    this.alG.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.6
                        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                        public void a(View view, String str, int i, boolean z, boolean z2) {
                            az.a(view, true, (List<MediaData>) NewGridImageLayout.this.alJ, i, NewGridImageLayout.this.agj.bln().eTc.bmq(), NewGridImageLayout.this.mFrom, NewGridImageLayout.this.agj.bln().eTc.eOw);
                        }
                    });
                }
                if (this.alH) {
                    if (this.agj.bln().eTc == null || this.agj.bln().eTc.eNx) {
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

    private void setVoiceData(cb cbVar) {
        if (cbVar != null) {
            if (this.alH) {
                this.alb.am(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NewGridImageLayout.this.agk != null) {
                            NewGridImageLayout.this.agk.onClick(view);
                        }
                    }
                });
            }
            ArrayList<VoiceData.VoiceModel> bod = (!cbVar.isShareThread || cbVar.eTc == null) ? cbVar.bod() : cbVar.eTc.eOx;
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
    }

    public void setObjectPool(b<ImageView> bVar, b<GifView> bVar2) {
        if (this.alG != null) {
            this.alG.setObjectPool(bVar, bVar2);
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

    public ab<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.aig;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.aig = abVar;
    }

    private boolean p(cb cbVar) {
        if (this.agj == null || this.agj.bln() == null) {
            return true;
        }
        if (this.agj.bln().getTid() == null || this.agj.bln().getTid().equals(cbVar.getTid())) {
            return (!cbVar.isShareThread || cbVar.eTc == null) ? !c(cbVar.bnZ(), this.agj.bln().bnZ()) : this.agj.bln().eTc == null || !c(cbVar.eTc.eOt, this.agj.bln().eTc.eOt);
        }
        return true;
    }

    private void q(cb cbVar) {
        boolean z;
        ArrayList<MediaData> arrayList;
        String b2;
        ArrayList<MediaData> bnZ = cbVar.bnZ();
        String bnA = cbVar.bnA();
        if (!cbVar.isShareThread || cbVar.eTc == null) {
            z = false;
            arrayList = bnZ;
        } else if (cbVar.eTc.eNx) {
            this.alG.setVisibility(8);
            return;
        } else {
            z = true;
            arrayList = cbVar.eTc.eOt;
        }
        if (k.bkT().isShowImages() && y.getCount(arrayList) != 0) {
            this.alJ.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(arrayList, i);
                if (mediaData != null && mediaData.getType() == 3 && (z || (bnA != null && bnA.equals(mediaData.getPostId() + "")))) {
                    this.alJ.add(mediaData);
                }
            }
            if (y.getCount(this.alJ) > 0) {
                this.ald = true;
                this.alG.setVisibility(0);
                ArrayList<TbRichTextImageInfo> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < this.alJ.size(); i2++) {
                    MediaData mediaData2 = (MediaData) y.getItem(this.alJ, i2);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.alJ.size() > 1) {
                        b2 = a(mediaData2);
                    } else {
                        b2 = b(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.setSrc(b2);
                    tbRichTextImageInfo.Eb(originalUrl);
                    tbRichTextImageInfo.lM(mediaData2.isLongPic());
                    if (mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(mediaData2.picWidth);
                        tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                    }
                    arrayList2.add(tbRichTextImageInfo);
                }
                this.alG.setData(arrayList2);
                return;
            }
            this.ald = false;
            this.alG.setVisibility(8);
            return;
        }
        this.ald = false;
        this.alG.setVisibility(8);
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
        this.akO = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    public void setTransmit(boolean z) {
        this.alH = z;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.agk = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.agk != null) {
            this.agk.onClick(view);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.alG != null) {
            this.alG.onChangeSkinType();
        }
        if (this.aji != null) {
            this.aji.onChangeSkinType(i);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.agD = z;
    }

    public void setFromForPb(int i) {
        this.agU = i;
    }

    private boolean a(PollData pollData) {
        return (pollData == null || pollData.getOptions() == null || pollData.getOptions().size() <= 0) ? false : true;
    }
}

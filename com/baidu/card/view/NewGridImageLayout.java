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
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.by;
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
/* loaded from: classes21.dex */
public class NewGridImageLayout extends LinearLayout implements View.OnClickListener, p<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a agJ;
    private View.OnClickListener agK;
    private int ahl;
    public TextView ahp;
    private ab<com.baidu.tbadk.core.data.a> aix;
    public VoteView ajI;
    private boolean ajm;
    public PlayVoiceBntNew alB;
    private boolean alD;
    private boolean alE;
    private int alO;
    protected boolean alQ;
    private boolean alo;
    private final int ame;
    public GridImageLayout amf;
    private boolean amg;
    public boolean amh;
    private LinkedList<MediaData> ami;
    private com.baidu.tbadk.widget.richText.a amj;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;
    private static final int aly = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int alz = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int amc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31);
    private static final int amd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
    private static final int alA = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int M_H_X004 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);

    public NewGridImageLayout(Context context) {
        this(context, null);
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ame = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (d.bkA() ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.alo = true;
        this.alD = false;
        this.alE = false;
        this.amg = false;
        this.amh = true;
        this.alO = 0;
        this.alQ = false;
        this.ajm = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ahp = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.alB = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.alB.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, NewGridImageLayout.this.agJ);
                }
            }
        });
        this.amf = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        this.amf.setSupportGifPlay(false);
        this.amf.setCornerStyle(1);
        this.amf.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    subClickListener.a(view, NewGridImageLayout.this.agJ);
                }
            }
        });
        this.amj = new com.baidu.tbadk.widget.richText.a();
        this.amj.fPo = l.getScreenDimensions(this.mContext)[0] - (d.bkA() ? l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X007) * 2 : l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004) * 2);
        this.amj.fPp = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.amf.setLayoutStrategy(this.amj);
        this.ami = new LinkedList<>();
        this.amf.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.3
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i, boolean z, boolean z2) {
                az.a(view, NewGridImageLayout.this.amj.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.ami, i, NewGridImageLayout.this.agJ.bmn(), NewGridImageLayout.this.mFrom, true);
            }
        });
        this.ajI = (VoteView) findViewById(R.id.thread_card_vote);
        this.ajI.setBgColor(R.color.CAM_X0207);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setCornerStyle(int i) {
        this.amf.setCornerStyle(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(final com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.bmn() != null) {
            by bmn = aVar.bmn();
            OriginalThreadInfo originalThreadInfo = bmn.eLH;
            if (originalThreadInfo != null && this.amg) {
                setMarginsTop(this.amf, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                c.bm(this.ahp).pu(R.string.F_X01).pt(R.dimen.T_X07);
                c.bm(this.mTitle).pt(R.dimen.T_X07);
                this.mTitle.setVisibility(8);
                if (originalThreadInfo.eGg) {
                    az.a(this.ahp, this.mTitle, new SpannableString(originalThreadInfo.title), bmn, this.ame, this.amg, this.ajm);
                    ap.setViewTextColor(this.ahp, R.color.CAM_X0108);
                } else {
                    az.a(this.ahp, this.mTitle, originalThreadInfo.eHg, bmn, this.ame, this.amg, this.ajm);
                }
                if (a(originalThreadInfo.pollData)) {
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            az.a(aVar.bmn().eLH, NewGridImageLayout.this.mContext, NewGridImageLayout.this.ahl);
                        }
                    };
                    this.ajI.setOnClickListener(onClickListener);
                    this.ajI.setOnItemClickListener(onClickListener);
                    this.ajI.setIsTransmit(true);
                    this.ajI.setData(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
                    this.ajI.setVisibility(0);
                } else {
                    this.ajI.setVisibility(8);
                }
            } else {
                setMarginsTop(this.amf, UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
                this.ajI.setVisibility(8);
                this.ahp.setTextSize(0, l.getDimens(this.mContext, R.dimen.T_X06));
                this.ahp.setLineSpacing(l.getDimens(this.mContext, R.dimen.M_T_X002), 1.0f);
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.T_X06));
                az.a(this.mTitle, bmn, this.ajm);
                az.a(this.ahp, this.mTitle, bmn.boq(), bmn, this.ame, this.amg, this.ajm);
            }
            if (p(bmn)) {
                q(bmn);
            }
            setVoiceData(bmn);
            this.agJ = aVar;
            if (this.agJ.bmn().eLH != null) {
                if (bmn.isShareThread) {
                    if (this.agJ.bmn().eLH != null) {
                        if (!this.agJ.bmn().eLH.eGg) {
                            this.amf.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.5
                                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                                public void a(View view, String str, int i, boolean z, boolean z2) {
                                    az.a(NewGridImageLayout.this.agJ.bmn().eLH, NewGridImageLayout.this.mContext, 2);
                                }
                            });
                        }
                    } else {
                        return;
                    }
                }
                if (!this.agJ.bmn().eLH.eGg) {
                    this.amf.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.6
                        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                        public void a(View view, String str, int i, boolean z, boolean z2) {
                            az.a(view, true, (List<MediaData>) NewGridImageLayout.this.ami, i, NewGridImageLayout.this.agJ.bmn().eLH.bnq(), NewGridImageLayout.this.mFrom, NewGridImageLayout.this.agJ.bmn().eLH.eHe);
                        }
                    });
                }
                if (this.amg) {
                    if (this.agJ.bmn().eLH == null || this.agJ.bmn().eLH.eGg) {
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

    private void setVoiceData(by byVar) {
        if (byVar != null) {
            if (this.amg) {
                this.alB.ak(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NewGridImageLayout.this.agK != null) {
                            NewGridImageLayout.this.agK.onClick(view);
                        }
                    }
                });
            }
            ArrayList<VoiceData.VoiceModel> bpc = (!byVar.isShareThread || byVar.eLH == null) ? byVar.bpc() : byVar.eLH.eHf;
            if (y.isEmpty(bpc)) {
                this.alB.setVisibility(8);
                this.alE = false;
                return;
            }
            this.alB.setVisibility(0);
            VoiceData.VoiceModel voiceModel = bpc.get(0);
            this.alB.setVoiceModel(voiceModel);
            this.alB.setTag(voiceModel);
            this.alB.bvs();
            if (voiceModel != null) {
                this.alB.EM(voiceModel.voice_status.intValue());
            }
            this.alB.ccz();
            this.alE = true;
        }
    }

    public void setObjectPool(b<ImageView> bVar, b<GifView> bVar2) {
        if (this.amf != null) {
            this.amf.setObjectPool(bVar, bVar2);
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
        return this.aix;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.aix = abVar;
    }

    private boolean p(by byVar) {
        if (this.agJ == null || this.agJ.bmn() == null) {
            return true;
        }
        if (this.agJ.bmn().getTid() == null || this.agJ.bmn().getTid().equals(byVar.getTid())) {
            return (!byVar.isShareThread || byVar.eLH == null) ? !c(byVar.boY(), this.agJ.bmn().boY()) : this.agJ.bmn().eLH == null || !c(byVar.eLH.eHb, this.agJ.bmn().eLH.eHb);
        }
        return true;
    }

    private void q(by byVar) {
        boolean z;
        ArrayList<MediaData> arrayList;
        String b;
        ArrayList<MediaData> boY = byVar.boY();
        String boz = byVar.boz();
        if (!byVar.isShareThread || byVar.eLH == null) {
            z = false;
            arrayList = boY;
        } else if (byVar.eLH.eGg) {
            this.amf.setVisibility(8);
            return;
        } else {
            z = true;
            arrayList = byVar.eLH.eHb;
        }
        if (k.blV().isShowImages() && y.getCount(arrayList) != 0) {
            this.ami.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(arrayList, i);
                if (mediaData != null && mediaData.getType() == 3 && (z || (boz != null && boz.equals(mediaData.getPostId() + "")))) {
                    this.ami.add(mediaData);
                }
            }
            if (y.getCount(this.ami) > 0) {
                this.alD = true;
                this.amf.setVisibility(0);
                ArrayList<TbRichTextImageInfo> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < this.ami.size(); i2++) {
                    MediaData mediaData2 = (MediaData) y.getItem(this.ami, i2);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.ami.size() > 1) {
                        b = a(mediaData2);
                    } else {
                        b = b(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.setSrc(b);
                    tbRichTextImageInfo.EW(originalUrl);
                    tbRichTextImageInfo.lq(mediaData2.isLongPic());
                    if (mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(mediaData2.picWidth);
                        tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                    }
                    arrayList2.add(tbRichTextImageInfo);
                }
                this.amf.setData(arrayList2);
                return;
            }
            this.alD = false;
            this.amf.setVisibility(8);
            return;
        }
        this.alD = false;
        this.amf.setVisibility(8);
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
        this.alo = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    public void setTransmit(boolean z) {
        this.amg = z;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.agK = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.agK != null) {
            this.agK.onClick(view);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.amf != null) {
            this.amf.onChangeSkinType();
        }
        if (this.ajI != null) {
            this.ajI.onChangeSkinType(i);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.ajm = z;
    }

    public void setFromForPb(int i) {
        this.ahl = i;
    }

    private boolean a(PollData pollData) {
        return (pollData == null || pollData.getOptions() == null || pollData.getOptions().size() <= 0) ? false : true;
    }
}

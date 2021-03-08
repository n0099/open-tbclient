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
    private com.baidu.tbadk.core.data.a ahB;
    private View.OnClickListener ahC;
    private boolean ahV;
    private int ain;
    public TextView air;
    private ab<com.baidu.tbadk.core.data.a> ajy;
    public VoteView akA;
    private int amH;
    protected boolean amJ;
    private final int amX;
    public GridImageLayout amY;
    private boolean amZ;
    private boolean amh;
    public PlayVoiceBntNew amu;
    private boolean amw;
    private boolean amx;
    public boolean ana;
    private LinkedList<MediaData> anb;
    private com.baidu.tbadk.widget.richText.a anc;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;
    private static final int amr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int ams = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int amV = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31);
    private static final int amW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
    private static final int amt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int M_H_X004 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);

    public NewGridImageLayout(Context context) {
        this(context, null);
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amX = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - ((l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.amh = true;
        this.amw = false;
        this.amx = false;
        this.amZ = false;
        this.ana = true;
        this.amH = 0;
        this.amJ = false;
        this.ahV = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.air = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.amu = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.amu.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, NewGridImageLayout.this.ahB);
                }
            }
        });
        this.amY = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        this.amY.setSupportGifPlay(false);
        this.amY.setCornerStyle(1);
        this.amY.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    subClickListener.a(view, NewGridImageLayout.this.ahB);
                }
            }
        });
        this.anc = new com.baidu.tbadk.widget.richText.a();
        int i = l.getScreenDimensions(this.mContext)[0];
        this.anc.fXZ = i - (l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004) * 2);
        this.anc.fYa = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.amY.setLayoutStrategy(this.anc);
        this.anb = new LinkedList<>();
        this.amY.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.3
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i2, boolean z, boolean z2) {
                az.a(view, NewGridImageLayout.this.anc.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.anb, i2, NewGridImageLayout.this.ahB.blp(), NewGridImageLayout.this.mFrom, true);
            }
        });
        this.akA = (VoteView) findViewById(R.id.thread_card_vote);
        this.akA.setBgColor(R.color.CAM_X0207);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setCornerStyle(int i) {
        this.amY.setCornerStyle(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void E(final com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.blp() != null) {
            cb blp = aVar.blp();
            OriginalThreadInfo originalThreadInfo = blp.eUD;
            if (originalThreadInfo != null && this.amZ) {
                setMarginsTop(this.amY, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                c.br(this.air).ob(R.string.F_X01).oa(R.dimen.T_X07);
                c.br(this.mTitle).oa(R.dimen.T_X07);
                this.mTitle.setVisibility(8);
                if (originalThreadInfo.eOY) {
                    az.a(this.air, this.mTitle, new SpannableString(originalThreadInfo.title), blp, this.amX, this.amZ, this.ahV);
                    ap.setViewTextColor(this.air, R.color.CAM_X0108);
                } else {
                    az.a(this.air, this.mTitle, originalThreadInfo.ePZ, blp, this.amX, this.amZ, this.ahV);
                }
                if (a(originalThreadInfo.pollData)) {
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            az.a(aVar.blp().eUD, NewGridImageLayout.this.mContext, NewGridImageLayout.this.ain);
                        }
                    };
                    this.akA.setOnClickListener(onClickListener);
                    this.akA.setOnItemClickListener(onClickListener);
                    this.akA.setIsTransmit(true);
                    this.akA.setData(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
                    this.akA.setVisibility(0);
                } else {
                    this.akA.setVisibility(8);
                }
            } else {
                setMarginsTop(this.amY, UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
                this.akA.setVisibility(8);
                this.air.setTextSize(0, l.getDimens(this.mContext, R.dimen.T_X06));
                this.air.setLineSpacing(l.getDimens(this.mContext, R.dimen.M_T_X002), 1.0f);
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.T_X06));
                az.a(this.mTitle, blp, this.ahV);
                az.a(this.air, this.mTitle, blp.bnt(), blp, this.amX, this.amZ, this.ahV);
            }
            if (p(blp)) {
                q(blp);
            }
            setVoiceData(blp);
            this.ahB = aVar;
            if (this.ahB.blp().eUD != null) {
                if (blp.isShareThread) {
                    if (this.ahB.blp().eUD != null) {
                        if (!this.ahB.blp().eUD.eOY) {
                            this.amY.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.5
                                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                                public void a(View view, String str, int i, boolean z, boolean z2) {
                                    az.a(NewGridImageLayout.this.ahB.blp().eUD, NewGridImageLayout.this.mContext, 2);
                                }
                            });
                        }
                    } else {
                        return;
                    }
                }
                if (!this.ahB.blp().eUD.eOY) {
                    this.amY.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.6
                        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                        public void a(View view, String str, int i, boolean z, boolean z2) {
                            az.a(view, true, (List<MediaData>) NewGridImageLayout.this.anb, i, NewGridImageLayout.this.ahB.blp().eUD.bms(), NewGridImageLayout.this.mFrom, NewGridImageLayout.this.ahB.blp().eUD.ePX);
                        }
                    });
                }
                if (this.amZ) {
                    if (this.ahB.blp().eUD == null || this.ahB.blp().eUD.eOY) {
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
            if (this.amZ) {
                this.amu.an(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NewGridImageLayout.this.ahC != null) {
                            NewGridImageLayout.this.ahC.onClick(view);
                        }
                    }
                });
            }
            ArrayList<VoiceData.VoiceModel> bof = (!cbVar.isShareThread || cbVar.eUD == null) ? cbVar.bof() : cbVar.eUD.ePY;
            if (y.isEmpty(bof)) {
                this.amu.setVisibility(8);
                this.amx = false;
                return;
            }
            this.amu.setVisibility(0);
            VoiceData.VoiceModel voiceModel = bof.get(0);
            this.amu.setVoiceModel(voiceModel);
            this.amu.setTag(voiceModel);
            this.amu.bur();
            if (voiceModel != null) {
                this.amu.Ds(voiceModel.voice_status.intValue());
            }
            this.amu.ccH();
            this.amx = true;
        }
    }

    public void setObjectPool(b<ImageView> bVar, b<GifView> bVar2) {
        if (this.amY != null) {
            this.amY.setObjectPool(bVar, bVar2);
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
        return this.ajy;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.ajy = abVar;
    }

    private boolean p(cb cbVar) {
        if (this.ahB == null || this.ahB.blp() == null) {
            return true;
        }
        if (this.ahB.blp().getTid() == null || this.ahB.blp().getTid().equals(cbVar.getTid())) {
            return (!cbVar.isShareThread || cbVar.eUD == null) ? !c(cbVar.bob(), this.ahB.blp().bob()) : this.ahB.blp().eUD == null || !c(cbVar.eUD.ePU, this.ahB.blp().eUD.ePU);
        }
        return true;
    }

    private void q(cb cbVar) {
        boolean z;
        ArrayList<MediaData> arrayList;
        String b;
        ArrayList<MediaData> bob = cbVar.bob();
        String bnC = cbVar.bnC();
        if (!cbVar.isShareThread || cbVar.eUD == null) {
            z = false;
            arrayList = bob;
        } else if (cbVar.eUD.eOY) {
            this.amY.setVisibility(8);
            return;
        } else {
            z = true;
            arrayList = cbVar.eUD.ePU;
        }
        if (k.bkV().isShowImages() && y.getCount(arrayList) != 0) {
            this.anb.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(arrayList, i);
                if (mediaData != null && mediaData.getType() == 3 && (z || (bnC != null && bnC.equals(mediaData.getPostId() + "")))) {
                    this.anb.add(mediaData);
                }
            }
            if (y.getCount(this.anb) > 0) {
                this.amw = true;
                this.amY.setVisibility(0);
                ArrayList<TbRichTextImageInfo> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < this.anb.size(); i2++) {
                    MediaData mediaData2 = (MediaData) y.getItem(this.anb, i2);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.anb.size() > 1) {
                        b = a(mediaData2);
                    } else {
                        b = b(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.setSrc(b);
                    tbRichTextImageInfo.Ei(originalUrl);
                    tbRichTextImageInfo.lM(mediaData2.isLongPic());
                    if (mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(mediaData2.picWidth);
                        tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                    }
                    arrayList2.add(tbRichTextImageInfo);
                }
                this.amY.setData(arrayList2);
                return;
            }
            this.amw = false;
            this.amY.setVisibility(8);
            return;
        }
        this.amw = false;
        this.amY.setVisibility(8);
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
        this.amh = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    public void setTransmit(boolean z) {
        this.amZ = z;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.ahC = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ahC != null) {
            this.ahC.onClick(view);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.amY != null) {
            this.amY.onChangeSkinType();
        }
        if (this.akA != null) {
            this.akA.onChangeSkinType(i);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahV = z;
    }

    public void setFromForPb(int i) {
        this.ain = i;
    }

    private boolean a(PollData pollData) {
        return (pollData == null || pollData.getOptions() == null || pollData.getOptions().size() <= 0) ? false : true;
    }
}

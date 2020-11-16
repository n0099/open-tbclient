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
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes20.dex */
public class NewGridImageLayout extends LinearLayout implements View.OnClickListener, p<com.baidu.tbadk.core.data.a> {
    private com.baidu.tbadk.core.data.a afN;
    private View.OnClickListener afO;
    private int agn;
    public TextView agr;
    private ab<com.baidu.tbadk.core.data.a> ahx;
    public VoteView aiJ;
    private boolean ain;
    public PlayVoiceBntNew akA;
    private boolean akC;
    private boolean akD;
    private int akN;
    protected boolean akP;
    private boolean akn;
    private final int ald;
    public GridImageLayout ale;
    private boolean alf;
    public boolean alg;
    private LinkedList<MediaData> alh;
    private com.baidu.tbadk.widget.richText.a ali;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;
    private static final int akx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int aky = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int alb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31);
    private static final int alc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
    private static final int akz = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private static final int M_H_X004 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);

    public NewGridImageLayout(Context context) {
        this(context, null);
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ald = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (d.bhw() ? l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X007) * 2 : (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.akn = true;
        this.akC = false;
        this.akD = false;
        this.alf = false;
        this.alg = true;
        this.akN = 0;
        this.akP = false;
        this.ain = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.agr = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.akA = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.akA.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, NewGridImageLayout.this.afN);
                }
            }
        });
        this.ale = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        this.ale.setSupportGifPlay(false);
        this.ale.setCornerStyle(1);
        this.ale.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab<com.baidu.tbadk.core.data.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    subClickListener.a(view, NewGridImageLayout.this.afN);
                }
            }
        });
        this.ali = new com.baidu.tbadk.widget.richText.a();
        this.ali.fHC = l.getScreenDimensions(this.mContext)[0] - (d.bhw() ? l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X007) * 2 : l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004) * 2);
        this.ali.fHD = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.ale.setLayoutStrategy(this.ali);
        this.alh = new LinkedList<>();
        this.ale.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.3
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i, boolean z, boolean z2) {
                az.a(view, NewGridImageLayout.this.ali.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.alh, i, NewGridImageLayout.this.afN.bjd(), NewGridImageLayout.this.mFrom, true);
            }
        });
        this.aiJ = (VoteView) findViewById(R.id.thread_card_vote);
        this.aiJ.setBgColor(R.color.CAM_X0207);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setCornerStyle(int i) {
        this.ale.setCornerStyle(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: b */
    public void H(final com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.bjd() != null) {
            bx bjd = aVar.bjd();
            OriginalThreadInfo originalThreadInfo = bjd.eEF;
            if (originalThreadInfo != null && this.alf) {
                setMarginsTop(this.ale, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                c.bj(this.agr).oV(R.string.F_X01).oU(R.dimen.T_X07);
                c.bj(this.mTitle).oU(R.dimen.T_X07);
                this.mTitle.setVisibility(8);
                if (originalThreadInfo.ezh) {
                    az.a(this.agr, this.mTitle, new SpannableString(originalThreadInfo.title), bjd, this.ald, this.alf, this.ain);
                    ap.setViewTextColor(this.agr, R.color.CAM_X0108);
                } else {
                    az.a(this.agr, this.mTitle, originalThreadInfo.eAh, bjd, this.ald, this.alf, this.ain);
                }
                if (a(originalThreadInfo.pollData)) {
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            az.a(aVar.bjd().eEF, NewGridImageLayout.this.mContext, NewGridImageLayout.this.agn);
                        }
                    };
                    this.aiJ.setOnClickListener(onClickListener);
                    this.aiJ.setOnItemClickListener(onClickListener);
                    this.aiJ.setIsTransmit(true);
                    this.aiJ.setData(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
                    this.aiJ.setVisibility(0);
                } else {
                    this.aiJ.setVisibility(8);
                }
            } else {
                setMarginsTop(this.ale, UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
                this.aiJ.setVisibility(8);
                this.agr.setTextSize(0, l.getDimens(this.mContext, R.dimen.T_X06));
                this.agr.setLineSpacing(l.getDimens(this.mContext, R.dimen.M_T_X002), 1.0f);
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.T_X06));
                az.a(this.mTitle, bjd, this.ain);
                az.a(this.agr, this.mTitle, bjd.bld(), bjd, this.ald, this.alf, this.ain);
            }
            if (p(bjd)) {
                q(bjd);
            }
            setVoiceData(bjd);
            this.afN = aVar;
            if (this.afN.bjd().eEF != null) {
                if (bjd.isShareThread) {
                    if (this.afN.bjd().eEF != null) {
                        if (!this.afN.bjd().eEF.ezh) {
                            this.ale.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.5
                                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                                public void a(View view, String str, int i, boolean z, boolean z2) {
                                    az.a(NewGridImageLayout.this.afN.bjd().eEF, NewGridImageLayout.this.mContext, 2);
                                }
                            });
                        }
                    } else {
                        return;
                    }
                }
                if (!this.afN.bjd().eEF.ezh) {
                    this.ale.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.6
                        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                        public void a(View view, String str, int i, boolean z, boolean z2) {
                            az.a(view, true, (List<MediaData>) NewGridImageLayout.this.alh, i, NewGridImageLayout.this.afN.bjd().eEF.bkd(), NewGridImageLayout.this.mFrom, NewGridImageLayout.this.afN.bjd().eEF.eAf);
                        }
                    });
                }
                if (this.alf) {
                    if (this.afN.bjd().eEF == null || this.afN.bjd().eEF.ezh) {
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

    private void setVoiceData(bx bxVar) {
        if (bxVar != null) {
            if (this.alf) {
                this.akA.ak(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NewGridImageLayout.this.afO != null) {
                            NewGridImageLayout.this.afO.onClick(view);
                        }
                    }
                });
            }
            ArrayList<VoiceData.VoiceModel> blP = (!bxVar.isShareThread || bxVar.eEF == null) ? bxVar.blP() : bxVar.eEF.eAg;
            if (y.isEmpty(blP)) {
                this.akA.setVisibility(8);
                this.akD = false;
                return;
            }
            this.akA.setVisibility(0);
            VoiceData.VoiceModel voiceModel = blP.get(0);
            this.akA.setVoiceModel(voiceModel);
            this.akA.setTag(voiceModel);
            this.akA.changeSkin();
            if (voiceModel != null) {
                this.akA.DX(voiceModel.voice_status.intValue());
            }
            this.akA.bYE();
            this.akD = true;
        }
    }

    public void setObjectPool(b<ImageView> bVar, b<GifView> bVar2) {
        if (this.ale != null) {
            this.ale.setObjectPool(bVar, bVar2);
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
        return this.ahx;
    }

    public void setSubClickListener(ab<com.baidu.tbadk.core.data.a> abVar) {
        this.ahx = abVar;
    }

    private boolean p(bx bxVar) {
        if (this.afN == null || this.afN.bjd() == null) {
            return true;
        }
        if (this.afN.bjd().getTid() == null || this.afN.bjd().getTid().equals(bxVar.getTid())) {
            return (!bxVar.isShareThread || bxVar.eEF == null) ? !c(bxVar.blL(), this.afN.bjd().blL()) : this.afN.bjd().eEF == null || !c(bxVar.eEF.eAc, this.afN.bjd().eEF.eAc);
        }
        return true;
    }

    private void q(bx bxVar) {
        boolean z;
        ArrayList<MediaData> arrayList;
        String b;
        ArrayList<MediaData> blL = bxVar.blL();
        String blm = bxVar.blm();
        if (!bxVar.isShareThread || bxVar.eEF == null) {
            z = false;
            arrayList = blL;
        } else if (bxVar.eEF.ezh) {
            this.ale.setVisibility(8);
            return;
        } else {
            z = true;
            arrayList = bxVar.eEF.eAc;
        }
        if (k.biL().isShowImages() && y.getCount(arrayList) != 0) {
            this.alh.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(arrayList, i);
                if (mediaData != null && mediaData.getType() == 3 && (z || (blm != null && blm.equals(mediaData.getPostId() + "")))) {
                    this.alh.add(mediaData);
                }
            }
            if (y.getCount(this.alh) > 0) {
                this.akC = true;
                this.ale.setVisibility(0);
                ArrayList<TbRichTextImageInfo> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < this.alh.size(); i2++) {
                    MediaData mediaData2 = (MediaData) y.getItem(this.alh, i2);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.alh.size() > 1) {
                        b = a(mediaData2);
                    } else {
                        b = b(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.setSrc(b);
                    tbRichTextImageInfo.Ei(originalUrl);
                    tbRichTextImageInfo.kW(mediaData2.isLongPic());
                    if (mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(mediaData2.picWidth);
                        tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                    }
                    arrayList2.add(tbRichTextImageInfo);
                }
                this.ale.setData(arrayList2);
                return;
            }
            this.akC = false;
            this.ale.setVisibility(8);
            return;
        }
        this.akC = false;
        this.ale.setVisibility(8);
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
        this.akn = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    public void setTransmit(boolean z) {
        this.alf = z;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.afO = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.afO != null) {
            this.afO.onClick(view);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.ale != null) {
            this.ale.onChangeSkinType();
        }
        if (this.aiJ != null) {
            this.aiJ.onChangeSkinType(i);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.ain = z;
    }

    public void setFromForPb(int i) {
        this.agn = i;
    }

    private boolean a(PollData pollData) {
        return (pollData == null || pollData.getOptions() == null || pollData.getOptions().size() <= 0) ? false : true;
    }
}

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
    private AbsThreadDataSupport aeW;
    private View.OnClickListener aeX;
    private int afv;
    public TextView afz;
    private aa<AbsThreadDataSupport> agI;
    public VoteView ahO;
    private boolean ahv;
    public PlayVoiceBntNew ajD;
    private boolean ajF;
    private boolean ajG;
    private int ajN;
    protected boolean ajX;
    private boolean ajr;
    private final int akf;
    public GridImageLayout akg;
    private boolean akh;
    public boolean aki;
    private LinkedList<MediaData> akj;
    private com.baidu.tbadk.widget.richText.a akk;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;
    private static final int ajB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int afE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int akd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31);
    private static final int ake = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds16);
    private static final int ajC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);

    public NewGridImageLayout(Context context) {
        this(context, null);
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.akf = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.ajr = true;
        this.ajF = false;
        this.ajG = false;
        this.akh = false;
        this.aki = true;
        this.ajN = 0;
        this.ajX = false;
        this.ahv = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.afz = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.ajD = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.ajD.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, NewGridImageLayout.this.aeW);
                }
            }
        });
        this.akg = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        com.baidu.tbadk.a.b.a.d(this.akg, R.dimen.tbds23, R.dimen.tbds14);
        this.akg.setSupportGifPlay(false);
        this.akg.setCornerStyle(1);
        this.akg.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    subClickListener.a(view, NewGridImageLayout.this.aeW);
                }
            }
        });
        this.akk = new com.baidu.tbadk.widget.richText.a();
        int i = l.getScreenDimensions(this.mContext)[0];
        this.akk.feB = i - l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds88);
        this.akk.feC = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.akg.setLayoutStrategy(this.akk);
        this.akj = new LinkedList<>();
        this.akg.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.3
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i2, boolean z, boolean z2) {
                ay.a(view, NewGridImageLayout.this.akk.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.akj, i2, NewGridImageLayout.this.aeW.bce(), NewGridImageLayout.this.mFrom, true);
            }
        });
        this.ahO = (VoteView) findViewById(R.id.thread_card_vote);
        this.ahO.setBgColor(R.color.cp_bg_line_e);
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setCornerStyle(int i) {
        this.akg.setCornerStyle(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: b */
    public void F(final AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.bce() != null) {
            bw bce = absThreadDataSupport.bce();
            OriginalThreadInfo originalThreadInfo = bce.edE;
            if (originalThreadInfo != null && this.akh) {
                this.afz.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.afz.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds15), 1.0f);
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setVisibility(8);
                if (originalThreadInfo.dYh) {
                    ay.a(this.afz, this.mTitle, new SpannableString(originalThreadInfo.title), bce, this.akf, this.akh, this.ahv);
                    ap.setViewTextColor(this.afz, R.color.cp_cont_c);
                } else {
                    ay.a(this.afz, this.mTitle, originalThreadInfo.dZh, bce, this.akf, this.akh, this.ahv);
                }
                if (a(originalThreadInfo.pollData)) {
                    View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            ay.a(absThreadDataSupport.bce().edE, NewGridImageLayout.this.mContext, NewGridImageLayout.this.afv);
                        }
                    };
                    this.ahO.setOnClickListener(onClickListener);
                    this.ahO.setOnItemClickListener(onClickListener);
                    this.ahO.setIsTransmit(true);
                    this.ahO.setData(originalThreadInfo.pollData, originalThreadInfo.threadId, originalThreadInfo.forumId);
                    this.ahO.setVisibility(0);
                } else {
                    this.ahO.setVisibility(8);
                }
            } else {
                this.ahO.setVisibility(8);
                this.afz.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                this.afz.setLineSpacing(l.getDimens(this.mContext, R.dimen.tbds17), 1.0f);
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                ay.a(this.mTitle, bce, this.ahv);
                ay.a(this.afz, this.mTitle, bce.bef(), bce, this.akf, this.akh, this.ahv);
            }
            if (o(bce)) {
                p(bce);
            }
            setVoiceData(bce);
            tU();
            this.aeW = absThreadDataSupport;
            if (this.aeW.bce().edE != null) {
                if (bce.isShareThread) {
                    if (this.aeW.bce().edE != null) {
                        if (!this.aeW.bce().edE.dYh) {
                            this.akg.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.5
                                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                                public void a(View view, String str, int i, boolean z, boolean z2) {
                                    ay.a(NewGridImageLayout.this.aeW.bce().edE, NewGridImageLayout.this.mContext, 2);
                                }
                            });
                        }
                    } else {
                        return;
                    }
                }
                if (!this.aeW.bce().edE.dYh) {
                    this.akg.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.6
                        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                        public void a(View view, String str, int i, boolean z, boolean z2) {
                            ay.a(view, true, (List<MediaData>) NewGridImageLayout.this.akj, i, NewGridImageLayout.this.aeW.bce().edE.bdf(), NewGridImageLayout.this.mFrom, NewGridImageLayout.this.aeW.bce().edE.dZf);
                        }
                    });
                }
                if (this.akh) {
                    if (this.aeW.bce().edE == null || this.aeW.bce().edE.dYh) {
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
            if (this.akh) {
                this.ajD.aj(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NewGridImageLayout.this.aeX != null) {
                            NewGridImageLayout.this.aeX.onClick(view);
                        }
                    }
                });
            }
            ArrayList<VoiceData.VoiceModel> beR = (!bwVar.isShareThread || bwVar.edE == null) ? bwVar.beR() : bwVar.edE.dZg;
            if (y.isEmpty(beR)) {
                this.ajD.setVisibility(8);
                this.ajG = false;
                return;
            }
            this.ajD.setVisibility(0);
            VoiceData.VoiceModel voiceModel = beR.get(0);
            this.ajD.setVoiceModel(voiceModel);
            this.ajD.setTag(voiceModel);
            this.ajD.changeSkin();
            if (voiceModel != null) {
                this.ajD.BM(voiceModel.voice_status.intValue());
            }
            this.ajD.bPe();
            this.ajG = true;
        }
    }

    private void tU() {
        if (this.akh && this.aki) {
            if (this.afz.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
                if (this.ajF) {
                    setMarginsTop(this.akg, 0);
                    setMarginsTop(this.ajD, akd);
                    setMarginsTop(this.ahO, akd);
                    return;
                } else if (this.ajG) {
                    setMarginsTop(this.akg, 0);
                    setMarginsTop(this.ajD, 0);
                    setMarginsTop(this.ahO, akd);
                    return;
                } else {
                    setMarginsTop(this.akg, 0);
                    setMarginsTop(this.ajD, 0);
                    setMarginsTop(this.ahO, 0);
                    return;
                }
            }
            setMarginsTop(this.akg, ake);
            setMarginsTop(this.ajD, akd);
            setMarginsTop(this.ahO, akd);
        } else if (this.afz.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.ajF) {
                setMarginsTop(this.ajD, ajB);
            } else if (this.ajG) {
                setMarginsTop(this.ajD, ajC);
            }
        } else if (this.ajD != null && this.ajD.getLayoutParams() != null) {
            if (this.ajF) {
                setMarginsTop(this.ajD, ajB);
            } else if (this.ajG) {
                setMarginsTop(this.ajD, afE);
            }
        }
    }

    public void setObjectPool(b<ImageView> bVar, b<GifView> bVar2) {
        if (this.akg != null) {
            this.akg.setObjectPool(bVar, bVar2);
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
        return this.agI;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.agI = aaVar;
    }

    private boolean o(bw bwVar) {
        if (this.aeW == null || this.aeW.bce() == null) {
            return true;
        }
        if (this.aeW.bce().getTid() == null || this.aeW.bce().getTid().equals(bwVar.getTid())) {
            return (!bwVar.isShareThread || bwVar.edE == null) ? !c(bwVar.beN(), this.aeW.bce().beN()) : this.aeW.bce().edE == null || !c(bwVar.edE.dZc, this.aeW.bce().edE.dZc);
        }
        return true;
    }

    private void p(bw bwVar) {
        boolean z;
        ArrayList<MediaData> arrayList;
        String b;
        ArrayList<MediaData> beN = bwVar.beN();
        String beo = bwVar.beo();
        if (!bwVar.isShareThread || bwVar.edE == null) {
            z = false;
            arrayList = beN;
        } else if (bwVar.edE.dYh) {
            this.akg.setVisibility(8);
            return;
        } else {
            z = true;
            arrayList = bwVar.edE.dZc;
        }
        if (k.bbM().isShowImages() && y.getCount(arrayList) != 0) {
            this.akj.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(arrayList, i);
                if (mediaData != null && mediaData.getType() == 3 && (z || (beo != null && beo.equals(mediaData.getPostId() + "")))) {
                    this.akj.add(mediaData);
                }
            }
            if (y.getCount(this.akj) > 0) {
                this.ajF = true;
                this.akg.setVisibility(0);
                ArrayList<TbRichTextImageInfo> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < this.akj.size(); i2++) {
                    MediaData mediaData2 = (MediaData) y.getItem(this.akj, i2);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.akj.size() > 1) {
                        b = a(mediaData2);
                    } else {
                        b = b(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.setSrc(b);
                    tbRichTextImageInfo.CR(originalUrl);
                    tbRichTextImageInfo.jY(mediaData2.isLongPic());
                    if (mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(mediaData2.picWidth);
                        tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                    }
                    arrayList2.add(tbRichTextImageInfo);
                }
                this.akg.setData(arrayList2);
                return;
            }
            this.ajF = false;
            this.akg.setVisibility(8);
            return;
        }
        this.ajF = false;
        this.akg.setVisibility(8);
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
        this.ajr = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    public void setTransmit(boolean z) {
        this.akh = z;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.aeX = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aeX != null) {
            this.aeX.onClick(view);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.akg != null) {
            this.akg.onChangeSkinType();
        }
        if (this.ahO != null) {
            this.ahO.onChangeSkinType(i);
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.ahv = z;
    }

    public void setFromForPb(int i) {
        this.afv = i;
    }

    private boolean a(PollData pollData) {
        return (pollData == null || pollData.getOptions() == null || pollData.getOptions().size() <= 0) ? false : true;
    }
}

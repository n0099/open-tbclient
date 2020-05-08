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
import com.baidu.card.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class NewGridImageLayout extends LinearLayout implements View.OnClickListener, m<com.baidu.tbadk.core.data.a> {
    private static final int agG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int agH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int agI = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    public TextView adB;
    private com.baidu.tbadk.core.data.a ade;
    private View.OnClickListener adf;
    private z<com.baidu.tbadk.core.data.a> aeC;
    private boolean afo;
    public PlayVoiceBntNew agJ;
    private boolean agL;
    private boolean agM;
    private int agT;
    private boolean agw;
    protected boolean ahd;
    private final int ahj;
    public GridImageLayout ahk;
    private boolean ahl;
    private LinkedList<MediaData> ahm;
    private com.baidu.tbadk.widget.richText.a ahn;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public NewGridImageLayout(Context context) {
        this(context, null);
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahj = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.agw = true;
        this.agL = false;
        this.agM = false;
        this.ahl = false;
        this.agT = 0;
        this.ahd = false;
        this.afo = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.adB = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.agJ = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.agJ.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, NewGridImageLayout.this.ade);
                }
            }
        });
        this.ahk = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        this.ahk.setSupportGifPlay(false);
        this.ahk.setCornerStyle(1);
        this.ahk.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    subClickListener.a(view, NewGridImageLayout.this.ade);
                }
            }
        });
        this.ahn = new com.baidu.tbadk.widget.richText.a();
        int i = l.getScreenDimensions(this.mContext)[0];
        this.ahn.eoC = i - l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds88);
        this.ahn.eoD = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.ahk.setLayoutStrategy(this.ahn);
        this.ahm = new LinkedList<>();
        this.ahk.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.3
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i2, boolean z, boolean z2) {
                au.a(view, NewGridImageLayout.this.ahn.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.ahm, i2, NewGridImageLayout.this.ade.aIu(), NewGridImageLayout.this.mFrom, true);
            }
        });
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setCornerStyle(int i) {
        this.ahk.setCornerStyle(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void B(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.aIu() != null) {
            bj aIu = aVar.aIu();
            OriginalThreadInfo originalThreadInfo = aIu.dtt;
            if (originalThreadInfo != null && this.ahl) {
                this.adB.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setVisibility(8);
                if (originalThreadInfo.doi) {
                    au.a(this.adB, this.mTitle, new SpannableString(originalThreadInfo.title), aIu, this.ahj, this.ahl, this.afo);
                    am.setViewTextColor(this.adB, (int) R.color.cp_cont_c);
                } else {
                    au.a(this.adB, this.mTitle, originalThreadInfo.dpj, aIu, this.ahj, this.ahl, this.afo);
                }
            } else {
                this.adB.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                au.a(this.mTitle, aIu, this.afo);
                au.a(this.adB, this.mTitle, aIu.aKe(), aIu, this.ahj, this.ahl, this.afo);
            }
            if (o(aIu)) {
                p(aIu);
            }
            setVoiceData(aIu);
            rG();
            this.ade = aVar;
            if (this.ade.aIu().dtt != null) {
                if (aIu.isShareThread) {
                    if (this.ade.aIu().dtt != null) {
                        if (!this.ade.aIu().dtt.doi) {
                            this.ahk.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.4
                                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                                public void a(View view, String str, int i, boolean z, boolean z2) {
                                    au.a(NewGridImageLayout.this.ade.aIu().dtt, NewGridImageLayout.this.mContext, 2);
                                }
                            });
                        }
                    } else {
                        return;
                    }
                }
                if (!this.ade.aIu().dtt.doi) {
                    this.ahk.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.5
                        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                        public void a(View view, String str, int i, boolean z, boolean z2) {
                            au.a(view, true, (List<MediaData>) NewGridImageLayout.this.ahm, i, NewGridImageLayout.this.ade.aIu().dtt.aJk(), NewGridImageLayout.this.mFrom, NewGridImageLayout.this.ade.aIu().dtt.dph);
                        }
                    });
                }
                if (this.ahl) {
                    if (this.ade.aIu().dtt == null || this.ade.aIu().dtt.doi) {
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

    private void setVoiceData(bj bjVar) {
        if (bjVar != null) {
            if (this.ahl) {
                this.agJ.ah(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NewGridImageLayout.this.adf != null) {
                            NewGridImageLayout.this.adf.onClick(view);
                        }
                    }
                });
            }
            ArrayList<VoiceData.VoiceModel> aKQ = (!bjVar.isShareThread || bjVar.dtt == null) ? bjVar.aKQ() : bjVar.dtt.dpi;
            if (v.isEmpty(aKQ)) {
                this.agJ.setVisibility(8);
                this.agM = false;
                return;
            }
            this.agJ.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aKQ.get(0);
            this.agJ.setVoiceModel(voiceModel);
            this.agJ.setTag(voiceModel);
            this.agJ.ckM();
            if (voiceModel != null) {
                this.agJ.xC(voiceModel.voice_status.intValue());
            }
            this.agJ.cXw();
            this.agM = true;
        }
    }

    private void rG() {
        if (this.adB.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.agL) {
                setMarginsTop(this.agJ, agG);
            } else if (this.agM) {
                setMarginsTop(this.agJ, agI);
            }
        } else if (this.agJ != null && this.agJ.getLayoutParams() != null) {
            if (this.agL) {
                setMarginsTop(this.agJ, agG);
            } else if (this.agM) {
                setMarginsTop(this.agJ, agH);
            }
        }
    }

    public void setObjectPool(b<ImageView> bVar, b<GifView> bVar2) {
        if (this.ahk != null) {
            this.ahk.setObjectPool(bVar, bVar2);
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

    public z<com.baidu.tbadk.core.data.a> getSubClickListener() {
        return this.aeC;
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.aeC = zVar;
    }

    private boolean o(bj bjVar) {
        if (this.ade == null || this.ade.aIu() == null) {
            return true;
        }
        if (this.ade.aIu().getTid() == null || this.ade.aIu().getTid().equals(bjVar.getTid())) {
            return (!bjVar.isShareThread || bjVar.dtt == null) ? !c(bjVar.aKM(), this.ade.aIu().aKM()) : this.ade.aIu().dtt == null || !c(bjVar.dtt.dpe, this.ade.aIu().dtt.dpe);
        }
        return true;
    }

    private void p(bj bjVar) {
        boolean z;
        ArrayList<MediaData> arrayList;
        String b;
        ArrayList<MediaData> aKM = bjVar.aKM();
        String aKm = bjVar.aKm();
        if (!bjVar.isShareThread || bjVar.dtt == null) {
            z = false;
            arrayList = aKM;
        } else if (bjVar.dtt.doi) {
            this.ahk.setVisibility(8);
            return;
        } else {
            z = true;
            arrayList = bjVar.dtt.dpe;
        }
        if (i.aIc().isShowImages() && v.getCount(arrayList) != 0) {
            this.ahm.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(arrayList, i);
                if (mediaData != null && mediaData.getType() == 3 && (z || (aKm != null && aKm.equals(mediaData.getPostId() + "")))) {
                    this.ahm.add(mediaData);
                }
            }
            if (v.getCount(this.ahm) > 0) {
                this.ahk.setVisibility(0);
                ArrayList<TbRichTextImageInfo> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < this.ahm.size(); i2++) {
                    MediaData mediaData2 = (MediaData) v.getItem(this.ahm, i2);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.ahm.size() > 1) {
                        b = a(mediaData2);
                    } else {
                        b = b(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.setSrc(b);
                    tbRichTextImageInfo.xv(originalUrl);
                    tbRichTextImageInfo.im(mediaData2.isLongPic());
                    if (mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(mediaData2.picWidth);
                        tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                    }
                    arrayList2.add(tbRichTextImageInfo);
                }
                this.ahk.setData(arrayList2);
                return;
            }
            this.ahk.setVisibility(8);
            return;
        }
        this.ahk.setVisibility(8);
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
        this.agw = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    public void setTransmit(boolean z) {
        this.ahl = z;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.adf = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.adf != null) {
            this.adf.onClick(view);
        }
    }

    public void onChangeSkinType() {
        if (this.ahk != null) {
            this.ahk.onChangeSkinType();
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.afo = z;
    }
}

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
    private static final int agD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int agE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int agF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private com.baidu.tbadk.core.data.a ada;
    private View.OnClickListener adb;
    public TextView ady;
    private z<com.baidu.tbadk.core.data.a> aez;
    private boolean afl;
    public PlayVoiceBntNew agG;
    private boolean agI;
    private boolean agJ;
    private int agQ;
    private boolean agt;
    protected boolean aha;
    private final int ahg;
    public GridImageLayout ahh;
    private boolean ahi;
    private LinkedList<MediaData> ahj;
    private com.baidu.tbadk.widget.richText.a ahk;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public NewGridImageLayout(Context context) {
        this(context, null);
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahg = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.agt = true;
        this.agI = false;
        this.agJ = false;
        this.ahi = false;
        this.agQ = 0;
        this.aha = false;
        this.afl = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ady = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.agG = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.agG.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, NewGridImageLayout.this.ada);
                }
            }
        });
        this.ahh = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        this.ahh.setSupportGifPlay(false);
        this.ahh.setCornerStyle(1);
        this.ahh.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    subClickListener.a(view, NewGridImageLayout.this.ada);
                }
            }
        });
        this.ahk = new com.baidu.tbadk.widget.richText.a();
        int i = l.getScreenDimensions(this.mContext)[0];
        this.ahk.eox = i - l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds88);
        this.ahk.eoy = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.ahh.setLayoutStrategy(this.ahk);
        this.ahj = new LinkedList<>();
        this.ahh.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.3
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i2, boolean z, boolean z2) {
                au.a(view, NewGridImageLayout.this.ahk.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.ahj, i2, NewGridImageLayout.this.ada.aIw(), NewGridImageLayout.this.mFrom, true);
            }
        });
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setCornerStyle(int i) {
        this.ahh.setCornerStyle(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.aIw() != null) {
            bj aIw = aVar.aIw();
            OriginalThreadInfo originalThreadInfo = aIw.dto;
            if (originalThreadInfo != null && this.ahi) {
                this.ady.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setVisibility(8);
                if (originalThreadInfo.doe) {
                    au.a(this.ady, this.mTitle, new SpannableString(originalThreadInfo.title), aIw, this.ahg, this.ahi, this.afl);
                    am.setViewTextColor(this.ady, (int) R.color.cp_cont_c);
                } else {
                    au.a(this.ady, this.mTitle, originalThreadInfo.dpf, aIw, this.ahg, this.ahi, this.afl);
                }
            } else {
                this.ady.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                au.a(this.mTitle, aIw, this.afl);
                au.a(this.ady, this.mTitle, aIw.aKg(), aIw, this.ahg, this.ahi, this.afl);
            }
            if (o(aIw)) {
                p(aIw);
            }
            setVoiceData(aIw);
            rG();
            this.ada = aVar;
            if (this.ada.aIw().dto != null) {
                if (aIw.isShareThread) {
                    if (this.ada.aIw().dto != null) {
                        if (!this.ada.aIw().dto.doe) {
                            this.ahh.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.4
                                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                                public void a(View view, String str, int i, boolean z, boolean z2) {
                                    au.a(NewGridImageLayout.this.ada.aIw().dto, NewGridImageLayout.this.mContext, 2);
                                }
                            });
                        }
                    } else {
                        return;
                    }
                }
                if (!this.ada.aIw().dto.doe) {
                    this.ahh.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.5
                        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                        public void a(View view, String str, int i, boolean z, boolean z2) {
                            au.a(view, true, (List<MediaData>) NewGridImageLayout.this.ahj, i, NewGridImageLayout.this.ada.aIw().dto.aJm(), NewGridImageLayout.this.mFrom, NewGridImageLayout.this.ada.aIw().dto.dpd);
                        }
                    });
                }
                if (this.ahi) {
                    if (this.ada.aIw().dto == null || this.ada.aIw().dto.doe) {
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
            if (this.ahi) {
                this.agG.ah(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NewGridImageLayout.this.adb != null) {
                            NewGridImageLayout.this.adb.onClick(view);
                        }
                    }
                });
            }
            ArrayList<VoiceData.VoiceModel> aKS = (!bjVar.isShareThread || bjVar.dto == null) ? bjVar.aKS() : bjVar.dto.dpe;
            if (v.isEmpty(aKS)) {
                this.agG.setVisibility(8);
                this.agJ = false;
                return;
            }
            this.agG.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aKS.get(0);
            this.agG.setVoiceModel(voiceModel);
            this.agG.setTag(voiceModel);
            this.agG.ckO();
            if (voiceModel != null) {
                this.agG.xC(voiceModel.voice_status.intValue());
            }
            this.agG.cXz();
            this.agJ = true;
        }
    }

    private void rG() {
        if (this.ady.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.agI) {
                setMarginsTop(this.agG, agD);
            } else if (this.agJ) {
                setMarginsTop(this.agG, agF);
            }
        } else if (this.agG != null && this.agG.getLayoutParams() != null) {
            if (this.agI) {
                setMarginsTop(this.agG, agD);
            } else if (this.agJ) {
                setMarginsTop(this.agG, agE);
            }
        }
    }

    public void setObjectPool(b<ImageView> bVar, b<GifView> bVar2) {
        if (this.ahh != null) {
            this.ahh.setObjectPool(bVar, bVar2);
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
        return this.aez;
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.aez = zVar;
    }

    private boolean o(bj bjVar) {
        if (this.ada == null || this.ada.aIw() == null) {
            return true;
        }
        if (this.ada.aIw().getTid() == null || this.ada.aIw().getTid().equals(bjVar.getTid())) {
            return (!bjVar.isShareThread || bjVar.dto == null) ? !c(bjVar.aKO(), this.ada.aIw().aKO()) : this.ada.aIw().dto == null || !c(bjVar.dto.dpa, this.ada.aIw().dto.dpa);
        }
        return true;
    }

    private void p(bj bjVar) {
        boolean z;
        ArrayList<MediaData> arrayList;
        String b;
        ArrayList<MediaData> aKO = bjVar.aKO();
        String aKo = bjVar.aKo();
        if (!bjVar.isShareThread || bjVar.dto == null) {
            z = false;
            arrayList = aKO;
        } else if (bjVar.dto.doe) {
            this.ahh.setVisibility(8);
            return;
        } else {
            z = true;
            arrayList = bjVar.dto.dpa;
        }
        if (i.aIe().isShowImages() && v.getCount(arrayList) != 0) {
            this.ahj.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(arrayList, i);
                if (mediaData != null && mediaData.getType() == 3 && (z || (aKo != null && aKo.equals(mediaData.getPostId() + "")))) {
                    this.ahj.add(mediaData);
                }
            }
            if (v.getCount(this.ahj) > 0) {
                this.ahh.setVisibility(0);
                ArrayList<TbRichTextImageInfo> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < this.ahj.size(); i2++) {
                    MediaData mediaData2 = (MediaData) v.getItem(this.ahj, i2);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.ahj.size() > 1) {
                        b = a(mediaData2);
                    } else {
                        b = b(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.setSrc(b);
                    tbRichTextImageInfo.xs(originalUrl);
                    tbRichTextImageInfo.im(mediaData2.isLongPic());
                    if (mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(mediaData2.picWidth);
                        tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                    }
                    arrayList2.add(tbRichTextImageInfo);
                }
                this.ahh.setData(arrayList2);
                return;
            }
            this.ahh.setVisibility(8);
            return;
        }
        this.ahh.setVisibility(8);
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
        this.agt = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    public void setTransmit(boolean z) {
        this.ahi = z;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.adb = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.adb != null) {
            this.adb.onClick(view);
        }
    }

    public void onChangeSkinType() {
        if (this.ahh != null) {
            this.ahh.onChangeSkinType();
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.afl = z;
    }
}

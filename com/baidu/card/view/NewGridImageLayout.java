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
    private static final int NV = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int NW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int NX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    public TextView KA;
    private com.baidu.tbadk.core.data.a Kc;
    private View.OnClickListener Ke;
    private z<com.baidu.tbadk.core.data.a> LD;
    private boolean NJ;
    public PlayVoiceBntNew NY;
    private final int OA;
    public GridImageLayout OB;
    private boolean OC;
    private LinkedList<MediaData> OD;
    private com.baidu.tbadk.widget.richText.a OE;
    private boolean Oa;
    private boolean Ob;
    private int Oj;
    protected boolean Ou;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public NewGridImageLayout(Context context) {
        this(context, null);
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OA = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.NJ = true;
        this.Oa = false;
        this.Ob = false;
        this.OC = false;
        this.Oj = 0;
        this.Ou = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.KA = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.NY = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.NY.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, NewGridImageLayout.this.Kc);
                }
            }
        });
        this.OB = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        this.OB.setSupportGifPlay(false);
        this.OB.setCornerStyle(1);
        this.OB.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    subClickListener.a(view, NewGridImageLayout.this.Kc);
                }
            }
        });
        this.OE = new com.baidu.tbadk.widget.richText.a();
        int i = l.getScreenDimensions(this.mContext)[0];
        this.OE.dOm = i - l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds88);
        this.OE.dOn = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.OB.setLayoutStrategy(this.OE);
        this.OD = new LinkedList<>();
        this.OB.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.3
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i2, boolean z, boolean z2) {
                au.a(view, NewGridImageLayout.this.OE.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.OD, i2, NewGridImageLayout.this.Kc.aAg(), NewGridImageLayout.this.mFrom, true);
            }
        });
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setCornerStyle(int i) {
        this.OB.setCornerStyle(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.aAg() != null) {
            bj aAg = aVar.aAg();
            OriginalThreadInfo originalThreadInfo = aAg.cTR;
            if (originalThreadInfo != null && this.OC) {
                this.KA.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setVisibility(8);
                if (originalThreadInfo.cOL) {
                    au.a(this.KA, this.mTitle, new SpannableString(originalThreadInfo.title), aAg, this.OA, this.OC);
                    am.setViewTextColor(this.KA, (int) R.color.cp_cont_c);
                } else {
                    au.a(this.KA, this.mTitle, originalThreadInfo.cPM, aAg, this.OA, this.OC);
                }
            } else {
                this.KA.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                au.a(this.mTitle, aAg);
                au.a(this.KA, this.mTitle, aAg.aBQ(), aAg, this.OA, this.OC);
            }
            if (o(aAg)) {
                p(aAg);
            }
            setVoiceData(aAg);
            nn();
            this.Kc = aVar;
            if (this.Kc.aAg().cTR != null) {
                if (aAg.isShareThread) {
                    if (this.Kc.aAg().cTR != null) {
                        if (!this.Kc.aAg().cTR.cOL) {
                            this.OB.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.4
                                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                                public void a(View view, String str, int i, boolean z, boolean z2) {
                                    au.a(NewGridImageLayout.this.Kc.aAg().cTR, NewGridImageLayout.this.mContext, 2);
                                }
                            });
                        }
                    } else {
                        return;
                    }
                }
                if (!this.Kc.aAg().cTR.cOL) {
                    this.OB.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.5
                        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                        public void a(View view, String str, int i, boolean z, boolean z2) {
                            au.a(view, true, (List<MediaData>) NewGridImageLayout.this.OD, i, NewGridImageLayout.this.Kc.aAg().cTR.aAW(), NewGridImageLayout.this.mFrom, NewGridImageLayout.this.Kc.aAg().cTR.cPK);
                        }
                    });
                }
                if (this.OC) {
                    if (this.Kc.aAg().cTR == null || this.Kc.aAg().cTR.cOL) {
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
            if (this.OC) {
                this.NY.ae(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NewGridImageLayout.this.Ke != null) {
                            NewGridImageLayout.this.Ke.onClick(view);
                        }
                    }
                });
            }
            ArrayList<VoiceData.VoiceModel> aCC = (!bjVar.isShareThread || bjVar.cTR == null) ? bjVar.aCC() : bjVar.cTR.cPL;
            if (v.isEmpty(aCC)) {
                this.NY.setVisibility(8);
                this.Ob = false;
                return;
            }
            this.NY.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aCC.get(0);
            this.NY.setVoiceModel(voiceModel);
            this.NY.setTag(voiceModel);
            this.NY.bHt();
            if (voiceModel != null) {
                this.NY.wW(voiceModel.voice_status.intValue());
            }
            this.NY.cMi();
            this.Ob = true;
        }
    }

    private void nn() {
        if (this.KA.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Oa) {
                setMarginsTop(this.NY, NV);
            } else if (this.Ob) {
                setMarginsTop(this.NY, NX);
            }
        } else if (this.NY != null && this.NY.getLayoutParams() != null) {
            if (this.Oa) {
                setMarginsTop(this.NY, NV);
            } else if (this.Ob) {
                setMarginsTop(this.NY, NW);
            }
        }
    }

    public void setObjectPool(b<ImageView> bVar, b<GifView> bVar2) {
        if (this.OB != null) {
            this.OB.setObjectPool(bVar, bVar2);
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
        return this.LD;
    }

    public void setSubClickListener(z<com.baidu.tbadk.core.data.a> zVar) {
        this.LD = zVar;
    }

    private boolean o(bj bjVar) {
        if (this.Kc == null || this.Kc.aAg() == null) {
            return true;
        }
        if (this.Kc.aAg().getTid() == null || this.Kc.aAg().getTid().equals(bjVar.getTid())) {
            return (!bjVar.isShareThread || bjVar.cTR == null) ? !c(bjVar.aCy(), this.Kc.aAg().aCy()) : this.Kc.aAg().cTR == null || !c(bjVar.cTR.cPH, this.Kc.aAg().cTR.cPH);
        }
        return true;
    }

    private void p(bj bjVar) {
        boolean z;
        ArrayList<MediaData> arrayList;
        String b;
        ArrayList<MediaData> aCy = bjVar.aCy();
        String aBY = bjVar.aBY();
        if (!bjVar.isShareThread || bjVar.cTR == null) {
            z = false;
            arrayList = aCy;
        } else if (bjVar.cTR.cOL) {
            this.OB.setVisibility(8);
            return;
        } else {
            z = true;
            arrayList = bjVar.cTR.cPH;
        }
        if (v.getCount(arrayList) != 0) {
            this.OD.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(arrayList, i);
                if (mediaData != null && mediaData.getType() == 3 && (z || (aBY != null && aBY.equals(mediaData.getPostId() + "")))) {
                    this.OD.add(mediaData);
                }
            }
            if (v.getCount(this.OD) > 0) {
                this.OB.setVisibility(0);
                ArrayList<TbRichTextImageInfo> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < this.OD.size(); i2++) {
                    MediaData mediaData2 = (MediaData) v.getItem(this.OD, i2);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.OD.size() > 1) {
                        b = a(mediaData2);
                    } else {
                        b = b(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.setSrc(b);
                    tbRichTextImageInfo.wf(originalUrl);
                    tbRichTextImageInfo.hn(mediaData2.isLongPic());
                    if (mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(mediaData2.picWidth);
                        tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                    }
                    arrayList2.add(tbRichTextImageInfo);
                }
                this.OB.setData(arrayList2);
                return;
            }
            this.OB.setVisibility(8);
            return;
        }
        this.OB.setVisibility(8);
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
        this.NJ = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    public void setTransmit(boolean z) {
        this.OC = z;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.Ke = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Ke != null) {
            this.Ke.onClick(view);
        }
    }

    public void onChangeSkinType() {
        if (this.OB != null) {
            this.OB.onChangeSkinType();
        }
    }
}

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
    private static final int NW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int NX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int NY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    public TextView KA;
    private com.baidu.tbadk.core.data.a Kc;
    private View.OnClickListener Ke;
    private z<com.baidu.tbadk.core.data.a> LD;
    private boolean Mw;
    private boolean NK;
    public PlayVoiceBntNew NZ;
    private final int OB;
    public GridImageLayout OC;
    private boolean OD;
    private LinkedList<MediaData> OE;
    private com.baidu.tbadk.widget.richText.a OF;
    private boolean Ob;
    private boolean Oc;
    private int Ok;
    protected boolean Ov;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public NewGridImageLayout(Context context) {
        this(context, null);
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OB = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.NK = true;
        this.Ob = false;
        this.Oc = false;
        this.OD = false;
        this.Ok = 0;
        this.Ov = false;
        this.Mw = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.KA = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.NZ = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.NZ.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, NewGridImageLayout.this.Kc);
                }
            }
        });
        this.OC = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        this.OC.setSupportGifPlay(false);
        this.OC.setCornerStyle(1);
        this.OC.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<com.baidu.tbadk.core.data.a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    subClickListener.a(view, NewGridImageLayout.this.Kc);
                }
            }
        });
        this.OF = new com.baidu.tbadk.widget.richText.a();
        int i = l.getScreenDimensions(this.mContext)[0];
        this.OF.dOD = i - l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds88);
        this.OF.dOE = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.OC.setLayoutStrategy(this.OF);
        this.OE = new LinkedList<>();
        this.OC.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.3
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i2, boolean z, boolean z2) {
                au.a(view, NewGridImageLayout.this.OF.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.OE, i2, NewGridImageLayout.this.Kc.aAj(), NewGridImageLayout.this.mFrom, true);
            }
        });
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setCornerStyle(int i) {
        this.OC.setCornerStyle(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(com.baidu.tbadk.core.data.a aVar) {
        if (aVar != null && aVar.aAj() != null) {
            bj aAj = aVar.aAj();
            OriginalThreadInfo originalThreadInfo = aAj.cUe;
            if (originalThreadInfo != null && this.OD) {
                this.KA.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setVisibility(8);
                if (originalThreadInfo.cOY) {
                    au.a(this.KA, this.mTitle, new SpannableString(originalThreadInfo.title), aAj, this.OB, this.OD, this.Mw);
                    am.setViewTextColor(this.KA, (int) R.color.cp_cont_c);
                } else {
                    au.a(this.KA, this.mTitle, originalThreadInfo.cPZ, aAj, this.OB, this.OD, this.Mw);
                }
            } else {
                this.KA.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                au.a(this.mTitle, aAj, this.Mw);
                au.a(this.KA, this.mTitle, aAj.aBT(), aAj, this.OB, this.OD, this.Mw);
            }
            if (o(aAj)) {
                p(aAj);
            }
            setVoiceData(aAj);
            nn();
            this.Kc = aVar;
            if (this.Kc.aAj().cUe != null) {
                if (aAj.isShareThread) {
                    if (this.Kc.aAj().cUe != null) {
                        if (!this.Kc.aAj().cUe.cOY) {
                            this.OC.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.4
                                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                                public void a(View view, String str, int i, boolean z, boolean z2) {
                                    au.a(NewGridImageLayout.this.Kc.aAj().cUe, NewGridImageLayout.this.mContext, 2);
                                }
                            });
                        }
                    } else {
                        return;
                    }
                }
                if (!this.Kc.aAj().cUe.cOY) {
                    this.OC.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.5
                        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                        public void a(View view, String str, int i, boolean z, boolean z2) {
                            au.a(view, true, (List<MediaData>) NewGridImageLayout.this.OE, i, NewGridImageLayout.this.Kc.aAj().cUe.aAZ(), NewGridImageLayout.this.mFrom, NewGridImageLayout.this.Kc.aAj().cUe.cPX);
                        }
                    });
                }
                if (this.OD) {
                    if (this.Kc.aAj().cUe == null || this.Kc.aAj().cUe.cOY) {
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
            if (this.OD) {
                this.NZ.ae(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NewGridImageLayout.this.Ke != null) {
                            NewGridImageLayout.this.Ke.onClick(view);
                        }
                    }
                });
            }
            ArrayList<VoiceData.VoiceModel> aCF = (!bjVar.isShareThread || bjVar.cUe == null) ? bjVar.aCF() : bjVar.cUe.cPY;
            if (v.isEmpty(aCF)) {
                this.NZ.setVisibility(8);
                this.Oc = false;
                return;
            }
            this.NZ.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aCF.get(0);
            this.NZ.setVoiceModel(voiceModel);
            this.NZ.setTag(voiceModel);
            this.NZ.can();
            if (voiceModel != null) {
                this.NZ.xe(voiceModel.voice_status.intValue());
            }
            this.NZ.cMC();
            this.Oc = true;
        }
    }

    private void nn() {
        if (this.KA.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Ob) {
                setMarginsTop(this.NZ, NW);
            } else if (this.Oc) {
                setMarginsTop(this.NZ, NY);
            }
        } else if (this.NZ != null && this.NZ.getLayoutParams() != null) {
            if (this.Ob) {
                setMarginsTop(this.NZ, NW);
            } else if (this.Oc) {
                setMarginsTop(this.NZ, NX);
            }
        }
    }

    public void setObjectPool(b<ImageView> bVar, b<GifView> bVar2) {
        if (this.OC != null) {
            this.OC.setObjectPool(bVar, bVar2);
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
        if (this.Kc == null || this.Kc.aAj() == null) {
            return true;
        }
        if (this.Kc.aAj().getTid() == null || this.Kc.aAj().getTid().equals(bjVar.getTid())) {
            return (!bjVar.isShareThread || bjVar.cUe == null) ? !c(bjVar.aCB(), this.Kc.aAj().aCB()) : this.Kc.aAj().cUe == null || !c(bjVar.cUe.cPU, this.Kc.aAj().cUe.cPU);
        }
        return true;
    }

    private void p(bj bjVar) {
        boolean z;
        ArrayList<MediaData> arrayList;
        String b;
        ArrayList<MediaData> aCB = bjVar.aCB();
        String aCb = bjVar.aCb();
        if (!bjVar.isShareThread || bjVar.cUe == null) {
            z = false;
            arrayList = aCB;
        } else if (bjVar.cUe.cOY) {
            this.OC.setVisibility(8);
            return;
        } else {
            z = true;
            arrayList = bjVar.cUe.cPU;
        }
        if (i.azR().isShowImages() && v.getCount(arrayList) != 0) {
            this.OE.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(arrayList, i);
                if (mediaData != null && mediaData.getType() == 3 && (z || (aCb != null && aCb.equals(mediaData.getPostId() + "")))) {
                    this.OE.add(mediaData);
                }
            }
            if (v.getCount(this.OE) > 0) {
                this.OC.setVisibility(0);
                ArrayList<TbRichTextImageInfo> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < this.OE.size(); i2++) {
                    MediaData mediaData2 = (MediaData) v.getItem(this.OE, i2);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.OE.size() > 1) {
                        b = a(mediaData2);
                    } else {
                        b = b(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.setSrc(b);
                    tbRichTextImageInfo.wg(originalUrl);
                    tbRichTextImageInfo.ho(mediaData2.isLongPic());
                    if (mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(mediaData2.picWidth);
                        tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                    }
                    arrayList2.add(tbRichTextImageInfo);
                }
                this.OC.setData(arrayList2);
                return;
            }
            this.OC.setVisibility(8);
            return;
        }
        this.OC.setVisibility(8);
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
        this.NK = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    public void setTransmit(boolean z) {
        this.OD = z;
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
        if (this.OC != null) {
            this.OC.onChangeSkinType();
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.Mw = z;
    }
}

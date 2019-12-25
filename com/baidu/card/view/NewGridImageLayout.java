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
import com.baidu.tbadk.core.data.a;
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
/* loaded from: classes5.dex */
public class NewGridImageLayout extends LinearLayout implements View.OnClickListener, m<a> {
    private static final int Np = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int Nq = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int Nr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private a JB;
    private View.OnClickListener JC;
    public TextView JZ;
    private z<a> Lb;
    private int ND;
    protected boolean NN;
    private final int NV;
    public GridImageLayout NW;
    private boolean NX;
    private LinkedList<MediaData> NY;
    private com.baidu.tbadk.widget.richText.a NZ;
    private boolean Nf;
    public PlayVoiceBntNew Ns;
    private boolean Nu;
    private boolean Nv;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public NewGridImageLayout(Context context) {
        this(context, null);
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NV = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.Nf = true;
        this.Nu = false;
        this.Nv = false;
        this.NX = false;
        this.ND = 0;
        this.NN = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.JZ = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.Ns = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.Ns.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, NewGridImageLayout.this.JB);
                }
            }
        });
        this.NW = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        this.NW.setSupportGifPlay(false);
        this.NW.setCornerStyle(1);
        this.NW.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    subClickListener.a(view, NewGridImageLayout.this.JB);
                }
            }
        });
        this.NZ = new com.baidu.tbadk.widget.richText.a();
        int i = l.getScreenDimensions(this.mContext)[0];
        this.NZ.dJK = i - l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds88);
        this.NZ.dJL = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.NW.setLayoutStrategy(this.NZ);
        this.NY = new LinkedList<>();
        this.NW.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.3
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i2, boolean z, boolean z2) {
                au.a(view, NewGridImageLayout.this.NZ.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.NY, i2, NewGridImageLayout.this.JB.axx(), NewGridImageLayout.this.mFrom, true);
            }
        });
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setCornerStyle(int i) {
        this.NW.setCornerStyle(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(a aVar) {
        if (aVar != null && aVar.axx() != null) {
            bj axx = aVar.axx();
            OriginalThreadInfo originalThreadInfo = axx.cPD;
            if (originalThreadInfo != null && this.NX) {
                this.JZ.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setVisibility(8);
                if (originalThreadInfo.cKv) {
                    au.a(this.JZ, this.mTitle, new SpannableString(originalThreadInfo.title), axx, this.NV, this.NX);
                    am.setViewTextColor(this.JZ, (int) R.color.cp_cont_c);
                } else {
                    au.a(this.JZ, this.mTitle, originalThreadInfo.cLx, axx, this.NV, this.NX);
                }
            } else {
                this.JZ.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                au.a(this.mTitle, axx);
                au.a(this.JZ, this.mTitle, axx.azf(), axx, this.NV, this.NX);
            }
            if (o(axx)) {
                p(axx);
            }
            setVoiceData(axx);
            mW();
            this.JB = aVar;
            if (axx.isShareThread) {
                if (this.JB.axx().cPD != null) {
                    if (!this.JB.axx().cPD.cKv) {
                        this.NW.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.4
                            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                            public void a(View view, String str, int i, boolean z, boolean z2) {
                                au.a(NewGridImageLayout.this.JB.axx().cPD, NewGridImageLayout.this.mContext, 2);
                            }
                        });
                    }
                } else {
                    return;
                }
            } else {
                this.NW.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.5
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                    public void a(View view, String str, int i, boolean z, boolean z2) {
                        au.a(view, NewGridImageLayout.this.NZ.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.NY, i, NewGridImageLayout.this.JB.axx(), NewGridImageLayout.this.mFrom, true);
                    }
                });
            }
            if (this.NX) {
                if (this.JB.axx().cPD == null || this.JB.axx().cPD.cKv) {
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

    private void setVoiceData(bj bjVar) {
        if (bjVar != null) {
            if (this.NX) {
                this.Ns.af(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NewGridImageLayout.this.JC != null) {
                            NewGridImageLayout.this.JC.onClick(view);
                        }
                    }
                });
            }
            ArrayList<VoiceData.VoiceModel> azS = (!bjVar.isShareThread || bjVar.cPD == null) ? bjVar.azS() : bjVar.cPD.cLw;
            if (v.isEmpty(azS)) {
                this.Ns.setVisibility(8);
                this.Nv = false;
                return;
            }
            this.Ns.setVisibility(0);
            VoiceData.VoiceModel voiceModel = azS.get(0);
            this.Ns.setVoiceModel(voiceModel);
            this.Ns.setTag(voiceModel);
            this.Ns.bEM();
            if (voiceModel != null) {
                this.Ns.wL(voiceModel.voice_status.intValue());
            }
            this.Ns.cJE();
            this.Nv = true;
        }
    }

    private void mW() {
        if (this.JZ.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Nu) {
                setMarginsTop(this.Ns, Np);
            } else if (this.Nv) {
                setMarginsTop(this.Ns, Nr);
            }
        } else if (this.Ns != null && this.Ns.getLayoutParams() != null) {
            if (this.Nu) {
                setMarginsTop(this.Ns, Np);
            } else if (this.Nv) {
                setMarginsTop(this.Ns, Nq);
            }
        }
    }

    public void setObjectPool(b<ImageView> bVar, b<GifView> bVar2) {
        if (this.NW != null) {
            this.NW.setObjectPool(bVar, bVar2);
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

    public z<a> getSubClickListener() {
        return this.Lb;
    }

    public void setSubClickListener(z<a> zVar) {
        this.Lb = zVar;
    }

    private boolean o(bj bjVar) {
        if (this.JB == null || this.JB.axx() == null) {
            return true;
        }
        if (this.JB.axx().getTid() == null || this.JB.axx().getTid().equals(bjVar.getTid())) {
            return (!bjVar.isShareThread || bjVar.cPD == null) ? !c(bjVar.azO(), this.JB.axx().azO()) : this.JB.axx().cPD == null || !c(bjVar.cPD.cLs, this.JB.axx().cPD.cLs);
        }
        return true;
    }

    private void p(bj bjVar) {
        boolean z;
        ArrayList<MediaData> arrayList;
        String b;
        ArrayList<MediaData> azO = bjVar.azO();
        String azo = bjVar.azo();
        if (!bjVar.isShareThread || bjVar.cPD == null) {
            z = false;
            arrayList = azO;
        } else if (bjVar.cPD.cKv) {
            this.NW.setVisibility(8);
            return;
        } else {
            z = true;
            arrayList = bjVar.cPD.cLs;
        }
        if (v.getCount(arrayList) != 0) {
            this.NY.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(arrayList, i);
                if (mediaData != null && mediaData.getType() == 3 && (z || (azo != null && azo.equals(mediaData.getPostId() + "")))) {
                    this.NY.add(mediaData);
                }
            }
            if (v.getCount(this.NY) > 0) {
                this.NW.setVisibility(0);
                ArrayList<TbRichTextImageInfo> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < this.NY.size(); i2++) {
                    MediaData mediaData2 = (MediaData) v.getItem(this.NY, i2);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.NY.size() > 1) {
                        b = a(mediaData2);
                    } else {
                        b = b(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.setSrc(b);
                    tbRichTextImageInfo.vG(originalUrl);
                    tbRichTextImageInfo.hb(mediaData2.isLongPic());
                    if (mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(mediaData2.picWidth);
                        tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                    }
                    arrayList2.add(tbRichTextImageInfo);
                }
                this.NW.setData(arrayList2);
                return;
            }
            this.NW.setVisibility(8);
            return;
        }
        this.NW.setVisibility(8);
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
        this.Nf = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    public void setTransmit(boolean z) {
        this.NX = z;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.JC = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.JC != null) {
            this.JC.onClick(view);
        }
    }

    public void onChangeSkinType() {
        if (this.NW != null) {
            this.NW.onChangeSkinType();
        }
    }
}

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
import com.baidu.card.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
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
/* loaded from: classes8.dex */
public class NewGridImageLayout extends LinearLayout implements View.OnClickListener, n<AbsThreadDataSupport> {
    public TextView adV;
    private AbsThreadDataSupport adw;
    private View.OnClickListener adx;
    private aa<AbsThreadDataSupport> aeY;
    private boolean afL;
    protected boolean ahG;
    private final int ahM;
    public GridImageLayout ahN;
    private boolean ahO;
    private LinkedList<MediaData> ahP;
    private com.baidu.tbadk.widget.richText.a ahQ;
    private boolean aha;
    public PlayVoiceBntNew ahm;
    private boolean aho;
    private boolean ahp;
    private int ahw;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;
    private static final int ahk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int adZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int ahl = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);

    public NewGridImageLayout(Context context) {
        this(context, null);
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahM = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.aha = true;
        this.aho = false;
        this.ahp = false;
        this.ahO = false;
        this.ahw = 0;
        this.ahG = false;
        this.afL = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.adV = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.ahm = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.ahm.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, NewGridImageLayout.this.adw);
                }
            }
        });
        this.ahN = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        this.ahN.setSupportGifPlay(false);
        this.ahN.setCornerStyle(1);
        this.ahN.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa<AbsThreadDataSupport> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    subClickListener.a(view, NewGridImageLayout.this.adw);
                }
            }
        });
        this.ahQ = new com.baidu.tbadk.widget.richText.a();
        int i = l.getScreenDimensions(this.mContext)[0];
        this.ahQ.eDp = i - l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds88);
        this.ahQ.eDq = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.ahN.setLayoutStrategy(this.ahQ);
        this.ahP = new LinkedList<>();
        this.ahN.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.3
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i2, boolean z, boolean z2) {
                au.a(view, NewGridImageLayout.this.ahQ.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.ahP, i2, NewGridImageLayout.this.adw.aOi(), NewGridImageLayout.this.mFrom, true);
            }
        });
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setCornerStyle(int i) {
        this.ahN.setCornerStyle(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: b */
    public void D(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport != null && absThreadDataSupport.aOi() != null) {
            bk aOi = absThreadDataSupport.aOi();
            OriginalThreadInfo originalThreadInfo = aOi.dHm;
            if (originalThreadInfo != null && this.ahO) {
                this.adV.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setVisibility(8);
                if (originalThreadInfo.dCi) {
                    au.a(this.adV, this.mTitle, new SpannableString(originalThreadInfo.title), aOi, this.ahM, this.ahO, this.afL);
                    am.setViewTextColor(this.adV, (int) R.color.cp_cont_c);
                } else {
                    au.a(this.adV, this.mTitle, originalThreadInfo.dDh, aOi, this.ahM, this.ahO, this.afL);
                }
            } else {
                this.adV.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                au.a(this.mTitle, aOi, this.afL);
                au.a(this.adV, this.mTitle, aOi.aPZ(), aOi, this.ahM, this.ahO, this.afL);
            }
            if (p(aOi)) {
                q(aOi);
            }
            setVoiceData(aOi);
            rP();
            this.adw = absThreadDataSupport;
            if (this.adw.aOi().dHm != null) {
                if (aOi.isShareThread) {
                    if (this.adw.aOi().dHm != null) {
                        if (!this.adw.aOi().dHm.dCi) {
                            this.ahN.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.4
                                @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                                public void a(View view, String str, int i, boolean z, boolean z2) {
                                    au.a(NewGridImageLayout.this.adw.aOi().dHm, NewGridImageLayout.this.mContext, 2);
                                }
                            });
                        }
                    } else {
                        return;
                    }
                }
                if (!this.adw.aOi().dHm.dCi) {
                    this.ahN.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.5
                        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                        public void a(View view, String str, int i, boolean z, boolean z2) {
                            au.a(view, true, (List<MediaData>) NewGridImageLayout.this.ahP, i, NewGridImageLayout.this.adw.aOi().dHm.aPf(), NewGridImageLayout.this.mFrom, NewGridImageLayout.this.adw.aOi().dHm.dDf);
                        }
                    });
                }
                if (this.ahO) {
                    if (this.adw.aOi().dHm == null || this.adw.aOi().dHm.dCi) {
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

    private void setVoiceData(bk bkVar) {
        if (bkVar != null) {
            if (this.ahO) {
                this.ahm.ah(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NewGridImageLayout.this.adx != null) {
                            NewGridImageLayout.this.adx.onClick(view);
                        }
                    }
                });
            }
            ArrayList<VoiceData.VoiceModel> aQL = (!bkVar.isShareThread || bkVar.dHm == null) ? bkVar.aQL() : bkVar.dHm.dDg;
            if (v.isEmpty(aQL)) {
                this.ahm.setVisibility(8);
                this.ahp = false;
                return;
            }
            this.ahm.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aQL.get(0);
            this.ahm.setVoiceModel(voiceModel);
            this.ahm.setTag(voiceModel);
            this.ahm.crv();
            if (voiceModel != null) {
                this.ahm.yk(voiceModel.voice_status.intValue());
            }
            this.ahm.dfa();
            this.ahp = true;
        }
    }

    private void rP() {
        if (this.adV.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.aho) {
                setMarginsTop(this.ahm, ahk);
            } else if (this.ahp) {
                setMarginsTop(this.ahm, ahl);
            }
        } else if (this.ahm != null && this.ahm.getLayoutParams() != null) {
            if (this.aho) {
                setMarginsTop(this.ahm, ahk);
            } else if (this.ahp) {
                setMarginsTop(this.ahm, adZ);
            }
        }
    }

    public void setObjectPool(b<ImageView> bVar, b<GifView> bVar2) {
        if (this.ahN != null) {
            this.ahN.setObjectPool(bVar, bVar2);
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
        return this.aeY;
    }

    public void setSubClickListener(aa<AbsThreadDataSupport> aaVar) {
        this.aeY = aaVar;
    }

    private boolean p(bk bkVar) {
        if (this.adw == null || this.adw.aOi() == null) {
            return true;
        }
        if (this.adw.aOi().getTid() == null || this.adw.aOi().getTid().equals(bkVar.getTid())) {
            return (!bkVar.isShareThread || bkVar.dHm == null) ? !c(bkVar.aQH(), this.adw.aOi().aQH()) : this.adw.aOi().dHm == null || !c(bkVar.dHm.dDc, this.adw.aOi().dHm.dDc);
        }
        return true;
    }

    private void q(bk bkVar) {
        boolean z;
        ArrayList<MediaData> arrayList;
        String b;
        ArrayList<MediaData> aQH = bkVar.aQH();
        String aQh = bkVar.aQh();
        if (!bkVar.isShareThread || bkVar.dHm == null) {
            z = false;
            arrayList = aQH;
        } else if (bkVar.dHm.dCi) {
            this.ahN.setVisibility(8);
            return;
        } else {
            z = true;
            arrayList = bkVar.dHm.dDc;
        }
        if (k.aNQ().isShowImages() && v.getCount(arrayList) != 0) {
            this.ahP.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(arrayList, i);
                if (mediaData != null && mediaData.getType() == 3 && (z || (aQh != null && aQh.equals(mediaData.getPostId() + "")))) {
                    this.ahP.add(mediaData);
                }
            }
            if (v.getCount(this.ahP) > 0) {
                this.ahN.setVisibility(0);
                ArrayList<TbRichTextImageInfo> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < this.ahP.size(); i2++) {
                    MediaData mediaData2 = (MediaData) v.getItem(this.ahP, i2);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.ahP.size() > 1) {
                        b = a(mediaData2);
                    } else {
                        b = b(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.setSrc(b);
                    tbRichTextImageInfo.zb(originalUrl);
                    tbRichTextImageInfo.iJ(mediaData2.isLongPic());
                    if (mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(mediaData2.picWidth);
                        tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                    }
                    arrayList2.add(tbRichTextImageInfo);
                }
                this.ahN.setData(arrayList2);
                return;
            }
            this.ahN.setVisibility(8);
            return;
        }
        this.ahN.setVisibility(8);
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
        this.aha = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    public void setTransmit(boolean z) {
        this.ahO = z;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.adx = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.adx != null) {
            this.adx.onClick(view);
        }
    }

    public void onChangeSkinType() {
        if (this.ahN != null) {
            this.ahN.onChangeSkinType();
        }
    }

    public void setNeedFrsTabName(boolean z) {
        this.afL = z;
    }
}

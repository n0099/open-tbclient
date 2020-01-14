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
/* loaded from: classes6.dex */
public class NewGridImageLayout extends LinearLayout implements View.OnClickListener, m<a> {
    private static final int Nt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int Nu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20);
    private static final int Nv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7);
    private a JH;
    private View.OnClickListener JI;
    public TextView Kf;
    private z<a> Lh;
    private int NH;
    protected boolean NT;
    private final int NZ;
    private boolean Nj;
    public PlayVoiceBntNew Nw;
    private boolean Ny;
    private boolean Nz;
    public GridImageLayout Oa;
    private boolean Ob;
    private LinkedList<MediaData> Oc;
    private com.baidu.tbadk.widget.richText.a Oe;
    private Context mContext;
    private String mFrom;
    public TextView mTitle;

    public NewGridImageLayout(Context context) {
        this(context, null);
    }

    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NZ = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
        this.Nj = true;
        this.Ny = false;
        this.Nz = false;
        this.Ob = false;
        this.NH = 0;
        this.NT = false;
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Kf = (TextView) findViewById(R.id.thread_card_abstract);
        this.mTitle = (TextView) findViewById(R.id.thread_card_title);
        this.Nw = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
        this.Nw.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("2");
                    subClickListener.a(view, NewGridImageLayout.this.JH);
                }
            }
        });
        this.Oa = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
        this.Oa.setSupportGifPlay(false);
        this.Oa.setCornerStyle(1);
        this.Oa.setAfterClickListener(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z<a> subClickListener = NewGridImageLayout.this.getSubClickListener();
                if (subClickListener != null) {
                    view.setTag("1");
                    subClickListener.a(view, NewGridImageLayout.this.JH);
                }
            }
        });
        this.Oe = new com.baidu.tbadk.widget.richText.a();
        int i = l.getScreenDimensions(this.mContext)[0];
        this.Oe.dJT = i - l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds88);
        this.Oe.dJU = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        this.Oa.setLayoutStrategy(this.Oe);
        this.Oc = new LinkedList<>();
        this.Oa.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.3
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i2, boolean z, boolean z2) {
                au.a(view, NewGridImageLayout.this.Oe.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.Oc, i2, NewGridImageLayout.this.JH.axQ(), NewGridImageLayout.this.mFrom, true);
            }
        });
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setCornerStyle(int i) {
        this.Oa.setCornerStyle(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(a aVar) {
        if (aVar != null && aVar.axQ() != null) {
            bj axQ = aVar.axQ();
            OriginalThreadInfo originalThreadInfo = axQ.cPN;
            if (originalThreadInfo != null && this.Ob) {
                this.Kf.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize39));
                this.mTitle.setVisibility(8);
                if (originalThreadInfo.cKG) {
                    au.a(this.Kf, this.mTitle, new SpannableString(originalThreadInfo.title), axQ, this.NZ, this.Ob);
                    am.setViewTextColor(this.Kf, (int) R.color.cp_cont_c);
                } else {
                    au.a(this.Kf, this.mTitle, originalThreadInfo.cLH, axQ, this.NZ, this.Ob);
                }
            } else {
                this.Kf.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                this.mTitle.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbfontsize44));
                au.a(this.mTitle, axQ);
                au.a(this.Kf, this.mTitle, axQ.azy(), axQ, this.NZ, this.Ob);
            }
            if (o(axQ)) {
                p(axQ);
            }
            setVoiceData(axQ);
            mX();
            this.JH = aVar;
            if (axQ.isShareThread) {
                if (this.JH.axQ().cPN != null) {
                    if (!this.JH.axQ().cPN.cKG) {
                        this.Oa.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.4
                            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                            public void a(View view, String str, int i, boolean z, boolean z2) {
                                au.a(NewGridImageLayout.this.JH.axQ().cPN, NewGridImageLayout.this.mContext, 2);
                            }
                        });
                    }
                } else {
                    return;
                }
            } else {
                this.Oa.setOnImageClickListener(new TbRichTextView.i() { // from class: com.baidu.card.view.NewGridImageLayout.5
                    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
                    public void a(View view, String str, int i, boolean z, boolean z2) {
                        au.a(view, NewGridImageLayout.this.Oe.mIsFromCDN, (List<MediaData>) NewGridImageLayout.this.Oc, i, NewGridImageLayout.this.JH.axQ(), NewGridImageLayout.this.mFrom, true);
                    }
                });
            }
            if (this.Ob) {
                if (this.JH.axQ().cPN == null || this.JH.axQ().cPN.cKG) {
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
            if (this.Ob) {
                this.Nw.ae(new View.OnClickListener() { // from class: com.baidu.card.view.NewGridImageLayout.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (NewGridImageLayout.this.JI != null) {
                            NewGridImageLayout.this.JI.onClick(view);
                        }
                    }
                });
            }
            ArrayList<VoiceData.VoiceModel> aAl = (!bjVar.isShareThread || bjVar.cPN == null) ? bjVar.aAl() : bjVar.cPN.cLG;
            if (v.isEmpty(aAl)) {
                this.Nw.setVisibility(8);
                this.Nz = false;
                return;
            }
            this.Nw.setVisibility(0);
            VoiceData.VoiceModel voiceModel = aAl.get(0);
            this.Nw.setVoiceModel(voiceModel);
            this.Nw.setTag(voiceModel);
            this.Nw.bFO();
            if (voiceModel != null) {
                this.Nw.wQ(voiceModel.voice_status.intValue());
            }
            this.Nw.cKK();
            this.Nz = true;
        }
    }

    private void mX() {
        if (this.Kf.getVisibility() != 0 && this.mTitle.getVisibility() != 0) {
            if (this.Ny) {
                setMarginsTop(this.Nw, Nt);
            } else if (this.Nz) {
                setMarginsTop(this.Nw, Nv);
            }
        } else if (this.Nw != null && this.Nw.getLayoutParams() != null) {
            if (this.Ny) {
                setMarginsTop(this.Nw, Nt);
            } else if (this.Nz) {
                setMarginsTop(this.Nw, Nu);
            }
        }
    }

    public void setObjectPool(b<ImageView> bVar, b<GifView> bVar2) {
        if (this.Oa != null) {
            this.Oa.setObjectPool(bVar, bVar2);
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
        return this.Lh;
    }

    public void setSubClickListener(z<a> zVar) {
        this.Lh = zVar;
    }

    private boolean o(bj bjVar) {
        if (this.JH == null || this.JH.axQ() == null) {
            return true;
        }
        if (this.JH.axQ().getTid() == null || this.JH.axQ().getTid().equals(bjVar.getTid())) {
            return (!bjVar.isShareThread || bjVar.cPN == null) ? !c(bjVar.aAh(), this.JH.axQ().aAh()) : this.JH.axQ().cPN == null || !c(bjVar.cPN.cLC, this.JH.axQ().cPN.cLC);
        }
        return true;
    }

    private void p(bj bjVar) {
        boolean z;
        ArrayList<MediaData> arrayList;
        String b;
        ArrayList<MediaData> aAh = bjVar.aAh();
        String azH = bjVar.azH();
        if (!bjVar.isShareThread || bjVar.cPN == null) {
            z = false;
            arrayList = aAh;
        } else if (bjVar.cPN.cKG) {
            this.Oa.setVisibility(8);
            return;
        } else {
            z = true;
            arrayList = bjVar.cPN.cLC;
        }
        if (v.getCount(arrayList) != 0) {
            this.Oc.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(arrayList, i);
                if (mediaData != null && mediaData.getType() == 3 && (z || (azH != null && azH.equals(mediaData.getPostId() + "")))) {
                    this.Oc.add(mediaData);
                }
            }
            if (v.getCount(this.Oc) > 0) {
                this.Oa.setVisibility(0);
                ArrayList<TbRichTextImageInfo> arrayList2 = new ArrayList<>();
                for (int i2 = 0; i2 < this.Oc.size(); i2++) {
                    MediaData mediaData2 = (MediaData) v.getItem(this.Oc, i2);
                    String originalUrl = mediaData2.getOriginalUrl();
                    if (this.Oc.size() > 1) {
                        b = a(mediaData2);
                    } else {
                        b = b(mediaData2);
                    }
                    TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                    tbRichTextImageInfo.setSrc(b);
                    tbRichTextImageInfo.vK(originalUrl);
                    tbRichTextImageInfo.hg(mediaData2.isLongPic());
                    if (mediaData2.picWidth > 0 && mediaData2.picHeight > 0) {
                        tbRichTextImageInfo.setWidth(mediaData2.picWidth);
                        tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                    }
                    arrayList2.add(tbRichTextImageInfo);
                }
                this.Oa.setData(arrayList2);
                return;
            }
            this.Oa.setVisibility(8);
            return;
        }
        this.Oa.setVisibility(8);
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
        this.Nj = z;
    }

    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
    }

    public void setTransmit(boolean z) {
        this.Ob = z;
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        this.JI = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.JI != null) {
            this.JI.onClick(view);
        }
    }

    public void onChangeSkinType() {
        if (this.Oa != null) {
            this.Oa.onChangeSkinType();
        }
    }
}

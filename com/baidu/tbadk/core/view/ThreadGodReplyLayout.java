package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.s;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int euC = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private View.OnClickListener aiC;
    private TextView aiH;
    private View.OnClickListener ajb;
    private boolean ajt;
    private bw ajz;
    private int eaT;
    private AgreeView etA;
    private TextView euD;
    private PlayVoiceBntNew euE;
    private FrameLayout euF;
    private TextView euG;
    private ClickableHeaderImageView euH;
    private PostData euI;
    private TbRichTextVoiceInfo euJ;
    private int euK;
    private final float euL;
    private View.OnClickListener euM;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.ajz = null;
        this.mSkinType = 3;
        this.euL = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.ajb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.euI != null && ThreadGodReplyLayout.this.euI.beE() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.euI.beE().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.euI.beE().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.euI.beE().getUserId(), ThreadGodReplyLayout.this.euI.beE().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.euI.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.aiC != null) {
                        ThreadGodReplyLayout.this.aiC.onClick(view);
                    }
                }
            }
        };
        this.euM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.aiC != null) {
                    ThreadGodReplyLayout.this.aiC.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajz = null;
        this.mSkinType = 3;
        this.euL = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.ajb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.euI != null && ThreadGodReplyLayout.this.euI.beE() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.euI.beE().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.euI.beE().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.euI.beE().getUserId(), ThreadGodReplyLayout.this.euI.beE().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.euI.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.aiC != null) {
                        ThreadGodReplyLayout.this.aiC.onClick(view);
                    }
                }
            }
        };
        this.euM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.aiC != null) {
                    ThreadGodReplyLayout.this.aiC.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajz = null;
        this.mSkinType = 3;
        this.euL = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.ajb = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.euI != null && ThreadGodReplyLayout.this.euI.beE() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.euI.beE().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.euI.beE().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.euI.beE().getUserId(), ThreadGodReplyLayout.this.euI.beE().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.euI.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.aiC != null) {
                        ThreadGodReplyLayout.this.aiC.onClick(view);
                    }
                }
            }
        };
        this.euM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.aiC != null) {
                    ThreadGodReplyLayout.this.aiC.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.euH = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.euH.setIsRound(true);
        this.euH.setClickable(true);
        this.aiH = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.aiH.setOnClickListener(this.ajb);
        this.etA = (AgreeView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.etA.setAfterClickListener(this.euM);
        this.etA.setAgreeAlone(true);
        this.euD = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.euE = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.euE.setVisibility(8);
        this.euF = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.euK = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.eaT = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.euK * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.eaT, this.eaT);
            layoutParams.leftMargin = (this.eaT + this.euK) * i;
            this.euF.addView(tbImageView, layoutParams);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(ap.getColor(R.color.cp_border_a));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setTag(R.id.god_reply_image_layout, Integer.valueOf(i));
            tbImageView.setTagTextSize((int) getResources().getDimension(R.dimen.tbfontsize26));
            tbImageView.setTagPaddingDis(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6));
            tbImageView.setOnClickListener(this);
            tbImageView.setPlaceHolder(2);
        }
        this.euF.setVisibility(8);
        this.euG = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.ajt = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bkZ() {
        if (this.euH != null) {
            this.euH.setPlaceHolder(1);
        }
        int childCount = this.euF.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.euF.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public void setData(bw bwVar) {
        this.ajz = bwVar;
        setData(bwVar != null ? bwVar.bgh() : null);
    }

    public void setData(PostData postData) {
        if (postData == null || postData.beE() == null || postData.beE().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.euI = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.dwM()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.euJ != null && this.euJ.byz() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds30));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds25));
        }
        if (!bi(this.euD) && !bi(this.euF) && !bi(this.euE)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.euD.setVisibility(8);
            return;
        }
        this.euD.setVisibility(0);
        if (!v.a(this.euL, this.euD.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.euD.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        s.cbY().e(new aq("c13348"));
                        ThreadGodReplyLayout.this.euD.setMaxLines(15);
                        ThreadGodReplyLayout.this.euD.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.euD.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.euD.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.euD.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.euD.setText(((Object) ThreadGodReplyLayout.this.euD.getText().subSequence(0, ThreadGodReplyLayout.this.euD.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.euD.getPaint(), (int) this.euL, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.euL;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.euL - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.euD.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.euD.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.euD.setText(spannableStringBuilder);
                this.euD.setOnTouchListener(new com.baidu.tieba.view.i(spannableStringBuilder));
                s.cbY().e(new aq("c13347"));
            } else {
                return;
            }
        }
        bla();
    }

    private boolean bi(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.euH.setData(postData.beE());
            this.aiH.setText(at.cutChineseAndEnglishWithSuffix(postData.beE().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.ajz != null) {
                postData.bgv().threadId = this.ajz.getTid();
            }
            postData.bgv().threadId = String.valueOf(postData.getTid());
            postData.bgv().objType = 3;
            this.etA.setData(postData.bgv());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> bxx;
        if (tbRichText == null || (bxx = tbRichText.bxx()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = bxx.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.bxE());
            } else if (next.getType() == 17) {
                String str = next.bxI().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    spannableStringBuilder.append((CharSequence) "[表情]");
                }
            } else if (next.getType() == 20) {
                spannableStringBuilder.append((CharSequence) "[表情]");
            }
        }
        if (spannableStringBuilder.length() > 0) {
            for (com.baidu.tbadk.widget.richText.f fVar : (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length() - 1, com.baidu.tbadk.widget.richText.f.class)) {
                spannableStringBuilder.removeSpan(fVar);
            }
            for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length() - 1, ForegroundColorSpan.class)) {
                spannableStringBuilder.removeSpan(foregroundColorSpan);
            }
        }
        return spannableStringBuilder;
    }

    public void b(PostData postData) {
        if (this.mImageList == null) {
            this.mImageList = new ArrayList();
        } else {
            this.mImageList.clear();
        }
        if (!com.baidu.tbadk.core.k.bbM().isShowImages()) {
            this.euF.setVisibility(8);
            this.euG.setVisibility(8);
            return;
        }
        TbRichText dwM = postData.dwM();
        if (dwM == null || dwM.bxx() == null) {
            this.euF.setVisibility(8);
            this.euG.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = dwM.bxx().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.bt(euC, euC);
                if (next.getType() == 8) {
                    this.mImageList.add(next.bxD());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.euF.setVisibility(8);
            this.euG.setVisibility(8);
            return;
        }
        this.euF.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = 0;
        for (int i2 = 0; i2 < this.euF.getChildCount(); i2++) {
            View childAt = this.euF.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.bwn();
                tbImageView.setRadius(dimens);
                tbImageView.qN(15);
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.bxT())) {
                        tbImageView.startLoad(tbRichTextImageInfo.bxT(), this.ajt ? 13 : 14, false);
                        tbImageView.setVisibility(0);
                        i++;
                    } else {
                        tbImageView.setVisibility(8);
                    }
                } else {
                    tbImageView.setVisibility(8);
                }
            }
            i = i;
        }
        if (this.mImageList.size() > 5) {
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.eaT, this.eaT);
            layoutParams.leftMargin = (this.eaT + this.euK) * 4;
            this.euF.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.euG.setVisibility(0);
            this.euG.setText("+" + (this.mImageList.size() - 5));
            this.euG.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.eaT - ThreadGodReplyLayout.this.euG.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.euG.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.euG.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.euG.setVisibility(8);
    }

    public void c(PostData postData) {
        this.euJ = postData.bxF();
        if (this.euJ == null) {
            this.euE.setVisibility(8);
            return;
        }
        this.euE.setVisibility(0);
        this.euE.setTag(this.euJ);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setViewTextColor(this.aiH, R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.bjQ().of(R.color.cp_bg_line_g).V(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).aZ(this.mRootView);
            bla();
            bkZ();
            this.etA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.euE.changeSkin();
        }
    }

    private void bla() {
        m.a(this.euD, this.ajz == null ? null : this.ajz.getTid(), R.color.cp_cont_b, R.color.cp_cont_d);
    }

    public TextView getGodReplyContent() {
        return this.euD;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.bxQ());
            }
            String str = "";
            String str2 = "";
            if (this.ajz != null) {
                str = this.ajz.beI();
                str2 = this.ajz.getTid();
            }
            ImageViewerConfig.a aVar = new ImageViewerConfig.a();
            aVar.x(arrayList).mM(intValue).yQ(str).yS(str2).hI(true).yT(arrayList.get(0)).hJ(true).r(this.ajz).hO(false);
            ImageViewerConfig dP = aVar.dP(getContext());
            dP.getIntent().putExtra("from", this.mFrom);
            dP.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, dP));
            if (this.aiC != null) {
                this.aiC.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiC = onClickListener;
    }
}

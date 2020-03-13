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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.card.r;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int diy = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private View.OnClickListener NG;
    private boolean NJ;
    private bj NQ;
    private View.OnClickListener Nh;
    private TextView Nl;
    private int cRh;
    private AgreeView dht;
    private PlayVoiceBntNew diA;
    private FrameLayout diB;
    private TextView diC;
    private ClickableHeaderImageView diD;
    private PostData diE;
    private TbRichTextVoiceInfo diF;
    private int diG;
    private final float diH;
    private View.OnClickListener diI;
    private TextView diz;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.NQ = null;
        this.mSkinType = 3;
        this.diH = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.NG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.diE != null && ThreadGodReplyLayout.this.diE.aCo() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.diE.aCo().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.diE.aCo().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.diE.aCo().getUserId(), ThreadGodReplyLayout.this.diE.aCo().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.diE.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.Nh != null) {
                        ThreadGodReplyLayout.this.Nh.onClick(view);
                    }
                }
            }
        };
        this.diI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.Nh != null) {
                    ThreadGodReplyLayout.this.Nh.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NQ = null;
        this.mSkinType = 3;
        this.diH = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.NG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.diE != null && ThreadGodReplyLayout.this.diE.aCo() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.diE.aCo().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.diE.aCo().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.diE.aCo().getUserId(), ThreadGodReplyLayout.this.diE.aCo().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.diE.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.Nh != null) {
                        ThreadGodReplyLayout.this.Nh.onClick(view);
                    }
                }
            }
        };
        this.diI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.Nh != null) {
                    ThreadGodReplyLayout.this.Nh.onClick(view);
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.NQ = null;
        this.mSkinType = 3;
        this.diH = com.baidu.adp.lib.util.l.getScreenSize((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.NG = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.diE != null && ThreadGodReplyLayout.this.diE.aCo() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.diE.aCo().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.diE.aCo().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.diE.aCo().getUserId(), ThreadGodReplyLayout.this.diE.aCo().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.diE.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.Nh != null) {
                        ThreadGodReplyLayout.this.Nh.onClick(view);
                    }
                }
            }
        };
        this.diI = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.Nh != null) {
                    ThreadGodReplyLayout.this.Nh.onClick(view);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.diD = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.diD.setIsRound(true);
        this.diD.setClickable(true);
        this.Nl = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.Nl.setOnClickListener(this.NG);
        this.dht = (AgreeView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.dht.setAfterClickListener(this.diI);
        this.dht.setAgreeAlone(true);
        this.diz = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.diA = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.diA.setVisibility(8);
        this.diB = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
        this.diG = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10);
        this.cRh = (((equipmentWidth - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.diG * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.cRh, this.cRh);
            layoutParams.leftMargin = (this.cRh + this.diG) * i;
            this.diB.addView(tbImageView, layoutParams);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(am.getColor(R.color.cp_border_a));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setTag(R.id.god_reply_image_layout, Integer.valueOf(i));
            tbImageView.setTagTextSize((int) getResources().getDimension(R.dimen.tbfontsize26));
            tbImageView.setTagPaddingDis(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds6));
            tbImageView.setOnClickListener(this);
            tbImageView.setPlaceHolder(2);
        }
        this.diB.setVisibility(8);
        this.diC = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.NJ = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aIf() {
        if (this.diD != null) {
            this.diD.setPlaceHolder(1);
        }
        int childCount = this.diB.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.diB.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public void setData(bj bjVar) {
        this.NQ = bjVar;
        setData(bjVar != null ? bjVar.aDM() : null);
    }

    public void setData(PostData postData) {
        if (postData == null || postData.aCo() == null || postData.aCo().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.diE = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.cLd()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.diF != null && this.diF.aUR() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds30));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds25));
        }
        if (!aY(this.diz) && !aY(this.diB) && !aY(this.diA)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.diz.setVisibility(8);
            return;
        }
        this.diz.setVisibility(0);
        if (!v.a(this.diH, this.diz.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.diz.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.f(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.f, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        r.bvh().d(new an("c13348"));
                        ThreadGodReplyLayout.this.diz.setMaxLines(15);
                        ThreadGodReplyLayout.this.diz.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.diz.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.diz.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.diz.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.diz.setText(((Object) ThreadGodReplyLayout.this.diz.getText().subSequence(0, ThreadGodReplyLayout.this.diz.getLayout().getLineEnd(14) - 1)) + StringHelper.STRING_MORE);
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.diz.getPaint(), (int) this.diH, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.diH;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.diH - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.diz.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.diz.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.diz.setText(spannableStringBuilder);
                this.diz.setOnTouchListener(new com.baidu.tieba.view.h(spannableStringBuilder));
                r.bvh().d(new an("c13347"));
            } else {
                return;
            }
        }
        aIg();
    }

    private boolean aY(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.diD.setData(postData.aCo());
            this.Nl.setText(aq.cutChineseAndEnglishWithSuffix(postData.aCo().getName_show(), 14, StringHelper.STRING_MORE) + "：");
            if (this.NQ != null) {
                postData.aEa().threadId = this.NQ.getTid();
            }
            postData.aEa().threadId = String.valueOf(postData.getTid());
            postData.aEa().objType = 3;
            this.dht.setData(postData.aEa());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> aTT;
        if (tbRichText == null || (aTT = tbRichText.aTT()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = aTT.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.aUa());
            } else if (next.getType() == 17) {
                String str = next.aUe().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.i.azO().isShowImages()) {
            this.diB.setVisibility(8);
            this.diC.setVisibility(8);
            return;
        }
        TbRichText cLd = postData.cLd();
        if (cLd == null || cLd.aTT() == null) {
            this.diB.setVisibility(8);
            this.diC.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = cLd.aTT().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.aU(diy, diy);
                if (next.getType() == 8) {
                    this.mImageList.add(next.aTZ());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.diB.setVisibility(8);
            this.diC.setVisibility(8);
            return;
        }
        this.diB.setVisibility(0);
        int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int i = 0;
        for (int i2 = 0; i2 < this.diB.getChildCount(); i2++) {
            View childAt = this.diB.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.aST();
                tbImageView.setRadius(dimens);
                tbImageView.mU(15);
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.aUm())) {
                        tbImageView.startLoad(tbRichTextImageInfo.aUm(), this.NJ ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.cRh, this.cRh);
            layoutParams.leftMargin = (this.cRh + this.diG) * 4;
            this.diB.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.diC.setVisibility(0);
            this.diC.setText("+" + (this.mImageList.size() - 5));
            this.diC.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int dimens2 = com.baidu.adp.lib.util.l.getDimens(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.cRh - ThreadGodReplyLayout.this.diC.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.diC.getLayoutParams();
                    layoutParams2.setMargins(0, dimens2, dimens2, 0);
                    ThreadGodReplyLayout.this.diC.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.diC.setVisibility(8);
    }

    public void c(PostData postData) {
        this.diF = postData.aUb();
        if (this.diF == null) {
            this.diA.setVisibility(8);
            return;
        }
        this.diA.setVisibility(0);
        this.diA.setTag(this.diF);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setViewTextColor(this.Nl, (int) R.color.cp_cont_b);
            com.baidu.tbadk.core.util.e.a.aHb().kC(R.color.cp_bg_line_g).af(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds10)).aQ(this.mRootView);
            aIg();
            aIf();
            this.dht.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.diA.bHt();
        }
    }

    private void aIg() {
        com.baidu.tieba.card.l.a(this.diz, this.NQ == null ? null : this.NQ.getTid(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    public TextView getGodReplyContent() {
        return this.diz;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.aUj());
            }
            String str = "";
            String str2 = "";
            if (this.NQ != null) {
                str = this.NQ.aCt();
                str2 = this.NQ.getTid();
            }
            ImageViewerConfig createConfig = new ImageViewerConfig(getContext()).createConfig(arrayList, intValue, str, "", str2, true, arrayList.get(0), true);
            createConfig.getIntent().putExtra("from", this.mFrom);
            createConfig.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            createConfig.setIsShowHost(false);
            createConfig.setThreadData(this.NQ);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
            if (this.Nh != null) {
                this.Nh.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Nh = onClickListener;
    }
}

package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.card.t;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int bTg = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds42);
    private View.OnClickListener ZN;
    private boolean ZQ;
    private TextView Zy;
    private int bAQ;
    private View.OnClickListener bNw;
    private TextView bTh;
    private PlayVoiceBntNew bTi;
    private FrameLayout bTj;
    private TextView bTk;
    private ClickableHeaderImageView bTl;
    private AgreeAloneView bTm;
    private bg bTn;
    private PostData bTo;
    private TbRichTextVoiceInfo bTp;
    private int bTq;
    private final float bTr;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.bTn = null;
        this.mSkinType = 3;
        this.bTr = com.baidu.adp.lib.util.l.s((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds70) * 2);
        this.ZN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.bTo != null && ThreadGodReplyLayout.this.bTo.YO() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.bTo.YO().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.bTo.YO().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.bTo.YO().getUserId(), ThreadGodReplyLayout.this.bTo.YO().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.bTo.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.bNw != null) {
                        ThreadGodReplyLayout.this.bNw.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTn = null;
        this.mSkinType = 3;
        this.bTr = com.baidu.adp.lib.util.l.s((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds70) * 2);
        this.ZN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.bTo != null && ThreadGodReplyLayout.this.bTo.YO() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.bTo.YO().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.bTo.YO().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.bTo.YO().getUserId(), ThreadGodReplyLayout.this.bTo.YO().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.bTo.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.bNw != null) {
                        ThreadGodReplyLayout.this.bNw.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bTn = null;
        this.mSkinType = 3;
        this.bTr = com.baidu.adp.lib.util.l.s((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds70) * 2);
        this.ZN = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.bTo != null && ThreadGodReplyLayout.this.bTo.YO() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.bTo.YO().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.bTo.YO().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.bTo.YO().getUserId(), ThreadGodReplyLayout.this.bTo.YO().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.bTo.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.bNw != null) {
                        ThreadGodReplyLayout.this.bNw.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(d.h.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(d.g.god_comment_layout);
        this.bTl = (ClickableHeaderImageView) this.mView.findViewById(d.g.god_reply_user_pendant_header);
        this.bTl.setIsRound(true);
        this.bTl.setClickable(true);
        this.Zy = (TextView) this.mView.findViewById(d.g.god_reply_username_text);
        this.Zy.setOnClickListener(this.ZN);
        this.bTm = (AgreeAloneView) this.mView.findViewById(d.g.god_reply_agree_view);
        this.bTh = (TextView) this.mView.findViewById(d.g.god_reply_content);
        this.bTi = (PlayVoiceBntNew) this.mView.findViewById(d.g.god_reply_voice_btn);
        this.bTi.setVisibility(8);
        this.bTj = (FrameLayout) this.mView.findViewById(d.g.god_reply_image_layout);
        int aO = com.baidu.adp.lib.util.l.aO(getContext());
        this.bTq = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds10);
        this.bAQ = (((aO - (com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds44) * 2)) - (com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds26) * 2)) - (this.bTq * 4)) / 5;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.bAQ, this.bAQ);
            layoutParams.leftMargin = (this.bAQ + this.bTq) * i;
            this.bTj.addView(tbImageView, layoutParams);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds1));
            tbImageView.setBorderColor(al.getColor(d.C0277d.black_alpha8));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setTag(d.g.god_reply_image_layout, Integer.valueOf(i));
            tbImageView.setTagTextSize((int) getResources().getDimension(d.e.tbfontsize26));
            tbImageView.setTagPaddingDis(com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds6), com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds6));
            tbImageView.setOnClickListener(this);
            int ai = com.baidu.tbadk.util.e.ai(arrayList);
            tbImageView.setDefaultBgResource(ai);
            arrayList.add(Integer.valueOf(ai));
        }
        this.bTj.setVisibility(8);
        this.bTk = (TextView) this.mView.findViewById(d.g.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.ZQ = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aeX() {
        if (this.bTl != null) {
            this.bTl.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        }
        int childCount = this.bTj.getChildCount();
        if (childCount > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.bTj.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    int ai = com.baidu.tbadk.util.e.ai(arrayList);
                    ((TbImageView) childAt).setDefaultBgResource(ai);
                    arrayList.add(Integer.valueOf(ai));
                }
            }
        }
    }

    public void setData(bg bgVar) {
        this.bTn = bgVar;
        setData(bgVar.aam());
    }

    public void setData(PostData postData) {
        if (postData == null || postData.YO() == null || postData.YO().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.bTo = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.cer()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.bTp != null && this.bTp.atq() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds30));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds25));
        }
        if (!aP(this.bTh) && !aP(this.bTj) && !aP(this.bTi)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.bTh.setVisibility(8);
            return;
        }
        if (!v.a(this.bTr, this.bTh.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.bTh.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(d.j.god_reply_expand_flag));
            Drawable drawable = al.getDrawable(d.f.icon_common_arrow_blue);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.c(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        t.aQD().b(new am("c13348"));
                        ThreadGodReplyLayout.this.bTh.setMaxLines(15);
                        ThreadGodReplyLayout.this.bTh.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.bTh.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.bTh.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.bTh.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.bTh.setText(((Object) ThreadGodReplyLayout.this.bTh.getText().subSequence(0, ThreadGodReplyLayout.this.bTh.getLayout().getLineEnd(14) - 1)) + "...");
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.bTh.getPaint(), (int) this.bTr, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.bTr;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.bTr - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.bTh.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.bTh.getPaint().measureText(subSequence.toString()) + f) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                spannableStringBuilder.setSpan(new ImageSpan(drawable, 1), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 17);
                this.bTh.setText(spannableStringBuilder);
                this.bTh.setOnTouchListener(new com.baidu.tieba.view.k(spannableStringBuilder));
                t.aQD().b(new am("c13347"));
            } else {
                return;
            }
        }
        if (this.bTn != null) {
            com.baidu.tieba.card.n.a(this.bTh, this.bTn.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        }
    }

    private boolean aP(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.bTl.setData(postData.YO());
            this.Zy.setText(ap.g(postData.YO().getName_show(), 14, "...") + "：");
            if (this.bTn != null) {
                postData.aaE().threadId = this.bTn.getTid();
            }
            postData.aaE().threadId = String.valueOf(postData.getTid());
            postData.aaE().objType = 3;
            this.bTm.setData(postData.aaE());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> ast;
        if (tbRichText == null || (ast = tbRichText.ast()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = ast.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.asB());
            } else if (next.getType() == 17) {
                String str = next.asF().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    spannableStringBuilder.append((CharSequence) "[表情]");
                }
            } else if (next.getType() == 20) {
                spannableStringBuilder.append((CharSequence) "[表情]");
            }
        }
        if (spannableStringBuilder.length() > 0) {
            for (com.baidu.tbadk.widget.richText.c cVar : (com.baidu.tbadk.widget.richText.c[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length() - 1, com.baidu.tbadk.widget.richText.c.class)) {
                spannableStringBuilder.removeSpan(cVar);
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
        if (!com.baidu.tbadk.core.i.Wv().Wz()) {
            this.bTj.setVisibility(8);
            this.bTk.setVisibility(8);
            return;
        }
        TbRichText cer = postData.cer();
        if (cer == null || cer.ast() == null) {
            this.bTj.setVisibility(8);
            this.bTk.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = cer.ast().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.at(bTg, bTg);
                if (next.getType() == 8) {
                    this.mImageList.add(next.asA());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.bTj.setVisibility(8);
            this.bTk.setVisibility(8);
            return;
        }
        this.bTj.setVisibility(0);
        int h = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds20);
        int i = 0;
        for (int i2 = 0; i2 < this.bTj.getChildCount(); i2++) {
            View childAt = this.bTj.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.clearCornerFlag();
                tbImageView.setRadius(h);
                if (i2 == 0) {
                    tbImageView.addCornerFlags(5);
                }
                if (i2 == this.mImageList.size() - 1 || i2 == 4) {
                    tbImageView.addCornerFlags(10);
                }
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.asO())) {
                        tbImageView.startLoad(tbRichTextImageInfo.asO(), this.ZQ ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.bAQ, this.bAQ);
            layoutParams.leftMargin = (this.bAQ + this.bTq) * 4;
            this.bTj.addView(imageView, -1, layoutParams);
            imageView.setImageResource(d.f.shape_black_0_to_50_vertical);
            this.bTk.setVisibility(0);
            this.bTk.setText("+" + this.mImageList.size());
            this.bTk.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int h2 = com.baidu.adp.lib.util.l.h(ThreadGodReplyLayout.this.getContext(), d.e.tbds26) + ((ThreadGodReplyLayout.this.bAQ - ThreadGodReplyLayout.this.bTk.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.bTk.getLayoutParams();
                    layoutParams2.setMargins(0, h2, h2, 0);
                    ThreadGodReplyLayout.this.bTk.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.bTk.setVisibility(8);
    }

    public void c(PostData postData) {
        this.bTp = postData.asC();
        if (this.bTp == null) {
            this.bTi.setVisibility(8);
            return;
        }
        this.bTi.setVisibility(0);
        this.bTi.setTag(this.bTp);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            al.l(this.mRootView, d.C0277d.cp_bg_line_e);
            al.l(this.bTh, d.C0277d.cp_bg_line_c);
            al.j(this.Zy, d.C0277d.cp_cont_b);
            this.bTm.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            aeX();
            this.bTi.bxS();
        }
    }

    public TextView getGodReplyContent() {
        return this.bTh;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(d.g.god_reply_image_layout) != null && (view.getTag(d.g.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(d.g.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.asL());
            }
            String str = "";
            String str2 = "";
            if (this.bTn != null) {
                str = this.bTn.YT();
                str2 = this.bTn.getTid();
            }
            ImageViewerConfig createConfig = new ImageViewerConfig(getContext()).createConfig(arrayList, intValue, str, "", str2, true, arrayList.get(0), true);
            createConfig.getIntent().putExtra("from", this.mFrom);
            createConfig.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            createConfig.setIsShowHost(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
            if (this.bNw != null) {
                this.bNw.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bNw = onClickListener;
    }
}

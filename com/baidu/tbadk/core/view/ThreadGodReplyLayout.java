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
    private static final int bTe = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds42);
    private View.OnClickListener ZM;
    private boolean ZP;
    private TextView Zy;
    private int bAN;
    private View.OnClickListener bNu;
    private TextView bTf;
    private PlayVoiceBntNew bTg;
    private FrameLayout bTh;
    private TextView bTi;
    private ClickableHeaderImageView bTj;
    private AgreeAloneView bTk;
    private bg bTl;
    private PostData bTm;
    private TbRichTextVoiceInfo bTn;
    private int bTo;
    private final float bTp;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.bTl = null;
        this.mSkinType = 3;
        this.bTp = com.baidu.adp.lib.util.l.s((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds70) * 2);
        this.ZM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.bTm != null && ThreadGodReplyLayout.this.bTm.YR() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.bTm.YR().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.bTm.YR().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.bTm.YR().getUserId(), ThreadGodReplyLayout.this.bTm.YR().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.bTm.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.bNu != null) {
                        ThreadGodReplyLayout.this.bNu.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTl = null;
        this.mSkinType = 3;
        this.bTp = com.baidu.adp.lib.util.l.s((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds70) * 2);
        this.ZM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.bTm != null && ThreadGodReplyLayout.this.bTm.YR() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.bTm.YR().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.bTm.YR().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.bTm.YR().getUserId(), ThreadGodReplyLayout.this.bTm.YR().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.bTm.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.bNu != null) {
                        ThreadGodReplyLayout.this.bNu.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bTl = null;
        this.mSkinType = 3;
        this.bTp = com.baidu.adp.lib.util.l.s((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds70) * 2);
        this.ZM = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.bTm != null && ThreadGodReplyLayout.this.bTm.YR() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.bTm.YR().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.bTm.YR().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.bTm.YR().getUserId(), ThreadGodReplyLayout.this.bTm.YR().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.bTm.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.bNu != null) {
                        ThreadGodReplyLayout.this.bNu.onClick(view);
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
        this.bTj = (ClickableHeaderImageView) this.mView.findViewById(d.g.god_reply_user_pendant_header);
        this.bTj.setIsRound(true);
        this.bTj.setClickable(true);
        this.Zy = (TextView) this.mView.findViewById(d.g.god_reply_username_text);
        this.Zy.setOnClickListener(this.ZM);
        this.bTk = (AgreeAloneView) this.mView.findViewById(d.g.god_reply_agree_view);
        this.bTf = (TextView) this.mView.findViewById(d.g.god_reply_content);
        this.bTg = (PlayVoiceBntNew) this.mView.findViewById(d.g.god_reply_voice_btn);
        this.bTg.setVisibility(8);
        this.bTh = (FrameLayout) this.mView.findViewById(d.g.god_reply_image_layout);
        int aO = com.baidu.adp.lib.util.l.aO(getContext());
        this.bTo = com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds10);
        this.bAN = (((aO - (com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds44) * 2)) - (com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds26) * 2)) - (this.bTo * 4)) / 5;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.bAN, this.bAN);
            layoutParams.leftMargin = (this.bAN + this.bTo) * i;
            this.bTh.addView(tbImageView, layoutParams);
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
        this.bTh.setVisibility(8);
        this.bTi = (TextView) this.mView.findViewById(d.g.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.ZP = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void afa() {
        if (this.bTj != null) {
            this.bTj.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        }
        int childCount = this.bTh.getChildCount();
        if (childCount > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.bTh.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    int ai = com.baidu.tbadk.util.e.ai(arrayList);
                    ((TbImageView) childAt).setDefaultBgResource(ai);
                    arrayList.add(Integer.valueOf(ai));
                }
            }
        }
    }

    public void setData(bg bgVar) {
        this.bTl = bgVar;
        setData(bgVar.aap());
    }

    public void setData(PostData postData) {
        if (postData == null || postData.YR() == null || postData.YR().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.bTm = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.cev()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.bTn != null && this.bTn.att() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds30));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(getContext(), d.e.tbds25));
        }
        if (!aP(this.bTf) && !aP(this.bTh) && !aP(this.bTg)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.bTf.setVisibility(8);
            return;
        }
        if (!v.a(this.bTp, this.bTf.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.bTf.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(d.j.god_reply_expand_flag));
            Drawable drawable = al.getDrawable(d.f.icon_common_arrow_blue);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.c(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        t.aQF().b(new am("c13348"));
                        ThreadGodReplyLayout.this.bTf.setMaxLines(15);
                        ThreadGodReplyLayout.this.bTf.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.bTf.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.bTf.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.bTf.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.bTf.setText(((Object) ThreadGodReplyLayout.this.bTf.getText().subSequence(0, ThreadGodReplyLayout.this.bTf.getLayout().getLineEnd(14) - 1)) + "...");
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.bTf.getPaint(), (int) this.bTp, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.bTp;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.bTp - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.bTf.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.bTf.getPaint().measureText(subSequence.toString()) + f) {
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
                this.bTf.setText(spannableStringBuilder);
                this.bTf.setOnTouchListener(new com.baidu.tieba.view.k(spannableStringBuilder));
                t.aQF().b(new am("c13347"));
            } else {
                return;
            }
        }
        if (this.bTl != null) {
            com.baidu.tieba.card.n.a(this.bTf, this.bTl.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
        }
    }

    private boolean aP(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.bTj.setData(postData.YR());
            this.Zy.setText(ap.g(postData.YR().getName_show(), 14, "...") + "：");
            if (this.bTl != null) {
                postData.aaH().threadId = this.bTl.getTid();
            }
            postData.aaH().threadId = String.valueOf(postData.getTid());
            postData.aaH().objType = 3;
            this.bTk.setData(postData.aaH());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> asw;
        if (tbRichText == null || (asw = tbRichText.asw()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = asw.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.asE());
            } else if (next.getType() == 17) {
                String str = next.asI().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.i.Wy().WC()) {
            this.bTh.setVisibility(8);
            this.bTi.setVisibility(8);
            return;
        }
        TbRichText cev = postData.cev();
        if (cev == null || cev.asw() == null) {
            this.bTh.setVisibility(8);
            this.bTi.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = cev.asw().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.at(bTe, bTe);
                if (next.getType() == 8) {
                    this.mImageList.add(next.asD());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.bTh.setVisibility(8);
            this.bTi.setVisibility(8);
            return;
        }
        this.bTh.setVisibility(0);
        int h = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), d.e.tbds20);
        int i = 0;
        for (int i2 = 0; i2 < this.bTh.getChildCount(); i2++) {
            View childAt = this.bTh.getChildAt(i2);
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
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.asR())) {
                        tbImageView.startLoad(tbRichTextImageInfo.asR(), this.ZP ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.bAN, this.bAN);
            layoutParams.leftMargin = (this.bAN + this.bTo) * 4;
            this.bTh.addView(imageView, -1, layoutParams);
            imageView.setImageResource(d.f.shape_black_0_to_50_vertical);
            this.bTi.setVisibility(0);
            this.bTi.setText("+" + this.mImageList.size());
            this.bTi.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int h2 = com.baidu.adp.lib.util.l.h(ThreadGodReplyLayout.this.getContext(), d.e.tbds26) + ((ThreadGodReplyLayout.this.bAN - ThreadGodReplyLayout.this.bTi.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.bTi.getLayoutParams();
                    layoutParams2.setMargins(0, h2, h2, 0);
                    ThreadGodReplyLayout.this.bTi.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.bTi.setVisibility(8);
    }

    public void c(PostData postData) {
        this.bTn = postData.asF();
        if (this.bTn == null) {
            this.bTg.setVisibility(8);
            return;
        }
        this.bTg.setVisibility(0);
        this.bTg.setTag(this.bTn);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            al.l(this.mRootView, d.C0277d.cp_bg_line_e);
            al.l(this.bTf, d.C0277d.cp_bg_line_c);
            al.j(this.Zy, d.C0277d.cp_cont_b);
            this.bTk.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            afa();
            this.bTg.bxV();
        }
    }

    public TextView getGodReplyContent() {
        return this.bTf;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(d.g.god_reply_image_layout) != null && (view.getTag(d.g.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(d.g.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.asO());
            }
            String str = "";
            String str2 = "";
            if (this.bTl != null) {
                str = this.bTl.YW();
                str2 = this.bTl.getTid();
            }
            ImageViewerConfig createConfig = new ImageViewerConfig(getContext()).createConfig(arrayList, intValue, str, "", str2, true, arrayList.get(0), true);
            createConfig.getIntent().putExtra("from", this.mFrom);
            createConfig.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            createConfig.setIsShowHost(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
            if (this.bNu != null) {
                this.bNu.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bNu = onClickListener;
    }
}

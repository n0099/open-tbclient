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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int cdd = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private TextView XK;
    private View.OnClickListener Ya;
    private boolean Yd;
    private int bJJ;
    private View.OnClickListener bXj;
    private TextView cde;
    private PlayVoiceBntNew cdf;
    private FrameLayout cdg;
    private TextView cdh;
    private ClickableHeaderImageView cdi;
    private AgreeAloneView cdj;
    private bh cdk;
    private PostData cdl;
    private TbRichTextVoiceInfo cdm;
    private int cdn;
    private final float cdo;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.cdk = null;
        this.mSkinType = 3;
        this.cdo = com.baidu.adp.lib.util.l.v((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds70) * 2);
        this.Ya = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.cdl != null && ThreadGodReplyLayout.this.cdl.aeC() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.cdl.aeC().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.cdl.aeC().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.cdl.aeC().getUserId(), ThreadGodReplyLayout.this.cdl.aeC().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.cdl.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.bXj != null) {
                        ThreadGodReplyLayout.this.bXj.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cdk = null;
        this.mSkinType = 3;
        this.cdo = com.baidu.adp.lib.util.l.v((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds70) * 2);
        this.Ya = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.cdl != null && ThreadGodReplyLayout.this.cdl.aeC() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.cdl.aeC().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.cdl.aeC().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.cdl.aeC().getUserId(), ThreadGodReplyLayout.this.cdl.aeC().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.cdl.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.bXj != null) {
                        ThreadGodReplyLayout.this.bXj.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cdk = null;
        this.mSkinType = 3;
        this.cdo = com.baidu.adp.lib.util.l.v((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds70) * 2);
        this.Ya = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.cdl != null && ThreadGodReplyLayout.this.cdl.aeC() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.cdl.aeC().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.cdl.aeC().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.cdl.aeC().getUserId(), ThreadGodReplyLayout.this.cdl.aeC().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.cdl.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.bXj != null) {
                        ThreadGodReplyLayout.this.bXj.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(R.id.god_comment_layout);
        this.cdi = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.cdi.setIsRound(true);
        this.cdi.setClickable(true);
        this.XK = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.XK.setOnClickListener(this.Ya);
        this.cdj = (AgreeAloneView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.cde = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.cdf = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.cdf.setVisibility(8);
        this.cdg = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int af = com.baidu.adp.lib.util.l.af(getContext());
        this.cdn = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds10);
        this.bJJ = (((af - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds26) * 2)) - (this.cdn * 4)) / 5;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.bJJ, this.bJJ);
            layoutParams.leftMargin = (this.bJJ + this.cdn) * i;
            this.cdg.addView(tbImageView, layoutParams);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(am.getColor(R.color.black_alpha8));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setTag(R.id.god_reply_image_layout, Integer.valueOf(i));
            tbImageView.setTagTextSize((int) getResources().getDimension(R.dimen.tbfontsize26));
            tbImageView.setTagPaddingDis(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds6), com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds6));
            tbImageView.setOnClickListener(this);
            int ap = com.baidu.tbadk.util.e.ap(arrayList);
            tbImageView.setDefaultBgResource(ap);
            arrayList.add(Integer.valueOf(ap));
        }
        this.cdg.setVisibility(8);
        this.cdh = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void alp() {
        if (this.cdi != null) {
            this.cdi.setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
        }
        int childCount = this.cdg.getChildCount();
        if (childCount > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.cdg.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    int ap = com.baidu.tbadk.util.e.ap(arrayList);
                    ((TbImageView) childAt).setDefaultBgResource(ap);
                    arrayList.add(Integer.valueOf(ap));
                }
            }
        }
    }

    public void setData(bh bhVar) {
        this.cdk = bhVar;
        setData(bhVar.aga());
    }

    public void setData(PostData postData) {
        if (postData == null || postData.aeC() == null || postData.aeC().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.cdl = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.cqB()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.cdm != null && this.cdm.azW() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds30));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds25));
        }
        if (!aX(this.cde) && !aX(this.cdg) && !aX(this.cdf)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.cde.setVisibility(8);
            return;
        }
        if (!v.a(this.cdo, this.cde.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.cde.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.god_reply_expand_flag));
            Drawable drawable = am.getDrawable(R.drawable.icon_common_arrow_blue);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.c(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        t.bat().c(new an("c13348"));
                        ThreadGodReplyLayout.this.cde.setMaxLines(15);
                        ThreadGodReplyLayout.this.cde.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.cde.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.cde.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.cde.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.cde.setText(((Object) ThreadGodReplyLayout.this.cde.getText().subSequence(0, ThreadGodReplyLayout.this.cde.getLayout().getLineEnd(14) - 1)) + "...");
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.cde.getPaint(), (int) this.cdo, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.cdo;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.cdo - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.cde.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.cde.getPaint().measureText(subSequence.toString()) + f) {
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
                this.cde.setText(spannableStringBuilder);
                this.cde.setOnTouchListener(new com.baidu.tieba.view.k(spannableStringBuilder));
                t.bat().c(new an("c13347"));
            } else {
                return;
            }
        }
        if (this.cdk != null) {
            com.baidu.tieba.card.n.a(this.cde, this.cdk.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private boolean aX(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.cdi.setData(postData.aeC());
            this.XK.setText(aq.j(postData.aeC().getName_show(), 14, "...") + "：");
            if (this.cdk != null) {
                postData.ags().threadId = this.cdk.getTid();
            }
            postData.ags().threadId = String.valueOf(postData.getTid());
            postData.ags().objType = 3;
            this.cdj.setData(postData.ags());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> ayZ;
        if (tbRichText == null || (ayZ = tbRichText.ayZ()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = ayZ.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.azh());
            } else if (next.getType() == 17) {
                String str = next.azl().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.i.ace().aci()) {
            this.cdg.setVisibility(8);
            this.cdh.setVisibility(8);
            return;
        }
        TbRichText cqB = postData.cqB();
        if (cqB == null || cqB.ayZ() == null) {
            this.cdg.setVisibility(8);
            this.cdh.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = cqB.ayZ().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.ax(cdd, cdd);
                if (next.getType() == 8) {
                    this.mImageList.add(next.azg());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.cdg.setVisibility(8);
            this.cdh.setVisibility(8);
            return;
        }
        this.cdg.setVisibility(0);
        int g = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        int i = 0;
        for (int i2 = 0; i2 < this.cdg.getChildCount(); i2++) {
            View childAt = this.cdg.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                TbImageView tbImageView = (TbImageView) childAt;
                tbImageView.clearCornerFlag();
                tbImageView.setRadius(g);
                if (i2 == 0) {
                    tbImageView.addCornerFlags(5);
                }
                if (i2 == this.mImageList.size() - 1 || i2 == 4) {
                    tbImageView.addCornerFlags(10);
                }
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.azu())) {
                        tbImageView.startLoad(tbRichTextImageInfo.azu(), this.Yd ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.bJJ, this.bJJ);
            layoutParams.leftMargin = (this.bJJ + this.cdn) * 4;
            this.cdg.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.cdh.setVisibility(0);
            this.cdh.setText("+" + this.mImageList.size());
            this.cdh.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int g2 = com.baidu.adp.lib.util.l.g(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.bJJ - ThreadGodReplyLayout.this.cdh.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.cdh.getLayoutParams();
                    layoutParams2.setMargins(0, g2, g2, 0);
                    ThreadGodReplyLayout.this.cdh.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.cdh.setVisibility(8);
    }

    public void c(PostData postData) {
        this.cdm = postData.azi();
        if (this.cdm == null) {
            this.cdf.setVisibility(8);
            return;
        }
        this.cdf.setVisibility(0);
        this.cdf.setTag(this.cdm);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.l(this.mRootView, R.color.cp_bg_line_g);
            am.j(this.XK, R.color.cp_cont_b);
            this.cdj.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            alp();
            this.cdf.bql();
        }
    }

    public TextView getGodReplyContent() {
        return this.cde;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.azr());
            }
            String str = "";
            String str2 = "";
            if (this.cdk != null) {
                str = this.cdk.aeH();
                str2 = this.cdk.getTid();
            }
            ImageViewerConfig createConfig = new ImageViewerConfig(getContext()).createConfig(arrayList, intValue, str, "", str2, true, arrayList.get(0), true);
            createConfig.getIntent().putExtra("from", this.mFrom);
            createConfig.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            createConfig.setIsShowHost(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
            if (this.bXj != null) {
                this.bXj.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bXj = onClickListener;
    }
}

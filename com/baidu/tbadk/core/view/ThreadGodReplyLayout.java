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
    private static final int ccc = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private TextView XL;
    private View.OnClickListener Ya;
    private boolean Yd;
    private int bJg;
    private View.OnClickListener bWk;
    private TextView ccd;
    private PlayVoiceBntNew cce;
    private FrameLayout ccf;
    private TextView ccg;
    private ClickableHeaderImageView cch;
    private AgreeAloneView cci;
    private bg ccj;
    private PostData cck;
    private TbRichTextVoiceInfo ccl;
    private int ccm;
    private final float ccn;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.ccj = null;
        this.mSkinType = 3;
        this.ccn = com.baidu.adp.lib.util.l.v((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds70) * 2);
        this.Ya = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.cck != null && ThreadGodReplyLayout.this.cck.aex() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.cck.aex().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.cck.aex().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.cck.aex().getUserId(), ThreadGodReplyLayout.this.cck.aex().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.cck.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.bWk != null) {
                        ThreadGodReplyLayout.this.bWk.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ccj = null;
        this.mSkinType = 3;
        this.ccn = com.baidu.adp.lib.util.l.v((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds70) * 2);
        this.Ya = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.cck != null && ThreadGodReplyLayout.this.cck.aex() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.cck.aex().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.cck.aex().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.cck.aex().getUserId(), ThreadGodReplyLayout.this.cck.aex().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.cck.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.bWk != null) {
                        ThreadGodReplyLayout.this.bWk.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ccj = null;
        this.mSkinType = 3;
        this.ccn = com.baidu.adp.lib.util.l.v((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds70) * 2);
        this.Ya = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.cck != null && ThreadGodReplyLayout.this.cck.aex() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.cck.aex().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.cck.aex().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.cck.aex().getUserId(), ThreadGodReplyLayout.this.cck.aex().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.cck.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.bWk != null) {
                        ThreadGodReplyLayout.this.bWk.onClick(view);
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
        this.cch = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.cch.setIsRound(true);
        this.cch.setClickable(true);
        this.XL = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.XL.setOnClickListener(this.Ya);
        this.cci = (AgreeAloneView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.ccd = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.cce = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.cce.setVisibility(8);
        this.ccf = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int af = com.baidu.adp.lib.util.l.af(getContext());
        this.ccm = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds10);
        this.bJg = (((af - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds26) * 2)) - (this.ccm * 4)) / 5;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.bJg, this.bJg);
            layoutParams.leftMargin = (this.bJg + this.ccm) * i;
            this.ccf.addView(tbImageView, layoutParams);
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
        this.ccf.setVisibility(8);
        this.ccg = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void alb() {
        if (this.cch != null) {
            this.cch.setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
        }
        int childCount = this.ccf.getChildCount();
        if (childCount > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ccf.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    int ap = com.baidu.tbadk.util.e.ap(arrayList);
                    ((TbImageView) childAt).setDefaultBgResource(ap);
                    arrayList.add(Integer.valueOf(ap));
                }
            }
        }
    }

    public void setData(bg bgVar) {
        this.ccj = bgVar;
        setData(bgVar.afV());
    }

    public void setData(PostData postData) {
        if (postData == null || postData.aex() == null || postData.aex().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.cck = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.cpr()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.ccl != null && this.ccl.azI() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds30));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds25));
        }
        if (!aX(this.ccd) && !aX(this.ccf) && !aX(this.cce)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.ccd.setVisibility(8);
            return;
        }
        if (!v.a(this.ccn, this.ccd.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.ccd.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.god_reply_expand_flag));
            Drawable drawable = am.getDrawable(R.drawable.icon_common_arrow_blue);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.c(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        t.aZN().c(new an("c13348"));
                        ThreadGodReplyLayout.this.ccd.setMaxLines(15);
                        ThreadGodReplyLayout.this.ccd.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.ccd.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.ccd.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.ccd.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.ccd.setText(((Object) ThreadGodReplyLayout.this.ccd.getText().subSequence(0, ThreadGodReplyLayout.this.ccd.getLayout().getLineEnd(14) - 1)) + "...");
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.ccd.getPaint(), (int) this.ccn, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.ccn;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.ccn - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.ccd.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.ccd.getPaint().measureText(subSequence.toString()) + f) {
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
                this.ccd.setText(spannableStringBuilder);
                this.ccd.setOnTouchListener(new com.baidu.tieba.view.k(spannableStringBuilder));
                t.aZN().c(new an("c13347"));
            } else {
                return;
            }
        }
        if (this.ccj != null) {
            com.baidu.tieba.card.n.a(this.ccd, this.ccj.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private boolean aX(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.cch.setData(postData.aex());
            this.XL.setText(aq.j(postData.aex().getName_show(), 14, "...") + "：");
            if (this.ccj != null) {
                postData.agn().threadId = this.ccj.getTid();
            }
            postData.agn().threadId = String.valueOf(postData.getTid());
            postData.agn().objType = 3;
            this.cci.setData(postData.agn());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> ayL;
        if (tbRichText == null || (ayL = tbRichText.ayL()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = ayL.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.ayT());
            } else if (next.getType() == 17) {
                String str = next.ayX().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.i.aca().ace()) {
            this.ccf.setVisibility(8);
            this.ccg.setVisibility(8);
            return;
        }
        TbRichText cpr = postData.cpr();
        if (cpr == null || cpr.ayL() == null) {
            this.ccf.setVisibility(8);
            this.ccg.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = cpr.ayL().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.ax(ccc, ccc);
                if (next.getType() == 8) {
                    this.mImageList.add(next.ayS());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.ccf.setVisibility(8);
            this.ccg.setVisibility(8);
            return;
        }
        this.ccf.setVisibility(0);
        int g = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        int i = 0;
        for (int i2 = 0; i2 < this.ccf.getChildCount(); i2++) {
            View childAt = this.ccf.getChildAt(i2);
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
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.azg())) {
                        tbImageView.startLoad(tbRichTextImageInfo.azg(), this.Yd ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.bJg, this.bJg);
            layoutParams.leftMargin = (this.bJg + this.ccm) * 4;
            this.ccf.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.ccg.setVisibility(0);
            this.ccg.setText("+" + this.mImageList.size());
            this.ccg.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int g2 = com.baidu.adp.lib.util.l.g(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.bJg - ThreadGodReplyLayout.this.ccg.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.ccg.getLayoutParams();
                    layoutParams2.setMargins(0, g2, g2, 0);
                    ThreadGodReplyLayout.this.ccg.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.ccg.setVisibility(8);
    }

    public void c(PostData postData) {
        this.ccl = postData.ayU();
        if (this.ccl == null) {
            this.cce.setVisibility(8);
            return;
        }
        this.cce.setVisibility(0);
        this.cce.setTag(this.ccl);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.l(this.mRootView, R.color.cp_bg_line_e);
            am.l(this.ccd, R.color.cp_bg_line_c);
            am.j(this.XL, R.color.cp_cont_b);
            this.cci.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            alb();
            this.cce.bIl();
        }
    }

    public TextView getGodReplyContent() {
        return this.ccd;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.azd());
            }
            String str = "";
            String str2 = "";
            if (this.ccj != null) {
                str = this.ccj.aeC();
                str2 = this.ccj.getTid();
            }
            ImageViewerConfig createConfig = new ImageViewerConfig(getContext()).createConfig(arrayList, intValue, str, "", str2, true, arrayList.get(0), true);
            createConfig.getIntent().putExtra("from", this.mFrom);
            createConfig.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            createConfig.setIsShowHost(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
            if (this.bWk != null) {
                this.bWk.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bWk = onClickListener;
    }
}

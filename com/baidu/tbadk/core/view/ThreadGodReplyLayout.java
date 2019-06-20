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
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int cba = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    private View.OnClickListener XF;
    private boolean XI;
    private TextView Xq;
    private int bIg;
    private View.OnClickListener bVj;
    private TextView cbb;
    private PlayVoiceBntNew cbc;
    private FrameLayout cbd;
    private TextView cbe;
    private ClickableHeaderImageView cbf;
    private AgreeAloneView cbg;
    private bg cbh;
    private PostData cbi;
    private TbRichTextVoiceInfo cbj;
    private int cbk;
    private final float cbl;
    private Context mContext;
    private String mFrom;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private int mSkinType;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.cbh = null;
        this.mSkinType = 3;
        this.cbl = com.baidu.adp.lib.util.l.s((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds70) * 2);
        this.XF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.cbi != null && ThreadGodReplyLayout.this.cbi.adv() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.cbi.adv().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.cbi.adv().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.cbi.adv().getUserId(), ThreadGodReplyLayout.this.cbi.adv().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.cbi.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.bVj != null) {
                        ThreadGodReplyLayout.this.bVj.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cbh = null;
        this.mSkinType = 3;
        this.cbl = com.baidu.adp.lib.util.l.s((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds70) * 2);
        this.XF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.cbi != null && ThreadGodReplyLayout.this.cbi.adv() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.cbi.adv().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.cbi.adv().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.cbi.adv().getUserId(), ThreadGodReplyLayout.this.cbi.adv().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.cbi.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.bVj != null) {
                        ThreadGodReplyLayout.this.bVj.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cbh = null;
        this.mSkinType = 3;
        this.cbl = com.baidu.adp.lib.util.l.s((Activity) getContext()).widthPixels - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds70) * 2);
        this.XF = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadGodReplyLayout.this.cbi != null && ThreadGodReplyLayout.this.cbi.adv() != null && !StringUtils.isNull(ThreadGodReplyLayout.this.cbi.adv().getName_show()) && !StringUtils.isNull(ThreadGodReplyLayout.this.cbi.adv().getUserId())) {
                    PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.mContext, ThreadGodReplyLayout.this.cbi.adv().getUserId(), ThreadGodReplyLayout.this.cbi.adv().getName_show());
                    personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.cbi.getId());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                    if (ThreadGodReplyLayout.this.bVj != null) {
                        ThreadGodReplyLayout.this.bVj.onClick(view);
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
        this.cbf = (ClickableHeaderImageView) this.mView.findViewById(R.id.god_reply_user_pendant_header);
        this.cbf.setIsRound(true);
        this.cbf.setClickable(true);
        this.Xq = (TextView) this.mView.findViewById(R.id.god_reply_username_text);
        this.Xq.setOnClickListener(this.XF);
        this.cbg = (AgreeAloneView) this.mView.findViewById(R.id.god_reply_agree_view);
        this.cbb = (TextView) this.mView.findViewById(R.id.god_reply_content);
        this.cbc = (PlayVoiceBntNew) this.mView.findViewById(R.id.god_reply_voice_btn);
        this.cbc.setVisibility(8);
        this.cbd = (FrameLayout) this.mView.findViewById(R.id.god_reply_image_layout);
        int af = com.baidu.adp.lib.util.l.af(getContext());
        this.cbk = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds10);
        this.bIg = (((af - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds26) * 2)) - (this.cbk * 4)) / 5;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.bIg, this.bIg);
            layoutParams.leftMargin = (this.bIg + this.cbk) * i;
            this.cbd.addView(tbImageView, layoutParams);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(al.getColor(R.color.black_alpha8));
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
        this.cbd.setVisibility(8);
        this.cbe = (TextView) this.mView.findViewById(R.id.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.XI = z;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void ajW() {
        if (this.cbf != null) {
            this.cbf.setDefaultBgResource(com.baidu.tbadk.util.e.get());
        }
        int childCount = this.cbd.getChildCount();
        if (childCount > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.cbd.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    int ap = com.baidu.tbadk.util.e.ap(arrayList);
                    ((TbImageView) childAt).setDefaultBgResource(ap);
                    arrayList.add(Integer.valueOf(ap));
                }
            }
        }
    }

    public void setData(bg bgVar) {
        this.cbh = bgVar;
        setData(bgVar.aeT());
    }

    public void setData(PostData postData) {
        if (postData == null || postData.adv() == null || postData.adv().getUserId() == null) {
            setVisibility(8);
            return;
        }
        this.cbi = postData;
        setVisibility(0);
        a(postData);
        a(a(postData.cmz()));
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.cbj != null && this.cbj.ayw() != null)) {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds30));
        } else {
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.tbds25));
        }
        if (!aV(this.cbb) && !aV(this.cbd) && !aV(this.cbc)) {
            setVisibility(8);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder) {
        float f;
        if (spannableStringBuilder == null || TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.cbb.setVisibility(8);
            return;
        }
        if (!v.a(this.cbl, this.cbb.getPaint(), spannableStringBuilder.toString(), 5)) {
            this.cbb.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else {
            final SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.god_reply_expand_flag));
            Drawable drawable = al.getDrawable(R.drawable.icon_common_arrow_blue);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            if (spannableStringBuilder3.length() >= 3) {
                spannableStringBuilder3.setSpan(new com.baidu.tbadk.widget.richText.c(2, null) { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                    @Override // com.baidu.tbadk.widget.richText.c, android.text.style.ClickableSpan
                    public void onClick(View view) {
                        t.aXP().b(new am("c13348"));
                        ThreadGodReplyLayout.this.cbb.setMaxLines(15);
                        ThreadGodReplyLayout.this.cbb.setEllipsize(TextUtils.TruncateAt.END);
                        ThreadGodReplyLayout.this.cbb.setText(spannableStringBuilder2.toString());
                        ThreadGodReplyLayout.this.cbb.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ThreadGodReplyLayout.this.cbb.getLineCount() >= 15) {
                                    ThreadGodReplyLayout.this.cbb.setText(((Object) ThreadGodReplyLayout.this.cbb.getText().subSequence(0, ThreadGodReplyLayout.this.cbb.getLayout().getLineEnd(14) - 1)) + "...");
                                }
                            }
                        });
                    }
                }, 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.cbb.getPaint(), (int) this.cbl, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.cbl;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f = this.cbl - staticLayout.getLineWidth(4);
                } else {
                    f = f2;
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.cbb.getPaint().measureText(spannableStringBuilder3.toString());
                int i = 2;
                while (measureText > this.cbb.getPaint().measureText(subSequence.toString()) + f) {
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
                this.cbb.setText(spannableStringBuilder);
                this.cbb.setOnTouchListener(new com.baidu.tieba.view.k(spannableStringBuilder));
                t.aXP().b(new am("c13347"));
            } else {
                return;
            }
        }
        if (this.cbh != null) {
            com.baidu.tieba.card.n.a(this.cbb, this.cbh.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
        }
    }

    private boolean aV(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData) {
        if (postData != null) {
            this.cbf.setData(postData.adv());
            this.Xq.setText(ap.j(postData.adv().getName_show(), 14, "...") + "：");
            if (this.cbh != null) {
                postData.afl().threadId = this.cbh.getTid();
            }
            postData.afl().threadId = String.valueOf(postData.getTid());
            postData.afl().objType = 3;
            this.cbg.setData(postData.afl());
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> axz;
        if (tbRichText == null || (axz = tbRichText.axz()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = axz.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.axH());
            } else if (next.getType() == 17) {
                String str = next.axL().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.i.abb().abf()) {
            this.cbd.setVisibility(8);
            this.cbe.setVisibility(8);
            return;
        }
        TbRichText cmz = postData.cmz();
        if (cmz == null || cmz.axz() == null) {
            this.cbd.setVisibility(8);
            this.cbe.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = cmz.axz().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.at(cba, cba);
                if (next.getType() == 8) {
                    this.mImageList.add(next.axG());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.cbd.setVisibility(8);
            this.cbe.setVisibility(8);
            return;
        }
        this.cbd.setVisibility(0);
        int g = com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        int i = 0;
        for (int i2 = 0; i2 < this.cbd.getChildCount(); i2++) {
            View childAt = this.cbd.getChildAt(i2);
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
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.axU())) {
                        tbImageView.startLoad(tbRichTextImageInfo.axU(), this.XI ? 13 : 14, false);
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
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.bIg, this.bIg);
            layoutParams.leftMargin = (this.bIg + this.cbk) * 4;
            this.cbd.addView(imageView, -1, layoutParams);
            imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
            this.cbe.setVisibility(0);
            this.cbe.setText("+" + this.mImageList.size());
            this.cbe.post(new Runnable() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    int g2 = com.baidu.adp.lib.util.l.g(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26) + ((ThreadGodReplyLayout.this.bIg - ThreadGodReplyLayout.this.cbe.getWidth()) / 2);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.cbe.getLayoutParams();
                    layoutParams2.setMargins(0, g2, g2, 0);
                    ThreadGodReplyLayout.this.cbe.setLayoutParams(layoutParams2);
                }
            });
            return;
        }
        this.cbe.setVisibility(8);
    }

    public void c(PostData postData) {
        this.cbj = postData.axI();
        if (this.cbj == null) {
            this.cbc.setVisibility(8);
            return;
        }
        this.cbc.setVisibility(0);
        this.cbc.setTag(this.cbj);
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            al.l(this.mRootView, R.color.cp_bg_line_e);
            al.l(this.cbb, R.color.cp_bg_line_c);
            al.j(this.Xq, R.color.cp_cont_b);
            this.cbg.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            ajW();
            this.cbc.bFE();
        }
    }

    public TextView getGodReplyContent() {
        return this.cbb;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(R.id.god_reply_image_layout) != null && (view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.axR());
            }
            String str = "";
            String str2 = "";
            if (this.cbh != null) {
                str = this.cbh.adA();
                str2 = this.cbh.getTid();
            }
            ImageViewerConfig createConfig = new ImageViewerConfig(getContext()).createConfig(arrayList, intValue, str, "", str2, true, arrayList.get(0), true);
            createConfig.getIntent().putExtra("from", this.mFrom);
            createConfig.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            createConfig.setIsShowHost(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
            if (this.bVj != null) {
                this.bVj.onClick(view);
            }
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bVj = onClickListener;
    }
}

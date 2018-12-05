package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.ActivityChooserView;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int aJX = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0210e.tbds42);
    private boolean aEq;
    private TextView aJQ;
    private PlayVoiceBntNew aJR;
    private FrameLayout aJS;
    private LinearLayout aJT;
    private TextView aJU;
    private TbRichTextVoiceInfo aJV;
    private boolean aJW;
    private Context mContext;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(e.h.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(e.g.god_comment_layout);
        this.aJQ = (TextView) this.mView.findViewById(e.g.god_reply_content);
        this.aJR = (PlayVoiceBntNew) this.mView.findViewById(e.g.god_reply_voice_btn);
        this.aJR.setVisibility(8);
        this.aJS = (FrameLayout) this.mView.findViewById(e.g.god_reply_image_layout);
        int aO = com.baidu.adp.lib.util.l.aO(getContext());
        int h = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds20);
        int h2 = ((aO - (com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds44) * 2)) - (h * 7)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(h2, h2);
            layoutParams.leftMargin = (h2 + h) * i;
            this.aJS.addView(tbImageView, layoutParams);
            tbImageView.setTag(e.g.god_reply_image_layout, Integer.valueOf(i));
            tbImageView.setTagTextSize((int) getResources().getDimension(e.C0210e.tbfontsize26));
            tbImageView.setTagPaddingDis(com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds6), com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds6));
            tbImageView.setOnClickListener(this);
        }
        this.aJS.setVisibility(8);
        this.aJT = (LinearLayout) this.mView.findViewById(e.g.god_reply_img_multi_layout);
        this.aJT.setVisibility(8);
        this.aJT.bringToFront();
        this.aJT.setClickable(false);
        this.aJU = (TextView) this.mView.findViewById(e.g.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.aEq = z;
    }

    public void setData(PostData postData) {
        if (postData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.aJV != null && this.aJV.SW() != null)) {
            this.aJW = true;
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds30));
        } else {
            this.aJW = false;
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds25));
        }
        a(postData, 2);
        if (!V(this.aJQ) && !V(this.aJS) && !V(this.aJR)) {
            setVisibility(8);
        }
    }

    private boolean V(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        Drawable drawable = al.getDrawable(e.f.icon_popular_reply_n);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableStringBuilder2.append((CharSequence) "tag");
        spannableStringBuilder2.setSpan(new a(drawable, this.aJQ, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.tbds4)), 0, spannableStringBuilder2.length(), 33);
        if (postData.AS() >= 0) {
            int length = spannableStringBuilder2.length();
            spannableStringBuilder2.append((CharSequence) (" " + ao.R(postData.AS()) + getResources().getString(e.j.zan)));
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_cont_h)), length, spannableStringBuilder2.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        SpannableStringBuilder a2 = a(postData.bDu());
        if (a2 != null && !TextUtils.isEmpty(a2.toString())) {
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("  |  ");
            int h = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds34);
            spannableStringBuilder3.setSpan(new b(h, al.getColor(e.d.cp_cont_d), aJX - h), 0, spannableStringBuilder3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
            spannableStringBuilder.append((CharSequence) a2);
            this.aJQ.setVisibility(0);
            this.aJQ.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.aJQ.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            if (i >= 2 && this.aJQ.getLineCount() > i) {
                spannableStringBuilder = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, this.aJQ.getLayout().getLineEnd(i - 1) - 3);
                spannableStringBuilder.append((CharSequence) "...");
            }
            this.aJQ.setMaxLines(i);
            this.aJQ.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else if (!this.aJW) {
            this.aJQ.setVisibility(8);
        } else {
            this.aJQ.setVisibility(0);
            this.aJQ.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> RZ;
        if (tbRichText == null || (RZ = tbRichText.RZ()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = RZ.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.Sg());
            } else if (next.getType() == 17) {
                String str = next.Sk().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.i.xE().xI()) {
            this.aJS.setVisibility(8);
            this.aJT.setVisibility(8);
            return;
        }
        TbRichText bDu = postData.bDu();
        if (bDu == null || bDu.RZ() == null) {
            this.aJS.setVisibility(8);
            this.aJT.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = bDu.RZ().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.V(aJX, aJX);
                if (next.getType() == 8) {
                    this.mImageList.add(next.Sf());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.aJS.setVisibility(8);
            this.aJT.setVisibility(8);
            return;
        }
        this.aJS.setVisibility(0);
        int i = 0;
        for (int i2 = 0; i2 < this.aJS.getChildCount(); i2++) {
            View childAt = this.aJS.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.Su())) {
                        ((TbImageView) childAt).startLoad(tbRichTextImageInfo.Su(), this.aEq ? 13 : 14, false);
                        childAt.setVisibility(0);
                        i++;
                    } else {
                        childAt.setVisibility(8);
                    }
                } else {
                    childAt.setVisibility(8);
                }
            }
            i = i;
        }
        if (this.mImageList.size() > 5) {
            this.aJT.setVisibility(0);
            this.aJU.setText("" + this.mImageList.size());
            return;
        }
        this.aJT.setVisibility(8);
    }

    public void c(PostData postData) {
        this.aJV = postData.Sh();
        if (this.aJV == null) {
            this.aJR.setVisibility(8);
            return;
        }
        this.aJR.setVisibility(0);
        this.aJR.setTag(this.aJV);
    }

    public void onChangeSkinType() {
        al.j(this.mRootView, e.d.cp_bg_line_e);
        al.j(this.aJQ, e.d.cp_bg_line_e);
        al.h(this.aJQ, e.d.cp_cont_j);
        this.aJR.aWg();
    }

    public TextView getGodReplyContent() {
        return this.aJQ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(e.g.god_reply_image_layout) != null && (view.getTag(e.g.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(e.g.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.Sq());
            }
            ImageViewerConfig createConfig = new ImageViewerConfig(getContext()).createConfig(arrayList, intValue, null, "", "", true, arrayList.get(0), true);
            createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_DISCOVER_BEAUTY);
            createConfig.setIsShowHost(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends ReplacementSpan {
        private int aKa;
        private int fontSize;
        private int mColor;

        public b(int i, int i2, int i3) {
            this.fontSize = i;
            this.aKa = i3;
            this.mColor = i2;
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            return (int) a(paint).measureText(charSequence.subSequence(i, i2).toString());
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            CharSequence subSequence = charSequence.subSequence(i, i2);
            TextPaint a = a(paint);
            a.setColor(this.mColor);
            canvas.drawText(subSequence.toString(), f, i4 - (this.aKa / 2), a);
        }

        private TextPaint a(Paint paint) {
            TextPaint textPaint = new TextPaint(paint);
            textPaint.setTextSize(this.fontSize);
            return textPaint;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends com.baidu.tbadk.widget.c {
        private int aJY;
        private TextView aJZ;

        public a(Drawable drawable, TextView textView, int i) {
            super(drawable);
            this.aJY = 0;
            this.aJZ = textView;
            this.aJY = i;
        }

        @Override // com.baidu.tbadk.widget.c, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            if (getDrawable() != null && (this.aJZ.getLineCount() > 1 || Build.VERSION.SDK_INT < 21)) {
                setVerticalOffset(this.aJY);
                super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
                return;
            }
            setVerticalOffset(0);
            super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
        }
    }
}

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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    private static final int ayg = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst(), d.e.tbds42);
    private boolean asR;
    private TextView axZ;
    private PlayVoiceBntNew aya;
    private FrameLayout ayb;
    private LinearLayout ayc;
    private TextView ayd;
    private TbRichTextVoiceInfo aye;
    private boolean ayf;
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
        this.mView = LayoutInflater.from(context).inflate(d.h.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(d.g.god_comment_layout);
        this.axZ = (TextView) this.mView.findViewById(d.g.god_reply_content);
        this.aya = (PlayVoiceBntNew) this.mView.findViewById(d.g.god_reply_voice_btn);
        this.aya.setVisibility(8);
        this.ayb = (FrameLayout) this.mView.findViewById(d.g.god_reply_image_layout);
        int ah = com.baidu.adp.lib.util.l.ah(getContext());
        int f = com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds20);
        int f2 = ((ah - (com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds44) * 2)) - (f * 7)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f2, f2);
            layoutParams.leftMargin = (f2 + f) * i;
            this.ayb.addView(tbImageView, layoutParams);
            tbImageView.setTag(d.g.god_reply_image_layout, Integer.valueOf(i));
            tbImageView.setTagTextSize((int) getResources().getDimension(d.e.tbfontsize26));
            tbImageView.setTagPaddingDis(com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds6), com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds6));
            tbImageView.setOnClickListener(this);
        }
        this.ayb.setVisibility(8);
        this.ayc = (LinearLayout) this.mView.findViewById(d.g.god_reply_img_multi_layout);
        this.ayc.setVisibility(8);
        this.ayc.bringToFront();
        this.ayc.setClickable(false);
        this.ayd = (TextView) this.mView.findViewById(d.g.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.asR = z;
    }

    public void setData(PostData postData) {
        if (postData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        a(postData);
        b(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.aye != null && this.aye.Ou() != null)) {
            this.ayf = true;
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds30));
        } else {
            this.ayf = false;
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds25));
        }
        a(postData, 2);
        if (!J(this.axZ) && !J(this.ayb) && !J(this.aya)) {
            setVisibility(8);
        }
    }

    private boolean J(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        Drawable drawable = am.getDrawable(d.f.icon_popular_reply_n);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableStringBuilder2.append((CharSequence) "tag");
        spannableStringBuilder2.setSpan(new a(drawable, this.axZ, com.baidu.adp.lib.util.l.f(getContext(), d.e.tbds4)), 0, spannableStringBuilder2.length(), 33);
        if (postData.bwq() >= 0) {
            int length = spannableStringBuilder2.length();
            spannableStringBuilder2.append((CharSequence) (" " + ap.C(postData.bwq()) + getResources().getString(d.j.zan)));
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(am.getColor(d.C0140d.cp_cont_h)), length, spannableStringBuilder2.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        SpannableStringBuilder a2 = a(postData.bwh());
        if (a2 != null && !TextUtils.isEmpty(a2.toString())) {
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("  |  ");
            int f = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds34);
            spannableStringBuilder3.setSpan(new b(f, am.getColor(d.C0140d.cp_cont_d), ayg - f), 0, spannableStringBuilder3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
            spannableStringBuilder.append((CharSequence) a2);
            this.axZ.setVisibility(0);
            this.axZ.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.axZ.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            if (i >= 2 && this.axZ.getLineCount() > i) {
                spannableStringBuilder = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, this.axZ.getLayout().getLineEnd(i - 1) - 3);
                spannableStringBuilder.append((CharSequence) "...");
            }
            this.axZ.setMaxLines(i);
            this.axZ.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else if (!this.ayf) {
            this.axZ.setVisibility(8);
        } else {
            this.axZ.setVisibility(0);
            this.axZ.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> Nx;
        if (tbRichText == null || (Nx = tbRichText.Nx()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = Nx.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.NE());
            } else if (next.getType() == 17) {
                String str = next.NI().mGifInfo.mSharpText;
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

    public void a(PostData postData) {
        if (this.mImageList == null) {
            this.mImageList = new ArrayList();
        } else {
            this.mImageList.clear();
        }
        if (!com.baidu.tbadk.core.i.te().tk()) {
            this.ayb.setVisibility(8);
            this.ayc.setVisibility(8);
            return;
        }
        TbRichText bwh = postData.bwh();
        if (bwh == null || bwh.Nx() == null) {
            this.ayb.setVisibility(8);
            this.ayc.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = bwh.Nx().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.R(ayg, ayg);
                if (next.getType() == 8) {
                    this.mImageList.add(next.ND());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.ayb.setVisibility(8);
            this.ayc.setVisibility(8);
            return;
        }
        this.ayb.setVisibility(0);
        int i = 0;
        for (int i2 = 0; i2 < this.ayb.getChildCount(); i2++) {
            View childAt = this.ayb.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.NS())) {
                        ((TbImageView) childAt).startLoad(tbRichTextImageInfo.NS(), this.asR ? 13 : 14, false);
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
            this.ayc.setVisibility(0);
            this.ayd.setText("" + this.mImageList.size());
            return;
        }
        this.ayc.setVisibility(8);
    }

    public void b(PostData postData) {
        this.aye = postData.NF();
        if (this.aye == null) {
            this.aya.setVisibility(8);
            return;
        }
        this.aya.setVisibility(0);
        this.aya.setTag(this.aye);
    }

    public void onChangeSkinType() {
        am.j(this.mRootView, d.C0140d.cp_bg_line_e);
        am.j(this.axZ, d.C0140d.cp_bg_line_e);
        am.h(this.axZ, d.C0140d.cp_cont_j);
        this.aya.aPt();
    }

    public TextView getGodReplyContent() {
        return this.axZ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(d.g.god_reply_image_layout) != null && (view.getTag(d.g.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(d.g.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.NO());
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
        private int ayj;
        private int fontSize;
        private int mColor;

        public b(int i, int i2, int i3) {
            this.fontSize = i;
            this.ayj = i3;
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
            canvas.drawText(subSequence.toString(), f, i4 - (this.ayj / 2), a);
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
        private int ayh;
        private TextView ayi;

        public a(Drawable drawable, TextView textView, int i) {
            super(drawable);
            this.ayh = 0;
            this.ayi = textView;
            this.ayh = i;
        }

        @Override // com.baidu.tbadk.widget.c, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            if (getDrawable() != null && (this.ayi.getLineCount() > 1 || Build.VERSION.SDK_INT < 21)) {
                setVerticalOffset(this.ayh);
                super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
                return;
            }
            setVerticalOffset(0);
            super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
        }
    }
}

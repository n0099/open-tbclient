package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
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
    private static final int bcx = com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst(), d.e.tbds42);
    private boolean aXA;
    private TextView bcq;
    private PlayVoiceBntNew bcr;
    private FrameLayout bcs;
    private LinearLayout bct;
    private TextView bcu;
    private TbRichTextVoiceInfo bcv;
    private boolean bcw;
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
        this.bcq = (TextView) this.mView.findViewById(d.g.god_reply_content);
        this.bcr = (PlayVoiceBntNew) this.mView.findViewById(d.g.god_reply_voice_btn);
        this.bcr.setVisibility(8);
        this.bcs = (FrameLayout) this.mView.findViewById(d.g.god_reply_image_layout);
        int ao = com.baidu.adp.lib.util.l.ao(getContext());
        int s = com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds20);
        int s2 = ((ao - (com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds44) * 2)) - (s * 7)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(s2, s2);
            layoutParams.leftMargin = (s2 + s) * i;
            this.bcs.addView(tbImageView, layoutParams);
            tbImageView.setTag(d.g.god_reply_image_layout, Integer.valueOf(i));
            tbImageView.setTagTextSize((int) getResources().getDimension(d.e.tbfontsize26));
            tbImageView.setTagPaddingDis(com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds6), com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds6));
            tbImageView.setOnClickListener(this);
        }
        this.bcs.setVisibility(8);
        this.bct = (LinearLayout) this.mView.findViewById(d.g.god_reply_img_multi_layout);
        this.bct.setVisibility(8);
        this.bct.bringToFront();
        this.bct.setClickable(false);
        this.bcu = (TextView) this.mView.findViewById(d.g.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.aXA = z;
    }

    public void setData(PostData postData) {
        if (postData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        a(postData);
        b(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.bcv != null && this.bcv.RA() != null)) {
            this.bcw = true;
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds30));
        } else {
            this.bcw = false;
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds25));
        }
        a(postData, 2);
        if (!ba(this.bcq) && !ba(this.bcs) && !ba(this.bcr)) {
            setVisibility(8);
        }
    }

    private boolean ba(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        Drawable drawable = aj.getDrawable(d.f.icon_popular_reply_n);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableStringBuilder2.append((CharSequence) "tag");
        spannableStringBuilder2.setSpan(new a(drawable, this.bcq, com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds4)), 0, spannableStringBuilder2.length(), 33);
        if (postData.bvX() >= 0) {
            int length = spannableStringBuilder2.length();
            spannableStringBuilder2.append((CharSequence) (" " + am.E(postData.bvX()) + getResources().getString(d.j.zan)));
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(aj.getColor(d.C0108d.cp_cont_h)), length, spannableStringBuilder2.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        SpannableStringBuilder a2 = a(postData.bvM());
        if (a2 != null && !TextUtils.isEmpty(a2.toString())) {
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("  |  ");
            int s = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds34);
            spannableStringBuilder3.setSpan(new b(s, aj.getColor(d.C0108d.cp_cont_d), bcx - s), 0, spannableStringBuilder3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
            spannableStringBuilder.append((CharSequence) a2);
            this.bcq.setVisibility(0);
            this.bcq.setMaxLines(Integer.MAX_VALUE);
            this.bcq.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            if (i >= 2 && this.bcq.getLineCount() > i) {
                spannableStringBuilder = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, this.bcq.getLayout().getLineEnd(i - 1) - 3);
                spannableStringBuilder.append((CharSequence) "...");
            }
            this.bcq.setMaxLines(i);
            this.bcq.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else if (!this.bcw) {
            this.bcq.setVisibility(8);
        } else {
            this.bcq.setVisibility(0);
            this.bcq.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> QD;
        if (tbRichText == null || (QD = tbRichText.QD()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = QD.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.QK());
            } else if (next.getType() == 17) {
                String str = next.QO().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.i.wB().wH()) {
            this.bcs.setVisibility(8);
            this.bct.setVisibility(8);
            return;
        }
        TbRichText bvM = postData.bvM();
        if (bvM == null || bvM.QD() == null) {
            this.bcs.setVisibility(8);
            this.bct.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = bvM.QD().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.aT(bcx, bcx);
                if (next.getType() == 8) {
                    this.mImageList.add(next.QJ());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.bcs.setVisibility(8);
            this.bct.setVisibility(8);
            return;
        }
        this.bcs.setVisibility(0);
        int i = 0;
        for (int i2 = 0; i2 < this.bcs.getChildCount(); i2++) {
            View childAt = this.bcs.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.QX())) {
                        ((TbImageView) childAt).startLoad(tbRichTextImageInfo.QX(), this.aXA ? 13 : 14, false);
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
            this.bct.setVisibility(0);
            this.bcu.setText("" + this.mImageList.size());
            return;
        }
        this.bct.setVisibility(8);
    }

    public void b(PostData postData) {
        this.bcv = postData.QL();
        if (this.bcv == null) {
            this.bcr.setVisibility(8);
            return;
        }
        this.bcr.setVisibility(0);
        this.bcr.setTag(this.bcv);
    }

    public void onChangeSkinType() {
        aj.t(this.mRootView, d.C0108d.cp_bg_line_e);
        aj.t(this.bcq, d.C0108d.cp_bg_line_e);
        aj.r(this.bcq, d.C0108d.cp_cont_j);
        this.bcr.bng();
    }

    public TextView getGodReplyContent() {
        return this.bcq;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(d.g.god_reply_image_layout) != null && (view.getTag(d.g.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(d.g.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.QU());
            }
            ImageViewerConfig createConfig = new ImageViewerConfig(getContext()).createConfig(arrayList, intValue, null, "", "", true, arrayList.get(0), true);
            createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_DISCOVER_BEAUTY);
            createConfig.setIsShowHost(false);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends ReplacementSpan {
        private int bcA;
        private int fontSize;
        private int mColor;

        public b(int i, int i2, int i3) {
            this.fontSize = i;
            this.bcA = i3;
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
            canvas.drawText(subSequence.toString(), f, i4 - (this.bcA / 2), a);
        }

        private TextPaint a(Paint paint) {
            TextPaint textPaint = new TextPaint(paint);
            textPaint.setTextSize(this.fontSize);
            return textPaint;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends com.baidu.tbadk.widget.f {
        private int bcy;
        private TextView bcz;

        public a(Drawable drawable, TextView textView, int i) {
            super(drawable);
            this.bcy = 0;
            this.bcz = textView;
            this.bcy = i;
        }

        @Override // com.baidu.tbadk.widget.f, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            if (getDrawable() != null && (this.bcz.getLineCount() > 1 || Build.VERSION.SDK_INT < 21)) {
                setVerticalOffset(this.bcy);
                super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
                return;
            }
            setVerticalOffset(0);
            super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
        }
    }
}

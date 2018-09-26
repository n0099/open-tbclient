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
    private static final int aBa = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0141e.tbds42);
    private TextView aAT;
    private PlayVoiceBntNew aAU;
    private FrameLayout aAV;
    private LinearLayout aAW;
    private TextView aAX;
    private TbRichTextVoiceInfo aAY;
    private boolean aAZ;
    private boolean avq;
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
        this.aAT = (TextView) this.mView.findViewById(e.g.god_reply_content);
        this.aAU = (PlayVoiceBntNew) this.mView.findViewById(e.g.god_reply_voice_btn);
        this.aAU.setVisibility(8);
        this.aAV = (FrameLayout) this.mView.findViewById(e.g.god_reply_image_layout);
        int aO = com.baidu.adp.lib.util.l.aO(getContext());
        int h = com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.tbds20);
        int h2 = ((aO - (com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.tbds44) * 2)) - (h * 7)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(h2, h2);
            layoutParams.leftMargin = (h2 + h) * i;
            this.aAV.addView(tbImageView, layoutParams);
            tbImageView.setTag(e.g.god_reply_image_layout, Integer.valueOf(i));
            tbImageView.setTagTextSize((int) getResources().getDimension(e.C0141e.tbfontsize26));
            tbImageView.setTagPaddingDis(com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.tbds6), com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.tbds6));
            tbImageView.setOnClickListener(this);
        }
        this.aAV.setVisibility(8);
        this.aAW = (LinearLayout) this.mView.findViewById(e.g.god_reply_img_multi_layout);
        this.aAW.setVisibility(8);
        this.aAW.bringToFront();
        this.aAW.setClickable(false);
        this.aAX = (TextView) this.mView.findViewById(e.g.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.avq = z;
    }

    public void setData(PostData postData) {
        if (postData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        b(postData);
        c(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.aAY != null && this.aAY.PM() != null)) {
            this.aAZ = true;
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.tbds30));
        } else {
            this.aAZ = false;
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.tbds25));
        }
        a(postData, 2);
        if (!V(this.aAT) && !V(this.aAV) && !V(this.aAU)) {
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
        spannableStringBuilder2.setSpan(new a(drawable, this.aAT, com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.tbds4)), 0, spannableStringBuilder2.length(), 33);
        if (postData.xy() >= 0) {
            int length = spannableStringBuilder2.length();
            spannableStringBuilder2.append((CharSequence) (" " + ao.G(postData.xy()) + getResources().getString(e.j.zan)));
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_cont_h)), length, spannableStringBuilder2.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        SpannableStringBuilder a2 = a(postData.byO());
        if (a2 != null && !TextUtils.isEmpty(a2.toString())) {
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("  |  ");
            int h = com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.tbds34);
            spannableStringBuilder3.setSpan(new b(h, al.getColor(e.d.cp_cont_d), aBa - h), 0, spannableStringBuilder3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
            spannableStringBuilder.append((CharSequence) a2);
            this.aAT.setVisibility(0);
            this.aAT.setMaxLines(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.aAT.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            if (i >= 2 && this.aAT.getLineCount() > i) {
                spannableStringBuilder = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, this.aAT.getLayout().getLineEnd(i - 1) - 3);
                spannableStringBuilder.append((CharSequence) "...");
            }
            this.aAT.setMaxLines(i);
            this.aAT.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else if (!this.aAZ) {
            this.aAT.setVisibility(8);
        } else {
            this.aAT.setVisibility(0);
            this.aAT.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> OP;
        if (tbRichText == null || (OP = tbRichText.OP()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = OP.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.OW());
            } else if (next.getType() == 17) {
                String str = next.Pa().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.i.uj().un()) {
            this.aAV.setVisibility(8);
            this.aAW.setVisibility(8);
            return;
        }
        TbRichText byO = postData.byO();
        if (byO == null || byO.OP() == null) {
            this.aAV.setVisibility(8);
            this.aAW.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = byO.OP().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.T(aBa, aBa);
                if (next.getType() == 8) {
                    this.mImageList.add(next.OV());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.aAV.setVisibility(8);
            this.aAW.setVisibility(8);
            return;
        }
        this.aAV.setVisibility(0);
        int i = 0;
        for (int i2 = 0; i2 < this.aAV.getChildCount(); i2++) {
            View childAt = this.aAV.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.Pk())) {
                        ((TbImageView) childAt).startLoad(tbRichTextImageInfo.Pk(), this.avq ? 13 : 14, false);
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
            this.aAW.setVisibility(0);
            this.aAX.setText("" + this.mImageList.size());
            return;
        }
        this.aAW.setVisibility(8);
    }

    public void c(PostData postData) {
        this.aAY = postData.OX();
        if (this.aAY == null) {
            this.aAU.setVisibility(8);
            return;
        }
        this.aAU.setVisibility(0);
        this.aAU.setTag(this.aAY);
    }

    public void onChangeSkinType() {
        al.j(this.mRootView, e.d.cp_bg_line_e);
        al.j(this.aAT, e.d.cp_bg_line_e);
        al.h(this.aAT, e.d.cp_cont_j);
        this.aAU.aRD();
    }

    public TextView getGodReplyContent() {
        return this.aAT;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(e.g.god_reply_image_layout) != null && (view.getTag(e.g.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(e.g.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.Pg());
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
        private int aBd;
        private int fontSize;
        private int mColor;

        public b(int i, int i2, int i3) {
            this.fontSize = i;
            this.aBd = i3;
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
            canvas.drawText(subSequence.toString(), f, i4 - (this.aBd / 2), a);
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
        private int aBb;
        private TextView aBc;

        public a(Drawable drawable, TextView textView, int i) {
            super(drawable);
            this.aBb = 0;
            this.aBc = textView;
            this.aBb = i;
        }

        @Override // com.baidu.tbadk.widget.c, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            if (getDrawable() != null && (this.aBc.getLineCount() > 1 || Build.VERSION.SDK_INT < 21)) {
                setVerticalOffset(this.aBb);
                super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
                return;
            }
            setVerticalOffset(0);
            super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
        }
    }
}

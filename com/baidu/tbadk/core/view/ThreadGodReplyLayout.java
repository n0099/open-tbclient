package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
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
    private static final int bee = com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst(), d.e.tbds42);
    private boolean aQq;
    private boolean aYZ;
    private TextView bdX;
    private PlayVoiceBntNew bdY;
    private FrameLayout bdZ;
    private LinearLayout bea;
    private TextView beb;
    private TbRichTextVoiceInfo bec;
    private boolean bed;
    private Context mContext;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private View mView;

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.aQq = false;
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aQq = false;
        init(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aQq = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mView = LayoutInflater.from(context).inflate(d.h.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(d.g.god_comment_layout);
        this.bdX = (TextView) this.mView.findViewById(d.g.god_reply_content);
        this.bdY = (PlayVoiceBntNew) this.mView.findViewById(d.g.god_reply_voice_btn);
        this.bdY.setVisibility(8);
        this.bdZ = (FrameLayout) this.mView.findViewById(d.g.god_reply_image_layout);
        int ao = com.baidu.adp.lib.util.l.ao(getContext());
        int t = com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds20);
        int t2 = ((ao - (com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds44) * 2)) - (t * 7)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(t2, t2);
            layoutParams.leftMargin = (t2 + t) * i;
            this.bdZ.addView(tbImageView, layoutParams);
            tbImageView.setTag(d.g.god_reply_image_layout, Integer.valueOf(i));
            tbImageView.setTagTextSize((int) getResources().getDimension(d.e.tbfontsize26));
            tbImageView.setTagPaddingDis(com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds6), com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds6));
            tbImageView.setOnClickListener(this);
        }
        this.bdZ.setVisibility(8);
        this.bea = (LinearLayout) this.mView.findViewById(d.g.god_reply_img_multi_layout);
        this.bea.setVisibility(8);
        this.bea.bringToFront();
        this.bea.setClickable(false);
        this.beb = (TextView) this.mView.findViewById(d.g.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.aYZ = z;
    }

    public void setData(PostData postData) {
        if (postData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        a(postData);
        b(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.bec != null && this.bec.Se() != null)) {
            this.bed = true;
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds30));
        } else {
            this.bed = false;
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds25));
        }
        a(postData, 2);
        if (!ba(this.bdX) && !ba(this.bdZ) && !ba(this.bdY)) {
            setVisibility(8);
        }
    }

    private boolean ba(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData, int i) {
        SpannableStringBuilder spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder();
        Drawable drawable = aj.getDrawable(d.f.icon_popular_reply_n);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        if (this.aQq) {
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            drawable.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        } else {
            drawable.setColorFilter(null);
        }
        spannableStringBuilder3.append((CharSequence) "tag");
        spannableStringBuilder3.setSpan(new a(drawable, this.bdX, com.baidu.adp.lib.util.l.t(getContext(), d.e.tbds4)), 0, spannableStringBuilder3.length(), 33);
        if (postData.bxk() >= 0) {
            int length = spannableStringBuilder3.length();
            spannableStringBuilder3.append((CharSequence) (" " + am.E(postData.bxk()) + getResources().getString(d.j.zan)));
            spannableStringBuilder3.setSpan(new ForegroundColorSpan(aj.getColor(this.aQq ? d.C0141d.cp_cont_b : d.C0141d.cp_cont_h)), length, spannableStringBuilder3.length(), 33);
        }
        spannableStringBuilder2.append((CharSequence) spannableStringBuilder3);
        SpannableStringBuilder a2 = a(postData.bxb());
        if (a2 != null && !TextUtils.isEmpty(a2.toString())) {
            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder("  |  ");
            int t = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds34);
            spannableStringBuilder4.setSpan(new b(t, aj.getColor(d.C0141d.cp_cont_d), bee - t), 0, spannableStringBuilder4.length(), 33);
            spannableStringBuilder2.append((CharSequence) spannableStringBuilder4);
            spannableStringBuilder2.append((CharSequence) a2);
            this.bdX.setVisibility(0);
            this.bdX.setMaxLines(Integer.MAX_VALUE);
            this.bdX.setText(spannableStringBuilder2, TextView.BufferType.SPANNABLE);
            if (i < 2 || this.bdX.getLineCount() <= i) {
                spannableStringBuilder = spannableStringBuilder2;
            } else {
                spannableStringBuilder = (SpannableStringBuilder) spannableStringBuilder2.subSequence(0, this.bdX.getLayout().getLineEnd(i - 1) - 3);
                spannableStringBuilder.append((CharSequence) "...");
            }
            this.bdX.setMaxLines(i);
            this.bdX.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else if (!this.bed) {
            this.bdX.setVisibility(8);
        } else {
            this.bdX.setVisibility(0);
            this.bdX.setText(spannableStringBuilder2, TextView.BufferType.SPANNABLE);
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> Ri;
        if (tbRichText == null || (Ri = tbRichText.Ri()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = Ri.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.Rp());
            } else if (next.getType() == 17) {
                String str = next.Rt().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.i.xo().xu()) {
            this.bdZ.setVisibility(8);
            this.bea.setVisibility(8);
            return;
        }
        TbRichText bxb = postData.bxb();
        if (bxb == null || bxb.Ri() == null) {
            this.bdZ.setVisibility(8);
            this.bea.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = bxb.Ri().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.aT(bee, bee);
                if (next.getType() == 8) {
                    this.mImageList.add(next.Ro());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.bdZ.setVisibility(8);
            this.bea.setVisibility(8);
            return;
        }
        this.bdZ.setVisibility(0);
        int i = 0;
        for (int i2 = 0; i2 < this.bdZ.getChildCount(); i2++) {
            View childAt = this.bdZ.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.RC())) {
                        ((TbImageView) childAt).startLoad(tbRichTextImageInfo.RC(), this.aYZ ? 13 : 14, false);
                        childAt.setVisibility(0);
                        ((TbImageView) childAt).changeGrayScaleMode(this.aQq);
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
            this.bea.setVisibility(0);
            this.beb.setText("" + this.mImageList.size());
            return;
        }
        this.bea.setVisibility(8);
    }

    public void b(PostData postData) {
        this.bec = postData.Rq();
        if (this.bec == null) {
            this.bdY.setVisibility(8);
            return;
        }
        this.bdY.setVisibility(0);
        this.bdY.setTag(this.bec);
    }

    public void onChangeSkinType() {
        aj.t(this.mRootView, d.C0141d.cp_bg_line_e);
        aj.t(this.bdX, d.C0141d.cp_bg_line_e);
        aj.r(this.bdX, d.C0141d.cp_cont_j);
        this.bdY.aNR();
    }

    public TextView getGodReplyContent() {
        return this.bdX;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(d.g.god_reply_image_layout) != null && (view.getTag(d.g.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(d.g.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.Rz());
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
        private int beh;
        private int fontSize;
        private int mColor;

        public b(int i, int i2, int i3) {
            this.fontSize = i;
            this.beh = i3;
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
            canvas.drawText(subSequence.toString(), f, i4 - (this.beh / 2), a);
        }

        private TextPaint a(Paint paint) {
            TextPaint textPaint = new TextPaint(paint);
            textPaint.setTextSize(this.fontSize);
            return textPaint;
        }
    }

    public void setGrayScaleMode(boolean z) {
        this.aQq = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends com.baidu.tbadk.widget.f {
        private int bef;
        private TextView beg;

        public a(Drawable drawable, TextView textView, int i) {
            super(drawable);
            this.bef = 0;
            this.beg = textView;
            this.bef = i;
        }

        @Override // com.baidu.tbadk.widget.f, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            if (getDrawable() != null && (this.beg.getLineCount() > 1 || Build.VERSION.SDK_INT < 21)) {
                setVerticalOffset(this.bef);
                super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
                return;
            }
            setVerticalOffset(0);
            super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
        }
    }
}

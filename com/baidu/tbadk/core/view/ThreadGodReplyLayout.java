package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
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
import com.baidu.adp.lib.util.l;
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
    private boolean aiR;
    private TextView anW;
    private PlayVoiceBntNew anX;
    private FrameLayout anY;
    private LinearLayout anZ;
    private TextView aoa;
    private TbRichTextVoiceInfo aob;
    private boolean aoc;
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
        this.anW = (TextView) this.mView.findViewById(d.g.god_reply_content);
        this.anX = (PlayVoiceBntNew) this.mView.findViewById(d.g.god_reply_voice_btn);
        this.anX.setVisibility(8);
        this.anY = (FrameLayout) this.mView.findViewById(d.g.god_reply_image_layout);
        int ac = l.ac(getContext()) - l.f(getContext(), d.e.ds100);
        int f = l.f(getContext(), d.e.ds16);
        int i = (int) ((ac - (f * 5)) * 0.1667d);
        for (int i2 = 0; i2 < 6; i2++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
            layoutParams.leftMargin = (i + f) * i2;
            this.anY.addView(tbImageView, layoutParams);
            tbImageView.setTag(d.g.god_reply_image_layout, Integer.valueOf(i2));
            tbImageView.setTagTextSize((int) getResources().getDimension(d.e.fontsize16));
            tbImageView.setTagPaddingDis(l.f(getContext(), d.e.ds4), l.f(getContext(), d.e.ds4));
            tbImageView.setTagDrawerExtraWH(l.f(getContext(), d.e.ds20), l.f(getContext(), d.e.ds14));
            tbImageView.setOnClickListener(this);
        }
        this.anY.setVisibility(8);
        this.anZ = (LinearLayout) this.mView.findViewById(d.g.god_reply_img_multi_layout);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.anZ.getLayoutParams();
        layoutParams2.width = i;
        layoutParams2.height = i;
        layoutParams2.leftMargin = (f + i) * 5;
        this.anZ.setLayoutParams(layoutParams2);
        this.anZ.setVisibility(8);
        this.anZ.bringToFront();
        this.anZ.setClickable(false);
        this.aoa = (TextView) this.mView.findViewById(d.g.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.aiR = z;
    }

    public void setData(PostData postData) {
        if (postData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        a(postData);
        b(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.aob != null && this.aob.JC() != null)) {
            this.aoc = true;
            a(postData, 2);
        } else {
            this.aoc = false;
            a(postData, 3);
        }
        if (!G(this.anW) && !G(this.anY) && !G(this.anX)) {
            setVisibility(8);
        }
    }

    private boolean G(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        Drawable drawable = aj.getDrawable(d.f.icon_popular_reply_n);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableStringBuilder2.append((CharSequence) "tag");
        spannableStringBuilder2.setSpan(new com.baidu.adp.widget.b(drawable, 1), 0, spannableStringBuilder2.length(), 33);
        if (postData.buG() >= 0) {
            int length = spannableStringBuilder2.length();
            spannableStringBuilder2.append((CharSequence) (" " + am.v(postData.buG()) + getResources().getString(d.j.zan)));
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(aj.getColor(d.C0080d.cp_cont_h)), length, spannableStringBuilder2.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        SpannableStringBuilder a2 = a(postData.aEt());
        if (a2 != null && !TextUtils.isEmpty(a2.toString())) {
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("  |  ");
            spannableStringBuilder3.setSpan(new a(l.f(this.mContext, d.e.ds26), aj.getColor(d.C0080d.cp_cont_d)), 0, spannableStringBuilder3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
            spannableStringBuilder.append((CharSequence) a2);
            this.anW.setVisibility(0);
            this.anW.setMaxLines(Integer.MAX_VALUE);
            this.anW.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            if (i >= 3 && this.anW.getLineCount() > i) {
                spannableStringBuilder = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, this.anW.getLayout().getLineEnd(i - 1) - 3);
                spannableStringBuilder.append((CharSequence) "...");
            }
            this.anW.setMaxLines(i);
            this.anW.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else if (!this.aoc) {
            this.anW.setVisibility(8);
        } else {
            this.anW.setVisibility(0);
            this.anW.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> II;
        if (tbRichText == null || (II = tbRichText.II()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = II.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.IP());
            } else if (next.getType() == 17) {
                String str = next.IT().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.h.oT().oZ()) {
            this.anY.setVisibility(8);
            this.anZ.setVisibility(8);
            return;
        }
        TbRichText aEt = postData.aEt();
        if (aEt == null || aEt.II() == null) {
            this.anY.setVisibility(8);
            this.anZ.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = aEt.II().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                this.mImageList.add(next.IO());
            }
        }
        if (this.mImageList.size() == 0) {
            this.anY.setVisibility(8);
            this.anZ.setVisibility(8);
            return;
        }
        this.anY.setVisibility(0);
        int i = 0;
        for (int i2 = 0; i2 < this.anY.getChildCount(); i2++) {
            View childAt = this.anY.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.Jc())) {
                        ((TbImageView) childAt).startLoad(tbRichTextImageInfo.Jc(), this.aiR ? 13 : 14, false);
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
        if (this.mImageList.size() > 6) {
            this.anZ.setVisibility(0);
            this.aoa.setText("" + this.mImageList.size());
            return;
        }
        this.anZ.setVisibility(8);
    }

    public void b(PostData postData) {
        this.aob = postData.IQ();
        if (this.aob == null) {
            this.anX.setVisibility(8);
            return;
        }
        this.anX.setVisibility(0);
        this.anX.setTag(this.aob);
    }

    public void onChangeSkinType() {
        aj.k(this.mRootView, d.C0080d.cp_bg_line_e);
        aj.k(this.anW, d.C0080d.cp_bg_line_e);
        aj.i(this.anW, d.C0080d.cp_cont_f);
        this.anX.bjo();
    }

    public TextView getGodReplyContent() {
        return this.anW;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(d.g.god_reply_image_layout) != null && (view.getTag(d.g.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(d.g.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.IZ());
            }
            ImageViewerConfig createConfig = new ImageViewerConfig(getContext()).createConfig(arrayList, intValue, null, "", "", true, arrayList.get(0), true);
            createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_DISCOVER_BEAUTY);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends ReplacementSpan {
        private int fontSize;
        private final int mColor;

        public a(int i, int i2) {
            this.fontSize = i;
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
            Paint.FontMetricsInt fontMetricsInt = a.getFontMetricsInt();
            canvas.drawText(subSequence.toString(), f, i4 - (((fontMetricsInt.ascent + ((fontMetricsInt.descent + i4) + i4)) / 2) - ((i5 + i3) / 2)), a);
        }

        private TextPaint a(Paint paint) {
            TextPaint textPaint = new TextPaint(paint);
            textPaint.setTextSize(this.fontSize);
            return textPaint;
        }
    }
}

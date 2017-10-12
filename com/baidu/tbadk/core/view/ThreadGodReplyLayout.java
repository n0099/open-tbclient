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
    private boolean aiG;
    private TextView anN;
    private PlayVoiceBntNew anO;
    private FrameLayout anP;
    private LinearLayout anQ;
    private TextView anR;
    private TbRichTextVoiceInfo anS;
    private boolean anT;
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
        this.mView = LayoutInflater.from(context).inflate(d.j.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(d.h.god_comment_layout);
        this.anN = (TextView) this.mView.findViewById(d.h.god_reply_content);
        this.anO = (PlayVoiceBntNew) this.mView.findViewById(d.h.god_reply_voice_btn);
        this.anO.setVisibility(8);
        this.anP = (FrameLayout) this.mView.findViewById(d.h.god_reply_image_layout);
        int ad = l.ad(getContext()) - l.f(getContext(), d.f.ds100);
        int f = l.f(getContext(), d.f.ds16);
        int i = (int) ((ad - (f * 5)) * 0.1667d);
        for (int i2 = 0; i2 < 6; i2++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
            layoutParams.leftMargin = (i + f) * i2;
            this.anP.addView(tbImageView, layoutParams);
            tbImageView.setTag(d.h.god_reply_image_layout, Integer.valueOf(i2));
            tbImageView.setTagTextSize((int) getResources().getDimension(d.f.fontsize16));
            tbImageView.O(l.f(getContext(), d.f.ds4), l.f(getContext(), d.f.ds4));
            tbImageView.N(l.f(getContext(), d.f.ds20), l.f(getContext(), d.f.ds14));
            tbImageView.setOnClickListener(this);
        }
        this.anP.setVisibility(8);
        this.anQ = (LinearLayout) this.mView.findViewById(d.h.god_reply_img_multi_layout);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.anQ.getLayoutParams();
        layoutParams2.width = i;
        layoutParams2.height = i;
        layoutParams2.leftMargin = (f + i) * 5;
        this.anQ.setLayoutParams(layoutParams2);
        this.anQ.setVisibility(8);
        this.anQ.bringToFront();
        this.anQ.setClickable(false);
        this.anR = (TextView) this.mView.findViewById(d.h.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.aiG = z;
    }

    public void setData(PostData postData) {
        if (postData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        a(postData);
        b(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.anS != null && this.anS.Jy() != null)) {
            this.anT = true;
            a(postData, 2);
        } else {
            this.anT = false;
            a(postData, 3);
        }
        if (!G(this.anN) && !G(this.anP) && !G(this.anO)) {
            setVisibility(8);
        }
    }

    private boolean G(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        Drawable drawable = aj.getDrawable(d.g.icon_popular_reply_n);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableStringBuilder2.append((CharSequence) "tag");
        spannableStringBuilder2.setSpan(new com.baidu.adp.widget.b(drawable, 1), 0, spannableStringBuilder2.length(), 33);
        if (postData.brJ() >= 0) {
            int length = spannableStringBuilder2.length();
            spannableStringBuilder2.append((CharSequence) (" " + am.u(postData.brJ()) + getResources().getString(d.l.zan)));
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_cont_h)), length, spannableStringBuilder2.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        SpannableStringBuilder a2 = a(postData.aCd());
        if (a2 != null && !TextUtils.isEmpty(a2.toString())) {
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("  |  ");
            spannableStringBuilder3.setSpan(new a(l.f(this.mContext, d.f.ds26), aj.getColor(d.e.cp_cont_d)), 0, spannableStringBuilder3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
            spannableStringBuilder.append((CharSequence) a2);
            this.anN.setVisibility(0);
            this.anN.setMaxLines(Integer.MAX_VALUE);
            this.anN.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            if (i >= 3 && this.anN.getLineCount() > i) {
                spannableStringBuilder = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, this.anN.getLayout().getLineEnd(i - 1) - 3);
                spannableStringBuilder.append((CharSequence) "...");
            }
            this.anN.setMaxLines(i);
            this.anN.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else if (!this.anT) {
            this.anN.setVisibility(8);
        } else {
            this.anN.setVisibility(0);
            this.anN.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> ID;
        if (tbRichText == null || (ID = tbRichText.ID()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = ID.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.IK());
            } else if (next.getType() == 17) {
                String str = next.IO().mGifInfo.mSharpText;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    spannableStringBuilder.append((CharSequence) "[表情]");
                }
            } else if (next.getType() == 20) {
                spannableStringBuilder.append((CharSequence) "[表情]");
            }
        }
        if (spannableStringBuilder.length() > 0) {
            for (com.baidu.tbadk.widget.richText.b bVar : (com.baidu.tbadk.widget.richText.b[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length() - 1, com.baidu.tbadk.widget.richText.b.class)) {
                spannableStringBuilder.removeSpan(bVar);
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
            this.anP.setVisibility(8);
            this.anQ.setVisibility(8);
            return;
        }
        TbRichText aCd = postData.aCd();
        if (aCd == null || aCd.ID() == null) {
            this.anP.setVisibility(8);
            this.anQ.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = aCd.ID().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                this.mImageList.add(next.IJ());
            }
        }
        if (this.mImageList.size() == 0) {
            this.anP.setVisibility(8);
            this.anQ.setVisibility(8);
            return;
        }
        this.anP.setVisibility(0);
        int i = 0;
        for (int i2 = 0; i2 < this.anP.getChildCount(); i2++) {
            View childAt = this.anP.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.IX())) {
                        ((TbImageView) childAt).c(tbRichTextImageInfo.IX(), this.aiG ? 13 : 14, false);
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
            this.anQ.setVisibility(0);
            this.anR.setText("" + this.mImageList.size());
            return;
        }
        this.anQ.setVisibility(8);
    }

    public void b(PostData postData) {
        this.anS = postData.IL();
        if (this.anS == null) {
            this.anO.setVisibility(8);
            return;
        }
        this.anO.setVisibility(0);
        this.anO.setTag(this.anS);
    }

    public void onChangeSkinType() {
        aj.k(this.mRootView, d.e.cp_bg_line_e);
        aj.k(this.anN, d.e.cp_bg_line_e);
        aj.i(this.anN, d.e.cp_cont_f);
        this.anO.bgh();
    }

    public TextView getGodReplyContent() {
        return this.anN;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(d.h.god_reply_image_layout) != null && (view.getTag(d.h.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(d.h.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.IU());
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

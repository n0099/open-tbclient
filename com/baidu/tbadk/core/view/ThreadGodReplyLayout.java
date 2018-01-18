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
    private static final int bcp = com.baidu.adp.lib.util.l.s(TbadkCoreApplication.getInst(), d.e.tbds42);
    private boolean aXs;
    private TextView bci;
    private PlayVoiceBntNew bcj;
    private FrameLayout bck;
    private LinearLayout bcl;
    private TextView bcm;
    private TbRichTextVoiceInfo bcn;
    private boolean bco;
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
        this.bci = (TextView) this.mView.findViewById(d.g.god_reply_content);
        this.bcj = (PlayVoiceBntNew) this.mView.findViewById(d.g.god_reply_voice_btn);
        this.bcj.setVisibility(8);
        this.bck = (FrameLayout) this.mView.findViewById(d.g.god_reply_image_layout);
        int ao = com.baidu.adp.lib.util.l.ao(getContext());
        int s = com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds20);
        int s2 = ((ao - (com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds44) * 2)) - (s * 7)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(s2, s2);
            layoutParams.leftMargin = (s2 + s) * i;
            this.bck.addView(tbImageView, layoutParams);
            tbImageView.setTag(d.g.god_reply_image_layout, Integer.valueOf(i));
            tbImageView.setTagTextSize((int) getResources().getDimension(d.e.tbfontsize26));
            tbImageView.setTagPaddingDis(com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds6), com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds6));
            tbImageView.setOnClickListener(this);
        }
        this.bck.setVisibility(8);
        this.bcl = (LinearLayout) this.mView.findViewById(d.g.god_reply_img_multi_layout);
        this.bcl.setVisibility(8);
        this.bcl.bringToFront();
        this.bcl.setClickable(false);
        this.bcm = (TextView) this.mView.findViewById(d.g.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.aXs = z;
    }

    public void setData(PostData postData) {
        if (postData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        a(postData);
        b(postData);
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.bcn != null && this.bcn.Ry() != null)) {
            this.bco = true;
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds30));
        } else {
            this.bco = false;
            this.mRootView.setPadding(0, 0, 0, com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds25));
        }
        a(postData, 2);
        if (!ba(this.bci) && !ba(this.bck) && !ba(this.bcj)) {
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
        spannableStringBuilder2.setSpan(new a(drawable, this.bci, com.baidu.adp.lib.util.l.s(getContext(), d.e.tbds4)), 0, spannableStringBuilder2.length(), 33);
        if (postData.bvV() >= 0) {
            int length = spannableStringBuilder2.length();
            spannableStringBuilder2.append((CharSequence) (" " + am.E(postData.bvV()) + getResources().getString(d.j.zan)));
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(aj.getColor(d.C0107d.cp_cont_h)), length, spannableStringBuilder2.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        SpannableStringBuilder a2 = a(postData.bvK());
        if (a2 != null && !TextUtils.isEmpty(a2.toString())) {
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("  |  ");
            int s = com.baidu.adp.lib.util.l.s(this.mContext, d.e.tbds34);
            spannableStringBuilder3.setSpan(new b(s, aj.getColor(d.C0107d.cp_cont_d), bcp - s), 0, spannableStringBuilder3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
            spannableStringBuilder.append((CharSequence) a2);
            this.bci.setVisibility(0);
            this.bci.setMaxLines(Integer.MAX_VALUE);
            this.bci.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            if (i >= 2 && this.bci.getLineCount() > i) {
                spannableStringBuilder = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, this.bci.getLayout().getLineEnd(i - 1) - 3);
                spannableStringBuilder.append((CharSequence) "...");
            }
            this.bci.setMaxLines(i);
            this.bci.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        } else if (!this.bco) {
            this.bci.setVisibility(8);
        } else {
            this.bci.setVisibility(0);
            this.bci.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
        }
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> QB;
        if (tbRichText == null || (QB = tbRichText.QB()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = QB.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.QI());
            } else if (next.getType() == 17) {
                String str = next.QM().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.i.wA().wG()) {
            this.bck.setVisibility(8);
            this.bcl.setVisibility(8);
            return;
        }
        TbRichText bvK = postData.bvK();
        if (bvK == null || bvK.QB() == null) {
            this.bck.setVisibility(8);
            this.bcl.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = bvK.QB().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                next.aT(bcp, bcp);
                if (next.getType() == 8) {
                    this.mImageList.add(next.QH());
                }
            }
        }
        if (this.mImageList.size() == 0) {
            this.bck.setVisibility(8);
            this.bcl.setVisibility(8);
            return;
        }
        this.bck.setVisibility(0);
        int i = 0;
        for (int i2 = 0; i2 < this.bck.getChildCount(); i2++) {
            View childAt = this.bck.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.QV())) {
                        ((TbImageView) childAt).startLoad(tbRichTextImageInfo.QV(), this.aXs ? 13 : 14, false);
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
            this.bcl.setVisibility(0);
            this.bcm.setText("" + this.mImageList.size());
            return;
        }
        this.bcl.setVisibility(8);
    }

    public void b(PostData postData) {
        this.bcn = postData.QJ();
        if (this.bcn == null) {
            this.bcj.setVisibility(8);
            return;
        }
        this.bcj.setVisibility(0);
        this.bcj.setTag(this.bcn);
    }

    public void onChangeSkinType() {
        aj.t(this.mRootView, d.C0107d.cp_bg_line_e);
        aj.t(this.bci, d.C0107d.cp_bg_line_e);
        aj.r(this.bci, d.C0107d.cp_cont_j);
        this.bcj.bnf();
    }

    public TextView getGodReplyContent() {
        return this.bci;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(d.g.god_reply_image_layout) != null && (view.getTag(d.g.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(d.g.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.QS());
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
        private int bcs;
        private int fontSize;
        private int mColor;

        public b(int i, int i2, int i3) {
            this.fontSize = i;
            this.bcs = i3;
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
            canvas.drawText(subSequence.toString(), f, i4 - (this.bcs / 2), a);
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
        private int bcq;
        private TextView bcr;

        public a(Drawable drawable, TextView textView, int i) {
            super(drawable);
            this.bcq = 0;
            this.bcr = textView;
            this.bcq = i;
        }

        @Override // com.baidu.tbadk.widget.f, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            if (getDrawable() != null && (this.bcr.getLineCount() > 1 || Build.VERSION.SDK_INT < 21)) {
                setVerticalOffset(this.bcq);
                super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
                return;
            }
            setVerticalOffset(0);
            super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
        }
    }
}

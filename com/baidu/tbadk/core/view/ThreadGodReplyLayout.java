package com.baidu.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ThreadGodReplyLayout extends RelativeLayout {
    private boolean ahU;
    private TextView amV;
    private PlayVoiceBntNew amW;
    private FrameLayout amX;
    private LinearLayout amY;
    private TextView amZ;
    private TextView aml;
    private ImageView ana;
    private boolean anb;
    private TbRichTextVoiceInfo anc;
    private Context mContext;
    private List<TbRichTextImageInfo> mImageList;
    private RelativeLayout mRootView;
    private View mView;
    private int mWidth;

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
        this.mView = LayoutInflater.from(context).inflate(w.j.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(w.h.god_comment_layout);
        this.ana = (ImageView) this.mView.findViewById(w.h.god_reply_tag);
        this.amV = (TextView) this.mView.findViewById(w.h.god_reply_content);
        this.aml = (TextView) this.mView.findViewById(w.h.praise_num);
        this.amW = (PlayVoiceBntNew) this.mView.findViewById(w.h.god_reply_voice_btn);
        this.amW.setVisibility(8);
        this.amX = (FrameLayout) this.mView.findViewById(w.h.god_reply_image_layout);
        this.mWidth = com.baidu.adp.lib.util.k.af(getContext()) - com.baidu.adp.lib.util.k.g(getContext(), w.f.ds140);
        int g = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds8);
        int i = (int) ((this.mWidth - (g * 2)) * 0.3333d);
        for (int i2 = 0; i2 < 3; i2++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
            layoutParams.leftMargin = (i + g) * i2;
            this.amX.addView(tbImageView, layoutParams);
            tbImageView.setOnClickListener(new ar(this, i2));
        }
        this.amX.setVisibility(8);
        this.amY = (LinearLayout) this.mView.findViewById(w.h.god_reply_img_multi_layout);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.amY.getLayoutParams();
        layoutParams2.width = i;
        layoutParams2.height = i;
        layoutParams2.leftMargin = (g + i) * 2;
        this.amY.setLayoutParams(layoutParams2);
        this.amY.setVisibility(8);
        this.amY.bringToFront();
        this.amY.setClickable(false);
        this.amZ = (TextView) this.mView.findViewById(w.h.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.ahU = z;
    }

    public void setData(PostData postData) {
        if (postData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        a(postData);
        b(postData);
        c(postData);
        setPraised(postData.bmH());
        aN(postData.bmH());
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.anc != null && this.anc.IO() != null)) {
            a(postData, 2);
        } else {
            a(postData, 3);
        }
        if (!B(this.amV) && !B(this.amX) && !B(this.amW)) {
            setVisibility(8);
        }
    }

    private boolean B(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData, int i) {
        if (this.amV == null || postData.azb() == null) {
            this.amV.setVisibility(8);
            return;
        }
        SpannableStringBuilder a = a(postData.azb());
        if (a == null || com.baidu.tbadk.core.util.aw.isEmpty(a.toString())) {
            this.amV.setVisibility(8);
            return;
        }
        this.amV.setVisibility(0);
        this.amV.setMaxLines(Integer.MAX_VALUE);
        this.amV.setText(a, TextView.BufferType.SPANNABLE);
        if (i >= 3 && this.amV.getLineCount() > i) {
            a = (SpannableStringBuilder) a.subSequence(0, this.amV.getLayout().getLineEnd(i - 1) - 3);
            a.append("...");
        }
        this.amV.setMaxLines(i);
        this.amV.setText(a, TextView.BufferType.SPANNABLE);
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> HU = tbRichText.HU();
        if (HU == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = HU.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.Ib());
            } else if (next.getType() == 17) {
                String str = next.If().mGifInfo.mSharpText;
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

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x008e: INVOKE  (r2v1 int A[REMOVE]) = 
      (wrap: java.util.List<com.baidu.tbadk.widget.richText.TbRichTextImageInfo> : 0x008c: IGET  (r2v0 java.util.List<com.baidu.tbadk.widget.richText.TbRichTextImageInfo> A[REMOVE]) = (r8v0 'this' com.baidu.tbadk.core.view.ThreadGodReplyLayout A[IMMUTABLE_TYPE, THIS]) com.baidu.tbadk.core.view.ThreadGodReplyLayout.mImageList java.util.List)
     type: INTERFACE call: java.util.List.size():int)] */
    public void a(PostData postData) {
        if (this.mImageList == null) {
            this.mImageList = new ArrayList();
        } else {
            this.mImageList.clear();
        }
        if (!com.baidu.tbadk.core.r.oK().oQ()) {
            this.amX.setVisibility(8);
            return;
        }
        TbRichText azb = postData.azb();
        if (azb == null || azb.HU() == null) {
            this.amX.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = azb.HU().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                this.mImageList.add(next.Ia());
            }
        }
        if (this.mImageList.size() == 0) {
            this.amX.setVisibility(8);
            return;
        }
        this.amX.setVisibility(0);
        int i = 0;
        for (int i2 = 0; i2 < this.amX.getChildCount(); i2++) {
            View childAt = this.amX.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.Ip())) {
                        ((TbImageView) childAt).c(tbRichTextImageInfo.Ip(), this.ahU ? 13 : 14, false);
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
        if (this.mImageList.size() > 3) {
            this.amY.setVisibility(0);
            this.amZ.setText(new StringBuilder().append(this.mImageList.size()).toString());
            return;
        }
        this.amY.setVisibility(8);
    }

    public void b(PostData postData) {
        this.anc = postData.Ic();
        if (this.anc == null) {
            this.amW.setVisibility(8);
            return;
        }
        this.amW.setVisibility(0);
        this.amW.setTag(this.anc);
    }

    public void c(PostData postData) {
        if (this.aml != null && postData != null) {
            this.aml.setText(com.baidu.tbadk.core.util.aw.u(postData.bmG() >= 0 ? (int) postData.bmG() : 0L));
        }
    }

    private void aN(boolean z) {
        Drawable drawable;
        if (z) {
            drawable = com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_floor_praised);
        } else {
            drawable = com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_floor_praise_n);
        }
        this.aml.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        this.aml.setGravity(16);
    }

    private void setPraised(boolean z) {
        this.anb = z;
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.util.as.k(this.mRootView, w.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.as.k(this.amV, w.e.cp_bg_line_e);
        com.baidu.tbadk.core.util.as.i(this.aml, w.e.cp_cont_f);
        com.baidu.tbadk.core.util.as.i(this.amV, w.e.cp_cont_f);
        com.baidu.tbadk.core.util.as.c(this.ana, w.g.icon_corner_shen);
        this.amW.bef();
        aN(this.anb);
    }

    public TextView getGodReplyContent() {
        return this.amV;
    }

    public TextView getPraiseNum() {
        return this.aml;
    }
}

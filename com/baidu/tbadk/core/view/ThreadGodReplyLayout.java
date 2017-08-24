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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
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
public class ThreadGodReplyLayout extends RelativeLayout {
    private boolean ajL;
    private TextView aoj;
    private TextView apa;
    private PlayVoiceBntNew apb;
    private FrameLayout apc;
    private LinearLayout apd;
    private TextView ape;
    private ImageView apf;
    private boolean apg;
    private TbRichTextVoiceInfo aph;
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
        this.mView = LayoutInflater.from(context).inflate(d.j.thread_god_reply_layout, (ViewGroup) this, true);
        this.mRootView = (RelativeLayout) this.mView.findViewById(d.h.god_comment_layout);
        this.apf = (ImageView) this.mView.findViewById(d.h.god_reply_tag);
        this.apa = (TextView) this.mView.findViewById(d.h.god_reply_content);
        this.aoj = (TextView) this.mView.findViewById(d.h.praise_num);
        this.apb = (PlayVoiceBntNew) this.mView.findViewById(d.h.god_reply_voice_btn);
        this.apb.setVisibility(8);
        this.apc = (FrameLayout) this.mView.findViewById(d.h.god_reply_image_layout);
        this.mWidth = com.baidu.adp.lib.util.k.ag(getContext()) - com.baidu.adp.lib.util.k.g(getContext(), d.f.ds140);
        int g = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds8);
        int i = (int) ((this.mWidth - (g * 2)) * 0.3333d);
        for (final int i2 = 0; i2 < 3; i2++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
            layoutParams.leftMargin = (i + g) * i2;
            this.apc.addView(tbImageView, layoutParams);
            tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ThreadGodReplyLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ThreadGodReplyLayout.this.mImageList != null && ThreadGodReplyLayout.this.mImageList.size() != 0) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        for (TbRichTextImageInfo tbRichTextImageInfo : ThreadGodReplyLayout.this.mImageList) {
                            arrayList.add(tbRichTextImageInfo.IF());
                        }
                        ImageViewerConfig createConfig = new ImageViewerConfig(ThreadGodReplyLayout.this.getContext()).createConfig(arrayList, i2, null, "", "", true, arrayList.get(0), true);
                        createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_DISCOVER_BEAUTY);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                    }
                }
            });
        }
        this.apc.setVisibility(8);
        this.apd = (LinearLayout) this.mView.findViewById(d.h.god_reply_img_multi_layout);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.apd.getLayoutParams();
        layoutParams2.width = i;
        layoutParams2.height = i;
        layoutParams2.leftMargin = (g + i) * 2;
        this.apd.setLayoutParams(layoutParams2);
        this.apd.setVisibility(8);
        this.apd.bringToFront();
        this.apd.setClickable(false);
        this.ape = (TextView) this.mView.findViewById(d.h.god_reply_img_num);
    }

    public void setFromCDN(boolean z) {
        this.ajL = z;
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
        setPraised(postData.btm());
        aO(postData.btm());
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.aph != null && this.aph.Jh() != null)) {
            a(postData, 2);
        } else {
            a(postData, 3);
        }
        if (!B(this.apa) && !B(this.apc) && !B(this.apb)) {
            setVisibility(8);
        }
    }

    private boolean B(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData, int i) {
        if (this.apa == null || postData.aBr() == null) {
            this.apa.setVisibility(8);
            return;
        }
        SpannableStringBuilder a = a(postData.aBr());
        if (a == null || al.isEmpty(a.toString())) {
            this.apa.setVisibility(8);
            return;
        }
        this.apa.setVisibility(0);
        this.apa.setMaxLines(Integer.MAX_VALUE);
        this.apa.setText(a, TextView.BufferType.SPANNABLE);
        if (i >= 3 && this.apa.getLineCount() > i) {
            a = (SpannableStringBuilder) a.subSequence(0, this.apa.getLayout().getLineEnd(i - 1) - 3);
            a.append("...");
        }
        this.apa.setMaxLines(i);
        this.apa.setText(a, TextView.BufferType.SPANNABLE);
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> Io = tbRichText.Io();
        if (Io == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = Io.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.Iu());
            } else if (next.getType() == 17) {
                String str = next.Iy().mGifInfo.mSharpText;
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
        if (!com.baidu.tbadk.core.h.oY().pe()) {
            this.apc.setVisibility(8);
            return;
        }
        TbRichText aBr = postData.aBr();
        if (aBr == null || aBr.Io() == null) {
            this.apc.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = aBr.Io().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                this.mImageList.add(next.It());
            }
        }
        if (this.mImageList.size() == 0) {
            this.apc.setVisibility(8);
            return;
        }
        this.apc.setVisibility(0);
        int i = 0;
        for (int i2 = 0; i2 < this.apc.getChildCount(); i2++) {
            View childAt = this.apc.getChildAt(i2);
            if (childAt != null && (childAt instanceof TbImageView)) {
                if (i < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.II())) {
                        ((TbImageView) childAt).c(tbRichTextImageInfo.II(), this.ajL ? 13 : 14, false);
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
            this.apd.setVisibility(0);
            this.ape.setText("" + this.mImageList.size());
            return;
        }
        this.apd.setVisibility(8);
    }

    public void b(PostData postData) {
        this.aph = postData.Iv();
        if (this.aph == null) {
            this.apb.setVisibility(8);
            return;
        }
        this.apb.setVisibility(0);
        this.apb.setTag(this.aph);
    }

    public void c(PostData postData) {
        if (this.aoj != null && postData != null) {
            this.aoj.setText(al.v(postData.btl() >= 0 ? (int) postData.btl() : 0L));
        }
    }

    private void aO(boolean z) {
        Drawable drawable;
        if (z) {
            drawable = ai.getDrawable(d.g.icon_floor_praised);
        } else {
            drawable = ai.getDrawable(d.g.icon_floor_praise_n);
        }
        this.aoj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        this.aoj.setGravity(16);
    }

    private void setPraised(boolean z) {
        this.apg = z;
    }

    public void onChangeSkinType() {
        ai.k(this.mRootView, d.e.cp_bg_line_e);
        ai.k(this.apa, d.e.cp_bg_line_e);
        ai.i(this.aoj, d.e.cp_cont_f);
        ai.i(this.apa, d.e.cp_cont_f);
        ai.c(this.apf, d.g.icon_corner_shen);
        this.apb.bis();
        aO(this.apg);
    }

    public TextView getGodReplyContent() {
        return this.apa;
    }

    public TextView getPraiseNum() {
        return this.aoj;
    }
}

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
    private boolean ajf;
    private TextView anD;
    private TextView aoA;
    private PlayVoiceBntNew aoB;
    private LinearLayout aoC;
    private ImageView aoD;
    private TextView aoE;
    private TextView aoF;
    private View aoG;
    private View aoH;
    private int aoI;
    private int aoJ;
    private int aoK;
    private int aoL;
    private boolean aoM;
    private TbRichTextVoiceInfo aoN;
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
        this.aoD = (ImageView) this.mView.findViewById(d.h.god_reply_tag);
        this.aoA = (TextView) this.mView.findViewById(d.h.god_reply_content);
        this.anD = (TextView) this.mView.findViewById(d.h.praise_num);
        this.aoB = (PlayVoiceBntNew) this.mView.findViewById(d.h.god_reply_voice_btn);
        this.aoB.setVisibility(8);
        this.aoC = (LinearLayout) this.mView.findViewById(d.h.god_reply_image_layout);
        this.aoK = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds12);
        this.aoL = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds24);
        int ad = com.baidu.adp.lib.util.k.ad(getContext()) - com.baidu.adp.lib.util.k.g(getContext(), d.f.ds68);
        int g = com.baidu.adp.lib.util.k.g(getContext(), d.f.ds8);
        this.aoI = (int) ((ad * 0.25d) - (g * 2));
        this.aoJ = (int) ((ad * 0.2d) - (g * 2));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.aoC.getChildCount()) {
                View childAt = this.aoC.getChildAt(i2);
                if (childAt instanceof TbImageView) {
                    childAt.setTag(d.h.god_reply_image_layout, Integer.valueOf(i2));
                    childAt.setOnClickListener(this);
                } else if (childAt instanceof FrameLayout) {
                    View findViewById = childAt.findViewById(d.h.god_reply_multi_img);
                    findViewById.setTag(d.h.god_reply_image_layout, Integer.valueOf(i2));
                    findViewById.setOnClickListener(this);
                    if (i2 == 3) {
                        this.aoG = childAt.findViewById(d.h.god_reply_img_multi_layout);
                        this.aoE = (TextView) childAt.findViewById(d.h.god_reply_img_num);
                    } else {
                        this.aoH = childAt.findViewById(d.h.god_reply_img_multi_layout);
                        this.aoF = (TextView) childAt.findViewById(d.h.god_reply_img_num);
                    }
                }
                n(childAt, this.aoJ);
                i = i2 + 1;
            } else {
                this.aoC.setVisibility(8);
                return;
            }
        }
    }

    private void n(View view, int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            view.setLayoutParams(new LinearLayout.LayoutParams(0, i));
        } else if (layoutParams.height != i) {
            layoutParams.height = i;
            view.setLayoutParams(layoutParams);
        }
    }

    public void setFromCDN(boolean z) {
        this.ajf = z;
    }

    public void setData(PostData postData) {
        if (postData == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        a(postData, postData.giQ);
        b(postData);
        c(postData);
        setPraised(postData.bsB());
        aO(postData.bsB());
        if ((this.mImageList != null && this.mImageList.size() > 0) || (this.aoN != null && this.aoN.Jp() != null)) {
            a(postData, 2);
        } else {
            a(postData, 3);
        }
        if (!G(this.aoA) && !G(this.aoC) && !G(this.aoB)) {
            setVisibility(8);
        }
    }

    private boolean G(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void a(PostData postData, int i) {
        if (this.aoA == null || postData.aDg() == null) {
            this.aoA.setVisibility(8);
            return;
        }
        SpannableStringBuilder a = a(postData.aDg());
        if (a == null || am.isEmpty(a.toString())) {
            this.aoA.setVisibility(8);
            return;
        }
        this.aoA.setVisibility(0);
        this.aoA.setMaxLines(Integer.MAX_VALUE);
        this.aoA.setText(a, TextView.BufferType.SPANNABLE);
        if (i >= 3 && this.aoA.getLineCount() > i) {
            a = (SpannableStringBuilder) a.subSequence(0, this.aoA.getLayout().getLineEnd(i - 1) - 3);
            a.append("...");
        }
        this.aoA.setMaxLines(i);
        this.aoA.setText(a, TextView.BufferType.SPANNABLE);
    }

    private SpannableStringBuilder a(TbRichText tbRichText) {
        ArrayList<TbRichTextData> Iv = tbRichText.Iv();
        if (Iv == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = Iv.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.IC());
            } else if (next.getType() == 17) {
                String str = next.IG().mGifInfo.mSharpText;
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

    public void a(PostData postData, boolean z) {
        int i;
        if (this.mImageList == null) {
            this.mImageList = new ArrayList();
        } else {
            this.mImageList.clear();
        }
        if (!com.baidu.tbadk.core.h.oS().oY()) {
            this.aoC.setVisibility(8);
            return;
        }
        TbRichText aDg = postData.aDg();
        if (aDg == null || aDg.Iv() == null) {
            this.aoC.setVisibility(8);
            return;
        }
        Iterator<TbRichTextData> it = aDg.Iv().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                this.mImageList.add(next.IB());
            }
        }
        if (this.mImageList.size() == 0) {
            this.aoC.setVisibility(8);
            return;
        }
        int size = this.mImageList.size();
        int i2 = z ? 5 : 4;
        if (!z && this.aoC.getChildCount() == 5) {
            setViewGone(this.aoC.getChildAt(4));
        }
        this.aoC.setWeightSum(z ? 5.0f : 4.0f);
        this.aoC.setVisibility(0);
        a(postData);
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            View childAt = this.aoC.getChildAt(i4);
            if (childAt != null && ((childAt instanceof TbImageView) || ((childAt instanceof FrameLayout) && childAt.findViewById(d.h.god_reply_multi_img) != null && (childAt.findViewById(d.h.god_reply_multi_img) instanceof TbImageView)))) {
                if (i3 < this.mImageList.size()) {
                    TbRichTextImageInfo tbRichTextImageInfo = this.mImageList.get(i3);
                    if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.IQ())) {
                        if (childAt instanceof TbImageView) {
                            ((TbImageView) childAt).c(tbRichTextImageInfo.IQ(), this.ajf ? 13 : 14, false);
                        } else {
                            ((TbImageView) childAt.findViewById(d.h.god_reply_multi_img)).c(tbRichTextImageInfo.IQ(), this.ajf ? 13 : 14, false);
                        }
                        childAt.setVisibility(0);
                        i = i3 + 1;
                    } else {
                        setViewGone(childAt);
                        i = i3;
                    }
                    i3 = i;
                } else {
                    setViewGone(childAt);
                }
            }
            n(childAt, z ? this.aoJ : this.aoI);
        }
        if (z && size > 5) {
            this.aoH.setVisibility(0);
            this.aoF.setText("" + size);
            setViewGone(this.aoG);
        } else if (!z && size > 4) {
            this.aoG.setVisibility(0);
            this.aoE.setText("" + size);
        } else {
            setViewGone(this.aoG);
            setViewGone(this.aoH);
        }
    }

    private void setViewGone(View view) {
        if (view != null && view.getVisibility() != 8) {
            view.setVisibility(8);
        }
    }

    private void a(PostData postData) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aoC.getLayoutParams();
        int i = layoutParams.topMargin;
        if ((a(postData.aDg()) == null || am.isEmpty(a(postData.aDg()).toString())) && postData.ID() == null && G(this.aoC)) {
            if (i != this.aoL) {
                layoutParams.topMargin = this.aoL;
                this.aoC.setLayoutParams(layoutParams);
            }
        } else if (i != this.aoK) {
            layoutParams.topMargin = this.aoK;
            this.aoC.setLayoutParams(layoutParams);
        }
    }

    public void b(PostData postData) {
        this.aoN = postData.ID();
        if (this.aoN == null) {
            this.aoB.setVisibility(8);
            return;
        }
        this.aoB.setVisibility(0);
        this.aoB.setTag(this.aoN);
    }

    public void c(PostData postData) {
        if (this.anD != null && postData != null) {
            this.anD.setText(am.v(postData.bsA() >= 0 ? (int) postData.bsA() : 0L));
        }
    }

    private void aO(boolean z) {
        Drawable drawable;
        if (z) {
            drawable = aj.getDrawable(d.g.icon_floor_praised);
        } else {
            drawable = aj.getDrawable(d.g.icon_floor_praise_n);
        }
        this.anD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        this.anD.setGravity(16);
    }

    private void setPraised(boolean z) {
        this.aoM = z;
    }

    public void onChangeSkinType() {
        aj.k(this.mRootView, d.e.cp_bg_line_e);
        aj.k(this.aoA, d.e.cp_bg_line_e);
        aj.i(this.anD, d.e.cp_cont_f);
        aj.i(this.aoA, d.e.cp_cont_f);
        aj.c(this.aoD, d.g.icon_corner_shen);
        this.aoB.bhr();
        aO(this.aoM);
    }

    public TextView getGodReplyContent() {
        return this.aoA;
    }

    public TextView getPraiseNum() {
        return this.anD;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view instanceof TbImageView) && this.mImageList != null && this.mImageList.size() != 0 && view.getTag(d.h.god_reply_image_layout) != null && (view.getTag(d.h.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view.getTag(d.h.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.mImageList) {
                arrayList.add(tbRichTextImageInfo.IN());
            }
            ImageViewerConfig createConfig = new ImageViewerConfig(getContext()).createConfig(arrayList, intValue, null, "", "", true, arrayList.get(0), true);
            createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_DISCOVER_BEAUTY);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
        }
    }
}

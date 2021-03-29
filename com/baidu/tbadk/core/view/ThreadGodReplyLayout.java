package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import d.b.b.e.p.l;
import d.b.h0.b1.m.f;
import d.b.h0.r.k;
import d.b.h0.r.q.a2;
import d.b.i0.t3.i;
import d.b.i0.x.m;
import d.b.i0.x.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    public static final int B = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    public View.OnClickListener A;

    /* renamed from: e  reason: collision with root package name */
    public TextView f13519e;

    /* renamed from: f  reason: collision with root package name */
    public PlayVoiceBntNew f13520f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f13521g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13522h;
    public ClickableHeaderImageView i;
    public TextView j;
    public AgreeView k;
    public a2 l;
    public PostData m;
    public Context n;
    public View o;
    public RelativeLayout p;
    public List<TbRichTextImageInfo> q;
    public TbRichTextVoiceInfo r;
    public boolean s;
    public String t;
    public int u;
    public int v;
    public View.OnClickListener w;
    public int x;
    public final float y;
    public View.OnClickListener z;

    /* loaded from: classes3.dex */
    public class a extends f {
        public final /* synthetic */ SpannableStringBuilder l;

        /* renamed from: com.baidu.tbadk.core.view.ThreadGodReplyLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0176a implements Runnable {
            public RunnableC0176a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (ThreadGodReplyLayout.this.f13519e.getLineCount() >= 15) {
                    int lineEnd = ThreadGodReplyLayout.this.f13519e.getLayout().getLineEnd(14);
                    ThreadGodReplyLayout.this.f13519e.setText(((Object) ThreadGodReplyLayout.this.f13519e.getText().subSequence(0, lineEnd - 1)) + StringHelper.STRING_MORE);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, String str, SpannableStringBuilder spannableStringBuilder) {
            super(i, str);
            this.l = spannableStringBuilder;
        }

        @Override // d.b.h0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            t.b().a(new StatisticItem(TbadkCoreStatisticKey.GOD_REPLY_LAYOUT_FULL_TEXT_CLICK));
            ThreadGodReplyLayout.this.f13519e.setMaxLines(15);
            ThreadGodReplyLayout.this.f13519e.setEllipsize(TextUtils.TruncateAt.END);
            ThreadGodReplyLayout.this.f13519e.setText(this.l.toString());
            ThreadGodReplyLayout.this.f13519e.post(new RunnableC0176a());
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int width = ((ThreadGodReplyLayout.this.u - ThreadGodReplyLayout.this.f13522h.getWidth()) / 2) + l.g(ThreadGodReplyLayout.this.getContext(), R.dimen.tbds26);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ThreadGodReplyLayout.this.f13522h.getLayoutParams();
            layoutParams.setMargins(0, width, width, 0);
            ThreadGodReplyLayout.this.f13522h.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ThreadGodReplyLayout.this.m == null || ThreadGodReplyLayout.this.m.s() == null || StringUtils.isNull(ThreadGodReplyLayout.this.m.s().getName_show()) || StringUtils.isNull(ThreadGodReplyLayout.this.m.s().getUserId())) {
                return;
            }
            PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(ThreadGodReplyLayout.this.n, ThreadGodReplyLayout.this.m.s().getUserId(), ThreadGodReplyLayout.this.m.s().getName_show());
            personInfoActivityConfig.setSourceTid(ThreadGodReplyLayout.this.m.D());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            if (ThreadGodReplyLayout.this.w != null) {
                ThreadGodReplyLayout.this.w.onClick(view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ThreadGodReplyLayout.this.w != null) {
                ThreadGodReplyLayout.this.w.onClick(view);
            }
        }
    }

    public ThreadGodReplyLayout(Context context) {
        super(context);
        this.l = null;
        this.x = 3;
        this.y = l.q((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds70) * 2);
        this.z = new c();
        this.A = new d();
        j(context);
    }

    public TextView getGodReplyContent() {
        return this.f13519e;
    }

    public void h() {
        ClickableHeaderImageView clickableHeaderImageView = this.i;
        if (clickableHeaderImageView != null) {
            clickableHeaderImageView.setPlaceHolder(1);
        }
        int childCount = this.f13521g.getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f13521g.getChildAt(i);
            if (childAt instanceof TbImageView) {
                ((TbImageView) childAt).setPlaceHolder(2);
            }
        }
    }

    public final SpannableStringBuilder i(TbRichText tbRichText) {
        ArrayList<TbRichTextData> u;
        if (tbRichText == null || (u = tbRichText.u()) == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<TbRichTextData> it = u.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                spannableStringBuilder.append((CharSequence) next.A());
            } else if (next.getType() == 17) {
                String str = next.u().mGifInfo.mSharpText;
                if (str != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                    spannableStringBuilder.append((CharSequence) "[表情]");
                }
            } else if (next.getType() == 20) {
                spannableStringBuilder.append((CharSequence) "[表情]");
            }
        }
        if (spannableStringBuilder.length() > 0) {
            for (f fVar : (f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length() - 1, f.class)) {
                spannableStringBuilder.removeSpan(fVar);
            }
            for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length() - 1, ForegroundColorSpan.class)) {
                spannableStringBuilder.removeSpan(foregroundColorSpan);
            }
        }
        return spannableStringBuilder;
    }

    public final void j(Context context) {
        this.n = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
        this.o = inflate;
        this.p = (RelativeLayout) inflate.findViewById(R.id.god_comment_layout);
        ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) this.o.findViewById(R.id.god_reply_user_pendant_header);
        this.i = clickableHeaderImageView;
        clickableHeaderImageView.setIsRound(true);
        this.i.setClickable(true);
        TextView textView = (TextView) this.o.findViewById(R.id.god_reply_username_text);
        this.j = textView;
        textView.setOnClickListener(this.z);
        AgreeView agreeView = (AgreeView) this.o.findViewById(R.id.god_reply_agree_view);
        this.k = agreeView;
        agreeView.setAfterClickListener(this.A);
        this.k.setAgreeAlone(true);
        this.f13519e = (TextView) this.o.findViewById(R.id.god_reply_content);
        PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) this.o.findViewById(R.id.god_reply_voice_btn);
        this.f13520f = playVoiceBntNew;
        playVoiceBntNew.setVisibility(8);
        this.f13521g = (FrameLayout) this.o.findViewById(R.id.god_reply_image_layout);
        int k = l.k(getContext());
        this.v = l.g(getContext(), R.dimen.tbds10);
        this.u = (((k - (l.g(getContext(), R.dimen.tbds44) * 2)) - (l.g(getContext(), R.dimen.tbds26) * 2)) - (this.v * 4)) / 5;
        for (int i = 0; i < 5; i++) {
            TbImageView tbImageView = new TbImageView(getContext());
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            int i2 = this.u;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i2);
            layoutParams.leftMargin = (this.u + this.v) * i;
            this.f13521g.addView(tbImageView, layoutParams);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setTag(R.id.god_reply_image_layout, Integer.valueOf(i));
            tbImageView.setTagTextSize((int) getResources().getDimension(R.dimen.tbfontsize26));
            tbImageView.setTagPaddingDis(l.g(getContext(), R.dimen.tbds6), l.g(getContext(), R.dimen.tbds6));
            tbImageView.setOnClickListener(this);
            tbImageView.setPlaceHolder(2);
        }
        this.f13521g.setVisibility(8);
        this.f13522h = (TextView) this.o.findViewById(R.id.god_reply_img_num);
    }

    public final boolean k(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public void l() {
        if (this.x != TbadkCoreApplication.getInst().getSkinType()) {
            this.x = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105);
            d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.p);
            a2.h(R.string.J_X05);
            a2.c(R.color.CAM_X0206);
            m();
            h();
            this.k.t(TbadkCoreApplication.getInst().getSkinType());
            this.f13520f.d();
        }
    }

    public final void m() {
        a2 a2Var = this.l;
        m.l(this.f13519e, a2Var == null ? null : a2Var.w1(), R.color.CAM_X0105, R.color.CAM_X0109);
    }

    public final void n(SpannableStringBuilder spannableStringBuilder) {
        if (spannableStringBuilder != null && !TextUtils.isEmpty(spannableStringBuilder.toString())) {
            this.f13519e.setVisibility(0);
            if (!d.b.b.e.p.t.b(this.y, this.f13519e.getPaint(), spannableStringBuilder.toString(), 5)) {
                this.f13519e.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            } else {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
                if (spannableStringBuilder3.length() < 3) {
                    return;
                }
                int i = 2;
                spannableStringBuilder3.setSpan(new a(2, null, spannableStringBuilder2), 3, spannableStringBuilder3.length(), 17);
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.f13519e.getPaint(), (int) this.y, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                float f2 = this.y;
                if (staticLayout.getLineCount() >= 5) {
                    spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                    f2 = this.y - staticLayout.getLineWidth(4);
                }
                CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                float measureText = this.f13519e.getPaint().measureText(spannableStringBuilder3.toString());
                while (measureText > this.f13519e.getPaint().measureText(subSequence.toString()) + f2) {
                    i++;
                    if (spannableStringBuilder.length() - i < 0) {
                        break;
                    }
                    subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                }
                if (spannableStringBuilder.length() - i > 0) {
                    spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                }
                this.f13519e.setText(spannableStringBuilder);
                this.f13519e.setOnTouchListener(new i(spannableStringBuilder));
                t.b().a(new StatisticItem(TbadkCoreStatisticKey.GOD_REPLY_LAYOUT_FULL_TEXT_SHOW));
            }
            m();
            return;
        }
        this.f13519e.setVisibility(8);
    }

    public void o(PostData postData) {
        List<TbRichTextImageInfo> list = this.q;
        if (list == null) {
            this.q = new ArrayList();
        } else {
            list.clear();
        }
        if (!k.c().g()) {
            this.f13521g.setVisibility(8);
            this.f13522h.setVisibility(8);
            return;
        }
        TbRichText J = postData.J();
        if (J != null && J.u() != null) {
            Iterator<TbRichTextData> it = J.u().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    int i = B;
                    next.I(i, i);
                    if (next.getType() == 8) {
                        this.q.add(next.x());
                    }
                }
            }
            if (this.q.size() == 0) {
                this.f13521g.setVisibility(8);
                this.f13522h.setVisibility(8);
                return;
            }
            this.f13521g.setVisibility(0);
            int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int i2 = 0;
            for (int i3 = 0; i3 < this.f13521g.getChildCount(); i3++) {
                View childAt = this.f13521g.getChildAt(i3);
                if (childAt != null && (childAt instanceof TbImageView)) {
                    TbImageView tbImageView = (TbImageView) childAt;
                    tbImageView.B();
                    tbImageView.setRadius(g2);
                    tbImageView.A(15);
                    if (i2 < this.q.size()) {
                        TbRichTextImageInfo tbRichTextImageInfo = this.q.get(i2);
                        if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.u())) {
                            tbImageView.W(tbRichTextImageInfo.u(), this.s ? 13 : 14, false);
                            tbImageView.setVisibility(0);
                            i2++;
                        } else {
                            tbImageView.setVisibility(8);
                        }
                    } else {
                        tbImageView.setVisibility(8);
                    }
                }
            }
            if (this.q.size() > 5) {
                ImageView imageView = new ImageView(getContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                int i4 = this.u;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i4);
                layoutParams.leftMargin = (this.u + this.v) * 4;
                this.f13521g.addView(imageView, -1, layoutParams);
                imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
                this.f13522h.setVisibility(0);
                this.f13522h.setText("+" + (this.q.size() - 5));
                this.f13522h.post(new b());
                return;
            }
            this.f13522h.setVisibility(8);
            return;
        }
        this.f13521g.setVisibility(8);
        this.f13522h.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List<TbRichTextImageInfo> list;
        String str;
        if (!(view instanceof TbImageView) || (list = this.q) == null || list.size() == 0 || view.getTag(R.id.god_reply_image_layout) == null || !(view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            return;
        }
        int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
        ArrayList<String> arrayList = new ArrayList<>();
        for (TbRichTextImageInfo tbRichTextImageInfo : this.q) {
            arrayList.add(tbRichTextImageInfo.s());
        }
        a2 a2Var = this.l;
        String str2 = "";
        if (a2Var != null) {
            str2 = a2Var.i0();
            str = this.l.w1();
        } else {
            str = "";
        }
        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
        bVar.x(arrayList);
        bVar.B(intValue);
        bVar.z(str2);
        bVar.P(str);
        bVar.C(true);
        bVar.K(arrayList.get(0));
        bVar.G(true);
        bVar.O(this.l);
        bVar.J(false);
        ImageViewerConfig v = bVar.v(getContext());
        v.getIntent().putExtra("from", this.t);
        v.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
        View.OnClickListener onClickListener = this.w;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void p(PostData postData) {
        if (postData == null) {
            return;
        }
        this.i.setData(postData.s());
        String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(postData.s().getName_show(), 14, StringHelper.STRING_MORE);
        TextView textView = this.j;
        textView.setText(cutChineseAndEnglishWithSuffix + "：");
        if (this.l != null) {
            postData.q().threadId = this.l.w1();
        }
        postData.q().threadId = String.valueOf(postData.P());
        postData.q().objType = 3;
        this.k.setData(postData.q());
    }

    public void q(PostData postData) {
        TbRichTextVoiceInfo U = postData.U();
        this.r = U;
        if (U == null) {
            this.f13520f.setVisibility(8);
            return;
        }
        this.f13520f.setVisibility(0);
        this.f13520f.setTag(this.r);
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.w = onClickListener;
    }

    public void setData(a2 a2Var) {
        this.l = a2Var;
        setData(a2Var != null ? a2Var.z1() : null);
    }

    public void setFrom(String str) {
        this.t = str;
    }

    public void setFromCDN(boolean z) {
        this.s = z;
    }

    public void setData(PostData postData) {
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        if (postData != null && postData.s() != null && postData.s().getUserId() != null) {
            this.m = postData;
            setVisibility(0);
            p(postData);
            n(i(postData.J()));
            o(postData);
            q(postData);
            List<TbRichTextImageInfo> list = this.q;
            if ((list != null && list.size() > 0) || ((tbRichTextVoiceInfo = this.r) != null && tbRichTextVoiceInfo.u() != null)) {
                this.p.setPadding(0, 0, 0, l.g(getContext(), R.dimen.M_H_X003));
            } else {
                this.p.setPadding(0, 0, 0, l.g(getContext(), R.dimen.tbds0));
            }
            if (k(this.f13519e) || k(this.f13521g) || k(this.f13520f)) {
                return;
            }
            setVisibility(8);
            return;
        }
        setVisibility(8);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = null;
        this.x = 3;
        this.y = l.q((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds70) * 2);
        this.z = new c();
        this.A = new d();
        j(context);
    }

    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = null;
        this.x = 3;
        this.y = l.q((Activity) getContext()).widthPixels - (l.g(getContext(), R.dimen.tbds70) * 2);
        this.z = new c();
        this.A = new d();
        j(context);
    }
}

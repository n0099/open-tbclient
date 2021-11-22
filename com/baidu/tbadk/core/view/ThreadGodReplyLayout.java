package com.baidu.tbadk.core.view;

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
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
import b.a.e.f.p.t;
import b.a.q0.e1.n.f;
import b.a.q0.s.k;
import b.a.q0.s.q.d2;
import b.a.r0.b0.m;
import b.a.r0.b0.v;
import b.a.r0.d4.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int B;
    public static final int MAX_USERNAME_LENGTH = 14;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;

    /* renamed from: e  reason: collision with root package name */
    public TextView f46280e;

    /* renamed from: f  reason: collision with root package name */
    public PlayVoiceBntNew f46281f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f46282g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46283h;

    /* renamed from: i  reason: collision with root package name */
    public ClickableHeaderImageView f46284i;
    public TextView j;
    public AgreeView k;
    public d2 l;
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

    /* loaded from: classes8.dex */
    public class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpannableStringBuilder l;
        public final /* synthetic */ ThreadGodReplyLayout m;

        /* renamed from: com.baidu.tbadk.core.view.ThreadGodReplyLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1742a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f46285e;

            public RunnableC1742a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46285e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f46285e.m.f46280e.getLineCount() < 15) {
                    return;
                }
                int lineEnd = this.f46285e.m.f46280e.getLayout().getLineEnd(14);
                this.f46285e.m.f46280e.setText(((Object) this.f46285e.m.f46280e.getText().subSequence(0, lineEnd - 1)) + "...");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ThreadGodReplyLayout threadGodReplyLayout, int i2, String str, SpannableStringBuilder spannableStringBuilder) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadGodReplyLayout, Integer.valueOf(i2), str, spannableStringBuilder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = threadGodReplyLayout;
            this.l = spannableStringBuilder;
        }

        @Override // b.a.q0.e1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                v.b().a(new StatisticItem(TbadkCoreStatisticKey.GOD_REPLY_LAYOUT_FULL_TEXT_CLICK));
                this.m.f46280e.setMaxLines(15);
                this.m.f46280e.setEllipsize(TextUtils.TruncateAt.END);
                this.m.f46280e.setText(this.l.toString());
                this.m.f46280e.post(new RunnableC1742a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadGodReplyLayout f46286e;

        public b(ThreadGodReplyLayout threadGodReplyLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadGodReplyLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46286e = threadGodReplyLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int width = ((this.f46286e.u - this.f46286e.f46283h.getWidth()) / 2) + l.g(this.f46286e.getContext(), R.dimen.tbds26);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f46286e.f46283h.getLayoutParams();
                layoutParams.setMargins(0, width, width, 0);
                this.f46286e.f46283h.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadGodReplyLayout f46287e;

        public c(ThreadGodReplyLayout threadGodReplyLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadGodReplyLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46287e = threadGodReplyLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f46287e.m == null || this.f46287e.m.t() == null || StringUtils.isNull(this.f46287e.m.t().getName_show()) || StringUtils.isNull(this.f46287e.m.t().getUserId())) {
                return;
            }
            PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.f46287e.n, this.f46287e.m.t().getUserId(), this.f46287e.m.t().getName_show());
            personInfoActivityConfig.setSourceTid(this.f46287e.m.G());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            if (this.f46287e.w != null) {
                this.f46287e.w.onClick(view);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadGodReplyLayout f46288e;

        public d(ThreadGodReplyLayout threadGodReplyLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadGodReplyLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46288e = threadGodReplyLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f46288e.w == null) {
                return;
            }
            this.f46288e.w.onClick(view);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1450808644, "Lcom/baidu/tbadk/core/view/ThreadGodReplyLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1450808644, "Lcom/baidu/tbadk/core/view/ThreadGodReplyLayout;");
                return;
            }
        }
        B = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadGodReplyLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = null;
        this.x = 3;
        this.y = l.k(getContext()) - (l.g(getContext(), R.dimen.tbds70) * 2);
        this.z = new c(this);
        this.A = new d(this);
        h(context);
    }

    public void changeBgIceCreamColor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ClickableHeaderImageView clickableHeaderImageView = this.f46284i;
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setPlaceHolder(1);
            }
            int childCount = this.f46282g.getChildCount();
            if (childCount <= 0) {
                return;
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f46282g.getChildAt(i2);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public final SpannableStringBuilder g(TbRichText tbRichText) {
        InterceptResult invokeL;
        ArrayList<TbRichTextData> y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbRichText)) == null) {
            if (tbRichText == null || (y = tbRichText.y()) == null) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            Iterator<TbRichTextData> it = y.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 1) {
                    spannableStringBuilder.append((CharSequence) next.G());
                } else if (next.getType() == 17) {
                    String str = next.z().mGifInfo.mSharpText;
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
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public TextView getGodReplyContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f46280e : (TextView) invokeV.objValue;
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.n = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
            this.o = inflate;
            this.p = (RelativeLayout) inflate.findViewById(R.id.god_comment_layout);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) this.o.findViewById(R.id.god_reply_user_pendant_header);
            this.f46284i = clickableHeaderImageView;
            clickableHeaderImageView.setIsRound(true);
            this.f46284i.setClickable(true);
            TextView textView = (TextView) this.o.findViewById(R.id.god_reply_username_text);
            this.j = textView;
            textView.setOnClickListener(this.z);
            AgreeView agreeView = (AgreeView) this.o.findViewById(R.id.god_reply_agree_view);
            this.k = agreeView;
            agreeView.setAfterClickListener(this.A);
            this.k.setAgreeAlone(true);
            this.f46280e = (TextView) this.o.findViewById(R.id.god_reply_content);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) this.o.findViewById(R.id.god_reply_voice_btn);
            this.f46281f = playVoiceBntNew;
            playVoiceBntNew.setVisibility(8);
            this.f46282g = (FrameLayout) this.o.findViewById(R.id.god_reply_image_layout);
            int k = l.k(getContext());
            this.v = l.g(getContext(), R.dimen.tbds10);
            this.u = (((k - (l.g(getContext(), R.dimen.tbds44) * 2)) - (l.g(getContext(), R.dimen.tbds26) * 2)) - (this.v * 4)) / 5;
            for (int i2 = 0; i2 < 5; i2++) {
                TbImageView tbImageView = new TbImageView(getContext());
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                int i3 = this.u;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i3);
                layoutParams.leftMargin = (this.u + this.v) * i2;
                this.f46282g.addView(tbImageView, layoutParams);
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                tbImageView.setBorderSurroundContent(true);
                tbImageView.setDrawBorder(true);
                tbImageView.setTag(R.id.god_reply_image_layout, Integer.valueOf(i2));
                tbImageView.setTagTextSize((int) getResources().getDimension(R.dimen.tbfontsize26));
                tbImageView.setTagPaddingDis(l.g(getContext(), R.dimen.tbds6), l.g(getContext(), R.dimen.tbds6));
                tbImageView.setOnClickListener(this);
                tbImageView.setPlaceHolder(2);
            }
            this.f46282g.setVisibility(8);
            this.f46283h = (TextView) this.o.findViewById(R.id.god_reply_img_num);
        }
    }

    public final boolean i(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) ? view != null && view.getVisibility() == 0 : invokeL.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d2 d2Var = this.l;
            m.l(this.f46280e, d2Var == null ? null : d2Var.t1(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    public final void k(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, spannableStringBuilder) == null) {
            if (spannableStringBuilder != null && !TextUtils.isEmpty(spannableStringBuilder.toString())) {
                this.f46280e.setVisibility(0);
                if (!t.b(this.y, this.f46280e.getPaint(), spannableStringBuilder.toString(), 5)) {
                    this.f46280e.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                } else {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
                    if (spannableStringBuilder3.length() < 3) {
                        return;
                    }
                    int i2 = 2;
                    spannableStringBuilder3.setSpan(new a(this, 2, null, spannableStringBuilder2), 3, spannableStringBuilder3.length(), 17);
                    StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.f46280e.getPaint(), (int) this.y, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                    float f2 = this.y;
                    if (staticLayout.getLineCount() >= 5) {
                        spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                        f2 = this.y - staticLayout.getLineWidth(4);
                    }
                    CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                    float measureText = this.f46280e.getPaint().measureText(spannableStringBuilder3.toString());
                    while (measureText > this.f46280e.getPaint().measureText(subSequence.toString()) + f2) {
                        i2++;
                        if (spannableStringBuilder.length() - i2 < 0) {
                            break;
                        }
                        subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i2, spannableStringBuilder.length());
                    }
                    if (spannableStringBuilder.length() - i2 > 0) {
                        spannableStringBuilder.replace(spannableStringBuilder.length() - i2, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                    }
                    this.f46280e.setText(spannableStringBuilder);
                    this.f46280e.setOnTouchListener(new h(spannableStringBuilder));
                    v.b().a(new StatisticItem(TbadkCoreStatisticKey.GOD_REPLY_LAYOUT_FULL_TEXT_SHOW));
                }
                j();
                return;
            }
            this.f46280e.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.x == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.x = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0105);
        b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.p);
        d2.n(R.string.J_X05);
        d2.f(R.color.CAM_X0206);
        j();
        changeBgIceCreamColor();
        this.k.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.f46281f.changeSkin();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List<TbRichTextImageInfo> list;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) || !(view instanceof TbImageView) || (list = this.q) == null || list.size() == 0 || view.getTag(R.id.god_reply_image_layout) == null || !(view.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            return;
        }
        int intValue = ((Integer) view.getTag(R.id.god_reply_image_layout)).intValue();
        ArrayList<String> arrayList = new ArrayList<>();
        for (TbRichTextImageInfo tbRichTextImageInfo : this.q) {
            arrayList.add(tbRichTextImageInfo.w());
        }
        d2 d2Var = this.l;
        String str2 = "";
        if (d2Var != null) {
            str2 = d2Var.Z();
            str = this.l.t1();
        } else {
            str = "";
        }
        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
        bVar.x(arrayList);
        bVar.B(intValue);
        bVar.z(str2);
        bVar.O(str);
        bVar.C(true);
        bVar.J(arrayList.get(0));
        bVar.F(true);
        bVar.N(this.l);
        bVar.I(false);
        ImageViewerConfig v = bVar.v(getContext());
        v.getIntent().putExtra("from", this.t);
        v.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
        View.OnClickListener onClickListener = this.w;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.w = onClickListener;
        }
    }

    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, d2Var) == null) {
            this.l = d2Var;
            setData(d2Var != null ? d2Var.w1() : null);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.t = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.s = z;
        }
    }

    public void updateGodReplyImages(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, postData) == null) {
            List<TbRichTextImageInfo> list = this.q;
            if (list == null) {
                this.q = new ArrayList();
            } else {
                list.clear();
            }
            if (!k.c().g()) {
                this.f46282g.setVisibility(8);
                this.f46283h.setVisibility(8);
                return;
            }
            TbRichText M = postData.M();
            if (M != null && M.y() != null) {
                Iterator<TbRichTextData> it = M.y().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        int i2 = B;
                        next.Q(i2, i2);
                        if (next.getType() == 8) {
                            this.q.add(next.C());
                        }
                    }
                }
                if (this.q.size() == 0) {
                    this.f46282g.setVisibility(8);
                    this.f46283h.setVisibility(8);
                    return;
                }
                this.f46282g.setVisibility(0);
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int i3 = 0;
                for (int i4 = 0; i4 < this.f46282g.getChildCount(); i4++) {
                    View childAt = this.f46282g.getChildAt(i4);
                    if (childAt != null && (childAt instanceof TbImageView)) {
                        TbImageView tbImageView = (TbImageView) childAt;
                        tbImageView.clearCornerFlag();
                        tbImageView.setRadius(g2);
                        tbImageView.addCornerFlags(15);
                        if (i3 < this.q.size()) {
                            TbRichTextImageInfo tbRichTextImageInfo = this.q.get(i3);
                            if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.y())) {
                                tbImageView.startLoad(tbRichTextImageInfo.y(), this.s ? 13 : 14, false);
                                tbImageView.setVisibility(0);
                                i3++;
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
                    int i5 = this.u;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i5, i5);
                    layoutParams.leftMargin = (this.u + this.v) * 4;
                    this.f46282g.addView(imageView, -1, layoutParams);
                    imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
                    this.f46283h.setVisibility(0);
                    this.f46283h.setText(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + (this.q.size() - 5));
                    this.f46283h.post(new b(this));
                    return;
                }
                this.f46283h.setVisibility(8);
                return;
            }
            this.f46282g.setVisibility(8);
            this.f46283h.setVisibility(8);
        }
    }

    public void updateGodReplyTopInfo(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, postData) == null) || postData == null) {
            return;
        }
        this.f46284i.setData(postData.t());
        String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(postData.t().getName_show(), 14, "...");
        TextView textView = this.j;
        textView.setText(cutChineseAndEnglishWithSuffix + "：");
        if (this.l != null) {
            postData.q().threadId = this.l.t1();
        }
        postData.q().threadId = String.valueOf(postData.T());
        postData.q().objType = 3;
        this.k.setData(postData.q());
    }

    public void updateGodReplyVoice(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, postData) == null) {
            TbRichTextVoiceInfo Y = postData.Y();
            this.r = Y;
            if (Y == null) {
                this.f46281f.setVisibility(8);
                return;
            }
            this.f46281f.setVisibility(0);
            this.f46281f.setTag(this.r);
        }
    }

    public void setData(PostData postData) {
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, postData) == null) {
            if (postData != null && postData.t() != null && postData.t().getUserId() != null) {
                this.m = postData;
                setVisibility(0);
                updateGodReplyTopInfo(postData);
                k(g(postData.M()));
                updateGodReplyImages(postData);
                updateGodReplyVoice(postData);
                List<TbRichTextImageInfo> list = this.q;
                if ((list != null && list.size() > 0) || ((tbRichTextVoiceInfo = this.r) != null && tbRichTextVoiceInfo.y() != null)) {
                    this.p.setPadding(0, 0, 0, l.g(getContext(), R.dimen.M_H_X003));
                } else {
                    this.p.setPadding(0, 0, 0, l.g(getContext(), R.dimen.tbds0));
                }
                if (i(this.f46280e) || i(this.f46282g) || i(this.f46281f)) {
                    return;
                }
                setVisibility(8);
                return;
            }
            setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.l = null;
        this.x = 3;
        this.y = l.k(getContext()) - (l.g(getContext(), R.dimen.tbds70) * 2);
        this.z = new c(this);
        this.A = new d(this);
        h(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.l = null;
        this.x = 3;
        this.y = l.k(getContext()) - (l.g(getContext(), R.dimen.tbds70) * 2);
        this.z = new c(this);
        this.A = new d(this);
        h(context);
    }
}

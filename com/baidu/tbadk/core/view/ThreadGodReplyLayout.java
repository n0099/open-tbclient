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
import c.a.d.f.p.n;
import c.a.d.f.p.w;
import c.a.t0.f1.n.f;
import c.a.t0.s.l;
import c.a.t0.s.r.e2;
import c.a.u0.g0.m;
import c.a.u0.g0.u;
import c.a.u0.q4.h;
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
/* loaded from: classes11.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int B;
    public static final int MAX_USERNAME_LENGTH = 14;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;

    /* renamed from: e  reason: collision with root package name */
    public TextView f40774e;

    /* renamed from: f  reason: collision with root package name */
    public PlayVoiceBntNew f40775f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f40776g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f40777h;

    /* renamed from: i  reason: collision with root package name */
    public ClickableHeaderImageView f40778i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f40779j;
    public AgreeView k;
    public e2 l;
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

    /* loaded from: classes11.dex */
    public class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpannableStringBuilder l;
        public final /* synthetic */ ThreadGodReplyLayout m;

        /* renamed from: com.baidu.tbadk.core.view.ThreadGodReplyLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class RunnableC1910a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f40780e;

            public RunnableC1910a(a aVar) {
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
                this.f40780e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f40780e.m.f40774e.getLineCount() < 15) {
                    return;
                }
                int lineEnd = this.f40780e.m.f40774e.getLayout().getLineEnd(14);
                this.f40780e.m.f40774e.setText(((Object) this.f40780e.m.f40774e.getText().subSequence(0, lineEnd - 1)) + "...");
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

        @Override // c.a.t0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                u.b().a(new StatisticItem(TbadkCoreStatisticKey.GOD_REPLY_LAYOUT_FULL_TEXT_CLICK));
                this.m.f40774e.setMaxLines(15);
                this.m.f40774e.setEllipsize(TextUtils.TruncateAt.END);
                this.m.f40774e.setText(this.l.toString());
                this.m.f40774e.post(new RunnableC1910a(this));
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadGodReplyLayout f40781e;

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
            this.f40781e = threadGodReplyLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int width = ((this.f40781e.u - this.f40781e.f40777h.getWidth()) / 2) + n.f(this.f40781e.getContext(), R.dimen.tbds26);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f40781e.f40777h.getLayoutParams();
                layoutParams.setMargins(0, width, width, 0);
                this.f40781e.f40777h.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadGodReplyLayout f40782e;

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
            this.f40782e = threadGodReplyLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f40782e.m == null || this.f40782e.m.t() == null || StringUtils.isNull(this.f40782e.m.t().getName_show()) || StringUtils.isNull(this.f40782e.m.t().getUserId())) {
                return;
            }
            PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.f40782e.n, this.f40782e.m.t().getUserId(), this.f40782e.m.t().getName_show());
            personInfoActivityConfig.setSourceTid(this.f40782e.m.G());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            if (this.f40782e.w != null) {
                this.f40782e.w.onClick(view);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThreadGodReplyLayout f40783e;

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
            this.f40783e = threadGodReplyLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f40783e.w == null) {
                return;
            }
            this.f40783e.w.onClick(view);
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
        B = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds42);
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
        this.y = n.k(getContext()) - (n.f(getContext(), R.dimen.tbds70) * 2);
        this.z = new c(this);
        this.A = new d(this);
        h(context);
    }

    public void changeBgIceCreamColor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ClickableHeaderImageView clickableHeaderImageView = this.f40778i;
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setPlaceHolder(1);
            }
            int childCount = this.f40776g.getChildCount();
            if (childCount <= 0) {
                return;
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f40776g.getChildAt(i2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40774e : (TextView) invokeV.objValue;
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.n = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
            this.o = inflate;
            this.p = (RelativeLayout) inflate.findViewById(R.id.god_comment_layout);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) this.o.findViewById(R.id.god_reply_user_pendant_header);
            this.f40778i = clickableHeaderImageView;
            clickableHeaderImageView.setIsRound(true);
            this.f40778i.setClickable(true);
            TextView textView = (TextView) this.o.findViewById(R.id.god_reply_username_text);
            this.f40779j = textView;
            textView.setOnClickListener(this.z);
            AgreeView agreeView = (AgreeView) this.o.findViewById(R.id.god_reply_agree_view);
            this.k = agreeView;
            agreeView.setAfterClickListener(this.A);
            this.k.setAgreeAlone(true);
            this.f40774e = (TextView) this.o.findViewById(R.id.god_reply_content);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) this.o.findViewById(R.id.god_reply_voice_btn);
            this.f40775f = playVoiceBntNew;
            playVoiceBntNew.setVisibility(8);
            this.f40776g = (FrameLayout) this.o.findViewById(R.id.god_reply_image_layout);
            int k = n.k(getContext());
            this.v = n.f(getContext(), R.dimen.tbds10);
            this.u = (((k - (n.f(getContext(), R.dimen.tbds44) * 2)) - (n.f(getContext(), R.dimen.tbds26) * 2)) - (this.v * 4)) / 5;
            for (int i2 = 0; i2 < 5; i2++) {
                TbImageView tbImageView = new TbImageView(getContext());
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                int i3 = this.u;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i3);
                layoutParams.leftMargin = (this.u + this.v) * i2;
                this.f40776g.addView(tbImageView, layoutParams);
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                tbImageView.setBorderSurroundContent(true);
                tbImageView.setDrawBorder(true);
                tbImageView.setTag(R.id.god_reply_image_layout, Integer.valueOf(i2));
                tbImageView.setTagTextSize((int) getResources().getDimension(R.dimen.tbfontsize26));
                tbImageView.setTagPaddingDis(n.f(getContext(), R.dimen.tbds6), n.f(getContext(), R.dimen.tbds6));
                tbImageView.setOnClickListener(this);
                tbImageView.setPlaceHolder(2);
            }
            this.f40776g.setVisibility(8);
            this.f40777h = (TextView) this.o.findViewById(R.id.god_reply_img_num);
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
            e2 e2Var = this.l;
            m.l(this.f40774e, e2Var == null ? null : e2Var.w1(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    public final void k(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, spannableStringBuilder) == null) {
            if (spannableStringBuilder != null && !TextUtils.isEmpty(spannableStringBuilder.toString())) {
                this.f40774e.setVisibility(0);
                if (!w.b(this.y, this.f40774e.getPaint(), spannableStringBuilder.toString(), 5)) {
                    this.f40774e.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                } else {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
                    if (spannableStringBuilder3.length() < 3) {
                        return;
                    }
                    int i2 = 2;
                    spannableStringBuilder3.setSpan(new a(this, 2, null, spannableStringBuilder2), 3, spannableStringBuilder3.length(), 17);
                    StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.f40774e.getPaint(), (int) this.y, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                    float f2 = this.y;
                    if (staticLayout.getLineCount() >= 5) {
                        spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                        f2 = this.y - staticLayout.getLineWidth(4);
                    }
                    CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                    float measureText = this.f40774e.getPaint().measureText(spannableStringBuilder3.toString());
                    while (measureText > this.f40774e.getPaint().measureText(subSequence.toString()) + f2) {
                        i2++;
                        if (spannableStringBuilder.length() - i2 < 0) {
                            break;
                        }
                        subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i2, spannableStringBuilder.length());
                    }
                    if (spannableStringBuilder.length() - i2 > 0) {
                        spannableStringBuilder.replace(spannableStringBuilder.length() - i2, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                    }
                    this.f40774e.setText(spannableStringBuilder);
                    this.f40774e.setOnTouchListener(new h(spannableStringBuilder));
                    u.b().a(new StatisticItem(TbadkCoreStatisticKey.GOD_REPLY_LAYOUT_FULL_TEXT_SHOW));
                }
                j();
                return;
            }
            this.f40774e.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.x == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.x = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setViewTextColor(this.f40779j, R.color.CAM_X0105);
        c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(this.p);
        d2.n(R.string.J_X05);
        d2.f(R.color.CAM_X0206);
        j();
        changeBgIceCreamColor();
        this.k.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.f40775f.changeSkin();
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
        e2 e2Var = this.l;
        String str2 = "";
        if (e2Var != null) {
            str2 = e2Var.b0();
            str = this.l.w1();
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

    public void setData(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, e2Var) == null) {
            this.l = e2Var;
            setData(e2Var != null ? e2Var.z1() : null);
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
            if (!l.c().g()) {
                this.f40776g.setVisibility(8);
                this.f40777h.setVisibility(8);
                return;
            }
            TbRichText N = postData.N();
            if (N != null && N.y() != null) {
                Iterator<TbRichTextData> it = N.y().iterator();
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
                    this.f40776g.setVisibility(8);
                    this.f40777h.setVisibility(8);
                    return;
                }
                this.f40776g.setVisibility(0);
                int f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int i3 = 0;
                for (int i4 = 0; i4 < this.f40776g.getChildCount(); i4++) {
                    View childAt = this.f40776g.getChildAt(i4);
                    if (childAt != null && (childAt instanceof TbImageView)) {
                        TbImageView tbImageView = (TbImageView) childAt;
                        tbImageView.clearCornerFlag();
                        tbImageView.setRadius(f2);
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
                    this.f40776g.addView(imageView, -1, layoutParams);
                    imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
                    this.f40777h.setVisibility(0);
                    this.f40777h.setText(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + (this.q.size() - 5));
                    this.f40777h.post(new b(this));
                    return;
                }
                this.f40777h.setVisibility(8);
                return;
            }
            this.f40776g.setVisibility(8);
            this.f40777h.setVisibility(8);
        }
    }

    public void updateGodReplyTopInfo(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, postData) == null) || postData == null) {
            return;
        }
        this.f40778i.setData(postData.t());
        String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(postData.t().getName_show(), 14, "...");
        TextView textView = this.f40779j;
        textView.setText(cutChineseAndEnglishWithSuffix + "：");
        if (this.l != null) {
            postData.q().threadId = this.l.w1();
        }
        postData.q().threadId = String.valueOf(postData.U());
        postData.q().objType = 3;
        this.k.setData(postData.q());
    }

    public void updateGodReplyVoice(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, postData) == null) {
            TbRichTextVoiceInfo Z = postData.Z();
            this.r = Z;
            if (Z == null) {
                this.f40775f.setVisibility(8);
                return;
            }
            this.f40775f.setVisibility(0);
            this.f40775f.setTag(this.r);
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
                k(g(postData.N()));
                updateGodReplyImages(postData);
                updateGodReplyVoice(postData);
                List<TbRichTextImageInfo> list = this.q;
                if ((list != null && list.size() > 0) || ((tbRichTextVoiceInfo = this.r) != null && tbRichTextVoiceInfo.y() != null)) {
                    this.p.setPadding(0, 0, 0, n.f(getContext(), R.dimen.M_H_X003));
                } else {
                    this.p.setPadding(0, 0, 0, n.f(getContext(), R.dimen.tbds0));
                }
                if (i(this.f40774e) || i(this.f40776g) || i(this.f40775f)) {
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
        this.y = n.k(getContext()) - (n.f(getContext(), R.dimen.tbds70) * 2);
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
        this.y = n.k(getContext()) - (n.f(getContext(), R.dimen.tbds70) * 2);
        this.z = new c(this);
        this.A = new d(this);
        h(context);
    }
}

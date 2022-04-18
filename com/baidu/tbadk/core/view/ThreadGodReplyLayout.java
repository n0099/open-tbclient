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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ThreadData;
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
import com.repackage.bn4;
import com.repackage.ex5;
import com.repackage.ff5;
import com.repackage.mx5;
import com.repackage.oi;
import com.repackage.vr4;
import com.repackage.xi;
import com.repackage.xw8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int x;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public PlayVoiceBntNew b;
    public FrameLayout c;
    public TextView d;
    public ClickableHeaderImageView e;
    public TextView f;
    public AgreeView g;
    public ThreadData h;
    public PostData i;
    public Context j;
    public View k;
    public RelativeLayout l;
    public List<TbRichTextImageInfo> m;
    public TbRichTextVoiceInfo n;
    public boolean o;
    public String p;
    public int q;
    public int r;
    public View.OnClickListener s;
    public int t;
    public final float u;
    public View.OnClickListener v;
    public View.OnClickListener w;

    /* loaded from: classes3.dex */
    public class a extends ff5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpannableStringBuilder h;
        public final /* synthetic */ ThreadGodReplyLayout i;

        /* renamed from: com.baidu.tbadk.core.view.ThreadGodReplyLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0170a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0170a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.i.a.getLineCount() < 15) {
                    return;
                }
                int lineEnd = this.a.i.a.getLayout().getLineEnd(14);
                this.a.i.a.setText(((Object) this.a.i.a.getText().subSequence(0, lineEnd - 1)) + StringHelper.STRING_MORE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ThreadGodReplyLayout threadGodReplyLayout, int i, String str, SpannableStringBuilder spannableStringBuilder) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadGodReplyLayout, Integer.valueOf(i), str, spannableStringBuilder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = threadGodReplyLayout;
            this.h = spannableStringBuilder;
        }

        @Override // com.repackage.ff5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                mx5.b().a(new StatisticItem(TbadkCoreStatisticKey.GOD_REPLY_LAYOUT_FULL_TEXT_CLICK));
                this.i.a.setMaxLines(15);
                this.i.a.setEllipsize(TextUtils.TruncateAt.END);
                this.i.a.setText(this.h.toString());
                this.i.a.post(new RunnableC0170a(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadGodReplyLayout a;

        public b(ThreadGodReplyLayout threadGodReplyLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadGodReplyLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadGodReplyLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int width = ((this.a.q - this.a.d.getWidth()) / 2) + oi.f(this.a.getContext(), R.dimen.tbds26);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.d.getLayoutParams();
                layoutParams.setMargins(0, width, width, 0);
                this.a.d.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadGodReplyLayout a;

        public c(ThreadGodReplyLayout threadGodReplyLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadGodReplyLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadGodReplyLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.i == null || this.a.i.s() == null || StringUtils.isNull(this.a.i.s().getName_show()) || StringUtils.isNull(this.a.i.s().getUserId())) {
                return;
            }
            PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.a.j, this.a.i.s().getUserId(), this.a.i.s().getName_show());
            personInfoActivityConfig.setSourceTid(this.a.i.I());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
            if (this.a.s != null) {
                this.a.s.onClick(view2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThreadGodReplyLayout a;

        public d(ThreadGodReplyLayout threadGodReplyLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadGodReplyLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = threadGodReplyLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.s == null) {
                return;
            }
            this.a.s.onClick(view2);
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
        x = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds42);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = null;
        this.t = 3;
        this.u = oi.k(getContext()) - (oi.f(getContext(), R.dimen.tbds70) * 2);
        this.v = new c(this);
        this.w = new d(this);
        i(context);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ClickableHeaderImageView clickableHeaderImageView = this.e;
            if (clickableHeaderImageView != null) {
                clickableHeaderImageView.setPlaceHolder(1);
            }
            int childCount = this.c.getChildCount();
            if (childCount <= 0) {
                return;
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = this.c.getChildAt(i);
                if (childAt instanceof TbImageView) {
                    ((TbImageView) childAt).setPlaceHolder(2);
                }
            }
        }
    }

    public TextView getGodReplyContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (TextView) invokeV.objValue;
    }

    public final SpannableStringBuilder h(TbRichText tbRichText) {
        InterceptResult invokeL;
        ArrayList<TbRichTextData> A;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbRichText)) == null) {
            if (tbRichText == null || (A = tbRichText.A()) == null) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            Iterator<TbRichTextData> it = A.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 1) {
                    spannableStringBuilder.append((CharSequence) next.I());
                } else if (next.getType() == 17) {
                    String str = next.B().mGifInfo.mSharpText;
                    if (str != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                        spannableStringBuilder.append((CharSequence) "[表情]");
                    }
                } else if (next.getType() == 20) {
                    spannableStringBuilder.append((CharSequence) "[表情]");
                }
            }
            if (spannableStringBuilder.length() > 0) {
                for (ff5 ff5Var : (ff5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length() - 1, ff5.class)) {
                    spannableStringBuilder.removeSpan(ff5Var);
                }
                for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length() - 1, ForegroundColorSpan.class)) {
                    spannableStringBuilder.removeSpan(foregroundColorSpan);
                }
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.j = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d082b, (ViewGroup) this, true);
            this.k = inflate;
            this.l = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090cd1);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) this.k.findViewById(R.id.obfuscated_res_0x7f090cd9);
            this.e = clickableHeaderImageView;
            clickableHeaderImageView.setIsRound(true);
            this.e.setClickable(true);
            TextView textView = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f090cda);
            this.f = textView;
            textView.setOnClickListener(this.v);
            AgreeView agreeView = (AgreeView) this.k.findViewById(R.id.obfuscated_res_0x7f090cd5);
            this.g = agreeView;
            agreeView.setAfterClickListener(this.w);
            this.g.setAgreeAlone(true);
            this.a = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f090cd6);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) this.k.findViewById(R.id.obfuscated_res_0x7f090cdb);
            this.b = playVoiceBntNew;
            playVoiceBntNew.setVisibility(8);
            this.c = (FrameLayout) this.k.findViewById(R.id.obfuscated_res_0x7f090cd7);
            int k = oi.k(getContext());
            this.r = oi.f(getContext(), R.dimen.tbds10);
            this.q = (((k - (oi.f(getContext(), R.dimen.tbds44) * 2)) - (oi.f(getContext(), R.dimen.tbds26) * 2)) - (this.r * 4)) / 5;
            for (int i = 0; i < 5; i++) {
                TbImageView tbImageView = new TbImageView(getContext());
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                int i2 = this.q;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i2);
                layoutParams.leftMargin = (this.q + this.r) * i;
                this.c.addView(tbImageView, layoutParams);
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                tbImageView.setBorderSurroundContent(true);
                tbImageView.setDrawBorder(true);
                tbImageView.setTag(R.id.obfuscated_res_0x7f090cd7, Integer.valueOf(i));
                tbImageView.setTagTextSize((int) getResources().getDimension(R.dimen.tbfontsize26));
                tbImageView.setTagPaddingDis(oi.f(getContext(), R.dimen.tbds6), oi.f(getContext(), R.dimen.tbds6));
                tbImageView.setOnClickListener(this);
                tbImageView.setPlaceHolder(2);
            }
            this.c.setVisibility(8);
            this.d = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f090cd8);
        }
    }

    public final boolean j(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) ? view2 != null && view2.getVisibility() == 0 : invokeL.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.t == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.t = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0105);
        vr4 d2 = vr4.d(this.l);
        d2.n(R.string.J_X05);
        d2.f(R.color.CAM_X0206);
        l();
        g();
        this.g.J(TbadkCoreApplication.getInst().getSkinType());
        this.b.d();
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ThreadData threadData = this.h;
            ex5.l(this.a, threadData == null ? null : threadData.getTid(), R.color.CAM_X0105, R.color.CAM_X0109);
        }
    }

    public final void m(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, spannableStringBuilder) == null) {
            if (spannableStringBuilder != null && !TextUtils.isEmpty(spannableStringBuilder.toString())) {
                this.a.setVisibility(0);
                if (!xi.b(this.u, this.a.getPaint(), spannableStringBuilder.toString(), 5)) {
                    this.a.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                } else {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.obfuscated_res_0x7f0f1388));
                    if (spannableStringBuilder3.length() < 3) {
                        return;
                    }
                    int i = 2;
                    spannableStringBuilder3.setSpan(new a(this, 2, null, spannableStringBuilder2), 3, spannableStringBuilder3.length(), 17);
                    StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.a.getPaint(), (int) this.u, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                    float f = this.u;
                    if (staticLayout.getLineCount() >= 5) {
                        spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                        f = this.u - staticLayout.getLineWidth(4);
                    }
                    CharSequence subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length());
                    float measureText = this.a.getPaint().measureText(spannableStringBuilder3.toString());
                    while (measureText > this.a.getPaint().measureText(subSequence.toString()) + f) {
                        i++;
                        if (spannableStringBuilder.length() - i < 0) {
                            break;
                        }
                        subSequence = spannableStringBuilder.subSequence(spannableStringBuilder.length() - i, spannableStringBuilder.length());
                    }
                    if (spannableStringBuilder.length() - i > 0) {
                        spannableStringBuilder.replace(spannableStringBuilder.length() - i, spannableStringBuilder.length(), (CharSequence) spannableStringBuilder3);
                    }
                    this.a.setText(spannableStringBuilder);
                    this.a.setOnTouchListener(new xw8(spannableStringBuilder));
                    mx5.b().a(new StatisticItem(TbadkCoreStatisticKey.GOD_REPLY_LAYOUT_FULL_TEXT_SHOW));
                }
                l();
                return;
            }
            this.a.setVisibility(8);
        }
    }

    public void n(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, postData) == null) {
            List<TbRichTextImageInfo> list = this.m;
            if (list == null) {
                this.m = new ArrayList();
            } else {
                list.clear();
            }
            if (!bn4.c().g()) {
                this.c.setVisibility(8);
                this.d.setVisibility(8);
                return;
            }
            TbRichText P = postData.P();
            if (P != null && P.A() != null) {
                Iterator<TbRichTextData> it = P.A().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        int i = x;
                        next.S(i, i);
                        if (next.getType() == 8) {
                            this.m.add(next.E());
                        }
                    }
                }
                if (this.m.size() == 0) {
                    this.c.setVisibility(8);
                    this.d.setVisibility(8);
                    return;
                }
                this.c.setVisibility(0);
                int f = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int i2 = 0;
                for (int i3 = 0; i3 < this.c.getChildCount(); i3++) {
                    View childAt = this.c.getChildAt(i3);
                    if (childAt != null && (childAt instanceof TbImageView)) {
                        TbImageView tbImageView = (TbImageView) childAt;
                        tbImageView.t();
                        tbImageView.setRadius(f);
                        tbImageView.s(15);
                        if (i2 < this.m.size()) {
                            TbRichTextImageInfo tbRichTextImageInfo = this.m.get(i2);
                            if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.A())) {
                                tbImageView.K(tbRichTextImageInfo.A(), this.o ? 13 : 14, false);
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
                if (this.m.size() > 5) {
                    ImageView imageView = new ImageView(getContext());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    int i4 = this.q;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i4);
                    layoutParams.leftMargin = (this.q + this.r) * 4;
                    this.c.addView(imageView, -1, layoutParams);
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f0810b5);
                    this.d.setVisibility(0);
                    this.d.setText(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + (this.m.size() - 5));
                    this.d.post(new b(this));
                    return;
                }
                this.d.setVisibility(8);
                return;
            }
            this.c.setVisibility(8);
            this.d.setVisibility(8);
        }
    }

    public void o(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, postData) == null) || postData == null) {
            return;
        }
        this.e.setData(postData.s());
        String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(postData.s().getName_show(), 14, StringHelper.STRING_MORE);
        TextView textView = this.f;
        textView.setText(cutChineseAndEnglishWithSuffix + "：");
        if (this.h != null) {
            postData.q().threadId = this.h.getTid();
        }
        postData.q().threadId = String.valueOf(postData.W());
        postData.q().objType = 3;
        this.g.setData(postData.q());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        List<TbRichTextImageInfo> list;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, view2) == null) || !(view2 instanceof TbImageView) || (list = this.m) == null || list.size() == 0 || view2.getTag(R.id.obfuscated_res_0x7f090cd7) == null || !(view2.getTag(R.id.obfuscated_res_0x7f090cd7) instanceof Integer)) {
            return;
        }
        int intValue = ((Integer) view2.getTag(R.id.obfuscated_res_0x7f090cd7)).intValue();
        ArrayList<String> arrayList = new ArrayList<>();
        for (TbRichTextImageInfo tbRichTextImageInfo : this.m) {
            arrayList.add(tbRichTextImageInfo.y());
        }
        ThreadData threadData = this.h;
        String str2 = "";
        if (threadData != null) {
            str2 = threadData.getForum_name();
            str = this.h.getTid();
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
        bVar.N(this.h);
        bVar.I(false);
        ImageViewerConfig v = bVar.v(getContext());
        v.getIntent().putExtra("from", this.p);
        v.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, v));
        View.OnClickListener onClickListener = this.s;
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
    }

    public void p(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, postData) == null) {
            TbRichTextVoiceInfo b0 = postData.b0();
            this.n = b0;
            if (b0 == null) {
                this.b.setVisibility(8);
                return;
            }
            this.b.setVisibility(0);
            this.b.setTag(this.n);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, threadData) == null) {
            this.h = threadData;
            setData(threadData != null ? threadData.getTopAgreePost() : null);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.p = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.o = z;
        }
    }

    public void setData(PostData postData) {
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, postData) == null) {
            if (postData != null && postData.s() != null && postData.s().getUserId() != null) {
                this.i = postData;
                setVisibility(0);
                o(postData);
                m(h(postData.P()));
                n(postData);
                p(postData);
                List<TbRichTextImageInfo> list = this.m;
                if ((list != null && list.size() > 0) || ((tbRichTextVoiceInfo = this.n) != null && tbRichTextVoiceInfo.A() != null)) {
                    this.l.setPadding(0, 0, 0, oi.f(getContext(), R.dimen.M_H_X003));
                } else {
                    this.l.setPadding(0, 0, 0, oi.f(getContext(), R.dimen.tbds0));
                }
                if (j(this.a) || j(this.c) || j(this.b)) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.h = null;
        this.t = 3;
        this.u = oi.k(getContext()) - (oi.f(getContext(), R.dimen.tbds70) * 2);
        this.v = new c(this);
        this.w = new d(this);
        i(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadGodReplyLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.h = null;
        this.t = 3;
        this.u = oi.k(getContext()) - (oi.f(getContext(), R.dimen.tbds70) * 2);
        this.v = new c(this);
        this.w = new d(this);
        i(context);
    }
}

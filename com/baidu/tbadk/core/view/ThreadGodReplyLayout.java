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
import com.baidu.tieba.bv5;
import com.baidu.tieba.ii;
import com.baidu.tieba.jg6;
import com.baidu.tieba.ky9;
import com.baidu.tieba.q25;
import com.baidu.tieba.qg6;
import com.baidu.tieba.ri;
import com.baidu.tieba.rv4;
import com.baidu.tieba.sl9;
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
    public sl9 i;
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
    public class a extends bv5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpannableStringBuilder i;
        public final /* synthetic */ ThreadGodReplyLayout j;

        /* renamed from: com.baidu.tbadk.core.view.ThreadGodReplyLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0197a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0197a(a aVar) {
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.j.a.getLineCount() >= 15) {
                    int lineEnd = this.a.j.a.getLayout().getLineEnd(14);
                    this.a.j.a.setText(((Object) this.a.j.a.getText().subSequence(0, lineEnd - 1)) + StringHelper.STRING_MORE);
                }
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
            this.j = threadGodReplyLayout;
            this.i = spannableStringBuilder;
        }

        @Override // com.baidu.tieba.bv5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                qg6.b().a(new StatisticItem(TbadkCoreStatisticKey.GOD_REPLY_LAYOUT_FULL_TEXT_CLICK));
                this.j.a.setMaxLines(15);
                this.j.a.setEllipsize(TextUtils.TruncateAt.END);
                this.j.a.setText(this.i.toString());
                this.j.a.post(new RunnableC0197a(this));
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
                int width = ((this.a.q - this.a.d.getWidth()) / 2) + ii.g(this.a.getContext(), R.dimen.tbds26);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.i != null && this.a.i.q() != null && !StringUtils.isNull(this.a.i.q().getName_show()) && !StringUtils.isNull(this.a.i.q().getUserId())) {
                PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.a.j, this.a.i.q().getUserId(), this.a.i.q().getName_show());
                personInfoActivityConfig.setSourceTid(this.a.i.O());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                if (this.a.s != null) {
                    this.a.s.onClick(view2);
                }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.s != null) {
                this.a.s.onClick(view2);
            }
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
        x = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    }

    public TextView getGodReplyContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (TextView) invokeV.objValue;
    }

    public final void l() {
        String tid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ThreadData threadData = this.h;
            if (threadData == null) {
                tid = null;
            } else {
                tid = threadData.getTid();
            }
            jg6.l(this.a, tid, R.color.CAM_X0105, R.color.CAM_X0109);
        }
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
        this.u = ii.l(getContext()) - (ii.g(getContext(), R.dimen.tbds70) * 2);
        this.v = new c(this);
        this.w = new d(this);
        i(context);
    }

    public void o(sl9 sl9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, sl9Var) != null) || sl9Var == null) {
            return;
        }
        this.e.setData(sl9Var.q());
        String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(sl9Var.q().getName_show(), 14, StringHelper.STRING_MORE);
        TextView textView = this.f;
        textView.setText(cutChineseAndEnglishWithSuffix + "：");
        if (this.h != null) {
            sl9Var.n().threadId = this.h.getTid();
        }
        sl9Var.n().threadId = String.valueOf(sl9Var.k0());
        sl9Var.n().objType = 3;
        this.g.setData(sl9Var.n());
    }

    public void setData(sl9 sl9Var) {
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, sl9Var) == null) {
            if (sl9Var != null && sl9Var.q() != null && sl9Var.q().getUserId() != null) {
                this.i = sl9Var;
                setVisibility(0);
                o(sl9Var);
                m(h(sl9Var.a0()));
                n(sl9Var);
                p(sl9Var);
                List<TbRichTextImageInfo> list = this.m;
                if ((list != null && list.size() > 0) || ((tbRichTextVoiceInfo = this.n) != null && tbRichTextVoiceInfo.S() != null)) {
                    this.l.setPadding(0, 0, 0, ii.g(getContext(), R.dimen.M_H_X003));
                } else {
                    this.l.setPadding(0, 0, 0, ii.g(getContext(), R.dimen.tbds0));
                }
                if (!j(this.a) && !j(this.c) && !j(this.b)) {
                    setVisibility(8);
                    return;
                }
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
        this.u = ii.l(getContext()) - (ii.g(getContext(), R.dimen.tbds70) * 2);
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
        this.u = ii.l(getContext()) - (ii.g(getContext(), R.dimen.tbds70) * 2);
        this.v = new c(this);
        this.w = new d(this);
        i(context);
    }

    public final boolean j(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            if (view2 == null || view2.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void p(sl9 sl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, sl9Var) == null) {
            TbRichTextVoiceInfo r0 = sl9Var.r0();
            this.n = r0;
            if (r0 == null) {
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
        sl9 sl9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, threadData) == null) {
            this.h = threadData;
            if (threadData != null) {
                sl9Var = threadData.getTopAgreePost();
            } else {
                sl9Var = null;
            }
            setData(sl9Var);
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

    public final SpannableStringBuilder h(TbRichText tbRichText) {
        InterceptResult invokeL;
        ArrayList<TbRichTextData> S;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbRichText)) == null) {
            if (tbRichText == null || (S = tbRichText.S()) == null) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            Iterator<TbRichTextData> it = S.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 1) {
                    spannableStringBuilder.append((CharSequence) next.c0());
                } else if (next.getType() == 17) {
                    String str = next.T().mGifInfo.mSharpText;
                    if (str != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                        spannableStringBuilder.append((CharSequence) "[表情]");
                    }
                } else if (next.getType() == 20) {
                    spannableStringBuilder.append((CharSequence) "[表情]");
                }
            }
            if (spannableStringBuilder.length() > 0) {
                for (bv5 bv5Var : (bv5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length() - 1, bv5.class)) {
                    spannableStringBuilder.removeSpan(bv5Var);
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
            View inflate = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
            this.k = inflate;
            this.l = (RelativeLayout) inflate.findViewById(R.id.god_comment_layout);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) this.k.findViewById(R.id.god_reply_user_pendant_header);
            this.e = clickableHeaderImageView;
            clickableHeaderImageView.setIsRound(true);
            this.e.setClickable(true);
            TextView textView = (TextView) this.k.findViewById(R.id.god_reply_username_text);
            this.f = textView;
            textView.setOnClickListener(this.v);
            AgreeView agreeView = (AgreeView) this.k.findViewById(R.id.god_reply_agree_view);
            this.g = agreeView;
            agreeView.setAfterClickListener(this.w);
            this.g.setAgreeAlone(true);
            this.g.v();
            this.g.setAgreeAnimationResource();
            this.a = (TextView) this.k.findViewById(R.id.god_reply_content);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) this.k.findViewById(R.id.god_reply_voice_btn);
            this.b = playVoiceBntNew;
            playVoiceBntNew.setVisibility(8);
            this.c = (FrameLayout) this.k.findViewById(R.id.god_reply_image_layout);
            int l = ii.l(getContext());
            this.r = ii.g(getContext(), R.dimen.tbds10);
            this.q = (((l - (ii.g(getContext(), R.dimen.tbds44) * 2)) - (ii.g(getContext(), R.dimen.tbds26) * 2)) - (this.r * 4)) / 5;
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
                tbImageView.setTag(R.id.god_reply_image_layout, Integer.valueOf(i));
                tbImageView.setTagTextSize((int) getResources().getDimension(R.dimen.tbfontsize26));
                tbImageView.setTagPaddingDis(ii.g(getContext(), R.dimen.tbds6), ii.g(getContext(), R.dimen.tbds6));
                tbImageView.setOnClickListener(this);
                tbImageView.setPlaceHolder(2);
            }
            this.c.setVisibility(8);
            this.d = (TextView) this.k.findViewById(R.id.god_reply_img_num);
        }
    }

    public void n(sl9 sl9Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sl9Var) == null) {
            List<TbRichTextImageInfo> list = this.m;
            if (list == null) {
                this.m = new ArrayList();
            } else {
                list.clear();
            }
            if (!rv4.c().g()) {
                this.c.setVisibility(8);
                this.d.setVisibility(8);
                return;
            }
            TbRichText a0 = sl9Var.a0();
            if (a0 != null && a0.S() != null) {
                Iterator<TbRichTextData> it = a0.S().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        int i2 = x;
                        next.n0(i2, i2);
                        if (next.getType() == 8) {
                            this.m.add(next.Y());
                        }
                    }
                }
                if (this.m.size() == 0) {
                    this.c.setVisibility(8);
                    this.d.setVisibility(8);
                    return;
                }
                this.c.setVisibility(0);
                int g = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int i3 = 0;
                for (int i4 = 0; i4 < this.c.getChildCount(); i4++) {
                    View childAt = this.c.getChildAt(i4);
                    if (childAt != null && (childAt instanceof TbImageView)) {
                        TbImageView tbImageView = (TbImageView) childAt;
                        tbImageView.s();
                        tbImageView.setRadius(g);
                        tbImageView.r(15);
                        if (i3 < this.m.size()) {
                            TbRichTextImageInfo tbRichTextImageInfo = this.m.get(i3);
                            if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.R())) {
                                String R = tbRichTextImageInfo.R();
                                if (this.o) {
                                    i = 13;
                                } else {
                                    i = 14;
                                }
                                tbImageView.N(R, i, false);
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
                if (this.m.size() > 5) {
                    ImageView imageView = new ImageView(getContext());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    int i5 = this.q;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i5, i5);
                    layoutParams.leftMargin = (this.q + this.r) * 4;
                    this.c.addView(imageView, -1, layoutParams);
                    imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
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

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.t != TbadkCoreApplication.getInst().getSkinType()) {
            this.t = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0105);
            q25 d2 = q25.d(this.l);
            d2.o(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            l();
            g();
            this.g.P(TbadkCoreApplication.getInst().getSkinType());
            this.b.e();
        }
    }

    public final void m(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, spannableStringBuilder) == null) {
            if (spannableStringBuilder != null && !TextUtils.isEmpty(spannableStringBuilder.toString())) {
                this.a.setVisibility(0);
                if (!ri.b(this.u, this.a.getPaint(), spannableStringBuilder.toString(), 5)) {
                    this.a.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                } else {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
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
                    this.a.setOnTouchListener(new ky9(spannableStringBuilder));
                    qg6.b().a(new StatisticItem(TbadkCoreStatisticKey.GOD_REPLY_LAYOUT_FULL_TEXT_SHOW));
                }
                l();
                return;
            }
            this.a.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        List<TbRichTextImageInfo> list;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, view2) == null) && (view2 instanceof TbImageView) && (list = this.m) != null && list.size() != 0 && view2.getTag(R.id.god_reply_image_layout) != null && (view2.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view2.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.m) {
                arrayList.add(tbRichTextImageInfo.Q());
            }
            ThreadData threadData = this.h;
            String str2 = "";
            if (threadData == null) {
                str = "";
            } else {
                str2 = threadData.getForum_name();
                str = this.h.getTid();
            }
            ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
            builder.A(arrayList);
            builder.E(intValue);
            builder.C(str2);
            builder.R(str);
            builder.F(true);
            builder.M(arrayList.get(0));
            builder.I(true);
            builder.Q(this.h);
            builder.L(false);
            builder.O(this.h.getFirst_post_id());
            ImageViewerConfig x2 = builder.x(getContext());
            x2.getIntent().putExtra("from", this.p);
            x2.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, x2));
            View.OnClickListener onClickListener = this.s;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }
}

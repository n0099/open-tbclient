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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.e26;
import com.baidu.tieba.ei;
import com.baidu.tieba.ep6;
import com.baidu.tieba.j45;
import com.baidu.tieba.m05;
import com.baidu.tieba.mi;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tha;
import com.baidu.tieba.u95;
import com.baidu.tieba.vva;
import com.baidu.tieba.xo6;
import com.baidu.tieba.zfa;
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
/* loaded from: classes4.dex */
public class ThreadGodReplyLayout extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int y;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public PlayVoiceBntNew b;
    public FrameLayout c;
    public TextView d;
    public ClickableHeaderImageView e;
    public TextView f;
    public AgreeView g;
    public TbImage h;
    public ThreadData i;
    public tha j;
    public Context k;
    public View l;
    public RelativeLayout m;
    public List<TbRichTextImageInfo> n;
    public TbRichTextVoiceInfo o;
    public boolean p;
    public String q;
    public int r;
    public int s;
    public View.OnClickListener t;
    public int u;
    public final float v;
    public View.OnClickListener w;
    public View.OnClickListener x;

    /* loaded from: classes4.dex */
    public class a extends e26 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpannableStringBuilder m;
        public final /* synthetic */ ThreadGodReplyLayout n;

        /* renamed from: com.baidu.tbadk.core.view.ThreadGodReplyLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0212a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0212a(a aVar) {
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.n.a.getLineCount() >= 15) {
                    int lineEnd = this.a.n.a.getLayout().getLineEnd(14);
                    this.a.n.a.setText(((Object) this.a.n.a.getText().subSequence(0, lineEnd - 1)) + "...");
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
            this.n = threadGodReplyLayout;
            this.m = spannableStringBuilder;
        }

        @Override // com.baidu.tieba.e26, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ep6.b().a(new StatisticItem(TbadkCoreStatisticKey.GOD_REPLY_LAYOUT_FULL_TEXT_CLICK));
                this.n.a.setMaxLines(15);
                this.n.a.setEllipsize(TextUtils.TruncateAt.END);
                this.n.a.setText(this.m);
                this.n.a.post(new RunnableC0212a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
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
                int width = ((this.a.r - this.a.d.getWidth()) / 2) + BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds26);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.d.getLayoutParams();
                layoutParams.setMargins(0, width, width, 0);
                this.a.d.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.j != null && this.a.j.t() != null && !StringUtils.isNull(this.a.j.t().getName_show()) && !StringUtils.isNull(this.a.j.t().getUserId())) {
                PersonInfoActivityConfig personInfoActivityConfig = new PersonInfoActivityConfig(this.a.k, this.a.j.t().getUserId(), this.a.j.t().getName_show());
                personInfoActivityConfig.setSourceTid(this.a.j.U());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, personInfoActivityConfig));
                if (this.a.t != null) {
                    this.a.t.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.t != null) {
                this.a.t.onClick(view2);
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
        y = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
    }

    public TextView getGodReplyContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (TextView) invokeV.objValue;
    }

    public final void m() {
        String tid;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ThreadData threadData = this.i;
            if (threadData == null) {
                tid = null;
            } else {
                tid = threadData.getTid();
            }
            xo6.l(this.a, tid, R.color.CAM_X0105, R.color.CAM_X0109);
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
        this.i = null;
        this.u = 3;
        this.v = BdUtilHelper.getEquipmentWidth(getContext()) - (BdUtilHelper.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.w = new c(this);
        this.x = new d(this);
        j(context);
    }

    public void setData(tha thaVar) {
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, thaVar) == null) {
            if (thaVar != null && thaVar.t() != null && thaVar.t().getUserId() != null) {
                this.j = thaVar;
                setVisibility(0);
                q(thaVar);
                SpannableStringBuilder i = i(thaVar.f0());
                p(thaVar, i);
                n(i);
                o(thaVar);
                r(thaVar);
                List<TbRichTextImageInfo> list = this.n;
                if ((list != null && list.size() > 0) || ((tbRichTextVoiceInfo = this.o) != null && tbRichTextVoiceInfo.O() != null)) {
                    this.m.setPadding(0, 0, 0, BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X003));
                } else {
                    this.m.setPadding(0, 0, 0, BdUtilHelper.getDimens(getContext(), R.dimen.tbds0));
                }
                if (!k(this.a) && !k(this.c) && !k(this.b)) {
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
        this.i = null;
        this.u = 3;
        this.v = BdUtilHelper.getEquipmentWidth(getContext()) - (BdUtilHelper.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.w = new c(this);
        this.x = new d(this);
        j(context);
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
        this.i = null;
        this.u = 3;
        this.v = BdUtilHelper.getEquipmentWidth(getContext()) - (BdUtilHelper.getDimens(getContext(), R.dimen.tbds70) * 2);
        this.w = new c(this);
        this.x = new d(this);
        j(context);
    }

    public final void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.e.setVisibility(i);
            this.f.setVisibility(i);
            this.g.setVisibility(i);
            this.h.setVisibility(i);
        }
    }

    public final boolean k(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
            if (view2 == null || view2.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void r(tha thaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, thaVar) == null) {
            TbRichTextVoiceInfo x0 = thaVar.x0();
            this.o = x0;
            if (x0 == null) {
                this.b.setVisibility(8);
                return;
            }
            this.b.setVisibility(0);
            this.b.setTag(this.o);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    public void setData(ThreadData threadData) {
        tha thaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, threadData) == null) {
            this.i = threadData;
            if (threadData != null) {
                thaVar = threadData.getTopAgreePost();
            } else {
                thaVar = null;
            }
            setData(thaVar);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.q = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.p = z;
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

    public final SpannableStringBuilder i(TbRichText tbRichText) {
        InterceptResult invokeL;
        ArrayList<TbRichTextData> O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, tbRichText)) == null) {
            if (tbRichText == null || (O = tbRichText.O()) == null) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            Iterator<TbRichTextData> it = O.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 1) {
                    spannableStringBuilder.append((CharSequence) next.Y());
                } else if (next.getType() == 17) {
                    String str = next.P().mGifInfo.mSharpText;
                    if (str != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                        spannableStringBuilder.append((CharSequence) "[表情]");
                    }
                } else if (next.getType() == 20) {
                    spannableStringBuilder.append((CharSequence) "[表情]");
                }
            }
            if (spannableStringBuilder.length() > 0) {
                for (e26 e26Var : (e26[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length() - 1, e26.class)) {
                    spannableStringBuilder.removeSpan(e26Var);
                }
                for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length() - 1, ForegroundColorSpan.class)) {
                    spannableStringBuilder.removeSpan(foregroundColorSpan);
                }
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public void q(tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, thaVar) != null) || thaVar == null) {
            return;
        }
        if (thaVar.z1()) {
            h(8);
            return;
        }
        h(0);
        this.e.setData(thaVar.t());
        String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(thaVar.t().getName_show(), 14, "...");
        TextView textView = this.f;
        textView.setText(cutChineseAndEnglishWithSuffix + "：");
        if (this.i != null) {
            thaVar.p().threadId = this.i.getTid();
        }
        thaVar.p().threadId = String.valueOf(thaVar.p0());
        thaVar.p().objType = 3;
        this.g.setData(thaVar.p());
        if (thaVar.r0() != null && !ei.isEmpty(thaVar.r0().b())) {
            this.h.l(thaVar.r0().b());
        } else {
            this.h.setImageResource(R.drawable.pic_comment_god_big);
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.k = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.thread_god_reply_layout, (ViewGroup) this, true);
            this.l = inflate;
            this.m = (RelativeLayout) inflate.findViewById(R.id.god_comment_layout);
            ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) this.l.findViewById(R.id.god_reply_user_pendant_header);
            this.e = clickableHeaderImageView;
            clickableHeaderImageView.setIsRound(true);
            this.e.setClickable(true);
            TextView textView = (TextView) this.l.findViewById(R.id.god_reply_username_text);
            this.f = textView;
            textView.setOnClickListener(this.w);
            AgreeView agreeView = (AgreeView) this.l.findViewById(R.id.god_reply_agree_view);
            this.g = agreeView;
            agreeView.setAfterClickListener(this.x);
            this.g.setAgreeAlone(true);
            this.g.w();
            this.g.setAgreeAnimationResource();
            this.h = (TbImage) this.l.findViewById(R.id.god_reply_icon);
            this.a = (TextView) this.l.findViewById(R.id.god_reply_content);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) this.l.findViewById(R.id.god_reply_voice_btn);
            this.b = playVoiceBntNew;
            playVoiceBntNew.setVisibility(8);
            this.c = (FrameLayout) this.l.findViewById(R.id.god_reply_image_layout);
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(getContext());
            this.s = BdUtilHelper.getDimens(getContext(), R.dimen.tbds10);
            this.r = (((equipmentWidth - (BdUtilHelper.getDimens(getContext(), R.dimen.tbds44) * 2)) - (BdUtilHelper.getDimens(getContext(), R.dimen.tbds26) * 2)) - (this.s * 4)) / 5;
            for (int i = 0; i < 5; i++) {
                TbImageView tbImageView = new TbImageView(getContext());
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                int i2 = this.r;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i2);
                layoutParams.leftMargin = (this.r + this.s) * i;
                this.c.addView(tbImageView, layoutParams);
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
                tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                tbImageView.setBorderSurroundContent(true);
                tbImageView.setDrawBorder(true);
                tbImageView.setTag(R.id.god_reply_image_layout, Integer.valueOf(i));
                tbImageView.setTagTextSize((int) getResources().getDimension(R.dimen.tbfontsize26));
                tbImageView.setTagPaddingDis(BdUtilHelper.getDimens(getContext(), R.dimen.tbds6), BdUtilHelper.getDimens(getContext(), R.dimen.tbds6));
                tbImageView.setOnClickListener(this);
                tbImageView.setPlaceHolder(2);
            }
            this.c.setVisibility(8);
            this.d = (TextView) this.l.findViewById(R.id.god_reply_img_num);
        }
    }

    public void o(tha thaVar) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, thaVar) == null) {
            List<TbRichTextImageInfo> list = this.n;
            if (list == null) {
                this.n = new ArrayList();
            } else {
                list.clear();
            }
            if (!m05.c().g()) {
                this.c.setVisibility(8);
                this.d.setVisibility(8);
                return;
            }
            TbRichText f0 = thaVar.f0();
            if (f0 != null && f0.O() != null) {
                Iterator<TbRichTextData> it = f0.O().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        int i2 = y;
                        next.j0(i2, i2);
                        if (next.getType() == 8) {
                            this.n.add(next.U());
                        }
                    }
                }
                if (this.n.size() == 0) {
                    this.c.setVisibility(8);
                    this.d.setVisibility(8);
                    return;
                }
                this.c.setVisibility(0);
                int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int i3 = 0;
                for (int i4 = 0; i4 < this.c.getChildCount(); i4++) {
                    View childAt = this.c.getChildAt(i4);
                    if (childAt != null && (childAt instanceof TbImageView)) {
                        TbImageView tbImageView = (TbImageView) childAt;
                        tbImageView.clearCornerFlag();
                        tbImageView.setRadius(dimens);
                        tbImageView.addCornerFlags(15);
                        if (i3 < this.n.size()) {
                            TbRichTextImageInfo tbRichTextImageInfo = this.n.get(i3);
                            if (tbRichTextImageInfo != null && !TextUtils.isEmpty(tbRichTextImageInfo.N())) {
                                String N = tbRichTextImageInfo.N();
                                if (this.p) {
                                    i = 13;
                                } else {
                                    i = 14;
                                }
                                tbImageView.startLoad(N, i, false);
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
                if (this.n.size() > 5) {
                    ImageView imageView = new ImageView(getContext());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    int i5 = this.r;
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i5, i5);
                    layoutParams.leftMargin = (this.r + this.s) * 4;
                    this.c.addView(imageView, -1, layoutParams);
                    imageView.setImageResource(R.drawable.shape_black_0_to_50_vertical);
                    this.d.setVisibility(0);
                    this.d.setText(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + (this.n.size() - 5));
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

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.u != TbadkCoreApplication.getInst().getSkinType()) {
            this.u = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0105);
            EMManager.from(this.m).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
            m();
            g();
            this.g.P(TbadkCoreApplication.getInst().getSkinType());
            this.b.b();
        }
    }

    public final void n(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, spannableStringBuilder) == null) {
            if (spannableStringBuilder != null && !TextUtils.isEmpty(spannableStringBuilder.toString())) {
                this.a.setVisibility(0);
                if (!mi.b(this.v, this.a.getPaint(), spannableStringBuilder.toString(), 5)) {
                    this.a.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                } else {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getResources().getString(R.string.text_expand_tail));
                    if (spannableStringBuilder3.length() < 3) {
                        return;
                    }
                    int i = 2;
                    spannableStringBuilder3.setSpan(new a(this, 2, null, spannableStringBuilder2), 3, spannableStringBuilder3.length(), 17);
                    StaticLayout staticLayout = new StaticLayout(spannableStringBuilder.toString(), this.a.getPaint(), (int) this.v, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                    float f = this.v;
                    if (staticLayout.getLineCount() >= 5) {
                        spannableStringBuilder.delete(staticLayout.getLineEnd(4), spannableStringBuilder.length());
                        f = this.v - staticLayout.getLineWidth(4);
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
                    this.a.setOnTouchListener(new vva(spannableStringBuilder));
                    ep6.b().a(new StatisticItem(TbadkCoreStatisticKey.GOD_REPLY_LAYOUT_FULL_TEXT_SHOW));
                }
                m();
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
        if ((interceptable == null || interceptable.invokeL(1048586, this, view2) == null) && (view2 instanceof TbImageView) && (list = this.n) != null && list.size() != 0 && view2.getTag(R.id.god_reply_image_layout) != null && (view2.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
            int intValue = ((Integer) view2.getTag(R.id.god_reply_image_layout)).intValue();
            ArrayList<String> arrayList = new ArrayList<>();
            for (TbRichTextImageInfo tbRichTextImageInfo : this.n) {
                arrayList.add(tbRichTextImageInfo.M());
            }
            ThreadData threadData = this.i;
            String str2 = "";
            if (threadData == null) {
                str = "";
            } else {
                str2 = threadData.getForum_name();
                str = this.i.getTid();
            }
            ImageViewerConfig.Builder builder = new ImageViewerConfig.Builder();
            builder.setData(arrayList).setIndex(intValue).setForumName(str2).setThreadId(str).setIsCDN(true).setLastId(arrayList.get(0)).setIsReserve(true).setThreadData(this.i).setIsShowHost(false).setPostId(this.i.getFirst_post_id());
            ImageViewerConfig bulid = builder.bulid(getContext());
            bulid.getIntent().putExtra("from", this.q);
            bulid.getIntent().putExtra(ImageViewerConfig.IS_GODREPLY_IMAGE, true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2010000, bulid));
            View.OnClickListener onClickListener = this.t;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    public final void p(tha thaVar, SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, thaVar, spannableStringBuilder) == null) {
            if (!thaVar.z1()) {
                this.a.setTextSize(0, BdUtilHelper.getDimens(getContext(), R.dimen.tbfontsize40));
                this.a.setMaxLines(5);
                return;
            }
            j45 r0 = thaVar.r0();
            spannableStringBuilder.insert(0, r0.d());
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.L_X01);
            int dimens2 = BdUtilHelper.getDimens(getContext(), R.dimen.T_X10);
            int dimens3 = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002);
            int dimens4 = BdUtilHelper.getDimens(getContext(), R.dimen.tbds1);
            int dimens5 = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X002);
            int dimens6 = BdUtilHelper.getDimens(getContext(), R.dimen.tbds42);
            int d2 = zfa.d(getContext(), r0.a());
            u95 u95Var = new u95(dimens, R.string.J_X04, d2, dimens2, d2, dimens3, dimens6);
            u95Var.i(dimens5);
            u95Var.h(dimens4);
            spannableStringBuilder.setSpan(u95Var, 0, thaVar.r0().d().length(), 33);
            this.a.setTextSize(0, BdUtilHelper.getDimens(getContext(), R.dimen.T_X07));
            this.a.setMaxLines(2);
        }
    }
}

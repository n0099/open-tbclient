package c.a.r0.q2.x;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.z1;
import c.a.r0.k4.h;
import c.a.r0.q2.i;
import c.a.r0.q2.l;
import c.a.r0.q2.u.f.r0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.VideoInfo;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f22345b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f22346c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22347d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22348e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22349f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f22350g;

    /* renamed from: h  reason: collision with root package name */
    public ThreadAgreeAndShareLayout f22351h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f22352i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f22353j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f22354k;
    public c.a.q0.s.g0.r.a l;
    public SpannableStringBuilder m;
    public SpannableStringBuilder n;
    public View.OnTouchListener o;
    public View.OnTouchListener p;
    public c.a.q0.f1.n.f q;
    public View.OnClickListener r;

    /* loaded from: classes6.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22355e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22355e = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            int ellipsisCount;
            Object[] spans;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f22355e;
                if (cVar.f22345b == null || cVar.m == null || this.f22355e.f22354k || (layout = this.f22355e.f22345b.getLayout()) == null) {
                    return;
                }
                if (this.f22355e.f22352i) {
                    if (this.f22355e.f22353j) {
                        return;
                    }
                    int lineCount = layout.getLineCount();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f22355e.f22348e.getLayoutParams();
                    if (this.f22355e.f22348e.getWidth() + layout.getLineWidth(lineCount - 1) > layout.getWidth()) {
                        layoutParams.addRule(3, i.view_video_title);
                        layoutParams.addRule(8, 0);
                    } else {
                        layoutParams.addRule(8, i.view_video_title);
                        layoutParams.addRule(3, 0);
                    }
                    this.f22355e.f22348e.setLayoutParams(layoutParams);
                    this.f22355e.f22353j = true;
                    return;
                }
                int lineCount2 = layout.getLineCount();
                if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                    if (this.f22355e.n == null) {
                        String spannableStringBuilder = this.f22355e.m.toString();
                        String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(spannableStringBuilder, StringHelper.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                        int length = cutChineseAndEnglishWithSuffix.length();
                        this.f22355e.n = new SpannableStringBuilder();
                        this.f22355e.n.append((CharSequence) cutChineseAndEnglishWithSuffix);
                        for (Object obj : this.f22355e.m.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                            int spanStart = this.f22355e.m.getSpanStart(obj);
                            int spanEnd = this.f22355e.m.getSpanEnd(obj);
                            if (spanStart < length && spanEnd >= length) {
                                break;
                            }
                            if (obj instanceof SpannableString) {
                                this.f22355e.n.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                            }
                        }
                        SpannableString spannableString = new SpannableString("...展开");
                        spannableString.setSpan(this.f22355e.q, 0, spannableString.length(), 17);
                        this.f22355e.n.insert(length, (CharSequence) spannableString);
                        c cVar2 = this.f22355e;
                        cVar2.p = new h(cVar2.n);
                    }
                    this.f22355e.f22348e.setVisibility(8);
                    c cVar3 = this.f22355e;
                    cVar3.f22345b.setOnTouchListener(cVar3.p);
                    c cVar4 = this.f22355e;
                    cVar4.f22345b.setText(cVar4.n);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends c.a.q0.f1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, int i2, String str, String str2) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2), str, str2};
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
            this.l = str2;
        }

        @Override // c.a.q0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.q0.m.a.v(TbadkCoreApplication.getInst().getApplicationContext(), false, this.l);
                TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "3"));
            }
        }

        @Override // c.a.q0.f1.n.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(c.a.r0.q2.f.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* renamed from: c.a.r0.q2.x.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1294c extends c.a.q0.f1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1294c(c cVar, int i2, String str) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2), str};
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
            this.l = cVar;
        }

        @Override // c.a.q0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.l.f22352i = true;
                this.l.f22345b.setMaxLines(10);
                c cVar = this.l;
                cVar.f22345b.setOnTouchListener(new h(cVar.m));
                c cVar2 = this.l;
                cVar2.f22345b.setText(cVar2.m);
                this.l.f22348e.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22356e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22356e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f22356e.f22349f) {
                    Object tag = this.f22356e.f22349f.getTag();
                    Context context = view.getContext();
                    if (!(tag instanceof String) || context == null) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                    return;
                }
                c cVar = this.f22356e;
                if (view == cVar.f22348e) {
                    cVar.f22352i = false;
                    c cVar2 = this.f22356e;
                    cVar2.f22345b.setOnTouchListener(cVar2.p);
                    c cVar3 = this.f22356e;
                    cVar3.f22345b.setText(cVar3.n);
                    this.f22356e.f22348e.setVisibility(8);
                }
            }
        }
    }

    public c(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new C1294c(this, 2, null);
        this.r = new d(this);
        if (view == null) {
            return;
        }
        this.a = view;
        TextView textView = (TextView) view.findViewById(i.view_video_title);
        this.f22345b = textView;
        textView.setTextSize(0, TbConfig.getContentSize());
        this.f22345b.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.f22345b.getPaint().setFakeBoldText(true);
        this.f22346c = (TextView) this.a.findViewById(i.pb_video_replay_num);
        this.f22347d = (TextView) this.a.findViewById(i.pb_video_play_count);
        this.f22348e = (TextView) this.a.findViewById(i.view_video_title_up);
        this.f22349f = (TextView) this.a.findViewById(i.pb_video_forum);
        this.f22351h = (ThreadAgreeAndShareLayout) this.a.findViewById(i.pb_video_act);
        this.f22350g = (TbImageView) this.a.findViewById(i.arrow_right);
        this.f22345b.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public void m(c.a.r0.q2.r.f fVar, String str) {
        d2 O;
        z1 z1Var;
        SpannableStringBuilder spannableStringBuilder;
        Layout j2;
        SpannableString c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, fVar, str) == null) || fVar == null || (O = fVar.O()) == null || O.t1() == null) {
            return;
        }
        O.f3();
        this.m = new SpannableStringBuilder(O.i1());
        boolean n = n(O);
        VideoInfo t1 = O.t1();
        if (!StringUtils.isNull(t1.mcn_lead_page) && !n) {
            this.f22354k = true;
        } else {
            this.f22354k = false;
        }
        if (this.m != null && !this.f22354k && !n && (c2 = r0.c(O)) != null) {
            c.a.q0.s.g0.r.a[] aVarArr = (c.a.q0.s.g0.r.a[]) c2.getSpans(0, c2.length(), c.a.q0.s.g0.r.a.class);
            if (aVarArr != null && aVarArr.length > 0) {
                this.l = aVarArr[0];
            }
            this.m.append((CharSequence) c2);
        }
        if (this.l != null && (spannableStringBuilder = this.m) != null && (j2 = r0.j(spannableStringBuilder)) != null && j2.getLineCount() > 10) {
            int spanStart = this.m.getSpanStart(this.l);
            int spanEnd = this.m.getSpanEnd(this.l);
            if (spanStart > 0) {
                this.m.delete(spanStart, spanEnd);
            }
        }
        if (this.f22354k) {
            c.a.r0.q2.x.h.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.f22345b, O.i1().toString(), t1.mcn_lead_page, O.v1());
        } else {
            this.f22345b.setText(this.m);
        }
        this.f22345b.setLinkTextColor(SkinManager.getColor(c.a.r0.q2.f.CAM_X0304));
        h hVar = new h(this.m);
        this.o = hVar;
        this.f22345b.setOnTouchListener(hVar);
        this.f22348e.setOnClickListener(this.r);
        this.f22347d.setText(String.format(TbadkCoreApplication.getInst().getString(l.pb_video_header_play_count), StringHelper.numberUniformFormatExtra(t1.play_count.intValue())));
        if (fVar.g0() && fVar.r0()) {
            if (TextUtils.isEmpty(str)) {
                str = O.a0();
            }
            if (TextUtils.isEmpty(str) && (z1Var = (z1) ListUtils.getItem(fVar.p(), 0)) != null) {
                str = z1Var.f13108b;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f22350g.setVisibility(0);
                this.f22349f.setVisibility(0);
                this.f22349f.setOnClickListener(this.r);
                this.f22349f.setText(r0.d(str));
                this.f22349f.setTag(str);
            } else {
                this.f22349f.setVisibility(8);
                this.f22350g.setVisibility(8);
            }
            this.f22346c.setVisibility(8);
            this.f22351h.setData(fVar, O.B());
        } else {
            this.f22350g.setVisibility(8);
            this.f22349f.setVisibility(8);
            this.f22346c.setVisibility(0);
            this.f22346c.setText(String.format(TbadkCoreApplication.getInst().getString(l.pb_video_header_replay_num), StringHelper.numberUniformFormatExtra(O.V0())));
            this.f22351h.setVisibility(8);
        }
        o();
    }

    public final boolean n(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var)) == null) {
            if (d2Var == null || this.m == null || !d2Var.i() || StringUtils.isNull(d2Var.v1())) {
                return false;
            }
            String str = c.a.q0.s.e0.b.j().p("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + d2Var.v1();
            this.m.append((CharSequence) d2Var.k(new b(this, 2, str, str)));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f22348e, c.a.r0.q2.f.CAM_X0304, 1);
            SkinManager.setViewTextColor(this.f22345b, c.a.r0.q2.f.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f22346c, c.a.r0.q2.f.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f22347d, c.a.r0.q2.f.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f22349f, c.a.r0.q2.f.CAM_X0107, 1);
            SkinManager.setImageResource(this.f22350g, c.a.r0.q2.h.icon_common_arrow20_right_n);
            ThreadAgreeAndShareLayout threadAgreeAndShareLayout = this.f22351h;
            if (threadAgreeAndShareLayout != null) {
                threadAgreeAndShareLayout.onChangeSkin();
            }
        }
    }
}

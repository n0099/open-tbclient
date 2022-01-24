package c.a.t0.t2.x;

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
import c.a.s0.s.q.a2;
import c.a.s0.s.q.e2;
import c.a.t0.n4.h;
import c.a.t0.t2.i;
import c.a.t0.t2.l;
import c.a.t0.t2.u.f.s0;
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
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f23483b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23484c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f23485d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f23486e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f23487f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f23488g;

    /* renamed from: h  reason: collision with root package name */
    public ThreadAgreeAndShareLayout f23489h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f23490i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f23491j;
    public boolean k;
    public c.a.s0.s.k0.r.a l;
    public SpannableStringBuilder m;
    public SpannableStringBuilder n;
    public View.OnTouchListener o;
    public View.OnTouchListener p;
    public c.a.s0.f1.n.f q;
    public View.OnClickListener r;

    /* loaded from: classes8.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23492e;

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
            this.f23492e = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            int ellipsisCount;
            Object[] spans;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f23492e;
                if (cVar.f23483b == null || cVar.m == null || this.f23492e.k || (layout = this.f23492e.f23483b.getLayout()) == null) {
                    return;
                }
                if (this.f23492e.f23490i) {
                    if (this.f23492e.f23491j) {
                        return;
                    }
                    int lineCount = layout.getLineCount();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f23492e.f23486e.getLayoutParams();
                    if (this.f23492e.f23486e.getWidth() + layout.getLineWidth(lineCount - 1) > layout.getWidth()) {
                        layoutParams.addRule(3, i.view_video_title);
                        layoutParams.addRule(8, 0);
                    } else {
                        layoutParams.addRule(8, i.view_video_title);
                        layoutParams.addRule(3, 0);
                    }
                    this.f23492e.f23486e.setLayoutParams(layoutParams);
                    this.f23492e.f23491j = true;
                    return;
                }
                int lineCount2 = layout.getLineCount();
                if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                    if (this.f23492e.n == null) {
                        String spannableStringBuilder = this.f23492e.m.toString();
                        String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(spannableStringBuilder, StringHelper.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                        int length = cutChineseAndEnglishWithSuffix.length();
                        this.f23492e.n = new SpannableStringBuilder();
                        this.f23492e.n.append((CharSequence) cutChineseAndEnglishWithSuffix);
                        for (Object obj : this.f23492e.m.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                            int spanStart = this.f23492e.m.getSpanStart(obj);
                            int spanEnd = this.f23492e.m.getSpanEnd(obj);
                            if (spanStart < length && spanEnd >= length) {
                                break;
                            }
                            if (obj instanceof SpannableString) {
                                this.f23492e.n.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                            }
                        }
                        SpannableString spannableString = new SpannableString("...展开");
                        spannableString.setSpan(this.f23492e.q, 0, spannableString.length(), 17);
                        this.f23492e.n.insert(length, (CharSequence) spannableString);
                        c cVar2 = this.f23492e;
                        cVar2.p = new h(cVar2.n);
                    }
                    this.f23492e.f23486e.setVisibility(8);
                    c cVar3 = this.f23492e;
                    cVar3.f23483b.setOnTouchListener(cVar3.p);
                    c cVar4 = this.f23492e;
                    cVar4.f23483b.setText(cVar4.n);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends c.a.s0.f1.n.f {
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

        @Override // c.a.s0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.s0.m.a.v(TbadkCoreApplication.getInst().getApplicationContext(), false, this.l);
                TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "3"));
            }
        }

        @Override // c.a.s0.f1.n.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(c.a.t0.t2.f.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* renamed from: c.a.t0.t2.x.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1430c extends c.a.s0.f1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1430c(c cVar, int i2, String str) {
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

        @Override // c.a.s0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.l.f23490i = true;
                this.l.f23483b.setMaxLines(10);
                c cVar = this.l;
                cVar.f23483b.setOnTouchListener(new h(cVar.m));
                c cVar2 = this.l;
                cVar2.f23483b.setText(cVar2.m);
                this.l.f23486e.setVisibility(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23493e;

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
            this.f23493e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f23493e.f23487f) {
                    Object tag = this.f23493e.f23487f.getTag();
                    Context context = view.getContext();
                    if (!(tag instanceof String) || context == null) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                    return;
                }
                c cVar = this.f23493e;
                if (view == cVar.f23486e) {
                    cVar.f23490i = false;
                    c cVar2 = this.f23493e;
                    cVar2.f23483b.setOnTouchListener(cVar2.p);
                    c cVar3 = this.f23493e;
                    cVar3.f23483b.setText(cVar3.n);
                    this.f23493e.f23486e.setVisibility(8);
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
        this.q = new C1430c(this, 2, null);
        this.r = new d(this);
        if (view == null) {
            return;
        }
        this.a = view;
        TextView textView = (TextView) view.findViewById(i.view_video_title);
        this.f23483b = textView;
        textView.setTextSize(0, TbConfig.getContentSize());
        this.f23483b.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.f23483b.getPaint().setFakeBoldText(true);
        this.f23484c = (TextView) this.a.findViewById(i.pb_video_replay_num);
        this.f23485d = (TextView) this.a.findViewById(i.pb_video_play_count);
        this.f23486e = (TextView) this.a.findViewById(i.view_video_title_up);
        this.f23487f = (TextView) this.a.findViewById(i.pb_video_forum);
        this.f23489h = (ThreadAgreeAndShareLayout) this.a.findViewById(i.pb_video_act);
        this.f23488g = (TbImageView) this.a.findViewById(i.arrow_right);
        this.f23483b.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public void m(c.a.t0.t2.r.f fVar, String str) {
        e2 O;
        a2 a2Var;
        SpannableStringBuilder spannableStringBuilder;
        Layout j2;
        SpannableString c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, fVar, str) == null) || fVar == null || (O = fVar.O()) == null || O.u1() == null) {
            return;
        }
        O.g3();
        this.m = new SpannableStringBuilder(O.j1());
        boolean n = n(O);
        VideoInfo u1 = O.u1();
        if (!StringUtils.isNull(u1.mcn_lead_page) && !n) {
            this.k = true;
        } else {
            this.k = false;
        }
        if (this.m != null && !this.k && !n && (c2 = s0.c(O)) != null) {
            c.a.s0.s.k0.r.a[] aVarArr = (c.a.s0.s.k0.r.a[]) c2.getSpans(0, c2.length(), c.a.s0.s.k0.r.a.class);
            if (aVarArr != null && aVarArr.length > 0) {
                this.l = aVarArr[0];
            }
            this.m.append((CharSequence) c2);
        }
        if (this.l != null && (spannableStringBuilder = this.m) != null && (j2 = s0.j(spannableStringBuilder)) != null && j2.getLineCount() > 10) {
            int spanStart = this.m.getSpanStart(this.l);
            int spanEnd = this.m.getSpanEnd(this.l);
            if (spanStart > 0) {
                this.m.delete(spanStart, spanEnd);
            }
        }
        if (this.k) {
            c.a.t0.t2.x.h.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.f23483b, O.j1().toString(), u1.mcn_lead_page, O.w1());
        } else {
            this.f23483b.setText(this.m);
        }
        this.f23483b.setLinkTextColor(SkinManager.getColor(c.a.t0.t2.f.CAM_X0304));
        h hVar = new h(this.m);
        this.o = hVar;
        this.f23483b.setOnTouchListener(hVar);
        this.f23486e.setOnClickListener(this.r);
        this.f23485d.setText(String.format(TbadkCoreApplication.getInst().getString(l.pb_video_header_play_count), StringHelper.numberUniformFormatExtra(u1.play_count.intValue())));
        if (fVar.g0() && fVar.r0()) {
            if (TextUtils.isEmpty(str)) {
                str = O.b0();
            }
            if (TextUtils.isEmpty(str) && (a2Var = (a2) ListUtils.getItem(fVar.p(), 0)) != null) {
                str = a2Var.f13459b;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f23488g.setVisibility(0);
                this.f23487f.setVisibility(0);
                this.f23487f.setOnClickListener(this.r);
                this.f23487f.setText(s0.d(str));
                this.f23487f.setTag(str);
            } else {
                this.f23487f.setVisibility(8);
                this.f23488g.setVisibility(8);
            }
            this.f23484c.setVisibility(8);
            this.f23489h.setData(fVar, O.B());
        } else {
            this.f23488g.setVisibility(8);
            this.f23487f.setVisibility(8);
            this.f23484c.setVisibility(0);
            this.f23484c.setText(String.format(TbadkCoreApplication.getInst().getString(l.pb_video_header_replay_num), StringHelper.numberUniformFormatExtra(O.W0())));
            this.f23489h.setVisibility(8);
        }
        o();
    }

    public final boolean n(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2Var)) == null) {
            if (e2Var == null || this.m == null || !e2Var.i() || StringUtils.isNull(e2Var.w1())) {
                return false;
            }
            String str = c.a.s0.s.i0.b.k().q("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + e2Var.w1();
            this.m.append((CharSequence) e2Var.k(new b(this, 2, str, str)));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f23486e, c.a.t0.t2.f.CAM_X0304, 1);
            SkinManager.setViewTextColor(this.f23483b, c.a.t0.t2.f.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f23484c, c.a.t0.t2.f.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f23485d, c.a.t0.t2.f.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f23487f, c.a.t0.t2.f.CAM_X0107, 1);
            SkinManager.setImageResource(this.f23488g, c.a.t0.t2.h.icon_common_arrow20_right_n);
            ThreadAgreeAndShareLayout threadAgreeAndShareLayout = this.f23489h;
            if (threadAgreeAndShareLayout != null) {
                threadAgreeAndShareLayout.onChangeSkin();
            }
        }
    }
}

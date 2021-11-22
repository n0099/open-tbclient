package b.a.r0.k2.x;

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
import b.a.q0.s.q.d2;
import b.a.q0.s.q.z1;
import b.a.r0.d4.h;
import b.a.r0.k2.i;
import b.a.r0.k2.l;
import b.a.r0.k2.u.f.r0;
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
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f21203a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f21204b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f21205c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21206d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f21207e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21208f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f21209g;

    /* renamed from: h  reason: collision with root package name */
    public ThreadAgreeAndShareLayout f21210h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21211i;
    public boolean j;
    public boolean k;
    public b.a.q0.s.g0.r.a l;
    public SpannableStringBuilder m;
    public SpannableStringBuilder n;
    public View.OnTouchListener o;
    public View.OnTouchListener p;
    public b.a.q0.e1.n.f q;
    public View.OnClickListener r;

    /* loaded from: classes5.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21212e;

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
            this.f21212e = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            int ellipsisCount;
            Object[] spans;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f21212e;
                if (cVar.f21204b == null || cVar.m == null || this.f21212e.k || (layout = this.f21212e.f21204b.getLayout()) == null) {
                    return;
                }
                if (this.f21212e.f21211i) {
                    if (this.f21212e.j) {
                        return;
                    }
                    int lineCount = layout.getLineCount();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f21212e.f21207e.getLayoutParams();
                    if (this.f21212e.f21207e.getWidth() + layout.getLineWidth(lineCount - 1) > layout.getWidth()) {
                        layoutParams.addRule(3, i.view_video_title);
                        layoutParams.addRule(8, 0);
                    } else {
                        layoutParams.addRule(8, i.view_video_title);
                        layoutParams.addRule(3, 0);
                    }
                    this.f21212e.f21207e.setLayoutParams(layoutParams);
                    this.f21212e.j = true;
                    return;
                }
                int lineCount2 = layout.getLineCount();
                if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                    if (this.f21212e.n == null) {
                        String spannableStringBuilder = this.f21212e.m.toString();
                        String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(spannableStringBuilder, StringHelper.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                        int length = cutChineseAndEnglishWithSuffix.length();
                        this.f21212e.n = new SpannableStringBuilder();
                        this.f21212e.n.append((CharSequence) cutChineseAndEnglishWithSuffix);
                        for (Object obj : this.f21212e.m.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                            int spanStart = this.f21212e.m.getSpanStart(obj);
                            int spanEnd = this.f21212e.m.getSpanEnd(obj);
                            if (spanStart < length && spanEnd >= length) {
                                break;
                            }
                            if (obj instanceof SpannableString) {
                                this.f21212e.n.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                            }
                        }
                        SpannableString spannableString = new SpannableString("...展开");
                        spannableString.setSpan(this.f21212e.q, 0, spannableString.length(), 17);
                        this.f21212e.n.insert(length, (CharSequence) spannableString);
                        c cVar2 = this.f21212e;
                        cVar2.p = new h(cVar2.n);
                    }
                    this.f21212e.f21207e.setVisibility(8);
                    c cVar3 = this.f21212e;
                    cVar3.f21204b.setOnTouchListener(cVar3.p);
                    c cVar4 = this.f21212e;
                    cVar4.f21204b.setText(cVar4.n);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends b.a.q0.e1.n.f {
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

        @Override // b.a.q0.e1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.q0.m.a.v(TbadkCoreApplication.getInst().getApplicationContext(), false, this.l);
                TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "3"));
            }
        }

        @Override // b.a.q0.e1.n.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(b.a.r0.k2.f.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* renamed from: b.a.r0.k2.x.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1047c extends b.a.q0.e1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1047c(c cVar, int i2, String str) {
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

        @Override // b.a.q0.e1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.l.f21211i = true;
                this.l.f21204b.setMaxLines(10);
                c cVar = this.l;
                cVar.f21204b.setOnTouchListener(new h(cVar.m));
                c cVar2 = this.l;
                cVar2.f21204b.setText(cVar2.m);
                this.l.f21207e.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21213e;

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
            this.f21213e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f21213e.f21208f) {
                    Object tag = this.f21213e.f21208f.getTag();
                    Context context = view.getContext();
                    if (!(tag instanceof String) || context == null) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                    return;
                }
                c cVar = this.f21213e;
                if (view == cVar.f21207e) {
                    cVar.f21211i = false;
                    c cVar2 = this.f21213e;
                    cVar2.f21204b.setOnTouchListener(cVar2.p);
                    c cVar3 = this.f21213e;
                    cVar3.f21204b.setText(cVar3.n);
                    this.f21213e.f21207e.setVisibility(8);
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
        this.q = new C1047c(this, 2, null);
        this.r = new d(this);
        if (view == null) {
            return;
        }
        this.f21203a = view;
        TextView textView = (TextView) view.findViewById(i.view_video_title);
        this.f21204b = textView;
        textView.setTextSize(0, TbConfig.getContentSize());
        this.f21204b.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.f21204b.getPaint().setFakeBoldText(true);
        this.f21205c = (TextView) this.f21203a.findViewById(i.pb_video_replay_num);
        this.f21206d = (TextView) this.f21203a.findViewById(i.pb_video_play_count);
        this.f21207e = (TextView) this.f21203a.findViewById(i.view_video_title_up);
        this.f21208f = (TextView) this.f21203a.findViewById(i.pb_video_forum);
        this.f21210h = (ThreadAgreeAndShareLayout) this.f21203a.findViewById(i.pb_video_act);
        this.f21209g = (TbImageView) this.f21203a.findViewById(i.arrow_right);
        this.f21204b.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public void m(b.a.r0.k2.r.f fVar, String str) {
        d2 O;
        z1 z1Var;
        SpannableStringBuilder spannableStringBuilder;
        Layout j;
        SpannableString c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, fVar, str) == null) || fVar == null || (O = fVar.O()) == null || O.r1() == null) {
            return;
        }
        O.d3();
        this.m = new SpannableStringBuilder(O.h1());
        boolean n = n(O);
        VideoInfo r1 = O.r1();
        if (!StringUtils.isNull(r1.mcn_lead_page) && !n) {
            this.k = true;
        } else {
            this.k = false;
        }
        if (this.m != null && !this.k && !n && (c2 = r0.c(O)) != null) {
            b.a.q0.s.g0.r.a[] aVarArr = (b.a.q0.s.g0.r.a[]) c2.getSpans(0, c2.length(), b.a.q0.s.g0.r.a.class);
            if (aVarArr != null && aVarArr.length > 0) {
                this.l = aVarArr[0];
            }
            this.m.append((CharSequence) c2);
        }
        if (this.l != null && (spannableStringBuilder = this.m) != null && (j = r0.j(spannableStringBuilder)) != null && j.getLineCount() > 10) {
            int spanStart = this.m.getSpanStart(this.l);
            int spanEnd = this.m.getSpanEnd(this.l);
            if (spanStart > 0) {
                this.m.delete(spanStart, spanEnd);
            }
        }
        if (this.k) {
            b.a.r0.k2.x.h.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.f21204b, O.h1().toString(), r1.mcn_lead_page, O.t1());
        } else {
            this.f21204b.setText(this.m);
        }
        this.f21204b.setLinkTextColor(SkinManager.getColor(b.a.r0.k2.f.CAM_X0304));
        h hVar = new h(this.m);
        this.o = hVar;
        this.f21204b.setOnTouchListener(hVar);
        this.f21207e.setOnClickListener(this.r);
        this.f21206d.setText(String.format(TbadkCoreApplication.getInst().getString(l.pb_video_header_play_count), StringHelper.numberUniformFormatExtra(r1.play_count.intValue())));
        if (fVar.g0() && fVar.r0()) {
            if (TextUtils.isEmpty(str)) {
                str = O.Z();
            }
            if (TextUtils.isEmpty(str) && (z1Var = (z1) ListUtils.getItem(fVar.p(), 0)) != null) {
                str = z1Var.f14288b;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f21209g.setVisibility(0);
                this.f21208f.setVisibility(0);
                this.f21208f.setOnClickListener(this.r);
                this.f21208f.setText(r0.d(str));
                this.f21208f.setTag(str);
            } else {
                this.f21208f.setVisibility(8);
                this.f21209g.setVisibility(8);
            }
            this.f21205c.setVisibility(8);
            this.f21210h.setData(fVar, O.B());
        } else {
            this.f21209g.setVisibility(8);
            this.f21208f.setVisibility(8);
            this.f21205c.setVisibility(0);
            this.f21205c.setText(String.format(TbadkCoreApplication.getInst().getString(l.pb_video_header_replay_num), StringHelper.numberUniformFormatExtra(O.U0())));
            this.f21210h.setVisibility(8);
        }
        o();
    }

    public final boolean n(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var)) == null) {
            if (d2Var == null || this.m == null || !d2Var.i() || StringUtils.isNull(d2Var.t1())) {
                return false;
            }
            String str = b.a.q0.s.e0.b.j().p("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + d2Var.t1();
            this.m.append((CharSequence) d2Var.k(new b(this, 2, str, str)));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f21207e, b.a.r0.k2.f.CAM_X0304, 1);
            SkinManager.setViewTextColor(this.f21204b, b.a.r0.k2.f.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f21205c, b.a.r0.k2.f.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f21206d, b.a.r0.k2.f.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f21208f, b.a.r0.k2.f.CAM_X0107, 1);
            SkinManager.setImageResource(this.f21209g, b.a.r0.k2.h.icon_common_arrow20_right_n);
            ThreadAgreeAndShareLayout threadAgreeAndShareLayout = this.f21210h;
            if (threadAgreeAndShareLayout != null) {
                threadAgreeAndShareLayout.onChangeSkin();
            }
        }
    }
}

package c.a.q0.i2.n;

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
import c.a.p0.s.q.c2;
import c.a.p0.s.q.y1;
import c.a.q0.a4.h;
import c.a.q0.i2.k.e.o0;
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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.ThreadAgreeAndShareLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f19926a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f19927b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19928c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19929d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19930e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19931f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f19932g;

    /* renamed from: h  reason: collision with root package name */
    public ThreadAgreeAndShareLayout f19933h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19934i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f19935j;
    public boolean k;
    public c.a.p0.s.f0.r.a l;
    public SpannableStringBuilder m;
    public SpannableStringBuilder n;
    public View.OnTouchListener o;
    public View.OnTouchListener p;
    public c.a.p0.d1.m.e q;
    public View.OnClickListener r;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19936e;

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
            this.f19936e = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            int ellipsisCount;
            Object[] spans;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f19936e;
                if (cVar.f19927b == null || cVar.m == null || this.f19936e.k || (layout = this.f19936e.f19927b.getLayout()) == null) {
                    return;
                }
                if (this.f19936e.f19934i) {
                    if (this.f19936e.f19935j) {
                        return;
                    }
                    int lineCount = layout.getLineCount();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f19936e.f19930e.getLayoutParams();
                    if (this.f19936e.f19930e.getWidth() + layout.getLineWidth(lineCount - 1) > layout.getWidth()) {
                        layoutParams.addRule(3, R.id.view_video_title);
                        layoutParams.addRule(8, 0);
                    } else {
                        layoutParams.addRule(8, R.id.view_video_title);
                        layoutParams.addRule(3, 0);
                    }
                    this.f19936e.f19930e.setLayoutParams(layoutParams);
                    this.f19936e.f19935j = true;
                    return;
                }
                int lineCount2 = layout.getLineCount();
                if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                    if (this.f19936e.n == null) {
                        String spannableStringBuilder = this.f19936e.m.toString();
                        String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(spannableStringBuilder, StringHelper.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                        int length = cutChineseAndEnglishWithSuffix.length();
                        this.f19936e.n = new SpannableStringBuilder();
                        this.f19936e.n.append((CharSequence) cutChineseAndEnglishWithSuffix);
                        for (Object obj : this.f19936e.m.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                            int spanStart = this.f19936e.m.getSpanStart(obj);
                            int spanEnd = this.f19936e.m.getSpanEnd(obj);
                            if (spanStart < length && spanEnd >= length) {
                                break;
                            }
                            if (obj instanceof SpannableString) {
                                this.f19936e.n.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                            }
                        }
                        SpannableString spannableString = new SpannableString("...展开");
                        spannableString.setSpan(this.f19936e.q, 0, spannableString.length(), 17);
                        this.f19936e.n.insert(length, (CharSequence) spannableString);
                        c cVar2 = this.f19936e;
                        cVar2.p = new h(cVar2.n);
                    }
                    this.f19936e.f19930e.setVisibility(8);
                    c cVar3 = this.f19936e;
                    cVar3.f19927b.setOnTouchListener(cVar3.p);
                    c cVar4 = this.f19936e;
                    cVar4.f19927b.setText(cVar4.n);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c.a.p0.d1.m.e {
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

        @Override // c.a.p0.d1.m.e, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.p0.m.a.t(TbadkCoreApplication.getInst().getApplicationContext(), false, this.l);
                TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "3"));
            }
        }

        @Override // c.a.p0.d1.m.e, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* renamed from: c.a.q0.i2.n.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0939c extends c.a.p0.d1.m.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0939c(c cVar, int i2, String str) {
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

        @Override // c.a.p0.d1.m.e, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.l.f19934i = true;
                this.l.f19927b.setMaxLines(10);
                c cVar = this.l;
                cVar.f19927b.setOnTouchListener(new h(cVar.m));
                c cVar2 = this.l;
                cVar2.f19927b.setText(cVar2.m);
                this.l.f19930e.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19937e;

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
            this.f19937e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f19937e.f19931f) {
                    Object tag = this.f19937e.f19931f.getTag();
                    Context context = view.getContext();
                    if (!(tag instanceof String) || context == null) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                    return;
                }
                c cVar = this.f19937e;
                if (view == cVar.f19930e) {
                    cVar.f19934i = false;
                    c cVar2 = this.f19937e;
                    cVar2.f19927b.setOnTouchListener(cVar2.p);
                    c cVar3 = this.f19937e;
                    cVar3.f19927b.setText(cVar3.n);
                    this.f19937e.f19930e.setVisibility(8);
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
        this.q = new C0939c(this, 2, null);
        this.r = new d(this);
        if (view == null) {
            return;
        }
        this.f19926a = view;
        TextView textView = (TextView) view.findViewById(R.id.view_video_title);
        this.f19927b = textView;
        textView.setTextSize(0, TbConfig.getContentSize());
        this.f19927b.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.f19927b.getPaint().setFakeBoldText(true);
        this.f19928c = (TextView) this.f19926a.findViewById(R.id.pb_video_replay_num);
        this.f19929d = (TextView) this.f19926a.findViewById(R.id.pb_video_play_count);
        this.f19930e = (TextView) this.f19926a.findViewById(R.id.view_video_title_up);
        this.f19931f = (TextView) this.f19926a.findViewById(R.id.pb_video_forum);
        this.f19933h = (ThreadAgreeAndShareLayout) this.f19926a.findViewById(R.id.pb_video_act);
        this.f19932g = (TbImageView) this.f19926a.findViewById(R.id.arrow_right);
        this.f19927b.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public void m(c.a.q0.i2.h.e eVar, String str) {
        c2 O;
        y1 y1Var;
        SpannableStringBuilder spannableStringBuilder;
        Layout j2;
        SpannableString c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, eVar, str) == null) || eVar == null || (O = eVar.O()) == null || O.o1() == null) {
            return;
        }
        O.V2();
        this.m = new SpannableStringBuilder(O.e1());
        boolean n = n(O);
        VideoInfo o1 = O.o1();
        if (!StringUtils.isNull(o1.mcn_lead_page) && !n) {
            this.k = true;
        } else {
            this.k = false;
        }
        if (this.m != null && !this.k && !n && (c2 = o0.c(O)) != null) {
            c.a.p0.s.f0.r.a[] aVarArr = (c.a.p0.s.f0.r.a[]) c2.getSpans(0, c2.length(), c.a.p0.s.f0.r.a.class);
            if (aVarArr != null && aVarArr.length > 0) {
                this.l = aVarArr[0];
            }
            this.m.append((CharSequence) c2);
        }
        if (this.l != null && (spannableStringBuilder = this.m) != null && (j2 = o0.j(spannableStringBuilder)) != null && j2.getLineCount() > 10) {
            int spanStart = this.m.getSpanStart(this.l);
            int spanEnd = this.m.getSpanEnd(this.l);
            if (spanStart > 0) {
                this.m.delete(spanStart, spanEnd);
            }
        }
        if (this.k) {
            c.a.q0.i2.n.h.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.f19927b, O.e1().toString(), o1.mcn_lead_page, O.q1());
        } else {
            this.f19927b.setText(this.m);
        }
        this.f19927b.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        h hVar = new h(this.m);
        this.o = hVar;
        this.f19927b.setOnTouchListener(hVar);
        this.f19930e.setOnClickListener(this.r);
        this.f19929d.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), StringHelper.numberUniformFormatExtra(o1.play_count.intValue())));
        if (eVar.f0() && eVar.p0()) {
            if (TextUtils.isEmpty(str)) {
                str = O.Z();
            }
            if (TextUtils.isEmpty(str) && (y1Var = (y1) ListUtils.getItem(eVar.q(), 0)) != null) {
                str = y1Var.f14399b;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f19932g.setVisibility(0);
                this.f19931f.setVisibility(0);
                this.f19931f.setOnClickListener(this.r);
                this.f19931f.setText(o0.d(str));
                this.f19931f.setTag(str);
            } else {
                this.f19931f.setVisibility(8);
                this.f19932g.setVisibility(8);
            }
            this.f19928c.setVisibility(8);
            this.f19933h.setData(eVar, O.B());
        } else {
            this.f19932g.setVisibility(8);
            this.f19931f.setVisibility(8);
            this.f19928c.setVisibility(0);
            this.f19928c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), StringHelper.numberUniformFormatExtra(O.S0())));
            this.f19933h.setVisibility(8);
        }
        o();
    }

    public final boolean n(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c2Var)) == null) {
            if (c2Var == null || this.m == null || !c2Var.i() || StringUtils.isNull(c2Var.q1())) {
                return false;
            }
            String str = c.a.p0.s.d0.b.j().p("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + c2Var.q1();
            this.m.append((CharSequence) c2Var.k(new b(this, 2, str, str)));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f19930e, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(this.f19927b, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f19928c, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f19929d, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f19931f, R.color.CAM_X0107, 1);
            SkinManager.setImageResource(this.f19932g, R.drawable.icon_common_arrow20_right_n);
            ThreadAgreeAndShareLayout threadAgreeAndShareLayout = this.f19933h;
            if (threadAgreeAndShareLayout != null) {
                threadAgreeAndShareLayout.onChangeSkin();
            }
        }
    }
}

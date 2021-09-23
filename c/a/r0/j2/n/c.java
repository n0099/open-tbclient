package c.a.r0.j2.n;

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
import c.a.r0.b4.h;
import c.a.r0.j2.k.e.q0;
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
    public View f20505a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f20506b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20507c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f20508d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f20509e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20510f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f20511g;

    /* renamed from: h  reason: collision with root package name */
    public ThreadAgreeAndShareLayout f20512h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20513i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f20514j;
    public boolean k;
    public c.a.q0.s.f0.r.a l;
    public SpannableStringBuilder m;
    public SpannableStringBuilder n;
    public View.OnTouchListener o;
    public View.OnTouchListener p;
    public c.a.q0.f1.m.e q;
    public View.OnClickListener r;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20515e;

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
            this.f20515e = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            int ellipsisCount;
            Object[] spans;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f20515e;
                if (cVar.f20506b == null || cVar.m == null || this.f20515e.k || (layout = this.f20515e.f20506b.getLayout()) == null) {
                    return;
                }
                if (this.f20515e.f20513i) {
                    if (this.f20515e.f20514j) {
                        return;
                    }
                    int lineCount = layout.getLineCount();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f20515e.f20509e.getLayoutParams();
                    if (this.f20515e.f20509e.getWidth() + layout.getLineWidth(lineCount - 1) > layout.getWidth()) {
                        layoutParams.addRule(3, R.id.view_video_title);
                        layoutParams.addRule(8, 0);
                    } else {
                        layoutParams.addRule(8, R.id.view_video_title);
                        layoutParams.addRule(3, 0);
                    }
                    this.f20515e.f20509e.setLayoutParams(layoutParams);
                    this.f20515e.f20514j = true;
                    return;
                }
                int lineCount2 = layout.getLineCount();
                if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                    if (this.f20515e.n == null) {
                        String spannableStringBuilder = this.f20515e.m.toString();
                        String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(spannableStringBuilder, StringHelper.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                        int length = cutChineseAndEnglishWithSuffix.length();
                        this.f20515e.n = new SpannableStringBuilder();
                        this.f20515e.n.append((CharSequence) cutChineseAndEnglishWithSuffix);
                        for (Object obj : this.f20515e.m.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                            int spanStart = this.f20515e.m.getSpanStart(obj);
                            int spanEnd = this.f20515e.m.getSpanEnd(obj);
                            if (spanStart < length && spanEnd >= length) {
                                break;
                            }
                            if (obj instanceof SpannableString) {
                                this.f20515e.n.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                            }
                        }
                        SpannableString spannableString = new SpannableString("...展开");
                        spannableString.setSpan(this.f20515e.q, 0, spannableString.length(), 17);
                        this.f20515e.n.insert(length, (CharSequence) spannableString);
                        c cVar2 = this.f20515e;
                        cVar2.p = new h(cVar2.n);
                    }
                    this.f20515e.f20509e.setVisibility(8);
                    c cVar3 = this.f20515e;
                    cVar3.f20506b.setOnTouchListener(cVar3.p);
                    c cVar4 = this.f20515e;
                    cVar4.f20506b.setText(cVar4.n);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c.a.q0.f1.m.e {
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

        @Override // c.a.q0.f1.m.e, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.q0.m.a.s(TbadkCoreApplication.getInst().getApplicationContext(), false, this.l);
                TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "3"));
            }
        }

        @Override // c.a.q0.f1.m.e, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* renamed from: c.a.r0.j2.n.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0970c extends c.a.q0.f1.m.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0970c(c cVar, int i2, String str) {
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

        @Override // c.a.q0.f1.m.e, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.l.f20513i = true;
                this.l.f20506b.setMaxLines(10);
                c cVar = this.l;
                cVar.f20506b.setOnTouchListener(new h(cVar.m));
                c cVar2 = this.l;
                cVar2.f20506b.setText(cVar2.m);
                this.l.f20509e.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20516e;

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
            this.f20516e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f20516e.f20510f) {
                    Object tag = this.f20516e.f20510f.getTag();
                    Context context = view.getContext();
                    if (!(tag instanceof String) || context == null) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                    return;
                }
                c cVar = this.f20516e;
                if (view == cVar.f20509e) {
                    cVar.f20513i = false;
                    c cVar2 = this.f20516e;
                    cVar2.f20506b.setOnTouchListener(cVar2.p);
                    c cVar3 = this.f20516e;
                    cVar3.f20506b.setText(cVar3.n);
                    this.f20516e.f20509e.setVisibility(8);
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
        this.q = new C0970c(this, 2, null);
        this.r = new d(this);
        if (view == null) {
            return;
        }
        this.f20505a = view;
        TextView textView = (TextView) view.findViewById(R.id.view_video_title);
        this.f20506b = textView;
        textView.setTextSize(0, TbConfig.getContentSize());
        this.f20506b.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.f20506b.getPaint().setFakeBoldText(true);
        this.f20507c = (TextView) this.f20505a.findViewById(R.id.pb_video_replay_num);
        this.f20508d = (TextView) this.f20505a.findViewById(R.id.pb_video_play_count);
        this.f20509e = (TextView) this.f20505a.findViewById(R.id.view_video_title_up);
        this.f20510f = (TextView) this.f20505a.findViewById(R.id.pb_video_forum);
        this.f20512h = (ThreadAgreeAndShareLayout) this.f20505a.findViewById(R.id.pb_video_act);
        this.f20511g = (TbImageView) this.f20505a.findViewById(R.id.arrow_right);
        this.f20506b.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public void m(c.a.r0.j2.h.e eVar, String str) {
        d2 O;
        z1 z1Var;
        SpannableStringBuilder spannableStringBuilder;
        Layout j2;
        SpannableString c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, eVar, str) == null) || eVar == null || (O = eVar.O()) == null || O.q1() == null) {
            return;
        }
        O.b3();
        this.m = new SpannableStringBuilder(O.g1());
        boolean n = n(O);
        VideoInfo q1 = O.q1();
        if (!StringUtils.isNull(q1.mcn_lead_page) && !n) {
            this.k = true;
        } else {
            this.k = false;
        }
        if (this.m != null && !this.k && !n && (c2 = q0.c(O)) != null) {
            c.a.q0.s.f0.r.a[] aVarArr = (c.a.q0.s.f0.r.a[]) c2.getSpans(0, c2.length(), c.a.q0.s.f0.r.a.class);
            if (aVarArr != null && aVarArr.length > 0) {
                this.l = aVarArr[0];
            }
            this.m.append((CharSequence) c2);
        }
        if (this.l != null && (spannableStringBuilder = this.m) != null && (j2 = q0.j(spannableStringBuilder)) != null && j2.getLineCount() > 10) {
            int spanStart = this.m.getSpanStart(this.l);
            int spanEnd = this.m.getSpanEnd(this.l);
            if (spanStart > 0) {
                this.m.delete(spanStart, spanEnd);
            }
        }
        if (this.k) {
            c.a.r0.j2.n.h.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.f20506b, O.g1().toString(), q1.mcn_lead_page, O.s1());
        } else {
            this.f20506b.setText(this.m);
        }
        this.f20506b.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        h hVar = new h(this.m);
        this.o = hVar;
        this.f20506b.setOnTouchListener(hVar);
        this.f20509e.setOnClickListener(this.r);
        this.f20508d.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_play_count), StringHelper.numberUniformFormatExtra(q1.play_count.intValue())));
        if (eVar.f0() && eVar.p0()) {
            if (TextUtils.isEmpty(str)) {
                str = O.Z();
            }
            if (TextUtils.isEmpty(str) && (z1Var = (z1) ListUtils.getItem(eVar.q(), 0)) != null) {
                str = z1Var.f14374b;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f20511g.setVisibility(0);
                this.f20510f.setVisibility(0);
                this.f20510f.setOnClickListener(this.r);
                this.f20510f.setText(q0.d(str));
                this.f20510f.setTag(str);
            } else {
                this.f20510f.setVisibility(8);
                this.f20511g.setVisibility(8);
            }
            this.f20507c.setVisibility(8);
            this.f20512h.setData(eVar, O.B());
        } else {
            this.f20511g.setVisibility(8);
            this.f20510f.setVisibility(8);
            this.f20507c.setVisibility(0);
            this.f20507c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.pb_video_header_replay_num), StringHelper.numberUniformFormatExtra(O.U0())));
            this.f20512h.setVisibility(8);
        }
        o();
    }

    public final boolean n(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var)) == null) {
            if (d2Var == null || this.m == null || !d2Var.i() || StringUtils.isNull(d2Var.s1())) {
                return false;
            }
            String str = c.a.q0.s.d0.b.j().p("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + d2Var.s1();
            this.m.append((CharSequence) d2Var.k(new b(this, 2, str, str)));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f20509e, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(this.f20506b, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f20507c, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f20508d, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f20510f, R.color.CAM_X0107, 1);
            SkinManager.setImageResource(this.f20511g, R.drawable.icon_common_arrow20_right_n);
            ThreadAgreeAndShareLayout threadAgreeAndShareLayout = this.f20512h;
            if (threadAgreeAndShareLayout != null) {
                threadAgreeAndShareLayout.onChangeSkin();
            }
        }
    }
}

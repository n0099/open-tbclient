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
import b.a.r0.c4.h;
import b.a.r0.k2.i;
import b.a.r0.k2.l;
import b.a.r0.k2.u.f.q0;
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
    public View f19666a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f19667b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19668c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19669d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19670e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19671f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f19672g;

    /* renamed from: h  reason: collision with root package name */
    public ThreadAgreeAndShareLayout f19673h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19674i;
    public boolean j;
    public boolean k;
    public b.a.q0.s.g0.r.a l;
    public SpannableStringBuilder m;
    public SpannableStringBuilder n;
    public View.OnTouchListener o;
    public View.OnTouchListener p;
    public b.a.q0.f1.n.f q;
    public View.OnClickListener r;

    /* loaded from: classes5.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19675e;

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
            this.f19675e = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            int ellipsisCount;
            Object[] spans;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.f19675e;
                if (cVar.f19667b == null || cVar.m == null || this.f19675e.k || (layout = this.f19675e.f19667b.getLayout()) == null) {
                    return;
                }
                if (this.f19675e.f19674i) {
                    if (this.f19675e.j) {
                        return;
                    }
                    int lineCount = layout.getLineCount();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f19675e.f19670e.getLayoutParams();
                    if (this.f19675e.f19670e.getWidth() + layout.getLineWidth(lineCount - 1) > layout.getWidth()) {
                        layoutParams.addRule(3, i.view_video_title);
                        layoutParams.addRule(8, 0);
                    } else {
                        layoutParams.addRule(8, i.view_video_title);
                        layoutParams.addRule(3, 0);
                    }
                    this.f19675e.f19670e.setLayoutParams(layoutParams);
                    this.f19675e.j = true;
                    return;
                }
                int lineCount2 = layout.getLineCount();
                if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                    if (this.f19675e.n == null) {
                        String spannableStringBuilder = this.f19675e.m.toString();
                        String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(spannableStringBuilder, StringHelper.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                        int length = cutChineseAndEnglishWithSuffix.length();
                        this.f19675e.n = new SpannableStringBuilder();
                        this.f19675e.n.append((CharSequence) cutChineseAndEnglishWithSuffix);
                        for (Object obj : this.f19675e.m.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                            int spanStart = this.f19675e.m.getSpanStart(obj);
                            int spanEnd = this.f19675e.m.getSpanEnd(obj);
                            if (spanStart < length && spanEnd >= length) {
                                break;
                            }
                            if (obj instanceof SpannableString) {
                                this.f19675e.n.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                            }
                        }
                        SpannableString spannableString = new SpannableString("...展开");
                        spannableString.setSpan(this.f19675e.q, 0, spannableString.length(), 17);
                        this.f19675e.n.insert(length, (CharSequence) spannableString);
                        c cVar2 = this.f19675e;
                        cVar2.p = new h(cVar2.n);
                    }
                    this.f19675e.f19670e.setVisibility(8);
                    c cVar3 = this.f19675e;
                    cVar3.f19667b.setOnTouchListener(cVar3.p);
                    c cVar4 = this.f19675e;
                    cVar4.f19667b.setText(cVar4.n);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends b.a.q0.f1.n.f {
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

        @Override // b.a.q0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.q0.m.a.u(TbadkCoreApplication.getInst().getApplicationContext(), false, this.l);
                TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "3"));
            }
        }

        @Override // b.a.q0.f1.n.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
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
    public class C0978c extends b.a.q0.f1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0978c(c cVar, int i2, String str) {
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

        @Override // b.a.q0.f1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.l.f19674i = true;
                this.l.f19667b.setMaxLines(10);
                c cVar = this.l;
                cVar.f19667b.setOnTouchListener(new h(cVar.m));
                c cVar2 = this.l;
                cVar2.f19667b.setText(cVar2.m);
                this.l.f19670e.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19676e;

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
            this.f19676e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f19676e.f19671f) {
                    Object tag = this.f19676e.f19671f.getTag();
                    Context context = view.getContext();
                    if (!(tag instanceof String) || context == null) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                    return;
                }
                c cVar = this.f19676e;
                if (view == cVar.f19670e) {
                    cVar.f19674i = false;
                    c cVar2 = this.f19676e;
                    cVar2.f19667b.setOnTouchListener(cVar2.p);
                    c cVar3 = this.f19676e;
                    cVar3.f19667b.setText(cVar3.n);
                    this.f19676e.f19670e.setVisibility(8);
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
        this.q = new C0978c(this, 2, null);
        this.r = new d(this);
        if (view == null) {
            return;
        }
        this.f19666a = view;
        TextView textView = (TextView) view.findViewById(i.view_video_title);
        this.f19667b = textView;
        textView.setTextSize(0, TbConfig.getContentSize());
        this.f19667b.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.f19667b.getPaint().setFakeBoldText(true);
        this.f19668c = (TextView) this.f19666a.findViewById(i.pb_video_replay_num);
        this.f19669d = (TextView) this.f19666a.findViewById(i.pb_video_play_count);
        this.f19670e = (TextView) this.f19666a.findViewById(i.view_video_title_up);
        this.f19671f = (TextView) this.f19666a.findViewById(i.pb_video_forum);
        this.f19673h = (ThreadAgreeAndShareLayout) this.f19666a.findViewById(i.pb_video_act);
        this.f19672g = (TbImageView) this.f19666a.findViewById(i.arrow_right);
        this.f19667b.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public void m(b.a.r0.k2.r.f fVar, String str) {
        d2 O;
        z1 z1Var;
        SpannableStringBuilder spannableStringBuilder;
        Layout j;
        SpannableString c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, fVar, str) == null) || fVar == null || (O = fVar.O()) == null || O.q1() == null) {
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
            b.a.q0.s.g0.r.a[] aVarArr = (b.a.q0.s.g0.r.a[]) c2.getSpans(0, c2.length(), b.a.q0.s.g0.r.a.class);
            if (aVarArr != null && aVarArr.length > 0) {
                this.l = aVarArr[0];
            }
            this.m.append((CharSequence) c2);
        }
        if (this.l != null && (spannableStringBuilder = this.m) != null && (j = q0.j(spannableStringBuilder)) != null && j.getLineCount() > 10) {
            int spanStart = this.m.getSpanStart(this.l);
            int spanEnd = this.m.getSpanEnd(this.l);
            if (spanStart > 0) {
                this.m.delete(spanStart, spanEnd);
            }
        }
        if (this.k) {
            b.a.r0.k2.x.h.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.f19667b, O.g1().toString(), q1.mcn_lead_page, O.s1());
        } else {
            this.f19667b.setText(this.m);
        }
        this.f19667b.setLinkTextColor(SkinManager.getColor(b.a.r0.k2.f.CAM_X0304));
        h hVar = new h(this.m);
        this.o = hVar;
        this.f19667b.setOnTouchListener(hVar);
        this.f19670e.setOnClickListener(this.r);
        this.f19669d.setText(String.format(TbadkCoreApplication.getInst().getString(l.pb_video_header_play_count), StringHelper.numberUniformFormatExtra(q1.play_count.intValue())));
        if (fVar.g0() && fVar.r0()) {
            if (TextUtils.isEmpty(str)) {
                str = O.Z();
            }
            if (TextUtils.isEmpty(str) && (z1Var = (z1) ListUtils.getItem(fVar.p(), 0)) != null) {
                str = z1Var.f13506b;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f19672g.setVisibility(0);
                this.f19671f.setVisibility(0);
                this.f19671f.setOnClickListener(this.r);
                this.f19671f.setText(q0.d(str));
                this.f19671f.setTag(str);
            } else {
                this.f19671f.setVisibility(8);
                this.f19672g.setVisibility(8);
            }
            this.f19668c.setVisibility(8);
            this.f19673h.setData(fVar, O.B());
        } else {
            this.f19672g.setVisibility(8);
            this.f19671f.setVisibility(8);
            this.f19668c.setVisibility(0);
            this.f19668c.setText(String.format(TbadkCoreApplication.getInst().getString(l.pb_video_header_replay_num), StringHelper.numberUniformFormatExtra(O.U0())));
            this.f19673h.setVisibility(8);
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
            String str = b.a.q0.s.e0.b.j().p("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + d2Var.s1();
            this.m.append((CharSequence) d2Var.k(new b(this, 2, str, str)));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f19670e, b.a.r0.k2.f.CAM_X0304, 1);
            SkinManager.setViewTextColor(this.f19667b, b.a.r0.k2.f.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f19668c, b.a.r0.k2.f.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f19669d, b.a.r0.k2.f.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f19671f, b.a.r0.k2.f.CAM_X0107, 1);
            SkinManager.setImageResource(this.f19672g, b.a.r0.k2.h.icon_common_arrow20_right_n);
            ThreadAgreeAndShareLayout threadAgreeAndShareLayout = this.f19673h;
            if (threadAgreeAndShareLayout != null) {
                threadAgreeAndShareLayout.onChangeSkin();
            }
        }
    }
}

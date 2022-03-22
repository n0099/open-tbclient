package c.a.p0.w2.p;

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
import c.a.o0.r.r.x1;
import c.a.p0.q4.i;
import c.a.p0.w2.m.f.y0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
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
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f20415b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20416c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f20417d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f20418e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20419f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f20420g;

    /* renamed from: h  reason: collision with root package name */
    public ThreadAgreeAndShareLayout f20421h;
    public boolean i;
    public boolean j;
    public boolean k;
    public c.a.o0.r.l0.r.a l;
    public SpannableStringBuilder m;
    public SpannableStringBuilder n;
    public View.OnTouchListener o;
    public View.OnTouchListener p;
    public c.a.o0.e1.n.f q;
    public View.OnClickListener r;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Layout layout;
            int ellipsisCount;
            Object[] spans;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c cVar = this.a;
                if (cVar.f20415b == null || cVar.m == null || this.a.k || (layout = this.a.f20415b.getLayout()) == null) {
                    return;
                }
                if (this.a.i) {
                    if (this.a.j) {
                        return;
                    }
                    int lineCount = layout.getLineCount();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.f20418e.getLayoutParams();
                    if (this.a.f20418e.getWidth() + layout.getLineWidth(lineCount - 1) > layout.getWidth()) {
                        layoutParams.addRule(3, R.id.obfuscated_res_0x7f0923e2);
                        layoutParams.addRule(8, 0);
                    } else {
                        layoutParams.addRule(8, R.id.obfuscated_res_0x7f0923e2);
                        layoutParams.addRule(3, 0);
                    }
                    this.a.f20418e.setLayoutParams(layoutParams);
                    this.a.j = true;
                    return;
                }
                int lineCount2 = layout.getLineCount();
                if (lineCount2 >= 2 && (ellipsisCount = layout.getEllipsisCount(lineCount2 - 1)) != 0) {
                    if (this.a.n == null) {
                        String spannableStringBuilder = this.a.m.toString();
                        String cutChineseAndEnglishWithSuffix = StringHelper.cutChineseAndEnglishWithSuffix(spannableStringBuilder, StringHelper.getChineseAndEnglishLength(spannableStringBuilder.substring(0, spannableStringBuilder.length() - ellipsisCount)) - 6, "");
                        int length = cutChineseAndEnglishWithSuffix.length();
                        this.a.n = new SpannableStringBuilder();
                        this.a.n.append((CharSequence) cutChineseAndEnglishWithSuffix);
                        for (Object obj : this.a.m.getSpans(length, spannableStringBuilder.length(), Object.class)) {
                            int spanStart = this.a.m.getSpanStart(obj);
                            int spanEnd = this.a.m.getSpanEnd(obj);
                            if (spanStart < length && spanEnd >= length) {
                                break;
                            }
                            if (obj instanceof SpannableString) {
                                this.a.n.setSpan(obj, spanStart, spanEnd, ((SpannableString) obj).getSpanFlags(obj));
                            }
                        }
                        SpannableString spannableString = new SpannableString("...展开");
                        spannableString.setSpan(this.a.q, 0, spannableString.length(), 17);
                        this.a.n.insert(length, (CharSequence) spannableString);
                        c cVar2 = this.a;
                        cVar2.p = new i(cVar2.n);
                    }
                    this.a.f20418e.setVisibility(8);
                    c cVar3 = this.a;
                    cVar3.f20415b.setOnTouchListener(cVar3.p);
                    c cVar4 = this.a;
                    cVar4.f20415b.setText(cVar4.n);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c.a.o0.e1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f20422h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, int i, String str, String str2) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i), str, str2};
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
            this.f20422h = str2;
        }

        @Override // c.a.o0.e1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.o0.l.a.v(TbadkCoreApplication.getInst().getApplicationContext(), false, this.f20422h);
                TiebaStatic.log(new StatisticItem("c12841").param("obj_source", "3"));
            }
        }

        @Override // c.a.o0.e1.n.f, android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(TbadkCoreApplication.getInst().getApplicationContext().getResources().getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* renamed from: c.a.p0.w2.p.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1523c extends c.a.o0.e1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f20423h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1523c(c cVar, int i, String str) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i), str};
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
            this.f20423h = cVar;
        }

        @Override // c.a.o0.e1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20423h.i = true;
                this.f20423h.f20415b.setMaxLines(10);
                c cVar = this.f20423h;
                cVar.f20415b.setOnTouchListener(new i(cVar.m));
                c cVar2 = this.f20423h;
                cVar2.f20415b.setText(cVar2.m);
                this.f20423h.f20418e.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.a.f20419f) {
                    Object tag = this.a.f20419f.getTag();
                    Context context = view.getContext();
                    if (!(tag instanceof String) || context == null) {
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(context).createNormalCfg((String) tag, null)));
                    return;
                }
                c cVar = this.a;
                if (view == cVar.f20418e) {
                    cVar.i = false;
                    c cVar2 = this.a;
                    cVar2.f20415b.setOnTouchListener(cVar2.p);
                    c cVar3 = this.a;
                    cVar3.f20415b.setText(cVar3.n);
                    this.a.f20418e.setVisibility(8);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new C1523c(this, 2, null);
        this.r = new d(this);
        if (view == null) {
            return;
        }
        this.a = view;
        TextView textView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0923e2);
        this.f20415b = textView;
        textView.setTextSize(0, TbConfig.getContentSize());
        this.f20415b.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.f20415b.getPaint().setFakeBoldText(true);
        this.f20416c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091749);
        this.f20417d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091747);
        this.f20418e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0923e3);
        this.f20419f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09173d);
        this.f20421h = (ThreadAgreeAndShareLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091733);
        this.f20420g = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0902a8);
        this.f20415b.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public void m(c.a.p0.w2.i.f fVar, String str) {
        ThreadData O;
        x1 x1Var;
        SpannableStringBuilder spannableStringBuilder;
        Layout j;
        SpannableString c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, fVar, str) == null) || fVar == null || (O = fVar.O()) == null || O.getThreadVideoInfo() == null) {
            return;
        }
        O.parserTitleFrsForTop();
        this.m = new SpannableStringBuilder(O.getSpan_str());
        boolean n = n(O);
        VideoInfo threadVideoInfo = O.getThreadVideoInfo();
        if (!StringUtils.isNull(threadVideoInfo.mcn_lead_page) && !n) {
            this.k = true;
        } else {
            this.k = false;
        }
        if (this.m != null && !this.k && !n && (c2 = y0.c(O)) != null) {
            c.a.o0.r.l0.r.a[] aVarArr = (c.a.o0.r.l0.r.a[]) c2.getSpans(0, c2.length(), c.a.o0.r.l0.r.a.class);
            if (aVarArr != null && aVarArr.length > 0) {
                this.l = aVarArr[0];
            }
            this.m.append((CharSequence) c2);
        }
        if (this.l != null && (spannableStringBuilder = this.m) != null && (j = y0.j(spannableStringBuilder)) != null && j.getLineCount() > 10) {
            int spanStart = this.m.getSpanStart(this.l);
            int spanEnd = this.m.getSpanEnd(this.l);
            if (spanStart > 0) {
                this.m.delete(spanStart, spanEnd);
            }
        }
        if (this.k) {
            c.a.p0.w2.p.h.a.a(TbadkCoreApplication.getInst().getApplicationContext(), this.f20415b, O.getSpan_str().toString(), threadVideoInfo.mcn_lead_page, O.getTid());
        } else {
            this.f20415b.setText(this.m);
        }
        this.f20415b.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        i iVar = new i(this.m);
        this.o = iVar;
        this.f20415b.setOnTouchListener(iVar);
        this.f20418e.setOnClickListener(this.r);
        this.f20417d.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0dc7), StringHelper.numberUniformFormatExtra(threadVideoInfo.play_count.intValue())));
        if (fVar.g0() && fVar.r0()) {
            if (TextUtils.isEmpty(str)) {
                str = O.getForum_name();
            }
            if (TextUtils.isEmpty(str) && (x1Var = (x1) ListUtils.getItem(fVar.p(), 0)) != null) {
                str = x1Var.f10991b;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f20420g.setVisibility(0);
                this.f20419f.setVisibility(0);
                this.f20419f.setOnClickListener(this.r);
                this.f20419f.setText(y0.d(str));
                this.f20419f.setTag(str);
            } else {
                this.f20419f.setVisibility(8);
                this.f20420g.setVisibility(8);
            }
            this.f20416c.setVisibility(8);
            this.f20421h.setData(fVar, O.getAgreeData());
        } else {
            this.f20420g.setVisibility(8);
            this.f20419f.setVisibility(8);
            this.f20416c.setVisibility(0);
            this.f20416c.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0dc8), StringHelper.numberUniformFormatExtra(O.getReply_num())));
            this.f20421h.setVisibility(8);
        }
        o();
    }

    public final boolean n(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData)) == null) {
            if (threadData == null || this.m == null || !threadData.canShowNaniTail() || StringUtils.isNull(threadData.getTid())) {
                return false;
            }
            String str = c.a.o0.r.j0.b.k().q("nani_key_pre_h5_link", TbConfig.NANI_DEFAULT_H5_PREFIX) + "/" + threadData.getTid();
            this.m.append((CharSequence) threadData.generateNaniTail(new b(this, 2, str, str)));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.f20418e, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(this.f20415b, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.f20416c, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f20417d, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f20419f, R.color.CAM_X0107, 1);
            SkinManager.setImageResource(this.f20420g, R.drawable.icon_common_arrow20_right_n);
            ThreadAgreeAndShareLayout threadAgreeAndShareLayout = this.f20421h;
            if (threadAgreeAndShareLayout != null) {
                threadAgreeAndShareLayout.j();
            }
        }
    }
}

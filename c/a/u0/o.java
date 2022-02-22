package c.a.u0;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
@JvmName(name = "PrivacyPolicyDialogUtil")
/* loaded from: classes8.dex */
public final class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class a extends n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f20038e;

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20038e = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, widget) == null) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                c.a.t0.m.a.j(this.f20038e, "http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b extends n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f20039e;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20039e = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, widget) == null) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                c.a.t0.m.a.j(this.f20039e, "https://gsp0.baidu.com/5aAHeD3nKhI2p27j8IqW0jdnxx1xbK/tb/eula.html");
            }
        }
    }

    public static final c.a.t0.s.t.a a(TbPageContext<?> tbPageContext, View.OnClickListener listener, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65536, null, tbPageContext, listener, i2, i3)) == null) {
            Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
            Intrinsics.checkNotNullParameter(listener, "listener");
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.privacy_prolicy_guide_dialog, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(tbPageContext.pageA…olicy_guide_dialog, null)");
            EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.title);
            eMTextView.setText(R.string.secret_hint_head);
            c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(eMTextView);
            d2.A(R.string.F_X02);
            d2.z(R.dimen.T_X05);
            EMTextView eMTextView2 = (EMTextView) inflate.findViewById(R.id.content);
            eMTextView2.setHighlightColor(0);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = tbPageContext.getString(i2);
            Intrinsics.checkNotNullExpressionValue(string, "tbPageContext.getString(contentTestResId)");
            String format = String.format(string, Arrays.copyOf(new Object[]{tbPageContext.getString(R.string.privacy_policy_text), tbPageContext.getString(R.string.user_protocol_text)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            Activity pageActivity = tbPageContext.getPageActivity();
            Intrinsics.checkNotNullExpressionValue(pageActivity, "tbPageContext.pageActivity");
            SpannableString d3 = d(pageActivity, format);
            eMTextView2.setMovementMethod(LinkMovementMethod.getInstance());
            eMTextView2.setText(d3);
            c.a.t0.s.v.c.d(eMTextView2).z(R.dimen.T_X07);
            EMTextView eMTextView3 = (EMTextView) inflate.findViewById(R.id.browseBtn);
            eMTextView3.setText(i3);
            c.a.t0.s.v.c.d(eMTextView3).z(R.dimen.T_X08);
            eMTextView3.setOnClickListener(listener);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.yesBtn);
            tBSpecificationBtn.setText(tbPageContext.getString(R.string.secret_hint_agree_and_go_on));
            tBSpecificationBtn.setTextSize(R.dimen.T_X07);
            c.a.t0.s.l0.n.b bVar = new c.a.t0.s.l0.n.b();
            bVar.p(R.color.CAM_X0303, R.color.CAM_X0101);
            tBSpecificationBtn.setConfig(bVar);
            tBSpecificationBtn.setOnClickListener(listener);
            c.a.t0.s.t.a aVar = new c.a.t0.s.t.a(tbPageContext.getPageActivity());
            aVar.setContentView(inflate);
            aVar.setContentViewSize(8);
            aVar.setAutoNight(false);
            aVar.setCanceledOnTouchOutside(false);
            aVar.setCancelable(false);
            aVar.create(tbPageContext);
            return aVar;
        }
        return (c.a.t0.s.t.a) invokeLLII.objValue;
    }

    public static final c.a.t0.s.t.a b(TbPageContext<?> tbPageContext, View.OnClickListener listener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbPageContext, listener)) == null) {
            Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
            Intrinsics.checkNotNullParameter(listener, "listener");
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(tbPageContext.pageA…rivate_hint_dialog, null)");
            ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
            inflate.findViewById(R.id.protocol_layout).setVisibility(0);
            TextView textView = (TextView) inflate.findViewById(R.id.protocol_scrollable_textview);
            textView.setHighlightColor(0);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = tbPageContext.getString(R.string.secret_hint_format);
            Intrinsics.checkNotNullExpressionValue(string, "tbPageContext.getString(…tring.secret_hint_format)");
            String format = String.format(string, Arrays.copyOf(new Object[]{tbPageContext.getString(R.string.secret_hint_footer), tbPageContext.getString(R.string.secret_hint_title), tbPageContext.getString(R.string.secret_hint_content_1), tbPageContext.getString(R.string.secret_hint_content_2), tbPageContext.getString(R.string.secret_hint_content_3), tbPageContext.getString(R.string.secret_hint_content_4), tbPageContext.getString(R.string.secret_hint_content_5)}, 7));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            Activity pageActivity = tbPageContext.getPageActivity();
            Intrinsics.checkNotNullExpressionValue(pageActivity, "tbPageContext.pageActivity");
            SpannableString d2 = d(pageActivity, format);
            Matcher matcher = Pattern.compile("\n\n").matcher(format);
            while (matcher.find()) {
                d2.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
            }
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(d2);
            TextView textView2 = (TextView) inflate.findViewById(R.id.private_no);
            textView2.setOnClickListener(listener);
            int i2 = R.color.CAM_X0110;
            SkinManager.setViewTextColorSelector(textView2, i2, i2, 0);
            TextView textView3 = (TextView) inflate.findViewById(R.id.private_yes);
            textView3.setOnClickListener(listener);
            c.a.t0.s.v.c d3 = c.a.t0.s.v.c.d(textView3);
            d3.n(R.string.J_X01);
            d3.f(R.color.CAM_X0303);
            SkinManager.setViewTextColorSelector(textView3, R.color.CAM_X0101, R.color.CAM_X0618, 0);
            c.a.t0.s.t.a aVar = new c.a.t0.s.t.a(tbPageContext.getPageActivity());
            aVar.setContentView(inflate);
            aVar.setContentViewSize(7);
            aVar.setCanceledOnTouchOutside(false);
            aVar.setAutoNight(false);
            aVar.setCancelable(false);
            aVar.create(tbPageContext);
            return aVar;
        }
        return (c.a.t0.s.t.a) invokeLL.objValue;
    }

    public static final int[] c(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
            String string = TbadkCoreApplication.getInst().getString(i2);
            Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(patternTextResId)");
            int[] iArr = {StringsKt__StringsKt.indexOf$default((CharSequence) str, string, 0, false, 6, (Object) null), iArr[0] + string.length()};
            return iArr;
        }
        return (int[]) invokeLI.objValue;
    }

    public static final SpannableString d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            SpannableString spannableString = new SpannableString(str);
            int[] c2 = c(str, R.string.privacy_policy_text);
            if (c2[0] != -1) {
                spannableString.setSpan(new a(context), c2[0], c2[1], 18);
            }
            int[] c3 = c(str, R.string.user_protocol_text);
            if (c3[0] != -1) {
                spannableString.setSpan(new b(context), c3[0], c3[1], 18);
            }
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }
}

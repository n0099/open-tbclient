package c.a.r0.k3.h0;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.q0.s.s.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static c.a.e.e.g.c f21001a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.k3.h0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0991a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f21002e;

        public C0991a(TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21002e = tbPageContext;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.f21002e.getPageActivity(), true, 23004, "remind");
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_BUBBLE_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                TiebaStatic.log(TbadkCoreStatisticKey.REMIND_EXPIRED);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements c.a.e.e.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f21003a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f21004b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SpannableString f21005c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f21006d;

        /* renamed from: c.a.r0.k3.h0.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0992a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f21007e;

            public View$OnClickListenerC0992a(c cVar) {
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
                this.f21007e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (a.f21001a != null) {
                        a.f21001a.d();
                    }
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.f21007e.f21003a.getPageActivity(), true, 23004, "expiring");
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_BUBBLE_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                }
            }
        }

        public c(TbPageContext tbPageContext, boolean z, SpannableString spannableString, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, Boolean.valueOf(z), spannableString, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21003a = tbPageContext;
            this.f21004b = z;
            this.f21005c = spannableString;
            this.f21006d = i2;
        }

        @Override // c.a.e.e.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21004b ? 4 : 2 : invokeV.intValue;
        }

        @Override // c.a.e.e.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f21004b ? 32 : 16 : invokeV.intValue;
        }

        @Override // c.a.e.e.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                TextView textView = new TextView(this.f21003a.getPageActivity());
                if (this.f21004b) {
                    textView.setBackgroundResource(R.drawable.pop_float_top);
                } else {
                    textView.setBackgroundResource(R.drawable.pop_float);
                }
                int dimensionPixelSize = this.f21003a.getResources().getDimensionPixelSize(R.dimen.ds32);
                int dimensionPixelSize2 = this.f21003a.getResources().getDimensionPixelSize(R.dimen.ds22);
                if (this.f21004b) {
                    textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
                } else {
                    textView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize);
                }
                textView.setGravity(17);
                textView.setText(this.f21005c);
                textView.setCompoundDrawablePadding(dimensionPixelSize);
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(this.f21006d), (Drawable) null);
                textView.setOnClickListener(new View$OnClickListenerC0992a(this));
                return textView;
            }
            return (View) invokeL.objValue;
        }

        @Override // c.a.e.e.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21004b ? 0 : 4 : invokeV.intValue;
        }

        @Override // c.a.e.e.g.b
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f21004b ? 5 : 30 : invokeV.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f21008e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f21009f;

        public d(TbPageContext tbPageContext, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21008e = tbPageContext;
            this.f21009f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.d(this.f21008e.getPageActivity(), this.f21009f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || a.f21001a == null) {
                return;
            }
            a.f21001a.d();
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void onRefresh();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v8, resolved type: c.a.e.e.g.d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r12v7 */
    public static void c(TbPageContext tbPageContext, View view, boolean z, f fVar) {
        int i2;
        SpannableString spannableString;
        ?? r12;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{tbPageContext, view, Boolean.valueOf(z), fVar}) == null) && TbadkCoreApplication.getInst().appResponseToIntentClass(MemberPayActivityConfig.class)) {
            long defaultBubbleEndTime = TbadkCoreApplication.getInst().getDefaultBubbleEndTime();
            if (defaultBubbleEndTime <= 0) {
                return;
            }
            long currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis >= defaultBubbleEndTime) {
                MessageManager.getInstance().runTask(2001283, TbPageContext.class, tbPageContext);
                TbadkCoreApplication.getInst().setDefaultBubble(null);
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(0);
                if (fVar != null) {
                    fVar.onRefresh();
                }
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(tbPageContext.getPageActivity());
                aVar.setCanceledOnTouchOutside(false);
                View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.bubble_free_dialog_content, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.tip1);
                TextView textView2 = (TextView) inflate.findViewById(R.id.tip2);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0105, 1);
                textView.setText(tbPageContext.getPageActivity().getString(R.string.bubble_ended_tip));
                textView2.setText(tbPageContext.getPageActivity().getString(R.string.bubble_ended_tip2));
                textView2.setTextSize(0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.fontsize32));
                aVar.setContentView(inflate);
                aVar.setPositiveButton(R.string.open_now, new C0991a(tbPageContext));
                aVar.setNegativeButton(R.string.group_create_private_isee, new b());
                aVar.create(tbPageContext);
                aVar.show();
                return;
            }
            long j2 = (defaultBubbleEndTime - currentTimeMillis) / 86400;
            if (j2 > 3 || j2 < 0) {
                return;
            }
            if (System.currentTimeMillis() / 86400000 == c.a.q0.s.d0.b.j().l("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), 0L)) {
                return;
            }
            int i3 = R.color.CAM_X0111;
            int i4 = R.color.CAM_X0305;
            int i5 = R.drawable.pop_float_arrow;
            if (i2 == 0) {
                if (new Date(currentTimeMillis).getDay() == new Date(defaultBubbleEndTime).getDay()) {
                    spannableString = new SpannableString(tbPageContext.getPageActivity().getString(R.string.bubble_end_time_tip_today));
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(i3)), 0, spannableString.length(), 34);
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(i4)), 9, 13, 34);
                } else {
                    spannableString = new SpannableString(String.format(tbPageContext.getPageActivity().getString(R.string.bubble_end_time_tip), 1));
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(i3)), 0, spannableString.length(), 34);
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(i4)), 10, 14, 34);
                }
                r12 = 0;
            } else {
                String string = tbPageContext.getPageActivity().getString(R.string.bubble_end_time_tip);
                Long valueOf = Long.valueOf(j2);
                r12 = 0;
                spannableString = new SpannableString(String.format(string, valueOf));
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(i3)), 0, spannableString.length(), 34);
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(i4)), 10, 14, 34);
            }
            c.a.e.e.g.d dVar = new c.a.e.e.g.d();
            dVar.j(view);
            dVar.c(r12);
            dVar.i(r12);
            dVar.a(new c(tbPageContext, z, spannableString, i5));
            dVar.d(true);
            dVar.h(r12);
            f21001a = dVar.b();
            new Handler().postDelayed(new d(tbPageContext, z), 1000L);
            c.a.q0.s.d0.b.j().w("bubble_time@" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis() / 86400000);
        }
    }

    public static void d(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, null, activity, z) == null) {
            c.a.e.e.g.c cVar = f21001a;
            if (cVar != null) {
                cVar.m(activity);
            }
            if (z) {
                return;
            }
            new Handler().postDelayed(new e(), 5000L);
        }
    }
}

package c.a.o0.s.d;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.g;
import c.a.d.f.p.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.service.SignAlertReceiver;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.auth.NTLMEngineImpl;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes2.dex */
public class e implements c.a.o0.s.d.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final long f11308b;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.o0.e1.q.a.f.b a;

    /* loaded from: classes2.dex */
    public class a implements c.a.o0.e1.q.a.d.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f11309b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f11310c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f11311d;

        public a(e eVar, Activity activity, TbPageContext tbPageContext, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, activity, tbPageContext, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11311d = eVar;
            this.a = activity;
            this.f11309b = tbPageContext;
            this.f11310c = viewGroup;
        }

        @Override // c.a.o0.e1.q.a.d.f
        public void a(Date date, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, date, view) == null) || date == null) {
                return;
            }
            boolean z = false;
            if ("frs.FrsActivity".equals(this.a.getLocalClassName()) && c.a.o0.r.j0.b.k().h("first_call_attention", true)) {
                c.a.o0.r.j0.b.k().u("first_call_attention", false);
                if (!NotificationManagerCompat.from(this.f11309b.getPageActivity()).areNotificationsEnabled()) {
                    z = true;
                }
            }
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001223, date));
                c.a.o0.s.h.a.f(this.f11309b, new boolean[]{true, false}, 2);
                return;
            }
            this.f11311d.i(true);
            d.d().V(date.getHours(), date.getMinutes());
            this.f11311d.e(this.a, this.f11310c);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.a.o0.e1.q.a.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f11312b;

        /* loaded from: classes2.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                    return true;
                }
                return invokeLL.booleanValue;
            }
        }

        /* renamed from: c.a.o0.s.d.e$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC0850b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public View$OnClickListenerC0850b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.a.f11312b.a != null) {
                        this.a.f11312b.a.A();
                        this.a.f11312b.a.f();
                    }
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_OK_CLICK);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    if (c.a.o0.s.h.a.e(TbadkCoreApplication.getInst(), 0)) {
                        c.a.o0.s.h.a.g(this.a.a, 5, 0L);
                    }
                }
            }
        }

        /* loaded from: classes2.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public c(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.a.f11312b.a != null) {
                        this.a.f11312b.a.f();
                    }
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_CLOSE_CLICK);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                }
            }
        }

        public b(e eVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11312b = eVar;
            this.a = tbPageContext;
        }

        @Override // c.a.o0.e1.q.a.d.a
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                View findViewById = view.findViewById(R.id.obfuscated_res_0x7f0911c8);
                View findViewById2 = view.findViewById(R.id.obfuscated_res_0x7f0911c3);
                View findViewById3 = view.findViewById(R.id.obfuscated_res_0x7f0911c4);
                TextView textView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0907bb);
                ImageView imageView = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f09079a);
                SkinManager.setBackgroundResource(findViewById2, R.color.CAM_X0211);
                SkinManager.setBackgroundResource(findViewById3, R.drawable.pic_frs_popup_sign);
                SkinManager.setViewTextColor(textView, (int) R.color.select_topbar_icon_white_color_tint);
                SkinManager.setImageResource(imageView, R.drawable.selector_topbar_close_white);
                SkinManager.setViewTextColor((TextView) view.findViewById(R.id.obfuscated_res_0x7f09221e), (int) R.color.CAM_X0101);
                View findViewById4 = view.findViewById(R.id.obfuscated_res_0x7f0911d2);
                SkinManager.setBackgroundColor(findViewById4, R.color.CAM_X0211);
                SkinManager.setViewTextColor((TextView) view.findViewById(R.id.obfuscated_res_0x7f09221c), (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor((TextView) view.findViewById(R.id.obfuscated_res_0x7f091d06), (int) R.color.CAM_X0105);
                SkinManager.setBackgroundColor((LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f092000), R.color.CAM_X0211);
                a aVar = new a(this);
                findViewById.setOnTouchListener(aVar);
                findViewById4.setOnTouchListener(aVar);
                textView.setOnClickListener(new View$OnClickListenerC0850b(this));
                imageView.setOnClickListener(new c(this));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(963606949, "Lc/a/o0/s/d/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(963606949, "Lc/a/o0/s/d/e;");
                return;
            }
        }
        f11308b = StringHelper.MS_TO_MIN * 1;
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.o0.s.d.a
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbadkSettings.getInst().loadBoolean("alert_sign_on", false) : invokeV.booleanValue;
    }

    @Override // c.a.o0.s.d.a
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int loadInt = TbadkSettings.getInst().loadInt("alert_sign_mins", -1);
            if (loadInt == -1) {
                m();
                return TbadkSettings.getInst().loadInt("alert_sign_mins", 30);
            }
            return loadInt;
        }
        return invokeV.intValue;
    }

    @Override // c.a.o0.s.d.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            AlarmManager alarmManager = (AlarmManager) inst.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent k = k();
            if (a()) {
                Calendar calendar = Calendar.getInstance();
                int h2 = h();
                int i = calendar.get(11);
                int b2 = b();
                int i2 = calendar.get(12);
                calendar.set(11, h2);
                calendar.set(12, b2);
                calendar.set(13, 0);
                calendar.set(14, 0);
                if (i >= h2 && (i != h2 || i2 >= b2)) {
                    calendar.set(6, calendar.get(6) + 1);
                }
                alarmManager.set(1, calendar.getTimeInMillis(), PendingIntent.getBroadcast(inst, 0, k, 134217728));
                return;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(inst, 0, k, NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
            if (broadcast != null) {
                alarmManager.cancel(broadcast);
            }
        }
    }

    @Override // c.a.o0.s.d.a
    public Dialog d(TbPageContext tbPageContext, c.a.o0.e1.q.a.d.f fVar) {
        InterceptResult invokeLL;
        Activity pageActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, tbPageContext, fVar)) == null) {
            if (tbPageContext == null || (pageActivity = tbPageContext.getPageActivity()) == null || !g.e(pageActivity)) {
                return null;
            }
            Calendar calendar = Calendar.getInstance();
            int i = d.d().i();
            int j = d.d().j();
            if (i > 0 && j > 0) {
                calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), i, j);
            } else {
                calendar.setTimeInMillis(System.currentTimeMillis() + f11308b);
            }
            c.a.o0.e1.q.a.b.a aVar = new c.a.o0.e1.q.a.b.a(pageActivity, fVar);
            aVar.g(calendar);
            aVar.k(R.layout.obfuscated_res_0x7f0d023b, new b(this, tbPageContext));
            aVar.f(18);
            aVar.p(new boolean[]{false, false, false, true, true, false});
            aVar.j("年", "月", "日", "时", "分", "秒");
            aVar.l(2.0f);
            aVar.o(0, 0, 0, 0, 0, 0);
            aVar.b(false);
            aVar.i(SkinManager.getColor(R.color.CAM_X0204));
            aVar.m(SkinManager.getColor(R.color.CAM_X0105));
            aVar.n(SkinManager.getColor(R.color.CAM_X0109));
            aVar.d(SkinManager.getColor(R.color.black_alpha30));
            aVar.e(SkinManager.getColor(R.color.CAM_X0211));
            c.a.o0.e1.q.a.f.b a2 = aVar.a();
            this.a = a2;
            a2.u();
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SIGN_REMIND_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            return this.a.j();
        }
        return (Dialog) invokeLL.objValue;
    }

    @Override // c.a.o0.s.d.a
    public NavigationBarCoverTip e(Activity activity, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, activity, viewGroup)) == null) {
            if (activity == null || viewGroup == null) {
                return null;
            }
            View findViewById = viewGroup.findViewById(R.id.obfuscated_res_0x7f0914f7);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            NavigationBarCoverTip navigationBarCoverTip = new NavigationBarCoverTip(activity);
            navigationBarCoverTip.setId(R.id.obfuscated_res_0x7f0914f7);
            viewGroup.addView(navigationBarCoverTip, new RelativeLayout.LayoutParams(-1, -2));
            TextView textView = new TextView(activity);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            textView.setMinHeight(l(R.dimen.tbds112));
            int l = l(R.dimen.tbds20);
            textView.setPadding(l, 0, l, 0);
            textView.setGravity(17);
            textView.setTextSize(0, l(R.dimen.tbfontsize42));
            textView.setLineSpacing(l(R.dimen.obfuscated_res_0x7f0701d4), 1.0f);
            textView.setText(activity.getString(R.string.obfuscated_res_0x7f0f1163));
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundColor(navigationBarCoverTip, R.color.cp_link_tip_a_alpha95);
            navigationBarCoverTip.l(activity, textView);
            return navigationBarCoverTip;
        }
        return (NavigationBarCoverTip) invokeLL.objValue;
    }

    @Override // c.a.o0.s.d.a
    public void f(TbPageContext tbPageContext, ViewGroup viewGroup) {
        Activity pageActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, tbPageContext, viewGroup) == null) || tbPageContext == null || (pageActivity = tbPageContext.getPageActivity()) == null || !g.e(pageActivity) || d.d().A() || c.a.o0.r.j0.b.k().l("sign_time_set_dialog", 0) > 0) {
            return;
        }
        d(tbPageContext, new a(this, pageActivity, tbPageContext, viewGroup));
        c.a.o0.r.j0.b.k().w("sign_time_set_dialog", 1);
    }

    @Override // c.a.o0.s.d.a
    public void g(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            TbadkSettings.getInst().saveInt("alert_sign_hours", i);
            TbadkSettings.getInst().saveInt("alert_sign_mins", i2);
            c();
        }
    }

    @Override // c.a.o0.s.d.a
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int loadInt = TbadkSettings.getInst().loadInt("alert_sign_hours", -1);
            if (loadInt == -1) {
                m();
                return TbadkSettings.getInst().loadInt("alert_sign_hours", 12);
            }
            return loadInt;
        }
        return invokeV.intValue;
    }

    @Override // c.a.o0.s.d.a
    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            TbadkSettings.getInst().saveBoolean("alert_sign_on", z);
            c();
        }
    }

    public Intent k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Intent intent = new Intent(TbConfig.getBroadcastActionSignAlert());
            intent.setData(Uri.parse("tieba_sign://alert"));
            intent.setClass(TbadkCoreApplication.getInst(), SignAlertReceiver.class);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    public final int l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) ? n.f(TbadkCoreApplication.getInst(), i) : invokeI.intValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis() + f11308b);
            g(calendar.get(11), calendar.get(12));
        }
    }
}

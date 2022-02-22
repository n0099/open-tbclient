package c.a.u0.e1.c3;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import c.a.u0.e1.c1;
import c.a.u0.e1.d1;
import c.a.u0.e1.e1;
import c.a.u0.e1.i1;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f16278e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16279f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f16280g;

    /* renamed from: h  reason: collision with root package name */
    public View f16281h;

    /* renamed from: i  reason: collision with root package name */
    public PopupWindow f16282i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f16283j;
    public Runnable k;

    /* renamed from: c.a.u0.e1.c3.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1034a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16284e;

        /* renamed from: c.a.u0.e1.c3.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1035a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ RunnableC1034a f16285e;

            public RunnableC1035a(RunnableC1034a runnableC1034a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1034a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16285e = runnableC1034a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16285e.f16284e.f16282i == null) {
                    return;
                }
                this.f16285e.f16284e.j();
            }
        }

        public RunnableC1034a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16284e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16284e.f16280g == null || this.f16284e.f16281h == null) {
                return;
            }
            Activity pageActivity = this.f16284e.f16280g.getPageActivity();
            int f2 = c.a.d.f.p.n.f(pageActivity, d1.ds64);
            a aVar = this.f16284e;
            View h2 = aVar.h(pageActivity, aVar.f16278e);
            int[] iArr = new int[2];
            this.f16284e.f16281h.getLocationInWindow(iArr);
            int f3 = c.a.d.f.p.n.f(pageActivity, d1.ds32);
            int f4 = (iArr[1] - f2) + c.a.d.f.p.n.f(pageActivity, d1.ds16);
            this.f16284e.f16282i = new PopupWindow(h2, -2, f2);
            this.f16284e.f16282i.showAtLocation(this.f16284e.f16281h, 53, f3, f4);
            this.f16284e.f16283j.postDelayed(new RunnableC1035a(this), 3000L);
        }
    }

    public a(TbPageContext tbPageContext, boolean z) {
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
        this.f16278e = i1.attention_post_update_tip;
        this.f16283j = new Handler();
        this.k = new RunnableC1034a(this);
        this.f16280g = tbPageContext;
        this.f16279f = z;
    }

    public final View h(Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, activity, i2)) == null) {
            TextView textView = new TextView(activity);
            int f2 = c.a.d.f.p.n.f(activity, d1.ds20);
            textView.setPadding(f2, 0 - activity.getResources().getDimensionPixelSize(d1.ds12), f2, 0);
            textView.setHeight(activity.getResources().getDimensionPixelSize(d1.ds76));
            textView.setGravity(17);
            textView.setTextSize(0, c.a.d.f.p.n.f(activity, d1.fontsize28));
            textView.setText(i2);
            textView.setOnClickListener(this);
            SkinManager.setBackgroundResource(textView, e1.bg_tip_blue_left);
            SkinManager.setViewTextColor(textView, c1.CAM_X0101);
            textView.setOnClickListener(this);
            return textView;
        }
        return (View) invokeLI.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f16283j.removeCallbacksAndMessages(null);
            j();
        }
    }

    public void j() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (popupWindow = this.f16282i) == null) {
            return;
        }
        popupWindow.dismiss();
        this.f16282i = null;
    }

    public void k(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (this.f16280g == null || view == null || StringUtils.isNull(currentAccount)) {
                return;
            }
            this.f16281h = view;
            if (this.f16279f) {
                this.f16278e = i1.attention_post_update_tip;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int l = c.a.t0.s.j0.b.k().l(str, 0);
                if (l >= 3) {
                    this.f16279f = false;
                    return;
                }
                c.a.t0.s.j0.b.k().w(str, l + 1);
                this.f16279f = false;
                this.f16283j.postDelayed(this.k, 500L);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            j();
        }
    }
}

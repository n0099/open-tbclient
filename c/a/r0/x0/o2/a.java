package c.a.r0.x0.o2;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f27556e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27557f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f27558g;

    /* renamed from: h  reason: collision with root package name */
    public View f27559h;

    /* renamed from: i  reason: collision with root package name */
    public PopupWindow f27560i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f27561j;
    public Runnable k;

    /* renamed from: c.a.r0.x0.o2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1293a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27562e;

        /* renamed from: c.a.r0.x0.o2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1294a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ RunnableC1293a f27563e;

            public RunnableC1294a(RunnableC1293a runnableC1293a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1293a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f27563e = runnableC1293a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f27563e.f27562e.f27560i == null) {
                    return;
                }
                this.f27563e.f27562e.j();
            }
        }

        public RunnableC1293a(a aVar) {
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
            this.f27562e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f27562e.f27558g == null || this.f27562e.f27559h == null) {
                return;
            }
            Activity pageActivity = this.f27562e.f27558g.getPageActivity();
            int g2 = c.a.e.e.p.l.g(pageActivity, R.dimen.ds64);
            a aVar = this.f27562e;
            View h2 = aVar.h(pageActivity, aVar.f27556e);
            int[] iArr = new int[2];
            this.f27562e.f27559h.getLocationInWindow(iArr);
            int g3 = c.a.e.e.p.l.g(pageActivity, R.dimen.ds32);
            int g4 = (iArr[1] - g2) + c.a.e.e.p.l.g(pageActivity, R.dimen.ds16);
            this.f27562e.f27560i = new PopupWindow(h2, -2, g2);
            this.f27562e.f27560i.showAtLocation(this.f27562e.f27559h, 53, g3, g4);
            this.f27562e.f27561j.postDelayed(new RunnableC1294a(this), 3000L);
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
        this.f27556e = R.string.attention_post_update_tip;
        this.f27561j = new Handler();
        this.k = new RunnableC1293a(this);
        this.f27558g = tbPageContext;
        this.f27557f = z;
    }

    public final View h(Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, activity, i2)) == null) {
            TextView textView = new TextView(activity);
            int g2 = c.a.e.e.p.l.g(activity, R.dimen.ds20);
            textView.setPadding(g2, 0 - activity.getResources().getDimensionPixelSize(R.dimen.ds12), g2, 0);
            textView.setHeight(activity.getResources().getDimensionPixelSize(R.dimen.ds76));
            textView.setGravity(17);
            textView.setTextSize(0, c.a.e.e.p.l.g(activity, R.dimen.fontsize28));
            textView.setText(i2);
            textView.setOnClickListener(this);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_tip_blue_left);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
            textView.setOnClickListener(this);
            return textView;
        }
        return (View) invokeLI.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f27561j.removeCallbacksAndMessages(null);
            j();
        }
    }

    public void j() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (popupWindow = this.f27560i) == null) {
            return;
        }
        popupWindow.dismiss();
        this.f27560i = null;
    }

    public void k(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (this.f27558g == null || view == null || StringUtils.isNull(currentAccount)) {
                return;
            }
            this.f27559h = view;
            if (this.f27557f) {
                this.f27556e = R.string.attention_post_update_tip;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int k = c.a.q0.s.d0.b.j().k(str, 0);
                if (k >= 3) {
                    this.f27557f = false;
                    return;
                }
                c.a.q0.s.d0.b.j().v(str, k + 1);
                this.f27557f = false;
                this.f27561j.postDelayed(this.k, 500L);
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

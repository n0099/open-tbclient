package c.a.r0.d1.s2;

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
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f16311e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16312f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f16313g;

    /* renamed from: h  reason: collision with root package name */
    public View f16314h;

    /* renamed from: i  reason: collision with root package name */
    public PopupWindow f16315i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f16316j;
    public Runnable k;

    /* renamed from: c.a.r0.d1.s2.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1043a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16317e;

        /* renamed from: c.a.r0.d1.s2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1044a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ RunnableC1043a f16318e;

            public RunnableC1044a(RunnableC1043a runnableC1043a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1043a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16318e = runnableC1043a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16318e.f16317e.f16315i == null) {
                    return;
                }
                this.f16318e.f16317e.j();
            }
        }

        public RunnableC1043a(a aVar) {
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
            this.f16317e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16317e.f16313g == null || this.f16317e.f16314h == null) {
                return;
            }
            Activity pageActivity = this.f16317e.f16313g.getPageActivity();
            int f2 = c.a.d.f.p.n.f(pageActivity, R.dimen.ds64);
            a aVar = this.f16317e;
            View h2 = aVar.h(pageActivity, aVar.f16311e);
            int[] iArr = new int[2];
            this.f16317e.f16314h.getLocationInWindow(iArr);
            int f3 = c.a.d.f.p.n.f(pageActivity, R.dimen.ds32);
            int f4 = (iArr[1] - f2) + c.a.d.f.p.n.f(pageActivity, R.dimen.ds16);
            this.f16317e.f16315i = new PopupWindow(h2, -2, f2);
            this.f16317e.f16315i.showAtLocation(this.f16317e.f16314h, 53, f3, f4);
            this.f16317e.f16316j.postDelayed(new RunnableC1044a(this), 3000L);
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
        this.f16311e = R.string.attention_post_update_tip;
        this.f16316j = new Handler();
        this.k = new RunnableC1043a(this);
        this.f16313g = tbPageContext;
        this.f16312f = z;
    }

    public final View h(Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, activity, i2)) == null) {
            TextView textView = new TextView(activity);
            int f2 = c.a.d.f.p.n.f(activity, R.dimen.ds20);
            textView.setPadding(f2, 0 - activity.getResources().getDimensionPixelSize(R.dimen.ds12), f2, 0);
            textView.setHeight(activity.getResources().getDimensionPixelSize(R.dimen.ds76));
            textView.setGravity(17);
            textView.setTextSize(0, c.a.d.f.p.n.f(activity, R.dimen.fontsize28));
            textView.setText(i2);
            textView.setOnClickListener(this);
            SkinManager.setBackgroundResource(textView, R.drawable.bg_tip_blue_left);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            textView.setOnClickListener(this);
            return textView;
        }
        return (View) invokeLI.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f16316j.removeCallbacksAndMessages(null);
            j();
        }
    }

    public void j() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (popupWindow = this.f16315i) == null) {
            return;
        }
        popupWindow.dismiss();
        this.f16315i = null;
    }

    public void k(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (this.f16313g == null || view == null || StringUtils.isNull(currentAccount)) {
                return;
            }
            this.f16314h = view;
            if (this.f16312f) {
                this.f16311e = R.string.attention_post_update_tip;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int l = c.a.q0.r.j0.b.k().l(str, 0);
                if (l >= 3) {
                    this.f16312f = false;
                    return;
                }
                c.a.q0.r.j0.b.k().w(str, l + 1);
                this.f16312f = false;
                this.f16316j.postDelayed(this.k, 500L);
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

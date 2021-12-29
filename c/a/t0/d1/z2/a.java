package c.a.t0.d1.z2;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.e1;
import c.a.t0.d1.i1;
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
    public int f17349e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f17350f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f17351g;

    /* renamed from: h  reason: collision with root package name */
    public View f17352h;

    /* renamed from: i  reason: collision with root package name */
    public PopupWindow f17353i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f17354j;

    /* renamed from: k  reason: collision with root package name */
    public Runnable f17355k;

    /* renamed from: c.a.t0.d1.z2.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1059a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17356e;

        /* renamed from: c.a.t0.d1.z2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1060a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ RunnableC1059a f17357e;

            public RunnableC1060a(RunnableC1059a runnableC1059a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1059a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f17357e = runnableC1059a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17357e.f17356e.f17353i == null) {
                    return;
                }
                this.f17357e.f17356e.j();
            }
        }

        public RunnableC1059a(a aVar) {
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
            this.f17356e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17356e.f17351g == null || this.f17356e.f17352h == null) {
                return;
            }
            Activity pageActivity = this.f17356e.f17351g.getPageActivity();
            int f2 = c.a.d.f.p.n.f(pageActivity, d1.ds64);
            a aVar = this.f17356e;
            View h2 = aVar.h(pageActivity, aVar.f17349e);
            int[] iArr = new int[2];
            this.f17356e.f17352h.getLocationInWindow(iArr);
            int f3 = c.a.d.f.p.n.f(pageActivity, d1.ds32);
            int f4 = (iArr[1] - f2) + c.a.d.f.p.n.f(pageActivity, d1.ds16);
            this.f17356e.f17353i = new PopupWindow(h2, -2, f2);
            this.f17356e.f17353i.showAtLocation(this.f17356e.f17352h, 53, f3, f4);
            this.f17356e.f17354j.postDelayed(new RunnableC1060a(this), 3000L);
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
        this.f17349e = i1.attention_post_update_tip;
        this.f17354j = new Handler();
        this.f17355k = new RunnableC1059a(this);
        this.f17351g = tbPageContext;
        this.f17350f = z;
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
            this.f17354j.removeCallbacksAndMessages(null);
            j();
        }
    }

    public void j() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (popupWindow = this.f17353i) == null) {
            return;
        }
        popupWindow.dismiss();
        this.f17353i = null;
    }

    public void k(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (this.f17351g == null || view == null || StringUtils.isNull(currentAccount)) {
                return;
            }
            this.f17352h = view;
            if (this.f17350f) {
                this.f17349e = i1.attention_post_update_tip;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int k2 = c.a.s0.s.g0.b.j().k(str, 0);
                if (k2 >= 3) {
                    this.f17350f = false;
                    return;
                }
                c.a.s0.s.g0.b.j().v(str, k2 + 1);
                this.f17350f = false;
                this.f17354j.postDelayed(this.f17355k, 500L);
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

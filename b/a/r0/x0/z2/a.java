package b.a.r0.x0.z2;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import b.a.r0.x0.i1;
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
/* loaded from: classes6.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f28413e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28414f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f28415g;

    /* renamed from: h  reason: collision with root package name */
    public View f28416h;

    /* renamed from: i  reason: collision with root package name */
    public PopupWindow f28417i;
    public Handler j;
    public Runnable k;

    /* renamed from: b.a.r0.x0.z2.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1389a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28418e;

        /* renamed from: b.a.r0.x0.z2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1390a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ RunnableC1389a f28419e;

            public RunnableC1390a(RunnableC1389a runnableC1389a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1389a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f28419e = runnableC1389a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f28419e.f28418e.f28417i == null) {
                    return;
                }
                this.f28419e.f28418e.j();
            }
        }

        public RunnableC1389a(a aVar) {
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
            this.f28418e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f28418e.f28415g == null || this.f28418e.f28416h == null) {
                return;
            }
            Activity pageActivity = this.f28418e.f28415g.getPageActivity();
            int g2 = b.a.e.f.p.l.g(pageActivity, d1.ds64);
            a aVar = this.f28418e;
            View h2 = aVar.h(pageActivity, aVar.f28413e);
            int[] iArr = new int[2];
            this.f28418e.f28416h.getLocationInWindow(iArr);
            int g3 = b.a.e.f.p.l.g(pageActivity, d1.ds32);
            int g4 = (iArr[1] - g2) + b.a.e.f.p.l.g(pageActivity, d1.ds16);
            this.f28418e.f28417i = new PopupWindow(h2, -2, g2);
            this.f28418e.f28417i.showAtLocation(this.f28418e.f28416h, 53, g3, g4);
            this.f28418e.j.postDelayed(new RunnableC1390a(this), 3000L);
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
        this.f28413e = i1.attention_post_update_tip;
        this.j = new Handler();
        this.k = new RunnableC1389a(this);
        this.f28415g = tbPageContext;
        this.f28414f = z;
    }

    public final View h(Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, activity, i2)) == null) {
            TextView textView = new TextView(activity);
            int g2 = b.a.e.f.p.l.g(activity, d1.ds20);
            textView.setPadding(g2, 0 - activity.getResources().getDimensionPixelSize(d1.ds12), g2, 0);
            textView.setHeight(activity.getResources().getDimensionPixelSize(d1.ds76));
            textView.setGravity(17);
            textView.setTextSize(0, b.a.e.f.p.l.g(activity, d1.fontsize28));
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
            this.j.removeCallbacksAndMessages(null);
            j();
        }
    }

    public void j() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (popupWindow = this.f28417i) == null) {
            return;
        }
        popupWindow.dismiss();
        this.f28417i = null;
    }

    public void k(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (this.f28415g == null || view == null || StringUtils.isNull(currentAccount)) {
                return;
            }
            this.f28416h = view;
            if (this.f28414f) {
                this.f28413e = i1.attention_post_update_tip;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int k = b.a.q0.s.e0.b.j().k(str, 0);
                if (k >= 3) {
                    this.f28414f = false;
                    return;
                }
                b.a.q0.s.e0.b.j().v(str, k + 1);
                this.f28414f = false;
                this.j.postDelayed(this.k, 500L);
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

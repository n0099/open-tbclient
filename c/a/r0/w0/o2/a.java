package c.a.r0.w0.o2;

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
    public int f27380e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27381f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f27382g;

    /* renamed from: h  reason: collision with root package name */
    public View f27383h;

    /* renamed from: i  reason: collision with root package name */
    public PopupWindow f27384i;

    /* renamed from: j  reason: collision with root package name */
    public Handler f27385j;
    public Runnable k;

    /* renamed from: c.a.r0.w0.o2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1284a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27386e;

        /* renamed from: c.a.r0.w0.o2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1285a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ RunnableC1284a f27387e;

            public RunnableC1285a(RunnableC1284a runnableC1284a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1284a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f27387e = runnableC1284a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f27387e.f27386e.f27384i == null) {
                    return;
                }
                this.f27387e.f27386e.j();
            }
        }

        public RunnableC1284a(a aVar) {
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
            this.f27386e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f27386e.f27382g == null || this.f27386e.f27383h == null) {
                return;
            }
            Activity pageActivity = this.f27386e.f27382g.getPageActivity();
            int g2 = c.a.e.e.p.l.g(pageActivity, R.dimen.ds64);
            a aVar = this.f27386e;
            View h2 = aVar.h(pageActivity, aVar.f27380e);
            int[] iArr = new int[2];
            this.f27386e.f27383h.getLocationInWindow(iArr);
            int g3 = c.a.e.e.p.l.g(pageActivity, R.dimen.ds32);
            int g4 = (iArr[1] - g2) + c.a.e.e.p.l.g(pageActivity, R.dimen.ds16);
            this.f27386e.f27384i = new PopupWindow(h2, -2, g2);
            this.f27386e.f27384i.showAtLocation(this.f27386e.f27383h, 53, g3, g4);
            this.f27386e.f27385j.postDelayed(new RunnableC1285a(this), 3000L);
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
        this.f27380e = R.string.attention_post_update_tip;
        this.f27385j = new Handler();
        this.k = new RunnableC1284a(this);
        this.f27382g = tbPageContext;
        this.f27381f = z;
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
            this.f27385j.removeCallbacksAndMessages(null);
            j();
        }
    }

    public void j() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (popupWindow = this.f27384i) == null) {
            return;
        }
        popupWindow.dismiss();
        this.f27384i = null;
    }

    public void k(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (this.f27382g == null || view == null || StringUtils.isNull(currentAccount)) {
                return;
            }
            this.f27383h = view;
            if (this.f27381f) {
                this.f27380e = R.string.attention_post_update_tip;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int k = c.a.q0.s.d0.b.j().k(str, 0);
                if (k >= 3) {
                    this.f27381f = false;
                    return;
                }
                c.a.q0.s.d0.b.j().v(str, k + 1);
                this.f27381f = false;
                this.f27385j.postDelayed(this.k, 500L);
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

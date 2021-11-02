package b.a.r0.x0.y2;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.h1;
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
/* loaded from: classes5.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f26818e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26819f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f26820g;

    /* renamed from: h  reason: collision with root package name */
    public View f26821h;

    /* renamed from: i  reason: collision with root package name */
    public PopupWindow f26822i;
    public Handler j;
    public Runnable k;

    /* renamed from: b.a.r0.x0.y2.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1316a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26823e;

        /* renamed from: b.a.r0.x0.y2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1317a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ RunnableC1316a f26824e;

            public RunnableC1317a(RunnableC1316a runnableC1316a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1316a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26824e = runnableC1316a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26824e.f26823e.f26822i == null) {
                    return;
                }
                this.f26824e.f26823e.j();
            }
        }

        public RunnableC1316a(a aVar) {
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
            this.f26823e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26823e.f26820g == null || this.f26823e.f26821h == null) {
                return;
            }
            Activity pageActivity = this.f26823e.f26820g.getPageActivity();
            int g2 = b.a.e.e.p.l.g(pageActivity, c1.ds64);
            a aVar = this.f26823e;
            View h2 = aVar.h(pageActivity, aVar.f26818e);
            int[] iArr = new int[2];
            this.f26823e.f26821h.getLocationInWindow(iArr);
            int g3 = b.a.e.e.p.l.g(pageActivity, c1.ds32);
            int g4 = (iArr[1] - g2) + b.a.e.e.p.l.g(pageActivity, c1.ds16);
            this.f26823e.f26822i = new PopupWindow(h2, -2, g2);
            this.f26823e.f26822i.showAtLocation(this.f26823e.f26821h, 53, g3, g4);
            this.f26823e.j.postDelayed(new RunnableC1317a(this), 3000L);
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
        this.f26818e = h1.attention_post_update_tip;
        this.j = new Handler();
        this.k = new RunnableC1316a(this);
        this.f26820g = tbPageContext;
        this.f26819f = z;
    }

    public final View h(Activity activity, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, activity, i2)) == null) {
            TextView textView = new TextView(activity);
            int g2 = b.a.e.e.p.l.g(activity, c1.ds20);
            textView.setPadding(g2, 0 - activity.getResources().getDimensionPixelSize(c1.ds12), g2, 0);
            textView.setHeight(activity.getResources().getDimensionPixelSize(c1.ds76));
            textView.setGravity(17);
            textView.setTextSize(0, b.a.e.e.p.l.g(activity, c1.fontsize28));
            textView.setText(i2);
            textView.setOnClickListener(this);
            SkinManager.setBackgroundResource(textView, d1.bg_tip_blue_left);
            SkinManager.setViewTextColor(textView, b1.CAM_X0101);
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (popupWindow = this.f26822i) == null) {
            return;
        }
        popupWindow.dismiss();
        this.f26822i = null;
    }

    public void k(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (this.f26820g == null || view == null || StringUtils.isNull(currentAccount)) {
                return;
            }
            this.f26821h = view;
            if (this.f26819f) {
                this.f26818e = h1.attention_post_update_tip;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int k = b.a.q0.s.e0.b.j().k(str, 0);
                if (k >= 3) {
                    this.f26819f = false;
                    return;
                }
                b.a.q0.s.e0.b.j().v(str, k + 1);
                this.f26819f = false;
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

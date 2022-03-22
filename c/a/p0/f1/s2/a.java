package c.a.p0.f1.s2;

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
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f14561b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f14562c;

    /* renamed from: d  reason: collision with root package name */
    public View f14563d;

    /* renamed from: e  reason: collision with root package name */
    public PopupWindow f14564e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f14565f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f14566g;

    /* renamed from: c.a.p0.f1.s2.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1102a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.p0.f1.s2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1103a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RunnableC1102a a;

            public RunnableC1103a(RunnableC1102a runnableC1102a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1102a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = runnableC1102a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.f14564e == null) {
                    return;
                }
                this.a.a.j();
            }
        }

        public RunnableC1102a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f14562c == null || this.a.f14563d == null) {
                return;
            }
            Activity pageActivity = this.a.f14562c.getPageActivity();
            int f2 = c.a.d.f.p.n.f(pageActivity, R.dimen.obfuscated_res_0x7f070258);
            a aVar = this.a;
            View h2 = aVar.h(pageActivity, aVar.a);
            int[] iArr = new int[2];
            this.a.f14563d.getLocationInWindow(iArr);
            int f3 = c.a.d.f.p.n.f(pageActivity, R.dimen.obfuscated_res_0x7f070207);
            int f4 = (iArr[1] - f2) + c.a.d.f.p.n.f(pageActivity, R.dimen.obfuscated_res_0x7f0701be);
            this.a.f14564e = new PopupWindow(h2, -2, f2);
            this.a.f14564e.showAtLocation(this.a.f14563d, 53, f3, f4);
            this.a.f14565f.postDelayed(new RunnableC1103a(this), 3000L);
        }
    }

    public a(TbPageContext tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = R.string.obfuscated_res_0x7f0f02aa;
        this.f14565f = new Handler();
        this.f14566g = new RunnableC1102a(this);
        this.f14562c = tbPageContext;
        this.f14561b = z;
    }

    public final View h(Activity activity, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, activity, i)) == null) {
            TextView textView = new TextView(activity);
            int f2 = c.a.d.f.p.n.f(activity, R.dimen.obfuscated_res_0x7f0701d5);
            textView.setPadding(f2, 0 - activity.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070234), f2, 0);
            textView.setHeight(activity.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07026f));
            textView.setGravity(17);
            textView.setTextSize(0, c.a.d.f.p.n.f(activity, R.dimen.obfuscated_res_0x7f0702b5));
            textView.setText(i);
            textView.setOnClickListener(this);
            SkinManager.setBackgroundResource(textView, R.drawable.obfuscated_res_0x7f0802f1);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            textView.setOnClickListener(this);
            return textView;
        }
        return (View) invokeLI.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f14565f.removeCallbacksAndMessages(null);
            j();
        }
    }

    public void j() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (popupWindow = this.f14564e) == null) {
            return;
        }
        popupWindow.dismiss();
        this.f14564e = null;
    }

    public void k(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (this.f14562c == null || view == null || StringUtils.isNull(currentAccount)) {
                return;
            }
            this.f14563d = view;
            if (this.f14561b) {
                this.a = R.string.obfuscated_res_0x7f0f02aa;
                String str = currentAccount + "frs_god_new_post_tip_count";
                int l = c.a.o0.r.j0.b.k().l(str, 0);
                if (l >= 3) {
                    this.f14561b = false;
                    return;
                }
                c.a.o0.r.j0.b.k().w(str, l + 1);
                this.f14561b = false;
                this.f14565f.postDelayed(this.f14566g, 500L);
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

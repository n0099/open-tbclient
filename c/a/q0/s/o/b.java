package c.a.q0.s.o;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f12818b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f12819c;

    /* renamed from: d  reason: collision with root package name */
    public Button f12820d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.a.d0.a f12821e;

    /* renamed from: f  reason: collision with root package name */
    public int f12822f;

    /* renamed from: g  reason: collision with root package name */
    public int f12823g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f12824h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f12825i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f12826e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12826e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f12826e.f12821e == null) {
                return;
            }
            if (this.f12826e.f12821e.f11607d == c.a.q0.a.d0.a.D) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.f12826e.f12821e.l) && !k.isEmpty(this.f12826e.f12821e.f11614k)) {
                    b bVar = this.f12826e;
                    bVar.e(bVar.f12821e.f11614k);
                }
            } else if (this.f12826e.f12821e.f11607d == c.a.q0.a.d0.a.E && !k.isEmpty(this.f12826e.f12821e.f11614k)) {
                b bVar2 = this.f12826e;
                bVar2.e(bVar2.f12821e.f11614k);
            }
            this.f12826e.dismiss();
        }
    }

    /* renamed from: c.a.q0.s.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC0807b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f12827e;

        public View$OnClickListenerC0807b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12827e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f12827e.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f12828e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12828e = bVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().unRegisterListener(this.f12828e.f12825i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12825i = new d(this, 2921420);
        g(context);
        MessageManager.getInstance().registerListener(this.f12825i);
    }

    public void d(Context context, c.a.q0.a.d0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, aVar) == null) || aVar == null) {
            return;
        }
        this.f12821e = aVar;
        if (k.isEmpty(aVar.f11608e)) {
            this.f12818b.setText(context.getResources().getString(R.string.task_already_finish));
        } else {
            this.f12818b.setText(aVar.f11608e);
        }
        if (k.isEmpty(aVar.p)) {
            this.f12818b.setTextColor(context.getResources().getColor(R.color.CAM_X0107));
        } else {
            this.f12818b.setTextColor(c.a.r0.w1.o.k.b.b(aVar.p));
        }
        if (k.isEmpty(aVar.f11609f)) {
            this.f12819c.setText(context.getResources().getString(R.string.back));
        } else {
            this.f12819c.setText(aVar.f11609f);
        }
        if (k.isEmpty(aVar.q)) {
            this.f12819c.setTextColor(context.getResources().getColor(R.color.CAM_X0101));
        } else {
            this.f12819c.setTextColor(c.a.r0.w1.o.k.b.b(aVar.q));
        }
        if (!k.isEmpty(aVar.o)) {
            this.f12819c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.f(context, R.dimen.tbds120), c.a.r0.w1.o.k.b.b(aVar.o)));
        }
        if (!k.isEmpty(aVar.f11613j)) {
            this.a.startLoad(aVar.f11613j, 10, false);
        } else {
            this.a.startLoad(String.valueOf(R.drawable.banner_size), 24, false);
        }
    }

    public final void e(String str) {
        TbPageContext<?> f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || k.isEmpty(str) || (f2 = f(TbadkCoreApplication.getInst().getCurrentActivity())) == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(f2, new String[]{str});
    }

    public final TbPageContext f(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            if (activity instanceof BaseActivity) {
                return ((BaseActivity) activity).getPageContext();
            }
            if (activity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) activity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.popupwindow_business, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.lower_hair_img);
            this.a = tbImageView;
            tbImageView.setRadius(l.f(context, R.dimen.tbds32));
            this.a.setConrers(3);
            this.f12818b = (TextView) inflate.findViewById(R.id.lower_hair_text_1);
            this.f12819c = (TextView) inflate.findViewById(R.id.lower_hair_text_2);
            this.f12820d = (Button) inflate.findViewById(R.id.btn_close);
            this.f12824h = (RelativeLayout) inflate.findViewById(R.id.lower_hair_content);
            this.f12819c.setOnClickListener(new a(this));
            this.f12820d.setOnClickListener(new View$OnClickListenerC0807b(this));
            setContentView(inflate);
            setWidth(-1);
            setHeight(-1);
            setFocusable(true);
            setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.black_alpha35)));
            setAnimationStyle(R.style.UpdateStyle);
            setClippingEnabled(false);
            setOnDismissListener(new c(this));
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                currentActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                this.f12822f = displayMetrics.widthPixels;
                this.f12823g = displayMetrics.heightPixels;
            }
            return this.f12823g > 2000 && this.f12822f > 2000;
        }
        return invokeV.booleanValue;
    }

    public void i() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (h() && (relativeLayout = this.f12824h) != null && relativeLayout.getLayoutParams() != null) {
                this.f12824h.getLayoutParams().width = (this.f12822f * 2) / 3;
            }
            showAtLocation(getContentView(), 17, 0, 0);
        }
    }
}

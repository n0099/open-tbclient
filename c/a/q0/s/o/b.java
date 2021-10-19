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
import c.a.e.e.p.k;
import c.a.e.e.p.l;
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
/* loaded from: classes3.dex */
public class b extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f14064a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f14065b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14066c;

    /* renamed from: d  reason: collision with root package name */
    public Button f14067d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.a.d0.a f14068e;

    /* renamed from: f  reason: collision with root package name */
    public int f14069f;

    /* renamed from: g  reason: collision with root package name */
    public int f14070g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f14071h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f14072i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14073e;

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
            this.f14073e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14073e.f14068e == null) {
                return;
            }
            if (this.f14073e.f14068e.f12559d == c.a.q0.a.d0.a.D) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.f14073e.f14068e.l) && !k.isEmpty(this.f14073e.f14068e.k)) {
                    b bVar = this.f14073e;
                    bVar.e(bVar.f14068e.k);
                }
            } else if (this.f14073e.f14068e.f12559d == c.a.q0.a.d0.a.E && !k.isEmpty(this.f14073e.f14068e.k)) {
                b bVar2 = this.f14073e;
                bVar2.e(bVar2.f14068e.k);
            }
            this.f14073e.dismiss();
        }
    }

    /* renamed from: c.a.q0.s.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0693b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14074e;

        public View$OnClickListenerC0693b(b bVar) {
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
            this.f14074e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14074e.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14075e;

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
            this.f14075e = bVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().unRegisterListener(this.f14075e.f14072i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f14076a;

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
            this.f14076a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f14076a.dismiss();
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
        this.f14072i = new d(this, 2921420);
        g(context);
        MessageManager.getInstance().registerListener(this.f14072i);
    }

    public void d(Context context, c.a.q0.a.d0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, aVar) == null) || aVar == null) {
            return;
        }
        this.f14068e = aVar;
        if (k.isEmpty(aVar.f12560e)) {
            this.f14065b.setText(context.getResources().getString(R.string.task_already_finish));
        } else {
            this.f14065b.setText(aVar.f12560e);
        }
        if (k.isEmpty(aVar.p)) {
            this.f14065b.setTextColor(context.getResources().getColor(R.color.CAM_X0107));
        } else {
            this.f14065b.setTextColor(c.a.r0.q1.o.k.b.b(aVar.p));
        }
        if (k.isEmpty(aVar.f12561f)) {
            this.f14066c.setText(context.getResources().getString(R.string.back));
        } else {
            this.f14066c.setText(aVar.f12561f);
        }
        if (k.isEmpty(aVar.q)) {
            this.f14066c.setTextColor(context.getResources().getColor(R.color.CAM_X0101));
        } else {
            this.f14066c.setTextColor(c.a.r0.q1.o.k.b.b(aVar.q));
        }
        if (!k.isEmpty(aVar.o)) {
            this.f14066c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(context, R.dimen.tbds120), c.a.r0.q1.o.k.b.b(aVar.o)));
        }
        if (!k.isEmpty(aVar.f12565j)) {
            this.f14064a.startLoad(aVar.f12565j, 10, false);
        } else {
            this.f14064a.startLoad(String.valueOf(R.drawable.banner_size), 24, false);
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
            this.f14064a = tbImageView;
            tbImageView.setRadius(l.g(context, R.dimen.tbds32));
            this.f14064a.setConrers(3);
            this.f14065b = (TextView) inflate.findViewById(R.id.lower_hair_text_1);
            this.f14066c = (TextView) inflate.findViewById(R.id.lower_hair_text_2);
            this.f14067d = (Button) inflate.findViewById(R.id.btn_close);
            this.f14071h = (RelativeLayout) inflate.findViewById(R.id.lower_hair_content);
            this.f14066c.setOnClickListener(new a(this));
            this.f14067d.setOnClickListener(new View$OnClickListenerC0693b(this));
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
                this.f14069f = displayMetrics.widthPixels;
                this.f14070g = displayMetrics.heightPixels;
            }
            return this.f14070g > 2000 && this.f14069f > 2000;
        }
        return invokeV.booleanValue;
    }

    public void i() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (h() && (relativeLayout = this.f14071h) != null && relativeLayout.getLayoutParams() != null) {
                this.f14071h.getLayoutParams().width = (this.f14069f * 2) / 3;
            }
            showAtLocation(getContentView(), 17, 0, 0);
        }
    }
}

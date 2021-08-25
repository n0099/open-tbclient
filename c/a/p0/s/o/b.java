package c.a.p0.s.o;

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
    public TbImageView f14093a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f14094b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f14095c;

    /* renamed from: d  reason: collision with root package name */
    public Button f14096d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.a.d0.a f14097e;

    /* renamed from: f  reason: collision with root package name */
    public int f14098f;

    /* renamed from: g  reason: collision with root package name */
    public int f14099g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f14100h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f14101i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14102e;

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
            this.f14102e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14102e.f14097e == null) {
                return;
            }
            if (this.f14102e.f14097e.f12548d == c.a.p0.a.d0.a.D) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.f14102e.f14097e.l) && !k.isEmpty(this.f14102e.f14097e.k)) {
                    b bVar = this.f14102e;
                    bVar.e(bVar.f14097e.k);
                }
            } else if (this.f14102e.f14097e.f12548d == c.a.p0.a.d0.a.E && !k.isEmpty(this.f14102e.f14097e.k)) {
                b bVar2 = this.f14102e;
                bVar2.e(bVar2.f14097e.k);
            }
            this.f14102e.dismiss();
        }
    }

    /* renamed from: c.a.p0.s.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0694b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14103e;

        public View$OnClickListenerC0694b(b bVar) {
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
            this.f14103e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f14103e.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f14104e;

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
            this.f14104e = bVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().unRegisterListener(this.f14104e.f14101i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f14105a;

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
            this.f14105a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f14105a.dismiss();
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
        this.f14101i = new d(this, 2921420);
        g(context);
        MessageManager.getInstance().registerListener(this.f14101i);
    }

    public void d(Context context, c.a.p0.a.d0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, aVar) == null) || aVar == null) {
            return;
        }
        this.f14097e = aVar;
        if (k.isEmpty(aVar.f12549e)) {
            this.f14094b.setText(context.getResources().getString(R.string.task_already_finish));
        } else {
            this.f14094b.setText(aVar.f12549e);
        }
        if (k.isEmpty(aVar.p)) {
            this.f14094b.setTextColor(context.getResources().getColor(R.color.CAM_X0107));
        } else {
            this.f14094b.setTextColor(c.a.q0.o1.o.k.b.b(aVar.p));
        }
        if (k.isEmpty(aVar.f12550f)) {
            this.f14095c.setText(context.getResources().getString(R.string.back));
        } else {
            this.f14095c.setText(aVar.f12550f);
        }
        if (k.isEmpty(aVar.q)) {
            this.f14095c.setTextColor(context.getResources().getColor(R.color.CAM_X0101));
        } else {
            this.f14095c.setTextColor(c.a.q0.o1.o.k.b.b(aVar.q));
        }
        if (!k.isEmpty(aVar.o)) {
            this.f14095c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(context, R.dimen.tbds120), c.a.q0.o1.o.k.b.b(aVar.o)));
        }
        if (!k.isEmpty(aVar.f12554j)) {
            this.f14093a.startLoad(aVar.f12554j, 10, false);
        } else {
            this.f14093a.startLoad(String.valueOf(R.drawable.banner_size), 24, false);
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
            this.f14093a = tbImageView;
            tbImageView.setRadius(l.g(context, R.dimen.tbds32));
            this.f14093a.setConrers(3);
            this.f14094b = (TextView) inflate.findViewById(R.id.lower_hair_text_1);
            this.f14095c = (TextView) inflate.findViewById(R.id.lower_hair_text_2);
            this.f14096d = (Button) inflate.findViewById(R.id.btn_close);
            this.f14100h = (RelativeLayout) inflate.findViewById(R.id.lower_hair_content);
            this.f14095c.setOnClickListener(new a(this));
            this.f14096d.setOnClickListener(new View$OnClickListenerC0694b(this));
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
                this.f14098f = displayMetrics.widthPixels;
                this.f14099g = displayMetrics.heightPixels;
            }
            return this.f14099g > 2000 && this.f14098f > 2000;
        }
        return invokeV.booleanValue;
    }

    public void i() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (h() && (relativeLayout = this.f14100h) != null && relativeLayout.getLayoutParams() != null) {
                this.f14100h.getLayoutParams().width = (this.f14098f * 2) / 3;
            }
            showAtLocation(getContentView(), 17, 0, 0);
        }
    }
}

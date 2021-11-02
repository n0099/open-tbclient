package b.a.q0.s.o;

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
import b.a.e.e.p.k;
import b.a.e.e.p.l;
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
/* loaded from: classes4.dex */
public class b extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbImageView f13182a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f13183b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f13184c;

    /* renamed from: d  reason: collision with root package name */
    public Button f13185d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.q0.a.d0.a f13186e;

    /* renamed from: f  reason: collision with root package name */
    public int f13187f;

    /* renamed from: g  reason: collision with root package name */
    public int f13188g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f13189h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f13190i;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f13191e;

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
            this.f13191e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f13191e.f13186e == null) {
                return;
            }
            if (this.f13191e.f13186e.f11730d == b.a.q0.a.d0.a.D) {
                if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.f13191e.f13186e.l) && !k.isEmpty(this.f13191e.f13186e.k)) {
                    b bVar = this.f13191e;
                    bVar.e(bVar.f13186e.k);
                }
            } else if (this.f13191e.f13186e.f11730d == b.a.q0.a.d0.a.E && !k.isEmpty(this.f13191e.f13186e.k)) {
                b bVar2 = this.f13191e;
                bVar2.e(bVar2.f13186e.k);
            }
            this.f13191e.dismiss();
        }
    }

    /* renamed from: b.a.q0.s.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC0689b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f13192e;

        public View$OnClickListenerC0689b(b bVar) {
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
            this.f13192e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f13192e.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f13193e;

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
            this.f13193e = bVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().unRegisterListener(this.f13193e.f13190i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f13194a;

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
            this.f13194a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f13194a.dismiss();
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
        this.f13190i = new d(this, 2921420);
        g(context);
        MessageManager.getInstance().registerListener(this.f13190i);
    }

    public void d(Context context, b.a.q0.a.d0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, aVar) == null) || aVar == null) {
            return;
        }
        this.f13186e = aVar;
        if (k.isEmpty(aVar.f11731e)) {
            this.f13183b.setText(context.getResources().getString(R.string.task_already_finish));
        } else {
            this.f13183b.setText(aVar.f11731e);
        }
        if (k.isEmpty(aVar.p)) {
            this.f13183b.setTextColor(context.getResources().getColor(R.color.CAM_X0107));
        } else {
            this.f13183b.setTextColor(b.a.r0.q1.o.k.b.b(aVar.p));
        }
        if (k.isEmpty(aVar.f11732f)) {
            this.f13184c.setText(context.getResources().getString(R.string.back));
        } else {
            this.f13184c.setText(aVar.f11732f);
        }
        if (k.isEmpty(aVar.q)) {
            this.f13184c.setTextColor(context.getResources().getColor(R.color.CAM_X0101));
        } else {
            this.f13184c.setTextColor(b.a.r0.q1.o.k.b.b(aVar.q));
        }
        if (!k.isEmpty(aVar.o)) {
            this.f13184c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(context, R.dimen.tbds120), b.a.r0.q1.o.k.b.b(aVar.o)));
        }
        if (!k.isEmpty(aVar.j)) {
            this.f13182a.startLoad(aVar.j, 10, false);
        } else {
            this.f13182a.startLoad(String.valueOf(R.drawable.banner_size), 24, false);
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
            this.f13182a = tbImageView;
            tbImageView.setRadius(l.g(context, R.dimen.tbds32));
            this.f13182a.setConrers(3);
            this.f13183b = (TextView) inflate.findViewById(R.id.lower_hair_text_1);
            this.f13184c = (TextView) inflate.findViewById(R.id.lower_hair_text_2);
            this.f13185d = (Button) inflate.findViewById(R.id.btn_close);
            this.f13189h = (RelativeLayout) inflate.findViewById(R.id.lower_hair_content);
            this.f13184c.setOnClickListener(new a(this));
            this.f13185d.setOnClickListener(new View$OnClickListenerC0689b(this));
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
                this.f13187f = displayMetrics.widthPixels;
                this.f13188g = displayMetrics.heightPixels;
            }
            return this.f13188g > 2000 && this.f13187f > 2000;
        }
        return invokeV.booleanValue;
    }

    public void i() {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (h() && (relativeLayout = this.f13189h) != null && relativeLayout.getLayoutParams() != null) {
                this.f13189h.getLayoutParams().width = (this.f13187f * 2) / 3;
            }
            showAtLocation(getContentView(), 17, 0, 0);
        }
    }
}

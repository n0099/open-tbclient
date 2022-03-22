package c.a.p0.a1.y.d;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends PopupWindow implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f12081b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f12082c;

    /* renamed from: d  reason: collision with root package name */
    public View f12083d;

    /* renamed from: e  reason: collision with root package name */
    public View f12084e;

    /* renamed from: f  reason: collision with root package name */
    public View f12085f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f12086g;

    /* renamed from: h  reason: collision with root package name */
    public c f12087h;
    public Context i;

    /* renamed from: c.a.p0.a1.y.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnTouchListenerC0915a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnTouchListenerC0915a(a aVar) {
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

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int top = this.a.f12083d.findViewById(R.id.obfuscated_res_0x7f090e3d).getTop();
                int y = (int) motionEvent.getY();
                if (motionEvent.getAction() == 1 && y < top) {
                    this.a.dismiss();
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
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
        b(context, i);
        this.i = context;
        e();
        c(TbadkCoreApplication.getInst().getSkinType());
        this.a.setOnClickListener(this);
        this.f12081b.setOnClickListener(this);
        this.f12082c.setOnClickListener(this);
    }

    public final void b(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, context, i) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0255, (ViewGroup) null);
            this.f12083d = inflate;
            this.a = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092209);
            this.f12081b = (TextView) this.f12083d.findViewById(R.id.obfuscated_res_0x7f0921da);
            this.f12082c = (TextView) this.f12083d.findViewById(R.id.obfuscated_res_0x7f09218c);
            this.f12086g = (LinearLayout) this.f12083d.findViewById(R.id.obfuscated_res_0x7f090e3d);
            this.f12084e = this.f12083d.findViewById(R.id.obfuscated_res_0x7f091257);
            this.f12085f = this.f12083d.findViewById(R.id.obfuscated_res_0x7f091258);
            if (i == 1) {
                SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0204);
            }
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            SkinManager.setBackgroundResource(this.f12086g, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.f12084e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f12085f, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f12081b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f12082c, (int) R.color.CAM_X0107);
        }
    }

    public void d(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f12087h = cVar;
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (Build.VERSION.SDK_INT >= 22) {
                setAttachedInDecor(false);
            }
            setContentView(this.f12083d);
            setWidth(-1);
            setHeight(n.i(this.i));
            setFocusable(true);
            setBackgroundDrawable(new ColorDrawable(getContentView().getResources().getColor(R.color.black_alpha50)));
            this.f12083d.setOnTouchListener(new View$OnTouchListenerC0915a(this));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            dismiss();
            c cVar = this.f12087h;
            if (cVar == null) {
                return;
            }
            if (view == this.a) {
                cVar.b();
            } else if (view == this.f12081b) {
                cVar.a();
            }
        }
    }
}

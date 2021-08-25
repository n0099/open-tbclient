package c.a.q0.q0.x.d;

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
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a extends PopupWindow implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f23840e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f23841f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23842g;

    /* renamed from: h  reason: collision with root package name */
    public View f23843h;

    /* renamed from: i  reason: collision with root package name */
    public View f23844i;

    /* renamed from: j  reason: collision with root package name */
    public View f23845j;
    public LinearLayout k;
    public c l;
    public Context m;

    /* renamed from: c.a.q0.q0.x.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC1101a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23846e;

        public View$OnTouchListenerC1101a(a aVar) {
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
            this.f23846e = aVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int top = this.f23846e.f23843h.findViewById(R.id.id_pop_layout).getTop();
                int y = (int) motionEvent.getY();
                if (motionEvent.getAction() == 1 && y < top) {
                    this.f23846e.dismiss();
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b(context, i2);
        this.m = context;
        e();
        c(TbadkCoreApplication.getInst().getSkinType());
        this.f23840e.setOnClickListener(this);
        this.f23841f.setOnClickListener(this);
        this.f23842g.setOnClickListener(this);
    }

    public final void b(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, context, i2) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.emotion_add_popupwindow, (ViewGroup) null);
            this.f23843h = inflate;
            this.f23840e = (TextView) inflate.findViewById(R.id.tv_single_bar);
            this.f23841f = (TextView) this.f23843h.findViewById(R.id.tv_my_emotion);
            this.f23842g = (TextView) this.f23843h.findViewById(R.id.tv_cancel);
            this.k = (LinearLayout) this.f23843h.findViewById(R.id.id_pop_layout);
            this.f23844i = this.f23843h.findViewById(R.id.line1);
            this.f23845j = this.f23843h.findViewById(R.id.line2);
            if (i2 == 1) {
                SkinManager.setViewTextColor(this.f23840e, R.color.CAM_X0105);
            } else {
                SkinManager.setViewTextColor(this.f23840e, R.color.CAM_X0204);
            }
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setBackgroundResource(this.k, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.f23844i, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f23845j, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f23841f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f23842g, R.color.CAM_X0107);
        }
    }

    public void d(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.l = cVar;
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (Build.VERSION.SDK_INT >= 22) {
                setAttachedInDecor(false);
            }
            setContentView(this.f23843h);
            setWidth(-1);
            setHeight(l.i(this.m));
            setFocusable(true);
            setBackgroundDrawable(new ColorDrawable(getContentView().getResources().getColor(R.color.black_alpha50)));
            this.f23843h.setOnTouchListener(new View$OnTouchListenerC1101a(this));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            dismiss();
            c cVar = this.l;
            if (cVar == null) {
                return;
            }
            if (view == this.f23840e) {
                cVar.b();
            } else if (view == this.f23841f) {
                cVar.a();
            }
        }
    }
}

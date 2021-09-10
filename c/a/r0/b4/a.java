package c.a.r0.b4;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f16150a;

    /* renamed from: b  reason: collision with root package name */
    public View f16151b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f16152c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16153d;

    /* renamed from: e  reason: collision with root package name */
    public View f16154e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16155f;

    /* renamed from: g  reason: collision with root package name */
    public String f16156g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f16157h;

    /* renamed from: i  reason: collision with root package name */
    public e f16158i;

    /* renamed from: j  reason: collision with root package name */
    public c f16159j;
    public boolean k;

    /* renamed from: c.a.r0.b4.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0771a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f16160e;

        public View$OnClickListenerC0771a(a aVar) {
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
            this.f16160e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16160e.f16159j.onClick();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f16161a;

        /* renamed from: b  reason: collision with root package name */
        public a f16162b;

        /* renamed from: c  reason: collision with root package name */
        public View f16163c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16164d;

        /* renamed from: e  reason: collision with root package name */
        public View f16165e;

        /* renamed from: f  reason: collision with root package name */
        public String f16166f;

        /* renamed from: g  reason: collision with root package name */
        public int f16167g;

        /* renamed from: h  reason: collision with root package name */
        public d f16168h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f16169i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f16170j;
        public final View.OnClickListener k;

        /* renamed from: c.a.r0.b4.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0772a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f16171e;

            public View$OnClickListenerC0772a(b bVar) {
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
                this.f16171e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f16171e.f16168h != null) {
                        this.f16171e.f16168h.onClick();
                    }
                    if (this.f16171e.f16162b == null || this.f16171e.f16162b.d() == null) {
                        return;
                    }
                    this.f16171e.f16162b.d().a(this.f16171e.f16161a, view);
                }
            }
        }

        public b(String str, a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16167g = 17;
            this.f16169i = true;
            this.k = new View$OnClickListenerC0772a(this);
            this.f16166f = str;
            this.f16162b = aVar;
            this.f16161a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16163c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f16164d) == null) {
                return;
            }
            textView.setOnClickListener(this.k);
        }

        public final void f() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f16162b) == null || aVar.c() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f16162b.c()).inflate(R.layout.bottom_up_list_dialog_item, this.f16162b.e(), false);
            this.f16163c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f16164d = textView;
            textView.setText(this.f16166f);
            this.f16164d.setGravity(this.f16167g);
            View findViewById = this.f16163c.findViewById(R.id.divider_line);
            this.f16165e = findViewById;
            if (this.f16169i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                TextView textView = this.f16164d;
                if (textView != null) {
                    if (this.f16170j) {
                        SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                    } else {
                        textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                    }
                }
                SkinManager.setViewTextColor(this.f16164d, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f16165e, R.color.CAM_X0204);
            }
        }

        public void h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                this.f16168h = dVar;
                e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(int i2, View view);
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (context == null) {
            return;
        }
        this.f16150a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
        this.f16151b = inflate;
        this.f16152c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f16153d = (TextView) this.f16151b.findViewById(R.id.title);
        this.f16154e = this.f16151b.findViewById(R.id.title_divide_line);
        this.f16157h = new ArrayList();
        this.f16155f = (TextView) this.f16151b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.f16156g)) {
                this.f16153d.setText(this.f16156g);
                this.f16154e.setVisibility(0);
            } else {
                this.f16153d.setVisibility(8);
                this.f16154e.setVisibility(8);
            }
            if (this.f16159j != null) {
                this.f16155f.setOnClickListener(new View$OnClickListenerC0771a(this));
            }
            f();
            return this.f16151b;
        }
        return (View) invokeV.objValue;
    }

    public Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16150a : (Context) invokeV.objValue;
    }

    public e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16158i : (e) invokeV.objValue;
    }

    public ViewGroup e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16152c : (ViewGroup) invokeV.objValue;
    }

    public void f() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundColor(this.f16151b, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f16153d, R.drawable.bg_title_corner_dialog_item);
            SkinManager.setViewTextColor(this.f16153d, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f16154e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f16155f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f16155f, R.color.CAM_X0107);
            List<b> list = this.f16157h;
            if (list != null) {
                for (b bVar : list) {
                    bVar.g();
                }
            }
            if (this.k) {
                if (!StringUtils.isNull(this.f16156g) && (textView = this.f16153d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                    float dimension = c().getResources().getDimension(R.dimen.tbds32);
                    ((GradientDrawable) this.f16153d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
                } else if (ListUtils.getCount(this.f16157h) > 0) {
                    b bVar2 = this.f16157h.get(0);
                    if (bVar2.f16170j) {
                        return;
                    }
                    bVar2.f16170j = true;
                    bVar2.g();
                }
            }
        }
    }

    public void g(List<b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null) {
            return;
        }
        this.f16157h = list;
        this.f16152c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar != null) {
                this.f16152c.addView(bVar.d());
            }
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f16159j = cVar;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f16156g = str;
        }
    }
}

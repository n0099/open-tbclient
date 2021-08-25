package c.a.q0.a4;

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
    public Context f15617a;

    /* renamed from: b  reason: collision with root package name */
    public View f15618b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f15619c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15620d;

    /* renamed from: e  reason: collision with root package name */
    public View f15621e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15622f;

    /* renamed from: g  reason: collision with root package name */
    public String f15623g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f15624h;

    /* renamed from: i  reason: collision with root package name */
    public e f15625i;

    /* renamed from: j  reason: collision with root package name */
    public c f15626j;
    public boolean k;

    /* renamed from: c.a.q0.a4.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0735a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15627e;

        public View$OnClickListenerC0735a(a aVar) {
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
            this.f15627e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15627e.f15626j.onClick();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f15628a;

        /* renamed from: b  reason: collision with root package name */
        public a f15629b;

        /* renamed from: c  reason: collision with root package name */
        public View f15630c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15631d;

        /* renamed from: e  reason: collision with root package name */
        public View f15632e;

        /* renamed from: f  reason: collision with root package name */
        public String f15633f;

        /* renamed from: g  reason: collision with root package name */
        public int f15634g;

        /* renamed from: h  reason: collision with root package name */
        public d f15635h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f15636i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f15637j;
        public final View.OnClickListener k;

        /* renamed from: c.a.q0.a4.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0736a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f15638e;

            public View$OnClickListenerC0736a(b bVar) {
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
                this.f15638e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f15638e.f15635h != null) {
                        this.f15638e.f15635h.onClick();
                    }
                    if (this.f15638e.f15629b == null || this.f15638e.f15629b.d() == null) {
                        return;
                    }
                    this.f15638e.f15629b.d().a(this.f15638e.f15628a, view);
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
            this.f15634g = 17;
            this.f15636i = true;
            this.k = new View$OnClickListenerC0736a(this);
            this.f15633f = str;
            this.f15629b = aVar;
            this.f15628a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15630c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f15631d) == null) {
                return;
            }
            textView.setOnClickListener(this.k);
        }

        public final void f() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f15629b) == null || aVar.c() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f15629b.c()).inflate(R.layout.bottom_up_list_dialog_item, this.f15629b.e(), false);
            this.f15630c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f15631d = textView;
            textView.setText(this.f15633f);
            this.f15631d.setGravity(this.f15634g);
            View findViewById = this.f15630c.findViewById(R.id.divider_line);
            this.f15632e = findViewById;
            if (this.f15636i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                TextView textView = this.f15631d;
                if (textView != null) {
                    if (this.f15637j) {
                        SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                    } else {
                        textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                    }
                }
                SkinManager.setViewTextColor(this.f15631d, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f15632e, R.color.CAM_X0204);
            }
        }

        public void h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                this.f15635h = dVar;
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
        this.f15617a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
        this.f15618b = inflate;
        this.f15619c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f15620d = (TextView) this.f15618b.findViewById(R.id.title);
        this.f15621e = this.f15618b.findViewById(R.id.title_divide_line);
        this.f15624h = new ArrayList();
        this.f15622f = (TextView) this.f15618b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.f15623g)) {
                this.f15620d.setText(this.f15623g);
                this.f15621e.setVisibility(0);
            } else {
                this.f15620d.setVisibility(8);
                this.f15621e.setVisibility(8);
            }
            if (this.f15626j != null) {
                this.f15622f.setOnClickListener(new View$OnClickListenerC0735a(this));
            }
            f();
            return this.f15618b;
        }
        return (View) invokeV.objValue;
    }

    public Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15617a : (Context) invokeV.objValue;
    }

    public e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15625i : (e) invokeV.objValue;
    }

    public ViewGroup e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15619c : (ViewGroup) invokeV.objValue;
    }

    public void f() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundColor(this.f15618b, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f15620d, R.drawable.bg_title_corner_dialog_item);
            SkinManager.setViewTextColor(this.f15620d, R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f15621e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f15622f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f15622f, R.color.CAM_X0107);
            List<b> list = this.f15624h;
            if (list != null) {
                for (b bVar : list) {
                    bVar.g();
                }
            }
            if (this.k) {
                if (!StringUtils.isNull(this.f15623g) && (textView = this.f15620d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                    float dimension = c().getResources().getDimension(R.dimen.tbds32);
                    ((GradientDrawable) this.f15620d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
                } else if (ListUtils.getCount(this.f15624h) > 0) {
                    b bVar2 = this.f15624h.get(0);
                    if (bVar2.f15637j) {
                        return;
                    }
                    bVar2.f15637j = true;
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
        this.f15624h = list;
        this.f15619c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar != null) {
                this.f15619c.addView(bVar.d());
            }
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f15626j = cVar;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f15623g = str;
        }
    }
}

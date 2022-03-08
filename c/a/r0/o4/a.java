package c.a.r0.o4;

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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f20412b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f20413c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f20414d;

    /* renamed from: e  reason: collision with root package name */
    public View f20415e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20416f;

    /* renamed from: g  reason: collision with root package name */
    public String f20417g;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f20418h;

    /* renamed from: i  reason: collision with root package name */
    public e f20419i;

    /* renamed from: j  reason: collision with root package name */
    public c f20420j;
    public boolean k;

    /* renamed from: c.a.r0.o4.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1276a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20421e;

        public View$OnClickListenerC1276a(a aVar) {
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
            this.f20421e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20421e.f20420j.onClick();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public a f20422b;

        /* renamed from: c  reason: collision with root package name */
        public View f20423c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f20424d;

        /* renamed from: e  reason: collision with root package name */
        public View f20425e;

        /* renamed from: f  reason: collision with root package name */
        public String f20426f;

        /* renamed from: g  reason: collision with root package name */
        public int f20427g;

        /* renamed from: h  reason: collision with root package name */
        public d f20428h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f20429i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f20430j;
        public final View.OnClickListener k;

        /* renamed from: c.a.r0.o4.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC1277a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f20431e;

            public View$OnClickListenerC1277a(b bVar) {
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
                this.f20431e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    if (this.f20431e.f20428h != null) {
                        this.f20431e.f20428h.onClick();
                    }
                    if (this.f20431e.f20422b == null || this.f20431e.f20422b.c() == null) {
                        return;
                    }
                    this.f20431e.f20422b.c().a(this.f20431e.a, view);
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
            this.f20427g = 17;
            this.f20429i = true;
            this.k = new View$OnClickListenerC1277a(this);
            this.f20426f = str;
            this.f20422b = aVar;
            this.a = hashCode();
            f();
            e();
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20423c : (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f20424d) == null) {
                return;
            }
            textView.setOnClickListener(this.k);
        }

        public final void f() {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f20422b) == null || aVar.getContext() == null) {
                return;
            }
            View inflate = LayoutInflater.from(this.f20422b.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.f20422b.d(), false);
            this.f20423c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.item_view);
            this.f20424d = textView;
            textView.setText(this.f20426f);
            this.f20424d.setGravity(this.f20427g);
            View findViewById = this.f20423c.findViewById(R.id.divider_line);
            this.f20425e = findViewById;
            if (this.f20429i) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            g();
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                TextView textView = this.f20424d;
                if (textView != null) {
                    if (this.f20430j) {
                        SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                    } else {
                        textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                    }
                }
                SkinManager.setViewTextColor(this.f20424d, (int) R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f20425e, R.color.CAM_X0204);
            }
        }

        public void h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                this.f20428h = dVar;
                e();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes2.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes2.dex */
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
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
        this.f20412b = inflate;
        this.f20413c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.f20414d = (TextView) this.f20412b.findViewById(R.id.title);
        this.f20415e = this.f20412b.findViewById(R.id.title_divide_line);
        this.f20418h = new ArrayList();
        this.f20416f = (TextView) this.f20412b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.f20417g)) {
                this.f20414d.setText(this.f20417g);
                this.f20415e.setVisibility(0);
            } else {
                this.f20414d.setVisibility(8);
                this.f20415e.setVisibility(8);
            }
            if (this.f20420j != null) {
                this.f20416f.setOnClickListener(new View$OnClickListenerC1276a(this));
            }
            e();
            return this.f20412b;
        }
        return (View) invokeV.objValue;
    }

    public e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20419i : (e) invokeV.objValue;
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20413c : (ViewGroup) invokeV.objValue;
    }

    public void e() {
        b bVar;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundColor(this.f20412b, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f20414d, R.drawable.bg_title_corner_dialog_item);
            SkinManager.setViewTextColor(this.f20414d, (int) R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.f20415e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f20416f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f20416f, (int) R.color.CAM_X0107);
            List<b> list = this.f20418h;
            if (list != null) {
                for (b bVar2 : list) {
                    bVar2.g();
                }
            }
            if (this.k) {
                if (!StringUtils.isNull(this.f20417g) && (textView = this.f20414d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                    float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                    ((GradientDrawable) this.f20414d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
                    return;
                }
                List<b> list2 = this.f20418h;
                if (list2 == null || ListUtils.getCount(list2) <= 0 || (bVar = this.f20418h.get(0)) == null || bVar.f20430j) {
                    return;
                }
                bVar.f20430j = true;
                bVar.g();
            }
        }
    }

    public void f(List<b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        this.f20418h = list;
        this.f20413c.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            b bVar = list.get(i2);
            if (bVar != null) {
                this.f20413c.addView(bVar.d());
            }
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f20420j = cVar;
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (Context) invokeV.objValue;
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f20417g = str;
        }
    }
}

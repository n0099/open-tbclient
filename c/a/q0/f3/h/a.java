package c.a.q0.f3.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.f3.j.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f18151e;

    /* renamed from: f  reason: collision with root package name */
    public int f18152f;

    /* renamed from: g  reason: collision with root package name */
    public C0874a f18153g;

    /* renamed from: h  reason: collision with root package name */
    public Context f18154h;

    /* renamed from: c.a.q0.f3.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0874a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ImageView f18155a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18156b;

        public C0874a(a aVar) {
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
                }
            }
        }
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
        this.f18152f = 0;
        this.f18154h = context;
    }

    public final View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.f18154h).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
            C0874a c0874a = new C0874a(this);
            this.f18153g = c0874a;
            c0874a.f18155a = (ImageView) inflate.findViewById(R.id.menu_choose);
            this.f18153g.f18156b = (TextView) inflate.findViewById(R.id.menu_name);
            inflate.setTag(this.f18153g);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public final void b(C0874a c0874a, d dVar, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0874a, dVar, view, i2) == null) || c0874a == null || dVar == null) {
            return;
        }
        c0874a.f18156b.setText("");
        if (i2 == 0) {
            TextView textView = c0874a.f18156b;
            textView.setText(this.f18154h.getString(R.string.all) + dVar.f18209b);
        } else {
            c0874a.f18156b.setText(dVar.f18209b);
        }
        if (i2 != this.f18152f) {
            c0874a.f18155a.setVisibility(4);
            SkinManager.setViewTextColor(c0874a.f18156b, R.color.common_color_10200, 1);
            return;
        }
        c0874a.f18155a.setVisibility(0);
        SkinManager.setViewTextColor(c0874a.f18156b, R.color.common_color_10013, 1);
    }

    public d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18151e : (d) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f18152f = i2;
            notifyDataSetChanged();
        }
    }

    public void e(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.f18151e = dVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        ArrayList<d> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d dVar = this.f18151e;
            if (dVar == null || (arrayList = dVar.f18212e) == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        ArrayList<d> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            d dVar = this.f18151e;
            if (dVar == null || (arrayList = dVar.f18212e) == null) {
                return null;
            }
            return arrayList.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = a();
            }
            d dVar = this.f18151e;
            if (dVar == null) {
                return view;
            }
            d dVar2 = dVar.f18212e.get(i2);
            C0874a c0874a = (C0874a) view.getTag();
            this.f18153g = c0874a;
            if (dVar2 != null) {
                b(c0874a, dVar2, view, i2);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

package c.a.r0.g3.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.g3.j.d;
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
    public d f18694e;

    /* renamed from: f  reason: collision with root package name */
    public int f18695f;

    /* renamed from: g  reason: collision with root package name */
    public C0903a f18696g;

    /* renamed from: h  reason: collision with root package name */
    public Context f18697h;

    /* renamed from: c.a.r0.g3.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0903a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ImageView f18698a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18699b;

        public C0903a(a aVar) {
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
        this.f18695f = 0;
        this.f18697h = context;
    }

    public final View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.f18697h).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
            C0903a c0903a = new C0903a(this);
            this.f18696g = c0903a;
            c0903a.f18698a = (ImageView) inflate.findViewById(R.id.menu_choose);
            this.f18696g.f18699b = (TextView) inflate.findViewById(R.id.menu_name);
            inflate.setTag(this.f18696g);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public final void b(C0903a c0903a, d dVar, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0903a, dVar, view, i2) == null) || c0903a == null || dVar == null) {
            return;
        }
        c0903a.f18699b.setText("");
        if (i2 == 0) {
            TextView textView = c0903a.f18699b;
            textView.setText(this.f18697h.getString(R.string.all) + dVar.f18752b);
        } else {
            c0903a.f18699b.setText(dVar.f18752b);
        }
        if (i2 != this.f18695f) {
            c0903a.f18698a.setVisibility(4);
            SkinManager.setViewTextColor(c0903a.f18699b, R.color.common_color_10200, 1);
            return;
        }
        c0903a.f18698a.setVisibility(0);
        SkinManager.setViewTextColor(c0903a.f18699b, R.color.common_color_10013, 1);
    }

    public d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18694e : (d) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f18695f = i2;
            notifyDataSetChanged();
        }
    }

    public void e(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.f18694e = dVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        ArrayList<d> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d dVar = this.f18694e;
            if (dVar == null || (arrayList = dVar.f18755e) == null) {
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
            d dVar = this.f18694e;
            if (dVar == null || (arrayList = dVar.f18755e) == null) {
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
            d dVar = this.f18694e;
            if (dVar == null) {
                return view;
            }
            d dVar2 = dVar.f18755e.get(i2);
            C0903a c0903a = (C0903a) view.getTag();
            this.f18696g = c0903a;
            if (dVar2 != null) {
                b(c0903a, dVar2, view, i2);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

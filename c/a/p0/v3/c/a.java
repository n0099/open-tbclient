package c.a.p0.v3.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.v3.e.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public int f19218b;

    /* renamed from: c  reason: collision with root package name */
    public C1454a f19219c;

    /* renamed from: d  reason: collision with root package name */
    public Context f19220d;

    /* renamed from: c.a.p0.v3.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1454a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f19221b;

        public C1454a(a aVar) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19218b = 0;
        this.f19220d = context;
    }

    public final View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.f19220d).inflate(R.layout.obfuscated_res_0x7f0d02ba, (ViewGroup) null);
            C1454a c1454a = new C1454a(this);
            this.f19219c = c1454a;
            c1454a.a = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0913eb);
            this.f19219c.f19221b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0913f2);
            inflate.setTag(this.f19219c);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public final void b(C1454a c1454a, d dVar, View view, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1454a, dVar, view, i) == null) || c1454a == null || dVar == null) {
            return;
        }
        c1454a.f19221b.setText("");
        if (i == 0) {
            TextView textView = c1454a.f19221b;
            textView.setText(this.f19220d.getString(R.string.obfuscated_res_0x7f0f025f) + dVar.f19260b);
        } else {
            c1454a.f19221b.setText(dVar.f19260b);
        }
        if (i != this.f19218b) {
            c1454a.a.setVisibility(4);
            SkinManager.setViewTextColor(c1454a.f19221b, R.color.common_color_10200, 1);
            return;
        }
        c1454a.a.setVisibility(0);
        SkinManager.setViewTextColor(c1454a.f19221b, R.color.common_color_10013, 1);
    }

    public d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (d) invokeV.objValue;
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f19218b = i;
            notifyDataSetChanged();
        }
    }

    public void e(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.a = dVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        ArrayList<d> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d dVar = this.a;
            if (dVar == null || (arrayList = dVar.f19263e) == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        ArrayList<d> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            d dVar = this.a;
            if (dVar == null || (arrayList = dVar.f19263e) == null) {
                return null;
            }
            return arrayList.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view, viewGroup)) == null) {
            if (view == null) {
                view = a();
            }
            d dVar = this.a;
            if (dVar == null) {
                return view;
            }
            d dVar2 = dVar.f19263e.get(i);
            C1454a c1454a = (C1454a) view.getTag();
            this.f19219c = c1454a;
            if (dVar2 != null) {
                b(c1454a, dVar2, view, i);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

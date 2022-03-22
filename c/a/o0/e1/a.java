package c.a.o0.e1;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f10028b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f10029c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f10030d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f10031e;

    /* renamed from: c.a.o0.e1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0792a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f10032b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f10033c;

        public C0792a(a aVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090323);
            this.a = tbImageView;
            tbImageView.setDefaultBgResource(R.color.CAM_X0206);
            this.f10032b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090325);
            this.f10033c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090322);
        }
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f10034b;

        public b(a aVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091758);
            this.f10034b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091757);
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
        this.f10028b = 0;
        this.a = context;
        this.f10029c = new ArrayList();
        this.f10030d = new ArrayList();
        this.f10031e = new ArrayList();
    }

    public void a(C0792a c0792a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, c0792a) == null) || c0792a == null) {
            return;
        }
        SkinManager.setViewTextColor(c0792a.f10032b, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(c0792a.f10033c, R.color.CAM_X0109, 1);
    }

    public void b(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        SkinManager.setViewTextColor(bVar.a, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(bVar.f10034b, (int) R.color.CAM_X0109);
    }

    public void c(List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, list2) == null) {
            this.f10030d.clear();
            this.f10031e.clear();
            if (!ListUtils.isEmpty(list) && !ListUtils.isEmpty(list2)) {
                this.f10030d.addAll(list);
                this.f10031e.addAll(list2);
            }
            notifyDataSetChanged();
        }
    }

    public void d(List<String> list, List<String> list2, List<String> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, list, list2, list3) == null) {
            this.f10029c.clear();
            if (!ListUtils.isEmpty(list)) {
                this.f10029c.addAll(list);
            }
            c(list2, list3);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f10028b = i;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (ListUtils.isEmpty(this.f10030d)) {
                return 0;
            }
            return this.f10030d.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? super.getItemViewType(i) : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view, viewGroup)) == null) {
            int i2 = this.f10028b;
            if (i2 == 0) {
                view = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d06a8, (ViewGroup) null, false);
                b bVar = new b(this, view);
                if (!ListUtils.isEmpty(this.f10030d) && this.f10030d.size() > i && !TextUtils.isEmpty(this.f10030d.get(i))) {
                    bVar.a.setText(this.f10030d.get(i));
                    bVar.a.setVisibility(0);
                } else {
                    bVar.a.setVisibility(8);
                }
                if (!ListUtils.isEmpty(this.f10031e) && this.f10031e.size() > i && !TextUtils.isEmpty(this.f10031e.get(i))) {
                    bVar.f10034b.setText(this.f10031e.get(i));
                    bVar.f10034b.setVisibility(0);
                } else {
                    bVar.f10034b.setVisibility(8);
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                layoutParams.weight = 1.0f;
                view.setLayoutParams(layoutParams);
                b(bVar);
            } else if (i2 == 1) {
                view = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d013e, (ViewGroup) null, false);
                C0792a c0792a = new C0792a(this, view);
                if (!ListUtils.isEmpty(this.f10029c) && this.f10029c.size() > i && !TextUtils.isEmpty(this.f10029c.get(i))) {
                    c0792a.a.setDefaultResource(R.drawable.obfuscated_res_0x7f081200);
                    c0792a.a.J(this.f10029c.get(i), 10, false);
                }
                if (!ListUtils.isEmpty(this.f10030d) && this.f10030d.size() > i && !TextUtils.isEmpty(this.f10030d.get(i))) {
                    c0792a.f10032b.setText(this.f10030d.get(i));
                    c0792a.f10032b.setVisibility(0);
                } else {
                    c0792a.f10032b.setVisibility(8);
                }
                if (!ListUtils.isEmpty(this.f10031e) && this.f10031e.size() > i && !TextUtils.isEmpty(this.f10031e.get(i))) {
                    c0792a.f10033c.setText(this.f10031e.get(i));
                    c0792a.f10033c.setVisibility(0);
                } else {
                    c0792a.f10033c.setVisibility(8);
                }
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
                layoutParams2.weight = 1.0f;
                view.setLayoutParams(layoutParams2);
                a(c0792a);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

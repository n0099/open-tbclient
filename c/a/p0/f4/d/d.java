package c.a.p0.f4.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.p0.f4.d.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: e  reason: collision with root package name */
    public static int f15006e = 16;
    public transient /* synthetic */ FieldHolder $fh;
    public AvatarPendantActivity a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.p0.f4.d.a> f15007b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.f4.d.b f15008c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f15009d;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public WholeDisplayGridView f15010b;

        /* renamed from: c  reason: collision with root package name */
        public View f15011c;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(d dVar, a aVar) {
            this(dVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1053612378, "Lc/a/p0/f4/d/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1053612378, "Lc/a/p0/f4/d/d;");
        }
    }

    public d(AvatarPendantActivity avatarPendantActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {avatarPendantActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = avatarPendantActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public c.a.p0.f4.d.a getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<c.a.p0.f4.d.a> list = this.f15007b;
            if (list == null || list.size() <= 0 || i < 0 || i >= getCount()) {
                return null;
            }
            return this.f15007b.get(i);
        }
        return (c.a.p0.f4.d.a) invokeI.objValue;
    }

    public void b(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f15009d = aVar;
        }
    }

    public void c(List<c.a.p0.f4.d.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f15007b = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<c.a.p0.f4.d.a> list = this.f15007b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view, viewGroup)) == null) {
            if (view != null && (view.getTag() instanceof b)) {
                bVar = (b) view.getTag();
            } else {
                view = LayoutInflater.from(this.a.getActivity()).inflate(R.layout.obfuscated_res_0x7f0d012b, viewGroup, false);
                bVar = new b(this, null);
                bVar.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0905a1);
                bVar.f15010b = (WholeDisplayGridView) view.findViewById(R.id.obfuscated_res_0x7f0902ea);
                bVar.f15011c = view.findViewById(R.id.obfuscated_res_0x7f091260);
                view.setTag(bVar);
            }
            c.a.p0.f4.d.a item = getItem(i);
            if (StringUtils.isNull(item.a())) {
                bVar.a.setVisibility(8);
            } else {
                bVar.a.setVisibility(0);
                bVar.a.setText(m.cutString(item.a(), f15006e));
            }
            if (item != null && !ListUtils.isEmpty(item.b())) {
                c.a.p0.f4.d.b bVar2 = new c.a.p0.f4.d.b(this.a);
                this.f15008c = bVar2;
                bVar2.d(item.b());
                bVar.f15010b.setAdapter((ListAdapter) this.f15008c);
                this.f15008c.c(this.f15009d);
            }
            if (i == getCount() - 1) {
                bVar.f15011c.setVisibility(8);
            } else {
                bVar.f15011c.setVisibility(0);
            }
            SkinManager.setBackgroundColor(bVar.f15011c, R.color.CAM_X0204);
            SkinManager.setViewTextColor(bVar.a, (int) R.color.CAM_X0109);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

package b.a.r0.r3.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import b.a.e.e.p.k;
import b.a.r0.r3.d.c;
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
/* loaded from: classes5.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: i  reason: collision with root package name */
    public static int f23097i = 16;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AvatarPendantActivity f23098e;

    /* renamed from: f  reason: collision with root package name */
    public List<b.a.r0.r3.d.a> f23099f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.r3.d.b f23100g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f23101h;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f23102a;

        /* renamed from: b  reason: collision with root package name */
        public WholeDisplayGridView f23103b;

        /* renamed from: c  reason: collision with root package name */
        public View f23104c;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1097342874, "Lb/a/r0/r3/d/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1097342874, "Lb/a/r0/r3/d/d;");
        }
    }

    public d(AvatarPendantActivity avatarPendantActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {avatarPendantActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f23098e = avatarPendantActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public b.a.r0.r3.d.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<b.a.r0.r3.d.a> list = this.f23099f;
            if (list == null || list.size() <= 0 || i2 < 0 || i2 >= getCount()) {
                return null;
            }
            return this.f23099f.get(i2);
        }
        return (b.a.r0.r3.d.a) invokeI.objValue;
    }

    public void b(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f23101h = aVar;
        }
    }

    public void c(List<b.a.r0.r3.d.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f23099f = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<b.a.r0.r3.d.a> list = this.f23099f;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view != null && (view.getTag() instanceof b)) {
                bVar = (b) view.getTag();
            } else {
                view = LayoutInflater.from(this.f23098e.getActivity()).inflate(R.layout.avatar_pendant_listiew_item, viewGroup, false);
                bVar = new b(this, null);
                bVar.f23102a = (TextView) view.findViewById(R.id.category_name);
                bVar.f23103b = (WholeDisplayGridView) view.findViewById(R.id.avatar_pedant_gridview);
                bVar.f23104c = view.findViewById(R.id.line_divider);
                view.setTag(bVar);
            }
            b.a.r0.r3.d.a item = getItem(i2);
            if (StringUtils.isNull(item.a())) {
                bVar.f23102a.setVisibility(8);
            } else {
                bVar.f23102a.setVisibility(0);
                bVar.f23102a.setText(k.cutString(item.a(), f23097i));
            }
            if (item != null && !ListUtils.isEmpty(item.b())) {
                b.a.r0.r3.d.b bVar2 = new b.a.r0.r3.d.b(this.f23098e);
                this.f23100g = bVar2;
                bVar2.d(item.b());
                bVar.f23103b.setAdapter((ListAdapter) this.f23100g);
                this.f23100g.c(this.f23101h);
            }
            if (i2 == getCount() - 1) {
                bVar.f23104c.setVisibility(8);
            } else {
                bVar.f23104c.setVisibility(0);
            }
            SkinManager.setBackgroundColor(bVar.f23104c, R.color.CAM_X0204);
            SkinManager.setViewTextColor(bVar.f23102a, R.color.CAM_X0109);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

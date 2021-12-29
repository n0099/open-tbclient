package c.a.t0.x.e.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes8.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static SparseArray<Integer> f25825h;

    /* renamed from: i  reason: collision with root package name */
    public static HashMap<b, Integer> f25826i;

    /* renamed from: j  reason: collision with root package name */
    public static HashMap<b, Integer> f25827j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public NewFriendsActivity f25828e;

    /* renamed from: f  reason: collision with root package name */
    public List<c.a.t0.s1.g.a> f25829f;

    /* renamed from: g  reason: collision with root package name */
    public c f25830g;

    /* renamed from: c.a.t0.x.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C1495a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                return obj != null && b.class == obj.getClass() && this.a == ((b) obj).a;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 31 + (this.a ? 1231 : 1237);
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(int i2, int i3, View view, c.a.t0.s1.g.a aVar);
    }

    /* loaded from: classes8.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f25831b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25832c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25833d;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a(c.a.t0.s1.g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                boolean z = false;
                this.a.startLoad(aVar.e(), 12, false);
                this.f25831b.setText(aVar.d());
                if (!TextUtils.isEmpty(aVar.a())) {
                    this.f25832c.setText(aVar.a());
                } else {
                    this.f25832c.setText("");
                }
                int f2 = aVar.f();
                this.f25833d.setText(((Integer) a.f25825h.get(f2)).intValue());
                this.f25833d.setEnabled((f2 == 0 || f2 == 1) ? true : true);
            }
        }

        public /* synthetic */ d(C1495a c1495a) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1928861546, "Lc/a/t0/x/e/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1928861546, "Lc/a/t0/x/e/a/a;");
                return;
            }
        }
        f25825h = new SparseArray<>();
        f25826i = new HashMap<>();
        f25827j = new HashMap<>();
        f25825h.put(0, Integer.valueOf(R.string.add));
        f25825h.put(4, Integer.valueOf(R.string.added));
        f25825h.put(1, Integer.valueOf(R.string.pass));
        f25825h.put(2, Integer.valueOf(R.string.passed));
        f25825h.put(3, Integer.valueOf(R.string.waiting));
        f25826i.put(new b(false), Integer.valueOf(R.drawable.btn_pass));
        f25826i.put(new b(true), Integer.valueOf(R.drawable.btn_all_blue));
        f25827j.put(new b(false), Integer.valueOf(R.color.btn_pass_text_color));
        f25827j.put(new b(true), Integer.valueOf(R.color.btn_agree_text_color));
    }

    public a(NewFriendsActivity newFriendsActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newFriendsActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f25828e = newFriendsActivity;
    }

    public final int b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            List<c.a.t0.s1.g.a> list = this.f25829f;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (j2 == this.f25829f.get(i2).b()) {
                        return i2;
                    }
                }
                return -1;
            }
            return -1;
        }
        return invokeJ.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public c.a.t0.s1.g.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f25829f.get(i2) : (c.a.t0.s1.g.a) invokeI.objValue;
    }

    public synchronized void d(c.a.t0.s1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            synchronized (this) {
                if (this.f25829f != null) {
                    this.f25829f.remove(aVar);
                }
            }
        }
    }

    public void e(List<c.a.t0.s1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f25829f = list;
        }
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f25830g = cVar;
        }
    }

    public void g(c.a.t0.s1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (this.f25829f == null) {
                this.f25829f = new ArrayList();
            }
            if (aVar == null || aVar.b() == 0) {
                return;
            }
            int b2 = b(aVar.b());
            if (b2 != -1) {
                this.f25829f.remove(b2);
                this.f25829f.add(0, aVar);
                return;
            }
            this.f25829f.add(0, aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<c.a.t0.s1.g.a> list = this.f25829f;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, view, viewGroup)) == null) {
            if (view != null && view.getTag() != null && (view.getTag() instanceof d)) {
                dVar = (d) view.getTag();
            } else {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.add_new_friend_list_item, (ViewGroup) null);
                dVar = new d(null);
                dVar.a = (HeadImageView) view.findViewById(R.id.friend_icon);
                dVar.f25831b = (TextView) view.findViewById(R.id.friend_name);
                dVar.f25832c = (TextView) view.findViewById(R.id.friend_info);
                dVar.f25833d = (TextView) view.findViewById(R.id.friend_add_btn);
                view.setTag(dVar);
            }
            c.a.t0.s1.g.a item = getItem(i2);
            dVar.a(item);
            dVar.f25833d.setTag(Integer.valueOf(i2));
            dVar.f25833d.setOnClickListener(this);
            this.f25828e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f25828e.getLayoutMode().j(view);
            Integer num = f25826i.get(new b(item.f() == 1));
            if (num != null) {
                SkinManager.setBackgroundResource(dVar.f25833d, num.intValue());
            }
            Integer num2 = f25827j.get(new b(item.f() == 1));
            if (num2 != null) {
                SkinManager.setViewTextColor(dVar.f25833d, num2.intValue(), 1);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public void h(List<c.a.t0.s1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            if (this.f25829f == null) {
                this.f25829f = new ArrayList();
            }
            if (list != null) {
                for (c.a.t0.s1.g.a aVar : list) {
                    g(aVar);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, view) == null) || this.f25830g == null) {
            return;
        }
        int id = view.getId();
        int intValue = ((Integer) view.getTag()).intValue();
        this.f25830g.a(id, intValue, view, getItem(intValue));
    }
}

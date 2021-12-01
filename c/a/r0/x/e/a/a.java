package c.a.r0.x.e.a;

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
/* loaded from: classes7.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static SparseArray<Integer> f25295h;

    /* renamed from: i  reason: collision with root package name */
    public static HashMap<b, Integer> f25296i;

    /* renamed from: j  reason: collision with root package name */
    public static HashMap<b, Integer> f25297j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public NewFriendsActivity f25298e;

    /* renamed from: f  reason: collision with root package name */
    public List<c.a.r0.r1.g.a> f25299f;

    /* renamed from: g  reason: collision with root package name */
    public c f25300g;

    /* renamed from: c.a.r0.x.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class C1446a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public interface c {
        void a(int i2, int i3, View view, c.a.r0.r1.g.a aVar);
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f25301b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25302c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25303d;

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

        public void a(c.a.r0.r1.g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                boolean z = false;
                this.a.startLoad(aVar.e(), 12, false);
                this.f25301b.setText(aVar.d());
                if (!TextUtils.isEmpty(aVar.a())) {
                    this.f25302c.setText(aVar.a());
                } else {
                    this.f25302c.setText("");
                }
                int f2 = aVar.f();
                this.f25303d.setText(((Integer) a.f25295h.get(f2)).intValue());
                this.f25303d.setEnabled((f2 == 0 || f2 == 1) ? true : true);
            }
        }

        public /* synthetic */ d(C1446a c1446a) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1665041172, "Lc/a/r0/x/e/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1665041172, "Lc/a/r0/x/e/a/a;");
                return;
            }
        }
        f25295h = new SparseArray<>();
        f25296i = new HashMap<>();
        f25297j = new HashMap<>();
        f25295h.put(0, Integer.valueOf(R.string.add));
        f25295h.put(4, Integer.valueOf(R.string.added));
        f25295h.put(1, Integer.valueOf(R.string.pass));
        f25295h.put(2, Integer.valueOf(R.string.passed));
        f25295h.put(3, Integer.valueOf(R.string.waiting));
        f25296i.put(new b(false), Integer.valueOf(R.drawable.btn_pass));
        f25296i.put(new b(true), Integer.valueOf(R.drawable.btn_all_blue));
        f25297j.put(new b(false), Integer.valueOf(R.color.btn_pass_text_color));
        f25297j.put(new b(true), Integer.valueOf(R.color.btn_agree_text_color));
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
        this.f25298e = newFriendsActivity;
    }

    public final int b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            List<c.a.r0.r1.g.a> list = this.f25299f;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (j2 == this.f25299f.get(i2).b()) {
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
    public c.a.r0.r1.g.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f25299f.get(i2) : (c.a.r0.r1.g.a) invokeI.objValue;
    }

    public synchronized void d(c.a.r0.r1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            synchronized (this) {
                if (this.f25299f != null) {
                    this.f25299f.remove(aVar);
                }
            }
        }
    }

    public void e(List<c.a.r0.r1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f25299f = list;
        }
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f25300g = cVar;
        }
    }

    public void g(c.a.r0.r1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (this.f25299f == null) {
                this.f25299f = new ArrayList();
            }
            if (aVar == null || aVar.b() == 0) {
                return;
            }
            int b2 = b(aVar.b());
            if (b2 != -1) {
                this.f25299f.remove(b2);
                this.f25299f.add(0, aVar);
                return;
            }
            this.f25299f.add(0, aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<c.a.r0.r1.g.a> list = this.f25299f;
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
                dVar.f25301b = (TextView) view.findViewById(R.id.friend_name);
                dVar.f25302c = (TextView) view.findViewById(R.id.friend_info);
                dVar.f25303d = (TextView) view.findViewById(R.id.friend_add_btn);
                view.setTag(dVar);
            }
            c.a.r0.r1.g.a item = getItem(i2);
            dVar.a(item);
            dVar.f25303d.setTag(Integer.valueOf(i2));
            dVar.f25303d.setOnClickListener(this);
            this.f25298e.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f25298e.getLayoutMode().j(view);
            Integer num = f25296i.get(new b(item.f() == 1));
            if (num != null) {
                SkinManager.setBackgroundResource(dVar.f25303d, num.intValue());
            }
            Integer num2 = f25297j.get(new b(item.f() == 1));
            if (num2 != null) {
                SkinManager.setViewTextColor(dVar.f25303d, num2.intValue(), 1);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public void h(List<c.a.r0.r1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            if (this.f25299f == null) {
                this.f25299f = new ArrayList();
            }
            if (list != null) {
                for (c.a.r0.r1.g.a aVar : list) {
                    g(aVar);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, view) == null) || this.f25300g == null) {
            return;
        }
        int id = view.getId();
        int intValue = ((Integer) view.getTag()).intValue();
        this.f25300g.a(id, intValue, view, getItem(intValue));
    }
}

package c.a.t0.u1.a.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f23926e;

    /* renamed from: f  reason: collision with root package name */
    public List<c.a.s0.t.f.a> f23927f;

    /* renamed from: g  reason: collision with root package name */
    public int f23928g;

    /* renamed from: h  reason: collision with root package name */
    public int f23929h;

    /* renamed from: c.a.t0.u1.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C1454a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f23930b;

        /* renamed from: c  reason: collision with root package name */
        public View f23931c;

        public b(a aVar) {
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

        public /* synthetic */ b(a aVar, C1454a c1454a) {
            this(aVar);
        }
    }

    /* loaded from: classes8.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public View f23932b;

        public c(a aVar) {
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

        public /* synthetic */ c(a aVar, C1454a c1454a) {
            this(aVar);
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
        this.f23926e = context;
        this.f23928g = R.color.CAM_X0105;
        this.f23929h = R.color.CAM_X0108;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public c.a.s0.t.f.a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<c.a.s0.t.f.a> list = this.f23927f;
            if (list == null || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return this.f23927f.get(i2);
        }
        return (c.a.s0.t.f.a) invokeI.objValue;
    }

    public void b(List<c.a.s0.t.f.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f23927f = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<c.a.s0.t.f.a> list = this.f23927f;
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            c.a.s0.t.f.a item = getItem(i2);
            if (item == null) {
                return 2;
            }
            return (!TextUtils.isEmpty(item.a()) && TextUtils.isEmpty(item.f()) && TextUtils.isEmpty(item.h())) ? 0 : 1;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (getItemViewType(i2) == 2) {
                return null;
            }
            TbadkCoreApplication.getInst().getSkinType();
            c.a.s0.t.f.a item = getItem(i2);
            if (getItemViewType(i2) == 0) {
                if (view != null && view.getTag() != null && (view.getTag() instanceof c)) {
                    cVar = (c) view.getTag();
                } else {
                    view = LayoutInflater.from(this.f23926e).inflate(R.layout.select_friend_group_item, (ViewGroup) null);
                    cVar = new c(this, null);
                    cVar.a = (TextView) view.findViewById(R.id.addresslist_group_item_key);
                    cVar.f23932b = view.findViewById(R.id.addresslist_group_item_divider);
                    view.setTag(cVar);
                }
                if (item.a() != null) {
                    cVar.a.setText(item.a());
                }
                SkinManager.setViewTextColor(cVar.a, this.f23929h, 1);
                SkinManager.setBackgroundColor(cVar.f23932b, R.color.CAM_X0204);
                return view;
            } else if (getItemViewType(i2) == 1) {
                if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
                    bVar = (b) view.getTag();
                } else {
                    bVar = new b(this, null);
                    view = LayoutInflater.from(this.f23926e).inflate(R.layout.select_friend_child_item, (ViewGroup) null);
                    bVar.a = (HeadImageView) view.findViewById(R.id.addresslist_child_item_icon);
                    bVar.f23930b = (TextView) view.findViewById(R.id.addresslist_child_item_name);
                    bVar.f23931c = view.findViewById(R.id.addresslist_child_item_divider);
                    view.setTag(bVar);
                }
                if (item.f() != null) {
                    bVar.f23930b.setText(item.f());
                    bVar.a.startLoad(item.h(), 12, false);
                }
                SkinManager.setViewTextColor(bVar.f23930b, this.f23928g, 1);
                SkinManager.setBackgroundResource(bVar.f23931c, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(view, R.drawable.select_friend_item_bg);
                return view;
            } else {
                return null;
            }
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }
}

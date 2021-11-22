package b.a.r0.c3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f16633e;

    /* renamed from: f  reason: collision with root package name */
    public List<d> f16634f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16635g;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f16636a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16637b;

        /* renamed from: c  reason: collision with root package name */
        public TbImageView f16638c;

        /* renamed from: d  reason: collision with root package name */
        public View f16639d;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(Context context) {
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
        this.f16635g = true;
        this.f16633e = context;
        this.f16634f = new ArrayList();
    }

    public void a(List<d> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        this.f16634f.addAll(list);
        notifyDataSetChanged();
    }

    public final b b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
            b bVar = new b(this, null);
            bVar.f16636a = (TextView) view.findViewById(R.id.push_msg_title);
            bVar.f16637b = (TextView) view.findViewById(R.id.push_msg_content);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.push_msg_pic);
            bVar.f16638c = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            bVar.f16639d = view.findViewById(R.id.line);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public d getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            List<d> list = this.f16634f;
            if (list == null || i2 >= list.size()) {
                return null;
            }
            return this.f16634f.get(i2);
        }
        return (d) invokeI.objValue;
    }

    public View d(d dVar, View view, ViewGroup viewGroup) {
        InterceptResult invokeLLL;
        b b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, dVar, view, viewGroup)) == null) {
            if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
                b2 = (b) view.getTag();
            } else {
                view = LayoutInflater.from(this.f16633e).inflate(R.layout.screenlock_show_item_view_4, viewGroup, false);
                b2 = b(view);
                view.setTag(b2);
            }
            if (dVar == null) {
                return view;
            }
            b2.f16636a.setText(dVar.f16643d);
            b2.f16637b.setText(dVar.f16644e);
            b2.f16638c.setDefaultResource(R.drawable.screen_notify_default_bg);
            b2.f16638c.startLoad(dVar.f16645f, 10, 0, 0, false);
            return view;
        }
        return (View) invokeLLL.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16635g : invokeV.booleanValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f16635g = z;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<d> list = this.f16634f;
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
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, view, viewGroup)) == null) ? d(this.f16634f.get(i2), view, viewGroup) : (View) invokeILL.objValue;
    }
}

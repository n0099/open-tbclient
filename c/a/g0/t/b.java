package c.a.g0.t;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.a.g0.d;
import c.a.g0.f;
import c.a.g0.g;
import c.a.g0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.entitiy.InstallmentEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<InstallmentEntity> f3270e;

    /* renamed from: f  reason: collision with root package name */
    public Context f3271f;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f3272b;

        /* renamed from: c  reason: collision with root package name */
        public View f3273c;

        public a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3273c = view.findViewById(g.period_item_view);
            this.a = (TextView) view.findViewById(g.period_title);
            this.f3272b = (TextView) view.findViewById(g.period_sub_title);
        }
    }

    public b(Context context) {
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
        this.f3271f = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public InstallmentEntity getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 < this.f3270e.size()) {
                return this.f3270e.get(i2);
            }
            return null;
        }
        return (InstallmentEntity) invokeI.objValue;
    }

    public void b(List<InstallmentEntity> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f3270e = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<InstallmentEntity> list = this.f3270e;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            InstallmentEntity item = getItem(i2);
            if (item == null) {
                return view;
            }
            if (view == null) {
                view = LayoutInflater.from(this.f3271f).inflate(h.period_list_item, (ViewGroup) null, false);
                view.setTag(new a(view));
            }
            if (view.getTag() != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
                aVar.a.setText(item.getTitle());
                aVar.f3272b.setText(item.getPayText());
                if (item.isChecked()) {
                    aVar.a.setTextSize(1, 14.0f);
                    aVar.a.setTextColor(this.f3271f.getResources().getColor(d.period_item_checked_color));
                    aVar.f3272b.setTextSize(1, 10.0f);
                    aVar.f3272b.setTextColor(this.f3271f.getResources().getColor(d.period_item_checked_color));
                    aVar.f3273c.setBackground(this.f3271f.getResources().getDrawable(f.period_item_checked_background_shape));
                } else {
                    aVar.a.setTextSize(1, 14.0f);
                    aVar.a.setTextColor(this.f3271f.getResources().getColor(d.title_color));
                    aVar.f3272b.setTextSize(1, 10.0f);
                    aVar.f3272b.setTextColor(this.f3271f.getResources().getColor(d.period_item_sub_title_color));
                    aVar.f3273c.setBackground(this.f3271f.getResources().getDrawable(f.period_background_shape));
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

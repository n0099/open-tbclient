package c.a.p0.e2.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f16668e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f16669f;

    /* renamed from: g  reason: collision with root package name */
    public final List<c.a.p0.e2.c.b> f16670g;

    /* renamed from: h  reason: collision with root package name */
    public c f16671h;

    /* renamed from: c.a.p0.e2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0811a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.e2.c.b f16672e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f16673f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f16674g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f16675h;

        public View$OnClickListenerC0811a(a aVar, c.a.p0.e2.c.b bVar, b bVar2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, bVar2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16675h = aVar;
            this.f16672e = bVar;
            this.f16673f = bVar2;
            this.f16674g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (!this.f16672e.d() && this.f16675h.f16668e >= 10) {
                    l.M(this.f16675h.f16669f.getApplicationContext(), this.f16675h.f16669f.getApplicationContext().getString(R.string.max_interest_select_num));
                    return;
                }
                c.a.p0.e2.c.b bVar = this.f16672e;
                bVar.e(!bVar.d());
                this.f16675h.i(this.f16673f.f16678c, this.f16672e);
                this.f16675h.h(this.f16672e);
                if (this.f16675h.f16671h != null) {
                    this.f16675h.f16671h.onSelectCountChanged(this.f16675h.f16668e);
                }
                if (this.f16672e.d()) {
                    StatisticItem statisticItem = new StatisticItem("c13682");
                    statisticItem.param("obj_type", 2);
                    statisticItem.param("obj_locate", 1);
                    statisticItem.param("obj_source", this.f16674g);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ImageView f16676a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16677b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f16678c;

        public b(View view) {
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
            this.f16676a = (ImageView) view.findViewById(R.id.interest_icon);
            this.f16677b = (TextView) view.findViewById(R.id.interest_text);
            this.f16678c = (ImageView) view.findViewById(R.id.select_status_view);
            SkinManager.setViewTextColor(this.f16677b, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void onSelectCountChanged(int i2);
    }

    public a(List<c.a.p0.e2.c.b> list, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16670g = list;
        this.f16669f = context;
    }

    public List<c.a.p0.e2.c.b> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (c.a.p0.e2.c.b bVar : this.f16670g) {
                if (bVar.d()) {
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f16671h = cVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<c.a.p0.e2.c.b> list = this.f16670g;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            return null;
        }
        return invokeI.objValue;
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
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f16669f).inflate(R.layout.list_item_interest_selection, viewGroup, false);
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            c.a.p0.e2.c.b bVar2 = this.f16670g.get(i2);
            if (bVar2.a() > 0) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(bVar.f16676a, bVar2.a(), null);
            }
            bVar.f16677b.setText(bVar2.c());
            i(bVar.f16678c, bVar2);
            if (bVar2.d()) {
                this.f16668e++;
            }
            view.setOnClickListener(new View$OnClickListenerC0811a(this, bVar2, bVar, i2));
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(c.a.p0.e2.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            if (bVar.d()) {
                this.f16668e++;
            } else {
                this.f16668e--;
            }
        }
    }

    public final void i(ImageView imageView, c.a.p0.e2.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, imageView, bVar) == null) {
            if (bVar.d()) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
            } else {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
            }
        }
    }
}

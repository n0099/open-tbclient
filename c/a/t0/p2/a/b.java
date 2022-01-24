package c.a.t0.p2.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.t0.p2.a.a;
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
import java.util.List;
/* loaded from: classes8.dex */
public class b extends c.a.t0.p2.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.p2.c.b f21108e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ C1315b f21109f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f21110g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f21111h;

        public a(b bVar, c.a.t0.p2.c.b bVar2, C1315b c1315b, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, c1315b, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21111h = bVar;
            this.f21108e = bVar2;
            this.f21109f = c1315b;
            this.f21110g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.t0.p2.c.b bVar = this.f21108e;
                bVar.l(!bVar.g());
                this.f21111h.f(this.f21109f.f21113c, this.f21108e);
                this.f21111h.d(this.f21108e);
                b bVar2 = this.f21111h;
                a.InterfaceC1314a interfaceC1314a = bVar2.f21107h;
                if (interfaceC1314a != null) {
                    interfaceC1314a.onSelectCountChanged(bVar2.f21104e);
                }
                if (this.f21108e.g()) {
                    StatisticItem statisticItem = new StatisticItem("c13682");
                    statisticItem.param("obj_type", 2);
                    statisticItem.param("obj_locate", 1);
                    statisticItem.param("obj_source", this.f21110g);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* renamed from: c.a.t0.p2.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1315b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f21112b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f21113c;

        public C1315b(View view) {
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
            this.a = (ImageView) view.findViewById(R.id.interest_icon);
            this.f21112b = (TextView) view.findViewById(R.id.interest_text);
            this.f21113c = (ImageView) view.findViewById(R.id.select_status_view);
            SkinManager.setViewTextColor(this.f21112b, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(List<c.a.t0.p2.c.b> list, Context context) {
        super(list, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((List) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void f(ImageView imageView, c.a.t0.p2.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, imageView, bVar) == null) {
            if (bVar.g()) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
            } else {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
            }
        }
    }

    @Override // c.a.t0.p2.a.a, android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<c.a.t0.p2.c.b> list = this.f21106g;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // c.a.t0.p2.a.a, android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // c.a.t0.p2.a.a, android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1315b c1315b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f21105f).inflate(R.layout.list_item_interest_selection, viewGroup, false);
                c1315b = new C1315b(view);
                view.setTag(c1315b);
            } else {
                c1315b = (C1315b) view.getTag();
            }
            c.a.t0.p2.c.b bVar = this.f21106g.get(i2);
            if (bVar == null) {
                return view;
            }
            if (bVar.d() > 0) {
                SkinManager.setImageResource(c1315b.a, bVar.d());
            }
            c1315b.f21112b.setText(bVar.f());
            f(c1315b.f21113c, bVar);
            if (bVar.g()) {
                this.f21104e++;
            }
            view.setOnClickListener(new a(this, bVar, c1315b, i2));
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

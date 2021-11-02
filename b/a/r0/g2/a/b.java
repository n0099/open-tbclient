package b.a.r0.g2.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.r0.g2.a.a;
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
/* loaded from: classes4.dex */
public class b extends b.a.r0.g2.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.g2.c.b f16713e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ C0864b f16714f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f16715g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f16716h;

        public a(b bVar, b.a.r0.g2.c.b bVar2, C0864b c0864b, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, c0864b, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16716h = bVar;
            this.f16713e = bVar2;
            this.f16714f = c0864b;
            this.f16715g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.r0.g2.c.b bVar = this.f16713e;
                bVar.l(!bVar.g());
                this.f16716h.f(this.f16714f.f16719c, this.f16713e);
                this.f16716h.d(this.f16713e);
                b bVar2 = this.f16716h;
                a.InterfaceC0863a interfaceC0863a = bVar2.f16712h;
                if (interfaceC0863a != null) {
                    interfaceC0863a.onSelectCountChanged(bVar2.f16709e);
                }
                if (this.f16713e.g()) {
                    StatisticItem statisticItem = new StatisticItem("c13682");
                    statisticItem.param("obj_type", 2);
                    statisticItem.param("obj_locate", 1);
                    statisticItem.param("obj_source", this.f16715g);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* renamed from: b.a.r0.g2.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0864b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ImageView f16717a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16718b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f16719c;

        public C0864b(View view) {
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
            this.f16717a = (ImageView) view.findViewById(R.id.interest_icon);
            this.f16718b = (TextView) view.findViewById(R.id.interest_text);
            this.f16719c = (ImageView) view.findViewById(R.id.select_status_view);
            SkinManager.setViewTextColor(this.f16718b, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(List<b.a.r0.g2.c.b> list, Context context) {
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

    public final void f(ImageView imageView, b.a.r0.g2.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, imageView, bVar) == null) {
            if (bVar.g()) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_pure_guide_select_svg, SvgManager.SvgResourceStateType.NORMAL);
            } else {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.ic_icon_mask_module_unselect_svg, SvgManager.SvgResourceStateType.NORMAL);
            }
        }
    }

    @Override // b.a.r0.g2.a.a, android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<b.a.r0.g2.c.b> list = this.f16711g;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.g2.a.a, android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // b.a.r0.g2.a.a, android.widget.Adapter
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
        C0864b c0864b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f16710f).inflate(R.layout.list_item_interest_selection, viewGroup, false);
                c0864b = new C0864b(view);
                view.setTag(c0864b);
            } else {
                c0864b = (C0864b) view.getTag();
            }
            b.a.r0.g2.c.b bVar = this.f16711g.get(i2);
            if (bVar == null) {
                return view;
            }
            if (bVar.d() > 0) {
                SkinManager.setImageResource(c0864b.f16717a, bVar.d());
            }
            c0864b.f16718b.setText(bVar.f());
            f(c0864b.f16719c, bVar);
            if (bVar.g()) {
                this.f16709e++;
            }
            view.setOnClickListener(new a(this, bVar, c0864b, i2));
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

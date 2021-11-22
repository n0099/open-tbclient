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
        public final /* synthetic */ b.a.r0.g2.c.b f18227e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ C0931b f18228f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f18229g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f18230h;

        public a(b bVar, b.a.r0.g2.c.b bVar2, C0931b c0931b, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, c0931b, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18230h = bVar;
            this.f18227e = bVar2;
            this.f18228f = c0931b;
            this.f18229g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.r0.g2.c.b bVar = this.f18227e;
                bVar.l(!bVar.g());
                this.f18230h.f(this.f18228f.f18233c, this.f18227e);
                this.f18230h.d(this.f18227e);
                b bVar2 = this.f18230h;
                a.InterfaceC0930a interfaceC0930a = bVar2.f18226h;
                if (interfaceC0930a != null) {
                    interfaceC0930a.onSelectCountChanged(bVar2.f18223e);
                }
                if (this.f18227e.g()) {
                    StatisticItem statisticItem = new StatisticItem("c13682");
                    statisticItem.param("obj_type", 2);
                    statisticItem.param("obj_locate", 1);
                    statisticItem.param("obj_source", this.f18229g);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* renamed from: b.a.r0.g2.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0931b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ImageView f18231a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18232b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f18233c;

        public C0931b(View view) {
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
            this.f18231a = (ImageView) view.findViewById(R.id.interest_icon);
            this.f18232b = (TextView) view.findViewById(R.id.interest_text);
            this.f18233c = (ImageView) view.findViewById(R.id.select_status_view);
            SkinManager.setViewTextColor(this.f18232b, R.color.CAM_X0105);
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
            List<b.a.r0.g2.c.b> list = this.f18225g;
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
        C0931b c0931b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f18224f).inflate(R.layout.list_item_interest_selection, viewGroup, false);
                c0931b = new C0931b(view);
                view.setTag(c0931b);
            } else {
                c0931b = (C0931b) view.getTag();
            }
            b.a.r0.g2.c.b bVar = this.f18225g.get(i2);
            if (bVar == null) {
                return view;
            }
            if (bVar.d() > 0) {
                SkinManager.setImageResource(c0931b.f18231a, bVar.d());
            }
            c0931b.f18232b.setText(bVar.f());
            f(c0931b.f18233c, bVar);
            if (bVar.g()) {
                this.f18223e++;
            }
            view.setOnClickListener(new a(this, bVar, c0931b, i2));
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

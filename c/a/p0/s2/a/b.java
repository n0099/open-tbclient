package c.a.p0.s2.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.p0.s2.a.a;
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
/* loaded from: classes2.dex */
public class b extends c.a.p0.s2.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.s2.c.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ C1375b f18186b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f18187c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f18188d;

        public a(b bVar, c.a.p0.s2.c.b bVar2, C1375b c1375b, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2, c1375b, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18188d = bVar;
            this.a = bVar2;
            this.f18186b = c1375b;
            this.f18187c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.p0.s2.c.b bVar = this.a;
                bVar.l(!bVar.g());
                this.f18188d.f(this.f18186b.f18190c, this.a);
                this.f18188d.d(this.a);
                b bVar2 = this.f18188d;
                a.InterfaceC1374a interfaceC1374a = bVar2.f18185d;
                if (interfaceC1374a != null) {
                    interfaceC1374a.B0(bVar2.a);
                }
                if (this.a.g()) {
                    StatisticItem statisticItem = new StatisticItem("c13682");
                    statisticItem.param("obj_type", 2);
                    statisticItem.param("obj_locate", 1);
                    statisticItem.param("obj_source", this.f18187c);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* renamed from: c.a.p0.s2.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1375b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18189b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f18190c;

        public C1375b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090f19);
            this.f18189b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090f27);
            this.f18190c = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091c8a);
            SkinManager.setViewTextColor(this.f18189b, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundResource(view, R.drawable.bg_interest_item_selection);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(List<c.a.p0.s2.c.b> list, Context context) {
        super(list, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((List) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void f(ImageView imageView, c.a.p0.s2.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, imageView, bVar) == null) {
            if (bVar.g()) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.obfuscated_res_0x7f080606, SvgManager.SvgResourceStateType.NORMAL);
            } else {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.obfuscated_res_0x7f0805ea, SvgManager.SvgResourceStateType.NORMAL);
            }
        }
    }

    @Override // c.a.p0.s2.a.a, android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<c.a.p0.s2.c.b> list = this.f18184c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // c.a.p0.s2.a.a, android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // c.a.p0.s2.a.a, android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1375b c1375b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f18183b).inflate(R.layout.obfuscated_res_0x7f0d0501, viewGroup, false);
                c1375b = new C1375b(view);
                view.setTag(c1375b);
            } else {
                c1375b = (C1375b) view.getTag();
            }
            c.a.p0.s2.c.b bVar = this.f18184c.get(i);
            if (bVar == null) {
                return view;
            }
            if (bVar.d() > 0) {
                SkinManager.setImageResource(c1375b.a, bVar.d());
            }
            c1375b.f18189b.setText(bVar.f());
            f(c1375b.f18190c, bVar);
            if (bVar.g()) {
                this.a++;
            }
            view.setOnClickListener(new a(this, bVar, c1375b, i));
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

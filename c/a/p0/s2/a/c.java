package c.a.p0.s2.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.p0.s2.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends c.a.p0.s2.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.s2.c.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f18191b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f18192c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f18193d;

        public a(c cVar, c.a.p0.s2.c.b bVar, b bVar2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar, bVar2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18193d = cVar;
            this.a = bVar;
            this.f18191b = bVar2;
            this.f18192c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.p0.s2.c.b bVar = this.a;
                bVar.l(!bVar.g());
                c cVar = this.f18193d;
                b bVar2 = this.f18191b;
                cVar.f(bVar2.f18196d, bVar2.f18197e, this.a);
                this.f18193d.d(this.a);
                c cVar2 = this.f18193d;
                a.InterfaceC1374a interfaceC1374a = cVar2.f18185d;
                if (interfaceC1374a != null) {
                    interfaceC1374a.B0(cVar2.a);
                }
                if (this.a.g()) {
                    StatisticItem statisticItem = new StatisticItem("c13682");
                    statisticItem.param("obj_type", 2);
                    statisticItem.param("obj_locate", 1);
                    statisticItem.param("obj_source", this.f18192c);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f18194b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f18195c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f18196d;

        /* renamed from: e  reason: collision with root package name */
        public View f18197e;

        public b(View view) {
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
            this.a = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090f23);
            this.f18194b = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f090f19);
            this.f18195c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090f27);
            this.f18196d = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091c8a);
            this.f18197e = view.findViewById(R.id.obfuscated_res_0x7f090f1a);
            int k = n.k(TbadkCoreApplication.getInst()) / 5;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(k, k);
            this.f18194b.setLayoutParams(layoutParams);
            this.f18197e.setLayoutParams(layoutParams);
        }

        public void a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f18195c);
                d2.v(R.color.CAM_X0105);
                d2.z(R.dimen.T_X06);
                this.f18194b.setConrers(15);
                this.f18194b.setIsRound(true);
                this.f18194b.setDrawBorder(true);
                this.f18194b.setPlaceHolder(3);
                this.f18194b.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                this.f18194b.setBorderWidth(n.f(context, R.dimen.L_X02));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(List<c.a.p0.s2.c.b> list, Context context) {
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

    public final void f(ImageView imageView, View view, c.a.p0.s2.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, imageView, view, bVar) == null) {
            if (bVar.g()) {
                SkinManager.setImageResource(imageView, R.drawable.icon_interest_checked);
                TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0608).into(view);
                return;
            }
            SkinManager.setImageResource(imageView, R.drawable.icon_interest_unchecked);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0601).into(view);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f18183b).inflate(R.layout.obfuscated_res_0x7f0d0502, viewGroup, false);
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.a(this.f18183b);
            c.a.p0.s2.c.b bVar2 = this.f18184c.get(i);
            if (bVar2 == null) {
                return view;
            }
            bVar.f18194b.J(bVar2.c(), 25, false);
            bVar.f18195c.setText(bVar2.b());
            f(bVar.f18196d, bVar.f18197e, bVar2);
            view.setOnClickListener(new a(this, bVar2, bVar, i));
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

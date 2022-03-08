package c.a.r0.q2.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.r0.q2.a.a;
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
public class c extends c.a.r0.q2.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.q2.c.b f21025e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f21026f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f21027g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f21028h;

        public a(c cVar, c.a.r0.q2.c.b bVar, b bVar2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar, bVar2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21028h = cVar;
            this.f21025e = bVar;
            this.f21026f = bVar2;
            this.f21027g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.r0.q2.c.b bVar = this.f21025e;
                bVar.l(!bVar.g());
                c cVar = this.f21028h;
                b bVar2 = this.f21026f;
                cVar.f(bVar2.f21031d, bVar2.f21032e, this.f21025e);
                this.f21028h.d(this.f21025e);
                c cVar2 = this.f21028h;
                a.InterfaceC1320a interfaceC1320a = cVar2.f21018h;
                if (interfaceC1320a != null) {
                    interfaceC1320a.onSelectCountChanged(cVar2.f21015e);
                }
                if (this.f21025e.g()) {
                    StatisticItem statisticItem = new StatisticItem("c13682");
                    statisticItem.param("obj_type", 2);
                    statisticItem.param("obj_locate", 1);
                    statisticItem.param("obj_source", this.f21027g);
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
        public HeadImageView f21029b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f21030c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f21031d;

        /* renamed from: e  reason: collision with root package name */
        public View f21032e;

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
            this.a = (LinearLayout) view.findViewById(R.id.interest_selection_rootview);
            this.f21029b = (HeadImageView) view.findViewById(R.id.interest_icon);
            this.f21030c = (TextView) view.findViewById(R.id.interest_text);
            this.f21031d = (ImageView) view.findViewById(R.id.select_status_view);
            this.f21032e = view.findViewById(R.id.interest_icon_cover);
            int k = n.k(TbadkCoreApplication.getInst()) / 5;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(k, k);
            this.f21029b.setLayoutParams(layoutParams);
            this.f21032e.setLayoutParams(layoutParams);
        }

        public void a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
                c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(this.f21030c);
                d2.v(R.color.CAM_X0105);
                d2.z(R.dimen.T_X06);
                this.f21029b.setConrers(15);
                this.f21029b.setIsRound(true);
                this.f21029b.setDrawBorder(true);
                this.f21029b.setPlaceHolder(3);
                this.f21029b.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                this.f21029b.setBorderWidth(n.f(context, R.dimen.L_X02));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(List<c.a.r0.q2.c.b> list, Context context) {
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

    public final void f(ImageView imageView, View view, c.a.r0.q2.c.b bVar) {
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
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f21016f).inflate(R.layout.list_item_interest_selection_style_a, viewGroup, false);
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.a(this.f21016f);
            c.a.r0.q2.c.b bVar2 = this.f21017g.get(i2);
            if (bVar2 == null) {
                return view;
            }
            bVar.f21029b.startLoad(bVar2.c(), 25, false);
            bVar.f21030c.setText(bVar2.b());
            f(bVar.f21031d, bVar.f21032e, bVar2);
            view.setOnClickListener(new a(this, bVar2, bVar, i2));
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

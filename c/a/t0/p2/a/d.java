package c.a.t0.p2.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.t0.p2.a.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends c.a.t0.p2.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.p2.c.b f21122e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f21123f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f21124g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f21125h;

        public a(d dVar, c.a.t0.p2.c.b bVar, b bVar2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bVar, bVar2, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21125h = dVar;
            this.f21122e = bVar;
            this.f21123f = bVar2;
            this.f21124g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.t0.p2.c.b bVar = this.f21122e;
                bVar.l(!bVar.g());
                this.f21125h.g(this.f21123f, this.f21122e);
                this.f21125h.d(this.f21122e);
                d dVar = this.f21125h;
                a.InterfaceC1314a interfaceC1314a = dVar.f21107h;
                if (interfaceC1314a != null) {
                    interfaceC1314a.onSelectCountChanged(dVar.f21104e);
                }
                if (this.f21122e.g()) {
                    StatisticItem statisticItem = new StatisticItem("c13682");
                    statisticItem.param("obj_type", 2);
                    statisticItem.param("obj_locate", 1);
                    statisticItem.param("obj_source", this.f21124g);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f21126b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f21127c;

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
            this.f21126b = (TbImageView) view.findViewById(R.id.interest_icon);
            this.f21127c = (TextView) view.findViewById(R.id.interest_text);
            int k = (n.k(TbadkCoreApplication.getInst()) / 4) + n.f(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            this.a.setLayoutParams(new LinearLayout.LayoutParams(k, k));
            int i4 = k / 3;
            this.f21126b.setLayoutParams(new LinearLayout.LayoutParams(i4, i4));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(List<c.a.t0.p2.c.b> list, Context context) {
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

    public final Bitmap f(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bitmap, i2)) == null) {
            if (bitmap == null) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            return createBitmap;
        }
        return (Bitmap) invokeLI.objValue;
    }

    public final void g(b bVar, c.a.t0.p2.c.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2) == null) {
            if (bVar2.g()) {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0302).setShapeRadius(n.f(this.f21105f, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0807).setShadowSide(ShadowDrawable.ALL).setShadowRadius(n.f(this.f21105f, R.dimen.tbds20)).setOffsetX(0).setOffsetY(n.f(this.f21105f, R.dimen.tbds10)).into(bVar.a);
                c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(bVar.f21127c);
                d2.v(R.color.CAM_X0313);
                d2.A(R.dimen.T_X06);
                if (bVar.f21126b.getBdImage() == null || StringUtils.isNull(bVar.f21126b.getBdImage().q())) {
                    return;
                }
                bVar.f21126b.setImageBitmap(f(bVar.f21126b.getBdImage().p(), -1));
                return;
            }
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0201).setShapeRadius(n.f(this.f21105f, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(n.f(this.f21105f, R.dimen.tbds20)).setOffsetX(0).setOffsetY(n.f(this.f21105f, R.dimen.tbds10)).into(bVar.a);
            c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(bVar.f21127c);
            d3.v(R.color.CAM_X0105);
            d3.A(R.dimen.T_X06);
            bVar.f21126b.setImageBitmap(null);
            bVar.f21126b.setPlaceHolder(1);
            bVar.f21126b.startLoad(bVar2.a(), 25, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f21105f).inflate(R.layout.list_item_interest_selection_style_b, viewGroup, false);
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            c.a.t0.p2.c.b bVar2 = this.f21106g.get(i2);
            if (bVar2 == null) {
                return view;
            }
            bVar.f21127c.setText(bVar2.b());
            g(bVar, bVar2);
            view.setOnClickListener(new a(this, bVar2, bVar, i2));
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

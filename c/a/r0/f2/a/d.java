package c.a.r0.f2.a;

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
import c.a.e.e.p.l;
import c.a.r0.f2.a.a;
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
/* loaded from: classes3.dex */
public class d extends c.a.r0.f2.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.f2.c.b f17589e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f17590f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17591g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f17592h;

        public a(d dVar, c.a.r0.f2.c.b bVar, b bVar2, int i2) {
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
            this.f17592h = dVar;
            this.f17589e = bVar;
            this.f17590f = bVar2;
            this.f17591g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.r0.f2.c.b bVar = this.f17589e;
                bVar.l(!bVar.g());
                this.f17592h.g(this.f17590f, this.f17589e);
                this.f17592h.d(this.f17589e);
                d dVar = this.f17592h;
                a.InterfaceC0861a interfaceC0861a = dVar.f17572h;
                if (interfaceC0861a != null) {
                    interfaceC0861a.onSelectCountChanged(dVar.f17569e);
                }
                if (this.f17589e.g()) {
                    StatisticItem statisticItem = new StatisticItem("c13682");
                    statisticItem.param("obj_type", 2);
                    statisticItem.param("obj_locate", 1);
                    statisticItem.param("obj_source", this.f17591g);
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
        public LinearLayout f17593a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f17594b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17595c;

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
            this.f17593a = (LinearLayout) view.findViewById(R.id.interest_selection_rootview);
            this.f17594b = (TbImageView) view.findViewById(R.id.interest_icon);
            this.f17595c = (TextView) view.findViewById(R.id.interest_text);
            int k = (l.k(TbadkCoreApplication.getInst()) / 4) + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            this.f17593a.setLayoutParams(new LinearLayout.LayoutParams(k, k));
            int i4 = k / 3;
            this.f17594b.setLayoutParams(new LinearLayout.LayoutParams(i4, i4));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(List<c.a.r0.f2.c.b> list, Context context) {
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

    public final void g(b bVar, c.a.r0.f2.c.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2) == null) {
            if (bVar2.g()) {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0302).setShapeRadius(l.g(this.f17570f, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0807).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.f17570f, R.dimen.tbds20)).setOffsetX(0).setOffsetY(l.g(this.f17570f, R.dimen.tbds10)).into(bVar.f17593a);
                c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(bVar.f17595c);
                d2.w(R.color.CAM_X0313);
                d2.B(R.dimen.T_X06);
                if (bVar.f17594b.getBdImage() == null || StringUtils.isNull(bVar.f17594b.getBdImage().q())) {
                    return;
                }
                bVar.f17594b.setImageBitmap(f(bVar.f17594b.getBdImage().p(), -1));
                return;
            }
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0201).setShapeRadius(l.g(this.f17570f, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.f17570f, R.dimen.tbds20)).setOffsetX(0).setOffsetY(l.g(this.f17570f, R.dimen.tbds10)).into(bVar.f17593a);
            c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(bVar.f17595c);
            d3.w(R.color.CAM_X0105);
            d3.B(R.dimen.T_X06);
            bVar.f17594b.setImageBitmap(null);
            bVar.f17594b.setPlaceHolder(1);
            bVar.f17594b.startLoad(bVar2.a(), 25, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f17570f).inflate(R.layout.list_item_interest_selection_style_b, viewGroup, false);
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            c.a.r0.f2.c.b bVar2 = this.f17571g.get(i2);
            if (bVar2 == null) {
                return view;
            }
            bVar.f17595c.setText(bVar2.b());
            g(bVar, bVar2);
            view.setOnClickListener(new a(this, bVar2, bVar, i2));
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

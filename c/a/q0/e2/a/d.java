package c.a.q0.e2.a;

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
import c.a.q0.e2.a.a;
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
public class d extends c.a.q0.e2.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.e2.c.b f16975e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f16976f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f16977g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f16978h;

        public a(d dVar, c.a.q0.e2.c.b bVar, b bVar2, int i2) {
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
            this.f16978h = dVar;
            this.f16975e = bVar;
            this.f16976f = bVar2;
            this.f16977g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.q0.e2.c.b bVar = this.f16975e;
                bVar.l(!bVar.g());
                this.f16978h.g(this.f16976f, this.f16975e);
                this.f16978h.d(this.f16975e);
                d dVar = this.f16978h;
                a.InterfaceC0821a interfaceC0821a = dVar.f16958h;
                if (interfaceC0821a != null) {
                    interfaceC0821a.onSelectCountChanged(dVar.f16955e);
                }
                if (this.f16975e.g()) {
                    StatisticItem statisticItem = new StatisticItem("c13682");
                    statisticItem.param("obj_type", 2);
                    statisticItem.param("obj_locate", 1);
                    statisticItem.param("obj_source", this.f16977g);
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
        public LinearLayout f16979a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f16980b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16981c;

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
            this.f16979a = (LinearLayout) view.findViewById(R.id.interest_selection_rootview);
            this.f16980b = (TbImageView) view.findViewById(R.id.interest_icon);
            this.f16981c = (TextView) view.findViewById(R.id.interest_text);
            int k = (l.k(TbadkCoreApplication.getInst()) / 4) + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            this.f16979a.setLayoutParams(new LinearLayout.LayoutParams(k, k));
            int i4 = k / 3;
            this.f16980b.setLayoutParams(new LinearLayout.LayoutParams(i4, i4));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(List<c.a.q0.e2.c.b> list, Context context) {
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

    public final void g(b bVar, c.a.q0.e2.c.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2) == null) {
            if (bVar2.g()) {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0302).setShapeRadius(l.g(this.f16956f, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0807).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.f16956f, R.dimen.tbds20)).setOffsetX(0).setOffsetY(l.g(this.f16956f, R.dimen.tbds10)).into(bVar.f16979a);
                c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(bVar.f16981c);
                d2.u(R.color.CAM_X0313);
                d2.z(R.dimen.T_X06);
                if (bVar.f16980b.getBdImage() == null || StringUtils.isNull(bVar.f16980b.getBdImage().q())) {
                    return;
                }
                bVar.f16980b.setImageBitmap(f(bVar.f16980b.getBdImage().p(), -1));
                return;
            }
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0201).setShapeRadius(l.g(this.f16956f, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.f16956f, R.dimen.tbds20)).setOffsetX(0).setOffsetY(l.g(this.f16956f, R.dimen.tbds10)).into(bVar.f16979a);
            c.a.p0.s.u.c d3 = c.a.p0.s.u.c.d(bVar.f16981c);
            d3.u(R.color.CAM_X0105);
            d3.z(R.dimen.T_X06);
            bVar.f16980b.setImageBitmap(null);
            bVar.f16980b.setPlaceHolder(1);
            bVar.f16980b.startLoad(bVar2.a(), 25, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f16956f).inflate(R.layout.list_item_interest_selection_style_b, viewGroup, false);
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            c.a.q0.e2.c.b bVar2 = this.f16957g.get(i2);
            if (bVar2 == null) {
                return view;
            }
            bVar.f16981c.setText(bVar2.b());
            g(bVar, bVar2);
            view.setOnClickListener(new a(this, bVar2, bVar, i2));
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

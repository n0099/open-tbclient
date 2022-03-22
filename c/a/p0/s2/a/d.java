package c.a.p0.s2.a;

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
import c.a.p0.s2.a.a;
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
/* loaded from: classes2.dex */
public class d extends c.a.p0.s2.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.s2.c.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f18198b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f18199c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f18200d;

        public a(d dVar, c.a.p0.s2.c.b bVar, b bVar2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bVar, bVar2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18200d = dVar;
            this.a = bVar;
            this.f18198b = bVar2;
            this.f18199c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.p0.s2.c.b bVar = this.a;
                bVar.l(!bVar.g());
                this.f18200d.g(this.f18198b, this.a);
                this.f18200d.d(this.a);
                d dVar = this.f18200d;
                a.InterfaceC1374a interfaceC1374a = dVar.f18185d;
                if (interfaceC1374a != null) {
                    interfaceC1374a.B0(dVar.a);
                }
                if (this.a.g()) {
                    StatisticItem statisticItem = new StatisticItem("c13682");
                    statisticItem.param("obj_type", 2);
                    statisticItem.param("obj_locate", 1);
                    statisticItem.param("obj_source", this.f18199c);
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
        public TbImageView f18201b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f18202c;

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
            this.f18201b = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090f19);
            this.f18202c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090f27);
            int k = (n.k(TbadkCoreApplication.getInst()) / 4) + n.f(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            this.a.setLayoutParams(new LinearLayout.LayoutParams(k, k));
            int i3 = k / 3;
            this.f18201b.setLayoutParams(new LinearLayout.LayoutParams(i3, i3));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(List<c.a.p0.s2.c.b> list, Context context) {
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

    public final Bitmap f(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bitmap, i)) == null) {
            if (bitmap == null) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            return createBitmap;
        }
        return (Bitmap) invokeLI.objValue;
    }

    public final void g(b bVar, c.a.p0.s2.c.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, bVar2) == null) {
            if (bVar2.g()) {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0302).setShapeRadius(n.f(this.f18183b, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0807).setShadowSide(ShadowDrawable.ALL).setShadowRadius(n.f(this.f18183b, R.dimen.tbds20)).setOffsetX(0).setOffsetY(n.f(this.f18183b, R.dimen.tbds10)).into(bVar.a);
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(bVar.f18202c);
                d2.v(R.color.CAM_X0313);
                d2.A(R.dimen.T_X06);
                if (bVar.f18201b.getBdImage() == null || StringUtils.isNull(bVar.f18201b.getBdImage().q())) {
                    return;
                }
                bVar.f18201b.setImageBitmap(f(bVar.f18201b.getBdImage().p(), -1));
                return;
            }
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0201).setShapeRadius(n.f(this.f18183b, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(n.f(this.f18183b, R.dimen.tbds20)).setOffsetX(0).setOffsetY(n.f(this.f18183b, R.dimen.tbds10)).into(bVar.a);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(bVar.f18202c);
            d3.v(R.color.CAM_X0105);
            d3.A(R.dimen.T_X06);
            bVar.f18201b.setImageBitmap(null);
            bVar.f18201b.setPlaceHolder(1);
            bVar.f18201b.J(bVar2.a(), 25, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f18183b).inflate(R.layout.obfuscated_res_0x7f0d0503, viewGroup, false);
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            c.a.p0.s2.c.b bVar2 = this.f18184c.get(i);
            if (bVar2 == null) {
                return view;
            }
            bVar.f18202c.setText(bVar2.b());
            g(bVar, bVar2);
            view.setOnClickListener(new a(this, bVar2, bVar, i));
            return view;
        }
        return (View) invokeILL.objValue;
    }
}

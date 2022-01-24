package c.a.t0.y2.j;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends c.a.t0.g0.b<c.a.t0.y2.e.g> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public View n;
    public View o;
    public TextView p;
    public HTypeListView q;
    public c.a.t0.y2.c.o r;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.y2.e.g f25804e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f25805f;

        public a(e eVar, c.a.t0.y2.e.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25805f = eVar;
            this.f25804e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25805f.q(this.f25804e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = tbPageContext;
        View j2 = j();
        this.n = j2;
        this.o = j2.findViewById(c.a.t0.z2.d.divider_view);
        this.p = (TextView) this.n.findViewById(c.a.t0.z2.d.gift_title);
        HTypeListView hTypeListView = (HTypeListView) this.n.findViewById(c.a.t0.z2.d.gift_horizontal_list);
        this.q = hTypeListView;
        this.r = new c.a.t0.y2.c.o(this.m, hTypeListView);
    }

    @Override // c.a.t0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.t0.z2.e.card_gift_list : invokeV.intValue;
    }

    @Override // c.a.t0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundColor(this.n, c.a.t0.z2.a.CAM_X0201);
            SkinManager.setBackgroundColor(this.o, c.a.t0.z2.a.CAM_X0204);
            SkinManager.setViewTextColor(this.p, c.a.t0.z2.a.CAM_X0109);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final void q(c.a.t0.y2.e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                this.m.showToast(c.a.t0.z2.g.gift_load_fail);
            } else if (ViewHelper.checkUpIsLogin(this.m.getPageActivity())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.m.getPageActivity(), gVar.f25709g, gVar.f25710h, gVar.f25711i, gVar.f25712j)));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.g0.b
    /* renamed from: s */
    public void k(c.a.t0.y2.e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            if (gVar != null && gVar.isValid()) {
                a aVar = new a(this, gVar);
                this.r.a(aVar);
                this.n.setOnClickListener(aVar);
                this.r.b(aVar);
                this.q.setData(t(gVar.k));
                if (gVar.f25707e) {
                    this.p.setText(c.a.t0.z2.g.gift_received_by_me);
                } else if (gVar.f25708f) {
                    this.p.setText(c.a.t0.z2.g.gift_received_by_him);
                } else {
                    this.p.setText(c.a.t0.z2.g.gift_received_by_her);
                }
                l(this.m, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.n.setVisibility(8);
        }
    }

    public final List<c.a.d.n.e.n> t(List<c.a.d.n.e.n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            int count = ListUtils.getCount(list);
            if (count <= 0) {
                return list;
            }
            List<c.a.d.n.e.n> arrayList = new ArrayList<>(list);
            int f2 = c.a.d.f.p.n.f(this.f17589f.getPageActivity(), c.a.t0.z2.b.ds100);
            int f3 = c.a.d.f.p.n.f(this.f17589f.getPageActivity(), c.a.t0.z2.b.ds32);
            if (count > 7) {
                arrayList = arrayList.subList(0, 7);
                c.a.t0.y2.e.h hVar = new c.a.t0.y2.e.h();
                hVar.f25715f = f2;
                hVar.f25714e = f2;
                ListUtils.add(arrayList, hVar);
            }
            c.a.t0.v2.d dVar = new c.a.t0.v2.d(f3, f2);
            ListUtils.add(arrayList, 0, dVar);
            ListUtils.add(arrayList, dVar);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}

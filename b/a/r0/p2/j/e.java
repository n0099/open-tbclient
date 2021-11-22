package b.a.r0.p2.j;

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
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class e extends b.a.r0.b0.b<b.a.r0.p2.e.g> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public View n;
    public View o;
    public TextView p;
    public HTypeListView q;
    public b.a.r0.p2.c.o r;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.p2.e.g f23890e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f23891f;

        public a(e eVar, b.a.r0.p2.e.g gVar) {
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
            this.f23891f = eVar;
            this.f23890e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23891f.p(this.f23890e);
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
        View i4 = i();
        this.n = i4;
        this.o = i4.findViewById(R.id.divider_view);
        this.p = (TextView) this.n.findViewById(R.id.gift_title);
        HTypeListView hTypeListView = (HTypeListView) this.n.findViewById(R.id.gift_horizontal_list);
        this.q = hTypeListView;
        this.r = new b.a.r0.p2.c.o(this.m, hTypeListView);
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_gift_list : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0109);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final void p(b.a.r0.p2.e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
                this.m.showToast(R.string.gift_load_fail);
            } else if (ViewHelper.checkUpIsLogin(this.m.getPageActivity())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MyGiftListActivityConfig(this.m.getPageActivity(), gVar.f23777g, gVar.f23778h, gVar.f23779i, gVar.j)));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: q */
    public void j(b.a.r0.p2.e.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            if (gVar != null && gVar.isValid()) {
                a aVar = new a(this, gVar);
                this.r.a(aVar);
                this.n.setOnClickListener(aVar);
                this.r.b(aVar);
                this.q.setData(s(gVar.k));
                if (gVar.f23775e) {
                    this.p.setText(R.string.gift_received_by_me);
                } else if (gVar.f23776f) {
                    this.p.setText(R.string.gift_received_by_him);
                } else {
                    this.p.setText(R.string.gift_received_by_her);
                }
                k(this.m, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.n.setVisibility(8);
        }
    }

    public final List<b.a.e.m.e.n> s(List<b.a.e.m.e.n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            int count = ListUtils.getCount(list);
            if (count <= 0) {
                return list;
            }
            List<b.a.e.m.e.n> arrayList = new ArrayList<>(list);
            int g2 = b.a.e.f.p.l.g(this.f16224f.getPageActivity(), R.dimen.ds100);
            int g3 = b.a.e.f.p.l.g(this.f16224f.getPageActivity(), R.dimen.ds32);
            if (count > 7) {
                arrayList = arrayList.subList(0, 7);
                b.a.r0.p2.e.h hVar = new b.a.r0.p2.e.h();
                hVar.f23782f = g2;
                hVar.f23781e = g2;
                ListUtils.add(arrayList, hVar);
            }
            b.a.r0.m2.d dVar = new b.a.r0.m2.d(g3, g2);
            ListUtils.add(arrayList, 0, dVar);
            ListUtils.add(arrayList, dVar);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}

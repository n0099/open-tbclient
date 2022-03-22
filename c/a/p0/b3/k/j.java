package c.a.p0.b3.k;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class j extends c.a.p0.h0.b<c.a.p0.b3.e.m> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long i;
    public View j;
    public TextView k;
    public HTypeListView l;
    public c.a.p0.b3.c.o m;
    public View.OnClickListener n;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.s();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new a(this);
        this.f15310h = 4;
        View k = k();
        this.j = k;
        this.k = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090563);
        HTypeListView hTypeListView = (HTypeListView) this.j.findViewById(R.id.obfuscated_res_0x7f090564);
        this.l = hTypeListView;
        this.m = new c.a.p0.b3.c.o(this.f15304b, hTypeListView);
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01b3 : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || i == this.a) {
            return;
        }
        this.a = i;
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoListActivityConfig(this.f15305c).createNormalCfg(this.i, "personal")));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: t */
    public void l(c.a.p0.b3.e.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mVar) == null) {
            if (mVar != null && !ListUtils.isEmpty(mVar.f12739b)) {
                this.i = mVar.a;
                this.k.setText(R.string.obfuscated_res_0x7f0f14f7);
                this.l.setData(u(mVar.f12739b));
                this.m.b(this.n);
                return;
            }
            this.j.setVisibility(8);
        }
    }

    public final List<c.a.d.o.e.n> u(List<c.a.d.o.e.n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            int count = ListUtils.getCount(list);
            if (count <= 0) {
                return list;
            }
            List<c.a.d.o.e.n> arrayList = new ArrayList<>(list);
            int f2 = c.a.d.f.p.n.f(this.f15304b.getPageActivity(), R.dimen.obfuscated_res_0x7f0702c7);
            int f3 = c.a.d.f.p.n.f(this.f15304b.getPageActivity(), R.dimen.obfuscated_res_0x7f070207);
            if (count > 3) {
                arrayList = arrayList.subList(0, 3);
                c.a.p0.b3.e.h hVar = new c.a.p0.b3.e.h();
                hVar.a = c.a.d.f.p.n.f(this.f15304b.getPageActivity(), R.dimen.obfuscated_res_0x7f070235);
                hVar.f12726b = c.a.d.f.p.n.f(this.f15304b.getPageActivity(), R.dimen.obfuscated_res_0x7f0702af);
                ListUtils.add(arrayList, hVar);
            }
            c.a.p0.y2.d dVar = new c.a.p0.y2.d(f3, f2);
            ListUtils.add(arrayList, 0, dVar);
            ListUtils.add(arrayList, dVar);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}

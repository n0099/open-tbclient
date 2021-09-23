package c.a.r0.o2.j;

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
/* loaded from: classes3.dex */
public class j extends c.a.r0.a0.b<c.a.r0.o2.e.m> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long m;
    public View n;
    public TextView o;
    public HTypeListView p;
    public c.a.r0.o2.c.o q;
    public View.OnClickListener r;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f23344e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23344e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23344e.q();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new a(this);
        this.l = 4;
        View j2 = j();
        this.n = j2;
        this.o = (TextView) j2.findViewById(R.id.card_person_vedio_list_title);
        HTypeListView hTypeListView = (HTypeListView) this.n.findViewById(R.id.card_person_vedio_view_pager);
        this.p = hTypeListView;
        this.q = new c.a.r0.o2.c.o(this.f15558f, hTypeListView);
    }

    @Override // c.a.r0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_person_vedio_list_view : invokeV.intValue;
    }

    @Override // c.a.r0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || i2 == this.f15557e) {
            return;
        }
        this.f15557e = i2;
        SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoListActivityConfig(this.f15559g).createNormalCfg(this.m, "personal")));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a0.b
    /* renamed from: s */
    public void k(c.a.r0.o2.e.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mVar) == null) {
            if (mVar != null && !ListUtils.isEmpty(mVar.f23250f)) {
                this.m = mVar.f23249e;
                this.o.setText(R.string.video_title_str);
                this.p.setData(t(mVar.f23250f));
                this.q.b(this.r);
                return;
            }
            this.n.setVisibility(8);
        }
    }

    public final List<c.a.e.l.e.n> t(List<c.a.e.l.e.n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            int count = ListUtils.getCount(list);
            if (count <= 0) {
                return list;
            }
            List<c.a.e.l.e.n> arrayList = new ArrayList<>(list);
            int g2 = c.a.e.e.p.l.g(this.f15558f.getPageActivity(), R.dimen.ds490);
            int g3 = c.a.e.e.p.l.g(this.f15558f.getPageActivity(), R.dimen.ds32);
            if (count > 3) {
                arrayList = arrayList.subList(0, 3);
                c.a.r0.o2.e.h hVar = new c.a.r0.o2.e.h();
                hVar.f23231e = c.a.e.e.p.l.g(this.f15558f.getPageActivity(), R.dimen.ds120);
                hVar.f23232f = c.a.e.e.p.l.g(this.f15558f.getPageActivity(), R.dimen.ds396);
                ListUtils.add(arrayList, hVar);
            }
            c.a.r0.l2.d dVar = new c.a.r0.l2.d(g3, g2);
            ListUtils.add(arrayList, 0, dVar);
            ListUtils.add(arrayList, dVar);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}

package c.a.p0.w0.o;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.adapter.ClassFitionForumItemAdapter;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends c.a.o0.k0.f.a<c.a.p0.w0.e.c, c.a.p0.w0.e.e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f19586g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f19587h;
    public RecyclerView i;
    public EMTextView j;
    public ImageView k;
    public ClassFitionForumItemAdapter l;
    public List<c.a.p0.w0.e.b> m;
    public boolean n;

    /* loaded from: classes2.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.p0.w0.o.c.b
        public void a(List<c.a.p0.w0.e.b> list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) {
                if (i == list.size() - 1) {
                    c cVar = this.a;
                    cVar.n = !cVar.n;
                    this.a.l.update(this.a.r());
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(this.a.f19586g.getString(R.string.obfuscated_res_0x7f0f069e), list.get(i).b());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921678, hashMap));
                TiebaStatic.log(new StatisticItem("c14583").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", i + 1));
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(List<c.a.p0.w0.e.b> list, int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter, h hVar, EnterForumModel enterForumModel) {
        super(tbPageContext, view, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, viewEventCenter, hVar, enterForumModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = false;
        this.f19586g = tbPageContext;
        this.j = (EMTextView) view.findViewById(R.id.obfuscated_res_0x7f09202b);
        this.k = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f0902a6);
        this.f19587h = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090489);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.obfuscated_res_0x7f091a27);
        this.i = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        this.i.setLayoutManager(new GridLayoutManager(getContext(), 5));
        ClassFitionForumItemAdapter classFitionForumItemAdapter = new ClassFitionForumItemAdapter(tbPageContext, null);
        this.l = classFitionForumItemAdapter;
        this.i.setAdapter(classFitionForumItemAdapter);
        this.l.f(new a(this));
    }

    @Override // c.a.p0.a4.v
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i)) == null) {
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f19587h);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.j);
            d3.A(R.string.F_X02);
            d3.z(R.dimen.T_X07);
            d3.v(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.k, R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final List<c.a.p0.w0.e.b> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.m);
            if (this.n) {
                if (this.m.size() >= 14) {
                    List<c.a.p0.w0.e.b> subList = arrayList.subList(0, 14);
                    subList.add(new c.a.p0.w0.e.b(this.f19586g.getString(R.string.obfuscated_res_0x7f0f0620), R.drawable.obfuscated_res_0x7f0807d9));
                    return subList;
                }
                return arrayList;
            } else if (this.m.size() >= 9) {
                List<c.a.p0.w0.e.b> subList2 = arrayList.subList(0, 9);
                subList2.add(new c.a.p0.w0.e.b(this.f19586g.getString(R.string.obfuscated_res_0x7f0f0aca), R.drawable.obfuscated_res_0x7f080829));
                return subList2;
            } else {
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.k0.f.e
    /* renamed from: s */
    public void i(c.a.p0.w0.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            super.i(cVar);
            this.m = cVar.k();
            this.l.update(r());
            this.j.setText(cVar.getTitle());
            onChangeSkinType(d(), TbadkCoreApplication.getInst().getSkinType());
        }
    }
}

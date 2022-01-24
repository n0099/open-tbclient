package c.a.t0.y2.j;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.personPolymeric.view.PersonCommonForumCardView;
import com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends c.a.t0.g0.b<c.a.t0.y2.e.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public int n;
    public c.a.t0.y2.e.c o;
    public b p;
    public c.a.d.f.k.b<PersonCommonForumItemView> q;
    public TextView r;
    public ListViewPager s;

    /* renamed from: c.a.t0.y2.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class C1556a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public class b extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) && (obj instanceof PersonCommonForumCardView)) {
                PersonCommonForumCardView personCommonForumCardView = (PersonCommonForumCardView) obj;
                personCommonForumCardView.recycle();
                viewGroup.removeView(personCommonForumCardView);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.o == null || ListUtils.isEmpty(this.a.o.f25690e)) {
                    return 0;
                }
                return this.a.o.f25690e.size() % 4 == 0 ? this.a.o.f25690e.size() / 4 : (this.a.o.f25690e.size() / 4) + 1;
            }
            return invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) {
                List<c.a.t0.y2.e.f> u = this.a.u(i2);
                if (ListUtils.isEmpty(u)) {
                    return null;
                }
                PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(this.a.m.getPageActivity());
                personCommonForumCardView.setForumItemViewBdObjectPool(this.a.q);
                personCommonForumCardView.setData(u);
                personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(c.a.t0.z2.b.tbds42));
                viewGroup.addView(personCommonForumCardView);
                return personCommonForumCardView;
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
        }

        public /* synthetic */ b(a aVar, C1556a c1556a) {
            this(aVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext) {
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
        this.n = 3;
        this.p = new b(this, null);
        this.m = tbPageContext;
        View j2 = j();
        this.r = (TextView) j2.findViewById(c.a.t0.z2.d.common_forum_title);
        this.s = (ListViewPager) j2.findViewById(c.a.t0.z2.d.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            j2.setLayerType(2, null);
            if (j2 instanceof ViewGroup) {
                ((ViewGroup) j2).setClipChildren(true);
            }
        }
        this.s.setOffscreenPageLimit(1);
    }

    @Override // c.a.t0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.t0.z2.e.person_info_common_forum_layout : invokeV.intValue;
    }

    @Override // c.a.t0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (this.n != i2) {
                SkinManager.setBackgroundResource(j(), c.a.t0.z2.a.CAM_X0201);
                SkinManager.setViewTextColor(this.r, c.a.t0.z2.a.CAM_X0109);
                int childCount = this.s.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = this.s.getChildAt(i3);
                    if (childAt instanceof PersonCommonForumCardView) {
                        ((PersonCommonForumCardView) childAt).onChangeSkinType();
                    }
                }
            }
            this.n = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final List<c.a.t0.y2.e.f> u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            c.a.t0.y2.e.c cVar = this.o;
            if (cVar == null || ListUtils.isEmpty(cVar.f25690e)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = i2 * 4;
            for (int i4 = i3; i4 < i3 + 4; i4++) {
                c.a.t0.y2.e.f fVar = (c.a.t0.y2.e.f) ListUtils.getItem(this.o.f25690e, i4);
                if (fVar != null) {
                    arrayList.add(fVar);
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public final boolean v(c.a.t0.y2.e.c cVar) {
        InterceptResult invokeL;
        c.a.t0.y2.e.c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
            if (cVar == null || ListUtils.isEmpty(cVar.f25690e) || cVar == (cVar2 = this.o)) {
                return false;
            }
            if (cVar2 == null || ListUtils.isEmpty(cVar2.f25690e)) {
                return true;
            }
            if (!ListUtils.isEmpty(cVar.f25690e)) {
                if (cVar.f25690e.size() != this.o.f25690e.size()) {
                    return true;
                }
                for (int i2 = 0; i2 < cVar.f25690e.size(); i2++) {
                    if (this.o.f25690e.get(i2) == null || cVar.f25690e.get(i2).f25702e != this.o.f25690e.get(i2).f25702e) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.g0.b
    /* renamed from: w */
    public void k(c.a.t0.y2.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            if (v(cVar)) {
                this.o = cVar;
                if (ListUtils.getCount(cVar.f25690e) <= 2) {
                    this.s.getLayoutParams().height = c.a.d.f.p.n.f(this.m.getPageActivity(), c.a.t0.z2.b.ds140);
                }
                this.s.setAdapter(this.p);
            }
            l(this.m, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void x(c.a.d.f.k.b<PersonCommonForumItemView> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.q = bVar;
        }
    }
}

package b.a.r0.p2.j;

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
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.view.PersonCommonForumCardView;
import com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends b.a.r0.b0.b<b.a.r0.p2.e.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public int n;
    public b.a.r0.p2.e.c o;
    public b p;
    public b.a.e.e.k.b<PersonCommonForumItemView> q;
    public TextView r;
    public ListViewPager s;

    /* renamed from: b.a.r0.p2.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class C1093a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f22409a;

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
            this.f22409a = aVar;
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
                if (this.f22409a.o == null || ListUtils.isEmpty(this.f22409a.o.f22283e)) {
                    return 0;
                }
                return this.f22409a.o.f22283e.size() % 4 == 0 ? this.f22409a.o.f22283e.size() / 4 : (this.f22409a.o.f22283e.size() / 4) + 1;
            }
            return invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) {
                List<b.a.r0.p2.e.f> t = this.f22409a.t(i2);
                if (ListUtils.isEmpty(t)) {
                    return null;
                }
                PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(this.f22409a.m.getPageActivity());
                personCommonForumCardView.setForumItemViewBdObjectPool(this.f22409a.q);
                personCommonForumCardView.setData(t);
                personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.tbds42));
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

        public /* synthetic */ b(a aVar, C1093a c1093a) {
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
        View i4 = i();
        this.r = (TextView) i4.findViewById(R.id.common_forum_title);
        this.s = (ListViewPager) i4.findViewById(R.id.common_forum_viewpager);
        if ("NX40X".equals(Build.MODEL)) {
            i4.setLayerType(2, null);
            if (i4 instanceof ViewGroup) {
                ((ViewGroup) i4).setClipChildren(true);
            }
        }
        this.s.setOffscreenPageLimit(1);
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.person_info_common_forum_layout : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (this.n != i2) {
                SkinManager.setBackgroundResource(i(), R.color.CAM_X0201);
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
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

    public final List<b.a.r0.p2.e.f> t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            b.a.r0.p2.e.c cVar = this.o;
            if (cVar == null || ListUtils.isEmpty(cVar.f22283e)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = i2 * 4;
            for (int i4 = i3; i4 < i3 + 4; i4++) {
                b.a.r0.p2.e.f fVar = (b.a.r0.p2.e.f) ListUtils.getItem(this.o.f22283e, i4);
                if (fVar != null) {
                    arrayList.add(fVar);
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public final boolean u(b.a.r0.p2.e.c cVar) {
        InterceptResult invokeL;
        b.a.r0.p2.e.c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
            if (cVar == null || ListUtils.isEmpty(cVar.f22283e) || cVar == (cVar2 = this.o)) {
                return false;
            }
            if (cVar2 == null || ListUtils.isEmpty(cVar2.f22283e)) {
                return true;
            }
            if (!ListUtils.isEmpty(cVar.f22283e)) {
                if (cVar.f22283e.size() != this.o.f22283e.size()) {
                    return true;
                }
                for (int i2 = 0; i2 < cVar.f22283e.size(); i2++) {
                    if (this.o.f22283e.get(i2) == null || cVar.f22283e.get(i2).f22293e != this.o.f22283e.get(i2).f22293e) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: v */
    public void j(b.a.r0.p2.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            if (u(cVar)) {
                this.o = cVar;
                if (ListUtils.getCount(cVar.f22283e) <= 2) {
                    this.s.getLayoutParams().height = b.a.e.e.p.l.g(this.m.getPageActivity(), R.dimen.ds140);
                }
                this.s.setAdapter(this.p);
            }
            k(this.m, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void w(b.a.e.e.k.b<PersonCommonForumItemView> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.q = bVar;
        }
    }
}

package c.a.t0.v2.f;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import c.a.d.f.p.n;
import c.a.t0.v2.d.k;
import c.a.t0.v2.d.l;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.view.PersonCenterSmartAppPageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends c.a.t0.g0.b<k> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c.a.t0.v2.d.c> m;
    public List<PersonCenterSmartAppPageView> n;
    public BdBaseViewPager o;
    public TbTabLayout p;
    public View q;
    public a r;
    public PersonCenterSmartAppPageView s;

    /* loaded from: classes8.dex */
    public class a extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<PersonCenterSmartAppPageView> a;

        public a(d dVar, List<PersonCenterSmartAppPageView> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        public void a(List<PersonCenterSmartAppPageView> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.a = list;
                notifyDataSetChanged();
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2, obj) == null) {
                viewGroup.removeView((View) obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.size() : invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                int indexOf = this.a.indexOf(obj);
                if (indexOf == -1) {
                    return -2;
                }
                return indexOf;
            }
            return invokeL.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i2)) == null) {
                PersonCenterSmartAppPageView personCenterSmartAppPageView = this.a.get(i2);
                viewGroup.addView(personCenterSmartAppPageView);
                return personCenterSmartAppPageView;
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext<?> tbPageContext) {
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
        View j2 = j();
        this.o = (BdBaseViewPager) j2.findViewById(R.id.vp_person_center_smart_app_banner);
        this.p = (TbTabLayout) j2.findViewById(R.id.tl_person_center_smart_app_banner);
        this.q = j2.findViewById(R.id.blank_view_below_person_center_smart_app_banner);
        this.p.setTabMode(1);
        ArrayList arrayList = new ArrayList();
        this.n = arrayList;
        a aVar = new a(this, arrayList);
        this.r = aVar;
        this.o.setAdapter(aVar);
        this.p.setupWithViewPager(this.o);
        this.q.setVisibility(8);
        l(i(), this.f18209e);
    }

    @Override // c.a.t0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.person_center_smart_app_banner_layout : invokeV.intValue;
    }

    @Override // c.a.t0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            for (PersonCenterSmartAppPageView personCenterSmartAppPageView : this.n) {
                if (personCenterSmartAppPageView != null) {
                    personCenterSmartAppPageView.onChangeSkinType();
                }
            }
            SkinManager.setBackgroundColor(j(), R.color.CAM_X0205);
            this.p.setSelectedTabIndicatorColor(SkinManager.getColor(R.color.CAM_X0629));
            this.p.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(tbPageContext.getPageActivity(), R.dimen.tbds3), SkinManager.getColor(R.color.CAM_X0625)));
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0204);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    public final void p(c.a.t0.v2.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            if (this.s.isCanAddMoreSmartApp()) {
                this.s.addSmartApp(cVar);
                return;
            }
            PersonCenterSmartAppPageView personCenterSmartAppPageView = new PersonCenterSmartAppPageView(getContext());
            this.s = personCenterSmartAppPageView;
            this.n.add(personCenterSmartAppPageView);
            this.s.addSmartApp(cVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.g0.b
    /* renamed from: q */
    public void k(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) {
            if (kVar != null && kVar.g() != null && !ListUtils.isEmpty(kVar.g())) {
                o(0);
                this.n.clear();
                this.m = kVar.g();
                PersonCenterSmartAppPageView personCenterSmartAppPageView = new PersonCenterSmartAppPageView(getContext());
                this.s = personCenterSmartAppPageView;
                this.n.add(personCenterSmartAppPageView);
                int min = Math.min(7, this.m.size());
                for (int i2 = 0; i2 < min; i2++) {
                    p((c.a.t0.v2.d.c) ListUtils.getItem(this.m, i2));
                }
                if (this.m.isEmpty()) {
                    o(8);
                } else {
                    p(new l());
                }
                if (this.n.size() <= 1) {
                    this.p.setVisibility(8);
                } else {
                    this.p.setVisibility(0);
                }
                this.r.a(this.n);
                l(i(), this.f18209e);
                return;
            }
            o(8);
        }
    }
}

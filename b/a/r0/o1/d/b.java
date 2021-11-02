package b.a.r0.o1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LabelRecommendActivity f21991a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f21992b;

    /* renamed from: c  reason: collision with root package name */
    public View f21993c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21994d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f21995e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21996f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f21997g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.o1.a.a f21998h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.r0.o1.d.a f21999i;
    public View.OnClickListener j;
    public List<b.a.r0.o1.b.a> k;
    public List<Integer> l;
    public View.OnClickListener m;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f22000e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22000e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof b.a.r0.o1.b.a)) {
                Integer valueOf = Integer.valueOf(((b.a.r0.o1.b.a) view.getTag()).f21980a);
                if (this.f22000e.l.contains(valueOf)) {
                    this.f22000e.l.remove(valueOf);
                } else {
                    this.f22000e.l.add(valueOf);
                }
                this.f22000e.i();
            }
        }
    }

    public b(LabelRecommendActivity labelRecommendActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {labelRecommendActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = new a(this);
        if (labelRecommendActivity == null) {
            return;
        }
        this.f21991a = labelRecommendActivity;
        g();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21992b : (View) invokeV.objValue;
    }

    public List<Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList(this.l);
            arrayList.add(0, Integer.valueOf(this.f21999i.b()));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21994d : (View) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21996f : (View) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f21991a.setContentView(R.layout.activity_label_recommend);
            this.f21992b = (ViewGroup) this.f21991a.findViewById(R.id.view_root);
            this.f21993c = this.f21991a.findViewById(R.id.statebar_view);
            this.f21994d = (TextView) this.f21991a.findViewById(R.id.skip);
            this.f21995e = (NoNetworkView) this.f21991a.findViewById(R.id.view_no_network);
            this.f21996f = (TextView) this.f21991a.findViewById(R.id.sub_label);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f21993c.getLayoutParams().height = UtilHelper.getStatusBarHeight();
            }
            l(0, 0);
            this.f21997g = (BdListView) this.f21991a.findViewById(R.id.listview);
            b.a.r0.o1.a.a aVar = new b.a.r0.o1.a.a(this.f21991a.getPageContext().getPageActivity());
            this.f21998h = aVar;
            aVar.b(this.m);
            b.a.r0.o1.d.a aVar2 = new b.a.r0.o1.d.a(this.f21991a.getPageContext().getPageActivity());
            this.f21999i = aVar2;
            this.f21997g.addHeaderView(aVar2.a());
            this.f21997g.setAdapter((ListAdapter) this.f21998h);
            h();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.f21994d, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f21996f, R.drawable.color_sub_lable_selector);
            SkinManager.setBackgroundResource(this.f21996f, R.drawable.bule_bg_commen_label_button);
            this.f21995e.onChangeSkinType(this.f21991a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (b.a.r0.o1.b.a aVar : this.k) {
                if (aVar != null) {
                    aVar.f21982c = this.l.contains(Integer.valueOf(aVar.f21980a));
                }
            }
            this.f21998h.a(this.k);
            l(this.l.size(), this.k.size());
        }
    }

    public void j(b.a.r0.o1.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || bVar == null || bVar.c() == null || bVar.b() == null) {
            return;
        }
        for (b.a.r0.o1.b.a aVar : bVar.b()) {
            if (aVar != null) {
                aVar.f21982c = false;
            }
        }
        this.k.clear();
        this.k.addAll(bVar.b());
        this.f21999i.d(bVar.c());
        this.f21998h.a(this.k);
        this.f21997g.setVisibility(0);
        l(0, this.k.size());
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.j = onClickListener;
            this.f21994d.setOnClickListener(onClickListener);
        }
    }

    public final void l(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            this.f21996f.setEnabled(i2 > 0);
            this.f21996f.setText(this.f21991a.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
            this.f21996f.setOnClickListener(i2 > 0 ? this.j : null);
        }
    }
}

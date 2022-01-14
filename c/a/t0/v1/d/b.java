package c.a.t0.v1.d;

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
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LabelRecommendActivity a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f24540b;

    /* renamed from: c  reason: collision with root package name */
    public View f24541c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24542d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f24543e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24544f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f24545g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.v1.a.a f24546h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.t0.v1.d.a f24547i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f24548j;
    public List<c.a.t0.v1.b.a> k;
    public List<Integer> l;
    public View.OnClickListener m;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24549e;

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
            this.f24549e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof c.a.t0.v1.b.a)) {
                Integer valueOf = Integer.valueOf(((c.a.t0.v1.b.a) view.getTag()).a);
                if (this.f24549e.l.contains(valueOf)) {
                    this.f24549e.l.remove(valueOf);
                } else {
                    this.f24549e.l.add(valueOf);
                }
                this.f24549e.i();
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
        this.a = labelRecommendActivity;
        g();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24540b : (View) invokeV.objValue;
    }

    public List<Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList(this.l);
            arrayList.add(0, Integer.valueOf(this.f24547i.b()));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24542d : (View) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f24544f : (View) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.setContentView(R.layout.activity_label_recommend);
            this.f24540b = (ViewGroup) this.a.findViewById(R.id.view_root);
            this.f24541c = this.a.findViewById(R.id.statebar_view);
            this.f24542d = (TextView) this.a.findViewById(R.id.skip);
            this.f24543e = (NoNetworkView) this.a.findViewById(R.id.view_no_network);
            this.f24544f = (TextView) this.a.findViewById(R.id.sub_label);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f24541c.getLayoutParams().height = UtilHelper.getStatusBarHeight();
            }
            l(0, 0);
            this.f24545g = (BdListView) this.a.findViewById(R.id.listview);
            c.a.t0.v1.a.a aVar = new c.a.t0.v1.a.a(this.a.getPageContext().getPageActivity());
            this.f24546h = aVar;
            aVar.b(this.m);
            c.a.t0.v1.d.a aVar2 = new c.a.t0.v1.d.a(this.a.getPageContext().getPageActivity());
            this.f24547i = aVar2;
            this.f24545g.addHeaderView(aVar2.a());
            this.f24545g.setAdapter((ListAdapter) this.f24546h);
            h();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.f24542d, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f24544f, R.drawable.color_sub_lable_selector);
            SkinManager.setBackgroundResource(this.f24544f, R.drawable.bule_bg_commen_label_button);
            this.f24543e.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (c.a.t0.v1.b.a aVar : this.k) {
                if (aVar != null) {
                    aVar.f24531c = this.l.contains(Integer.valueOf(aVar.a));
                }
            }
            this.f24546h.a(this.k);
            l(this.l.size(), this.k.size());
        }
    }

    public void j(c.a.t0.v1.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || bVar == null || bVar.c() == null || bVar.b() == null) {
            return;
        }
        for (c.a.t0.v1.b.a aVar : bVar.b()) {
            if (aVar != null) {
                aVar.f24531c = false;
            }
        }
        this.k.clear();
        this.k.addAll(bVar.b());
        this.f24547i.d(bVar.c());
        this.f24546h.a(this.k);
        this.f24545g.setVisibility(0);
        l(0, this.k.size());
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.f24548j = onClickListener;
            this.f24542d.setOnClickListener(onClickListener);
        }
    }

    public final void l(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            this.f24544f.setEnabled(i2 > 0);
            this.f24544f.setText(this.a.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
            this.f24544f.setOnClickListener(i2 > 0 ? this.f24548j : null);
        }
    }
}

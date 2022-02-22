package c.a.u0.x1.d;

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
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LabelRecommendActivity a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f25167b;

    /* renamed from: c  reason: collision with root package name */
    public View f25168c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f25169d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f25170e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f25171f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f25172g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.u0.x1.a.a f25173h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.u0.x1.d.a f25174i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f25175j;
    public List<c.a.u0.x1.b.a> k;
    public List<Integer> l;
    public View.OnClickListener m;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f25176e;

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
            this.f25176e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof c.a.u0.x1.b.a)) {
                Integer valueOf = Integer.valueOf(((c.a.u0.x1.b.a) view.getTag()).a);
                if (this.f25176e.l.contains(valueOf)) {
                    this.f25176e.l.remove(valueOf);
                } else {
                    this.f25176e.l.add(valueOf);
                }
                this.f25176e.i();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25167b : (View) invokeV.objValue;
    }

    public List<Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList(this.l);
            arrayList.add(0, Integer.valueOf(this.f25174i.b()));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f25169d : (View) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f25171f : (View) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.setContentView(R.layout.activity_label_recommend);
            this.f25167b = (ViewGroup) this.a.findViewById(R.id.view_root);
            this.f25168c = this.a.findViewById(R.id.statebar_view);
            this.f25169d = (TextView) this.a.findViewById(R.id.skip);
            this.f25170e = (NoNetworkView) this.a.findViewById(R.id.view_no_network);
            this.f25171f = (TextView) this.a.findViewById(R.id.sub_label);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f25168c.getLayoutParams().height = UtilHelper.getStatusBarHeight();
            }
            l(0, 0);
            this.f25172g = (BdListView) this.a.findViewById(R.id.listview);
            c.a.u0.x1.a.a aVar = new c.a.u0.x1.a.a(this.a.getPageContext().getPageActivity());
            this.f25173h = aVar;
            aVar.b(this.m);
            c.a.u0.x1.d.a aVar2 = new c.a.u0.x1.d.a(this.a.getPageContext().getPageActivity());
            this.f25174i = aVar2;
            this.f25172g.addHeaderView(aVar2.a());
            this.f25172g.setAdapter((ListAdapter) this.f25173h);
            h();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.f25169d, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f25171f, R.drawable.color_sub_lable_selector);
            SkinManager.setBackgroundResource(this.f25171f, R.drawable.bule_bg_commen_label_button);
            this.f25170e.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (c.a.u0.x1.b.a aVar : this.k) {
                if (aVar != null) {
                    aVar.f25158c = this.l.contains(Integer.valueOf(aVar.a));
                }
            }
            this.f25173h.a(this.k);
            l(this.l.size(), this.k.size());
        }
    }

    public void j(c.a.u0.x1.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || bVar == null || bVar.c() == null || bVar.b() == null) {
            return;
        }
        for (c.a.u0.x1.b.a aVar : bVar.b()) {
            if (aVar != null) {
                aVar.f25158c = false;
            }
        }
        this.k.clear();
        this.k.addAll(bVar.b());
        this.f25174i.d(bVar.c());
        this.f25173h.a(this.k);
        this.f25172g.setVisibility(0);
        l(0, this.k.size());
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.f25175j = onClickListener;
            this.f25169d.setOnClickListener(onClickListener);
        }
    }

    public final void l(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            this.f25171f.setEnabled(i2 > 0);
            this.f25171f.setText(this.a.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
            this.f25171f.setOnClickListener(i2 > 0 ? this.f25175j : null);
        }
    }
}

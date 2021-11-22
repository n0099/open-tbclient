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
    public LabelRecommendActivity f23490a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f23491b;

    /* renamed from: c  reason: collision with root package name */
    public View f23492c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f23493d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f23494e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f23495f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f23496g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.o1.a.a f23497h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.r0.o1.d.a f23498i;
    public View.OnClickListener j;
    public List<b.a.r0.o1.b.a> k;
    public List<Integer> l;
    public View.OnClickListener m;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23499e;

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
            this.f23499e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof b.a.r0.o1.b.a)) {
                Integer valueOf = Integer.valueOf(((b.a.r0.o1.b.a) view.getTag()).f23479a);
                if (this.f23499e.l.contains(valueOf)) {
                    this.f23499e.l.remove(valueOf);
                } else {
                    this.f23499e.l.add(valueOf);
                }
                this.f23499e.i();
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
        this.f23490a = labelRecommendActivity;
        g();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23491b : (View) invokeV.objValue;
    }

    public List<Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList(this.l);
            arrayList.add(0, Integer.valueOf(this.f23498i.b()));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23493d : (View) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23495f : (View) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f23490a.setContentView(R.layout.activity_label_recommend);
            this.f23491b = (ViewGroup) this.f23490a.findViewById(R.id.view_root);
            this.f23492c = this.f23490a.findViewById(R.id.statebar_view);
            this.f23493d = (TextView) this.f23490a.findViewById(R.id.skip);
            this.f23494e = (NoNetworkView) this.f23490a.findViewById(R.id.view_no_network);
            this.f23495f = (TextView) this.f23490a.findViewById(R.id.sub_label);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f23492c.getLayoutParams().height = UtilHelper.getStatusBarHeight();
            }
            l(0, 0);
            this.f23496g = (BdListView) this.f23490a.findViewById(R.id.listview);
            b.a.r0.o1.a.a aVar = new b.a.r0.o1.a.a(this.f23490a.getPageContext().getPageActivity());
            this.f23497h = aVar;
            aVar.b(this.m);
            b.a.r0.o1.d.a aVar2 = new b.a.r0.o1.d.a(this.f23490a.getPageContext().getPageActivity());
            this.f23498i = aVar2;
            this.f23496g.addHeaderView(aVar2.a());
            this.f23496g.setAdapter((ListAdapter) this.f23497h);
            h();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.f23493d, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f23495f, R.drawable.color_sub_lable_selector);
            SkinManager.setBackgroundResource(this.f23495f, R.drawable.bule_bg_commen_label_button);
            this.f23494e.onChangeSkinType(this.f23490a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (b.a.r0.o1.b.a aVar : this.k) {
                if (aVar != null) {
                    aVar.f23481c = this.l.contains(Integer.valueOf(aVar.f23479a));
                }
            }
            this.f23497h.a(this.k);
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
                aVar.f23481c = false;
            }
        }
        this.k.clear();
        this.k.addAll(bVar.b());
        this.f23498i.d(bVar.c());
        this.f23497h.a(this.k);
        this.f23496g.setVisibility(0);
        l(0, this.k.size());
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.j = onClickListener;
            this.f23493d.setOnClickListener(onClickListener);
        }
    }

    public final void l(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            this.f23495f.setEnabled(i2 > 0);
            this.f23495f.setText(this.f23490a.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
            this.f23495f.setOnClickListener(i2 > 0 ? this.j : null);
        }
    }
}

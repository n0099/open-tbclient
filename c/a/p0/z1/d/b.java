package c.a.p0.z1.d;

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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LabelRecommendActivity a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f20901b;

    /* renamed from: c  reason: collision with root package name */
    public View f20902c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f20903d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f20904e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f20905f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f20906g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.z1.a.a f20907h;
    public c.a.p0.z1.d.a i;
    public View.OnClickListener j;
    public List<c.a.p0.z1.b.a> k;
    public List<Integer> l;
    public View.OnClickListener m;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof c.a.p0.z1.b.a)) {
                Integer valueOf = Integer.valueOf(((c.a.p0.z1.b.a) view.getTag()).a);
                if (this.a.l.contains(valueOf)) {
                    this.a.l.remove(valueOf);
                } else {
                    this.a.l.add(valueOf);
                }
                this.a.i();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20901b : (View) invokeV.objValue;
    }

    public List<Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList(this.l);
            arrayList.add(0, Integer.valueOf(this.i.b()));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20903d : (View) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20905f : (View) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d003d);
            this.f20901b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f0923d9);
            this.f20902c = this.a.findViewById(R.id.obfuscated_res_0x7f091da5);
            this.f20903d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091d2d);
            this.f20904e = (NoNetworkView) this.a.findViewById(R.id.obfuscated_res_0x7f0923d1);
            this.f20905f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091dc0);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.f20902c.getLayoutParams().height = UtilHelper.getStatusBarHeight();
            }
            l(0, 0);
            this.f20906g = (BdListView) this.a.findViewById(R.id.obfuscated_res_0x7f091281);
            c.a.p0.z1.a.a aVar = new c.a.p0.z1.a.a(this.a.getPageContext().getPageActivity());
            this.f20907h = aVar;
            aVar.b(this.m);
            c.a.p0.z1.d.a aVar2 = new c.a.p0.z1.d.a(this.a.getPageContext().getPageActivity());
            this.i = aVar2;
            this.f20906g.addHeaderView(aVar2.a());
            this.f20906g.setAdapter((ListAdapter) this.f20907h);
            h();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.f20903d, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f20905f, (int) R.drawable.color_sub_lable_selector);
            SkinManager.setBackgroundResource(this.f20905f, R.drawable.bule_bg_commen_label_button);
            this.f20904e.c(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (c.a.p0.z1.b.a aVar : this.k) {
                if (aVar != null) {
                    aVar.f20891c = this.l.contains(Integer.valueOf(aVar.a));
                }
            }
            this.f20907h.a(this.k);
            l(this.l.size(), this.k.size());
        }
    }

    public void j(c.a.p0.z1.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || bVar == null || bVar.c() == null || bVar.b() == null) {
            return;
        }
        for (c.a.p0.z1.b.a aVar : bVar.b()) {
            if (aVar != null) {
                aVar.f20891c = false;
            }
        }
        this.k.clear();
        this.k.addAll(bVar.b());
        this.i.d(bVar.c());
        this.f20907h.a(this.k);
        this.f20906g.setVisibility(0);
        l(0, this.k.size());
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.j = onClickListener;
            this.f20903d.setOnClickListener(onClickListener);
        }
    }

    public final void l(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            this.f20905f.setEnabled(i > 0);
            this.f20905f.setText(this.a.getString(R.string.obfuscated_res_0x7f0f11c6, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            this.f20905f.setOnClickListener(i > 0 ? this.j : null);
        }
    }
}

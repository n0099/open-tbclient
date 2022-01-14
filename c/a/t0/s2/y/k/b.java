package c.a.t0.s2.y.k;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.t0.s2.f;
import c.a.t0.s2.i;
import c.a.t0.s2.r.q;
import c.a.t0.w3.j0.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f23380b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23381c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f23382d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f23383e;

    /* renamed from: f  reason: collision with root package name */
    public int f23384f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f23385g;

    /* renamed from: h  reason: collision with root package name */
    public int f23386h;

    /* renamed from: i  reason: collision with root package name */
    public int f23387i;

    /* renamed from: j  reason: collision with root package name */
    public SortSwitchButton.f f23388j;
    public View.OnClickListener k;

    /* loaded from: classes8.dex */
    public class a implements SortSwitchButton.f {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.a.f23383e != null) {
                    return this.a.f23383e.a(i2);
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* renamed from: c.a.t0.s2.y.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1430b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23389e;

        public View$OnClickListenerC1430b(b bVar) {
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
            this.f23389e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f23389e.f23385g != null) {
                    this.f23389e.f23385g.onClick(view);
                }
                if (l.z()) {
                    if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                        if (view != this.f23389e.f23380b) {
                            if (view == this.f23389e.f23381c) {
                                this.f23389e.k(1);
                                return;
                            }
                            return;
                        }
                        this.f23389e.k(0);
                    }
                }
            }
        }
    }

    public b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23384f = 0;
        this.f23388j = new a(this);
        this.k = new View$OnClickListenerC1430b(this);
        if (view == null) {
            return;
        }
        this.a = view;
        TextView textView = (TextView) view.findViewById(i.all_reply);
        this.f23380b = textView;
        textView.setOnClickListener(this.k);
        TextView textView2 = (TextView) this.a.findViewById(i.owner_reply);
        this.f23381c = textView2;
        textView2.setOnClickListener(this.k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.a.findViewById(i.video_pb_sort_switch_btn);
        this.f23382d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.f23388j);
        this.f23382d.changeState(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(q qVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) || qVar == null) {
            return;
        }
        int i2 = 0;
        if (qVar.f22438f == q.l) {
            this.f23380b.setClickable(true);
            this.f23380b.setText(TbadkCoreApplication.getInst().getString(c.a.t0.s2.l.all_reply));
            this.f23381c.setVisibility(0);
            f(qVar.f22440h);
        }
        if (qVar.f22441i) {
            this.f23381c.setVisibility(8);
            this.f23382d.setVisibility(8);
        } else if (qVar.f22442j) {
            this.f23381c.setVisibility(8);
        } else {
            this.f23381c.setVisibility(0);
        }
        if (!qVar.f22441i && qVar.k != null) {
            this.f23382d.setVisibility(0);
            int i3 = 0;
            while (true) {
                if (i3 < qVar.k.size()) {
                    if (qVar.k.get(i3) != null && qVar.f22439g == qVar.k.get(i3).sort_type.intValue()) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            g(qVar.k, i2);
        }
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                k(1);
            } else {
                k(0);
            }
        }
    }

    public void g(List<PbSortType> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, list, i2) == null) {
            if (ListUtils.isEmpty(list)) {
                this.f23382d.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PbSortType pbSortType : list) {
                s sVar = new s();
                sVar.c(pbSortType.sort_type.intValue());
                sVar.d(pbSortType.sort_name);
                arrayList.add(sVar);
            }
            this.f23382d.setVisibility(0);
            this.f23382d.setData(arrayList, i2);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.a, f.CAM_X0205);
            this.f23387i = SkinManager.getColor(f.CAM_X0105);
            this.f23386h = SkinManager.getColor(f.CAM_X0107);
            k(this.f23384f);
            this.f23382d.onChangeSkinType();
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f23385g = onClickListener;
        }
    }

    public void j(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f23383e = fVar;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f23384f = i2;
            if (i2 == 0) {
                this.f23380b.setTypeface(Typeface.defaultFromStyle(1));
                this.f23381c.setTypeface(Typeface.defaultFromStyle(0));
                this.f23380b.setTextColor(this.f23387i);
                this.f23381c.setTextColor(this.f23386h);
            } else if (i2 == 1) {
                this.f23380b.setTypeface(Typeface.defaultFromStyle(0));
                this.f23381c.setTypeface(Typeface.defaultFromStyle(1));
                this.f23380b.setTextColor(this.f23386h);
                this.f23381c.setTextColor(this.f23387i);
            }
        }
    }
}

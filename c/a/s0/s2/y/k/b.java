package c.a.s0.s2.y.k;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import c.a.d.f.p.k;
import c.a.s0.s2.f;
import c.a.s0.s2.i;
import c.a.s0.s2.l;
import c.a.s0.s2.r.q;
import c.a.s0.v3.j0.s;
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
    public TextView f23537b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23538c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f23539d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f23540e;

    /* renamed from: f  reason: collision with root package name */
    public int f23541f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f23542g;

    /* renamed from: h  reason: collision with root package name */
    public int f23543h;

    /* renamed from: i  reason: collision with root package name */
    public int f23544i;

    /* renamed from: j  reason: collision with root package name */
    public SortSwitchButton.f f23545j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f23546k;

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
                if (this.a.f23540e != null) {
                    return this.a.f23540e.a(i2);
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* renamed from: c.a.s0.s2.y.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1387b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23547e;

        public View$OnClickListenerC1387b(b bVar) {
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
            this.f23547e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f23547e.f23542g != null) {
                    this.f23547e.f23542g.onClick(view);
                }
                if (k.z()) {
                    if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                        if (view != this.f23547e.f23537b) {
                            if (view == this.f23547e.f23538c) {
                                this.f23547e.k(1);
                                return;
                            }
                            return;
                        }
                        this.f23547e.k(0);
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
        this.f23541f = 0;
        this.f23545j = new a(this);
        this.f23546k = new View$OnClickListenerC1387b(this);
        if (view == null) {
            return;
        }
        this.a = view;
        TextView textView = (TextView) view.findViewById(i.all_reply);
        this.f23537b = textView;
        textView.setOnClickListener(this.f23546k);
        TextView textView2 = (TextView) this.a.findViewById(i.owner_reply);
        this.f23538c = textView2;
        textView2.setOnClickListener(this.f23546k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.a.findViewById(i.video_pb_sort_switch_btn);
        this.f23539d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.f23545j);
        this.f23539d.changeState(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(q qVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) || qVar == null) {
            return;
        }
        int i2 = 0;
        if (qVar.f22561f == q.l) {
            this.f23537b.setClickable(true);
            this.f23537b.setText(TbadkCoreApplication.getInst().getString(l.all_reply));
            this.f23538c.setVisibility(0);
            f(qVar.f22563h);
        }
        if (qVar.f22564i) {
            this.f23538c.setVisibility(8);
            this.f23539d.setVisibility(8);
        } else if (qVar.f22565j) {
            this.f23538c.setVisibility(8);
        } else {
            this.f23538c.setVisibility(0);
        }
        if (!qVar.f22564i && qVar.f22566k != null) {
            this.f23539d.setVisibility(0);
            int i3 = 0;
            while (true) {
                if (i3 < qVar.f22566k.size()) {
                    if (qVar.f22566k.get(i3) != null && qVar.f22562g == qVar.f22566k.get(i3).sort_type.intValue()) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            g(qVar.f22566k, i2);
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
                this.f23539d.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PbSortType pbSortType : list) {
                s sVar = new s();
                sVar.c(pbSortType.sort_type.intValue());
                sVar.d(pbSortType.sort_name);
                arrayList.add(sVar);
            }
            this.f23539d.setVisibility(0);
            this.f23539d.setData(arrayList, i2);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.a, f.CAM_X0205);
            this.f23544i = SkinManager.getColor(f.CAM_X0105);
            this.f23543h = SkinManager.getColor(f.CAM_X0107);
            k(this.f23541f);
            this.f23539d.onChangeSkinType();
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f23542g = onClickListener;
        }
    }

    public void j(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f23540e = fVar;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f23541f = i2;
            if (i2 == 0) {
                this.f23537b.setTypeface(Typeface.defaultFromStyle(1));
                this.f23538c.setTypeface(Typeface.defaultFromStyle(0));
                this.f23537b.setTextColor(this.f23544i);
                this.f23538c.setTextColor(this.f23543h);
            } else if (i2 == 1) {
                this.f23537b.setTypeface(Typeface.defaultFromStyle(0));
                this.f23538c.setTypeface(Typeface.defaultFromStyle(1));
                this.f23537b.setTextColor(this.f23543h);
                this.f23538c.setTextColor(this.f23544i);
            }
        }
    }
}

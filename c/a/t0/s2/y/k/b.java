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
    public TextView f24050b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24051c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f24052d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f24053e;

    /* renamed from: f  reason: collision with root package name */
    public int f24054f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f24055g;

    /* renamed from: h  reason: collision with root package name */
    public int f24056h;

    /* renamed from: i  reason: collision with root package name */
    public int f24057i;

    /* renamed from: j  reason: collision with root package name */
    public SortSwitchButton.f f24058j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f24059k;

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
                if (this.a.f24053e != null) {
                    return this.a.f24053e.a(i2);
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* renamed from: c.a.t0.s2.y.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1415b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f24060e;

        public View$OnClickListenerC1415b(b bVar) {
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
            this.f24060e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f24060e.f24055g != null) {
                    this.f24060e.f24055g.onClick(view);
                }
                if (l.z()) {
                    if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                        if (view != this.f24060e.f24050b) {
                            if (view == this.f24060e.f24051c) {
                                this.f24060e.k(1);
                                return;
                            }
                            return;
                        }
                        this.f24060e.k(0);
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
        this.f24054f = 0;
        this.f24058j = new a(this);
        this.f24059k = new View$OnClickListenerC1415b(this);
        if (view == null) {
            return;
        }
        this.a = view;
        TextView textView = (TextView) view.findViewById(i.all_reply);
        this.f24050b = textView;
        textView.setOnClickListener(this.f24059k);
        TextView textView2 = (TextView) this.a.findViewById(i.owner_reply);
        this.f24051c = textView2;
        textView2.setOnClickListener(this.f24059k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.a.findViewById(i.video_pb_sort_switch_btn);
        this.f24052d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.f24058j);
        this.f24052d.changeState(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(q qVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) || qVar == null) {
            return;
        }
        int i2 = 0;
        if (qVar.f23073f == q.l) {
            this.f24050b.setClickable(true);
            this.f24050b.setText(TbadkCoreApplication.getInst().getString(c.a.t0.s2.l.all_reply));
            this.f24051c.setVisibility(0);
            f(qVar.f23075h);
        }
        if (qVar.f23076i) {
            this.f24051c.setVisibility(8);
            this.f24052d.setVisibility(8);
        } else if (qVar.f23077j) {
            this.f24051c.setVisibility(8);
        } else {
            this.f24051c.setVisibility(0);
        }
        if (!qVar.f23076i && qVar.f23078k != null) {
            this.f24052d.setVisibility(0);
            int i3 = 0;
            while (true) {
                if (i3 < qVar.f23078k.size()) {
                    if (qVar.f23078k.get(i3) != null && qVar.f23074g == qVar.f23078k.get(i3).sort_type.intValue()) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            g(qVar.f23078k, i2);
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
                this.f24052d.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PbSortType pbSortType : list) {
                s sVar = new s();
                sVar.c(pbSortType.sort_type.intValue());
                sVar.d(pbSortType.sort_name);
                arrayList.add(sVar);
            }
            this.f24052d.setVisibility(0);
            this.f24052d.setData(arrayList, i2);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.a, f.CAM_X0205);
            this.f24057i = SkinManager.getColor(f.CAM_X0105);
            this.f24056h = SkinManager.getColor(f.CAM_X0107);
            k(this.f24054f);
            this.f24052d.onChangeSkinType();
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f24055g = onClickListener;
        }
    }

    public void j(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f24053e = fVar;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f24054f = i2;
            if (i2 == 0) {
                this.f24050b.setTypeface(Typeface.defaultFromStyle(1));
                this.f24051c.setTypeface(Typeface.defaultFromStyle(0));
                this.f24050b.setTextColor(this.f24057i);
                this.f24051c.setTextColor(this.f24056h);
            } else if (i2 == 1) {
                this.f24050b.setTypeface(Typeface.defaultFromStyle(0));
                this.f24051c.setTypeface(Typeface.defaultFromStyle(1));
                this.f24050b.setTextColor(this.f24056h);
                this.f24051c.setTextColor(this.f24057i);
            }
        }
    }
}

package c.a.t0.t2.y.l;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.t0.t2.f;
import c.a.t0.t2.i;
import c.a.t0.t2.r.q;
import c.a.t0.x3.j0.s;
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
    public TextView f23659b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23660c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f23661d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f23662e;

    /* renamed from: f  reason: collision with root package name */
    public int f23663f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f23664g;

    /* renamed from: h  reason: collision with root package name */
    public int f23665h;

    /* renamed from: i  reason: collision with root package name */
    public int f23666i;

    /* renamed from: j  reason: collision with root package name */
    public SortSwitchButton.f f23667j;
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
                if (this.a.f23662e != null) {
                    return this.a.f23662e.a(i2);
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* renamed from: c.a.t0.t2.y.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1442b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23668e;

        public View$OnClickListenerC1442b(b bVar) {
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
            this.f23668e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f23668e.f23664g != null) {
                    this.f23668e.f23664g.onClick(view);
                }
                if (l.z()) {
                    if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                        if (view != this.f23668e.f23659b) {
                            if (view == this.f23668e.f23660c) {
                                this.f23668e.k(1);
                                return;
                            }
                            return;
                        }
                        this.f23668e.k(0);
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
        this.f23663f = 0;
        this.f23667j = new a(this);
        this.k = new View$OnClickListenerC1442b(this);
        if (view == null) {
            return;
        }
        this.a = view;
        TextView textView = (TextView) view.findViewById(i.all_reply);
        this.f23659b = textView;
        textView.setOnClickListener(this.k);
        TextView textView2 = (TextView) this.a.findViewById(i.owner_reply);
        this.f23660c = textView2;
        textView2.setOnClickListener(this.k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.a.findViewById(i.video_pb_sort_switch_btn);
        this.f23661d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.f23667j);
        this.f23661d.changeState(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(q qVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) || qVar == null) {
            return;
        }
        int i2 = 0;
        if (qVar.f22717f == q.l) {
            this.f23659b.setClickable(true);
            this.f23659b.setText(TbadkCoreApplication.getInst().getString(c.a.t0.t2.l.all_reply));
            this.f23660c.setVisibility(0);
            f(qVar.f22719h);
        }
        if (qVar.f22720i) {
            this.f23660c.setVisibility(8);
            this.f23661d.setVisibility(8);
        } else if (qVar.f22721j) {
            this.f23660c.setVisibility(8);
        } else {
            this.f23660c.setVisibility(0);
        }
        if (!qVar.f22720i && qVar.k != null) {
            this.f23661d.setVisibility(0);
            int i3 = 0;
            while (true) {
                if (i3 < qVar.k.size()) {
                    if (qVar.k.get(i3) != null && qVar.f22718g == qVar.k.get(i3).sort_type.intValue()) {
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
                this.f23661d.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PbSortType pbSortType : list) {
                s sVar = new s();
                sVar.c(pbSortType.sort_type.intValue());
                sVar.d(pbSortType.sort_name);
                arrayList.add(sVar);
            }
            this.f23661d.setVisibility(0);
            this.f23661d.setData(arrayList, i2);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.a, f.CAM_X0205);
            this.f23666i = SkinManager.getColor(f.CAM_X0105);
            this.f23665h = SkinManager.getColor(f.CAM_X0107);
            k(this.f23663f);
            this.f23661d.onChangeSkinType();
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f23664g = onClickListener;
        }
    }

    public void j(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f23662e = fVar;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f23663f = i2;
            if (i2 == 0) {
                this.f23659b.setTypeface(Typeface.defaultFromStyle(1));
                this.f23660c.setTypeface(Typeface.defaultFromStyle(0));
                this.f23659b.setTextColor(this.f23666i);
                this.f23660c.setTextColor(this.f23665h);
            } else if (i2 == 1) {
                this.f23659b.setTypeface(Typeface.defaultFromStyle(0));
                this.f23660c.setTypeface(Typeface.defaultFromStyle(1));
                this.f23659b.setTextColor(this.f23665h);
                this.f23660c.setTextColor(this.f23666i);
            }
        }
    }
}

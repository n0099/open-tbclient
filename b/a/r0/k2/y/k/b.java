package b.a.r0.k2.y.k;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import b.a.e.f.p.j;
import b.a.r0.k2.f;
import b.a.r0.k2.i;
import b.a.r0.k2.l;
import b.a.r0.k2.r.q;
import b.a.r0.m3.j0.s;
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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f21409a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f21410b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f21411c;

    /* renamed from: d  reason: collision with root package name */
    public SortSwitchButton f21412d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton.f f21413e;

    /* renamed from: f  reason: collision with root package name */
    public int f21414f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f21415g;

    /* renamed from: h  reason: collision with root package name */
    public int f21416h;

    /* renamed from: i  reason: collision with root package name */
    public int f21417i;
    public SortSwitchButton.f j;
    public View.OnClickListener k;

    /* loaded from: classes5.dex */
    public class a implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f21418a;

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
            this.f21418a = bVar;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (this.f21418a.f21413e != null) {
                    return this.f21418a.f21413e.a(i2);
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* renamed from: b.a.r0.k2.y.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1059b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21419e;

        public View$OnClickListenerC1059b(b bVar) {
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
            this.f21419e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f21419e.f21415g != null) {
                    this.f21419e.f21415g.onClick(view);
                }
                if (j.z()) {
                    if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                        if (view != this.f21419e.f21410b) {
                            if (view == this.f21419e.f21411c) {
                                this.f21419e.k(1);
                                return;
                            }
                            return;
                        }
                        this.f21419e.k(0);
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
        this.f21414f = 0;
        this.j = new a(this);
        this.k = new View$OnClickListenerC1059b(this);
        if (view == null) {
            return;
        }
        this.f21409a = view;
        TextView textView = (TextView) view.findViewById(i.all_reply);
        this.f21410b = textView;
        textView.setOnClickListener(this.k);
        TextView textView2 = (TextView) this.f21409a.findViewById(i.owner_reply);
        this.f21411c = textView2;
        textView2.setOnClickListener(this.k);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) this.f21409a.findViewById(i.video_pb_sort_switch_btn);
        this.f21412d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.j);
        this.f21412d.changeState(2);
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public void e(q qVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, qVar) == null) || qVar == null) {
            return;
        }
        int i2 = 0;
        if (qVar.f20332f == q.l) {
            this.f21410b.setClickable(true);
            this.f21410b.setText(TbadkCoreApplication.getInst().getString(l.all_reply));
            this.f21411c.setVisibility(0);
            f(qVar.f20334h);
        }
        if (qVar.f20335i) {
            this.f21411c.setVisibility(8);
            this.f21412d.setVisibility(8);
        } else if (qVar.j) {
            this.f21411c.setVisibility(8);
        } else {
            this.f21411c.setVisibility(0);
        }
        if (!qVar.f20335i && qVar.k != null) {
            this.f21412d.setVisibility(0);
            int i3 = 0;
            while (true) {
                if (i3 < qVar.k.size()) {
                    if (qVar.k.get(i3) != null && qVar.f20333g == qVar.k.get(i3).sort_type.intValue()) {
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
                this.f21412d.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PbSortType pbSortType : list) {
                s sVar = new s();
                sVar.c(pbSortType.sort_type.intValue());
                sVar.d(pbSortType.sort_name);
                arrayList.add(sVar);
            }
            this.f21412d.setVisibility(0);
            this.f21412d.setData(arrayList, i2);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f21409a, f.CAM_X0205);
            this.f21417i = SkinManager.getColor(f.CAM_X0105);
            this.f21416h = SkinManager.getColor(f.CAM_X0107);
            k(this.f21414f);
            this.f21412d.onChangeSkinType();
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f21415g = onClickListener;
        }
    }

    public void j(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f21413e = fVar;
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f21414f = i2;
            if (i2 == 0) {
                this.f21410b.setTypeface(Typeface.defaultFromStyle(1));
                this.f21411c.setTypeface(Typeface.defaultFromStyle(0));
                this.f21410b.setTextColor(this.f21417i);
                this.f21411c.setTextColor(this.f21416h);
            } else if (i2 == 1) {
                this.f21410b.setTypeface(Typeface.defaultFromStyle(0));
                this.f21411c.setTypeface(Typeface.defaultFromStyle(1));
                this.f21410b.setTextColor(this.f21416h);
                this.f21411c.setTextColor(this.f21417i);
            }
        }
    }
}

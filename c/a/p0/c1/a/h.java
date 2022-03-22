package c.a.p0.c1.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.p0.c1.c.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.bawu.BawuManagerApplyInfoView;
import com.baidu.tieba.forumMember.bawu.BawuMemberInfoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class h extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<i> f13394b;

    /* renamed from: c  reason: collision with root package name */
    public l f13395c;

    /* renamed from: d  reason: collision with root package name */
    public int f13396d;

    /* renamed from: e  reason: collision with root package name */
    public int f13397e;

    /* renamed from: f  reason: collision with root package name */
    public d f13398f;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f13398f == null) {
                return;
            }
            this.a.f13398f.a(this.a.f13395c.a());
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f13398f == null) {
                return;
            }
            this.a.f13398f.a(this.a.f13395c.a());
        }
    }

    /* loaded from: classes2.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        public c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(String str);
    }

    /* loaded from: classes2.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;

        /* renamed from: b  reason: collision with root package name */
        public BawuMemberInfoView f13399b;

        /* renamed from: c  reason: collision with root package name */
        public BawuMemberInfoView f13400c;

        /* renamed from: d  reason: collision with root package name */
        public BawuManagerApplyInfoView f13401d;

        /* renamed from: e  reason: collision with root package name */
        public BawuManagerApplyInfoView f13402e;

        public e(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        public f(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public h(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13396d = 0;
        this.f13397e = 0;
        this.a = tbPageContext;
        this.f13394b = new ArrayList<>();
        this.f13396d = n.f(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.f13397e = n.f(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public i getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            ArrayList<i> arrayList = this.f13394b;
            if (arrayList == null || i >= arrayList.size()) {
                return null;
            }
            return this.f13394b.get(i);
        }
        return (i) invokeI.objValue;
    }

    public void d(ArrayList<i> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.f13394b = arrayList;
        }
    }

    public void e(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            this.f13395c = lVar;
        }
    }

    public void f(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.f13398f = dVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList<i> arrayList = this.f13394b;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? getItem(i).a() : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        e eVar;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view, viewGroup)) == null) {
            if (getItemViewType(i) == 0) {
                if (view != null && (view.getTag() instanceof f)) {
                    fVar = (f) view.getTag();
                } else {
                    view = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0147, viewGroup, false);
                    fVar = new f(this);
                    fVar.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091f5e);
                    view.setTag(fVar);
                }
                fVar.a.setText(((c.a.p0.c1.a.c) getItem(i)).b());
                c.a.o0.r.v.c.d(view).f(R.color.CAM_X0204);
                this.a.getLayoutMode().j(view);
            } else if (getItemViewType(i) == 1) {
                if (view != null && (view.getTag() instanceof e)) {
                    eVar = (e) view.getTag();
                    eVar.f13399b.setVisibility(0);
                    eVar.f13400c.setVisibility(8);
                    eVar.f13401d.setVisibility(8);
                    eVar.f13402e.setVisibility(8);
                } else {
                    view = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0146, viewGroup, false);
                    eVar = new e(this);
                    eVar.a = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f09032c);
                    eVar.f13399b = (BawuMemberInfoView) view.findViewById(R.id.obfuscated_res_0x7f091224);
                    eVar.f13400c = (BawuMemberInfoView) view.findViewById(R.id.obfuscated_res_0x7f091ab4);
                    eVar.f13401d = (BawuManagerApplyInfoView) view.findViewById(R.id.obfuscated_res_0x7f091223);
                    eVar.f13402e = (BawuManagerApplyInfoView) view.findViewById(R.id.obfuscated_res_0x7f091ab3);
                    view.setTag(eVar);
                }
                c.a.p0.c1.a.b bVar = (c.a.p0.c1.a.b) getItem(i);
                if (bVar != null && bVar.c() != null && bVar.c().size() > 0) {
                    if (bVar.e() && bVar.b()) {
                        RelativeLayout relativeLayout = eVar.a;
                        int i2 = this.f13396d;
                        relativeLayout.setPadding(i2, 0, i2, this.f13397e);
                        l lVar = this.f13395c;
                        if (lVar != null && !lVar.e()) {
                            if (bVar.c().size() == 2) {
                                if (bVar.d().equals(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02ea))) {
                                    eVar.f13402e.setVisibility(8);
                                    eVar.f13401d.setVisibility(8);
                                } else if (bVar.d().equals(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02eb))) {
                                    eVar.f13402e.setVisibility(8);
                                    eVar.f13401d.setVisibility(0);
                                    eVar.f13401d.a(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f13ca), this.f13395c.b());
                                    eVar.f13401d.setOnClickListener(new a(this));
                                }
                            } else if (bVar.d().equals(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02ea))) {
                                eVar.f13400c.setVisibility(8);
                                eVar.f13402e.setVisibility(8);
                                eVar.f13401d.setVisibility(8);
                            } else if (bVar.d().equals(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02eb))) {
                                eVar.f13400c.setVisibility(8);
                                eVar.f13402e.setVisibility(0);
                                eVar.f13401d.setVisibility(8);
                                eVar.f13402e.a(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f13ca), this.f13395c.b());
                                eVar.f13402e.setOnClickListener(new b(this));
                            }
                        }
                    } else {
                        RelativeLayout relativeLayout2 = eVar.a;
                        int i3 = this.f13396d;
                        relativeLayout2.setPadding(i3, 0, i3, 0);
                        eVar.f13401d.setVisibility(8);
                        eVar.f13402e.setVisibility(8);
                    }
                    eVar.f13399b.c(bVar.c().get(0));
                    if (bVar.c().size() >= 2) {
                        eVar.f13400c.c(bVar.c().get(1));
                        eVar.f13400c.setVisibility(0);
                    } else {
                        eVar.f13400c.setVisibility(8);
                    }
                    c.a.o0.r.v.c.d(view).f(R.color.CAM_X0201);
                    this.a.getLayoutMode().j(view);
                }
            } else if (getItemViewType(i) == 2) {
                if (view != null && (view.getTag() instanceof c)) {
                    c cVar = (c) view.getTag();
                } else {
                    view = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0145, viewGroup, false);
                    c cVar2 = new c(this);
                    cVar2.a = view.findViewById(R.id.obfuscated_res_0x7f090809);
                    view.setTag(cVar2);
                }
                c.a.o0.r.v.c.d(view).f(R.color.CAM_X0204);
                this.a.getLayoutMode().j(view);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }
}

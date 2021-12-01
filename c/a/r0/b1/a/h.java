package c.a.r0.b1.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.b1.c.l;
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
/* loaded from: classes5.dex */
public class h extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f14695e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<i> f14696f;

    /* renamed from: g  reason: collision with root package name */
    public l f14697g;

    /* renamed from: h  reason: collision with root package name */
    public int f14698h;

    /* renamed from: i  reason: collision with root package name */
    public int f14699i;

    /* renamed from: j  reason: collision with root package name */
    public d f14700j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f14701e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14701e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14701e.f14700j == null) {
                return;
            }
            this.f14701e.f14700j.a(this.f14701e.f14697g.a());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f14702e;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14702e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f14702e.f14700j == null) {
                return;
            }
            this.f14702e.f14700j.a(this.f14702e.f14697g.a());
        }
    }

    /* loaded from: classes5.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(String str);
    }

    /* loaded from: classes5.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;

        /* renamed from: b  reason: collision with root package name */
        public BawuMemberInfoView f14703b;

        /* renamed from: c  reason: collision with root package name */
        public BawuMemberInfoView f14704c;

        /* renamed from: d  reason: collision with root package name */
        public BawuManagerApplyInfoView f14705d;

        /* renamed from: e  reason: collision with root package name */
        public BawuManagerApplyInfoView f14706e;

        public e(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14698h = 0;
        this.f14699i = 0;
        this.f14695e = tbPageContext;
        this.f14696f = new ArrayList<>();
        this.f14698h = c.a.d.f.p.l.f(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.f14699i = c.a.d.f.p.l.f(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public i getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            ArrayList<i> arrayList = this.f14696f;
            if (arrayList == null || i2 >= arrayList.size()) {
                return null;
            }
            return this.f14696f.get(i2);
        }
        return (i) invokeI.objValue;
    }

    public void d(ArrayList<i> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.f14696f = arrayList;
        }
    }

    public void e(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
            this.f14697g = lVar;
        }
    }

    public void f(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.f14700j = dVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList<i> arrayList = this.f14696f;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? getItem(i2).a() : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        e eVar;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            if (getItemViewType(i2) == 0) {
                if (view != null && (view.getTag() instanceof f)) {
                    fVar = (f) view.getTag();
                } else {
                    view = LayoutInflater.from(this.f14695e.getPageActivity()).inflate(R.layout.bawu_item_title_view, viewGroup, false);
                    fVar = new f(this);
                    fVar.a = (TextView) view.findViewById(R.id.text_view_title);
                    view.setTag(fVar);
                }
                fVar.a.setText(((c.a.r0.b1.a.c) getItem(i2)).b());
                this.f14695e.getLayoutMode().j(view);
            } else if (getItemViewType(i2) == 1) {
                if (view != null && (view.getTag() instanceof e)) {
                    eVar = (e) view.getTag();
                    eVar.f14703b.setVisibility(0);
                    eVar.f14704c.setVisibility(8);
                    eVar.f14705d.setVisibility(8);
                    eVar.f14706e.setVisibility(8);
                } else {
                    view = LayoutInflater.from(this.f14695e.getPageActivity()).inflate(R.layout.bawu_item_member, viewGroup, false);
                    eVar = new e(this);
                    eVar.a = (RelativeLayout) view.findViewById(R.id.bawu_item_member_root);
                    eVar.f14703b = (BawuMemberInfoView) view.findViewById(R.id.left_member);
                    eVar.f14704c = (BawuMemberInfoView) view.findViewById(R.id.right_member);
                    eVar.f14705d = (BawuManagerApplyInfoView) view.findViewById(R.id.left_manager_apply);
                    eVar.f14706e = (BawuManagerApplyInfoView) view.findViewById(R.id.right_manager_apply);
                    view.setTag(eVar);
                }
                c.a.r0.b1.a.b bVar = (c.a.r0.b1.a.b) getItem(i2);
                if (bVar != null && bVar.c() != null && bVar.c().size() > 0) {
                    if (bVar.e() && bVar.b()) {
                        RelativeLayout relativeLayout = eVar.a;
                        int i3 = this.f14698h;
                        relativeLayout.setPadding(i3, 0, i3, this.f14699i);
                        l lVar = this.f14697g;
                        if (lVar != null && !lVar.e()) {
                            if (bVar.c().size() == 2) {
                                if (bVar.d().equals(this.f14695e.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                    eVar.f14706e.setVisibility(8);
                                    eVar.f14705d.setVisibility(8);
                                } else if (bVar.d().equals(this.f14695e.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                    eVar.f14706e.setVisibility(8);
                                    eVar.f14705d.setVisibility(0);
                                    eVar.f14705d.fillView(this.f14695e.getResources().getString(R.string.tip_assist_apply), this.f14697g.d());
                                    eVar.f14705d.setOnClickListener(new a(this));
                                }
                            } else if (bVar.d().equals(this.f14695e.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                eVar.f14704c.setVisibility(8);
                                eVar.f14706e.setVisibility(8);
                                eVar.f14705d.setVisibility(8);
                            } else if (bVar.d().equals(this.f14695e.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                eVar.f14704c.setVisibility(8);
                                eVar.f14706e.setVisibility(0);
                                eVar.f14705d.setVisibility(8);
                                eVar.f14706e.fillView(this.f14695e.getResources().getString(R.string.tip_assist_apply), this.f14697g.d());
                                eVar.f14706e.setOnClickListener(new b(this));
                            }
                        }
                    } else {
                        RelativeLayout relativeLayout2 = eVar.a;
                        int i4 = this.f14698h;
                        relativeLayout2.setPadding(i4, 0, i4, 0);
                        eVar.f14705d.setVisibility(8);
                        eVar.f14706e.setVisibility(8);
                    }
                    eVar.f14703b.fillView(bVar.c().get(0));
                    if (bVar.c().size() >= 2) {
                        eVar.f14704c.fillView(bVar.c().get(1));
                        eVar.f14704c.setVisibility(0);
                    } else {
                        eVar.f14704c.setVisibility(8);
                    }
                    this.f14695e.getLayoutMode().j(view);
                }
            } else if (getItemViewType(i2) == 2) {
                if (view != null && (view.getTag() instanceof c)) {
                    c cVar = (c) view.getTag();
                } else {
                    view = LayoutInflater.from(this.f14695e.getPageActivity()).inflate(R.layout.bawu_item_divider_view, viewGroup, false);
                    c cVar2 = new c(this);
                    cVar2.a = view.findViewById(R.id.divider_view);
                    view.setTag(cVar2);
                }
                this.f14695e.getLayoutMode().j(view);
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

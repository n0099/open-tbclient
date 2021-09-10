package c.a.r0.t2;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.s.s.a;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.PostSearchActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f25019a;

    /* renamed from: b  reason: collision with root package name */
    public View f25020b;

    /* renamed from: c  reason: collision with root package name */
    public View f25021c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f25022d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.u1.d f25023e;

    /* renamed from: f  reason: collision with root package name */
    public View f25024f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.s.s.a f25025g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f25026h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f25027i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25028e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25028e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25028e.l();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25029e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25029e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                TiebaStatic.log(new StatisticItem("c12403").param("fid", this.f25029e.f25019a.mForumId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", this.f25029e.f25019a.mForumName));
                String str = (String) this.f25029e.f25022d.getItemAtPosition(i2 + 1);
                this.f25029e.f25019a.setEditSearchText(str);
                this.f25029e.f25019a.startSearch(str);
                PostSearchActivity unused = this.f25029e.f25019a;
                TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", str).param("obj_source", "3").param("obj_type", "2").param("fid", this.f25029e.f25019a.mForumId));
            }
        }
    }

    /* renamed from: c.a.r0.t2.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC1165c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25030e;

        public View$OnTouchListenerC1165c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25030e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f25030e.f25019a.hideSoftKeyPad();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25031e;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25031e = cVar;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f25031e.f25019a.getModel().g();
                this.f25031e.f25022d.setVisibility(8);
                this.f25031e.n();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25032e;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25032e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f25032e.f25019a.hideSoftKeyPad();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public c(PostSearchActivity postSearchActivity, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {postSearchActivity, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25023e = null;
        this.f25024f = null;
        this.f25027i = false;
        this.f25019a = postSearchActivity;
        this.f25020b = view;
        h();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25021c.setVisibility(8);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f25027i = false;
            this.f25019a.hideLoadingView(this.f25021c);
        }
    }

    public void g() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (noDataView = this.f25026h) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f25021c = this.f25019a.findViewById(R.id.history_frame);
            this.f25022d = (BdListView) this.f25020b.findViewById(R.id.history_list);
            BdListViewHelper.d(this.f25019a.getActivity(), this.f25022d, BdListViewHelper.HeadType.DEFAULT);
            c.a.r0.u1.d dVar = new c.a.r0.u1.d(this.f25019a.getPageContext().getPageActivity(), null);
            this.f25023e = dVar;
            dVar.b(false);
            this.f25022d.setAdapter((ListAdapter) this.f25023e);
            View inflate = LayoutInflater.from(this.f25019a.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
            this.f25024f = inflate;
            this.f25022d.addFooterView(inflate);
            this.f25024f.setOnClickListener(new a(this));
            this.f25022d.setOnItemClickListener(new b(this));
            this.f25022d.setOnTouchListener(new View$OnTouchListenerC1165c(this));
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f25021c.getVisibility() != 0 || this.f25027i) {
                return false;
            }
            NoDataView noDataView = this.f25026h;
            return noDataView == null || 8 == noDataView.getVisibility();
        }
        return invokeV.booleanValue;
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            c.a.q0.w0.a.a(this.f25019a.getPageContext(), this.f25024f);
            this.f25023e.notifyDataSetChanged();
            NoDataView noDataView = this.f25026h;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f25019a.getPageContext(), i2);
            }
        }
    }

    public void k(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f25021c.setVisibility(0);
            f();
            if (arrayList != null && arrayList.size() != 0) {
                g();
                this.f25022d.setVisibility(0);
                this.f25023e.a(arrayList);
                this.f25023e.notifyDataSetChanged();
                return;
            }
            this.f25022d.setVisibility(8);
            n();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f25025g == null) {
                this.f25025g = new c.a.q0.s.s.a(this.f25019a.getPageContext().getPageActivity()).setMessage(this.f25019a.getPageContext().getString(R.string.alert_clean_history)).setPositiveButton(this.f25019a.getPageContext().getString(R.string.clear_all_text), new e(this)).setNegativeButton(this.f25019a.getPageContext().getString(R.string.cancel), new d(this)).create(this.f25019a.getPageContext());
            }
            this.f25025g.show();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f25027i = true;
            PostSearchActivity postSearchActivity = this.f25019a;
            postSearchActivity.showLoadingView(this.f25021c, false, postSearchActivity.getResources().getDimensionPixelSize(R.dimen.ds386));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            o(R.string.new_text_no_search_record);
        }
    }

    public final void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (this.f25026h == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f25019a.getPageContext().getPageActivity(), this.f25021c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f25019a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_record), null);
                this.f25026h = a2;
                a2.onChangeSkinType(this.f25019a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                this.f25026h.setOnTouchListener(new f(this));
            }
            this.f25026h.setTextOption(NoDataViewFactory.e.d(null, this.f25019a.getResources().getString(i2)));
            this.f25026h.setVisibility(0);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f25022d.setVisibility(8);
            o(R.string.new_text_no_search_result);
        }
    }
}

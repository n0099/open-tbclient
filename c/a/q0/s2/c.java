package c.a.q0.s2;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.p0.s.s.a;
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
    public PostSearchActivity f24353a;

    /* renamed from: b  reason: collision with root package name */
    public View f24354b;

    /* renamed from: c  reason: collision with root package name */
    public View f24355c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f24356d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.t1.d f24357e;

    /* renamed from: f  reason: collision with root package name */
    public View f24358f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.s.s.a f24359g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f24360h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f24361i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f24362e;

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
            this.f24362e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f24362e.l();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f24363e;

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
            this.f24363e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                TiebaStatic.log(new StatisticItem("c12403").param("fid", this.f24363e.f24353a.mForumId).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fname", this.f24363e.f24353a.mForumName));
                String str = (String) this.f24363e.f24356d.getItemAtPosition(i2 + 1);
                this.f24363e.f24353a.setEditSearchText(str);
                this.f24363e.f24353a.startSearch(str);
                PostSearchActivity unused = this.f24363e.f24353a;
                TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", str).param("obj_source", "3").param("obj_type", "2").param("fid", this.f24363e.f24353a.mForumId));
            }
        }
    }

    /* renamed from: c.a.q0.s2.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC1127c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f24364e;

        public View$OnTouchListenerC1127c(c cVar) {
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
            this.f24364e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f24364e.f24353a.hideSoftKeyPad();
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

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
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
        public final /* synthetic */ c f24365e;

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
            this.f24365e = cVar;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f24365e.f24353a.getModel().g();
                this.f24365e.f24356d.setVisibility(8);
                this.f24365e.n();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f24366e;

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
            this.f24366e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f24366e.f24353a.hideSoftKeyPad();
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
        this.f24357e = null;
        this.f24358f = null;
        this.f24361i = false;
        this.f24353a = postSearchActivity;
        this.f24354b = view;
        h();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24355c.setVisibility(8);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24361i = false;
            this.f24353a.hideLoadingView(this.f24355c);
        }
    }

    public void g() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (noDataView = this.f24360h) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f24355c = this.f24353a.findViewById(R.id.history_frame);
            this.f24356d = (BdListView) this.f24354b.findViewById(R.id.history_list);
            BdListViewHelper.d(this.f24353a.getActivity(), this.f24356d, BdListViewHelper.HeadType.DEFAULT);
            c.a.q0.t1.d dVar = new c.a.q0.t1.d(this.f24353a.getPageContext().getPageActivity(), null);
            this.f24357e = dVar;
            dVar.b(false);
            this.f24356d.setAdapter((ListAdapter) this.f24357e);
            View inflate = LayoutInflater.from(this.f24353a.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
            this.f24358f = inflate;
            this.f24356d.addFooterView(inflate);
            this.f24358f.setOnClickListener(new a(this));
            this.f24356d.setOnItemClickListener(new b(this));
            this.f24356d.setOnTouchListener(new View$OnTouchListenerC1127c(this));
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f24355c.getVisibility() != 0 || this.f24361i) {
                return false;
            }
            NoDataView noDataView = this.f24360h;
            return noDataView == null || 8 == noDataView.getVisibility();
        }
        return invokeV.booleanValue;
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            c.a.p0.u0.a.a(this.f24353a.getPageContext(), this.f24358f);
            this.f24357e.notifyDataSetChanged();
            NoDataView noDataView = this.f24360h;
            if (noDataView != null) {
                noDataView.onChangeSkinType(this.f24353a.getPageContext(), i2);
            }
        }
    }

    public void k(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) {
            this.f24355c.setVisibility(0);
            f();
            if (arrayList != null && arrayList.size() != 0) {
                g();
                this.f24356d.setVisibility(0);
                this.f24357e.a(arrayList);
                this.f24357e.notifyDataSetChanged();
                return;
            }
            this.f24356d.setVisibility(8);
            n();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f24359g == null) {
                this.f24359g = new c.a.p0.s.s.a(this.f24353a.getPageContext().getPageActivity()).setMessage(this.f24353a.getPageContext().getString(R.string.alert_clean_history)).setPositiveButton(this.f24353a.getPageContext().getString(R.string.clear_all_text), new e(this)).setNegativeButton(this.f24353a.getPageContext().getString(R.string.cancel), new d(this)).create(this.f24353a.getPageContext());
            }
            this.f24359g.show();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f24361i = true;
            PostSearchActivity postSearchActivity = this.f24353a;
            postSearchActivity.showLoadingView(this.f24355c, false, postSearchActivity.getResources().getDimensionPixelSize(R.dimen.ds386));
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
            if (this.f24360h == null) {
                NoDataView a2 = NoDataViewFactory.a(this.f24353a.getPageContext().getPageActivity(), this.f24355c, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f24353a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.text_no_search_record), null);
                this.f24360h = a2;
                a2.onChangeSkinType(this.f24353a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                this.f24360h.setOnTouchListener(new f(this));
            }
            this.f24360h.setTextOption(NoDataViewFactory.e.d(null, this.f24353a.getResources().getString(i2)));
            this.f24360h.setVisibility(0);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f24356d.setVisibility(8);
            o(R.string.new_text_no_search_result);
        }
    }
}

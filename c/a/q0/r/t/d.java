package c.a.q0.r.t;

import android.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<l> f13458b;

    /* renamed from: c  reason: collision with root package name */
    public AdapterView.OnItemClickListener f13459c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f13460d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f13461e;

    /* renamed from: f  reason: collision with root package name */
    public k f13462f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13463g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f13464h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13465i;

    /* renamed from: j  reason: collision with root package name */
    public AlertDialog f13466j;
    public AdapterView.OnItemClickListener k;

    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f13467e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13467e = dVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (this.f13467e.f13459c != null) {
                    this.f13467e.f13459c.onItemClick(adapterView, view, i2, j2);
                }
                this.f13467e.f();
            }
        }
    }

    public d(TbPageContext<?> tbPageContext) {
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
        this.f13465i = false;
        this.k = new a(this);
        this.f13464h = tbPageContext;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.dialog_rich_layout, (ViewGroup) null);
        this.f13460d = viewGroup;
        this.f13463g = (TextView) viewGroup.findViewById(R.id.dialog_title_list);
        this.f13461e = (BdListView) this.f13460d.findViewById(R.id.dialog_content_list);
        this.f13462f = new k(this.f13464h);
    }

    public void b(c.a.d.a.f<?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) fVar;
                tbPageContext.getLayoutMode().k(skinType == 1);
                tbPageContext.getLayoutMode().j(this.f13460d);
            }
            this.f13460d.setBackgroundResource(R.drawable.transparent_bg);
        }
    }

    public d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f13465i) {
                return this;
            }
            this.f13465i = true;
            if (!TextUtils.isEmpty(this.a)) {
                this.f13463g.setText(this.a);
                this.f13463g.setVisibility(0);
            } else {
                this.f13463g.setVisibility(8);
            }
            this.f13461e.setAdapter((ListAdapter) this.f13462f);
            this.f13462f.c(this.f13458b);
            b(this.f13464h);
            return this;
        }
        return (d) invokeV.objValue;
    }

    public void d() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (alertDialog = this.f13466j) == null) {
            return;
        }
        c.a.d.f.m.g.a(alertDialog, this.f13464h.getPageActivity());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13460d : (View) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b(this.f13464h);
            k kVar = this.f13462f;
            if (kVar != null) {
                kVar.notifyDataSetChanged();
            }
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            for (int i3 = 0; i3 < this.f13458b.size(); i3++) {
                if (i3 == i2) {
                    this.f13458b.get(i3).e(true);
                } else {
                    this.f13458b.get(i3).e(false);
                }
            }
            this.f13462f.c(this.f13458b);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f13462f.b(z);
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            for (int i3 = 0; i3 < this.f13458b.size(); i3++) {
                if (i3 == i2) {
                    l lVar = this.f13458b.get(i3);
                    lVar.e(!lVar.d());
                }
            }
            this.f13462f.c(this.f13458b);
        }
    }

    public d k(ArrayList<l> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, arrayList, onItemClickListener)) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.f13458b = arrayList;
                if (onItemClickListener != null) {
                    this.f13459c = onItemClickListener;
                    this.f13461e.setOnItemClickListener(this.k);
                }
            }
            return this;
        }
        return (d) invokeLL.objValue;
    }

    public d l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            m(this.f13464h.getResources().getString(i2));
            return this;
        }
        return (d) invokeI.objValue;
    }

    public d m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.a = str;
            return this;
        }
        return (d) invokeL.objValue;
    }

    public d n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f13465i) {
                AlertDialog alertDialog = this.f13466j;
                if (alertDialog != null) {
                    c.a.d.f.m.g.j(alertDialog, this.f13464h);
                    return this;
                }
                AlertDialog create = new AlertDialog.Builder(this.f13464h.getPageActivity()).create();
                this.f13466j = create;
                create.setCanceledOnTouchOutside(true);
                if (c.a.d.f.m.g.i(this.f13466j, this.f13464h.getPageActivity())) {
                    Window window = this.f13466j.getWindow();
                    window.addFlags(512);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.y = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                    window.setAttributes(attributes);
                    window.setWindowAnimations(R.style.share_dialog_style);
                    window.setGravity(80);
                    window.setLayout(-1, -2);
                    window.setContentView(this.f13460d);
                    return this;
                }
                return this;
            }
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        return (d) invokeV.objValue;
    }
}

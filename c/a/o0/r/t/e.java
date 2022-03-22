package c.a.o0.r.t;

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
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f11037b;

    /* renamed from: c  reason: collision with root package name */
    public AdapterView.OnItemClickListener f11038c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f11039d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f11040e;

    /* renamed from: f  reason: collision with root package name */
    public m f11041f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f11042g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext<?> f11043h;
    public boolean i;
    public AlertDialog j;
    public AdapterView.OnItemClickListener k;

    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (this.a.f11038c != null) {
                    this.a.f11038c.onItemClick(adapterView, view, i, j);
                }
                this.a.f();
            }
        }
    }

    public e(TbPageContext<?> tbPageContext) {
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
        this.i = false;
        this.k = new a(this);
        this.f11043h = tbPageContext;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0239, (ViewGroup) null);
        this.f11039d = viewGroup;
        this.f11042g = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907b8);
        this.f11040e = (BdListView) this.f11039d.findViewById(R.id.obfuscated_res_0x7f09079f);
        this.f11041f = new m(this.f11043h);
    }

    public void b(c.a.d.a.f<?> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (fVar instanceof TbPageContext) {
                TbPageContext tbPageContext = (TbPageContext) fVar;
                tbPageContext.getLayoutMode().k(skinType == 1);
                tbPageContext.getLayoutMode().j(this.f11039d);
            }
            this.f11039d.setBackgroundResource(R.drawable.obfuscated_res_0x7f081200);
        }
    }

    public e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.i) {
                return this;
            }
            this.i = true;
            if (!TextUtils.isEmpty(this.a)) {
                this.f11042g.setText(this.a);
                this.f11042g.setVisibility(0);
            } else {
                this.f11042g.setVisibility(8);
            }
            this.f11040e.setAdapter((ListAdapter) this.f11041f);
            this.f11041f.c(this.f11037b);
            b(this.f11043h);
            return this;
        }
        return (e) invokeV.objValue;
    }

    public void d() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (alertDialog = this.j) == null) {
            return;
        }
        c.a.d.f.m.g.a(alertDialog, this.f11043h.getPageActivity());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f11039d : (View) invokeV.objValue;
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
            b(this.f11043h);
            m mVar = this.f11041f;
            if (mVar != null) {
                mVar.notifyDataSetChanged();
            }
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            for (int i2 = 0; i2 < this.f11037b.size(); i2++) {
                if (i2 == i) {
                    this.f11037b.get(i2).e(true);
                } else {
                    this.f11037b.get(i2).e(false);
                }
            }
            this.f11041f.c(this.f11037b);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f11041f.b(z);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            for (int i2 = 0; i2 < this.f11037b.size(); i2++) {
                if (i2 == i) {
                    n nVar = this.f11037b.get(i2);
                    nVar.e(!nVar.d());
                }
            }
            this.f11041f.c(this.f11037b);
        }
    }

    public e k(ArrayList<n> arrayList, AdapterView.OnItemClickListener onItemClickListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, arrayList, onItemClickListener)) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.f11037b = arrayList;
                if (onItemClickListener != null) {
                    this.f11038c = onItemClickListener;
                    this.f11040e.setOnItemClickListener(this.k);
                }
            }
            return this;
        }
        return (e) invokeLL.objValue;
    }

    public e l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            m(this.f11043h.getResources().getString(i));
            return this;
        }
        return (e) invokeI.objValue;
    }

    public e m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            this.a = str;
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.i) {
                AlertDialog alertDialog = this.j;
                if (alertDialog != null) {
                    c.a.d.f.m.g.j(alertDialog, this.f11043h);
                    return this;
                }
                AlertDialog create = new AlertDialog.Builder(this.f11043h.getPageActivity()).create();
                this.j = create;
                create.setCanceledOnTouchOutside(true);
                if (c.a.d.f.m.g.i(this.j, this.f11043h.getPageActivity())) {
                    Window window = this.j.getWindow();
                    window.addFlags(512);
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.y = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
                    window.setAttributes(attributes);
                    window.setWindowAnimations(R.style.obfuscated_res_0x7f1003ed);
                    window.setGravity(80);
                    window.setLayout(-1, -2);
                    window.setContentView(this.f11039d);
                    return this;
                }
                return this;
            }
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        return (e) invokeV.objValue;
    }
}

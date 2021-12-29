package c.a.t0.s2.u.f.h1;

import android.view.View;
import android.widget.TextView;
import c.a.t0.s2.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View a;

    /* renamed from: b  reason: collision with root package name */
    public final View f23564b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23565c;

    /* renamed from: d  reason: collision with root package name */
    public PbFragment f23566d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f23567e;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f23568e;

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
            this.f23568e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = this.f23568e;
                if (view != bVar.f23564b || bVar.f23566d == null || this.f23568e.f23566d.getBaseFragmentActivity() == null) {
                    return;
                }
                this.f23568e.f23566d.getBaseFragmentActivity().finish();
            }
        }
    }

    public b(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23567e = new a(this);
        this.f23566d = pbFragment;
        this.f23564b = pbFragment.getBaseFragmentActivity().findViewById(i.manga_navigation_bar_back);
        this.f23565c = (TextView) this.f23566d.getBaseFragmentActivity().findViewById(i.manga_navigation_bar_title);
        this.a = this.f23566d.getBaseFragmentActivity().findViewById(i.manga_browser_navigation_bar);
        this.f23564b.setOnClickListener(this.f23567e);
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f23565c.setText(str);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.setVisibility(0);
        }
    }
}

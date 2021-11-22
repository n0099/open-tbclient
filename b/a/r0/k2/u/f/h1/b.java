package b.a.r0.k2.u.f.h1;

import android.view.View;
import android.widget.TextView;
import b.a.r0.k2.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final View f20859a;

    /* renamed from: b  reason: collision with root package name */
    public final View f20860b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f20861c;

    /* renamed from: d  reason: collision with root package name */
    public PbFragment f20862d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f20863e;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f20864e;

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
            this.f20864e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = this.f20864e;
                if (view != bVar.f20860b || bVar.f20862d == null || this.f20864e.f20862d.getBaseFragmentActivity() == null) {
                    return;
                }
                this.f20864e.f20862d.getBaseFragmentActivity().finish();
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
        this.f20863e = new a(this);
        this.f20862d = pbFragment;
        this.f20860b = pbFragment.getBaseFragmentActivity().findViewById(i.manga_navigation_bar_back);
        this.f20861c = (TextView) this.f20862d.getBaseFragmentActivity().findViewById(i.manga_navigation_bar_title);
        this.f20859a = this.f20862d.getBaseFragmentActivity().findViewById(i.manga_browser_navigation_bar);
        this.f20860b.setOnClickListener(this.f20863e);
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.f20861c.setText(str);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f20859a.setVisibility(0);
        }
    }
}

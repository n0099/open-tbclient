package c.a.c0.h0;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.c0.h0.k;
import c.a.c0.p.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.view.AdInteractionView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c implements k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final AdInteractionView a;

    /* renamed from: b  reason: collision with root package name */
    public k.a f1704b;

    /* loaded from: classes.dex */
    public class a implements AdInteractionView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
        }

        @Override // com.baidu.nadcore.widget.view.AdInteractionView.b
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.a.f1704b == null) {
                return;
            }
            this.a.f1704b.onClick(i2);
        }
    }

    /* loaded from: classes.dex */
    public class b implements AdInteractionView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }
    }

    public c(@NonNull ViewGroup viewGroup, @Nullable c.a.c0.p.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        AdInteractionView adInteractionView = new AdInteractionView(viewGroup.getContext());
        this.a = adInteractionView;
        adInteractionView.setContainer(viewGroup);
        eVar = eVar == null ? new c.a.c0.p.e() : eVar;
        this.a.setInteractionConfig(eVar);
        if (viewGroup.getContext() instanceof Activity) {
            e((Activity) viewGroup.getContext(), eVar.f1793f);
        }
        this.a.setInteractionClickListener(new a(this));
    }

    @Override // c.a.c0.h0.k
    @Nullable
    public View a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.a.getView(str) : (View) invokeL.objValue;
    }

    @Override // c.a.c0.h0.k
    public void b(@NonNull AdBaseModel adBaseModel) {
        c.a.c0.p.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel) == null) || adBaseModel == null || (fVar = adBaseModel.f38070k) == null || fVar.f1795c == null || fVar.a == null || fVar.f1794b == null) {
            return;
        }
        this.a.setTag(adBaseModel);
        f(adBaseModel.f38070k.a.f1797b == 1, adBaseModel.f38070k.a.a);
        this.a.setClickPraiseListener(new b(this));
        this.a.initAvatar(adBaseModel);
    }

    public final String d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 > 9999) {
                return (((int) ((i2 / 1000.0d) + 0.5d)) / 10.0d) + "万";
            }
            return String.valueOf(i2);
        }
        return (String) invokeI.objValue;
    }

    public final void e(@NonNull Activity activity, @NonNull e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, activity, bVar) == null) {
        }
    }

    public final void f(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.a.setPraiseData(z, i2 <= 0 ? "" : d(i2));
        }
    }

    @Override // c.a.c0.h0.k
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.release();
        }
    }
}

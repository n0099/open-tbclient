package c.a.u0.e1.v2.c.f;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.u0.e1.c1;
import c.a.u0.e1.d1;
import c.a.u0.e1.e1;
import c.a.u0.e1.f1;
import c.a.u0.e1.i1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThemeElement;
/* loaded from: classes8.dex */
public class e implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f17247b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public Boolean f17248c;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1390293100, "Lc/a/u0/e1/v2/c/f/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1390293100, "Lc/a/u0/e1/v2/c/f/e$a;");
                    return;
                }
            }
            int[] iArr = new int[LogicField.values().length];
            a = iArr;
            try {
                iArr[LogicField.LIKE_BTN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LogicField.SIGN_BTN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TBSpecificationBtn f17249b;

        /* renamed from: c  reason: collision with root package name */
        public TBSpecificationBtn f17250c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @NonNull
        public static b a(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view)) == null) {
                b bVar = new b();
                bVar.a = view;
                bVar.f17249b = (TBSpecificationBtn) view.findViewById(f1.like);
                bVar.f17250c = (TBSpecificationBtn) view.findViewById(f1.sign);
                return bVar;
            }
            return (b) invokeL.objValue;
        }
    }

    public e(@NonNull FrsFragment frsFragment, @NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17247b = view.getContext();
        b a2 = b.a(view);
        this.a = a2;
        a2.f17249b.setText(this.f17247b.getResources().getString(i1.attention));
        this.a.f17249b.setTextSize(d1.T_X08);
        c.a.t0.s.l0.n.b bVar = new c.a.t0.s.l0.n.b();
        bVar.p(c1.CAM_X0901, c1.CAM_X0105);
        this.a.f17249b.setConfig(bVar);
        this.a.f17249b.setTag(f1.click_view_tag, LogicField.LIKE_BTN);
        this.a.f17250c.setTextSize(d1.T_X08);
        c.a.t0.s.l0.n.b bVar2 = new c.a.t0.s.l0.n.b();
        bVar2.u(c1.CAM_X0105);
        bVar2.g(UtilHelper.getDimenPixelSize(d1.tbds39));
        bVar2.i(e1.icon_pure_frs_sign16, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.a.f17250c.setConfig(bVar2);
        this.a.f17250c.setText(this.f17247b.getResources().getString(i1.sign));
        this.a.f17250c.setTag(f1.click_view_tag, LogicField.SIGN_BTN);
    }

    @Override // c.a.u0.e1.v2.c.f.d
    @Nullable
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            int i2 = a.a[logicField.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return null;
                }
                return (T) this.a.f17250c;
            }
            return (T) this.a.f17249b;
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.a : (View) invokeV.objValue;
    }

    @Override // c.a.u0.e1.v2.c.f.d
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.a.f17249b.setVisibility(8);
                this.a.f17250c.setVisibility(0);
                return;
            }
            this.a.f17249b.setVisibility(0);
            this.a.f17250c.setVisibility(8);
        }
    }

    @Override // c.a.u0.e1.v2.c.f.d
    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.a.f17249b.setOnClickListener(onClickListener);
            this.a.f17250c.setOnClickListener(onClickListener);
        }
    }

    public void e(boolean z, @NonNull ThemeElement themeElement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, themeElement) == null) {
            Boolean bool = this.f17248c;
            if (bool == null || bool.booleanValue() != z) {
                this.f17248c = Boolean.valueOf(z);
                c.a.t0.s.l0.n.b bVar = (c.a.t0.s.l0.n.b) this.a.f17249b.getStyleConfig();
                if (z) {
                    bVar.p(c1.CAM_X0901, c1.CAM_X0105);
                } else {
                    bVar.s(c.a.u0.z3.c.e(themeElement.common_color));
                }
                this.a.f17249b.setConfig(bVar);
                this.a.f17249b.setTag(f1.item_tag_data, Boolean.valueOf(!z));
                c.a.t0.s.l0.n.b bVar2 = (c.a.t0.s.l0.n.b) this.a.f17250c.getStyleConfig();
                if (z) {
                    bVar2.u(c1.CAM_X0105);
                } else {
                    Object tag = this.a.f17250c.getTag(f1.item_tag_data);
                    if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                        bVar2.t(c1.CAM_X0105);
                    } else {
                        bVar2.s(c.a.u0.z3.c.e(themeElement.common_color));
                    }
                }
                this.a.f17250c.setConfig(bVar2);
            }
        }
    }
}

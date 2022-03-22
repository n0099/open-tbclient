package c.a.p0.f1.l2.c.f;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
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
/* loaded from: classes2.dex */
public class e implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f14229b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public Boolean f14230c;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-797202308, "Lc/a/p0/f1/l2/c/f/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-797202308, "Lc/a/p0/f1/l2/c/f/e$a;");
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

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TBSpecificationBtn f14231b;

        /* renamed from: c  reason: collision with root package name */
        public TBSpecificationBtn f14232c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                bVar.f14231b = (TBSpecificationBtn) view.findViewById(R.id.obfuscated_res_0x7f09124c);
                bVar.f14232c = (TBSpecificationBtn) view.findViewById(R.id.obfuscated_res_0x7f091cfc);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14229b = view.getContext();
        b a2 = b.a(view);
        this.a = a2;
        a2.f14231b.setText(this.f14229b.getResources().getString(R.string.obfuscated_res_0x7f0f029b));
        this.a.f14231b.setTextSize(R.dimen.T_X08);
        c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
        bVar.p(R.color.CAM_X0901, R.color.CAM_X0105);
        this.a.f14231b.setConfig(bVar);
        this.a.f14231b.setTag(R.id.obfuscated_res_0x7f090659, LogicField.LIKE_BTN);
        this.a.f14232c.setTextSize(R.dimen.T_X08);
        c.a.o0.r.l0.n.b bVar2 = new c.a.o0.r.l0.n.b();
        bVar2.u(R.color.CAM_X0105);
        bVar2.g(UtilHelper.getDimenPixelSize(R.dimen.tbds39));
        bVar2.i(R.drawable.obfuscated_res_0x7f080906, 0, TBSpecificationButtonConfig.IconType.WEBP);
        this.a.f14232c.setConfig(bVar2);
        this.a.f14232c.setText(this.f14229b.getResources().getString(R.string.obfuscated_res_0x7f0f1158));
        this.a.f14232c.setTag(R.id.obfuscated_res_0x7f090659, LogicField.SIGN_BTN);
    }

    @Override // c.a.p0.f1.l2.c.f.d
    @Nullable
    public <T> T a(@NonNull LogicField logicField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, logicField)) == null) {
            int i = a.a[logicField.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return (T) this.a.f14232c;
            }
            return (T) this.a.f14231b;
        }
        return (T) invokeL.objValue;
    }

    @NonNull
    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.a : (View) invokeV.objValue;
    }

    @Override // c.a.p0.f1.l2.c.f.d
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.a.f14231b.setVisibility(8);
                this.a.f14232c.setVisibility(0);
                return;
            }
            this.a.f14231b.setVisibility(0);
            this.a.f14232c.setVisibility(8);
        }
    }

    @Override // c.a.p0.f1.l2.c.f.d
    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.a.f14231b.setOnClickListener(onClickListener);
            this.a.f14232c.setOnClickListener(onClickListener);
        }
    }

    public void e(boolean z, @NonNull ThemeElement themeElement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, themeElement) == null) {
            Boolean bool = this.f14230c;
            if (bool == null || bool.booleanValue() != z) {
                this.f14230c = Boolean.valueOf(z);
                c.a.o0.r.l0.n.b bVar = (c.a.o0.r.l0.n.b) this.a.f14231b.getStyleConfig();
                if (z) {
                    bVar.p(R.color.CAM_X0901, R.color.CAM_X0105);
                } else if (UtilHelper.isNightOrDarkMode()) {
                    bVar.t(R.color.CAM_X0105);
                } else {
                    bVar.s(c.a.p0.a4.c.e(themeElement.common_color));
                }
                this.a.f14231b.setConfig(bVar);
                this.a.f14231b.setTag(R.id.obfuscated_res_0x7f090fa7, Boolean.valueOf(!z));
                c.a.o0.r.l0.n.b bVar2 = (c.a.o0.r.l0.n.b) this.a.f14232c.getStyleConfig();
                if (z) {
                    bVar2.u(R.color.CAM_X0105);
                } else {
                    Object tag = this.a.f14232c.getTag(R.id.obfuscated_res_0x7f090fa7);
                    if (((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) || UtilHelper.isNightOrDarkMode()) {
                        bVar2.t(R.color.CAM_X0105);
                    } else {
                        bVar2.s(c.a.p0.a4.c.e(themeElement.common_color));
                    }
                }
                this.a.f14232c.setConfig(bVar2);
            }
        }
    }
}

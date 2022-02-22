package c.a.t0.x.s;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import c.a.t0.x.m;
import c.a.u0.a4.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.inputtool.InputView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a extends m {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] s;
    public transient /* synthetic */ FieldHolder $fh;
    public InputView r;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(659861722, "Lc/a/t0/x/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(659861722, "Lc/a/t0/x/s/a;");
                return;
            }
        }
        s = new int[]{4, 17, 24, 3, 9, 6, 44};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, boolean z) {
        super(context, (String) null, 3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        f(context, z);
    }

    public final void f(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, context, z) == null) {
            this.m = false;
            this.l = 2;
            this.n = s;
            InputView inputView = new InputView(context, z);
            this.r = inputView;
            this.k = inputView;
            RawLayout.LayoutParams layoutParams = new RawLayout.LayoutParams(0, -1);
            ((LinearLayout.LayoutParams) layoutParams).topMargin = context.getResources().getDimensionPixelSize(e.ds14);
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = context.getResources().getDimensionPixelSize(e.ds14);
            ((LinearLayout.LayoutParams) layoutParams).leftMargin = context.getResources().getDimensionPixelSize(e.ds30);
            ((LinearLayout.LayoutParams) layoutParams).rightMargin = context.getResources().getDimensionPixelSize(e.ds12);
            ((LinearLayout.LayoutParams) layoutParams).weight = 1.0f;
            ((LinearLayout.LayoutParams) layoutParams).gravity = 80;
            ((View) this.k).setLayoutParams(layoutParams);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            ((InputView) this.k).setIsOnlyLocalEmotion(z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, boolean z, boolean z2) {
        super(context, (String) null, 3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        f(context, z);
        InputView inputView = this.r;
        if (inputView != null) {
            inputView.setNeedFaceMaxCount(z2);
        }
    }
}

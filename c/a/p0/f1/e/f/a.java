package c.a.p0.f1.e.f;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f17168a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0836a f17169b;

    /* renamed from: c.a.p0.f1.e.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0836a {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext tbPageContext, View view, int i2, int i3) {
        super(view, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17168a = tbPageContext;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.dismiss();
        }
    }

    public void b(InterfaceC0836a interfaceC0836a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0836a) == null) {
            this.f17169b = interfaceC0836a;
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            InterfaceC0836a interfaceC0836a = this.f17169b;
            if (interfaceC0836a != null) {
                interfaceC0836a.a();
            } else {
                super.dismiss();
            }
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                setHeight(ViewCommonUtil.getScreenFullSize(this.f17168a.getPageActivity())[1] - rect.bottom);
            }
            super.showAsDropDown(view);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, view, i2, i3) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                setHeight(ViewCommonUtil.getScreenFullSize(this.f17168a.getPageActivity())[1] - rect.bottom);
            }
            super.showAsDropDown(view, i2, i3);
        }
    }
}

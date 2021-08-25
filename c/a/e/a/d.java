package c.a.e.a;

import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f<T> mContext;
    public InputMethodManager mInputManager;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public View f1977e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f1978f;

        public a(d dVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1978f = dVar;
            this.f1977e = null;
            this.f1977e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            f<T> fVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fVar = this.f1978f.mContext) == null || fVar.getPageActivity() == null || this.f1978f.mContext.getPageActivity().isFinishing()) {
                return;
            }
            this.f1978f.ShowSoftKeyPad(this.f1977e);
        }
    }

    public d(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = null;
        this.mInputManager = null;
        this.mContext = fVar;
    }

    public void HidenSoftKeyPad(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            try {
                if (this.mInputManager == null) {
                    getInputMethodManager();
                }
                if (this.mInputManager != null && view != null) {
                    this.mInputManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void ShowSoftKeyPad(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            try {
                getInputMethodManager().showSoftInput(view, 0);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void ShowSoftKeyPadDelay(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i2) == null) {
            new Handler().postDelayed(new a(this, view), i2);
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public InputMethodManager getInputMethodManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mInputManager == null) {
                this.mInputManager = (InputMethodManager) this.mContext.getContext().getSystemService("input_method");
            }
            return this.mInputManager;
        }
        return (InputMethodManager) invokeV.objValue;
    }

    public f<T> getPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mContext : (f) invokeV.objValue;
    }

    public void setInputMethodManager(InputMethodManager inputMethodManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, inputMethodManager) == null) {
            this.mInputManager = inputMethodManager;
        }
    }
}

package c.a.t0.s2.t;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import c.a.d.f.p.n;
import c.a.t0.s2.t.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlertDialog a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f23116b;

    /* renamed from: c  reason: collision with root package name */
    public Context f23117c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnKeyListener f23118d;

    /* renamed from: e  reason: collision with root package name */
    public DialogInterface.OnCancelListener f23119e;

    /* renamed from: f  reason: collision with root package name */
    public int f23120f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23121g;

    /* renamed from: h  reason: collision with root package name */
    public V f23122h;

    /* renamed from: c.a.t0.s2.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1375a implements ViewHelper.ViewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicBoolean a;

        public C1375a(a aVar, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atomicBoolean;
        }

        @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
        public boolean onViewFound(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (view instanceof EditText) {
                    this.a.set(true);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public a(TbPageContext tbPageContext, V v, D d2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, v, d2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23120f = -1;
        this.f23121g = false;
        this.f23116b = tbPageContext;
        this.f23117c = tbPageContext.getPageActivity();
        this.f23122h = v;
        d(d2);
    }

    public void d(D d2) {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, d2) == null) || (v = this.f23122h) == null) {
            return;
        }
        v.b(d2);
    }

    @Override // c.a.t0.s2.t.f
    public void dismiss() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (alertDialog = this.a) == null) {
            return;
        }
        c.a.d.f.m.g.a(alertDialog, this.f23116b.getPageActivity());
    }

    @Override // c.a.t0.s2.t.f
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AlertDialog alertDialog = this.a;
            if (alertDialog != null) {
                c.a.d.f.m.g.i(alertDialog, this.f23116b.getPageActivity());
                return;
            }
            if (this.f23121g) {
                this.a = new AlertDialog.Builder(this.f23117c, R.style.search_dialog).create();
            } else {
                this.a = new AlertDialog.Builder(this.f23117c).create();
            }
            this.a.setCanceledOnTouchOutside(c());
            this.a.setCancelable(b());
            this.a.setOnKeyListener(this.f23118d);
            DialogInterface.OnCancelListener onCancelListener = this.f23119e;
            if (onCancelListener != null) {
                this.a.setOnCancelListener(onCancelListener);
            }
            c.a.d.f.m.g.i(this.a, this.f23116b.getPageActivity());
            if (this.a.getWindow().getDecorView().getParent() == null) {
                return;
            }
            Window window = this.a.getWindow();
            if (this.f23120f == -1) {
                this.f23120f = 17;
            }
            window.setGravity(this.f23120f);
            window.setBackgroundDrawableResource(R.drawable.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics q = n.q(this.f23116b.getPageActivity());
            if (q != null) {
                int a = a();
                if (UtilHelper.getRealScreenOrientation(this.f23117c) == 2) {
                    attributes.width = q.heightPixels - (a * 2);
                } else {
                    attributes.width = q.widthPixels - (a * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.f23122h.getViewGroup());
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ViewHelper.processAllViewsIn(this.f23122h.getViewGroup(), false, new C1375a(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
    }
}

package b.a.r0.k2.t;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import b.a.e.e.p.l;
import b.a.r0.k2.t.g;
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
/* loaded from: classes5.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AlertDialog f18837a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f18838b;

    /* renamed from: c  reason: collision with root package name */
    public Context f18839c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnKeyListener f18840d;

    /* renamed from: e  reason: collision with root package name */
    public DialogInterface.OnCancelListener f18841e;

    /* renamed from: f  reason: collision with root package name */
    public int f18842f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18843g;

    /* renamed from: h  reason: collision with root package name */
    public V f18844h;

    /* renamed from: b.a.r0.k2.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0950a implements ViewHelper.ViewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f18845a;

        public C0950a(a aVar, AtomicBoolean atomicBoolean) {
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
            this.f18845a = atomicBoolean;
        }

        @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
        public boolean onViewFound(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (view instanceof EditText) {
                    this.f18845a.set(true);
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
        this.f18842f = -1;
        this.f18843g = false;
        this.f18838b = tbPageContext;
        this.f18839c = tbPageContext.getPageActivity();
        this.f18844h = v;
        d(d2);
    }

    public void d(D d2) {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, d2) == null) || (v = this.f18844h) == null) {
            return;
        }
        v.b(d2);
    }

    @Override // b.a.r0.k2.t.f
    public void dismiss() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (alertDialog = this.f18837a) == null) {
            return;
        }
        b.a.e.e.m.g.a(alertDialog, this.f18838b.getPageActivity());
    }

    @Override // b.a.r0.k2.t.f
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AlertDialog alertDialog = this.f18837a;
            if (alertDialog != null) {
                b.a.e.e.m.g.i(alertDialog, this.f18838b.getPageActivity());
                return;
            }
            if (this.f18843g) {
                this.f18837a = new AlertDialog.Builder(this.f18839c, R.style.search_dialog).create();
            } else {
                this.f18837a = new AlertDialog.Builder(this.f18839c).create();
            }
            this.f18837a.setCanceledOnTouchOutside(c());
            this.f18837a.setCancelable(b());
            this.f18837a.setOnKeyListener(this.f18840d);
            DialogInterface.OnCancelListener onCancelListener = this.f18841e;
            if (onCancelListener != null) {
                this.f18837a.setOnCancelListener(onCancelListener);
            }
            b.a.e.e.m.g.i(this.f18837a, this.f18838b.getPageActivity());
            if (this.f18837a.getWindow().getDecorView().getParent() == null) {
                return;
            }
            Window window = this.f18837a.getWindow();
            if (this.f18842f == -1) {
                this.f18842f = 17;
            }
            window.setGravity(this.f18842f);
            window.setBackgroundDrawableResource(R.drawable.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics q = l.q(this.f18838b.getPageActivity());
            if (q != null) {
                int a2 = a();
                if (UtilHelper.getRealScreenOrientation(this.f18839c) == 2) {
                    attributes.width = q.heightPixels - (a2 * 2);
                } else {
                    attributes.width = q.widthPixels - (a2 * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.f18844h.getViewGroup());
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ViewHelper.processAllViewsIn(this.f18844h.getViewGroup(), false, new C0950a(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
    }
}

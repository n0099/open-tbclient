package c.a.r0.j2.j;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import c.a.e.e.p.l;
import c.a.r0.j2.j.g;
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
/* loaded from: classes3.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AlertDialog f19712a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f19713b;

    /* renamed from: c  reason: collision with root package name */
    public Context f19714c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnKeyListener f19715d;

    /* renamed from: e  reason: collision with root package name */
    public DialogInterface.OnCancelListener f19716e;

    /* renamed from: f  reason: collision with root package name */
    public int f19717f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19718g;

    /* renamed from: h  reason: collision with root package name */
    public V f19719h;

    /* renamed from: c.a.r0.j2.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0944a implements ViewHelper.ViewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f19720a;

        public C0944a(a aVar, AtomicBoolean atomicBoolean) {
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
            this.f19720a = atomicBoolean;
        }

        @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
        public boolean onViewFound(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (view instanceof EditText) {
                    this.f19720a.set(true);
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
        this.f19717f = -1;
        this.f19718g = false;
        this.f19713b = tbPageContext;
        this.f19714c = tbPageContext.getPageActivity();
        this.f19719h = v;
        d(d2);
    }

    public void d(D d2) {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, d2) == null) || (v = this.f19719h) == null) {
            return;
        }
        v.b(d2);
    }

    @Override // c.a.r0.j2.j.f
    public void dismiss() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (alertDialog = this.f19712a) == null) {
            return;
        }
        c.a.e.e.m.g.a(alertDialog, this.f19713b.getPageActivity());
    }

    @Override // c.a.r0.j2.j.f
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AlertDialog alertDialog = this.f19712a;
            if (alertDialog != null) {
                c.a.e.e.m.g.i(alertDialog, this.f19713b.getPageActivity());
                return;
            }
            if (this.f19718g) {
                this.f19712a = new AlertDialog.Builder(this.f19714c, R.style.search_dialog).create();
            } else {
                this.f19712a = new AlertDialog.Builder(this.f19714c).create();
            }
            this.f19712a.setCanceledOnTouchOutside(c());
            this.f19712a.setCancelable(b());
            this.f19712a.setOnKeyListener(this.f19715d);
            DialogInterface.OnCancelListener onCancelListener = this.f19716e;
            if (onCancelListener != null) {
                this.f19712a.setOnCancelListener(onCancelListener);
            }
            c.a.e.e.m.g.i(this.f19712a, this.f19713b.getPageActivity());
            if (this.f19712a.getWindow().getDecorView().getParent() == null) {
                return;
            }
            Window window = this.f19712a.getWindow();
            if (this.f19717f == -1) {
                this.f19717f = 17;
            }
            window.setGravity(this.f19717f);
            window.setBackgroundDrawableResource(R.drawable.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics q = l.q(this.f19713b.getPageActivity());
            if (q != null) {
                int a2 = a();
                if (UtilHelper.getRealScreenOrientation(this.f19714c) == 2) {
                    attributes.width = q.heightPixels - (a2 * 2);
                } else {
                    attributes.width = q.widthPixels - (a2 * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.f19719h.getViewGroup());
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ViewHelper.processAllViewsIn(this.f19719h.getViewGroup(), false, new C0944a(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
    }
}

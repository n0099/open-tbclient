package c.a.p0.w2.k;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import c.a.d.f.p.n;
import c.a.p0.w2.k.g;
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
/* loaded from: classes2.dex */
public abstract class a<V extends g, D extends IBaseDialogData> implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlertDialog a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f19882b;

    /* renamed from: c  reason: collision with root package name */
    public Context f19883c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnKeyListener f19884d;

    /* renamed from: e  reason: collision with root package name */
    public DialogInterface.OnCancelListener f19885e;

    /* renamed from: f  reason: collision with root package name */
    public int f19886f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19887g;

    /* renamed from: h  reason: collision with root package name */
    public V f19888h;

    /* renamed from: c.a.p0.w2.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1496a implements ViewHelper.ViewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicBoolean a;

        public C1496a(a aVar, AtomicBoolean atomicBoolean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, atomicBoolean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19886f = -1;
        this.f19887g = false;
        this.f19882b = tbPageContext;
        this.f19883c = tbPageContext.getPageActivity();
        this.f19888h = v;
        d(d2);
    }

    public void d(D d2) {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, d2) == null) || (v = this.f19888h) == null) {
            return;
        }
        v.b(d2);
    }

    @Override // c.a.p0.w2.k.f
    public void dismiss() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (alertDialog = this.a) == null) {
            return;
        }
        c.a.d.f.m.g.a(alertDialog, this.f19882b.getPageActivity());
    }

    @Override // c.a.p0.w2.k.f
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AlertDialog alertDialog = this.a;
            if (alertDialog != null) {
                c.a.d.f.m.g.i(alertDialog, this.f19882b.getPageActivity());
                return;
            }
            if (this.f19887g) {
                this.a = new AlertDialog.Builder(this.f19883c, R.style.obfuscated_res_0x7f1003e5).create();
            } else {
                this.a = new AlertDialog.Builder(this.f19883c).create();
            }
            this.a.setCanceledOnTouchOutside(c());
            this.a.setCancelable(b());
            this.a.setOnKeyListener(this.f19884d);
            DialogInterface.OnCancelListener onCancelListener = this.f19885e;
            if (onCancelListener != null) {
                this.a.setOnCancelListener(onCancelListener);
            }
            c.a.d.f.m.g.i(this.a, this.f19882b.getPageActivity());
            if (this.a.getWindow().getDecorView().getParent() == null) {
                return;
            }
            Window window = this.a.getWindow();
            if (this.f19886f == -1) {
                this.f19886f = 17;
            }
            window.setGravity(this.f19886f);
            window.setBackgroundDrawableResource(R.drawable.obfuscated_res_0x7f081200);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics q = n.q(this.f19882b.getPageActivity());
            if (q != null) {
                int a = a();
                if (UtilHelper.getRealScreenOrientation(this.f19883c) == 2) {
                    attributes.width = q.heightPixels - (a * 2);
                } else {
                    attributes.width = q.widthPixels - (a * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.f19888h.getViewGroup());
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ViewHelper.processAllViewsIn(this.f19888h.getViewGroup(), false, new C1496a(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
    }
}

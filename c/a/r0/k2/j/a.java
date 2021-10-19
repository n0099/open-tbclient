package c.a.r0.k2.j;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import c.a.e.e.p.l;
import c.a.r0.k2.j.g;
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
    public AlertDialog f19889a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f19890b;

    /* renamed from: c  reason: collision with root package name */
    public Context f19891c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnKeyListener f19892d;

    /* renamed from: e  reason: collision with root package name */
    public DialogInterface.OnCancelListener f19893e;

    /* renamed from: f  reason: collision with root package name */
    public int f19894f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19895g;

    /* renamed from: h  reason: collision with root package name */
    public V f19896h;

    /* renamed from: c.a.r0.k2.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0953a implements ViewHelper.ViewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f19897a;

        public C0953a(a aVar, AtomicBoolean atomicBoolean) {
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
            this.f19897a = atomicBoolean;
        }

        @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
        public boolean onViewFound(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (view instanceof EditText) {
                    this.f19897a.set(true);
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
        this.f19894f = -1;
        this.f19895g = false;
        this.f19890b = tbPageContext;
        this.f19891c = tbPageContext.getPageActivity();
        this.f19896h = v;
        d(d2);
    }

    public void d(D d2) {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, d2) == null) || (v = this.f19896h) == null) {
            return;
        }
        v.b(d2);
    }

    @Override // c.a.r0.k2.j.f
    public void dismiss() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (alertDialog = this.f19889a) == null) {
            return;
        }
        c.a.e.e.m.g.a(alertDialog, this.f19890b.getPageActivity());
    }

    @Override // c.a.r0.k2.j.f
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AlertDialog alertDialog = this.f19889a;
            if (alertDialog != null) {
                c.a.e.e.m.g.i(alertDialog, this.f19890b.getPageActivity());
                return;
            }
            if (this.f19895g) {
                this.f19889a = new AlertDialog.Builder(this.f19891c, R.style.search_dialog).create();
            } else {
                this.f19889a = new AlertDialog.Builder(this.f19891c).create();
            }
            this.f19889a.setCanceledOnTouchOutside(c());
            this.f19889a.setCancelable(b());
            this.f19889a.setOnKeyListener(this.f19892d);
            DialogInterface.OnCancelListener onCancelListener = this.f19893e;
            if (onCancelListener != null) {
                this.f19889a.setOnCancelListener(onCancelListener);
            }
            c.a.e.e.m.g.i(this.f19889a, this.f19890b.getPageActivity());
            if (this.f19889a.getWindow().getDecorView().getParent() == null) {
                return;
            }
            Window window = this.f19889a.getWindow();
            if (this.f19894f == -1) {
                this.f19894f = 17;
            }
            window.setGravity(this.f19894f);
            window.setBackgroundDrawableResource(R.drawable.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics q = l.q(this.f19890b.getPageActivity());
            if (q != null) {
                int a2 = a();
                if (UtilHelper.getRealScreenOrientation(this.f19891c) == 2) {
                    attributes.width = q.heightPixels - (a2 * 2);
                } else {
                    attributes.width = q.widthPixels - (a2 * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.f19896h.getViewGroup());
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ViewHelper.processAllViewsIn(this.f19896h.getViewGroup(), false, new C0953a(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
    }
}

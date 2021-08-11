package c.a.p0.i2.j;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import c.a.e.e.p.l;
import c.a.p0.i2.j.g;
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
    public AlertDialog f18815a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f18816b;

    /* renamed from: c  reason: collision with root package name */
    public Context f18817c;

    /* renamed from: d  reason: collision with root package name */
    public DialogInterface.OnKeyListener f18818d;

    /* renamed from: e  reason: collision with root package name */
    public DialogInterface.OnCancelListener f18819e;

    /* renamed from: f  reason: collision with root package name */
    public int f18820f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18821g;

    /* renamed from: h  reason: collision with root package name */
    public V f18822h;

    /* renamed from: c.a.p0.i2.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0903a implements ViewHelper.ViewCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f18823a;

        public C0903a(a aVar, AtomicBoolean atomicBoolean) {
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
            this.f18823a = atomicBoolean;
        }

        @Override // com.baidu.tbadk.core.util.ViewHelper.ViewCallback
        public boolean onViewFound(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (view instanceof EditText) {
                    this.f18823a.set(true);
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
        this.f18820f = -1;
        this.f18821g = false;
        this.f18816b = tbPageContext;
        this.f18817c = tbPageContext.getPageActivity();
        this.f18822h = v;
        d(d2);
    }

    public void d(D d2) {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, d2) == null) || (v = this.f18822h) == null) {
            return;
        }
        v.b(d2);
    }

    @Override // c.a.p0.i2.j.f
    public void dismiss() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (alertDialog = this.f18815a) == null) {
            return;
        }
        c.a.e.e.m.g.a(alertDialog, this.f18816b.getPageActivity());
    }

    @Override // c.a.p0.i2.j.f
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AlertDialog alertDialog = this.f18815a;
            if (alertDialog != null) {
                c.a.e.e.m.g.i(alertDialog, this.f18816b.getPageActivity());
                return;
            }
            if (this.f18821g) {
                this.f18815a = new AlertDialog.Builder(this.f18817c, R.style.search_dialog).create();
            } else {
                this.f18815a = new AlertDialog.Builder(this.f18817c).create();
            }
            this.f18815a.setCanceledOnTouchOutside(c());
            this.f18815a.setCancelable(b());
            this.f18815a.setOnKeyListener(this.f18818d);
            DialogInterface.OnCancelListener onCancelListener = this.f18819e;
            if (onCancelListener != null) {
                this.f18815a.setOnCancelListener(onCancelListener);
            }
            c.a.e.e.m.g.i(this.f18815a, this.f18816b.getPageActivity());
            if (this.f18815a.getWindow().getDecorView().getParent() == null) {
                return;
            }
            Window window = this.f18815a.getWindow();
            if (this.f18820f == -1) {
                this.f18820f = 17;
            }
            window.setGravity(this.f18820f);
            window.setBackgroundDrawableResource(R.drawable.transparent_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.7f;
            attributes.width = -1;
            DisplayMetrics q = l.q(this.f18816b.getPageActivity());
            if (q != null) {
                int a2 = a();
                if (UtilHelper.getRealScreenOrientation(this.f18817c) == 2) {
                    attributes.width = q.heightPixels - (a2 * 2);
                } else {
                    attributes.width = q.widthPixels - (a2 * 2);
                }
            }
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setContentView(this.f18822h.getViewGroup());
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ViewHelper.processAllViewsIn(this.f18822h.getViewGroup(), false, new C0903a(this, atomicBoolean));
            if (atomicBoolean.get()) {
                window.clearFlags(131080);
            }
        }
    }
}

package com.baidu.swan.apps.res.widget.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.g;
import d.a.n0.a.k;
import d.a.n0.a.v2.f;
import d.a.n0.a.v2.q0;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class BaseActivityDialog extends Activity implements DialogInterface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String KEY_FOR_BUILDER = "BOX_ACTIVITY_DIALOG_FOR_BUILDER";
    public static final String KEY_FROM = "BOX_ACTIVITY_DIALOG_FROM";
    public static final String KEY_NIGHT_MODE = "BOX_ACTIVITY_DIALOG_NIGHT_MODE";
    public static final String TAG = "BaseActivityDialog";
    public transient /* synthetic */ FieldHolder $fh;
    public int mBtnHeight;
    public LinearLayout mBtnPanelLayout;
    public e mBuilder;
    public FrameLayout mDialogContent;
    public RelativeLayout mDialogLayout;
    public View mDivider2;
    public View mDivider3;
    public View mDivider4;
    public ImageView mIcon;
    public TextView mMessage;
    public LinearLayout mMessageContent;
    public TextView mNegativeButton;
    public TextView mNeutralButton;
    public TextView mPositiveButton;
    public SwanAppScrollView mScrollView;
    public TextView mTitle;

    /* loaded from: classes3.dex */
    public class a implements Action<e.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaseActivityDialog f11451a;

        public a(BaseActivityDialog baseActivityDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivityDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11451a = baseActivityDialog;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        /* renamed from: a */
        public void call(e.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f11451a.mBuilder.onEvent(cVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Action<e.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaseActivityDialog f11452a;

        public b(BaseActivityDialog baseActivityDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivityDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11452a = baseActivityDialog;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        /* renamed from: a */
        public void call(e.b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) && bVar.f11466a == this.f11452a.mBuilder.r) {
                this.f11452a.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseActivityDialog f11453e;

        public c(BaseActivityDialog baseActivityDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivityDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11453e = baseActivityDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f11453e.onButtonClick(-1);
                BdEventBus.Companion.getDefault().post(new e.c(this.f11453e, -1));
                this.f11453e.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseActivityDialog f11454e;

        public d(BaseActivityDialog baseActivityDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivityDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11454e = baseActivityDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f11454e.onButtonClick(-2);
                this.f11454e.dismiss();
                BdEventBus.Companion.getDefault().post(new e.c(this.f11454e, -2));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public static volatile HashMap<String, e> t;
        public static ArrayList u;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f11455a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f11456b;

        /* renamed from: c  reason: collision with root package name */
        public String f11457c;

        /* renamed from: d  reason: collision with root package name */
        public String f11458d;

        /* renamed from: e  reason: collision with root package name */
        public View f11459e;

        /* renamed from: f  reason: collision with root package name */
        public Drawable f11460f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f11461g;

        /* renamed from: h  reason: collision with root package name */
        public int f11462h;

        /* renamed from: i  reason: collision with root package name */
        public Bundle f11463i;
        public DialogInterface.OnClickListener j;
        public DialogInterface.OnClickListener k;
        public DialogInterface.OnCancelListener l;
        public DialogInterface.OnDismissListener m;
        public Context n;
        public Class<? extends Activity> o;
        public int p;
        public String q;
        public Object r;
        public boolean s;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ boolean f11464e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f11465f;

            public a(e eVar, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11465f = eVar;
                this.f11464e = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Context appContext = AppRuntime.getAppContext();
                    if (this.f11465f.o == null) {
                        this.f11465f.o = BaseActivityDialog.class;
                    }
                    Intent intent = new Intent(appContext, this.f11465f.o);
                    intent.putExtra(BaseActivityDialog.KEY_NIGHT_MODE, this.f11464e);
                    String valueOf = String.valueOf(intent.hashCode());
                    intent.putExtra(BaseActivityDialog.KEY_FOR_BUILDER, valueOf);
                    if (!TextUtils.isEmpty(this.f11465f.q)) {
                        intent.putExtra(BaseActivityDialog.KEY_FROM, this.f11465f.q);
                    }
                    if (this.f11465f.f11463i != null) {
                        intent.putExtras(this.f11465f.f11463i);
                    }
                    e.t(valueOf, this.f11465f);
                    intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    f.g(appContext, intent);
                }
            }
        }

        /* loaded from: classes3.dex */
        public static class b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public Object f11466a;
        }

        /* loaded from: classes3.dex */
        public static class c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public DialogInterface f11467a;

            /* renamed from: b  reason: collision with root package name */
            public int f11468b;

            public c(DialogInterface dialogInterface, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dialogInterface, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11467a = dialogInterface;
                this.f11468b = i2;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-381900710, "Lcom/baidu/swan/apps/res/widget/dialog/BaseActivityDialog$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-381900710, "Lcom/baidu/swan/apps/res/widget/dialog/BaseActivityDialog$e;");
                    return;
                }
            }
            t = new HashMap<>();
            u = new ArrayList();
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public e() {
            this(BaseActivityDialog.class);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    this((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public static e r(String str) {
            InterceptResult invokeL;
            e remove;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                synchronized (t) {
                    remove = t.remove(str);
                }
                return remove;
            }
            return (e) invokeL.objValue;
        }

        public static void t(String str, e eVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65557, null, str, eVar) == null) || TextUtils.isEmpty(str) || eVar == null) {
                return;
            }
            synchronized (t) {
                t.put(str, eVar);
            }
        }

        public e A(String str, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, onClickListener)) == null) {
                this.f11457c = str;
                this.j = onClickListener;
                return this;
            }
            return (e) invokeLL.objValue;
        }

        public e B(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                C(this.n.getString(i2));
                return this;
            }
            return (e) invokeI.objValue;
        }

        public e C(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f11455a = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        public void D() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                E(false);
            }
        }

        public void E(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
                q0.X(new a(this, z));
            }
        }

        public void onEvent(c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || cVar == null) {
                return;
            }
            DialogInterface.OnClickListener onClickListener = null;
            int i2 = cVar.f11468b;
            if (i2 == -2) {
                onClickListener = this.k;
            } else if (i2 == -1) {
                onClickListener = this.j;
            }
            if (onClickListener != null) {
                onClickListener.onClick(cVar.f11467a, cVar.f11468b);
            }
        }

        public void s() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                u.remove(this.r);
                this.j = null;
                this.k = null;
                this.l = null;
                this.m = null;
                this.f11459e = null;
                this.f11460f = null;
            }
        }

        public e u(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                v(this.n.getString(i2));
                return this;
            }
            return (e) invokeI.objValue;
        }

        public e v(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.f11456b = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        public e w(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, onClickListener)) == null) {
                x(this.n.getString(i2), onClickListener);
                return this;
            }
            return (e) invokeIL.objValue;
        }

        public e x(String str, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, onClickListener)) == null) {
                this.f11458d = str;
                this.k = onClickListener;
                return this;
            }
            return (e) invokeLL.objValue;
        }

        public e y(DialogInterface.OnDismissListener onDismissListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, onDismissListener)) == null) {
                this.m = onDismissListener;
                return this;
            }
            return (e) invokeL.objValue;
        }

        public e z(int i2, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i2, onClickListener)) == null) {
                A(this.n.getString(i2), onClickListener);
                return this;
            }
            return (e) invokeIL.objValue;
        }

        public e(Class<? extends Activity> cls) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f11461g = true;
            this.p = -1;
            this.n = AppRuntime.getAppContext();
            this.o = cls;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1363524357, "Lcom/baidu/swan/apps/res/widget/dialog/BaseActivityDialog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1363524357, "Lcom/baidu/swan/apps/res/widget/dialog/BaseActivityDialog;");
                return;
            }
        }
        DEBUG = k.f45831a;
    }

    public BaseActivityDialog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (this.mBuilder != null) {
                BdEventBus.Companion.getDefault().unregister(this.mBuilder);
                this.mBuilder.s();
                this.mBuilder = null;
            }
            setView(null);
        }
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        DialogInterface.OnCancelListener onCancelListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e eVar = this.mBuilder;
            if (eVar != null && (onCancelListener = eVar.l) != null) {
                onCancelListener.onCancel(this);
            }
            finish();
        }
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            onDismiss();
            finish();
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Resources b2 = d.a.n0.a.c1.a.H().b();
            return b2 != null ? b2 : super.getResources();
        }
        return (Resources) invokeV.objValue;
    }

    public TextView ifOnlyOneBtnGetIt() {
        InterceptResult invokeV;
        int i2;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TextView textView2 = this.mPositiveButton;
            if (textView2 == null || textView2.getVisibility() != 0) {
                i2 = 0;
                textView = null;
            } else {
                textView = this.mPositiveButton;
                i2 = 1;
            }
            TextView textView3 = this.mNegativeButton;
            if (textView3 != null && textView3.getVisibility() == 0) {
                i2++;
                textView = this.mNegativeButton;
            }
            TextView textView4 = this.mNeutralButton;
            if (textView4 != null && textView4.getVisibility() == 0) {
                i2++;
                textView = this.mNeutralButton;
            }
            if (i2 != 1) {
                return null;
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public void initViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mTitle = (TextView) findViewById(d.a.n0.a.f.dialog_title);
            this.mMessage = (TextView) findViewById(d.a.n0.a.f.dialog_message);
            this.mMessageContent = (LinearLayout) findViewById(d.a.n0.a.f.dialog_message_content);
            this.mPositiveButton = (TextView) findViewById(d.a.n0.a.f.positive_button);
            this.mNegativeButton = (TextView) findViewById(d.a.n0.a.f.negative_button);
            this.mNeutralButton = (TextView) findViewById(d.a.n0.a.f.neutral_button);
            this.mDivider3 = findViewById(d.a.n0.a.f.divider3);
            this.mDivider4 = findViewById(d.a.n0.a.f.divider4);
            this.mDialogContent = (FrameLayout) findViewById(d.a.n0.a.f.dialog_custom_content);
            this.mIcon = (ImageView) findViewById(d.a.n0.a.f.dialog_icon);
            this.mDialogLayout = (RelativeLayout) findViewById(d.a.n0.a.f.searchbox_alert_dialog);
            this.mDivider2 = findViewById(d.a.n0.a.f.divider2);
            this.mScrollView = (SwanAppScrollView) findViewById(d.a.n0.a.f.message_scrollview);
            this.mBtnPanelLayout = (LinearLayout) findViewById(d.a.n0.a.f.btn_panel);
            this.mBtnHeight = getResources().getDimensionPixelSize(d.a.n0.a.d.aiapps_dialog_btns_height);
            if (this.mBuilder.p > 0) {
                this.mScrollView.getLayoutParams().height = this.mBuilder.p;
            }
            if (d.a.n0.a.v2.d.k() || d.a.n0.a.v2.d.l()) {
                int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(d.a.n0.a.d.aiapps_dialog_text_padding);
                this.mMessage.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            onDismiss();
            super.onBackPressed();
        }
    }

    public void onButtonClick(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(g.aiapps_alert_dialog);
            getWindow().setLayout(-1, -1);
            e r = e.r(getIntent().getStringExtra(KEY_FOR_BUILDER));
            this.mBuilder = r;
            if (r == null) {
                if (DEBUG) {
                    Log.e(TAG, "The builder for dialog activity can NOT be null.");
                }
                finish();
                return;
            }
            BdEventBus.Companion.getDefault().register(this.mBuilder, e.c.class, new a(this));
            BdEventBus.Companion.getDefault().register(this.mBuilder, e.b.class, new b(this));
            initViews();
            setupViews();
            show();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            release();
            super.onDestroy();
        }
    }

    public void onDismiss() {
        e eVar;
        DialogInterface.OnDismissListener onDismissListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (eVar = this.mBuilder) == null || (onDismissListener = eVar.m) == null) {
            return;
        }
        onDismissListener.onDismiss(this);
    }

    public void post(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, runnable) == null) || runnable == null) {
            return;
        }
        q0.X(runnable);
    }

    public void setBtnsPanlVisible(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && z) {
            this.mBtnPanelLayout.setVisibility(8);
            this.mDivider2.setVisibility(8);
        }
    }

    public void setIcon(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, drawable) == null) {
            this.mIcon.setImageDrawable(drawable);
            this.mIcon.setVisibility(drawable != null ? 0 : 8);
        }
    }

    public void setMessage(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, charSequence) == null) {
            this.mMessage.setText(charSequence);
            this.mMessageContent.setVisibility(!TextUtils.isEmpty(charSequence) ? 0 : 8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, d.a.n0.a.f.dialog_message_content);
            this.mBtnPanelLayout.setLayoutParams(layoutParams);
        }
    }

    public void setNegativeButton(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mNegativeButton.setText(str);
            this.mNegativeButton.setOnClickListener(new d(this));
            if (TextUtils.isEmpty(str)) {
                this.mNegativeButton.setVisibility(8);
                if (this.mPositiveButton.getVisibility() == 0) {
                    this.mDivider3.setVisibility(8);
                    return;
                }
                return;
            }
            this.mNegativeButton.setVisibility(0);
            if (this.mPositiveButton.getVisibility() == 0) {
                this.mDivider3.setVisibility(0);
            }
        }
    }

    public void setPositiveButton(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.mPositiveButton.setText(str);
            this.mPositiveButton.setOnClickListener(new c(this));
            if (TextUtils.isEmpty(str)) {
                this.mPositiveButton.setVisibility(8);
                if (this.mNegativeButton.getVisibility() == 0) {
                    this.mDivider3.setVisibility(8);
                    return;
                }
                return;
            }
            this.mPositiveButton.setVisibility(0);
            if (this.mNegativeButton.getVisibility() == 0) {
                this.mDivider3.setVisibility(0);
            }
        }
    }

    public void setPositiveEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.mPositiveButton.setEnabled(z);
        }
    }

    public void setPositiveTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.mPositiveButton.setTextColor(i2);
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.mTitle.setText(str);
        }
    }

    public void setView(View view) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, view) == null) || (frameLayout = this.mDialogContent) == null) {
            return;
        }
        frameLayout.removeAllViews();
        if (view != null) {
            this.mDialogContent.addView(view);
            this.mMessageContent.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, d.a.n0.a.f.dialog_customPanel);
            this.mBtnPanelLayout.setLayoutParams(layoutParams);
        }
    }

    public void setupViews() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (eVar = this.mBuilder) == null) {
            return;
        }
        setTitle(eVar.f11455a);
        setIcon(eVar.f11460f);
        setMessage(eVar.f11456b);
        setView(eVar.f11459e);
        setPositiveEnable(eVar.f11461g);
        setPositiveTextColor(eVar.f11462h);
        setPositiveButton(eVar.f11457c);
        setNegativeButton(eVar.f11458d);
        setBtnsPanlVisible(eVar.s);
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            Resources resources = getResources();
            int color = resources.getColor(d.a.n0.a.c.aiapps_dialog_title_text_color);
            int color2 = resources.getColor(d.a.n0.a.c.aiapps_box_dialog_message_text_color);
            int color3 = resources.getColor(d.a.n0.a.c.aiapps_dialog_gray);
            this.mDialogLayout.setBackground(resources.getDrawable(d.a.n0.a.e.aiapps_dialog_bg_white));
            this.mTitle.setTextColor(color);
            this.mMessage.setTextColor(color2);
            this.mPositiveButton.setTextColor(color);
            this.mNegativeButton.setTextColor(color);
            this.mNeutralButton.setTextColor(color);
            this.mDivider2.setBackgroundColor(color3);
            this.mDivider3.setBackgroundColor(color3);
            this.mDivider4.setBackgroundColor(color3);
            this.mPositiveButton.setBackground(resources.getDrawable(d.a.n0.a.e.aiapp_alertdialog_button_day_bg_right_selector));
            this.mNegativeButton.setBackground(resources.getDrawable(d.a.n0.a.e.aiapp_alertdialog_button_day_bg_left_selector));
            this.mNeutralButton.setBackground(resources.getDrawable(d.a.n0.a.e.aiapp_alertdialog_button_day_bg_selector));
            TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
            if (ifOnlyOneBtnGetIt != null) {
                ifOnlyOneBtnGetIt.setBackground(resources.getDrawable(d.a.n0.a.e.aiapp_alertdialog_button_day_bg_all_selector));
            }
        }
    }
}

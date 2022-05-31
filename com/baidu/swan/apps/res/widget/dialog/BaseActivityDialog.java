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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bd3;
import com.repackage.ob3;
import com.repackage.oi2;
import com.repackage.qb3;
import com.repackage.rf1;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public class a implements Action<e.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseActivityDialog a;

        public a(BaseActivityDialog baseActivityDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivityDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseActivityDialog;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        public void call(e.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.a.mBuilder.onEvent(cVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Action<e.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseActivityDialog a;

        public b(BaseActivityDialog baseActivityDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivityDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseActivityDialog;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        public void call(e.b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) && bVar.a == this.a.mBuilder.r) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseActivityDialog a;

        public c(BaseActivityDialog baseActivityDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivityDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseActivityDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.onButtonClick(-1);
                BdEventBus.Companion.getDefault().post(new e.c(this.a, -1));
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseActivityDialog a;

        public d(BaseActivityDialog baseActivityDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActivityDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseActivityDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.onButtonClick(-2);
                this.a.dismiss();
                BdEventBus.Companion.getDefault().post(new e.c(this.a, -2));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public static volatile HashMap<String, e> t;
        public static ArrayList u;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public CharSequence b;
        public String c;
        public String d;
        public View e;
        public Drawable f;
        public boolean g;
        public int h;
        public Bundle i;
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

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean a;
            public final /* synthetic */ e b;

            public a(e eVar, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Context appContext = AppRuntime.getAppContext();
                    if (this.b.o == null) {
                        this.b.o = BaseActivityDialog.class;
                    }
                    Intent intent = new Intent(appContext, this.b.o);
                    intent.putExtra(BaseActivityDialog.KEY_NIGHT_MODE, this.a);
                    String valueOf = String.valueOf(intent.hashCode());
                    intent.putExtra(BaseActivityDialog.KEY_FOR_BUILDER, valueOf);
                    if (!TextUtils.isEmpty(this.b.q)) {
                        intent.putExtra(BaseActivityDialog.KEY_FROM, this.b.q);
                    }
                    if (this.b.i != null) {
                        intent.putExtras(this.b.i);
                    }
                    e.t(valueOf, this.b);
                    intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                    qb3.g(appContext, intent);
                }
            }
        }

        /* loaded from: classes2.dex */
        public static class b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public Object a;
        }

        /* loaded from: classes2.dex */
        public static class c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public DialogInterface a;
            public int b;

            public c(DialogInterface dialogInterface, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dialogInterface, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dialogInterface;
                this.b = i;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.c = str;
                this.j = onClickListener;
                return this;
            }
            return (e) invokeLL.objValue;
        }

        public e B(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                C(this.n.getString(i));
                return this;
            }
            return (e) invokeI.objValue;
        }

        public e C(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.a = str;
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
                bd3.a0(new a(this, z));
            }
        }

        public void onEvent(c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || cVar == null) {
                return;
            }
            DialogInterface.OnClickListener onClickListener = null;
            int i = cVar.b;
            if (i == -2) {
                onClickListener = this.k;
            } else if (i == -1) {
                onClickListener = this.j;
            }
            if (onClickListener != null) {
                onClickListener.onClick(cVar.a, cVar.b);
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
                this.e = null;
                this.f = null;
            }
        }

        public e u(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                v(this.n.getString(i));
                return this;
            }
            return (e) invokeI.objValue;
        }

        public e v(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                this.b = str;
                return this;
            }
            return (e) invokeL.objValue;
        }

        public e w(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, onClickListener)) == null) {
                x(this.n.getString(i), onClickListener);
                return this;
            }
            return (e) invokeIL.objValue;
        }

        public e x(String str, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, onClickListener)) == null) {
                this.d = str;
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

        public e z(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, onClickListener)) == null) {
                A(this.n.getString(i), onClickListener);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.g = true;
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
        DEBUG = rf1.a;
    }

    public BaseActivityDialog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            Resources b2 = oi2.M().b();
            return b2 != null ? b2 : super.getResources();
        }
        return (Resources) invokeV.objValue;
    }

    public TextView ifOnlyOneBtnGetIt() {
        InterceptResult invokeV;
        int i;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TextView textView2 = this.mPositiveButton;
            if (textView2 == null || textView2.getVisibility() != 0) {
                i = 0;
                textView = null;
            } else {
                textView = this.mPositiveButton;
                i = 1;
            }
            TextView textView3 = this.mNegativeButton;
            if (textView3 != null && textView3.getVisibility() == 0) {
                i++;
                textView = this.mNegativeButton;
            }
            TextView textView4 = this.mNeutralButton;
            if (textView4 != null && textView4.getVisibility() == 0) {
                i++;
                textView = this.mNeutralButton;
            }
            if (i != 1) {
                return null;
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public void initViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f0907a0);
            this.mMessage = (TextView) findViewById(R.id.obfuscated_res_0x7f090796);
            this.mMessageContent = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090797);
            this.mPositiveButton = (TextView) findViewById(R.id.obfuscated_res_0x7f0918aa);
            this.mNegativeButton = (TextView) findViewById(R.id.obfuscated_res_0x7f09150d);
            this.mNeutralButton = (TextView) findViewById(R.id.obfuscated_res_0x7f091519);
            this.mDivider3 = findViewById(R.id.obfuscated_res_0x7f0907c8);
            this.mDivider4 = findViewById(R.id.obfuscated_res_0x7f0907c9);
            this.mDialogContent = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09078d);
            this.mIcon = (ImageView) findViewById(R.id.obfuscated_res_0x7f090790);
            this.mDialogLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091c3d);
            this.mDivider2 = findViewById(R.id.obfuscated_res_0x7f0907c7);
            this.mScrollView = (SwanAppScrollView) findViewById(R.id.obfuscated_res_0x7f0913da);
            this.mBtnPanelLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090427);
            this.mBtnHeight = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070125);
            if (this.mBuilder.p > 0) {
                this.mScrollView.getLayoutParams().height = this.mBuilder.p;
            }
            if (ob3.k() || ob3.l()) {
                int dimensionPixelSize = this.mMessage.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07012c);
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

    public void onButtonClick(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0094);
            getWindow().setLayout(-1, -1);
            e r = e.r(getIntent().getStringExtra(KEY_FOR_BUILDER));
            this.mBuilder = r;
            if (r == null) {
                if (DEBUG) {
                    Log.e(TAG, "The builder for dialog activity can NOT be null.");
                }
                finish();
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            BdEventBus.Companion.getDefault().register(this.mBuilder, e.c.class, new a(this));
            BdEventBus.Companion.getDefault().register(this.mBuilder, e.b.class, new b(this));
            initViews();
            setupViews();
            show();
            LogUtil.logActivity(this, "onCreate");
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
        bd3.a0(runnable);
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
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f090797);
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

    public void setPositiveTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.mPositiveButton.setTextColor(i);
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.mTitle.setText(str);
        }
    }

    public void setView(View view2) {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, view2) == null) || (frameLayout = this.mDialogContent) == null) {
            return;
        }
        frameLayout.removeAllViews();
        if (view2 != null) {
            this.mDialogContent.addView(view2);
            this.mMessageContent.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f09078c);
            this.mBtnPanelLayout.setLayoutParams(layoutParams);
        }
    }

    public void setupViews() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (eVar = this.mBuilder) == null) {
            return;
        }
        setTitle(eVar.a);
        setIcon(eVar.f);
        setMessage(eVar.b);
        setView(eVar.e);
        setPositiveEnable(eVar.g);
        setPositiveTextColor(eVar.h);
        setPositiveButton(eVar.c);
        setNegativeButton(eVar.d);
        setBtnsPanlVisible(eVar.s);
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            Resources resources = getResources();
            int color = resources.getColor(R.color.obfuscated_res_0x7f060392);
            int color2 = resources.getColor(R.color.obfuscated_res_0x7f060385);
            int color3 = resources.getColor(R.color.obfuscated_res_0x7f06038f);
            this.mDialogLayout.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f080143));
            this.mTitle.setTextColor(color);
            this.mMessage.setTextColor(color2);
            this.mPositiveButton.setTextColor(color);
            this.mNegativeButton.setTextColor(color);
            this.mNeutralButton.setTextColor(color);
            this.mDivider2.setBackgroundColor(color3);
            this.mDivider3.setBackgroundColor(color3);
            this.mDivider4.setBackgroundColor(color3);
            this.mPositiveButton.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0800cc));
            this.mNegativeButton.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0800cb));
            this.mNeutralButton.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0800cd));
            TextView ifOnlyOneBtnGetIt = ifOnlyOneBtnGetIt();
            if (ifOnlyOneBtnGetIt != null) {
                ifOnlyOneBtnGetIt.setBackground(resources.getDrawable(R.drawable.obfuscated_res_0x7f0800ca));
            }
        }
    }
}

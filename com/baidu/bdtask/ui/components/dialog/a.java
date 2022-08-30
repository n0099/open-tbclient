package com.baidu.bdtask.ui.components.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.bdtask.component.dialog.TaskDialogViewData;
import com.baidu.bdtask.ui.utils.d;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.as;
import com.baidu.tieba.au;
import com.baidu.tieba.bu;
import com.baidu.tieba.gv;
import com.baidu.tieba.ju;
import com.baidu.tieba.ku;
import com.baidu.tieba.xq;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\b&\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b6\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\r\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J#\u0010\u0015\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u0019\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001c\u0010\u0004JI\u0010&\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u00112\b\u0010\"\u001a\u0004\u0018\u00010\u00112\b\u0010#\u001a\u0004\u0018\u00010\u00112\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020$¢\u0006\u0004\b&\u0010'R\"\u0010(\u001a\u00020\u001f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020\u00138\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105¨\u00068"}, d2 = {"Lcom/baidu/bdtask/ui/components/dialog/BaseActivityDialog;", "Landroid/app/Activity;", "", "dialogCancelUbc", "()V", "dialogClickUbc", "dialogCloseUbc", "dialogShowUbc", "disMiss", "", "getBtnLayout", "()I", "Lcom/baidu/bdtask/component/dialog/TaskDialogViewData;", "getData", "()Lcom/baidu/bdtask/component/dialog/TaskDialogViewData;", "initExtraView", "initView", "", "url", "Landroid/view/View;", NativeConstants.TYPE_VIEW, "loadImageAsync", "(Ljava/lang/String;Landroid/view/View;)V", "onAttachedToWindow", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", MissionEvent.MESSAGE_PAUSE, "Landroid/widget/TextView;", "textBtn", "Landroid/widget/ImageView;", "imageBtn", "btnText", "btnTextColor", "btnBgUrl", "Lkotlin/Function0;", "clickAction", "showButton", "(Landroid/widget/TextView;Landroid/widget/ImageView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/Function0;)V", "bgImg", "Landroid/widget/ImageView;", "getBgImg", "()Landroid/widget/ImageView;", "setBgImg", "(Landroid/widget/ImageView;)V", "closeBtn", "Landroid/view/View;", "getCloseBtn", "()Landroid/view/View;", "setCloseBtn", "(Landroid/view/View;)V", "data", "Lcom/baidu/bdtask/component/dialog/TaskDialogViewData;", "<init>", "Companion", "lib-bdtask-ui-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public abstract class a extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public ImageView b;
    public TaskDialogViewData c;

    /* renamed from: com.baidu.bdtask.ui.components.dialog.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class View$OnClickListenerC0080a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC0080a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            au v;
            bu d;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TaskDialogViewData a = this.a.a();
                if (a != null && (v = BDPTask.m.v()) != null && (d = v.d()) != null) {
                    d.b(a.getTaskInfoSingleKey(), xq.c.a());
                }
                this.a.g();
                this.a.d();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function0};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.invoke();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Function0 a;

        public c(Function0 function0) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {function0};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.invoke();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1371601847, "Lcom/baidu/bdtask/ui/components/dialog/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1371601847, "Lcom/baidu/bdtask/ui/components/dialog/a;");
        }
    }

    public a() {
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

    public final TaskDialogViewData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (TaskDialogViewData) invokeV.objValue;
    }

    public final void b(TextView textView, ImageView imageView, String str, String str2, String str3, Function0<Unit> function0) {
        au v;
        as h;
        Context appContext;
        Resources resources;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{textView, imageView, str, str2, str3, function0}) == null) || (v = BDPTask.m.v()) == null || (h = v.h()) == null || (appContext = h.getAppContext()) == null || (resources = appContext.getResources()) == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            textView.setVisibility(0);
            imageView.setVisibility(8);
            textView.setTextColor(gv.a.a(str2, resources.getColor(R.color.obfuscated_res_0x7f060acb)));
            textView.setText(str);
            textView.setOnClickListener(new b(function0));
            c(str3, textView);
            return;
        }
        textView.setVisibility(8);
        imageView.setVisibility(0);
        imageView.setOnClickListener(new c(function0));
        c(str3, imageView);
    }

    public final void c(String str, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view2) == null) {
            d.a.a(str, view2);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            finish();
        }
    }

    @LayoutRes
    public abstract int e();

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TaskDialogViewData taskDialogViewData = this.c;
            String closeBg = taskDialogViewData != null ? taskDialogViewData.getCloseBg() : null;
            View view2 = this.a;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            }
            c(closeBg, view2);
            TaskDialogViewData taskDialogViewData2 = this.c;
            String bgUrl = taskDialogViewData2 != null ? taskDialogViewData2.getBgUrl() : null;
            ImageView imageView = this.b;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgImg");
            }
            c(bgUrl, imageView);
        }
    }

    public final void g() {
        TaskDialogViewData a;
        au v;
        ju f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (a = a()) == null || (v = BDPTask.m.v()) == null || (f = v.f()) == null) {
            return;
        }
        f.a("y_task_pop", "close_clk", ku.b(ku.a, a.getTaskId(), a.getTaskActId(), null, 4, null));
    }

    public final void h() {
        TaskDialogViewData a;
        au v;
        ju f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (a = a()) == null || (v = BDPTask.m.v()) == null || (f = v.f()) == null) {
            return;
        }
        f.a("y_task_pop", "icon_clk", ku.b(ku.a, a.getTaskId(), a.getTaskActId(), null, 4, null));
    }

    public final void i() {
        TaskDialogViewData a;
        au v;
        ju f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (a = a()) == null || (v = BDPTask.m.v()) == null || (f = v.f()) == null) {
            return;
        }
        f.a("y_task_pop", "cancel_clk", ku.b(ku.a, a.getTaskId(), a.getTaskActId(), null, 4, null));
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09079f);
            frameLayout.removeAllViews();
            getLayoutInflater().inflate(e(), frameLayout);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0907a7);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.dialog_content_img)");
            this.b = (ImageView) findViewById;
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f0907a4);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.dialog_close)");
            this.a = findViewById2;
            if (findViewById2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            }
            findViewById2.setOnClickListener(new View$OnClickListenerC0080a(this));
            Intent intent = getIntent();
            Intrinsics.checkExpressionValueIsNotNull(intent, "intent");
            Bundle extras = intent.getExtras();
            Serializable serializable = extras != null ? extras.getSerializable("data") : null;
            TaskDialogViewData taskDialogViewData = serializable instanceof TaskDialogViewData ? serializable : null;
            this.c = taskDialogViewData;
            if (taskDialogViewData == null) {
                d();
            }
            f();
            k();
        }
    }

    public final void k() {
        TaskDialogViewData a;
        au v;
        ju f;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (a = a()) == null || (v = BDPTask.m.v()) == null || (f = v.f()) == null) {
            return;
        }
        f.a("y_task_pop", "c_pv", ku.b(ku.a, a.getTaskId(), a.getTaskActId(), null, 4, null));
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onAttachedToWindow();
            overridePendingTransition(0, 0);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d077b);
            getWindow().setLayout(-1, -1);
            j();
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            overridePendingTransition(0, 0);
        }
    }

    public final void setCloseBtn(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            this.a = view2;
        }
    }
}

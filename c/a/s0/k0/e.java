package c.a.s0.k0;

import android.view.View;
import androidx.annotation.NonNull;
import c.a.s0.o;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.searchbox.performance.speed.task.LaunchTaskSchedule;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.s.t.a f18915b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.s.t.a f18916c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.s.t.a f18917d;

    /* renamed from: e  reason: collision with root package name */
    public int f18918e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f18919f;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f18920e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18920e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                if (id == R.id.private_yes || id == R.id.yesBtn) {
                    if (this.f18920e.f18915b != null && this.f18920e.f18915b.isShowing()) {
                        this.f18920e.f18915b.dismiss();
                        SmartLaunchStats.onConfirmPrivacy();
                        c.a.s0.r3.f.a.a("1", "1");
                        c.a.r0.s.z.a.k("logoController", false);
                    }
                    if (this.f18920e.f18916c != null && this.f18920e.f18916c.isShowing()) {
                        this.f18920e.f18916c.dismiss();
                        c.a.s0.r3.f.a.a("2", "1");
                        c.a.r0.s.z.a.k("logoController", false);
                    }
                    if (this.f18920e.f18917d != null && this.f18920e.f18917d.isShowing()) {
                        this.f18920e.f18917d.dismiss();
                        c.a.s0.r3.f.a.a("3", "1");
                        c.a.r0.s.z.a.k("logoController", false);
                    }
                    PermissionUtil.setIsAgreePrivacyPolicy(true);
                    c.a.r0.s.g0.b.j().w("key_first_enter_app_timestamp", System.currentTimeMillis());
                    LaunchTaskSchedule.getInstance().start(4);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921639, 2));
                } else if (id == R.id.private_no) {
                    if (this.f18920e.f18915b.isShowing()) {
                        this.f18920e.f18915b.dismiss();
                        c.a.s0.r3.f.a.a("1", "2");
                    }
                    if (this.f18920e.f18916c == null) {
                        e eVar = this.f18920e;
                        eVar.f18916c = o.a(eVar.a.getPageContext(), this.f18920e.f18919f, R.string.privacy_policy_guide_one, R.string.secret_hint_no_agree);
                    }
                    this.f18920e.f18916c.show();
                    c.a.s0.r3.f.a.b("2");
                } else if (id == R.id.browseBtn) {
                    e.h(this.f18920e);
                    if (this.f18920e.f18916c.isShowing()) {
                        this.f18920e.f18916c.dismiss();
                        c.a.s0.r3.f.a.a("2", "2");
                        if (this.f18920e.f18917d == null) {
                            e eVar2 = this.f18920e;
                            eVar2.f18917d = o.a(eVar2.a.getPageContext(), this.f18920e.f18919f, R.string.privacy_policy_guide_two, R.string.secret_hint_browser_exit);
                            this.f18920e.f18917d.show();
                            c.a.s0.r3.f.a.b("3");
                        }
                    }
                    if (this.f18920e.f18917d.isShowing() && this.f18920e.f18918e == 2) {
                        this.f18920e.f18917d.dismiss();
                        c.a.s0.r3.f.a.a("3", "2");
                        this.f18920e.a.finish();
                    }
                }
            }
        }
    }

    public e(@NonNull BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18918e = 0;
        this.f18919f = new a(this);
        this.a = baseFragmentActivity;
    }

    public static /* synthetic */ int h(e eVar) {
        int i2 = eVar.f18918e;
        eVar.f18918e = i2 + 1;
        return i2;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.r0.s.t.a aVar = this.f18915b;
            if (aVar != null) {
                aVar.dismiss();
            }
            c.a.r0.s.t.a aVar2 = this.f18916c;
            if (aVar2 != null) {
                aVar2.dismiss();
            }
            c.a.r0.s.t.a aVar3 = this.f18917d;
            if (aVar3 != null) {
                aVar3.dismiss();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.r0.s.t.a b2 = o.b(this.a.getPageContext(), this.f18919f);
            this.f18915b = b2;
            b2.show();
            SmartLaunchStats.onPrivacyDialogShow();
            c.a.s0.r3.f.a.b("1");
        }
    }
}

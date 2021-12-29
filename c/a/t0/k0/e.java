package c.a.t0.k0;

import android.view.View;
import androidx.annotation.NonNull;
import c.a.t0.o;
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
    public c.a.s0.s.s.a f19144b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.s.s.a f19145c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.s0.s.s.a f19146d;

    /* renamed from: e  reason: collision with root package name */
    public int f19147e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f19148f;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f19149e;

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
            this.f19149e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                if (id == R.id.private_yes || id == R.id.yesBtn) {
                    if (this.f19149e.f19144b != null && this.f19149e.f19144b.isShowing()) {
                        this.f19149e.f19144b.dismiss();
                        SmartLaunchStats.onConfirmPrivacy();
                        c.a.t0.r3.f.a.a("1", "1");
                        c.a.s0.s.y.a.k("logoController", false);
                    }
                    if (this.f19149e.f19145c != null && this.f19149e.f19145c.isShowing()) {
                        this.f19149e.f19145c.dismiss();
                        c.a.t0.r3.f.a.a("2", "1");
                        c.a.s0.s.y.a.k("logoController", false);
                    }
                    if (this.f19149e.f19146d != null && this.f19149e.f19146d.isShowing()) {
                        this.f19149e.f19146d.dismiss();
                        c.a.t0.r3.f.a.a("3", "1");
                        c.a.s0.s.y.a.k("logoController", false);
                    }
                    c.a.s0.s.g0.b.j().w("key_first_enter_app_timestamp", System.currentTimeMillis());
                    PermissionUtil.setIsAgreePrivacyPolicy(true);
                    LaunchTaskSchedule.getInstance().start(4);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921639, 2));
                } else if (id == R.id.private_no) {
                    if (this.f19149e.f19144b.isShowing()) {
                        this.f19149e.f19144b.dismiss();
                        c.a.t0.r3.f.a.a("1", "2");
                    }
                    if (this.f19149e.f19145c == null) {
                        e eVar = this.f19149e;
                        eVar.f19145c = o.a(eVar.a.getPageContext(), this.f19149e.f19148f, R.string.privacy_policy_guide_one, R.string.secret_hint_no_agree);
                    }
                    this.f19149e.f19145c.show();
                    c.a.t0.r3.f.a.b("2");
                } else if (id == R.id.browseBtn) {
                    e.h(this.f19149e);
                    if (this.f19149e.f19145c.isShowing()) {
                        this.f19149e.f19145c.dismiss();
                        c.a.t0.r3.f.a.a("2", "2");
                        if (this.f19149e.f19146d == null) {
                            e eVar2 = this.f19149e;
                            eVar2.f19146d = o.a(eVar2.a.getPageContext(), this.f19149e.f19148f, R.string.privacy_policy_guide_two, R.string.secret_hint_browser_exit);
                            this.f19149e.f19146d.show();
                            c.a.t0.r3.f.a.b("3");
                        }
                    }
                    if (this.f19149e.f19146d.isShowing() && this.f19149e.f19147e == 2) {
                        this.f19149e.f19146d.dismiss();
                        c.a.t0.r3.f.a.a("3", "2");
                        this.f19149e.a.finish();
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
        this.f19147e = 0;
        this.f19148f = new a(this);
        this.a = baseFragmentActivity;
    }

    public static /* synthetic */ int h(e eVar) {
        int i2 = eVar.f19147e;
        eVar.f19147e = i2 + 1;
        return i2;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.s0.s.s.a aVar = this.f19144b;
            if (aVar != null) {
                aVar.dismiss();
            }
            c.a.s0.s.s.a aVar2 = this.f19145c;
            if (aVar2 != null) {
                aVar2.dismiss();
            }
            c.a.s0.s.s.a aVar3 = this.f19146d;
            if (aVar3 != null) {
                aVar3.dismiss();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.s0.s.s.a b2 = o.b(this.a.getPageContext(), this.f19148f);
            this.f19144b = b2;
            b2.show();
            SmartLaunchStats.onPrivacyDialogShow();
            c.a.t0.r3.f.a.b("1");
        }
    }
}

package b.a.r0.f0;

import android.view.View;
import androidx.annotation.NonNull;
import b.a.r0.l;
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
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final BaseFragmentActivity f16329a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.q0.s.s.a f16330b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.q0.s.s.a f16331c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.q0.s.s.a f16332d;

    /* renamed from: e  reason: collision with root package name */
    public int f16333e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f16334f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f16335e;

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
            this.f16335e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                if (id == R.id.private_yes || id == R.id.yesBtn) {
                    if (this.f16335e.f16330b != null && this.f16335e.f16330b.isShowing()) {
                        this.f16335e.f16330b.dismiss();
                        SmartLaunchStats.onConfirmPrivacy();
                        b.a.r0.h3.f.a.a("1", "1");
                    }
                    if (this.f16335e.f16331c != null && this.f16335e.f16331c.isShowing()) {
                        this.f16335e.f16331c.dismiss();
                        b.a.r0.h3.f.a.a("2", "1");
                    }
                    if (this.f16335e.f16332d != null && this.f16335e.f16332d.isShowing()) {
                        this.f16335e.f16332d.dismiss();
                        b.a.r0.h3.f.a.a("3", "1");
                    }
                    PermissionUtil.setIsAgreePrivacyPolicy(true);
                    b.a.q0.s.e0.b.j().w("key_first_enter_app_timestamp", System.currentTimeMillis());
                    LaunchTaskSchedule.getInstance().start(4);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921639, 2));
                } else if (id == R.id.private_no) {
                    if (this.f16335e.f16330b.isShowing()) {
                        this.f16335e.f16330b.dismiss();
                        b.a.r0.h3.f.a.a("1", "2");
                    }
                    if (this.f16335e.f16331c == null) {
                        e eVar = this.f16335e;
                        eVar.f16331c = l.a(eVar.f16329a.getPageContext(), this.f16335e.f16334f, R.string.privacy_policy_guide_one, R.string.secret_hint_no_agree);
                    }
                    this.f16335e.f16331c.show();
                    b.a.r0.h3.f.a.b("2");
                } else if (id == R.id.browseBtn) {
                    e.h(this.f16335e);
                    if (this.f16335e.f16331c.isShowing()) {
                        this.f16335e.f16331c.dismiss();
                        b.a.r0.h3.f.a.a("2", "2");
                        if (this.f16335e.f16332d == null) {
                            e eVar2 = this.f16335e;
                            eVar2.f16332d = l.a(eVar2.f16329a.getPageContext(), this.f16335e.f16334f, R.string.privacy_policy_guide_two, R.string.secret_hint_browser_exit);
                            this.f16335e.f16332d.show();
                            b.a.r0.h3.f.a.b("3");
                        }
                    }
                    if (this.f16335e.f16332d.isShowing() && this.f16335e.f16333e == 2) {
                        this.f16335e.f16332d.dismiss();
                        b.a.r0.h3.f.a.a("3", "2");
                        this.f16335e.f16329a.finish();
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
        this.f16333e = 0;
        this.f16334f = new a(this);
        this.f16329a = baseFragmentActivity;
    }

    public static /* synthetic */ int h(e eVar) {
        int i2 = eVar.f16333e;
        eVar.f16333e = i2 + 1;
        return i2;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.q0.s.s.a aVar = this.f16330b;
            if (aVar != null) {
                aVar.dismiss();
            }
            b.a.q0.s.s.a aVar2 = this.f16331c;
            if (aVar2 != null) {
                aVar2.dismiss();
            }
            b.a.q0.s.s.a aVar3 = this.f16332d;
            if (aVar3 != null) {
                aVar3.dismiss();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.q0.s.s.a b2 = l.b(this.f16329a.getPageContext(), this.f16334f);
            this.f16330b = b2;
            b2.show();
            SmartLaunchStats.onPrivacyDialogShow();
            b.a.r0.h3.f.a.b("1");
        }
    }
}

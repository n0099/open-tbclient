package c.a.r0.k0;

import android.view.View;
import androidx.annotation.NonNull;
import c.a.r0.o;
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
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.s.s.a f18556b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.q0.s.s.a f18557c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.s.s.a f18558d;

    /* renamed from: e  reason: collision with root package name */
    public int f18559e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f18560f;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f18561e;

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
            this.f18561e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                if (id == R.id.private_yes || id == R.id.yesBtn) {
                    if (this.f18561e.f18556b != null && this.f18561e.f18556b.isShowing()) {
                        this.f18561e.f18556b.dismiss();
                        SmartLaunchStats.onConfirmPrivacy();
                        c.a.r0.p3.f.a.a("1", "1");
                    }
                    if (this.f18561e.f18557c != null && this.f18561e.f18557c.isShowing()) {
                        this.f18561e.f18557c.dismiss();
                        c.a.r0.p3.f.a.a("2", "1");
                    }
                    if (this.f18561e.f18558d != null && this.f18561e.f18558d.isShowing()) {
                        this.f18561e.f18558d.dismiss();
                        c.a.r0.p3.f.a.a("3", "1");
                    }
                    PermissionUtil.setIsAgreePrivacyPolicy(true);
                    c.a.q0.s.e0.b.j().w("key_first_enter_app_timestamp", System.currentTimeMillis());
                    LaunchTaskSchedule.getInstance().start(4);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921639, 2));
                    c.a.q0.s.y.a.i();
                } else if (id == R.id.private_no) {
                    if (this.f18561e.f18556b.isShowing()) {
                        this.f18561e.f18556b.dismiss();
                        c.a.r0.p3.f.a.a("1", "2");
                    }
                    if (this.f18561e.f18557c == null) {
                        e eVar = this.f18561e;
                        eVar.f18557c = o.a(eVar.a.getPageContext(), this.f18561e.f18560f, R.string.privacy_policy_guide_one, R.string.secret_hint_no_agree);
                    }
                    this.f18561e.f18557c.show();
                    c.a.r0.p3.f.a.b("2");
                } else if (id == R.id.browseBtn) {
                    e.h(this.f18561e);
                    if (this.f18561e.f18557c.isShowing()) {
                        this.f18561e.f18557c.dismiss();
                        c.a.r0.p3.f.a.a("2", "2");
                        if (this.f18561e.f18558d == null) {
                            e eVar2 = this.f18561e;
                            eVar2.f18558d = o.a(eVar2.a.getPageContext(), this.f18561e.f18560f, R.string.privacy_policy_guide_two, R.string.secret_hint_browser_exit);
                            this.f18561e.f18558d.show();
                            c.a.r0.p3.f.a.b("3");
                        }
                    }
                    if (this.f18561e.f18558d.isShowing() && this.f18561e.f18559e == 2) {
                        this.f18561e.f18558d.dismiss();
                        c.a.r0.p3.f.a.a("3", "2");
                        this.f18561e.a.finish();
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
        this.f18559e = 0;
        this.f18560f = new a(this);
        this.a = baseFragmentActivity;
    }

    public static /* synthetic */ int h(e eVar) {
        int i2 = eVar.f18559e;
        eVar.f18559e = i2 + 1;
        return i2;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.q0.s.s.a aVar = this.f18556b;
            if (aVar != null) {
                aVar.dismiss();
            }
            c.a.q0.s.s.a aVar2 = this.f18557c;
            if (aVar2 != null) {
                aVar2.dismiss();
            }
            c.a.q0.s.s.a aVar3 = this.f18558d;
            if (aVar3 != null) {
                aVar3.dismiss();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.q0.s.s.a b2 = o.b(this.a.getPageContext(), this.f18560f);
            this.f18556b = b2;
            b2.show();
            SmartLaunchStats.onPrivacyDialogShow();
            c.a.r0.p3.f.a.b("1");
        }
    }
}

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
    public final BaseFragmentActivity f17829a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.q0.s.s.a f17830b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.q0.s.s.a f17831c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.q0.s.s.a f17832d;

    /* renamed from: e  reason: collision with root package name */
    public int f17833e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f17834f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f17835e;

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
            this.f17835e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                if (id == R.id.private_yes || id == R.id.yesBtn) {
                    if (this.f17835e.f17830b != null && this.f17835e.f17830b.isShowing()) {
                        this.f17835e.f17830b.dismiss();
                        SmartLaunchStats.onConfirmPrivacy();
                        b.a.r0.i3.f.a.a("1", "1");
                    }
                    if (this.f17835e.f17831c != null && this.f17835e.f17831c.isShowing()) {
                        this.f17835e.f17831c.dismiss();
                        b.a.r0.i3.f.a.a("2", "1");
                    }
                    if (this.f17835e.f17832d != null && this.f17835e.f17832d.isShowing()) {
                        this.f17835e.f17832d.dismiss();
                        b.a.r0.i3.f.a.a("3", "1");
                    }
                    PermissionUtil.setIsAgreePrivacyPolicy(true);
                    b.a.q0.s.e0.b.j().w("key_first_enter_app_timestamp", System.currentTimeMillis());
                    LaunchTaskSchedule.getInstance().start(4);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921639, 2));
                    b.a.q0.s.y.a.c();
                } else if (id == R.id.private_no) {
                    if (this.f17835e.f17830b.isShowing()) {
                        this.f17835e.f17830b.dismiss();
                        b.a.r0.i3.f.a.a("1", "2");
                    }
                    if (this.f17835e.f17831c == null) {
                        e eVar = this.f17835e;
                        eVar.f17831c = l.a(eVar.f17829a.getPageContext(), this.f17835e.f17834f, R.string.privacy_policy_guide_one, R.string.secret_hint_no_agree);
                    }
                    this.f17835e.f17831c.show();
                    b.a.r0.i3.f.a.b("2");
                } else if (id == R.id.browseBtn) {
                    e.h(this.f17835e);
                    if (this.f17835e.f17831c.isShowing()) {
                        this.f17835e.f17831c.dismiss();
                        b.a.r0.i3.f.a.a("2", "2");
                        if (this.f17835e.f17832d == null) {
                            e eVar2 = this.f17835e;
                            eVar2.f17832d = l.a(eVar2.f17829a.getPageContext(), this.f17835e.f17834f, R.string.privacy_policy_guide_two, R.string.secret_hint_browser_exit);
                            this.f17835e.f17832d.show();
                            b.a.r0.i3.f.a.b("3");
                        }
                    }
                    if (this.f17835e.f17832d.isShowing() && this.f17835e.f17833e == 2) {
                        this.f17835e.f17832d.dismiss();
                        b.a.r0.i3.f.a.a("3", "2");
                        this.f17835e.f17829a.finish();
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
        this.f17833e = 0;
        this.f17834f = new a(this);
        this.f17829a = baseFragmentActivity;
    }

    public static /* synthetic */ int h(e eVar) {
        int i2 = eVar.f17833e;
        eVar.f17833e = i2 + 1;
        return i2;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.q0.s.s.a aVar = this.f17830b;
            if (aVar != null) {
                aVar.dismiss();
            }
            b.a.q0.s.s.a aVar2 = this.f17831c;
            if (aVar2 != null) {
                aVar2.dismiss();
            }
            b.a.q0.s.s.a aVar3 = this.f17832d;
            if (aVar3 != null) {
                aVar3.dismiss();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.q0.s.s.a b2 = l.b(this.f17829a.getPageContext(), this.f17834f);
            this.f17830b = b2;
            b2.show();
            SmartLaunchStats.onPrivacyDialogShow();
            b.a.r0.i3.f.a.b("1");
        }
    }
}

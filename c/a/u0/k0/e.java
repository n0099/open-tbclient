package c.a.u0.k0;

import android.view.View;
import androidx.annotation.NonNull;
import c.a.u0.o;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.t0.s.t.a f19006b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.s.t.a f19007c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.s.t.a f19008d;

    /* renamed from: e  reason: collision with root package name */
    public int f19009e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f19010f;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f19011e;

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
            this.f19011e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                if (id == R.id.private_yes || id == R.id.yesBtn) {
                    if (this.f19011e.f19006b != null && this.f19011e.f19006b.isShowing()) {
                        this.f19011e.f19006b.dismiss();
                        SmartLaunchStats.onConfirmPrivacy();
                        c.a.u0.t3.e.a.a("1", "1");
                        c.a.t0.s.a0.a.j("logoController", false);
                    }
                    if (this.f19011e.f19007c != null && this.f19011e.f19007c.isShowing()) {
                        this.f19011e.f19007c.dismiss();
                        c.a.u0.t3.e.a.a("2", "1");
                        c.a.t0.s.a0.a.j("logoController", false);
                    }
                    if (this.f19011e.f19008d != null && this.f19011e.f19008d.isShowing()) {
                        this.f19011e.f19008d.dismiss();
                        c.a.u0.t3.e.a.a("3", "1");
                        c.a.t0.s.a0.a.j("logoController", false);
                    }
                    c.a.t0.s.j0.b.k().x("key_first_enter_app_timestamp", System.currentTimeMillis());
                    PermissionUtil.setIsAgreePrivacyPolicy(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921639, 2));
                } else if (id == R.id.private_no) {
                    if (this.f19011e.f19006b.isShowing()) {
                        this.f19011e.f19006b.dismiss();
                        c.a.u0.t3.e.a.a("1", "2");
                    }
                    if (this.f19011e.f19007c == null) {
                        e eVar = this.f19011e;
                        eVar.f19007c = o.a(eVar.a.getPageContext(), this.f19011e.f19010f, R.string.privacy_policy_guide_one, R.string.secret_hint_no_agree);
                    }
                    this.f19011e.f19007c.show();
                    c.a.u0.t3.e.a.b("2");
                } else if (id == R.id.browseBtn) {
                    e.h(this.f19011e);
                    if (this.f19011e.f19007c.isShowing()) {
                        this.f19011e.f19007c.dismiss();
                        c.a.u0.t3.e.a.a("2", "2");
                        if (this.f19011e.f19008d == null) {
                            e eVar2 = this.f19011e;
                            eVar2.f19008d = o.a(eVar2.a.getPageContext(), this.f19011e.f19010f, R.string.privacy_policy_guide_two, R.string.secret_hint_browser_exit);
                            this.f19011e.f19008d.show();
                            c.a.u0.t3.e.a.b("3");
                        }
                    }
                    if (this.f19011e.f19008d.isShowing() && this.f19011e.f19009e == 2) {
                        this.f19011e.f19008d.dismiss();
                        c.a.u0.t3.e.a.a("3", "2");
                        this.f19011e.a.finish();
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
        this.f19009e = 0;
        this.f19010f = new a(this);
        this.a = baseFragmentActivity;
    }

    public static /* synthetic */ int h(e eVar) {
        int i2 = eVar.f19009e;
        eVar.f19009e = i2 + 1;
        return i2;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.t0.s.t.a aVar = this.f19006b;
            if (aVar != null) {
                aVar.dismiss();
            }
            c.a.t0.s.t.a aVar2 = this.f19007c;
            if (aVar2 != null) {
                aVar2.dismiss();
            }
            c.a.t0.s.t.a aVar3 = this.f19008d;
            if (aVar3 != null) {
                aVar3.dismiss();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.t0.s.t.a b2 = o.b(this.a.getPageContext(), this.f19010f);
            this.f19006b = b2;
            b2.show();
            TbSingleton.getInstance().setExceptInsertAdDiaShow(true);
            SmartLaunchStats.onPrivacyDialogShow();
            c.a.u0.t3.e.a.b("1");
        }
    }
}

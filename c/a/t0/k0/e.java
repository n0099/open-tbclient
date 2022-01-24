package c.a.t0.k0;

import android.view.View;
import androidx.annotation.NonNull;
import c.a.t0.o;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.SmartLaunchStats;
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
    public c.a.s0.s.s.a f18639b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.s0.s.s.a f18640c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.s0.s.s.a f18641d;

    /* renamed from: e  reason: collision with root package name */
    public int f18642e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f18643f;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f18644e;

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
            this.f18644e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                if (id == R.id.private_yes || id == R.id.yesBtn) {
                    if (this.f18644e.f18639b != null && this.f18644e.f18639b.isShowing()) {
                        this.f18644e.f18639b.dismiss();
                        SmartLaunchStats.onConfirmPrivacy();
                        c.a.t0.s3.e.a.a("1", "1");
                        c.a.s0.s.z.a.j("logoController", false);
                    }
                    if (this.f18644e.f18640c != null && this.f18644e.f18640c.isShowing()) {
                        this.f18644e.f18640c.dismiss();
                        c.a.t0.s3.e.a.a("2", "1");
                        c.a.s0.s.z.a.j("logoController", false);
                    }
                    if (this.f18644e.f18641d != null && this.f18644e.f18641d.isShowing()) {
                        this.f18644e.f18641d.dismiss();
                        c.a.t0.s3.e.a.a("3", "1");
                        c.a.s0.s.z.a.j("logoController", false);
                    }
                    c.a.s0.s.i0.b.k().x("key_first_enter_app_timestamp", System.currentTimeMillis());
                    PermissionUtil.setIsAgreePrivacyPolicy(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921639, 2));
                } else if (id == R.id.private_no) {
                    if (this.f18644e.f18639b.isShowing()) {
                        this.f18644e.f18639b.dismiss();
                        c.a.t0.s3.e.a.a("1", "2");
                    }
                    if (this.f18644e.f18640c == null) {
                        e eVar = this.f18644e;
                        eVar.f18640c = o.a(eVar.a.getPageContext(), this.f18644e.f18643f, R.string.privacy_policy_guide_one, R.string.secret_hint_no_agree);
                    }
                    this.f18644e.f18640c.show();
                    c.a.t0.s3.e.a.b("2");
                } else if (id == R.id.browseBtn) {
                    e.h(this.f18644e);
                    if (this.f18644e.f18640c.isShowing()) {
                        this.f18644e.f18640c.dismiss();
                        c.a.t0.s3.e.a.a("2", "2");
                        if (this.f18644e.f18641d == null) {
                            e eVar2 = this.f18644e;
                            eVar2.f18641d = o.a(eVar2.a.getPageContext(), this.f18644e.f18643f, R.string.privacy_policy_guide_two, R.string.secret_hint_browser_exit);
                            this.f18644e.f18641d.show();
                            c.a.t0.s3.e.a.b("3");
                        }
                    }
                    if (this.f18644e.f18641d.isShowing() && this.f18644e.f18642e == 2) {
                        this.f18644e.f18641d.dismiss();
                        c.a.t0.s3.e.a.a("3", "2");
                        this.f18644e.a.finish();
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
        this.f18642e = 0;
        this.f18643f = new a(this);
        this.a = baseFragmentActivity;
    }

    public static /* synthetic */ int h(e eVar) {
        int i2 = eVar.f18642e;
        eVar.f18642e = i2 + 1;
        return i2;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.s0.s.s.a aVar = this.f18639b;
            if (aVar != null) {
                aVar.dismiss();
            }
            c.a.s0.s.s.a aVar2 = this.f18640c;
            if (aVar2 != null) {
                aVar2.dismiss();
            }
            c.a.s0.s.s.a aVar3 = this.f18641d;
            if (aVar3 != null) {
                aVar3.dismiss();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.s0.s.s.a b2 = o.b(this.a.getPageContext(), this.f18643f);
            this.f18639b = b2;
            b2.show();
            SmartLaunchStats.onPrivacyDialogShow();
            c.a.t0.s3.e.a.b("1");
        }
    }
}

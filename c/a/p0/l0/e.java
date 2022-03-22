package c.a.p0.l0;

import android.view.View;
import androidx.annotation.NonNull;
import c.a.p0.o;
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
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.o0.r.t.a f16031b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.o0.r.t.a f16032c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.r.t.a f16033d;

    /* renamed from: e  reason: collision with root package name */
    public int f16034e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f16035f;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                if (id == R.id.obfuscated_res_0x7f091901 || id == R.id.obfuscated_res_0x7f0924b8) {
                    if (this.a.f16031b != null && this.a.f16031b.isShowing()) {
                        this.a.f16031b.dismiss();
                        SmartLaunchStats.onConfirmPrivacy();
                        c.a.p0.u3.e.a.a("1", "1");
                        c.a.o0.r.a0.a.l("logoController", false);
                    }
                    if (this.a.f16032c != null && this.a.f16032c.isShowing()) {
                        this.a.f16032c.dismiss();
                        c.a.p0.u3.e.a.a("2", "1");
                        c.a.o0.r.a0.a.l("logoController", false);
                    }
                    if (this.a.f16033d != null && this.a.f16033d.isShowing()) {
                        this.a.f16033d.dismiss();
                        c.a.p0.u3.e.a.a("3", "1");
                        c.a.o0.r.a0.a.l("logoController", false);
                    }
                    c.a.o0.r.j0.b.k().x("key_first_enter_app_timestamp", System.currentTimeMillis());
                    PermissionUtil.setIsAgreePrivacyPolicy(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921639, 2));
                } else if (id == R.id.obfuscated_res_0x7f0918ff) {
                    if (this.a.f16031b.isShowing()) {
                        this.a.f16031b.dismiss();
                        c.a.p0.u3.e.a.a("1", "2");
                    }
                    if (this.a.f16032c == null) {
                        e eVar = this.a;
                        eVar.f16032c = o.a(eVar.a.getPageContext(), this.a.f16035f, R.string.obfuscated_res_0x7f0f0ebd, R.string.obfuscated_res_0x7f0f10b5);
                    }
                    this.a.f16032c.show();
                    c.a.p0.u3.e.a.b("2");
                } else if (id == R.id.obfuscated_res_0x7f0903ef) {
                    e.h(this.a);
                    if (this.a.f16032c.isShowing()) {
                        this.a.f16032c.dismiss();
                        c.a.p0.u3.e.a.a("2", "2");
                        if (this.a.f16033d == null) {
                            e eVar2 = this.a;
                            eVar2.f16033d = o.a(eVar2.a.getPageContext(), this.a.f16035f, R.string.obfuscated_res_0x7f0f0ebe, R.string.obfuscated_res_0x7f0f10aa);
                            this.a.f16033d.show();
                            c.a.p0.u3.e.a.b("3");
                        }
                    }
                    if (this.a.f16033d.isShowing() && this.a.f16034e == 2) {
                        this.a.f16033d.dismiss();
                        c.a.p0.u3.e.a.a("3", "2");
                        this.a.a.finish();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16034e = 0;
        this.f16035f = new a(this);
        this.a = baseFragmentActivity;
    }

    public static /* synthetic */ int h(e eVar) {
        int i = eVar.f16034e;
        eVar.f16034e = i + 1;
        return i;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.o0.r.t.a aVar = this.f16031b;
            if (aVar != null) {
                aVar.dismiss();
            }
            c.a.o0.r.t.a aVar2 = this.f16032c;
            if (aVar2 != null) {
                aVar2.dismiss();
            }
            c.a.o0.r.t.a aVar3 = this.f16033d;
            if (aVar3 != null) {
                aVar3.dismiss();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.o0.r.t.a b2 = o.b(this.a.getPageContext(), this.f16035f);
            this.f16031b = b2;
            b2.show();
            TbSingleton.getInstance().setExceptInsertAdDiaShow(true);
            SmartLaunchStats.onPrivacyDialogShow();
            c.a.p0.u3.e.a.b("1");
        }
    }
}

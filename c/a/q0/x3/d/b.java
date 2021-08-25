package c.a.q0.x3.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b implements c.a.q0.x3.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.q0.x3.c.a f29059a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.x3.b f29060b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f29061c;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f29062e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f29063f;

        public a(b bVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29063f = bVar;
            this.f29062e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.e.e.p.a.a(this.f29062e.t);
                l.M(this.f29063f.f29061c.getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* renamed from: c.a.q0.x3.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class DialogInterface$OnDismissListenerC1349b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f29064e;

        public DialogInterface$OnDismissListenerC1349b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29064e = bVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f29064e.h();
            }
        }
    }

    public b(TbPageContext<?> tbPageContext, c.a.q0.x3.b bVar, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar, intent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29061c = tbPageContext;
        this.f29060b = bVar;
        c.a.q0.x3.c.b bVar2 = new c.a.q0.x3.c.b();
        this.f29059a = bVar2;
        bVar2.b(intent);
        this.f29059a.e(tbPageContext.getUniqueId());
    }

    @Override // c.a.q0.x3.d.a
    public void a() {
        c.a.q0.x3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f29060b) == null) {
            return;
        }
        bVar.showErrorView();
    }

    @Override // c.a.q0.x3.d.a
    public void b() {
        c.a.q0.x3.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f29059a) == null) {
            return;
        }
        c.a.p0.s.d0.b.j().t(c.a.p0.s.d0.b.n(aVar.c()), false);
    }

    @Override // c.a.q0.x3.d.a
    public void c() {
        c.a.q0.x3.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f29059a) == null || this.f29060b == null) {
            return;
        }
        this.f29060b.rePlayVideo(aVar.getVideoUrl());
    }

    @Override // c.a.q0.x3.d.a
    public void d() {
        c.a.q0.x3.b bVar;
        c.a.q0.x3.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.f29060b) == null || (aVar = this.f29059a) == null) {
            return;
        }
        bVar.showDialog(aVar.a(), this.f29059a.g());
    }

    @Override // c.a.q0.x3.d.a
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f29061c == null) {
            return;
        }
        if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f29061c.getPageActivity())) {
            i();
        }
    }

    public final void h() {
        c.a.q0.x3.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.f29059a) == null || this.f29060b == null) {
            return;
        }
        this.f29060b.startPlayVideo(aVar.getVideoUrl());
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f29059a == null || this.f29061c == null) {
            return;
        }
        ShareItem shareItem = new ShareItem();
        shareItem.r = this.f29059a.d();
        shareItem.s = this.f29059a.i();
        shareItem.t = this.f29059a.f();
        shareItem.u = this.f29059a.f();
        if (!k.isEmpty(this.f29059a.h())) {
            shareItem.v = Uri.parse(this.f29059a.h());
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.f29061c.getPageActivity(), shareItem, true, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
        shareDialogConfig.setOnDismissListener(new DialogInterface$OnDismissListenerC1349b(this));
        this.f29061c.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    @Override // c.a.q0.x3.d.a
    public void onClose() {
        c.a.q0.x3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bVar = this.f29060b) == null) {
            return;
        }
        bVar.finishActivity();
    }

    @Override // c.a.q0.x3.d.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // c.a.q0.x3.d.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // c.a.q0.x3.d.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h();
        }
    }
}

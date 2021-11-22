package b.a.r0.b4.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.k;
import b.a.e.f.p.l;
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
public class b implements b.a.r0.b4.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.r0.b4.c.a f16514a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.b4.b f16515b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext<?> f16516c;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f16517e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f16518f;

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
            this.f16518f = bVar;
            this.f16517e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.e.f.p.a.a(this.f16517e.t);
                l.M(this.f16518f.f16516c.getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* renamed from: b.a.r0.b4.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class DialogInterface$OnDismissListenerC0823b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16519e;

        public DialogInterface$OnDismissListenerC0823b(b bVar) {
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
            this.f16519e = bVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f16519e.h();
            }
        }
    }

    public b(TbPageContext<?> tbPageContext, b.a.r0.b4.b bVar, Intent intent) {
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
        this.f16516c = tbPageContext;
        this.f16515b = bVar;
        b.a.r0.b4.c.b bVar2 = new b.a.r0.b4.c.b();
        this.f16514a = bVar2;
        bVar2.b(intent);
        this.f16514a.e(tbPageContext.getUniqueId());
    }

    @Override // b.a.r0.b4.d.a
    public void a() {
        b.a.r0.b4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f16515b) == null) {
            return;
        }
        bVar.showErrorView();
    }

    @Override // b.a.r0.b4.d.a
    public void b() {
        b.a.r0.b4.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f16514a) == null) {
            return;
        }
        b.a.q0.s.e0.b.j().t(b.a.q0.s.e0.b.n(aVar.c()), false);
    }

    @Override // b.a.r0.b4.d.a
    public void c() {
        b.a.r0.b4.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f16514a) == null || this.f16515b == null) {
            return;
        }
        this.f16515b.rePlayVideo(aVar.getVideoUrl());
    }

    @Override // b.a.r0.b4.d.a
    public void d() {
        b.a.r0.b4.b bVar;
        b.a.r0.b4.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.f16515b) == null || (aVar = this.f16514a) == null) {
            return;
        }
        bVar.showDialog(aVar.a(), this.f16514a.g());
    }

    @Override // b.a.r0.b4.d.a
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f16516c == null) {
            return;
        }
        if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.f16516c.getPageActivity())) {
            i();
        }
    }

    public final void h() {
        b.a.r0.b4.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.f16514a) == null || this.f16515b == null) {
            return;
        }
        this.f16515b.startPlayVideo(aVar.getVideoUrl());
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f16514a == null || this.f16516c == null) {
            return;
        }
        ShareItem shareItem = new ShareItem();
        shareItem.r = this.f16514a.d();
        shareItem.s = this.f16514a.i();
        shareItem.t = this.f16514a.f();
        shareItem.u = this.f16514a.f();
        if (!k.isEmpty(this.f16514a.h())) {
            shareItem.v = Uri.parse(this.f16514a.h());
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.f16516c.getPageActivity(), shareItem, true, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
        shareDialogConfig.setOnDismissListener(new DialogInterface$OnDismissListenerC0823b(this));
        this.f16516c.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    @Override // b.a.r0.b4.d.a
    public void onClose() {
        b.a.r0.b4.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bVar = this.f16515b) == null) {
            return;
        }
        bVar.finishActivity();
    }

    @Override // b.a.r0.b4.d.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // b.a.r0.b4.d.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // b.a.r0.b4.d.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h();
        }
    }
}

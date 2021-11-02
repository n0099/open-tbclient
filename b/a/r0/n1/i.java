package b.a.r0.n1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.k;
import b.a.e.e.p.l;
import b.a.q0.s.s.a;
import b.a.q0.s.s.i;
import b.a.r0.l3.j0.r;
import b.a.r0.t3.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StorageFile;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.image.ImageViewerActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class i implements ImageViewerBottomLayout.c, ImageViewerBottomLayout.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ImageViewerActivity f21322a;

    /* renamed from: b  reason: collision with root package name */
    public MultiImageView f21323b;

    /* renamed from: c  reason: collision with root package name */
    public PermissionJudgePolicy f21324c;

    /* renamed from: d  reason: collision with root package name */
    public j f21325d;

    /* renamed from: e  reason: collision with root package name */
    public String f21326e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.t3.c f21327f;

    /* renamed from: g  reason: collision with root package name */
    public PopupDialog f21328g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.q0.s.s.i f21329h;

    /* renamed from: i  reason: collision with root package name */
    public List<b.a.q0.s.s.f> f21330i;
    public b.a.q0.s.s.f j;
    public b.a.q0.s.s.f k;
    public b.a.q0.s.s.f l;
    public b.a.q0.s.s.f m;
    public b.a.q0.s.s.f n;
    public b.a.q0.s.s.f o;
    public b.a.r0.n1.f p;
    public CustomMessageListener q;
    public i.d r;
    public i.d s;
    public i.d t;
    public i.d u;
    public i.d v;
    public i.d w;
    public View.OnClickListener x;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f21331a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21331a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            r rVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof r) || this.f21331a.f21322a.isFinishing() || (rVar = (r) customResponsedMessage.getData()) == null) {
                return;
            }
            rVar.f20645c = null;
            if (TextUtils.isEmpty(rVar.f20647e) || TextUtils.isEmpty(rVar.f20644b) || !rVar.f20644b.equals(this.f21331a.f21326e)) {
                return;
            }
            this.f21331a.f21323b.setCurrentImageQRInfo(rVar.f20647e);
            this.f21331a.s(rVar.f20647e);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f21332a;

        public b(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21332a = iVar;
        }

        @Override // b.a.q0.s.s.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21332a.u();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f21333a;

        public c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21333a = iVar;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21333a.f21323b.downloadOriginImgAtIndex(this.f21333a.f21322a.calCurrentIndex());
                this.f21333a.u();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f21334a;

        public d(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21334a = iVar;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.r0.n1.d.a(this.f21334a.f21322a.getPageContext().getPageActivity(), this.f21334a.f21323b.getCurrentImageUrl());
                this.f21334a.u();
                this.f21334a.r(1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f21335a;

        public e(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21335a = iVar;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String currentImageUrl = this.f21335a.f21323b.getCurrentImageUrl();
                if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
                } else {
                    Intent intent = new Intent(b.a.q0.c0.d.f11980a);
                    intent.putExtra(b.a.q0.c0.d.f11981b, currentImageUrl);
                    TbadkCoreApplication.getInst().sendBroadcast(intent);
                }
                this.f21335a.u();
                this.f21335a.r(2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f21336a;

        public f(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21336a = iVar;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Activity pageActivity = this.f21336a.f21322a.getPageContext().getPageActivity();
                if (this.f21336a.f21324c == null) {
                    this.f21336a.f21324c = new PermissionJudgePolicy();
                }
                this.f21336a.f21324c.clearRequestPermissionList();
                this.f21336a.f21324c.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (this.f21336a.f21324c.startRequestPermission(pageActivity)) {
                    return;
                }
                this.f21336a.C();
                this.f21336a.u();
                this.f21336a.r(3);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f21337a;

        public g(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21337a = iVar;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21337a.y();
                this.f21337a.u();
                this.f21337a.r(4);
                this.f21337a.q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f21338a;

        /* loaded from: classes5.dex */
        public class a implements c.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f21339a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f21340b;

            /* renamed from: b.a.r0.n1.i$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C1047a implements a.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f21341e;

                public C1047a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f21341e = aVar;
                }

                @Override // b.a.q0.s.s.a.e
                public void onClick(b.a.q0.s.s.a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                        aVar.dismiss();
                        a aVar2 = this.f21341e;
                        aVar2.f21340b.f21338a.z(aVar2.f21339a);
                    }
                }
            }

            /* loaded from: classes5.dex */
            public class b implements a.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public b(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // b.a.q0.s.s.a.e
                public void onClick(b.a.q0.s.s.a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                        aVar.dismiss();
                    }
                }
            }

            /* loaded from: classes5.dex */
            public class c implements a.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public c(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // b.a.q0.s.s.a.e
                public void onClick(b.a.q0.s.s.a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                        aVar.dismiss();
                    }
                }
            }

            public a(h hVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21340b = hVar;
                this.f21339a = str;
            }

            @Override // b.a.r0.t3.c.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f21340b.f21338a.f21322a.getPageContext().getPageActivity());
                    aVar.setTitle((String) null);
                    aVar.setMessageShowCenter(true);
                    aVar.setMessage(this.f21340b.f21338a.t(R.string.qr_url_risk_forbid));
                    aVar.setPositiveButton(this.f21340b.f21338a.t(R.string.qr_url_risk_forbid_button), new c(this));
                    aVar.setCancelable(false);
                    aVar.setCanceledOnTouchOutside(false);
                    aVar.create(this.f21340b.f21338a.f21322a.getPageContext()).show();
                }
            }

            @Override // b.a.r0.t3.c.a
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f21340b.f21338a.f21322a.getPageContext().getPageActivity());
                    aVar.setTitleShowCenter(true);
                    aVar.setTitle(this.f21340b.f21338a.t(R.string.qr_url_jump_external_title));
                    aVar.setMessageShowCenter(true);
                    aVar.setMessage(this.f21340b.f21338a.t(R.string.qr_url_jump_external_message));
                    aVar.setPositiveButton(this.f21340b.f21338a.t(R.string.confirm), new C1047a(this));
                    aVar.setNegativeButton(this.f21340b.f21338a.t(R.string.cancel), new b(this));
                    aVar.setCancelable(false);
                    aVar.setCanceledOnTouchOutside(false);
                    aVar.create(this.f21340b.f21338a.f21322a.getPageContext()).show();
                }
            }

            @Override // b.a.r0.t3.c.a
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f21340b.f21338a.z(this.f21339a);
                }
            }

            @Override // b.a.r0.t3.c.a
            public void onError(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                    l.M(this.f21340b.f21338a.f21322a.getPageContext().getPageActivity(), this.f21340b.f21338a.t(R.string.qr_scan_error));
                }
            }
        }

        public h(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21338a = iVar;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String currentImageQRInfo = this.f21338a.f21323b.getCurrentImageQRInfo();
                if (TextUtils.isEmpty(currentImageQRInfo) || "qr_none".equals(currentImageQRInfo)) {
                    return;
                }
                if (!l.D()) {
                    l.M(this.f21338a.f21322a.getPageContext().getPageActivity(), this.f21338a.t(R.string.network_not_available));
                    return;
                }
                if (this.f21338a.f21327f != null && !this.f21338a.f21327f.isCancelled()) {
                    this.f21338a.f21327f.cancel();
                }
                this.f21338a.f21327f = new b.a.r0.t3.c(currentImageQRInfo, new a(this, currentImageQRInfo));
                this.f21338a.f21327f.setPriority(3);
                this.f21338a.f21327f.execute(new String[0]);
                this.f21338a.u();
                this.f21338a.r(5);
            }
        }
    }

    /* renamed from: b.a.r0.n1.i$i  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1048i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f21342e;

        public View$OnClickListenerC1048i(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21342e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlDragImageView currentUrlDragImageView;
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21342e.f21323b == null || (currentUrlDragImageView = this.f21342e.f21323b.getCurrentUrlDragImageView()) == null) {
                return;
            }
            ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
            String str2 = "";
            if (imageUrlData != null) {
                str2 = imageUrlData.imageUrl;
                str = BigImageLoaderProc.getNameMd5FromUrl(str2);
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f21342e.f21323b.getCurrentImageUrl();
                str = TbMd5.getNameMd5FromUrl(str2);
            }
            ShareItem shareItem = new ShareItem();
            if (imageUrlData != null) {
                long j = imageUrlData.threadId;
                if (j > 0) {
                    shareItem.t = "http://tieba.baidu.com/p/" + j + "?fr=share";
                }
            }
            if (!k.isEmpty(str2)) {
                shareItem.v = Uri.parse(str2);
                shareItem.Z = 2;
                shareItem.r = this.f21342e.t(R.string.save_to_emotion);
                shareItem.s = this.f21342e.t(R.string.save_to_emotion);
                shareItem.w = str2;
                Bundle bundle = new Bundle();
                bundle.putString("path", "images");
                bundle.putString("name", str);
                bundle.putBoolean("formatData", true);
                bundle.putBoolean("isSubDir", true);
                bundle.putBoolean("isSdcard", false);
                bundle.putBoolean("isSavedCache", true);
                shareItem.A = bundle;
            }
            new Bundle().putInt("obj_locate", 13);
            new b.a.q0.t.g.g(this.f21342e.f21322a, null).m(shareItem);
        }
    }

    /* loaded from: classes5.dex */
    public class j extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f21343a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f21344b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f21345c;

        public j(i iVar, String str, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21345c = iVar;
            this.f21343a = str;
            this.f21344b = bArr;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21345c.f21325d = null;
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            byte[] bArr;
            String nameMd5FromUrl;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                Map<String, ImageUrlData> assistUrls = this.f21345c.f21322a.getAssistUrls();
                if (this.f21343a != null && assistUrls != null) {
                    ImageUrlData imageUrlData = null;
                    Iterator<Map.Entry<String, ImageUrlData>> it = assistUrls.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<String, ImageUrlData> next = it.next();
                        if (next != null && next.getKey() != null && next.getValue() != null && next.getKey().contains(this.f21343a)) {
                            imageUrlData = next.getValue();
                            break;
                        }
                    }
                    if (imageUrlData != null) {
                        String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + StorageFile.getInstance().getDirectoryName(nameMd5FromUrl) + "/" + TbMd5.getNameMd5FromUrl(imageUrlData.originalUrl);
                        int[] imageFileWH = FileHelper.getImageFileWH(str);
                        if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && FileHelper.copyImageFile(str, this.f21343a, this.f21345c.f21322a.getPageContext().getPageActivity()) == 0) {
                            return this.f21345c.f21322a.getPageContext().getString(R.string.save_image_to_album);
                        }
                    }
                }
                String str2 = this.f21343a;
                if (str2 != null && (bArr = this.f21344b) != null) {
                    int saveImageFileByUser = FileHelper.saveImageFileByUser(str2, bArr, this.f21345c.f21322a.getPageContext().getPageActivity());
                    if (saveImageFileByUser == -2) {
                        return FileHelper.getSdErrorString();
                    }
                    if (saveImageFileByUser == 0) {
                        return this.f21345c.t(R.string.save_image_to_album);
                    }
                }
                return this.f21345c.t(R.string.save_fail);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((j) str);
                if (!b.a.q0.b.d.y() || this.f21345c.t(R.string.save_fail).equals(str)) {
                    this.f21345c.f21322a.showToast(str);
                } else if (this.f21345c.p != null) {
                    this.f21345c.p.g(this.f21345c.f21323b, this.f21345c.f21323b.getBottomHeight(), this.f21345c.x);
                }
                this.f21345c.f21325d = null;
            }
        }
    }

    public i(@Nullable ImageViewerActivity imageViewerActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageViewerActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21326e = null;
        this.f21330i = null;
        this.q = new a(this, 2921403);
        this.r = new c(this);
        this.s = new d(this);
        this.t = new e(this);
        this.u = new f(this);
        this.v = new g(this);
        this.w = new h(this);
        this.x = new View$OnClickListenerC1048i(this);
        this.f21322a = imageViewerActivity;
        imageViewerActivity.registerListener(this.q);
        this.p = new b.a.r0.n1.f(imageViewerActivity);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j jVar = this.f21325d;
            if (jVar != null) {
                jVar.cancel();
                this.f21325d = null;
            }
            b.a.r0.t3.c cVar = this.f21327f;
            if (cVar != null) {
                cVar.cancel();
                this.f21327f = null;
            }
            b.a.r0.n1.f fVar = this.p;
            if (fVar != null) {
                fVar.f();
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f21326e = null;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                j jVar = new j(this, this.f21323b.getCurrentImageUrl(), this.f21323b.getCurrentImageData());
                this.f21325d = jVar;
                jVar.execute(new String[0]);
                if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.f21322a.getFrom())) {
                    TiebaStatic.log("c12173");
                }
            } catch (Exception unused) {
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f21330i.clear();
            String checkOriginImgStringAtIndex = this.f21323b.getCheckOriginImgStringAtIndex(this.f21322a.calCurrentIndex());
            if (checkOriginImgStringAtIndex != null) {
                b.a.q0.s.s.f fVar = new b.a.q0.s.s.f(checkOriginImgStringAtIndex, this.f21329h);
                this.j = fVar;
                fVar.l(this.r);
                this.f21330i.add(this.j);
            }
            b.a.q0.s.s.f fVar2 = new b.a.q0.s.s.f(t(R.string.save_to_local), this.f21329h);
            this.l = fVar2;
            fVar2.l(this.u);
            this.f21330i.add(this.l);
            ImageViewerActivity imageViewerActivity = this.f21322a;
            if (imageViewerActivity != null && !imageViewerActivity.isIsBJHThread()) {
                b.a.q0.s.s.f fVar3 = new b.a.q0.s.s.f(t(R.string.save_to_emotion), this.f21329h);
                this.m = fVar3;
                fVar3.l(this.t);
                this.f21330i.add(this.m);
            }
            b.a.q0.s.s.f fVar4 = new b.a.q0.s.s.f(t(R.string.identify_image), this.f21329h);
            this.k = fVar4;
            fVar4.l(this.s);
            this.f21330i.add(this.k);
            String currentImageQRInfo = this.f21323b.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
                b.a.q0.s.s.f fVar5 = new b.a.q0.s.s.f(t(R.string.image_qr_code), this.f21329h);
                this.o = fVar5;
                fVar5.l(this.w);
                this.f21330i.add(this.o);
            }
            b.a.q0.s.s.f fVar6 = new b.a.q0.s.s.f(t(R.string.image_share), this.f21329h);
            this.n = fVar6;
            fVar6.l(this.v);
            this.f21330i.add(this.n);
            this.f21329h.l(new b(this));
            this.f21329h.j(this.f21330i);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f21328g == null || this.f21322a.isFinishing()) {
            return;
        }
        this.f21328g.showDialog();
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String currentImageUrl = this.f21323b.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
            } else if (FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f21322a.getPageContext(), null)) {
                return;
            } else {
                Intent intent = new Intent(b.a.q0.c0.d.f11980a);
                intent.putExtra(b.a.q0.c0.d.f11981b, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            r(2);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void onSave() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Activity pageActivity = this.f21322a.getPageContext().getPageActivity();
            if (this.f21324c == null) {
                this.f21324c = new PermissionJudgePolicy();
            }
            this.f21324c.clearRequestPermissionList();
            this.f21324c.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.f21324c.startRequestPermission(pageActivity)) {
                return;
            }
            C();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public final void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c13270").param("uid", this.f21322a.getUserId()).param("obj_type", i2));
            int i3 = i2 == 1 ? 22 : i2 == 2 ? 21 : i2 == 3 ? 20 : 0;
            if (i3 != 0) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i3));
            }
        }
    }

    public void s(String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || this.f21328g == null || this.f21322a.isFinishing() || !this.f21328g.isShowing() || TextUtils.isEmpty(str) || "qr_none".equals(str)) {
            return;
        }
        b.a.q0.s.s.f fVar = new b.a.q0.s.s.f(t(R.string.image_qr_code), this.f21329h);
        this.o = fVar;
        fVar.l(this.w);
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 < this.f21330i.size()) {
                if (this.k != null && this.f21330i.get(i3) == this.k && (i2 = i3 + 1) <= this.f21330i.size()) {
                    this.f21330i.add(i2, this.o);
                    z = true;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        if (!z) {
            this.f21330i.add(this.o);
        }
        this.f21329h.j(this.f21330i);
    }

    public final String t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? this.f21322a.getString(i2) : (String) invokeI.objValue;
    }

    public void u() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (popupDialog = this.f21328g) != null && popupDialog.isShowing()) {
            this.f21328g.dismiss();
        }
    }

    public void v(@Nullable MultiImageView multiImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, multiImageView) == null) {
            this.f21323b = multiImageView;
            if (this.f21328g == null) {
                this.f21329h = new b.a.q0.s.s.i(this.f21322a);
            }
            if (this.f21330i == null) {
                this.f21330i = new ArrayList();
            }
            D();
            this.f21328g = new PopupDialog(this.f21322a.getPageContext(), this.f21329h);
        }
    }

    public void w(View view) {
        Bitmap imageBitmap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, view) == null) && view != null && (view instanceof DragImageView)) {
            DragImageView dragImageView = (DragImageView) view;
            ImageUrlData imageUrlData = dragImageView.getImageUrlData();
            if ((imageUrlData != null && !TextUtils.isEmpty(imageUrlData.qrInfo)) || (imageBitmap = dragImageView.getImageBitmap()) == null || imageBitmap.isRecycled()) {
                return;
            }
            r rVar = new r();
            rVar.f20643a = 0;
            rVar.f20645c = imageBitmap;
            String currentImageUrl = this.f21323b.getCurrentImageUrl();
            if (!TextUtils.isEmpty(currentImageUrl)) {
                rVar.f20644b = String.valueOf(System.currentTimeMillis()) + TbMd5.getNameMd5FromUrl(currentImageUrl);
            } else {
                rVar.f20644b = String.valueOf(BdUniqueId.gen().getId());
            }
            this.f21326e = rVar.f20644b;
            this.f21322a.sendMessage(new CustomMessage(2921403, rVar));
        }
    }

    public void x() {
        b.a.q0.s.s.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (iVar = this.f21329h) == null) {
            return;
        }
        iVar.i();
    }

    public void y() {
        MultiImageView multiImageView;
        UrlDragImageView currentUrlDragImageView;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (multiImageView = this.f21323b) == null || (currentUrlDragImageView = multiImageView.getCurrentUrlDragImageView()) == null) {
            return;
        }
        ImageUrlData imageUrlData = currentUrlDragImageView.getmAssistUrlData();
        String str2 = "";
        if (imageUrlData != null) {
            str2 = imageUrlData.imageUrl;
            str = BigImageLoaderProc.getNameMd5FromUrl(str2);
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.f21323b.getCurrentImageUrl();
            str = TbMd5.getNameMd5FromUrl(str2);
        }
        ShareItem shareItem = new ShareItem();
        if (imageUrlData != null) {
            long j2 = imageUrlData.threadId;
            if (j2 > 0) {
                shareItem.t = "http://tieba.baidu.com/p/" + j2 + "?fr=share";
            }
        }
        boolean z = false;
        if (!k.isEmpty(str2)) {
            shareItem.v = Uri.parse(str2);
            shareItem.Z = 1;
            Bundle bundle = new Bundle();
            bundle.putString("path", "images");
            bundle.putString("name", str);
            bundle.putBoolean("formatData", true);
            bundle.putBoolean("isSubDir", true);
            bundle.putBoolean("isSdcard", false);
            bundle.putBoolean("isSavedCache", true);
            shareItem.A = bundle;
        }
        shareItem.j = true;
        shareItem.E = 23;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f21322a, shareItem, false);
        if (b.a.q0.b.d.x()) {
            shareDialogConfig.isImageViewerDialog = true;
            shareDialogConfig.originImgText = this.f21323b.getCheckOriginImgStringAtIndex(this.f21322a.calCurrentIndex());
            ImageViewerActivity imageViewerActivity = this.f21322a;
            shareDialogConfig.showAddEmotion = (imageViewerActivity == null || imageViewerActivity.isIsBJHThread()) ? false : true;
            String currentImageQRInfo = this.f21323b.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
                z = true;
            }
            shareDialogConfig.showQRCode = z;
            shareDialogConfig.dialogSaveToDiskListener = this.u;
            shareDialogConfig.dialogAddToExpressionListener = this.t;
            shareDialogConfig.dialogDownloadOriginListener = this.r;
            shareDialogConfig.dialogRecognizePicListener = this.s;
            shareDialogConfig.qrCodeClickListener = this.w;
            shareDialogConfig.onWeChatEmotionShareListener = this.x;
        }
        this.f21322a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f21322a.getPageContext().getPageActivity(), null, str, false)));
        }
    }
}

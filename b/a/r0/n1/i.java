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
import b.a.e.f.p.k;
import b.a.e.f.p.l;
import b.a.q0.s.s.a;
import b.a.q0.s.s.i;
import b.a.r0.m3.j0.r;
import b.a.r0.u3.c;
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
    public final ImageViewerActivity f22818a;

    /* renamed from: b  reason: collision with root package name */
    public MultiImageView f22819b;

    /* renamed from: c  reason: collision with root package name */
    public PermissionJudgePolicy f22820c;

    /* renamed from: d  reason: collision with root package name */
    public j f22821d;

    /* renamed from: e  reason: collision with root package name */
    public String f22822e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.u3.c f22823f;

    /* renamed from: g  reason: collision with root package name */
    public PopupDialog f22824g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.q0.s.s.i f22825h;

    /* renamed from: i  reason: collision with root package name */
    public List<b.a.q0.s.s.f> f22826i;
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
        public final /* synthetic */ i f22827a;

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
            this.f22827a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            r rVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof r) || this.f22827a.f22818a.isFinishing() || (rVar = (r) customResponsedMessage.getData()) == null) {
                return;
            }
            rVar.f22495c = null;
            if (TextUtils.isEmpty(rVar.f22497e) || TextUtils.isEmpty(rVar.f22494b) || !rVar.f22494b.equals(this.f22827a.f22822e)) {
                return;
            }
            this.f22827a.f22819b.setCurrentImageQRInfo(rVar.f22497e);
            this.f22827a.s(rVar.f22497e);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22828a;

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
            this.f22828a = iVar;
        }

        @Override // b.a.q0.s.s.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22828a.u();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22829a;

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
            this.f22829a = iVar;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22829a.f22819b.downloadOriginImgAtIndex(this.f22829a.f22818a.calCurrentIndex());
                this.f22829a.u();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22830a;

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
            this.f22830a = iVar;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.r0.n1.d.a(this.f22830a.f22818a.getPageContext().getPageActivity(), this.f22830a.f22819b.getCurrentImageUrl());
                this.f22830a.u();
                this.f22830a.r(1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22831a;

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
            this.f22831a = iVar;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String currentImageUrl = this.f22831a.f22819b.getCurrentImageUrl();
                if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
                } else {
                    Intent intent = new Intent(b.a.q0.c0.d.f12734a);
                    intent.putExtra(b.a.q0.c0.d.f12735b, currentImageUrl);
                    TbadkCoreApplication.getInst().sendBroadcast(intent);
                }
                this.f22831a.u();
                this.f22831a.r(2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22832a;

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
            this.f22832a = iVar;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Activity pageActivity = this.f22832a.f22818a.getPageContext().getPageActivity();
                if (this.f22832a.f22820c == null) {
                    this.f22832a.f22820c = new PermissionJudgePolicy();
                }
                this.f22832a.f22820c.clearRequestPermissionList();
                this.f22832a.f22820c.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (this.f22832a.f22820c.startRequestPermission(pageActivity)) {
                    return;
                }
                this.f22832a.C();
                this.f22832a.u();
                this.f22832a.r(3);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22833a;

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
            this.f22833a = iVar;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22833a.y();
                this.f22833a.u();
                this.f22833a.r(4);
                this.f22833a.q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22834a;

        /* loaded from: classes5.dex */
        public class a implements c.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f22835a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f22836b;

            /* renamed from: b.a.r0.n1.i$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C1111a implements a.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f22837e;

                public C1111a(a aVar) {
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
                    this.f22837e = aVar;
                }

                @Override // b.a.q0.s.s.a.e
                public void onClick(b.a.q0.s.s.a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                        aVar.dismiss();
                        a aVar2 = this.f22837e;
                        aVar2.f22836b.f22834a.z(aVar2.f22835a);
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
                this.f22836b = hVar;
                this.f22835a = str;
            }

            @Override // b.a.r0.u3.c.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f22836b.f22834a.f22818a.getPageContext().getPageActivity());
                    aVar.setTitle((String) null);
                    aVar.setMessageShowCenter(true);
                    aVar.setMessage(this.f22836b.f22834a.t(R.string.qr_url_risk_forbid));
                    aVar.setPositiveButton(this.f22836b.f22834a.t(R.string.qr_url_risk_forbid_button), new c(this));
                    aVar.setCancelable(false);
                    aVar.setCanceledOnTouchOutside(false);
                    aVar.create(this.f22836b.f22834a.f22818a.getPageContext()).show();
                }
            }

            @Override // b.a.r0.u3.c.a
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f22836b.f22834a.f22818a.getPageContext().getPageActivity());
                    aVar.setTitleShowCenter(true);
                    aVar.setTitle(this.f22836b.f22834a.t(R.string.qr_url_jump_external_title));
                    aVar.setMessageShowCenter(true);
                    aVar.setMessage(this.f22836b.f22834a.t(R.string.qr_url_jump_external_message));
                    aVar.setPositiveButton(this.f22836b.f22834a.t(R.string.confirm), new C1111a(this));
                    aVar.setNegativeButton(this.f22836b.f22834a.t(R.string.cancel), new b(this));
                    aVar.setCancelable(false);
                    aVar.setCanceledOnTouchOutside(false);
                    aVar.create(this.f22836b.f22834a.f22818a.getPageContext()).show();
                }
            }

            @Override // b.a.r0.u3.c.a
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f22836b.f22834a.z(this.f22835a);
                }
            }

            @Override // b.a.r0.u3.c.a
            public void onError(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                    l.M(this.f22836b.f22834a.f22818a.getPageContext().getPageActivity(), this.f22836b.f22834a.t(R.string.qr_scan_error));
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
            this.f22834a = iVar;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String currentImageQRInfo = this.f22834a.f22819b.getCurrentImageQRInfo();
                if (TextUtils.isEmpty(currentImageQRInfo) || "qr_none".equals(currentImageQRInfo)) {
                    return;
                }
                if (!l.D()) {
                    l.M(this.f22834a.f22818a.getPageContext().getPageActivity(), this.f22834a.t(R.string.network_not_available));
                    return;
                }
                if (this.f22834a.f22823f != null && !this.f22834a.f22823f.isCancelled()) {
                    this.f22834a.f22823f.cancel();
                }
                this.f22834a.f22823f = new b.a.r0.u3.c(currentImageQRInfo, new a(this, currentImageQRInfo));
                this.f22834a.f22823f.setPriority(3);
                this.f22834a.f22823f.execute(new String[0]);
                this.f22834a.u();
                this.f22834a.r(5);
            }
        }
    }

    /* renamed from: b.a.r0.n1.i$i  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1112i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f22838e;

        public View$OnClickListenerC1112i(i iVar) {
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
            this.f22838e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlDragImageView currentUrlDragImageView;
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22838e.f22819b == null || (currentUrlDragImageView = this.f22838e.f22819b.getCurrentUrlDragImageView()) == null) {
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
                str2 = this.f22838e.f22819b.getCurrentImageUrl();
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
                shareItem.r = this.f22838e.t(R.string.save_to_emotion);
                shareItem.s = this.f22838e.t(R.string.save_to_emotion);
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
            new b.a.q0.t.g.g(this.f22838e.f22818a, null).m(shareItem);
        }
    }

    /* loaded from: classes5.dex */
    public class j extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f22839a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f22840b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f22841c;

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
            this.f22841c = iVar;
            this.f22839a = str;
            this.f22840b = bArr;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22841c.f22821d = null;
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
                Map<String, ImageUrlData> assistUrls = this.f22841c.f22818a.getAssistUrls();
                if (this.f22839a != null && assistUrls != null) {
                    ImageUrlData imageUrlData = null;
                    Iterator<Map.Entry<String, ImageUrlData>> it = assistUrls.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<String, ImageUrlData> next = it.next();
                        if (next != null && next.getKey() != null && next.getValue() != null && next.getKey().contains(this.f22839a)) {
                            imageUrlData = next.getValue();
                            break;
                        }
                    }
                    if (imageUrlData != null) {
                        String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + StorageFile.getInstance().getDirectoryName(nameMd5FromUrl) + "/" + TbMd5.getNameMd5FromUrl(imageUrlData.originalUrl);
                        int[] imageFileWH = FileHelper.getImageFileWH(str);
                        if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && FileHelper.copyImageFile(str, this.f22839a, this.f22841c.f22818a.getPageContext().getPageActivity()) == 0) {
                            return this.f22841c.f22818a.getPageContext().getString(R.string.save_image_to_album);
                        }
                    }
                }
                String str2 = this.f22839a;
                if (str2 != null && (bArr = this.f22840b) != null) {
                    int saveImageFileByUser = FileHelper.saveImageFileByUser(str2, bArr, this.f22841c.f22818a.getPageContext().getPageActivity());
                    if (saveImageFileByUser == -2) {
                        return FileHelper.getSdErrorString();
                    }
                    if (saveImageFileByUser == 0) {
                        return this.f22841c.t(R.string.save_image_to_album);
                    }
                }
                return this.f22841c.t(R.string.save_fail);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((j) str);
                if (!b.a.q0.b.d.y() || this.f22841c.t(R.string.save_fail).equals(str)) {
                    this.f22841c.f22818a.showToast(str);
                } else if (this.f22841c.p != null) {
                    this.f22841c.p.g(this.f22841c.f22819b, this.f22841c.f22819b.getBottomHeight(), this.f22841c.x);
                }
                this.f22841c.f22821d = null;
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
        this.f22822e = null;
        this.f22826i = null;
        this.q = new a(this, 2921403);
        this.r = new c(this);
        this.s = new d(this);
        this.t = new e(this);
        this.u = new f(this);
        this.v = new g(this);
        this.w = new h(this);
        this.x = new View$OnClickListenerC1112i(this);
        this.f22818a = imageViewerActivity;
        imageViewerActivity.registerListener(this.q);
        this.p = new b.a.r0.n1.f(imageViewerActivity);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j jVar = this.f22821d;
            if (jVar != null) {
                jVar.cancel();
                this.f22821d = null;
            }
            b.a.r0.u3.c cVar = this.f22823f;
            if (cVar != null) {
                cVar.cancel();
                this.f22823f = null;
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
            this.f22822e = null;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                j jVar = new j(this, this.f22819b.getCurrentImageUrl(), this.f22819b.getCurrentImageData());
                this.f22821d = jVar;
                jVar.execute(new String[0]);
                if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.f22818a.getFrom())) {
                    TiebaStatic.log("c12173");
                }
            } catch (Exception unused) {
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f22826i.clear();
            String checkOriginImgStringAtIndex = this.f22819b.getCheckOriginImgStringAtIndex(this.f22818a.calCurrentIndex());
            if (checkOriginImgStringAtIndex != null) {
                b.a.q0.s.s.f fVar = new b.a.q0.s.s.f(checkOriginImgStringAtIndex, this.f22825h);
                this.j = fVar;
                fVar.l(this.r);
                this.f22826i.add(this.j);
            }
            b.a.q0.s.s.f fVar2 = new b.a.q0.s.s.f(t(R.string.save_to_local), this.f22825h);
            this.l = fVar2;
            fVar2.l(this.u);
            this.f22826i.add(this.l);
            ImageViewerActivity imageViewerActivity = this.f22818a;
            if (imageViewerActivity != null && !imageViewerActivity.isIsBJHThread()) {
                b.a.q0.s.s.f fVar3 = new b.a.q0.s.s.f(t(R.string.save_to_emotion), this.f22825h);
                this.m = fVar3;
                fVar3.l(this.t);
                this.f22826i.add(this.m);
            }
            b.a.q0.s.s.f fVar4 = new b.a.q0.s.s.f(t(R.string.identify_image), this.f22825h);
            this.k = fVar4;
            fVar4.l(this.s);
            this.f22826i.add(this.k);
            String currentImageQRInfo = this.f22819b.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
                b.a.q0.s.s.f fVar5 = new b.a.q0.s.s.f(t(R.string.image_qr_code), this.f22825h);
                this.o = fVar5;
                fVar5.l(this.w);
                this.f22826i.add(this.o);
            }
            b.a.q0.s.s.f fVar6 = new b.a.q0.s.s.f(t(R.string.image_share), this.f22825h);
            this.n = fVar6;
            fVar6.l(this.v);
            this.f22826i.add(this.n);
            this.f22825h.l(new b(this));
            this.f22825h.j(this.f22826i);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f22824g == null || this.f22818a.isFinishing()) {
            return;
        }
        this.f22824g.showDialog();
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String currentImageUrl = this.f22819b.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
            } else if (FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f22818a.getPageContext(), null)) {
                return;
            } else {
                Intent intent = new Intent(b.a.q0.c0.d.f12734a);
                intent.putExtra(b.a.q0.c0.d.f12735b, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            r(2);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void onSave() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Activity pageActivity = this.f22818a.getPageContext().getPageActivity();
            if (this.f22820c == null) {
                this.f22820c = new PermissionJudgePolicy();
            }
            this.f22820c.clearRequestPermissionList();
            this.f22820c.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.f22820c.startRequestPermission(pageActivity)) {
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
            TiebaStatic.log(new StatisticItem("c13270").param("uid", this.f22818a.getUserId()).param("obj_type", i2));
            int i3 = i2 == 1 ? 22 : i2 == 2 ? 21 : i2 == 3 ? 20 : 0;
            if (i3 != 0) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i3));
            }
        }
    }

    public void s(String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || this.f22824g == null || this.f22818a.isFinishing() || !this.f22824g.isShowing() || TextUtils.isEmpty(str) || "qr_none".equals(str)) {
            return;
        }
        b.a.q0.s.s.f fVar = new b.a.q0.s.s.f(t(R.string.image_qr_code), this.f22825h);
        this.o = fVar;
        fVar.l(this.w);
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 < this.f22826i.size()) {
                if (this.k != null && this.f22826i.get(i3) == this.k && (i2 = i3 + 1) <= this.f22826i.size()) {
                    this.f22826i.add(i2, this.o);
                    z = true;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        if (!z) {
            this.f22826i.add(this.o);
        }
        this.f22825h.j(this.f22826i);
    }

    public final String t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? this.f22818a.getString(i2) : (String) invokeI.objValue;
    }

    public void u() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (popupDialog = this.f22824g) != null && popupDialog.isShowing()) {
            this.f22824g.dismiss();
        }
    }

    public void v(@Nullable MultiImageView multiImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, multiImageView) == null) {
            this.f22819b = multiImageView;
            if (this.f22824g == null) {
                this.f22825h = new b.a.q0.s.s.i(this.f22818a);
            }
            if (this.f22826i == null) {
                this.f22826i = new ArrayList();
            }
            D();
            this.f22824g = new PopupDialog(this.f22818a.getPageContext(), this.f22825h);
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
            rVar.f22493a = 0;
            rVar.f22495c = imageBitmap;
            String currentImageUrl = this.f22819b.getCurrentImageUrl();
            if (!TextUtils.isEmpty(currentImageUrl)) {
                rVar.f22494b = String.valueOf(System.currentTimeMillis()) + TbMd5.getNameMd5FromUrl(currentImageUrl);
            } else {
                rVar.f22494b = String.valueOf(BdUniqueId.gen().getId());
            }
            this.f22822e = rVar.f22494b;
            this.f22818a.sendMessage(new CustomMessage(2921403, rVar));
        }
    }

    public void x() {
        b.a.q0.s.s.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (iVar = this.f22825h) == null) {
            return;
        }
        iVar.i();
    }

    public void y() {
        MultiImageView multiImageView;
        UrlDragImageView currentUrlDragImageView;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (multiImageView = this.f22819b) == null || (currentUrlDragImageView = multiImageView.getCurrentUrlDragImageView()) == null) {
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
            str2 = this.f22819b.getCurrentImageUrl();
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
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f22818a, shareItem, false);
        if (b.a.q0.b.d.x()) {
            shareDialogConfig.isImageViewerDialog = true;
            shareDialogConfig.originImgText = this.f22819b.getCheckOriginImgStringAtIndex(this.f22818a.calCurrentIndex());
            ImageViewerActivity imageViewerActivity = this.f22818a;
            shareDialogConfig.showAddEmotion = (imageViewerActivity == null || imageViewerActivity.isIsBJHThread()) ? false : true;
            String currentImageQRInfo = this.f22819b.getCurrentImageQRInfo();
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
        this.f22818a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f22818a.getPageContext().getPageActivity(), null, str, false)));
        }
    }
}

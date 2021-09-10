package c.a.r0.m1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.s.s.a;
import c.a.q0.s.s.i;
import c.a.r0.j3.i0.r;
import c.a.r0.r3.c;
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
/* loaded from: classes3.dex */
public class i implements ImageViewerBottomLayout.c, ImageViewerBottomLayout.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ImageViewerActivity f22237a;

    /* renamed from: b  reason: collision with root package name */
    public MultiImageView f22238b;

    /* renamed from: c  reason: collision with root package name */
    public PermissionJudgePolicy f22239c;

    /* renamed from: d  reason: collision with root package name */
    public j f22240d;

    /* renamed from: e  reason: collision with root package name */
    public String f22241e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.r3.c f22242f;

    /* renamed from: g  reason: collision with root package name */
    public PopupDialog f22243g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.s.s.i f22244h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.q0.s.s.f> f22245i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.s.s.f f22246j;
    public c.a.q0.s.s.f k;
    public c.a.q0.s.s.f l;
    public c.a.q0.s.s.f m;
    public c.a.q0.s.s.f n;
    public c.a.q0.s.s.f o;
    public c.a.r0.m1.g p;
    public CustomMessageListener q;
    public i.d r;
    public i.d s;
    public i.d t;
    public i.d u;
    public i.d v;
    public i.d w;
    public View.OnClickListener x;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22247a;

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
            this.f22247a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            r rVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof r) || this.f22247a.f22237a.isFinishing() || (rVar = (r) customResponsedMessage.getData()) == null) {
                return;
            }
            rVar.f20883c = null;
            if (TextUtils.isEmpty(rVar.f20885e) || TextUtils.isEmpty(rVar.f20882b) || !rVar.f20882b.equals(this.f22247a.f22241e)) {
                return;
            }
            this.f22247a.f22238b.setCurrentImageQRInfo(rVar.f20885e);
            this.f22247a.s(rVar.f20885e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22248a;

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
            this.f22248a = iVar;
        }

        @Override // c.a.q0.s.s.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22248a.u();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22249a;

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
            this.f22249a = iVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22249a.f22238b.downloadOriginImgAtIndex(this.f22249a.f22237a.calCurrentIndex());
                this.f22249a.u();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22250a;

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
            this.f22250a = iVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.m1.e.a(this.f22250a.f22237a.getPageContext().getPageActivity(), this.f22250a.f22238b.getCurrentImageUrl());
                this.f22250a.u();
                this.f22250a.r(1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22251a;

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
            this.f22251a = iVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String currentImageUrl = this.f22251a.f22238b.getCurrentImageUrl();
                if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
                } else {
                    Intent intent = new Intent(c.a.q0.c0.d.f12796a);
                    intent.putExtra(c.a.q0.c0.d.f12797b, currentImageUrl);
                    TbadkCoreApplication.getInst().sendBroadcast(intent);
                }
                this.f22251a.u();
                this.f22251a.r(2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22252a;

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
            this.f22252a = iVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Activity pageActivity = this.f22252a.f22237a.getPageContext().getPageActivity();
                if (this.f22252a.f22239c == null) {
                    this.f22252a.f22239c = new PermissionJudgePolicy();
                }
                this.f22252a.f22239c.clearRequestPermissionList();
                this.f22252a.f22239c.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (this.f22252a.f22239c.startRequestPermission(pageActivity)) {
                    return;
                }
                this.f22252a.C();
                this.f22252a.u();
                this.f22252a.r(3);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22253a;

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
            this.f22253a = iVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22253a.y();
                this.f22253a.u();
                this.f22253a.r(4);
                this.f22253a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22254a;

        /* loaded from: classes3.dex */
        public class a implements c.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f22255a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f22256b;

            /* renamed from: c.a.r0.m1.i$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C1040a implements a.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f22257e;

                public C1040a(a aVar) {
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
                    this.f22257e = aVar;
                }

                @Override // c.a.q0.s.s.a.e
                public void onClick(c.a.q0.s.s.a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                        aVar.dismiss();
                        a aVar2 = this.f22257e;
                        aVar2.f22256b.f22254a.z(aVar2.f22255a);
                    }
                }
            }

            /* loaded from: classes3.dex */
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

                @Override // c.a.q0.s.s.a.e
                public void onClick(c.a.q0.s.s.a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                        aVar.dismiss();
                    }
                }
            }

            /* loaded from: classes3.dex */
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

                @Override // c.a.q0.s.s.a.e
                public void onClick(c.a.q0.s.s.a aVar) {
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
                this.f22256b = hVar;
                this.f22255a = str;
            }

            @Override // c.a.r0.r3.c.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f22256b.f22254a.f22237a.getPageContext().getPageActivity());
                    aVar.setTitle((String) null);
                    aVar.setMessageShowCenter(true);
                    aVar.setMessage(this.f22256b.f22254a.t(R.string.qr_url_risk_forbid));
                    aVar.setPositiveButton(this.f22256b.f22254a.t(R.string.qr_url_risk_forbid_button), new c(this));
                    aVar.setCancelable(false);
                    aVar.setCanceledOnTouchOutside(false);
                    aVar.create(this.f22256b.f22254a.f22237a.getPageContext()).show();
                }
            }

            @Override // c.a.r0.r3.c.a
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f22256b.f22254a.f22237a.getPageContext().getPageActivity());
                    aVar.setTitleShowCenter(true);
                    aVar.setTitle(this.f22256b.f22254a.t(R.string.qr_url_jump_external_title));
                    aVar.setMessageShowCenter(true);
                    aVar.setMessage(this.f22256b.f22254a.t(R.string.qr_url_jump_external_message));
                    aVar.setPositiveButton(this.f22256b.f22254a.t(R.string.confirm), new C1040a(this));
                    aVar.setNegativeButton(this.f22256b.f22254a.t(R.string.cancel), new b(this));
                    aVar.setCancelable(false);
                    aVar.setCanceledOnTouchOutside(false);
                    aVar.create(this.f22256b.f22254a.f22237a.getPageContext()).show();
                }
            }

            @Override // c.a.r0.r3.c.a
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f22256b.f22254a.z(this.f22255a);
                }
            }

            @Override // c.a.r0.r3.c.a
            public void onError(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                    l.M(this.f22256b.f22254a.f22237a.getPageContext().getPageActivity(), this.f22256b.f22254a.t(R.string.qr_scan_error));
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
            this.f22254a = iVar;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String currentImageQRInfo = this.f22254a.f22238b.getCurrentImageQRInfo();
                if (TextUtils.isEmpty(currentImageQRInfo) || "qr_none".equals(currentImageQRInfo)) {
                    return;
                }
                if (!l.D()) {
                    l.M(this.f22254a.f22237a.getPageContext().getPageActivity(), this.f22254a.t(R.string.network_not_available));
                    return;
                }
                if (this.f22254a.f22242f != null && !this.f22254a.f22242f.isCancelled()) {
                    this.f22254a.f22242f.cancel();
                }
                this.f22254a.f22242f = new c.a.r0.r3.c(currentImageQRInfo, new a(this, currentImageQRInfo));
                this.f22254a.f22242f.setPriority(3);
                this.f22254a.f22242f.execute(new String[0]);
                this.f22254a.u();
                this.f22254a.r(5);
            }
        }
    }

    /* renamed from: c.a.r0.m1.i$i  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1041i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f22258e;

        public View$OnClickListenerC1041i(i iVar) {
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
            this.f22258e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlDragImageView currentUrlDragImageView;
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22258e.f22238b == null || (currentUrlDragImageView = this.f22258e.f22238b.getCurrentUrlDragImageView()) == null) {
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
                str2 = this.f22258e.f22238b.getCurrentImageUrl();
                str = TbMd5.getNameMd5FromUrl(str2);
            }
            ShareItem shareItem = new ShareItem();
            if (imageUrlData != null) {
                long j2 = imageUrlData.threadId;
                if (j2 > 0) {
                    shareItem.t = "http://tieba.baidu.com/p/" + j2 + "?fr=share";
                }
            }
            if (!k.isEmpty(str2)) {
                shareItem.v = Uri.parse(str2);
                shareItem.Z = 2;
                shareItem.r = this.f22258e.t(R.string.save_to_emotion);
                shareItem.s = this.f22258e.t(R.string.save_to_emotion);
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
            new c.a.q0.t.g.g(this.f22258e.f22237a, null).m(shareItem);
        }
    }

    /* loaded from: classes3.dex */
    public class j extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f22259a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f22260b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f22261c;

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
            this.f22261c = iVar;
            this.f22259a = str;
            this.f22260b = bArr;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22261c.f22240d = null;
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
                Map<String, ImageUrlData> assistUrls = this.f22261c.f22237a.getAssistUrls();
                if (this.f22259a != null && assistUrls != null) {
                    ImageUrlData imageUrlData = null;
                    Iterator<Map.Entry<String, ImageUrlData>> it = assistUrls.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<String, ImageUrlData> next = it.next();
                        if (next != null && next.getKey() != null && next.getValue() != null && next.getKey().contains(this.f22259a)) {
                            imageUrlData = next.getValue();
                            break;
                        }
                    }
                    if (imageUrlData != null) {
                        String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + StorageFile.getInstance().getDirectoryName(nameMd5FromUrl) + "/" + TbMd5.getNameMd5FromUrl(imageUrlData.originalUrl);
                        int[] imageFileWH = FileHelper.getImageFileWH(str);
                        if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && FileHelper.copyImageFile(str, this.f22259a, this.f22261c.f22237a.getPageContext().getPageActivity()) == 0) {
                            return this.f22261c.f22237a.getPageContext().getString(R.string.save_image_to_album);
                        }
                    }
                }
                String str2 = this.f22259a;
                if (str2 != null && (bArr = this.f22260b) != null) {
                    int saveImageFileByUser = FileHelper.saveImageFileByUser(str2, bArr, this.f22261c.f22237a.getPageContext().getPageActivity());
                    if (saveImageFileByUser == -2) {
                        return FileHelper.getSdErrorString();
                    }
                    if (saveImageFileByUser == 0) {
                        return this.f22261c.t(R.string.save_image_to_album);
                    }
                }
                return this.f22261c.t(R.string.save_fail);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((j) str);
                if (!c.a.q0.b.d.y() || this.f22261c.t(R.string.save_fail).equals(str)) {
                    this.f22261c.f22237a.showToast(str);
                } else if (this.f22261c.p != null) {
                    this.f22261c.p.g(this.f22261c.f22238b, this.f22261c.f22238b.getBottomHeight(), this.f22261c.x);
                }
                this.f22261c.f22240d = null;
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
        this.f22241e = null;
        this.f22245i = null;
        this.q = new a(this, 2921403);
        this.r = new c(this);
        this.s = new d(this);
        this.t = new e(this);
        this.u = new f(this);
        this.v = new g(this);
        this.w = new h(this);
        this.x = new View$OnClickListenerC1041i(this);
        this.f22237a = imageViewerActivity;
        imageViewerActivity.registerListener(this.q);
        this.p = new c.a.r0.m1.g(imageViewerActivity);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j jVar = this.f22240d;
            if (jVar != null) {
                jVar.cancel();
                this.f22240d = null;
            }
            c.a.r0.r3.c cVar = this.f22242f;
            if (cVar != null) {
                cVar.cancel();
                this.f22242f = null;
            }
            c.a.r0.m1.g gVar = this.p;
            if (gVar != null) {
                gVar.f();
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f22241e = null;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                j jVar = new j(this, this.f22238b.getCurrentImageUrl(), this.f22238b.getCurrentImageData());
                this.f22240d = jVar;
                jVar.execute(new String[0]);
                if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.f22237a.getFrom())) {
                    TiebaStatic.log("c12173");
                }
            } catch (Exception unused) {
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f22245i.clear();
            String checkOriginImgStringAtIndex = this.f22238b.getCheckOriginImgStringAtIndex(this.f22237a.calCurrentIndex());
            if (checkOriginImgStringAtIndex != null) {
                c.a.q0.s.s.f fVar = new c.a.q0.s.s.f(checkOriginImgStringAtIndex, this.f22244h);
                this.f22246j = fVar;
                fVar.l(this.r);
                this.f22245i.add(this.f22246j);
            }
            c.a.q0.s.s.f fVar2 = new c.a.q0.s.s.f(t(R.string.save_to_local), this.f22244h);
            this.l = fVar2;
            fVar2.l(this.u);
            this.f22245i.add(this.l);
            ImageViewerActivity imageViewerActivity = this.f22237a;
            if (imageViewerActivity != null && !imageViewerActivity.isIsBJHThread()) {
                c.a.q0.s.s.f fVar3 = new c.a.q0.s.s.f(t(R.string.save_to_emotion), this.f22244h);
                this.m = fVar3;
                fVar3.l(this.t);
                this.f22245i.add(this.m);
            }
            c.a.q0.s.s.f fVar4 = new c.a.q0.s.s.f(t(R.string.identify_image), this.f22244h);
            this.k = fVar4;
            fVar4.l(this.s);
            this.f22245i.add(this.k);
            String currentImageQRInfo = this.f22238b.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
                c.a.q0.s.s.f fVar5 = new c.a.q0.s.s.f(t(R.string.image_qr_code), this.f22244h);
                this.o = fVar5;
                fVar5.l(this.w);
                this.f22245i.add(this.o);
            }
            c.a.q0.s.s.f fVar6 = new c.a.q0.s.s.f(t(R.string.image_share), this.f22244h);
            this.n = fVar6;
            fVar6.l(this.v);
            this.f22245i.add(this.n);
            this.f22244h.m(new b(this));
            this.f22244h.k(this.f22245i);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f22243g == null || this.f22237a.isFinishing()) {
            return;
        }
        this.f22243g.showDialog();
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String currentImageUrl = this.f22238b.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
            } else if (FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f22237a.getPageContext(), null)) {
                return;
            } else {
                Intent intent = new Intent(c.a.q0.c0.d.f12796a);
                intent.putExtra(c.a.q0.c0.d.f12797b, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            r(2);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void onSave() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Activity pageActivity = this.f22237a.getPageContext().getPageActivity();
            if (this.f22239c == null) {
                this.f22239c = new PermissionJudgePolicy();
            }
            this.f22239c.clearRequestPermissionList();
            this.f22239c.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.f22239c.startRequestPermission(pageActivity)) {
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
            TiebaStatic.log(new StatisticItem("c13270").param("uid", this.f22237a.getUserId()).param("obj_type", i2));
            int i3 = i2 == 1 ? 22 : i2 == 2 ? 21 : i2 == 3 ? 20 : 0;
            if (i3 != 0) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i3));
            }
        }
    }

    public void s(String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || this.f22243g == null || this.f22237a.isFinishing() || !this.f22243g.isShowing() || TextUtils.isEmpty(str) || "qr_none".equals(str)) {
            return;
        }
        c.a.q0.s.s.f fVar = new c.a.q0.s.s.f(t(R.string.image_qr_code), this.f22244h);
        this.o = fVar;
        fVar.l(this.w);
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 < this.f22245i.size()) {
                if (this.k != null && this.f22245i.get(i3) == this.k && (i2 = i3 + 1) <= this.f22245i.size()) {
                    this.f22245i.add(i2, this.o);
                    z = true;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        if (!z) {
            this.f22245i.add(this.o);
        }
        this.f22244h.k(this.f22245i);
    }

    public final String t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? this.f22237a.getString(i2) : (String) invokeI.objValue;
    }

    public void u() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (popupDialog = this.f22243g) != null && popupDialog.isShowing()) {
            this.f22243g.dismiss();
        }
    }

    public void v(@Nullable MultiImageView multiImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, multiImageView) == null) {
            this.f22238b = multiImageView;
            if (this.f22243g == null) {
                this.f22244h = new c.a.q0.s.s.i(this.f22237a);
            }
            if (this.f22245i == null) {
                this.f22245i = new ArrayList();
            }
            D();
            this.f22243g = new PopupDialog(this.f22237a.getPageContext(), this.f22244h);
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
            rVar.f20881a = 0;
            rVar.f20883c = imageBitmap;
            String currentImageUrl = this.f22238b.getCurrentImageUrl();
            if (!TextUtils.isEmpty(currentImageUrl)) {
                rVar.f20882b = String.valueOf(System.currentTimeMillis()) + TbMd5.getNameMd5FromUrl(currentImageUrl);
            } else {
                rVar.f20882b = String.valueOf(BdUniqueId.gen().getId());
            }
            this.f22241e = rVar.f20882b;
            this.f22237a.sendMessage(new CustomMessage(2921403, rVar));
        }
    }

    public void x() {
        c.a.q0.s.s.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (iVar = this.f22244h) == null) {
            return;
        }
        iVar.j();
    }

    public void y() {
        MultiImageView multiImageView;
        UrlDragImageView currentUrlDragImageView;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (multiImageView = this.f22238b) == null || (currentUrlDragImageView = multiImageView.getCurrentUrlDragImageView()) == null) {
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
            str2 = this.f22238b.getCurrentImageUrl();
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
        shareItem.f48114j = true;
        shareItem.E = 23;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.f22237a, shareItem, false);
        if (c.a.q0.b.d.x()) {
            shareDialogConfig.isImageViewerDialog = true;
            shareDialogConfig.originImgText = this.f22238b.getCheckOriginImgStringAtIndex(this.f22237a.calCurrentIndex());
            ImageViewerActivity imageViewerActivity = this.f22237a;
            shareDialogConfig.showAddEmotion = (imageViewerActivity == null || imageViewerActivity.isIsBJHThread()) ? false : true;
            String currentImageQRInfo = this.f22238b.getCurrentImageQRInfo();
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
        this.f22237a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f22237a.getPageContext().getPageActivity(), null, str, false)));
        }
    }
}

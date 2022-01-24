package c.a.t0.v1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.s0.s.s.a;
import c.a.s0.s.s.j;
import c.a.t0.e4.c;
import c.a.t0.x3.j0.r;
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
/* loaded from: classes8.dex */
public class i implements ImageViewerBottomLayout.c, ImageViewerBottomLayout.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ImageViewerActivity a;

    /* renamed from: b  reason: collision with root package name */
    public MultiImageView f24633b;

    /* renamed from: c  reason: collision with root package name */
    public PermissionJudgePolicy f24634c;

    /* renamed from: d  reason: collision with root package name */
    public j f24635d;

    /* renamed from: e  reason: collision with root package name */
    public String f24636e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.e4.c f24637f;

    /* renamed from: g  reason: collision with root package name */
    public PopupDialog f24638g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.s0.s.s.j f24639h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.s0.s.s.g> f24640i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.s0.s.s.g f24641j;
    public c.a.s0.s.s.g k;
    public c.a.s0.s.s.g l;
    public c.a.s0.s.s.g m;
    public c.a.s0.s.s.g n;
    public c.a.s0.s.s.g o;
    public c.a.t0.v1.f p;
    public CustomMessageListener q;
    public j.d r;
    public j.d s;
    public j.d t;
    public j.d u;
    public j.d v;
    public j.d w;
    public View.OnClickListener x;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

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
            this.a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            r rVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof r) || this.a.a.isFinishing() || (rVar = (r) customResponsedMessage.getData()) == null) {
                return;
            }
            rVar.f25127c = null;
            if (TextUtils.isEmpty(rVar.f25129e) || TextUtils.isEmpty(rVar.f25126b) || !rVar.f25126b.equals(this.a.f24636e)) {
                return;
            }
            this.a.f24633b.setCurrentImageQRInfo(rVar.f25129e);
            this.a.s(rVar.f25129e);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

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
            this.a = iVar;
        }

        @Override // c.a.s0.s.s.j.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.u();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

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
            this.a = iVar;
        }

        @Override // c.a.s0.s.s.j.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f24633b.downloadOriginImgAtIndex(this.a.a.calCurrentIndex());
                this.a.u();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

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
            this.a = iVar;
        }

        @Override // c.a.s0.s.s.j.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.t0.v1.d.a(this.a.a.getPageContext().getPageActivity(), this.a.f24633b.getCurrentImageUrl());
                this.a.u();
                this.a.r(1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

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
            this.a = iVar;
        }

        @Override // c.a.s0.s.s.j.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String currentImageUrl = this.a.f24633b.getCurrentImageUrl();
                if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
                } else {
                    Intent intent = new Intent(c.a.s0.c0.d.a);
                    intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
                    intent.putExtra(c.a.s0.c0.d.f12415b, currentImageUrl);
                    TbadkCoreApplication.getInst().sendBroadcast(intent);
                }
                this.a.u();
                this.a.r(2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

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
            this.a = iVar;
        }

        @Override // c.a.s0.s.s.j.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Activity pageActivity = this.a.a.getPageContext().getPageActivity();
                if (this.a.f24634c == null) {
                    this.a.f24634c = new PermissionJudgePolicy();
                }
                this.a.f24634c.clearRequestPermissionList();
                this.a.f24634c.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (this.a.f24634c.startRequestPermission(pageActivity)) {
                    return;
                }
                this.a.C();
                this.a.u();
                this.a.r(3);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

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
            this.a = iVar;
        }

        @Override // c.a.s0.s.s.j.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.y();
                this.a.u();
                this.a.r(4);
                this.a.q();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        /* loaded from: classes8.dex */
        public class a implements c.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ h f24642b;

            /* renamed from: c.a.t0.v1.i$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C1494a implements a.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f24643e;

                public C1494a(a aVar) {
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
                    this.f24643e = aVar;
                }

                @Override // c.a.s0.s.s.a.e
                public void onClick(c.a.s0.s.s.a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                        aVar.dismiss();
                        a aVar2 = this.f24643e;
                        aVar2.f24642b.a.z(aVar2.a);
                    }
                }
            }

            /* loaded from: classes8.dex */
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

                @Override // c.a.s0.s.s.a.e
                public void onClick(c.a.s0.s.s.a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                        aVar.dismiss();
                    }
                }
            }

            /* loaded from: classes8.dex */
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

                @Override // c.a.s0.s.s.a.e
                public void onClick(c.a.s0.s.s.a aVar) {
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
                this.f24642b = hVar;
                this.a = str;
            }

            @Override // c.a.t0.e4.c.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.f24642b.a.a.getPageContext().getPageActivity());
                    aVar.setTitle((String) null);
                    aVar.setMessageShowCenter(true);
                    aVar.setMessage(this.f24642b.a.t(R.string.qr_url_risk_forbid));
                    aVar.setPositiveButton(this.f24642b.a.t(R.string.qr_url_risk_forbid_button), new c(this));
                    aVar.setCancelable(false);
                    aVar.setCanceledOnTouchOutside(false);
                    aVar.create(this.f24642b.a.a.getPageContext()).show();
                }
            }

            @Override // c.a.t0.e4.c.a
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.f24642b.a.a.getPageContext().getPageActivity());
                    aVar.setTitleShowCenter(true);
                    aVar.setTitle(this.f24642b.a.t(R.string.qr_url_jump_external_title));
                    aVar.setMessageShowCenter(true);
                    aVar.setMessage(this.f24642b.a.t(R.string.qr_url_jump_external_message));
                    aVar.setPositiveButton(this.f24642b.a.t(R.string.confirm), new C1494a(this));
                    aVar.setNegativeButton(this.f24642b.a.t(R.string.cancel), new b(this));
                    aVar.setCancelable(false);
                    aVar.setCanceledOnTouchOutside(false);
                    aVar.create(this.f24642b.a.a.getPageContext()).show();
                }
            }

            @Override // c.a.t0.e4.c.a
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f24642b.a.z(this.a);
                }
            }

            @Override // c.a.t0.e4.c.a
            public void onError(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                    n.N(this.f24642b.a.a.getPageContext().getPageActivity(), this.f24642b.a.t(R.string.qr_scan_error));
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
            this.a = iVar;
        }

        @Override // c.a.s0.s.s.j.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String currentImageQRInfo = this.a.f24633b.getCurrentImageQRInfo();
                if (TextUtils.isEmpty(currentImageQRInfo) || "qr_none".equals(currentImageQRInfo)) {
                    return;
                }
                if (!n.C()) {
                    n.N(this.a.a.getPageContext().getPageActivity(), this.a.t(R.string.network_not_available));
                    return;
                }
                if (this.a.f24637f != null && !this.a.f24637f.isCancelled()) {
                    this.a.f24637f.cancel();
                }
                this.a.f24637f = new c.a.t0.e4.c(currentImageQRInfo, new a(this, currentImageQRInfo));
                this.a.f24637f.setPriority(3);
                this.a.f24637f.execute(new String[0]);
                this.a.u();
                this.a.r(5);
            }
        }
    }

    /* renamed from: c.a.t0.v1.i$i  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1495i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f24644e;

        public View$OnClickListenerC1495i(i iVar) {
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
            this.f24644e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlDragImageView currentUrlDragImageView;
            String str;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f24644e.f24633b == null || (currentUrlDragImageView = this.f24644e.f24633b.getCurrentUrlDragImageView()) == null) {
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
                str2 = this.f24644e.f24633b.getCurrentImageUrl();
                str = TbMd5.getNameMd5FromUrl(str2);
            }
            ShareItem shareItem = new ShareItem();
            if (imageUrlData != null) {
                long j2 = imageUrlData.threadId;
                if (j2 > 0) {
                    shareItem.t = "http://tieba.baidu.com/p/" + j2 + "?fr=share";
                }
            }
            if (!m.isEmpty(str2)) {
                shareItem.v = Uri.parse(str2);
                shareItem.b0 = 2;
                shareItem.r = this.f24644e.t(R.string.save_to_emotion);
                shareItem.s = this.f24644e.t(R.string.save_to_emotion);
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
            new c.a.s0.t.g.g(this.f24644e.a, null).t(shareItem);
        }
    }

    /* loaded from: classes8.dex */
    public class j extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f24645b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f24646c;

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
            this.f24646c = iVar;
            this.a = str;
            this.f24645b = bArr;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f24646c.f24635d = null;
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
                Map<String, ImageUrlData> assistUrls = this.f24646c.a.getAssistUrls();
                if (this.a != null && assistUrls != null) {
                    ImageUrlData imageUrlData = null;
                    Iterator<Map.Entry<String, ImageUrlData>> it = assistUrls.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<String, ImageUrlData> next = it.next();
                        if (next != null && next.getKey() != null && next.getValue() != null && next.getKey().contains(this.a)) {
                            imageUrlData = next.getValue();
                            break;
                        }
                    }
                    if (imageUrlData != null) {
                        String str = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + StorageFile.getInstance().getDirectoryName(nameMd5FromUrl) + "/" + TbMd5.getNameMd5FromUrl(imageUrlData.originalUrl);
                        int[] imageFileWH = FileHelper.getImageFileWH(str);
                        if (imageFileWH != null && imageFileWH.length == 2 && imageFileWH[0] > 0 && FileHelper.copyImageFile(str, this.a, this.f24646c.a.getPageContext().getPageActivity()) == 0) {
                            return this.f24646c.a.getPageContext().getString(R.string.save_image_to_album);
                        }
                    }
                }
                String str2 = this.a;
                if (str2 != null && (bArr = this.f24645b) != null) {
                    int saveImageFileByUser = FileHelper.saveImageFileByUser(str2, bArr, this.f24646c.a.getPageContext().getPageActivity());
                    if (saveImageFileByUser == -2) {
                        return FileHelper.getSdErrorString();
                    }
                    if (saveImageFileByUser == 0) {
                        return this.f24646c.t(R.string.save_image_to_album);
                    }
                }
                return this.f24646c.t(R.string.save_fail);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((j) str);
                if (!c.a.s0.b.d.E() || this.f24646c.t(R.string.save_fail).equals(str)) {
                    this.f24646c.a.showToast(str);
                } else if (this.f24646c.p != null) {
                    this.f24646c.p.g(this.f24646c.f24633b, this.f24646c.f24633b.getBottomHeight(), this.f24646c.x);
                }
                this.f24646c.f24635d = null;
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
        this.f24636e = null;
        this.f24640i = null;
        this.q = new a(this, 2921403);
        this.r = new c(this);
        this.s = new d(this);
        this.t = new e(this);
        this.u = new f(this);
        this.v = new g(this);
        this.w = new h(this);
        this.x = new View$OnClickListenerC1495i(this);
        this.a = imageViewerActivity;
        imageViewerActivity.registerListener(this.q);
        this.p = new c.a.t0.v1.f(imageViewerActivity);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j jVar = this.f24635d;
            if (jVar != null) {
                jVar.cancel();
                this.f24635d = null;
            }
            c.a.t0.e4.c cVar = this.f24637f;
            if (cVar != null) {
                cVar.cancel();
                this.f24637f = null;
            }
            c.a.t0.v1.f fVar = this.p;
            if (fVar != null) {
                fVar.f();
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f24636e = null;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                j jVar = new j(this, this.f24633b.getCurrentImageUrl(), this.f24633b.getCurrentImageData());
                this.f24635d = jVar;
                jVar.execute(new String[0]);
                if (ImageViewerConfig.FROM_DISCOVER_BEAUTY.equals(this.a.getFrom())) {
                    TiebaStatic.log("c12173");
                }
            } catch (Exception unused) {
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f24640i.clear();
            String checkOriginImgStringAtIndex = this.f24633b.getCheckOriginImgStringAtIndex(this.a.calCurrentIndex());
            if (checkOriginImgStringAtIndex != null) {
                c.a.s0.s.s.g gVar = new c.a.s0.s.s.g(checkOriginImgStringAtIndex, this.f24639h);
                this.f24641j = gVar;
                gVar.l(this.r);
                this.f24640i.add(this.f24641j);
            }
            c.a.s0.s.s.g gVar2 = new c.a.s0.s.s.g(t(R.string.save_to_local), this.f24639h);
            this.l = gVar2;
            gVar2.l(this.u);
            this.f24640i.add(this.l);
            ImageViewerActivity imageViewerActivity = this.a;
            if (imageViewerActivity != null && !imageViewerActivity.isIsBJHThread()) {
                c.a.s0.s.s.g gVar3 = new c.a.s0.s.s.g(t(R.string.save_to_emotion), this.f24639h);
                this.m = gVar3;
                gVar3.l(this.t);
                this.f24640i.add(this.m);
            }
            c.a.s0.s.s.g gVar4 = new c.a.s0.s.s.g(t(R.string.identify_image), this.f24639h);
            this.k = gVar4;
            gVar4.l(this.s);
            this.f24640i.add(this.k);
            String currentImageQRInfo = this.f24633b.getCurrentImageQRInfo();
            if (!TextUtils.isEmpty(currentImageQRInfo) && !currentImageQRInfo.equals("qr_none")) {
                c.a.s0.s.s.g gVar5 = new c.a.s0.s.s.g(t(R.string.image_qr_code), this.f24639h);
                this.o = gVar5;
                gVar5.l(this.w);
                this.f24640i.add(this.o);
            }
            c.a.s0.s.s.g gVar6 = new c.a.s0.s.s.g(t(R.string.image_share), this.f24639h);
            this.n = gVar6;
            gVar6.l(this.v);
            this.f24640i.add(this.n);
            this.f24639h.m(new b(this));
            this.f24639h.j(this.f24640i);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f24638g == null || this.a.isFinishing()) {
            return;
        }
        this.f24638g.showDialog();
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String currentImageUrl = this.f24633b.getCurrentImageUrl();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, currentImageUrl));
            } else if (FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.getPageContext(), null)) {
                return;
            } else {
                Intent intent = new Intent(c.a.s0.c0.d.a);
                intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
                intent.putExtra(c.a.s0.c0.d.f12415b, currentImageUrl);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
            }
            r(2);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.b
    public void onSave() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Activity pageActivity = this.a.getPageContext().getPageActivity();
            if (this.f24634c == null) {
                this.f24634c = new PermissionJudgePolicy();
            }
            this.f24634c.clearRequestPermissionList();
            this.f24634c.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.f24634c.startRequestPermission(pageActivity)) {
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
            TiebaStatic.log(new StatisticItem("c13270").param("uid", this.a.getUserId()).param("obj_type", i2));
            int i3 = i2 == 1 ? 22 : i2 == 2 ? 21 : i2 == 3 ? 20 : 0;
            if (i3 != 0) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("obj_type", i3));
            }
        }
    }

    public void s(String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || this.f24638g == null || this.a.isFinishing() || !this.f24638g.isShowing() || TextUtils.isEmpty(str) || "qr_none".equals(str)) {
            return;
        }
        c.a.s0.s.s.g gVar = new c.a.s0.s.s.g(t(R.string.image_qr_code), this.f24639h);
        this.o = gVar;
        gVar.l(this.w);
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 < this.f24640i.size()) {
                if (this.k != null && this.f24640i.get(i3) == this.k && (i2 = i3 + 1) <= this.f24640i.size()) {
                    this.f24640i.add(i2, this.o);
                    z = true;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        if (!z) {
            this.f24640i.add(this.o);
        }
        this.f24639h.j(this.f24640i);
    }

    public final String t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? this.a.getString(i2) : (String) invokeI.objValue;
    }

    public void u() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (popupDialog = this.f24638g) != null && popupDialog.isShowing()) {
            this.f24638g.dismiss();
        }
    }

    public void v(@Nullable MultiImageView multiImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, multiImageView) == null) {
            this.f24633b = multiImageView;
            if (this.f24638g == null) {
                this.f24639h = new c.a.s0.s.s.j(this.a);
            }
            if (this.f24640i == null) {
                this.f24640i = new ArrayList();
            }
            D();
            this.f24638g = new PopupDialog(this.a.getPageContext(), this.f24639h);
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
            rVar.a = 0;
            rVar.f25127c = imageBitmap;
            String currentImageUrl = this.f24633b.getCurrentImageUrl();
            if (!TextUtils.isEmpty(currentImageUrl)) {
                rVar.f25126b = String.valueOf(System.currentTimeMillis()) + TbMd5.getNameMd5FromUrl(currentImageUrl);
            } else {
                rVar.f25126b = String.valueOf(BdUniqueId.gen().getId());
            }
            this.f24636e = rVar.f25126b;
            this.a.sendMessage(new CustomMessage(2921403, rVar));
        }
    }

    public void x() {
        c.a.s0.s.s.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (jVar = this.f24639h) == null) {
            return;
        }
        jVar.i();
    }

    public void y() {
        MultiImageView multiImageView;
        UrlDragImageView currentUrlDragImageView;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (multiImageView = this.f24633b) == null || (currentUrlDragImageView = multiImageView.getCurrentUrlDragImageView()) == null) {
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
            str2 = this.f24633b.getCurrentImageUrl();
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
        if (!m.isEmpty(str2)) {
            shareItem.v = Uri.parse(str2);
            shareItem.b0 = 1;
            Bundle bundle = new Bundle();
            bundle.putString("path", "images");
            bundle.putString("name", str);
            bundle.putBoolean("formatData", true);
            bundle.putBoolean("isSubDir", true);
            bundle.putBoolean("isSdcard", false);
            bundle.putBoolean("isSavedCache", true);
            shareItem.A = bundle;
        }
        shareItem.f40798j = true;
        shareItem.E = 23;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.a, shareItem, false);
        if (c.a.s0.b.d.D()) {
            shareDialogConfig.isImageViewerDialog = true;
            shareDialogConfig.originImgText = this.f24633b.getCheckOriginImgStringAtIndex(this.a.calCurrentIndex());
            ImageViewerActivity imageViewerActivity = this.a;
            shareDialogConfig.showAddEmotion = (imageViewerActivity == null || imageViewerActivity.isIsBJHThread()) ? false : true;
            String currentImageQRInfo = this.f24633b.getCurrentImageQRInfo();
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
        this.a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.getPageContext().getPageActivity(), null, str, false)));
        }
    }
}

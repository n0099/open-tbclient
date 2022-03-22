package c.a.p0.x.f.b.d;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import c.a.a0.j.f.d;
import c.a.a0.j.f.i;
import c.a.p0.x.g.g.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a extends d implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.x.f.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1537a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.x.g.g.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f20598b;

        public View$OnClickListenerC1537a(a aVar, c.a.p0.x.g.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20598b = aVar;
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.b(view)) {
                return;
            }
            this.f20598b.p();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r9v4, types: [android.view.View] */
    public a(@NonNull c.a.p0.x.g.g.b bVar, @NonNull i<?> iVar, @NonNull AdDownloadData adDownloadData) {
        super(x(adDownloadData), iVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, iVar, adDownloadData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.a0.j.d.a) objArr2[0], (i) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ?? realView = this.f1281f.get().getRealView();
        if (realView != 0) {
            realView.setOnClickListener(new View$OnClickListenerC1537a(this, bVar));
        }
    }

    public static c.a.a0.j.d.a x(@NonNull AdDownloadData adDownloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adDownloadData)) == null) {
            if (c.a.a0.j.b.a.a().query(adDownloadData.getDownloadKey()) != null) {
                return c.a.a0.j.b.a.a().query(adDownloadData.getDownloadKey());
            }
            c.a.a0.j.d.a aVar = new c.a.a0.j.d.a();
            aVar.g(adDownloadData.getDownloadKey());
            if (TextUtils.isEmpty(aVar.d())) {
                aVar.g(adDownloadData.getDownloadUrl());
            }
            aVar.f1250g = adDownloadData.getDownloadUrl();
            aVar.f1247d = adDownloadData.getPkgName();
            c.a.a0.j.d.d dVar = new c.a.a0.j.d.d();
            dVar.j = adDownloadData.adId();
            dVar.a = adDownloadData.getExtInfo();
            dVar.f1266g = adDownloadData.getAppIcon();
            dVar.f1267h = adDownloadData.getAppName();
            if (y(adDownloadData.getCmdScheme())) {
                dVar.f1262c = adDownloadData.getCmdScheme();
            }
            aVar.n = dVar;
            c.a.a0.j.d.b bVar = new c.a.a0.j.d.b();
            bVar.a = adDownloadData.getPage();
            aVar.o = bVar;
            return aVar;
        }
        return (c.a.a0.j.d.a) invokeL.objValue;
    }

    public static boolean y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                return TextUtils.equals("dlink", c.a.a0.g.h.d.i(Uri.parse(str)));
            } catch (Exception e2) {
                c.a.a0.i.a.d("AdNewDownloadPresenter", "cmd parse faile, cmd=" + str, e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.x.g.g.c
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [android.view.View] */
    @Override // c.a.p0.x.g.g.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f1281f.get().getRealView().setVisibility(0);
            p();
        }
    }

    @Override // c.a.a0.j.f.d, c.a.a0.j.f.a, c.a.a0.j.f.h
    public void c(@NonNull AdDownloadAction adDownloadAction, @NonNull c.a.a0.j.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, aVar) == null) {
            super.c(adDownloadAction, aVar);
        }
    }

    @Override // c.a.p0.x.g.g.c
    public void d(@NonNull DownloadStatus downloadStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadStatus) == null) {
        }
    }

    @Override // c.a.p0.x.g.g.c
    public void e(@NonNull AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, adDownloadData) == null) {
        }
    }
}

package c.a.u0.v.f.b.d;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import c.a.d0.j.f.d;
import c.a.d0.j.f.i;
import c.a.u0.v.g.g.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a extends d implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.u0.v.f.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1474a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.u0.v.g.g.b f24360e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f24361f;

        public View$OnClickListenerC1474a(a aVar, c.a.u0.v.g.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24361f = aVar;
            this.f24360e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f24360e.onClickIntercept(view)) {
                return;
            }
            this.f24361f.o();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r9v4, types: [android.view.View] */
    public a(@NonNull c.a.u0.v.g.g.b bVar, @NonNull i<?> iVar, @NonNull AdDownloadData adDownloadData) {
        super(w(adDownloadData), iVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, iVar, adDownloadData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.d0.j.d.a) objArr2[0], (i) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ?? realView = this.f2840j.get().getRealView();
        if (realView != 0) {
            realView.setOnClickListener(new View$OnClickListenerC1474a(this, bVar));
        }
    }

    public static c.a.d0.j.d.a w(@NonNull AdDownloadData adDownloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adDownloadData)) == null) {
            if (c.a.d0.j.b.a.a().query(adDownloadData.getDownloadKey()) != null) {
                return c.a.d0.j.b.a.a().query(adDownloadData.getDownloadKey());
            }
            c.a.d0.j.d.a aVar = new c.a.d0.j.d.a();
            aVar.g(adDownloadData.getDownloadKey());
            if (TextUtils.isEmpty(aVar.d())) {
                aVar.g(adDownloadData.getDownloadUrl());
            }
            aVar.f2802g = adDownloadData.getDownloadUrl();
            aVar.f2799d = adDownloadData.getPkgName();
            c.a.d0.j.d.d dVar = new c.a.d0.j.d.d();
            dVar.f2825j = adDownloadData.adId();
            dVar.a = adDownloadData.getExtInfo();
            dVar.f2822g = adDownloadData.getAppIcon();
            dVar.f2823h = adDownloadData.getAppName();
            if (x(adDownloadData.getCmdScheme())) {
                dVar.f2818c = adDownloadData.getCmdScheme();
            }
            aVar.n = dVar;
            c.a.d0.j.d.b bVar = new c.a.d0.j.d.b();
            bVar.a = adDownloadData.getPage();
            aVar.o = bVar;
            return aVar;
        }
        return (c.a.d0.j.d.a) invokeL.objValue;
    }

    public static boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                return TextUtils.equals("dlink", c.a.d0.f.i.d.i(Uri.parse(str)));
            } catch (Exception e2) {
                c.a.d0.i.a.d("AdNewDownloadPresenter", "cmd parse faile, cmd=" + str, e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [android.view.View] */
    @Override // c.a.u0.v.g.g.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f2840j.get().getRealView().setVisibility(0);
            o();
        }
    }

    @Override // c.a.d0.j.f.d, c.a.d0.j.f.a, c.a.d0.j.f.h
    public void b(@NonNull AdDownloadAction adDownloadAction, @NonNull c.a.d0.j.d.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadAction, aVar) == null) {
            super.b(adDownloadAction, aVar);
        }
    }

    @Override // c.a.u0.v.g.g.c
    public void c(@NonNull DownloadStatus downloadStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadStatus) == null) {
        }
    }

    @Override // c.a.u0.v.g.g.c
    public void d(@NonNull AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adDownloadData) == null) {
        }
    }

    @Override // c.a.u0.v.g.g.c
    public void onProgressChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
        }
    }
}

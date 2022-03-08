package c.e.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.imagemanager.ImageLoader;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.utils.FileCopyUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.StringUtils;
import com.dxm.credit.marketdialog.data.MarketDialogResponse;
import com.dxm.credit.marketdialog.ui.Market3Dialog;
import com.dxm.credit.marketdialog.ui.MarketBaseDialog;
import com.dxm.credit.marketdialog.ui.MarketWebViewDialog;
import java.io.File;
import java.io.FileReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements IBeanResponseCallback {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static Handler f28178h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Activity f28179e;

    /* renamed from: f  reason: collision with root package name */
    public volatile MarketDialogResponse f28180f;

    /* renamed from: g  reason: collision with root package name */
    public c.e.b.a.c.a f28181g;

    /* renamed from: c.e.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1651a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28182e;

        /* renamed from: c.e.b.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1652a implements MarketBaseDialog.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f28183b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f28184c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ RunnableC1651a f28185d;

            public C1652a(RunnableC1651a runnableC1651a, String str, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1651a, str, Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f28185d = runnableC1651a;
                this.a = str;
                this.f28183b = i2;
                this.f28184c = i3;
            }

            @Override // com.dxm.credit.marketdialog.ui.MarketBaseDialog.b
            public boolean a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.e.b.a.b.a.e(this.f28185d.f28182e.f28179e, this.a, this.f28183b, this.f28184c) : invokeV.booleanValue;
            }
        }

        /* renamed from: c.e.b.a.a$a$b */
        /* loaded from: classes3.dex */
        public class b implements DialogInterface.OnShowListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f28186e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f28187f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ RunnableC1651a f28188g;

            public b(RunnableC1651a runnableC1651a, String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1651a, str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f28188g = runnableC1651a;
                this.f28186e = str;
                this.f28187f = i2;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    c.e.b.a.b.a.c(this.f28188g.f28182e.f28179e, this.f28186e, this.f28187f);
                }
            }
        }

        public RunnableC1651a(a aVar) {
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
            this.f28182e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            MarketDialogResponse.Dialog[] dialogArr;
            MarketBaseDialog c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f28182e.f28180f.isPollingChanged() && this.f28182e.f28180f.polling != null) {
                    int i2 = -1;
                    for (MarketDialogResponse.Dialog dialog : this.f28182e.f28180f.polling) {
                        if (c.e.b.a.b.a.e(this.f28182e.f28179e, dialog.group_md5, StringUtils.parseInt(dialog.group_limit), StringUtils.parseInt(dialog.group_day_limit)) && (c2 = this.f28182e.c(dialog)) != null) {
                            int i3 = i2 + 1;
                            c2.setIndex(i2);
                            String str = dialog.group_md5;
                            int parseInt = StringUtils.parseInt(dialog.group_limit);
                            int parseInt2 = StringUtils.parseInt(dialog.group_day_limit);
                            c2.setRule(new C1652a(this, str, parseInt, parseInt2));
                            c2.setOnShowListener(new b(this, str, parseInt2));
                            this.f28182e.f28181g.c(c2);
                            i2 = i3;
                        }
                    }
                }
                this.f28182e.f28180f.setPollingChanged(false);
                this.f28182e.f28181g.h();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ImageLoader.OnGetBitmapListener {
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

        @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
        public boolean needCancel(String str, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, obj)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
        public void onError(String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
            }
        }

        @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
        public void onGetBitmap(String str, Object obj, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, obj, bitmap) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BaseBean<MarketDialogResponse> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public MarketDialogResponse f28189b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, String str, MarketDialogResponse marketDialogResponse) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, marketDialogResponse};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = "0";
            this.a = str;
            this.f28189b = marketDialogResponse;
        }

        @Override // com.baidu.apollon.beans.ApollonBean
        public void execBean() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.execBean(MarketDialogResponse.class);
            }
        }

        @Override // com.baidu.wallet.core.beans.NetworkBean
        public List<RestNameValuePair> generateRequestParam() {
            InterceptResult invokeV;
            RestNameValuePair restNameValuePair;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ArrayList arrayList = new ArrayList();
                if (this.f28189b != null) {
                    LogUtil.d("market", "bean o = " + this.f28189b.polling_md5);
                    restNameValuePair = new RestNameValuePair("polling_md5", TextUtils.isEmpty(this.f28189b.polling_md5) ? "" : this.f28189b.polling_md5);
                } else {
                    restNameValuePair = new RestNameValuePair("polling_md5", "");
                }
                arrayList.add(restNameValuePair);
                arrayList.add(new RestNameValuePair("immediate_md5", ""));
                arrayList.add(new RestNameValuePair("occasion", this.a));
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        @Override // com.baidu.apollon.beans.ApollonBean
        public int getBeanId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 65280;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.apollon.beans.ApollonBean
        public String getUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return DomainConfig.getInstance().getAppHost(this.tag) + "/walletappapi/app/popwindow";
            }
            return (String) invokeV.objValue;
        }
    }

    public a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (activity == null) {
            return;
        }
        this.f28179e = activity;
        this.f28181g = new c.e.b.a.c.a(activity);
        f28178h = new Handler(activity.getMainLooper());
        j();
    }

    public final MarketBaseDialog c(MarketDialogResponse.Dialog dialog) {
        InterceptResult invokeL;
        MarketBaseDialog marketWebViewDialog;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dialog)) == null) {
            if (this.f28179e.isFinishing() || this.f28181g == null || dialog == null || TextUtils.isEmpty(dialog.group_md5)) {
                return null;
            }
            if (TextUtils.equals(dialog.group_layout, "t3")) {
                if (!TextUtils.isEmpty(dialog.group_img)) {
                    marketWebViewDialog = new Market3Dialog(this.f28179e);
                    h(dialog.group_img);
                }
                marketWebViewDialog = null;
            } else {
                if (TextUtils.equals(dialog.group_layout, "t8") && !TextUtils.isEmpty(dialog.group_link_addr)) {
                    marketWebViewDialog = new MarketWebViewDialog(this.f28179e);
                }
                marketWebViewDialog = null;
            }
            if (marketWebViewDialog == null) {
                return null;
            }
            marketWebViewDialog.setData(dialog);
            if (marketWebViewDialog.isValid()) {
                return marketWebViewDialog;
            }
            return null;
        }
        return (MarketBaseDialog) invokeL.objValue;
    }

    public c.e.b.a.c.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28181g : (c.e.b.a.c.a) invokeV.objValue;
    }

    public void e(String str) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            LogUtil.d("market", "requestMarketDialog = " + this.f28180f);
            WeakReference weakReference = new WeakReference(this.f28179e);
            if (weakReference.get() == null || (activity = (Activity) weakReference.get()) == null) {
                return;
            }
            c cVar = new c(activity, str, this.f28180f);
            cVar.setResponseCallback(this);
            cVar.execBean();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f28180f != null && this.f28180f.isPollingChanged()) {
            try {
                String json = JsonUtils.toJson(this.f28180f);
                FileCopyUtils.copyToFile(json, new File(this.f28179e.getApplication().getCacheDir() + "/popwindow_config.cfg"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            ImageLoader.getInstance(this.f28179e).getBitmapFromDiskOrNet(str, new b(this), null, 0);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f28179e.isFinishing() || this.f28179e.isRestricted()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 17 && this.f28179e.isDestroyed()) {
            return;
        }
        File file = new File(this.f28179e.getCacheDir() + "/popwindow_config.cfg");
        FileReader fileReader = null;
        try {
            try {
                try {
                    if (file.exists() && file.isFile()) {
                        FileReader fileReader2 = new FileReader(file);
                        try {
                            String copyToString = FileCopyUtils.copyToString(fileReader2);
                            if (!TextUtils.isEmpty(copyToString) && this.f28180f == null) {
                                this.f28180f = (MarketDialogResponse) JsonUtils.fromJson(copyToString, MarketDialogResponse.class);
                                LogUtil.d("market", "get cache data o = " + this.f28180f.polling_md5);
                            }
                            fileReader = fileReader2;
                        } catch (Exception e2) {
                            e = e2;
                            fileReader = fileReader2;
                            e.printStackTrace();
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            fileReader = fileReader2;
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, str) == null) {
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048583, this, i2, obj, str) == null) && obj != null && (obj instanceof MarketDialogResponse)) {
            MarketDialogResponse marketDialogResponse = (MarketDialogResponse) obj;
            if (this.f28180f == null) {
                LogUtil.d("market", " m is null success o = " + marketDialogResponse);
                this.f28180f = marketDialogResponse;
                if (this.f28180f.polling != null && this.f28180f.polling.length > 0) {
                    this.f28180f.setPollingChanged(true);
                }
            } else if (i2 == 65280) {
                LogUtil.d("market", " m is not null success o = " + marketDialogResponse);
                this.f28180f.setNetResponse(this.f28179e, marketDialogResponse);
            }
            g();
            f28178h.post(new RunnableC1651a(this));
        }
    }
}

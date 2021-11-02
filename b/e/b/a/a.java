package b.e.b.a;

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
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.io.FileReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements IBeanResponseCallback {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static Handler f30612h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Activity f30613e;

    /* renamed from: f  reason: collision with root package name */
    public volatile MarketDialogResponse f30614f;

    /* renamed from: g  reason: collision with root package name */
    public b.e.b.a.c.a f30615g;

    /* renamed from: b.e.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1452a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f30616e;

        /* renamed from: b.e.b.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1453a implements MarketBaseDialog.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f30617a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f30618b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ int f30619c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ RunnableC1452a f30620d;

            public C1453a(RunnableC1452a runnableC1452a, String str, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1452a, str, Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f30620d = runnableC1452a;
                this.f30617a = str;
                this.f30618b = i2;
                this.f30619c = i3;
            }

            @Override // com.dxm.credit.marketdialog.ui.MarketBaseDialog.b
            public boolean a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b.e.b.a.b.a.e(this.f30620d.f30616e.f30613e, this.f30617a, this.f30618b, this.f30619c) : invokeV.booleanValue;
            }
        }

        /* renamed from: b.e.b.a.a$a$b */
        /* loaded from: classes6.dex */
        public class b implements DialogInterface.OnShowListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f30621e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f30622f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ RunnableC1452a f30623g;

            public b(RunnableC1452a runnableC1452a, String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC1452a, str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f30623g = runnableC1452a;
                this.f30621e = str;
                this.f30622f = i2;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    b.e.b.a.b.a.c(this.f30623g.f30616e.f30613e, this.f30621e, this.f30622f);
                }
            }
        }

        public RunnableC1452a(a aVar) {
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
            this.f30616e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            MarketDialogResponse.Dialog[] dialogArr;
            MarketBaseDialog c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f30616e.f30614f.isPollingChanged() && this.f30616e.f30614f.polling != null) {
                    int i2 = -1;
                    for (MarketDialogResponse.Dialog dialog : this.f30616e.f30614f.polling) {
                        if (b.e.b.a.b.a.e(this.f30616e.f30613e, dialog.group_md5, StringUtils.parseInt(dialog.group_limit), StringUtils.parseInt(dialog.group_day_limit)) && (c2 = this.f30616e.c(dialog)) != null) {
                            int i3 = i2 + 1;
                            c2.setIndex(i2);
                            String str = dialog.group_md5;
                            int parseInt = StringUtils.parseInt(dialog.group_limit);
                            int parseInt2 = StringUtils.parseInt(dialog.group_day_limit);
                            c2.setRule(new C1453a(this, str, parseInt, parseInt2));
                            c2.setOnShowListener(new b(this, str, parseInt2));
                            this.f30616e.f30615g.c(c2);
                            i2 = i3;
                        }
                    }
                }
                this.f30616e.f30614f.setPollingChanged(false);
                this.f30616e.f30615g.h();
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class c extends BaseBean<MarketDialogResponse> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f30624a;

        /* renamed from: b  reason: collision with root package name */
        public MarketDialogResponse f30625b;

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
            this.f30624a = "0";
            this.f30624a = str;
            this.f30625b = marketDialogResponse;
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
                if (this.f30625b != null) {
                    LogUtil.d(BaseConstants.SCHEME_MARKET, "bean o = " + this.f30625b.polling_md5);
                    restNameValuePair = new RestNameValuePair("polling_md5", TextUtils.isEmpty(this.f30625b.polling_md5) ? "" : this.f30625b.polling_md5);
                } else {
                    restNameValuePair = new RestNameValuePair("polling_md5", "");
                }
                arrayList.add(restNameValuePair);
                arrayList.add(new RestNameValuePair("immediate_md5", ""));
                arrayList.add(new RestNameValuePair("occasion", this.f30624a));
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
        this.f30613e = activity;
        this.f30615g = new b.e.b.a.c.a(activity);
        f30612h = new Handler(activity.getMainLooper());
        j();
    }

    public final MarketBaseDialog c(MarketDialogResponse.Dialog dialog) {
        InterceptResult invokeL;
        MarketBaseDialog marketWebViewDialog;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dialog)) == null) {
            if (this.f30613e.isFinishing() || this.f30615g == null || dialog == null || TextUtils.isEmpty(dialog.group_md5)) {
                return null;
            }
            if (TextUtils.equals(dialog.group_layout, "t3")) {
                if (!TextUtils.isEmpty(dialog.group_img)) {
                    marketWebViewDialog = new Market3Dialog(this.f30613e);
                    h(dialog.group_img);
                }
                marketWebViewDialog = null;
            } else {
                if (TextUtils.equals(dialog.group_layout, "t8") && !TextUtils.isEmpty(dialog.group_link_addr)) {
                    marketWebViewDialog = new MarketWebViewDialog(this.f30613e);
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

    public b.e.b.a.c.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30615g : (b.e.b.a.c.a) invokeV.objValue;
    }

    public void e(String str) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            LogUtil.d(BaseConstants.SCHEME_MARKET, "requestMarketDialog = " + this.f30614f);
            WeakReference weakReference = new WeakReference(this.f30613e);
            if (weakReference.get() == null || (activity = (Activity) weakReference.get()) == null) {
                return;
            }
            c cVar = new c(activity, str, this.f30614f);
            cVar.setResponseCallback(this);
            cVar.execBean();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f30614f != null && this.f30614f.isPollingChanged()) {
            try {
                String json = JsonUtils.toJson(this.f30614f);
                FileCopyUtils.copyToFile(json, new File(this.f30613e.getApplication().getCacheDir() + "/popwindow_config.cfg"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            ImageLoader.getInstance(this.f30613e).getBitmapFromDiskOrNet(str, new b(this), null, 0);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f30613e.isFinishing() || this.f30613e.isRestricted()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 17 && this.f30613e.isDestroyed()) {
            return;
        }
        File file = new File(this.f30613e.getCacheDir() + "/popwindow_config.cfg");
        FileReader fileReader = null;
        try {
            try {
                try {
                    if (file.exists() && file.isFile()) {
                        FileReader fileReader2 = new FileReader(file);
                        try {
                            String copyToString = FileCopyUtils.copyToString(fileReader2);
                            if (!TextUtils.isEmpty(copyToString) && this.f30614f == null) {
                                this.f30614f = (MarketDialogResponse) JsonUtils.fromJson(copyToString, MarketDialogResponse.class);
                                LogUtil.d(BaseConstants.SCHEME_MARKET, "get cache data o = " + this.f30614f.polling_md5);
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
            if (this.f30614f == null) {
                LogUtil.d(BaseConstants.SCHEME_MARKET, " m is null success o = " + marketDialogResponse);
                this.f30614f = marketDialogResponse;
                if (this.f30614f.polling != null && this.f30614f.polling.length > 0) {
                    this.f30614f.setPollingChanged(true);
                }
            } else if (i2 == 65280) {
                LogUtil.d(BaseConstants.SCHEME_MARKET, " m is not null success o = " + marketDialogResponse);
                this.f30614f.setNetResponse(this.f30613e, marketDialogResponse);
            }
            g();
            f30612h.post(new RunnableC1452a(this));
        }
    }
}

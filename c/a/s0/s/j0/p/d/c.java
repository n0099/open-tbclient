package c.a.s0.s.j0.p.d;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.itemcard.download.ItemDownloadExtraData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static c f13124d;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, DownloadData> a;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, DownloadData> f13125b;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<String, String> f13126c;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage)) {
                List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                if (ListUtils.isEmpty(data)) {
                    return;
                }
                for (DownloadData downloadData : data) {
                    if (downloadData != null && (downloadData.getExtra() instanceof ItemDownloadExtraData)) {
                        String str = ((ItemDownloadExtraData) downloadData.getExtra()).pkgName;
                        int status = downloadData.getStatus();
                        if (status == 0) {
                            if (this.a.a.containsKey(str)) {
                                this.a.f13125b.put(str, this.a.a.get(str));
                                this.a.a.remove(str);
                                c.a.s0.s.j0.p.d.b.a(downloadData, 700);
                                return;
                            }
                            return;
                        } else if (status != 2) {
                            if (status == 4 && this.a.a.containsKey(str)) {
                                this.a.a.remove(str);
                                c.a.s0.s.j0.p.d.b.a(downloadData, 400);
                                return;
                            }
                            return;
                        } else {
                            c.a.s0.s.j0.p.d.b.a(downloadData, 600);
                            return;
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Intent) {
                    Intent intent = (Intent) data;
                    String g2 = c.a.s0.e0.a.g(intent);
                    if (PackageChangedReceiver.ACTION_INSTALL.equals(intent.getAction()) || "android.intent.action.PACKAGE_REPLACED".equals(intent.getAction())) {
                        if (this.a.f13125b.containsKey(g2)) {
                            c.a.s0.s.j0.p.d.b.a((DownloadData) this.a.f13125b.get(g2), 900);
                            this.a.f13125b.remove(g2);
                        }
                    } else if (PackageChangedReceiver.ACTION_UNINSTALL.equals(intent.getAction())) {
                        this.a.l(g2);
                    }
                }
            }
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.f13125b = new HashMap<>();
        this.f13126c = new HashMap<>();
        h();
        i();
    }

    public static c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f13124d == null) {
                f13124d = new c();
            }
            return f13124d;
        }
        return (c) invokeV.objValue;
    }

    public void d(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, downloadData) == null) && downloadData != null && (downloadData.getExtra() instanceof ItemDownloadExtraData) && ((ItemDownloadExtraData) downloadData.getExtra()).isShouzhuData()) {
            this.a.put(((ItemDownloadExtraData) downloadData.getExtra()).pkgName, downloadData);
        }
    }

    public void e(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) && downloadData != null && (downloadData.getExtra() instanceof ItemDownloadExtraData) && ((ItemDownloadExtraData) downloadData.getExtra()).isShouzhuData()) {
            this.f13125b.put(((ItemDownloadExtraData) downloadData.getExtra()).pkgName, downloadData);
        }
    }

    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.f13126c.containsKey(str)) {
                return this.f13126c.get(str);
            }
            String string = TbadkCoreApplication.getInst().getSharedPreferences("shouzhu_app_source_sp", 0).getString(str, "");
            this.f13126c.put(str, string);
            return string;
        }
        return (String) invokeL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a aVar = new a(this, 2001118);
            aVar.setPriority(-1);
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b bVar = new b(this, 2002504);
            bVar.setPriority(-1);
            MessageManager.getInstance().registerListener(bVar);
        }
    }

    public void j(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, downloadData) == null) && downloadData != null && (downloadData.getExtra() instanceof ItemDownloadExtraData) && ((ItemDownloadExtraData) downloadData.getExtra()).isShouzhuData()) {
            this.a.remove(((ItemDownloadExtraData) downloadData.getExtra()).pkgName);
        }
    }

    public void k(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, downloadData) == null) && downloadData != null && (downloadData.getExtra() instanceof ItemDownloadExtraData) && ((ItemDownloadExtraData) downloadData.getExtra()).isShouzhuData()) {
            this.f13125b.remove(((ItemDownloadExtraData) downloadData.getExtra()).pkgName);
        }
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f13126c.remove(str);
            SharedPreferences.Editor edit = TbadkCoreApplication.getInst().getSharedPreferences("shouzhu_app_source_sp", 0).edit();
            edit.remove(str);
            edit.commit();
        }
    }

    public void m(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) || StringHelper.equals(this.f13126c.get(str), str2)) {
            return;
        }
        this.f13126c.put(str, str2);
        SharedPreferences.Editor edit = TbadkCoreApplication.getInst().getSharedPreferences("shouzhu_app_source_sp", 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }
}

package c.a.t0.e4;

import android.app.Activity;
import c.a.d.a.g;
import c.a.d.f.p.m;
import c.a.s0.s.s.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.ueg.UEGCancelModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f17255d;
    public transient /* synthetic */ FieldHolder $fh;
    public UEGCancelModel a;

    /* renamed from: b  reason: collision with root package name */
    public UEGCancelModel.b f17256b;

    /* renamed from: c  reason: collision with root package name */
    public int f17257c;

    /* loaded from: classes7.dex */
    public class a implements UEGCancelModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
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
            this.a = bVar;
        }

        @Override // com.baidu.tieba.ueg.UEGCancelModel.b
        public void a(BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, blockPopInfoData) == null) || blockPopInfoData == null || b.f17255d) {
                return;
            }
            this.a.d(blockPopInfoData);
        }
    }

    /* renamed from: c.a.t0.e4.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1093b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BlockPopInfoData f17258e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f17259f;

        public C1093b(b bVar, BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, blockPopInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17259f = bVar;
            this.f17258e = blockPopInfoData;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", this.f17259f.f17257c).param("obj_type", this.f17258e.win_type));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BlockPopInfoData f17260e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f17261f;

        public c(b bVar, BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, blockPopInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17261f = bVar;
            this.f17260e = blockPopInfoData;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f17261f.e(this.f17260e);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", this.f17261f.f17257c).param("obj_type", this.f17260e.win_type));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(973655436, "Lc/a/t0/e4/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(973655436, "Lc/a/t0/e4/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f17257c = TbadkCoreStatisticKey.AntiLocateValue.LOCATE_COLD_BOOT;
        this.a = new UEGCancelModel();
        if (this.f17256b == null) {
            this.f17256b = new a(this);
        }
        this.a.y(this.f17256b);
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f17257c = i2;
            this.a.x();
        }
    }

    public final void d(BlockPopInfoData blockPopInfoData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, blockPopInfoData) == null) || blockPopInfoData == null || c.a.d.a.b.f().b() == null) {
            return;
        }
        String str = blockPopInfoData.block_id_code;
        int i2 = blockPopInfoData.win_type;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str2 = blockPopInfoData.ahead_url;
        String str3 = blockPopInfoData.ok_info;
        String str4 = blockPopInfoData.ahead_info;
        String str5 = blockPopInfoData.block_info;
        if ((i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4) || m.isEmpty(currentAccount) || m.isEmpty(str)) {
            return;
        }
        c.a.s0.s.h0.b k = c.a.s0.s.h0.b.k();
        boolean z = false;
        boolean h2 = k.h(str + i2 + currentAccount, false);
        if ((!m.isEmpty(str2) || i2 == 4) && !m.isEmpty(str3) && ((!m.isEmpty(str4) || i2 == 4) && !m.isEmpty(str5))) {
            z = true;
        }
        if (h2 || !z) {
            return;
        }
        c.a.s0.s.h0.b k2 = c.a.s0.s.h0.b.k();
        k2.u(str + i2 + currentAccount, true);
        h(blockPopInfoData);
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", this.f17257c).param("obj_type", i2));
    }

    public final void e(BlockPopInfoData blockPopInfoData) {
        Activity b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, blockPopInfoData) == null) || blockPopInfoData == null || (b2 = c.a.d.a.b.f().b()) == null) {
            return;
        }
        AntiHelper.p(b2, blockPopInfoData.ahead_url);
    }

    public void f() {
        UEGCancelModel uEGCancelModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (uEGCancelModel = this.a) == null) {
            return;
        }
        uEGCancelModel.onDestroy();
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            f17255d = z;
        }
    }

    public final void h(BlockPopInfoData blockPopInfoData) {
        Activity b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, blockPopInfoData) == null) || blockPopInfoData == null || (b2 = c.a.d.a.b.f().b()) == null) {
            return;
        }
        c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(b2);
        aVar.setMessage(blockPopInfoData.block_info);
        aVar.setNegativeButton(blockPopInfoData.ok_info, new C1093b(this, blockPopInfoData));
        aVar.setPositiveButton(blockPopInfoData.ahead_info, new c(this, blockPopInfoData));
        aVar.create(((g) b2).getPageContext());
        aVar.show();
    }
}

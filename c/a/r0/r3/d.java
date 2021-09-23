package c.a.r0.r3;

import c.a.e.e.p.k;
import c.a.q0.s.s.a;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.BlockPopInfo;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static BlockPopInfo f24507c;

    /* renamed from: d  reason: collision with root package name */
    public static BlockPopInfo f24508d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f24509a;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f24510b;

    /* loaded from: classes3.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
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
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BlockPopInfo f24511e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f24512f;

        public b(d dVar, BlockPopInfo blockPopInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, blockPopInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24512f = dVar;
            this.f24511e = blockPopInfo;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f24512f.e(this.f24511e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            d.g(null);
            d.f(null);
        }
    }

    public d(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c cVar = new c(this, 2005016);
        this.f24510b = cVar;
        this.f24509a = tbPageContext;
        tbPageContext.registerListener(cVar);
    }

    public static void f(BlockPopInfo blockPopInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, blockPopInfo) == null) {
            f24508d = blockPopInfo;
        }
    }

    public static void g(BlockPopInfo blockPopInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, blockPopInfo) == null) {
            f24507c = blockPopInfo;
        }
    }

    public final boolean b(BlockPopInfo blockPopInfo) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, blockPopInfo)) == null) {
            if (blockPopInfo != null && (num = blockPopInfo.appeal_status) != null && num.intValue() == 1) {
                BdToast.h(this.f24509a.getPageActivity(), blockPopInfo.appeal_msg, R.drawable.icon_pure_toast_mistake40_svg, 3000, false).q();
                return true;
            } else if (blockPopInfo == null || blockPopInfo.can_post.intValue() != 0 || (!(blockPopInfo.ahead_type.intValue() == 1 || blockPopInfo.ahead_type.intValue() == 2) || blockPopInfo.appeal_status.intValue() == 1)) {
                return false;
            } else {
                if (blockPopInfo.ahead_type.intValue() == 1) {
                    String str = blockPopInfo.block_info;
                    String str2 = blockPopInfo.ok_info;
                    if (!k.isEmpty(str) && !k.isEmpty(str2)) {
                        h(blockPopInfo);
                    } else {
                        BdToast.h(this.f24509a.getPageActivity(), this.f24509a.getString(R.string.hanpen_error), R.drawable.icon_pure_toast_mistake40_svg, 3000, false).q();
                    }
                } else if (blockPopInfo.ahead_type.intValue() == 2) {
                    e(blockPopInfo);
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b(f24508d) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b(f24507c) : invokeV.booleanValue;
    }

    public final void e(BlockPopInfo blockPopInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, blockPopInfo) == null) || blockPopInfo == null) {
            return;
        }
        AntiHelper.p(this.f24509a.getPageActivity(), blockPopInfo.ahead_url);
    }

    public final void h(BlockPopInfo blockPopInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, blockPopInfo) == null) || blockPopInfo == null) {
            return;
        }
        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f24509a.getPageActivity());
        aVar.setMessage(blockPopInfo.block_info);
        aVar.setNegativeButton(blockPopInfo.ok_info, new a(this));
        aVar.setPositiveButton(blockPopInfo.ahead_info, new b(this, blockPopInfo));
        aVar.create(this.f24509a).show();
    }
}

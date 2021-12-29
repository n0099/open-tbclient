package c.a.t0.a0.f.c.f.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import c.a.t0.g0.d0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernOfflineViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class e extends c.a.d.n.e.a<c.a.t0.a0.f.c.f.b.b, LiveTabConcernOfflineViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public d0<c.a.t0.a0.f.c.f.b.b> n;

    /* loaded from: classes6.dex */
    public class a extends d0<c.a.t0.a0.f.c.f.b.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f14802b;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14802b = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.g0.d0
        /* renamed from: d */
        public void a(View view, c.a.t0.a0.f.c.f.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, bVar) == null) {
                this.f14802b.a0(bVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), c.a.t0.a0.f.c.f.b.b.f14804k);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new a(this);
        this.m = tbPageContext;
    }

    public final void a0(c.a.t0.a0.f.c.f.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
            return;
        }
        String str = bVar.f14805e;
        if (StringUtils.isNull(str) || c.a.d.f.m.b.g(str, 0L) == 0) {
            return;
        }
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.m.getPageActivity());
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.m.getPageActivity()).createNormalConfig(c.a.d.f.m.b.g(str, 0L), !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str), false)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: b0 */
    public LiveTabConcernOfflineViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            c.a.t0.a0.f.c.f.d.f fVar = new c.a.t0.a0.f.c.f.d.f(this.m, viewGroup);
            fVar.m(this.n);
            return new LiveTabConcernOfflineViewHolder(fVar);
        }
        return (LiveTabConcernOfflineViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: c0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.t0.a0.f.c.f.b.b bVar, LiveTabConcernOfflineViewHolder liveTabConcernOfflineViewHolder) {
        InterceptResult invokeCommon;
        c.a.t0.a0.f.c.f.d.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, liveTabConcernOfflineViewHolder})) == null) {
            if (liveTabConcernOfflineViewHolder == null || (fVar = liveTabConcernOfflineViewHolder.mView) == null) {
                return null;
            }
            fVar.k(bVar);
            return liveTabConcernOfflineViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}

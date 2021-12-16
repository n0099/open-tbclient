package c.a.r0.s.i0.o.c;

import android.view.View;
import c.a.d.a.e;
import c.a.s0.v3.s0.k;
import c.a.s0.v3.x;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f13038e;

    /* renamed from: f  reason: collision with root package name */
    public LikeModel f13039f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.s.i0.o.b f13040g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.s.i0.o.c.b f13041h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f13042i;

    /* renamed from: j  reason: collision with root package name */
    public CustomMessageListener f13043j;

    /* renamed from: k  reason: collision with root package name */
    public CustomMessageListener f13044k;
    public e l;

    /* renamed from: c.a.r0.s.i0.o.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0833a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0833a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k)) {
                k kVar = (k) customResponsedMessage.getData();
                String l = Long.toString(kVar.a);
                if (this.a.f13041h != null && l.equals(this.a.f13041h.getForumId()) && kVar.f25131b) {
                    this.a.f13041h.setIsLike(true);
                    this.a.f13041h.a(true);
                    this.a.f13040g.updateLikeStatus(true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k)) {
                k kVar = (k) customResponsedMessage.getData();
                String l = Long.toString(kVar.a);
                if (this.a.f13041h != null && l.equals(this.a.f13041h.getForumId()) && kVar.f25131b) {
                    this.a.f13041h.setIsLike(false);
                    this.a.f13041h.a(false);
                    this.a.f13040g.updateLikeStatus(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof x) && ((x) obj).d() != 0) {
                if (AntiHelper.m(this.a.f13039f.getErrorCode(), this.a.f13039f.getErrorString())) {
                    AntiHelper.u(this.a.f13038e.getPageActivity(), this.a.f13039f.getErrorString());
                } else {
                    this.a.f13038e.showToast(this.a.f13039f.getErrorString());
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, c.a.r0.s.i0.o.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13043j = new C0833a(this, 2001437);
        this.f13044k = new b(this, 2001438);
        this.l = new c(this);
        this.f13038e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f13039f = likeModel;
        likeModel.setLoadDataCallBack(this.l);
        this.f13040g = bVar;
        bVar.bindOnClickListener(this);
        tbPageContext.registerListener(this.f13043j);
        tbPageContext.registerListener(this.f13044k);
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.f13042i = onClickListener;
        }
    }

    public void f(c.a.r0.s.i0.o.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f13041h = bVar;
        this.f13040g.updateLikeStatus(bVar.getIsLike());
    }

    public void g(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.f13043j.setTag(bdUniqueId);
            this.f13044k.setTag(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            c.a.r0.s.i0.o.b bVar = this.f13040g;
            if (bVar != null) {
                bVar.onClickEvent(view);
            }
            if (!c.a.d.f.p.k.z()) {
                this.f13038e.showToast(R.string.neterror);
                return;
            }
            if (ViewHelper.checkUpIsLogin(this.f13038e.getPageActivity())) {
                c.a.r0.s.i0.o.c.b bVar2 = this.f13041h;
                if (bVar2 == null) {
                    return;
                }
                this.f13039f.L(bVar2.getForumName(), this.f13041h.getForumId());
            }
            View.OnClickListener onClickListener = this.f13042i;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }
}

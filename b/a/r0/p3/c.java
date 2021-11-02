package b.a.r0.p3;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.animation.ScaleAnimation;
import b.a.e.a.e;
import b.a.e.e.m.g;
import b.a.r0.l3.h0;
import b.a.r0.l3.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideCommonShowBox;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideImgShowBox;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideRankShowBox;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public NewUserGuideActivity f22459e;

    /* renamed from: f  reason: collision with root package name */
    public InterestFrsData.Tag f22460f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.p3.a f22461g;

    /* renamed from: h  reason: collision with root package name */
    public LikeModel f22462h;

    /* renamed from: i  reason: collision with root package name */
    public h0 f22463i;

    /* loaded from: classes5.dex */
    public class a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f22464a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22464a = cVar;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj == null) {
                    this.f22464a.f22459e.showToast(R.string.neterror);
                } else if (obj instanceof x) {
                    int e2 = b.a.e.e.m.b.e(((x) obj).g(), 0);
                    this.f22464a.f22461g.ForumLike(e2);
                    this.f22464a.c(e2, true);
                    this.f22464a.f22459e.setHasLike(true);
                    this.f22464a.f22459e.setIsChanged(true);
                    TiebaStatic.eventStat(this.f22464a.f22459e.getPageContext().getPageActivity(), "notlogin_12", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements h0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f22465a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22465a = cVar;
        }

        @Override // b.a.r0.l3.h0.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.f22465a.f22459e.showToast(R.string.error);
            }
        }

        @Override // b.a.r0.l3.h0.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                int e2 = b.a.e.e.m.b.e(String.valueOf(j), 0);
                this.f22465a.f22461g.ForumUnLike(e2);
                this.f22465a.c(e2, false);
            }
        }
    }

    /* renamed from: b.a.r0.p3.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class DialogInterface$OnDismissListenerC1096c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewUserGuideMainFragment.b f22466e;

        public DialogInterface$OnDismissListenerC1096c(c cVar, NewUserGuideMainFragment.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22466e = bVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f22466e.a();
            }
        }
    }

    public c(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, NewUserGuideMainFragment.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newUserGuideActivity, tag, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22459e = newUserGuideActivity;
        this.f22460f = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.f22461g = new NewUserGuideRankShowBox(this.f22459e.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.f22461g = new NewUserGuideCommonShowBox(this.f22459e.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.f22461g = new NewUserGuideImgShowBox(this.f22459e.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        LikeModel likeModel = new LikeModel(newUserGuideActivity.getPageContext());
        this.f22462h = likeModel;
        likeModel.setLoadDataCallBack(new a(this));
        h0 h0Var = new h0();
        this.f22463i = h0Var;
        h0Var.b(new b(this));
        this.f22461g.setOnClickListener(this);
        this.f22461g.setData(this.f22460f);
        ((Dialog) this.f22461g).setOnDismissListener(new DialogInterface$OnDismissListenerC1096c(this, bVar));
    }

    public void c(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            for (int i3 = 0; i3 < this.f22460f.getCard_list().size(); i3++) {
                if (this.f22460f.getCard_list().get(i3).getFid() == i2) {
                    this.f22460f.getCard_list().get(i3).setIs_like(z ? 1 : 0);
                    return;
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NewUserGuideActivity newUserGuideActivity = this.f22459e;
            if (newUserGuideActivity == null || g.e(newUserGuideActivity.getPageContext().getPageActivity())) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
                scaleAnimation.setDuration(350L);
                this.f22461g.getRootView().setAnimation(scaleAnimation);
                this.f22461g.show();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            if (view.getId() == R.id.box_close_layout) {
                this.f22461g.hide();
            } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
                InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
                if (card.getIs_like() == 1) {
                    this.f22463i.c(card.getFname(), card.getFid());
                } else {
                    this.f22462h.M(card.getFname(), String.valueOf(card.getFid()), "newuser");
                }
            }
        }
    }
}

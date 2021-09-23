package c.a.r0.n3;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.animation.ScaleAnimation;
import c.a.e.a.e;
import c.a.e.e.m.g;
import c.a.r0.j3.g0;
import c.a.r0.j3.x;
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
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public NewUserGuideActivity f23029e;

    /* renamed from: f  reason: collision with root package name */
    public InterestFrsData.Tag f23030f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.n3.a f23031g;

    /* renamed from: h  reason: collision with root package name */
    public LikeModel f23032h;

    /* renamed from: i  reason: collision with root package name */
    public g0 f23033i;

    /* loaded from: classes3.dex */
    public class a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f23034a;

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
            this.f23034a = cVar;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj == null) {
                    this.f23034a.f23029e.showToast(R.string.neterror);
                } else if (obj instanceof x) {
                    int e2 = c.a.e.e.m.b.e(((x) obj).g(), 0);
                    this.f23034a.f23031g.ForumLike(e2);
                    this.f23034a.c(e2, true);
                    this.f23034a.f23029e.setHasLike(true);
                    this.f23034a.f23029e.setIsChanged(true);
                    TiebaStatic.eventStat(this.f23034a.f23029e.getPageContext().getPageActivity(), "notlogin_12", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements g0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f23035a;

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
            this.f23035a = cVar;
        }

        @Override // c.a.r0.j3.g0.a
        public void a(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
                this.f23035a.f23029e.showToast(R.string.error);
            }
        }

        @Override // c.a.r0.j3.g0.a
        public void b(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
                int e2 = c.a.e.e.m.b.e(String.valueOf(j2), 0);
                this.f23035a.f23031g.ForumUnLike(e2);
                this.f23035a.c(e2, false);
            }
        }
    }

    /* renamed from: c.a.r0.n3.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class DialogInterface$OnDismissListenerC1070c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewUserGuideMainFragment.b f23036e;

        public DialogInterface$OnDismissListenerC1070c(c cVar, NewUserGuideMainFragment.b bVar) {
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
            this.f23036e = bVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f23036e.a();
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
        this.f23029e = newUserGuideActivity;
        this.f23030f = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.f23031g = new NewUserGuideRankShowBox(this.f23029e.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.f23031g = new NewUserGuideCommonShowBox(this.f23029e.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.f23031g = new NewUserGuideImgShowBox(this.f23029e.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        LikeModel likeModel = new LikeModel(newUserGuideActivity.getPageContext());
        this.f23032h = likeModel;
        likeModel.setLoadDataCallBack(new a(this));
        g0 g0Var = new g0();
        this.f23033i = g0Var;
        g0Var.b(new b(this));
        this.f23031g.setOnClickListener(this);
        this.f23031g.setData(this.f23030f);
        ((Dialog) this.f23031g).setOnDismissListener(new DialogInterface$OnDismissListenerC1070c(this, bVar));
    }

    public void c(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            for (int i3 = 0; i3 < this.f23030f.getCard_list().size(); i3++) {
                if (this.f23030f.getCard_list().get(i3).getFid() == i2) {
                    this.f23030f.getCard_list().get(i3).setIs_like(z ? 1 : 0);
                    return;
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NewUserGuideActivity newUserGuideActivity = this.f23029e;
            if (newUserGuideActivity == null || g.e(newUserGuideActivity.getPageContext().getPageActivity())) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
                scaleAnimation.setDuration(350L);
                this.f23031g.getRootView().setAnimation(scaleAnimation);
                this.f23031g.show();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            if (view.getId() == R.id.box_close_layout) {
                this.f23031g.hide();
            } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
                InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
                if (card.getIs_like() == 1) {
                    this.f23033i.c(card.getFname(), card.getFid());
                } else {
                    this.f23032h.M(card.getFname(), String.valueOf(card.getFid()), "newuser");
                }
            }
        }
    }
}

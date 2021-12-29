package c.a.t0.a4;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.animation.ScaleAnimation;
import c.a.d.a.e;
import c.a.d.f.m.g;
import c.a.t0.w3.h0;
import c.a.t0.w3.x;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes6.dex */
public class c implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public NewUserGuideActivity f15445e;

    /* renamed from: f  reason: collision with root package name */
    public InterestFrsData.Tag f15446f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.a4.a f15447g;

    /* renamed from: h  reason: collision with root package name */
    public LikeModel f15448h;

    /* renamed from: i  reason: collision with root package name */
    public h0 f15449i;

    /* loaded from: classes6.dex */
    public class a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj == null) {
                    this.a.f15445e.showToast(R.string.neterror);
                } else if (obj instanceof x) {
                    int e2 = c.a.d.f.m.b.e(((x) obj).g(), 0);
                    this.a.f15447g.ForumLike(e2);
                    this.a.c(e2, true);
                    this.a.f15445e.setHasLike(true);
                    this.a.f15445e.setIsChanged(true);
                    TiebaStatic.eventStat(this.a.f15445e.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements h0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
        }

        @Override // c.a.t0.w3.h0.a
        public void a(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
                this.a.f15445e.showToast(R.string.error);
            }
        }

        @Override // c.a.t0.w3.h0.a
        public void b(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2) == null) {
                int e2 = c.a.d.f.m.b.e(String.valueOf(j2), 0);
                this.a.f15447g.ForumUnLike(e2);
                this.a.c(e2, false);
            }
        }
    }

    /* renamed from: c.a.t0.a4.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class DialogInterface$OnDismissListenerC0952c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewUserGuideMainFragment.b f15450e;

        public DialogInterface$OnDismissListenerC0952c(c cVar, NewUserGuideMainFragment.b bVar) {
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
            this.f15450e = bVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f15450e.a();
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
        this.f15445e = newUserGuideActivity;
        this.f15446f = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.f15447g = new NewUserGuideRankShowBox(this.f15445e.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.f15447g = new NewUserGuideCommonShowBox(this.f15445e.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.f15447g = new NewUserGuideImgShowBox(this.f15445e.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        LikeModel likeModel = new LikeModel(newUserGuideActivity.getPageContext());
        this.f15448h = likeModel;
        likeModel.setLoadDataCallBack(new a(this));
        h0 h0Var = new h0();
        this.f15449i = h0Var;
        h0Var.b(new b(this));
        this.f15447g.setOnClickListener(this);
        this.f15447g.setData(this.f15446f);
        ((Dialog) this.f15447g).setOnDismissListener(new DialogInterface$OnDismissListenerC0952c(this, bVar));
    }

    public void c(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            for (int i3 = 0; i3 < this.f15446f.getCard_list().size(); i3++) {
                if (this.f15446f.getCard_list().get(i3).getFid() == i2) {
                    this.f15446f.getCard_list().get(i3).setIs_like(z ? 1 : 0);
                    return;
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NewUserGuideActivity newUserGuideActivity = this.f15445e;
            if (newUserGuideActivity == null || g.e(newUserGuideActivity.getPageContext().getPageActivity())) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
                scaleAnimation.setDuration(350L);
                this.f15447g.getRootView().setAnimation(scaleAnimation);
                this.f15447g.show();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            if (view.getId() == R.id.box_close_layout) {
                this.f15447g.hide();
            } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
                InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
                if (card.getIs_like() == 1) {
                    this.f15449i.c(card.getFname(), card.getFid());
                } else {
                    this.f15448h.M(card.getFname(), String.valueOf(card.getFid()), "newuser");
                }
            }
        }
    }
}

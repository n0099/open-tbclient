package c.a.r0.a0.l.g.d;

import android.content.Context;
import android.widget.RelativeLayout;
import c.a.d.f.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.gift.AlaDynamicGift;
import com.baidu.ala.gift.AlaDynamicGiftAndNativeData;
import com.baidu.ala.gift.AlaDynamicGiftConfigInfo;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.ala.gift.IFrameCallback;
import com.baidu.ala.gift.IImageFramePlayerViewController;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEffectPreviewView;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f14541b;

    /* renamed from: c  reason: collision with root package name */
    public IImageFramePlayerViewController f14542c;

    /* renamed from: d  reason: collision with root package name */
    public AlaEffectPreviewView f14543d;

    /* renamed from: e  reason: collision with root package name */
    public AlaEnterEffectData f14544e;

    /* renamed from: f  reason: collision with root package name */
    public int f14545f;

    /* renamed from: g  reason: collision with root package name */
    public IFrameCallback f14546g;

    /* renamed from: h  reason: collision with root package name */
    public c f14547h;

    /* loaded from: classes5.dex */
    public class a implements IFrameCallback {
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

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.b(this.a);
                if (this.a.f14545f > 0 || this.a.f14544e == null) {
                    return;
                }
                b bVar = this.a;
                bVar.g(bVar.f14544e);
            }
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            }
        }
    }

    /* renamed from: c.a.r0.a0.l.g.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0879b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0879b(b bVar) {
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

        @Override // c.a.r0.a0.l.g.d.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.b(this.a);
                if (this.a.f14544e != null) {
                    if (this.a.f14544e.type != 1 || this.a.f14545f > 0) {
                        if (this.a.f14544e.type == 0) {
                            b bVar = this.a;
                            bVar.g(bVar.f14544e);
                            return;
                        }
                        return;
                    }
                    b bVar2 = this.a;
                    bVar2.g(bVar2.f14544e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a();
    }

    public b(Context context, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14545f = 2;
        this.f14546g = new a(this);
        this.f14547h = new C0879b(this);
        this.a = context;
        this.f14541b = relativeLayout;
    }

    public static /* synthetic */ int b(b bVar) {
        int i2 = bVar.f14545f;
        bVar.f14545f = i2 - 1;
        return i2;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            IImageFramePlayerViewController iImageFramePlayerViewController = this.f14542c;
            if (iImageFramePlayerViewController != null) {
                iImageFramePlayerViewController.onDestroy();
            }
            AlaEffectPreviewView alaEffectPreviewView = this.f14543d;
            if (alaEffectPreviewView != null) {
                alaEffectPreviewView.onDestory();
            }
        }
    }

    public final void e(AlaEnterEffectData alaEnterEffectData) {
        AlaDynamicGiftConfigInfo alaDynamicGiftConfigInfo;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, alaEnterEffectData) == null) {
            if (this.f14542c == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.a)) != null && runTask.getData() != null) {
                IImageFramePlayerViewController iImageFramePlayerViewController = (IImageFramePlayerViewController) runTask.getData();
                this.f14542c = iImageFramePlayerViewController;
                iImageFramePlayerViewController.setFrameCallback(this.f14546g);
            }
            IImageFramePlayerViewController iImageFramePlayerViewController2 = this.f14542c;
            if (iImageFramePlayerViewController2 != null) {
                if (iImageFramePlayerViewController2.getAnimView().getParent() == null) {
                    this.f14541b.addView(this.f14542c.getAnimView(), new RelativeLayout.LayoutParams(-1, l.i(this.a)));
                }
                AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
                AlaDynamicGift alaDynamicGift = alaEnterEffectData.gift;
                alaDynamicGiftAndNativeData.mAlaDynamicGift = alaDynamicGift;
                if (alaDynamicGift != null && (alaDynamicGiftConfigInfo = alaDynamicGift.configInfo) != null) {
                    alaDynamicGiftConfigInfo.isBottomMargin = 1;
                    alaDynamicGiftConfigInfo.oppositeY = 0.6499999761581421d;
                }
                alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
                this.f14542c.setData(alaDynamicGiftAndNativeData);
                this.f14542c.startAnim();
            }
        }
    }

    public final void f(AlaEnterEffectData alaEnterEffectData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, alaEnterEffectData) == null) {
            if (this.f14543d == null) {
                AlaEffectPreviewView alaEffectPreviewView = new AlaEffectPreviewView(this.a);
                this.f14543d = alaEffectPreviewView;
                alaEffectPreviewView.setAnimCompleteCallback(this.f14547h);
            }
            if (this.f14543d.getParent() == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(2, R.id.effet_name_tv);
                layoutParams.bottomMargin = this.a.getResources().getDimensionPixelSize(R.dimen.ds51);
                this.f14541b.addView(this.f14543d, layoutParams);
            }
            this.f14543d.setData(alaEnterEffectData);
            this.f14543d.startAnimtion();
        }
    }

    public void g(AlaEnterEffectData alaEnterEffectData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, alaEnterEffectData) == null) || alaEnterEffectData == null) {
            return;
        }
        this.f14544e = alaEnterEffectData;
        int i2 = alaEnterEffectData.type;
        if (i2 == 1) {
            this.f14545f = 2;
            e(alaEnterEffectData);
            f(alaEnterEffectData);
        } else if (i2 == 0) {
            f(alaEnterEffectData);
        }
    }
}

package c.a.r0.w.l.g.d;

import android.content.Context;
import android.widget.RelativeLayout;
import c.a.e.e.p.l;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f26430a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f26431b;

    /* renamed from: c  reason: collision with root package name */
    public IImageFramePlayerViewController f26432c;

    /* renamed from: d  reason: collision with root package name */
    public AlaEffectPreviewView f26433d;

    /* renamed from: e  reason: collision with root package name */
    public AlaEnterEffectData f26434e;

    /* renamed from: f  reason: collision with root package name */
    public int f26435f;

    /* renamed from: g  reason: collision with root package name */
    public IFrameCallback f26436g;

    /* renamed from: h  reason: collision with root package name */
    public c f26437h;

    /* loaded from: classes4.dex */
    public class a implements IFrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26438a;

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
            this.f26438a = bVar;
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.b(this.f26438a);
                if (this.f26438a.f26435f > 0 || this.f26438a.f26434e == null) {
                    return;
                }
                b bVar = this.f26438a;
                bVar.g(bVar.f26434e);
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

    /* renamed from: c.a.r0.w.l.g.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1234b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26439a;

        public C1234b(b bVar) {
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
            this.f26439a = bVar;
        }

        @Override // c.a.r0.w.l.g.d.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.b(this.f26439a);
                if (this.f26439a.f26434e != null) {
                    if (this.f26439a.f26434e.type != 1 || this.f26439a.f26435f > 0) {
                        if (this.f26439a.f26434e.type == 0) {
                            b bVar = this.f26439a;
                            bVar.g(bVar.f26434e);
                            return;
                        }
                        return;
                    }
                    b bVar2 = this.f26439a;
                    bVar2.g(bVar2.f26434e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
        this.f26435f = 2;
        this.f26436g = new a(this);
        this.f26437h = new C1234b(this);
        this.f26430a = context;
        this.f26431b = relativeLayout;
    }

    public static /* synthetic */ int b(b bVar) {
        int i2 = bVar.f26435f;
        bVar.f26435f = i2 - 1;
        return i2;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            IImageFramePlayerViewController iImageFramePlayerViewController = this.f26432c;
            if (iImageFramePlayerViewController != null) {
                iImageFramePlayerViewController.onDestroy();
            }
            AlaEffectPreviewView alaEffectPreviewView = this.f26433d;
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
            if (this.f26432c == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.f26430a)) != null && runTask.getData() != null) {
                IImageFramePlayerViewController iImageFramePlayerViewController = (IImageFramePlayerViewController) runTask.getData();
                this.f26432c = iImageFramePlayerViewController;
                iImageFramePlayerViewController.setFrameCallback(this.f26436g);
            }
            IImageFramePlayerViewController iImageFramePlayerViewController2 = this.f26432c;
            if (iImageFramePlayerViewController2 != null) {
                if (iImageFramePlayerViewController2.getAnimView().getParent() == null) {
                    this.f26431b.addView(this.f26432c.getAnimView(), new RelativeLayout.LayoutParams(-1, l.i(this.f26430a)));
                }
                AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
                AlaDynamicGift alaDynamicGift = alaEnterEffectData.gift;
                alaDynamicGiftAndNativeData.mAlaDynamicGift = alaDynamicGift;
                if (alaDynamicGift != null && (alaDynamicGiftConfigInfo = alaDynamicGift.configInfo) != null) {
                    alaDynamicGiftConfigInfo.isBottomMargin = 1;
                    alaDynamicGiftConfigInfo.oppositeY = 0.6499999761581421d;
                }
                alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
                this.f26432c.setData(alaDynamicGiftAndNativeData);
                this.f26432c.startAnim();
            }
        }
    }

    public final void f(AlaEnterEffectData alaEnterEffectData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, alaEnterEffectData) == null) {
            if (this.f26433d == null) {
                AlaEffectPreviewView alaEffectPreviewView = new AlaEffectPreviewView(this.f26430a);
                this.f26433d = alaEffectPreviewView;
                alaEffectPreviewView.setAnimCompleteCallback(this.f26437h);
            }
            if (this.f26433d.getParent() == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(2, R.id.effet_name_tv);
                layoutParams.bottomMargin = this.f26430a.getResources().getDimensionPixelSize(R.dimen.ds51);
                this.f26431b.addView(this.f26433d, layoutParams);
            }
            this.f26433d.setData(alaEnterEffectData);
            this.f26433d.startAnimtion();
        }
    }

    public void g(AlaEnterEffectData alaEnterEffectData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, alaEnterEffectData) == null) || alaEnterEffectData == null) {
            return;
        }
        this.f26434e = alaEnterEffectData;
        int i2 = alaEnterEffectData.type;
        if (i2 == 1) {
            this.f26435f = 2;
            e(alaEnterEffectData);
            f(alaEnterEffectData);
        } else if (i2 == 0) {
            f(alaEnterEffectData);
        }
    }
}

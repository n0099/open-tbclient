package b.a.r0.w.l.g.d;

import android.content.Context;
import android.widget.RelativeLayout;
import b.a.e.f.p.l;
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

    /* renamed from: a  reason: collision with root package name */
    public Context f26778a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f26779b;

    /* renamed from: c  reason: collision with root package name */
    public IImageFramePlayerViewController f26780c;

    /* renamed from: d  reason: collision with root package name */
    public AlaEffectPreviewView f26781d;

    /* renamed from: e  reason: collision with root package name */
    public AlaEnterEffectData f26782e;

    /* renamed from: f  reason: collision with root package name */
    public int f26783f;

    /* renamed from: g  reason: collision with root package name */
    public IFrameCallback f26784g;

    /* renamed from: h  reason: collision with root package name */
    public c f26785h;

    /* loaded from: classes5.dex */
    public class a implements IFrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26786a;

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
            this.f26786a = bVar;
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.b(this.f26786a);
                if (this.f26786a.f26783f > 0 || this.f26786a.f26782e == null) {
                    return;
                }
                b bVar = this.f26786a;
                bVar.g(bVar.f26782e);
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

    /* renamed from: b.a.r0.w.l.g.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1303b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f26787a;

        public C1303b(b bVar) {
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
            this.f26787a = bVar;
        }

        @Override // b.a.r0.w.l.g.d.b.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.b(this.f26787a);
                if (this.f26787a.f26782e != null) {
                    if (this.f26787a.f26782e.type != 1 || this.f26787a.f26783f > 0) {
                        if (this.f26787a.f26782e.type == 0) {
                            b bVar = this.f26787a;
                            bVar.g(bVar.f26782e);
                            return;
                        }
                        return;
                    }
                    b bVar2 = this.f26787a;
                    bVar2.g(bVar2.f26782e);
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
        this.f26783f = 2;
        this.f26784g = new a(this);
        this.f26785h = new C1303b(this);
        this.f26778a = context;
        this.f26779b = relativeLayout;
    }

    public static /* synthetic */ int b(b bVar) {
        int i2 = bVar.f26783f;
        bVar.f26783f = i2 - 1;
        return i2;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            IImageFramePlayerViewController iImageFramePlayerViewController = this.f26780c;
            if (iImageFramePlayerViewController != null) {
                iImageFramePlayerViewController.onDestroy();
            }
            AlaEffectPreviewView alaEffectPreviewView = this.f26781d;
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
            if (this.f26780c == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.f26778a)) != null && runTask.getData() != null) {
                IImageFramePlayerViewController iImageFramePlayerViewController = (IImageFramePlayerViewController) runTask.getData();
                this.f26780c = iImageFramePlayerViewController;
                iImageFramePlayerViewController.setFrameCallback(this.f26784g);
            }
            IImageFramePlayerViewController iImageFramePlayerViewController2 = this.f26780c;
            if (iImageFramePlayerViewController2 != null) {
                if (iImageFramePlayerViewController2.getAnimView().getParent() == null) {
                    this.f26779b.addView(this.f26780c.getAnimView(), new RelativeLayout.LayoutParams(-1, l.i(this.f26778a)));
                }
                AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
                AlaDynamicGift alaDynamicGift = alaEnterEffectData.gift;
                alaDynamicGiftAndNativeData.mAlaDynamicGift = alaDynamicGift;
                if (alaDynamicGift != null && (alaDynamicGiftConfigInfo = alaDynamicGift.configInfo) != null) {
                    alaDynamicGiftConfigInfo.isBottomMargin = 1;
                    alaDynamicGiftConfigInfo.oppositeY = 0.6499999761581421d;
                }
                alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
                this.f26780c.setData(alaDynamicGiftAndNativeData);
                this.f26780c.startAnim();
            }
        }
    }

    public final void f(AlaEnterEffectData alaEnterEffectData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, alaEnterEffectData) == null) {
            if (this.f26781d == null) {
                AlaEffectPreviewView alaEffectPreviewView = new AlaEffectPreviewView(this.f26778a);
                this.f26781d = alaEffectPreviewView;
                alaEffectPreviewView.setAnimCompleteCallback(this.f26785h);
            }
            if (this.f26781d.getParent() == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(2, R.id.effet_name_tv);
                layoutParams.bottomMargin = this.f26778a.getResources().getDimensionPixelSize(R.dimen.ds51);
                this.f26779b.addView(this.f26781d, layoutParams);
            }
            this.f26781d.setData(alaEnterEffectData);
            this.f26781d.startAnimtion();
        }
    }

    public void g(AlaEnterEffectData alaEnterEffectData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, alaEnterEffectData) == null) || alaEnterEffectData == null) {
            return;
        }
        this.f26782e = alaEnterEffectData;
        int i2 = alaEnterEffectData.type;
        if (i2 == 1) {
            this.f26783f = 2;
            e(alaEnterEffectData);
            f(alaEnterEffectData);
        } else if (i2 == 0) {
            f(alaEnterEffectData);
        }
    }
}

package com.baidu.live.business;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.base.LiveBaseItemView;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.view.banner.BannerEntity;
import com.baidu.live.business.view.banner.BannerView;
import com.baidu.tieba.R;
import com.baidu.tieba.oa0;
import com.baidu.tieba.qc0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class Live4Ratio5BannerItemView extends LiveBaseItemView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout h;
    public BannerView i;
    public boolean j;
    public Context k;

    /* loaded from: classes2.dex */
    public interface c {
        void a(LiveBannerEntity liveBannerEntity);

        void b(LiveBannerEntity liveBannerEntity);
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setIsCurViewing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    /* loaded from: classes2.dex */
    public class a implements BannerView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Live4Ratio5BannerItemView a;

        public a(Live4Ratio5BannerItemView live4Ratio5BannerItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {live4Ratio5BannerItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = live4Ratio5BannerItemView;
        }

        @Override // com.baidu.live.business.view.banner.BannerView.g
        public void a(LiveBannerEntity liveBannerEntity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, liveBannerEntity) == null) && this.a.e != null && liveBannerEntity != null) {
                this.a.e.b(liveBannerEntity);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements BannerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Live4Ratio5BannerItemView a;

        public b(Live4Ratio5BannerItemView live4Ratio5BannerItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {live4Ratio5BannerItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = live4Ratio5BannerItemView;
        }

        @Override // com.baidu.live.business.view.banner.BannerView.i
        public void onBannerShow(LiveBannerEntity liveBannerEntity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, liveBannerEntity) == null) && this.a.e != null && liveBannerEntity != null) {
                this.a.e.a(liveBannerEntity);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Live4Ratio5BannerItemView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = false;
        k(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Live4Ratio5BannerItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = false;
        k(context);
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            setNeedRatio(true);
            setAspectRatio(1.25f);
            this.k = context;
            this.h = (FrameLayout) RelativeLayout.inflate(context, R.layout.obfuscated_res_0x7f0d054c, this).findViewById(R.id.obfuscated_res_0x7f091497);
            j();
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            i();
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            h();
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            h();
        }
    }

    public final void h() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (bannerView = this.i) != null) {
            bannerView.w();
        }
    }

    public final void i() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (bannerView = this.i) != null && this.j) {
            bannerView.x();
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            BannerView bannerView = new BannerView(this.k);
            this.i = bannerView;
            bannerView.setShowRoundPicture(true, 10);
            this.i.setIndicatorGravity(81);
            this.i.setIndicatorMargin(0, 0, 0, (int) oa0.c(this.k.getResources(), 7.0f));
            this.i.setLargeIndicatorItemSize((int) oa0.c(this.k.getResources(), 4.0f));
            this.i.setSmallIndicatorItemSize((int) oa0.c(this.k.getResources(), 4.0f));
            this.i.setIndicatorInterval((int) oa0.c(this.k.getResources(), 6.0f));
            this.i.setAspectRatio(1.25f);
            this.i.setScene(this.c);
            this.i.setOnBannerClickListener(new a(this));
            this.i.setOnBannerShowListener(new b(this));
            this.h.addView(this.i, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void l(List<LiveBannerEntity> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, list) == null) && this.i != null && this.h != null) {
            int i = 8;
            if (!qc0.c(list)) {
                if (this.i.r(list)) {
                    BannerEntity bannerEntity = new BannerEntity();
                    bannerEntity.mBannerList = list;
                    bannerEntity.mBroadcastInterval = 5000;
                    this.i.setBannerEntity(bannerEntity);
                }
                this.i.setVisibility(0);
                this.j = true;
            } else {
                this.j = false;
                this.i.setVisibility(8);
            }
            FrameLayout frameLayout = this.h;
            if (this.i.getVisibility() == 0) {
                i = 0;
            }
            frameLayout.setVisibility(i);
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseItemView
    public void setData(LiveRoomEntity liveRoomEntity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, liveRoomEntity, i) == null) {
            l(liveRoomEntity.bannerList);
        }
    }
}

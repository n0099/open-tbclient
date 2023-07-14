package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.TbLiveCyberView;
import com.baidu.tieba.b85;
import com.baidu.tieba.d85;
import com.baidu.tieba.iu9;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TbLiveContainer extends FrameLayout implements iu9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbLiveCyberView a;
    public RoundRelativeLayout b;
    public ViewGroup c;
    public boolean d;
    public ThreadData e;
    public long f;
    public String g;
    public String h;
    public final CustomMessageListener i;

    @Override // com.baidu.tieba.iu9
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iu9
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbLiveContainer a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TbLiveContainer tbLiveContainer, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbLiveContainer, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbLiveContainer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage)) {
                return;
            }
            this.a.stopPlay();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TbLiveCyberView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbLiveContainer a;

        public b(TbLiveContainer tbLiveContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbLiveContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbLiveContainer;
        }

        @Override // com.baidu.tieba.ala.TbLiveCyberView.b
        public void onError() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.stopPlay();
            }
        }

        @Override // com.baidu.tieba.ala.TbLiveCyberView.b
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.b != null) {
                this.a.b.setVisibility(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbLiveContainer(@NonNull Context context) {
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
        this.d = false;
        this.i = new a(this, 2000994);
        d();
    }

    public void c(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            this.b.setVisibility(8);
            if (threadData != null && threadData.getThreadAlaInfo() != null) {
                this.e = threadData;
                AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
                if (!this.d) {
                    setLayout(threadAlaInfo);
                    this.d = true;
                }
                this.h = threadAlaInfo.hls_url;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbLiveContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        this.d = false;
        this.i = new a(this, 2000994);
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbLiveContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = false;
        this.i = new a(this, 2000994);
        d();
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            d85 d = d85.d(this.c);
            d.o(R.string.J_X05);
            d.f(R.color.CAM_X0201);
        }
    }

    public void setStaticsLocationPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.g = str;
        }
    }

    private void setLayout(AlaInfoData alaInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, alaInfoData) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.c.getLayoutParams();
            int i = 0;
            if (alaInfoData.isVertialLive()) {
                layoutParams.height = (((yi.l(getContext()) - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2)) * 9) / 16) - (yi.g(getContext(), R.dimen.M_H_X003) * 2);
                layoutParams.width = (this.b.getLayoutParams().height * 9) / 16;
                layoutParams2.rightMargin = yi.g(getContext(), R.dimen.M_W_X004);
                i = yi.g(getContext(), R.dimen.L_X02);
            } else {
                layoutParams.height = -1;
                layoutParams.width = -1;
                layoutParams2.rightMargin = 0;
            }
            this.c.setPadding(i, i, i, i);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.view_live_container, (ViewGroup) null);
            this.a = (TbLiveCyberView) inflate.findViewById(R.id.tbLiveCyberView);
            this.b = (RoundRelativeLayout) inflate.findViewById(R.id.frame_video);
            this.c = (ViewGroup) inflate.findViewById(R.id.stroke_background);
            addView(inflate, new ViewGroup.LayoutParams(-1, -1));
            this.b.setRoundLayoutRadius(b85.B(R.string.J_X05));
            this.b.setVisibility(8);
            this.a.setOuterListener(new b(this));
        }
    }

    public void f() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (threadData = this.e) == null || threadData.getThreadAlaInfo() == null || this.f == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f;
        StatisticItem statisticItem = new StatisticItem("c14355");
        statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis);
        statisticItem.param("tid", this.e.getTid());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("obj_locate", this.g);
        statisticItem.param("fid", this.e.getFid());
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.e.statFloor);
        statisticItem.param("end_type", getEndType());
        AlaInfoData threadAlaInfo = this.e.getThreadAlaInfo();
        if (threadAlaInfo.isLegalYYLiveData()) {
            String str = null;
            if (!StringUtils.isNull(threadAlaInfo.appId)) {
                str = threadAlaInfo.appId;
            }
            if (threadAlaInfo.mYyExtData != null) {
                str = TiebaStatic.YYValues.YY_LIVE;
            }
            statisticItem.addParam("obj_param1", YYLiveUtil.calculateLiveType(threadAlaInfo));
            statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, str);
            TiebaStaticHelper.addYYParam(statisticItem, threadAlaInfo.mYyExtData);
        }
        TiebaStatic.log(statisticItem);
    }

    @Override // com.baidu.tieba.iu9
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public String getEndType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String str = (String) getTag(-1001);
            if (TextUtils.isEmpty(str)) {
                str = "2";
            }
            setTag(-1001, "");
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iu9
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a.getOriginUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iu9
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.a.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.iu9
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.iu9
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.a.setVideoPath(this.h);
            this.a.start();
            this.f = System.currentTimeMillis();
            MessageManager.getInstance().registerListener(this.i);
        }
    }

    @Override // com.baidu.tieba.iu9
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a.n();
            f();
            this.f = 0L;
            this.b.setVisibility(8);
            MessageManager.getInstance().unRegisterListener(this.i);
        }
    }
}

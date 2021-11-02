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
import b.a.e.e.p.l;
import b.a.q0.s.q.d2;
import b.a.q0.s.u.c;
import b.a.r0.q2.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.TbLiveCyberView;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class TbLiveContainer extends FrameLayout implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbLiveCyberView f36829e;

    /* renamed from: f  reason: collision with root package name */
    public RoundRelativeLayout f36830f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f36831g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36832h;

    /* renamed from: i  reason: collision with root package name */
    public d2 f36833i;
    public long j;
    public String k;
    public String l;
    public final CustomMessageListener m;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbLiveContainer f36834a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TbLiveContainer tbLiveContainer, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbLiveContainer, Integer.valueOf(i2)};
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
            this.f36834a = tbLiveContainer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                this.f36834a.stopPlay();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements TbLiveCyberView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbLiveContainer f36835a;

        public b(TbLiveContainer tbLiveContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbLiveContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36835a = tbLiveContainer;
        }

        @Override // com.baidu.tieba.ala.TbLiveCyberView.b
        public void onError() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f36835a.stopPlay();
            }
        }

        @Override // com.baidu.tieba.ala.TbLiveCyberView.b
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f36835a.f36830f == null) {
                return;
            }
            this.f36835a.f36830f.setVisibility(0);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36832h = false;
        this.m = new a(this, 2000994);
        b();
    }

    private void setLayout(AlaInfoData alaInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, alaInfoData) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f36830f.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f36831g.getLayoutParams();
            int i2 = 0;
            if (alaInfoData.isVertialLive()) {
                layoutParams.height = (((l.k(getContext()) - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2)) * 9) / 16) - (l.g(getContext(), R.dimen.M_H_X003) * 2);
                layoutParams.width = (this.f36830f.getLayoutParams().height * 9) / 16;
                layoutParams2.rightMargin = l.g(getContext(), R.dimen.M_W_X004);
                i2 = l.g(getContext(), R.dimen.L_X02);
            } else {
                layoutParams.height = -1;
                layoutParams.width = -1;
                layoutParams2.rightMargin = 0;
            }
            this.f36831g.setPadding(i2, i2, i2, i2);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.view_live_container, (ViewGroup) null);
            this.f36829e = (TbLiveCyberView) inflate.findViewById(R.id.tbLiveCyberView);
            this.f36830f = (RoundRelativeLayout) inflate.findViewById(R.id.frame_video);
            this.f36831g = (ViewGroup) inflate.findViewById(R.id.stroke_background);
            addView(inflate, new ViewGroup.LayoutParams(-1, -1));
            this.f36830f.setRoundLayoutRadius(b.a.q0.s.u.a.y(R.string.J_X05));
            this.f36830f.setVisibility(8);
            this.f36829e.setOuterListener(new b(this));
        }
    }

    public void bindData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d2Var) == null) {
            this.f36830f.setVisibility(8);
            if (d2Var == null || d2Var.l1() == null) {
                return;
            }
            this.f36833i = d2Var;
            AlaInfoData l1 = d2Var.l1();
            if (!this.f36832h) {
                setLayout(l1);
                this.f36832h = true;
            }
            this.l = l1.hls_url;
        }
    }

    @Override // b.a.r0.q2.e
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f36829e.getCurrentPosition() : invokeV.intValue;
    }

    public String getEndType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String str = (String) getTag(-1001);
            if (TextUtils.isEmpty(str)) {
                str = "2";
            }
            setTag(-1001, "");
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.r0.q2.e
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f36829e.getOriginUrl() : (String) invokeV.objValue;
    }

    @Override // b.a.r0.q2.e
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // b.a.r0.q2.e
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.q2.e
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f36829e.isPlaying() : invokeV.booleanValue;
    }

    @Override // b.a.r0.q2.e
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f36829e.isPlaying() : invokeV.booleanValue;
    }

    public void onChangeSkin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            c d2 = c.d(this.f36831g);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0201);
        }
    }

    public void setStaticsLocationPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.k = str;
        }
    }

    @Override // b.a.r0.q2.e
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f36829e.setVideoPath(this.l);
            this.f36829e.start();
            this.j = System.currentTimeMillis();
            MessageManager.getInstance().registerListener(this.m);
        }
    }

    public void statisticLiveDuration() {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (d2Var = this.f36833i) == null || d2Var.l1() == null || this.j == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.j;
        StatisticItem statisticItem = new StatisticItem("c14355");
        statisticItem.param(TiebaStatic.Params.OBJ_DURATION, currentTimeMillis);
        statisticItem.param("tid", this.f36833i.s1());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("obj_locate", this.k);
        statisticItem.param("fid", this.f36833i.T());
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.f36833i.T1);
        statisticItem.param("end_type", getEndType());
        AlaInfoData l1 = this.f36833i.l1();
        if (l1.isLegalYYLiveData()) {
            String str = StringUtils.isNull(l1.appId) ? null : l1.appId;
            if (l1.mYyExtData != null) {
                str = TiebaStatic.YYValues.YY_LIVE;
            }
            statisticItem.addParam("obj_param1", YYLiveUtil.calculateLiveType(l1));
            statisticItem.addParam(TiebaStatic.Params.OBJ_PARAM2, str);
            TiebaStaticHelper.addYYParam(statisticItem, l1.mYyExtData);
        }
        TiebaStatic.log(statisticItem);
    }

    @Override // b.a.r0.q2.e
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f36829e.stop();
            statisticLiveDuration();
            this.j = 0L;
            this.f36830f.setVisibility(8);
            MessageManager.getInstance().unRegisterListener(this.m);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f36832h = false;
        this.m = new a(this, 2000994);
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbLiveContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f36832h = false;
        this.m = new a(this, 2000994);
        b();
    }
}

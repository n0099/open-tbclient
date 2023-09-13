package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.b15;
import com.baidu.tieba.dz;
import com.baidu.tieba.ux;
import com.baidu.tieba.view.TbImageAutoSwitch;
import com.baidu.tieba.z35;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class HeadlinesAgreeCardView extends FrameLayout implements ux<b15> {
    public static /* synthetic */ Interceptable $ic;
    public static final int k;
    public static final int l;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public HeadlinesAgreeRewardContainer b;
    public TbImageView c;
    public TbImageAutoSwitch d;
    public TextView e;
    public HeadlinesItemInfoView f;
    public z35 g;
    public dz h;
    public final List<String> i;
    public final TbImageAutoSwitch.b j;

    /* loaded from: classes3.dex */
    public class a implements TbImageAutoSwitch.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HeadlinesAgreeCardView a;

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        public a(HeadlinesAgreeCardView headlinesAgreeCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headlinesAgreeCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = headlinesAgreeCardView;
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void a(View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
                String str = (String) ListUtils.getItem(this.a.i, i);
                if (!StringUtils.isNull(str) && (view2 instanceof HeadImageView)) {
                    ((HeadImageView) view2).startLoad(str, 12, false);
                }
            }
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HeadImageView headImageView = new HeadImageView(this.a.getContext());
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(HeadlinesAgreeCardView.l, HeadlinesAgreeCardView.l));
                headImageView.setBorderWidth(HeadlinesAgreeCardView.m);
                headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
                headImageView.setIsRound(true);
                headImageView.setDrawBorder(true);
                headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                headImageView.setPlaceHolder(1);
                return headImageView;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a.i.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HeadlinesAgreeCardView a;

        public b(HeadlinesAgreeCardView headlinesAgreeCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headlinesAgreeCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = headlinesAgreeCardView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.f();
                if (this.a.h != null) {
                    this.a.h.a();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1612265088, "Lcom/baidu/card/view/HeadlinesAgreeCardView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1612265088, "Lcom/baidu/card/view/HeadlinesAgreeCardView;");
                return;
            }
        }
        k = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
        l = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62);
        m = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeadlinesAgreeCardView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeadlinesAgreeCardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadlinesAgreeCardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.i = new ArrayList();
        this.j = new a(this);
        e(context);
    }

    public void f() {
        z35 z35Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (z35Var = this.g) != null && !TextUtils.isEmpty(z35Var.a())) {
            BrowserHelper.startWebActivity(getContext(), (String) null, this.g.a(), true);
        }
    }

    public void g() {
        z35 z35Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (z35Var = this.g) != null && !TextUtils.isEmpty(z35Var.i())) {
            BrowserHelper.startWebActivity(getContext(), (String) null, this.g.i(), true);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            EMManager.from(this.e).setTextColor(R.color.CAM_X0109);
        }
    }

    public void j(@NonNull ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, threadData) == null) {
            this.f.b(this.g);
        }
    }

    public void setItemBtnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.f.setOnButtonClickListener(onClickListener);
        }
    }

    public void setOnStatListener(dz dzVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dzVar) == null) {
            this.h = dzVar;
        }
    }

    public final void e(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.headlines_agree_card_view, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.headlines_background);
            this.a = tbImageView;
            tbImageView.setRadiusById(R.string.J_X05);
            this.a.addCornerFlags(15);
            this.a.setImageResource(R.drawable.icon_pic_bg_toutiaotie);
            this.b = (HeadlinesAgreeRewardContainer) findViewById(R.id.headlines_rewards_container);
            TbImageView tbImageView2 = (TbImageView) findViewById(R.id.right_bottom_icon);
            this.c = tbImageView2;
            tbImageView2.setAutoChangeStyle(true);
            this.c.setDrawCorner(true);
            this.c.setRadiusById(R.string.J_X05);
            this.c.addCornerFlags(8);
            this.c.setImageResource(R.drawable.icon_pic_bg_toutiao_choujiang);
            TbImageAutoSwitch tbImageAutoSwitch = (TbImageAutoSwitch) findViewById(R.id.headlines_auto_switch);
            this.d = tbImageAutoSwitch;
            int i = l;
            tbImageAutoSwitch.l(4, i, i, k);
            this.d.setAnimationDuration(500);
            this.d.setCarouselDelayPeriod(2000);
            this.d.setCarouselPeriod(2000);
            this.d.setAdapter(this.j);
            this.e = (TextView) findViewById(R.id.headlines_auto_switch_text);
            this.f = (HeadlinesItemInfoView) findViewById(R.id.headlines_item_info);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ux
    /* renamed from: h */
    public void onBindDataToView(b15 b15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, b15Var) == null) && b15Var != null && b15Var.getThreadData() != null && b15Var.getThreadData().getTaskInfoData() != null && b15Var.getThreadData().getTaskInfoData().f() != null) {
            z35 f = b15Var.getThreadData().getTaskInfoData().f();
            this.g = f;
            this.b.setData(f);
            this.i.clear();
            this.i.addAll(this.g.e());
            this.d.q();
            if (!TextUtils.isEmpty(this.g.h())) {
                this.e.setText(this.g.h());
            }
            j(b15Var.getThreadData());
            this.f.setOnBannerClickListener(new b(this));
            dz dzVar = this.h;
            if (dzVar != null) {
                dzVar.onShow();
            }
        }
    }
}

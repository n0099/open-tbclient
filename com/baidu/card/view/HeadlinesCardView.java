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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.j45;
import com.baidu.tieba.kw4;
import com.baidu.tieba.nu4;
import com.baidu.tieba.rr4;
import com.baidu.tieba.rx;
import com.baidu.tieba.view.TbImageAutoSwitch;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class HeadlinesCardView extends FrameLayout implements rx<rr4> {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public static final int p;
    public transient /* synthetic */ FieldHolder $fh;
    public rr4 a;
    public TbImageView b;
    public TbImageView c;
    public ImageView d;
    public TextView e;
    public View f;
    public ImageProgressView g;
    public TbImageAutoSwitch h;
    public TextView i;
    public HeadlinesItemInfoView j;
    public zy k;
    public List<String> l;
    public TbImageAutoSwitch.b m;

    /* loaded from: classes.dex */
    public class a implements TbImageAutoSwitch.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HeadlinesCardView a;

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        public a(HeadlinesCardView headlinesCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headlinesCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = headlinesCardView;
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void a(View view2, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) && (view2 instanceof HeadImageView)) {
                ((HeadImageView) view2).K((String) this.a.l.get(i), 12, false);
            }
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HeadImageView headImageView = new HeadImageView(this.a.getContext());
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(HeadlinesCardView.n, HeadlinesCardView.n));
                headImageView.setBorderWidth(HeadlinesCardView.p);
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
                return this.a.l.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu4 a;
        public final /* synthetic */ HeadlinesCardView b;

        public b(HeadlinesCardView headlinesCardView, nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headlinesCardView, nu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = headlinesCardView;
            this.a = nu4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!TextUtils.isEmpty(this.a.a())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view2.getContext(), null, this.a.a(), true)));
                }
                if (this.b.k != null) {
                    this.b.k.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nu4 a;
        public final /* synthetic */ HeadlinesCardView b;

        public c(HeadlinesCardView headlinesCardView, nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headlinesCardView, nu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = headlinesCardView;
            this.a = nu4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!TextUtils.isEmpty(this.a.h())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(view2.getContext(), null, this.a.h(), true)));
                }
                if (this.b.k != null) {
                    this.b.k.b();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HeadlinesCardView a;

        public d(HeadlinesCardView headlinesCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headlinesCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = headlinesCardView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null) {
                j45.f(this.a.getContext(), this.a.a.getThreadData(), 1, 2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1943058816, "Lcom/baidu/card/view/HeadlinesCardView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1943058816, "Lcom/baidu/card/view/HeadlinesCardView;");
                return;
            }
        }
        n = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62);
        o = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds30);
        p = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeadlinesCardView(@NonNull Context context) {
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
    public HeadlinesCardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
    public HeadlinesCardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = null;
        this.l = new ArrayList();
        this.m = new a(this);
        g();
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            kw4.d(this.i).v(R.color.CAM_X0109);
            WebPManager.setPureDrawable(this.d, R.drawable.obfuscated_res_0x7f08094d, R.color.CAM_X0305, null);
            kw4.d(this.e).v(R.color.CAM_X0305);
        }
    }

    public void setOnStatListener(zy zyVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, zyVar) == null) {
            this.k = zyVar;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0391, (ViewGroup) this, true);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090d8d);
            this.b = tbImageView;
            tbImageView.setRadiusById(R.string.J_X05);
            this.b.r(15);
            this.b.setImageResource(R.drawable.obfuscated_res_0x7f0808e7);
            TbImageView tbImageView2 = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091c75);
            this.c = tbImageView2;
            tbImageView2.setAutoChangeStyle(true);
            this.c.setDrawCorner(true);
            this.c.setRadiusById(R.string.J_X05);
            this.c.r(8);
            this.c.setImageResource(R.drawable.obfuscated_res_0x7f0808e6);
            this.g = (ImageProgressView) findViewById(R.id.obfuscated_res_0x7f090d90);
            TbImageAutoSwitch tbImageAutoSwitch = (TbImageAutoSwitch) findViewById(R.id.obfuscated_res_0x7f090d8b);
            this.h = tbImageAutoSwitch;
            int i = n;
            tbImageAutoSwitch.l(4, i, i, o);
            this.h.setAnimationDuration(500);
            this.h.setCarouselDelayPeriod(2000);
            this.h.setCarouselPeriod(2000);
            this.h.setAdapter(this.m);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f090d8c);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f090d97);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f090d98);
            this.f = findViewById(R.id.obfuscated_res_0x7f090d96);
            this.j = (HeadlinesItemInfoView) findViewById(R.id.obfuscated_res_0x7f090d93);
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rx
    /* renamed from: h */
    public void a(rr4 rr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rr4Var) == null) {
            this.a = rr4Var;
            if (rr4Var != null && rr4Var.getThreadData() != null && rr4Var.getThreadData().getTaskInfoData() != null && rr4Var.getThreadData().getTaskInfoData().e() != null) {
                nu4 e = rr4Var.getThreadData().getTaskInfoData().e();
                this.g.c(e);
                this.l.clear();
                this.l.addAll(e.d());
                this.h.p();
                if (!TextUtils.isEmpty(e.g())) {
                    this.i.setText(e.g());
                }
                this.j.b(e);
                this.j.setOnBannerClickListener(new b(this, e));
                this.j.setOnButtonClickListener(new c(this, e));
                this.f.setOnClickListener(new d(this));
                zy zyVar = this.k;
                if (zyVar != null) {
                    zyVar.onShow();
                }
            }
        }
    }
}

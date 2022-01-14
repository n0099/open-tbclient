package com.baidu.poly.widget.digitalbank;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import c.a.h0.c;
import c.a.h0.g;
import c.a.h0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PayChannelEntity;
import com.baidu.poly.widget.ProgressButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes10.dex */
public class DigitalBankPayView extends FrameLayout implements View.OnClickListener, AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ListView f37856e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressButton f37857f;

    /* renamed from: g  reason: collision with root package name */
    public List<PayChannelEntity> f37858g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.h0.t.d.a f37859h;

    /* renamed from: i  reason: collision with root package name */
    public b f37860i;

    /* loaded from: classes10.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DigitalBankPayView a;

        public a(DigitalBankPayView digitalBankPayView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {digitalBankPayView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = digitalBankPayView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void onDigitalBankPayViewClick(int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DigitalBankPayView(Context context) {
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
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(h.poly_sdk_bank_list, (ViewGroup) this, true);
            this.f37856e = (ListView) findViewById(g.poly_sdk_bank_list_view);
            ProgressButton progressButton = (ProgressButton) findViewById(g.poly_sdk_digital_bank_pay);
            this.f37857f = progressButton;
            progressButton.setText("下一步");
            this.f37857f.setOnClickListener(this);
            this.f37856e.setOnItemClickListener(this);
        }
    }

    public PayChannelEntity getSelectedChildrenEntity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<PayChannelEntity> list = this.f37858g;
            if (list == null || list.size() <= 0) {
                return null;
            }
            for (int i2 = 0; i2 < this.f37858g.size(); i2++) {
                if (this.f37858g.get(i2).getIsSelected() == 1) {
                    return this.f37858g.get(i2);
                }
            }
            return null;
        }
        return (PayChannelEntity) invokeV.objValue;
    }

    public void hideDigitalBankListView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), c.slide_left_2_right);
            loadAnimation.setAnimationListener(new a(this));
            startAnimation(loadAnimation);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view.getId() == g.poly_sdk_digital_bank_pay) {
            this.f37857f.setEnable(false);
            b bVar = this.f37860i;
            if (bVar != null) {
                bVar.onDigitalBankPayViewClick(view.getId());
            }
            this.f37857f.setEnable(true);
            this.f37857f.setPressed(false);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            List<PayChannelEntity> list = this.f37858g;
            if (list != null && list.size() > 0 && i2 >= 0 && i2 < this.f37858g.size()) {
                for (int i3 = 0; i3 < this.f37858g.size(); i3++) {
                    PayChannelEntity payChannelEntity = this.f37858g.get(i3);
                    if (i3 == i2) {
                        if (payChannelEntity.getIsSelected() == 0) {
                            payChannelEntity.setIsSelected(1);
                        }
                    } else {
                        payChannelEntity.setIsSelected(0);
                    }
                }
            }
            this.f37859h.b(this.f37858g);
            this.f37859h.notifyDataSetChanged();
        }
    }

    public void setOptionListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f37860i = bVar;
        }
    }

    public void showDigitalBankListView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setVisibility(0);
            startAnimation(AnimationUtils.loadAnimation(getContext(), c.slide_right_2_left));
        }
    }

    public void update(List<PayChannelEntity> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f37858g = list;
            if (this.f37859h == null) {
                this.f37859h = new c.a.h0.t.d.a(getContext());
            }
            this.f37856e.setAdapter((ListAdapter) this.f37859h);
            this.f37859h.b(this.f37858g);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DigitalBankPayView(Context context, AttributeSet attributeSet) {
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
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DigitalBankPayView(Context context, AttributeSet attributeSet, int i2) {
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
        a(context);
    }
}

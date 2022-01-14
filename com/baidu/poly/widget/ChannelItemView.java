package com.baidu.poly.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.h0.d;
import c.a.h0.f;
import c.a.h0.g;
import c.a.h0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.entitiy.InstallmentEntity;
import com.baidu.poly.widget.entitiy.PayChannelExtInfoEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class ChannelItemView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f37739e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f37740f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f37741g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f37742h;

    /* renamed from: i  reason: collision with root package name */
    public c f37743i;

    /* renamed from: j  reason: collision with root package name */
    public b f37744j;
    public TextView k;
    public LinearLayout l;
    public LinearLayout m;
    public LinearLayout n;
    public TextView o;
    public TextView p;
    public boolean q;
    public boolean r;
    public String s;
    public TextView t;
    public PayChannelEntity u;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InstallmentEntity f37745e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ChannelItemView f37746f;

        public a(ChannelItemView channelItemView, InstallmentEntity installmentEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelItemView, installmentEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37746f = channelItemView;
            this.f37745e = installmentEntity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.h0.p.a.f3597c++;
                if (this.f37746f.f37744j != null) {
                    this.f37746f.f37744j.a(this.f37745e);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(InstallmentEntity installmentEntity);
    }

    /* loaded from: classes10.dex */
    public interface c {
        void a(ChannelItemView channelItemView);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChannelItemView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static int dp2px(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(InputDeviceCompat.SOURCE_TRACKBALL, null, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(h.view_channel_list_item, (ViewGroup) this, true);
            this.f37739e = (ImageView) findViewById(g.channel_icon_view);
            this.f37740f = (TextView) findViewById(g.channel_name_view);
            this.f37741g = (TextView) findViewById(g.channel_desc_view);
            this.f37742h = (ImageView) findViewById(g.channel_select_view);
            this.l = (LinearLayout) findViewById(g.ll_installment_group);
            this.m = (LinearLayout) findViewById(g.ll_instalment_money);
            this.n = (LinearLayout) findViewById(g.ll_instalment_detail);
            this.o = (TextView) findViewById(g.tv_instalment_money);
            this.p = (TextView) findViewById(g.tv_service_charge);
            this.k = (TextView) findViewById(g.installmentTitle);
            this.t = (TextView) findViewById(g.poly_sdk_pay_channel_disable_desc);
            setOnClickListener(this);
        }
    }

    public final void c(PayChannelEntity payChannelEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, payChannelEntity) == null) {
            PayChannelExtInfoEntity payChannelExtInfoEntity = payChannelEntity.getPayChannelExtInfoEntity();
            if (payChannelExtInfoEntity == null) {
                this.l.setVisibility(8);
                return;
            }
            ArrayList<InstallmentEntity> installmentEntities = payChannelExtInfoEntity.getInstallmentEntities();
            if (installmentEntities != null && installmentEntities.size() != 0) {
                updateInstallDetail(installmentEntities);
                for (int i2 = 0; i2 < installmentEntities.size(); i2++) {
                    InstallmentEntity installmentEntity = installmentEntities.get(i2);
                    this.m.setVisibility(0);
                    TextView textView = this.o;
                    String str = this.s;
                    if (str == null) {
                        str = "";
                    }
                    textView.setText(str);
                    if (installmentEntity != null && installmentEntity.isSelected()) {
                        this.f37741g.setText(installmentEntity.getDisplay());
                        this.p.setText(installmentEntity.getPayText());
                        payChannelEntity.setInstallmentPeriod(installmentEntity.getInstallmentPeriod());
                        this.q = true;
                        return;
                    }
                }
                return;
            }
            this.l.setVisibility(8);
        }
    }

    public LinearLayout generateChildLinearLayout(InstallmentEntity installmentEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, installmentEntity)) == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(1);
            if (installmentEntity == null) {
                return linearLayout;
            }
            linearLayout.setGravity(16);
            linearLayout.setPadding(dp2px(getContext(), 10.0f), 0, 0, 0);
            linearLayout.setBackgroundResource(f.channel_list_installment_shape_selector);
            linearLayout.setEnabled(true ^ installmentEntity.isSelected());
            TextView textView = new TextView(getContext());
            textView.setTextSize(11.0f);
            if (installmentEntity.isSelected()) {
                textView.setTextColor(getContext().getResources().getColor(d.period_item_checked_color));
            } else {
                textView.setTextColor(getContext().getResources().getColor(d.title_color));
            }
            textView.setText(installmentEntity.getTitle() == null ? "" : installmentEntity.getTitle());
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            linearLayout.addView(textView);
            TextView textView2 = new TextView(getContext());
            if (installmentEntity.isSelected()) {
                textView2.setTextColor(getContext().getResources().getColor(d.period_item_checked_color));
            } else {
                textView2.setTextColor(getContext().getResources().getColor(d.period_item_sub_title_color));
            }
            textView2.setTextSize(11.0f);
            textView2.setText(installmentEntity.getDisplay() != null ? installmentEntity.getDisplay() : "");
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, dp2px(getContext(), 4.0f), 0, 0);
            textView2.setLayoutParams(layoutParams2);
            linearLayout.addView(textView2);
            linearLayout.setOnClickListener(new a(this, installmentEntity));
            return linearLayout;
        }
        return (LinearLayout) invokeL.objValue;
    }

    public boolean hasChoseInstallmentPeriod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.q : invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, view) == null) || 1 == this.u.disAbled || (cVar = this.f37743i) == null) {
            return;
        }
        cVar.a(this);
    }

    public void setChannelInfo(PayChannelEntity payChannelEntity, c cVar, b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, payChannelEntity, cVar, bVar, str) == null) {
            this.s = str;
            this.u = payChannelEntity;
            String displayName = payChannelEntity.getDisplayName();
            String payText = payChannelEntity.getPayText();
            String icon = payChannelEntity.getIcon();
            int isSelected = payChannelEntity.getIsSelected();
            int enable = payChannelEntity.getEnable();
            c.a.h0.m.b.b().a(this.f37739e, icon);
            this.f37740f.setText(displayName);
            if (isSelected == 1) {
                this.f37742h.setImageResource(f.channel_checked);
                this.r = true;
            } else {
                this.f37742h.setImageResource(f.unchecked);
                this.r = false;
            }
            if (1 == enable) {
                this.f37743i = cVar;
                this.f37744j = bVar;
            } else {
                this.f37739e.setAlpha(0.4f);
                this.f37740f.setAlpha(0.4f);
                this.f37741g.setAlpha(0.4f);
                this.f37742h.setVisibility(8);
            }
            if (1 == payChannelEntity.disAbled && !TextUtils.isEmpty(payChannelEntity.disAbledMsg)) {
                this.f37740f.setTextColor(Color.parseColor("#B8B8B8"));
                this.t.setVisibility(0);
                this.t.setText(payChannelEntity.disAbledMsg);
                this.f37742h.setAlpha(0.4f);
            } else {
                this.f37740f.setTextColor(Color.parseColor("#1F1F1F"));
                this.t.setVisibility(8);
                this.f37742h.setAlpha(1.0f);
            }
            if (!TextUtils.isEmpty(payText)) {
                String displayColor = payChannelEntity.getDisplayColor();
                if (!TextUtils.isEmpty(displayColor)) {
                    try {
                        this.f37741g.setTextColor(Color.parseColor(displayColor));
                    } catch (Exception unused) {
                    }
                }
                this.f37741g.setText(payText);
                this.f37741g.setVisibility(0);
            }
            c(payChannelEntity);
        }
    }

    public void setShowInstallDetail(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.r = z;
        }
    }

    public void updateInstallDetail(ArrayList<InstallmentEntity> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                if (this.r) {
                    this.l.setVisibility(0);
                }
                int size = arrayList.size();
                int i2 = (size / 2) + (size % 2);
                for (int i3 = 0; i3 < i2; i3++) {
                    int i4 = i3 * 2;
                    InstallmentEntity installmentEntity = arrayList.get(i4);
                    int i5 = i4 + 1;
                    InstallmentEntity installmentEntity2 = i5 < size ? arrayList.get(i5) : null;
                    if (installmentEntity != null) {
                        LinearLayout linearLayout = new LinearLayout(getContext());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dp2px(getContext(), 54.0f));
                        linearLayout.setGravity(16);
                        linearLayout.setPadding(0, dp2px(getContext(), 4.5f), 0, dp2px(getContext(), 4.5f));
                        linearLayout.setLayoutParams(layoutParams);
                        linearLayout.setOrientation(0);
                        linearLayout.addView(generateChildLinearLayout(installmentEntity));
                        View view = new View(getContext());
                        view.setLayoutParams(new LinearLayout.LayoutParams(dp2px(getContext(), 8.0f), 1));
                        linearLayout.addView(view);
                        linearLayout.addView(generateChildLinearLayout(installmentEntity2));
                        this.n.addView(linearLayout);
                    }
                }
                return;
            }
            this.l.setVisibility(8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChannelItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelItemView(Context context, AttributeSet attributeSet, int i2) {
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
        b(context);
    }
}

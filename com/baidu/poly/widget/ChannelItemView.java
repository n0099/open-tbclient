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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.entitiy.InstallmentEntity;
import com.baidu.poly.widget.entitiy.PayChannelExtInfoEntity;
import com.baidu.tieba.R;
import com.baidu.tieba.qc1;
import com.baidu.tieba.zb1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ChannelItemView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public TextView b;
    public TextView c;
    public ImageView d;
    public c e;
    public b f;
    public TextView g;
    public LinearLayout h;
    public LinearLayout i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public boolean m;
    public String n;
    public TextView o;
    public PayChannelEntity p;

    /* loaded from: classes2.dex */
    public interface b {
        void a(InstallmentEntity installmentEntity);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(ChannelItemView channelItemView);
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InstallmentEntity a;
        public final /* synthetic */ ChannelItemView b;

        public a(ChannelItemView channelItemView, InstallmentEntity installmentEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {channelItemView, installmentEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = channelItemView;
            this.a = installmentEntity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                qc1.c++;
                if (this.b.f != null) {
                    this.b.f.a(this.a);
                }
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelItemView(Context context, AttributeSet attributeSet, int i) {
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
        d(context);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && 1 != this.p.disAbled && (cVar = this.e) != null) {
            cVar.a(this);
        }
    }

    public void setShowInstallDetail(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.m = z;
        }
    }

    public static int b(Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(InputDeviceCompat.SOURCE_TRACKBALL, null, context, f)) == null) {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return invokeLF.intValue;
    }

    public LinearLayout c(InstallmentEntity installmentEntity) {
        InterceptResult invokeL;
        String title;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, installmentEntity)) == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(1);
            if (installmentEntity == null) {
                return linearLayout;
            }
            linearLayout.setGravity(16);
            linearLayout.setPadding(b(getContext(), 10.0f), 0, 0, 0);
            linearLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f080454);
            linearLayout.setEnabled(true ^ installmentEntity.isSelected());
            TextView textView = new TextView(getContext());
            textView.setTextSize(11.0f);
            if (installmentEntity.isSelected()) {
                textView.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060902));
            } else {
                textView.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060b00));
            }
            String str = "";
            if (installmentEntity.getTitle() == null) {
                title = "";
            } else {
                title = installmentEntity.getTitle();
            }
            textView.setText(title);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            linearLayout.addView(textView);
            TextView textView2 = new TextView(getContext());
            if (installmentEntity.isSelected()) {
                textView2.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060902));
            } else {
                textView2.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060903));
            }
            textView2.setTextSize(11.0f);
            if (installmentEntity.getDisplay() != null) {
                str = installmentEntity.getDisplay();
            }
            textView2.setText(str);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, b(getContext(), 4.0f), 0, 0);
            textView2.setLayoutParams(layoutParams2);
            linearLayout.addView(textView2);
            linearLayout.setOnClickListener(new a(this, installmentEntity));
            return linearLayout;
        }
        return (LinearLayout) invokeL.objValue;
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d08ff, (ViewGroup) this, true);
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f090609);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f090613);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090608);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f090615);
            this.h = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091433);
            this.i = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091435);
            this.j = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091434);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f092403);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f092450);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f090f72);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f091a63);
            setOnClickListener(this);
        }
    }

    public void e(ArrayList<InstallmentEntity> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                if (this.m) {
                    this.h.setVisibility(0);
                }
                int size = arrayList.size();
                int i = (size / 2) + (size % 2);
                for (int i2 = 0; i2 < i; i2++) {
                    int i3 = i2 * 2;
                    InstallmentEntity installmentEntity = arrayList.get(i3);
                    InstallmentEntity installmentEntity2 = null;
                    int i4 = i3 + 1;
                    if (i4 < size) {
                        installmentEntity2 = arrayList.get(i4);
                    }
                    if (installmentEntity != null) {
                        LinearLayout linearLayout = new LinearLayout(getContext());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, b(getContext(), 54.0f));
                        linearLayout.setGravity(16);
                        linearLayout.setPadding(0, b(getContext(), 4.5f), 0, b(getContext(), 4.5f));
                        linearLayout.setLayoutParams(layoutParams);
                        linearLayout.setOrientation(0);
                        linearLayout.addView(c(installmentEntity));
                        View view2 = new View(getContext());
                        view2.setLayoutParams(new LinearLayout.LayoutParams(b(getContext(), 8.0f), 1));
                        linearLayout.addView(view2);
                        linearLayout.addView(c(installmentEntity2));
                        this.j.addView(linearLayout);
                    }
                }
                return;
            }
            this.h.setVisibility(8);
        }
    }

    public final void f(PayChannelEntity payChannelEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, payChannelEntity) == null) {
            PayChannelExtInfoEntity payChannelExtInfoEntity = payChannelEntity.getPayChannelExtInfoEntity();
            if (payChannelExtInfoEntity == null) {
                this.h.setVisibility(8);
                return;
            }
            ArrayList<InstallmentEntity> installmentEntities = payChannelExtInfoEntity.getInstallmentEntities();
            if (installmentEntities != null && installmentEntities.size() != 0) {
                e(installmentEntities);
                for (int i = 0; i < installmentEntities.size(); i++) {
                    InstallmentEntity installmentEntity = installmentEntities.get(i);
                    this.i.setVisibility(0);
                    TextView textView = this.k;
                    String str = this.n;
                    if (str == null) {
                        str = "";
                    }
                    textView.setText(str);
                    if (installmentEntity != null && installmentEntity.isSelected()) {
                        this.c.setText(installmentEntity.getDisplay());
                        this.l.setText(installmentEntity.getPayText());
                        payChannelEntity.setInstallmentPeriod(installmentEntity.getInstallmentPeriod());
                        return;
                    }
                }
                return;
            }
            this.h.setVisibility(8);
        }
    }

    public void setChannelInfo(PayChannelEntity payChannelEntity, c cVar, b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, payChannelEntity, cVar, bVar, str) == null) {
            this.n = str;
            this.p = payChannelEntity;
            String displayName = payChannelEntity.getDisplayName();
            String payText = payChannelEntity.getPayText();
            String icon = payChannelEntity.getIcon();
            int isSelected = payChannelEntity.getIsSelected();
            int enable = payChannelEntity.getEnable();
            zb1.b().a(this.a, icon);
            this.b.setText(displayName);
            if (isSelected == 1) {
                this.d.setImageResource(R.drawable.obfuscated_res_0x7f080450);
                this.m = true;
            } else {
                this.d.setImageResource(R.drawable.obfuscated_res_0x7f0812aa);
                this.m = false;
            }
            if (1 == enable) {
                this.e = cVar;
                this.f = bVar;
            } else {
                this.a.setAlpha(0.4f);
                this.b.setAlpha(0.4f);
                this.c.setAlpha(0.4f);
                this.d.setVisibility(8);
            }
            if (1 == payChannelEntity.disAbled && !TextUtils.isEmpty(payChannelEntity.disAbledMsg)) {
                this.b.setTextColor(Color.parseColor("#B8B8B8"));
                this.o.setVisibility(0);
                this.o.setText(payChannelEntity.disAbledMsg);
                this.d.setAlpha(0.4f);
            } else {
                this.b.setTextColor(Color.parseColor("#1F1F1F"));
                this.o.setVisibility(8);
                this.d.setAlpha(1.0f);
            }
            if (!TextUtils.isEmpty(payText)) {
                String displayColor = payChannelEntity.getDisplayColor();
                if (!TextUtils.isEmpty(displayColor)) {
                    try {
                        this.c.setTextColor(Color.parseColor(displayColor));
                    } catch (Exception unused) {
                    }
                }
                this.c.setText(payText);
                this.c.setVisibility(0);
            }
            f(payChannelEntity);
        }
    }
}

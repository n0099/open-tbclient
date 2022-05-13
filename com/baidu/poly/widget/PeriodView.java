package com.baidu.poly.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.entitiy.InstallmentEntity;
import com.baidu.poly.widget.entitiy.PayChannelExtInfoEntity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.k91;
import com.repackage.n91;
import com.repackage.oa1;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PeriodView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public PolyFrameLayout c;
    public View d;
    public d e;
    public View f;
    public ListView g;
    public View h;
    public TextView i;
    public TextView j;
    public PayChannelEntity k;
    public oa1 l;
    public InstallmentEntity m;
    public String n;

    /* loaded from: classes2.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PeriodView a;

        public a(PeriodView periodView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {periodView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = periodView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.a.h.setAlpha(0.2f);
                    return false;
                } else if (action != 1) {
                    return false;
                } else {
                    this.a.h.setAlpha(1.0f);
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PeriodView a;

        public b(PeriodView periodView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {periodView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = periodView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PayChannelExtInfoEntity payChannelExtInfoEntity;
            ArrayList<InstallmentEntity> installmentEntities;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.e == null || this.a.k == null || this.a.k.getPayChannelExtInfoEntity() == null || (payChannelExtInfoEntity = this.a.k.getPayChannelExtInfoEntity()) == null || (installmentEntities = payChannelExtInfoEntity.getInstallmentEntities()) == null) {
                return;
            }
            for (int i = 0; i < installmentEntities.size(); i++) {
                InstallmentEntity installmentEntity = installmentEntities.get(i);
                if (this.a.m == installmentEntity) {
                    installmentEntity.setIsSelected("1");
                } else {
                    installmentEntity.setIsSelected("0");
                }
            }
            this.a.e.a();
            this.a.e.b("confirm");
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PeriodView a;

        public c(PeriodView periodView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {periodView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = periodView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.e == null) {
                return;
            }
            this.a.e.b("back");
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a();

        void b(String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PeriodView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = false;
        e(context);
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0698, (ViewGroup) this, true);
            this.c = (PolyFrameLayout) findViewById(R.id.obfuscated_res_0x7f091b24);
            this.d = findViewById(R.id.obfuscated_res_0x7f09178b);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f090618);
            this.h = findViewById;
            findViewById.setOnTouchListener(new a(this));
            this.h.setOnClickListener(new b(this));
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f0902f3);
            this.f = findViewById2;
            findViewById2.setOnClickListener(new c(this));
            this.g = (ListView) findViewById(R.id.obfuscated_res_0x7f09178c);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f090f18);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f090694);
            oa1 oa1Var = new oa1(getContext());
            this.l = oa1Var;
            this.g.setAdapter((ListAdapter) oa1Var);
            setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            k91 k91Var = new k91("10");
            k91Var.a("type", this.n);
            n91.e(k91Var);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!this.b && this.a && (dVar = this.e) != null) {
                dVar.b("back");
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void setListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.e = dVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PeriodView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = false;
        e(context);
    }
}

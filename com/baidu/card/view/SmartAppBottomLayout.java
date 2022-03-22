package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.a.d.f.p.n;
import c.a.l.p;
import c.a.o0.r.r.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class SmartAppBottomLayout extends LinearLayout implements p<a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final int f25189e;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public HeadImageView f25190b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f25191c;

    /* renamed from: d  reason: collision with root package name */
    public int f25192d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-128636299, "Lcom/baidu/card/view/SmartAppBottomLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-128636299, "Lcom/baidu/card/view/SmartAppBottomLayout;");
                return;
            }
        }
        f25189e = (n.k(TbadkCoreApplication.getInst()) - (n.f(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - n.f(TbadkCoreApplication.getInst(), R.dimen.tbds58);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmartAppBottomLayout(Context context) {
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
        b(context);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.a = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0784, (ViewGroup) this, true);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f25190b = (HeadImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090189);
            this.f25191c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09018a);
            this.f25190b.setIsBigV(false);
            this.f25190b.setIsGod(false);
            this.f25190b.setShowV(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: c */
    public void a(a aVar) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || (threadData = aVar.getThreadData()) == null || threadData.getSmartApp() == null) {
            return;
        }
        if (!TextUtils.isEmpty(threadData.getSmartApp().avatar)) {
            this.f25190b.J(threadData.getSmartApp().avatar, 10, false);
        } else {
            SkinManager.setImageResource(this.f25190b, R.drawable.icon_avatar_smallapp_tie);
        }
        if (threadData.getSmartApp() != null && !TextUtils.isEmpty(threadData.getSmartApp().name)) {
            ThreadCardUtils.cutAndSetTextByMaxLine(this.f25191c, threadData.getSmartApp().name, R.string.obfuscated_res_0x7f0f00e3, R.dimen.tbds0, 1, f25189e, false);
        } else {
            this.f25191c.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f00e3));
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f25192d == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.f25192d = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setViewTextColor(this.f25191c, (int) R.color.CAM_X0109);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartAppBottomLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f25192d = 3;
        b(context);
    }
}

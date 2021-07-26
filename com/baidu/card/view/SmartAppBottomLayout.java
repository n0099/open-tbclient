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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import d.a.d.e.p.l;
import d.a.k.p;
import d.a.p0.s.q.a;
import d.a.p0.s.q.b2;
/* loaded from: classes2.dex */
public class SmartAppBottomLayout extends LinearLayout implements p<a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final int f4606i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f4607e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f4608f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f4609g;

    /* renamed from: h  reason: collision with root package name */
    public int f4610h;

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
        f4606i = (l.k(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds58);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            this.f4607e = LayoutInflater.from(context).inflate(R.layout.smart_app_bottom_layout, (ViewGroup) this, true);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f4608f = (HeadImageView) this.f4607e.findViewById(R.id.ai_smart_app_icon);
            this.f4609g = (TextView) this.f4607e.findViewById(R.id.ai_smart_app_text);
            this.f4608f.setIsBigV(false);
            this.f4608f.setIsGod(false);
            this.f4608f.setShowV(false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k.p
    /* renamed from: c */
    public void a(a aVar) {
        b2 threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || (threadData = aVar.getThreadData()) == null || threadData.a1() == null) {
            return;
        }
        if (!TextUtils.isEmpty(threadData.a1().avatar)) {
            this.f4608f.M(threadData.a1().avatar, 10, false);
        } else {
            SkinManager.setImageResource(this.f4608f, R.drawable.icon_avatar_smallapp_tie);
        }
        if (threadData.a1() != null && !TextUtils.isEmpty(threadData.a1().name)) {
            ThreadCardUtils.cutAndSetTextByMaxLine(this.f4609g, threadData.a1().name, R.string.ai_smart_app, R.dimen.tbds0, 1, f4606i, false);
        } else {
            this.f4609g.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ai_smart_app));
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f4610h == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.f4610h = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setViewTextColor(this.f4609g, R.color.CAM_X0109);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f4610h = 3;
        b(context);
    }
}
